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
-- Table structure for table `evaluacija_znanja`
--

DROP TABLE IF EXISTS `evaluacija_znanja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `evaluacija_znanja` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bodovi` int(11) NOT NULL,
  `trajanjeuminutima` int(11) NOT NULL,
  `vreme_pocetka` date DEFAULT NULL,
  `vreme_zavrsetka` date DEFAULT NULL,
  `realizacija_predmeta_id` bigint(20) DEFAULT NULL,
  `tip_evaluacije_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmicppx3e9v4gl9wn4i6l46v7p` (`realizacija_predmeta_id`),
  KEY `FKrld48go4m6p9x3s0baevu51un` (`tip_evaluacije_id`),
  CONSTRAINT `FKmicppx3e9v4gl9wn4i6l46v7p` FOREIGN KEY (`realizacija_predmeta_id`) REFERENCES `realizacija_predmeta` (`id`),
  CONSTRAINT `FKrld48go4m6p9x3s0baevu51un` FOREIGN KEY (`tip_evaluacije_id`) REFERENCES `tip_evaluacije` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluacija_znanja`
--

LOCK TABLES `evaluacija_znanja` WRITE;
/*!40000 ALTER TABLE `evaluacija_znanja` DISABLE KEYS */;
INSERT INTO `evaluacija_znanja` VALUES (1,20,150,'2019-01-05','2019-04-17',1,1),(2,40,200,'2019-04-17','2019-04-18',2,2),(3,60,120,'2019-05-17','2019-06-17',3,3);
/*!40000 ALTER TABLE `evaluacija_znanja` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-05 23:21:18
