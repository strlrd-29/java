import java.sql.*;
import java.util.*;

public class UpdateLocationPrice {
    static String DB_URL = "jdbc:mysql://localhost:3306/car";
    static String USER = "root";
    static String PASS = "";
    static final String QUERY = "SELECT * FROM car";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("immat: " + rs.getInt("immat"));
                System.out.print(", brand: " + rs.getString("brand"));
                System.out.print(", model: " + rs.getString("model"));
                System.out.print(", price: " + rs.getString("priceByDay") + '\n');
            }
            // Execute a query
            System.out.println("Updating records into the table Car");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The registration number: ");
            String immat = sc.next();

            System.out.println("Enter new  Location price: ");
            float price = sc.nextFloat();
            String sql = "UPDATE car SET priceByDay = " + price + " WHERE immat = " + immat;
            stmt.executeUpdate(sql);
            System.out.println("Records are updated successfully");
            sc.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
}
