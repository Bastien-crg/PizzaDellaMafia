-- En une fois mais repetition
SELECT pizzaName, basePrice, ingredientName FROM Pizza NATURAL JOIN Ingredient;

--sinn
SELECT pizzaName, basePrice FROM Pizza;
SELECT ingresdientName FROM Ingredient NATURAL JOIN Pizza WHERE PizzaId = ? ;