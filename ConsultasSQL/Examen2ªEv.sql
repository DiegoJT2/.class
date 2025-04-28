/*1. Cantidad de películas por género*/
SELECT genero, COUNT(*) AS "TOTAL PELICULAS"
FROM peliculas
GROUP BY genero;
/*2. Precio más barato, más caro y promedio por género*/
SELECT 
    genero,
    MIN(precio) AS "PRECIO MINIMO",
    MAX(precio) AS "PRECIO MAXIMO",
    AVG(precio) AS "PRECIO PROMEDIO"
FROM peliculas
GROUP BY genero;
/*3. Fechas de publicación con una sola película*/
SELECT fecha_publicacion, COUNT(*) AS "TOTAL PELICULAS"
FROM peliculas
GROUP BY fecha_publicacion
HAVING COUNT(*) = 1;
/*INSERT*/
INSERT INTO Torneos (nombre, juego_id, fecha)
VALUES ('Masters League 2024', 3, '2024-10-15');
/*DELETE (5 puntos)
1. Jugadores que nunca han jugado ni se han inscrito en un torneo:*/
DELETE FROM Jugadores
WHERE id NOT IN (SELECT DISTINCT jugador_id FROM Partidas)
  AND id NOT IN (SELECT DISTINCT jugador_id FROM Inscripciones_Torneos);
/*2. Eliminar partidas con puntuación menor al promedio de todas las partidas:*/
DELETE FROM Partidas
WHERE puntuacion < (
    SELECT AVG(puntuacion) FROM Partidas
);
/*3. Eliminar los 3 jugadores con más puntuación total en el juego con ID 7:*/
DELETE FROM Jugadores
WHERE id IN (
    SELECT jugador_id
    FROM Partidas
    WHERE juego_id = 7
    GROUP BY jugador_id
    ORDER BY SUM(puntuacion) DESC
    LIMIT 3
);
/*4. Eliminar juegos lanzados antes del año 2000 y con menos partidas que el promedio de los juegos lanzados después del 2000:*/
DELETE FROM Juegos
WHERE año_lanzamiento < 2000
  AND id IN (
    SELECT juego_id
    FROM Partidas
    GROUP BY juego_id
    HAVING COUNT(*) < (
        SELECT AVG(cant_partidas) FROM (
            SELECT COUNT(*) AS cant_partidas
            FROM Partidas
            WHERE juego_id IN (
                SELECT id FROM Juegos WHERE año_lanzamiento >= 2000
            )
            GROUP BY juego_id
        ) AS subq
    )
  );
/*UPDATE (4 puntos)
1. Corregir torneos que deberían estar en el juego ID 5 y están en el ID 2:*/
UPDATE Torneos
SET juego_id = 5
WHERE juego_id = 2;

/*2. Aumentar en 10 el nivel de jugadores con más de 5 partidas:*/
UPDATE Jugadores
SET nivel = nivel + 10
WHERE id IN (
    SELECT jugador_id
    FROM Partidas
    GROUP BY jugador_id
    HAVING COUNT(*) > 5
);
/*3. Subir 5 puntos la puntuación de todas las partidas de un juego específico:*/
UPDATE Partidas
SET puntuacion = puntuacion + 5
WHERE juego_id = [ID_DEL_JUEGO];
/*Sustituye [ID_DEL_JUEGO] por el número que quieras (por ejemplo, 7).*/