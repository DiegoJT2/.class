SELECT * FROM PrimeraConsultaExamen.Pasa;
SELECT nombre FROM Bus;
SELECT * FROM Trabajador WHERE nombre = 'Pablo';
SELECT c.nombre FROM PrimeraConsultaExamen.Calle c JOIN PrimeraConsultaExamen.Pasa p ON c.idCalle = p.idCalle_FK WHERE p.idRuta_FK = 1;