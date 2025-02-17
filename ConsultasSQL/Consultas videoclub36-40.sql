/*36. Selecciona el Titulo y el Precio de las películas cuyo precio supere al precio medio de
todas las películas.*/
SELECT titulo, precio AS PRECIO FROM videoclub.Peliculas AS A
WHERE precio >(SELECT AVG(precio) FROM videoclub.Peliculas);
/*37. Selecciona el Titulo de las películas que nunca han sido alquiladas.*/
SELECT titulo FROM videoclub.Peliculas AS A 
LEFT JOIN videoclub.Alquileres AS B ON A.CODIGOPELICULA = B.CODIGOPELICULA WHERE B.CODIGOPELICULA IS NULL;
/*38. Selecciona el Titulo de aquellas películas que superen el precio mas bajo de las películas
del género Terror*/
SELECT titulo FROM videoclub.Peliculas WHERE precio >(SELECT MIN(precio) FROM videoclub.Peliculas AS A
JOIN videoclub.Generos AS B ON A.GENERO = B.CODIGOGENERO WHERE B.NOMBREGENERO = 'Terror');
/*39. Seleccionar el Titulo de las películas que tengan como inicial una letra diferente a las
iniciales de las películas del género comedia.*/
SELECT titulo FROM videoclub.Peliculas WHERE LEFT(titulo, 1) NOT IN(SELECT DISTINCT LEFT(titulo, 1)
FROM videoclub.Peliculas AS A JOIN videoclub.Generos AS B ON A.GENERO = B.CODIGOGENERO WHERE B.NOMBREGENERO = 'Comedia');
/*40. Seleccionar el Título de las películas que contengan las letras ‘el’ o que hayan sido
alquiladas por personas cuyo nombre contenga las letras ‘el’*/
SELECT titulo FROM videoclub.Peliculas AS A
LEFT JOIN videoclub.Alquileres AS B ON A.CODIGOPELICULA = B.CODIGOPELICULA
LEFT JOIN videoclub.Clientes AS C ON B.CODIGOCLIENTE = C.CODIGOCLIENTE WHERE titulo LIKE '%el%' OR NOMBRECLIENTE LIKE '%el%';