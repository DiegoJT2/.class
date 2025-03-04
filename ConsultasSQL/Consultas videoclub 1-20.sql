/*1. Realiza una consulta que nos muestre los campos Título, FECHAPUBLICACION de todas las
películas, ordenado descendentemente por el Título.*/
SELECT Titulo, FECHAPUBLICACION FROM videoclub.Peliculas
ORDER BY TITULO DESC;
/*2. Realiza una consulta que nos muestre los campos Título, FECHAPUBLICACION y Género de
todas las películas, ordenando ascendentemente por FECHAPUBLICACION y
descendentemente por Género.*/
SELECT titulo, FECHAPUBLICACION, NOMBREGENERO FROM videoclub.Peliculas AS A
JOIN videoclub.Generos AS B ON A.GENERO = B.CODIGOGENERO
ORDER BY FECHAPUBLICACION ASC, GENERO DESC;
/*3. Realiza una consulta que nos muestre los campos Título, FECHAPUBLICACION, Género y
Tipo de todas las películas, ordenando ascendentemente por Tipo y Título.*/
SELECT titulo, fechapublicacion, nombreGenero, modalidad FROM videoclub.Peliculas AS A
JOIN videoclub.Generos AS B ON A.GENERO = B.CODIGOGENERO
JOIN videoclub.Tipopeliculas AS C ON A.TIPOPELICULA = C.CODIGOENTREGA
ORDER BY tipopelicula, titulo ASC;
/*4. Realiza una consulta que nos muestre el Título y Género de las 7 últimas películas (en orden
alfabético) del género Comedia.*/
SELECT titulo, FECHAPUBLICACION, NOMBREGENERO FROM videoclub.Peliculas AS A
JOIN videoclub.Generos AS B ON A.GENERO = B.CODIGOGENERO
WHERE B.NOMBREGENERO = "Comedia"
ORDER BY A.TITULO DESC LIMIT 7;
/*5. Realiza una consulta que nos muestre todos los campos de las películas cuyo género sea
Drama o Comedia, ordenadas por genero.*/
SELECT A.*, NOMBREGENERO FROM videoclub.Peliculas AS A
JOIN videoclub.Generos AS B ON A.GENERO = B.CODIGOGENERO
WHERE B.NOMBREGENERO IN ("Drama", "Comedia")
ORDER BY B.NOMBREGENERO;
/*6. Realiza una consulta que nos muestre todos los campos de las películas cuyo precio esté
entre 15 y 16, ordenadas por título.*/
SELECT * FROM videoclub.Peliculas AS A
WHERE precio IN (15, 16)
ORDER BY titulo;
/*7. Realiza una consulta que nos muestre todos los campos de las películas PUBLICADAS en el
año 2017.*/
SELECT * FROM videoclub.Peliculas AS A
WHERE YEAR (FECHAPUBLICACION) = 2017;
/*8. Realiza una consulta que nos muestre todos los campos de las películas PUBLICADAS en el
mes de marzo del año 2017.*/
SELECT * FROM videoclub.Peliculas
WHERE YEAR(fechapublicacion) = 2017 AND MONTH(fechapublicacion) = 7;
/*9. Realiza una consulta que nos muestre el Título de la película y al lado una columna donde
aparezca ‘Para niños’ si el género es INFANTIL, o que aparezca ‘Para adultos’ en caso
contrario. (El título de la nueva columna se llamará RECOMENDADA).*/
SELECT A.TITULO, if(B.nombregenero="infantil", "PARA NIÑOS", "PARA ADULTOS") AS RECOMENDADA FROM videoclub.Peliculas AS A
JOIN videoclub.Generos AS B ON A.GENERO = B.CODIGOGENERO;
/*10. Realiza una consulta que nos muestre los Títulos de películas que empiezan por M o P.*/
SELECT titulo FROM videoclub.Peliculas
WHERE titulo LIKE "M%" OR titulo LIKE"P%";
/*11. Realiza una consulta que nos muestre los Títulos de películas que acaben en la letra S.*/
SELECT titulo FROM videoclub.Peliculas
WHERE titulo LIKE "%S";
/*12. Realiza una consulta que nos muestre los Títulos de películas que contengan la palabra
AMOR.*/
SELECT titulo FROM videoclub.Peliculas
WHERE TITULO LIKE "%AMOR%";
/*13. Realiza una consulta que nos muestre los Títulos y Géneros de películas que tengan 4
caracteres en su título.*/
SELECT titulo, NOMBREGENERO FROM videoclub.Peliculas AS A
JOIN videoclub.Generos AS B ON B.CODIGOGENERO = A.GENERO
WHERE LENGTH(TITULO) = 4;
/*14. Realiza una consulta que nos muestre los Títulos y Géneros de películas que tengan 4
caracteres en su título y sean de género Acción.*/
SELECT TITULO, NOMBREGENERO FROM videoclub.Peliculas AS A
JOIN videoclub.Generos AS B ON A.GENERO = B.CODIGOGENERO
WHERE LENGTH(TITULO) = 4 AND NOMBREGENERO = "ACCIÓN";
/*15. Realiza una consulta que nos muestre los Títulos de películas que tengan por lo menos un
carácter numérico.*/
SELECT titulo FROM videoclub.Peliculas AS A
WHERE titulo REGEXP "[0-9]";
/*16. Realiza una consulta que nos muestre los Títulos y la fecha de publicación de las películas
que empiezan por alguno de los siguientes caracteres: C,D,E,F,G,H*/
SELECT TITULO, FECHAPUBLICACION FROM videoclub.Peliculas AS A
WHERE TITULO LIKE "C%" OR TITULO LIKE "D%" OR TITULO LIKE"E%" OR TITULO LIKE "F%" OR TITULO LIKE "G%" OR TITULO LIKE"H%";
/*17. Realiza una consulta que nos muestre los Títulos y la fecha de publicación de las películas
que empiezan por alguno de los siguientes caracteres: C,D,E,F,G,H,P,Q,R,S,T,U,V*/
SELECT TITULO, FECHAPUBLICACION FROM videoclub.Peliculas AS A
WHERE titulo REGEXP '^[CDEFGHPQRSTUV]';
/*18. Realiza una consulta que nos muestre los Títulos y la fecha de publicación de las películas
que no terminen por alguno de los siguientes caracteres: I,J,K,L,M,N,O,P*/
SELECT TITULO, FECHAPUBLICACION FROM videoclub.Peliculas
WHERE titulo NOT REGEXP '[I-P]$';
/*19. Realiza una consulta que muestre los Títulos de películas que no contengan la letra a.*/
SELECT TITULO FROM videoclub.Peliculas
WHERE TITULO NOT LIKE "%A%";
/*20. Realiza una consulta que nos muestre los Títulos y el género de las películas cuyo género sea
TERROR, COMEDIA, INFANTIL ordenadas ascendentemente por el título.*/
SELECT TITULO, NOMBREGENERO FROM videoclub.peliculas AS A
JOIN videoclub.generos AS B ON A.codigopelicula = B.codigogenero
WHERE NOMBREGENERO LIKE "%COMEDIA%" OR NOMBREGENERO LIKE "TERROR" OR NOMBREGENERO LIKE "INFANTIL"
ORDER BY TITULO ASC;