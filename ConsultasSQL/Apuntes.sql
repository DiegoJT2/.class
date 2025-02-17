SELECT genero,
    MIN(precio) AS precio_minimo,
    MAX(precio) AS precio_maximo,
    AVG(precio) AS precio_promedio
FROM videoclub.peliculas
GROUP BY genero;

COUNT - Contar
SUM - Suma
CONCAT

La cláusula HAVING en SQL se utiliza para filtrar los grupos de resultados que se generan mediante la cláusula
GROUP BY. A diferencia de la cláusula WHERE, que filtra filas individuales antes de agrupar los datos,
HAVING filtra después de que se han aplicado las funciones de agregación (como COUNT(), SUM(), AVG(), etc.).

Por ejemplo, en la siguiente consulta:

SELECT genero,
       COUNT(*) AS "TOTAL PELICULAS"
FROM videoclub.peliculas
GROUP BY genero
HAVING COUNT(*) > 1;

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

REGEXP: Busca coincidencias basadas en una expresión regular.
^[CDEFGHPQRSTUV]: Busca títulos que comienzan (^) con cualquiera de las letras en el conjunto especificado
^: Marca el inicio de la cadena.
$: Marca el final de la cadena.
[ ]: Define un conjunto de caracteres permitidos o prohibidos.

/*CASE*/
SELECT jobtitle
CASE gender WHEN "M" THEN "MALE" WHEN "F" THEN "FEMALE" ELSE "unknown" VALUE End
FROM HumanResources.Employee

Pablo20? [a-zA-Z]+ 1 o mas caracteres
Pablo20? [a-zA-Z]{6} solo 6
Pablo20? [a-zA-Z]{6,} 6 o +
Pablo20? [a-zA-Z]{6,10} de 6 a 10
Pablo20? [a-zA-Z]+[0-9]+[\\?] solo admite 1 interrogante, doble barra porque si no es una funcion especial
Pablo20? ([a-zA-Z]+) obliga a que este al principio
[]rango ()exacto
^([a-z]+)[\.]([a-z]+)([0-9]{2})(\@)zaragoza(\.)salesianos(\.)edu$
jaraba.tudie19@zaragoza.salesianos.edu
