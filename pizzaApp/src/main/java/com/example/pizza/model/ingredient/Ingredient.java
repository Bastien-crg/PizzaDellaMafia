package com.example.pizza.model.ingredient;

import java.util.Objects;

public class Ingredient {
    private int idIngredient;
    private String nomIngredient;

    public Ingredient(int idIngredient, String nomIngredient) {
        this.idIngredient = idIngredient;
        this.nomIngredient = nomIngredient;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getNomIngredient() {
        return nomIngredient;
    }

    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return idIngredient == that.idIngredient && Objects.equals(nomIngredient, that.nomIngredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIngredient, nomIngredient);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "idIngredient=" + idIngredient +
                ", nomIngredient='" + nomIngredient + '\'' +
                '}';
    }
}
