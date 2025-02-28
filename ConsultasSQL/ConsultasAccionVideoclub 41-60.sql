/*41. Borrar todos los registros de clientes que residan fuera de Zaragoza.*/

DELETE Clientes FROM videoclub.Clientes WHERE CODIGOCLIENTE NOT LIKE "Zaragoza";

/*42. Borrar todos los registros de Peliculas cuyo precio sea inferior a 15 €.*/

DELETE Peliculas FROM videoclub.peliculas WHERE precio < 15;

/*43. Borrar todos los registros de películas que empiecen por H.*/

DELETE Peliculas FROM videoclub.Peliculas WHERE TITULO LIKE "%H%";

/*44. Borrar todos los registros de películas cuya modalidad sea ESTRENO*/

DELETE A FROM Peliculas AS A JOIN Tipopeliculas AS B ON A.TIPOPELICULA = B.CODIGOENTREGA
WHERE B.MODALIDAD = "Estreno";

/*45. Borrar todos los registros de películas del género de TERROR*/

DELETE A FROM Peliculas AS A JOIN Generos AS B ON A.GENERO = B.CODIGOGENERO WHERE B.NOMBREGENERO = "Terror";

/*46. Borrar todos los registros de películas cuyo género sea AVENTURAS y hayan sido
adquiridas en el año 98.*/

DELETE A FROM Peliculas AS A JOIN Generos AS B ON A.GENERO = B.CODIGOGENERO
WHERE B.NOMBREGENERO = "Aventuras" AND YEAR(A.FECHAPUBLICACION)=1998;

/*47. Añadir un registro nuevo en Generos cuyo numero sea 14 y se denomine
DOCUMENTAL.*/

INSERT INTO Generos (CODIGOGENERO, NOMBREGENERO)VALUES (14, 'DOCUMENTAL');

/*48. Añadir un registro nuevo en la tabla de clientes cuya información corresponda a
vuestros datos personales.*/

INSERT INTO Clientes ( NOMBRECLIENTE, APELLIDO1CLIENTE, APELLIDO2CLIENTE, DNI, DIRECCION, CIUDAD, CODIGOPOSTAL, PROVINCIA, TELEFONO, FECHALTA)
VALUES ('Diego', 'Jaraba', 'TUDELA', '75233311C', 'Paseo Fernando el Católico', 'ZARAGOZA', '50009', 'ZARAGOZA', '605176932', '2002-07-16');
/*49. Crear una tabla vacía (llamada CopiaGeneros) con los mismos campos de la tabla de
Generos. Traspasar toda la información de Generos a CopiaGeneros.*/

CREATE TABLE CopiaGeneros AS
SELECT * FROM Generos;

/*50. Eliminar los registros de la tabla de CopiaGeneros cuyo nombre comience por C*/

DELETE FROM CopiaGeneros WHERE NOMBREGENERO LIKE 'C%';

/*51. Añadir a la tabla CopiaGeneros los registros de Generos cuyo nombre comience por
C*/

INSERT INTO CopiaGeneros SELECT * FROM Generos WHERE NOMBREGENERO LIKE 'C%';

/*52. Crear una tabla vacía (llamada Infantiles) con los mismos campos de la tabla de
Peliculas. Traspasar todos los registros de la tabla Peliculas a la tabla Infantiles, que
tengan como genero Infantil, Aventuras, Ciencia-ficción*/

CREATE TABLE Infantiles AS SELECT P.* FROM Peliculas AS P
JOIN Generos AS G ON P.GENERO = G.CODIGOGENERO
WHERE G.NOMBREGENERO IN ('Infantil', 'Aventuras', 'Ciencia-ficción');

/*53. Dividir la tabla de clientes en dos tablas llamadas Capital y Provincias con la misma
estructura, en la primera guardaremos todos los registros de clientes que sean de
Zaragoza y en Provincias el resto.*/

CREATE TABLE Capital LIKE Clientes;
CREATE TABLE Provincias LIKE Clientes;
INSERT INTO Capital SELECT * FROM Clientes WHERE CIUDAD = 'ZARAGOZA';
INSERT INTO Provincias SELECT * FROM Clientes WHERE CIUDAD != 'ZARAGOZA';

/*54. Modificar el campo de Codigo Postal de la tabla de clientes para que a todos les
aparezca 50900*/

UPDATE Clientes SET CODIGOPOSTAL = '50900';

/*55. Modificar el campo de Observaciones de la tabla de clientes para que a todos les
ponga un CODIGO formado por 3 caracteres de la izda del nombre + los 2
ultimos del 2 apellido+ 3 digitos centrales del telefono*/

UPDATE Clientes SET OBSERVACIONES = CONCAT(
    LEFT(NOMBRECLIENTE, 3),
    RIGHT(APELLIDO2CLIENTE, 2),
    SUBSTRING(TELEFONO, 4, 3));

/*56. Modificar el campo de Observaciones de la tabla de clientes para que a todos los que
se dieron de alta en el mes de Abril del 99 les aparezca el mensaje de BONIFICADO*/

UPDATE Clientes SET OBSERVACIONES = 'BONIFICADO'
WHERE YEAR(FECHALTA) = 1999 AND MONTH(FECHALTA) = 4;

/*57. Modificar el campo de Ciudad de la tabla de clientes para que todos los que residan
en Zaragoza les aparezca la ciudad en mayúsculas.*/

UPDATE Clientes SET CIUDAD = UPPER(CIUDAD) WHERE CIUDAD = 'Zaragoza';

/*58. Modificar el título de películas para que en todas que empiecen por R les aparezca ----
-*/

UPDATE Peliculas SET TITULO = CONCAT('----', TITULO) WHERE TITULO LIKE 'R%';

/*59. Incrementar el precio de cada película un cinco por ciento.*/

UPDATE Peliculas SET PRECIO = PRECIO * 1.05;

/*60. Acentuar el apellido de López en la tabla de Clientes.*/

UPDATE Clientes SET APELLIDO1CLIENTE = REPLACE(APELLIDO1CLIENTE, 'Lopez', 'López') WHERE APELLIDO1CLIENTE LIKE 'Lopez';