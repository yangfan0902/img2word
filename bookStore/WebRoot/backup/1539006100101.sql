-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: bookStore
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `author` varchar(20) NOT NULL,
  `image` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id_FK` (`category_id`),
  CONSTRAINT `category_id_FK` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('0650515c-669f-48a5-834d-5a0daaa58fb8','卡卡自传',89.00,'卡卡','b90b3410-9b55-444d-80fb-694ef9b5fe2d卡卡.jpg',' 帅','8dd1b455-499c-46e6-9ab3-51e53d0e850a'),('075063de-6645-4bb3-906a-5e1f8ec13b01','哲科自传',57.00,'哲科','86db844c-fa4c-44a4-8bd2-fc4d67ed8d1bzeko.jpg',' 长得高，跑得慢，无用武之地','8dd1b455-499c-46e6-9ab3-51e53d0e850a'),('1','从燃气发电到系能源的思考',5.00,'李顺隆','11111','火电专家','1'),('37974844-26b5-43a5-a09e-497291713785','123',123.00,'123','eb347e79-f8bf-48d4-bb0b-f326e9177cecjava.jpg',' 123','1'),('5cfb7d24-3ee8-40f8-9991-692369bd8b4d','梅西自传',78.00,'梅西','8b8caa68-aad5-477e-b8bf-69506567c426messi.jpg',' 梅西是个戴明星','8dd1b455-499c-46e6-9ab3-51e53d0e850a'),('76d14d9d-6438-402d-a44f-eeb23b49cb7a','内马尔自传',75.00,'内马尔','c4caafe6-b14f-48a0-ba75-321c42775ea9neymar.jpg',' 内马尔赚钱有错吗','8dd1b455-499c-46e6-9ab3-51e53d0e850a'),('de8183eb-0ad0-4ead-bd3b-3f8e10294269','C罗自传',89.00,'CR7','a3defa57-f890-43f9-8b6b-75baf8c84917cr7.jpg',' C罗是个带人物','8dd1b455-499c-46e6-9ab3-51e53d0e850a');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('1','java develope','sadsfa'),('2','python develope','asdfeas'),('4de6920c-5e4f-4a47-948e-e696226f477b','ccc','ccccc'),('6d42c24b-cfbb-41d0-b025-6af9178d006d','bbb','bbbbb'),('81837e04-b419-48ee-9abd-36411b1dea42','aa','aaa'),('8189143c-c531-4e9b-b617-55f9f6caf724','cc',''),('8dd1b455-499c-46e6-9ab3-51e53d0e850a','足球运动','足球明星'),('fd8c0c2f-ddc0-4724-baed-1128e25a1c9b','123','123');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orderitem` (
  `id` varchar(40) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `book_id` varchar(40) DEFAULT NULL,
  `order_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id_FK` (`book_id`),
  KEY `order_id_FK` (`order_id`),
  CONSTRAINT `book_id_FK` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `order_id_FK` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` VALUES ('1cf47b89-6bd4-4bc3-9523-8e2c89821b0f',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','47065e11-1384-4233-83b9-51ea5b5424af'),('2920a3b0-8956-4607-bd9e-f5374e261717',1,5.00,'1','927bb143-782b-45ef-a151-20636fca1ae8'),('340fcb63-9254-47bd-a82b-b5d665f77140',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','7aa2c79c-6474-4c32-b5be-1295ab37722f'),('3621e96c-ee1d-447f-9703-12d1f3a95681',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','82eec8ea-0f2f-4379-b524-546abd658ec2'),('39f6709a-0f92-4285-9c39-980f8e86ff17',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','32e30092-babf-44de-a791-4b793e8f237d'),('49460846-b6fb-47e9-beb1-bb30c9b02939',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','f3065e3f-8ecc-42b4-95b7-c250cb4eb625'),('67a556c4-d3a3-4bce-949d-baa38f253b16',1,57.00,'075063de-6645-4bb3-906a-5e1f8ec13b01','56c5af98-9e0f-4fc8-b55f-124052ef7558'),('6ba20cf7-c48b-4a82-b780-8364ab2159dc',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','d40b457d-e5e7-457a-84a7-b47769f8a986'),('74647ba1-49e4-4925-852f-86745146bc4f',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','52f9c9fa-007c-4542-a12a-90fc1a0c323d'),('a7d0326b-9aa7-4796-b874-c5967f8ee4c7',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','7e525935-5c20-47cb-b075-173227574462'),('aefcec02-cf5f-49d2-bf5c-649bc1b61342',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','e6b05718-042d-4cb2-bc5c-8f5424cf3b3b'),('b50a8bc3-e59f-4eee-abd8-bea7671918cd',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','aad92755-04b2-4639-bb90-580f6cf1b530'),('b7641c79-7695-45db-aa2f-40981203a6ed',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','9531f12f-364d-4a00-8c91-4bcf20d35d03'),('b8b1fa6b-be48-40e1-b80a-dcea55c260c1',1,5.00,'1','2552f020-ce3e-4118-bce3-a4d576e443a2'),('c197db28-2756-487d-b8f8-33d58cfc4596',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','4d2e28ae-d0da-42b3-a3bb-80b890a322c4'),('c93c7903-796b-44b2-bed7-8e36192eea52',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','bcdd5371-d587-4eb3-bd3d-18672f484e23'),('d2e5b106-ffba-4aec-8eb4-82c60b80371a',3,267.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','56c5af98-9e0f-4fc8-b55f-124052ef7558'),('d83fad29-0154-4868-85dd-bb67c367c381',1,5.00,'1','66a41e6d-e054-4330-9094-65b97baf8568'),('e5ef6732-2c70-4124-a869-923f05cd48a9',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','f3755420-87b9-422c-8b18-722143f6fdc5'),('eae6f014-44c9-4998-bd46-6a1d622a5afa',2,178.00,'0650515c-669f-48a5-834d-5a0daaa58fb8','2cd9094a-8d83-4a4d-9f76-e525c30ab941');
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `id` varchar(40) NOT NULL,
  `ordertime` datetime NOT NULL,
  `state` tinyint(1) NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `user_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_FK` (`user_id`),
  CONSTRAINT `user_id_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('09fb329f-0626-40ee-8235-f84bd29c8c67','2018-10-04 19:15:55',0,0.00,'1'),('1841cfe1-ca2a-420a-9c17-ff27a79ee72d','2018-10-04 19:21:27',0,0.00,'1'),('2552f020-ce3e-4118-bce3-a4d576e443a2','2018-10-05 04:16:48',0,5.00,'1'),('2cd9094a-8d83-4a4d-9f76-e525c30ab941','2018-10-08 10:27:45',1,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('32e30092-babf-44de-a791-4b793e8f237d','2018-10-07 15:22:48',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('47065e11-1384-4233-83b9-51ea5b5424af','2018-10-08 10:27:02',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('48a07ea8-f4f6-4a8b-a520-2478724e69ef','2018-10-05 04:10:41',0,0.00,'1'),('4d2e28ae-d0da-42b3-a3bb-80b890a322c4','2018-10-08 10:27:04',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('52f9c9fa-007c-4542-a12a-90fc1a0c323d','2018-10-08 10:27:49',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('56c5af98-9e0f-4fc8-b55f-124052ef7558','2018-10-07 15:23:50',0,324.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('66a41e6d-e054-4330-9094-65b97baf8568','2018-10-05 04:16:48',0,5.00,'1'),('7aa2c79c-6474-4c32-b5be-1295ab37722f','2018-10-08 10:27:46',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('7e525935-5c20-47cb-b075-173227574462','2018-10-08 07:08:42',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('82eec8ea-0f2f-4379-b524-546abd658ec2','2018-10-08 10:26:19',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('927bb143-782b-45ef-a151-20636fca1ae8','2018-10-05 04:15:15',1,5.00,'1'),('9531f12f-364d-4a00-8c91-4bcf20d35d03','2018-10-08 10:26:56',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('aad92755-04b2-4639-bb90-580f6cf1b530','2018-10-08 10:27:03',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('bcdd5371-d587-4eb3-bd3d-18672f484e23','2018-10-08 10:26:59',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('d40b457d-e5e7-457a-84a7-b47769f8a986','2018-10-08 10:27:01',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('e6b05718-042d-4cb2-bc5c-8f5424cf3b3b','2018-10-08 10:27:44',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('f3065e3f-8ecc-42b4-95b7-c250cb4eb625','2018-10-08 10:27:03',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4'),('f3755420-87b9-422c-8b18-722143f6fdc5','2018-10-08 10:27:47',0,178.00,'4a289cdf-299e-4bc0-a800-580ffe645fa4');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `cellphone` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','圣母','947889','1309999999','13888888888','aa@sina.com','南京'),('4a289cdf-299e-4bc0-a800-580ffe645fa4','yfyfyf947','123','123','123','aaa@sina.com','123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-08 21:41:47
