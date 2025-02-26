SELECT A.telefono, B.tipo, especialidad
FROM EMBARCACIONES.telefonos_socio AS A
JOIN EMBARCACIONES.embarcacion AS B ON nif_dueño = nif_socio
JOIN EMBARCACIONES.empleado AS C
JOIN EMBARCACIONES.se_encarga AS D ON cod_empleado = codigo
WHERE B.tipo = "pesquero" AND C.especialidad != "motor";

SELECT MIN(A.telefono) AS telefono, B.tipo, C.especialidad
FROM EMBARCACIONES.telefonos_socio AS A
JOIN EMBARCACIONES.embarcacion AS B ON nif_dueño = nif_socio
JOIN EMBARCACIONES.empleado AS C
JOIN EMBARCACIONES.se_encarga AS D ON cod_empleado = codigo
WHERE B.tipo = "pesquero" AND C.especialidad != "motor"
GROUP BY B.tipo, C.especialidad;

SELECT especialidad, COUNT(especialidad) AS numeroEmpleados
FROM EMBARCACIONES.Empleado
GROUP BY especialidad;

SELECT nombre, COUNT(nif_socio) AS numero_telefonos
FROM EMBARCACIONES.telefonos_socio AS A
JOIN EMBARCACIONES.Socio AS B ON A.nif_socio = B.nif
WHERE nombre LIKE 'A%'
GROUP BY nombre;

SELECT B.nombre, COUNT(nif_dueño) AS NºBarcos
FROM EMBARCACIONES.embarcacion AS A
JOIN EMBARCACIONES.Socio AS B ON A.nif_dueño = B.nif
GROUP BY B.nombre;

SELECT A.nombre AS PropietarioEmbarcacion, D.nombre AS PropietarioMuelle
FROM EMBARCACIONES.socio AS A
JOIN EMBARCACIONES.embarcacion AS B ON A.nif = B.nif_dueño
JOIN EMBARCACIONES.muelle AS C ON B.matricula = C.matr_embarcacion
JOIN EMBARCACIONES.socio AS D ON C.nif_propietario = A.nif
WHERE A.nif != D.nif;

SELECT A.nombre AS NombreSocio, COUNT(C.nif_dueño) AS NºEmbarcaciones
FROM EMBARCACIONES.socio AS A
JOIN EMBARCACIONES.muelle AS B ON A.nif = B.nif_propietario
JOIN EMBARCACIONES.embarcacion AS C ON C.matricula = B.matr_embarcacion
WHERE A.nif != C.nif_dueño
GROUP BY A.nif;

SELECT C.nombre AS Embarcacion,  C.matricula
FROM EMBARCACIONES.embarcacion AS C
JOIN EMBARCACIONES.se_encarga AS A ON A.matr_embarcacion = C.matricula
JOIN EMBARCACIONES.empleado AS B ON A.cod_empleado = B.codigo
GROUP BY C.nombre, C.matricula
HAVING COUNT(A.cod_empleado) >= 2;

/*Consulta 19*/
SELECT YEAR(fecha_ingreso) AS año, count(*) AS sociosTotal
FROM EMBARCACIONES.socio
GROUP BY YEAR(fecha_ingreso)
HAVING sociosTotal > 2
ORDER BY sociosTotal DESC;

SELECT A.codigo, A.nombre, 
       (COUNT(DISTINCT B.numero) + COUNT(DISTINCT D.matricula)) AS total_trabajos
FROM EMBARCACIONES.empleado AS A
LEFT JOIN EMBARCACIONES.muelle B ON A.codigo = B.cod_empleado
LEFT JOIN EMBARCACIONES.se_encarga AS C ON A.codigo = C.cod_empleado
LEFT JOIN EMBARCACIONES.embarcacion AS D ON C.matr_embarcacion = D.matricula
GROUP BY A.codigo, A.nombre
HAVING total_trabajos > 2
ORDER BY total_trabajos DESC;

/*Consulta 22*/
SELECT nombre FROM EMBARCACIONES.embarcacion WHERE EXISTS
(SELECT * FROM EMBARCACIONES.socio AS socio WHERE socio.fecha_ingreso < "2000/01/01" AND fecha_ingreso > "1989/12/12");

