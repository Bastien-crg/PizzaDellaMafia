-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 09 juin 2023 à 15:21
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `rapizz`
--

--
-- Déchargement des données de la table `client`
--

USE rapizz;

INSERT INTO `client` (`id_client`, `solde`, `adresse`, `stack`, `nom_client`) VALUES
(0, 150.00, '1 rue de la street', 2, 'Sebastien'),
(1, 0.00, '27bis avenue des chats', 0, 'Isabelle'),
(2, 10.50, '7 rue de la flemme', 0, 'Pierre'),
(3, 30.00, '13 rue en fromage', 0, 'Jung');

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_commande`, `prix_effectif`, `date_commande`, `delivery_time`, `id_client`) VALUES
(0, '18.50', '2023-06-08 09:04:25', 15, 0),
(1, '0', '2023-06-05 09:10:10', 35, 0),
(2, '8.50', '2023-06-01 09:32:51', 10, 2);

--
-- Déchargement des données de la table `containing`
--





--
-- Déchargement des données de la table `ingredient`
--

INSERT INTO `ingredient` (`id_ingredient`, `nom_ingredient`) VALUES
(0, 'Tomate'),
(1, 'Creme fraiche'),
(2, 'oignon'),
(3, 'Pomme de terre'),
(4, 'Merguez'),
(5, 'Peperoni'),
(6, 'Emmental'),
(7, 'Mozzarella');


--
-- Déchargement des données de la table `livreur`
--

INSERT INTO `livreur` (`id_livreur`, `nom_livreur`) VALUES
(0, 'Celian'),
(1, 'Idriss');

--
-- Déchargement des données de la table `pizza`
--

INSERT INTO `pizza` (`idPizza`, `pizzaName`, `price`) VALUES
(0, 'Margarita', 8.00),
(1, 'Orientale', 10.50),
(2, 'Campagnarde', 10.50);

--
-- Déchargement des données de la table `has_ingredient`
--

INSERT INTO `has_ingredient` (`idPizza`, `id_ingredient`) VALUES
(0, 0),
(0, 6),
(1, 0),
(1, 4),
(1, 5),
(1, 6),
(2, 1),
(2, 2),
(2, 3),
(2, 6);

--
-- Déchargement des données de la table `size`
--

INSERT INTO `size` (`idSize`, `priceCoeff`, `sizeName`) VALUES
(0, '0.75', 'Naine'),
(1, '1', 'Humaine'),
(2, '1.25', 'Hogresse');

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`id_vehicule`, `type`) VALUES
(0, 'Voiture'),
(1, 'Voiture'),
(2, 'Scooter');
COMMIT;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id_livreur`, `id_vehicule`, `id_commande`) VALUES
(0, 2, 0),
(1, 0, 1),
(1, 2, 2);


INSERT INTO `containing` (`idPizza`, `idSize`, `id_commande`, `quantite`) VALUES
(0, 1, 0, 1),
(0, 1, 2, 1),
(1, 1, 0, 1),
(1, 2, 1, 2),
(2, 2, 1, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
