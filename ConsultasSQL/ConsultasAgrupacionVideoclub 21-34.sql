/*21 Realiza una consulta que nos agrupe las películas por género.*/
SELECT B.nombregenero AS Genero, COUNT(A.codigopelicula) AS cantidad_peliculas
FROM peliculas AS A JOIN generos AS B ON A.Genero = B.codigoGenero
GROUP BY B.nombregenero ORDER BY cantidad_peliculas DESC;
/*22. Realiza una consulta que nos muestre cuantas películas existen de cada género. (Mostrar como título de columna TOTAL PELICULAS)*/
SELECT B.nombregenero AS Genero, COUNT(A.codigoPelicula) AS "TOTAL PELICULAS"
FROM peliculas AS A JOIN generos AS B ON A.Genero = B.codigoGenero
GROUP BY B.nombregenero ORDER BY "TOTAL PELICULAS" DESC;
/*23. Realiza una consulta que nos muestre cuantas películas existen de cada género y nos muestre aquellos que superen 10 películas (Mostrar como título de columna TOTAL
PELICULAS)*/
SELECT B.nombregenero AS Genero, COUNT(A.codigoPelicula) AS "TOTAL PELICULAS"
FROM peliculas AS A JOIN generos AS B ON A.Genero = B.codigoGenero
GROUP BY B.nombregenero HAVING COUNT(A.codigoPelicula) > 10
ORDER BY "TOTAL PELICULAS" DESC;
/*24. Realiza una consulta que nos muestre cuantas películas existen de los géneros INFANTIL y MUSICAL. (Mostrar como título de columna TOTAL PELICULAS)*/
SELECT B.nombregenero AS Genero, COUNT(A.codigoPelicula) AS "TOTAL PELICULAS"
FROM peliculas AS A JOIN generos AS B ON A.Genero = B.codigoGenero
WHERE B.nombregenero IN ('INFANTIL', 'MUSICAL')
GROUP BY B.nombregenero ORDER BY "TOTAL PELICULAS" DESC;
/*25. Realiza una consulta que nos agrupe las películas por fecha de publicación.*/
SELECT YEAR(A.fechaPublicacion) AS Año, COUNT(A.codigoPelicula) AS "TOTAL PELICULAS"
FROM peliculas AS A GROUP BY YEAR(A.fechaPublicacion) ORDER BY Año DESC;
/*26. Realiza una consulta que nos muestre cuantas películas existen de cada fecha de
publicación . (Mostrar como título de columna TOTAL PELICULAS)*/
SELECT A.fechaPublicacion AS "Fecha de Publicación", COUNT(A.codigoPelicula) AS "TOTAL PELICULAS"
FROM peliculas AS A GROUP BY A.fechaPublicacion HAVING COUNT(A.codigoPelicula) = 1 ORDER BY A.fechaPublicacion DESC;
/*27. Realiza una consulta que nos muestre cuantas películas existen de cada fecha de
publicación mostrando sólo aquellas fechas que tengan 1 película. (Mostrar como título de columna TOTAL PELICULAS)*/
SELECT B.nombregenero AS Genero, A.fechaPublicacion AS "Fecha de Publicación", COUNT(A.codigoPelicula) AS "TOTAL PELICULAS"
FROM peliculas AS A JOIN generos AS B ON A.Genero = B.codigoGenero
GROUP BY B.nombregenero, A.fechaPublicacion
ORDER BY B.nombregenero, A.fechaPublicacion DESC;
/*28. Realiza una consulta que nos agrupe las películas por genero y fecha de publicación.*/
SELECT B.nombregenero AS Genero, A.fechaPublicacion AS "Fecha de Publicación", COUNT(A.codigoPelicula) AS "TOTAL PELICULAS"
FROM peliculas AS A JOIN generos AS B ON A.Genero = B.codigoGenero
GROUP BY B.nombregenero, A.fechaPublicacion
ORDER BY "TOTAL PELICULAS" DESC, A.fechaPublicacion DESC;
/*29. Realiza una consulta que nos muestre cuantas películas existen de cada género y fecha de publicación. (Mostrar como título de columna TOTAL PELICULAS)*/
SELECT B.nombregenero AS Genero, A.fechaPublicacion AS "Fecha de Publicación",
COUNT(A.codigoPelicula) AS "TOTAL PELICULAS", SUM(A.precio) AS "TOTAL"
FROM peliculas AS A JOIN generos AS B ON A.Genero = B.codigoGenero
GROUP BY B.nombregenero, A.fechaPublicacion
ORDER BY "TOTAL PELICULAS" DESC, A.fechaPublicacion DESC;
/*30. Añadir a la consulta anterior, la suma del precio. (Mostrar como título de columna TOTAL)*/
SELECT SUM(A.precio) AS "TOTAL AÑO 2017", SUM(A.precio) * 1.21 AS "TOTAL AÑO 2017 con IVA"
FROM peliculas AS A WHERE YEAR(A.fechaPublicacion) = 2017;
/*31. Realiza una consulta que nos muestre el sumatorio de los precios de las películas
publicadas en el año 2017 y al lado el sumatorio de los precios con un incremento del 21% de IVA . (Mostrar como título de columnas TOTAL AÑO 2017 y TOTAL AÑO 2017 con
IVA)*/
SELECT A.fechaPublicacion AS "Fecha de Publicación", AVG(A.precio) AS "PROMEDIO"
FROM peliculas AS A GROUP BY A.fechaPublicacion ORDER BY A.fechaPublicacion DESC;
/*32. Realiza una consulta que nos muestre por cada fecha de publicación, el promedio de los precios de las películas. (Mostrar como título de columna PROMEDIO)*/
SELECT B.nombregenero AS Genero, MIN(A.fechaPublicacion) AS "Primera Fecha de Publicación",
MAX(A.fechaPublicacion) AS "Última Fecha de Publicación"
FROM peliculas AS A JOIN generos AS B ON A.Genero = B.codigoGenero
GROUP BY B.nombregenero ORDER BY B.nombregenero;
/*33. Realiza una consulta que nos muestre de cada tipo de película la primera y la última fecha de publicación.*/
SELECT B.nombregenero AS Genero, MIN(A.precio) AS "Precio Más Barato", MAX(A.precio) AS "Precio Más Caro",
AVG(A.precio) AS "Promedio de Precios" FROM peliculas AS A JOIN generos AS B ON A.Genero = B.codigoGenero
GROUP BY B.nombregenero ORDER BY B.nombregenero;
