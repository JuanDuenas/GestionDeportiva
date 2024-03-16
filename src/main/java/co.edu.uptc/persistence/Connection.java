package co.edu.uptc.persistence;

import co.edu.uptc.model.Affiliated;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    private List<Affiliated> listAffiliateds;
    private Document document;
    private MongoCollection collection;

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

    public void getAffiliated(){
        collection.find();
    }

    public Affiliated update(Integer id, Affiliated affiliated){
        document = new Document("id",id);
        Document found = (Document) collection.find(new Document("_id",id)).first();

        if(found != null){
            System.out.println("Found user");
        }

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("id",affiliated);
        collection.updateOne(document,newDocument);
        return affiliated;
    }
}
