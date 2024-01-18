package tasks.caso_tarifa;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import tasks.PruebaMongoDB;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReviewApi implements Task {
    private Map<String, String> data;

    public ReviewApi(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> datos = new HashMap<>(data);
        Random r = new Random();
        Double total = 0.0;
        List<String> clientesDescuentoApi = new ArrayList<>();
        clientesDescuentoApi.add("123");
        clientesDescuentoApi.add("111");
        clientesDescuentoApi.add("222");
        clientesDescuentoApi.add("333");
        clientesDescuentoApi.add("444");
        clientesDescuentoApi.add("555");
        clientesDescuentoApi.add("666");
        clientesDescuentoApi.add("777");
        actor.remember("listaClientes",clientesDescuentoApi);
        actor.remember("datos",data);

        if (clientesDescuentoApi.contains(data.get("cedula"))) {
            total = Double.parseDouble(data.get("precioProducto")) - (Double.parseDouble(data.get("precioProducto")) * ((Double.parseDouble(String.valueOf(r.nextInt(1 + 8) + 1))) * 10 / 100));

        } else
            total = Double.parseDouble(data.get("precioProducto"));


        datos.put("total", String.format("%.2f",total));
        datos.put("fecha", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());


        actor.attemptsTo(PruebaMongoDB.querys(datos, "guardar"));

    }

    public static ReviewApi with(Map<String, String> data) {
        return Tasks.instrumented(ReviewApi.class, data);
    }
}
