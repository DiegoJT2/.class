SELECT A.nombre, A.fecha_ingreso
FROM EMBARCACIONES.socio AS A
WHERE A.fecha_ingreso > "2000/01/01";
/*correccion*/
select *
from EMBARCACIONES.socio
where fecha_ingreso >= "2000-01-01"
order by fecha_ingreso;

SELECT A.nombre
FROM EMBARCACIONES.socio AS A
WHERE A.nombre LIKE "eric%" AND A.fecha_ingreso < "2000/01/01";

SELECT A.nombre, B.telefono
FROM EMBARCACIONES.socio AS A
JOIN EMBARCACIONES.telefonos_socio AS B ON A.nif = B.nif_socio
WHERE A.nombre LIKE "A%";

SELECT A.nombre, B.matricula, B.tipo
FROM EMBARCACIONES.socio AS A
INNER JOIN EMBARCACIONES.embarcacion AS B ON B.nif_dueño = A.nif
WHERE B.tipo != "";

SELECT dimensiones, numero, lect_cont_agua
FROM EMBARCACIONES.embarcacion AS A
JOIN EMBARCACIONES.muelle AS B ON A.nif_dueño = B.nif_propietario
WHERE A.dimensiones > 30 AND B.lect_cont_agua > 500;

SELECT especialidad, tipo
FROM EMBARCACIONES.empleado AS A
JOIN EMBARCACIONES.embarcacion AS B
JOIN EMBARCACIONES.se_encarga AS C ON cod_empleado = codigo
WHERE A.especialidad = "motor" AND B.tipo = "lancha";

SELECT numero, codigo
FROM EMBARCACIONES.muelle AS A
JOIN EMBARCACIONES.se_encarga AS C ON A.matr_embarcacion = C.matr_embarcacion
JOIN EMBARCACIONES.empleado AS B ON codigo = cod_empleado
WHERE mantenimiento = 0;

SELECT nombre, numero
FROM EMBARCACIONES.empleado AS A
JOIN EMBARCACIONES.atiende AS C ON codigo = cod_empleado
JOIN EMBARCACIONES.muelle AS B ON numero = num_muelle
WHERE lect_cont_agua OR lect_cont_luz < 100;

SELECT numero, nombre
FROM EMBARCACIONES.muelle AS A
JOIN EMBARCACIONES.se_encarga AS C ON A.matr_embarcacion = C.matr_embarcacion
JOIN EMBARCACIONES.empleado AS B ON codigo = cod_empleado
WHERE mantenimiento = 1 AND especialidad = "limpieza";