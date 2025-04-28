/*1 Mostrar todos los libros publicados después del año 2015.*/
SELECT * FROM Libro WHERE anio_publicacion > 2015;
/*2 Listar los nombres y países de todos los autores.*/
SELECT nombre, pais FROM Autor;
/*3 Mostrar el nombre y ciudad de todas las tiendas.*/
SELECT nombre, ciudad FROM Tienda;
/*4 Obtener los títulos de los libros junto con el nombre de su editorial.*/
SELECT A.titulo, B.nombre FROM Libro AS A
JOIN Editorial AS B on A.editorial_id = B.editorial_id;
/*5 Listar todos los clientes que hayan realizado alguna compra (usando JOIN).*/
SELECT DISTINCT A.nombre FROM Cliente AS A
JOIN Venta AS B ON A.cliente_id = B.cliente_id;
/*6 Mostrar cuántos libros hay por cada editorial.*/
SELECT B.nombre AS Editorial, COUNT(A.libro_id)AS NºLibros FROM Libros AS A
JOIN Editorial AS B ON A.editorial_id = B.editorial_id GROUP BY B.nombre ORDER BY NºLibros DESC;
/*7 Listar los libros con más de un autor.*/
SELECT A.nombre, COUNT(B.autor_id) FROM Libro AS A
JOIN LibroAutor AS B ON A.libro_id = B.libro_id GROUP BY A.titulo HAVING COUNT(B.autor_id>1);
/*8 Mostrar el total de ventas por cliente (nombre y total gastado), ordenado de mayor a
menor.*/
SELECT A.nombre, SUM(B.total)AS "Total Gastado" FROM Cliente AS A
JOIN Venta AS B ON A.cliente_id = B.cliente_id GROUP BY A.nombre ORDER BY "Total Gastado"DESC;
/*9 Obtener los libros que nunca han sido vendidos.*/
SELECT A.nombre FROM Libro AS A
LEFT JOIN Venta AS B ON A.libro_id = B.libro_id
WHERE B.libro_id IS NULL;
/*10 Mostrar, por cada tienda, el nombre del empleado más antiguo.*/
SELECT A.nombre AS Tienda, B.nombre AS "Nombre Empleado" FROM Tienda AS A
JOIN Empleado AS B ON A.tienda_id = B.tienda_id
WHERE B.fecha_contratacion =(SELECT MIN(fecha_contratacion)FROM Empleado
WHERE tienda_id = A.tienda_id);