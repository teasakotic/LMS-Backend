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
-- Table structure for table `realizacija_predmeta`
--

DROP TABLE IF EXISTS `realizacija_predmeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `realizacija_predmeta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `godina_studija_id` bigint(20) DEFAULT NULL,
  `predmet_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpij79o9rlod59kvoxw132u5vw` (`godina_studija_id`),
  KEY `FKrw6tx0pbaevbvs89psuqfqijx` (`predmet_id`),
  CONSTRAINT `FKpij79o9rlod59kvoxw132u5vw` FOREIGN KEY (`godina_studija_id`) REFERENCES `godina_studija` (`id`),
  CONSTRAINT `FKrw6tx0pbaevbvs89psuqfqijx` FOREIGN KEY (`predmet_id`) REFERENCES `predmet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `realizacija_predmeta`
--

LOCK TABLES `realizacija_predmeta` WRITE;
/*!40000 ALTER TABLE `realizacija_predmeta` DISABLE KEYS */;
INSERT INTO `realizacija_predmeta` VALUES (1,1,1),(2,2,2),(3,3,3);
/*!40000 ALTER TABLE `realizacija_predmeta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-05 23:21:35
