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
-- Table structure for table `studijski_program`
--

DROP TABLE IF EXISTS `studijski_program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `studijski_program` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(128) NOT NULL,
  `obrisan` bit(1) NOT NULL,
  `opis` varchar(128) NOT NULL,
  `fakultet_id` bigint(20) DEFAULT NULL,
  `rektor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK303wuewako66hti92rcv4a9mh` (`fakultet_id`),
  KEY `FKrk66ull4jfutgfnttjqd7clrm` (`rektor_id`),
  CONSTRAINT `FK303wuewako66hti92rcv4a9mh` FOREIGN KEY (`fakultet_id`) REFERENCES `fakultet` (`id`),
  CONSTRAINT `FKrk66ull4jfutgfnttjqd7clrm` FOREIGN KEY (`rektor_id`) REFERENCES `nastavnik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studijski_program`
--

LOCK TABLES `studijski_program` WRITE;
/*!40000 ALTER TABLE `studijski_program` DISABLE KEYS */;
INSERT INTO `studijski_program` VALUES (1,'naziv_1',_binary '\0','opis_1',1,1),(2,'naziv_2',_binary '\0','opis_2',2,2),(3,'naziv_3',_binary '\0','opis_3',3,3);
/*!40000 ALTER TABLE `studijski_program` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-05 23:21:39
