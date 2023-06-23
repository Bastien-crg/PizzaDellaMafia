package com.example.pizza.model.pizza;

import com.example.pizza.DBConnection;
import com.example.pizza.model.ingredient.Ingredient;
import com.example.pizza.model.ingredient.IngredientDAO;
import com.example.pizza.model.size.Size;
import com.example.pizza.model.size.SizeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {

    public static List<Pizza> getPizzas() throws SQLException {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT * FROM pizza");
        ResultSet res = stm.executeQuery();
        while (res.next()) {
            pizzas.add(new Pizza(res.getInt(1), res.getString(2), res.getFloat(3), IngredientDAO.getPizzaIngredients(res.getInt(1)), SizeDAO.getPizzaSize(res.getInt(1))));
        }

        return pizzas;
    }

    public static List<Pizza> getCommandPizzas(int commandId) throws SQLException {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT idPizza, pizzaName, price, quantite FROM pizza NATURAL JOIN containing WHERE id_commande = ?;");
        stm.setInt(1, commandId);
        ResultSet res = stm.executeQuery();
        while (res.next()) {
            for (int i = 0; i < res.getInt(4) ; i++) {
                pizzas.add(new Pizza(res.getInt(1), res.getString(2), res.getFloat(3), IngredientDAO.getPizzaIngredients(res.getInt(1)), SizeDAO.getPizzaSize(res.getInt(1))));
            }
        }

        return pizzas;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(new PizzaDAO().getPizzas());
        System.out.println(new PizzaDAO().getCommandPizzas(0));
    }
}
