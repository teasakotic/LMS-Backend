-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lms1
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fakultet`
--

DROP TABLE IF EXISTS `fakultet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fakultet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(128) NOT NULL,
  `opis` varchar(150) NOT NULL,
  `adresa_id` bigint(20) DEFAULT NULL,
  `dekan_id` bigint(20) DEFAULT NULL,
  `univerzitet_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKny458ljsoekngf1rrtexkl5vg` (`adresa_id`),
  KEY `FKop18q47667vp5icvvh0qr8tjo` (`dekan_id`),
  KEY `FKc9lc5sekwpb19qpobc7eegjpn` (`univerzitet_id`),
  CONSTRAINT `FKc9lc5sekwpb19qpobc7eegjpn` FOREIGN KEY (`univerzitet_id`) REFERENCES `univerzitet` (`id`),
  CONSTRAINT `FKny458ljsoekngf1rrtexkl5vg` FOREIGN KEY (`adresa_id`) REFERENCES `adresa` (`id`),
  CONSTRAINT `FKop18q47667vp5icvvh0qr8tjo` FOREIGN KEY (`dekan_id`) REFERENCES `nastavnik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fakultet`
--

LOCK TABLES `fakultet` WRITE;
/*!40000 ALTER TABLE `fakultet` DISABLE KEYS */;
INSERT INTO `fakultet` VALUES (1,'ime_1','opis_1',1,1,1),(2,'ime_2','opis_2',2,2,2),(3,'ime_3','opis_3',3,3,3);
/*!40000 ALTER TABLE `fakultet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-05 23:21:38
