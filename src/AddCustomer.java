import java.sql.*;
import java.util.*;

public class AddCustomer {

    static final String DB_URL = "jdbc:mysql://localhost:3306/car";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            System.out.println("Inserting records into the table Client");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The client ID: ");
            String id = sc.next();
            System.out.println("Enter Client's First name : ");
            String fname = sc.next();
            System.out.println("Enter Client's last Name: ");
            String lname = sc.next();
            System.out.println("Enter Client's Phone number: ");
            String phone = sc.next();
            System.out.println("Enter Client's Street of residence: ");
            String street = sc.next();
            System.out.println("Enter Client's City of residence: ");
            String city = sc.next();
            System.out.println("Enter Client's Job: ");
            String job = sc.next();
            String sql = "INSERT INTO client VALUES (" + id + ", '" + fname + "', '" + lname + "', " + phone + ", '"
                    + street + "', '" + city + "', '" + job + "')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table client");
            sc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
