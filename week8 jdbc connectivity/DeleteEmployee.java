import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "your_password";
        
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "DELETE FROM employees WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 3);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An employee was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
