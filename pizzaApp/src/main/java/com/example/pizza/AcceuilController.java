package com.example.pizza;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AcceuilController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button LivraisonButton;

    @FXML
    private Button PizzaButton;

    @FXML
    void ButtonGoToPizzaListe(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PizzaListe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ButtonGoToCommandeListe(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CommandeListe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
