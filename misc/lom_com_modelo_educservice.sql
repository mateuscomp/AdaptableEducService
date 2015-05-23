CREATE DATABASE  IF NOT EXISTS `lom` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `lom`;
-- MySQL dump 10.13  Distrib 5.5.43, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: lom
-- ------------------------------------------------------
-- Server version	5.5.43-0ubuntu0.14.04.1

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
-- Table structure for table `entity`
--

DROP TABLE IF EXISTS `entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL DEFAULT '0',
  `entityType_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity`
--

LOCK TABLES `entity` WRITE;
/*!40000 ALTER TABLE `entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entityType`
--

DROP TABLE IF EXISTS `entityType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entityType` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL DEFAULT '0',
  `namespace` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entityType`
--

LOCK TABLES `entityType` WRITE;
/*!40000 ALTER TABLE `entityType` DISABLE KEYS */;
INSERT INTO `entityType` VALUES (1,0,'br.ufpb.educservice','questaoMultiplaEscolha'),(2,0,'br.ufpb.educservice','exercicio'),(3,0,'br.ufpb.educservice','aluno');
/*!40000 ALTER TABLE `entityType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL DEFAULT '0',
  `entity_id` bigint(20) NOT NULL,
  `propertyType_id` bigint(20) NOT NULL,
  `value` longtext,
  PRIMARY KEY (`id`),
  KEY `fk_property_entity_idx` (`entity_id`),
  KEY `fk_property_propertyType_idx` (`propertyType_id`),
  CONSTRAINT `fk_property_entity` FOREIGN KEY (`entity_id`) REFERENCES `entity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_property_propertyType` FOREIGN KEY (`propertyType_id`) REFERENCES `propertyType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propertyType`
--

DROP TABLE IF EXISTS `propertyType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `propertyType` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL DEFAULT '0',
  `sequence` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `configuration` longtext,
  `entityType_id` bigint(20) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_attributeType_entityType_idx` (`entityType_id`),
  CONSTRAINT `fk_attributeType_entityType` FOREIGN KEY (`entityType_id`) REFERENCES `entityType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propertyType`
--

LOCK TABLES `propertyType` WRITE;
/*!40000 ALTER TABLE `propertyType` DISABLE KEYS */;
INSERT INTO `propertyType` VALUES (1,0,'1','id','{\"mandatory\" : true, \"minvalue\": 0}',1,'INTEGER'),(2,0,'2','enunciado','{\"mandatory\" : true}',1,'TEXT'),(3,0,'3','alternativaCorreta','{\"mandatory\" : true, \"minvalue\" : 0, \"maxvalue\" : 4}',1,'INTEGER'),(4,0,'4','alternativaA','{\"mandatory\" : true}',1,'TEXT'),(5,0,'5','alternativaB','{\"mandatory\" : true}',1,'TEXT'),(6,0,'6','alternativaC','{\"mandatory\" : true}',1,'TEXT'),(7,0,'7','alternativaD','{\"mandatory\" : true}',1,'TEXT'),(8,0,'8','alternativaE','{\"mandatory\" : true}',1,'TEXT'),(9,0,'1','id','{\"mandatory\" : true, \"minvalue\" : 0}',3,'INTEGER'),(10,0,'2','nome','{\"mandatory\" : true}',3,'TEXT'),(11,0,'3','login','{\"mandatory\" : true}',3,'TEXT'),(12,0,'4','senha','{\"mandatory\" : true}',3,'PASSWORD'),(13,0,'9','idExercicio','',1,'INTEGER'),(14,0,'1','id','{\"mandatory\" : true, \"minvalue\" : 0}',2,'INTEGER'),(15,0,'2','palavraChave01','',2,'TEXT'),(16,0,'3','palavraChave02','',2,'TEXT'),(17,0,'4','palavraChave03','',2,'TEXT'),(18,0,'5','palavraChave04','',2,'TEXT'),(19,0,'6','palavraChave05','',2,'TEXT');
/*!40000 ALTER TABLE `propertyType` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-23 11:38:45
