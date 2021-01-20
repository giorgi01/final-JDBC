package ge.edu.btu.DAO;

import ge.edu.btu.river.River;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RiverDAOImpl implements RiverDAO {

    private Connection connection;

    public RiverDAOImpl() throws SQLException {
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);

        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "toor");
    }

    @Override
    public void addRiver(River river) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO rivers (id, name, length) VALUES (?, ?, ?)");
        preparedStatement.setLong(1, river.getId());
        preparedStatement.setString(2, river.getName());
        preparedStatement.setInt(3, river.getLength());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void changeRiverName(String oldName, String newName) throws SQLException {
        Statement update_statement = connection.createStatement();
        update_statement.executeUpdate("UPDATE rivers SET name = '" + newName + "' WHERE name = '" + oldName + "'");
        update_statement.close();
    }

    @Override
    public List<River> getByLengthBetween(int fromLength, int toLength) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM rivers WHERE length BETWEEN " + fromLength + " AND " + toLength);

        List<River> list = new ArrayList<>();

        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            int length = resultSet.getInt("length");

            River river = new River(id, name, length);
            list.add(river);
        }

        statement.close();

        return list;
    }
}
