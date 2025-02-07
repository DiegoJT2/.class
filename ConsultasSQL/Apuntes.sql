AVG - media
MIN/MAX
COUNT - Cuenta
SUM - Suma

SELECT titulo, FECHAPUBLICACION, NOMBREGENERO FROM videoclub.Peliculas AS A
JOIN videoclub.Generos AS B ON A.GENERO = B.CODIGOGENERO
WHERE B.NOMBREGENERO = "Comedia"
ORDER BY A.TITULO DESC LIMIT 7;/*ordena titulo "A-Z" y linita a 7 las pelicuas mostradas*/

SELECT titulo FROM videoclub.Peliculas
WHERE titulo LIKE "M%" OR titulo LIKE"P%";/*muestra el titulo que empiece por P o M*/

SELECT A.TITULO, if(B.nombregenero="infantil", "PARA NIÑOS", "PARA ADULTOS") AS RECOMENDADA
/*if(lugar="condicion", "resultado", "else")*/
FROM videoclub.Peliculas AS A
JOIN videoclub.Generos AS B ON A.GENERO = B.CODIGOGENERO;

SELECT * FROM videoclub.Peliculas
WHERE YEAR(fechapublicacion) = "2017" AND MONTH(fechapublicacion) = "7";

WHERE LENGTH(TITULO) = 4;/*coge la palabra con esa longitud de caracteres*/

SELECT titulo FROM videoclub.Peliculas AS A
WHERE titulo REGEXP "[0-9]"; /* muestra al menos un caracter numerico*/

SELECT TITULO, FECHAPUBLICACION FROM videoclub.Peliculas AS A
WHERE titulo REGEXP '^[CDEFGHPQRSTUV]';
/*REGEXP: Busca coincidencias basadas en una expresión regular.
^[CDEFGHPQRSTUV]: Busca títulos que comienzan (^) con cualquiera de las letras en el conjunto especificado
^: Marca el inicio de la cadena.
$: Marca el final de la cadena.
[ ]: Define un conjunto de caracteres permitidos o prohibidos.*/