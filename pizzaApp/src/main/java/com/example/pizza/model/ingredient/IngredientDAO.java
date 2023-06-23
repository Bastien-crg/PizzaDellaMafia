package com.example.pizza.model.ingredient;

import com.example.pizza.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO {

    public static List<Ingredient> getIngredients() throws SQLException {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT * FROM ingredient");
        ResultSet res = stm.executeQuery();
        while (res.next()) {
            ingredients.add(new Ingredient(res.getInt(1), res.getString(2)));
        }
        return ingredients;
    }

    public static List<Ingredient> getPizzaIngredients(int pizzaId) throws SQLException {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT * FROM ingredient NATURAL JOIN has_ingredient WHERE idPizza = ?;");
        stm.setInt(1, pizzaId);
        ResultSet res = stm.executeQuery();
        while (res.next()) {
            ingredients.add(new Ingredient(res.getInt(1), res.getString(2)));
        }
        return ingredients;
    }

    public static void updateIngredients(Ingredient ingredient) throws SQLException {
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("UPDATE ingredient nom_ingredient = ? WHERE ingredient.id_ingredient = ?;");
        stm.setInt(2, ingredient.getIdIngredient());
        stm.setString(1, ingredient.getNomIngredient());
        stm.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {
        IngredientDAO ingredientDAO = new IngredientDAO();
        System.out.println(ingredientDAO.getIngredients());
    }
}
