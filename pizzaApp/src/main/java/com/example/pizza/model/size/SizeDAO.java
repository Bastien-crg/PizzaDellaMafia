package com.example.pizza.model.size;

import com.example.pizza.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SizeDAO {

    public static List<Size> getSizes() throws SQLException {
        ArrayList<Size> sizes = new ArrayList<>();
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT * FROM size ;");
        ResultSet res = stm.executeQuery();
        while (res.next()) {
            sizes.add(new Size(res.getInt(1), res.getFloat(2), res.getString(3)));
        }
        return sizes;
    }

    public static Size getPizzaSize(int pizzaId) throws SQLException {
        PreparedStatement stm = DBConnection.GetConn().prepareStatement("SELECT idSize, priceCoeff, sizeName FROM size NATURAL JOIN pizza WHERE idPizza = ?;");
        stm.setInt(1, pizzaId);
        ResultSet res = stm.executeQuery();
       res.next();
       return new Size(res.getInt(1), res.getFloat(2), res.getString(3));
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getSizes());
    }
}
