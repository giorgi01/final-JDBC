package ge.edu.btu.DAO;

import ge.edu.btu.river.River;

import java.sql.SQLException;
import java.util.List;

public interface RiverDAO {

    void addRiver(River river) throws SQLException;

    void changeRiverName(String oldName, String newName) throws SQLException;

    List<River> getByLengthBetween(int fromLength, int toLength) throws SQLException;

}