SELECT * FROM EMBARCACIONES.socio AS A WHERE EXISTS
(SELECT * FROM EMBARCACIONES.embarcacion AS B WHERE B.tipo = "yate");

SELECT DISTINCT nombre, numero FROM EMBARCACIONES.muelle AS A
JOIN EMBARCACIONES.atiende AS B ON A.numero = B.num_muelle
JOIN EMBARCACIONES.empleado AS C ON B.cod_empleado = C.codigo
WHERE EXISTS
(SELECT 1 FROM EMBARCACIONES.embarcacion AS D WHERE D.dimensiones IS NOT NULL AND A.nif_propietario = D.nif_dueño);

SELECT count(A.dimensiones) AS numero FROM EMBARCACIONES.embarcacion AS A WHERE dimensiones IS NOT NULL AND EXISTS
(SELECT * FROM EMBARCACIONES.empleado AS B
JOIN EMBARCACIONES.se_encarga AS C ON B.codigo = C.cod_empleado
WHERE A.matricula = C.matr_embarcacion);

SELECT A.cod_empleado
FROM EMBARCACIONES.se_encarga AS A
WHERE A.matr_embarcacion = ALL (
    SELECT B.matricula
    FROM EMBARCACIONES.embarcacion AS B
    WHERE B.nif_dueño = (
        SELECT B1.nif_dueño
        FROM EMBARCACIONES.embarcacion AS B1
        WHERE B1.matricula = A.matr_embarcacion
    )
)
AND NOT EXISTS (
    -- Verificar que el empleado no gestione barcos de otros dueños
    SELECT 1
    FROM EMBARCACIONES.embarcacion AS B2
    WHERE B2.matricula IN (
        SELECT A2.matr_embarcacion
        FROM EMBARCACIONES.se_encarga AS A2
        WHERE A2.cod_empleado = A.cod_empleado
    )
    AND B2.nif_dueño <> (
        SELECT B3.nif_dueño
        FROM EMBARCACIONES.embarcacion AS B3
        WHERE B3.matricula = A.matr_embarcacion
    )
);

SELECT A.nombre FROM EMBARCACIONES.socio AS A WHERE 50 < ANY
(SELECT B.dimensiones FROM EMBARCACIONES.embarcacion AS B WHERE A.nif = B.nif_dueño);

SELECT A.nombre FROM EMBARCACIONES.socio AS A
JOIN EMBARCACIONES.telefonos_socio AS B ON A.nif = B.nif_socio
GROUP BY A.nif, A.nombre
HAVING count(DISTINCT RIGHT(B.telefono, 1))=1
AND COUNT(B.telefono)>1;

SELECT B.nif_socio, B.telefono
FROM EMBARCACIONES.telefonos_socio AS B
WHERE B.nif_socio IN (
    SELECT A.nif
    FROM EMBARCACIONES.socio AS A
    JOIN EMBARCACIONES.telefonos_socio AS B1 ON A.nif = B1.nif_socio
    GROUP BY A.nif
    HAVING COUNT(DISTINCT RIGHT(B1.telefono, 1)) = 1
           AND COUNT(B1.telefono) > 1
);

SELECT A.nombre, B.telefono
FROM EMBARCACIONES.socio AS A
JOIN EMBARCACIONES.telefonos_socio AS B ON A.nif = B.nif_socio
WHERE A.nif IN (
    SELECT A.nif
    FROM EMBARCACIONES.socio AS A
    JOIN EMBARCACIONES.telefonos_socio AS B ON A.nif = B.nif_socio
    GROUP BY A.nif
    HAVING COUNT(DISTINCT RIGHT(B.telefono, 1)) = 1
    AND COUNT(B.telefono) > 1
);

SELECT nombre FROM EMBARCACIONES.socio AS A WHERE A.nif = ALL(
SELECT nif FROM EMBARCACIONES.embarcacion AS B WHERE A.nif = B.nif_dueño AND B.tipo="yate");