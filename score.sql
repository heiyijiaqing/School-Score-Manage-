/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : score

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2021-01-09 14:42:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for academy
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学院id',
  `name` varchar(255) DEFAULT NULL COMMENT '学院名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for check
-- ----------------------------
DROP TABLE IF EXISTS `check`;
CREATE TABLE `check` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '审核id',
  `classId` int(11) DEFAULT NULL,
  `state` tinyint(1) DEFAULT '0' COMMENT '审核状态：0-未审核，1-未通过，2-已通过',
  PRIMARY KEY (`id`),
  KEY `check_class_id` (`classId`),
  CONSTRAINT `check_class_id` FOREIGN KEY (`classId`) REFERENCES `class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `majorId` int(11) DEFAULT NULL COMMENT '专业id',
  `name` varchar(255) DEFAULT NULL COMMENT '班级名',
  PRIMARY KEY (`id`),
  KEY `class_major_id` (`majorId`),
  CONSTRAINT `class_major_id` FOREIGN KEY (`majorId`) REFERENCES `major` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `classId` int(11) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `year` varchar(10) DEFAULT NULL,
  `term` tinyint(1) DEFAULT NULL COMMENT '学期：1-上学期，2-下学期',
  `hour` smallint(3) DEFAULT NULL COMMENT '学时',
  `type` tinyint(1) DEFAULT NULL COMMENT '0-考试，1-考查',
  `credit` int(255) DEFAULT NULL COMMENT '学分',
  PRIMARY KEY (`id`),
  KEY `course_class_id` (`classId`),
  KEY `course_teacher_id` (`teacherId`),
  CONSTRAINT `course_class_id` FOREIGN KEY (`classId`) REFERENCES `class` (`id`),
  CONSTRAINT `course_teacher_id` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专业id',
  `academyId` int(11) DEFAULT NULL COMMENT '学院id',
  `name` varchar(255) DEFAULT NULL COMMENT '专业名',
  PRIMARY KEY (`id`),
  KEY `major_academy_id` (`academyId`),
  CONSTRAINT `major_academy_id` FOREIGN KEY (`academyId`) REFERENCES `academy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩id',
  `courseId` int(11) DEFAULT NULL,
  `studentId` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`id`),
  KEY `score_course_id` (`courseId`),
  KEY `score_student_id` (`studentId`),
  CONSTRAINT `score_course_id` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`),
  CONSTRAINT `score_student_id` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `classId` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(1) DEFAULT NULL COMMENT '0-女，1-男',
  `age` smallint(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_class_id` (`classId`),
  CONSTRAINT `student_class_id` FOREIGN KEY (`classId`) REFERENCES `class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `academyId` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL COMMENT '0-女，1-男',
  `age` smallint(3) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_academy_id` (`academyId`),
  CONSTRAINT `teacher_academy_id` FOREIGN KEY (`academyId`) REFERENCES `academy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
