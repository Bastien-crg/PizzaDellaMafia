package com.example.pizza.model.vehicule;

import java.util.Objects;

public class Vehicule {
    private int idVehicule;
    private String type;

    public Vehicule(int idVehicule, String type) {
        this.idVehicule = idVehicule;
        this.type = type;
    }

    public int getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(int idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return idVehicule == vehicule.idVehicule && Objects.equals(type, vehicule.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVehicule, type);
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "idVehicule=" + idVehicule +
                ", type='" + type + '\'' +
                '}';
    }
}
