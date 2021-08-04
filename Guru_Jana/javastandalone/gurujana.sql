-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: gurujana
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.18.04.1

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `clientId` varchar(255) NOT NULL,
  `clientName` varchar(255) DEFAULT NULL,
  `clientEmails` varchar(255) DEFAULT NULL,
  `clientTags` varchar(255) DEFAULT NULL,
  `status` varchar(10000) DEFAULT NULL,
  `createdDate` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `folderName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`clientId`),
  FULLTEXT KEY `clientTags` (`clientTags`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('12345678','Shweta','sushmita@trisysit.com','trisys','ACTIVE','2020-03-28 00:00:00','Sushmita','trustedstay');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email` (
  `emailId` varchar(255) NOT NULL,
  `fromEmail` varchar(255) DEFAULT NULL,
  `toEmail` varchar(255) DEFAULT NULL,
  `ccEmail` varchar(255) DEFAULT NULL,
  `bccEmail` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `contentFilePath` varchar(255) DEFAULT NULL,
  `isEmailAttachment` bit(1) DEFAULT NULL,
  `emailAttachments` longtext CHARACTER SET utf8,
  `emailCreatedDate` datetime DEFAULT NULL,
  `emailStatus` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES ('04f42f84-e3da-431c-96a4-81ec0460e360','psushmita10@gmail.com','sushmita31Dec@outlook.com',NULL,NULL,'testing','/home/user/Projects/sushmita31Dec@outlook.com/30_03_2020/04f42f84-e3da-431c-96a4-81ec0460e360/Shweta//04f42f84-e3da-431c-96a4-81ec0460e360_emailContent.txt',_binary '\0','','2020-03-30 12:29:51',NULL,'12345678'),('137179fd-8968-4969-af24-388c9f3a3071','psushmita10@gmail.com','sushmita31Dec@outlook.com',NULL,NULL,'testing','/home/user/Projects/sushmita31Dec@outlook.com/30_03_2020/137179fd-8968-4969-af24-388c9f3a3071/undertmined//137179fd-8968-4969-af24-388c9f3a3071_emailContent.txt',_binary '\0','','2020-03-30 09:45:44',NULL,'undertmined'),('13f6415e-7fe4-44f4-ab4b-71d7b168dd31','psushmita10@gmail.com','sushmita31Dec@outlook.com',NULL,NULL,'trisys','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/13f6415e-7fe4-44f4-ab4b-71d7b168dd31/Shweta//13f6415e-7fe4-44f4-ab4b-71d7b168dd31_emailContent.txt',_binary '\0','','2020-03-27 21:35:38',NULL,'12345678'),('1684edc0-29c2-42c2-a155-62bfa33cbd6b','psushmita10@gmail.com','sushmita31Dec@outlook.com',NULL,NULL,'trisys','/home/user/Projects/sushmita31Dec@outlook.com/30_03_2020/1684edc0-29c2-42c2-a155-62bfa33cbd6b/Shweta//1684edc0-29c2-42c2-a155-62bfa33cbd6b_emailContent.txt',_binary '\0','','2020-03-30 12:41:21',NULL,'12345678'),('3b691f71-c10d-42f3-8a13-5e0432dbcdd0','sushmita31Dec@outlook.com','sushmita patil <sushmita31Dec@outlook.com>',NULL,NULL,'testing email','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/3b691f71-c10d-42f3-8a13-5e0432dbcdd0/Shweta//3b691f71-c10d-42f3-8a13-5e0432dbcdd0_emailContent.txt',_binary '','Screenshot from 2020-02-25 15-48-52.png','2020-03-27 21:09:31',NULL,'12345678'),('3c3b019c-9928-4a3d-885c-0d0a94fb9d82','psushmita10@gmail.com','sushmita31Dec@outlook.com',NULL,NULL,'testing','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/3c3b019c-9928-4a3d-885c-0d0a94fb9d82/Shweta//3c3b019c-9928-4a3d-885c-0d0a94fb9d82_emailContent.txt',_binary '\0','','2020-03-27 22:28:56',NULL,'12345678'),('4278a3aa-d291-4592-8775-2e71e8c98add','psushmita10@gmail.com','sushmita31Dec@outlook.com',NULL,NULL,'testing','/home/user/Projects/sushmita31Dec@outlook.com/30_03_2020/4278a3aa-d291-4592-8775-2e71e8c98add/Shweta//4278a3aa-d291-4592-8775-2e71e8c98add_emailContent.txt',_binary '\0','','2020-03-30 12:42:30',NULL,'12345678'),('7191bf92-08ef-403a-892e-051530baa469','email@mail.onedrive.com','sushmita31Dec@outlook.com',NULL,NULL,'Your new OneDrive is almost set up','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/7191bf92-08ef-403a-892e-051530baa469/undertmined//7191bf92-08ef-403a-892e-051530baa469_emailContent.txt',_binary '\0','','2020-03-27 21:09:29',NULL,'undertmined'),('75c1df9d-5c0c-46fc-802c-9636dff9626b','psushmita10@gmail.com','sushmita31Dec@outlook.com',NULL,NULL,'testing','/home/user/Projects/sushmita31Dec@outlook.com/30_03_2020/75c1df9d-5c0c-46fc-802c-9636dff9626b/Shweta//75c1df9d-5c0c-46fc-802c-9636dff9626b_emailContent.txt',_binary '\0','','2020-03-30 09:53:37',NULL,'12345678'),('7b70e1f4-af93-4553-94d1-e965f66264d4','psushmita10@gmail.com','sushmita31Dec@outlook.com',NULL,NULL,'testing','/home/user/Projects/sushmita31Dec@outlook.com/30_03_2020/7b70e1f4-af93-4553-94d1-e965f66264d4/Shweta//7b70e1f4-af93-4553-94d1-e965f66264d4_emailContent.txt',_binary '\0','','2020-03-30 09:49:36',NULL,'12345678'),('7e0e8f60-f3e3-423c-869f-d4ef8871dfde','no-reply@microsoft.com','sushmita patil <sushmita31dec@outlook.com>',NULL,NULL,'Welcome to your new Outlook.com account','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/7e0e8f60-f3e3-423c-869f-d4ef8871dfde/undertmined//7e0e8f60-f3e3-423c-869f-d4ef8871dfde_emailContent.txt',_binary '\0','','2020-03-27 21:09:29',NULL,'undertmined'),('841924d4-17e8-47af-8ed9-76645fe0b020','sushmita31Dec@outlook.com','sushmita patil <sushmita31Dec@outlook.com>',NULL,NULL,'testing email','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/841924d4-17e8-47af-8ed9-76645fe0b020/Shweta//841924d4-17e8-47af-8ed9-76645fe0b020_emailContent.txt',_binary '','Screenshot from 2020-02-25 15-48-52.png','2020-03-27 21:08:29',NULL,'12345678'),('8e49ef49-bd16-4cf7-866d-d07490d84907','no-reply@microsoft.com','sushmita patil <sushmita31dec@outlook.com>',NULL,NULL,'Welcome to your new Outlook.com account','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/8e49ef49-bd16-4cf7-866d-d07490d84907/undertmined//8e49ef49-bd16-4cf7-866d-d07490d84907_emailContent.txt',_binary '\0','','2020-03-27 12:07:54',NULL,'undertmined'),('92e4d5fe-b585-4f8b-abc4-208e4b82cd88','no-reply@microsoft.com','sushmita patil <sushmita31dec@outlook.com>',NULL,NULL,'Welcome to your new Outlook.com account','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/92e4d5fe-b585-4f8b-abc4-208e4b82cd88/undertmined//92e4d5fe-b585-4f8b-abc4-208e4b82cd88_emailContent.txt',_binary '\0','','2020-03-27 12:08:35',NULL,'undertmined'),('9652bbc7-ea1d-4a8c-b386-09acb7939037','psushmita10@gmail.com','sushmita31Dec@outlook.com',NULL,NULL,'trisys','/home/user/Projects/sushmita31Dec@outlook.com/30_03_2020/9652bbc7-ea1d-4a8c-b386-09acb7939037/Shweta//9652bbc7-ea1d-4a8c-b386-09acb7939037_emailContent.txt',_binary '\0','','2020-03-30 12:33:26',NULL,'12345678'),('9969cfc7-b479-4a1d-b6af-05f559230a30','no-reply@microsoft.com','sushmita patil <sushmita31dec@outlook.com>',NULL,NULL,'Welcome to your new Outlook.com account','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/9969cfc7-b479-4a1d-b6af-05f559230a30/undertmined//9969cfc7-b479-4a1d-b6af-05f559230a30_emailContent.txt',_binary '\0','','2020-03-27 12:06:53',NULL,'undertmined'),('a5b1b161-5bfc-4a80-8218-6f6c4363efec','psushmita10@gmail.com','sushmita31Dec@outlook.com',NULL,NULL,'testing mail','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/a5b1b161-5bfc-4a80-8218-6f6c4363efec/undertmined//a5b1b161-5bfc-4a80-8218-6f6c4363efec_emailContent.txt',_binary '\0','','2020-03-27 22:21:00',NULL,'undertmined'),('c414d885-9a1d-47b1-811e-dbe8df1c5d65','sushmita31Dec@outlook.com','sushmita patil <sushmita31Dec@outlook.com>',NULL,NULL,'testing email','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/c414d885-9a1d-47b1-811e-dbe8df1c5d65/Shweta//c414d885-9a1d-47b1-811e-dbe8df1c5d65_emailContent.txt',_binary '','Screenshot from 2020-02-25 15-48-52.png','2020-03-27 11:42:24',NULL,NULL),('c644b6d4-1607-4f58-9bb5-36f20a111327','email@mail.onedrive.com','sushmita31Dec@outlook.com',NULL,NULL,'Your new OneDrive is almost set up','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/c644b6d4-1607-4f58-9bb5-36f20a111327/undertmined//c644b6d4-1607-4f58-9bb5-36f20a111327_emailContent.txt',_binary '\0','','2020-03-27 21:08:26',NULL,'undertmined'),('d3a1766c-67e0-4923-9590-3bb309dff1a7','no-reply@microsoft.com','sushmita patil <sushmita31dec@outlook.com>',NULL,NULL,'Welcome to your new Outlook.com account','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/d3a1766c-67e0-4923-9590-3bb309dff1a7/undertmined//d3a1766c-67e0-4923-9590-3bb309dff1a7_emailContent.txt',_binary '\0','','2020-03-27 11:41:24',NULL,NULL),('e0eb3813-e277-411e-a2e2-a76ef500e3f8','no-reply@microsoft.com','sushmita patil <sushmita31dec@outlook.com>',NULL,NULL,'Welcome to your new Outlook.com account','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/e0eb3813-e277-411e-a2e2-a76ef500e3f8/undertmined//e0eb3813-e277-411e-a2e2-a76ef500e3f8_emailContent.txt',_binary '\0','','2020-03-27 21:08:25',NULL,'undertmined'),('e409c684-5296-41ae-825b-eb3cd39301ba','email@mail.onedrive.com','sushmita31Dec@outlook.com',NULL,NULL,'Your new OneDrive is almost set up','/home/user/Projects/sushmita31Dec@outlook.com/27_03_2020/e409c684-5296-41ae-825b-eb3cd39301ba/Shweta//e409c684-5296-41ae-825b-eb3cd39301ba_emailContent.txt',_binary '\0','','2020-03-27 11:42:17',NULL,NULL);
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userEmail`
--

DROP TABLE IF EXISTS `userEmail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userEmail` (
  `userEmailId` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(10000) DEFAULT NULL,
  `createdDate` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userEmailId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userEmail`
--

LOCK TABLES `userEmail` WRITE;
/*!40000 ALTER TABLE `userEmail` DISABLE KEYS */;
INSERT INTO `userEmail` VALUES ('sushmita31Dec@outlook.com','sushmita31Dec@outlook.com','','ACTIVE','2020-03-26 00:00:00','Sushmita');
/*!40000 ALTER TABLE `userEmail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-09  8:58:12
