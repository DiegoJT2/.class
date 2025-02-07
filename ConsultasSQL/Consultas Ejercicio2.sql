SELECT DISTINCT c.numeroConvocatoria, c.programa, o.nombre AS organismo, c.fechaLimite
FROM Ejercicio2.convocatoriaAyuda c
JOIN Ejercicio2.organismo o ON c.idOrganismo_FK = o.idOrganismo;

SELECT DISTINCT c.numeroConvocatoria, o.poblacion, c.fechaLimite
FROM Ejercicio2.convocatoriaAyuda c
JOIN Ejercicio2.organismo o ON c.idOrganismo_FK = o.idOrganismo;

SELECT s.tituloProyecto, i.nombre AS "Nombre Investigador", s.importeSolicitado, c.programa, c.fechaLimite,
o.nombre AS "Nombre Organismo", o.poblacion AS "Poblacion Organismo"
FROM Ejercicio2.solicitud s, Ejercicio2.convocatoriaAyuda c, Ejercicio2.Organismo o, Ejercicio2.Investigador i
WHERE c.idConvocatoriaAyuda = s.idConvocatoria_FK AND c.idOrganismo_FK = o.idOrganismo
AND s.idInvestigador_FK = i.idInvestigador;