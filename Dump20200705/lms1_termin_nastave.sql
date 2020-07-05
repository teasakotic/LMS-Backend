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
-- Table structure for table `termin_nastave`
--

DROP TABLE IF EXISTS `termin_nastave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `termin_nastave` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dan` varchar(255) NOT NULL,
  `obrisan` bit(1) NOT NULL,
  `vreme_kraja` date NOT NULL,
  `vreme_pocetka` date NOT NULL,
  `realizacija_predmeta_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKasrq9uj8dmfa2dtyycxclwwwu` (`realizacija_predmeta_id`),
  CONSTRAINT `FKasrq9uj8dmfa2dtyycxclwwwu` FOREIGN KEY (`realizacija_predmeta_id`) REFERENCES `realizacija_predmeta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `termin_nastave`
--

LOCK TABLES `termin_nastave` WRITE;
/*!40000 ALTER TABLE `termin_nastave` DISABLE KEYS */;
INSERT INTO `termin_nastave` VALUES (1,'ponedeljak',_binary '\0','2018-12-12','2018-12-12',1),(2,'utorak',_binary '\0','2012-12-06','2012-12-06',2),(3,'sreda',_binary '\0','2012-12-07','2012-12-07',3);
/*!40000 ALTER TABLE `termin_nastave` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-05 23:21:23
