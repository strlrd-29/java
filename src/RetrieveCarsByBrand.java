import java.sql.*;
import java.util.*;

public class RetrieveCarsByBrand {

    static String DB_URL = "jdbc:mysql://localhost:3306/car";
    static String USER = "root";
    static String PASS = "";

    public static void main(String[] args) throws Exception {
        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            System.out.println("Retrieving records from the table Car");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The brand: ");
            String brand = sc.next();
            System.out.println("Enter The model: ");
            String model = sc.next();
            sc.close();
            String sql = "SELECT * FROM car WHERE brand = '" + brand + "' AND model = '" + model + "'";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("immat: " + rs.getInt("immat"));
                System.out.print(", brand: " + rs.getString("brand"));
                System.out.print(", model: " + rs.getString("model"));
                System.out.print(", price: " + rs.getFloat("priceByDay") + '\n');
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
