package questions;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.bson.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ValidarTarifaDb implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        Map<String, String> data = actor.recall("datos");
        List<String> clientesApi = actor.recall("listaClientes");

        MongoClientURI uri = new MongoClientURI("mongodb+srv://jtobong:" + System.getProperty("password") + "@clustertest0.hirzkqd.mongodb.net/");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("cliente");
        MongoCollection<Document> collection = mongoDatabase.getCollection("tarifa_final");
        BasicDBObject query = new BasicDBObject("cedulaCliente", data.get("cedula"));
        FindIterable<Document> result = collection.find(query);

        for (Document doc : result) {
            if (clientesApi.contains(data.get("cedula"))) {
                if (Double.parseDouble(doc.get("tarifaTotal").toString()) < Double.parseDouble(data.get("precioProducto")) &&
                        doc.get("nombreCliente").toString().equals(data.get("nombre")) &&
                        doc.get("fecha").toString().equals(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))))
                    return true;
            } else {
                if (Double.parseDouble(doc.get("tarifaTotal").toString()) == Double.parseDouble(data.get("precioProducto")) &&
                        doc.get("nombreCliente").toString().equals(data.get("nombre")) &&
                        doc.get("fecha").toString().equals(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))))
                    return true;
            }
        }

        return false;
    }

    public static ValidarTarifaDb on() {
        return new ValidarTarifaDb();
    }
}
