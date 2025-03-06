/*1. Validar una contraseña que comience con 2 números y termine en una
vocal*/
SELECT * FROM usuarios 
WHERE contraseña REGEXP '^[0-9]{2}[a-zA-Z]*[aeiouAEIOU]$';

/*2. Encontrar palabras que contengan al menos una letra mayúscula y una
minúscula*/
SELECT * FROM tabla 
WHERE columna REGEXP '^(?=.*[a-z])(?=.*[A-Z]).+$';

/*3. Detectar números telefónicos con formato variable (+34 612345678, 612-
345-678, 612 345 678)*/
SELECT * FROM tabla 
WHERE telefono REGEXP '^\\+?[0-9]{1,3}?[ -]?[0-9]{3}[ -]?[0-9]{3}[ -]?[0-9]{3}$';

/*4. Validar una fecha en formato DD-MM-YYYY pero asegurando que el día sea
de 01 a 31 y el mes de 01 a 12*/
SELECT * FROM tabla 
WHERE fecha REGEXP '^([0-2][0-9]|3[01])-(0[1-9]|1[0-2])-[0-9]{4}$';

/*5. Buscar direcciones IPv4 pero evitando valores fuera del rango 0-255*/
SELECT * FROM tabla 
WHERE ip REGEXP '^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$';

/*6. Validar una matrícula de coche española (4 números + 3 letras
mayúsculas)*/
SELECT * FROM coches 
WHERE matricula REGEXP '^[0-9]{4} [A-Z]{3}$';

/*7. Buscar palabras que empiecen y terminen con la misma letra*/
SELECT * FROM tabla 
WHERE palabra REGEXP '^(.) .* \\1$';

/*8. Detectar palabras palíndromas (sin importar mayúsculas/minúsculas)

• Ejemplo válido: "Anilina"
• Ejemplo inválido: "Ejemplo"*/
SELECT * FROM tabla 
WHERE palabra REGEXP '^(.?)(.?)(.?)(.?)(.?)(.?)(.?)\7\6\5\4\3\2\1$';

/*9. Encontrar números que sean múltiplos de 3*/
SELECT * FROM tabla 
WHERE numero REGEXP '^(0|[369]|[0-9]*([0369]|[147][258]|[258][147])([0369]|[147][258]|[258][147])*)$';

/*10. Validar una clave de acceso que contenga exactamente 2 números y al
menos 1 letra mayúscula*/
SELECT * FROM tabla 
WHERE clave REGEXP '^(?=[^0-9]*[0-9][^0-9]*[0-9][^0-9]*$)(?=.*[A-Z]).*$';

/*11. Validar coordenadas geográficas en formato (+/-XX.XXXX, +/-YY.YYYY)*/
SELECT * FROM tabla 
WHERE coordenadas REGEXP '^[+-]?\d{1,3}\.\d{4},\s?[+-]?\d{1,3}\.\d{4}$';

/*12. Encontrar palabras que no contengan vocales consecutivas*/
SELECT * FROM tabla 
WHERE palabra REGEXP '^[^aeiou]*[aeiou][^aeiou]*$|^[^aeiou]*$';

/*13. Buscar números primos de hasta 3 dígitos*/
SELECT * FROM tabla 
WHERE numero REGEXP '^[1-9][0-9]{0,2}$';

/*14. Detectar hashtags válidos en Twitter (#palabra sin números ni caracteres
especiales)*/
SELECT * FROM tabla 
WHERE hashtag REGEXP '^#[A-Za-z]+$';

/*15. Validar una clave de acceso que contenga exactamente 3 letras y 3 números
en cualquier orden*/
SELECT * FROM tabla 
WHERE clave REGEXP '^(?=(.*[a-zA-Z]){3})(?=(.*[0-9]){3})[a-zA-Z0-9]{6}$';

/*16. Encontrar oraciones donde la primera y última palabra sean la misma*/
SELECT * FROM tabla 
WHERE oracion REGEXP '^([a-zA-Z0-9]+)(.*\s\1)$';

/*17. Detectar palabras donde cada letra esté repetida exactamente dos veces*/
SELECT * FROM tabla 
WHERE palabra REGEXP '^([a-zA-Z])\\1+$';

/*18. Validar expresiones matemáticas simples como X + Y = Z donde X, Y y Z
sean números enteros*/
SELECT * FROM tabla 
WHERE expresion REGEXP '^(-?[0-9]+)\\s\\+\\s(-?[0-9]+)\\s=\\s(-?[0-9]+)$';

/*19. Buscar direcciones de Bitcoin (Empiezan por 1 o 3 y tienen 26-35
caracteres alfanuméricos)*/
SELECT * FROM tabla 
WHERE direccion REGEXP '^[13][A-Za-z0-9]{25,34}$';

/*20. Extraer todas las palabras que contengan la misma vocal repetida al menos
3 veces*/
SELECT * FROM tabla 
WHERE palabra REGEXP '([aeiouAEIOU])\\1{2,}';