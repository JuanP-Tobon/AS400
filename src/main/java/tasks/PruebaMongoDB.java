package tasks;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.bson.Document;

import java.util.Map;

public class PruebaMongoDB implements Task {
    private Map<String,String> data;
    private String tipoConsulta;

    public PruebaMongoDB(Map<String, String> data, String tipoConsulta) {
        this.data = data;
        this.tipoConsulta = tipoConsulta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://jtobong:" + System.getProperty("password") + "@clustertest0.hirzkqd.mongodb.net/");
        MongoClient mongoClient = new MongoClient(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("cliente");


        MongoCollection<Document> collection = mongoDatabase.getCollection("tarifa_final");

        if (tipoConsulta.equals("guardar")) {
            Document document = new Document();
            document.put("cedulaCliente", data.get("cedula"));
            document.put("nombreCliente", data.get("nombre"));
            document.put("tarifaTotal", data.get("total"));
            document.put("fecha", data.get("fecha"));
            collection.insertOne(document);
        }

       /* for (Document doc : result) {
            System.out.println(doc.toJson());
        }*/
    }

    public static PruebaMongoDB querys(Map<String,String>data,String tipoConsulta) {
        return Tasks.instrumented(PruebaMongoDB.class,data,tipoConsulta);
    }
}
