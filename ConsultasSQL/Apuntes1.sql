CREATE DATABASE IF NOT EXISTS Base_Pruebas;
DROP DATABASE IF EXISTS Base_Pruebas;
CREATE USER 'Usuario Prueba'
IDENTIFIED BY '1234';
DROP USER 'Usuario Prueba';
/*Conceder todos privilegios*/
GRANT all privileges
ON *.*
TO 'Usuario Prueba';
/*Ver privilegios*/
SHOW grants
For 'Usuario Prueba';
SELECT User, Host FROM mysql.user;

CREATE USER 'Admin' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES
ON *.*
TO 'Admin' WITH GRANT OPTION;

CREATE USER 'Usuario_Lectura' IDENTIFIED BY '1234';
GRANT SELECT
ON *.*
TO 'Usuario_Lectura';

DELETE FROM estudiantes AS A WHERE A.edad < 30;