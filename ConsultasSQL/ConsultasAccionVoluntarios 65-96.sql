/*65. Modificar el campo de sexo para que aparezca H de Hombre dónde
actualmente aparece V.*/

UPDATE voluntarios_OLD SET sexo = 'H' WHERE sexo = 'V';

/*66. Modificar la provincia para que aparezca La Rioja dónde actualmente
aparece Logroño.*/

UPDATE voluntarios_OLD SET provincia = 'La Rioja' WHERE provincia = 'Logroño';

/*67. Modificar el campo de laboral para que en todos quede sin información.*/

UPDATE voluntarios_OLD SET laboral = NULL;

/*68. Modificar el campo LABORAL y Deporte para que el contenido aparezca
en mayúsculas.*/

UPDATE voluntarios_OLD SET laboral = UPPER(laboral), deporte = UPPER(deporte);

/*69. Modificar el campo de Edad para que aparezca a edad exacta de la
persona a fecha 13/12/1990.*/

UPDATE voluntarios_OLD SET edad = TIMESTAMPDIFF(YEAR, fechaNacimiento, '1990-12-13') 
    - (DATE_FORMAT('1990-12-13', '%m%d') < DATE_FORMAT(fechaNacimiento, '%m%d'));

/*70. Seleccionar el campo de pais mostrando solo aquellos diferentes. Crear la
tabla de paises con los registros seleccionados. (Voluntarios_OLD)*/

CREATE TABLE paises AS SELECT DISTINCT pais FROM Voluntarios_OLD;

/*71. Seleccionar el campo de pais y provincia mostrando sólo aquellas
provincias de España (las provincias no tienen que repetirse). Crear una
tabla de provincias con los registros seleccionados. Añadir a esta tabla el
resto de provincias que no sean de España.*/

CREATE TABLE provincias AS SELECT DISTINCT provincia FROM voluntarios WHERE pais = 'España';
72. Seleccionar el campo de provincia y población mostrando solo aquellas
poblaciones diferentes. Crear la tabla de poblaciones con los registros
seleccionados.

CREATE TABLE poblaciones AS SELECT DISTINCT provincia, poblacion FROM voluntarios_OLD;

/*73. Asignar la tarea de Administrativo a :15 personas con conocimientos de
ingles ESCRITO o francés ESCRITO Medios o Altos, con nivel medio o
alto de informática*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT D.idvoluntario
    FROM voluntariado.nivel D
    JOIN voluntariado.idiomas E ON D.ididioma = E.ididioma
    JOIN voluntariado.nivel F ON D.idvoluntario = F.idvoluntario
    JOIN voluntariado.idiomas G ON F.ididioma = G.ididioma
    WHERE 
        (E.idioma IN ('Inglés', 'Francés') AND D.escrito IN ('medio', 'alto'))
        AND (G.idioma = 'Informática' AND F.escrito IN ('medio', 'alto'))
    LIMIT 15
) AS sub ON A.idVoluntarios = sub.idvoluntario
SET A.Puesto = 'Administrativo';

/*74. Asignar la tarea de Traducción /Interprete a:
a. 39 personas que tengan nivel Alto de inglés HABLADO.*/

UPDATE voluntarios_OLD
SET TareasTraduccion = 'X', TareasInterprete = 'X'
WHERE InglesHa = 'alto'
LIMIT 39;

/*b. 10 personas que tengan nivel Alto de francés HABLADO.*/

UPDATE voluntarios_OLD
SET TareasTraduccion = 'X', TareasInterprete = 'X'
WHERE FrancesHa = 'alto'
LIMIT 10;
/*c. 2 personas que tengan nivel Alto de alemán HABLADO.*/

UPDATE voluntarios_OLD
SET TareasTraduccion = 'X', TareasInterprete = 'X'
WHERE AlemanHa = 'alto'
LIMIT 2;

/*d. 2 personas que tengan nivel Alto de italiano HABLADO*/

UPDATE voluntarios_OLD
SET TareasTraduccion = 'X', TareasInterprete = 'X'
WHERE ItalianoHa = 'alto'
LIMIT 2;

