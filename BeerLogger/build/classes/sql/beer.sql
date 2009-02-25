-- MySQL dump 10.11
--
-- Host: localhost    Database: beer
-- ------------------------------------------------------
-- Server version	5.0.67-0ubuntu6

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
-- Table structure for table `Additive`
--

DROP TABLE IF EXISTS `Additive`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Additive` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Additive`
--

LOCK TABLES `Additive` WRITE;
/*!40000 ALTER TABLE `Additive` DISABLE KEYS */;
/*!40000 ALTER TABLE `Additive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AdditiveIngredient`
--

DROP TABLE IF EXISTS `AdditiveIngredient`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `AdditiveIngredient` (
  `id` int(11) NOT NULL auto_increment,
  `quantity` double NOT NULL,
  `additive_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK443C76DDCA917E86` (`additive_id`),
  CONSTRAINT `FK443C76DDCA917E86` FOREIGN KEY (`additive_id`) REFERENCES `Additive` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `AdditiveIngredient`
--

LOCK TABLES `AdditiveIngredient` WRITE;
/*!40000 ALTER TABLE `AdditiveIngredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `AdditiveIngredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Barley`
--

DROP TABLE IF EXISTS `Barley`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Barley` (
  `id` int(11) NOT NULL auto_increment,
  `variety` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Barley`
--

LOCK TABLES `Barley` WRITE;
/*!40000 ALTER TABLE `Barley` DISABLE KEYS */;
/*!40000 ALTER TABLE `Barley` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BarleyIngredient`
--

DROP TABLE IF EXISTS `BarleyIngredient`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `BarleyIngredient` (
  `id` int(11) NOT NULL auto_increment,
  `quantity` double NOT NULL,
  `barley_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK3B7C06FEF6DE19E6` (`barley_id`),
  CONSTRAINT `FK3B7C06FEF6DE19E6` FOREIGN KEY (`barley_id`) REFERENCES `Barley` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `BarleyIngredient`
--

LOCK TABLES `BarleyIngredient` WRITE;
/*!40000 ALTER TABLE `BarleyIngredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `BarleyIngredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Flavoring`
--

DROP TABLE IF EXISTS `Flavoring`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Flavoring` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Flavoring`
--

LOCK TABLES `Flavoring` WRITE;
/*!40000 ALTER TABLE `Flavoring` DISABLE KEYS */;
/*!40000 ALTER TABLE `Flavoring` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FlavoringIngredient`
--

DROP TABLE IF EXISTS `FlavoringIngredient`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `FlavoringIngredient` (
  `id` int(11) NOT NULL auto_increment,
  `quantity` double NOT NULL,
  `flavoring_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKB33D51555A784C6E` (`flavoring_id`),
  CONSTRAINT `FKB33D51555A784C6E` FOREIGN KEY (`flavoring_id`) REFERENCES `Flavoring` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `FlavoringIngredient`
--

LOCK TABLES `FlavoringIngredient` WRITE;
/*!40000 ALTER TABLE `FlavoringIngredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `FlavoringIngredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hop`
--

DROP TABLE IF EXISTS `Hop`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Hop` (
  `id` int(11) NOT NULL auto_increment,
  `alpha` double NOT NULL,
  `application` varchar(255) default NULL,
  `aroma_bitter` varchar(255) default NULL,
  `category` int(11) default NULL,
  `country` varchar(255) default NULL,
  `description` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `storage` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Hop`
--

LOCK TABLES `Hop` WRITE;
/*!40000 ALTER TABLE `Hop` DISABLE KEYS */;
/*!40000 ALTER TABLE `Hop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HopIngredient`
--

DROP TABLE IF EXISTS `HopIngredient`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `HopIngredient` (
  `id` int(11) NOT NULL auto_increment,
  `boilTime` int(11) NOT NULL,
  `pelletLeaf` varchar(255) default NULL,
  `quantity` double NOT NULL,
  `hop_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKF9730ADA37F6F14E` (`hop_id`),
  CONSTRAINT `FKF9730ADA37F6F14E` FOREIGN KEY (`hop_id`) REFERENCES `Hop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `HopIngredient`
--

LOCK TABLES `HopIngredient` WRITE;
/*!40000 ALTER TABLE `HopIngredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `HopIngredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MashSchedule`
--

DROP TABLE IF EXISTS `MashSchedule`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `MashSchedule` (
  `id` int(11) NOT NULL auto_increment,
  `category` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `MashSchedule`
--

LOCK TABLES `MashSchedule` WRITE;
/*!40000 ALTER TABLE `MashSchedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `MashSchedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MashSchedule_MashStep`
--

DROP TABLE IF EXISTS `MashStep`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `MashStep` (
  `id` int(11) NOT NULL auto_increment,
  `MashSchedule_id` int(11) NOT NULL,
  `order` int(11) NOT NULL,
  `waterQuantity` double NOT NULL,
  `temp` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FKC78FFA14E77A3026` (`MashSchedule_id`),
  CONSTRAINT `FKC78FFA14E77A3026` FOREIGN KEY (`MashSchedule_id`) REFERENCES `MashSchedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `MashSchedule_MashStep`
--

LOCK TABLES `MashSchedule_MashStep` WRITE;
/*!40000 ALTER TABLE `MashSchedule_MashStep` DISABLE KEYS */;
/*!40000 ALTER TABLE `MashSchedule_MashStep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Recipe`
--

DROP TABLE IF EXISTS `Recipe`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Recipe` (
  `id` int(11) NOT NULL auto_increment,
  `finalGravity` double NOT NULL,
  `initialGravity` double NOT NULL,
  `name` varchar(255) default NULL,
  `style` enum('AMBER_ALE', 'AMBER_LAGER', 'BARLEY_WINE', 'BELGIAN', 'BITTER', 'BOCK', 'BRITISH_ALE', 'BROWN_ALE', 'DARK_ALE', 'DARK_LAGER', 'GOLDEN_ALE', 'IPA', 'LIGHT_LAGER', 'PALE_ALE', 'PORTER', 'RED_ALE', 'RYE_ALE', 'SCOTTISH_ALE', 'SEASONAL', 'STOUT', 'WHEAT') default NULL,
  `mashSchedule_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK91AB41AEE77A3026` (`mashSchedule_id`),
  CONSTRAINT `FK91AB41AEE77A3026` FOREIGN KEY (`mashSchedule_id`) REFERENCES `MashSchedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Recipe`
--

LOCK TABLES `Recipe` WRITE;
/*!40000 ALTER TABLE `Recipe` DISABLE KEYS */;
/*!40000 ALTER TABLE `Recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Recipe_AdditiveIngredient`
--

DROP TABLE IF EXISTS `Recipe_AdditiveIngredient`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Recipe_AdditiveIngredient` (
  `Recipe_id` int(11) NOT NULL,
  `additives_id` int(11) NOT NULL,
  UNIQUE KEY `additives_id` (`additives_id`),
  KEY `FK1E59910EB2B1AA3C` (`additives_id`),
  KEY `FK1E59910ED81EB246` (`Recipe_id`),
  CONSTRAINT `FK1E59910ED81EB246` FOREIGN KEY (`Recipe_id`) REFERENCES `Recipe` (`id`),
  CONSTRAINT `FK1E59910EB2B1AA3C` FOREIGN KEY (`additives_id`) REFERENCES `AdditiveIngredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Recipe_AdditiveIngredient`
--

LOCK TABLES `Recipe_AdditiveIngredient` WRITE;
/*!40000 ALTER TABLE `Recipe_AdditiveIngredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `Recipe_AdditiveIngredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Recipe_BarleyIngredient`
--

DROP TABLE IF EXISTS `Recipe_BarleyIngredient`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Recipe_BarleyIngredient` (
  `Recipe_id` int(11) NOT NULL,
  `barlies_id` int(11) NOT NULL,
  UNIQUE KEY `barlies_id` (`barlies_id`),
  KEY `FK69CBF96FD81EB246` (`Recipe_id`),
  KEY `FK69CBF96FA84E16A6` (`barlies_id`),
  CONSTRAINT `FK69CBF96FA84E16A6` FOREIGN KEY (`barlies_id`) REFERENCES `BarleyIngredient` (`id`),
  CONSTRAINT `FK69CBF96FD81EB246` FOREIGN KEY (`Recipe_id`) REFERENCES `Recipe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Recipe_BarleyIngredient`
--

LOCK TABLES `Recipe_BarleyIngredient` WRITE;
/*!40000 ALTER TABLE `Recipe_BarleyIngredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `Recipe_BarleyIngredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Recipe_FlavoringIngredient`
--

DROP TABLE IF EXISTS `Recipe_FlavoringIngredient`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Recipe_FlavoringIngredient` (
  `Recipe_id` int(11) NOT NULL,
  `flavorings_id` int(11) NOT NULL,
  UNIQUE KEY `flavorings_id` (`flavorings_id`),
  KEY `FK1CC37D44C3365894` (`flavorings_id`),
  KEY `FK1CC37D44D81EB246` (`Recipe_id`),
  CONSTRAINT `FK1CC37D44D81EB246` FOREIGN KEY (`Recipe_id`) REFERENCES `Recipe` (`id`),
  CONSTRAINT `FK1CC37D44C3365894` FOREIGN KEY (`flavorings_id`) REFERENCES `FlavoringIngredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Recipe_FlavoringIngredient`
--

LOCK TABLES `Recipe_FlavoringIngredient` WRITE;
/*!40000 ALTER TABLE `Recipe_FlavoringIngredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `Recipe_FlavoringIngredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Recipe_HopIngredient`
--

DROP TABLE IF EXISTS `Recipe_HopIngredient`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Recipe_HopIngredient` (
  `Recipe_id` int(11) NOT NULL,
  `hops_id` int(11) NOT NULL,
  UNIQUE KEY `hops_id` (`hops_id`),
  KEY `FK5E4896095402FA5E` (`hops_id`),
  KEY `FK5E489609D81EB246` (`Recipe_id`),
  CONSTRAINT `FK5E489609D81EB246` FOREIGN KEY (`Recipe_id`) REFERENCES `Recipe` (`id`),
  CONSTRAINT `FK5E4896095402FA5E` FOREIGN KEY (`hops_id`) REFERENCES `HopIngredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Recipe_HopIngredient`
--

LOCK TABLES `Recipe_HopIngredient` WRITE;
/*!40000 ALTER TABLE `Recipe_HopIngredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `Recipe_HopIngredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Recipe_YeastIngredient`
--

DROP TABLE IF EXISTS `Recipe_YeastIngredient`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Recipe_YeastIngredient` (
  `Recipe_id` int(11) NOT NULL,
  `yeasts_id` int(11) NOT NULL,
  UNIQUE KEY `yeasts_id` (`yeasts_id`),
  KEY `FK960005B6B82141F8` (`yeasts_id`),
  KEY `FK960005B6D81EB246` (`Recipe_id`),
  CONSTRAINT `FK960005B6D81EB246` FOREIGN KEY (`Recipe_id`) REFERENCES `Recipe` (`id`),
  CONSTRAINT `FK960005B6B82141F8` FOREIGN KEY (`yeasts_id`) REFERENCES `YeastIngredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Recipe_YeastIngredient`
--

LOCK TABLES `Recipe_YeastIngredient` WRITE;
/*!40000 ALTER TABLE `Recipe_YeastIngredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `Recipe_YeastIngredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Yeast`
--

DROP TABLE IF EXISTS `Yeast`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Yeast` (
  `id` int(11) NOT NULL auto_increment,
  `brand` varchar(255) default NULL,
  `category` int(11) NOT NULL,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Yeast`
--

LOCK TABLES `Yeast` WRITE;
/*!40000 ALTER TABLE `Yeast` DISABLE KEYS */;
/*!40000 ALTER TABLE `Yeast` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `YeastIngredient`
--

DROP TABLE IF EXISTS `YeastIngredient`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `YeastIngredient` (
  `id` int(11) NOT NULL auto_increment,
  `quantity` double NOT NULL,
  `yeast_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK10608A47D366792E` (`yeast_id`),
  CONSTRAINT `FK10608A47D366792E` FOREIGN KEY (`yeast_id`) REFERENCES `Yeast` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `YeastIngredient`
--

LOCK TABLES `YeastIngredient` WRITE;
/*!40000 ALTER TABLE `YeastIngredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `YeastIngredient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2009-02-06 20:53:44
