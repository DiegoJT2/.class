CREATE DATABASE  IF NOT EXISTS `appbases` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `appbases`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: appbases
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Abastecer`
--

DROP TABLE IF EXISTS `Abastecer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Abastecer` (
  `idAbastecer` int NOT NULL AUTO_INCREMENT,
  `idDepartamento_FK2` int NOT NULL,
  `cif_proveedor_FK` varchar(45) NOT NULL,
  PRIMARY KEY (`idAbastecer`),
  KEY `idDepartamento_FK2` (`idDepartamento_FK2`),
  KEY `cif_proveedor_FK_idx` (`cif_proveedor_FK`),
  CONSTRAINT `cif_proveedor_FK` FOREIGN KEY (`cif_proveedor_FK`) REFERENCES `Proveedor` (`CIF`),
  CONSTRAINT `idDepartamento_FK2` FOREIGN KEY (`idDepartamento_FK2`) REFERENCES `Departamento` (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Abastecer`
--

LOCK TABLES `Abastecer` WRITE;
/*!40000 ALTER TABLE `Abastecer` DISABLE KEYS */;
INSERT INTO `Abastecer` VALUES (1,1,'1'),(2,2,'2'),(8,2,'N0183661I'),(9,1,'N0183661I');
/*!40000 ALTER TABLE `Abastecer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Bolsa_Dinero`
--

DROP TABLE IF EXISTS `Bolsa_Dinero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Bolsa_Dinero` (
  `idBolsa_Dinero` int NOT NULL AUTO_INCREMENT,
  `idDepartamento_FK1` int NOT NULL,
  PRIMARY KEY (`idBolsa_Dinero`),
  KEY `idDepartamento_FK1_idx` (`idDepartamento_FK1`),
  CONSTRAINT `idDepartamento_FK1` FOREIGN KEY (`idDepartamento_FK1`) REFERENCES `Departamento` (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bolsa_Dinero`
--

LOCK TABLES `Bolsa_Dinero` WRITE;
/*!40000 ALTER TABLE `Bolsa_Dinero` DISABLE KEYS */;
INSERT INTO `Bolsa_Dinero` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `Bolsa_Dinero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ComentarioOrden`
--

DROP TABLE IF EXISTS `ComentarioOrden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ComentarioOrden` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_compra` varchar(50) NOT NULL,
  `texto` text NOT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `numero_compra_idx` (`numero_compra`),
  CONSTRAINT `numero_compra` FOREIGN KEY (`numero_compra`) REFERENCES `Orden_Compra` (`numero_compra`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ComentarioOrden`
--