/*Realizar la siguiente consulta para poder realizar las sql a continuación
indicadas
ALTER TABLE voluntariado.voluntarios ADD Puesto VARCHAR(20) NULL;
ALTER TABLE voluntariado.Voluntarios_OLD ADD Puesto VARCHAR(20)
NULL;

75. Asignar en la tabla voluntarios la columna puesto con el valor
“Informática” a:15 personas con nivel alto de informática y hayan elegido
Tareas Informática con preferencia 1 o 2.*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    JOIN voluntariado.nivel D ON B.idVoluntario = D.idVoluntario
    WHERE C.nombre = 'Informática'
    AND B.Preferencia IN (1, 2)
    AND D.hablado = 'alto'
    AND D.escrito = 'alto'
    LIMIT 15
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Informática';

/*76. Asignar en la tabla voluntarios old la columna Puesto con el valor
“Protocolo” a: 20 personas que hayan elegido Tareas Protocolo con
preferencia 1 o 2, tengan nivel medio escrito de cualquier idioma.*/

UPDATE voluntariado.Voluntarios_OLD A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    JOIN voluntariado.nivel D ON B.idVoluntario = D.idVoluntario
    WHERE C.nombre = 'Protocolo'
    AND B.Preferencia IN (1, 2)
    AND D.escrito = 'medio'
    LIMIT 20
) AS sub ON A.idVoluntario = sub.idVoluntario
SET A.Puesto = 'Protocolo';

/*77. Asignar en la tabla voluntarios old la columna puesto con el valor
“Conducción” a:
a. 10 personas con carnet de conducir tipo C.*/

UPDATE voluntariado.Voluntarios_OLD v
SET v.Puesto = 'Conducción'
WHERE v.CarnetC = 'Si'
LIMIT 10;

/*b. 60 personas con carnet de conducir tipo B que tengan nivel hablado
bajo o medio de algún idioma y que preferiblemente sean de Jaca o
Huesca o Zaragoza.*/

UPDATE voluntariado.Voluntarios_OLD v
JOIN (
    SELECT v.idvoluntario
    FROM voluntariado.Voluntarios_OLD v
    JOIN voluntariado.nivel n ON v.idvoluntario = n.idvoluntario
    WHERE v.CarnetB = 'Si'
    AND (n.hablado = 'Bajo' OR n.hablado = 'Medio')
    AND (v.poblacion = 'Jaca' OR v.poblacion = 'Huesca' OR v.poblacion = 'Zaragoza')
    LIMIT 60
) AS selected_volunteers ON v.idvoluntario = selected_volunteers.idvoluntario
SET v.Puesto = 'Conducción';

/*78. Asignar en la tabla voluntarios la columna puesto el valor “Sanitario” a: 30
personas, que hayan elegido Tareas Sanitarias con preferencia 1 o 2 y
preferiblemente tengan la situación laboral de trabajadores en caso
contrario de estudiante.*/

UPDATE voluntariado.Voluntarios AS A
JOIN (
    SELECT idVoluntarios
    FROM (
        SELECT A.idVoluntarios
        FROM voluntariado.Voluntarios AS A
        JOIN voluntariado.preferencias AS B ON A.idVoluntarios = B.idVoluntario
        JOIN voluntariado.tareas AS C ON B.idTarea = C.IdTarea
        JOIN voluntariado.laboral AS D ON A.idLabor = D.idLabor
        WHERE C.nombre = 'Sanitaria'
          AND (B.Preferencia = 1 OR B.Preferencia = 2)
          AND D.labor IN ('trabajador', 'estudiante')
        ORDER BY CASE WHEN D.labor = 'trabajador' THEN 0 ELSE 1 END
        LIMIT 30
    ) AS temp
) AS sub ON A.idVoluntarios = sub.idVoluntarios
SET A.Puesto = 'Sanitario';

