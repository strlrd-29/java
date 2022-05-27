import java.sql.*;
import java.util.*;

public class AddRental {

    static final String DB_URL = "jdbc:mysql://localhost:3306/car";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            System.out.println("Inserting records into the table Rental");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The Rental ID: ");
            String immat = sc.next();
            System.out.println("Enter The Location Date: (yyyy-mm-dd)");
            String locationDate = sc.next();
            System.out.println("Enter The Start Date: (yyyy-mm-dd)");
            String startDate = sc.next();
            System.out.println("Enter The End Date: (yyyy-mm-dd)");
            String endDate = sc.next();
            System.out.println("Enter the rental Type (WD/ND)");
            String rentalType = sc.next();
            System.out.println("Enter the Registration number: ");
            String regNumber = sc.next();
            System.out.println("Enter the Client ID: ");
            String clientID = sc.next();

            // parse the date
            java.sql.Date sqlDate = java.sql.Date.valueOf(locationDate);
            java.sql.Date sqlStartDate = java.sql.Date.valueOf(startDate);
            java.sql.Date sqlEndDate = java.sql.Date.valueOf(endDate);

            String sql = "INSERT INTO rental VALUES (" + immat + ", '" + sqlDate + "', '" + sqlStartDate + "', '"
                    + sqlEndDate + "', '" + rentalType + "', '" + regNumber + "', " + clientID + ")";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table Rental");
            sc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
