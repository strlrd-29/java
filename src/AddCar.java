import java.sql.*;
import java.util.*;

public class AddCar {

    static final String DB_URL = "jdbc:mysql://localhost:3306/car";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            System.out.println("Inserting records into the table Car");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The registration number: ");
            int immat = sc.nextInt();
            System.out.println("Enter brand: ");
            String brand = sc.next();
            System.out.println("Enter model: ");
            String model = sc.next();
            System.out.println("Enter price: ");
            float price = sc.nextFloat();
            String sql = "INSERT INTO Car VALUES (" + immat + ", '" + brand + "', '" + model + "', " + price
                    + ")";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table Car");
            sc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
