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
-- Table structure for table `disertacija`
--

DROP TABLE IF EXISTS `disertacija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `disertacija` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datum_aplikacije` datetime NOT NULL,
  `datum_odbrane` datetime NOT NULL,
  `naslov` varchar(128) NOT NULL,
  `datoteka_za_disertaciju_id` bigint(20) DEFAULT NULL,
  `mentor_id` bigint(20) DEFAULT NULL,
  `student_na_godini_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr3lefts9gd2s73746t0oon8jv` (`datoteka_za_disertaciju_id`),
  KEY `FKnq8eeotvhl5wontti75nk6hit` (`mentor_id`),
  KEY `FK6njaytjqh0mth4sslh8s5golr` (`student_na_godini_id`),
  CONSTRAINT `FK6njaytjqh0mth4sslh8s5golr` FOREIGN KEY (`student_na_godini_id`) REFERENCES `student_na_godini` (`id`),
  CONSTRAINT `FKnq8eeotvhl5wontti75nk6hit` FOREIGN KEY (`mentor_id`) REFERENCES `nastavnik` (`id`),
  CONSTRAINT `FKr3lefts9gd2s73746t0oon8jv` FOREIGN KEY (`datoteka_za_disertaciju_id`) REFERENCES `datoteka_za_disertaciju` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disertacija`
--

LOCK TABLES `disertacija` WRITE;
/*!40000 ALTER TABLE `disertacija` DISABLE KEYS */;
INSERT INTO `disertacija` VALUES (1,'2016-04-05 00:00:00','2016-04-09 00:00:00','naslov_1',1,1,1),(2,'2018-04-05 00:00:00','2018-04-05 00:00:00','naslov_2',2,2,2),(3,'2017-04-05 00:00:00','2017-04-05 00:00:00','naslov_3',3,3,3);
/*!40000 ALTER TABLE `disertacija` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-05 23:21:31
