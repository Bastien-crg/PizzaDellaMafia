-- notre bdd permet la commande de plusieurs pizza
-- Fiche de livraison de la commande 0
SELECT nom_livreur, type, nom_client, date_commande, delivery_time FROM commande NATURAL JOIN livre NATURAL JOIN livreur NATURAL JOIN vehicule NATURAL JOIN client WHERE id_commande = 0;
-- pizza et leur prix de base relative a la commande 0
SELECT pizzaName, price, quantite FROM pizza NATURAL JOIN containing WHERE id_commande = 0;
