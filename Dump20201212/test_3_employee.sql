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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `supervisor` int DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Nimal1',50000,'2020-10-06','17/V1','Bambalapitiya1','Colombo1',NULL,NULL),(2,'Nimal2',50000,'2020-10-01','17/V2','Bambalapitiya2','Colombo2',NULL,NULL),(3,'Nimal3',50000,'2020-09-26','17/V3','Bambalapitiya3','Colombo3',NULL,NULL),(4,'Nimal4',50000,'2020-09-21','17/V4','Bambalapitiya4','Colombo4',NULL,NULL),(5,'Nimal5',50000,'2020-10-10','17/V5','Bambalapitiya0','Colombo0',NULL,NULL),(6,'Nimal6',50000,'2020-10-06','17/V6','Bambalapitiya1','Colombo1',NULL,NULL),(7,'Nimal7',50000,'2020-10-01','17/V7','Bambalapitiya2','Colombo2',NULL,NULL),(8,'Nimal8',50000,'2020-09-26','17/V8','Bambalapitiya3','Colombo3',NULL,NULL),(9,'Nimal9',50000,'2020-09-21','17/V9','Bambalapitiya4','Colombo4',NULL,NULL),(10,'Nimal10',50000,'2020-10-10','17/V10','Bambalapitiya0','Colombo0',NULL,NULL),(11,'Nimal11',50000,'2020-10-06','17/V11','Bambalapitiya1','Colombo1',NULL,NULL),(12,'Nimal12',50000,'2020-10-01','17/V12','Bambalapitiya2','Colombo2',NULL,NULL),(13,'Nimal13',50000,'2020-09-26','17/V13','Bambalapitiya3','Colombo3',NULL,NULL),(14,'Nimal14',50000,'2020-09-21','17/V14','Bambalapitiya4','Colombo4',NULL,NULL),(15,'Nimal15',50000,'2020-10-10','17/V15','Bambalapitiya0','Colombo0',NULL,NULL),(16,'Nimal16',50000,'2020-10-06','17/V16','Bambalapitiya1','Colombo1',NULL,NULL),(17,'Nimal17',50000,'2020-10-01','17/V17','Bambalapitiya2','Colombo2',NULL,NULL),(18,'Nimal18',50000,'2020-09-26','17/V18','Bambalapitiya3','Colombo3',NULL,NULL),(19,'Nimal19',50000,'2020-09-21','17/V19','Bambalapitiya4','Colombo4',NULL,NULL),(20,'Nimal20',50000,'2020-10-10','17/V20','Bambalapitiya0','Colombo0',NULL,NULL),(21,'Nimal21',50000,'2020-10-06','17/V21','Bambalapitiya1','Colombo1',NULL,NULL),(22,'Nimal22',50000,'2020-10-01','17/V22','Bambalapitiya2','Colombo2',NULL,NULL),(23,'Nimal23',50000,'2020-09-26','17/V23','Bambalapitiya3','Colombo3',NULL,NULL),(24,'Nimal24',50000,'2020-09-21','17/V24','Bambalapitiya4','Colombo4',NULL,NULL),(25,'Nimal25',50000,'2020-10-10','17/V25','Bambalapitiya0','Colombo0',NULL,NULL),(26,'Nimal26',50000,'2020-10-06','17/V26','Bambalapitiya1','Colombo1',NULL,NULL),(27,'Nimal27',50000,'2020-10-01','17/V27','Bambalapitiya2','Colombo2',NULL,NULL),(28,'Nimal28',50000,'2020-09-26','17/V28','Bambalapitiya3','Colombo3',NULL,NULL),(29,'Nimal29',50000,'2020-09-21','17/V29','Bambalapitiya4','Colombo4',NULL,NULL),(30,'Nimal30',50000,'2020-10-10','17/V30','Bambalapitiya0','Colombo0',NULL,NULL),(31,'Nimal31',50000,'2020-10-06','17/V31','Bambalapitiya1','Colombo1',NULL,NULL),(32,'Nimal32',50000,'2020-10-01','17/V32','Bambalapitiya2','Colombo2',NULL,NULL),(33,'Nimal33',50000,'2020-09-26','17/V33','Bambalapitiya3','Colombo3',NULL,NULL),(34,'Nimal34',50000,'2020-09-21','17/V34','Bambalapitiya4','Colombo4',NULL,NULL),(35,'Nimal35',50000,'2020-10-10','17/V35','Bambalapitiya0','Colombo0',NULL,NULL),(36,'Nimal36',50000,'2020-10-06','17/V36','Bambalapitiya1','Colombo1',NULL,NULL),(37,'Nimal37',50000,'2020-10-01','17/V37','Bambalapitiya2','Colombo2',NULL,NULL),(38,'Nimal38',50000,'2020-09-26','17/V38','Bambalapitiya3','Colombo3',NULL,NULL),(39,'Nimal39',50000,'2020-09-21','17/V39','Bambalapitiya4','Colombo4',NULL,NULL),(40,'Nimal40',50000,'2020-10-10','17/V40','Bambalapitiya0','Colombo0',NULL,NULL),(41,'Nimal41',50000,'2020-10-06','17/V41','Bambalapitiya1','Colombo1',NULL,NULL),(42,'Nimal42',50000,'2020-10-01','17/V42','Bambalapitiya2','Colombo2',NULL,NULL),(43,'Nimal43',50000,'2020-09-26','17/V43','Bambalapitiya3','Colombo3',NULL,NULL),(44,'Nimal44',50000,'2020-09-21','17/V44','Bambalapitiya4','Colombo4',NULL,NULL),(45,'Nimal45',50000,'2020-10-10','17/V45','Bambalapitiya0','Colombo0',NULL,NULL),(46,'Nimal46',50000,'2020-10-06','17/V46','Bambalapitiya1','Colombo1',NULL,NULL),(47,'Nimal47',50000,'2020-10-01','17/V47','Bambalapitiya2','Colombo2',NULL,NULL),(48,'Nimal48',50000,'2020-09-26','17/V48','Bambalapitiya3','Colombo3',NULL,NULL),(49,'Nimal49',50000,'2020-09-21','17/V49','Bambalapitiya4','Colombo4',NULL,NULL),(50,'Nimal50',50000,'2020-10-10','17/V50','Bambalapitiya0','Colombo0',NULL,NULL),(51,'Nimal51',50000,'2020-10-06','17/V51','Bambalapitiya1','Colombo1',NULL,NULL),(52,'Nimal52',50000,'2020-10-01','17/V52','Bambalapitiya2','Colombo2',NULL,NULL),(53,'Nimal53',50000,'2020-09-26','17/V53','Bambalapitiya3','Colombo3',NULL,NULL),(54,'Nimal54',50000,'2020-09-21','17/V54','Bambalapitiya4','Colombo4',NULL,NULL),(55,'Nimal55',50000,'2020-10-10','17/V55','Bambalapitiya0','Colombo0',NULL,NULL),(56,'Nimal56',50000,'2020-10-06','17/V56','Bambalapitiya1','Colombo1',NULL,NULL),(57,'Nimal57',50000,'2020-10-01','17/V57','Bambalapitiya2','Colombo2',NULL,NULL),(58,'Nimal58',50000,'2020-09-26','17/V58','Bambalapitiya3','Colombo3',NULL,NULL),(59,'Nimal59',50000,'2020-09-21','17/V59','Bambalapitiya4','Colombo4',NULL,NULL),(60,'Nimal60',50000,'2020-10-10','17/V60','Bambalapitiya0','Colombo0',NULL,NULL),(61,'Nimal61',50000,'2020-10-06','17/V61','Bambalapitiya1','Colombo1',NULL,NULL),(62,'Nimal62',50000,'2020-10-01','17/V62','Bambalapitiya2','Colombo2',NULL,NULL),(63,'Nimal63',50000,'2020-09-26','17/V63','Bambalapitiya3','Colombo3',NULL,NULL),(64,'Nimal64',50000,'2020-09-21','17/V64','Bambalapitiya4','Colombo4',NULL,NULL),(65,'Nimal65',50000,'2020-10-10','17/V65','Bambalapitiya0','Colombo0',NULL,NULL),(66,'Nimal66',50000,'2020-10-06','17/V66','Bambalapitiya1','Colombo1',NULL,NULL),(67,'Nimal67',50000,'2020-10-01','17/V67','Bambalapitiya2','Colombo2',NULL,NULL),(68,'Nimal68',50000,'2020-09-26','17/V68','Bambalapitiya3','Colombo3',NULL,NULL),(69,'Nimal69',50000,'2020-09-21','17/V69','Bambalapitiya4','Colombo4',NULL,NULL),(70,'Nimal70',50000,'2020-10-10','17/V70','Bambalapitiya0','Colombo0',NULL,NULL),(71,'Nimal71',50000,'2020-10-06','17/V71','Bambalapitiya1','Colombo1',NULL,NULL),(72,'Nimal72',50000,'2020-10-01','17/V72','Bambalapitiya2','Colombo2',NULL,NULL),(73,'Nimal73',50000,'2020-09-26','17/V73','Bambalapitiya3','Colombo3',NULL,NULL),(74,'Nimal74',50000,'2020-09-21','17/V74','Bambalapitiya4','Colombo4',NULL,NULL),(75,'Nimal75',50000,'2020-10-10','17/V75','Bambalapitiya0','Colombo0',NULL,NULL),(76,'Nimal76',50000,'2020-10-06','17/V76','Bambalapitiya1','Colombo1',NULL,NULL),(77,'Nimal77',50000,'2020-10-01','17/V77','Bambalapitiya2','Colombo2',NULL,NULL),(78,'Nimal78',50000,'2020-09-26','17/V78','Bambalapitiya3','Colombo3',NULL,NULL),(79,'Nimal79',50000,'2020-09-21','17/V79','Bambalapitiya4','Colombo4',NULL,NULL),(80,'Nimal80',50000,'2020-10-10','17/V80','Bambalapitiya0','Colombo0',NULL,NULL),(81,'Nimal81',50000,'2020-10-06','17/V81','Bambalapitiya1','Colombo1',NULL,NULL),(82,'Nimal82',50000,'2020-10-01','17/V82','Bambalapitiya2','Colombo2',NULL,NULL),(83,'Nimal83',50000,'2020-09-26','17/V83','Bambalapitiya3','Colombo3',NULL,NULL),(84,'Nimal84',50000,'2020-09-21','17/V84','Bambalapitiya4','Colombo4',NULL,NULL),(85,'Nimal85',50000,'2020-10-10','17/V85','Bambalapitiya0','Colombo0',NULL,NULL),(86,'Nimal86',50000,'2020-10-06','17/V86','Bambalapitiya1','Colombo1',NULL,NULL),(87,'Nimal87',50000,'2020-10-01','17/V87','Bambalapitiya2','Colombo2',NULL,NULL),(88,'Nimal88',50000,'2020-09-26','17/V88','Bambalapitiya3','Colombo3',NULL,NULL),(89,'Nimal89',50000,'2020-09-21','17/V89','Bambalapitiya4','Colombo4',NULL,NULL),(90,'Nimal90',50000,'2020-10-10','17/V90','Bambalapitiya0','Colombo0',NULL,NULL),(91,'Nimal91',50000,'2020-10-06','17/V91','Bambalapitiya1','Colombo1',NULL,NULL),(92,'Nimal92',50000,'2020-10-01','17/V92','Bambalapitiya2','Colombo2',NULL,NULL),(93,'Nimal93',50000,'2020-09-26','17/V93','Bambalapitiya3','Colombo3',NULL,NULL),(94,'Nimal94',50000,'2020-09-21','17/V94','Bambalapitiya4','Colombo4',NULL,NULL),(95,'Nimal95',50000,'2020-10-10','17/V95','Bambalapitiya0','Colombo0',NULL,NULL),(96,'Nimal96',50000,'2020-10-06','17/V96','Bambalapitiya1','Colombo1',NULL,NULL),(97,'Nimal97',50000,'2020-10-01','17/V97','Bambalapitiya2','Colombo2',NULL,NULL),(98,'Nimal98',50000,'2020-09-26','17/V98','Bambalapitiya3','Colombo3',NULL,NULL),(99,'Nimal99',50000,'2020-09-21','17/V99','Bambalapitiya4','Colombo4',NULL,NULL),(100,'Nimal100',50000,'2020-10-10','17/V100','Bambalapitiya0','Colombo0',NULL,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
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
