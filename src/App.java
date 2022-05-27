import java.sql.*;

public class App {

    static final String DB_URL = "jdbc:mysql://localhost:3306/car";
    static final String USER = "root";
    static final String PASS = "";
    static final String QUERY = "SELECT * FROM car";

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("immat: " + rs.getInt("immat"));
                System.out.print(", brand: " + rs.getString("brand"));
                System.out.print(", model: " + rs.getString("model") + '\n');
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
