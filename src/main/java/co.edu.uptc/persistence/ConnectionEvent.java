package co.edu.uptc.persistence;

import co.edu.uptc.model.Event;
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

import static com.mongodb.client.model.Filters.eq;


public class ConnectionEvent {
    private Document document;
    private MongoCollection<Document> collection;

    public ConnectionEvent(){
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb+srv://julianvelandia01:WyjuRjMC2v85M7WB@cluster0.dtddx5y.mongodb.net/");
        MongoClient mongoClient = new MongoClient(mongoClientURI);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("sport_managment");
        if(mongoDatabase != null){
            System.out.println("Database connected");
        }else{
            System.out.println("Database not connected");
        }
        collection = mongoDatabase.getCollection("event");

    }

    public Event insertEvent(Event event){
        Document document = new Document("id",event.getId())
                .append("name",event.getName())
                .append("description",event.getDescription())
                .append("discipline",event.getDiscipline().toString());

        collection.insertOne(document);
        return event;
    }

    public String getEvent(){
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
            System.out.println(line);
        }
        return line;
    }

    public Event updateEvent(String dni, Event event){
        Bson query = eq("id",dni);

        Bson updates = Updates.combine(
                Updates.set("name",event.getName()),
                Updates.set("description",event.getDescription()),
                Updates.set("podium",event.getPodium()),
                Updates.set("discipline",event.getDiscipline().toString())
        );

        UpdateResult upResult = collection.updateOne(query,updates);
        System.out.println(upResult.getModifiedCount());
        return event;
    }

    public boolean deleteEvent(ObjectId id){
        Bson query = eq("id",id);
        DeleteResult deleteResult = collection.deleteOne(query);
        if(deleteResult.getDeletedCount() > 0){
            return true;
        }
        return false;
    }
}
