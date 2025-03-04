/*1. Extranjeros que vienen al FOJE*/
SELECT v.* FROM voluntarios as v, localidades as l, provincias
as p, paises as pa WHERE (v.idlocalidad=l.idlocalidad and
l.idprovincia = p.idprovincia And p.idpais=pa.idpais) and
pa.pais <> "España";
/*2. Personas de fuera de Aragón*/
SELECT * FROM voluntarios_OLD WHERE provincia<>'Zaragoza'
AND provincia<> 'Huesca' AND provincia<> 'TERUEL';
/*3. Personas de Jaca*/
SELECT * FROM voluntarios_OLD WHERE poblacion = 'Jaca';
/*4. Personas que no tengan alojamiento durante el FOJE*/
SELECT * FROM voluntarios_OLD WHERE alojamientofoje = 'no';
/*5. Personas entre 18 y 25 años que pesen más de 70Kg y lleven la talla M o L*/
SELECT * FROM voluntarios_OLD WHERE (Edad >= 18 AND Edad <= 25)
AND Peso > 70 AND (Talla = 'M' OR Talla = 'L');
/*6. Personas entre 26 y 40 años de Zaragoza o Personas entre 41 y 55 años de huesca*/
SELECT * FROM voluntarios_OLD WHERE (Edad >=26 AND Edad <= 40 AND provincia = 'ZARAGOZA')
OR (Edad >=26 AND Edad <= 40 AND  provincia = 'HUESCA');
/*7. Personas mayores a 55 años*/
SELECT * FROM Voluntarios_OLD WHERE Edad>55;
/*8. Personas con una talla XXL y cuya altura sea inferior a 175cm*/
SELECT * FROM voluntarios as v WHERE v.talla ='XXL' and v.altura < 175;
/*9. Personas estudiantes con nivel ALTO en informatica*/
SELECT A.* FROM voluntarios AS A, laboral AS B WHERE A.idLabor = B.IdLabor AND
B.labor ='Estudiante' AND A.nivelInformatica = 'alto';
/*10. Personas estudiantes con un nivel ALTO en ingles hablado y escrito*/
SELECT A.nombre, C.hablado, C.escrito, B.labor FROM
voluntarios AS A, laboral AS B,  nivel AS C,  idiomas as D, tareas AS E
WHERE (A.idLabor = B.IdLabor AND A.IdVoluntarios = C.IdVoluntario
AND C.IdIdioma = D.Ididioma) AND B.labor ='Estudiante' AND A.nivelInformatica = 'alto'
AND C.hablado = 'alto' AND C.escrito = 'alto' AND D.idioma = 'Inglés';
/*11. Personas jubiladas con un nivel ALTO en frances hablado y escrito o con un nivel
ALTO en inglés hablado y escrito*/
SELECT v.nombre, n.hablado, n.escrito, l.labor, i.idioma FROM voluntarios AS v, laboral AS l,
tareas AS t, nivel AS n , idiomas AS i WHERE (v.idLabor = l.IdLabor AND v.IdVoluntarios = n.IdVoluntario
AND n.IdIdioma = i.Ididioma) AND l.labor ='Jubilado' AND v.nivelInformatica = 'alto'
AND n.hablado = 'alto' AND n.escrito = 'alto' AND (i.idioma = 'Inglés' OR i.idioma = 'Francés');
/*12. Personas que practiquen esquí en cualquiera de sus modalidades*/
SELECT A.nombre, C.deporte FROM voluntarios AS A, practicar AS B, deportes AS C WHERE
(A.IdVoluntarios = B.IdVoluntarios AND B.IdDeportes = C.IdDeporte) AND C.deporte LIKE '%Esquí%';
/*13. Personas que cumplen años hoy*/
SELECT * FROM voluntarios AS A WHERE (MONTH(A.fnacimiento) = MONTH(CURRENT_DATE)) AND
(DAY(A.fnacimiento) = DAY(CURRENT_DATE));
/*14. Personas que cumplen años en el mes de diciembre*/
SELECT * FROM voluntarios AS A WHERE MONTH(A.fnacimiento) = 12;
/*15. Personas que cumplen años en invierno*/
SELECT * FROM voluntarios as v WHERE (DAY(v.fnacimiento)>=21 AND MONTH(v.fnacimiento)=12) OR
MONTH(v.fnacimiento)=1 OR MONTH(v.fnacimiento)=2 OR(DAY(v.fnacimiento)<21 AND MONTH(v.fnacimiento)=3);
/*16. Personas que cumplen años en el primer trimestre del año*/
SELECT * FROM voluntarios as v WHERE MONTH(v.fnacimiento) IN (1,2,3);
/*17. Personas que tengan preferencia 1 en tareas de informática o preferencia 1 en tareas
de conducción*/
SELECT A.nombre, B.nombre FROM voluntarios AS A, tareas AS B, preferencias AS C WHERE
(A.IdVoluntarios = C.IdVoluntario AND B.IdTarea = C.IdTarea) AND B.nombre = 'Informática' OR
B.nombre = 'Conducción';
/*18. Personas que tengan preferencia 1 en tareas de interprete y que tengan un nivel
hablado alto en cualquiera de los idiomas*/
SELECT v.nombre, t.nombre FROM voluntarios AS v, tareas AS t, preferencias AS p, nivel AS n, idiomas AS i
WHERE (v.IdVoluntarios = p.IdVoluntario AND t.IdTarea = p.IdTarea AND
v.IdVoluntarios = n.IdVoluntario AND n.IdIdioma = i.Ididioma) AND p.Preferencia = 1 AND
t.nombre = 'Intérprete' AND n.hablado='alto' AND n.escrito='alto' AND (i.idioma = 'Inglés' OR
i.idioma = 'Francés' OR i.idioma = 'Alemán' OR i.idioma = 'Italiano');
/*19. Personas que tengan preferencia 1 en tareas de informatica y tengan un nivel medio o
alto en informatica*/
SELECT v.nombre, v.nivelInformatica FROM voluntarios AS v, tareas AS t, preferencias AS p WHERE
(v.IdVoluntarios = p.IdVoluntario AND t.IdTarea = p.IdTarea) AND p.Preferencia = 1 AND t.nombre
= 'Informática' AND (v.nivelInformatica = 'Alto' OR v.nivelInformatica='Medio');
/*20. Personas que tengan preferencia 1 en tareas de conducción, tengan un nivel medio o
alto de ingles hablado, sean mayores de 26 años, tengan carnet de conducir B y sean
de Huesca.*/
SELECT v.nombre, r.provincia , t.nombre, v.carnetB, i.idioma, n.hablado, (year(CURRENT_DATE)-
year(v.fnacimiento)) AS Edad FROM voluntarios AS v, tareas AS t, provincias AS r, preferencias
AS p, nivel AS n, idiomas AS i WHERE (v.IdVoluntarios = p.IdVoluntario AND t.IdTarea = p.IdTarea
AND v.IdVoluntarios= n.IdVoluntario) AND (year(CURRENT_DATE)-year(v.fnacimiento)) > 26
AND p.Preferencia=1 AND t.nombre = 'Intérprete' AND v.carnetB = 'True' AND (n.hablado = 'alto'
OR n.hablado = 'medio') AND i.idioma = 'Inglés' AND r.provincia = 'Huesca';
/*21. Personas que tengan preferencia 2 en tareas administrativas, tengan un nivel medio o
alto de ingles hablado y sean mayores de 40 años.*/
SELECT * FROM Voluntarios_OLD AS A WHERE A.TareasAdministrativos = 2
AND (A.InglesHa = 'medio' OR A.InglesHa='alto')AND A.Edad > 40;
/*22. Personas cuyo nombre comience por A y que sean de Cataluña*/
SELECT * FROM Voluntarios_OLD A WHERE A.nombre LIKE 'a%'
AND provincia IN ('Barcelona','Lleida','Tarragona','Girona');
/*23. Personas cuyo codigo postal comience por 2 y termine en 6*/
SELECT * FROM Voluntarios_OLD WHERE Cp LIKE '2%6';
/*24. Personas cuya población comience por CAN*/
SELECT * FROM voluntarios v, localidades l
WHERE v.idLocalidad = l.idLocalidad AND l.localidad LIKE 'can%';
/*25. Personas cuyo nombre comience por cualquiera de las siguientes letras
F,G.H,I,J,K,L,M*/
SELECT * FROM voluntarios WHERE nombre REGEXP '^[F-M]';
/*26. Personas cuya cuarta letra del nombre tenga una de las siguientes letras P,Q,R,S,T
y además sean aragonesas.*/
SELECT l.localidad, p.provincia, v.* FROM voluntarios AS v, localidades AS l, provincias AS p WHERE
(v.idLocalidad = l.idLocalidad AND l.idProvincia = p.idProvincia) AND v.nombre REGEXP '^...[P-T]'
AND p.provincia IN ('Zaragoza', 'Huesca', 'Teruel');
/*27. Personas cuyo nombre comience por cualquiera de las siguientes letras
A,B,C,D,E,F,G,H,I,J,K,L sean varones y residan en Galicia*/
SELECT l.localidad, p.provincia, v.* FROM voluntarios as v, localidades as l, provincias as p
WHERE (v.idLocalidad = l.idLocalidad AND l.idProvincia = p.idProvincia) AND v.nombre REGEXP
'^[A-L]' AND p.provincia IN ('Pontevedra', 'Orense', 'Lugo', 'A Coruña');
/*28. Personas cuyo nombre comience y termine por una vocal*/
SELECT * FROM voluntarios WHERE nombre REGEXP '^[aeiou]' AND nombre REGEXP '[aeiou]';
/*29. Personas cuyo nombre tenga 3 letras o tenga 10 letras*/
SELECT * FROM voluntarios WHERE nombre LIKE '___' OR nombre LIKE '__________';
/*30. Personas en cuya población aparezca la palabra VILLANUEVA*/
SELECT * FROM voluntarios_old WHERE poblacion LIKE 'VILLANUEVA%';
/*31. Personas en cuya población aparezca la letra Ñ*/
SELECT * FROM voluntarios_old WHERE poblacion REGEXP '[ñÑ]';
/*32. Personas en cuya población aparezca una vocal acentuada*/
SELECT * FROM voluntarios_old WHERE Poblacion REGEXP '[áéíóúàèìòùÁÉÍÓÚÀÈÌÒÙ]';
/*33. Seleccionar el campo nombre, otro que contenga las tres primeras posiciones del
nombre, otro que contenga las dos últimas posiciones del nombre.*/
SELECT nombre, LEFT(nombre,3) AS izda, RIGHT(nombre,2) AS dcha FROM voluntarios;
/*34. Seleccionar el campo nombre, población, otro que contenga las posiciones 2 y 3 del
nombre, y otro que contenga la posición primera y última de la población.*/
SELECT v.nombre, l.localidad, MID(v.nombre,2,2) AS parte1,
concat(LEFT(l.localidad,1),RIGHT(l.localidad,1)) AS parte2
FROM voluntarios AS v, localidades AS l;
/*35. Seleccionar el campo nombre, población, otro al que llamaremos usuario, que
contenga las tres primeras posiciones del nombre junto con las tres ultimas posiciones
de la población y el idvoluntario y otro al que llamaremos clave que contenga los
dígitos 3 y 4 del codigo postal junto con el idvoluntario y el mes de nacimiento.*/
SELECT v.nombre, l.localidad, v.IdVoluntarios, p.provincia, v.fNacimiento,
CONCAT(LEFT(v.nombre,3),RIGHT(l.localidad,3),v.IdVoluntarios) AS usuario,
CONCAT(MID(p.provincia,3,2), v.Idvoluntarios, MONTH(v.fNacimiento)) AS clave
FROM voluntarios as v, localidades as l, provincias as p
WHERE (v.idLocalidad = l.idLocalidad AND l.idProvincia = p.idProvincia);
/*36. Seleccionar el campo nombre y otro llamado Dias Vividos donde muestre la diferencia
de dias entre la fecha actual y la de su nacimiento.*/
SELECT nombre, DATEDIFF(CURRENT_DATE, fNacimiento) AS 'Dias Vividos', fNacimiento FROM voluntarios;
/*37. Seleccionar el campo de nombre, fecha, otro llamado Dia Nacimiento en el que se
muestre el día de la semana en el que nació, otro llamado Trimestre en el que se
muestre el trimestre correspondiente a la fecha de nacimiento.*/
SELECT nombre, fNacimiento, WEEKDAY(fNacimiento) AS 'Dia Nacimiento',
QUARTER(fNacimiento) AS 'Trimestre' FROM voluntarios;
/*38. Seleccionar el campo de nombre, provincia y otro al que llamaremos comunidad y el
cual llevará ARAGONES si la persona reside en cualquier provincia de Aragón,
ANDALUZ si reside en cualquier provincia de Andalucía y guiones (--------) en caso
contrario.*/
SELECT v.nombre, p.provincia, if(p.provincia IN ('Zaragoza', 'Huesca', 'Teruel'),'Aragonés',
if(p.provincia IN ('Sevilla','Almería','Cádiz','Huelva','Granada','Málaga','Córdoba','Jaén'),'Andaluz','------'))
AS Comunidad FROM voluntarios AS v, provincias AS p, localidades AS l
WHERE (v.idLocalidad = l.idLocalidad AND l.idProvincia = p.idProvincia);
/*39. Selecciona el campo de nombre, fecha, edad y prepara un campo llamado Edad
Exacta que contenga la edad exacta de la persona.*/
SELECT v.nombre, v.fNacimiento,
DATEDIFF(CURRENT_DATE(), v.fNacimiento) DIV 365 AS 'Edad
Exacta' FROM voluntarios as v;
SELECT vol.nombre, vol.fNacimiento,
CONCAT(TIMESTAMPDIFF(YEAR, vol.fNacimiento, NOW() ),'años,',
TIMESTAMPDIFF(MONTH, vol.fNacimiento, NOW() ) % 12,'meses,',
FLOOR( TIMESTAMPDIFF(DAY, vol.fNacimiento, NOW() ) %
30.4375 ),' dias')AS edadExacta FROM voluntariado.voluntarios AS vol;