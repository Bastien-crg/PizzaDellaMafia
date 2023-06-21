package com.example.pizza.model.pizza;

import com.example.pizza.model.ingredient.Ingredient;
import com.example.pizza.model.size.Size;

import java.util.ArrayList;
import java.util.Objects;

public class Pizza {
    private int idPizza;
    private String pizzaName;
    private float price;
    private ArrayList<Ingredient> ingredients;
    private Size size;

    public Pizza(int idPizza, String pizzaName, float price, ArrayList<Ingredient> ingredients, Size size) {
        this.idPizza = idPizza;
        this.pizzaName = pizzaName;
        this.price = price;
        this.ingredients = ingredients;
        this.size = size;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return idPizza == pizza.idPizza && Float.compare(pizza.price, price) == 0 && Objects.equals(pizzaName, pizza.pizzaName) && Objects.equals(ingredients, pizza.ingredients) && Objects.equals(size, pizza.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPizza, pizzaName, price, ingredients, size);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "idPizza=" + idPizza +
                ", pizzaName='" + pizzaName + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                ", size=" + size +
                '}';
    }
}
