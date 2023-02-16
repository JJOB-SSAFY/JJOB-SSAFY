-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 54.180.146.30    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.41

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `card_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  UNIQUE KEY `UK_mbmcqelty0fbrvxp1q58dn57t` (`email`),
  KEY `FKt2e7qxw08gny8n2fcalh0ynmy` (`card_id`),
  KEY `FKax2gealrg44mnq3ibas3q9de6` (`company_id`),
  CONSTRAINT `FKax2gealrg44mnq3ibas3q9de6` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  CONSTRAINT `FKt2e7qxw08gny8n2fcalh0ynmy` FOREIGN KEY (`card_id`) REFERENCES `card` (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (2,'admin@a.com','admin','$2a$10$OpYSFJZsgMjigrnq7Z/5mu2fcieV5UT1K.aQpMpJUpkYNLi8gCrjq',2,1),(3,'ssafy@ssafy.com','김싸피','$2a$10$2b.kJnFN24B3DguXeHoF4.y/lB3FLlGM2nYfU4NF5aJKZIqKVsRLq',3,2),(4,'study@ssafy.com','교육생','$2a$10$CgGB8PRXzaf0dh.D92HApOLTNeEhLLz.v2rkAnaSsV1H9RFQf9aqe',4,2),(5,'keeeeeey@naver.com','김기윤','$2a$10$KY2riC3NaGp9c4AA29iYgOvgmRi4aHwZGjEf8yzIXPNG.OJnymhtG',5,NULL),(6,'key@gmail.com','김기윤','$2a$10$M0i.VHQTufxCUA9gB5VH7OUGuE/WUAqfvGVrMuJQPbDqft1fHY2s2',6,NULL),(7,'ssafy1@ssafy.com','싸피1','$2a$10$hOFP4VMNdGzhi75Tw182teRMDwyxSvfcQf6Gtx534FJ7pfCbwJFEW',7,2),(8,'sseioul@naver.com','김기윤','$2a$10$IjoB7bq8NJ0E8oXI4lGShO91CVHdCXJLQPiPcPhIIE1J9oWX19Rk.',8,NULL),(9,'gkatldus@daum.net','시연','$2a$10$/IIlXAThrbHjPENEYcsNhugP6zLJUniZXqRX6WixPa8sDtGedxIve',9,NULL),(10,'gobuig00@naver.com','정우영','$2a$10$L1jLiIRORWlW5ToH7RIgCusE/niViQMKV7WAgGVv16rjEx0Zy/FM.',10,NULL),(11,'sseioul@gmail.com','김기윤[광주_2반_C208]팀원','$2a$10$HnumCFu0c96zR/p4t9FMy.EDlFnqPElcSe.j7BsErl4XetyWHC/Cm',11,NULL),(12,'qkrxoghks@gmail.com','박소나','$2a$10$17Y4qx4EgXXMjNCKF/ZMdeLulPVFpLK4Sde8HpiKpjtNXmE1yfWs.',12,NULL),(13,'wkdwlsans@gmail.com','장아리','$2a$10$9vt8FVvc.7OgDyns14UXZeh4jhVAO7ZDgiCpg4Vdkm0s7dGqnVAfG',13,NULL),(14,'gkatldus@gmail.com','함잔나','$2a$10$l784B0MAl4pgMwSjoQr7/egSRbxI2Iz3DZ1o.7uTG00hWOPtiflmu',14,NULL),(15,'rlarldbs@gmail.com','김유미','$2a$10$YWrH2mvxY6mH6nWc.YBmqefwmeDfhTb2WBZmssT9gZh0jS6vLYNpW',15,NULL),(16,'wjddndud@gmail.com','정나미','$2a$10$zSI9uRBWRdgg70ZCt6N7QODRaiHzmKTNrsMFtFGATa20MIEx4fkfW',16,NULL),(17,'jjm1261@naver.com','장진문','$2a$10$Er2SesxV5VdOVSUcgkmn6OX1662KW.rbSsspM19YF0JAzYdrNhw5q',17,NULL),(18,'kakao@kakao.com','카카오 관리자1','$2a$10$tsBhyJC25XcqIpzb/Vp.ze9A52vZM4Lqgc1nAoIDr1uuZHtZNM/Si',18,1),(19,'samsung@samsung.com','삼성전자 관리자','$2a$10$ITJ2SqYV0bksZZlYA7Q2FeIDSV65JMDW4BBm2YXzeezU9uz2YCaj6',19,3),(20,'jobis@j.com','자비스','$2a$10$2x8G6sJLSwaZzHeRWhUkx.vhFWYrVavE7o5smtBsgEfXaUKA1QQMe',20,5),(21,'swatch@s.com','스와치온','$2a$10$a8i8NvkNOC1fptht4fjfj.MJ1cruq7XRhn.SFovlD.F9gttoVaPvC',21,6),(22,'hey@h.com','헤이딜러','$2a$10$zhpkTkXy98wIvCrDPrKo8em/ULU3RpX3ogqnGWH.xCZFcZN1K00Ty',22,7),(23,'ncsoft@ncsoft.com','엔시소프트 관리자1','$2a$10$RgfvBXnyGGnK1DOR9H4Dtekowmz3y4M4aaRlPnSGIB6CvgWQbFKD.',23,8),(24,'auto@auto.com','현대오토에버 관리자','$2a$10$XtoyDlAWG4e5JkN.336y5uz1tGSlLbqYz4nARDqCf1yf7cAh6JTYq',24,9),(25,'hana@hana.com','하나은행 관리자','$2a$10$3oVCnKkn.pySuoSFbAceOeE8J926XZglX2Z3dWXMxnvJFSJEAcTba',25,10),(26,'skt@skt.com','skt관리자1','$2a$10$LE4l.sUNC1EsO0AjgDS1ouQ0gCthTWoqm1My/MAPOZ/LROEMgf8Ra',26,11),(27,'google@google.com','구글관리자1','$2a$10$7f4XRj/1hqureSmFkEpkw.NNZgVR6eIFynYEEqBIORh8x0neqJMve',27,12),(28,'naver@naver.com','네이버관리자','$2a$10$PhS.GoS0x758MiRN8foOMuCMuVO5Uv/2kBpZzzmM6OnlHAkvNQnOG',28,13);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-16 21:35:41
