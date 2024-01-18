package integration;

import com.ibm.as400.access.AS400JDBCDriver;
import utils.CaptureQueries;

import java.sql.*;

public class ConectTo {

    public static Connection dataBase(){
        Connection conn = null;
        try {

            AS400JDBCDriver driver = new com.ibm.as400.access.AS400JDBCDriver();
            DriverManager.registerDriver(driver);

            String url = "jdbc:as400://www.pub400.com;promt=true";
            conn = DriverManager.getConnection(url,"JTOBON","TH7SQJ2U");

            System.out.println("Conexion");


            if (conn != null) {
                System.out.println("conectado con la base de datos as400");
            } else {
                System.out.println("fallo la conexion hacia la base de datos");
            }

            String query = CaptureQueries.QUERIES.getString("SQL.PRUEBA.test");

            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            System.out.println("RESULTADO: " + resultSet.toString());

        } catch (SQLException e) {
            System.out.println("fallo al conectarse a la base de datos");
            e.printStackTrace();
        }

        return conn;
    }
}
