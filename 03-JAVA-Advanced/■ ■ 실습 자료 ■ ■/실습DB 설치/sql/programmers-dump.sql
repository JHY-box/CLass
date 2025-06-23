/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.4.5-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: programmers
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
-- Current Database: `programmers`
--

DROP DATABASE IF EXISTS `programmers`;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `programmers` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `programmers`;

--
-- Table structure for table `AIR_POLLUTION`
--

DROP TABLE IF EXISTS `AIR_POLLUTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `AIR_POLLUTION` (
  `LOCATION1` varchar(100) DEFAULT NULL COMMENT '지역구분1',
  `LOCATION2` varchar(100) DEFAULT NULL COMMENT '지역구분2',
  `YM` date DEFAULT NULL COMMENT '측정일',
  `PM_VAL1` int(11) DEFAULT NULL COMMENT '미세먼지 오염도',
  `PM_VAL2` int(11) DEFAULT NULL COMMENT '초미세먼지 오염도'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='전국의 월별 미세먼지 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AIR_POLLUTION`
--

LOCK TABLES `AIR_POLLUTION` WRITE;
/*!40000 ALTER TABLE `AIR_POLLUTION` DISABLE KEYS */;
INSERT INTO `AIR_POLLUTION` VALUES
('경기도','수원','2018-01-01',48,27),
('경기도','수원','2018-02-01',51,30),
('경기도','수원','2018-03-01',52,21),
('경기도','수원','2018-04-01',52,20),
('경기도','수원','2018-05-01',45,19),
('경기도','수원','2018-06-01',39,17),
('경기도','수원','2018-07-01',27,15),
('경기도','수원','2018-08-01',26,16),
('경기도','수원','2018-09-01',21,12),
('경기도','수원','2018-10-01',31,18),
('경기도','수원','2018-11-01',56,21),
('경기도','수원','2018-12-01',44,27),
('서울시','노원','2018-11-01',25,45),
('경기도','용인','2018-02-01',14,21);
/*!40000 ALTER TABLE `AIR_POLLUTION` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Table structure for table `ANIMAL_OUTS`
--

DROP TABLE IF EXISTS `ANIMAL_OUTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `ANIMAL_OUTS` (
  `ANIMAL_ID` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '동물의 아이디',
  `ANIMAL_TYPE` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '생물 종',
  `DATETIME` datetime NOT NULL COMMENT '입양일',
  `NAME` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '이름',
  `SEX_UPON_OUTCOME` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '성별 및 중성화 여부',
  PRIMARY KEY (`ANIMAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='입양 보낸 동물 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ANIMAL_OUTS`
--

LOCK TABLES `ANIMAL_OUTS` WRITE;
/*!40000 ALTER TABLE `ANIMAL_OUTS` DISABLE KEYS */;
INSERT INTO `ANIMAL_OUTS` VALUES
('A349480','Dog','2013-12-22 11:30:00','Daisy','Spayed Female'),
('A349733','Dog','2017-09-27 19:09:00','Allie','Spayed Female'),
('A349990','Cat','2018-02-02 14:18:00','Spice','Spayed Female'),
('A349996','Cat','2018-02-02 14:17:00','Sugar','Neutered Male'),
('A350276','Cat','2018-01-28 17:51:00','Jewel','Spayed Female'),
('A350375','Cat','2017-05-23 16:17:00','Meo','Neutered Male'),
('A352555','Dog','2014-08-10 18:57:00','Harley','Spayed Female'),
('A352713','Cat','2017-04-25 12:25:00','Gia','Spayed Female'),
('A352872','Dog','2015-07-16 17:58:00','Peanutbutter','Neutered Male'),
('A353259','Dog','2016-05-09 10:40:00','Bj','Neutered Male'),
('A354540','Cat','2015-01-22 12:07:00','Tux','Neutered Male'),
('A354597','Cat','2014-06-03 12:30:00','Ariel','Spayed Female'),
('A354725','Dog','2015-08-29 15:17:00','Kia','Spayed Female'),
('A354753','Dog','2017-04-22 11:27:00','Sammy','Neutered Male'),
('A355519','Dog','2015-05-09 11:15:00','Faith','Spayed Female'),
('A355688','Dog','2014-02-23 17:48:00','Shadow','Neutered Male'),
('A355753','Dog','2015-09-19 18:08:00','Elijah','Neutered Male'),
('A357021','Dog','2014-12-04 15:34:00','Queens','Spayed Female'),
('A357444','Dog','2016-03-14 17:24:00','Puppy','Neutered Male'),
('A357846','Dog','2016-03-17 18:32:00','Happy','Neutered Male'),
('A358697','Dog','2015-02-12 18:50:00','Fuzzo','Neutered Male'),
('A358879','Dog','2015-09-15 16:22:00','Simba','Neutered Male'),
('A361391','Dog','2015-04-20 11:23:00','Baby Bear','Neutered Male'),
('A362103','Dog','2014-11-19 15:35:00','Stitch','Neutered Male'),
('A362137','Dog','2014-01-01 07:39:00','*Darcy','Spayed Female'),
('A362383','Dog','2016-03-22 17:53:00','*Morado','Neutered Male'),
('A362707','Dog','2017-01-10 10:44:00','Girly Girl','Spayed Female'),
('A362967','Dog','2014-06-15 11:14:00','Honey','Spayed Female'),
('A363653','Dog','2014-11-18 11:55:00','Goofy','Neutered Male'),
('A364429','Dog','2015-09-28 18:13:00','Hugo','Neutered Male'),
('A365172','Dog','2014-08-30 16:47:00','Diablo','Neutered Male'),
('A365302','Dog','2017-01-08 17:29:00','Minnie','Spayed Female'),
('A367012','Dog','2015-09-16 13:07:00','Miller','Neutered Male'),
('A367438','Dog','2015-09-12 13:30:00','Cookie','Spayed Female'),
('A367747','Dog','2014-11-04 08:34:00','Woody','Neutered Male'),
('A368742','Dog','2018-02-03 16:06:00','Stormy','Spayed Female'),
('A368930','Dog','2014-06-13 15:52:00','','Spayed Female'),
('A370439','Dog','2016-06-25 14:15:00','Sniket','Neutered Male'),
('A370507','Cat','2015-08-15 09:24:00','Emily','Spayed Female'),
('A370852','Dog','2013-11-08 13:19:00','Katie','Spayed Female'),
('A371000','Cat','2015-10-02 12:19:00','Greg','Neutered Male'),
('A371102','Dog','2015-08-03 12:19:00','Ceballo','Neutered Male'),
('A371344','Dog','2015-05-11 15:43:00','Sailor','Neutered Male'),
('A371534','Dog','2016-06-07 18:55:00','April','Spayed Female'),
('A373219','Cat','2014-08-05 16:16:00','Ella','Spayed Female'),
('A373687','Dog','2014-04-08 14:05:00','Rosie','Spayed Female'),
('A375393','Dog','2015-06-13 14:22:00','Dash','Neutered Male'),
('A376322','Dog','2014-02-18 16:53:00','Mama Dog','Spayed Female'),
('A376459','Dog','2017-07-09 13:53:00','Dora','Spayed Female'),
('A377750','Dog','2017-10-26 14:19:00','Lucy','Spayed Female'),
('A378348','Dog','2014-04-23 07:43:00','Frijolito','Neutered Male'),
('A378353','Dog','2014-08-02 12:31:00','Lyla','Intact Female'),
('A378818','Dog','2014-07-07 16:34:00','Zoe','Spayed Female'),
('A378946','Dog','2017-10-14 18:31:00','Mercedes','Spayed Female'),
('A379998','Dog','2013-10-25 12:53:00','Disciple','Intact Male'),
('A380009','Dog','2016-02-12 14:32:00','Pickle','Spayed Female'),
('A380320','Dog','2014-02-05 14:26:00','Scooby','Neutered Male'),
('A380420','Dog','2018-02-22 07:06:00','Laika','Spayed Female'),
('A380506','Dog','2016-01-23 12:43:00','Ruby','Spayed Female'),
('A381173','Dog','2014-08-06 17:12:00','Pepper','Spayed Female'),
('A381217','Dog','2017-06-09 18:51:00','Cherokee','Neutered Male'),
('A382192','Dog','2015-03-16 13:46:00','Maxwell 2','Neutered Male'),
('A382251','Dog','2014-11-08 19:01:00','Princess','Spayed Female'),
('A383036','Cat','2014-06-28 13:40:00','Oreo','Neutered Male'),
('A383964','Dog','2017-02-05 17:56:00','Finney','Neutered Male'),
('A384360','Cat','2014-07-16 18:34:00','Jj','Neutered Male'),
('A384568','Cat','2014-12-28 13:47:00','Jedi','Neutered Male'),
('A385442','Dog','2014-01-11 16:00:00','Clyde','Neutered Male'),
('A386005','Dog','2015-09-26 11:15:00','Giovanni','Neutered Male'),
('A386276','Cat','2015-12-28 16:24:00','Tiko','Neutered Male'),
('A386688','Dog','2015-08-29 17:46:00','Punch','Neutered Male'),
('A387083','Dog','2014-02-12 11:12:00','Goldie','Spayed Female'),
('A387965','Dog','2014-06-27 11:13:00','Dakota','Spayed Female'),
('A388360','Dog','2015-12-26 13:19:00','Spider','Neutered Male'),
('A388691','Dog','2015-11-29 18:40:00','Blaze','Neutered Male'),
('A390222','Dog','2013-12-15 17:10:00','Holly','Spayed Female'),
('A391512','Dog','2016-04-06 18:14:00','Rome','Neutered Male'),
('A391858','Dog','2017-03-19 18:12:00','Nellie','Spayed Female'),
('A392027','Dog','2014-01-31 18:55:00','Penny','Spayed Female'),
('A392075','Dog','2013-11-20 17:04:00','Skips','Neutered Male'),
('A392615','Dog','2015-07-26 15:18:00','Chip','Neutered Male'),
('A394547','Dog','2015-01-25 11:15:00','Snickerdoodl','Spayed Female'),
('A395451','Dog','2016-01-03 15:54:00','Logan','Neutered Male'),
('A396810','Dog','2016-12-23 13:19:00','Raven','Spayed Female'),
('A397882','Dog','2017-07-12 16:41:00','Charlie','Neutered Male'),
('A399421','Dog','2015-08-25 18:23:00','Lucy','Spayed Female'),
('A399552','Dog','2013-10-18 13:46:00','Jack','Neutered Male'),
('A400498','Dog','2016-10-15 13:57:00','Reggie','Neutered Male'),
('A400680','Dog','2017-10-02 14:35:00','Lucy','Spayed Female'),
('A403564','Dog','2013-11-18 18:51:00','Anna','Spayed Female'),
('A405494','Dog','2014-05-20 11:44:00','Kaila','Spayed Female'),
('A406756','Dog','2016-05-14 11:30:00','Sabrina','Spayed Female'),
('A407156','Dog','2016-10-28 13:22:00','Jake','Neutered Male'),
('A408035','Dog','2014-12-27 12:59:00','Lizzie','Spayed Female'),
('A409637','Dog','2016-04-07 18:33:00','Stanley','Neutered Male'),
('A410330','Dog','2016-09-13 13:46:00','Chewy','Spayed Female'),
('A410668','Cat','2016-06-12 11:46:00','Raven','Spayed Female'),
('A410684','Cat','2014-06-27 17:50:00','Mitty','Spayed Female'),
('A412173','Dog','2015-08-08 12:22:00','Jimminee','Neutered Male'),
('A412626','Dog','2016-03-28 13:15:00','*Sam','Neutered Male');
/*!40000 ALTER TABLE `ANIMAL_OUTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `APPOINTMENT`
--

DROP TABLE IF EXISTS `APPOINTMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `APPOINTMENT` (
  `APNT_YMD` timestamp NULL DEFAULT NULL COMMENT '진료예약일시',
  `APNT_NO` int(11) NOT NULL COMMENT '진료예약번호',
  `PT_NO` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '환자번호',
  `MCDP_CD` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '진료과코드',
  `MDDR_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '의사ID',
  `APNT_CNCL_YN` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '예약취소여부',
  `APNT_CNCL_YMD` date DEFAULT NULL COMMENT '예약취소날짜',
  PRIMARY KEY (`APNT_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='종합병원 진료 예약정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `APPOINTMENT`
--

LOCK TABLES `APPOINTMENT` WRITE;
/*!40000 ALTER TABLE `APPOINTMENT` DISABLE KEYS */;
INSERT INTO `APPOINTMENT` VALUES
('2022-01-03 04:00:00',1,'PT22000009','CS','DR20090029','N',NULL),
('2022-01-13 00:00:00',3,'PT22000006','CS','DR20090001','N',NULL),
('2022-01-13 00:30:00',4,'PT22000001','CS','DR20090001','N',NULL),
('2022-01-13 04:30:00',5,'PT22000007','CS','DR20090001','Y','2022-01-10'),
('2022-01-13 06:30:00',6,'PT22000005','CS','DR20090001','Y','2022-01-11'),
('2022-01-03 02:00:00',7,'PT22000002','NP','DR20100011','N',NULL),
('2022-01-03 02:00:00',8,'PT22000003','OS','DR20090231','N',NULL),
('2022-01-21 23:30:00',9,'PT22000004','NP','DR20100011','N',NULL),
('2022-01-29 06:30:00',10,'PT22000009','CS','DR20090001','Y','2022-01-20'),
('2022-01-29 01:30:00',11,'PT22000012','FM','DR20090112','N',NULL),
('2022-01-29 06:30:00',12,'PT22000011','FM','DR20190102','N',NULL),
('2022-02-01 06:30:00',13,'PT22000009','CS','DR20200012','N',NULL),
('2022-02-13 02:00:00',14,'PT22000002','NP','DR20100011','N',NULL),
('2022-02-23 02:00:00',15,'PT22000003','OS','DR20090231','N',NULL),
('2022-02-14 00:00:00',16,'PT22000013','CS','DR20090029','N',NULL),
('2022-02-14 00:30:00',17,'PT22000014','GS','DR20170123','N',NULL),
('2022-02-05 01:00:00',18,'PT22000015','OS','DR20150231','N',NULL),
('2022-02-05 08:30:00',19,'PT22000016','OB','DR20160031','N',NULL),
('2022-02-13 03:30:00',20,'PT22000017','DR','DR20160039','Y','2022-02-04'),
('2022-02-13 02:30:00',21,'PT22000018','GS','DR20100032','Y','2022-02-10'),
('2022-02-13 01:00:00',22,'PT22000019','GS','DR20100039','N',NULL),
('2022-02-13 03:00:00',23,'PT22000020','FM','DR20010112','N',NULL),
('2022-02-21 23:30:00',24,'PT22000021','GS','DR20100039','N',NULL),
('2022-03-23 06:30:00',25,'PT22000022','FM','DR20100102','Y','2022-03-20'),
('2022-03-24 01:30:00',26,'PT22000023','FM','DR20090112','N',NULL),
('2022-03-24 06:30:00',27,'PT22000024','CS','DR20200012','N',NULL),
('2022-03-24 06:30:00',28,'PT22000025','CS','DR20200012','N',NULL),
('2022-03-30 02:00:00',29,'PT22000001','OS','DR20100031','N',NULL),
('2022-03-29 01:00:00',30,'PT22000002','OS','DR20100031','N',NULL),
('2022-03-03 00:00:00',31,'PT22000018','CS','DR20090029','N',NULL),
('2022-04-13 06:30:00',43,'PT22000019','CS','DR20200012','N',NULL),
('2022-04-04 02:00:00',44,'PT22000022','NP','DR20100011','N',NULL),
('2022-05-18 01:30:00',52,'PT22000019','GS','DR20100039','N',NULL),
('2022-05-19 03:00:00',53,'PT22000020','FM','DR20010112','N',NULL),
('2022-05-21 23:30:00',54,'PT22000021','GS','DR20100039',NULL,NULL),
('2022-05-23 06:30:00',55,'PT22000012','FM','DR20100102','Y','2022-05-16'),
('2022-06-03 00:00:00',63,'PT22000016','CS','DR20090001','N',NULL),
('2022-06-23 00:30:00',64,'PT22000021','CS','DR20190029','N',NULL),
('2022-06-23 02:00:00',67,'PT22000022','NP','DR20100011','N',NULL),
('2022-12-30 03:00:00',119,'PT22000001','OS','DR20100031','N',NULL),
('2022-12-29 02:00:00',120,'PT22000002','OS','DR20100031','N',NULL);
/*!40000 ALTER TABLE `APPOINTMENT` ENABLE KEYS */;
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
  `ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'ID',
  `FIRST_NAME` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '이름',
  `LAST_NAME` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '성',
  `EMAIL` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '이메일',
  `SKILL_1` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '첫 번째 스킬',
  `SKILL_2` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '두 번째 스킬',
  `SKILL_3` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '세 번째 스킬',
  UNIQUE KEY `ID` (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='개발자들의 프로그래밍 스킬 정보';
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
-- Table structure for table `FOOD_ORDER`
--

DROP TABLE IF EXISTS `FOOD_ORDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `FOOD_ORDER` (
  `ORDER_ID` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '주문 ID',
  `PRODUCT_ID` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '제품 ID',
  `AMOUNT` int(11) DEFAULT NULL COMMENT '주문양',
  `PRODUCE_DATE` date DEFAULT NULL COMMENT '생산일자',
  `IN_DATE` date DEFAULT NULL COMMENT '입고일자',
  `OUT_DATE` date DEFAULT NULL COMMENT '출고일자',
  `FACTORY_ID` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '공장 ID',
  `WAREHOUSE_ID` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '창고 ID',
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='식품공장의 주문정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FOOD_ORDER`
--

LOCK TABLES `FOOD_ORDER` WRITE;
/*!40000 ALTER TABLE `FOOD_ORDER` DISABLE KEYS */;
INSERT INTO `FOOD_ORDER` VALUES
('OD00000036','P0071',1200,'2022-03-03','2022-03-16','2022-03-16','FT20040002','WH0021'),
('OD00000037','P0072',2000,'2022-03-07','2022-03-16','2022-03-31','FT20040002','WH0022'),
('OD00000038','P0073',1200,'2022-03-12','2022-03-26','2022-03-31','FT20100004','WH0023'),
('OD00000039','P0074',2000,'2022-03-13','2022-03-16','2022-03-31','FT20140004','WH0024'),
('OD00000040','P0075',1200,'2022-03-15','2022-03-26','2022-03-26','FT20140004','WH0025'),
('OD00000041','P0081',1000,'2022-03-01','2022-03-06',NULL,'FT20090001','WH0001'),
('OD00000042','P0082',1500,'2022-03-10','2022-03-16','2022-03-20','FT20090001','WH0002'),
('OD00000043','P0083',1200,'2022-04-15','2022-04-26','2022-05-01','FT20180005','WH0003'),
('OD00000044','P0084',1000,'2022-04-20','2022-04-26','2022-04-30','FT20180005','WH0004'),
('OD00000045','P0085',1400,'2022-04-25','2022-04-29','2022-05-01','FT20140005','WH0005'),
('OD00000046','P0091',1000,'2022-04-14','2022-04-21','2022-04-29','FT20090002','WH0031'),
('OD00000047','P0092',1500,'2022-04-14','2022-04-29','2022-05-01','FT20090002','WH0032'),
('OD00000048','P0093',1200,'2022-04-19','2022-05-01','2022-05-01','FT20140006','WH0033'),
('OD00000049','P0094',1000,'2022-04-24','2022-05-01','2022-05-01','FT20140006','WH0034'),
('OD00000050','P0095',1800,'2022-04-29','2022-05-11','2022-05-12','FT20170006','WH0035'),
('OD00000051','P0002',4000,'2022-04-01','2022-04-21','2022-04-21','FT19970003','WH0005'),
('OD00000052','P0003',2500,'2022-04-10','2022-04-27','2022-04-27','FT19970003','WH0006'),
('OD00000053','P0005',6200,'2022-04-15','2022-04-30','2022-05-01','FT19940003','WH0003'),
('OD00000054','P0006',1000,'2022-04-21','2022-04-30',NULL,'FT19940003','WH0009'),
('OD00000055','P0008',1500,'2022-04-25','2022-05-11','2022-05-11','FT19980003','WH0009'),
('OD00000056','P0012',1000,'2022-04-04','2022-04-21','2022-04-25','FT19980002','WH0032'),
('OD00000057','P0014',2500,'2022-04-14','2022-04-27','2022-05-01','FT19980002','WH0033'),
('OD00000058','P0017',1200,'2022-05-19','2022-05-28','2022-05-28','FT20070002','WH0033'),
('OD00000059','P0017',1000,'2022-05-24','2022-05-30','2022-05-30','FT20070002','WH0038'),
('OD00000060','P0019',2000,'2022-05-29','2022-06-08','2022-06-08','FT20070002','WH0035'),
('OD00000061','P0022',1000,'2022-05-01','2022-05-21','2022-05-22','FT20060001','WH0011'),
('OD00000062','P0022',1500,'2022-05-10','2022-05-27','2022-05-29','FT20060001','WH0022'),
('OD00000063','P0023',1200,'2022-05-15','2022-05-21','2022-05-29','FT20050001','WH0033'),
('OD00000064','P0024',1000,'2022-05-20','2022-05-29','2022-05-29','FT20050001','WH0044'),
('OD00000065','P0025',1900,'2022-05-25','2022-06-01','2022-06-01','FT20070009','WH0025');
/*!40000 ALTER TABLE `FOOD_ORDER` ENABLE KEYS */;
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
-- Table structure for table `ITEM_INFO`
--

DROP TABLE IF EXISTS `ITEM_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `ITEM_INFO` (
  `ITEM_ID` int(11) NOT NULL COMMENT '아이템 ID',
  `ITEM_NAME` varchar(100) NOT NULL COMMENT '아이템 명',
  `RARITY` varchar(10) NOT NULL COMMENT '아이템의 희귀도',
  `PRICE` int(11) NOT NULL COMMENT '아이템의 가격',
  PRIMARY KEY (`ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='아이템 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ITEM_INFO`
--

LOCK TABLES `ITEM_INFO` WRITE;
/*!40000 ALTER TABLE `ITEM_INFO` DISABLE KEYS */;
INSERT INTO `ITEM_INFO` VALUES
(0,'ITEM_A','COMMON',10000),
(1,'ITEM_B','LEGEND',9000),
(2,'ITEM_C','LEGEND',11000),
(3,'ITEM_D','UNIQUE',10000),
(4,'ITEM_E','LEGEND',12000);
/*!40000 ALTER TABLE `ITEM_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ONLINE_SALE`
--

DROP TABLE IF EXISTS `ONLINE_SALE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `ONLINE_SALE` (
  `ONLINE_SALE_ID` int(11) NOT NULL COMMENT '온라인 상품 판매 ID',
  `USER_ID` int(11) NOT NULL COMMENT '회원 ID',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '상품 ID',
  `SALES_AMOUNT` int(11) NOT NULL COMMENT '판매량',
  `SALES_DATE` date NOT NULL COMMENT '판매일',
  PRIMARY KEY (`ONLINE_SALE_ID`),
  UNIQUE KEY `online_sale_unique_index1` (`USER_ID`,`PRODUCT_ID`,`SALES_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='온라인 상품 판매';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ONLINE_SALE`
--

LOCK TABLES `ONLINE_SALE` WRITE;
/*!40000 ALTER TABLE `ONLINE_SALE` DISABLE KEYS */;
INSERT INTO `ONLINE_SALE` VALUES
(1,2,26,1,'2022-01-01'),
(2,7,1,1,'2022-01-01'),
(3,45,15,1,'2022-01-01'),
(4,154,7,1,'2022-01-02'),
(5,12,7,1,'2022-01-02'),
(6,152,7,1,'2022-01-02'),
(7,109,5,1,'2022-01-02'),
(8,120,4,1,'2022-01-03'),
(9,57,25,1,'2022-01-03'),
(10,109,13,1,'2022-01-05'),
(11,117,7,1,'2022-01-05'),
(12,2,30,1,'2022-01-05'),
(13,131,19,1,'2022-01-05'),
(14,154,29,1,'2022-01-05'),
(15,15,12,3,'2022-01-05'),
(16,90,24,2,'2022-01-07'),
(17,162,30,2,'2022-01-07'),
(18,92,26,1,'2022-01-08'),
(19,123,14,1,'2022-01-08'),
(20,126,9,1,'2022-01-08'),
(21,58,11,2,'2022-01-08'),
(22,149,8,1,'2022-01-09'),
(23,65,19,2,'2022-01-09'),
(24,23,7,1,'2022-01-09'),
(25,81,20,1,'2022-01-12'),
(26,42,19,1,'2022-01-12'),
(27,117,12,1,'2022-01-12'),
(28,108,27,1,'2022-01-14'),
(29,56,28,1,'2022-01-15'),
(30,4,27,2,'2022-01-15'),
(31,143,15,2,'2022-01-15'),
(32,84,8,1,'2022-01-15'),
(33,113,15,2,'2022-01-17'),
(34,120,29,1,'2022-01-17'),
(35,68,15,1,'2022-01-17'),
(36,127,29,1,'2022-01-17'),
(37,57,11,1,'2022-01-17'),
(38,134,18,1,'2022-01-18'),
(39,99,27,1,'2022-01-18'),
(40,101,9,1,'2022-01-21'),
(41,7,5,2,'2022-01-21'),
(42,29,15,1,'2022-01-22'),
(43,73,21,2,'2022-01-22'),
(44,23,26,2,'2022-01-22'),
(45,160,23,2,'2022-01-22'),
(46,134,26,1,'2022-01-24'),
(47,27,3,1,'2022-01-24'),
(48,15,12,3,'2022-01-24'),
(49,34,6,2,'2022-01-24'),
(50,151,26,2,'2022-01-25'),
(51,55,30,3,'2022-01-25'),
(52,78,19,1,'2022-01-26'),
(53,93,3,2,'2022-01-26'),
(54,114,1,1,'2022-01-27'),
(55,58,26,1,'2022-01-27'),
(56,118,1,2,'2022-01-28'),
(57,87,24,2,'2022-01-29'),
(58,22,8,1,'2022-01-31'),
(59,102,18,1,'2022-01-31'),
(60,117,22,1,'2022-01-31'),
(61,35,8,1,'2022-01-31'),
(62,170,25,1,'2022-02-02'),
(63,66,21,1,'2022-02-02'),
(64,14,18,1,'2022-02-02'),
(65,50,24,2,'2022-02-02'),
(66,133,17,1,'2022-02-03'),
(67,121,14,2,'2022-02-04'),
(68,66,4,1,'2022-02-04'),
(69,72,12,1,'2022-02-06'),
(70,62,29,2,'2022-02-06'),
(71,19,26,2,'2022-02-06'),
(72,74,9,1,'2022-02-06'),
(73,119,12,1,'2022-02-07'),
(74,111,30,2,'2022-02-07'),
(75,73,25,1,'2022-02-07'),
(76,46,1,2,'2022-02-07'),
(77,180,30,1,'2022-02-09'),
(78,145,8,1,'2022-02-09'),
(79,59,14,1,'2022-02-09'),
(80,29,26,1,'2022-02-09'),
(81,41,1,1,'2022-02-11'),
(82,157,30,1,'2022-02-11'),
(83,78,4,1,'2022-02-11'),
(84,139,9,1,'2022-02-11'),
(85,54,11,1,'2022-02-11'),
(86,110,9,1,'2022-02-13'),
(87,43,6,2,'2022-02-13'),
(88,53,12,1,'2022-02-13'),
(89,138,4,1,'2022-02-13'),
(90,73,8,1,'2022-02-15'),
(91,91,21,1,'2022-02-15'),
(92,37,1,2,'2022-02-15'),
(93,183,14,1,'2022-02-15'),
(94,60,15,1,'2022-02-16'),
(95,177,9,1,'2022-02-16'),
(96,88,28,1,'2022-02-16'),
(97,78,6,1,'2022-02-16'),
(98,42,30,1,'2022-02-16'),
(99,61,20,1,'2022-02-17'),
(100,123,25,1,'2022-02-17'),
(101,114,12,1,'2022-02-20'),
(102,52,15,1,'2022-02-20'),
(103,24,2,1,'2022-02-22'),
(104,5,12,1,'2022-02-23'),
(105,42,9,1,'2022-02-23'),
(106,134,22,1,'2022-02-23'),
(107,163,6,2,'2022-02-23'),
(108,184,24,2,'2022-02-25'),
(109,119,12,1,'2022-02-25'),
(110,190,25,1,'2022-02-25'),
(111,189,25,1,'2022-02-26'),
(112,2,21,1,'2022-02-26'),
(113,20,24,1,'2022-02-28'),
(114,13,27,2,'2022-02-28'),
(115,70,27,1,'2022-03-01'),
(116,98,3,1,'2022-03-01'),
(117,170,24,1,'2022-03-03'),
(118,68,1,1,'2022-03-03'),
(119,140,4,1,'2022-03-06'),
(120,126,21,2,'2022-03-06'),
(121,68,6,1,'2022-03-06'),
(122,103,29,2,'2022-03-07');
/*!40000 ALTER TABLE `ONLINE_SALE` ENABLE KEYS */;
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
-- Table structure for table `SUBWAY_DISTANCE`
--

DROP TABLE IF EXISTS `SUBWAY_DISTANCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `SUBWAY_DISTANCE` (
  `LINE` varchar(10) DEFAULT NULL COMMENT '호선',
  `NO` int(11) DEFAULT NULL COMMENT '순번',
  `ROUTE` varchar(50) DEFAULT NULL COMMENT '노선',
  `STATION_NAME` varchar(100) DEFAULT NULL COMMENT '역 이름',
  `D_BETWEEN_DIST` float(10,3) DEFAULT NULL COMMENT '역 사이 거리',
  `D_CUMULATIVE` float(10,3) DEFAULT NULL COMMENT '노선별 누계 거리'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='서울지하철 2호선의 역 간 거리 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SUBWAY_DISTANCE`
--

LOCK TABLES `SUBWAY_DISTANCE` WRITE;
/*!40000 ALTER TABLE `SUBWAY_DISTANCE` DISABLE KEYS */;
INSERT INTO `SUBWAY_DISTANCE` VALUES
('2호선',45,'성수지선','용답',2.300,51.100),
('2호선',46,'성수지선','신답',1.000,52.100),
('2호선',47,'성수지선','용두(동대문구청)',0.900,53.000),
('2호선',48,'성수지선','신설동',1.200,54.200),
('2호선',49,'신정지선','도림천',1.000,55.200),
('2호선',50,'신정지선','양천구청',1.700,56.900),
('2호선',51,'신정지선','신정네거리',1.900,58.800),
('2호선',52,'신정지선','까치산',1.400,60.200);
/*!40000 ALTER TABLE `SUBWAY_DISTANCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USED_GOODS_BOARD`
--

DROP TABLE IF EXISTS `USED_GOODS_BOARD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `USED_GOODS_BOARD` (
  `BOARD_ID` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '게시글 ID',
  `WRITER_ID` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '작성자 ID',
  `TITLE` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '게시글 제목',
  `CONTENTS` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '게시글 내용',
  `PRICE` int(11) DEFAULT NULL COMMENT '가격',
  `CREATED_DATE` date DEFAULT NULL COMMENT '작성일',
  `STATUS` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '거래상태',
  `VIEWS` int(11) DEFAULT NULL COMMENT '조회수',
  PRIMARY KEY (`BOARD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='중고거래 게시판 정보';
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
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '회원 ID',
  `GENDER` tinyint(1) DEFAULT NULL COMMENT '성별 (0: 남자, 1: 여자)',
  `AGE` int(11) DEFAULT NULL COMMENT '나이',
  `JOINED` date NOT NULL COMMENT '가입일',
  PRIMARY KEY (`USER_ID`)
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
-- Dumping routines for database 'programmers'
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_TABLE_INFO` */;
ALTER DATABASE `programmers` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ;
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
ALTER DATABASE `programmers` CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-04-11 10:48:32
