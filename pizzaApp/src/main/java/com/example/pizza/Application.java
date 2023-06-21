package com.example.pizza;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.*;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Acceuil.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
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