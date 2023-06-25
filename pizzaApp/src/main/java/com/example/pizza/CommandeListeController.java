package com.example.pizza;

import com.example.pizza.model.client.ClientDAO;
import com.example.pizza.model.commande.CommandDAO;
import com.example.pizza.model.commande.Commande;
import com.example.pizza.model.ingredient.Ingredient;
import com.example.pizza.model.pizza.Pizza;
import com.example.pizza.model.pizza.PizzaDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class CommandeListeController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button Menu;
    @FXML
    private Text LabelCommande;

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

    public void initialize(URL url, ResourceBundle resourceBundle){
        ArrayList<String> commandeStr = new ArrayList<>();

        for (Commande commande :
                commandes) {
            try {
                commandeStr.add(getLabelText(commande));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        ListeCommande.getItems().addAll(commandeStr);

        ListeCommande.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1)  {
                currentCommande = ListeCommande.getSelectionModel().getSelectedItem();
                for(Commande commande :
                        commandes){
                    try {
                        if(Objects.equals(currentCommande,getLabelText(commande))){

                            String client = "Client : " + commande.getClient().getNomClient();
                            String date = "Date : " + commande.getDateCommande().toString();
                            List<Pizza> pizzaCommande = PizzaDAO.getCommandPizzas(commande.getIdCommande());
                            String pizza = "Pizza : \n";
                            for(Pizza piz : pizzaCommande){
                                pizza += piz.getPizzaName().toString() + " , " + piz.getPrice() +"€\n";
                            }
                            String livreur = "Livreur : " +commande.getLivreur().getNomLivreur();
                            String vehicule = "Vehicule : " + commande.getVehicule().getType();
                            System.out.println(pizza);
                            String label = client + "\n" + date + "\n" + pizza + "\n" + vehicule;
                            LabelCommande.setText(label);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    private String getLabelText(Commande commande) throws SQLException {
        return ClientDAO.getCommandClient(commande.getIdCommande()).getNomClient() + " " + commande.getDateCommande().toString() + " id :" + commande.getIdCommande();
    }
}
