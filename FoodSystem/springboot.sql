/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2018-07-04 19:55:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `board`
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(255) DEFAULT NULL,
  `bsign` int(11) DEFAULT NULL,
  `btime` datetime DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES ('1', '一号桌', '1', '2018-01-11 17:27:56');
INSERT INTO `board` VALUES ('2', '二号桌', '0', '2018-07-04 19:49:26');
INSERT INTO `board` VALUES ('3', '三号桌', '0', '2017-11-14 19:27:11');
INSERT INTO `board` VALUES ('4', '四号桌', '0', '2017-11-21 19:27:38');
INSERT INTO `board` VALUES ('5', '五号桌', '0', '2017-11-06 20:36:28');
INSERT INTO `board` VALUES ('6', '六号桌', '0', '2017-11-08 15:13:51');
INSERT INTO `board` VALUES ('7', '七号桌', '0', '2017-11-08 15:20:32');
INSERT INTO `board` VALUES ('8', '新餐桌', '0', '2017-11-08 12:45:02');

-- ----------------------------
-- Table structure for `boardfood`
-- ----------------------------
DROP TABLE IF EXISTS `boardfood`;
CREATE TABLE `boardfood` (
  `bid` int(11) NOT NULL,
  `fid` int(11) NOT NULL,
  `number` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bid`,`fid`),
  KEY `fid` (`fid`),
  CONSTRAINT `boardfood_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `board` (`bid`),
  CONSTRAINT `boardfood_ibfk_2` FOREIGN KEY (`fid`) REFERENCES `food` (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boardfood
-- ----------------------------

-- ----------------------------
-- Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) NOT NULL,
  `ftype` int(11) NOT NULL,
  `price` double(11,2) NOT NULL,
  `mprice` double(11,2) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `clickNumber` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`fid`),
  KEY `food_foodType` (`ftype`),
  CONSTRAINT `food_foodType` FOREIGN KEY (`ftype`) REFERENCES `foodtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', '鸡爪有', '8', '23.00', '22.00', '好吃1231233', '110.png', '3');
INSERT INTO `food` VALUES ('2', '金针菇', '2', '22.00', '23.00', '不好吃', '1.jpg', '1');
INSERT INTO `food` VALUES ('3', '白菜1', '6', '10.00', '5.00', '很棒', '1.jpg', '100');
INSERT INTO `food` VALUES ('4', '猪肉11111111111111111111', '4', '30.00', '20.00', '123', '4.jpg', '3');
INSERT INTO `food` VALUES ('5', '鸡肉', '5', '25.00', '20.00', '555', '1.jpg', '7');
INSERT INTO `food` VALUES ('6', '香菜', '4', '11.00', '10.00', '号好好1231', '1.jpg', '3');
INSERT INTO `food` VALUES ('7', '辣椒1', '5', '6.00', '5.00', '很卡', '1.jpg', '4');
INSERT INTO `food` VALUES ('8', '豆腐', '7', '6.00', '5.00', '23132', '1.jpg', '7');
INSERT INTO `food` VALUES ('9', '菜花', '1', '4.00', '3.50', '很棒', '1.jpg', '5');
INSERT INTO `food` VALUES ('10', '豆腐皮1', '2', '7.00', '6.50', '很棒', '1.jpg', '7');
INSERT INTO `food` VALUES ('11', '黄瓜', '4', '2.00', '1.10', '很棒11', '1.jpg', '3');
INSERT INTO `food` VALUES ('12', '西红柿', '1', '2.00', '1.10', '很棒', '1101.png', '4');
INSERT INTO `food` VALUES ('20', '有图片', '3', '1.00', '1.00', '11113333', 'T1S48ZJGE4LS]Q`])6C6OEN.jpg', '5');
INSERT INTO `food` VALUES ('21', '没图片', '4', '1.00', '10.00', '111', null, '5');
INSERT INTO `food` VALUES ('22', '123', '1', '1.00', '1.00', '123321', '', '4');

