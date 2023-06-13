package com.example.pizza;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Acceuil.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

       //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();


        Connection cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/rapizz?user=root&password=root");
        Statement statement = cx.createStatement();
        ResultSet res = statement.executeQuery("SELECT * FROM pizza ;");
        //System.out.println(res.getString("pizzaName"));
        while (res.next()) {
            System.out.println(res.getString("pizzaName"));
        }

        launch();

    }
}