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

DROP DATABASE IF EXISTS myschool;

CREATE DATABASE myschool CHARSET utf8mb4;

USE myschool;

--
-- Table structure for table `ANIMAL_INS`
--

DROP TABLE IF EXISTS `ANIMAL_INS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `ANIMAL_INS` (
  `ANIMAL_ID` varchar(7) NOT NULL COMMENT '아이디',
  `ANIMAL_TYPE` varchar(3) NOT NULL COMMENT '생물 종',
  `DATETIME` datetime NOT NULL COMMENT '보호 시작일',
  `INTAKE_CONDITION` varchar(7) NOT NULL COMMENT '보호 시작시 상태',
  `NAME` varchar(12) DEFAULT NULL COMMENT '이름',
  `SEX_UPON_INTAKE` varchar(13) NOT NULL COMMENT '성별 및 중성화 여부',
  PRIMARY KEY (`ANIMAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='동물';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ANIMAL_INS`
--

LOCK TABLES `ANIMAL_INS` WRITE;
/*!40000 ALTER TABLE `ANIMAL_INS` DISABLE KEYS */;
INSERT INTO `ANIMAL_INS` VALUES
('A349996','Cat','2018-01-22 14:32:00','Normal','Sugar','Neutered Male'),
('A350276','Cat','2017-08-13 13:50:00','Normal','Jewel','Spayed Female'),
('A350375','Cat','2017-03-06 15:01:00','Normal','Meo','Neutered Male'),
('A352555','Dog','2014-08-08 04:20:00','Normal','Harley','Spayed Female'),
('A352713','Cat','2017-04-13 16:29:00','Normal','Gia','Spayed Female'),
('A352872','Dog','2015-07-09 17:51:00','Aged','Peanutbutter','Neutered Male'),
('A353259','Dog','2016-05-08 12:57:00','Injured','Bj','Neutered Male'),
('A354540','Cat','2014-12-11 11:48:00','Normal','Tux','Neutered Male'),
('A354597','Cat','2014-05-02 12:16:00','Normal','Ariel','Spayed Female'),
('A354725','Dog','2015-08-26 11:51:00','Normal','Kia','Spayed Female'),
('A354753','Dog','2017-04-21 11:33:00','Normal','Sammy','Neutered Male'),
('A355519','Dog','2015-05-08 18:34:00','Normal','Faith','Spayed Female'),
('A355688','Dog','2014-01-26 13:48:00','Normal','Shadow','Neutered Male'),
('A355753','Dog','2015-09-10 13:14:00','Normal','Elijah','Neutered Male'),
('A357021','Dog','2014-12-03 15:15:00','Normal','Queens','Spayed Female'),
('A357444','Dog','2016-03-11 15:43:00','Normal','Puppy','Neutered Male'),
('A357846','Dog','2016-03-17 14:09:00','Normal','Happy','Neutered Male'),
('A358697','Dog','2015-02-06 12:12:00','Normal','Fuzzo','Neutered Male'),
('A358879','Dog','2015-09-14 16:52:00','Normal','Simba','Neutered Male'),
('A361391','Dog','2015-03-30 11:36:00','Normal','Baby Bear','Neutered Male'),
('A362103','Dog','2014-11-18 21:20:00','Normal','Stitch','Neutered Male'),
('A362383','Dog','2016-04-21 08:19:00','Normal','*Morado','Neutered Male'),
('A362707','Dog','2016-01-27 12:27:00','Sick','Girly Girl','Spayed Female'),
('A362967','Dog','2014-06-08 18:19:00','Normal','Honey','Spayed Female'),
('A363653','Dog','2014-11-17 17:39:00','Normal','Goofy','Neutered Male'),
('A364429','Dog','2015-09-28 16:26:00','Normal','Hugo','Neutered Male'),
('A365172','Dog','2014-08-26 12:53:00','Normal','Diablo','Neutered Male'),
('A365302','Dog','2017-01-08 16:34:00','Aged','Minnie','Spayed Female'),
('A367012','Dog','2015-09-16 09:06:00','Sick','Miller','Neutered Male'),
('A367438','Dog','2015-09-10 16:01:00','Normal','Cookie','Spayed Female'),
('A367747','Dog','2014-10-19 14:49:00','Normal','Woody','Neutered Male'),
('A368742','Dog','2018-02-03 10:40:00','Aged','Stormy','Spayed Female'),
('A368930','Dog','2014-06-08 13:20:00','Normal',NULL,'Spayed Female'),
('A370439','Dog','2016-06-25 11:46:00','Normal','Sniket','Neutered Male'),
('A370507','Cat','2014-10-27 14:43:00','Normal','Emily','Spayed Female'),
('A370852','Dog','2013-11-03 15:04:00','Normal','Katie','Spayed Female'),
('A371000','Cat','2015-07-29 16:07:00','Normal','Greg','Neutered Male'),
('A371102','Dog','2015-08-03 09:09:00','Normal','Ceballo','Neutered Male'),
('A371344','Dog','2015-05-11 12:33:00','Normal','Sailor','Neutered Male'),
('A371534','Dog','2016-06-07 17:42:00','Normal','April','Spayed Female'),
('A373219','Cat','2014-07-29 11:43:00','Normal','Ella','Spayed Female'),
('A373687','Dog','2014-03-20 12:31:00','Normal','Rosie','Spayed Female'),
('A375393','Dog','2015-06-12 12:47:00','Aged','Dash','Neutered Male'),
('A376322','Dog','2014-02-18 12:24:00','Normal','Mama Dog','Spayed Female'),
('A376459','Dog','2017-07-09 07:42:00','Normal','Dora','Spayed Female'),
('A377750','Dog','2017-10-25 17:17:00','Normal','Lucy','Spayed Female'),
('A378348','Dog','2014-01-25 14:38:00','Normal','Frijolito','Neutered Male'),
('A378353','Dog','2014-08-02 11:23:00','Aged','Lyla','Intact Female'),
('A378818','Dog','2014-07-05 07:13:00','Normal','Zoe','Spayed Female'),
('A378946','Dog','2017-09-28 13:36:00','Normal','Mercedes','Spayed Female'),
('A379998','Dog','2013-10-23 11:42:00','Normal','Disciple','Intact Male'),
('A380009','Dog','2016-02-01 14:35:00','Normal','Pickle','Spayed Female'),
('A380320','Dog','2014-02-03 12:41:00','Normal','Scooby','Neutered Male'),
('A380420','Dog','2017-08-04 16:45:00','Normal','Laika','Spayed Female'),
('A380506','Dog','2016-01-22 17:13:00','Normal','Ruby','Spayed Female'),
('A381173','Dog','2014-08-06 12:07:00','Normal','Pepper','Spayed Female'),
('A381217','Dog','2017-07-08 09:41:00','Sick','Cherokee','Neutered Male'),
('A382192','Dog','2015-03-13 13:14:00','Normal','Maxwell 2','Intact Male'),
('A382251','Dog','2014-11-08 16:14:00','Normal','Princess','Spayed Female'),
('A383036','Cat','2014-05-29 12:31:00','Normal','Oreo','Neutered Male'),
('A383964','Dog','2017-02-05 12:27:00','Normal','Finney','Neutered Male'),
('A384360','Cat','2014-07-04 01:55:00','Injured','Jj','Neutered Male'),
('A384568','Cat','2014-12-13 15:19:00','Normal','Jedi','Neutered Male'),
('A385442','Dog','2014-01-11 15:15:00','Normal','Clyde','Neutered Male'),
('A386005','Dog','2015-09-25 18:17:00','Normal','Giovanni','Neutered Male'),
('A386276','Cat','2015-12-19 12:52:00','Normal','Tiko','Neutered Male'),
('A386688','Dog','2015-08-17 12:55:00','Aged','Punch','Neutered Male'),
('A387083','Dog','2014-02-01 18:36:00','Normal','Goldie','Spayed Female'),
('A387965','Dog','2014-06-25 16:58:00','Sick','Dakota','Spayed Female'),
('A388360','Dog','2015-12-25 10:13:00','Sick','Spider','Neutered Male'),
('A388691','Dog','2015-11-27 15:59:00','Normal','Blaze','Neutered Male'),
('A390222','Dog','2013-12-08 17:04:00','Normal','Holly','Spayed Female'),
('A391512','Dog','2016-04-06 15:53:00','Normal','Rome','Neutered Male'),
('A391858','Dog','2017-03-16 16:53:00','Normal','Nellie','Spayed Female'),
('A392027','Dog','2014-01-31 13:46:00','Normal','Penny','Spayed Female'),
('A392075','Dog','2013-11-20 13:09:00','Normal','Skips','Neutered Male'),
('A392615','Dog','2015-07-26 11:39:00','Normal','Chip','Neutered Male'),
('A394547','Dog','2015-01-24 16:14:00','Normal','Snickerdoodl','Spayed Female'),
('A395451','Dog','2015-12-27 17:42:00','Normal','Rogan','Neutered Male'),
('A396810','Dog','2016-08-22 16:13:00','Injured','Raven','Spayed Female'),
('A397882','Dog','2017-07-12 14:43:00','Injured','Charlie','Neutered Male'),
('A399421','Dog','2015-08-25 14:08:00','Normal','Lucy','Spayed Female'),
('A399552','Dog','2013-10-14 15:38:00','Normal','Jack','Neutered Male'),
('A400498','Dog','2016-10-04 20:31:00','Normal','Reggie','Neutered Male'),
('A400680','Dog','2017-06-17 13:29:00','Normal','Lucy','Spayed Female'),
('A403564','Dog','2013-11-18 17:03:00','Normal','Anna','Spayed Female'),
('A405494','Dog','2014-05-16 14:17:00','Normal','Kaila','Spayed Female'),
('A406756','Dog','2016-05-12 20:23:00','Injured','Sabrina','Spayed Female'),
('A407156','Dog','2016-10-18 11:01:00','Normal','Jake','Neutered Male'),
('A408035','Dog','2014-12-25 12:02:00','Normal','Lizzie','Spayed Female'),
('A409637','Dog','2016-04-02 11:36:00','Aged','Stanley','Neutered Male'),
('A410330','Dog','2016-09-11 14:09:00','Sick','Chewy','Intact Female'),
('A410668','Cat','2015-11-19 13:41:00','Normal','Raven','Spayed Female'),
('A410684','Cat','2014-06-21 12:25:00','Normal','Mitty','Spayed Female'),
('A412173','Dog','2015-07-28 18:17:00','Normal','Jimminee','Neutered Male'),
('A412626','Dog','2016-03-13 11:17:00','Normal','*Sam','Neutered Male'),
('A412697','Dog','2016-01-03 16:25:00','Normal','Jackie','Neutered Male'),
('A413789','Dog','2016-04-19 13:28:00','Normal','Benji','Spayed Female'),
('A414198','Dog','2015-01-29 15:01:00','Normal','Shelly','Spayed Female'),
('A414513','Dog','2016-06-07 09:17:00','Normal','Rocky','Neutered Male');
/*!40000 ALTER TABLE `ANIMAL_INS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BOOK`
--

DROP TABLE IF EXISTS `BOOK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `BOOK` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '도서 ID',
  `category` varchar(255) NOT NULL COMMENT '카테고리 (경제, 인문, 소설, 생활, 기술)',
  `author_id` int(11) NOT NULL COMMENT '저자 ID',
  `price` int(11) NOT NULL COMMENT '판매가',
  `published_date` date NOT NULL COMMENT '출판일',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='도서';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BOOK`
--

LOCK TABLES `BOOK` WRITE;
/*!40000 ALTER TABLE `BOOK` DISABLE KEYS */;
INSERT INTO `BOOK` VALUES
(1,'경제',1,9000,'2020-01-10'),
(2,'경제',1,12000,'2021-06-10'),
(3,'인문',1,11000,'2021-10-24'),
(4,'소설',2,7500,'2020-03-03'),
(5,'기술',3,11000,'2020-02-17'),
(6,'기술',3,8000,'2020-04-29'),
(7,'생활',3,9500,'2021-08-20');
/*!40000 ALTER TABLE `BOOK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CAR_RENTAL_COMPANY_CAR`
--

DROP TABLE IF EXISTS `CAR_RENTAL_COMPANY_CAR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `CAR_RENTAL_COMPANY_CAR` (
  `CAR_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '자동차 ID',
  `CAR_TYPE` varchar(255) NOT NULL COMMENT '자동차 종류 (세단, SUV, 승합차, 트럭, 리무진)',
  `DAILY_FEE` int(11) NOT NULL COMMENT '일일 대여 요금 (원)',
  `OPTIONS` varchar(255) NOT NULL COMMENT '자동차 옵션 리스트 (","로 구분된 옵션 키워드 리스트. 키워드 종류: 주차감지센서,스마트키,네비게이션,통풍시트,열선시트,후방카메라,가죽시트)',
  PRIMARY KEY (`CAR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='자동차 대여 회사 자동차 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAR_RENTAL_COMPANY_CAR`
--

LOCK TABLES `CAR_RENTAL_COMPANY_CAR` WRITE;
/*!40000 ALTER TABLE `CAR_RENTAL_COMPANY_CAR` DISABLE KEYS */;
INSERT INTO `CAR_RENTAL_COMPANY_CAR` VALUES
(1,'트럭',102000,'주차감지센서,열선시트'),
(2,'SUV',148000,'주차감지센서,후방카메라'),
(3,'세단',55000,'스마트키,통풍시트,가죽시트'),
(4,'SUV',150000,'주차감지센서,스마트키,열선시트,후방카메라,가죽시트'),
(5,'SUV',127000,'주차감지센서,스마트키'),
(6,'트럭',133000,'주차감지센서,스마트키'),
(7,'승합차',150000,'스마트키,통풍시트,열선시트,후방카메라'),
(8,'트럭',107000,'주차감지센서,통풍시트,열선시트'),
(9,'SUV',84000,'주차감지센서,스마트키'),
(10,'세단',162000,'주차감지센서,스마트키,후방카메라'),
(11,'승합차',122000,'열선시트,후방카메라'),
(12,'트럭',142000,'후방카메라'),
(13,'승합차',144000,'네비게이션'),
(14,'SUV',77000,'주차감지센서,스마트키,열선시트,후방카메라'),
(15,'승합차',114000,'주차감지센서,통풍시트,후방카메라'),
(16,'세단',168000,'주차감지센서,열선시트,후방카메라'),
(17,'SUV',107000,'스마트키,후방카메라'),
(18,'SUV',22000,'주차감지센서,스마트키,열선시트,후방카메라'),
(19,'SUV',79000,'주차감지센서,스마트키,열선시트,후방카메라'),
(20,'트럭',168000,'주차감지센서,통풍시트'),
(21,'리무진',250000,'주차감지센서,스마트키,통풍시트,후방카메라'),
(22,'세단',186000,'주차감지센서,스마트키,통풍시트'),
(23,'세단',50000,'스마트키,네비게이션,열선시트'),
(24,'세단',184000,'주차감지센서,스마트키,열선시트,후방카메라'),
(25,'세단',115000,'주차감지센서,열선시트'),
(26,'SUV',126000,'주차감지센서,통풍시트'),
(27,'SUV',23000,'주차감지센서,스마트키,통풍시트'),
(28,'리무진',298000,'주차감지센서,스마트키,네비게이션,열선시트,후방카메라,가죽시트'),
(29,'SUV',88000,'주차감지센서,후방카메라'),
(30,'트럭',140000,'주차감지센서,스마트키');
/*!40000 ALTER TABLE `CAR_RENTAL_COMPANY_CAR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CAR_RENTAL_COMPANY_RENTAL_HISTORY`
--

DROP TABLE IF EXISTS `CAR_RENTAL_COMPANY_RENTAL_HISTORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `CAR_RENTAL_COMPANY_RENTAL_HISTORY` (
  `HISTORY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '자동차 대여 기록 ID',
  `CAR_ID` int(11) NOT NULL COMMENT '자동차 대여 회사 자동차 ID',
  `START_DATE` date NOT NULL COMMENT '대여 시작일',
  `END_DATE` date NOT NULL COMMENT '대여 종료일',
  PRIMARY KEY (`HISTORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=725 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='자동차 대여 회사 자동차 대여 기록';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAR_RENTAL_COMPANY_RENTAL_HISTORY`
--

LOCK TABLES `CAR_RENTAL_COMPANY_RENTAL_HISTORY` WRITE;
/*!40000 ALTER TABLE `CAR_RENTAL_COMPANY_RENTAL_HISTORY` DISABLE KEYS */;
INSERT INTO `CAR_RENTAL_COMPANY_RENTAL_HISTORY` VALUES
(506,15,'2022-08-01','2022-08-02'),
(507,26,'2022-08-01','2022-11-09'),
(508,27,'2022-08-01','2022-08-02'),
(510,29,'2022-08-02','2022-08-05'),
(511,13,'2022-08-03','2022-08-07'),
(512,27,'2022-08-03','2022-08-04'),
(513,28,'2022-08-03','2022-08-03'),
(517,2,'2022-08-05','2022-08-07'),
(518,5,'2022-08-05','2022-08-08'),
(519,23,'2022-08-05','2022-08-06'),
(520,25,'2022-08-05','2022-08-07'),
(521,27,'2022-08-05','2022-08-06'),
(523,7,'2022-08-06','2022-08-08'),
(524,8,'2022-08-06','2022-08-06'),
(527,8,'2022-08-07','2022-08-11'),
(528,19,'2022-08-07','2022-09-16'),
(529,28,'2022-08-07','2022-08-21'),
(530,29,'2022-08-07','2022-08-11'),
(531,23,'2022-08-08','2022-08-21'),
(532,25,'2022-08-08','2022-08-09'),
(534,2,'2022-08-09','2022-08-09'),
(535,5,'2022-08-09','2022-08-09'),
(536,27,'2022-08-09','2022-08-16'),
(537,2,'2022-08-10','2022-08-20'),
(538,5,'2022-08-10','2022-08-10'),
(539,9,'2022-08-10','2022-08-10'),
(540,15,'2022-08-10','2022-09-19'),
(542,25,'2022-08-11','2022-08-12'),
(545,5,'2022-08-12','2022-09-21'),
(546,8,'2022-08-12','2022-08-13'),
(547,13,'2022-08-12','2022-08-14'),
(548,16,'2022-08-13','2022-08-13'),
(549,29,'2022-08-13','2022-08-13'),
(551,7,'2022-08-14','2022-08-15'),
(552,25,'2022-08-14','2022-08-14'),
(556,8,'2022-08-16','2022-08-23'),
(558,6,'2022-08-17','2022-09-21'),
(559,13,'2022-08-17','2022-08-19'),
(560,16,'2022-08-17','2022-11-15'),
(561,25,'2022-08-17','2022-08-27'),
(562,9,'2022-08-18','2022-08-20'),
(564,7,'2022-08-19','2022-08-22'),
(567,10,'2022-08-20','2022-08-21'),
(568,2,'2022-08-21','2022-08-23'),
(569,29,'2022-08-21','2022-11-29'),
(571,9,'2022-08-22','2022-10-01'),
(573,7,'2022-08-23','2022-09-22'),
(574,13,'2022-08-23','2022-08-24'),
(575,2,'2022-08-24','2022-08-28'),
(576,27,'2022-08-24','2022-09-23'),
(577,10,'2022-08-25','2022-08-26'),
(578,23,'2022-08-25','2022-09-01'),
(579,28,'2022-08-25','2022-09-08'),
(581,8,'2022-08-26','2022-08-27'),
(582,10,'2022-08-27','2022-08-29'),
(583,13,'2022-08-27','2022-09-06'),
(586,8,'2022-08-29','2022-08-30'),
(587,11,'2022-08-29','2022-08-29'),
(591,8,'2022-09-01','2022-09-11'),
(592,10,'2022-09-01','2022-09-02'),
(593,25,'2022-09-01','2022-09-03'),
(594,12,'2022-09-02','2022-09-15'),
(595,10,'2022-09-03','2022-09-18'),
(596,11,'2022-09-04','2022-09-04'),
(597,23,'2022-09-04','2022-09-07'),
(601,2,'2022-09-05','2022-10-05'),
(602,20,'2022-09-05','2022-09-06'),
(603,18,'2022-09-06','2022-09-07'),
(604,22,'2022-09-06','2022-09-06'),
(605,25,'2022-09-06','2022-09-09'),
(606,22,'2022-09-07','2022-12-06'),
(607,24,'2022-09-08','2022-09-11'),
(609,18,'2022-09-09','2022-09-12'),
(610,20,'2022-09-09','2022-09-12'),
(611,13,'2022-09-10','2022-09-11'),
(613,4,'2022-09-11','2022-10-21'),
(614,28,'2022-09-11','2022-09-12'),
(615,11,'2022-09-12','2022-09-13'),
(616,25,'2022-09-12','2022-09-14'),
(618,8,'2022-09-13','2022-09-14'),
(619,18,'2022-09-13','2022-09-15'),
(620,28,'2022-09-13','2022-12-22'),
(621,11,'2022-09-14','2022-09-16'),
(622,13,'2022-09-14','2022-09-21'),
(623,20,'2022-09-14','2022-09-15'),
(624,24,'2022-09-14','2022-09-14'),
(626,23,'2022-09-15','2022-09-16'),
(627,8,'2022-09-16','2022-09-16'),
(628,12,'2022-09-16','2022-09-18'),
(629,18,'2022-09-16','2022-10-16'),
(630,20,'2022-09-16','2022-10-16'),
(631,8,'2022-09-17','2022-09-19'),
(632,11,'2022-09-17','2022-09-18'),
(634,19,'2022-09-18','2022-09-20'),
(635,24,'2022-09-18','2022-10-28'),
(637,11,'2022-09-19','2022-09-19'),
(638,15,'2022-09-20','2022-09-23'),
(639,25,'2022-09-20','2022-09-21'),
(640,8,'2022-09-21','2022-09-24'),
(641,12,'2022-09-21','2022-09-23'),
(642,19,'2022-09-21','2022-09-23'),
(645,10,'2022-09-22','2022-09-23'),
(646,23,'2022-09-22','2022-09-24'),
(648,5,'2022-09-23','2022-11-02'),
(649,7,'2022-09-23','2022-10-06'),
(650,13,'2022-09-23','2022-09-24'),
(653,6,'2022-09-24','2022-10-24'),
(654,12,'2022-09-24','2022-09-25'),
(656,10,'2022-09-25','2022-09-25'),
(657,11,'2022-09-25','2023-01-03'),
(658,21,'2022-09-25','2022-09-26'),
(659,25,'2022-09-25','2022-09-27'),
(660,27,'2022-09-25','2022-12-24'),
(663,15,'2022-09-26','2022-09-26'),
(664,19,'2022-09-26','2022-10-03'),
(665,23,'2022-09-26','2022-10-06'),
(667,10,'2022-09-28','2022-10-12'),
(668,13,'2022-09-28','2022-09-28'),
(669,25,'2022-09-29','2022-10-28'),
(671,15,'2022-10-01','2022-10-14'),
(672,21,'2022-10-01','2022-10-01'),
(673,8,'2022-10-02','2022-10-04'),
(674,17,'2022-10-02','2022-11-06'),
(675,9,'2022-10-03','2023-01-04'),
(676,12,'2022-10-03','2022-10-06'),
(678,19,'2022-10-05','2022-11-14'),
(679,13,'2022-10-06','2022-10-06'),
(680,8,'2022-10-07','2022-10-21'),
(681,12,'2022-10-07','2022-11-16'),
(682,21,'2022-10-07','2022-10-09'),
(685,2,'2022-10-10','2023-01-11'),
(687,7,'2022-10-14','2022-11-23'),
(688,13,'2022-10-14','2022-10-15'),
(689,23,'2022-10-14','2022-10-27'),
(691,21,'2022-10-17','2022-10-17'),
(692,10,'2022-10-18','2022-10-18'),
(694,18,'2022-10-19','2022-10-19'),
(695,21,'2022-10-19','2022-10-26'),
(697,10,'2022-10-20','2022-10-23'),
(699,3,'2022-10-21','2022-10-24'),
(700,18,'2022-10-21','2022-10-22'),
(701,20,'2022-10-21','2022-10-23'),
(702,15,'2022-10-22','2022-11-06'),
(704,4,'2022-10-23','2022-10-26'),
(705,8,'2022-10-23','2022-10-23'),
(706,13,'2022-10-23','2022-10-26'),
(707,10,'2022-10-24','2023-01-25'),
(710,6,'2022-10-25','2022-10-28'),
(711,8,'2022-10-25','2022-10-25'),
(712,18,'2022-10-25','2023-01-26'),
(713,3,'2022-10-27','2022-10-28'),
(714,8,'2022-10-27','2022-11-06'),
(715,13,'2022-10-27','2022-10-27'),
(716,30,'2022-10-27','2022-10-27'),
(718,13,'2022-10-28','2022-10-30'),
(720,6,'2022-10-30','2022-11-02'),
(721,21,'2022-10-30','2022-11-02'),
(722,1,'2022-10-31','2022-11-30'),
(723,4,'2022-10-31','2022-11-01'),
(724,20,'2022-10-31','2022-12-10');
/*!40000 ALTER TABLE `CAR_RENTAL_COMPANY_RENTAL_HISTORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DEVELOPER_INFOS`
--

DROP TABLE IF EXISTS `DEVELOPER_INFOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `DEVELOPER_INFOS` (
  `ID` varchar(10) DEFAULT NULL COMMENT 'ID',
  `FIRST_NAME` varchar(10) DEFAULT NULL COMMENT '이름',
  `LAST_NAME` varchar(10) DEFAULT NULL COMMENT '성',
  `EMAIL` varchar(32) DEFAULT NULL COMMENT '이메일',
  `SKILL_1` varchar(10) DEFAULT NULL COMMENT '첫 번째 스킬',
  `SKILL_2` varchar(10) DEFAULT NULL COMMENT '두 번째 스킬',
  `SKILL_3` varchar(10) DEFAULT NULL COMMENT '세 번째 스킬',
  UNIQUE KEY `ID` (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='개발자들의 프로그래밍 스킬 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DEVELOPER_INFOS`
--

LOCK TABLES `DEVELOPER_INFOS` WRITE;
/*!40000 ALTER TABLE `DEVELOPER_INFOS` DISABLE KEYS */;
INSERT INTO `DEVELOPER_INFOS` VALUES
('D165','Jerami','Edwards','jerami_edwards@grepp.co','Java','JavaScript','Python'),
('D161','Carsen','Garza','carsen_garza@grepp.co','React',NULL,NULL),
('D164','Kelly','Grant','kelly_grant@grepp.co','C#',NULL,NULL),
('D163','Luka','Cory','luka_cory@grepp.co','Node.js',NULL,NULL),
('D162','Cade','Cunningham','cade_cunningham@grepp.co','Vue','C++','Python');
/*!40000 ALTER TABLE `DEVELOPER_INFOS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DOCTOR`
--

DROP TABLE IF EXISTS `DOCTOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `DOCTOR` (
  `DR_NAME` varchar(20) NOT NULL COMMENT '의사이름',
  `DR_ID` varchar(10) NOT NULL COMMENT '의사ID',
  `LCNS_NO` varchar(30) DEFAULT NULL COMMENT '면허번호',
  `HIRE_YMD` date DEFAULT NULL COMMENT '고용일자',
  `MCDP_CD` varchar(6) DEFAULT NULL COMMENT '진료과코드',
  `TLNO` varchar(50) DEFAULT NULL COMMENT '전화번호',
  PRIMARY KEY (`DR_NAME`,`DR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='의사';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DOCTOR`
--

LOCK TABLES `DOCTOR` WRITE;
/*!40000 ALTER TABLE `DOCTOR` DISABLE KEYS */;
INSERT INTO `DOCTOR` VALUES
('깨미','DR20100102','LC00011262','2011-03-01','FM','01094645690'),
('니모','DR20200012','LC00911162','2020-03-01','CS','01089483921'),
('띠띠','DR20150231','LC00041302','2015-12-01','OS','01049457878'),
('루피','DR20090029','LC00010001','2009-03-01','CS','01085482011'),
('베지','DR20190102','LC00091162','2021-03-01','FM','01094677590'),
('벨','DR20100039','LC00010562','2010-07-01','GS','01058390758'),
('뽀','DR20010112','LC00041162','2005-03-01','FM','01094622322'),
('뽀로로','DR20170123','LC00091201','2017-03-01','GS','01034969210'),
('오로라','DR20100031','LC00010327','2010-11-01','OS','01098428957'),
('윈더','DR20190029','LC00040001','2019-03-01','CS','01085444411'),
('자스민','DR20100032','LC00010192','2010-03-01','GS','01023981922'),
('젤라비','DR20160031','LC00340327','2016-11-01','OB','01098334957'),
('티거','DR20100011','LC00011201','2010-03-01','NP','01034229818'),
('티몬','DR20090112','LC00011162','2010-03-01','FM','01094622190'),
('패티','DR20090001','LC00010901','2009-07-01','CS','01085220122'),
('품바','DR20090231','LC00011302','2015-11-01','OS','01049840278'),
('호비','DR20160039','LC00070562','2016-07-01','DR','01058332558');
/*!40000 ALTER TABLE `DOCTOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ECOLI_DATA`
--

DROP TABLE IF EXISTS `ECOLI_DATA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `ECOLI_DATA` (
  `ID` int(11) DEFAULT NULL COMMENT '대장균 개체의 ID',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '부모 개체의 ID',
  `SIZE_OF_COLONY` int(11) DEFAULT NULL COMMENT '개체의 크기',
  `DIFFERENTIATION_DATE` date DEFAULT NULL COMMENT '분화되어 나온 날짜',
  `GENOTYPE` int(11) DEFAULT NULL COMMENT '개체의 형질'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='실험실에서 배양한 대장균들의 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ECOLI_DATA`
--

LOCK TABLES `ECOLI_DATA` WRITE;
/*!40000 ALTER TABLE `ECOLI_DATA` DISABLE KEYS */;
INSERT INTO `ECOLI_DATA` VALUES
(1,NULL,10,'2019-01-01',1),
(2,1,2,'2019-01-01',1),
(3,1,100,'2020-01-01',3),
(4,2,16,'2020-01-01',2),
(5,4,17,'2020-01-01',8),
(6,3,101,'2021-01-01',5),
(7,2,101,'2021-01-01',5),
(8,6,1,'2021-01-01',13);
/*!40000 ALTER TABLE `ECOLI_DATA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FIRST_HALF`
--

DROP TABLE IF EXISTS `FIRST_HALF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `FIRST_HALF` (
  `SHIPMENT_ID` int(11) NOT NULL COMMENT '출하 번호',
  `FLAVOR` varchar(300) NOT NULL COMMENT '아이스크림 맛',
  `TOTAL_ORDER` int(11) NOT NULL COMMENT '총주문량',
  PRIMARY KEY (`FLAVOR`),
  UNIQUE KEY `SHIPMENT_ID` (`SHIPMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='아이스크림 가게의 상반기 주문 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FIRST_HALF`
--

LOCK TABLES `FIRST_HALF` WRITE;
/*!40000 ALTER TABLE `FIRST_HALF` DISABLE KEYS */;
INSERT INTO `FIRST_HALF` VALUES
(104,'caramel',2600),
(101,'chocolate',3200),
(103,'mint_chocolate',1700),
(106,'peach',2450),
(109,'strawberry',3100),
(102,'vanilla',2800),
(105,'white_chocolate',3100);
/*!40000 ALTER TABLE `FIRST_HALF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FISH_INFO`
--

DROP TABLE IF EXISTS `FISH_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `FISH_INFO` (
  `ID` int(11) DEFAULT NULL COMMENT '물고기의 ID',
  `FISH_TYPE` int(11) DEFAULT NULL COMMENT '물고기의 종류(숫자)',
  `LENGTH` float(5,2) DEFAULT NULL COMMENT '잡은 물고기의 길이(cm), 10cm 이하는 NULL',
  `TIME` date DEFAULT NULL COMMENT '물고기를 잡은 날짜'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='물고기 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FISH_INFO`
--

LOCK TABLES `FISH_INFO` WRITE;
/*!40000 ALTER TABLE `FISH_INFO` DISABLE KEYS */;
INSERT INTO `FISH_INFO` VALUES
(0,0,30.00,'2021-12-04'),
(1,0,50.00,'2020-03-07'),
(2,0,40.00,'2020-03-07'),
(3,1,20.00,'2022-03-09'),
(4,1,NULL,'2022-04-08'),
(5,2,13.00,'2021-04-28'),
(6,3,60.00,'2021-07-27'),
(7,0,55.00,'2021-01-18'),
(8,2,73.00,'2020-01-28'),
(9,3,73.00,'2021-04-08'),
(10,2,22.00,'2020-06-28'),
(11,2,17.00,'2022-12-23');
/*!40000 ALTER TABLE `FISH_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FOOD_FACTORY`
--

DROP TABLE IF EXISTS `FOOD_FACTORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `FOOD_FACTORY` (
  `FACTORY_ID` varchar(10) NOT NULL COMMENT '공장 ID',
  `FACTORY_NAME` varchar(50) NOT NULL COMMENT '공장 이름',
  `ADDRESS` varchar(100) DEFAULT NULL COMMENT '주소',
  `TLNO` varchar(20) DEFAULT NULL COMMENT '전화번호',
  PRIMARY KEY (`FACTORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='식품공장';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FOOD_FACTORY`
--

LOCK TABLES `FOOD_FACTORY` WRITE;
/*!40000 ALTER TABLE `FOOD_FACTORY` DISABLE KEYS */;
INSERT INTO `FOOD_FACTORY` VALUES
('FT19980001','(주)맛있는라면','경기도 동두천시 강변로850번길 120','031-231-1032'),
('FT19980002','(주)맛있는기름','충청북도 음성군 생극면 음성로 1506-275','043-641-9900'),
('FT19980003','(주)맛있는라면','강원도 정선군 남면 칠현로 679','033-431-3122'),
('FT19980004','(주)맛있는기름','경기도 평택시 포승읍 포승공단순환로 245','031-651-2410'),
('FT20000001','(주)맛있는소스','경기도 안양시 동안구 흥안대로 405','031-221-7211'),
('FT20000002','(주)맛있는통조림','경기도 파주시 파주읍 파발로 65','031-641-1900'),
('FT20010001','(주)맛있는소스','경상북도 구미시 1공단로7길 58-11','054-231-2121'),
('FT20010002','(주)맛있는통조림','전라남도 영암군 미암면 곤미현로 1336','061-341-5210'),
('FT20020001','(주)맛있는차','충청남도 논산시 은진면 관촉로58번길 138','041-241-1420'),
('FT20020002','(주)맛있는김치','경기도 평택시 포승읍 포승공단로 2','031-541-5400'),
('FT20040001','(주)맛있는음료','경기도 평택시 안중읍 서해로 1427','031-722-2430'),
('FT20040002','(주)맛있는국','경상남도 거제시 사등면 거제대로 5382','055-351-1240'),
('FT20070001','(주)맛있는라면','경상북도 경산시 하양읍 대경로 541','054-423-3122'),
('FT20070002','(주)맛있는기름','대전광역시 대덕구 신일서로67번길 57','042-121-2410'),
('FT20070009','(주)맛있는소스','부산광역시 영도구 봉래길 113','051-551-7721'),
('FT20080002','(주)맛있는통조림','부산광역시 사하구 다대로170번길','051-841-5810'),
('FT20080003','(주)맛있는차','전라남도 무안군 삼향읍 왕산로 91','061-221-9920'),
('FT20090001','(주)맛있는밥','경기도 안성시 공단2로 29','031-761-1359'),
('FT20090002','(주)맛있는과자','부산광역시 강서구 녹산산단261로73번길 48','051-821-4259'),
('FT20100001','(주)맛있는차','전라남도 장성군 서삼면 장산리 233-1번지','061-661-1420'),
('FT20100002','(주)맛있는김치','충청남도 아산시 탕정면 탕정면로 485','041-241-5421'),
('FT20100003','(주)맛있는음료','강원도 원주시 문막읍 문막공단길 154','033-232-7630'),
('FT20100004','(주)맛있는국','강원도 평창군 봉평면 진조길 227-35','033-323-6640'),
('FT20110001','(주)맛있는밥','경기도 화성시 팔탄면 가재리 34번지','031-661-1532'),
('FT20110002','(주)맛있는과자','광주광역시 북구 하서로 222','062-211-7759'),
('FT20150004','(주)맛있는김치','전라북도 익산시 석암로7길 31-17','063-981-5421'),
('FT20150005','(주)맛있는음료','전라북도 익산시 석암로11길 99','063-932-1672'),
('FT20160005','(주)맛있는국','전라남도 광양시 옥곡면 신금산단1길 4','061-923-6940'),
('FT20180005','(주)맛있는밥','충청남도 천안시 서북구 성거읍 천흥8길 67','041-861-1432'),
('FT20200005','(주)맛있는과자','충청북도 청주시 흥덕구 공단로 48','043-911-5759');
/*!40000 ALTER TABLE `FOOD_FACTORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FOOD_PRODUCT`
--

DROP TABLE IF EXISTS `FOOD_PRODUCT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `FOOD_PRODUCT` (
  `PRODUCT_ID` varchar(10) NOT NULL COMMENT 'ID',
  `PRODUCT_NAME` varchar(50) NOT NULL COMMENT '이름',
  `PRODUCT_CD` varchar(10) DEFAULT NULL COMMENT '코드',
  `CATEGORY` varchar(10) DEFAULT NULL COMMENT '분류',
  `PRICE` int(11) DEFAULT NULL COMMENT '가격',
  PRIMARY KEY (`PRODUCT_ID`,`PRODUCT_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='식품의 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FOOD_PRODUCT`
--

LOCK TABLES `FOOD_PRODUCT` WRITE;
/*!40000 ALTER TABLE `FOOD_PRODUCT` DISABLE KEYS */;
INSERT INTO `FOOD_PRODUCT` VALUES
('P0001','맛있는라면','CD_ND00001','면',3780),
('P0002','맛있는비빔면','CD_ND00002','면',3920),
('P0003','맛있는짜장','CD_ND00003','면',4950),
('P0004','맛있는짬뽕','CD_ND00004','면',4950),
('P0011','맛있는콩기름','CD_OL00001','식용유',4880),
('P0012','맛있는올리브유','CD_OL00002','식용유',7200),
('P0013','맛있는포도씨유','CD_OL00003','식용유',5950),
('P0014','맛있는마조유','CD_OL00004','식용유',8950),
('P0021','맛있는케첩','CD_SC00001','소스',4500),
('P0022','맛있는마요네즈','CD_SC00002','소스',4700),
('P0023','맛있는핫소스','CD_SC00003','소스',3950),
('P0024','맛있는칠리소스','CD_SC00004','소스',7950),
('P0031','맛있는참치','CD_CN00001','캔',1800),
('P0032','맛있는꽁치','CD_CN00002','캔',2100),
('P0033','맛있는골뱅이','CD_CN00003','캔',3950),
('P0034','맛있는고등어','CD_CN00004','캔',2950),
('P0041','맛있는보리차','CD_TE00001','차',3400),
('P0042','맛있는메밀차','CD_TE00002','차',3500),
('P0043','맛있는아메리카노','CD_TE00003','차',3950),
('P0044','맛있는라떼','CD_TE00004','차',4050),
('P0051','맛있는배추김치','CD_KC00001','김치',19000),
('P0052','맛있는열무김치','CD_KC00002','김치',17000),
('P0053','맛있는파김치','CD_KC00003','김치',17500),
('P0054','맛있는백김치','CD_KC00004','김치',16950),
('P0061','맛있는생수','CD_BR00001','음료',1100),
('P0062','맛있는콜라','CD_BR00002','음료',2700),
('P0063','맛있는사이다','CD_BR00003','음료',2450),
('P0064','맛있는사과주스','CD_BR00004','음료',3100),
('P0071','맛있는미역국','CD_SU00001','국',2400),
('P0072','맛있는소고기국','CD_SU00002','국',2700),
('P0073','맛있는육개장','CD_SU00003','국',2450),
('P0074','맛있는김치찌개','CD_SU00004','국',2900),
('P0081','맛있는백미밥','CD_RI00001','밥',1500),
('P0082','맛있는현미밥','CD_RI00002','밥',1800),
('P0083','맛있는잡곡밥','CD_RI00003','밥',1950),
('P0084','맛있는완두콩밥','CD_RI00004','밥',1900),
('P0091','맛있는포카칩','CD_CK00001','과자',1500),
('P0092','맛있는고구마깡','CD_CK00002','과자',1800),
('P0093','맛있는허니버터칩','CD_CK00003','과자',1950),
('P0094','맛있는새우깡','CD_CK00004','과자',1900);
/*!40000 ALTER TABLE `FOOD_PRODUCT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FOOD_WAREHOUSE`
--

DROP TABLE IF EXISTS `FOOD_WAREHOUSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `FOOD_WAREHOUSE` (
  `WAREHOUSE_ID` varchar(10) NOT NULL COMMENT 'ID',
  `WAREHOUSE_NAME` varchar(20) NOT NULL COMMENT '이름',
  `ADDRESS` varchar(100) DEFAULT NULL COMMENT '주소',
  `TLNO` varchar(20) DEFAULT NULL COMMENT '전화번호',
  `FREEZER_YN` varchar(1) DEFAULT NULL COMMENT '냉동시설 여부',
  PRIMARY KEY (`WAREHOUSE_ID`),
  UNIQUE KEY `WH_NAME_UNIQUE` (`WAREHOUSE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='식품창고';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FOOD_WAREHOUSE`
--

LOCK TABLES `FOOD_WAREHOUSE` WRITE;
/*!40000 ALTER TABLE `FOOD_WAREHOUSE` DISABLE KEYS */;
INSERT INTO `FOOD_WAREHOUSE` VALUES
('WH0001','창고_경기1','경기도 안산시 상록구 용담로 141','031-152-1332','Y'),
('WH0002','창고_충북1','충청북도 진천군 진천읍 씨제이로 110','043-623-9900','Y'),
('WH0003','창고_경기2','경기도 이천시 마장면 덕평로 811','031-221-7241',NULL),
('WH0004','창고_경기3','경기도 김포시 대곶면 율생중앙로205번길','031-671-1900','N'),
('WH0005','창고_충남1','충청남도 천안시 동남구 광덕면 신덕리1길 9','041-876-5421','Y'),
('WH0011','창고_강원1','강원도 원주시 문막읍 비두초교길 17','033-231-3442','N'),
('WH0012','창고_경기7','경기도 수원시 권선구 오목천로152번길 40','031-561-2410','N'),
('WH0013','창고_경북1','경상북도 영주시 장수면 용주로 213','054-651-2121','Y'),
('WH0014','창고_전남1','전라남도 목포시 삽진산단로 89-4','061-341-5750',NULL),
('WH0015','창고_전남2','전라남도 순천시 해룡면 율촌산단4로 13','061-451-1420','N'),
('WH0021','창고_경북2','경상북도 경산시 하양읍 대경로 541','054-523-3442',NULL),
('WH0022','창고_대전1','대전광역시 대덕구 신일서로67번길 57','042-661-2610',NULL),
('WH0023','창고_부산2','부산광역시 영도구 봉래길 113','051-531-7331','Y'),
('WH0024','창고_부산3','부산광역시 사하구 다대로170번길 10','051-833-5310','N'),
('WH0025','창고_전남3','전라남도 무안군 삼향읍 왕산로 91','061-221-9320','N'),
('WH0031','창고_강원4','강원도 홍천군 북방면 도둔길 49','033-123-3442',NULL),
('WH0032','창고_경기9','경기도 안양시 만안구 전파로 3','031-661-2610',NULL),
('WH0033','창고_경남2','경상남도 진주시 진성면 동부로 1582-16','055-131-1331','Y'),
('WH0034','창고_전북3','전라북도 순창군 쌍치면 청정로 58-37','063-823-0310','N'),
('WH0035','창고_전북4','전라북도 순창군 인계면 물통길 22-2','063-224-9320','N'),
('WH0041','창고_서울1','서울특별시 영등포구 양평로21길 257','02-231-2242','N'),
('WH0042','창고_서울2','서울특별시 영등포구 양평동4가 17번지 외 1필지','02-991-2410','N'),
('WH0043','창고_울산1','울산광역시 남구 여천로217번길 19','052-651-2331','Y'),
('WH0044','창고_울산2','울산광역시 남구 사평로 119','052-341-5711',NULL),
('WH0045','창고_울산3','울산광역시 울주군 청량읍 상개로 63-15','052-451-5540','N');
/*!40000 ALTER TABLE `FOOD_WAREHOUSE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ICECREAM_INFO`
--

DROP TABLE IF EXISTS `ICECREAM_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `ICECREAM_INFO` (
  `FLAVOR` varchar(300) NOT NULL COMMENT '아이스크림 맛',
  `INGREDIENT_TYPE` varchar(300) NOT NULL COMMENT '성분 타입(설탕=sugar_based, 과일=fruit_based)',
  PRIMARY KEY (`FLAVOR`),
  CONSTRAINT `icecream_info_ibfk_1` FOREIGN KEY (`FLAVOR`) REFERENCES `FIRST_HALF` (`FLAVOR`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='아이스크림 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ICECREAM_INFO`
--

LOCK TABLES `ICECREAM_INFO` WRITE;
/*!40000 ALTER TABLE `ICECREAM_INFO` DISABLE KEYS */;
INSERT INTO `ICECREAM_INFO` VALUES
('caramel','sugar_based'),
('chocolate','sugar_based'),
('mint_chocolate','sugar_based'),
('peach','fruit_based'),
('strawberry','fruit_based'),
('vanilla','sugar_based'),
('white_chocolate','sugar_based');
/*!40000 ALTER TABLE `ICECREAM_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PATIENT`
--

DROP TABLE IF EXISTS `PATIENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `PATIENT` (
  `PT_NO` varchar(10) NOT NULL COMMENT '환자번호',
  `PT_NAME` varchar(20) DEFAULT NULL COMMENT '환자이름',
  `GEND_CD` varchar(1) DEFAULT NULL COMMENT '성별코드',
  `AGE` int(11) DEFAULT NULL COMMENT '나이',
  `TLNO` varchar(50) DEFAULT NULL COMMENT '전화번호',
  PRIMARY KEY (`PT_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='환자';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PATIENT`
--

LOCK TABLES `PATIENT` WRITE;
/*!40000 ALTER TABLE `PATIENT` DISABLE KEYS */;
INSERT INTO `PATIENT` VALUES
('PT22000001','라이언','M',28,'01076482309'),
('PT22000002','어피치','W',34,'01076485839'),
('PT22000003','브라운','M',18,'01031246641'),
('PT22000004','크롱','M',7,NULL),
('PT22000005','포비','M',7,NULL),
('PT22000006','뽀뽀','W',8,NULL),
('PT22000007','나미','W',28,'01022292123'),
('PT22000008','미미','W',32,'01076434111'),
('PT22000009','한나','W',12,'01032323117'),
('PT22000010','톰슨','M',19,'01023238588'),
('PT22000011','해리','W',22,'01099846284'),
('PT22000012','뿡뿡이','M',5,NULL),
('PT22000013','크리스','M',30,'01059341192'),
('PT22000014','토프','W',22,'01039458213'),
('PT22000015','스벤','M',16,'01031246232'),
('PT22000016','올라프','M',40,'01023541211'),
('PT22000017','한스','M',38,'01023879696'),
('PT22000018','안나','W',11,NULL),
('PT22000019','바라','W',10,'01079068799'),
('PT22000020','엘사','W',21,'01012359781'),
('PT22000021','릴로','W',33,'01023290767'),
('PT22000022','스티치','W',9,NULL);
/*!40000 ALTER TABLE `PATIENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCT`
--

DROP TABLE IF EXISTS `PRODUCT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `PRODUCT` (
  `PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '상품 ID',
  `PRODUCT_CODE` char(8) NOT NULL COMMENT '8자리 상품 코드. 앞 2자리는 상품 분류 코드',
  `PRICE` int(11) NOT NULL COMMENT '판매가',
  PRIMARY KEY (`PRODUCT_ID`),
  UNIQUE KEY `PRODUCT_UNIQUE_INDEX1` (`PRODUCT_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='상품';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT`
--

LOCK TABLES `PRODUCT` WRITE;
/*!40000 ALTER TABLE `PRODUCT` DISABLE KEYS */;
INSERT INTO `PRODUCT` VALUES
(1,'C2000000',72000),
(2,'C1000000',51000),
(3,'D1000000',63000),
(4,'D3000000',82000),
(5,'B2000000',42000),
(6,'D3000001',85000),
(7,'C2000001',31000),
(8,'C3000000',46000),
(9,'A2000000',54000),
(10,'B2000001',72000),
(11,'C3000001',61000),
(12,'A3000000',60000),
(13,'C4000000',54000),
(14,'C3000002',19000),
(15,'D2000000',35000),
(16,'A3000001',15000),
(17,'D2000001',46000),
(18,'B1000000',65000),
(19,'D1000001',62000),
(20,'B2000002',80000),
(21,'A2000001',42000),
(22,'C3000003',55000),
(23,'C4000001',65000),
(24,'C4000002',21000),
(25,'A3000002',32000),
(26,'D1000002',51000),
(27,'D3000002',60000),
(28,'A3000003',80000),
(29,'C1000001',51000),
(30,'A2000002',22000);
/*!40000 ALTER TABLE `PRODUCT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USED_GOODS_BOARD`
--

DROP TABLE IF EXISTS `USED_GOODS_BOARD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `USED_GOODS_BOARD` (
  `BOARD_ID` varchar(5) NOT NULL COMMENT '게시글 ID',
  `WRITER_ID` varchar(50) DEFAULT NULL COMMENT '작성자 ID',
  `TITLE` varchar(100) DEFAULT NULL COMMENT '게시글 제목',
  `CONTENTS` varchar(1000) DEFAULT NULL COMMENT '게시글 내용',
  `PRICE` int(11) DEFAULT NULL COMMENT '가격',
  `CREATED_DATE` date DEFAULT NULL COMMENT '작성일',
  `STATUS` varchar(10) DEFAULT NULL COMMENT '거래상태',
  `VIEWS` int(11) DEFAULT NULL COMMENT '조회수',
  PRIMARY KEY (`BOARD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci COMMENT='중고거래 게시판 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USED_GOODS_BOARD`
--

LOCK TABLES `USED_GOODS_BOARD` WRITE;
/*!40000 ALTER TABLE `USED_GOODS_BOARD` DISABLE KEYS */;
INSERT INTO `USED_GOODS_BOARD` VALUES
('B0001','kwag98','반려견 배변패드 팝니다','정말 저렴히 판매합니다. 전부 미개봉 새상품입니다.',12000,'2022-10-01','DONE',250),
('B0002','lee871201','국내산 볶음참깨','직접 농사지은 참깨입니다.',3000,'2022-10-02','DONE',141),
('B0003','goung12','배드민턴 라켓','사놓고 방치만 해서 팝니다.',9000,'2022-10-02','SALE',212),
('B0004','keel1990','디올 귀걸이','신세계강남점에서 구입. 정품 아닐시 백퍼센트 환불',130000,'2022-10-02','SALE',199),
('B0005','haphli01','스팸클래식 팔아요','유통기한 2025년까지에요',10000,'2022-10-02','SALE',122),
('B0006','hanju23','제습기 가져가세요','사무실 용으로추천드립니다',20000,'2022-10-03','DONE',123),
('B0007','s2s2123','커피글라인더','새상품처럼 깨끗합니다.',7000,'2022-10-04','DONE',210),
('B0008','hong02','자전거 판매합니다','출퇴근용으로 구매했다가 사용하지 않아서 내놔요',40000,'2022-10-04','SALE',301),
('B0009','yawoong67','선반 팝니다','6단 선반. 환불 반품 안됩니다.',12000,'2022-10-05','DONE',202),
('B0010','keel1990','철제선반5단','철제선반 5단 조립식 팜',10000,'2022-10-05','SALE',194),
('B0011','sangyoung58','아이폰14프로 256기가 자급제팔아요','단순변심으로 팔아요 깨끗해요',1500000,'2022-10-05','DONE',178),
('B0012','hwahwa2','에어팟 프로 팔아요','모든 성능 이상 없구 생활기스 있어요',125000,'2022-10-05','DONE',123),
('B0013','kwag98','삼성 65인치 led tv 팝니다','tv변경으로 팝니다.',320000,'2022-10-05','RESERVED',132),
('B0014','whgkdkgo1','루이비통 카드지갑','단순변심을 팔아요',540000,'2022-10-06','SALE',112),
('B0015','spdlqj12','아이리버 CD플레이어','라디오 및 블루투스 동작해요',30000,'2022-10-06','DONE',133),
('B0016','miyeon89','캔들워머','추가 LED까지 함께 드려요.',20000,'2022-10-06','DONE',166),
('B0017','spdlqj12','미니 식세기','6인용 식세기 팔아요',110000,'2022-10-07','SALE',112),
('B0018','whgkdkgo1','컴퓨터 의자','의자 새로 구입해서 판배합니다.',15000,'2022-10-08','SALE',157),
('B0019','miyeon89','조말론 향수','절반정도 남았는데 싸게 판매합니다.',30000,'2022-10-09','SALE',154),
('B0020','hwahwa2','나이키 캡','택도 안뜯은 새거 팝니다.',16000,'2022-10-10','DONE',174),
('B0021','spdlqj12','아기옷','아가방 아기옷 사이즈 작아서 팔아요',20000,'2022-10-10','DONE',170),
('B0022','spdlqj12','저스트댄스 2022','PS5 버전 팝매합니다.',50000,'2022-10-11','SALE',124),
('B0023','hwahwa2','구찌 크로스백','작년에 구매했고, 실사용 거의없습니다.',380000,'2022-10-11','SALE',131),
('B0024','xlqpfh2','영화관람관','롯데시네마 2장팝니다',18000,'2022-10-11','SALE',122),
('B0025','hoho1112','두유','검은콩두유 10개 팔아요',5000,'2022-10-12','DONE',130),
('B0026','xlaortm1','푸쉬업바','푸쉬업파 팝니다. 튼튼하고 좋아요',10000,'2022-10-13','DONE',101),
('B0027','spdlqj12','엔진오일','5w30 기아 순정 4L 엔진오일 팔아요',35000,'2022-10-12','SALE',110),
('B0028','s2s2123','카샴푸','소낙스 카샴푸 팝니다.',12000,'2022-10-12','SALE',115),
('B0029','kwag98','책장','6단 책장 팔아요. 생활기스 약간 있어요',19000,'2022-10-11','SALE',117),
('B0030','spdlqj12','아이패드 프로 4세대 12.9 팝니다','작년에 구매했어요',1200000,'2022-10-13','SALE',112),
('B0031','tkfkdgo1','S22 팔아요','케이스 사용해서 완전 새것입니다.',310000,'2022-10-15','SALE',90),
('B0032','s2s2123','스노우피크 캠핑의자','실사용 5회 미만입니다.',43000,'2022-10-15','SALE',100),
('B0033','xlqpfh2','나이키 반팔티','집에서 편하게 입기 좋습니다.',5000,'2022-10-14','SALE',155),
('B0034','dhfkzmf09','칼라거펠트 코트','양모 70%이상 코트입니다.',120000,'2022-10-14','DONE',104),
('B0035','tkfkdgo1','퐁퐁 주방세제','주방세제 3개 같이 팔아요',10000,'2022-10-11','SALE',99),
('B0036','dhfkzmf09','나이키 숏패팅','사이즈는 M입니다.',40000,'2022-10-17','DONE',98),
('B0037','xlqpfh2','화장대','한샘 화장대 팝니다.',100000,'2022-10-17','SALE',85),
('B0038','hong02','전자렌지','동작 정상적으로 잘되요. 사용감은 좀 있습니다.',20000,'2022-10-16','SALE',84),
('B0039','hong02','통기타 팔아요','입문용으로 좋습니다.',30000,'2022-10-18','SALE',88),
('B0041','xlqpfh2','갤럭시버즈','버즈2이고 정상동작해요',60000,'2022-10-19','SALE',70),
('B0043','skeh123','캠핑 등유난로','등유난로 팝니다',10000,'2022-10-22','SALE',86),
('B0044','dlPcks90','헬스의자','홈트용으로 좋습니다.',12000,'2022-10-21','SALE',102),
('B0045','hong02','아기침대','영유야용 아기침대 팔아요',120000,'2022-10-20','SALE',125),
('B0046','hong02','고야드 카드지갑','고야드 카드지갑 팔아요. 사용감 있습니다.',80000,'2022-10-21','SALE',75),
('B0047','skeh123','구찌 카드지갑','작년 모델이고 싸게 내놔요',340000,'2022-10-22','SALE',72),
('B0048','hoho1112','따수미텐트','침대 및 일반 바닥에 설치 가능합니다.',15000,'2022-10-23','SALE',73),
('B0051','xlaortm1','건조대','건조대 무료나눔 합니다.',0,'2022-10-26','SALE',66),
('B0052','xlqpfh2','컴퓨터의자','이사로 인해 무료 나눔해요',0,'2022-10-26','SALE',78),
('B0053','hoho1112','스위치 oled','스위치 oled 팔아요',350000,'2022-10-27','SALE',111),
('B0054','dlPcks90','젤다의전설','다들 아시는 그 명작입니다',40000,'2022-10-28','SALE',84),
('B0055','xlaortm1','사과 한박스','직접 농사지은 사과입니다.',30000,'2022-10-29','DONE',66),
('B0060','xlaortm1','이케아 의자','편하게 사용하는 의자 팔아요',10000,'2022-11-01','DONE',156),
('B0064','dhfkzmf09','PS4','PS5 구매로인해 팝니다.',250000,'2022-11-03','DONE',111),
('B0068','hakho11','스파이용권','분당스파 5회 이용권 팔아요',50000,'2022-11-07','SALE',123),
('B0076','hakho11','폴로니트','M사이즈 판매합니다. 실착 2번이에용',60000,'2022-11-12','DONE',33),
('B0078','hakju88','프라다 백팩','프라다 백팩 팔아요',40000,'2022-11-13','SALE',129),
('B0082','hakju88','캠핑웨건 미사용 새거','분당 직거래 큰사이즈입니다.',20000,'2022-11-18','SALE',141),
('B0084','hakju88','압력밥솥','쿠쿠 10인용 밥솥 팔아요',90000,'2022-11-22','SALE',73),
('B0088','dhfkzmf09','철제선반','이사로인해 처분합니다',10000,'2022-11-25','RESERVED',122),
('B0092','zkzkdh1','캠핑의자','가벼워요 깨끗한 상태입니다. 2개',25000,'2022-11-29','SALE',34),
('B0094','hakju88','BTS 콘서트','부산 콘서트 티켓입니다. 초대권인데 양도합니다.(2장)',300000,'2022-11-28','RESERVED',42),
('B0095','miyeon89','벽걸이 에어컨','엘지 휘센 7평',100000,'2022-11-29','SALE',55),
('B0096','dhfkzmf09','에어팟 맥스','에어팟 맥스 스카이 블루 색상 판매합니다.',450000,'2022-11-26','DONE',67),
('B0099','zkzkdh1','애플워치7','애플워치7 실버 스텐 45미리 판매합니다.',700000,'2022-11-30','DONE',90),
('B0100','miyeon89','버너','부탄가스 버너 팝니다.',9000,'2022-11-30','DONE',77);
/*!40000 ALTER TABLE `USED_GOODS_BOARD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_INFO`
--

DROP TABLE IF EXISTS `USER_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `USER_INFO` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '회원 ID',
  `gender` tinyint(1) DEFAULT NULL COMMENT '성별 (0: 남자, 1: 여자)',
  `age` int(11) DEFAULT NULL COMMENT '나이',
  `joined` date NOT NULL COMMENT '가입일',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='회원';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_INFO`
--

LOCK TABLES `USER_INFO` WRITE;
/*!40000 ALTER TABLE `USER_INFO` DISABLE KEYS */;
INSERT INTO `USER_INFO` VALUES
(1,1,25,'2021-06-03'),
(2,1,24,'2021-06-06'),
(3,1,31,'2021-06-09'),
(4,1,23,'2021-06-09'),
(5,1,22,'2021-06-11'),
(6,0,40,'2021-06-11'),
(7,1,36,'2021-06-13'),
(8,1,32,'2021-06-13'),
(9,0,23,'2021-06-15'),
(10,0,24,'2021-06-15'),
(11,1,38,'2021-06-16'),
(12,0,35,'2021-06-16'),
(13,1,31,'2021-06-17'),
(14,1,34,'2021-06-20'),
(15,0,29,'2021-06-20'),
(16,0,25,'2021-06-22'),
(17,0,27,'2021-06-23'),
(18,1,29,'2021-06-26'),
(19,1,26,'2021-06-26'),
(20,0,29,'2021-06-29'),
(21,0,29,'2021-07-01'),
(22,0,29,'2021-07-01'),
(23,1,33,'2021-07-04'),
(24,0,24,'2021-07-06'),
(25,1,30,'2021-07-06'),
(26,1,29,'2021-07-08'),
(27,1,22,'2021-07-09'),
(28,1,21,'2021-07-10'),
(29,1,30,'2021-07-10'),
(30,1,20,'2021-07-11'),
(31,NULL,25,'2021-07-11'),
(32,1,44,'2021-07-14'),
(33,1,24,'2021-07-14'),
(34,1,24,'2021-07-17'),
(35,1,37,'2021-07-18'),
(36,1,24,'2021-07-21'),
(37,0,NULL,'2021-07-22'),
(38,0,24,'2021-07-24'),
(39,0,26,'2021-07-24'),
(40,1,23,'2021-07-27'),
(41,1,29,'2021-07-28'),
(42,0,40,'2021-07-28'),
(43,1,23,'2021-07-31'),
(44,1,41,'2021-08-01'),
(45,1,41,'2021-08-01'),
(46,0,39,'2021-08-03'),
(47,1,24,'2021-08-03'),
(48,1,24,'2021-08-05'),
(49,1,20,'2021-08-07'),
(50,1,28,'2021-08-08'),
(51,1,37,'2021-08-08'),
(52,0,44,'2021-08-09'),
(53,0,25,'2021-08-09'),
(54,0,25,'2021-08-12'),
(55,1,25,'2021-08-14'),
(56,1,40,'2021-08-14'),
(57,1,27,'2021-08-17'),
(58,1,41,'2021-08-17'),
(59,0,21,'2021-08-19'),
(60,NULL,20,'2021-08-19'),
(61,1,29,'2021-08-21'),
(62,1,25,'2021-08-24'),
(63,0,20,'2021-08-24'),
(64,0,29,'2021-08-25'),
(65,1,29,'2021-08-27'),
(66,0,27,'2021-08-27'),
(67,1,20,'2021-08-29'),
(68,0,20,'2021-08-30'),
(69,0,33,'2021-08-30'),
(70,1,27,'2021-09-01'),
(71,1,36,'2021-09-01'),
(72,1,33,'2021-09-04'),
(73,0,26,'2021-09-06'),
(74,1,27,'2021-09-07'),
(75,0,26,'2021-09-07'),
(76,1,36,'2021-09-09'),
(77,1,30,'2021-09-12'),
(78,0,21,'2021-09-13'),
(79,1,32,'2021-09-15'),
(80,0,30,'2021-09-15'),
(81,0,38,'2021-09-16'),
(82,1,27,'2021-09-16'),
(83,1,34,'2021-09-19'),
(84,1,33,'2021-09-22'),
(85,0,27,'2021-09-22'),
(86,0,28,'2021-09-25'),
(87,1,38,'2021-09-28'),
(88,0,30,'2021-09-28'),
(89,1,24,'2021-10-01'),
(90,0,20,'2021-10-01'),
(91,0,24,'2021-10-02'),
(92,0,21,'2021-10-02'),
(93,1,34,'2021-10-03'),
(94,0,43,'2021-10-03'),
(95,0,22,'2021-10-04'),
(96,1,21,'2021-10-07'),
(97,0,35,'2021-10-10'),
(98,1,20,'2021-10-10'),
(99,0,30,'2021-10-11'),
(100,0,41,'2021-10-11'),
(101,1,31,'2021-10-12'),
(102,0,29,'2021-10-12'),
(103,0,23,'2021-10-15'),
(104,0,38,'2021-10-15'),
(105,0,21,'2021-10-17'),
(106,1,20,'2021-10-17'),
(107,1,36,'2021-10-20'),
(108,1,24,'2021-10-20'),
(109,1,23,'2021-10-22'),
(110,1,NULL,'2021-10-24'),
(111,0,37,'2021-10-26'),
(112,1,24,'2021-10-26'),
(113,0,32,'2021-10-28'),
(114,0,37,'2021-10-31'),
(115,1,24,'2021-10-31'),
(116,1,28,'2021-11-02'),
(117,0,25,'2021-11-02'),
(118,1,26,'2021-11-05'),
(119,1,30,'2021-11-06'),
(120,0,38,'2021-11-06'),
(121,0,29,'2021-11-09'),
(122,1,23,'2021-11-09'),
(123,0,23,'2021-11-11'),
(124,1,27,'2021-11-11'),
(125,0,22,'2021-11-12'),
(126,0,31,'2021-11-14'),
(127,1,24,'2021-11-17'),
(128,1,23,'2021-11-20'),
(129,0,21,'2021-11-20'),
(130,1,23,'2021-11-21'),
(131,1,29,'2021-11-21'),
(132,1,22,'2021-11-23'),
(133,1,22,'2021-11-26'),
(134,0,27,'2021-11-26'),
(135,1,40,'2021-11-29'),
(136,0,33,'2021-11-30'),
(137,1,22,'2021-12-01'),
(138,0,41,'2021-12-01'),
(139,0,37,'2021-12-04'),
(140,1,23,'2021-12-06'),
(141,1,29,'2021-12-06'),
(142,1,40,'2021-12-09'),
(143,0,25,'2021-12-12'),
(144,1,23,'2021-12-13'),
(145,0,26,'2021-12-16'),
(146,1,42,'2021-12-16'),
(147,1,22,'2021-12-18'),
(148,1,27,'2021-12-18'),
(149,1,33,'2021-12-19'),
(150,1,26,'2021-12-22'),
(151,1,33,'2021-12-25'),
(152,0,25,'2021-12-25'),
(153,0,25,'2021-12-26'),
(154,0,NULL,'2021-12-26'),
(155,1,36,'2021-12-27'),
(156,1,NULL,'2021-12-27'),
(157,0,22,'2021-12-30'),
(158,1,30,'2021-12-30'),
(159,0,22,'2022-01-02'),
(160,0,33,'2022-01-03'),
(161,0,32,'2022-01-05'),
(162,0,28,'2022-01-07'),
(163,1,36,'2022-01-07'),
(164,1,22,'2022-01-08'),
(165,1,24,'2022-01-10'),
(166,1,39,'2022-01-10'),
(167,NULL,42,'2022-01-13'),
(168,0,32,'2022-01-16'),
(169,NULL,28,'2022-01-19'),
(170,1,25,'2022-01-20'),
(171,1,21,'2022-01-20'),
(172,0,21,'2022-01-22'),
(173,0,21,'2022-01-22'),
(174,1,26,'2022-01-25'),
(175,0,21,'2022-01-27'),
(176,1,40,'2022-01-27'),
(177,1,24,'2022-01-30'),
(178,1,43,'2022-01-30'),
(179,1,31,'2022-01-31'),
(180,0,20,'2022-02-03'),
(181,1,21,'2022-02-03'),
(182,0,34,'2022-02-05'),
(183,1,25,'2022-02-06'),
(184,NULL,21,'2022-02-09'),
(185,0,32,'2022-02-11'),
(186,1,20,'2022-02-13'),
(187,1,34,'2022-02-14'),
(188,0,23,'2022-02-14'),
(189,0,36,'2022-02-15'),
(190,1,24,'2022-02-15'),
(191,0,32,'2022-02-17'),
(192,0,28,'2022-02-17'),
(193,1,34,'2022-02-19'),
(194,1,27,'2022-02-21'),
(195,1,24,'2022-02-24'),
(196,0,30,'2022-02-24'),
(197,0,39,'2022-02-27'),
(198,1,43,'2022-03-02'),
(199,0,28,'2022-03-03'),
(200,0,21,'2022-03-03');
/*!40000 ALTER TABLE `USER_INFO` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=403 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='학과';
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
(402,'심리학과','인문사회관','051-132-4567','psy@myschool.ac.kr',1987,'http://psy.myschool.ac.kr');
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
(10101,'황진우','hhan',1,'7b761b8750a5560337f93d1d4748ec2817a22e5c0f17af259ca0a2aae0077ec2','2001-10-19 00:00:00','017-887-6693',151,62,'minjae67@yu.kr','남','재학','http://myschool.ac.kr/photos/hhan.jpg','2020-10-19',NULL,101,9901),
(10102,'서순옥','ojimin',4,'fbdb38da9369c4188434918c4b056dfeb623435cba6dc30ac8c1b183eaa2b755','1999-07-22 00:00:00','042-035-3999',152,46,'iminjae@daum.net','남','재학','http://myschool.ac.kr/photos/ojimin.jpg','2018-07-22',NULL,101,NULL),
(10103,'백순옥','gimgyeonghyi',2,'2c2957eb732c867392b707f5a09ad86a3792f4036e1a067a6580dafa2f683fd0','2001-04-19 00:00:00','063-174-8132',184,71,'eunju75@hotmail.com','남','재학','http://myschool.ac.kr/photos/gimgyeonghyi.jpg','2020-04-19',NULL,101,9901),
(10104,'김서연','yeonghogang',4,'9e23f8e8e8b3bca75ceb95ece80e0bd0a31198ebcc9e215ac2436cf107d012da','2005-07-16 00:00:00','041-078-9682',171,62,'hyeonjii@gimhan.net','남','재학','http://myschool.ac.kr/photos/yeonghogang.jpg','2024-07-16',NULL,101,9901),
(10105,'박미영','ni',1,'773710c64f0889e3c54d191b4f123d3e233283dcd2959669b063016dbba9f4ea','2004-01-10 00:00:00','032-491-2811',172,67,'jongsu11@hotmail.com','여','휴학','http://myschool.ac.kr/photos/ni.jpg','2023-01-10',NULL,101,9901),
(10106,'서현지','kgim',1,'c6173d6786e0d2566fd8262d2f0ec6cdc20987d24c6b6570c5d84bfa502d31a8','2005-04-25 00:00:00','017-733-6126',185,63,'hyejingim@yu.net','여','재학','http://myschool.ac.kr/photos/kgim.jpg','2024-04-25',NULL,101,NULL),
(10107,'고정숙','gyeongsug76',2,'b878f226b928dd33ae250c1bdee2debb6e3ee8811f79f56aab675928184a73b6','2004-08-10 00:00:00','031-449-8852',168,50,'yeji40@daum.net','남','졸업','http://myschool.ac.kr/photos/gyeongsug76.jpg','2023-08-10','2027-08-09',101,9901),
(10108,'송영미','mhan',2,'3d8cd8a8b559aeea97708d206cd419f009d4a33cefe9e9cd2680fbdf975ebebd','2005-08-06 00:00:00','032-117-7567',173,67,'gju@yuhanhoesa.kr','남','재학','http://myschool.ac.kr/photos/mhan.jpg','2024-08-06',NULL,101,9901),
(10109,'안서윤','sangho09',2,'6e4f1ce2afe62ebb5d2eff25eac0a638a296ebf86d5df39ec24ddd0c6015db0e','2005-06-11 00:00:00','018-340-5697',184,60,'subin24@nate.com','남','재학','http://myschool.ac.kr/photos/sangho09.jpg','2024-06-11',NULL,101,9901),
(10110,'성성민','yeongjin64',3,'52d41607a9241e34d815643586a3f51d3972a37ff7078241ff6f95ed3bf19046','2005-10-10 00:00:00','054-704-6602',153,59,'yunseosong@live.com','남','휴학','http://myschool.ac.kr/photos/yeongjin64.jpg','2024-10-10',NULL,101,NULL),
(10111,'고미영','doyun18',3,'26befa41e26de777d0c982a70215f143d0e8ea405c3f7a20b15471aa802c2cc3','2006-01-04 00:00:00','064-796-7461',163,86,'eyun@gmail.com','여','재학','http://myschool.ac.kr/photos/doyun18.jpg','2025-01-04',NULL,102,9904),
(10112,'장하윤','hyeonjeong23',2,'8171cb54dce6249575c98bd9f2941319cd889ad147621994ac0f513688f58b23','2004-10-19 00:00:00','011-326-5155',165,80,'yejian@yuhanhoesa.com','여','휴학','http://myschool.ac.kr/photos/hyeonjeong23.jpg','2023-10-19',NULL,102,9904),
(10113,'최서영','junyeonggwag',2,'b0ee8d9942e1f192b412a15b215867f9493de7c16cf57659603d7bedc863d95a','2005-07-09 00:00:00','044-061-9736',158,77,'jongsui@daum.net','여','재학','http://myschool.ac.kr/photos/junyeonggwag.jpg','2024-07-09',NULL,102,9903),
(10114,'김명숙','jinu82',4,'32e37de4f6c6794c167ec1e17c467dec35f9d566a6cff03b0cb92aac7679ff76','1999-10-04 00:00:00','042-194-8127',188,49,'eunjijang@gimjini.com','여','재학','http://myschool.ac.kr/photos/jinu82.jpg','2018-10-04',NULL,102,9906),
(10115,'황예지','cayeonghyi',1,'845356558241ab1e3e98e1bd2f53121f1e557139d32dfca18b49e44264ffda7f','2006-12-06 00:00:00','061-239-3584',157,88,'bagsujin@gmail.com','여','휴학','http://myschool.ac.kr/photos/cayeonghyi.jpg','2025-12-06',NULL,102,9903),
(10116,'김정훈','yejingweon',4,'1695db96d6058063b110d42311b04f703ac1b1fee81dbad0788b7d594d827e70','2006-10-18 00:00:00','055-103-7716',150,61,'dgim@daum.net','남','재학','http://myschool.ac.kr/photos/yejingweon.jpg','2025-10-18',NULL,102,9906),
(10117,'최혜진','yujin33',2,'593d4f9025e6d249684e0b384ab5dcc6c5858c6a3448dd1ef0959dcfe7873ad2','2001-03-17 00:00:00','042-217-2047',159,68,'songminjun@live.com','남','재학','http://myschool.ac.kr/photos/yujin33.jpg','2020-03-17',NULL,102,9902),
(10118,'강지우','jiyejin',3,'b916bbb616ae7b0cac9b4e6744f47668e12e5f0406962f2cf22632db15ad0093','2003-09-02 00:00:00','041-507-6667',181,46,'ihyeonu@ju.com','남','졸업','http://myschool.ac.kr/photos/jiyejin.jpg','2022-09-02','2026-09-01',102,9904),
(10119,'박은영','egim',2,'89043a70be43049c811ffd46c6bffe7a39a57fd1cdd4a06a1626ab421e323a92','2000-04-23 00:00:00','011-577-9875',153,60,'seungmingweon@naver.com','남','재학','http://myschool.ac.kr/photos/egim.jpg','2019-04-23',NULL,102,NULL),
(10120,'박서현','hyeonji18',2,'6e2208af2fa52cca2e2ce3616dfaaf3b78a5a27a0dd8ecc5502239667dae317d','2000-03-04 00:00:00','010-2080-5361',158,87,'hcoe@ju.com','여','졸업','http://myschool.ac.kr/photos/hyeonji18.jpg','2019-03-04','2023-03-03',201,9911),
(10121,'한명자','bagjeonghun',4,'6a4a8aa77ad16ecd1667eb5d73b4121bd3feb480c7e8f3b9a0fd02b5fa1ac69f','2001-01-21 00:00:00','061-914-7543',163,79,'seonghyeongweon@hotmail.com','남','휴학','http://myschool.ac.kr/photos/bagjeonghun.jpg','2020-01-21',NULL,201,9909),
(10122,'이순자','minjihwang',4,'dfbd86f30959d02a6698e7049c649575eed97d0ab2d3f41655ea09ff36cb06b6','2004-04-12 00:00:00','019-634-5609',183,73,'bagmyeongsug@nate.com','남','재학','http://myschool.ac.kr/photos/minjihwang.jpg','2023-04-12',NULL,201,NULL),
(10123,'김병철','ki',2,'b0993aca44c7454cd8d100d7d812516e14be5cc93130f73ba2f179bc96eeaeb6','1999-11-20 00:00:00','017-804-9523',187,59,'jeongsun07@hanmail.net','남','재학','http://myschool.ac.kr/photos/ki.jpg','2018-11-20',NULL,201,9907),
(10124,'최예지','ryang',3,'bf7a3bd1c024b9fa80126f1d0322387a4afd3167ac4009b77c834e4c7503f84a','1999-04-11 00:00:00','043-852-3775',154,77,'najeongsig@ju.org','남','재학','http://myschool.ac.kr/photos/ryang.jpg','2018-04-11',NULL,201,9911),
(10125,'최정미','eomyeongsug',4,'8605e18d07c30888437dbe66e75673d4eb7bffba0a054d9906ec84caa3638335','1999-09-10 00:00:00','054-570-0988',165,75,'bagmisug@hotmail.com','여','재학','http://myschool.ac.kr/photos/eomyeongsug.jpg','2018-09-10',NULL,201,9910),
(10126,'송정식','sangceol72',4,'35da11abe25d3bf3bb57999b9c561c417a1f6ab4f0ab1db65553a2ce7004efb3','1999-10-01 00:00:00','062-868-5159',179,48,'gimeunju@dreamwiz.com','남','재학','http://myschool.ac.kr/photos/sangceol72.jpg','2018-10-01',NULL,201,9907),
(10127,'박은영','ihan',2,'f1a8d5c9b0dfe3ed135f8a0ac2a87ab8ef9dfac6ebe3e4fa6f03633d8840ed2e','2003-05-05 00:00:00','054-298-9727',162,57,'sunja37@yuhanhoesa.org','여','재학','http://myschool.ac.kr/photos/ihan.jpg','2022-05-05',NULL,201,9907),
(10128,'이지원','gimhyejin',4,'9a7efa486cc14f47b746e68c1d5ffe878ad67232826068a36ffa85b0506ffbbc','2005-02-07 00:00:00','053-896-1670',185,51,'ijihye@naver.com','남','재학','http://myschool.ac.kr/photos/gimhyejin.jpg','2024-02-07',NULL,201,NULL),
(10129,'김아름','gweonjia',2,'2ccd444a23e2f666ef54dd3b43cdb6c0ef1fe63b759d28f3cc292a39e4bf1e7a','2000-02-18 00:00:00','032-923-7535',160,71,'hgim@yunbae.kr','여','재학','http://myschool.ac.kr/photos/gweonjia.jpg','2019-02-18',NULL,202,9912),
(10130,'문지호','jeonyeongja',4,'43521fc885a30e5e70bd3b2ce90d63d3e94a4da4adec46ef381e49c0a994b2a7','2005-03-19 00:00:00','044-071-5331',150,69,'gimsugja@baghong.kr','여','졸업','http://myschool.ac.kr/photos/jeonyeongja.jpg','2024-03-19','2028-03-18',202,9912),
(10131,'권정수','yeongsigi',2,'c8830e437defaa612681a6a71cb1be41dde129ee6e88ea6e4806b8ec8f8b5f35','2005-04-30 00:00:00','019-574-6275',162,63,'vgu@hanmail.net','남','퇴학','http://myschool.ac.kr/photos/yeongsigi.jpg','2024-04-30',NULL,202,9912),
(10132,'전미영','jeongungjo',1,'dc20eebc22cc0797a9fa6515e50bb70ba776423724be4b994fe9fdaeab12b058','2002-02-28 00:00:00','051-910-0578',153,82,'icaeweon@jusighoesa.kr','여','재학','http://myschool.ac.kr/photos/jeongungjo.jpg','2021-02-28',NULL,202,9912),
(10133,'최현주','ean',2,'b5897e90436d8c26ee39aaf97af260b6babb47149d4e9576042201ed159202f5','1999-06-26 00:00:00','055-443-2111',154,83,'yeongsun06@seoibaeg.com','남','재학','http://myschool.ac.kr/photos/ean.jpg','2018-06-26',NULL,202,9912),
(10134,'이민영','eunjui',1,'1b331873f01b46887dd744e06609d89db2da493407adbe02b110f207992eee98','2006-03-28 00:00:00','053-537-4240',189,50,'yujin37@dreamwiz.com','여','재학','http://myschool.ac.kr/photos/eunjui.jpg','2025-03-28',NULL,203,9915),
(10135,'박가람','coeyunseo',2,'a6c80d3cadbe404754c4fff9d348c47fcf977c4bd3f147f863ad270a9bce9c89','2004-10-31 00:00:00','02-7259-4559',170,60,'jangseoyun@ju.com','여','재학','http://myschool.ac.kr/photos/coeyunseo.jpg','2023-10-31',NULL,203,9915),
(10136,'김준혁','gimjiyeong',1,'bd25c0bea72d090b3c2e7efdf5cfd902b989c707f6ed8405a4f7a1d79f44b787','2005-11-13 00:00:00','031-191-0779',150,74,'seohyeonsug@juii.com','남','재학','http://myschool.ac.kr/photos/gimjiyeong.jpg','2024-11-13',NULL,203,9915),
(10137,'한영자','jiyeonghyi',1,'cebd16f4145b935fd46a9b801d1523ea4ae4af6ff9c7d1a8d46964ef669bb1f6','2005-08-01 00:00:00','017-087-3248',165,68,'songsangho@dreamwiz.com','여','재학','http://myschool.ac.kr/photos/jiyeonghyi.jpg','2024-08-01',NULL,203,9917),
(10138,'홍지후','gusangho',1,'12b1736b58326f762b9761abfe91c50327e6993f79ad34cadca468fe5a720bc0','2004-12-20 00:00:00','019-439-2722',185,64,'cunjagim@ibaeg.kr','남','졸업','http://myschool.ac.kr/photos/gusangho.jpg','2023-12-20','2027-12-19',203,9913),
(10139,'양영수','jongsu22',2,'d61558b9fc876ca6df3589381cbedcb6716330700599feacf508b8bb80d12183','1999-08-20 00:00:00','070-4768-5028',167,63,'seonghogwag@daum.net','남','휴학','http://myschool.ac.kr/photos/jongsu22.jpg','2018-08-20',NULL,203,9915),
(10140,'손영호','coeseungmin',4,'0d8081229379de71149c5ffb8756ceb154c86e8cea6b5900722acaa1253d65ef','2004-01-30 00:00:00','042-328-2901',166,48,'nbag@ganggwag.kr','남','재학','http://myschool.ac.kr/photos/coeseungmin.jpg','2023-01-30',NULL,203,NULL),
(10141,'김영지','jimingim',3,'d0f103a3dff9fa17c27f324d32699ebfc3f476952bad20659b241ba46c94d834','1999-12-02 00:00:00','019-531-5971',158,85,'ggim@jusighoesa.net','여','재학','http://myschool.ac.kr/photos/jimingim.jpg','2018-12-02',NULL,203,9917),
(10142,'심지아','jinubag',1,'d9f049f9d30a2da2971906c9449e09f16d8bf42ac63ac9a4c5f9192828330948','1999-08-28 00:00:00','011-297-5207',157,49,'rjang@jusighoesa.org','남','재학','http://myschool.ac.kr/photos/jinubag.jpg','2018-08-28',NULL,203,9914),
(10143,'윤정희','minjae02',2,'bfa01bf20bb3dbc6cd28fe4aa273919df46ae823956c2aea087bcc9bb66fead6','2006-08-12 00:00:00','053-681-8103',152,64,'jeonogja@naver.com','여','졸업','http://myschool.ac.kr/photos/minjae02.jpg','2025-08-12','2029-08-11',204,9918),
(10144,'권경숙','minseo39',2,'1c04c2b0cdf78792ad4880a0b16af83b046678fdc875a1e861930936b78b4218','2005-03-02 00:00:00','041-483-8575',165,87,'ihyeonjun@daum.net','남','재학','http://myschool.ac.kr/photos/minseo39.jpg','2024-03-02',NULL,204,9918),
(10145,'배혜진','yeongho24',2,'4dad2e0475aac7764c51374a6be12c28bc31921cd9bd4b0d08cfb7d638b746f2','2002-06-12 00:00:00','062-241-0213',160,56,'dohyeon60@gwagjiju.com','여','재학','http://myschool.ac.kr/photos/yeongho24.jpg','2021-06-12',NULL,204,9918),
(10146,'김은정','misuggim',2,'860476ec4211e35a67ebf9e4d397234afa908709fcd4df17bac9ee6edd851f37','2003-09-05 00:00:00','052-766-3129',167,55,'gwangsui@baggwago.kr','남','재학','http://myschool.ac.kr/photos/misuggim.jpg','2022-09-05',NULL,204,9918),
(10147,'권민준','seoyun91',4,'c8b23a4dad6e6cd641c4f2a5e03fda3029ddce61bf70276ce5a305f4688ea20c','2004-10-30 00:00:00','063-780-7911',172,64,'junho69@gmail.com','남','재학','http://myschool.ac.kr/photos/seoyun91.jpg','2023-10-30',NULL,204,9918),
(10148,'김서연','jo',1,'7f1d7b4932102b572d9efe05934ddb87f6647e20636eff15e2dbf0293828063f','2001-07-24 00:00:00','052-121-4653',167,67,'gimjeongnam@yu.net','여','재학','http://myschool.ac.kr/photos/jo.jpg','2020-07-24',NULL,204,9918),
(10149,'김자영','sgim',1,'b33a78218c3bb3e0193891a6e9dfad3a16d0f10497d28ca9b8582e004e2fbb18','2007-01-16 00:00:00','070-7807-6674',166,56,'yunyeongceol@yu.org','여','재학','http://myschool.ac.kr/photos/sgim.jpg','2026-01-16',NULL,204,9918),
(10150,'양도윤','yeongil06',4,'138feb53af49816d690d40f9ad2045d15d9ee4bc10d89fb3eca72cb64d4294d2','2006-03-28 00:00:00','052-241-7778',188,77,'dgim@munio.org','남','재학','http://myschool.ac.kr/photos/yeongil06.jpg','2025-03-28',NULL,204,9918),
(10151,'심지현','jiweon13',2,'44733de63a2749363f886aa84f457cb1c632f0704e9f7a8b172ad6d2cf0366eb','2006-02-03 00:00:00','051-578-7189',173,72,'gyeongsuggweon@hanmail.net','남','졸업','http://myschool.ac.kr/photos/jiweon13.jpg','2025-02-03','2029-02-02',301,9919),
(10152,'민지민','myang',3,'4cf5bb0c44a78f4131dc1056866a70344b565513e261ef3d4fee718704d70a0f','2006-06-14 00:00:00','011-852-7725',182,64,'gimminsu@munsimseong.kr','여','재학','http://myschool.ac.kr/photos/myang.jpg','2025-06-14',NULL,301,9920),
(10153,'손지후','cyu',4,'eee5e239549f33adf24d4d9f02a75da1ec430cab94d1368ab063e583cadc8bbb','1999-10-29 00:00:00','051-572-8527',174,88,'coeeunju@live.com','남','재학','http://myschool.ac.kr/photos/cyu.jpg','2018-10-29',NULL,301,9919),
(10154,'오영미','si',3,'e9fba28cbc8cf4b7ad05af3a03175651d97198430034fa40d4de31a23258ff8b','2000-03-29 00:00:00','055-349-7256',168,58,'fgim@hanmail.net','여','휴학','http://myschool.ac.kr/photos/si.jpg','2019-03-29',NULL,301,9922),
(10155,'김수민','ogjagim',4,'aa0d454a6fb9e7654205e16082ef69716c4d7588c60a777d8bce11f19eb7605d','1999-11-06 00:00:00','063-194-1106',163,77,'gimboram@hanmail.net','여','휴학','http://myschool.ac.kr/photos/ogjagim.jpg','2018-11-06',NULL,301,9919),
(10156,'이민영','gimyeongmi',3,'8c336a52d08d09573faf94103673199cb663afb8d55117aee567a4295549147b','2000-03-12 00:00:00','054-241-4562',155,60,'jeonghunyun@yu.com','여','재학','http://myschool.ac.kr/photos/gimyeongmi.jpg','2019-03-12',NULL,302,NULL),
(10157,'백승현','gujiu',2,'d6e3eaebfc3348fe36092d290520cbfbb5bcde754e80366342e80e0b17288771','2005-10-30 00:00:00','02-5470-7683',180,84,'qgim@jusighoesa.com','남','재학','http://myschool.ac.kr/photos/gujiu.jpg','2024-10-30',NULL,302,9923),
(10158,'박민석','jeonseongmin',4,'963f687af54094f1f0589613bdd691293cd68fc4ad5e601329cfec4f377f4be3','2003-03-10 00:00:00','051-097-6035',175,60,'jyang@naver.com','남','재학','http://myschool.ac.kr/photos/jeonseongmin.jpg','2022-03-10',NULL,302,9923),
(10159,'구영미','simseunghyeon',4,'27897a20cc11faebb793401464340e9e33579805fb6d87b830390b67fd96891e','2002-03-27 00:00:00','016-117-1565',164,56,'gimyeongho@naver.com','여','재학','http://myschool.ac.kr/photos/simseunghyeon.jpg','2021-03-27',NULL,302,9923),
(10160,'김서연','sujingim',2,'845d9ab9aa6d2b8a8ee04c2507fba253ce20b9a412a070c3b2ce92fc8da13d0a','2006-11-24 00:00:00','053-802-2592',179,87,'myeongjayang@ii.kr','여','퇴학','http://myschool.ac.kr/photos/sujingim.jpg','2025-11-24',NULL,302,9923),
(10161,'이서윤','msong',4,'ea6752363c8fa05ad7bba1cebd99219d1c1691f7ec61878b536a00eaab1aaf19','2004-12-31 00:00:00','031-820-0437',160,75,'gimyeeun@live.com','여','재학','http://myschool.ac.kr/photos/msong.jpg','2023-12-31',NULL,302,9923),
(10162,'김현지','nojiweon',2,'0a57c4219b00b70512a66c771dfcc9f46227a2d9528ae834ee2ed3d9a5fe5098','2003-12-14 00:00:00','019-498-0988',167,73,'lsong@jusighoesa.com','남','휴학','http://myschool.ac.kr/photos/nojiweon.jpg','2022-12-14',NULL,302,9923),
(10163,'이광수','lseo',2,'de0fda5289c41925bd08424454fb30f734800e349c7deaa2a1455a3657be88e0','2001-02-07 00:00:00','032-558-1062',164,69,'yeonghwan67@hotmail.com','남','휴학','http://myschool.ac.kr/photos/lseo.jpg','2020-02-07',NULL,401,9925),
(10164,'권영진','minjaebag',4,'4821e6a40d555e582db7a7540727f020714952901c8fc61120bcda6ec300a8b2','1999-04-02 00:00:00','070-0254-7258',153,58,'iyejin@imun.kr','여','재학','http://myschool.ac.kr/photos/minjaebag.jpg','2018-04-02',NULL,401,9924),
(10165,'박은영','jihuyun',4,'ab8befe22cac0c815e153655cec98696d188eb8fb8d970be0db2326690918c4b','2002-12-04 00:00:00','055-674-2655',180,45,'yejungo@baesimbag.org','여','재학','http://myschool.ac.kr/photos/jihuyun.jpg','2021-12-04',NULL,401,9925),
(10166,'이주원','xbag',2,'64a7a2c1703e8b07901276f593d9222a4cf91b45e89341031f850b3d4819573c','2001-05-20 00:00:00','064-783-5458',181,59,'seonyeongi@naver.com','여','재학','http://myschool.ac.kr/photos/xbag.jpg','2020-05-20',NULL,401,9925),
(10167,'이진우','yeongceol98',2,'5ebc188371175d6ad473d9531049bcccb26f5d23623793ebcaed0470a7f738b5','2001-01-07 00:00:00','011-683-9453',179,53,'hyejin77@naver.com','남','졸업','http://myschool.ac.kr/photos/yeongceol98.jpg','2020-01-07','2024-01-06',401,9924),
(10168,'오하윤','yeongsugbag',4,'9baa0e1bce9513536c4b80b91b6e3d8842ba09fd451c64f1f14d17edb36052dd','2002-04-19 00:00:00','016-436-8577',158,74,'jaehogim@daum.net','남','재학','http://myschool.ac.kr/photos/yeongsugbag.jpg','2021-04-19',NULL,401,9925),
(10169,'강재현','gimboram',4,'c90ec713328b27e99be3232ab5d0f3c63d15d23be1f1ee4ad56ee2aa158db795','2007-01-31 00:00:00','054-746-9188',167,71,'yeonggilgim@igim.kr','여','휴학','http://myschool.ac.kr/photos/gimboram.jpg','2026-01-31',NULL,402,9926),
(10170,'황동현','yeongil91',3,'07dfa0be849d170c15124a060d991baceb20b042f20ecdf4597c95056ff6f912','2003-01-12 00:00:00','018-676-0085',164,86,'eunseo74@naver.com','남','휴학','http://myschool.ac.kr/photos/yeongil91.jpg','2022-01-12',NULL,402,9927),
(10171,'배미정','jiagim',2,'099efdf307343b1b6891c0857c5c8bfa1927358cc0bab94266099e867364a76f','2006-12-08 00:00:00','054-491-0236',151,84,'yeongsig15@hotmail.com','남','재학','http://myschool.ac.kr/photos/jiagim.jpg','2025-12-08',NULL,402,9927),
(10172,'김숙자','ugim',4,'f72a878c6686212f0facaebb6778d0c0deed3c90af88cdc54f47ea7787f260d1','2004-05-04 00:00:00','051-773-1391',166,68,'hyeonjunsong@dreamwiz.com','남','재학','http://myschool.ac.kr/photos/ugim.jpg','2023-05-04',NULL,402,9927),
(10173,'안선영','jiweongim',3,'6e03a5f36c1ec3e3a2ce64273bcfe6e45ddc8f7287e1e3e7468ee0e0ba9eba2f','2001-03-13 00:00:00','033-482-7910',156,82,'boramo@gimgimgim.com','남','졸업','http://myschool.ac.kr/photos/jiweongim.jpg','2020-03-13','2024-03-12',402,9929),
(10174,'이지민','geonu06',4,'7409254bfe5c873dcef673b8fc6d6a5147d235923a1933d82796a39436a92c53','2006-08-30 00:00:00','070-4903-8642',162,49,'hanyeongceol@live.com','남','재학','http://myschool.ac.kr/photos/geonu06.jpg','2025-08-30',NULL,402,9930),
(10175,'문은서','gyeongsu72',1,'f7a4dc511a56943db3aacf3e57892a43e47407c1cf451a7b1d468f85506bebf6','2003-09-10 00:00:00','016-883-7377',186,47,'yeongsu76@live.com','여','재학','http://myschool.ac.kr/photos/gyeongsu72.jpg','2022-09-10',NULL,402,NULL);
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
/*!50003 DROP PROCEDURE IF EXISTS `SP_TABLE_INFO_ALL` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_TABLE_INFO_ALL`()
BEGIN
    -- 종료 조건 변수
    DECLARE _done INT DEFAULT FALSE;

    -- 현재 스키마 이름 저장
    DECLARE _current_schema VARCHAR(100);

    -- 테이블 이름을 담을 변수
    DECLARE _table_name VARCHAR(100);

    -- 커서 선언 (변수 선언 다음에 위치해야 함)
    DECLARE MY_CURSOR CURSOR FOR
        SELECT table_name
        FROM information_schema.tables
        WHERE table_schema = DATABASE();

    -- 핸들러는 커서 선언 다음에 위치해야 함
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET _done = TRUE;

    -- 현재 스키마 이름 저장
    SET _current_schema = DATABASE();

    -- 커서 열기
    OPEN MY_CURSOR;

    -- 커서 반복 처리
    read_loop: REPEAT
        FETCH MY_CURSOR INTO _table_name;

        IF NOT _done THEN
            -- 각 테이블의 컬럼 정보 출력
            SELECT
                _table_name AS '테이블',
                ORDINAL_POSITION AS '번호',
                COLUMN_NAME AS '필드명',
                COLUMN_TYPE AS '속성',
                IS_NULLABLE AS 'NULL',
                COLUMN_KEY AS 'KEY',
                EXTRA AS '자동증가',
                COLUMN_DEFAULT AS '기본값',
                COLUMN_COMMENT AS '설명'
            FROM
                INFORMATION_SCHEMA.COLUMNS
            WHERE
                TABLE_SCHEMA = _current_schema
                AND TABLE_NAME = _table_name
            ORDER BY
                ORDINAL_POSITION;
        END IF;

    UNTIL _done END REPEAT read_loop;

    -- 커서 닫기
    CLOSE MY_CURSOR;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_TABLE_INFO_PROGRAMMERS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_TABLE_INFO_PROGRAMMERS`()
BEGIN
    -- 종료 조건 변수
    DECLARE _done INT DEFAULT FALSE;

    -- 현재 스키마 이름 저장
    DECLARE _current_schema VARCHAR(100);

    -- 테이블 이름을 담을 변수
    DECLARE _table_name VARCHAR(100);

    -- 커서 선언 (변수 선언 다음에 위치해야 함)
    DECLARE MY_CURSOR CURSOR FOR
        SELECT table_name
        FROM information_schema.tables
        WHERE table_schema = DATABASE()
        AND table_name NOT IN ('departments', 'professors', 'students', 'enrollments', 'subjects');

    -- 핸들러는 커서 선언 다음에 위치해야 함
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET _done = TRUE;

    -- 현재 스키마 이름 저장
    SET _current_schema = DATABASE();

    -- 커서 열기
    OPEN MY_CURSOR;

    -- 커서 반복 처리
    read_loop: REPEAT
        FETCH MY_CURSOR INTO _table_name;

        IF NOT _done THEN
            -- 각 테이블의 컬럼 정보 출력
            SELECT
                _table_name AS '테이블',
                ORDINAL_POSITION AS '번호',
                COLUMN_NAME AS '필드명',
                COLUMN_TYPE AS '속성',
                IS_NULLABLE AS 'NULL',
                COLUMN_KEY AS 'KEY',
                EXTRA AS '자동증가',
                COLUMN_DEFAULT AS '기본값',
                COLUMN_COMMENT AS '설명'
            FROM
                INFORMATION_SCHEMA.COLUMNS
            WHERE
                TABLE_SCHEMA = _current_schema
                AND TABLE_NAME = _table_name
            ORDER BY
                ORDINAL_POSITION;
        END IF;

    UNTIL _done END REPEAT read_loop;

    -- 커서 닫기
    CLOSE MY_CURSOR;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_TABLE_INFO_STUDY` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_TABLE_INFO_STUDY`()
BEGIN
    -- 종료 조건 변수
    DECLARE _done INT DEFAULT FALSE;

    -- 현재 스키마 이름 저장
    DECLARE _current_schema VARCHAR(100);

    -- 테이블 이름을 담을 변수
    DECLARE _table_name VARCHAR(100);

    -- 커서 선언 (변수 선언 다음에 위치해야 함)
    DECLARE MY_CURSOR CURSOR FOR
        SELECT table_name
        FROM information_schema.tables
        WHERE table_schema = DATABASE()
        AND table_name IN ('departments', 'professors', 'students', 'enrollments', 'subjects');

    -- 핸들러는 커서 선언 다음에 위치해야 함
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET _done = TRUE;

    -- 현재 스키마 이름 저장
    SET _current_schema = DATABASE();

    -- 커서 열기
    OPEN MY_CURSOR;

    -- 커서 반복 처리
    read_loop: REPEAT
        FETCH MY_CURSOR INTO _table_name;

        IF NOT _done THEN
            -- 각 테이블의 컬럼 정보 출력
            SELECT
                _table_name AS '테이블',
                ORDINAL_POSITION AS '번호',
                COLUMN_NAME AS '필드명',
                COLUMN_TYPE AS '속성',
                IS_NULLABLE AS 'NULL',
                COLUMN_KEY AS 'KEY',
                EXTRA AS '자동증가',
                COLUMN_DEFAULT AS '기본값',
                COLUMN_COMMENT AS '설명'
            FROM
                INFORMATION_SCHEMA.COLUMNS
            WHERE
                TABLE_SCHEMA = _current_schema
                AND TABLE_NAME = _table_name
            ORDER BY
                ORDINAL_POSITION;
        END IF;

    UNTIL _done END REPEAT read_loop;

    -- 커서 닫기
    CLOSE MY_CURSOR;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-04-07  9:37:22
