/*1. Usando IF:
Crea una consulta que muestre el nombre del estudiante y unacolumna llamada aprobado que diga "Sí" si la
calificación es mayor o igual a 70, y "No" si es menor.*/
SELECT nombre, if(calificacion>=70, 'SI', 'NO') AS APROBADO FROM estudiantes;

/*2. Usando CASE:
Crea una consulta que muestre el nombre del estudiante y una columna llamada nivel que clasifique la calificación en:
§ "Excelente" si es mayor o igual a 90.
§ "Bueno" si es mayor o igual a 80 y menor que 90.
§ "Regular" si es mayor o igual a 70 y menor que 80.
§ "Necesita mejorar" si es menor que 70.*/
SELECT nombre, CASE
        WHEN calificacion >= 90 THEN 'Excelente'
        WHEN calificacion >= 80 AND calificacion < 90 THEN 'Bueno'
        WHEN calificacion >= 70 AND calificacion < 80 THEN 'Regular'
        ELSE 'Necesita mejorar'
    END AS nivel
FROM estudiantes;

/*3. Usando IF y CASE:
Crea una consulta que muestre el nombre del estudiante, su edad y una columna llamada mayor_de_edad que
diga "Mayor" si el estudiante tiene 18 años o más, y "Menor" si tiene menos de 18.
Además, agrega una columna llamada rango_calificacion que clasifique la calificación en "Alta" si es mayor
o igual a 85, y "Baja" si es menor.*/
SELECT nombre, edad, IF(edad >= 18, 'Mayor', 'Menor') AS mayor_de_edad, CASE
        WHEN calificacion >= 85 THEN 'Alta'
        ELSE 'Baja'
    END AS rango_calificacion
FROM estudiantes;

/*4. Usando CASE con múltiples condiciones:
Crea una consulta que muestre el nombre del estudiante y una columna llamada grupo que clasifique a los estudiantes en:
§ "Grupo A" si tienen 18 años y una calificación mayor o igual a 80.
§ "Grupo B" si tienen 17 años y una calificación mayor o igual a 85.
§ "Grupo C" para todos los demás casos.*/
SELECT nombre, CASE
        WHEN edad = 18 AND calificacion >= 80 THEN 'Grupo A'
        WHEN edad = 17 AND calificacion >= 85 THEN 'Grupo B'
        ELSE 'Grupo C'
    END AS grupo
FROM estudiantes;
