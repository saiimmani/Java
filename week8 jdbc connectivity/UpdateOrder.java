import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateOrder {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "your_password";
        
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "UPDATE orders SET status = ? WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "Shipped");
            statement.setInt(2, 1);
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing order was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

