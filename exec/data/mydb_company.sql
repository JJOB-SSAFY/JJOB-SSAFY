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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `company_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_address` varchar(255) NOT NULL,
  `company_desc` varchar(255) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  `company_url` varchar(255) NOT NULL,
  `employee_cnt` int(11) NOT NULL,
  `company_logo` varchar(255) DEFAULT 'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2FLogo.png?alt=media&token=6b1c5377-2694-4836-85f6-00b377113391',
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `UK_46jubpbtfae2gfb74a3x6qug7` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'address','description','카카오','url',500,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fkakao-logo-23bff02f.png?alt=media&token=99098a23-b0fc-479c-90c3-28fb22474c02'),(2,'광주','소프트웨어 교육','싸피','edu.ssafy.com',150,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2F%EC%8B%B8%ED%94%BC.png?alt=media&token=cfdd73b6-6c1d-497d-81a2-221a2f2f0643'),(3,'경기도 수원시','삼성전자는 대한민국의 제조 기업으로 기업집단 삼성의 주력 회사이다. 휴대폰과 노트북의 전자제품, 에어컨과 냉장고의 가전제품, 메모리 반도체 등을 중심으로 한 종합 반도체와 디스플레이 사업을 하고 있다','삼성전자','www.samsung.com/sec',117498,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2F%EC%83%98%EC%84%B1.png?alt=media&token=d865150c-26b7-41d3-afed-b540bec0fe82'),(5,'서울특별시 강남구 테헤란로 332, HJ타워 10층(역삼동)','세금 신고·환급 도움 서비스 ‘삼쩜삼’을 운영하는 AI 스타트업 자비스앤빌런즈”  삼쩜삼(자비스앤빌런즈)은 세무가 어렵다는 편견을 깨기 위해 거침없는 도전과 혁신을 이어가고 있습니다. 개인 세금 신고와 환급을 도와주는 서비스인 삼쩜삼은 출시 2년 7개월 만에 가입자 1,400만 명 & 누적 환급액 5,893억이라는 가파른 성장을 보이고 있습니다.','자비스앤빌런즈(삼쩜삼)','https://jobis.co/',138,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2F%EC%82%BC%EC%A9%9C%EC%82%BC.PNG?alt=media&token=2aeddc73-a063-4aaa-905b-2e5f30655540'),(6,'성동구 광나루로 286, 아인빌딩 5층(성수동2가)','\"패션브랜드들이 그들의 메시지를 표현할 수 있는 더 멋지고 효율적인 방법을 제시한다\"  스와치온은 창업 시점부터 북미/유럽 패션 선진국 시장을 타겟으로 사업을 시작했습니다. 지금은 52개국 17,000여개 브랜드들이 이용하고, 전체 매출의 70% 이상이 북미와 유럽에서 발생하는, 성공적인 글로벌 서비스로 성장했습니다.','스와치온(SwatchOn)','https://swatchon.com/',54,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2F%EC%8A%A4%EC%99%80%EC%B9%98%EC%98%A8.PNG?alt=media&token=cc436406-0151-4896-abfd-6e67ff3fc642'),(7,'서초구 서초대로74길 14, 8층(The Asset)','＜헤이딜러 소개＞  ‘우리가 바라던 중고차 거래, 우리가 만들자’  헤이딜러는 고객의 거래 경험을 모두 책임지는 중고차 플랫폼입니다. 2015년 시작한 헤이딜러는 중고차 시장을 내차팔기부터 바꾸고 있습니다.','피알앤디컴퍼니(헤이딜러)','https://www.prnd.co.kr/',55,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2F%ED%94%BC%EC%95%8C%EC%95%A4%EB%94%94%EC%BB%B4%ED%8D%BC%EB%8B%88(%ED%97%A4%EC%9D%B4%EB%94%9C%EB%9F%AC).PNG?alt=media&token=5aa8751c-ea28-440b-afff-ce474ed9e2bd'),(8,'경기도 성남시 분당구','주식회사 엔씨소프트는 대한민국에 기반을 둔 온라인 · 모바일 게임 개발사 및 퍼블리셔이다. MMORPG 《리니지》, 《리니지2》, 《아이온》, 《블레이드 & 소울》로 유명하다','엔씨소프트','careers.ncsoft.com',4500,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2F%EC%97%94%EC%8B%9C.PNG?alt=media&token=38175737-f20a-402a-9294-1adb1e510152'),(9,' 대한민국 서울특별시 강남구 테헤란로 510 (대치동)','현대오토에버는 현대자동차그룹의 소프트웨어 전문업체로, In-Car와 Out-Car 영역 전반의 차량 소프트웨어와 인프라를 지원하고, 그룹 내 클라우드 서비스, 시스템 통합과 업무 시스템을 운영 및 유지보수하는 IT 아웃소싱 사업을 하는 회사이다','현대오토에버','www.hyundai-autoever.com/',4000,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2F%ED%98%84%EB%8C%80.png?alt=media&token=9a41c318-c48c-476c-a69a-ca95cfb6c3e8'),(10,' 대한민국 서울특별시 중구 을지로 35','하나은행은 대한민국의 은행이다','하나은행','https://www.kebhana.com',11549,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2F%ED%95%98%EB%82%98.png?alt=media&token=c2faf047-4e13-4c4d-bd4d-611f530b70fd'),(11,'서울특별시 중구 을지로 65','SK텔레콤은 대한민국의 이동통신 서비스 업체','sk텔레콤','www.sktelecom.com',5376,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fskt.png?alt=media&token=fa948e79-5f68-4619-91c2-0efec929b3ab'),(12,'미국 캘리포니아 마운틴뷰','구글은 구글 검색을 중심으로 스마트폰 운영체제인 안드로이드와 유튜브 사업, 클라우드 사업을 하는 미국의 기업이다. 다양한 구글 서비스들과 함께 \'전 세계의 모든 정보들을 체계화하여 모든 사용자가 유익하게 사용할 수 있도록 한다\'라는 사명을 가지고 사업을 하고 있다.','구글','google.com',3000,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fgoogle.PNG?alt=media&token=4f87b04f-3df1-4907-a542-86f5257ba0bf'),(13,'경기도 성남시 분당구 불정로 6','네이버 그린팩토리은 대한민국 경기도 성남시 분당구 정자동에 위치한 사무용 건물로 한국의 인터넷 콘텐츠 서비스 업체인 네이버의 본사를 운영하고 있다. 건물은 지상 27층, 지하 7층으로 2010년 3월에 완공되었다. 주차대수는 총 799대다','네이버','naver.com',2963,'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fna.png?alt=media&token=c3c44ab1-b8e9-4332-b997-42d23a1c57af');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-16 21:35:43
