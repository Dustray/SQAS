/*
Navicat MySQL Data Transfer

Source Server         : link
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : sqas_db

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-06-17 12:55:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appealinfo
-- ----------------------------
DROP TABLE IF EXISTS `appealinfo`;
CREATE TABLE `appealinfo` (
  `aplid` int(11) NOT NULL AUTO_INCREMENT,
  `aplname` varchar(255) DEFAULT NULL,
  `aplbrlid` int(11) DEFAULT NULL,
  `aplgradeclass` varchar(255) DEFAULT NULL,
  `apldepartment` varchar(255) DEFAULT NULL,
  `aplreason` varchar(255) DEFAULT NULL,
  `apldate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `aplresult` varchar(255) DEFAULT NULL,
  `apldisposdate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `apldisposename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aplid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for breakrulelistinfo
-- ----------------------------
DROP TABLE IF EXISTS `breakrulelistinfo`;
CREATE TABLE `breakrulelistinfo` (
  `brlid` int(11) NOT NULL AUTO_INCREMENT,
  `brltype` varchar(255) DEFAULT NULL,
  `brlstuname` varchar(255) DEFAULT NULL,
  `brlstugrade` int(255) DEFAULT NULL,
  `brlstuclass` varchar(255) DEFAULT NULL,
  `brldate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `brldetail` varchar(255) DEFAULT NULL,
  `brlpoints` double DEFAULT NULL,
  `brlpointsunit` varchar(10) DEFAULT NULL,
  `brldealadminid` int(11) DEFAULT NULL,
  `brldepartmentid` int(11) DEFAULT NULL,
  `brldealdate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`brlid`),
  KEY `dealadminidkey` (`brldealadminid`),
  KEY `departmentidkey` (`brldepartmentid`),
  CONSTRAINT `dealadminidkey` FOREIGN KEY (`brldealadminid`) REFERENCES `stuunimeminfo` (`sumid`),
  CONSTRAINT `departmentidkey` FOREIGN KEY (`brldepartmentid`) REFERENCES `stuunidepinfo` (`sudid`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for loginpersoninfo
-- ----------------------------
DROP TABLE IF EXISTS `loginpersoninfo`;
CREATE TABLE `loginpersoninfo` (
  `loginperid` int(11) NOT NULL AUTO_INCREMENT,
  `sumid` int(11) DEFAULT NULL,
  `sumpassword` varchar(255) DEFAULT NULL,
  `jurisdiction` int(11) DEFAULT NULL,
  PRIMARY KEY (`loginperid`),
  KEY `sumidkey` (`sumid`),
  CONSTRAINT `sumidkey` FOREIGN KEY (`sumid`) REFERENCES `stuunimeminfo` (`sumid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for stuunidepinfo
-- ----------------------------
DROP TABLE IF EXISTS `stuunidepinfo`;
CREATE TABLE `stuunidepinfo` (
  `sudid` int(11) NOT NULL,
  `sudname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sudid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for stuunimeminfo
-- ----------------------------
DROP TABLE IF EXISTS `stuunimeminfo`;
CREATE TABLE `stuunimeminfo` (
  `sumid` int(11) NOT NULL AUTO_INCREMENT,
  `sumsid` int(11) DEFAULT NULL,
  `sumname` varchar(255) DEFAULT NULL,
  `sumgrade` int(11) DEFAULT NULL,
  `sumdepartmentid` int(255) DEFAULT NULL,
  `sumposition` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sumid`),
  KEY `departmentkey` (`sumdepartmentid`),
  CONSTRAINT `departmentkey` FOREIGN KEY (`sumdepartmentid`) REFERENCES `stuunidepinfo` (`sudid`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=gbk;
