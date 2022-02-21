import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BudgetDao {

    private Connection connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/home_budget?serverTimezone=UTC";
        try {
            return DriverManager.getConnection(url, "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void cloceConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*private Long id;
    private String type;
    private String description;
    private int amount;
    private String date;

     */
    public void insert(Transaction budget) {
        Connection connection = connection();

        PreparedStatement preparedStatement = null;
        try{
            String sql = "INSERT INTO transaction (type, description, amount, date) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, budget.getType());
            preparedStatement.setString(2, budget.getDescription());
            preparedStatement.setInt(3, budget.getAmount());
            preparedStatement.setString(4, budget.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczasu zapisu do bazy: " + e.getMessage());
        }

        cloceConnection(connection);
    }


}
