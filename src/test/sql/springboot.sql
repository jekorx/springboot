/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2017-12-20 08:43:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '24', 'a1', '男的');
INSERT INTO `person` VALUES ('4', '25', 'b1', '女');
INSERT INTO `person` VALUES ('19', '18', '张三2', '男');
INSERT INTO `person` VALUES ('20', '18', '张三3', '男');
INSERT INTO `person` VALUES ('21', '18', '张三4', '男');
INSERT INTO `person` VALUES ('22', '18', '张三5', '男');
INSERT INTO `person` VALUES ('23', '18', '张三6', '男');
INSERT INTO `person` VALUES ('24', '18', '张三7', '男');
INSERT INTO `person` VALUES ('25', '18', '张三8', '男');
INSERT INTO `person` VALUES ('27', '30', '张三aaa', '123');
INSERT INTO `person` VALUES ('28', '30', '张三aaa', '123');
INSERT INTO `person` VALUES ('29', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('30', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('31', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('32', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('33', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('34', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('35', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('36', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('37', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('38', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('39', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('40', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('41', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('42', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('43', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('44', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('45', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('46', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('47', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('48', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('49', '19', 'aa', '00aa');
INSERT INTO `person` VALUES ('50', '19', 'aa', '00aa');

-- ----------------------------
-- Table structure for `t_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `uid` int(255) NOT NULL,
  `ulogin` varchar(100) NOT NULL,
  `upwd` varchar(100) NOT NULL,
  `uname` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `u_login` varchar(255) DEFAULT NULL,
  `u_name` varchar(255) DEFAULT NULL,
  `u_pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('1', 'admin1', '21232F297A57A5A743894A0E4A801FC3', '1', '20', null, null, null);
INSERT INTO `t_users` VALUES ('2', 'admin2', '21232F297A57A5A743894A0E4A801FC3', '2', '21', null, null, null);
