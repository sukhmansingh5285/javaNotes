// this was done with the help of gemini

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDbConnections {
    public static void main(String[] args) {
        String password = "hellyeah5285";
        
        System.out.println("Starting Database Connection Tests...");
        System.out.println("-------------------------------------");

        // 1. Test MySQL
        // User said: Port 5432. Standard is 3306.
        System.out.println("--- MySQL Tests ---");
        testConnection("MySQL (User Port 5432)", "com.mysql.jdbc.Driver", 
            "jdbc:mysql://localhost:5432/?user=root&password=" + password);
        testConnection("MySQL (Standard Port 3306)", "com.mysql.jdbc.Driver", 
            "jdbc:mysql://localhost:3306/?user=root&password=" + password);

        // 2. Test PostgreSQL
        // User said: Port 3306. Standard is 5432.
        System.out.println("--- PostgreSQL Tests ---");
        testConnection("PostgreSQL (User Port 3306)", "org.postgresql.Driver", 
            "jdbc:postgresql://localhost:3306/postgres?user=postgres&password=" + password);
        testConnection("PostgreSQL (Standard Port 5432)", "org.postgresql.Driver", 
            "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=" + password);

        // 3. Test Oracle (Optional, but user mentioned it)
        // Standard Oracle port 1521.
        testConnection("Oracle", "oracle.jdbc.driver.OracleDriver", 
            "jdbc:oracle:thin:@localhost:1521:XE", "system", password); 
            // Note: XE is typical SID for Oracle XE. User has 10g XE.
    }

    public static void testConnection(String dbName, String driverClass, String url) {
        testConnection(dbName, driverClass, url, null, null);
    }

    public static void testConnection(String dbName, String driverClass, String url, String user, String pass) {
        System.out.println("Testing " + dbName + "...");
        System.out.println("  URL: " + url);
        try {
            Class.forName(driverClass);
            Connection conn;
            if (user != null && pass != null) {
                conn = DriverManager.getConnection(url, user, pass);
            } else {
                conn = DriverManager.getConnection(url);
            }
            System.out.println("  [SUCCESS] Connected to " + dbName + " successfully!");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("  [FAILURE] Driver class not found: " + driverClass);
            System.out.println("  Make sure the jar is in the CLASSPATH.");
        } catch (SQLException e) {
            System.out.println("  [FAILURE] Could not connect to " + dbName);
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println("-------------------------------------");
    }
}
