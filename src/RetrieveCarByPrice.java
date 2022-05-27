import java.sql.*;
import java.util.*;

public class RetrieveCarByPrice {

    static final String DB_URL = "jdbc:mysql://localhost:3306/car";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            System.out.println("Retrieving records from the table Car Using a stored procedure");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the price: ");
            float price = sc.nextFloat();
            // call a stored procedure to retrieve the car with the price
            String sql = "{call getCarsByPrice(?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setFloat(1, price);
            cstmt.execute();
            sc.close();
            ResultSet rs = cstmt.getResultSet();
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("immat: " + rs.getInt("immat"));
                System.out.print(", brand: " + rs.getString("brand"));
                System.out.print(", model: " + rs.getString("model"));
                System.out.print(", price: " + rs.getFloat("priceByDay") + '\n');
            }
            // check if the result set is not empty
            if (rs.next() == false) {
                System.out.println("No car found with the price " + price);
            }
            // Extract data from result set
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
