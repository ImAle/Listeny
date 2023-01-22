CREATE DATABASE  IF NOT EXISTS `listeny` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci */ /*!80016  */;
USE `listeny`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: listeny
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `album` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `imagen` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `publico` bit(1) DEFAULT NULL,
  `reproducciones` int DEFAULT NULL,
  `titulo` varchar(45) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `id_propietario` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd5xwtiivuijwkpqqx9vj0ipi0` (`id_propietario`),
  CONSTRAINT `FKd5xwtiivuijwkpqqx9vj0ipi0` FOREIGN KEY (`id_propietario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `albumes`
--

DROP TABLE IF EXISTS `albumes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `albumes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reproducciones` int DEFAULT NULL,
  `titulo` varchar(45) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `imagen` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `descripcion` varchar(45) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `publico` tinyint DEFAULT '0',
  `propietario_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8fow02cudqm11q2m1pws9o7ki` (`propietario_id`),
  CONSTRAINT `FK8fow02cudqm11q2m1pws9o7ki` FOREIGN KEY (`propietario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albumes`
--

LOCK TABLES `albumes` WRITE;
/*!40000 ALTER TABLE `albumes` DISABLE KEYS */;
INSERT INTO `albumes` VALUES (1,1,'Album 1','URL del Album 1','Descripción del album 1',0,10),(2,2,'Album 2','URL del Album 2','Descripción del album 2',1,15),(3,3,'Album 3','URL del Album 3','Descripción del album 3',1,15),(4,4,'Album 4','URL del Album 4','Descripción del album 4',1,2),(5,5,'Album 5','URL del Album 5','Descripción del album 5',0,6),(6,6,'Album 6','URL del Album 6','Descripción del album 6',1,9),(7,7,'Album 7','URL del Album 7','Descripción del album 7',1,11),(8,8,'Album 8','URL del Album 8','Descripción del album 8',0,13),(9,9,'Album 9','URL del Album 9','Descripción del album 9',0,2),(10,10,'Album 10','URL del Album 10','Descripción del album 10',1,2),(11,11,'Album 11','URL del Album 11','Descripción del album 11',1,1),(12,12,'Album 12','URL del Album 12','Descripción del album 12',1,13),(13,13,'Album 13','URL del Album 13','Descripción del album 13',0,4),(14,14,'Album 14','URL del Album 14','Descripción del album 14',1,9),(15,15,'Album 15','URL del Album 15','Descripción del album 15',1,2),(16,16,'Album 16','URL del Album 16','Descripción del album 16',1,15),(17,17,'Album 17','URL del Album 17','Descripción del album 17',1,5),(18,18,'Album 18','URL del Album 18','Descripción del album 18',1,13),(19,19,'Album 19','URL del Album 19','Descripción del album 19',0,3),(20,20,'Album 20','URL del Album 20','Descripción del album 20',0,7),(21,21,'Album 21','URL del Album 21','Descripción del album 21',1,10),(22,22,'Album 22','URL del Album 22','Descripción del album 22',0,11),(23,23,'Album 23','URL del Album 23','Descripción del album 23',0,11),(24,24,'Album 24','URL del Album 24','Descripción del album 24',0,7),(25,25,'Album 25','URL del Album 25','Descripción del album 25',0,15),(26,26,'Album 26','URL del Album 26','Descripción del album 26',1,9),(27,27,'Album 27','URL del Album 27','Descripción del album 27',0,14),(28,28,'Album 28','URL del Album 28','Descripción del album 28',0,15),(29,29,'Album 29','URL del Album 29','Descripción del album 29',1,1),(30,30,'Album 30','URL del Album 30','Descripción del album 30',0,3),(31,31,'Album 31','URL del Album 31','Descripción del album 31',0,13),(32,32,'Album 32','URL del Album 32','Descripción del album 32',0,9),(33,33,'Album 33','URL del Album 33','Descripción del album 33',0,7),(34,34,'Album 34','URL del Album 34','Descripción del album 34',0,8),(35,35,'Album 35','URL del Album 35','Descripción del album 35',1,2),(36,36,'Album 36','URL del Album 36','Descripción del album 36',0,1),(37,37,'Album 37','URL del Album 37','Descripción del album 37',1,13),(38,38,'Album 38','URL del Album 38','Descripción del album 38',1,3),(39,39,'Album 39','URL del Album 39','Descripción del album 39',1,6),(40,40,'Album 40','URL del Album 40','Descripción del album 40',0,3);
/*!40000 ALTER TABLE `albumes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `albumes_has_canciones`
--

DROP TABLE IF EXISTS `albumes_has_canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `albumes_has_canciones` (
  `albumes_id` int NOT NULL,
  `canciones_id` int NOT NULL,
  KEY `fk_albumes_has_canciones_canciones1_idx` (`canciones_id`),
  KEY `fk_albumes_has_canciones_albumes1_idx` (`albumes_id`),
  CONSTRAINT `fk_albumes_has_canciones_canciones1` FOREIGN KEY (`canciones_id`) REFERENCES `canciones` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albumes_has_canciones`
--

