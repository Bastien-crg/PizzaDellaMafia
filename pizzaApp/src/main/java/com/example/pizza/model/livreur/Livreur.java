package com.example.pizza.model.livreur;

import java.util.Objects;

public class Livreur {
    private int IdLivreur;
    private String nomLivreur;

    public Livreur(int idLivreur, String nomLivreur) {
        IdLivreur = idLivreur;
        this.nomLivreur = nomLivreur;
    }

    public int getIdLivreur() {
        return IdLivreur;
    }

    public void setIdLivreur(int idLivreur) {
        IdLivreur = idLivreur;
    }

    public String getNomLivreur() {
        return nomLivreur;
    }

    public void setNomLivreur(String nomLivreur) {
        this.nomLivreur = nomLivreur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livreur livreur = (Livreur) o;
        return IdLivreur == livreur.IdLivreur && Objects.equals(nomLivreur, livreur.nomLivreur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdLivreur, nomLivreur);
    }

    @Override
    public String toString() {
        return "Livreur{" +
                "IdLivreur=" + IdLivreur +
                ", nomLivreur='" + nomLivreur + '\'' +
                '}';
    }
}
