/*60. Mostrar voluntarios de la provincia de Madrid cuya edad supere la media de
edades de los voluntarios de Zaragoza.*/
SELECT * FROM voluntarios_OLD WHERE provincia = 'Madrid'AND Edad > (SELECT AVG(Edad) FROM Voluntarios_OLD
WHERE Provincia = 'Zaragoza');
/*61. Mostrar voluntarios y edad que superen a todas las edades de los voluntarios
de la provincia de Madrid.*/
SELECT idVoluntario, edad FROM voluntarios_old
WHERE Edad > ALL (SELECT Edad FROM voluntarios_old WHERE provincia = 'Madrid');

/*62. Mostrar voluntarios y altura, que superen el peso más alto de los voluntarios de
Barcelona.*/
SELECT Nombre, altura FROM voluntarios_old
WHERE Altura > (SELECT MAX(peso) FROM voluntarios_old WHERE provincia = 'Barcelona');

/*63. Mostrar voluntarios y altura cuyo altura sea inferior a cualquier altura de los
voluntarios de Burgos.*/
SELECT Nombre, altura FROM voluntarios_old
WHERE altura < ANY (SELECT altura FROM voluntarios_old WHERE provincia = 'Burgos');

/*64. Mostrar nombre de voluntarios y altura cuya altura coincida con alturas de
voluntarios de Valencia.*/
SELECT nombre, altura FROM voluntarios_old
WHERE altura IN (SELECT altura FROM voluntarios_old WHERE provincia = 'Valencia');