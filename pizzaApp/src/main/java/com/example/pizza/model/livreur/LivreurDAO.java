package com.example.pizza.model.livreur;

import com.example.pizza.DBConnection;
import com.example.pizza.model.vehicule.Vehicule;
import com.example.pizza.model.vehicule.VehiculeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreurDAO {

    public static List<Livreur> getLivreurs() throws SQLException {
        ArrayList<Livreur> livreurs = new ArrayList<>();
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT * FROM livreur");
        ResultSet res = stm.executeQuery();
        while (res.next()) {
            livreurs.add(new Livreur(res.getInt(1), res.getString(2)));
        }
        return livreurs;
    }

    public static Livreur getCommandLivreur(int commandId) throws SQLException {
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT id_livreur, nom_livreur FROM livreur NATURAL JOIN livre WHERE id_commande = ?;");
        stm.setInt(1, commandId);
        ResultSet res = stm.executeQuery();
        res.next();
        return new Livreur(res.getInt(1), res.getString(2));
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(new LivreurDAO().getLivreurs());
    }

}
