-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: test_3
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `budget` double DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `est_end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'ABC','aaaaaasas ',358000,'2003-01-03',NULL,'2017-01-03'),(2,'QBC_1','asasasadas ',358500,'2003-01-07',NULL,'2017-01-04'),(3,'CAC','sdasdasdasd ',359000,'2003-01-11',NULL,'2017-01-05'),(4,'ASA',' asdasdasdasd',359500,'2005-05-07',NULL,'2017-01-06'),(5,'AAA','adsasdasda ',360000,'2005-03-07',NULL,'2017-01-07'),(6,'A&A','asdasdasdasd ',360500,'2007-05-01',NULL,'2017-01-08'),(7,'B&AS','asdasdasd',361000,'2007-05-03',NULL,'2017-01-09'),(8,'AVB','asdasdasd',361500,'2007-05-04',NULL,'2017-01-10'),(9,'AVB','asdasdasd',361500,'2007-05-04',NULL,'2017-01-10'),(10,'AQX','asdasdasd ',362000,'2007-05-05',NULL,'2017-01-11'),(11,'ASA1','asdasdasd ',362500,'2007-05-06',NULL,'2017-01-12'),(12,'AKJ','asdasdasd ',363000,'2007-05-07',NULL,'2017-01-13'),(13,'AVB','asdasdasd',361500,'2007-05-04',NULL,'2017-01-10'),(14,'AQX','asdasdasd ',362000,'2007-05-05',NULL,'2017-01-11'),(15,'ASA1','asdasdasd ',362500,'2007-05-06',NULL,'2017-01-12'),(16,'AKJ','asdasdasd ',363000,'2007-05-07',NULL,'2017-01-13'),(17,'AKA1','asdasdasd ',363500,'2007-05-08',NULL,'2017-01-14'),(18,'AKO','asdasdasd ',364000,'2007-05-09',NULL,'2017-01-15'),(19,'AKH3','asdasdasd ',364500,'2007-05-10',NULL,'2017-01-16'),(20,'AKJ5','asdasdasd ',365000,'2007-05-11',NULL,'2017-01-17'),(21,'AKJ7','adasdasd ',365500,'2007-05-12',NULL,'2017-01-18'),(22,'BHA3','sadasdasd ',366000,'2007-05-13',NULL,'2017-01-19');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-12 13:46:25
