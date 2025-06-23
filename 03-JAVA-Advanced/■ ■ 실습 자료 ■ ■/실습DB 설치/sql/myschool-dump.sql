/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.4.5-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: myschool
-- ------------------------------------------------------
-- Server version	11.4.5-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Current Database: `myschool`
--

DROP DATABASE IF EXISTS `myschool`;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `myschool` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `myschool`;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '학과번호',
  `dname` varchar(100) NOT NULL COMMENT '학과명',
  `loc` varchar(100) NOT NULL COMMENT '위치',
  `phone` varchar(15) NOT NULL COMMENT '전화번호',
  `email` varchar(100) NOT NULL COMMENT '이메일 주소',
  `established` int(4) NOT NULL COMMENT '설립 연도',
  `homepage` varchar(255) DEFAULT NULL COMMENT '홈페이지 주소',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=504 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='학과';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES
(101,'컴퓨터공학과','공학관','051-123-4567','cs@myschool.ac.kr',1990,'http://cs.myschool.ac.kr'),
(102,'멀티미디어학과','디자인관','051-124-4567','media@myschool.ac.kr',1995,'http://media.myschool.ac.kr'),
(201,'전자공학과','공학관','051-125-4567','ee@myschool.ac.kr',1985,'http://ee.myschool.ac.kr'),
(202,'기계공학과','공학관','051-126-4567','me@myschool.ac.kr',1988,'http://machine.myschool.ac.kr'),
(203,'건축학과','건축관','051-127-4567','arch@myschool.ac.kr',1992,NULL),
(204,'산업디자인학과','디자인관','051-128-4567','id@myschool.ac.kr',1996,'http://id.myschool.ac.kr'),
(301,'경영학과','경영관','051-129-4567','biz@myschool.ac.kr',1980,'http://biz.myschool.ac.kr'),
(302,'경제학과','경영관','051-130-4567','econ@myschool.ac.kr',1982,NULL),
(401,'영어영문학과','인문사회관','051-131-4567','eng@myschool.ac.kr',1975,NULL),
(402,'심리학과','인문사회관','051-132-4567','psy@myschool.ac.kr',1987,'http://psy.myschool.ac.kr'),
(500,'인공지능학과','공학관','051-123-4567','ai@myschool.ac.kr',2001,'http://ai.myschool.ac.kr'),
(501,'사회복지학과','인문관','051-432-2233','social@myschool.ac.kr',2002,'http://social.myschool.ac.kr'),
(502,'심리학과','인문관','051-336-7788','psyc@myschool.ac.kr',2000,'http://psyc.myschool.ac.kr'),
(503,'체육학과','체육관','051-434-3345','phy@myschool.ac.kr',2004,'http://phy.myschool.ac.kr');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollments`
--

DROP TABLE IF EXISTS `enrollments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrollments` (
  `student_id` int(11) NOT NULL COMMENT '학생번호',
  `subject_id` int(11) NOT NULL COMMENT '과목번호',
  `enroll_date` date NOT NULL COMMENT '수강신청일',
  `score` int(11) DEFAULT NULL COMMENT '성적 점수 (100점 만점)',
  PRIMARY KEY (`student_id`,`subject_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `enrollments_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  CONSTRAINT `enrollments_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='수강';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollments`
--

LOCK TABLES `enrollments` WRITE;
/*!40000 ALTER TABLE `enrollments` DISABLE KEYS */;
INSERT INTO `enrollments` VALUES
(10101,1001,'2024-03-05',NULL),
(10101,1005,'2024-03-12',77),
(10102,1005,'2024-03-11',94),
(10102,1009,'2024-03-12',98),
(10103,1001,'2024-03-08',67),
(10103,1002,'2024-03-05',73),
(10103,1010,'2024-03-01',62),
(10104,1002,'2024-03-08',NULL),
(10104,1007,'2024-03-03',NULL),
(10104,1013,'2024-03-11',85),
(10105,1002,'2024-03-10',80),
(10105,1004,'2024-03-10',61),
(10105,1005,'2024-03-09',88),
(10105,1012,'2024-03-09',69),
(10106,1005,'2024-03-05',79),
(10106,1007,'2024-03-12',NULL),
(10106,1010,'2024-03-01',81),
(10107,1004,'2024-03-03',62),
(10107,1011,'2024-03-05',83),
(10108,1001,'2024-03-04',64),
(10108,1002,'2024-03-08',85),
(10108,1003,'2024-03-08',64),
(10108,1007,'2024-03-05',85),
(10109,1002,'2024-03-15',63),
(10109,1004,'2024-03-11',90),
(10109,1011,'2024-03-13',81),
(10110,1002,'2024-03-03',96),
(10110,1007,'2024-03-09',61),
(10111,1014,'2024-03-10',88),
(10111,1015,'2024-03-03',90),
(10112,1015,'2024-03-09',77),
(10112,1017,'2024-03-08',NULL),
(10112,1018,'2024-03-12',65),
(10112,1021,'2024-03-07',98),
(10113,1019,'2024-03-02',61),
(10113,1020,'2024-03-10',62),
(10114,1014,'2024-03-03',73),
(10114,1018,'2024-03-11',72),
(10114,1021,'2024-03-05',NULL),
(10114,1023,'2024-03-01',88),
(10115,1015,'2024-03-14',NULL),
(10115,1017,'2024-03-07',85),
(10115,1020,'2024-03-06',70),
(10115,1021,'2024-03-06',84),
(10116,1014,'2024-03-13',70),
(10116,1020,'2024-03-08',NULL),
(10116,1022,'2024-03-05',66),
(10117,1014,'2024-03-01',NULL),
(10117,1017,'2024-03-13',NULL),
(10117,1021,'2024-03-08',81),
(10117,1022,'2024-03-06',81),
(10118,1016,'2024-03-08',NULL),
(10118,1018,'2024-03-11',81),
(10118,1022,'2024-03-08',94),
(10119,1016,'2024-03-09',NULL),
(10119,1018,'2024-03-07',NULL),
(10120,1024,'2024-03-08',97),
(10120,1025,'2024-03-11',92),
(10121,1024,'2024-03-09',NULL),
(10121,1025,'2024-03-08',62),
(10121,1026,'2024-03-14',74),
(10122,1024,'2024-03-13',90),
(10122,1026,'2024-03-14',NULL),
(10123,1024,'2024-03-11',74),
(10123,1025,'2024-03-05',87),
(10123,1026,'2024-03-14',79),
(10124,1025,'2024-03-06',66),
(10124,1026,'2024-03-13',77),
(10125,1024,'2024-03-14',89),
(10125,1025,'2024-03-10',69),
(10125,1026,'2024-03-01',66),
(10126,1024,'2024-03-08',99),
(10126,1025,'2024-03-11',100),
(10126,1026,'2024-03-11',90),
(10127,1025,'2024-03-14',72),
(10127,1026,'2024-03-14',NULL),
(10128,1024,'2024-03-14',83),
(10128,1025,'2024-03-13',99),
(10128,1026,'2024-03-03',NULL),
(10129,1027,'2024-03-07',98),
(10129,1028,'2024-03-11',93),
(10129,1029,'2024-03-14',66),
(10130,1027,'2024-03-15',64),
(10130,1028,'2024-03-04',88),
(10130,1029,'2024-03-04',82),
(10131,1027,'2024-03-03',85),
(10131,1028,'2024-03-06',90),
(10131,1029,'2024-03-15',NULL),
(10132,1027,'2024-03-13',NULL),
(10132,1028,'2024-03-03',62),
(10132,1029,'2024-03-07',78),
(10133,1027,'2024-03-10',84),
(10133,1028,'2024-03-08',96),
(10134,1030,'2024-03-11',62),
(10134,1031,'2024-03-05',84),
(10135,1030,'2024-03-10',65),
(10135,1031,'2024-03-08',98),
(10135,1032,'2024-03-07',85),
(10136,1030,'2024-03-04',69),
(10136,1031,'2024-03-14',74),
(10136,1032,'2024-03-06',79),
(10137,1030,'2024-03-01',78),
(10137,1031,'2024-03-11',89),
(10137,1032,'2024-03-01',96),
(10138,1030,'2024-03-10',62),
(10138,1031,'2024-03-04',82),
(10138,1032,'2024-03-13',86),
(10139,1030,'2024-03-01',65),
(10139,1032,'2024-03-15',82),
(10140,1030,'2024-03-02',96),
(10140,1031,'2024-03-06',88),
(10140,1032,'2024-03-03',60),
(10141,1030,'2024-03-05',88),
(10141,1031,'2024-03-08',99),
(10141,1032,'2024-03-05',96),
(10142,1030,'2024-03-03',88),
(10142,1031,'2024-03-04',93),
(10142,1032,'2024-03-12',84),
(10143,1033,'2024-03-05',77),
(10143,1034,'2024-03-13',70),
(10144,1033,'2024-03-11',97),
(10144,1034,'2024-03-10',69),
(10145,1033,'2024-03-01',81),
(10145,1034,'2024-03-09',66),
(10146,1033,'2024-03-15',85),
(10146,1034,'2024-03-11',70),
(10147,1033,'2024-03-05',100),
(10147,1034,'2024-03-02',NULL),
(10148,1033,'2024-03-12',85),
(10148,1034,'2024-03-06',84),
(10149,1033,'2024-03-11',NULL),
(10149,1034,'2024-03-08',81),
(10150,1033,'2024-03-04',72),
(10150,1034,'2024-03-04',93),
(10151,1035,'2024-03-04',99),
(10151,1036,'2024-03-01',70),
(10152,1035,'2024-03-11',82),
(10152,1036,'2024-03-01',NULL),
(10153,1035,'2024-03-13',78),
(10153,1036,'2024-03-02',92),
(10154,1035,'2024-03-06',89),
(10154,1036,'2024-03-13',95),
(10155,1035,'2024-03-13',NULL),
(10155,1036,'2024-03-03',77),
(10156,1037,'2024-03-06',90),
(10156,1039,'2024-03-04',80),
(10157,1037,'2024-03-01',NULL),
(10157,1038,'2024-03-07',76),
(10158,1038,'2024-03-13',68),
(10158,1039,'2024-03-10',NULL),
(10159,1037,'2024-03-14',83),
(10159,1039,'2024-03-12',89),
(10160,1037,'2024-03-07',84),
(10160,1038,'2024-03-08',93),
(10160,1039,'2024-03-08',86),
(10161,1037,'2024-03-10',NULL),
(10161,1038,'2024-03-11',79),
(10161,1039,'2024-03-03',64),
(10162,1037,'2024-03-02',93),
(10162,1038,'2024-03-09',80),
(10162,1039,'2024-03-02',90),
(10163,1041,'2024-03-15',61),
(10163,1042,'2024-03-06',92),
(10164,1040,'2024-03-05',69),
(10164,1041,'2024-03-07',65),
(10164,1042,'2024-03-03',85),
(10165,1040,'2024-03-02',72),
(10165,1041,'2024-03-13',NULL),
(10165,1042,'2024-03-12',87),
(10166,1041,'2024-03-06',94),
(10166,1042,'2024-03-11',NULL),
(10167,1040,'2024-03-02',79),
(10167,1041,'2024-03-04',NULL),
(10167,1042,'2024-03-10',65),
(10168,1040,'2024-03-14',78),
(10168,1041,'2024-03-10',61),
(10168,1042,'2024-03-02',88),
(10169,1043,'2024-03-12',88),
(10169,1044,'2024-03-15',67),
(10169,1045,'2024-03-01',NULL),
(10170,1043,'2024-03-10',83),
(10170,1045,'2024-03-02',NULL),
(10171,1043,'2024-03-07',71),
(10171,1045,'2024-03-06',NULL),
(10172,1043,'2024-03-01',84),
(10172,1044,'2024-03-03',88),
(10172,1045,'2024-03-15',NULL),
(10173,1043,'2024-03-09',NULL),
(10173,1044,'2024-03-10',72),
(10173,1045,'2024-03-05',60),
(10174,1043,'2024-03-09',84),
(10174,1044,'2024-03-01',61),
(10174,1045,'2024-03-10',NULL),
(10175,1043,'2024-03-05',64),
(10175,1044,'2024-03-13',NULL);
/*!40000 ALTER TABLE `enrollments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professors`
--

DROP TABLE IF EXISTS `professors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `professors` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '교수번호',
  `name` varchar(50) NOT NULL COMMENT '이름',
  `user_id` varchar(50) NOT NULL COMMENT '아이디',
  `position` enum('교수','부교수','조교수','전임강사') NOT NULL DEFAULT '교수' COMMENT '직급',
  `sal` int(10) NOT NULL COMMENT '급여',
  `hiredate` datetime NOT NULL COMMENT '입사일',
  `comm` int(11) DEFAULT NULL COMMENT '보직수당',
  `email` varchar(100) DEFAULT NULL COMMENT '이메일 주소',
  `phone` varchar(15) DEFAULT NULL COMMENT '전화번호',
  `photo_url` varchar(255) DEFAULT NULL COMMENT '프로필 사진 URL',
  `status` enum('재직','휴직','퇴직') NOT NULL DEFAULT '재직' COMMENT '재직 상태',
  `department_id` int(11) NOT NULL COMMENT '소속 학과번호',
  PRIMARY KEY (`id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `fk_professors_departments` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9931 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='교수';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professors`
--

LOCK TABLES `professors` WRITE;
/*!40000 ALTER TABLE `professors` DISABLE KEYS */;
INSERT INTO `professors` VALUES
(9901,'차미경','seoyunseong','전임강사',390,'2023-07-14 23:24:53',NULL,'gangjiyeon@yu.net','053-902-0850','http://myschool.ac.kr/photos/seoyunseong.jpg','퇴직',101),
(9902,'허경희','ogsun31','전임강사',552,'1999-08-19 03:13:25',NULL,'gimgwangsu@gimryu.net','064-774-8244','http://myschool.ac.kr/photos/ogsun31.jpg','재직',102),
(9903,'전종수','jiyeong46','조교수',508,'2011-02-18 18:44:22',NULL,'hwangsujin@gmail.com','043-195-4424','http://myschool.ac.kr/photos/jiyeong46.jpg','재직',102),
(9904,'이성훈','icoe','조교수',479,'2015-08-08 21:22:48',28,'iyeongsig@yu.org','055-885-3837','http://myschool.ac.kr/photos/icoe.jpg','재직',102),
(9905,'이정남','gimseungmin','부교수',392,'1996-04-02 20:24:35',NULL,'yejinhan@gmail.com','063-796-1594','http://myschool.ac.kr/photos/gimseungmin.jpg','재직',102),
(9906,'김현주','yo','교수',300,'2006-08-31 01:04:24',21,'fbag@gmail.com','053-285-8072','http://myschool.ac.kr/photos/yo.jpg','재직',102),
(9907,'이은영','yeongho81','전임강사',443,'1999-01-04 15:55:04',12,'chan@dreamwiz.com','018-443-4597','http://myschool.ac.kr/photos/yeongho81.jpg','퇴직',201),
(9908,'박서영','mijeong31','전임강사',273,'2011-07-22 02:10:41',17,'jeonghungim@onam.org','070-4379-4764','http://myschool.ac.kr/photos/mijeong31.jpg','재직',201),
(9909,'김정훈','doyun73','교수',392,'2001-09-09 07:36:05',24,'yeongja93@naver.com','041-625-8390','http://myschool.ac.kr/photos/doyun73.jpg','휴직',201),
(9910,'강영호','seonghyeon92','조교수',593,'2011-04-03 07:37:22',NULL,'uyun@jusighoesa.kr','064-736-1077','http://myschool.ac.kr/photos/seonghyeon92.jpg','퇴직',201),
(9911,'박영미','yeongsui','조교수',486,'2015-11-29 01:07:18',22,'bagjeonghyi@baggweonseo.net','061-977-7396','http://myschool.ac.kr/photos/yeongsui.jpg','재직',201),
(9912,'윤서현','doyungu','조교수',266,'2011-07-22 09:22:36',20,'ki@daum.net','055-602-0551','http://myschool.ac.kr/photos/doyungu.jpg','재직',202),
(9913,'장정자','jgim','부교수',358,'2020-06-29 11:14:45',30,'seoyeoncoe@gweongim.kr','041-587-2280','http://myschool.ac.kr/photos/jgim.jpg','퇴직',203),
(9914,'김지아','jcoe','조교수',385,'2002-08-06 23:35:57',NULL,'ngim@live.com','051-018-9642','http://myschool.ac.kr/photos/jcoe.jpg','퇴직',203),
(9915,'이옥순','seonghoseo','교수',548,'2023-11-15 15:17:27',22,'agim@gimgim.kr','044-234-3359','http://myschool.ac.kr/photos/seonghoseo.jpg','재직',203),
(9916,'이정식','gimjia','전임강사',274,'2002-08-13 12:19:42',NULL,'doyun27@nate.com','02-1070-2228','http://myschool.ac.kr/photos/gimjia.jpg','퇴직',203),
(9917,'박경수','igim','전임강사',447,'2020-11-09 06:32:30',22,'isangceol@yu.com','052-537-9720','http://myschool.ac.kr/photos/igim.jpg','휴직',203),
(9918,'오미영','jongsu93','부교수',578,'2010-06-17 07:32:06',NULL,'byeongceolcoe@gmail.com','032-087-7731','http://myschool.ac.kr/photos/jongsu93.jpg','휴직',204),
(9919,'이명숙','minseog87','전임강사',384,'2002-12-03 07:22:12',NULL,'jiyeong54@ogim.com','032-840-6857','http://myschool.ac.kr/photos/minseog87.jpg','재직',301),
(9920,'장지후','isujin','조교수',328,'2005-01-30 18:03:04',NULL,'handonghyeon@live.com','042-757-1873','http://myschool.ac.kr/photos/isujin.jpg','퇴직',301),
(9921,'박현숙','dohyeongim','부교수',500,'2001-03-19 05:40:14',NULL,'ojongsu@namgim.org','031-257-4301','http://myschool.ac.kr/photos/dohyeongim.jpg','휴직',301),
(9922,'최정자','jihungim','전임강사',373,'2007-07-05 05:28:22',NULL,'kcoe@dreamwiz.com','033-713-4372','http://myschool.ac.kr/photos/jihungim.jpg','퇴직',301),
(9923,'박경희','sineunyeong','조교수',315,'2001-06-13 22:19:25',NULL,'yeongsunnam@igang.net','051-199-9499','http://myschool.ac.kr/photos/sineunyeong.jpg','퇴직',302),
(9924,'허예진','ghong','조교수',409,'2016-08-11 02:49:21',22,'boramsong@nate.com','016-149-5850','http://myschool.ac.kr/photos/ghong.jpg','퇴직',401),
(9925,'박영일','subinsong','전임강사',376,'2019-06-10 05:26:28',NULL,'doyunbaeg@jusighoesa.com','070-2273-7433','http://myschool.ac.kr/photos/subinsong.jpg','재직',401),
(9926,'김정웅','seoyeon95','조교수',253,'2012-07-24 21:27:58',NULL,'sanghun41@yuhanhoesa.net','018-039-4876','http://myschool.ac.kr/photos/seoyeon95.jpg','재직',402),
(9927,'진주원','yeonghwan49','부교수',300,'2020-09-21 02:49:53',NULL,'jinminsu@yungweon.net','054-082-9702','http://myschool.ac.kr/photos/yeonghwan49.jpg','퇴직',402),
(9928,'이영길','rgim','조교수',526,'2016-12-22 19:59:30',14,'gimminjae@jusighoesa.kr','052-314-9662','http://myschool.ac.kr/photos/rgim.jpg','휴직',402),
(9929,'최영식','gi','조교수',300,'2009-01-29 06:54:03',13,'gimjihye@hanmail.net','017-497-2511','http://myschool.ac.kr/photos/gi.jpg','휴직',402),
(9930,'박유진','jeongsu38','교수',277,'2011-05-25 13:10:56',NULL,'jihungim@gimim.net','055-284-0371','http://myschool.ac.kr/photos/jeongsu38.jpg','휴직',402);
/*!40000 ALTER TABLE `professors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '학생번호',
  `name` varchar(50) NOT NULL COMMENT '이름',
  `user_id` varchar(50) NOT NULL COMMENT '아이디',
  `grade` int(11) NOT NULL COMMENT '학년',
  `idnum` char(64) NOT NULL COMMENT '주민등록번호(SHA2 해시)',
  `birthdate` datetime NOT NULL COMMENT '생년월일',
  `phone` varchar(13) NOT NULL COMMENT '전화번호',
  `height` int(11) NOT NULL COMMENT '키',
  `weight` int(11) NOT NULL COMMENT '몸무게',
  `email` varchar(100) DEFAULT NULL COMMENT '이메일 주소',
  `gender` enum('남','여') DEFAULT NULL COMMENT '성별',
  `status` enum('재학','휴학','졸업','퇴학') DEFAULT '재학' COMMENT '학적 상태',
  `photo_url` varchar(255) DEFAULT NULL COMMENT '프로필 사진 경로',
  `admission_date` date DEFAULT NULL COMMENT '입학일',
  `graduation_date` date DEFAULT NULL COMMENT '졸업일',
  `department_id` int(11) NOT NULL COMMENT '소속 학과번호',
  `professor_id` int(11) DEFAULT NULL COMMENT '지도교수번호',
  PRIMARY KEY (`id`),
  KEY `department_id` (`department_id`),
  KEY `professor_id` (`professor_id`),
  CONSTRAINT `fk_students_departments` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`),
  CONSTRAINT `fk_students_professors` FOREIGN KEY (`professor_id`) REFERENCES `professors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10176 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='학생';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES
(10101,'황진우','hhan',1,'7b761b8750a5560337f93d1d4748ec2817a22e5c0f17af259ca0a2aae0077ec2','2001-10-19 00:00:00','017-8897-6693',151,62,'minjae67@yu.kr','남','재학','http://myschool.ac.kr/photos/hhan.jpg','2020-10-19',NULL,101,9901),
(10102,'서순옥','ojimin',4,'fbdb38da9369c4188434918c4b056dfeb623435cba6dc30ac8c1b183eaa2b755','1999-07-22 00:00:00','042-1305-3999',152,46,'iminjae@daum.net','남','재학','http://myschool.ac.kr/photos/ojimin.jpg','2018-07-22',NULL,101,NULL),
(10103,'백순옥','gimgyeonghyi',2,'2c2957eb732c867392b707f5a09ad86a3792f4036e1a067a6580dafa2f683fd0','2001-04-19 00:00:00','063-1754-8132',184,71,'eunju75@hotmail.com','남','재학','http://myschool.ac.kr/photos/gimgyeonghyi.jpg','2020-04-19',NULL,101,9901),
(10104,'김서연','yeonghogang',4,'9e23f8e8e8b3bca75ceb95ece80e0bd0a31198ebcc9e215ac2436cf107d012da','2005-07-16 00:00:00','041-1708-9682',171,62,'hyeonjii@gimhan.net','남','재학','http://myschool.ac.kr/photos/yeonghogang.jpg','2024-07-16',NULL,101,9901),
(10105,'박미영','ni',1,'773710c64f0889e3c54d191b4f123d3e233283dcd2959669b063016dbba9f4ea','2004-01-10 00:00:00','032-4691-2811',172,67,'jongsu11@hotmail.com','여','휴학','http://myschool.ac.kr/photos/ni.jpg','2023-01-10',NULL,101,9901),
(10106,'서현지','kgim',1,'c6173d6786e0d2566fd8262d2f0ec6cdc20987d24c6b6570c5d84bfa502d31a8','2005-04-25 00:00:00','017-7393-6126',185,63,'hyejingim@yu.net','여','재학','http://myschool.ac.kr/photos/kgim.jpg','2024-04-25',NULL,101,NULL),
(10107,'고정숙','gyeongsug76',2,'b878f226b928dd33ae250c1bdee2debb6e3ee8811f79f56aab675928184a73b6','2004-08-10 00:00:00','031-4249-8852',168,50,'yeji40@daum.net','남','졸업','http://myschool.ac.kr/photos/gyeongsug76.jpg','2023-08-10','2027-08-09',101,9901),
(10108,'송영미','mhan',2,'3d8cd8a8b559aeea97708d206cd419f009d4a33cefe9e9cd2680fbdf975ebebd','2005-08-06 00:00:00','032-1517-7567',173,67,'gju@yuhanhoesa.kr','남','재학','http://myschool.ac.kr/photos/mhan.jpg','2024-08-06',NULL,101,9901),
(10109,'안서윤','sangho09',2,'6e4f1ce2afe62ebb5d2eff25eac0a638a296ebf86d5df39ec24ddd0c6015db0e','2005-06-11 00:00:00','018-3440-5697',184,60,'subin24@nate.com','남','재학','http://myschool.ac.kr/photos/sangho09.jpg','2024-06-11',NULL,101,9901),
(10110,'성성민','yeongjin64',3,'52d41607a9241e34d815643586a3f51d3972a37ff7078241ff6f95ed3bf19046','2005-10-10 00:00:00','054-7045-6602',153,59,'yunseosong@live.com','남','휴학','http://myschool.ac.kr/photos/yeongjin64.jpg','2024-10-10',NULL,101,NULL),
(10111,'고미영','doyun18',3,'26befa41e26de777d0c982a70215f143d0e8ea405c3f7a20b15471aa802c2cc3','2006-01-04 00:00:00','064-7936-7461',163,86,'eyun@gmail.com','여','재학','http://myschool.ac.kr/photos/doyun18.jpg','2025-01-04',NULL,102,9904),
(10112,'장하윤','hyeonjeong23',2,'8171cb54dce6249575c98bd9f2941319cd889ad147621994ac0f513688f58b23','2004-10-19 00:00:00','011-3526-5155',165,80,'yejian@yuhanhoesa.com','여','휴학','http://myschool.ac.kr/photos/hyeonjeong23.jpg','2023-10-19',NULL,102,9904),
(10113,'최서영','junyeonggwag',2,'b0ee8d9942e1f192b412a15b215867f9493de7c16cf57659603d7bedc863d95a','2005-07-09 00:00:00','044-1601-9736',158,77,'jongsui@daum.net','여','재학','http://myschool.ac.kr/photos/junyeonggwag.jpg','2024-07-09',NULL,102,9903),
(10114,'김명숙','jinu82',4,'32e37de4f6c6794c167ec1e17c467dec35f9d566a6cff03b0cb92aac7679ff76','1999-10-04 00:00:00','042-194-8127',188,49,'eunjijang@gimjini.com','여','재학','http://myschool.ac.kr/photos/jinu82.jpg','2018-10-04',NULL,102,9906),
(10115,'황예지','cayeonghyi',1,'845356558241ab1e3e98e1bd2f53121f1e557139d32dfca18b49e44264ffda7f','2006-12-06 00:00:00','061-2439-3584',157,88,'bagsujin@gmail.com','여','휴학','http://myschool.ac.kr/photos/cayeonghyi.jpg','2025-12-06',NULL,102,9903),
(10116,'김정훈','yejingweon',4,'1695db96d6058063b110d42311b04f703ac1b1fee81dbad0788b7d594d827e70','2006-10-18 00:00:00','055-1035-7716',150,61,'dgim@daum.net','남','재학','http://myschool.ac.kr/photos/yejingweon.jpg','2025-10-18',NULL,102,9906),
(10117,'최혜진','yujin33',2,'593d4f9025e6d249684e0b384ab5dcc6c5858c6a3448dd1ef0959dcfe7873ad2','2001-03-17 00:00:00','042-2107-2047',159,68,'songminjun@live.com','남','재학','http://myschool.ac.kr/photos/yujin33.jpg','2020-03-17',NULL,102,9902),
(10118,'강지우','jiyejin',3,'b916bbb616ae7b0cac9b4e6744f47668e12e5f0406962f2cf22632db15ad0093','2003-09-02 00:00:00','041-5207-6667',181,46,'ihyeonu@ju.com','남','졸업','http://myschool.ac.kr/photos/jiyejin.jpg','2022-09-02','2026-09-01',102,9904),
(10119,'박은영','egim',2,'89043a70be43049c811ffd46c6bffe7a39a57fd1cdd4a06a1626ab421e323a92','2000-04-23 00:00:00','011-5577-9875',153,60,'seungmingweon@naver.com','남','재학','http://myschool.ac.kr/photos/egim.jpg','2019-04-23',NULL,102,NULL),
(10120,'박서현','hyeonji18',2,'6e2208af2fa52cca2e2ce3616dfaaf3b78a5a27a0dd8ecc5502239667dae317d','2000-03-04 00:00:00','010-2080-5361',158,87,'hcoe@ju.com','여','졸업','http://myschool.ac.kr/photos/hyeonji18.jpg','2019-03-04','2023-03-03',201,9911),
(10121,'한명자','bagjeonghun',4,'6a4a8aa77ad16ecd1667eb5d73b4121bd3feb480c7e8f3b9a0fd02b5fa1ac69f','2001-01-21 00:00:00','061-3914-7543',163,79,'seonghyeongweon@hotmail.com','남','휴학','http://myschool.ac.kr/photos/bagjeonghun.jpg','2020-01-21',NULL,201,9909),
(10122,'이순자','minjihwang',4,'dfbd86f30959d02a6698e7049c649575eed97d0ab2d3f41655ea09ff36cb06b6','2004-04-12 00:00:00','019-6034-5609',183,73,'bagmyeongsug@nate.com','남','재학','http://myschool.ac.kr/photos/minjihwang.jpg','2023-04-12',NULL,201,NULL),
(10123,'김병철','ki',2,'b0993aca44c7454cd8d100d7d812516e14be5cc93130f73ba2f179bc96eeaeb6','1999-11-20 00:00:00','017-8504-9523',187,59,'jeongsun07@hanmail.net','남','재학','http://myschool.ac.kr/photos/ki.jpg','2018-11-20',NULL,201,9907),
(10124,'최예지','ryang',3,'bf7a3bd1c024b9fa80126f1d0322387a4afd3167ac4009b77c834e4c7503f84a','1999-04-11 00:00:00','043-8552-3775',154,77,'najeongsig@ju.org','남','재학','http://myschool.ac.kr/photos/ryang.jpg','2018-04-11',NULL,201,9911),
(10125,'최정미','eomyeongsug',4,'8605e18d07c30888437dbe66e75673d4eb7bffba0a054d9906ec84caa3638335','1999-09-10 00:00:00','054-5720-0988',165,75,'bagmisug@hotmail.com','여','재학','http://myschool.ac.kr/photos/eomyeongsug.jpg','2018-09-10',NULL,201,9910),
(10126,'송정식','sangceol72',4,'35da11abe25d3bf3bb57999b9c561c417a1f6ab4f0ab1db65553a2ce7004efb3','1999-10-01 00:00:00','062-5868-5159',179,48,'gimeunju@dreamwiz.com','남','재학','http://myschool.ac.kr/photos/sangceol72.jpg','2018-10-01',NULL,201,9907),
(10127,'박은영','ihan',2,'f1a8d5c9b0dfe3ed135f8a0ac2a87ab8ef9dfac6ebe3e4fa6f03633d8840ed2e','2003-05-05 00:00:00','054-2958-9727',162,57,'sunja37@yuhanhoesa.org','여','재학','http://myschool.ac.kr/photos/ihan.jpg','2022-05-05',NULL,201,9907),
(10128,'이지원','gimhyejin',4,'9a7efa486cc14f47b746e68c1d5ffe878ad67232826068a36ffa85b0506ffbbc','2005-02-07 00:00:00','053-2896-1670',185,51,'ijihye@naver.com','남','재학','http://myschool.ac.kr/photos/gimhyejin.jpg','2024-02-07',NULL,201,NULL),
(10129,'김아름','gweonjia',2,'2ccd444a23e2f666ef54dd3b43cdb6c0ef1fe63b759d28f3cc292a39e4bf1e7a','2000-02-18 00:00:00','032-9023-7535',160,71,'hgim@yunbae.kr','여','재학','http://myschool.ac.kr/photos/gweonjia.jpg','2019-02-18',NULL,202,9912),
(10130,'문지호','jeonyeongja',4,'43521fc885a30e5e70bd3b2ce90d63d3e94a4da4adec46ef381e49c0a994b2a7','2005-03-19 00:00:00','044-1071-5331',150,69,'gimsugja@baghong.kr','여','졸업','http://myschool.ac.kr/photos/jeonyeongja.jpg','2024-03-19','2028-03-18',202,9912),
(10131,'권정수','yeongsigi',2,'c8830e437defaa612681a6a71cb1be41dde129ee6e88ea6e4806b8ec8f8b5f35','2005-04-30 00:00:00','019-5764-6275',162,63,'vgu@hanmail.net','남','퇴학','http://myschool.ac.kr/photos/yeongsigi.jpg','2024-04-30',NULL,202,9912),
(10132,'전미영','jeongungjo',1,'dc20eebc22cc0797a9fa6515e50bb70ba776423724be4b994fe9fdaeab12b058','2002-02-28 00:00:00','051-9510-0578',153,82,'icaeweon@jusighoesa.kr','여','재학','http://myschool.ac.kr/photos/jeongungjo.jpg','2021-02-28',NULL,202,9912),
(10133,'최현주','ean',2,'b5897e90436d8c26ee39aaf97af260b6babb47149d4e9576042201ed159202f5','1999-06-26 00:00:00','055-4433-2111',154,83,'yeongsun06@seoibaeg.com','남','재학','http://myschool.ac.kr/photos/ean.jpg','2018-06-26',NULL,202,9912),
(10134,'이민영','eunjui',1,'1b331873f01b46887dd744e06609d89db2da493407adbe02b110f207992eee98','2006-03-28 00:00:00','053-5337-4240',189,50,'yujin37@dreamwiz.com','여','재학','http://myschool.ac.kr/photos/eunjui.jpg','2025-03-28',NULL,203,9915),
(10135,'박가람','coeyunseo',2,'a6c80d3cadbe404754c4fff9d348c47fcf977c4bd3f147f863ad270a9bce9c89','2004-10-31 00:00:00','02-7259-4559',170,60,'jangseoyun@ju.com','여','재학','http://myschool.ac.kr/photos/coeyunseo.jpg','2023-10-31',NULL,203,9915),
(10136,'김준혁','gimjiyeong',1,'bd25c0bea72d090b3c2e7efdf5cfd902b989c707f6ed8405a4f7a1d79f44b787','2005-11-13 00:00:00','031-1991-0779',150,74,'seohyeonsug@juii.com','남','재학','http://myschool.ac.kr/photos/gimjiyeong.jpg','2024-11-13',NULL,203,9915),
(10137,'한영자','jiyeonghyi',1,'cebd16f4145b935fd46a9b801d1523ea4ae4af6ff9c7d1a8d46964ef669bb1f6','2005-08-01 00:00:00','017-0897-3248',165,68,'songsangho@dreamwiz.com','여','재학','http://myschool.ac.kr/photos/jiyeonghyi.jpg','2024-08-01',NULL,203,9917),
(10138,'홍지후','gusangho',1,'12b1736b58326f762b9761abfe91c50327e6993f79ad34cadca468fe5a720bc0','2004-12-20 00:00:00','019-4399-2722',185,64,'cunjagim@ibaeg.kr','남','졸업','http://myschool.ac.kr/photos/gusangho.jpg','2023-12-20','2027-12-19',203,9913),
(10139,'양영수','jongsu22',2,'d61558b9fc876ca6df3589381cbedcb6716330700599feacf508b8bb80d12183','1999-08-20 00:00:00','070-4768-5028',167,63,'seonghogwag@daum.net','남','휴학','http://myschool.ac.kr/photos/jongsu22.jpg','2018-08-20',NULL,203,9915),
(10140,'손영호','coeseungmin',4,'0d8081229379de71149c5ffb8756ceb154c86e8cea6b5900722acaa1253d65ef','2004-01-30 00:00:00','042-3128-2901',166,48,'nbag@ganggwag.kr','남','재학','http://myschool.ac.kr/photos/coeseungmin.jpg','2023-01-30',NULL,203,NULL),
(10141,'김영지','jimingim',3,'d0f103a3dff9fa17c27f324d32699ebfc3f476952bad20659b241ba46c94d834','1999-12-02 00:00:00','019-5351-5971',158,85,'ggim@jusighoesa.net','여','재학','http://myschool.ac.kr/photos/jimingim.jpg','2018-12-02',NULL,203,9917),
(10142,'심지아','jinubag',1,'d9f049f9d30a2da2971906c9449e09f16d8bf42ac63ac9a4c5f9192828330948','1999-08-28 00:00:00','011-2997-5207',157,49,'rjang@jusighoesa.org','남','재학','http://myschool.ac.kr/photos/jinubag.jpg','2018-08-28',NULL,203,9914),
(10143,'윤정희','minjae02',2,'bfa01bf20bb3dbc6cd28fe4aa273919df46ae823956c2aea087bcc9bb66fead6','2006-08-12 00:00:00','053-6841-8103',152,64,'jeonogja@naver.com','여','졸업','http://myschool.ac.kr/photos/minjae02.jpg','2025-08-12','2029-08-11',204,9918),
(10144,'권경숙','minseo39',2,'1c04c2b0cdf78792ad4880a0b16af83b046678fdc875a1e861930936b78b4218','2005-03-02 00:00:00','041-4083-8575',165,87,'ihyeonjun@daum.net','남','재학','http://myschool.ac.kr/photos/minseo39.jpg','2024-03-02',NULL,204,9918),
(10145,'배혜진','yeongho24',2,'4dad2e0475aac7764c51374a6be12c28bc31921cd9bd4b0d08cfb7d638b746f2','2002-06-12 00:00:00','062-2414-0213',160,56,'dohyeon60@gwagjiju.com','여','재학','http://myschool.ac.kr/photos/yeongho24.jpg','2021-06-12',NULL,204,9918),
(10146,'김은정','misuggim',2,'860476ec4211e35a67ebf9e4d397234afa908709fcd4df17bac9ee6edd851f37','2003-09-05 00:00:00','052-7656-3129',167,55,'gwangsui@baggwago.kr','남','재학','http://myschool.ac.kr/photos/misuggim.jpg','2022-09-05',NULL,204,9918),
(10147,'권민준','seoyun91',4,'c8b23a4dad6e6cd641c4f2a5e03fda3029ddce61bf70276ce5a305f4688ea20c','2004-10-30 00:00:00','063-7780-7911',172,64,'junho69@gmail.com','남','재학','http://myschool.ac.kr/photos/seoyun91.jpg','2023-10-30',NULL,204,9918),
(10148,'김서연','jo',1,'7f1d7b4932102b572d9efe05934ddb87f6647e20636eff15e2dbf0293828063f','2001-07-24 00:00:00','052-1721-4653',167,67,'gimjeongnam@yu.net','여','재학','http://myschool.ac.kr/photos/jo.jpg','2020-07-24',NULL,204,9918),
(10149,'김자영','sgim',1,'b33a78218c3bb3e0193891a6e9dfad3a16d0f10497d28ca9b8582e004e2fbb18','2007-01-16 00:00:00','070-7807-6674',166,56,'yunyeongceol@yu.org','여','재학','http://myschool.ac.kr/photos/sgim.jpg','2026-01-16',NULL,204,9918),
(10150,'양도윤','yeongil06',4,'138feb53af49816d690d40f9ad2045d15d9ee4bc10d89fb3eca72cb64d4294d2','2006-03-28 00:00:00','052-2241-7778',188,77,'dgim@munio.org','남','재학','http://myschool.ac.kr/photos/yeongil06.jpg','2025-03-28',NULL,204,9918),
(10151,'심지현','jiweon13',2,'44733de63a2749363f886aa84f457cb1c632f0704e9f7a8b172ad6d2cf0366eb','2006-02-03 00:00:00','051-5788-7189',173,72,'gyeongsuggweon@hanmail.net','남','졸업','http://myschool.ac.kr/photos/jiweon13.jpg','2025-02-03','2029-02-02',301,9919),
(10152,'민지민','myang',3,'4cf5bb0c44a78f4131dc1056866a70344b565513e261ef3d4fee718704d70a0f','2006-06-14 00:00:00','011-8562-7725',182,64,'gimminsu@munsimseong.kr','여','재학','http://myschool.ac.kr/photos/myang.jpg','2025-06-14',NULL,301,9920),
(10153,'손지후','cyu',4,'eee5e239549f33adf24d4d9f02a75da1ec430cab94d1368ab063e583cadc8bbb','1999-10-29 00:00:00','051-2572-8527',174,88,'coeeunju@live.com','남','재학','http://myschool.ac.kr/photos/cyu.jpg','2018-10-29',NULL,301,9919),
(10154,'오영미','si',3,'e9fba28cbc8cf4b7ad05af3a03175651d97198430034fa40d4de31a23258ff8b','2000-03-29 00:00:00','055-3549-7256',168,58,'fgim@hanmail.net','여','휴학','http://myschool.ac.kr/photos/si.jpg','2019-03-29',NULL,301,9922),
(10155,'김수민','ogjagim',4,'aa0d454a6fb9e7654205e16082ef69716c4d7588c60a777d8bce11f19eb7605d','1999-11-06 00:00:00','063-6194-1106',163,77,'gimboram@hanmail.net','여','휴학','http://myschool.ac.kr/photos/ogjagim.jpg','2018-11-06',NULL,301,9919),
(10156,'이민영','gimyeongmi',3,'8c336a52d08d09573faf94103673199cb663afb8d55117aee567a4295549147b','2000-03-12 00:00:00','054-2461-4562',155,60,'jeonghunyun@yu.com','여','재학','http://myschool.ac.kr/photos/gimyeongmi.jpg','2019-03-12',NULL,302,NULL),
(10157,'백승현','gujiu',2,'d6e3eaebfc3348fe36092d290520cbfbb5bcde754e80366342e80e0b17288771','2005-10-30 00:00:00','02-5470-7683',180,84,'qgim@jusighoesa.com','남','재학','http://myschool.ac.kr/photos/gujiu.jpg','2024-10-30',NULL,302,9923),
(10158,'박민석','jeonseongmin',4,'963f687af54094f1f0589613bdd691293cd68fc4ad5e601329cfec4f377f4be3','2003-03-10 00:00:00','051-1097-6035',175,60,'jyang@naver.com','남','재학','http://myschool.ac.kr/photos/jeonseongmin.jpg','2022-03-10',NULL,302,9923),
(10159,'구영미','simseunghyeon',4,'27897a20cc11faebb793401464340e9e33579805fb6d87b830390b67fd96891e','2002-03-27 00:00:00','016-1167-1565',164,56,'gimyeongho@naver.com','여','재학','http://myschool.ac.kr/photos/simseunghyeon.jpg','2021-03-27',NULL,302,9923),
(10160,'김서연','sujingim',2,'845d9ab9aa6d2b8a8ee04c2507fba253ce20b9a412a070c3b2ce92fc8da13d0a','2006-11-24 00:00:00','053-7802-2592',179,87,'myeongjayang@ii.kr','여','퇴학','http://myschool.ac.kr/photos/sujingim.jpg','2025-11-24',NULL,302,9923),
(10161,'이서윤','msong',4,'ea6752363c8fa05ad7bba1cebd99219d1c1691f7ec61878b536a00eaab1aaf19','2004-12-31 00:00:00','031-8020-0437',160,75,'gimyeeun@live.com','여','재학','http://myschool.ac.kr/photos/msong.jpg','2023-12-31',NULL,302,9923),
(10162,'김현지','nojiweon',2,'0a57c4219b00b70512a66c771dfcc9f46227a2d9528ae834ee2ed3d9a5fe5098','2003-12-14 00:00:00','019-4598-0988',167,73,'lsong@jusighoesa.com','남','휴학','http://myschool.ac.kr/photos/nojiweon.jpg','2022-12-14',NULL,302,9923),
(10163,'이광수','lseo',2,'de0fda5289c41925bd08424454fb30f734800e349c7deaa2a1455a3657be88e0','2001-02-07 00:00:00','032-5581-1062',164,69,'yeonghwan67@hotmail.com','남','휴학','http://myschool.ac.kr/photos/lseo.jpg','2020-02-07',NULL,401,9925),
(10164,'권영진','minjaebag',4,'4821e6a40d555e582db7a7540727f020714952901c8fc61120bcda6ec300a8b2','1999-04-02 00:00:00','070-1254-7258',153,58,'iyejin@imun.kr','여','재학','http://myschool.ac.kr/photos/minjaebag.jpg','2018-04-02',NULL,401,9924),
(10165,'박은영','jihuyun',4,'ab8befe22cac0c815e153655cec98696d188eb8fb8d970be0db2326690918c4b','2002-12-04 00:00:00','055-6744-2655',180,45,'yejungo@baesimbag.org','여','재학','http://myschool.ac.kr/photos/jihuyun.jpg','2021-12-04',NULL,401,9925),
(10166,'이주원','xbag',2,'64a7a2c1703e8b07901276f593d9222a4cf91b45e89341031f850b3d4819573c','2001-05-20 00:00:00','064-7863-5458',181,59,'seonyeongi@naver.com','여','재학','http://myschool.ac.kr/photos/xbag.jpg','2020-05-20',NULL,401,9925),
(10167,'이진우','yeongceol98',2,'5ebc188371175d6ad473d9531049bcccb26f5d23623793ebcaed0470a7f738b5','2001-01-07 00:00:00','011-6823-9453',179,53,'hyejin77@naver.com','남','졸업','http://myschool.ac.kr/photos/yeongceol98.jpg','2020-01-07','2024-01-06',401,9924),
(10168,'오하윤','yeongsugbag',4,'9baa0e1bce9513536c4b80b91b6e3d8842ba09fd451c64f1f14d17edb36052dd','2002-04-19 00:00:00','016-4336-8577',158,74,'jaehogim@daum.net','남','재학','http://myschool.ac.kr/photos/yeongsugbag.jpg','2021-04-19',NULL,401,9925),
(10169,'강재현','gimboram',4,'c90ec713328b27e99be3232ab5d0f3c63d15d23be1f1ee4ad56ee2aa158db795','2007-01-31 00:00:00','054-7416-9188',167,71,'yeonggilgim@igim.kr','여','휴학','http://myschool.ac.kr/photos/gimboram.jpg','2026-01-31',NULL,402,9926),
(10170,'황동현','yeongil91',3,'07dfa0be849d170c15124a060d991baceb20b042f20ecdf4597c95056ff6f912','2003-01-12 00:00:00','018-6764-0085',164,86,'eunseo74@naver.com','남','휴학','http://myschool.ac.kr/photos/yeongil91.jpg','2022-01-12',NULL,402,9927),
(10171,'배미정','jiagim',2,'099efdf307343b1b6891c0857c5c8bfa1927358cc0bab94266099e867364a76f','2006-12-08 00:00:00','054-4911-0236',151,84,'yeongsig15@hotmail.com','남','재학','http://myschool.ac.kr/photos/jiagim.jpg','2025-12-08',NULL,402,9927),
(10172,'김숙자','ugim',4,'f72a878c6686212f0facaebb6778d0c0deed3c90af88cdc54f47ea7787f260d1','2004-05-04 00:00:00','051-2773-1391',166,68,'hyeonjunsong@dreamwiz.com','남','재학','http://myschool.ac.kr/photos/ugim.jpg','2023-05-04',NULL,402,9927),
(10173,'안선영','jiweongim',3,'6e03a5f36c1ec3e3a2ce64273bcfe6e45ddc8f7287e1e3e7468ee0e0ba9eba2f','2001-03-13 00:00:00','033-4852-7910',156,82,'boramo@gimgimgim.com','남','졸업','http://myschool.ac.kr/photos/jiweongim.jpg','2020-03-13','2024-03-12',402,9929),
(10174,'이지민','geonu06',4,'7409254bfe5c873dcef673b8fc6d6a5147d235923a1933d82796a39436a92c53','2006-08-30 00:00:00','070-4903-8642',162,49,'hanyeongceol@live.com','남','재학','http://myschool.ac.kr/photos/geonu06.jpg','2025-08-30',NULL,402,9930),
(10175,'문은서','gyeongsu72',1,'f7a4dc511a56943db3aacf3e57892a43e47407c1cf451a7b1d468f85506bebf6','2003-09-10 00:00:00','016-8893-7377',186,47,'yeongsu76@live.com','여','재학','http://myschool.ac.kr/photos/gyeongsu72.jpg','2022-09-10',NULL,402,NULL);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '과목번호',
  `name` varchar(100) NOT NULL COMMENT '과목명',
  `credit` int(11) NOT NULL COMMENT '학점',
  `department_id` int(11) NOT NULL COMMENT '개설 학과',
  `professor_id` int(11) DEFAULT NULL COMMENT '담당 교수',
  PRIMARY KEY (`id`),
  KEY `department_id` (`department_id`),
  KEY `professor_id` (`professor_id`),
  CONSTRAINT `subjects_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`),
  CONSTRAINT `subjects_ibfk_2` FOREIGN KEY (`professor_id`) REFERENCES `professors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1028 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='과목';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES
(1001,'JAVA 프로그래밍',2,101,9901),
(1002,'기계설계',3,101,9901),
(1003,'소프트웨어 공학',2,101,9901),
(1004,'3D모델링',3,102,9906),
(1005,'연구윤리',1,102,9905),
(1006,'금융의 이해',1,201,9907),
(1007,'웹프로그래밍',3,201,9910),
(1008,'그래픽디자인',2,201,9910),
(1009,'시스템 설계',3,202,9912),
(1010,'운영체제',3,202,9912),
(1011,'임베디드 프로그래밍',3,202,9912),
(1012,'모바일프로그래밍',3,203,9917),
(1013,'사진학개론',1,203,9917),
(1014,'심리학개론',1,203,9913),
(1015,'네트워크 보안',2,204,9918),
(1016,'인공지능',3,204,9918),
(1017,'텍스트 마이닝',2,301,9922),
(1018,'멀티미디어개론',2,301,9921),
(1019,'3D 프로그래밍',3,302,9923),
(1020,'게임 프로그래밍',3,302,9923),
(1021,'2D 그래픽',3,302,9923),
(1022,'파이썬 프로그래밍',2,401,9925),
(1023,'캡스톤디자인',2,401,9924),
(1024,'알고리즘',2,401,9924),
(1025,'머신러닝',3,402,9926),
(1026,'데이터베이스',2,402,9928),
(1027,'해킹과 보안',2,402,9928);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'myschool'
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_TABLE_INFO` */;
ALTER DATABASE `myschool` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_TABLE_INFO`()
BEGIN
    
    DECLARE _done INT DEFAULT FALSE;

    
    DECLARE _current_schema VARCHAR(100);

    
    DECLARE _table_name VARCHAR(100);

    
    DECLARE MY_CURSOR CURSOR FOR
        SELECT table_name
        FROM information_schema.tables
        WHERE table_schema = DATABASE();

    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET _done = TRUE;

    
    SET _current_schema = DATABASE();

    
    OPEN MY_CURSOR;

    
    read_loop: REPEAT
        FETCH MY_CURSOR INTO _table_name;

        IF NOT _done THEN
            
            SELECT
                _table_name AS '테이블',
                col.ORDINAL_POSITION AS '번호',
                col.COLUMN_NAME AS '필드명',
                col.COLUMN_TYPE AS '속성',
                col.IS_NULLABLE AS 'NULL',
								col.COLUMN_KEY AS 'KEY',
                col.EXTRA AS '자동증가',
                col.COLUMN_DEFAULT AS '기본값',
								IF (col.COLUMN_COMMENT IS NOT NULL AND col.COLUMN_COMMENT != '', 
										CONCAT(col.COLUMN_COMMENT, ' (', kcu.REFERENCED_TABLE_NAME, '.', kcu.REFERENCED_COLUMN_NAME, ')'),
										CONCAT('(', kcu.REFERENCED_TABLE_NAME, '.', kcu.REFERENCED_COLUMN_NAME, ')')) AS '설명'
            FROM
                information_schema.COLUMNS AS col
						LEFT OUTER JOIN 
								information_schema.KEY_COLUMN_USAGE AS kcu
						ON
								col.TABLE_NAME = kcu.TABLE_NAME AND col.COLUMN_NAME = kcu.COLUMN_NAME
            WHERE
                col.TABLE_SCHEMA = _current_schema
                AND col.TABLE_NAME = _table_name
            ORDER BY
                col.ORDINAL_POSITION;
        END IF;

    UNTIL _done END REPEAT read_loop;

    
    CLOSE MY_CURSOR;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `myschool` CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-04-11 10:48:31
