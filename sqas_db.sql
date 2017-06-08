/*
Navicat MySQL Data Transfer

Source Server         : link
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : sqas_db

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-06-17 12:55:42
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
-- Records of appealinfo
-- ----------------------------
INSERT INTO `appealinfo` VALUES ('1', '达芬奇', '74', '2014级软件一班', '1', '个人网', '2016-06-16 21:01:13', '处理中', null, null);
INSERT INTO `appealinfo` VALUES ('2', '332', '73', '2013级计算机本科一班', '1', '额哇', '2016-06-16 23:10:00', '处理中', null, null);

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
-- Records of breakrulelistinfo
-- ----------------------------
INSERT INTO `breakrulelistinfo` VALUES ('1', '迟到', '老王', '2013', '网络2班', '2016-05-22 13:30:31', '迟到了', '0.5', '学时', '1001', '1', null);
INSERT INTO `breakrulelistinfo` VALUES ('2', '旷课', '奥巴马', '2014', '计本1', '2016-05-22 13:36:10', '旷课', '2', '学时', '1001', '1', null);
INSERT INTO `breakrulelistinfo` VALUES ('3', '卫生不合格', '普京', '2013', '软件1', '2016-05-28 18:02:41', 'rr', '2', '分', '1002', '2', '2016-05-28 18:02:41');
INSERT INTO `breakrulelistinfo` VALUES ('4', 'ww', 'ww', '2013', null, '2014-05-21 12:12:12', 'ff', '122', 'rr', null, null, null);
INSERT INTO `breakrulelistinfo` VALUES ('5', 'fe', 'rrr', '2015', null, '2014-06-21 12:12:12', 'ff', '122', 'rr', null, null, null);
INSERT INTO `breakrulelistinfo` VALUES ('6', 'fe', 'rrr', '2015', null, '2012-06-21 12:12:12', 'ff', '122', 'rr', null, null, null);
INSERT INTO `breakrulelistinfo` VALUES ('7', 'fe', 'rrr', '2015', null, '2017-06-21 12:12:12', 'ff', '122', 'rr', null, null, null);
INSERT INTO `breakrulelistinfo` VALUES ('8', '非法登上巅峰', '倒萨', '431', null, '2014-04-04 21:21:21', 'gg', '3', 'gfd', null, null, null);
INSERT INTO `breakrulelistinfo` VALUES ('9', '反的', '范德萨', '1212', null, '1212-12-12 12:12:12', 'ss', '23', '11dd', '1001', '1', null);
INSERT INTO `breakrulelistinfo` VALUES ('10', '反的', '范德萨', '1212', null, '1212-12-12 12:12:12', 'ss', '23', '11dd', '1001', '1', null);
INSERT INTO `breakrulelistinfo` VALUES ('11', 'fds ', '分手', '1212', null, '1214-01-12 12:13:12', 'ss', '23', '11dd', '1002', '1', null);
INSERT INTO `breakrulelistinfo` VALUES ('12', 'fds ', '分手', '1212', null, '1214-01-12 12:13:12', 'ss', '23', '11dd', '1002', '1', null);
INSERT INTO `breakrulelistinfo` VALUES ('13', 'fds ', '分手', '1212', null, '1214-01-12 12:13:12', 'ss', '23', '11dd', '1002', '1', null);
INSERT INTO `breakrulelistinfo` VALUES ('14', 'fds ', '分手', '1212', null, '1214-01-12 12:13:12', 'ss', '23', '11dd', '1002', '1', null);
INSERT INTO `breakrulelistinfo` VALUES ('61', '2324', '', '2013', '计算机本科一班', '2019-08-14 17:24:17', 'ww', '33', '学时', '1001', '1', '2016-06-01 20:27:10');
INSERT INTO `breakrulelistinfo` VALUES ('62', '22', '娃娃', '2013', '计算机本科一班', '2023-04-10 09:55:15', '44', '32', '学时', '1001', '1', '2016-06-01 20:29:26');
INSERT INTO `breakrulelistinfo` VALUES ('63', '22', 'swkaof', '2013', '计算机本科一班', '2023-04-10 09:55:15', '44', '32', '学时', '1001', '1', '2016-06-01 20:29:26');
INSERT INTO `breakrulelistinfo` VALUES ('64', '22', '欧澳', '2013', '计算机本科一班', '2023-04-10 09:55:15', '44', '32', '学时', '1001', '1', '2016-06-01 20:29:26');
INSERT INTO `breakrulelistinfo` VALUES ('65', '22', 'fe', '2013', '计算机本科一班', '2023-04-10 09:55:15', '44', '32', '学时', '1001', '1', '2016-06-01 20:29:26');
INSERT INTO `breakrulelistinfo` VALUES ('66', '22', '是', '2013', '计算机本科一班', '2023-04-10 09:55:15', '44', '32', '学时', '1001', '1', '2016-06-01 20:29:26');
INSERT INTO `breakrulelistinfo` VALUES ('67', '物权法', '谔谔', '2013', '计算机本科一班', '2017-11-25 06:46:25', 'rr', '3', '学时', '1001', '1', '2016-06-01 22:22:11');
INSERT INTO `breakrulelistinfo` VALUES ('68', '物权法', '谔谔', '2013', '计算机本科一班', '2017-11-25 06:46:25', 'rr', '3', '学时', '1001', '1', '2016-06-01 22:23:51');
INSERT INTO `breakrulelistinfo` VALUES ('69', 'fer', 'gre', '2013', '计算机本科一班', '2020-06-23 21:18:06', '33', '33', '学时', '1001', '1', '2016-06-02 20:36:16');
INSERT INTO `breakrulelistinfo` VALUES ('70', 'fer', 'gre', '2013', '计算机本科一班', '2020-06-23 21:18:06', '33', '33', '学时', '1001', '1', '2016-06-02 20:37:29');
INSERT INTO `breakrulelistinfo` VALUES ('71', 'few', ' ff', '2013', '计算机本科一班', '2020-06-24 10:25:46', '44', '44', '学时', '1003', '1', '2016-06-02 20:38:09');
INSERT INTO `breakrulelistinfo` VALUES ('72', 'ee', 'gg', '2013', '计算机本科一班', '2020-06-23 00:27:26', '33', '33', '学时', '1003', '1', '2016-06-02 20:40:03');
INSERT INTO `breakrulelistinfo` VALUES ('73', 'fewa', '332', '2013', '计算机本科一班', '2020-07-25 22:05:04', 'rew', '4', '学时', '1003', '1', '2016-06-12 22:49:12');
INSERT INTO `breakrulelistinfo` VALUES ('74', 'fewa', '达芬奇', '2014', '软件一班', '2020-07-25 22:05:04', 'rew', '4', '学时', '1003', '1', '2016-06-12 22:49:36');
INSERT INTO `breakrulelistinfo` VALUES ('75', '外观', '额外', '2014', '通信二班', '2017-11-25 16:03:23', 't5', '34', '学时', '1001', '1', '2016-06-16 20:47:56');
INSERT INTO `breakrulelistinfo` VALUES ('76', '外观', '谔谔', '2014', '通信二班', '2017-11-25 16:03:23', 't5', '34', '学时', '1001', '1', '2016-06-16 20:47:56');
INSERT INTO `breakrulelistinfo` VALUES ('77', '外观', '广告', '2014', '通信二班', '2017-11-25 16:03:23', 't5', '34', '学时', '1001', '1', '2016-06-16 20:47:56');
INSERT INTO `breakrulelistinfo` VALUES ('78', '外观', '啊啊', '2014', '通信二班', '2017-11-25 16:03:23', 't5', '34', '学时', '1001', '1', '2016-06-16 20:47:56');

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
-- Records of loginpersoninfo
-- ----------------------------
INSERT INTO `loginpersoninfo` VALUES ('1', '1001', 'aaa111', '2');
INSERT INTO `loginpersoninfo` VALUES ('2', '1002', 'qqq222', '2');
INSERT INTO `loginpersoninfo` VALUES ('3', '1003', 'qqqqqq', '1');

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
-- Records of stuunidepinfo
-- ----------------------------
INSERT INTO `stuunidepinfo` VALUES ('1', '纪检部');
INSERT INTO `stuunidepinfo` VALUES ('2', '生卫部');
INSERT INTO `stuunidepinfo` VALUES ('3', '体育部');
INSERT INTO `stuunidepinfo` VALUES ('4', '学习部');

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

-- ----------------------------
-- Records of stuunimeminfo
-- ----------------------------
INSERT INTO `stuunimeminfo` VALUES ('1001', '111111', '张三', '2014', '1', '干事');
INSERT INTO `stuunimeminfo` VALUES ('1002', '1423110001', 'lisi', '2014', '1', '干事');
INSERT INTO `stuunimeminfo` VALUES ('1003', '222222', 'master', '2011', '1', '部长');
