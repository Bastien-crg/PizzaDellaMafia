package com.example.pizza.model.client;

import java.util.Objects;

public class Client {
    private int idClient;
    private float solde;
    private String adresse;
    private int stack;
    private String nomClient;

    public Client(int idClient, float solde, String adresse, int stack, String nomClient) {
        this.idClient = idClient;
        this.solde = solde;
        this.adresse = adresse;
        this.stack = stack;
        this.nomClient = nomClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idClient == client.idClient && Float.compare(client.solde, solde) == 0 && stack == client.stack && Objects.equals(adresse, client.adresse) && Objects.equals(nomClient, client.nomClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, solde, adresse, stack, nomClient);
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", solde=" + solde +
                ", adresse='" + adresse + '\'' +
                ", stack=" + stack +
                ", nomClient='" + nomClient + '\'' +
                '}';
    }
}
