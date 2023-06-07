CREATE DATABASE rapizz;
USE rapizz;

CREATE TABLE Pizza(
   idPizza INT,
   pizzaName VARCHAR(50),
   price DECIMAL(15,2),
   PRIMARY KEY(idPizza)
);

CREATE TABLE Ingredient(
   id_ingredient INT,
   nom_ingredient VARCHAR(50),
   PRIMARY KEY(id_ingredient)
);

CREATE TABLE Client(
   id_client INT,
   solde VARCHAR(50),
   adresse VARCHAR(50),
   stack INT,
   nom_client VARCHAR(50),
   PRIMARY KEY(id_client)
);

CREATE TABLE Livreur(
   id_livreur INT,
   nom_livreur VARCHAR(50),
   PRIMARY KEY(id_livreur)
);

CREATE TABLE Vehicule(
   id_vehicule INT,
   type VARCHAR(50),
   PRIMARY KEY(id_vehicule)
);

CREATE TABLE size(
   idSize INT,
   priceCoeff VARCHAR(50),
   sizeName VARCHAR(50),
   PRIMARY KEY(idSize)
);

CREATE TABLE Commande(
   id_commande INT,
   prix_effectif VARCHAR(50),
   date_commande DATETIME,
   delivery_time INT,
   id_client INT NOT NULL,
   PRIMARY KEY(id_commande),
   FOREIGN KEY(id_client) REFERENCES Client(id_client)
);

CREATE TABLE has_ingredient(
   idPizza INT,
   id_ingredient INT,
   PRIMARY KEY(idPizza, id_ingredient),
   FOREIGN KEY(idPizza) REFERENCES Pizza(idPizza),
   FOREIGN KEY(id_ingredient) REFERENCES Ingredient(id_ingredient)
);

CREATE TABLE containing(
   idPizza INT,
   idSize INT,
   id_commande INT,
   quantite INT,
   PRIMARY KEY(idPizza, idSize, id_commande),
   FOREIGN KEY(idPizza) REFERENCES Pizza(idPizza),
   FOREIGN KEY(idSize) REFERENCES size(idSize),
   FOREIGN KEY(id_commande) REFERENCES Commande(id_commande)
);

CREATE TABLE livre(
   id_livreur INT,
   id_vehicule INT,
   id_commande INT,
   PRIMARY KEY(id_livreur, id_vehicule, id_commande),
   FOREIGN KEY(id_livreur) REFERENCES Livreur(id_livreur),
   FOREIGN KEY(id_vehicule) REFERENCES Vehicule(id_vehicule),
   FOREIGN KEY(id_commande) REFERENCES Commande(id_commande)
);
