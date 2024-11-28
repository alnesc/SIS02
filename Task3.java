import java.sql.*;

public class Task3 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sis2_task3";
        String user = "root";
        String password = "Alan.050206";

        Connection connect = DriverManager.getConnection(url, user, password);
        Statement a = connect.createStatement();

        String insertZapros = "INSERT INTO Employees (id, first, last, age) VALUES (4, 'Kumarbek', 'Magzhan', 18)";
        a.executeUpdate(insertZapros);
        System.out.println("Insert success");

        String selectZapros = "SELECT id, first, last, age FROM Employees";
        ResultSet resultSet = a.executeQuery(selectZapros);

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("First: " + resultSet.getString("first"));
            System.out.println("Last: " + resultSet.getString("last"));
            System.out.println("Age: " + resultSet.getInt("age"));
            System.out.println("------------------------");
        }


        String updateZapros = "UPDATE Employees SET age = 35 WHERE id = 1";
        a.executeUpdate(updateZapros);
        System.out.println("Update success");


        String deleteZapros = "DELETE FROM Employees WHERE id = 1";
        a.executeUpdate(deleteZapros);
        System.out.println("Delete success");

        resultSet.close();
        a.close();
        connect.close();
    }
}