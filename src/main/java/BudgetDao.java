import java.sql.*;
import java.util.Optional;

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

    private void closeConnection(Connection connection) {
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
    public void insert(Transaction transaction) {
        Connection connection = connection();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO transaction (type, description, amount, date) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setInt(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczasu zapisu do bazy: " + e.getMessage());
        }

        closeConnection(connection);
    }


    public void update(Transaction transaction) {
        Connection connection = connection();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE transaction SET type = ?, description = ?, amount = ?, date = ? WHERE id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setInt(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getDate());
            preparedStatement.setLong(5, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczasu zapisu do bazy: " + e.getMessage());
        }

        closeConnection(connection);
    }


    public void deleteById(int id) {
        Connection connection = connection();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM transaction WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + e.getMessage());
        }

        closeConnection(connection);
    }

    public void viewAllRevenuess() {
        Connection connection = connection();
        try {
            String sql = "SELECT * FROM transaction WHERE type LIKE '%inc%';";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                int amount = resultSet.getInt("amount");
                String date = resultSet.getString("date");
                System.out.println("Id: " + id + ", type " + type + ", description: " + description + ", amount " + amount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllExpenses() {
        Connection connection = connection();
        try {
            String sql = "SELECT * FROM transaction WHERE type LIKE '%exp%';";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                int amount = resultSet.getInt("amount");
                String date = resultSet.getString("date");
                System.out.println("Id: " + id + ", type " + type + ", description: " + description + ", amount " + amount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