/*79. Asignar en la tabla voluntarios la columna puesto el valor “Comunicación”
a: 30 personas que hayan elegido Tareas Comunicación con preferencia 1
ó 2*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT idVoluntarios
    FROM (
        SELECT A.idVoluntarios
        FROM voluntariado.Voluntarios A
        JOIN voluntariado.preferencias B ON A.idVoluntarios = B.idVoluntario
        JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
        WHERE C.nombre = 'Comunicación'
          AND (B.Preferencia = 1 OR B.Preferencia = 2)
        LIMIT 30
    ) AS temp
) AS sub ON A.idVoluntarios = sub.idVoluntarios
SET A.Puesto = 'Comunicación';

/*80. Asignar en la tabla voluntarios la columna puesto el valor “Acompañante”
a: 20 personas que hayan elegido Tareas Acompañante con preferencia 1
ó 2 ó 3*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT idVoluntarios
    FROM (
        SELECT A.idVoluntarios
        FROM voluntariado.Voluntarios A
        JOIN voluntariado.preferencias B ON A.idVoluntarios = B.idVoluntario
        JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
        WHERE C.nombre = 'Acompañante'
          AND (B.Preferencia = 1 OR B.Preferencia = 2 OR B.Preferencia = 3)
        LIMIT 20
    ) AS temp
) AS sub ON A.idVoluntarios = sub.idVoluntarios
SET A.Puesto = 'Acompañante';

/*81. Asignar en la tabla voluntarios la columna puesto el valor “Logística” a: 30
personas que hayan elegido Tareas Logistica con preferencia 1 ó 2 ó 3 ó 4*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT idVoluntarios
    FROM (
        SELECT A.idVoluntarios
        FROM voluntariado.Voluntarios A
        JOIN voluntariado.preferencias B ON A.idVoluntarios = B.idVoluntario
        JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
        WHERE C.nombre = 'Logistica'
          AND (B.Preferencia = 1 OR B.Preferencia = 2 OR B.Preferencia = 3 OR B.Preferencia = 4)
        LIMIT 30
    ) AS temp
) AS sub ON A.idVoluntarios = sub.idVoluntarios
SET A.Puesto = 'Logística';

/*82. Asignar en la tabla voluntarios old la labor de Promoción a: 30 personas
que hayan elegido Tareas Promocion con preferencia 1 ó 2 ó 3 ó 4*/

UPDATE voluntariado.Voluntarios_OLD A
JOIN (
    SELECT idVoluntario
    FROM (
        SELECT A.idVoluntario
        FROM voluntariado.Voluntarios_OLD A
        JOIN voluntariado.preferencias B ON A.idVoluntario = B.idVoluntario
        JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
        WHERE C.nombre = 'Promocion'
          AND (B.Preferencia = 1 OR B.Preferencia = 2 OR B.Preferencia = 3 OR B.Preferencia = 4)
        LIMIT 30
    ) AS temp
) AS sub ON A.idVoluntario = sub.idVoluntario
SET A.Puesto = 'Promoción';

