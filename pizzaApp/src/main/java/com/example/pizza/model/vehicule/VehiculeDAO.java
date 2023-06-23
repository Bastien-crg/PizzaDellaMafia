package com.example.pizza.model.vehicule;

import com.example.pizza.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculeDAO {

    public static List<Vehicule> getVehicles() throws SQLException {
        ArrayList<Vehicule> vehicules = new ArrayList<>();
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT * FROM vehicule");
        ResultSet res = stm.executeQuery();
        while (res.next()) {
            vehicules.add(new Vehicule(res.getInt(1), res.getString(2)));
        }
        return vehicules;
    }

    public static Vehicule getCommandVehicle(int commandId) throws SQLException {
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT id_vehicule, type FROM vehicule NATURAL JOIN livre WHERE id_commande = ?;");
        stm.setInt(1, commandId);
        ResultSet res = stm.executeQuery();
        res.next();
        return new Vehicule(res.getInt(1), res.getString(2));
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(new VehiculeDAO().getVehicles());
    }
}
