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
-- Table structure for table `registrovani_korisnik`
--

DROP TABLE IF EXISTS `registrovani_korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registrovani_korisnik` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(128) NOT NULL,
  `lozinka` varchar(128) NOT NULL,
  `username` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jx8k01bi33jh38wj29q3guje8` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrovani_korisnik`
--

LOCK TABLES `registrovani_korisnik` WRITE;
/*!40000 ALTER TABLE `registrovani_korisnik` DISABLE KEYS */;
INSERT INTO `registrovani_korisnik` VALUES (1,'admin@gmail.com','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','admin_1'),(2,'admin@email_2','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','admin_2'),(3,'admin@email_3','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','admin_3'),(4,'admin@email_4','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','admin_4'),(5,'admin@email_5','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','admin_5'),(6,'admin@email_6','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','admin_6'),(7,'admin@email_7','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','admin_7'),(8,'admin@email_8','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','admin_8'),(9,'admin@email_9','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','admin_9'),(10,'admin@email_10','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','admin_10'),(11,'staff@email_1','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','staff_1'),(12,'staff@email_2','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','staff_2'),(13,'staff@email_3','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','staff_3'),(14,'staff@email_4','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','staff_4'),(15,'staff@email_5','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','staff_5'),(16,'staff@email_6','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','staff_6'),(17,'staff@email_7','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','staff_7'),(18,'staff@email_8','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','staff_8'),(19,'staff@email_9','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','staff_9'),(20,'staff@email_10','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','staff_10'),(21,'nastavnik@email_1','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','nastavnik_1'),(22,'nastavnik@email_2','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','nastavnik_2'),(23,'nastavnik@email_3','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','nastavnik_3'),(24,'nastavnik@email_4','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','nastavnik_4'),(25,'nastavnik@email_5','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','nastavnik_5'),(26,'nastavnik@email_6','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','nastavnik_6'),(27,'nastavnik@email_7','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','nastavnik_7'),(28,'nastavnik@email_8','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','nastavnik_8'),(29,'nastavnik@email_9','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','nastavnik_9'),(30,'nastavnik@email_10','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','nastavnik_10'),(31,'student@email_1','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','student_1'),(32,'student@email_2','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','student_2'),(33,'student@email_3','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','student_3'),(34,'student@email_4','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','student_4'),(35,'student@email_5','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','student_5'),(36,'student@email_6','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','student_6'),(37,'student@email_7','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','student_7'),(38,'student@email_8','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','student_8'),(39,'student@email_9','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','student_9'),(40,'student@email_10','{bcrypt}$2a$10$u5nBomxHtyUvodCcewSIgOrKtcW5wTzOZng1yOLDVzkHC5kaUNFeC','student_10');
/*!40000 ALTER TABLE `registrovani_korisnik` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-05 23:21:20
