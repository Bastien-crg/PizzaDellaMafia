package com.example.pizza.model.commande;

import com.example.pizza.DBConnection;
import com.example.pizza.model.client.ClientDAO;
import com.example.pizza.model.livreur.Livreur;
import com.example.pizza.model.livreur.LivreurDAO;
import com.example.pizza.model.pizza.PizzaDAO;
import com.example.pizza.model.vehicule.VehiculeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandDAO {

    public List<Commande> getCommands() throws SQLException {
        ArrayList<Commande> commandes = new ArrayList<>();
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT * FROM commande");
        ResultSet res = stm.executeQuery();
        while (res.next()) {
            commandes.add(new Commande(res.getInt(1),
                    res.getFloat(2),
                    res.getString(3),
                    res.getInt(4),
                    PizzaDAO.getCommandPizzas(res.getInt(1)),
                    ClientDAO.getCommandClient(res.getInt(1)),
                    LivreurDAO.getCommandLivreur(res.getInt(1)),
                    VehiculeDAO.getCommandVehicle(res.getInt(1))));
        }
        return commandes;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(new CommandDAO().getCommands());
    }
}
