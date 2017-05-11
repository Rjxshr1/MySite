-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.50 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 mysite 的数据库结构
DROP DATABASE IF EXISTS `mysite`;
CREATE DATABASE IF NOT EXISTS `mysite` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mysite`;

-- 导出  表 mysite.category 结构
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id`   INT(4) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255)    DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

-- 正在导出表  mysite.category 的数据：1 rows
DELETE FROM `category`;
/*!40000 ALTER TABLE `category`
  DISABLE KEYS */;
INSERT INTO `category` (`id`, `name`) VALUES
  (1, 'Life');
/*!40000 ALTER TABLE `category`
  ENABLE KEYS */;

-- 导出  表 mysite.message 结构
DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `id`      INT(10)     NOT NULL AUTO_INCREMENT,
  `title`   VARCHAR(50)          DEFAULT NULL,
  `content` TEXT,
  `author_id`   INT(11)   NOT NULL,
  `pubdate` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;

-- 正在导出表  mysite.message 的数据：0 rows
DELETE FROM `message`;
/*!40000 ALTER TABLE `message`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `message`
  ENABLE KEYS */;

-- 导出  表 mysite.post 结构
DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `id`          INT(10)   NOT NULL AUTO_INCREMENT,
  `title`       VARCHAR(50)        DEFAULT NULL,
  `content`     TEXT,
  `category_id` INT(11)   NOT NULL,
  `user_id`   INT(11)   NOT NULL,
  `pubdate`     TIMESTAMP NULL     DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;

-- 正在导出表  mysite.post 的数据：0 rows
DELETE FROM `post`;
/*!40000 ALTER TABLE `post`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `post`
  ENABLE KEYS */;

-- 导出  表 mysite.user 结构
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id`       INT(4) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255)    DEFAULT NULL,
  `password` VARCHAR(32)     DEFAULT NULL,
  `admin`    TINYINT(1)      DEFAULT '0',
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

-- 正在导出表  mysite.user 的数据：1 rows
DELETE FROM `user`;
/*!40000 ALTER TABLE `user`
  DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `admin`) VALUES
  (1, 'admin', 'admin', 1);
INSERT INTO `user` (`id`, `username`, `password`, `admin`) VALUES
  (2, 'jason', '123', 0);
INSERT INTO `user` (`id`, `username`, `password`, `admin`) VALUES
  (3, 'jane', 'abc', 0);
/*!40000 ALTER TABLE `user`
  ENABLE KEYS */;
/*!40101 SET SQL_MODE = IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS = IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
