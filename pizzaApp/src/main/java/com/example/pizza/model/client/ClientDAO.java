package com.example.pizza.model.client;

import com.example.pizza.DBConnection;
import com.example.pizza.model.livreur.Livreur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    public static List<Client> getClients() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT * FROM client;");
        ResultSet res = stm.executeQuery();
        while (res.next()) {
            clients.add(new Client(res.getInt(1), res.getFloat(2), res.getString(3), res.getInt(4), res.getString(5)));
        }
        return clients;
    }

    public static Client getCommandClient(int commandId) throws SQLException {
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT id_client, solde, adresse, stack, nom_client FROM client NATURAL JOIN commande WHERE id_commande = ?;");
        stm.setInt(1, commandId);
        ResultSet res = stm.executeQuery();
        res.next();
        return new Client(res.getInt(1), res.getFloat(2), res.getString(3), res.getInt(4), res.getString(5));
    }

    public static void updateClient(Client client) throws SQLException {
            PreparedStatement stm = DBConnection.GetConn().prepareStatement("UPDATE client SET solde = ?, adresse = ?, stack = ?, nom_client = ? WHERE client.id_client = ?;");
            stm.setFloat(1, client.getSolde());
            stm.setString(2, client.getAdresse());
            stm.setInt(3, client.getStack());
            stm.setString(4, client.getNomClient());
            stm.setInt(5, client.getIdClient());
            stm.executeUpdate();
    }

    public static void deleteClient(Client client) throws SQLException {
            PreparedStatement stm = DBConnection.GetConn().prepareStatement("DELETE FROM client WHERE client.id_client = ?");
            stm.setInt(1, client.getIdClient());
            stm.execute();
    }

    public static void addClient(Client client) throws SQLException {
            PreparedStatement stm = DBConnection.GetConn().prepareStatement("INSERT INTO client (id_client, solde, adresse, stack, nom_client) VALUES (?, ?, ?, ?, ?);");
            stm.setInt(1, client.getIdClient());
            stm.setFloat(2, client.getSolde());
            stm.setString(3, client.getAdresse());
            stm.setInt(4, client.getStack());
            stm.setString(5, client.getNomClient());
            stm.execute();
    }

    public static void main(String[] args) throws SQLException {
        ClientDAO clientDAO = new ClientDAO();
        List<Client> clients = clientDAO.getClients();
        System.out.println(clients);

        Client clientToUpdate = clients.get(0);
        clientToUpdate.setSolde(200);
        clientDAO.updateClient(clientToUpdate);
    }
}
