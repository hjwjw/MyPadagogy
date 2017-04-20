/*
Navicat MySQL Data Transfer

Source Server         : MyData
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : pada

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-04-20 11:17:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `NAME` varchar(30) NOT NULL COMMENT '管理员名称',
  `PWD` varchar(30) NOT NULL COMMENT '管理员登陆密码',
  `LATE_TIME` date DEFAULT NULL COMMENT '最近登陆时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `appitem`
-- ----------------------------
DROP TABLE IF EXISTS `appitem`;
CREATE TABLE `appitem` (
  `APP_ID` int(11) NOT NULL COMMENT 'app的ID\r\n',
  `USER_ID` int(11) DEFAULT NULL COMMENT '创建用户的ID\r\n',
  `NAME` varchar(30) NOT NULL COMMENT 'APP名称',
  `DOWN_LINK` varchar(0) DEFAULT NULL COMMENT 'app下载链接',
  `INTRODUCE` text NOT NULL COMMENT 'APP介绍',
  `CREATETIME` date DEFAULT NULL COMMENT '创建时间',
  `STATE` tinyint(1) NOT NULL COMMENT 'app 的展示状态，显示/不显示',
  `COUNT` int(11) NOT NULL DEFAULT '0' COMMENT '浏览次数',
  `SUPPORT` int(11) DEFAULT '0' COMMENT '点赞数',
  `DISLIKE` int(11) DEFAULT '0' COMMENT '踩数',
  PRIMARY KEY (`APP_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `appitem_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='APP  信息表';

-- ----------------------------
-- Records of appitem
-- ----------------------------

-- ----------------------------
-- Table structure for `apptype`
-- ----------------------------
DROP TABLE IF EXISTS `apptype`;
CREATE TABLE `apptype` (
  `TYPE_ID` int(11) NOT NULL COMMENT 'APP类型ID\r\n',
  `NAME` varchar(50) NOT NULL COMMENT '类型名\r\n',
  `PARENT_ID` int(11) NOT NULL DEFAULT '0' COMMENT '类型的父ID',
  PRIMARY KEY (`TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='APP分类表';

-- ----------------------------
-- Records of apptype
-- ----------------------------

-- ----------------------------
-- Table structure for `apptypelist`
-- ----------------------------
DROP TABLE IF EXISTS `apptypelist`;
CREATE TABLE `apptypelist` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `APP_ID` int(11) NOT NULL COMMENT 'app的ID\r\n',
  `TYPE_ID` int(11) NOT NULL COMMENT 'APP类型ID\r\n',
  PRIMARY KEY (`ID`),
  KEY `APP_ID` (`APP_ID`),
  KEY `TYPE_ID` (`TYPE_ID`),
  CONSTRAINT `apptypelist_ibfk_1` FOREIGN KEY (`APP_ID`) REFERENCES `appitem` (`APP_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `apptypelist_ibfk_2` FOREIGN KEY (`TYPE_ID`) REFERENCES `apptype` (`TYPE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apptypelist
-- ----------------------------

-- ----------------------------
-- Table structure for `count`
-- ----------------------------
DROP TABLE IF EXISTS `count`;
CREATE TABLE `count` (
  `ID` int(11) NOT NULL COMMENT '访问记录id\r\n',
  `COUNT` int(11) NOT NULL DEFAULT '0' COMMENT '访问次数',
  `TIME` date DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站访问数据统计表';

-- ----------------------------
-- Records of count
-- ----------------------------

-- ----------------------------
-- Table structure for `keyword`
-- ----------------------------
DROP TABLE IF EXISTS `keyword`;
CREATE TABLE `keyword` (
  `KEY_ID` int(11) NOT NULL COMMENT '关键字记录ID',
  `NAME` varbinary(30) NOT NULL COMMENT '关键字名称',
  `DESCRIPTION` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`KEY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of keyword
-- ----------------------------

-- ----------------------------
-- Table structure for `keywordlist`
-- ----------------------------
DROP TABLE IF EXISTS `keywordlist`;
CREATE TABLE `keywordlist` (
  `KEYLIST_ID` int(11) NOT NULL COMMENT '记录ID',
  `KEY_ID` int(11) NOT NULL COMMENT '关键字记录ID',
  `APP_ID` int(11) NOT NULL COMMENT 'app的ID\r\n',
  PRIMARY KEY (`KEYLIST_ID`),
  KEY `APP_ID` (`APP_ID`),
  KEY `KEY_ID` (`KEY_ID`),
  CONSTRAINT `keywordlist_ibfk_1` FOREIGN KEY (`APP_ID`) REFERENCES `appitem` (`APP_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `keywordlist_ibfk_2` FOREIGN KEY (`KEY_ID`) REFERENCES `keyword` (`KEY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='按关键字的收集的APP集合';

-- ----------------------------
-- Records of keywordlist
-- ----------------------------

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `ID` int(11) NOT NULL COMMENT '留言记录ID\r\n',
  `USER_ID` int(11) DEFAULT NULL COMMENT '用户ID\r\n',
  `APP_ID` int(11) NOT NULL COMMENT 'app的ID\r\n',
  `CONTENT` text NOT NULL COMMENT '留言内容',
  `TIME` date DEFAULT NULL COMMENT '创建时间\r\n',
  PRIMARY KEY (`ID`),
  KEY `APP_ID` (`APP_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`APP_ID`) REFERENCES `appitem` (`APP_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户留言表';

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL COMMENT '用户ID\r\n',
  `USERNAME` varchar(30) NOT NULL COMMENT '用户名',
  `LOGO` varchar(0) DEFAULT NULL COMMENT '用户头像地址',
  `PASSWORD` varchar(40) NOT NULL,
  `LATE_TIME` date DEFAULT NULL COMMENT '用户最近登陆时间',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
