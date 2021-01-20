package ge.edu.btu;

import ge.edu.btu.DAO.RiverDAO;
import ge.edu.btu.DAO.RiverDAOImpl;
import ge.edu.btu.river.River;

import java.util.List;

public class Runner {

    public static void main(String[] args) throws Exception {
        RiverDAO RiverDAO = new RiverDAOImpl();

        RiverDAO.addRiver(new River(1, "Amazon", 5000));
        RiverDAO.addRiver(new River(2, "Mtkvari", 700));
        RiverDAO.addRiver(new River(3, "Volga", 2300));

        RiverDAO.changeRiverName("Mtkvari", "Aragvi");

        List<River> rivers = RiverDAO.getByLengthBetween(500, 3000);

        for (int i = 0; i < rivers.size(); i++) {
            System.out.println("River name: " + rivers.get(i).getName() + ", Length: " + rivers.get(i).getLength());
        }

    }
}
