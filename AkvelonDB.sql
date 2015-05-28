CREATE DATABASE  IF NOT EXISTS `denisenko_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `denisenko_test`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: akvelon
-- ------------------------------------------------------
-- Server version	5.6.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bicycle_storage`
--

DROP TABLE IF EXISTS `bicycle_storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bicycle_storage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturer` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `gender` char(1) NOT NULL,
  `amount` int(11) NOT NULL,
  `last_check` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bicycle_storage`
--

LOCK TABLES `bicycle_storage` WRITE;
/*!40000 ALTER TABLE `bicycle_storage` DISABLE KEYS */;
INSERT INTO `bicycle_storage` VALUES (1,'Ghost','Powerkid girl','W',10,'2015-04-25'),(2,'Spelli','FX-7000','B',5,'2015-05-19'),(3,'Ghost','Powerkid boy','M',6,'2015-03-08'),(4,'Cannondale','Quick CX 5','M',5,'2015-05-17'),(5,'Avanti','Pirate','M',12,'2015-05-25');
/*!40000 ALTER TABLE `bicycle_storage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

CREATE USER 'denisenko'@'localhost' IDENTIFIED BY '12345';
GRANT ALL PRIVILEGES ON denisenko_test.bicycle_storage TO 'denisenko'@'localhost';
-- Dump completed on 2015-05-26 12:43:47
