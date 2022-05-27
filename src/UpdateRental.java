import java.sql.*;
import java.util.*;

public class UpdateRental {
    static String DB_URL = "jdbc:mysql://localhost:3306/car";
    static String USER = "root";
    static String PASS = "";
    static final String QUERY = "SELECT * FROM rental";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("Rental ID: " + rs.getInt("rentalID"));
                System.out.print(", Location Date: " + rs.getString("locDate"));
                System.out.print(", Start Date: " + rs.getString("sDate"));
                System.out.print(", End Date: " + rs.getString("eDate"));
                System.out.print(", Rental Type: " + rs.getString("rentalType"));
                System.out.print(", Registration Number: " + rs.getString("immat"));
                System.out.print(", Client ID: " + rs.getString("idClient") + '\n');
            }
            // Execute a query
            System.out.println("Updating records into the table Rental");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The Rental ID: ");
            String rentalID = sc.next();
            System.out.println("Enter The new End Date: (yyyy-mm-dd)");
            String endDate = sc.next();
            java.sql.Date sqlEndDate = java.sql.Date.valueOf(endDate);
            String sql = "UPDATE rental SET eDate = '" + sqlEndDate + "' WHERE rentalID = " + rentalID;
            stmt.executeUpdate(sql);
            System.out.println("Records are updated successfully");
            sc.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
}
