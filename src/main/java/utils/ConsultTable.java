package utils;

import java.sql.*;

public class ConsultTable {
    private ConsultTable() {
    }

    public static void consultLog() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //OTRA FORMA DE INSTANCIAR EL DRIVER Y QUE JDBC RECONOZCA EL DRIVER DE AS400
            //AS400JDBCDriver driver = new AS400JDBCDriver();
            //DriverManager.registerDriver(driver);
            Class.forName("com.ibm.as400.access.AS400JDBCDriver");

            String url = "jdbc:as400://pub400.com";
            conn = DriverManager.getConnection(url, "JTOBON", System.getProperty("password"));

            String query = CaptureQueries.QUERIES.getString("SQL.PRUEBA.test");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            System.out.println("RESULTADO");

            while (rs.next()) {
                System.out.println("Documento: " + rs.getString("NUMDOC") + ", Nombre: " + rs.getString("NOMALUM").trim() + ", Apellido: " + rs.getString("PRIAPE"));
            }


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("fallo al conectarse a la base de datos");
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception ignored) {}
            try {
                stmt.close();
            } catch (Exception ignored) {}
            try {
                conn.close();
            } catch (Exception ignored) {}
        }

    }
}
