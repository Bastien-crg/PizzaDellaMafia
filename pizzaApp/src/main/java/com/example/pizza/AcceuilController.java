package com.example.pizza;

import com.example.pizza.model.pizza.PizzaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class AcceuilController {

    @FXML
    private Button LivraisonButton;

    @FXML
    private Button PizzaButton;

    @FXML
    void onHelloButtonClick(MouseEvent event) {
        PizzaButton.setText("Welcome to JavaFX Application!");
        PizzaDAO PizzaLoader = new PizzaDAO();
    }

}