LOCK TABLES `ComentarioOrden` WRITE;
/*!40000 ALTER TABLE `ComentarioOrden` DISABLE KEYS */;
INSERT INTO `ComentarioOrden` VALUES (4,'OC0001','Bombillas LED','2025-05-31 20:07:27'),(5,'OC0004','Mesas BT4','2025-05-31 20:07:49');
/*!40000 ALTER TABLE `ComentarioOrden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Departamento`
--

DROP TABLE IF EXISTS `Departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Departamento` (
  `idDepartamento` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Departamento`
--

LOCK TABLES `Departamento` WRITE;
/*!40000 ALTER TABLE `Departamento` DISABLE KEYS */;
INSERT INTO `Departamento` VALUES (1,'Recursos Humanos'),(2,'Finanzas'),(3,'Logística');
/*!40000 ALTER TABLE `Departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Elemento_Compra`
--

DROP TABLE IF EXISTS `Elemento_Compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Elemento_Compra` (
  `idElemento_Compra` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `fungible` tinyint NOT NULL,
  PRIMARY KEY (`idElemento_Compra`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Elemento_Compra`
--

LOCK TABLES `Elemento_Compra` WRITE;
/*!40000 ALTER TABLE `Elemento_Compra` DISABLE KEYS */;
INSERT INTO `Elemento_Compra` VALUES (1,'Papel',1),(2,'Laptop',0),(6,'Tele DHC',0),(7,'Silvia ',1),(8,'tele1',0),(9,'movil',0),(13,'cosa',0),(27,'XBOX',0),(28,'PS5',0);
/*!40000 ALTER TABLE `Elemento_Compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Factura`
--

DROP TABLE IF EXISTS `Factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Factura` (
  `idFactura` int NOT NULL AUTO_INCREMENT,
  `comentario` varchar(200) NOT NULL,
  `pdf` varchar(1000) DEFAULT NULL,
  `fch_pedido` date NOT NULL,
  `cif_proveedor_FK2` varchar(45) NOT NULL,
  `numero_compra_FK2` varchar(14) NOT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `cif_proveedor_FK2_idx` (`cif_proveedor_FK2`),
  KEY `numero_compra_FK2_idx` (`numero_compra_FK2`),
  CONSTRAINT `cif_proveedor_FK2` FOREIGN KEY (`cif_proveedor_FK2`) REFERENCES `Proveedor` (`CIF`),
  CONSTRAINT `numero_compra_FK2` FOREIGN KEY (`numero_compra_FK2`) REFERENCES `Orden_Compra` (`numero_compra`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Factura`
--

LOCK TABLES `Factura` WRITE;
/*!40000 ALTER TABLE `Factura` DISABLE KEYS */;
INSERT INTO `Factura` VALUES (1,'Factura por materiales','factura1.pdf','2025-03-22','1','OC0001'),(2,'Factura por equipos','factura2.pdf','2025-03-23','2','OC0002'),(3,'Factura por televisiones','factura3.pdf','2023-07-28','2','OC0003'),(4,'Factura por mesas','factura4.pdf','2025-12-02','1','OC0004'),(12,'Compra XBOX',NULL,'2025-05-28','N0183661I','OC6721'),(13,'Compra PS5','/pdfs/777bd61d-dbaa-4582-9226-10e96e7a559d_download.png','2025-05-23','N0183661I','OC5621');
/*!40000 ALTER TABLE `Factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Inversion`
--

DROP TABLE IF EXISTS `Inversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Inversion` (
  `numero_inversion` int NOT NULL AUTO_INCREMENT,
  `idBolsa_Dinero_FK` int NOT NULL,
  `dineroINV` double NOT NULL,
  `fch` int NOT NULL,
  PRIMARY KEY (`numero_inversion`),
  KEY `idBolsa_Dinero_FK_idx` (`idBolsa_Dinero_FK`),
  CONSTRAINT `idBolsa_Dinero_FK` FOREIGN KEY (`idBolsa_Dinero_FK`) REFERENCES `Bolsa_Dinero` (`idBolsa_Dinero`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Inversion`
--

LOCK TABLES `Inversion` WRITE;
/*!40000 ALTER TABLE `Inversion` DISABLE KEYS */;
INSERT INTO `Inversion` VALUES (1,1,3000,2025),(2,2,5000,2025);
/*!40000 ALTER TABLE `Inversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orden_Compra`
--

DROP TABLE IF EXISTS `Orden_Compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Orden_Compra` (
  `numero_compra` varchar(14) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `fch` date NOT NULL,
  `cif_proveedor_FK1` varchar(45) NOT NULL,
  `idDepartamento_FK3` int NOT NULL,
  `importe_Total` double NOT NULL,
  PRIMARY KEY (`numero_compra`),
  KEY `idDepartamento_FK3_idx` (`idDepartamento_FK3`),
  KEY `cif_proveedor_FK1_idx` (`cif_proveedor_FK1`),
  CONSTRAINT `cif_proveedor_FK1` FOREIGN KEY (`cif_proveedor_FK1`) REFERENCES `Proveedor` (`CIF`),
  CONSTRAINT `idDepartamento_FK3` FOREIGN KEY (`idDepartamento_FK3`) REFERENCES `Departamento` (`idDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orden_Compra`
--

LOCK TABLES `Orden_Compra` WRITE;
/*!40000 ALTER TABLE `Orden_Compra` DISABLE KEYS */;
INSERT INTO `Orden_Compra` VALUES ('OC0001','Compra de materiales de oficina','2025-03-20','1',1,0),('OC0002','Compra de equipos informáticos','2025-03-21','2',2,0),('OC0003','Compra televisiones','2024-03-15','1',2,0),('OC0004','Compra mesas','2025-12-07','2',1,0),('OC5621','Compra PS5','2025-05-23','N0183661I',2,500),('OC6721','Compra XBOX','2025-05-28','N0183661I',2,200);
/*!40000 ALTER TABLE `Orden_Compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pertenecer`
--

DROP TABLE IF EXISTS `Pertenecer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pertenecer` (
  `idPertenecer` int NOT NULL AUTO_INCREMENT,
  `DNI_Usuario_FK` int NOT NULL,
  `idDepartamento_FK` int NOT NULL,
  PRIMARY KEY (`idPertenecer`),
  KEY `DNI_Usuario_FK_idx` (`DNI_Usuario_FK`),
  KEY `idDepartamento_FK_idx` (`idDepartamento_FK`),
  CONSTRAINT `DNI_Usuario_FK` FOREIGN KEY (`DNI_Usuario_FK`) REFERENCES `Usuario` (`DNI`),
  CONSTRAINT `idDepartamento_FK` FOREIGN KEY (`idDepartamento_FK`) REFERENCES `Departamento` (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pertenecer`
--

LOCK TABLES `Pertenecer` WRITE;
/*!40000 ALTER TABLE `Pertenecer` DISABLE KEYS */;
INSERT INTO `Pertenecer` VALUES (2,1002,2),(4,1001,1);
/*!40000 ALTER TABLE `Pertenecer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Por_Inversion`
--

DROP TABLE IF EXISTS `Por_Inversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Por_Inversion` (
  `idPor_Inversion` int NOT NULL AUTO_INCREMENT,
  `numero_compra_FK1` varchar(14) NOT NULL,
  `numero_inversion_FK` int NOT NULL,
  PRIMARY KEY (`idPor_Inversion`),
  KEY `numero_compra_FK1_idx` (`numero_compra_FK1`),
  KEY `numero_inversion_FK_idx` (`numero_inversion_FK`),
  CONSTRAINT `numero_compra_FK1` FOREIGN KEY (`numero_compra_FK1`) REFERENCES `Orden_Compra` (`numero_compra`),
  CONSTRAINT `numero_inversion_FK` FOREIGN KEY (`numero_inversion_FK`) REFERENCES `Inversion` (`numero_inversion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Por_Inversion`
--

LOCK TABLES `Por_Inversion` WRITE;
/*!40000 ALTER TABLE `Por_Inversion` DISABLE KEYS */;
INSERT INTO `Por_Inversion` VALUES (1,'OC0001',1),(3,'OC0003',2),(5,'OC6721',2);
/*!40000 ALTER TABLE `Por_Inversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Por_Presupuesto`
--

DROP TABLE IF EXISTS `Por_Presupuesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Por_Presupuesto` (
  `idPor_Presupuesto` int NOT NULL AUTO_INCREMENT,
  `numero_compra_FK` varchar(14) NOT NULL,
  `id_Presupuesto` int NOT NULL,
  PRIMARY KEY (`idPor_Presupuesto`),
  KEY `id_Presupuesto_FK_idx` (`id_Presupuesto`),
  KEY `numero_compra_FK_idx` (`numero_compra_FK`),
  CONSTRAINT `id_Presupuesto_FK` FOREIGN KEY (`id_Presupuesto`) REFERENCES `Presupuesto` (`idPresupuesto`),
  CONSTRAINT `numero_compra_FK` FOREIGN KEY (`numero_compra_FK`) REFERENCES `Orden_Compra` (`numero_compra`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Por_Presupuesto`
--

LOCK TABLES `Por_Presupuesto` WRITE;
/*!40000 ALTER TABLE `Por_Presupuesto` DISABLE KEYS */;
INSERT INTO `Por_Presupuesto` VALUES (2,'OC0002',2),(3,'OC0004',1),(8,'OC5621',2);
/*!40000 ALTER TABLE `Por_Presupuesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Presupuesto`
--

DROP TABLE IF EXISTS `Presupuesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Presupuesto` (
  `idPresupuesto` int NOT NULL AUTO_INCREMENT,
  `idBolsa_Dinero_FK1` int NOT NULL,
  `dineroPre` double NOT NULL,
  `fch` int NOT NULL,
  PRIMARY KEY (`idPresupuesto`),
  KEY `idBolsa_Dinero_FK1_idx` (`idBolsa_Dinero_FK1`),
  CONSTRAINT `idBolsa_Dinero_FK1` FOREIGN KEY (`idBolsa_Dinero_FK1`) REFERENCES `Bolsa_Dinero` (`idBolsa_Dinero`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Presupuesto`
--

LOCK TABLES `Presupuesto` WRITE;
/*!40000 ALTER TABLE `Presupuesto` DISABLE KEYS */;
INSERT INTO `Presupuesto` VALUES (1,1,10000,2025),(2,2,12000,2025);
/*!40000 ALTER TABLE `Presupuesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Proveedor`
--

DROP TABLE IF EXISTS `Proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Proveedor` (
  `CIF` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `contacto` varchar(45) NOT NULL,
  `tlf` int NOT NULL,
  PRIMARY KEY (`CIF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Proveedor`
--

LOCK TABLES `Proveedor` WRITE;
/*!40000 ALTER TABLE `Proveedor` DISABLE KEYS */;
INSERT INTO `Proveedor` VALUES ('1','Calle 123, Ciudad A','Proveedor A','Juan Pérez',123456789),('2','Avenida 456, Ciudad B','Proveedor B','Ana Gómez',987654321),('N0183661I','Calle Luis 14','Amazon','Fidel Garcia',657342511);
/*!40000 ALTER TABLE `Proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ser_Solicitado`
--

DROP TABLE IF EXISTS `Ser_Solicitado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ser_Solicitado` (
  `idSer_Solicitado` int NOT NULL AUTO_INCREMENT,
  `numero_compra_FK3` varchar(14) NOT NULL,
  `id_Elemento_Compra_FK` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`idSer_Solicitado`),
  KEY `numero_compra_FK3_idx` (`numero_compra_FK3`),
  KEY `id_Elemento_Compra_FK_idx` (`id_Elemento_Compra_FK`),
  CONSTRAINT `id_Elemento_Compra_FK` FOREIGN KEY (`id_Elemento_Compra_FK`) REFERENCES `Elemento_Compra` (`idElemento_Compra`),
  CONSTRAINT `numero_compra_FK3` FOREIGN KEY (`numero_compra_FK3`) REFERENCES `Orden_Compra` (`numero_compra`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ser_Solicitado`
--

LOCK TABLES `Ser_Solicitado` WRITE;
/*!40000 ALTER TABLE `Ser_Solicitado` DISABLE KEYS */;
INSERT INTO `Ser_Solicitado` VALUES (1,'OC0001',1,1),(2,'OC0002',2,3),(16,'OC6721',27,1),(17,'OC5621',28,1);
/*!40000 ALTER TABLE `Ser_Solicitado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuario` (
  `DNI` int NOT NULL,
  `rol` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `tlf` int NOT NULL,
  `fch_nacimiento` date NOT NULL,
  `permisos` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `token` varchar(255) NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1001,'Administrador','Guillermo','López',111222333,'1985-06-15','Todos','diegojaraba02@gmail.com','0c6d7c3d01ac01ed2b2eabd46409a801698a2a0b433228e94436dfb8be450242'),(1002,'Jefe','Marta','Fernández',444555666,'1990-09-21','Limitado','murciano.fagui24@zaragoza.salesianos.edu','3f08d63ac0df991ce8a57fb0550123fc5cf057f174d7305e7ba079a704e9a497');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-03  9:02:24
