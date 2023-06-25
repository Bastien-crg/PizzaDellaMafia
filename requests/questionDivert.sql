-- Never used vehicles
SELECT id_vehicule, type FROM vehicule WHERE NOT EXISTS (SELECT * FROM livre WHERE livre.id_vehicule = vehicule.id_vehicule);

-- Number of order for client ?
SELECT count(*) AS order_count FROM commande WHERE id_client = ? ;

-- Mean price of all commands
SELECT AVG(prix_effectif) FROM commande;

-- Clients that has ordered more than most people
SELECT id_client as client_id, count(*) AS order_number FROM commande 
GROUP BY id_client
having order_number > (
	select avg(order_count) as avg_order from(
		SELECT count(*) AS order_count FROM commande GROUP BY id_client
    ) as counts
);