/*83. Asignar en la tabla voluntarios la columna puesto el valor “Apoyo” a: 60
personas que practiquen esquí.*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT P.idvoluntarios
    FROM voluntariado.practicar P
    JOIN voluntariado.deportes D ON P.iddeportes = D.iddeporte
    WHERE D.deporte = 'Esquí'
    LIMIT 60
) AS sub ON A.idVoluntarios = sub.idvoluntarios
SET A.Puesto = 'Apoyo';

/*84. Asignar en la tabla voluntarios la columna puesto el valor “Accesos” a: 30
personas mas altas.*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT idVoluntarios
    FROM voluntariado.Voluntarios
    ORDER BY altura DESC
    LIMIT 30
) AS sub ON A.idVoluntarios = sub.idVoluntarios
SET A.Puesto = 'Accesos';

/*85. Asignar en la tabla voluntarios la columna puesto el valor “Voluntarios” a:
30 personas de menor peso.*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT idVoluntarios
    FROM voluntariado.Voluntarios
    ORDER BY peso ASC
    LIMIT 30
) AS sub ON A.idVoluntarios = sub.idVoluntarios
SET A.Puesto = 'Voluntarios';

/*86. Asignar en la tabla voluntarios la columna puesto el valor “Información” a:
30 personas.*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT idVoluntarios
    FROM voluntariado.Voluntarios
    LIMIT 30
) AS sub ON A.idVoluntarios = sub.idVoluntarios
SET A.Puesto = 'Información';

/*87. Asignar en la tabla voluntarios la columna puesto el valor “Palacio de
congresos” a personas con las siguientes tareas:
a. 10 personas Traducción o Interprete,*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre IN ('Traducción', 'Intérprete')
    LIMIT 10
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Palacio de congresos';

/*b. 4 sanitarios,*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Sanitaria'
    LIMIT 4
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Palacio de congresos';

/*c. 10 administrativos,*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Administrativas'
    LIMIT 10
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Palacio de congresos';

/*d. 5 información,*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Información'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Palacio de congresos';

/*e. 5 informaticos,*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Informática'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Palacio de congresos';

/*f. 10 protocolo*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Protocolo'
    LIMIT 10
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Palacio de congresos';

/*g. 5 logistica*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Logístico'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Palacio de congresos';

/*88. Asigna en la tabla voluntarios la columna puesto el valor “Pista de Hielo”
a personas con las siguientes tareas:
a. 8 personas de Accesos,*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Accesos'
    LIMIT 8
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Pista de Hielo';

/*b. 8 personas de logística,*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Logístico'
    LIMIT 8
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Pista de Hielo';

/*c. 6 sanitarios,*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = ‘Sanitaria’
    LIMIT 6
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Pista de Hielo';

/*d. 5 información,*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = ‘Información’
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Pista de Hielo';

/*e. 5 informaticos*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = ‘Informática’
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Pista de Hielo';

/*89. Asigna en la tabla voluntarios la columna puesto el valor “Centro de
Transporte” a personas con las siguientes tareas:
a. 70 personas de conducción,*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Conducción'
    LIMIT 70
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Centro de Transporte';

/*b. 5 administrativos*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Administrativas'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Centro de Transporte';

/*c. 5 informaticos*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = Informática'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Centro de Transporte';

/*d. 5 logistica*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Logístico'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Centro de Transporte';

/*e. 5 informacion*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = ‘Información'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Centro de Transporte';

/*90. asigna en la tabla voluntarios la columna puesto el valor “Nave de
Logistica” a personas con las siguientes tareas:
a. 2 personas de Accesos*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Accesos'
    LIMIT 2
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Nave de Logística';

/*b. 30 promocion*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Promoción'
    LIMIT 30
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Nave de Logística';

/*c. 5 logistica*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Logístico'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Nave de Logística';

/*91. Asigna en la tabla voluntarios la columna puesto el valor “Escuela militar
de montaña” a personas con las siguientes tareas:
a. 5 Accesos*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Accesos'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Escuela militar de montaña';

/*b. 30 voluntarios*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Voluntarios'
    LIMIT 30
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Escuela militar de montaña';

/*92. Asigna en la tabla voluntarios la columna puesto el valor “delegaciones”
a personas con las siguientes tareas:
a. 43 personas de Traducción/Interprete*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre IN ('Traducción', 'Intérprete')
    LIMIT 43
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Delegaciones';

/*b. 10 protocolo*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Protocolo'
    LIMIT 10
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Delegaciones';

/*c. 20 acompañantes*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre IN ('Acompañantes')
    LIMIT 20
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Delegaciones';

/*d. 7 logistica*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre IN ('Logístico')
    LIMIT 7
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Delegaciones';

/*e. 5 comunicación*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Comunicación'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
SET A.Puesto = 'Delegaciones';

/*93. Asigna en la tabla voluntarios la localidad “Berja” a personas con las
siguientes tareas:
a. 12 personas Apoyo*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Apoyo'
    LIMIT 12
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Berja'
SET A.idlocalidad = L.idlocalidad;

/*b. 4 sanitarios*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Sanitaria'
    LIMIT 4
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Berja'
SET A.idlocalidad = L.idlocalidad;

/*c. 3 informacion*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Información'
    LIMIT 3
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Berja'
SET A.idlocalidad = L.idlocalidad;

/*d. 5 comunicacion*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Comunicación'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Berja'
SET A.idlocalidad = L.idlocalidad;

/*e. 3 accesos*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Accesos'
    LIMIT 3
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Berja'
SET A.idlocalidad = L.idlocalidad;

/*94. Asigna en la tabla voluntarios la localidad “Jaca” a personas con las
siguientes tareas:
a. 12 personas Apoyo*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Apoyo'
    LIMIT 12
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Jaca'
SET A.idlocalidad = L.idlocalidad;

/*b. 4 sanitarios*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Sanitaria'
    LIMIT 4
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Jaca'
SET A.idlocalidad = L.idlocalidad;

/*c. 3 informacion*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Información'
    LIMIT 3
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Jaca'
SET A.idlocalidad = L.idlocalidad;

/*d. 5 comunicacion*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Comunicación'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Jaca'
SET A.idlocalidad = L.idlocalidad;

/*e. 3 accesos*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Accesos'
    LIMIT 3
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Jaca'
SET A.idlocalidad = L.idlocalidad;

/*95. Asigna en la tabla voluntarios la localidad “Formentera” a personas con
las siguientes tareas:
a. 12 personas Apoyo*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Apoyo'
    LIMIT 12
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Formentera'
SET A.idlocalidad = L.idlocalidad;

/*b. 4 sanitarios*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Sanitaria'
    LIMIT 4
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Formentera'
SET A.idlocalidad = L.idlocalidad;

/*c. 3 informacion*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Información'
    LIMIT 3
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Formentera'
SET A.idlocalidad = L.idlocalidad;

/*d. 5 comunicacion*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Comunicación'
    LIMIT 5
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Formentera'
SET A.idlocalidad = L.idlocalidad;

/*e. 3 accesos*/

