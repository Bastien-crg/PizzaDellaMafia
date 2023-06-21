package com.example.pizza;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import java.util.ResourceBundle;

public class PizzaListeController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button Menu;
    @FXML
    private Text LabelPizza;

    @FXML
    private ListView<String> ListePizza;

    String[] pizza = {"Reine","Calzonne","4 Fromages","Bastien t'es beau"};
    String currentPizza;
    @FXML
    void ButtonGoToAcceuil(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListePizza.getItems().addAll(pizza);

        ListePizza.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentPizza = ListePizza.getSelectionModel().getSelectedItem();
                LabelPizza.setText(currentPizza);
            }
        });
    }
}
