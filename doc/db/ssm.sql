/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50546
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2016-11-15 10:40:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for event
-- ----------------------------
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_type` varchar(45) DEFAULT NULL,
  `event_man` int(11) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  UNIQUE KEY `event_id_UNIQUE` (`event_id`),
  KEY `ev_fi_idx` (`event_man`),
  CONSTRAINT `ev_fi` FOREIGN KEY (`event_man`) REFERENCES `fireman` (`fireman_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event
-- ----------------------------
INSERT INTO `event` VALUES ('1', 'put_out', '3');
INSERT INTO `event` VALUES ('2', 'put_out', '4');

-- ----------------------------
-- Table structure for event_detail
-- ----------------------------
DROP TABLE IF EXISTS `event_detail`;
CREATE TABLE `event_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) DEFAULT NULL,
  `left_air` varchar(255) DEFAULT NULL,
  `detail_time` datetime DEFAULT NULL,
  `fireman_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`detail_id`),
  UNIQUE KEY `event_detail_id_UNIQUE` (`detail_id`),
  KEY `cs_idx` (`event_id`),
  CONSTRAINT `ev_e` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=ucs2 COMMENT='事件详情';

-- ----------------------------
-- Records of event_detail
-- ----------------------------
INSERT INTO `event_detail` VALUES ('7', '1', '20', '2009-09-15 20:22:11', '3');
INSERT INTO `event_detail` VALUES ('8', '1', '40', '2009-09-26 21:22:11', '3');
INSERT INTO `event_detail` VALUES ('9', '2', '100', '2009-08-21 22:22:11', '4');

-- ----------------------------
-- Table structure for fireman
-- ----------------------------
DROP TABLE IF EXISTS `fireman`;
CREATE TABLE `fireman` (
  `fireman_id` int(11) NOT NULL AUTO_INCREMENT,
  `fireman_name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `fireman_mac` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`fireman_id`),
  UNIQUE KEY `fireman_id_UNIQUE` (`fireman_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fireman
-- ----------------------------
INSERT INTO `fireman` VALUES ('3', '老吴', '1.1.1.1');
INSERT INTO `fireman` VALUES ('4', '王总', '2.2.2.2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `sys_user_id` bigint(20) NOT NULL,
  `sys_user_login_name` varchar(50) NOT NULL,
  `sys_user_login_password` varchar(50) NOT NULL,
  `sys_user_status` varchar(1) NOT NULL,
  `sys_user_is_delete` varchar(1) NOT NULL,
  `sys_user_register_datetime` datetime NOT NULL,
  `sys_user_register_source` varchar(1) NOT NULL,
  `sys_user_type` varchar(1) NOT NULL,
  `sys_user_sex` varchar(1) NOT NULL,
  `sys_user_is_email_active` varchar(1) NOT NULL,
  `sys_user_is_mobile_active` varchar(1) NOT NULL,
  `sys_user_register_type` varchar(1) NOT NULL,
  `sys_user_pay_passwrod` varchar(50) DEFAULT NULL,
  `sys_user_icon` varchar(100) DEFAULT NULL,
  `sys_user_real_name` varchar(20) DEFAULT NULL,
  `sys_user_email` varchar(50) DEFAULT NULL,
  `sys_user_mobile` varchar(20) DEFAULT NULL,
  `sys_user_weibo_id` varchar(36) DEFAULT NULL,
  `sys_user_qq_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`sys_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'YouMeek1', 'e10adc3949ba59abbe56e057f20f883e', '0', 'N', '2016-02-24 00:12:23', '0', '0', '0', 'Y', 'Y', '0', 'e10adc3949ba59abbe56e057f20f883e', '', '张觉恩1', '363379441@qq.com', '13800000001', '', '');
INSERT INTO `sys_user` VALUES ('2', 'YouMeek2', 'e10adc3949ba59abbe56e057f20f883e', '0', 'N', '2016-02-24 00:12:23', '0', '0', '0', 'Y', 'Y', '0', 'e10adc3949ba59abbe56e057f20f883e', '', '张觉恩2', '363379442@qq.com', '13800000002', '', '');
INSERT INTO `sys_user` VALUES ('3', 'YouMeek3', 'e10adc3949ba59abbe56e057f20f883e', '0', 'N', '2016-02-24 00:12:23', '0', '0', '0', 'Y', 'Y', '0', 'e10adc3949ba59abbe56e057f20f883e', '', '张觉恩3', '363379443@qq.com', '13800000003', '', '');
INSERT INTO `sys_user` VALUES ('4', 'YouMeek4', 'e10adc3949ba59abbe56e057f20f883e', '0', 'N', '2016-02-24 00:12:23', '0', '0', '0', 'Y', 'Y', '0', 'e10adc3949ba59abbe56e057f20f883e', '', '张觉恩4', '363379444@qq.com', '13800000004', '', '');
INSERT INTO `sys_user` VALUES ('5', 'YouMeek5', 'e10adc3949ba59abbe56e057f20f883e', '0', 'N', '2016-02-24 00:12:23', '0', '0', '0', 'Y', 'Y', '0', 'e10adc3949ba59abbe56e057f20f883e', '', '张觉恩5', '363379445@qq.com', '13800000005', '', '');
