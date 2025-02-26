SELECT a.nombre AS nombre_albanil, a.apellidos AS apellidos_albanil, a.fechaNacimiento AS fecha_nacimiento,
    c.nombre AS nombre_cuadrilla
FROM Albanil a
JOIN Interna i ON a.dniAlbanil = i.dniAlbanil_FK

JOIN Cuadrilla c ON i.idCuadrilla_FK = c.idCuadrilla
WHERE a.fechaNacimiento < '1995-02-02';

SELECT DISTINCT c.nombre AS Nombre_Cuadrilla, r.dniCliente AS DNI_Cliente, r.nombre AS Nombre_Cliente
FROM Reforma r, Cuadrilla c, Interna i, Externa e, Participa p
WHERE r.idReforma = 1 AND ((r.idCuadrillaInterna_FK = i.codigoInterno AND i.idCuadrilla_FK = c.idCuadrilla
AND (p.idCuadrillaExterna_FK = e.cifCuadrillaExterna AND p.idReforma_FK = r.idReforma))
OR
(e.idCuadrilla_FK = c.idCuadrilla AND p.idCuadrillaExterna_FK = e.cifCuadrillaExterna
AND p.idReforma_FK = r.idReforma) AND r.idCuadrillaInterna_FK = i.codigoInterno);

SELECT DISTINCT Cuadrilla.nombre AS Nombre_Cuadrilla
FROM Externa
LEFT JOIN Participa ON Externa.cifCuadrillaExterna = Participa.idCuadrillaExterna_FK
JOIN Cuadrilla ON Externa.idCuadrilla_FK = Cuadrilla.idCuadrilla
WHERE Participa.idReforma_FK is null;