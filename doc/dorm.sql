/*
Navicat MySQL Data Transfer

Source Server         : local_person
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2019-05-20 09:37:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `bed_num` varchar(10) DEFAULT NULL COMMENT '床位号',
  `empty` varchar(1) DEFAULT NULL COMMENT '是否有人',
  `bedroom_id` varchar(50) DEFAULT NULL COMMENT '所属寝室号',
  `bedroom_name` varchar(50) DEFAULT NULL COMMENT '寝室名',
  `department_id` varchar(50) DEFAULT NULL COMMENT '公寓id',
  `department_name` varchar(50) DEFAULT NULL COMMENT '公寓名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='床位';

-- ----------------------------
-- Records of bed
-- ----------------------------
INSERT INTO `bed` VALUES ('579723514819379200', '1', 'N', '579723514802601984', '665', '578925146895548416', '五公寓西');
INSERT INTO `bed` VALUES ('579723514844545024', '2', null, '579723514802601984', '665', '578925146895548416', '五公寓西');
INSERT INTO `bed` VALUES ('579723514861322240', '3', null, '579723514802601984', '665', '578925146895548416', '五公寓西');
INSERT INTO `bed` VALUES ('579723514878099456', '4', null, '579723514802601984', '665', '578925146895548416', '五公寓西');
INSERT INTO `bed` VALUES ('579723514890682368', '5', null, '579723514802601984', '665', '578925146895548416', '五公寓西');

-- ----------------------------
-- Table structure for bedroom
-- ----------------------------
DROP TABLE IF EXISTS `bedroom`;
CREATE TABLE `bedroom` (
  `id` varchar(20) NOT NULL COMMENT '寝室id',
  `bedroom_name` varchar(20) DEFAULT NULL COMMENT '寝室名称',
  `people_sum_num` varchar(10) DEFAULT '0' COMMENT '人数（几人寝）',
  `floor` varchar(10) DEFAULT '0' COMMENT '所在楼层',
  `people_cur_num` varchar(10) DEFAULT '0' COMMENT '当前所住人数',
  `empty` varchar(1) DEFAULT NULL COMMENT '是否为空',
  `department_id` varchar(50) DEFAULT NULL COMMENT '公寓id',
  `department_name` varchar(50) DEFAULT NULL COMMENT '公寓名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='寝室表';

-- ----------------------------
-- Records of bedroom
-- ----------------------------
INSERT INTO `bedroom` VALUES ('579723324372811776', '665', '6', '6', '0', null, '578925146895548416', '五公寓西');
INSERT INTO `bedroom` VALUES ('579723514802601984', '665', '6', '6', '0', null, '578925146895548416', '五公寓西');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` varchar(50) NOT NULL COMMENT '公寓id',
  `department_name` varchar(50) DEFAULT NULL COMMENT '公寓名',
  `department_num` int(10) DEFAULT NULL COMMENT '公寓序号',
  `floor_num` int(10) DEFAULT NULL COMMENT '楼层',
  `department_type` varchar(10) DEFAULT NULL COMMENT '公寓类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公寓表';

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('578925146895548416', '五公寓西', '5', '7', '男');
INSERT INTO `department` VALUES ('578927476936278016', '五公寓东', '5', '7', '男');

-- ----------------------------
-- Table structure for habit
-- ----------------------------
DROP TABLE IF EXISTS `habit`;
CREATE TABLE `habit` (
  `id` varchar(50) NOT NULL,
  `eating_habits` varchar(50) DEFAULT NULL COMMENT '饮食习惯（以喜好菜系区分）',
  `work_rest` varchar(50) DEFAULT NULL COMMENT '作息（夜猫子，早睡早起，两者兼顾默认）',
  `smoke` varchar(10) DEFAULT NULL COMMENT '是否吸烟',
  `sleep_quality` varchar(10) DEFAULT NULL COMMENT '睡眠质量（低，中，高）三个等级，越低表示越容易被吵醒',
  `student_id` varchar(50) DEFAULT NULL COMMENT '学生id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `habit_student_id` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个人习性';

-- ----------------------------
-- Records of habit
-- ----------------------------
INSERT INTO `habit` VALUES ('579411844985257984', '川菜', '夜猫子', '是', '中', '20151793');
INSERT INTO `habit` VALUES ('579420371111903232', '粤菜', '早睡早起', '是', '低', '20151794');
INSERT INTO `habit` VALUES ('579423824886366208', '川菜', '早睡早起', '否', '低', '20151795');
INSERT INTO `habit` VALUES ('579423824886366289', '湘菜', '夜猫子', '是', '低', '20151796');
INSERT INTO `habit` VALUES ('579439737459179520', '川菜', '夜猫子', '是', '高', '20151792');
INSERT INTO `habit` VALUES ('579650205708713984', '东北菜', '早睡早起', '否', '高', 'admin');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '学生名字',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `tel_no` varchar(50) DEFAULT NULL COMMENT '电话',
  `student_no` varchar(50) DEFAULT NULL COMMENT '学号',
  `college_id` varchar(50) DEFAULT NULL COMMENT '学院id',
  `college_name` varchar(50) DEFAULT NULL COMMENT '所属学院名',
  `classes_id` varchar(50) DEFAULT NULL COMMENT '班级id',
  `classes_name` varchar(50) DEFAULT NULL COMMENT '所在班级名称',
  `bed_id` varchar(50) DEFAULT NULL COMMENT '是否分配床位，为空表示未分配',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('579797522403295232', '陈年杰', '男', '15663456952', '20151792', '1000', '计算机科学与技术', '10000', '信管15-2', '579723514819379200');

-- ----------------------------
-- Table structure for t_sys_datas
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_datas`;
CREATE TABLE `t_sys_datas` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `file_path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文件表存储表';

-- ----------------------------
-- Records of t_sys_datas
-- ----------------------------
INSERT INTO `t_sys_datas` VALUES ('493164859534344192', 'D:/profile/57e6ed81bc836d122fcff4f86e0cebbc.jpg');
INSERT INTO `t_sys_datas` VALUES ('493191568597975040', 'D:/profile/499885e31867b77550deac0cb4596c22.jpg');
INSERT INTO `t_sys_datas` VALUES ('493194407776878592', 'D:/profile/304ed8bf6257c6b3a77e7f367e916b96.jpg');
INSERT INTO `t_sys_datas` VALUES ('493195419333951488', 'D:/profile/49c7c2126ea04b65c2164f0aff6c3279.jpg');
INSERT INTO `t_sys_datas` VALUES ('493195646874943488', 'D:/profile/b336f90e57ea73cc286e266103033c74.jpg');

-- ----------------------------
-- Table structure for t_sys_file
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_file`;
CREATE TABLE `t_sys_file` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '主键',
  `file_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片名字',
  `create_user_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人id',
  `create_user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人名字',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人',
  `update_user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人名字',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文件信息表';

-- ----------------------------
-- Records of t_sys_file
-- ----------------------------
INSERT INTO `t_sys_file` VALUES ('493105775934177280', '水电费2', '1', 'admin', '2018-09-22 17:03:25', '1', 'admin', '2018-09-22 21:01:09');
INSERT INTO `t_sys_file` VALUES ('493191574256091136', '阿达达', '1', 'admin', '2018-09-22 22:47:14', null, null, null);

-- ----------------------------
-- Table structure for t_sys_file_data
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_file_data`;
CREATE TABLE `t_sys_file_data` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `data_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `file_id` varchar(255) COLLATE utf8_bin DEFAULT '文件id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文件数据外键绑定表';

-- ----------------------------
-- Records of t_sys_file_data
-- ----------------------------
INSERT INTO `t_sys_file_data` VALUES ('493105048578949120', '493105005788659712', '493105048578949120');
INSERT INTO `t_sys_file_data` VALUES ('493164878349991936', '493164859534344192', '493105775934177280');
INSERT INTO `t_sys_file_data` VALUES ('493191574256091136', '493191568597975040', '493191574256091136');
INSERT INTO `t_sys_file_data` VALUES ('493191574256091137', '493164859534344192', '493191574256091136');
INSERT INTO `t_sys_file_data` VALUES ('493195660292521984', '493195646874943488', '493195660292521984');

-- ----------------------------
-- Table structure for t_sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_oper_log`;
CREATE TABLE `t_sys_oper_log` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `method` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '方法',
  `oper_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人',
  `oper_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'url',
  `oper_param` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '参数',
  `error_msg` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `oper_time` date DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='日志记录表';

-- ----------------------------
-- Records of t_sys_oper_log
-- ----------------------------
INSERT INTO `t_sys_oper_log` VALUES ('495981627277574144', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2018-09-30');
INSERT INTO `t_sys_oper_log` VALUES ('496130829131448320', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2018-10-01');
INSERT INTO `t_sys_oper_log` VALUES ('496130881971290112', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2018-10-01');
INSERT INTO `t_sys_oper_log` VALUES ('496131511678926848', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2018-10-01');
INSERT INTO `t_sys_oper_log` VALUES ('496133762661220352', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2018-10-01');
INSERT INTO `t_sys_oper_log` VALUES ('496801222838190080', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2018-10-02');
INSERT INTO `t_sys_oper_log` VALUES ('496801238482944000', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2018-10-02');
INSERT INTO `t_sys_oper_log` VALUES ('496802305908146176', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2018-10-02');
INSERT INTO `t_sys_oper_log` VALUES ('496804902987628544', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2018-10-02');
INSERT INTO `t_sys_oper_log` VALUES ('496805167543353344', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2018-10-02');
INSERT INTO `t_sys_oper_log` VALUES ('496806436433559552', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2018-10-02');
INSERT INTO `t_sys_oper_log` VALUES ('548521545325084672', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-02-22');
INSERT INTO `t_sys_oper_log` VALUES ('548522078878302208', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-02-22');
INSERT INTO `t_sys_oper_log` VALUES ('548522095005401088', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-02-22');
INSERT INTO `t_sys_oper_log` VALUES ('548522402275917824', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-02-22');
INSERT INTO `t_sys_oper_log` VALUES ('548522413080444928', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-02-22');
INSERT INTO `t_sys_oper_log` VALUES ('548522419581616128', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-02-22');
INSERT INTO `t_sys_oper_log` VALUES ('548522847354486784', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-02-22');
INSERT INTO `t_sys_oper_log` VALUES ('548527944973156352', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-02-22');
INSERT INTO `t_sys_oper_log` VALUES ('548527983720136704', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-02-22');
INSERT INTO `t_sys_oper_log` VALUES ('550320803963469824', '用户集合查询', 'cn.com.jetshine.datav.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-02-27');
INSERT INTO `t_sys_oper_log` VALUES ('554024819377569792', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-03-09');
INSERT INTO `t_sys_oper_log` VALUES ('572829171173031936', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-04-30');
INSERT INTO `t_sys_oper_log` VALUES ('572829178798276608', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-04-30');
INSERT INTO `t_sys_oper_log` VALUES ('572829190399721472', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-04-30');
INSERT INTO `t_sys_oper_log` VALUES ('572946409100148736', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572946451189989376', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572946453597519872', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572949769186443264', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572949826359001088', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572949834143629312', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572950139371520000', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572950429306978304', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572950438211485696', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572950443378868224', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572952192667877376', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572952194916024320', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572952199684947968', '用户集合查询', 'cn.com.jetshine.user.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572957590665822208', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572957612786581504', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572959611405991936', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572959625121366016', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572960399230500864', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572960403772932096', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572960405828141056', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572960407648468992', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572960408986451968', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572960409661734912', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572960410341212160', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572968038253461504', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572968047648702464', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572968061154361344', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572968071300382720', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572968085766537216', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572970121207742464', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572970169140248576', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572970186114596864', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '///UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572981002880679936', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572981031699742720', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572981121122304000', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572981123202678784', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572981127552172032', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572981129179561984', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572981136943218688', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572981830395887616', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572981835462606848', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572981892177985536', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572984108251086848', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572984472446697472', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572984639782649856', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572985386804969472', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/springboot/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572985407378030592', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/springboot/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572985417922510848', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/springboot/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572985907766886400', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572985925638815744', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572985934518157312', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572990439833993216', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/demo/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('572990457194217472', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/demo/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-01');
INSERT INTO `t_sys_oper_log` VALUES ('574746434637660160', '用户集合查询', 'cn.com.jetshine.ywzspt.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-05');
INSERT INTO `t_sys_oper_log` VALUES ('574746459027537920', '用户集合查询', 'cn.com.jetshine.ywzspt.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-05');
INSERT INTO `t_sys_oper_log` VALUES ('575103573847703552', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-06');
INSERT INTO `t_sys_oper_log` VALUES ('575103582882234368', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-06');
INSERT INTO `t_sys_oper_log` VALUES ('575103584832585728', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-06');
INSERT INTO `t_sys_oper_log` VALUES ('575103588733288448', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-06');
INSERT INTO `t_sys_oper_log` VALUES ('575106362099367936', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-06');
INSERT INTO `t_sys_oper_log` VALUES ('575106383096053760', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-06');
INSERT INTO `t_sys_oper_log` VALUES ('575106403916578816', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '//UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-06');
INSERT INTO `t_sys_oper_log` VALUES ('575114555802255360', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575114613012561920', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575114624546897920', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575114634210574336', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575114676153614336', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575114684047294464', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575114707627671552', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575125179835875328', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575125181685563392', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575125191626063872', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575125198718631936', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575125200337633280', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575125208873041920', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('575126190109491200', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-07');
INSERT INTO `t_sys_oper_log` VALUES ('576600087799529472', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-11');
INSERT INTO `t_sys_oper_log` VALUES ('578624041875668992', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-16');
INSERT INTO `t_sys_oper_log` VALUES ('578709837966213120', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-16');
INSERT INTO `t_sys_oper_log` VALUES ('578873498152206336', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-17');
INSERT INTO `t_sys_oper_log` VALUES ('578925879229415424', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-17');
INSERT INTO `t_sys_oper_log` VALUES ('579416222043471872', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-18');
INSERT INTO `t_sys_oper_log` VALUES ('579416298656628736', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-18');
INSERT INTO `t_sys_oper_log` VALUES ('579416370941263872', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-18');
INSERT INTO `t_sys_oper_log` VALUES ('579421015101145088', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-18');
INSERT INTO `t_sys_oper_log` VALUES ('579421183485673472', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-18');
INSERT INTO `t_sys_oper_log` VALUES ('579421261487144960', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-18');
INSERT INTO `t_sys_oper_log` VALUES ('579431207847067648', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-18');
INSERT INTO `t_sys_oper_log` VALUES ('579718699859050496', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-19');
INSERT INTO `t_sys_oper_log` VALUES ('579718703382265856', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', null, '2019-05-19');

-- ----------------------------
-- Table structure for t_sys_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permission_role`;
CREATE TABLE `t_sys_permission_role` (
  `id` varchar(255) NOT NULL,
  `role_id` varchar(255) DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(255) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限中间表';

-- ----------------------------
-- Records of t_sys_permission_role
-- ----------------------------
INSERT INTO `t_sys_permission_role` VALUES ('06428c1a-3f8b-439c-a588-9a2c3f82247d', '488243256161730560', '578710910017732608');
INSERT INTO `t_sys_permission_role` VALUES ('06b2fd63-07e4-40f9-bf29-b08f47d49158', '488243256161730560', '5797027832303452161');
INSERT INTO `t_sys_permission_role` VALUES ('0a2d0e1b-c3e8-4a3f-9b43-50f7525d7880', '488243256161730560', '5789260229933793281');
INSERT INTO `t_sys_permission_role` VALUES ('0d419824-3182-4455-a003-e31bb715a100', '488305788310257664', '14');
INSERT INTO `t_sys_permission_role` VALUES ('14c710cc-bbc4-440f-9bfb-dfaba965f727', '488305788310257664', '575853607149109248');
INSERT INTO `t_sys_permission_role` VALUES ('16ff5394-768c-4e75-af54-a4d36aa41e18', '488243256161730560', '5793873361276764162');
INSERT INTO `t_sys_permission_role` VALUES ('18d78238-7c4f-4b52-9f16-e76b2ea24aeb', '488289006124007424', '333');
INSERT INTO `t_sys_permission_role` VALUES ('1c849f6a-7f6f-405f-ae11-4c93a925e11d', '488243256161730560', '5');
INSERT INTO `t_sys_permission_role` VALUES ('1e4a34fa-183d-405b-b44c-56b479664192', '488305788310257664', '5766007011074375683');
INSERT INTO `t_sys_permission_role` VALUES ('1e9da378-1b26-45bc-88e5-5e1a2bc3e51f', '488305788310257664', '5766007011074375682');
INSERT INTO `t_sys_permission_role` VALUES ('204598c7-9708-4536-b28e-92a4e5da9b8d', '488305788310257664', '5766007011074375684');
INSERT INTO `t_sys_permission_role` VALUES ('20fb8ae7-b95a-4474-9e37-62192d9ae619', '488305788310257664', '9');
INSERT INTO `t_sys_permission_role` VALUES ('287460a3-f7dc-4f67-a370-54df839b46bb', '488289006124007424', '15');
INSERT INTO `t_sys_permission_role` VALUES ('28acf8b8-77be-4c6c-b30c-3116c44d06ba', '488243256161730560', '12');
INSERT INTO `t_sys_permission_role` VALUES ('2b0946a6-ffe7-492d-9b4f-4005d1dfb70d', '488289006124007424', '111');
INSERT INTO `t_sys_permission_role` VALUES ('2bd7ffcd-685a-4425-8d3b-3f288dce1fd5', '488243256161730560', '5797027832303452163');
INSERT INTO `t_sys_permission_role` VALUES ('2fedc1b5-7d80-482a-938b-34befbccdd7e', '488243256161730560', '5793873361276764163');
INSERT INTO `t_sys_permission_role` VALUES ('302ff50e-42fc-45ef-9a07-07333ec63c69', '488243256161730560', '496803374054768640');
INSERT INTO `t_sys_permission_role` VALUES ('30704f4e-b6cf-4010-86fc-0bf356c27fa8', '488289006124007424', '10');
INSERT INTO `t_sys_permission_role` VALUES ('30f58bad-3fd0-4798-9736-9adf3893e920', '488243256161730560', '5789260229933793283');
INSERT INTO `t_sys_permission_role` VALUES ('31633e59-cb83-436f-89ce-9626dd3531ac', '488305788310257664', '575852089792528384');
INSERT INTO `t_sys_permission_role` VALUES ('37093c9d-ca9e-4fa3-8479-cb1294c854fc', '488243256161730560', '575853607149109248');
INSERT INTO `t_sys_permission_role` VALUES ('373564cb-9b19-42d8-a89f-ea93193cadd9', '488243256161730560', '8');
INSERT INTO `t_sys_permission_role` VALUES ('378edca7-b8cd-4741-af44-55fe2b83dd17', '488289006124007424', '1');
INSERT INTO `t_sys_permission_role` VALUES ('41607b9e-3717-4ce5-bff3-aa5cdda91c62', '488243256161730560', '5794276725227520001');
INSERT INTO `t_sys_permission_role` VALUES ('4593aaae-42e7-4877-ac9a-939e80e37d05', '488289006124007424', '4');
INSERT INTO `t_sys_permission_role` VALUES ('4afa8efc-f4dd-45d8-a7e3-ca06fd18b829', '488305788310257664', '496805860547231744');
INSERT INTO `t_sys_permission_role` VALUES ('4c38dca4-880a-43b0-8042-d7bca3d7f120', '488243256161730560', '17');
INSERT INTO `t_sys_permission_role` VALUES ('4dc4c717-228b-45c9-b022-c9e4205f4708', '488305788310257664', '18');
INSERT INTO `t_sys_permission_role` VALUES ('50059c69-164d-45ec-b6e6-4a5401777421', '488305788310257664', '5766007011074375681');
INSERT INTO `t_sys_permission_role` VALUES ('523e6afb-f9b8-4825-98f5-c77933eb96bd', '579421160144371712', '579387336127676416');
INSERT INTO `t_sys_permission_role` VALUES ('536ff514-ac3c-48b2-a4d8-fb4bbce5e470', '488305788310257664', '5');
INSERT INTO `t_sys_permission_role` VALUES ('53ef1984-0340-4b82-9804-306014dd3763', '488243256161730560', '5796526202185318403');
INSERT INTO `t_sys_permission_role` VALUES ('58cc630b-6c9b-4652-98cb-7bfc8a8041f1', '488243256161730560', '4');
INSERT INTO `t_sys_permission_role` VALUES ('5c4749be-c607-4820-a090-de3251044b03', '488243256161730560', '578926022993379328');
INSERT INTO `t_sys_permission_role` VALUES ('615eb5fa-8b26-44e2-a8aa-baa7df4989b9', '488305788310257664', '12');
INSERT INTO `t_sys_permission_role` VALUES ('645a4a82-3b5d-4656-9598-38ac0d3c2ca8', '488243256161730560', '13');
INSERT INTO `t_sys_permission_role` VALUES ('686cffaa-692f-4d21-adfa-499b9e88d85e', '488243256161730560', '5794276725227520002');
INSERT INTO `t_sys_permission_role` VALUES ('6b5d8c6d-5104-474b-a3ad-b0b532e25cad', '488243256161730560', '5794276725227520003');
INSERT INTO `t_sys_permission_role` VALUES ('6f0d3ec4-776e-496d-9105-fda3d1567772', '488243256161730560', '5793873361276764164');
INSERT INTO `t_sys_permission_role` VALUES ('7091e5db-7659-44b7-9c85-5a68d0c81f6f', '488243256161730560', '14');
INSERT INTO `t_sys_permission_role` VALUES ('71dcae3a-f18e-4997-b966-518575497d4d', '488305788310257664', '10');
INSERT INTO `t_sys_permission_role` VALUES ('72278064-2a41-46cb-829a-1d18e6990998', '488305788310257664', '19');
INSERT INTO `t_sys_permission_role` VALUES ('770316d8-314f-49f7-8dce-d03b4d360c71', '488243256161730560', '7');
INSERT INTO `t_sys_permission_role` VALUES ('7bd91905-29e5-4193-b4aa-b7bcbde2d664', '488243256161730560', '20');
INSERT INTO `t_sys_permission_role` VALUES ('7d954ab2-4faa-4752-befe-b034affe9da0', '488243256161730560', '9');
INSERT INTO `t_sys_permission_role` VALUES ('80717c18-64e4-4c62-9950-73095d1bdb96', '488243256161730560', '15');
INSERT INTO `t_sys_permission_role` VALUES ('815c7b31-7d82-4d43-9683-8c4168237da3', '488305788310257664', '486690002869157888');
INSERT INTO `t_sys_permission_role` VALUES ('83a1171b-ba52-433e-82e6-07526658fe7e', '488305788310257664', '576600701107437568');
INSERT INTO `t_sys_permission_role` VALUES ('840933c6-b0ab-4629-845d-b19d73a0d75b', '488305788310257664', '21');
INSERT INTO `t_sys_permission_role` VALUES ('85845cb3-9a7a-41a2-986d-02ac10420492', '488305788310257664', '1');
INSERT INTO `t_sys_permission_role` VALUES ('8746b5f2-6858-48a8-bae4-568f0ded8fd5', '488305788310257664', '23');
INSERT INTO `t_sys_permission_role` VALUES ('883aaffd-a483-4983-8f85-ace031fc10ee', '488243256161730560', '5796526202185318404');
INSERT INTO `t_sys_permission_role` VALUES ('8967fff4-8019-4aba-98cc-50d374c4bfd6', '488305788310257664', '11');
INSERT INTO `t_sys_permission_role` VALUES ('8c9c2a91-26e3-4400-9d7f-4ed1e009a1f8', '488305788310257664', '7');
INSERT INTO `t_sys_permission_role` VALUES ('909f2781-63df-4cac-af89-398ee0b91ea2', '488243256161730560', '11');
INSERT INTO `t_sys_permission_role` VALUES ('9489a52a-69a4-48b6-aa3f-4cabd3e65a58', '488243256161730560', '5797027832303452164');
INSERT INTO `t_sys_permission_role` VALUES ('981b4104-4276-48ab-ad46-b772a6fb9daa', '488243256161730560', '21');
INSERT INTO `t_sys_permission_role` VALUES ('9c69a2f1-3978-4d52-84b2-36b13e461920', '488243256161730560', '5789260229933793284');
INSERT INTO `t_sys_permission_role` VALUES ('9d6876f7-68ba-4970-8c48-d8308af879fc', '488243256161730560', '579427672522752000');
INSERT INTO `t_sys_permission_role` VALUES ('a09aea29-69ea-4ec5-b7b5-d8e15faf56c6', '488243256161730560', '579702783230345216');
INSERT INTO `t_sys_permission_role` VALUES ('a44f43fb-6512-4c39-8667-c29aef5bfd26', '488243256161730560', '22');
INSERT INTO `t_sys_permission_role` VALUES ('a4622fec-dffc-4c96-8a56-3c8d27584d9a', '488305788310257664', '20');
INSERT INTO `t_sys_permission_role` VALUES ('a5b5670b-2db7-43d6-8c79-d934b60a33ee', '488243256161730560', '23');
INSERT INTO `t_sys_permission_role` VALUES ('a73b56bd-50c9-4a94-91a9-12d49d2e54d2', '488243256161730560', '5794276725227520004');
INSERT INTO `t_sys_permission_role` VALUES ('a89ccffd-1dec-4052-b49e-a07341e13b90', '488305788310257664', '496782496638173184');
INSERT INTO `t_sys_permission_role` VALUES ('a8a6b92f-f263-484f-8a3c-a3a801376a17', '488305788310257664', '6');
INSERT INTO `t_sys_permission_role` VALUES ('a931f970-2a69-42d9-a426-0a97c4977147', '488289006124007424', '9');
INSERT INTO `t_sys_permission_role` VALUES ('b141a6c5-1bc5-4e54-b80b-f56f47515400', '488305788310257664', '8');
INSERT INTO `t_sys_permission_role` VALUES ('b2053b16-a2d3-4407-956d-5695ce9dc2f4', '488243256161730560', '16');
INSERT INTO `t_sys_permission_role` VALUES ('b2d649ce-de23-46c9-8372-9e1471282aca', '488243256161730560', '579387336127676416');
INSERT INTO `t_sys_permission_role` VALUES ('b9a43043-3a69-480a-8778-bcff5d2089b4', '488243256161730560', '5789260229933793282');
INSERT INTO `t_sys_permission_role` VALUES ('c12cf6d6-a050-4c84-9309-720e62ec4e3c', '579421160144371712', '5793873361276764164');
INSERT INTO `t_sys_permission_role` VALUES ('c1c094e2-3ff4-4028-a834-1aa973fa1564', '488243256161730560', '1');
INSERT INTO `t_sys_permission_role` VALUES ('c5c998d0-aa42-4106-af58-2f50d0afe03c', '488289006124007424', '5');
INSERT INTO `t_sys_permission_role` VALUES ('ce6877e4-c467-4077-a8c9-7fccdd976122', '488305788310257664', '4');
INSERT INTO `t_sys_permission_role` VALUES ('d2f3dde3-2395-4589-b07e-f9f8e33d47c0', '488243256161730560', '5796526202185318402');
INSERT INTO `t_sys_permission_role` VALUES ('d4d174e2-5e83-49b0-b658-c56b76a3ab05', '488305788310257664', '22');
INSERT INTO `t_sys_permission_role` VALUES ('d8c9517d-aaaa-43c9-b108-b367c692c094', '488305788310257664', '496803374054768640');
INSERT INTO `t_sys_permission_role` VALUES ('da914664-61cd-4f48-8e1b-6d41f7dd8566', '488243256161730560', '6');
INSERT INTO `t_sys_permission_role` VALUES ('db8d6f6b-5034-4129-81f1-f568e7a56b3a', '488243256161730560', '19');
INSERT INTO `t_sys_permission_role` VALUES ('dc5db1ba-de7f-449a-89ae-ce07fd407c65', '488243256161730560', '575851658483859456');
INSERT INTO `t_sys_permission_role` VALUES ('ded3451c-9dce-4212-afed-d369380411e2', '488305788310257664', '17');
INSERT INTO `t_sys_permission_role` VALUES ('e3c2aa7f-adfb-49fc-a62a-f8217b888756', '488243256161730560', '575852089792528384');
INSERT INTO `t_sys_permission_role` VALUES ('e563ed91-e939-4631-abee-bf6d6e679a29', '488243256161730560', '5797027832303452162');
INSERT INTO `t_sys_permission_role` VALUES ('e6d33929-1c05-4c54-b594-2ba0ab7312fb', '488289006124007424', '14');
INSERT INTO `t_sys_permission_role` VALUES ('e6ffb8a4-a718-4ffa-829a-f3cb3396dac7', '488243256161730560', '496782496638173184');
INSERT INTO `t_sys_permission_role` VALUES ('ed8fcafc-0ac8-4040-83a9-d9506f5a9830', '488243256161730560', '5796526202185318401');
INSERT INTO `t_sys_permission_role` VALUES ('eea494e5-cb7e-47c5-adfa-b373ec0a3110', '488243256161730560', '18');
INSERT INTO `t_sys_permission_role` VALUES ('f31f64ad-0752-4bfd-8732-8c250722a44a', '488305788310257664', '13');
INSERT INTO `t_sys_permission_role` VALUES ('f42af1bf-a892-40f6-98cb-d21b746986bb', '488305788310257664', '15');
INSERT INTO `t_sys_permission_role` VALUES ('f4cca7b0-661e-4e51-9d82-eeb4e4994207', '579421160144371712', '5793873361276764162');
INSERT INTO `t_sys_permission_role` VALUES ('f93b486c-2e67-41b4-8741-bf69bcd21f7f', '488243256161730560', '496805860547231744');
INSERT INTO `t_sys_permission_role` VALUES ('f9eaa18f-7e35-40e0-84c7-235ce6873a14', '488305788310257664', '575851658483859456');
INSERT INTO `t_sys_permission_role` VALUES ('faa51c33-8560-4bdc-9c7a-0f0dce5a501d', '488243256161730560', '579652620218531840');
INSERT INTO `t_sys_permission_role` VALUES ('fe03a878-8400-4b5b-8829-a990b14cb3f2', '488289006124007424', '222');
INSERT INTO `t_sys_permission_role` VALUES ('fe3176c5-b8a9-4659-8790-ac3a033f7fb2', '488243256161730560', '486690002869157888');
INSERT INTO `t_sys_permission_role` VALUES ('fe8e0d53-db6d-4c9f-b297-6ffcba623d0a', '488243256161730560', '5793873361276764161');
INSERT INTO `t_sys_permission_role` VALUES ('fef15b59-56c2-4d00-9cbc-43d363278b72', '488243256161730560', '10');
INSERT INTO `t_sys_permission_role` VALUES ('ff422257-5bec-43f2-87f1-8a6294f9b3b1', '488305788310257664', '16');

-- ----------------------------
-- Table structure for t_sys_premission
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_premission`;
CREATE TABLE `t_sys_premission` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `descripion` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) DEFAULT NULL COMMENT '授权链接',
  `pid` varchar(255) DEFAULT NULL COMMENT '父节点id',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_sys_premission
-- ----------------------------
INSERT INTO `t_sys_premission` VALUES ('1', '首页', '首页', null, '0', null, '0', 'fa fa-home', '1');
INSERT INTO `t_sys_premission` VALUES ('10', '角色集合', '角色集合', '/RoleController/list', '9', 'system:role:list', '2', '', null);
INSERT INTO `t_sys_premission` VALUES ('11', '角色添加', '角色添加', '/RoleController/add', '9', 'system:role:add', '2', 'entypo-plus-squared', null);
INSERT INTO `t_sys_premission` VALUES ('12', '角色删除', '角色删除', '/RoleController/remove', '9', 'system:role:remove', '2', 'entypo-trash', null);
INSERT INTO `t_sys_premission` VALUES ('13', '角色修改', '角色修改', '/RoleController/edit', '9', 'system:role:edit', '2', 'fa fa-wrench', null);
INSERT INTO `t_sys_premission` VALUES ('14', '权限展示', '权限展示', '/PremissionController/view', '496782496638173184', 'system:premission:view', '1', 'fa fa-key', null);
INSERT INTO `t_sys_premission` VALUES ('15', '权限集合', '权限集合', '/PremissionController/list', '14', 'system:premission:list', '2', '', null);
INSERT INTO `t_sys_premission` VALUES ('16', '权限添加', '权限添加', '/PremissionController/add', '14', 'system:premission:add', '2', 'entypo-plus-squared', null);
INSERT INTO `t_sys_premission` VALUES ('17', '权限删除', '权限删除', '/PremissionController/remove', '14', 'system:premission:remove', '2', 'entypo-trash', null);
INSERT INTO `t_sys_premission` VALUES ('18', '权限修改', '权限修改', '/PremissionController/edit', '14', 'system:premission:edit', '2', 'fa fa-wrench', null);
INSERT INTO `t_sys_premission` VALUES ('19', '文件展示', '文件展示', '/FileController/view', '496782496638173184', 'system:file:view', '1', 'fa fa-file-image-o', null);
INSERT INTO `t_sys_premission` VALUES ('20', '文件添加', '文件添加', '/FileController/add', '19', 'system:file:add', '2', 'entypo-plus-squared', null);
INSERT INTO `t_sys_premission` VALUES ('21', '文件删除', '文件删除', '/FileController/remove', '19', 'system:file:remove', '2', 'entypo-trash', null);
INSERT INTO `t_sys_premission` VALUES ('22', '文件修改', '文件修改', '/FileController/edit', '19', 'system:file:edit', '2', 'fa fa-wrench', null);
INSERT INTO `t_sys_premission` VALUES ('23', '文件集合', '文件集合', '/FileController/list', '19', 'system:file:list', '2', '', null);
INSERT INTO `t_sys_premission` VALUES ('4', '用户管理', '用户展示', '/UserController/view', '496782496638173184', 'system:user:view', '1', 'icon icon-user', '1');
INSERT INTO `t_sys_premission` VALUES ('486690002869157888', '用户密码修改', '用户密码修改', '/UserController/editPwd', '4', 'system:user:editPwd', '2', 'entypo-tools', '3');
INSERT INTO `t_sys_premission` VALUES ('496126970468237312', '日志展示', '日志管理', '/LogController/view', '496124944220946432', 'system:log:view', '1', 'fa-bitbucket', null);
INSERT INTO `t_sys_premission` VALUES ('496127240363311104', '日志删除', '日志删除', '/LogController/remove', '496126970468237312', 'system:log:remove', '2', 'entypo-trash', null);
INSERT INTO `t_sys_premission` VALUES ('496127794879660032', '日志集合', '日志集合', '/LogController/list', '496126970468237312', 'system:log:list', '2', null, null);
INSERT INTO `t_sys_premission` VALUES ('496782496638173184', '系统设置', '系统设置', null, '1', null, '0', 'fa fa-gear', '3');
INSERT INTO `t_sys_premission` VALUES ('496803374054768640', '其他页面', '其他页面', null, '1', null, '0', 'fa fa-windows', '2');
INSERT INTO `t_sys_premission` VALUES ('496805860547231744', '图标页面', '图标页面', 'Icons/view', '496803374054768640', 'system:icons:view', '1', 'fa fa-magic', '2');
INSERT INTO `t_sys_premission` VALUES ('5', '用户集合', '用户集合', '/UserController/list', '4', 'system:user:list', '2', '', null);
INSERT INTO `t_sys_premission` VALUES ('575851658483859456', '代码生成', '代码生成', null, '1', null, '0', 'fa fa-ra', '3');
INSERT INTO `t_sys_premission` VALUES ('575852089792528384', '代码管理', '代码生成', '/generatorController/view', '575851658483859456', 'system:generator:view', '1', 'fa fa-bug', '1');
INSERT INTO `t_sys_premission` VALUES ('575853607149109248', '代码集合', '代码集合', '/generatorController/list', '575852089792528384', 'system:generator:list', '2', null, null);
INSERT INTO `t_sys_premission` VALUES ('578710910017732608', '宿舍管理', '学生宿舍管理', null, '1', null, '0', 'fa fa-address-book-o', '4');
INSERT INTO `t_sys_premission` VALUES ('578926022993379328', '公寓表管理', '公寓表展示', '/DepartmentController/view', '578710910017732608', 'gen:department:view', '1', 'fa fa-quora', null);
INSERT INTO `t_sys_premission` VALUES ('5789260229933793281', '公寓表集合', '公寓表集合', '/DepartmentController/list', '578926022993379328', 'gen:department:list', '2', '', null);
INSERT INTO `t_sys_premission` VALUES ('5789260229933793282', '公寓表添加', '公寓表添加', '/DepartmentController/add', '578926022993379328', 'gen:department:add', '2', 'entypo-plus-squared', null);
INSERT INTO `t_sys_premission` VALUES ('5789260229933793283', '公寓表删除', '公寓表删除', '/DepartmentController/remove', '578926022993379328', 'gen:department:remove', '2', 'entypo-trash', null);
INSERT INTO `t_sys_premission` VALUES ('5789260229933793284', '公寓表修改', '公寓表修改', '/DepartmentController/edit', '578926022993379328', 'gen:department:edit', '2', 'fa fa-wrench', null);
INSERT INTO `t_sys_premission` VALUES ('579387336127676416', '个人习性管理', '个人习性展示', '/HabitController/view', '578710910017732608', 'gen:habit:view', '1', 'fa fa-quora', null);
INSERT INTO `t_sys_premission` VALUES ('5793873361276764161', '个人习性集合', '个人习性集合', '/HabitController/list', '579387336127676416', 'gen:habit:list', '2', '', null);
INSERT INTO `t_sys_premission` VALUES ('5793873361276764162', '个人习性添加', '个人习性添加', '/HabitController/add', '579387336127676416', 'gen:habit:add', '2', 'entypo-plus-squared', null);
INSERT INTO `t_sys_premission` VALUES ('5793873361276764163', '个人习性删除', '个人习性删除', '/HabitController/remove', '579387336127676416', 'gen:habit:remove', '2', 'entypo-trash', null);
INSERT INTO `t_sys_premission` VALUES ('5793873361276764164', '个人习性修改', '个人习性修改', '/HabitController/edit', '579387336127676416', 'gen:habit:edit', '2', 'fa fa-wrench', null);
INSERT INTO `t_sys_premission` VALUES ('579427672522752000', '学生管理', '学生展示', '/StudentController/view', '578710910017732608', 'gen:student:view', '1', 'fa fa-quora', null);
INSERT INTO `t_sys_premission` VALUES ('5794276725227520001', '学生集合', '学生集合', '/StudentController/list', '579427672522752000', 'gen:student:list', '2', '', null);
INSERT INTO `t_sys_premission` VALUES ('5794276725227520002', '学生添加', '学生添加', '/StudentController/add', '579427672522752000', 'gen:student:add', '2', 'entypo-plus-squared', null);
INSERT INTO `t_sys_premission` VALUES ('5794276725227520003', '学生删除', '学生删除', '/StudentController/remove', '579427672522752000', 'gen:student:remove', '2', 'entypo-trash', null);
INSERT INTO `t_sys_premission` VALUES ('5794276725227520004', '学生修改', '学生修改', '/StudentController/edit', '579427672522752000', 'gen:student:edit', '2', 'fa fa-wrench', null);
INSERT INTO `t_sys_premission` VALUES ('579652620218531840', '寝室表管理', '寝室表展示', '/BedroomController/view', '578710910017732608', 'gen:bedroom:view', '1', 'fa fa-quora', null);
INSERT INTO `t_sys_premission` VALUES ('5796526202185318401', '寝室表集合', '寝室表集合', '/BedroomController/list', '579652620218531840', 'gen:bedroom:list', '2', '', null);
INSERT INTO `t_sys_premission` VALUES ('5796526202185318402', '寝室表添加', '寝室表添加', '/BedroomController/add', '579652620218531840', 'gen:bedroom:add', '2', 'entypo-plus-squared', null);
INSERT INTO `t_sys_premission` VALUES ('5796526202185318403', '寝室表删除', '寝室表删除', '/BedroomController/remove', '579652620218531840', 'gen:bedroom:remove', '2', 'entypo-trash', null);
INSERT INTO `t_sys_premission` VALUES ('5796526202185318404', '寝室表修改', '寝室表修改', '/BedroomController/edit', '579652620218531840', 'gen:bedroom:edit', '2', 'fa fa-wrench', null);
INSERT INTO `t_sys_premission` VALUES ('579702783230345216', '床位管理', '床位展示', '/BedController/view', '578710910017732608', 'gen:bed:view', '1', 'fa fa-quora', null);
INSERT INTO `t_sys_premission` VALUES ('5797027832303452161', '床位集合', '床位集合', '/BedController/list', '579702783230345216', 'gen:bed:list', '2', '', null);
INSERT INTO `t_sys_premission` VALUES ('5797027832303452162', '床位添加', '床位添加', '/BedController/add', '579702783230345216', 'gen:bed:add', '2', 'entypo-plus-squared', null);
INSERT INTO `t_sys_premission` VALUES ('5797027832303452163', '床位删除', '床位删除', '/BedController/remove', '579702783230345216', 'gen:bed:remove', '2', 'entypo-trash', null);
INSERT INTO `t_sys_premission` VALUES ('5797027832303452164', '床位修改', '床位修改', '/BedController/edit', '579702783230345216', 'gen:bed:edit', '2', 'fa fa-wrench', null);
INSERT INTO `t_sys_premission` VALUES ('6', '用户添加', '用户添加', '/UserController/add', '4', 'system:user:add', '2', 'entypo-plus-squared', null);
INSERT INTO `t_sys_premission` VALUES ('7', '用户删除', '用户删除', '/UserController/remove', '4', 'system:user:remove', '2', 'entypo-trash', null);
INSERT INTO `t_sys_premission` VALUES ('8', '用户修改', '用户修改', '/UserController/edit', '4', 'system:user:edit', '2', 'fa fa-wrench', null);
INSERT INTO `t_sys_premission` VALUES ('9', '角色管理', '角色展示', '/RoleController/view', '496782496638173184', 'system:role:view', '1', 'fa fa-group', null);

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('488243256161730560', '管理员');
INSERT INTO `t_sys_role` VALUES ('488289006124007424', '用户');
INSERT INTO `t_sys_role` VALUES ('488305788310257664', '能修改用户密码角色');
INSERT INTO `t_sys_role` VALUES ('579421160144371712', '学生');

-- ----------------------------
-- Table structure for t_sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_user`;
CREATE TABLE `t_sys_role_user` (
  `id` varchar(255) NOT NULL,
  `sys_user_id` varchar(255) DEFAULT NULL COMMENT 'ç”¨æˆ·id',
  `sys_role_id` varchar(255) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色中间表';

-- ----------------------------
-- Records of t_sys_role_user
-- ----------------------------
INSERT INTO `t_sys_role_user` VALUES ('2', '2', '2');
INSERT INTO `t_sys_role_user` VALUES ('488203259031322624', '487424004592762880', '488203230455529472');
INSERT INTO `t_sys_role_user` VALUES ('488243438727200768', '1', '488243256161730560');
INSERT INTO `t_sys_role_user` VALUES ('488857903675998208', '488857903675998208', '488289006124007424');
INSERT INTO `t_sys_role_user` VALUES ('575114609501929472', '575114609501929472', '488243256161730560');
INSERT INTO `t_sys_role_user` VALUES ('579416295108247552', '488294747442511872', '488289006124007424');
INSERT INTO `t_sys_role_user` VALUES ('579416295116636160', '488294747442511872', '488305788310257664');
INSERT INTO `t_sys_role_user` VALUES ('579421257850683392', '579421257850683392', '579421160144371712');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户账号',
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO `t_sys_user` VALUES ('488294747442511872', 'fuce', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `t_sys_user` VALUES ('579421257850683392', '20151792', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for t_tsts
-- ----------------------------
DROP TABLE IF EXISTS `t_tsts`;
CREATE TABLE `t_tsts` (
  `id` varchar(255) NOT NULL COMMENT '主键',
  `test1` varchar(255) DEFAULT NULL COMMENT '备注1',
  `test2` datetime DEFAULT NULL COMMENT '备注2',
  `test_hs` varchar(255) DEFAULT NULL COMMENT '备注3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自动生成测试';

-- ----------------------------
-- Records of t_tsts
-- ----------------------------
INSERT INTO `t_tsts` VALUES ('365', 'lacinia convallis bibendum ultricies fermentum sociis ut porta euismod sem', '2019-05-07 00:00:00', 'Etiam Pellentesque urna libero');
INSERT INTO `t_tsts` VALUES ('366', 'rutrum consectetuer nascetur litora magna aliquam vitae imperdiet vulputate parturient', '2019-05-09 00:00:00', 'sociosqu Ut justo ad vulputate feugiat pulvinar');
INSERT INTO `t_tsts` VALUES ('373', 'Cum sapien convallis euismod tristique penatibus Morbi Phasellus quis nec', '2019-05-04 00:00:00', 'est');
INSERT INTO `t_tsts` VALUES ('375', 'sociis vulputate Quisque netus Vestibulum congue rutrum ornare placerat Pellentesque', '2019-05-10 00:00:00', 'dolor congue accumsan');
INSERT INTO `t_tsts` VALUES ('453', 'eu sit Curae magna in justo Aliquam felis libero Curabitur', '2019-05-09 00:00:00', 'semper mauris');
INSERT INTO `t_tsts` VALUES ('472', 'hendrerit primis iaculis at aliquam condimentum Phasellus fames eleifend Cum', '2019-05-10 00:00:00', 'Donec ipsum magnis penatibus Donec id Vestibulum mi');
INSERT INTO `t_tsts` VALUES ('478', 'dapibus ad diam ad Lorem per Quisque venenatis urna feugiat', '2019-05-09 00:00:00', 'ultrices tempor netus Ut');
INSERT INTO `t_tsts` VALUES ('495', 'facilisis blandit aliquet est litora diam viverra erat Nullam imperdiet', '2019-05-09 00:00:00', 'hendrerit erat tristique ultricies viverra mollis pellentesque scelerisque elementum auctor');
INSERT INTO `t_tsts` VALUES ('5', '5', '2019-05-11 01:48:03', '5');
INSERT INTO `t_tsts` VALUES ('504', 'In Pellentesque Phasellus convallis facilisis placerat morbi dapibus pulvinar convallis', '2019-05-05 00:00:00', 'Vestibulum');
INSERT INTO `t_tsts` VALUES ('509', 'ante volutpat non dignissim mauris morbi eleifend sit iaculis Phasellus', '2019-05-07 00:00:00', 'dictum Proin');
INSERT INTO `t_tsts` VALUES ('521', 'penatibus turpis nostra nec quis cubilia Proin velit a mauris', '2019-05-10 00:00:00', 'sagittis gravida eros semper');
INSERT INTO `t_tsts` VALUES ('522', 'ad blandit tristique eros magna euismod porta arcu libero Nunc', '2019-05-06 00:00:00', 'Mauris pulvinar commodo est Duis convallis Praesent');
INSERT INTO `t_tsts` VALUES ('523', 'velit ultricies orci nisi cubilia sem Nam Integer parturient conubia', '2019-05-07 00:00:00', 'pede metus aliquet a augue eu hymenaeos viverra turpis');
INSERT INTO `t_tsts` VALUES ('527', 'bibendum hendrerit consequat Cras euismod lacinia tempus Nunc aliquet sapien', '2019-05-05 00:00:00', 'pellentesque varius Vestibulum Maecenas porta');
INSERT INTO `t_tsts` VALUES ('529', 'conubia sociosqu purus mus Lorem faucibus sociosqu egestas Vivamus fermentum', '2019-05-06 00:00:00', 'tellus Phasellus volutpat scelerisque porttitor eget vel quis primis');
INSERT INTO `t_tsts` VALUES ('531', 'justo dapibus mollis Pellentesque Vestibulum tincidunt taciti Lorem nec Praesent', '2019-05-08 00:00:00', 'suscipit velit felis nonummy rutrum dolor ridiculus magnis nascetur');
INSERT INTO `t_tsts` VALUES ('547', 'cursus ut netus Donec dapibus dignissim rhoncus ultricies at dignissim', '2019-05-07 00:00:00', 'feugiat elit urna Morbi litora faucibus convallis mauris');
INSERT INTO `t_tsts` VALUES ('554', 'arcu parturient vel eu sollicitudin tellus Fusce torquent torquent mattis', '2019-05-08 00:00:00', 'dolor vestibulum sit ridiculus hendrerit Aliquam Fusce cubilia viverra in');
INSERT INTO `t_tsts` VALUES ('557', 'torquent sem scelerisque dui Morbi at convallis eu congue mollis', '2019-05-08 00:00:00', 'Nam fermentum mus nisi eu rhoncus accumsan in nostra');
INSERT INTO `t_tsts` VALUES ('564', 'volutpat Suspendisse Fusce vestibulum facilisi lobortis Aliquam Maecenas feugiat Proin', '2019-05-08 00:00:00', 'tellus conubia conubia convallis hendrerit Aenean est non');
INSERT INTO `t_tsts` VALUES ('57', 'vitae lobortis pharetra eu Ut primis est vehicula rutrum convallis', '2019-05-04 00:00:00', 'mauris est mattis');
INSERT INTO `t_tsts` VALUES ('570', 'leo libero consequat lacus ad rhoncus iaculis vel fermentum libero', '2019-05-05 00:00:00', 'urna commodo rutrum ligula magnis');
INSERT INTO `t_tsts` VALUES ('579', 'laoreet accumsan tincidunt sapien id nonummy eget eu diam viverra', '2019-05-07 00:00:00', 'conubia Nulla');
INSERT INTO `t_tsts` VALUES ('580', 'Cras Integer volutpat luctus luctus Curabitur ut vel Curabitur volutpat', '2019-05-05 00:00:00', 'Integer nisl');
INSERT INTO `t_tsts` VALUES ('584', 'nibh vel netus non Nunc montes nulla nec hymenaeos Ut', '2019-05-05 00:00:00', 'ultrices In nisl ultrices');
INSERT INTO `t_tsts` VALUES ('605', 'Fusce at tincidunt lacinia egestas sociis est quam ridiculus parturient', '2019-05-09 00:00:00', 'eget nulla torquent mus luctus habitant risus lobortis pretium convallis');
INSERT INTO `t_tsts` VALUES ('61', 'feugiat metus quis eros Praesent Cum eu Morbi conubia laoreet', '2019-05-07 00:00:00', 'congue sit dis mattis penatibus consectetuer montes');
INSERT INTO `t_tsts` VALUES ('617', 'tempus iaculis Mauris justo rutrum ultricies Duis id est eleifend', '2019-05-06 00:00:00', 'ad convallis conubia cubilia');
INSERT INTO `t_tsts` VALUES ('624', 'litora ultricies metus nostra commodo Integer augue ut interdum faucibus', '2019-05-07 00:00:00', 'consectetuer Etiam sollicitudin euismod lorem');
INSERT INTO `t_tsts` VALUES ('637', 'porta vestibulum euismod posuere porta convallis ultricies nulla elit at', '2019-05-04 00:00:00', 'dapibus');
INSERT INTO `t_tsts` VALUES ('648', 'mauris consectetuer Phasellus ipsum turpis per eros erat enim habitant', '2019-05-09 00:00:00', 'nostra');
INSERT INTO `t_tsts` VALUES ('652', 'congue hymenaeos blandit pulvinar torquent Vestibulum ridiculus nulla Fusce volutpat', '2019-05-07 00:00:00', 'metus nostra enim hymenaeos');
INSERT INTO `t_tsts` VALUES ('653', 'erat Mauris natoque consequat magnis suscipit sagittis Mauris eleifend ornare', '2019-05-09 00:00:00', 'conubia');
INSERT INTO `t_tsts` VALUES ('657', 'nec augue malesuada natoque eros vitae eget porttitor urna eget', '2019-05-07 00:00:00', 'condimentum ornare tortor lobortis');
INSERT INTO `t_tsts` VALUES ('660', 'ac risus risus blandit Suspendisse non Vestibulum Cum volutpat lacus', '2019-05-08 00:00:00', 'vel nisl dapibus sed amet ac lacinia semper imperdiet');
INSERT INTO `t_tsts` VALUES ('661', 'ipsum nisl Maecenas congue morbi Nunc Praesent venenatis semper facilisis', '2019-05-04 00:00:00', 'Suspendisse');
INSERT INTO `t_tsts` VALUES ('662', 'eros in et velit lectus sociis urna cursus nisl lorem', '2019-05-06 00:00:00', 'nec Phasellus aliquam sagittis fringilla faucibus semper et elit tellus');
INSERT INTO `t_tsts` VALUES ('671', 'ridiculus tincidunt fringilla Cum Aliquam amet Sed Quisque semper quam', '2019-05-04 00:00:00', 'purus ridiculus ut malesuada in');
INSERT INTO `t_tsts` VALUES ('674', 'arcu Curae odio taciti convallis tempor mus mollis dapibus Aliquam', '2019-05-08 00:00:00', 'sociosqu per');
INSERT INTO `t_tsts` VALUES ('679', 'sagittis Aenean orci est dis nostra feugiat est dis dignissim', '2019-05-09 00:00:00', 'consectetuer scelerisque egestas at ac per Nam facilisi habitant suscipit');
INSERT INTO `t_tsts` VALUES ('680', 'pharetra dignissim risus iaculis Aenean nulla ridiculus parturient sociis tempus', '2019-05-07 00:00:00', 'dapibus Aenean');
INSERT INTO `t_tsts` VALUES ('69', 'eget dapibus Phasellus habitant volutpat Donec et elit Ut Fusce', '2019-05-06 00:00:00', 'ut');
INSERT INTO `t_tsts` VALUES ('698', 'purus metus libero pulvinar torquent risus per morbi porta tincidunt', '2019-05-07 00:00:00', 'est sem Maecenas tortor erat nunc nisi sociis');
INSERT INTO `t_tsts` VALUES ('705', 'molestie sagittis conubia mus Curae ac scelerisque per volutpat Mauris', '2019-05-08 00:00:00', 'ante turpis urna Duis Morbi');
INSERT INTO `t_tsts` VALUES ('707', 'ornare quis Curae torquent conubia interdum Nullam Aliquam facilisi ornare', '2019-05-07 00:00:00', 'eu tempus faucibus pharetra taciti odio Nam luctus');
INSERT INTO `t_tsts` VALUES ('715', 'torquent laoreet tellus hymenaeos magnis Cras Etiam ante imperdiet Cras', '2019-05-10 00:00:00', 'ad natoque Proin in');
INSERT INTO `t_tsts` VALUES ('736', 'aliquet rutrum Pellentesque litora molestie sociis cubilia aliquam sociosqu Aenean', '2019-05-10 00:00:00', 'elit massa eu nostra Duis');
INSERT INTO `t_tsts` VALUES ('743', 'hendrerit fermentum aliquet pede quam sollicitudin pharetra tortor nunc elit', '2019-05-04 00:00:00', 'ut tortor laoreet magna et nostra ridiculus');
INSERT INTO `t_tsts` VALUES ('744', 'adipiscing molestie semper ut malesuada aliquam dapibus tristique Etiam placerat', '2019-05-06 00:00:00', 'Nam rutrum in');
INSERT INTO `t_tsts` VALUES ('745', 'facilisis lectus lectus scelerisque nostra mattis lacinia consequat habitant malesuada', '2019-05-05 00:00:00', 'pulvinar tincidunt');
INSERT INTO `t_tsts` VALUES ('747', 'rhoncus fringilla fermentum penatibus Duis natoque est dapibus fames purus', '2019-05-07 00:00:00', 'Donec neque conubia felis vitae ultrices');
INSERT INTO `t_tsts` VALUES ('753', 'rutrum Nulla pharetra cubilia Nunc id pellentesque sed penatibus montes', '2019-05-07 00:00:00', 'penatibus hymenaeos fermentum eget Proin');
INSERT INTO `t_tsts` VALUES ('76', 'cubilia at hymenaeos dui bibendum sed consectetuer hendrerit hymenaeos congue', '2019-05-10 00:00:00', 'a rutrum nisl mollis Fusce posuere fringilla');
INSERT INTO `t_tsts` VALUES ('768', 'dui euismod Curae ultrices sapien porttitor suscipit semper habitant volutpat', '2019-05-08 00:00:00', 'sed massa laoreet molestie Aenean purus fames Integer');
INSERT INTO `t_tsts` VALUES ('769', 'nulla condimentum Etiam risus ante dui congue feugiat vehicula elementum', '2019-05-06 00:00:00', 'eros a venenatis condimentum justo sit');
INSERT INTO `t_tsts` VALUES ('773', 'dis Class porttitor primis euismod euismod auctor massa Morbi litora', '2019-05-07 00:00:00', 'feugiat');
INSERT INTO `t_tsts` VALUES ('775', 'vestibulum Maecenas quis tempus rutrum per et odio sit tristique', '2019-05-04 00:00:00', 'eget quis rutrum Integer adipiscing euismod velit sollicitudin Vestibulum interdum');
INSERT INTO `t_tsts` VALUES ('785', 'morbi venenatis fames Maecenas Aliquam dignissim ornare libero mollis aptent', '2019-05-08 00:00:00', 'facilisis');
INSERT INTO `t_tsts` VALUES ('789', 'nostra tristique eros Mauris mi mollis iaculis Etiam aliquam sapien', '2019-05-10 00:00:00', 'mus Vivamus gravida elit Fusce');
INSERT INTO `t_tsts` VALUES ('791', 'aliquet iaculis Pellentesque sagittis viverra arcu blandit Nunc magna elementum', '2019-05-05 00:00:00', 'mus Aenean Aenean ut vulputate non');
INSERT INTO `t_tsts` VALUES ('801', 'quam ligula Sed gravida natoque fames dignissim ridiculus suscipit vel', '2019-05-07 00:00:00', 'rhoncus aptent commodo facilisi enim velit cubilia');
INSERT INTO `t_tsts` VALUES ('803', 'inceptos sapien diam varius sollicitudin malesuada tempor placerat Cum primis', '2019-05-07 00:00:00', 'nibh penatibus auctor auctor euismod Aliquam');
INSERT INTO `t_tsts` VALUES ('807', 'interdum lorem orci dolor Donec Integer adipiscing ullamcorper Phasellus Ut', '2019-05-04 00:00:00', 'eu nonummy Cum eget dolor lobortis senectus lorem per eget');
INSERT INTO `t_tsts` VALUES ('81', 'lacinia accumsan suscipit metus Praesent semper dapibus commodo dictum adipiscing', '2019-05-08 00:00:00', 'nisl commodo metus ridiculus penatibus commodo est suscipit dolor fermentum');
INSERT INTO `t_tsts` VALUES ('810', 'consequat Cum Nullam urna eget nonummy penatibus interdum non Duis', '2019-05-07 00:00:00', 'eros vel Cras lacinia tellus Sed');
INSERT INTO `t_tsts` VALUES ('821', 'posuere rutrum ipsum odio In sagittis luctus dapibus placerat orci', '2019-05-04 00:00:00', 'facilisis Vestibulum euismod Ut dictum');
INSERT INTO `t_tsts` VALUES ('827', 'Sed nunc hymenaeos Fusce Fusce Curae ad torquent enim nisl', '2019-05-04 00:00:00', 'tortor cursus Curae tempor In eros egestas');
INSERT INTO `t_tsts` VALUES ('840', 'conubia eros leo Integer consectetuer libero turpis rutrum fames Morbi', '2019-05-05 00:00:00', 'ante Fusce varius neque');
INSERT INTO `t_tsts` VALUES ('87', 'ac cubilia amet Aliquam sem nisi posuere rhoncus Mauris hendrerit', '2019-05-04 00:00:00', 'lobortis id Cras mi accumsan hymenaeos Nam adipiscing hendrerit feugiat');
INSERT INTO `t_tsts` VALUES ('874', 'vulputate malesuada natoque conubia dolor Cum interdum Duis nibh Maecenas', '2019-05-08 00:00:00', 'Lorem tempus senectus consectetuer Vestibulum non gravida diam morbi');
INSERT INTO `t_tsts` VALUES ('898', 'nonummy faucibus sapien Morbi Pellentesque Cum torquent sollicitudin ad vehicula', '2019-05-05 00:00:00', 'justo at pharetra taciti magnis nonummy Curabitur');
INSERT INTO `t_tsts` VALUES ('9', 'Praesent augue sodales diam pharetra gravida diam vehicula nascetur Praesent', '2019-05-04 00:00:00', 'mollis dui');
INSERT INTO `t_tsts` VALUES ('901', 'inceptos senectus ullamcorper laoreet Aenean elementum sagittis feugiat laoreet vel', '2019-05-07 00:00:00', 'est scelerisque In Vivamus lorem dignissim sagittis libero iaculis sem');
INSERT INTO `t_tsts` VALUES ('91', 'velit sociis ornare mus Curae porta Mauris laoreet lectus malesuada', '2019-05-04 00:00:00', 'elementum blandit cubilia Ut enim laoreet');
INSERT INTO `t_tsts` VALUES ('910', 'Morbi natoque posuere nibh nisi arcu tincidunt porttitor Morbi inceptos', '2019-05-07 00:00:00', 'purus');
INSERT INTO `t_tsts` VALUES ('92', 'dignissim diam Fusce convallis interdum torquent nec faucibus sociosqu aptent', '2019-05-07 00:00:00', 'eleifend arcu Integer sagittis Donec ac tellus bibendum');