UPDATE voluntariado.Voluntarios A
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Accesos'
    LIMIT 3
) AS sub ON A.idVoluntarios = sub.idVoluntario
JOIN voluntariado.localidades L ON L.localidad = 'Formentera'
SET A.idlocalidad = L.idlocalidad;

/*96. Asigna la tarea de Panticosa a personas con las siguientes tareas:
a. 12 personas Apoyo*/

UPDATE voluntariado.preferencias B
JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
JOIN voluntariado.tareas T ON T.nombre = 'Panticosa'
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Apoyo'
    LIMIT 12
) AS sub ON B.idVoluntario = sub.idVoluntario
SET B.idTarea = T.IdTarea;

/*b. 4 sanitarios*/

UPDATE voluntariado.preferencias B
JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
JOIN voluntariado.tareas T ON T.nombre = 'Panticosa'
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Sanitaria'
    LIMIT 4
) AS sub ON B.idVoluntario = sub.idVoluntario
SET B.idTarea = T.IdTarea;

/*c. 3 informacion*/

UPDATE voluntariado.preferencias B
JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
JOIN voluntariado.tareas T ON T.nombre = 'Panticosa'
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Información'
    LIMIT 3
) AS sub ON B.idVoluntario = sub.idVoluntario
SET B.idTarea = T.IdTarea;

/*d. 5 comunicacion*/

UPDATE voluntariado.preferencias B
JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
JOIN voluntariado.tareas T ON T.nombre = 'Panticosa'
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Comunicación'
    LIMIT 5
) AS sub ON B.idVoluntario = sub.idVoluntario
SET B.idTarea = T.IdTarea;

/*e. 3 accesoS*/

UPDATE voluntariado.preferencias B
JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
JOIN voluntariado.tareas T ON T.nombre = 'Panticosa'
JOIN (
    SELECT B.idVoluntario
    FROM voluntariado.preferencias B
    JOIN voluntariado.tareas C ON B.idTarea = C.IdTarea
    WHERE C.nombre = 'Accesos'
    LIMIT 3
) AS sub ON B.idVoluntario = sub.idVoluntario
SET B.idTarea = T.IdTarea;