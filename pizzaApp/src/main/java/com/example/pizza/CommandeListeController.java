package com.example.pizza;


import com.example.pizza.model.client.ClientDAO;
import com.example.pizza.model.commande.Commande;
import com.example.pizza.model.commande.CommandDAO;
import com.example.pizza.model.pizza.Pizza;
import com.example.pizza.model.pizza.PizzaDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class CommandeListeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button Menu;

    @FXML
    private ListView<String> ListeCommande;
    String currentCommande;

    List<Commande> commandes = CommandDAO.getCommands();
    public CommandeListeController() throws SQLException {
    }

    @FXML
    void ButtonGoToAcceuil(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() throws SQLException {
        ArrayList<String> commandeStr = new ArrayList<>();
        System.out.println(commandes.toString());
        for (Commande commande :
                commandes) {
            commandeStr.add(ClientDAO.getCommandClient(commande.getIdCommande()).getNomClient() + " " + commande.getDateCommande().toString());

        }

        ListeCommande.getItems().addAll(commandeStr);

        ListeCommande.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentCommande = ListeCommande.getSelectionModel().getSelectedItem();
            }
        });
    }

}
