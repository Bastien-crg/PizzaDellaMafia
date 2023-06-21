package com.example.pizza;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.*;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        /*
        Connection cx = DBConnection.GetConn();
        Statement statement = cx.createStatement();
        ResultSet res = statement.executeQuery("SELECT * FROM pizza ;");
        while (res.next()) {
            System.out.println(res.getString("pizzaName"));
        }
        */

        launch();

    }
}