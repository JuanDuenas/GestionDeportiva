package co.edu.uptc.persistence;

import co.edu.uptc.model.Affiliated;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    private List<Document> listAffiliateds;
    private Document document;
    private MongoCollection<Document> collection;

    public Connection(){
        listAffiliateds = new ArrayList<>();
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb+srv://julianvelandia01:WyjuRjMC2v85M7WB@cluster0.dtddx5y.mongodb.net/");
        MongoClient mongoClient = new MongoClient(mongoClientURI);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("sport_managment");
        if(mongoDatabase != null){
            System.out.println("Database connected");
        }else{
            System.out.println("Database not connected");
        }
        collection = mongoDatabase.getCollection("affiliated");

    }

    public Affiliated insert(Affiliated affiliated){
        System.out.println(affiliated);
        Document document = new Document("name",affiliated.getName())
                .append("lastName",affiliated.getLastName())
                .append("dni",affiliated.getDni())
                .append("age",affiliated.getAge());
        System.out.println("casote");

        collection.insertOne(document);
        return affiliated;
    }

    public String getAffiliated(){
        String line = "[";
        try(MongoCursor<Document> cursor = collection.find().iterator()){
            long count = 1;
            while(cursor.hasNext()){
                if(collection.countDocuments() != count){
                    count++;
                    line = line+cursor.next().toJson()+",";
                }else{
                    line = line+cursor.next().toJson();
                }

            }
            line+="]";
        }
        return line;
    }

    public Affiliated update(ObjectId id, Affiliated affiliated){
        Bson query = Filters.eq("_id",id);
        Bson updates = Updates.combine(
                Updates.set("name",affiliated.getName()),
                Updates.set("lastName",affiliated.getLastName()),
                Updates.set("dni",affiliated.getDni()),
                Updates.set("age",affiliated.getAge())
        );

        UpdateResult upResult = collection.updateOne(query,updates);
        return affiliated;
    }

    public boolean delete(ObjectId id){
        Bson query = Filters.eq("_id",id);
        DeleteResult deleteResult = collection.deleteOne(query);
        if(deleteResult.getDeletedCount() > 0){
            return true;
        }
        return false;
    }
}
