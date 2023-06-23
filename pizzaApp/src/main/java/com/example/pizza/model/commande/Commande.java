package com.example.pizza.model.commande;

import com.example.pizza.model.client.Client;
import com.example.pizza.model.livreur.Livreur;
import com.example.pizza.model.pizza.Pizza;
import com.example.pizza.model.vehicule.Vehicule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Commande {
    private int idCommande;
    private float prixEffectif;

    // timestamp
    private String dateCommande;
    private int deliveryTime;
    private List<Pizza> pizzas;
    private Client client;
    private Livreur livreur;
    private Vehicule vehicule;

    public Commande(int idCommande, float prixEffectif, String dateCommande, int deliveryTime, List<Pizza> pizzas, Client client, Livreur livreur, Vehicule vehicule) {
        this.idCommande = idCommande;
        this.prixEffectif = prixEffectif;
        this.dateCommande = dateCommande;
        this.deliveryTime = deliveryTime;
        this.pizzas = pizzas;
        this.client = client;
        this.livreur = livreur;
        this.vehicule = vehicule;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public float getPrixEffectif() {
        return prixEffectif;
    }

    public void setPrixEffectif(float prixEffectif) {
        this.prixEffectif = prixEffectif;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return idCommande == commande.idCommande && Float.compare(commande.prixEffectif, prixEffectif) == 0 && dateCommande == commande.dateCommande && deliveryTime == commande.deliveryTime && Objects.equals(pizzas, commande.pizzas) && Objects.equals(client, commande.client) && Objects.equals(livreur, commande.livreur) && Objects.equals(vehicule, commande.vehicule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCommande, prixEffectif, dateCommande, deliveryTime, pizzas, client, livreur, vehicule);
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", prixEffectif=" + prixEffectif +
                ", dateCommande=" + dateCommande +
                ", deliveryTime=" + deliveryTime +
                ", pizzas=" + pizzas +
                ", client=" + client +
                ", livreur=" + livreur +
                ", vehicule=" + vehicule +
                '}';
    }
}
