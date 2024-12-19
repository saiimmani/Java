import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectCustomers {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "your_password";
        
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "SELECT * FROM customers";
            
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                System.out.println(id + ", " + name + ", " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
