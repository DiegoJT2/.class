/*41. Cantidad de personas de cada país.*/
SELECT D.pais, COUNT(A.idvoluntarios) AS Total
FROM voluntarios AS A, localidades AS B, provincias AS C, paises AS D
WHERE (A.idlocalidad=B.idlocalidad AND B.idprovincia=C.idprovincia AND C.idpais=D.idpais)
GROUP BY D.pais;
/*42. Cantidad de personas de las diferentes provincias de España.*/
SELECT C.provincia, COUNT(A.idvoluntarios) AS Total
FROM voluntarios AS A, localidades AS B, provincias AS C, paises AS D
WHERE (A.idlocalidad=B.idlocalidad AND B.idprovincia=C.idprovincia AND C.idpais=D.idpais)AND D.pais='España'
GROUP BY C.provincia;
/*43. Cantidad de personas de las tres provincias de Aragón.*/
SELECT provincia, COUNT(*) AS "Cantidad de Personas" FROM voluntarios_old
WHERE provincia IN ('Huesca', 'Zaragoza', 'Teruel') GROUP BY provincia;
/*44. Cantidad de personas de las diferentes poblaciones de Huesca.*/
SELECT poblacion, COUNT(*) AS "Cantidad de Personas" FROM Voluntarios_OLD
WHERE provincia = 'Huesca' GROUP BY poblacion;
/*45.
a. Cantidad de personas que se llaman igual.*/
SELECT nombre, COUNT(*) AS "Cantidad de Personas" FROM voluntarios
GROUP BY nombre HAVING COUNT(*) > 1 ORDER BY COUNT(*) DESC;
/*b. Nombre que más se repite*/
SELECT nombre, COUNT(*) AS "Cantidad de Personas" FROM voluntarios
GROUP BY nombre ORDER BY COUNT(*) DESC
LIMIT 1;
/*c. Nombre que se repiten entre 5 y 10 veces*/
SELECT nombre, COUNT(*) AS "Cantidad de Personas" FROM voluntarios
GROUP BY nombre HAVING COUNT(*) BETWEEN 5 AND 10 ORDER BY COUNT(*) DESC;
/*46. Cantidad de personas por edades.*/
SELECT edad, COUNT(*) AS "Cantidad de Personas" FROM voluntarios_old GROUP BY edad ORDER BY edad;
/*47. Cantidad de personas por tallas.*/
SELECT talla, COUNT(*) AS "Cantidad de Personas" FROM voluntarios GROUP BY talla ORDER BY talla;
/*48. Cantidad de personas por profesion.*/
SELECT laboral, COUNT(*) AS "Cantidad de Personas" FROM voluntarios_old
GROUP BY laboral ORDER BY COUNT(*) DESC;
/*49. Cantidad de personas por sexo.*/
SELECT sexo, COUNT(*) AS "Cantidad de Personas" FROM voluntarios_old
GROUP BY sexo ORDER BY COUNT(*) DESC;
/*50. Cantidad de personas nacidas en cada mes.*/
SELECT MONTH(fNacimiento) AS "Mes", COUNT(*) AS "Cantidad de Personas" FROM voluntarios
GROUP BY MONTH(fNacimiento) ORDER BY MONTH(fNacimiento);
/*51. Cantidad de personas nacidas en cada trimestre.*/
SELECT QUARTER(fNacimiento) AS "Trimestre", COUNT(*) AS "Cantidad de Personas" FROM voluntarios
GROUP BY QUARTER(fNacimiento) ORDER BY QUARTER(fNacimiento);
/*52. Cantidad de personas nacidas en cada trimestre, pero solo de aquellos trimestres
que tengan más de 110 personas.*/
SELECT QUARTER(fNacimiento) AS "Trimestre", COUNT(*) AS "Cantidad de Personas" FROM voluntarios
GROUP BY QUARTER(fNacimiento) HAVING COUNT(*) > 110 ORDER BY QUARTER(fNacimiento);
/*53. Cantidad de personas de los diferentes niveles de italiano hablado.*/
SELECT A.hablado AS "Nivel de Italiano", COUNT(A.idvoluntario) AS "Cantidad de Personas" FROM nivel AS A
JOIN idiomas AS B ON A.ididioma = B.ididioma WHERE B.idioma = 'Italiano' GROUP BY A.hablado ORDER BY A.hablado;
/*54. Cantidad de personas de los diferentes niveles de frances hablado*/
SELECT A.hablado AS "Nivel de Francés", COUNT(A.idvoluntario) AS "Cantidad de Personas" FROM nivel AS A
JOIN idiomas AS B ON A.ididioma = B.ididioma WHERE B.idioma = 'Francés' GROUP BY A.hablado ORDER BY A.hablado;
/*55. Cantidad de personas de los diferentes niveles de ingles hablado.*/
SELECT A.hablado AS "Nivel de Inglés", COUNT(A.idvoluntario) AS "Cantidad de Personas" FROM nivel AS A
JOIN idiomas AS B ON A.ididioma = B.ididioma WHERE B.idioma = 'Inglés' GROUP BY A.hablado ORDER BY A.hablado;
/*56. Cantidad de personas de los diferentes niveles de ingles hablado y por edades.*/
SELECT A.hablado AS "Nivel de Inglés", C.edad, COUNT(A.idvoluntario) AS "Cantidad de Personas" FROM nivel AS A
JOIN idiomas AS B ON A.ididioma = B.ididioma JOIN Voluntarios_OLD AS C ON A.idvoluntario = C.idvoluntario
WHERE B.idioma = 'Inglés' GROUP BY A.hablado, C.edad ORDER BY C.edad, A.hablado;
/*57. Promedio de edades, Más viejo, Más Joven*/
SELECT AVG(A.edad) AS "Promedio de Edades", MAX(A.edad) AS "Más Viejo", MIN(A.edad) AS "Más Joven"
FROM Voluntarios_OLD AS A;
/*58. Promedio de edades de cada provincia.*/
SELECT A.provincia, AVG(A.edad) AS "Promedio de Edades" FROM Voluntarios_OLD AS A GROUP BY A.provincia
ORDER BY A.provincia;
/*59. Edad de la persona más viejo y más joven de cada pais.*/
SELECT A.pais, MAX(A.edad) AS "Más Viejo", MIN(A.edad) AS "Más Joven" FROM Voluntarios_OLD AS A
GROUP BY A.pais ORDER BY A.pais;