LOCK TABLES `albumes_has_canciones` WRITE;
/*!40000 ALTER TABLE `albumes_has_canciones` DISABLE KEYS */;
INSERT INTO `albumes_has_canciones` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,1),(3,7),(3,8),(3,9),(4,10),(4,11),(4,12),(5,13),(5,14),(5,15),(6,16),(6,17),(6,18),(7,19),(7,20),(7,21),(8,22),(8,23),(8,24),(9,25),(9,26),(9,27),(10,28),(10,29),(10,30);
/*!40000 ALTER TABLE `albumes_has_canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artista`
--

DROP TABLE IF EXISTS `artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artista` (
  `nombre` varchar(45) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artistas`
--

DROP TABLE IF EXISTS `artistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artistas` (
  `id` int NOT NULL,
  `nombre` varchar(45) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `idUsuario` varchar(45) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistas`
--

LOCK TABLES `artistas` WRITE;
/*!40000 ALTER TABLE `artistas` DISABLE KEYS */;
INSERT INTO `artistas` VALUES (1,'D61796847','1'),(2,'I22439397','2'),(3,'E51170904','5'),(4,'I68962282','4'),(5,'J96295648','3'),(6,'K24937891','6'),(7,'B11408651','7'),(8,'C41693814','8'),(9,'C18387539','9'),(10,'S83730970','10');
/*!40000 ALTER TABLE `artistas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artistas_canciones`
--

DROP TABLE IF EXISTS `artistas_canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artistas_canciones` (
  `idCancion` int NOT NULL,
  `idArtista` int NOT NULL,
  `artistas_nombre` varchar(45) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `id_cancion` bigint NOT NULL,
  PRIMARY KEY (`idCancion`,`idArtista`),
  KEY `fk_canciones_has_Artistas_Artistas1_idx` (`idArtista`),
  KEY `fk_canciones_has_Artistas_canciones1_idx` (`idCancion`),
  CONSTRAINT `fk_canciones_has_Artistas_Artistas1` FOREIGN KEY (`idArtista`) REFERENCES `artistas` (`id`),
  CONSTRAINT `fk_canciones_has_Artistas_canciones1` FOREIGN KEY (`idCancion`) REFERENCES `canciones` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistas_canciones`
--

LOCK TABLES `artistas_canciones` WRITE;
/*!40000 ALTER TABLE `artistas_canciones` DISABLE KEYS */;
INSERT INTO `artistas_canciones` VALUES (1,1,'',0),(2,2,'',0),(3,5,'',0),(4,3,'',0),(5,4,'',0),(7,5,'',0),(8,6,'',0),(10,7,'',0),(11,8,'',0),(13,9,'',0),(14,10,'',0),(16,3,'',0),(17,6,'',0),(19,9,'',0),(20,2,'',0),(22,4,'',0);
/*!40000 ALTER TABLE `artistas_canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cancion`
--

DROP TABLE IF EXISTS `cancion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cancion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `duracion` int DEFAULT NULL,
  `fecha_incorporacion` datetime(6) DEFAULT NULL,
  `imagen` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `publica` bit(1) DEFAULT NULL,
  `titulo` varchar(50) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `url` varchar(200) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `id_categoria` bigint NOT NULL,
  `id_propietario` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6f5ip0f91ooybtxllthc5f9vv` (`id_categoria`),
  KEY `FKbhsqq2b3gxsdhibbvuv3nv7nj` (`id_propietario`),
  CONSTRAINT `FK6f5ip0f91ooybtxllthc5f9vv` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  CONSTRAINT `FKbhsqq2b3gxsdhibbvuv3nv7nj` FOREIGN KEY (`id_propietario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancion`
--

LOCK TABLES `cancion` WRITE;
/*!40000 ALTER TABLE `cancion` DISABLE KEYS */;
/*!40000 ALTER TABLE `cancion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canciones`
--

DROP TABLE IF EXISTS `canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `imagen` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `titulo` varchar(50) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `duracion` int DEFAULT NULL,
  `descripcion` varchar(45) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `fecha_incorporacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `publica` tinyint DEFAULT '0',
  `id_categoria` int DEFAULT NULL,
  `url` varchar(200) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `propietario_id` int DEFAULT NULL,
  `categoria_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnffwxg6q4yj06co1vrkjqklsl` (`propietario_id`),
  KEY `FKnyd8gts4h2yoqv3rx90mi0qmu` (`categoria_id`),
  CONSTRAINT `FKnffwxg6q4yj06co1vrkjqklsl` FOREIGN KEY (`propietario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKnyd8gts4h2yoqv3rx90mi0qmu` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canciones`
--

LOCK TABLES `canciones` WRITE;
/*!40000 ALTER TABLE `canciones` DISABLE KEYS */;
INSERT INTO `canciones` VALUES (1,'Imagen de la canción 1','Título de la canción 1',1,'Descripción de la canción 1','2023-01-04 14:33:00',0,NULL,'URL de la canción 1',1,1),(2,'Imagen de la canción 2','Título de la canción 2',2,'Descripción de la canción 2','2023-01-04 14:33:00',1,NULL,'URL de la canción 2',2,1),(3,'Imagen de la canción 3','Título de la canción 3',3,'Descripción de la canción 3','2023-01-04 14:33:00',0,NULL,'URL de la canción 3',7,1),(4,'Imagen de la canción 4','Título de la canción 4',4,'Descripción de la canción 4','2023-01-04 14:33:00',0,NULL,'URL de la canción 4',12,1),(5,'Imagen de la canción 5','Título de la canción 5',1,'Descripción de la canción 5','2023-01-04 14:33:00',0,NULL,'URL de la canción 5',8,1),(6,'Imagen de la canción 6','Título de la canción 6',2,'Descripción de la canción 6','2023-01-04 14:33:00',0,NULL,'URL de la canción 6',5,2),(7,'Imagen de la canción 7','Título de la canción 7',3,'Descripción de la canción 7','2023-01-04 14:33:00',0,NULL,'URL de la canción 7',14,2),(8,'Imagen de la canción 8','Título de la canción 8',4,'Descripción de la canción 8','2023-01-04 14:33:00',1,NULL,'URL de la canción 8',11,2),(9,'Imagen de la canción 9','Título de la canción 9',1,'Descripción de la canción 9','2023-01-04 14:33:00',1,NULL,'URL de la canción 9',13,2),(10,'Imagen de la canción 10','Título de la canción 10',2,'Descripción de la canción 10','2023-01-04 14:33:00',0,NULL,'URL de la canción 10',2,3),(11,'Imagen de la canción 11','Título de la canción 11',3,'Descripción de la canción 11','2023-01-04 14:33:00',0,NULL,'URL de la canción 11',13,3),(12,'Imagen de la canción 12','Título de la canción 12',4,'Descripción de la canción 12','2023-01-04 14:33:00',0,NULL,'URL de la canción 12',13,3),(13,'Imagen de la canción 13','Título de la canción 13',1,'Descripción de la canción 13','2023-01-04 14:33:00',1,NULL,'URL de la canción 13',10,3),(14,'Imagen de la canción 14','Título de la canción 14',2,'Descripción de la canción 14','2023-01-04 14:33:00',0,NULL,'URL de la canción 14',13,4),(15,'Imagen de la canción 15','Título de la canción 15',3,'Descripción de la canción 15','2023-01-04 14:33:00',0,NULL,'URL de la canción 15',5,4),(16,'Imagen de la canción 16','Título de la canción 16',4,'Descripción de la canción 16','2023-01-04 14:33:00',0,NULL,'URL de la canción 16',14,4),(17,'Imagen de la canción 17','Título de la canción 17',1,'Descripción de la canción 17','2023-01-04 14:33:00',0,NULL,'URL de la canción 17',11,5),(18,'Imagen de la canción 18','Título de la canción 18',2,'Descripción de la canción 18','2023-01-04 14:33:00',0,NULL,'URL de la canción 18',11,5),(19,'Imagen de la canción 19','Título de la canción 19',3,'Descripción de la canción 19','2023-01-04 14:33:00',1,NULL,'URL de la canción 19',7,5),(20,'Imagen de la canción 20','Título de la canción 20',4,'Descripción de la canción 20','2023-01-04 14:33:00',0,NULL,'URL de la canción 20',3,6),(21,'Imagen de la canción 21','Título de la canción 21',1,'Descripción de la canción 21','2023-01-04 14:33:00',0,NULL,'URL de la canción 21',7,6),(22,'Imagen de la canción 22','Título de la canción 22',2,'Descripción de la canción 22','2023-01-04 14:33:00',0,NULL,'URL de la canción 22',11,6),(23,'Imagen de la canción 23','Título de la canción 23',3,'Descripción de la canción 23','2023-01-04 14:33:00',1,NULL,'URL de la canción 23',4,7),(24,'Imagen de la canción 24','Título de la canción 24',4,'Descripción de la canción 24','2023-01-04 14:33:00',0,NULL,'URL de la canción 24',1,7),(25,'Imagen de la canción 25','Título de la canción 25',1,'Descripción de la canción 25','2023-01-04 14:33:00',1,NULL,'URL de la canción 25',6,7),(26,'Imagen de la canción 26','Título de la canción 26',2,'Descripción de la canción 26','2023-01-04 14:33:00',1,NULL,'URL de la canción 26',13,8),(27,'Imagen de la canción 27','Título de la canción 27',3,'Descripción de la canción 27','2023-01-04 14:33:00',1,NULL,'URL de la canción 27',3,8),(28,'Imagen de la canción 28','Título de la canción 28',4,'Descripción de la canción 28','2023-01-04 14:33:00',1,NULL,'URL de la canción 28',3,8),(29,'Imagen de la canción 29','Título de la canción 29',1,'Descripción de la canción 29','2023-01-04 14:33:00',0,NULL,'URL de la canción 29',5,9),(30,'Imagen de la canción 30','Título de la canción 30',2,'Descripción de la canción 30','2023-01-04 14:33:00',0,NULL,'URL de la canción 30',15,9),(31,'Imagen de la canción 31','Título de la canción 31',3,'Descripción de la canción 31','2023-01-04 14:33:00',1,NULL,'URL de la canción 31',3,9),(32,'Imagen de la canción 32','Título de la canción 32',4,'Descripción de la canción 32','2023-01-04 14:33:00',0,NULL,'URL de la canción 32',11,10),(33,'Imagen de la canción 33','Título de la canción 33',1,'Descripción de la canción 33','2023-01-04 14:33:00',1,NULL,'URL de la canción 33',1,10),(34,'Imagen de la canción 34','Título de la canción 34',2,'Descripción de la canción 34','2023-01-04 14:33:00',0,NULL,'URL de la canción 34',2,10),(35,'Imagen de la canción 35','Título de la canción 35',3,'Descripción de la canción 35','2023-01-04 14:33:00',0,NULL,'URL de la canción 35',6,11),(36,'Imagen de la canción 36','Título de la canción 36',4,'Descripción de la canción 36','2023-01-04 14:33:00',1,NULL,'URL de la canción 36',7,11),(37,'Imagen de la canción 37','Título de la canción 37',1,'Descripción de la canción 37','2023-01-04 14:33:00',1,NULL,'URL de la canción 37',3,12),(38,'Imagen de la canción 38','Título de la canción 38',2,'Descripción de la canción 38','2023-01-04 14:33:00',1,NULL,'URL de la canción 38',10,13),(39,'Imagen de la canción 39','Título de la canción 39',3,'Descripción de la canción 39','2023-01-04 14:33:00',1,NULL,'URL de la canción 39',9,13),(40,'Imagen de la canción 40','Título de la canción 40',4,'Descripción de la canción 40','2023-01-04 14:33:00',1,NULL,'URL de la canción 40',13,13);
/*!40000 ALTER TABLE `canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canciones_has_albumes`
--

DROP TABLE IF EXISTS `canciones_has_albumes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canciones_has_albumes` (
  `canciones_id` int NOT NULL,
  `albumes_id` int NOT NULL,
  PRIMARY KEY (`canciones_id`,`albumes_id`),
  KEY `fk_canciones_has_albumes_albumes1_idx` (`albumes_id`),
  KEY `fk_canciones_has_albumes_canciones1_idx` (`canciones_id`),
  CONSTRAINT `fk_canciones_has_albumes_albumes1` FOREIGN KEY (`albumes_id`) REFERENCES `albumes` (`id`),
  CONSTRAINT `fk_canciones_has_albumes_canciones1` FOREIGN KEY (`canciones_id`) REFERENCES `canciones` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canciones_has_albumes`
--

LOCK TABLES `canciones_has_albumes` WRITE;
/*!40000 ALTER TABLE `canciones_has_albumes` DISABLE KEYS */;
/*!40000 ALTER TABLE `canciones_has_albumes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `categoria` varchar(45) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `id_madre` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKohfj48fqwo14ot6919y326hy9` (`id_madre`),
  CONSTRAINT `FKohfj48fqwo14ot6919y326hy9` FOREIGN KEY (`id_madre`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `categoria` varchar(45) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `idMadre` int DEFAULT NULL,
  `id_madre` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_categoriaMadre_idx` (`idMadre`),
  CONSTRAINT `fk_categoriaMadre` FOREIGN KEY (`idMadre`) REFERENCES `categorias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'rock&roll',NULL,NULL),(2,'rock cristiano',1,NULL),(3,'pop',NULL,NULL),(4,'blues',NULL,NULL),(5,'jazz',NULL,NULL),(6,'heavy metal',1,NULL),(7,'hard rock',1,NULL),(8,'kpop',3,NULL),(9,'música clasica',NULL,NULL),(10,'soul',NULL,NULL),(11,'country',NULL,NULL),(12,'disco',NULL,NULL),(13,'techno',NULL,NULL),(14,'regaetton',NULL,NULL),(15,'hip hop',NULL,NULL);
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favoritos_albumes`
--

DROP TABLE IF EXISTS `favoritos_albumes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favoritos_albumes` (
  `idFavorito` int NOT NULL,
  `idUsuario` int NOT NULL,
  `id_usuario` bigint NOT NULL,
  `id_album` bigint NOT NULL,
  PRIMARY KEY (`idFavorito`,`idUsuario`),
  KEY `fk_usuario_idx` (`idUsuario`),
  CONSTRAINT `fk_albumFavorito` FOREIGN KEY (`idFavorito`) REFERENCES `albumes` (`id`),
  CONSTRAINT `fk_usuario_albumes` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favoritos_albumes`
--

LOCK TABLES `favoritos_albumes` WRITE;
/*!40000 ALTER TABLE `favoritos_albumes` DISABLE KEYS */;
INSERT INTO `favoritos_albumes` VALUES (1,40,0,0),(2,1,0,0),(3,2,0,0),(4,3,0,0),(5,4,0,0),(6,5,0,0),(7,6,0,0),(8,7,0,0),(9,8,0,0),(10,9,0,0),(11,10,0,0),(12,11,0,0),(13,12,0,0),(14,13,0,0),(15,14,0,0),(16,15,0,0),(17,16,0,0),(18,17,0,0),(19,18,0,0),(20,19,0,0),(21,20,0,0),(22,21,0,0),(23,22,0,0),(24,23,0,0),(25,24,0,0),(26,25,0,0),(27,26,0,0),(28,27,0,0),(29,28,0,0),(30,29,0,0),(31,30,0,0),(32,31,0,0),(33,32,0,0),(34,33,0,0),(35,34,0,0),(36,35,0,0),(37,36,0,0),(38,37,0,0),(39,38,0,0),(40,39,0,0);
/*!40000 ALTER TABLE `favoritos_albumes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favoritos_canciones`
--

DROP TABLE IF EXISTS `favoritos_canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favoritos_canciones` (
  `idFavorito` int NOT NULL,
  `idUsuario` int NOT NULL,
  `id_usuario` bigint NOT NULL,
  `id_favorito` bigint NOT NULL,
  PRIMARY KEY (`idFavorito`,`idUsuario`),
  KEY `fk_usuario_idx` (`idUsuario`),
  CONSTRAINT `fk_cancionFavorita` FOREIGN KEY (`idFavorito`) REFERENCES `canciones` (`id`),
  CONSTRAINT `fk_usuario_canciones` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favoritos_canciones`
--

LOCK TABLES `favoritos_canciones` WRITE;
/*!40000 ALTER TABLE `favoritos_canciones` DISABLE KEYS */;
INSERT INTO `favoritos_canciones` VALUES (1,40,0,0),(2,1,0,0),(3,2,0,0),(4,3,0,0),(5,4,0,0),(6,5,0,0),(10,9,0,0),(11,10,0,0),(12,11,0,0),(13,12,0,0),(14,13,0,0),(15,14,0,0),(16,15,0,0),(17,16,0,0),(18,17,0,0),(22,21,0,0),(23,22,0,0),(24,23,0,0),(26,25,0,0),(31,30,0,0),(32,31,0,0),(33,32,0,0),(34,33,0,0),(35,34,0,0),(39,38,0,0),(40,39,0,0);
/*!40000 ALTER TABLE `favoritos_canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favoritos_lista`
--

DROP TABLE IF EXISTS `favoritos_lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favoritos_lista` (
  `idLista` int NOT NULL,
  `idUsuario` int NOT NULL,
  PRIMARY KEY (`idLista`,`idUsuario`),
  KEY `fk_usuario_idx` (`idUsuario`),
  CONSTRAINT `fk_listasFavoritos` FOREIGN KEY (`idLista`) REFERENCES `listas` (`id`),
  CONSTRAINT `fk_usuario_listas` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favoritos_lista`
--

LOCK TABLES `favoritos_lista` WRITE;
/*!40000 ALTER TABLE `favoritos_lista` DISABLE KEYS */;
INSERT INTO `favoritos_lista` VALUES (1,1),(1,2),(1,3),(2,4),(3,5),(4,6),(7,7),(6,8),(9,9),(10,10),(12,11),(12,12),(14,13),(14,14);
/*!40000 ALTER TABLE `favoritos_lista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favoritos_listas`
--

DROP TABLE IF EXISTS `favoritos_listas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favoritos_listas` (
  `id_usuario` bigint NOT NULL,
  `id_lista` bigint NOT NULL,
  KEY `FKumsfj2rhua5sbl0yq0oh7av5` (`id_lista`),
  KEY `FKm3ywxhehncdrsftv6d4efen93` (`id_usuario`),
  CONSTRAINT `FKm3ywxhehncdrsftv6d4efen93` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKumsfj2rhua5sbl0yq0oh7av5` FOREIGN KEY (`id_lista`) REFERENCES `lista` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favoritos_listas`
--

LOCK TABLES `favoritos_listas` WRITE;
/*!40000 ALTER TABLE `favoritos_listas` DISABLE KEYS */;
/*!40000 ALTER TABLE `favoritos_listas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista`
--

DROP TABLE IF EXISTS `lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `color` varchar(15) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `descripcion` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `imagen` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `nombre` varchar(45) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `publica` bit(1) DEFAULT NULL,
  `reproducciones` int DEFAULT NULL,
  `id_categoria` bigint NOT NULL,
  `id_propietario` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9bg7asjq7uc575pg1s0j24vc6` (`id_categoria`),
  KEY `FK92sa1n6h7ep3lcrdqcaq8pf0a` (`id_propietario`),
  CONSTRAINT `FK92sa1n6h7ep3lcrdqcaq8pf0a` FOREIGN KEY (`id_propietario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK9bg7asjq7uc575pg1s0j24vc6` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista`
--

LOCK TABLES `lista` WRITE;
/*!40000 ALTER TABLE `lista` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listas`
--

DROP TABLE IF EXISTS `listas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_propietario` int NOT NULL,
  `reproducciones` int DEFAULT NULL,
  `nombre` varchar(45) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `imagen` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `descripcion` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `color` varchar(15) COLLATE utf8mb3_spanish2_ci DEFAULT ' #32CD32',
  `publica` tinyint DEFAULT '0',
  `idCategoria` int NOT NULL,
  PRIMARY KEY (`id`,`id_propietario`),
  KEY `fk_idCategoria_idx` (`idCategoria`),
  KEY `fk_idPropietario_idx` (`id_propietario`),
  CONSTRAINT `fk_idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`id`),
  CONSTRAINT `fk_idPropietario` FOREIGN KEY (`id_propietario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listas`
--

LOCK TABLES `listas` WRITE;
/*!40000 ALTER TABLE `listas` DISABLE KEYS */;
INSERT INTO `listas` VALUES (1,1,8,'e6h5gtfes','GWd84f|skeynimp:44769imagenkcz-2377871','Jutdekmytathd. Kwkvovfgw','9347dcyb',1,1),(2,1,7,'juhygtfr','DPg76v|fjjclmfc:49242imagenbsn-5555402','Jqzihcwlinehb. Etzvtlsjn','0547garx',0,1),(3,1,6,'kjiuhygtre','GYd81d|msijwldk:90321imagenglo-6390084','Ekeqwxpitpmkw. Kpjhadbiq','5529yghb',1,1),(4,2,5,'kmtrehgtge','OOw91b|pttwzrjb:56601imagenbsa-5270248','Prhtexbmmorff. Kqjwmnaxp','1609wydu',0,2),(5,2,12,'jyutkjysrg','ZMp41n|uahafnui:47251imagenbqn-6836960','Ifdpyalixfqfy. Ialhehszb','8017bjaj',0,2),(6,4,33,'jiuykfdmfd','MEw99z|rbvrxveu:23881imagentha-9119887','Debfmjzhslita. Fjhdgkytx','9430icif',1,4),(7,7,21,'cfgndgftr','EXi76a|iythkjtc:33044imagenpky-8332907','Vttfotbdzzqyb. Epdvxtfqv','0640nfbt',1,6),(8,9,16,'eitujrfwx','JDs56a|sdnvmgye:53536imagenehh-1683327','Xthwzmnoilaji. Inarillqz','2545cefm',0,7),(9,10,22,'mdzbsrbrvc','DCv91d|reqspcpn:64475imagentma-1654751','Ldosxxpspifes. Jdxklarms','2602jmqz',0,10),(10,5,0,'sadegvwbr','ZBm31v|tcisyyfd:39091imagentvy-7993718','Pbceeupvghqmf. Qpkrgkbdf','2749ycyj',1,10),(11,40,0,'jtukjuthet','GUd95t|ijaasxcw:65786imagenelh-1959273','Mxiajuxwwutzr. Mgkdysppf','0709nimp',0,12),(12,40,0,'wfqrthry','FZu86a|xxnufynd:03369imagenhjk-0405463','Oejnmlhizmhmk. Kztaaumpp','2856nodn',1,11),(13,29,1,'mgufmndsfvs','UAs60g|mpfhrtlj:45022imagenujm-7699925','Hskftfcwprqwd. Rxdlifppb','6697aafl',0,15),(14,31,14,'ktkiyjdtaq','OHp94j|nxhucktk:27737imagenzwb-3416395','Ywkxuaryziafv. Koyaiojle','5548ncdo',1,5),(15,33,6,'vgnfyhbdtvd','ZRs55q|nxfulkhl:63374imagenayq-3614961','Cywoqlskfwcmb. Imskpbwoj','1984asdr',0,9),(16,32,6,'hynrebtvegf','LVg98u|gedegiid:43254imagenbmn-0481601','Bgotiaffzozfo. Hvwvcomap','9760tyro',0,9);
/*!40000 ALTER TABLE `listas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listas_has_canciones`
--

DROP TABLE IF EXISTS `listas_has_canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listas_has_canciones` (
  `listas_id` int NOT NULL,
  `canciones_id` int NOT NULL,
  PRIMARY KEY (`listas_id`,`canciones_id`),
  KEY `fk_listas_has_canciones_canciones1_idx` (`canciones_id`),
  KEY `fk_listas_has_canciones_listas1_idx` (`listas_id`),
  CONSTRAINT `fk_listas_has_canciones_canciones1` FOREIGN KEY (`canciones_id`) REFERENCES `canciones` (`id`),
  CONSTRAINT `fk_listas_has_canciones_listas1` FOREIGN KEY (`listas_id`) REFERENCES `listas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listas_has_canciones`
--

LOCK TABLES `listas_has_canciones` WRITE;
/*!40000 ALTER TABLE `listas_has_canciones` DISABLE KEYS */;
INSERT INTO `listas_has_canciones` VALUES (1,1),(2,2),(3,2),(1,3),(2,3),(1,4),(2,4),(3,4),(1,5),(2,5),(3,5),(4,6),(5,6),(5,7),(4,8),(5,8),(4,9),(5,9),(6,14),(6,15),(6,16),(14,17),(14,18),(14,19),(7,20),(7,21),(7,22),(8,23),(8,24),(8,25),(15,29),(16,29),(15,30),(16,30),(15,31),(9,32),(10,32),(9,33),(9,34),(10,34),(12,35),(12,36),(11,37);
/*!40000 ALTER TABLE `listas_has_canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificacion`
--

DROP TABLE IF EXISTS `notificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificacion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `titulo` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion`
--

LOCK TABLES `notificacion` WRITE;
/*!40000 ALTER TABLE `notificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificaciones`
--

DROP TABLE IF EXISTS `notificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificaciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `titulo` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `envio` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificaciones`
--

LOCK TABLES `notificaciones` WRITE;
/*!40000 ALTER TABLE `notificaciones` DISABLE KEYS */;
INSERT INTO `notificaciones` VALUES (1,'Estas han sido las 3 playlist mas escuchadas de la semana','Escucha tus playlist favorita ','2023-01-04 14:32:59'),(2,'Estas han sido las 5 canciones mas escuchadas de la semana','Escucha tu canción favorita ','2023-01-04 14:32:59'),(3,'Quizá sea el momento de escuchar tus temas preferidos','Escucha tu canción favorita ','2023-01-04 14:32:59'),(4,'Tranquilizate escuchando algo de música','Escucha tu canción favorita ','2023-01-04 14:32:59'),(5,'Siempre hay tiempo para escuchar música','Escucha tu canción favorita ','2023-01-04 14:32:59'),(6,'Este álbum ha sido el mas escuchado del año','Escucha el álbum más popular ','2023-01-04 14:32:59'),(7,'¡Entra a la aplicación y escuchala!','¡Esta canción lo esta petando!','2023-01-04 14:32:59'),(8,'Uno de tus artistas favoritos acaba de subir una canción, Sé el primero en escucharla','Nueva canción ','2023-01-04 14:32:59'),(9,'Estas han sido las 3 playlist mas escuchadas de la semana','Escucha tu canción favorita ','2023-01-04 14:32:59'),(10,'Estas han sido las 5 canciones mas escuchadas de la semana','Escucha tu canción favorita ','2023-01-04 14:32:59'),(11,'Este álbum se está volviendo muy popular','¡Escuchalo ya!','2023-01-04 14:32:59'),(12,'Si Jesús estuviera vivo, también lo haría','Es el momento ideal para escuchar música ','2023-01-04 14:32:59'),(13,'Un poco de música para calmar el ambiente','Escucha tu canción favorita ','2023-01-04 14:32:59'),(14,'¡Uno de tus artistas favoritos acaba de subir un álbum!','Nuevo álbum ','2023-01-04 14:32:59'),(15,'¿Trabajando? ponte múscia relajante de fondo','Haz que la música te acompañe ','2023-01-04 14:32:59'),(16,'¿Aburrido? Ponte este temazo','La canción más escuchada del día ','2023-01-04 14:32:59'),(17,'Sea disco chino o filipino, pon esta canción a tu hijo','Recomendación canciones infantiles ','2023-01-04 14:32:59'),(18,'Si tuviera que elegir, eleigirá esta canción para mi funeral','Canciones alegres en inglés ','2023-01-04 14:32:59'),(19,'¿Has oido hablar de este artista?','Escucha al artista del momento ','2023-01-04 14:32:59'),(20,'Para gustos, las canciones','Escucha tu canción favorita ','2023-01-04 14:32:59'),(21,'Jesús ama esta canción','Escucha la canción del momento ','2023-01-04 14:32:59'),(22,'El español más escuchado del mundo','Este artista lidera los rankings','2023-01-04 14:32:59'),(23,'Ponte una canción y hakuna matata','¡Escucha esta canción ahora!','2023-01-04 14:32:59'),(24,'En esta epoca del año, escucha esta terrorifica playlist','¡Ya ha llegado HALLOWEEN! ','2023-01-04 14:32:59'),(25,'¡Hoy es el día nacional de Italia! Celebralo escuchando esta música folclorica','Mamma mia italiana ','2023-01-04 14:32:59'),(26,'¿Jugando? !Ponte esta música de acción de fondo¡','Momento gamer ','2023-01-04 14:32:59'),(27,'Igual te gustaría esta playlist de Mr. Robot','¿Hackeando la NASA? ','2023-01-04 14:32:59'),(28,'Escucha este álbum de jazz, el 1º de USA','Jazz para relajarse ','2023-01-04 14:32:59'),(29,'Si Mahoma no viene a la playlist, la playlist viene a Mahoma','Música porro ','2023-01-04 14:32:59'),(30,'Escucha la música mas navideña rodeado de tu familia','¡Navidad!¡Navidad!¡Dulce navidad! ','2023-01-04 14:32:59'),(31,'Escucha esta recopilación de canciones mas populares del 2010-2019','¡Canciones que marcaron la decada! ','2023-01-04 14:32:59'),(32,'Las mejores canciones nunca pasan de moda','Canciones que marcaron la epoca ','2023-01-04 14:32:59'),(33,'A Jesús también le ha gustado esto','¡Este artista lo está petando! ','2023-01-04 14:32:59'),(34,'Música para adolescentes','Like a Boss ','2023-01-04 14:32:59'),(35,'¡Esta canción le está dando la vuelta al mundo!','Deberías echar una orejada ','2023-01-04 14:32:59'),(36,'Estas músicas están siendo todo un hit del año ¡Escuchalas mientras puedas!','La música de esta serie es relamente popular ','2023-01-04 14:32:59'),(37,'¿Demasiado joven para morir? ¿Seguro?','Escucha canciones mientras puedas ','2023-01-04 14:32:59'),(38,'Esta playlist se ha hecho muy popular entre los que sigues','Escucha los hits del momento ','2023-01-04 14:32:59'),(39,'¿Escuchando la misma canción en bucle hasta que te sangre los oídos? Tenemos otras canciones parecidas para ti','Tenemos mas de una canción ','2023-01-04 14:32:59'),(40,'¿Sales a pasear? Ponte música épica para atravesar el paso de cebra','Hay canciones para todo ','2023-01-04 14:32:59');
/*!40000 ALTER TABLE `notificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reproduccion`
--

DROP TABLE IF EXISTS `reproduccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reproduccion` (
  `fecha_last_reproduccion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `reproducciones` bigint NOT NULL,
  `id_cancion` bigint NOT NULL,
  `id_usuario` bigint NOT NULL,
  PRIMARY KEY (`fecha_last_reproduccion`,`id_cancion`,`id_usuario`,`reproducciones`),
  KEY `FK2tx3rvjsjl2rnh00vi13uhovb` (`id_cancion`),
  KEY `FK9v7yxujm57ubq5po9qbghu90b` (`id_usuario`),
  CONSTRAINT `FK2tx3rvjsjl2rnh00vi13uhovb` FOREIGN KEY (`id_cancion`) REFERENCES `cancion` (`id`),
  CONSTRAINT `FK9v7yxujm57ubq5po9qbghu90b` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reproduccion`
--

LOCK TABLES `reproduccion` WRITE;
/*!40000 ALTER TABLE `reproduccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `reproduccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reproducciones`
--

DROP TABLE IF EXISTS `reproducciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reproducciones` (
  `id_usuario` int NOT NULL,
  `id_cancion` int NOT NULL,
  `reproducciones` int DEFAULT NULL,
  `fecha_lastReproduccion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_last_reproduccion` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`,`id_cancion`),
  KEY `FKm23h3mxg0a1fsbibh6xt1k6g6` (`id_cancion`),
  CONSTRAINT `FK9p2077e2w1uq1u9yswutcjit8` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKm23h3mxg0a1fsbibh6xt1k6g6` FOREIGN KEY (`id_cancion`) REFERENCES `canciones` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reproducciones`
--

LOCK TABLES `reproducciones` WRITE;
/*!40000 ALTER TABLE `reproducciones` DISABLE KEYS */;
INSERT INTO `reproducciones` VALUES (1,1,1,'2023-01-04 14:33:01',NULL),(1,2,2,'2023-01-04 14:33:01',NULL),(1,3,3,'2023-01-04 14:33:01',NULL),(1,22,21,'2023-01-04 14:33:01',NULL),(2,3,6,'2023-01-04 14:33:01',NULL),(2,4,4,'2023-01-04 14:33:01',NULL),(2,5,5,'2023-01-04 14:33:01',NULL),(2,22,22,'2023-01-04 14:33:01',NULL),(3,2,7,'2023-01-04 14:33:01',NULL),(3,10,9,'2023-01-04 14:33:01',NULL),(3,23,23,'2023-01-04 14:33:01',NULL),(4,1,8,'2023-01-04 14:33:01',NULL),(6,10,10,'2023-01-04 14:33:01',NULL),(7,14,14,'2023-01-04 14:33:01',NULL),(7,15,15,'2023-01-04 14:33:01',NULL),(9,19,19,'2023-01-04 14:33:01',NULL),(11,11,11,'2023-01-04 14:33:01',NULL),(12,1,12,'2023-01-04 14:33:01',NULL),(16,7,25,'2023-01-04 14:33:01',NULL),(16,16,24,'2023-01-04 14:33:01',NULL),(17,17,17,'2023-01-04 14:33:01',NULL),(18,17,18,'2023-01-04 14:33:01',NULL),(19,13,13,'2023-01-04 14:33:01',NULL),(20,22,20,'2023-01-04 14:33:01',NULL),(26,6,2,'2023-01-04 14:33:01',NULL),(27,4,30,'2023-01-04 14:33:01',NULL),(27,5,31,'2023-01-04 14:33:01',NULL),(31,18,2,'2023-01-04 14:33:01',NULL),(32,7,27,'2023-01-04 14:33:01',NULL),(32,17,16,'2023-01-04 14:33:01',NULL),(32,18,28,'2023-01-04 14:33:01',NULL),(33,11,35,'2023-01-04 14:33:01',NULL),(33,18,36,'2023-01-04 14:33:01',NULL),(36,40,40,'2023-01-04 14:33:01',NULL),(37,14,37,'2023-01-04 14:33:01',NULL),(38,14,38,'2023-01-04 14:33:01',NULL),(39,39,39,'2023-01-04 14:33:01',NULL),(40,9,32,'2023-01-04 14:33:01',NULL),(40,10,33,'2023-01-04 14:33:01',NULL),(40,15,3,'2023-01-04 14:33:01',NULL);
/*!40000 ALTER TABLE `reproducciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguidor`
--

DROP TABLE IF EXISTS `seguidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguidor` (
  `id_seguidor` bigint NOT NULL,
  `id_seguido` bigint NOT NULL,
  KEY `FK7m5yeae46r7kidkh745j83wt1` (`id_seguido`),
  KEY `FKshauxuejxaiguxm7jlk5bpuej` (`id_seguidor`),
  CONSTRAINT `FK7m5yeae46r7kidkh745j83wt1` FOREIGN KEY (`id_seguido`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKshauxuejxaiguxm7jlk5bpuej` FOREIGN KEY (`id_seguidor`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguidor`
--

LOCK TABLES `seguidor` WRITE;
/*!40000 ALTER TABLE `seguidor` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguidor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguidores`
--

DROP TABLE IF EXISTS `seguidores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguidores` (
  `id_seguidor` int NOT NULL,
  `id_seguido` int NOT NULL,
  `seguidorescol1` int DEFAULT NULL,
  KEY `FKi9yf180m6cu53qcy3d148on0a` (`id_seguido`) /*!80000 INVISIBLE */,
  KEY `FKfhq9ttgswewt33ffi8vmnht1p` (`id_seguidor`),
  CONSTRAINT `FKfhq9ttgswewt33ffi8vmnht1p` FOREIGN KEY (`id_seguidor`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKi9yf180m6cu53qcy3d148on0a` FOREIGN KEY (`id_seguido`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguidores`
--

LOCK TABLES `seguidores` WRITE;
/*!40000 ALTER TABLE `seguidores` DISABLE KEYS */;
INSERT INTO `seguidores` VALUES (1,5,NULL),(1,11,NULL),(1,15,NULL),(2,40,NULL),(2,1,NULL),(3,2,NULL),(4,3,NULL),(5,4,NULL),(7,6,NULL),(8,7,NULL),(9,1,NULL),(10,9,NULL),(11,10,NULL),(13,12,NULL),(14,13,NULL),(15,14,NULL),(17,16,NULL),(18,17,NULL),(19,18,NULL),(20,19,NULL),(21,1,NULL),(22,21,NULL),(23,22,NULL),(24,23,NULL),(25,1,NULL),(26,25,NULL),(27,26,NULL),(28,27,NULL),(29,28,NULL),(30,29,NULL),(31,30,NULL),(32,31,NULL),(33,32,NULL),(34,33,NULL),(35,34,NULL),(36,35,NULL),(37,36,NULL),(38,37,NULL),(39,38,NULL),(40,39,NULL);
/*!40000 ALTER TABLE `seguidores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `clave` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `email` varchar(60) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `es_artista` bit(1) DEFAULT NULL,
  `fecha_nacimiento` datetime(6) NOT NULL,
  `imagen` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `imagen_fondo` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `nombre_usuario` varchar(45) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `sexo` char(1) COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(45) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `email` varchar(60) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `clave` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `alias` varchar(45) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` char(1) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `imagen` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `imagen_fondo` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `notificaciones_id` int DEFAULT NULL,
  `esArtista` tinyint DEFAULT NULL,
  `es_artista` bit(1) DEFAULT NULL,
  `nombre_usuario` varchar(45) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `emilio_UNIQUE` (`email`),
  UNIQUE KEY `nombre_UNIQUE` (`nombreUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'D61796847','gcamilletti0@ucla.edu','09KxNSx','Nliovnjgv5','2022-05-19','M','vuuremjkfne:805590ZOMTimagenONJUAbyxi','okebmqgzwbx:4769844ECBfotoFondoYFEIBamqc',1,1,NULL,NULL),(2,'I22439397','llapworth1@java.com','NsHBZGG','Fqfwhydli0','2022-11-16','F','nizthqjezml:533065O3RCimagenUJXCVfrgv','rkfxfyrxxsp:340136QUFJfotoFondoWSJVUsarh',2,0,NULL,NULL),(3,'J96295648','rvaggers2@ucla.edu','r3V54Y','Gsxqzdty42','2022-01-11','F','vonejncvmjb:501776VA0HimagenEACUUeywq','nhshnaluvcs:220886YNWBfotoFondoGKHRCvykg',3,1,NULL,NULL),(4,'I68962282','bmacallen3@goo.gl','QESLWE','Gjsgugekk1','2022-10-20','F','rghzoxfarat:400572WB49imagenJXWLOwjtp','jlccbmokglk:19160841XZfotoFondoJFOQErtbc',4,0,NULL,NULL),(5,'E51170904','dflucks4@desdev.cn','1WFigSV','Feagceuen4','2022-03-26','M','ckenoiigken:839519NOL0imagenUYNWPigiu','ymtxygmgadm:7062307S9EfotoFondoYEPYNgfxx',5,0,NULL,NULL),(6,'K24937891','hbrinkworth5@163.com','9vHxEQkqNf','Qelhakkk45','2022-12-08','F','ubwjiyibjsc:508343WWSZimagenWFEXJntok','psyxmhhckkz:336806BETPfotoFondoOHVKVztdp',6,1,NULL,NULL),(7,'B11408651','itukely6@netlog.com','mBzSBOr5Qe','Ohvffkpt27','2022-12-19','F','becmxzitrsu:7886331ZALimagenWNRWCajot','jpynexuunyf:002838YSA7fotoFondoBPRQBzcim',7,1,NULL,NULL),(8,'C41693814','esouter7@webnode.com','75lUBfkUrr0','Sdzbbvlox3','2022-03-17','F','whnfxhdyqzx:8871851LY6imagenMQWCSrugz','zqxralgfgrh:8080535BUDfotoFondoEXEQManli',8,0,NULL,NULL),(9,'C18387539','auttridge8@webmd.com','3wARGaXR','Vpdfrfty55','2022-07-24','M','gscttcjgoci:462506B1T9imagenEJDVBlfly','txfvmovqpvh:9837901MAIfotoFondoALQFVikqy',9,1,NULL,NULL),(10,'S83730970','bcornish9@mozilla.org','JMXN6r','Ohywyozsu8','2022-09-04','M','evppeojztwh:731568VP2NimagenWELPSglxs','nirjetxyrcd:44382887RXfotoFondoQJMRMcyar',10,1,NULL,NULL),(11,'E56971945','gcoopa@youtu.be','gpdd4rND','Qnyrozbuf0','2022-12-04','M','liznxflbwjk:9230154XTVimagenWEZQEonoq','zbtmyechyyk:928992Y0XZfotoFondoGHPIUamcj',11,1,NULL,NULL),(12,'T74938715','nloxstonb@home.pl','Bx2exVRjQ7Q','Moqhyusy37','2022-08-26','M','hdcufwnmumh:7067091LVWimagenTWKXUrbgb','fxnlsrqnvgj:852972WRXKfotoFondoVZSYMeemy',12,1,NULL,NULL),(13,'N13643446','pbaskervillec@jiathis.com','j2MY7g31iTW','Bratmnjod6','2022-12-21','F','sfszxhpsdvo:221022XL3LimagenGGLGYnjip','eaflhtjobfd:743775HET6fotoFondoCYPRJjauf',13,1,NULL,NULL),(14,'M68522944','tchisolmd@google.pl','eHVS9Fb4ynp','Ofefuhhst6','2022-04-02','F','ltkgsnytypj:792411OM6FimagenDISSAqjfd','kvrxijyixls:603376L1P4fotoFondoZINDDhreo',14,1,NULL,NULL),(15,'B84322805','gpanswicke@odnoklassniki.ru','pns9TWvO0XZA','Vxnyjcuey9','2022-07-13','M','swawsogjsdb:107564KXUTimagenBNVVXqmuu','irfpgrqdczt:934769JK5ZfotoFondoXCWUWtqrv',15,1,NULL,NULL),(16,'G28023493','bmeliorf@icq.com','zuabQH0nZcW','Facomkxv51','2022-06-17','M','wpogeylssva:393999F8RTimagenNLSIVzgbv','xnvocrcihmc:623639PO9WfotoFondoKGIEJauoa',16,1,NULL,NULL),(17,'O60580136','ljeppenseng@usatoday.com','wlIZ7DM0WJa','Zetuyizzt0','2022-12-15','M','botyquqzpbi:225930G39FimagenGGTJRznoy','pzmtpltzouz:1222853VZIfotoFondoKHHBErirk',17,0,NULL,NULL),(18,'F05952327','rkenningleyh@mozilla.com','q6ToBwq','Jqurzntwz5','2022-08-20','M','cqquwgaqesz:479189TW5LimagenRXGUDkkqc','thojfxianbx:069433YJK4fotoFondoDEUXTpfwa',18,0,NULL,NULL),(19,'R98403990','ekillichi@nhs.uk','tVaPAC','Dlouujaqf2','2022-08-04','M','fhvjgkkepak:911805W4LHimagenTRFPPdjpr','jsaktlctqyj:810461XAPGfotoFondoBBSVYorui',19,1,NULL,NULL),(20,'H36102055','ckoubekj@ihg.com','eOWZx7','Oeftpeqdk7','2022-04-15','F','whlcnpbogwj:431891IGQ0imagenAFDSIglwn','xirpvnbelpn:532567YEKGfotoFondoESUJMdlqs',20,1,NULL,NULL),(21,'B10634507','xleadleyk@ezinearticles.com','uynxaUvpJ3pS','Qyupexdb32','2022-05-16','F','glkswlimbpd:375051H6ZAimagenKMVCUndlj','zwspihfobkv:922547UQYDfotoFondoRZPYUneka',21,0,NULL,NULL),(22,'C04060739','mkamiyamal@biblegateway.com','IbOyMe','Hkabgfnt44','2022-03-03','F','qewswcuvvpm:7530703LTLimagenOGWPDkqzc','itqfahiptvf:048992YAGQfotoFondoKIKWXqlhz',22,0,NULL,NULL),(23,'Y60202277','cdugganm@toplist.cz','nOhdy7ZT','Cszzrxlqj1','2022-04-22','M','suvmazivfxg:9496045C6TimagenPIRQNjhkr','xyyrjiwcwcq:657929DWERfotoFondoFRBOZkjit',23,0,NULL,NULL),(24,'B79047649','wburganen@skyrock.com','H4SE87l','Yvtsfolv89','2022-04-16','M','yaoqlfabyle:199883V5KZimagenAWCZDhmgh','qmzackgqfss:3010042YYAfotoFondoHYQVPicex',24,1,NULL,NULL),(25,'V87868541','mreeno@studiopress.com','BbdliFYzBEc','Hefovpgiq1','2022-11-30','M','vxqhojdqbjd:7013449B5FimagenEZWJCrnsz','qviuujnygvv:480364SEMDfotoFondoEVBOArwnu',25,1,NULL,NULL),(26,'P84016098','vlecointep@zdnet.com','2jHW8H','Lcjwrgtfg9','2022-08-24','M','toyhicliwud:06228342V2imagenGEPCIwmcq','tvrsiqccsrz:255093JDJDfotoFondoSLHAEvflh',26,1,NULL,NULL),(27,'L28016499','rcuddehayq@cdbaby.com','KHFSiAppU2k','Hagmmqkpv1','2022-07-13','M','tvqnttczgoy:361650OYN3imagenORBZUlcka','chzfakrvars:805740QOK4fotoFondoWMNKBscpt',27,0,NULL,NULL),(28,'M97823211','tbranscomber@hud.gov','itksq1gmu','Rkyoqega63','2022-12-11','F','wltlytsrzbv:346935GYBNimagenNSJNGemdm','bwdndoqkimr:95825645XQfotoFondoQOXIGplek',28,1,NULL,NULL),(29,'S45762206','jslaghts@addthis.com','Oaks10r','Hqfojzvbi7','2022-07-15','F','scrwckxrvrt:5746704TSQimagenAYZKEvzoe','htgxtcwevaj:830051GOG3fotoFondoDGRZYyqnt',29,0,NULL,NULL),(30,'G01393381','ffrantzenit@yahoo.com','ntPfVWK5aPHL','Paghfcdt45','2022-08-03','F','qanmtgshpip:308263YC08imagenMUXTQkjwc','uilxxdktaio:4812098LD2fotoFondoQEEWNoqek',30,1,NULL,NULL),(31,'Y25549809','awildboreu@businesswire.com','dAlEFS','Lhhtpmxqd3','2022-04-08','F','gahomdkyohf:5298754OVTimagenBUXHLgjhr','xkcrgcfzzhv:523398DFNWfotoFondoDYMSLfwlp',31,0,NULL,NULL),(32,'D97378276','ewortv@cisco.com','wVTdKcaUNypp','Rlfxtpmdk7','2022-10-06','F','sqrfezowniz:718214QHZLimagenBUXLVbmhi','yxcjpxqwllt:883318FVLSfotoFondoBAOBLryjo',32,0,NULL,NULL),(33,'M23365668','mhappertw@nsw.gov.au','CCXr23sC','Rvebjnver9','2022-06-19','F','lelqfkohipn:055711IKUZimagenYICYJqkxa','zzisjntvgbg:615848OB8DfotoFondoLLBSNaxxr',33,1,NULL,NULL),(34,'U58270510','mrodgmanx@e-recht24.de','hTpeEZ','Hciypmns33','2022-02-20','M','bmxszfonlpu:43436973RAimagenTEIORjauq','tiihiwjaors:747378X58IfotoFondoLICQKgrje',34,1,NULL,NULL),(35,'D34098237','rlyddiardy@phpbb.com','v6Fu7TB','Lvgkqmheu6','2022-07-27','F','bstixlhllvf:551811O84FimagenEQVXYsiva','gcftfyrrjxo:410910U661fotoFondoMKQGXdjhu',35,1,NULL,NULL),(36,'N67506173','sslatcherz@delicious.com','3nfFi4P','Jgsalybu32','2022-07-06','M','ndssoictjwy:537888PUBMimagenRZDYSwwte','juynmcgctzq:1270791LXNfotoFondoSUJFUjqej',36,1,NULL,NULL),(37,'S04029769','cnanson10@scribd.com','4Ch64sSoIk','Srinwimvn4','2022-07-18','M','umwtjqsnlii:918062R21IimagenNQGHMofgy','wvuqrosziea:952207JGKMfotoFondoJXQYOuckb',37,0,NULL,NULL),(38,'J30994012','relderton11@instagram.com','rFK5VrbAvvW','Rslqgqsb53','2022-08-04','F','lnylkpkovbf:378475SOCVimagenZYOYMhvak','lxprajsusle:141132CT79fotoFondoYDURBpecy',38,0,NULL,NULL),(39,'R27069128','minstone12@w3.org','yWgkS9I8Q','Welokowma3','2022-01-22','M','ptjksrvmoee:0355893CFJimagenDIHFEqesx','ulskryowqqu:7970592RV3fotoFondoUNFDOeouu',39,1,NULL,NULL),(40,'D90367256','ledgecombe13@altervista.org','0vyahiTvMhNd','Qihjqenqk0','2022-07-03','F','lcylaztqxsc:062296N7LSimagenXRGTFlsmc','wmzxuhklvzp:927455W2V5fotoFondoJKUBCkjbx',40,1,NULL,NULL),(41,'CPL','carlos@centopyme.com','12345','pepe','1961-01-25','M',NULL,NULL,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_has_albumes`
--

DROP TABLE IF EXISTS `usuarios_has_albumes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_has_albumes` (
  `Propietario_id` int NOT NULL,
  `albumes_id` int NOT NULL,
  PRIMARY KEY (`Propietario_id`,`albumes_id`),
  KEY `fk_Usuarios_has_albumes_albumes1_idx` (`albumes_id`),
  KEY `fk_Usuarios_has_albumes_Usuarios1_idx` (`Propietario_id`),
  CONSTRAINT `fk_Usuarios_has_albumes_albumes1` FOREIGN KEY (`albumes_id`) REFERENCES `albumes` (`id`),
  CONSTRAINT `fk_Usuarios_has_albumes_Usuarios1` FOREIGN KEY (`Propietario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_has_albumes`
--

LOCK TABLES `usuarios_has_albumes` WRITE;
/*!40000 ALTER TABLE `usuarios_has_albumes` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_has_albumes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-17 18:22:14