-- ----------------------------
-- Table structure for `foodtype`
-- ----------------------------
DROP TABLE IF EXISTS `foodtype`;
CREATE TABLE `foodtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of foodtype
-- ----------------------------
INSERT INTO `foodtype` VALUES ('1', '食品');
INSERT INTO `foodtype` VALUES ('2', '电子1');
INSERT INTO `foodtype` VALUES ('3', '生活用品');
INSERT INTO `foodtype` VALUES ('4', '衣服');
INSERT INTO `foodtype` VALUES ('5', '水果');
INSERT INTO `foodtype` VALUES ('6', '蔬菜');
INSERT INTO `foodtype` VALUES ('7', '肉类');
INSERT INTO `foodtype` VALUES ('8', '饮料');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(255) NOT NULL,
  `message` varchar(255) NOT NULL,
  `money` double NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '一号桌', '白菜*2', '1', '2017-11-21 16:03:51');
INSERT INTO `message` VALUES ('2', '三号桌', '猪肉*2', '13.2', '2017-11-07 16:15:44');
INSERT INTO `message` VALUES ('3', '二号桌', '猪肉*2', '13.2', '2017-11-07 16:16:40');
INSERT INTO `message` VALUES ('4', '六号桌', '猪肉*2', '13.2', '2017-11-07 17:06:15');
INSERT INTO `message` VALUES ('5', '五号桌', '金针菇*2 , 白菜*3 , 4*2 ,', '51', '2017-11-07 17:52:28');
INSERT INTO `message` VALUES ('7', '三号桌', '鸡爪*2 , 金针菇*1 , 白菜*1 , 菜花*1 ,', '28', '2017-11-07 19:30:45');
INSERT INTO `message` VALUES ('9', '四号桌', '鸡爪*1 , 金针菇*1 , 白菜*1 ,', '25', '2017-11-07 19:36:04');
INSERT INTO `message` VALUES ('10', '二号桌', '鸡爪*2 , 猪肉*3 , 香菜*1 ,', '145', '2017-11-07 19:48:03');
INSERT INTO `message` VALUES ('11', '六号桌', '鸡爪*2 , 金针菇*1 ,', '66', '2017-11-08 12:40:42');
INSERT INTO `message` VALUES ('12', '新餐桌', '金针菇*1 , 白菜*1 ,', '32', '2017-11-08 12:42:03');
INSERT INTO `message` VALUES ('13', '新餐桌', '大鸡爪*2 , 金针菇*1 ,', '68', '2017-11-08 12:45:51');
INSERT INTO `message` VALUES ('14', '六号桌', '小鸡爪*3 , 金针菇*1 ,', '91', '2017-11-08 15:14:37');
INSERT INTO `message` VALUES ('16', '一号桌', '大鸡爪*1 , 金针菇*1 ,', '45', '2017-11-08 18:58:27');
INSERT INTO `message` VALUES ('17', '二号桌', '大鸡爪*1 , 金针菇*1 , 白菜*1 , 新菜*1 ,', '66', '2017-11-10 18:54:29');
INSERT INTO `message` VALUES ('18', '二号桌', '鸡爪有*2 , 金针菇*1 , 猪肉11111111111111111111*1 , 西红柿*1 , 有图片*3 , 123*1 ,', '104', '2018-07-04 19:49:30');

-- ----------------------------
-- Table structure for `springboot01`
-- ----------------------------
DROP TABLE IF EXISTS `springboot01`;
CREATE TABLE `springboot01` (
  `nid` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nid`,`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of springboot01
-- ----------------------------
INSERT INTO `springboot01` VALUES ('1', '0', '张三');
INSERT INTO `springboot01` VALUES ('1', '1', '11');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sign` int(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', 'admin', 'admin', '1');
INSERT INTO `user` VALUES ('2', '李四', '123', '456', '10');
