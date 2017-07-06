/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : jiazhao

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2017-07-06 16:58:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `url` varchar(255) DEFAULT NULL COMMENT '链接',
  `title` varchar(255) DEFAULT NULL COMMENT '题目',
  `answer` varchar(255) DEFAULT NULL COMMENT '答案',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=649 DEFAULT CHARSET=utf8 COMMENT='试题';
