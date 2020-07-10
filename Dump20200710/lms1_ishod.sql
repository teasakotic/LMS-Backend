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
-- Table structure for table `ishod`
--

DROP TABLE IF EXISTS `ishod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ishod` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nedelja` int(11) NOT NULL,
  `obrisan` bit(1) NOT NULL,
  `opis` varchar(128) NOT NULL,
  `putanja_do_ikonice` varchar(128) DEFAULT NULL,
  `predmet_id` bigint(20) DEFAULT NULL,
  `realizacija_predmeta_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKshna04judhuvrpku4w60urgfv` (`predmet_id`),
  KEY `FKj092o6h2e0x961cs9bgifq7sd` (`realizacija_predmeta_id`),
  CONSTRAINT `FKj092o6h2e0x961cs9bgifq7sd` FOREIGN KEY (`realizacija_predmeta_id`) REFERENCES `realizacija_predmeta` (`id`),
  CONSTRAINT `FKshna04judhuvrpku4w60urgfv` FOREIGN KEY (`predmet_id`) REFERENCES `predmet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ishod`
--

LOCK TABLES `ishod` WRITE;
/*!40000 ALTER TABLE `ishod` DISABLE KEYS */;
/*!40000 ALTER TABLE `ishod` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-10 18:50:29
