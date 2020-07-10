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
-- Table structure for table `nastavnik_na_realizaciji`
--

DROP TABLE IF EXISTS `nastavnik_na_realizaciji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nastavnik_na_realizaciji` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `broj_casova` int(11) NOT NULL,
  `licni_podaci_id` bigint(20) DEFAULT NULL,
  `nastavnik_id` bigint(20) DEFAULT NULL,
  `realizacija_predmeta_id` bigint(20) DEFAULT NULL,
  `tip_nastave_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKokhvuwkg9244vl3a83tmg60q2` (`licni_podaci_id`),
  KEY `FKnevmktxs4agqf99pqqqlaeuhg` (`nastavnik_id`),
  KEY `FKlt1o46t5hb12amfcj1q362kqd` (`realizacija_predmeta_id`),
  KEY `FKo7x2h84alaxk70bvj5s7to3iu` (`tip_nastave_id`),
  CONSTRAINT `FKlt1o46t5hb12amfcj1q362kqd` FOREIGN KEY (`realizacija_predmeta_id`) REFERENCES `realizacija_predmeta` (`id`),
  CONSTRAINT `FKnevmktxs4agqf99pqqqlaeuhg` FOREIGN KEY (`nastavnik_id`) REFERENCES `nastavnik` (`id`),
  CONSTRAINT `FKo7x2h84alaxk70bvj5s7to3iu` FOREIGN KEY (`tip_nastave_id`) REFERENCES `tip_nastave` (`id`),
  CONSTRAINT `FKokhvuwkg9244vl3a83tmg60q2` FOREIGN KEY (`licni_podaci_id`) REFERENCES `licni_podaci` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nastavnik_na_realizaciji`
--

LOCK TABLES `nastavnik_na_realizaciji` WRITE;
/*!40000 ALTER TABLE `nastavnik_na_realizaciji` DISABLE KEYS */;
INSERT INTO `nastavnik_na_realizaciji` VALUES (1,100,1,1,1,1),(2,200,2,2,2,2),(3,300,3,3,3,1);
/*!40000 ALTER TABLE `nastavnik_na_realizaciji` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-05 23:21:17
