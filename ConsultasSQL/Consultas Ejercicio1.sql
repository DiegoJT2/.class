SELECT Socio.Nombre AS Nombre, Socio.Apellidos AS Apellidos, Sede.NombreSede AS Sede
FROM Ejercicio1.Socio, Ejercicio1.Sede
WHERE Socio.idSede_FK = Sede.idSede;

SELECT Envio.codigoEnvio AS CodigoEnvio, Sede.domicilio AS CiudadSede, Envio.fechaSalida AS FechaSalida
FROM Ejercicio1.Envio, Ejercicio1.Sede, Ejercicio1.SedeEnvio
WHERE Envio.codigoEnvio = SedeEnvio.idEnvio_FK AND Sede.idSede = SedeEnvio.idSede_FK;

SELECT v.Nombre, v.Apellidos, s.Profesion, s.Disponibilidad
FROM Ejercicio1.Voluntario v, Ejercicio1.Sanitario s
WHERE v.idVoluntario = s.idVoluntario_FK AND s.Disponibilidad = 1;