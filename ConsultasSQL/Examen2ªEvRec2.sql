/*1 Insertar un nuevo autor.*/
INSERT INTO Autor(nombre, pais)VALUES ('Diego', 'España');
/*2 Insertar una nueva tienda en la ciudad de Valencia.*/
INSERT INTO Tienda(nombre, ciudad) VALUES('Tréndico', 'Valencia');
/*3 Actualizar el precio de un libro aumentando un 10%.*/
UPDATE Libro SET precio = precio * 0.10;
/*4 Insertar una nueva venta con dos libros distintos.*/
INSERT INTO Venta(venta_id, cliente_id, fecha, total, tienda_id)VALUES(25, 35, 2025-04-29, 15+20, 10);
INSERT INTO DetalleVenta(venta_id,  libro_id, cantidad, precio_unitario) VALUES(25, 12, 1, 20);
INSERT INTO DetalleVenta(venta_id,  libro_id, cantidad, precio_unitario) VALUES(25, 13, 1, 15);
/*5 Cambiar la editorial de todos los libros de una editorial antigua a una nueva.*/
UPDATE Libro SET editorial_id = 25
WHERE editorial_id = 2;
/*6 Eliminar a un cliente que no ha hecho ninguna compra.*/
DELETE A FROM Cliente AS A WHERE cliente_id NOT IN (SELECT cliente_id FROM venta);
/*7 Insertar un nuevo libro con dos autores (requiere insertar en Libro y LibroAutor).*/
INSERT INTO Libro (libro_id, titulo, anio_publicacion, precio, editorial_id) VALUES(3, 'Guiñote', 2025, 8, 5);
INSERT INTO LibroAutor (libro_id, autor_id) VALUES(3, 4);
INSERT INTO LibroAutor (libro_id, autor_id) VALUES(3, 5);
/*8 Actualizar los precios de todos los libros publicados antes de 2000, descontando un
15%.*/
UPDATE Libro SET precio = precio-(precio*0.15)WHERE anio_publicacion < 2000;
/*9 Eliminar todos los libros que nunca se han vendido.*/
DELETE A FROM Libro AS A WHERE libro_id NOT IN (SELECT libro_id FROM DetalleVenta);
/*10 Eliminar una editorial sólo si no tiene libros asociados.*/
DELETE A FROM Editorial AS A WHERE editorial_id NOT IN (SELECT editorial_id FROM Libro);