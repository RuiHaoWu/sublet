DROP DATABASE IF EXISTS `sublet`;

CREATE DATABASE  `sublet` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

USE `sublet`;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`  (
  `auth_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `auth_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单名称',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单图标',
  `menu_uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单路径/路由地址',
  `pid` int(0) NULL DEFAULT NULL COMMENT '父菜单id',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '前端对应的组件',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序值',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '类型',
  `del_flag` tinyint(0) NULL DEFAULT NULL COMMENT '删除标志',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `create_time` bigint(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新者',
  `update_time` bigint(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`auth_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES (2, '用户管理', 'user_page', 'contacts', '/users', 20, 'SysUserPage', 1, '0', 0, 'wuruihao', 1637067924757, 'admin', 1638881025149);
INSERT INTO `authority` VALUES (3, '新增用户', 'user_add', '', '', 2, '', 5, '1', 0, 'wuruihao', 1637068278149, 'admin', 1640067778810);
INSERT INTO `authority` VALUES (4, '编辑用户信息', 'user_edit', '', '', 2, '', 2, '1', 0, 'wuruihao', 1637119498812, 'wuruihao', 1637119498812);
INSERT INTO `authority` VALUES (5, '删除用户', 'user_del', '', '', 2, '', 3, '1', 0, 'wuruihao', 1637119703133, 'wuruihao', 1637119703133);
INSERT INTO `authority` VALUES (6, '系统管理', 'sys_manager_page', 'setting', '', -1, 'RouteView', 5, '0', 0, 'admin', 1638346721102, 'admin', 1638879644387);
INSERT INTO `authority` VALUES (7, '帖子管理', 'sublet_info_page', 'file-sync', '/sublet-info', 26, 'SubletInfoPage', 1, '0', 0, 'admin', 1638346721102, 'admin', 1639548902245);
INSERT INTO `authority` VALUES (8, '主页', 'home_page', 'home', '/main', -1, 'MainPage', 1, '0', 0, 'admin', 1638346721102, 'admin', 1638346721102);
INSERT INTO `authority` VALUES (9, '角色管理', 'role_page', 'user', '/roles', 20, 'RolePage', 2, '0', 0, 'admin', 1638346721102, 'admin', 1638881038484);
INSERT INTO `authority` VALUES (10, '权限管理', 'permission_page', 'apartment', '/permission', 20, 'PermissionPage', 3, '0', 0, 'admin', 1638346721102, 'admin', 1638881044092);
INSERT INTO `authority` VALUES (11, '添加角色', 'role_add', NULL, NULL, 9, NULL, 2, '1', 0, 'admin', 1638346721102, 'admin', 1640067853533);
INSERT INTO `authority` VALUES (12, '删除角色', 'role_del', NULL, NULL, 9, NULL, 4, '1', 0, 'admin', 1638346721102, 'admin', 1640067868010);
INSERT INTO `authority` VALUES (13, '编辑角色', 'role_edit', NULL, NULL, 9, NULL, 3, '1', 0, 'admin', 1638346721102, 'admin', 1640067860271);
INSERT INTO `authority` VALUES (14, '禁用用户', 'user_lock', NULL, NULL, 2, NULL, 4, '1', 0, 'admin', 1638346721102, NULL, NULL);
INSERT INTO `authority` VALUES (15, '新增权限', 'authority_add', NULL, NULL, 10, NULL, 3, '1', 0, 'admin', 1638346721102, 'admin', 1640067940583);
INSERT INTO `authority` VALUES (16, '编辑权限', 'authority_edit', NULL, NULL, 10, '', 2, '1', 0, 'admin', 1638346721102, NULL, NULL);
INSERT INTO `authority` VALUES (17, '删除权限', 'authority_del', NULL, NULL, 10, '', 4, '1', 0, 'admin', 1638346721102, 'admin', 1638879116292);
INSERT INTO `authority` VALUES (18, '分配角色权限', 'assign_role', NULL, NULL, 2, NULL, 6, '1', 0, 'admin', 1638346721102, 'admin', 1640067790111);
INSERT INTO `authority` VALUES (20, '用户角色管理', 'user_role_auth', 'team', NULL, 6, 'RouteView', 1, '0', 0, 'admin', 1638881014532, NULL, NULL);
INSERT INTO `authority` VALUES (21, '系统日志', 'sys_log_page', 'file-text', '/log', 6, 'SysLogPage', 2, '0', 0, 'admin', 1638881432086, NULL, NULL);
INSERT INTO `authority` VALUES (22, '删除日志', 'log_del', NULL, NULL, 21, NULL, 2, '1', 0, 'admin', 1638930618831, 'admin', 1638944047782);
INSERT INTO `authority` VALUES (23, '日志详情', 'log_detail', NULL, NULL, 21, NULL, 3, '1', 0, 'admin', 1638944037562, 'admin', 1640314779249);
INSERT INTO `authority` VALUES (24, '帖子禁用', 'sublet_info_lock', NULL, NULL, 7, NULL, 5, '1', 0, 'admin', 1639472025943, 'admin', 1640315456238);
INSERT INTO `authority` VALUES (25, '帖子详情', 'sublet_info_detail', NULL, NULL, 7, NULL, 2, '1', 0, 'admin', 1639472089615, NULL, NULL);
INSERT INTO `authority` VALUES (26, '转租信息管理', 'sublet_manager_page', 'container', NULL, -1, 'RouteView', 2, '0', 0, 'admin', 1639472089615, NULL, NULL);
INSERT INTO `authority` VALUES (28, '删除评论', 'comment_del', NULL, NULL, 7, NULL, 4, '1', 0, 'admin', 1639548963372, 'admin', 1640163659790);
INSERT INTO `authority` VALUES (29, '标签管理', 'label_page', 'paper-clip', '/label', 26, 'LabelPage', 3, '0', 0, 'admin', 1639549071036, 'admin', 1639549461628);
INSERT INTO `authority` VALUES (30, '删除标签', 'label_del', NULL, NULL, 29, NULL, 3, '1', 0, 'admin', 1639549140245, NULL, NULL);
INSERT INTO `authority` VALUES (31, '新增标签', 'label_add', NULL, NULL, 29, NULL, 4, '1', 0, 'admin', 1639549164576, 'admin', 1640068019018);
INSERT INTO `authority` VALUES (32, '编辑标签', 'label_edit', NULL, NULL, 29, NULL, 2, '1', 0, 'admin', 1639549188411, NULL, NULL);
INSERT INTO `authority` VALUES (33, '用户列表', 'user_list', NULL, NULL, 2, NULL, 1, '1', 0, 'admin', 1640067737641, NULL, NULL);
INSERT INTO `authority` VALUES (34, '角色列表', 'role_list', NULL, NULL, 9, NULL, 1, '1', 0, 'admin', 1640067836042, NULL, NULL);
INSERT INTO `authority` VALUES (35, '权限列表', 'authority_list', NULL, NULL, 10, NULL, 1, '1', 0, 'admin', 1640067918682, NULL, NULL);
INSERT INTO `authority` VALUES (36, '标签列表', 'label_list', NULL, NULL, 29, NULL, 1, '1', 0, 'admin', 1640067991235, NULL, NULL);
INSERT INTO `authority` VALUES (37, '评论列表', 'comment_list', NULL, NULL, 7, NULL, 3, '1', 0, 'admin', 1640154524790, 'admin', 1640163650307);
INSERT INTO `authority` VALUES (38, '转租信息列表', 'sublet_info_list', NULL, NULL, 7, NULL, 1, '1', 0, 'admin', 1640314639337, NULL, NULL);
INSERT INTO `authority` VALUES (39, '日志列表', 'log_list', NULL, NULL, 21, NULL, 1, '1', 0, 'admin', 1640314749082, 'admin', 1640314770759);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `sublet_info_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '转租信息id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '发布作者id',
  `reply_comment_id` int(0) NULL DEFAULT NULL COMMENT '回复评论id',
  `create_time` bigint(0) NULL DEFAULT NULL COMMENT '评论时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `pid` int(0) NULL DEFAULT NULL COMMENT '评论的评论id',
  `del_flag` tinyint(0) NULL DEFAULT NULL COMMENT '删除标志 0正常/1删除',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (2, '香江的房子确实不错', 'ebd983487f2234fc5d2a2db932612f4b', 'ac34389f9d1bc981d190318e4d4053a9', NULL, 1640144525029, 'admin', -1, 0);
INSERT INTO `comment` VALUES (3, '请问哪里不错，我觉得一般般', 'ebd983487f2234fc5d2a2db932612f4b', 'e813fa325c0f6a96ca5a5ed486a43bd7', NULL, 1640144652069, 'test', 2, 0);
INSERT INTO `comment` VALUES (4, '就是物业呀，环境都不错', 'ebd983487f2234fc5d2a2db932612f4b', 'ac34389f9d1bc981d190318e4d4053a9', 3, 1640144713658, 'admin', 2, 0);
INSERT INTO `comment` VALUES (5, '我也住香江，觉得物业费有点高', 'ebd983487f2234fc5d2a2db932612f4b', 'ac34389f9d1bc981d190318e4d4053a9', NULL, 1640144750074, 'admin', -1, 1);
INSERT INTO `comment` VALUES (6, '我也住香江，觉得物业费有点高', 'ebd983487f2234fc5d2a2db932612f4b', 'b41159765822c1ef0e196249e34c6534', NULL, 1640163420311, 'wrh', -1, 0);
INSERT INTO `comment` VALUES (7, '有意思的请联系我', 'ebd983487f2234fc5d2a2db932612f4b', 'ac34389f9d1bc981d190318e4d4053a9', NULL, 1640313266686, 'admin', -1, 1);
INSERT INTO `comment` VALUES (8, '快快快', 'ebd983487f2234fc5d2a2db932612f4b', 'ac34389f9d1bc981d190318e4d4053a9', NULL, 1640313379719, 'admin', -1, 1);
INSERT INTO `comment` VALUES (13, '什么时候可以开始租？', '9bb7cfedaf5f8b362853b1e0fa80dc2c', 'ebd983487f2234fc5d2a2db932612f4b', NULL, 1640850340201, 'wrh', -1, 0);
INSERT INTO `comment` VALUES (14, '多久起租，半年可以吗？', '424207c3093be9cc96d463207cb4d2bc', 'ebd983487f2234fc5d2a2db932612f4b', NULL, 1640850441239, 'wrh', -1, 0);
INSERT INTO `comment` VALUES (15, '可以', '424207c3093be9cc96d463207cb4d2bc', 'a9844c981ff23ab03bed6b076ee5b79a', NULL, 1640850827347, 'sublet', 14, 0);
INSERT INTO `comment` VALUES (16, '这个月底到期', '9bb7cfedaf5f8b362853b1e0fa80dc2c', 'a9844c981ff23ab03bed6b076ee5b79a', NULL, 1640851150125, 'sublet', 13, 0);

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`  (
  `label_id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `create_time` bigint(0) NULL DEFAULT NULL COMMENT '添加时间',
  `label_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标签名称',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '编辑者',
  `update_time` bigint(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`label_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES (1, 1635133176600, '一房一厅', 'admin', NULL, NULL);
INSERT INTO `label` VALUES (2, 1635133210997, '押二付一', 'admin', NULL, NULL);
INSERT INTO `label` VALUES (3, 1639575283806, '两房两卫', 'admin', 'admin', 1639575056594);
INSERT INTO `label` VALUES (4, 1639575283806, '拎包入住', 'admin', NULL, NULL);
INSERT INTO `label` VALUES (6, 1640690873557, '精装', 'admin', NULL, NULL);
INSERT INTO `label` VALUES (7, 1640690881008, '近地铁', 'admin', NULL, NULL);
INSERT INTO `label` VALUES (8, 1640691750364, '两室一厅', 'admin', NULL, NULL);

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `authorized_grant_types` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `access_token_validity` int(0) NULL DEFAULT NULL,
  `refresh_token_validity` int(0) NULL DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('gateway', 'sublet-auth', '$2a$10$dFTUukr9lQxWTbJNJXjShud5JMGihVNXelrjBnEBDXGoziAf7oOPq', 'all', 'password', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('sublet-chat', 'sublet-chat', '$2a$10$dFTUukr9lQxWTbJNJXjShud5JMGihVNXelrjBnEBDXGoziAf7oOPq', 'all', 'password', NULL, NULL, 3600, 3600, NULL, 'true');
INSERT INTO `oauth_client_details` VALUES ('sublet-frontend', 'sublet-frontend', '$2a$10$dFTUukr9lQxWTbJNJXjShud5JMGihVNXelrjBnEBDXGoziAf7oOPq', 'all', 'password,refresh_token', NULL, NULL, 3600, 3600, NULL, 'true');
INSERT INTO `oauth_client_details` VALUES ('sublet-middle', 'sublet-middle', '$2a$10$dFTUukr9lQxWTbJNJXjShud5JMGihVNXelrjBnEBDXGoziAf7oOPq', 'all', 'password,refresh_token', NULL, NULL, 600, 36000, NULL, 'true');
INSERT INTO `oauth_client_details` VALUES ('sublet-post', 'sublet-post', '$2a$10$dFTUukr9lQxWTbJNJXjShud5JMGihVNXelrjBnEBDXGoziAf7oOPq', 'all', 'password', NULL, NULL, 3600, 3600, NULL, 'true');
INSERT INTO `oauth_client_details` VALUES ('sublet-user', 'sublet-user', '$2a$10$dFTUukr9lQxWTbJNJXjShud5JMGihVNXelrjBnEBDXGoziAf7oOPq', 'all', 'password,refresh_token,authorization_code', 'http://baidu.com', NULL, 3600, 36000, NULL, 'true');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色名',
  `role_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色标识',
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色描述',
  `del_flag` tinyint(0) NULL DEFAULT NULL COMMENT '删除标识',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `create_time` bigint(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新者',
  `update_time` bigint(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '前台用户', 'ROLE_FRONT', '转租前台的用户', 0, NULL, NULL, NULL, NULL);
INSERT INTO `role` VALUES (9, '中台用户', 'ROLE_MIDDLE', '中台普通用户', 0, 'admin', 1637234581262, 'admin', 1640315503698);
INSERT INTO `role` VALUES (15, '管理员', 'ROLE_ADMIN', '中台管理员', 0, 'admin', 1637240453917, 'admin', 1640315075117);
INSERT INTO `role` VALUES (16, 'test', 'TEST', 'test', 1, 'admin', 1638870616507, NULL, NULL);
INSERT INTO `role` VALUES (17, '体验用户', 'ROLE_VISITOR', '体验用户', 0, 'admin', 1640678062729, NULL, NULL);

-- ----------------------------
-- Table structure for role_authority_rel
-- ----------------------------
DROP TABLE IF EXISTS `role_authority_rel`;
CREATE TABLE `role_authority_rel`  (
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `auth_id` int(0) NULL DEFAULT NULL COMMENT '权限id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_authority_rel
-- ----------------------------
INSERT INTO `role_authority_rel` VALUES (15, 3);
INSERT INTO `role_authority_rel` VALUES (15, 2);
INSERT INTO `role_authority_rel` VALUES (15, 20);
INSERT INTO `role_authority_rel` VALUES (15, 6);
INSERT INTO `role_authority_rel` VALUES (15, 33);
INSERT INTO `role_authority_rel` VALUES (15, 4);
INSERT INTO `role_authority_rel` VALUES (15, 5);
INSERT INTO `role_authority_rel` VALUES (15, 14);
INSERT INTO `role_authority_rel` VALUES (15, 18);
INSERT INTO `role_authority_rel` VALUES (15, 9);
INSERT INTO `role_authority_rel` VALUES (15, 11);
INSERT INTO `role_authority_rel` VALUES (15, 13);
INSERT INTO `role_authority_rel` VALUES (15, 12);
INSERT INTO `role_authority_rel` VALUES (15, 10);
INSERT INTO `role_authority_rel` VALUES (15, 16);
INSERT INTO `role_authority_rel` VALUES (15, 15);
INSERT INTO `role_authority_rel` VALUES (15, 17);
INSERT INTO `role_authority_rel` VALUES (15, 8);
INSERT INTO `role_authority_rel` VALUES (15, 22);
INSERT INTO `role_authority_rel` VALUES (15, 21);
INSERT INTO `role_authority_rel` VALUES (15, 23);
INSERT INTO `role_authority_rel` VALUES (15, 24);
INSERT INTO `role_authority_rel` VALUES (15, 7);
INSERT INTO `role_authority_rel` VALUES (15, 26);
INSERT INTO `role_authority_rel` VALUES (15, 25);
INSERT INTO `role_authority_rel` VALUES (15, 28);
INSERT INTO `role_authority_rel` VALUES (15, 30);
INSERT INTO `role_authority_rel` VALUES (15, 29);
INSERT INTO `role_authority_rel` VALUES (15, 36);
INSERT INTO `role_authority_rel` VALUES (15, 32);
INSERT INTO `role_authority_rel` VALUES (15, 31);
INSERT INTO `role_authority_rel` VALUES (15, 37);
INSERT INTO `role_authority_rel` VALUES (15, 38);
INSERT INTO `role_authority_rel` VALUES (15, 39);
INSERT INTO `role_authority_rel` VALUES (9, 8);
INSERT INTO `role_authority_rel` VALUES (9, 25);
INSERT INTO `role_authority_rel` VALUES (9, 7);
INSERT INTO `role_authority_rel` VALUES (9, 26);
INSERT INTO `role_authority_rel` VALUES (9, 33);
INSERT INTO `role_authority_rel` VALUES (9, 2);
INSERT INTO `role_authority_rel` VALUES (9, 20);
INSERT INTO `role_authority_rel` VALUES (9, 6);
INSERT INTO `role_authority_rel` VALUES (9, 34);
INSERT INTO `role_authority_rel` VALUES (9, 9);
INSERT INTO `role_authority_rel` VALUES (9, 35);
INSERT INTO `role_authority_rel` VALUES (9, 10);
INSERT INTO `role_authority_rel` VALUES (9, 36);
INSERT INTO `role_authority_rel` VALUES (9, 29);
INSERT INTO `role_authority_rel` VALUES (9, 37);
INSERT INTO `role_authority_rel` VALUES (9, 38);
INSERT INTO `role_authority_rel` VALUES (9, 39);
INSERT INTO `role_authority_rel` VALUES (9, 21);
INSERT INTO `role_authority_rel` VALUES (17, 8);
INSERT INTO `role_authority_rel` VALUES (17, 38);
INSERT INTO `role_authority_rel` VALUES (17, 7);
INSERT INTO `role_authority_rel` VALUES (17, 26);
INSERT INTO `role_authority_rel` VALUES (17, 25);
INSERT INTO `role_authority_rel` VALUES (17, 37);
INSERT INTO `role_authority_rel` VALUES (17, 24);
INSERT INTO `role_authority_rel` VALUES (17, 36);
INSERT INTO `role_authority_rel` VALUES (17, 29);
INSERT INTO `role_authority_rel` VALUES (17, 32);
INSERT INTO `role_authority_rel` VALUES (17, 31);
INSERT INTO `role_authority_rel` VALUES (17, 33);
INSERT INTO `role_authority_rel` VALUES (17, 2);
INSERT INTO `role_authority_rel` VALUES (17, 20);
INSERT INTO `role_authority_rel` VALUES (17, 6);
INSERT INTO `role_authority_rel` VALUES (17, 3);
INSERT INTO `role_authority_rel` VALUES (17, 34);
INSERT INTO `role_authority_rel` VALUES (17, 9);
INSERT INTO `role_authority_rel` VALUES (17, 11);
INSERT INTO `role_authority_rel` VALUES (17, 35);
INSERT INTO `role_authority_rel` VALUES (17, 10);
INSERT INTO `role_authority_rel` VALUES (17, 39);
INSERT INTO `role_authority_rel` VALUES (17, 21);
INSERT INTO `role_authority_rel` VALUES (17, 23);
INSERT INTO `role_authority_rel` VALUES (15, 34);
INSERT INTO `role_authority_rel` VALUES (15, 35);

-- ----------------------------
-- Table structure for sublet_info
-- ----------------------------
DROP TABLE IF EXISTS `sublet_info`;
CREATE TABLE `sublet_info`  (
  `sublet_info_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `description` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '描述信息',
  `monthly_rent` decimal(10, 0) NULL DEFAULT NULL COMMENT '每月租金 单位元',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '面积',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '详细地址',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所在省',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所在城市',
  `district` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所在区',
  `street` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所在街道',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `create_time` bigint(0) NOT NULL COMMENT '发布时间',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '转租信息状态 转租 0/转租 1',
  `lock_flag` tinyint(0) NULL DEFAULT NULL COMMENT '违规锁定标志 0正常 1违规',
  `update_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '发布人用户名',
  `images` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '图片集',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`sublet_info_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sublet_info
-- ----------------------------
INSERT INTO `sublet_info` VALUES ('424207c3093be9cc96d463207cb4d2bc', '南北通透，1月份可转', 1500, '76.0', '碧桂园海湾1号32层3201', '广东省', '广州市', '南沙区', '南沙街道', 'a9844c981ff23ab03bed6b076ee5b79a', 1640693047855, 0, 0, NULL, 'sublet', '{\"images\":[\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/e4a08b8234d34fdc87bbf2a9ca83cab3.JPG\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/610634b93df24cd58e583861f2507bf4.JPG\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/d3ad8dc87efe4fd9a25487bf663cf44e.JPG\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/54ba54265d5f450a8e548c73ff32f8fc.JPG\"]}', NULL);
INSERT INTO `sublet_info` VALUES ('9bb7cfedaf5f8b362853b1e0fa80dc2c', '采光很好，环境干净，没有噪音，住起来很舒服', 1600, '45.0', '真功夫总部大楼公寓403', '广东省', '广州市', '南沙区', '南沙街道', 'a9844c981ff23ab03bed6b076ee5b79a', 1640693459375, 0, 0, NULL, 'sublet', '{\"images\":[\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/0c0b94fbad76436db805df26d390a493.JPG\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/a1948c081e6241c8a579eae95ccf08a4.JPG\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/9b72756ba68b474ab0023e7809e979fb.JPG\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/da8d9098813d4396861a587556a6557f.JPG\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/3b21ffd2038d472e8a905569dc9a0925.JPG\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/5d9f655fe0714028a45b7a67874ebf6f.JPG\"]}', NULL);
INSERT INTO `sublet_info` VALUES ('9bc638b225068d8e5932c08e053d3cf2', '南北通透，1月份可转', 1600, '76.0', '碧桂园海湾1号32层3201', '广东省', '广州市', '南沙区', '南沙街道', 'ac34389f9d1bc981d190318e4d4053a9', 1640691947084, 1, 0, NULL, 'admin', '{\"images\":[]}', NULL);
INSERT INTO `sublet_info` VALUES ('ebd983487f2234fc5d2a2db932612f4b', '因工作原因转租，房东人非常好', 1600, '40.0', '香江国际科创中心4栋', '广东省', '广州市', '南沙区', '金隆路', 'b41159765822c1ef0e196249e34c6534', 1635144443095, 0, 1, NULL, 'wrh', '{\"images\": [\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-15/fd6d2c062625498bb25255cd8989e2b7.jpg\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-15/fd6d2c062625498bb25255cd8989e2b7.jpg\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-15/fd6d2c062625498bb25255cd8989e2b7.jpg\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-15/fd6d2c062625498bb25255cd8989e2b7.jpg\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-15/fd6d2c062625498bb25255cd8989e2b7.jpg\",\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-15/fd6d2c062625498bb25255cd8989e2b7.jpg\"]}', 'sublet');
INSERT INTO `sublet_info` VALUES ('f059ee140ebb199993ca788241b6a50d', '采光非常好', 1500, '50', '真功夫总部大楼', '广东省', '广州市', '南沙区', '南沙街道', 'ac34389f9d1bc981d190318e4d4053a9', 1640691523241, 1, 0, NULL, 'admin', '{\"images\":[]}', NULL);

-- ----------------------------
-- Table structure for sublet_info_label
-- ----------------------------
DROP TABLE IF EXISTS `sublet_info_label`;
CREATE TABLE `sublet_info_label`  (
  `sublet_info_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `label_id` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sublet_info_label
-- ----------------------------
INSERT INTO `sublet_info_label` VALUES ('ebd983487f2234fc5d2a2db932612f4b', 1);
INSERT INTO `sublet_info_label` VALUES ('ebd983487f2234fc5d2a2db932612f4b', 2);
INSERT INTO `sublet_info_label` VALUES ('f059ee140ebb199993ca788241b6a50d', 1);
INSERT INTO `sublet_info_label` VALUES ('f059ee140ebb199993ca788241b6a50d', 6);
INSERT INTO `sublet_info_label` VALUES ('9bc638b225068d8e5932c08e053d3cf2', 7);
INSERT INTO `sublet_info_label` VALUES ('9bc638b225068d8e5932c08e053d3cf2', 8);
INSERT INTO `sublet_info_label` VALUES ('424207c3093be9cc96d463207cb4d2bc', 7);
INSERT INTO `sublet_info_label` VALUES ('424207c3093be9cc96d463207cb4d2bc', 8);
INSERT INTO `sublet_info_label` VALUES ('9bb7cfedaf5f8b362853b1e0fa80dc2c', 1);
INSERT INTO `sublet_info_label` VALUES ('9bb7cfedaf5f8b362853b1e0fa80dc2c', 6);
INSERT INTO `sublet_info_label` VALUES ('9963e2ede18ceccba5b152a0bc333ba9', 1);
INSERT INTO `sublet_info_label` VALUES ('9963e2ede18ceccba5b152a0bc333ba9', 6);
INSERT INTO `sublet_info_label` VALUES ('b974b6a4c30817c81095fb6bb5fd3a46', 1);
INSERT INTO `sublet_info_label` VALUES ('b974b6a4c30817c81095fb6bb5fd3a46', 6);
INSERT INTO `sublet_info_label` VALUES ('1c4914d32afc03af53500d6fb1998750', 1);
INSERT INTO `sublet_info_label` VALUES ('1c4914d32afc03af53500d6fb1998750', 6);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '日志标题',
  `remote_addr` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '操作ip地址',
  `request_uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '请求uri',
  `method` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '请求方式',
  `body` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '请求body',
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '请求参数',
  `exec_time` bigint(0) NULL DEFAULT NULL COMMENT '执行时间',
  `type` tinyint(0) NULL DEFAULT NULL COMMENT '日志类型（0正常 1错误）',
  `client_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户端id',
  `error_msg` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '错误消息',
  `create_time` bigint(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varbinary(255) NULL DEFAULT NULL COMMENT '操作人',
  `update_time` bigint(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 149 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (6, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', NULL, '', 17, 1, 'sublet-user', 'For input string: \"2，3，4，5\"', 1637231960199, 0x61646D696E, 1637231960222, 'anonymousUser');
INSERT INTO `sys_log` VALUES (7, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', NULL, '', 31, 1, 'sublet-user', 'com.wrh.sublet.user.biz.mapper.RoleAuthorityMapper.insert (batch index #1) failed. Cause: java.sql.BatchUpdateException: Duplicate entry \'5\' for key \'role_authority.PRIMARY\'\n; Duplicate entry \'5\' for key \'role_authority.PRIMARY\'; nested exception is java.sql.BatchUpdateException: Duplicate entry \'5\' for key \'role_authority.PRIMARY\'', 1637232131682, 0x61646D696E, 1637232131720, 'anonymousUser');
INSERT INTO `sys_log` VALUES (8, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', NULL, '', 137, 1, 'sublet-user', 'com.wrh.sublet.user.biz.mapper.RoleAuthorityMapper.insert (batch index #1) failed. Cause: java.sql.BatchUpdateException: Duplicate entry \'6\' for key \'role_authority.PRIMARY\'\n; Duplicate entry \'6\' for key \'role_authority.PRIMARY\'; nested exception is java.sql.BatchUpdateException: Duplicate entry \'6\' for key \'role_authority.PRIMARY\'', 1637234160770, 0x61646D696E, 1637234161028, 'anonymousUser');
INSERT INTO `sys_log` VALUES (9, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', NULL, '', 107, 1, 'sublet-user', 'com.wrh.sublet.user.biz.mapper.RoleAuthorityMapper.insert (batch index #1) failed. Cause: java.sql.BatchUpdateException: Duplicate entry \'7\' for key \'role_authority.PRIMARY\'\n; Duplicate entry \'7\' for key \'role_authority.PRIMARY\'; nested exception is java.sql.BatchUpdateException: Duplicate entry \'7\' for key \'role_authority.PRIMARY\'', 1637234285357, 0x61646D696E, 1637234285572, 'anonymousUser');
INSERT INTO `sys_log` VALUES (10, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', NULL, '', 109, 1, 'sublet-user', 'com.wrh.sublet.user.biz.mapper.RoleAuthorityMapper.insert (batch index #1) failed. Cause: java.sql.BatchUpdateException: Duplicate entry \'8\' for key \'role_authority.PRIMARY\'\n; Duplicate entry \'8\' for key \'role_authority.PRIMARY\'; nested exception is java.sql.BatchUpdateException: Duplicate entry \'8\' for key \'role_authority.PRIMARY\'', 1637234485776, 0x61646D696E, 1637234485993, 'anonymousUser');
INSERT INTO `sys_log` VALUES (11, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', NULL, '', 89, 1, 'sublet-user', 'For input string: \"string\"', 1637238435177, 0x61646D696E, 1637239688580, 'anonymousUser');
INSERT INTO `sys_log` VALUES (12, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', '', '', 64, 1, 'sublet-user', 'For input string: \"string\"', 1637240417073, 0x61646D696E, 1637240417236, 'anonymousUser');
INSERT INTO `sys_log` VALUES (13, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', '', '', 16, 0, 'sublet-user', NULL, 1637240453915, 0x61646D696E, 1637240453940, 'anonymousUser');
INSERT INTO `sys_log` VALUES (14, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', '', '', 2, 0, 'sublet-user', NULL, 1637240741433, 0x61646D696E, 1637240741560, 'anonymousUser');
INSERT INTO `sys_log` VALUES (15, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', '', '', 2, 0, 'sublet-user', NULL, 1637240803757, 0x61646D696E, 1637240803879, 'anonymousUser');
INSERT INTO `sys_log` VALUES (16, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', '', '', 3, 0, 'sublet-user', NULL, 1637240962540, 0x61646D696E, 1637240962658, 'anonymousUser');
INSERT INTO `sys_log` VALUES (17, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', '', '', 0, 0, 'sublet-user', NULL, 1637241033219, 0x61646D696E, 1637241033227, 'anonymousUser');
INSERT INTO `sys_log` VALUES (18, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', '{\r\n  \"authorityIds\": \"2,3,4,5\",\r\n  \"roleCode\": \"ROLE_ADMIN\",\r\n  \"roleDesc\": \"中台管理员\",\r\n  \"roleName\": \"管理员\"\r\n}', '', 2, 0, 'sublet-user', NULL, 1637242561361, 0x61646D696E, 1637242561466, 'anonymousUser');
INSERT INTO `sys_log` VALUES (19, '新增角色', '0:0:0:0:0:0:0:1', '/sublet-user/role', 'POST', '{\r\n  \"authorityIds\": \"2,3,4,5\",\r\n  \"roleCode\": \"ROLE_ADMIN\",\r\n  \"roleDesc\": \"中台管理员\",\r\n  \"roleName\": \"管理员\"\r\n}', 'aaa=%5Bbbbb%5D&ccc=%5Bdddd%5D', 0, 0, 'sublet-user', NULL, 1637242619091, 0x61646D696E, 1637242619110, 'anonymousUser');
INSERT INTO `sys_log` VALUES (20, '新增权限', '0:0:0:0:0:0:0:1', '/sublet-user/authority', 'POST', '{\n  \"authName\": \"系统管理页面\",\n  \"component\": \"RouteView\",\n  \"icon\": \"setting\",\n  \"menuUri\": \"\",\n  \"permission\": \"sys_manager_page\",\n  \"pid\": -1,\n  \"sort\": 5,\n  \"type\": \"0\"\n}', '', 78, 0, 'sublet-user', NULL, 1638346721033, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (21, '编辑用户', '127.0.0.1', '/sublet-user/user/undefined', 'PUT', '{\"state\":1}', '', 95, 0, 'sublet-user', NULL, 1638841463506, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (22, '修改用户状态', '127.0.0.1', '/sublet-user/user/lock/ac34389f9d1bc981d190318e4d4053a9', 'PUT', '', '', 19, 0, 'sublet-user', NULL, 1638842426650, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (23, '修改用户状态', '127.0.0.1', '/sublet-user/user/lock/ac34389f9d1bc981d190318e4d4053a9', 'PUT', '', '', 11, 0, 'sublet-user', NULL, 1638842464144, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (24, '修改用户状态', '127.0.0.1', '/sublet-user/user/lock/b41159765822c1ef0e196249e34c6534', 'PUT', '', '', 12, 0, 'sublet-user', NULL, 1638842645725, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (25, '修改用户状态', '127.0.0.1', '/sublet-user/user/lock/b41159765822c1ef0e196249e34c6534', 'PUT', '', '', 9, 0, 'sublet-user', NULL, 1638842806470, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (26, '修改用户状态', '127.0.0.1', '/sublet-user/user/lock/b41159765822c1ef0e196249e34c6534', 'PUT', '', '', 10, 0, 'sublet-user', NULL, 1638842990973, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (27, '修改用户状态', '127.0.0.1', '/sublet-user/user/lock/b41159765822c1ef0e196249e34c6534', 'PUT', '', '', 12, 0, 'sublet-user', NULL, 1638843022156, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (28, '修改用户状态', '127.0.0.1', '/sublet-user/user/lock/b41159765822c1ef0e196249e34c6534', 'PUT', '', '', 16, 0, 'sublet-user', NULL, 1638843082309, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (29, '修改用户状态', '127.0.0.1', '/sublet-user/user/lock/b41159765822c1ef0e196249e34c6534', 'PUT', '', '', 39, 0, 'sublet-user', NULL, 1638857609319, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (30, '给用户分配角色', '127.0.0.1', '/sublet-user/userRoleRel/role', 'POST', '{\"userId\":\"ac34389f9d1bc981d190318e4d4053a9\",\"roleIds\":\"[1,9,15]\"}', '', 44, 1, 'sublet-user', 'For input string: \"[1\"', 1638858728836, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (31, '给用户分配角色', '127.0.0.1', '/sublet-user/userRoleRel/role', 'POST', '{\"userId\":\"ac34389f9d1bc981d190318e4d4053a9\",\"roleIds\":[1,9,15]}', '', 33, 0, 'sublet-user', NULL, 1638859113185, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (32, '给用户分配角色', '127.0.0.1', '/sublet-user/userRoleRel/role', 'POST', '{\"userId\":\"ac34389f9d1bc981d190318e4d4053a9\",\"roleIds\":[9,15]}', '', 23, 0, 'sublet-user', NULL, 1638859128453, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (33, '角色编辑', '127.0.0.1', '/sublet-user/role/1', 'PUT', '{\"createBy\":null,\"createTime\":null,\"updateBy\":null,\"updateTime\":null,\"roleId\":1,\"roleName\":\"前台用户1\",\"roleDesc\":\"转租前台的用户\",\"roleCode\":\"ROLE_FRONT\",\"delFlag\":0,\"entIdListStr\":\"\"}', '', 42, 1, 'sublet-user', NULL, 1638865685334, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (34, '角色编辑', '127.0.0.1', '/sublet-user/role/15', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637240453917,\"updateBy\":\"admin\",\"updateTime\":1637240453917,\"roleId\":15,\"roleName\":\"管理员\",\"roleDesc\":\"中台管理员\",\"roleCode\":\"ROLE_ADMIN\",\"delFlag\":0,\"entIdListStr\":\"[3,2,6,4,5,11,9,12,13,14,15,10,16,17,18]\"}', '', 8, 1, 'sublet-user', NULL, 1638869160901, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (35, '角色编辑', '127.0.0.1', '/sublet-user/role/9', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637234581262,\"updateBy\":\"admin\",\"updateTime\":1637234581262,\"roleId\":9,\"roleName\":\"中台用户\",\"roleDesc\":\"中台用户\",\"roleCode\":\"ROLE_MIDDLE\",\"delFlag\":0,\"entIdListStr\":[8]}', '', 9, 1, 'sublet-user', NULL, 1638869521322, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (36, '角色编辑', '127.0.0.1', '/sublet-user/role/9', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637234581262,\"updateBy\":\"admin\",\"updateTime\":1637234581262,\"roleId\":9,\"roleName\":\"中台用户\",\"roleDesc\":\"中台用户\",\"roleCode\":\"ROLE_MIDDLE\",\"delFlag\":0,\"authorityIds\":[8]}', '', 33, 0, 'sublet-user', NULL, 1638869681177, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (37, '角色编辑', '127.0.0.1', '/sublet-user/role/9', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637234581262,\"updateBy\":\"admin\",\"updateTime\":1638869681189,\"roleId\":9,\"roleName\":\"中台用户111\",\"roleDesc\":\"中台用户1111\",\"roleCode\":\"ROLE_MIDDLE\",\"delFlag\":0,\"authorityIds\":[8,7]}', '', 18, 0, 'sublet-user', NULL, 1638869714125, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (38, '角色编辑', '127.0.0.1', '/sublet-user/role/9', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637234581262,\"updateBy\":\"admin\",\"updateTime\":1638869714127,\"roleId\":9,\"roleName\":\"中台用户\",\"roleDesc\":\"中台用户\",\"roleCode\":\"ROLE_MIDDLE\",\"delFlag\":0,\"authorityIds\":[7,8]}', '', 16, 0, 'sublet-user', NULL, 1638869723372, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (39, '新增角色', '127.0.0.1', '/sublet-user/role', 'POST', '{\"roleName\":\"test\",\"roleCode\":\"TEST\",\"roleDesc\":\"test\",\"authorityIds\":[8,7]}', '', 14, 0, 'sublet-user', NULL, 1638870616505, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (40, '删除角色', '127.0.0.1', '/sublet-user/role/16', 'DELETE', '', '', 16, 0, 'sublet-user', NULL, 1638870740554, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (41, '编辑权限', '127.0.0.1', '/sublet-user/authority/17', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1638346721102,\"updateBy\":null,\"updateTime\":null,\"authId\":17,\"authName\":\"删除权限\",\"permission\":\"authority_del\",\"icon\":null,\"menuUri\":null,\"pid\":10,\"component\":\"\",\"sort\":\"4\",\"type\":\"1\",\"delFlag\":0}', '', 42, 0, 'sublet-user', NULL, 1638879116255, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (42, '编辑权限', '127.0.0.1', '/sublet-user/authority/6', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1638346721102,\"updateBy\":\"admin\",\"updateTime\":1638346721102,\"authId\":6,\"authName\":\"系统管理\",\"permission\":\"\",\"icon\":\"setting\",\"menuUri\":\"\",\"pid\":-1,\"component\":\"RouteView\",\"sort\":5,\"type\":\"0\",\"delFlag\":0}', '', 19, 0, 'sublet-user', NULL, 1638879618874, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (43, '编辑权限', '127.0.0.1', '/sublet-user/authority/6', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1638346721102,\"updateBy\":\"admin\",\"updateTime\":1638879618878,\"authId\":6,\"authName\":\"系统管理\",\"permission\":\"sys_manager_page\",\"icon\":\"setting\",\"menuUri\":\"\",\"pid\":-1,\"component\":\"RouteView\",\"sort\":5,\"type\":\"0\",\"delFlag\":0}', '', 12, 0, 'sublet-user', NULL, 1638879644383, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (44, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"test\",\"permission\":\"test\",\"type\":1,\"menuUri\":\"/test\",\"component\":\"test\",\"icon\":\"test\",\"sort\":\"2\",\"pid\":\"-1\",\"state\":1}', '', 14, 0, 'sublet-user', NULL, 1638880119411, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (45, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"用户角色管理\",\"permission\":\"user_role_auth\",\"type\":0,\"component\":\"RoterView\",\"icon\":\"team\",\"sort\":\"1\",\"pid\":\"6\"}', '', 13, 0, 'sublet-user', NULL, 1638881014531, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (46, '编辑权限', '127.0.0.1', '/sublet-user/authority/9', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1638346721102,\"updateBy\":\"admin\",\"updateTime\":1638346721102,\"authId\":9,\"authName\":\"角色管理\",\"permission\":\"role_page\",\"icon\":\"user\",\"menuUri\":\"/roles\",\"pid\":\"20\",\"component\":\"RolePage\",\"sort\":2,\"type\":\"0\",\"delFlag\":0}', '', 16, 0, 'sublet-user', NULL, 1638881038480, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (47, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"系统日志\",\"permission\":\"sys_log_page\",\"type\":0,\"menuUri\":\"/log\",\"component\":\"SysLogPage\",\"icon\":\"file-text\",\"sort\":\"2\",\"pid\":\"6\"}', '', 10, 0, 'sublet-user', NULL, 1638881432086, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (48, '角色编辑', '127.0.0.1', '/sublet-user/role/15', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637240453917,\"updateBy\":\"admin\",\"updateTime\":1637240453917,\"roleId\":15,\"roleName\":\"管理员\",\"roleDesc\":\"中台管理员\",\"roleCode\":\"ROLE_ADMIN\",\"delFlag\":0,\"authorityIds\":[3,2,20,6,4,5,11,9,12,13,14,15,10,16,17,18,21]}', '', 59, 0, 'sublet-user', NULL, 1638881453793, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (49, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"删除日志\",\"permission\":\"log_del\",\"type\":1,\"sort\":\"1\",\"pid\":\"21\"}', '', 78, 0, 'sublet-user', NULL, 1638930618781, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (50, '角色编辑', '127.0.0.1', '/sublet-user/role/15', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637240453917,\"updateBy\":\"admin\",\"updateTime\":1638881453800,\"roleId\":15,\"roleName\":\"管理员\",\"roleDesc\":\"中台管理员\",\"roleCode\":\"ROLE_ADMIN\",\"delFlag\":0,\"authorityIds\":[3,2,20,6,4,5,11,9,12,13,14,15,10,16,17,18,21,22]}', '', 48, 0, 'sublet-user', NULL, 1638930632908, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (51, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"日志详情\",\"permission\":\"log_detail\",\"type\":1,\"pid\":\"21\",\"sort\":\"1\"}', '', 62, 0, 'sublet-middle', NULL, 1638944037505, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (52, '编辑权限', '127.0.0.1', '/sublet-user/authority/22', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1638930618831,\"updateBy\":null,\"updateTime\":null,\"authId\":22,\"authName\":\"删除日志\",\"permission\":\"log_del\",\"icon\":null,\"menuUri\":null,\"pid\":21,\"component\":null,\"sort\":\"2\",\"type\":\"1\",\"delFlag\":0}', '', 13, 0, 'sublet-middle', NULL, 1638944047777, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (53, '角色编辑', '127.0.0.1', '/sublet-user/role/15', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637240453917,\"updateBy\":\"admin\",\"updateTime\":1638930632926,\"roleId\":15,\"roleName\":\"管理员\",\"roleDesc\":\"中台管理员\",\"roleCode\":\"ROLE_ADMIN\",\"delFlag\":0,\"authorityIds\":[3,2,20,6,4,5,11,9,12,13,14,15,10,16,17,18,22,21,23]}', '', 41, 0, 'sublet-middle', NULL, 1638944068432, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (54, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"帖子禁用\",\"permission\":\"sublet_info_lock\",\"type\":1,\"sort\":\"1\",\"pid\":\"7\"}', '', 112, 0, 'sublet-middle', NULL, 1639472025826, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (55, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"帖子详情\",\"permission\":\"sublet_info_detail\",\"type\":1,\"pid\":\"7\",\"sort\":\"2\"}', '', 9, 0, 'sublet-middle', NULL, 1639472089615, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (56, '角色编辑', '127.0.0.1', '/sublet-user/role/15', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637240453917,\"updateBy\":\"admin\",\"updateTime\":1638944068446,\"roleId\":15,\"roleName\":\"管理员\",\"roleDesc\":\"中台管理员\",\"roleCode\":\"ROLE_ADMIN\",\"delFlag\":0,\"authorityIds\":[3,2,20,6,4,5,11,9,12,13,14,15,10,16,17,18,22,21,23,7,24,25]}', '', 96, 0, 'sublet-middle', NULL, 1639472099426, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (57, '锁定违规帖子不然展示', '127.0.0.1', '/sublet-post/sublet-info/lock/ebd983487f2234fc5d2a2db932612f4b', 'PUT', '', '', 140, 1, 'sublet-middle', '\r\n### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'update_by\' in \'field list\'\r\n### The error may exist in com/wrh/sublet/post/biz/mapper/SubletInfoMapper.java (best guess)\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: SELECT sublet_info_id,description,monthly_rent,address,province,city,district,street,area,user_id,status,lock_flag,images,create_time,update_time,create_by,update_by FROM sublet_info WHERE sublet_info_id=?\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'update_by\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'update_by\' in \'field list\'', 1639472949387, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (58, '锁定违规帖子不然展示', '127.0.0.1', '/sublet-post/sublet-info/lock/ebd983487f2234fc5d2a2db932612f4b', 'PUT', '', '', 6, 1, 'sublet-middle', '\r\n### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'update_by\' in \'field list\'\r\n### The error may exist in com/wrh/sublet/post/biz/mapper/SubletInfoMapper.java (best guess)\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: SELECT sublet_info_id,description,monthly_rent,address,province,city,district,street,area,user_id,status,lock_flag,images,create_time,update_time,create_by,update_by FROM sublet_info WHERE sublet_info_id=?\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'update_by\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'update_by\' in \'field list\'', 1639473001038, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (59, '锁定违规帖子不然展示', '127.0.0.1', '/sublet-post/sublet-info/lock/ebd983487f2234fc5d2a2db932612f4b', 'PUT', '', '', 37, 0, 'sublet-middle', NULL, 1639473132567, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (60, '锁定违规帖子不然展示', '127.0.0.1', '/sublet-post/sublet-info/lock/ebd983487f2234fc5d2a2db932612f4b', 'PUT', '', '', 44, 0, 'sublet-middle', NULL, 1639475056105, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (61, '锁定违规帖子不然展示', '127.0.0.1', '/sublet-post/sublet-info/lock/ebd983487f2234fc5d2a2db932612f4b', 'PUT', '', '', 20, 0, 'sublet-middle', NULL, 1639482738865, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (62, '锁定违规帖子不然展示', '127.0.0.1', '/sublet-post/sublet-info/lock/ebd983487f2234fc5d2a2db932612f4b', 'PUT', '', '', 16, 0, 'sublet-middle', NULL, 1639482741450, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (63, '角色编辑', '127.0.0.1', '/sublet-user/role/9', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637234581262,\"updateBy\":\"admin\",\"updateTime\":1638869723374,\"roleId\":9,\"roleName\":\"中台用户\",\"roleDesc\":\"中台用户66\",\"roleCode\":\"ROLE_MIDDLE\",\"delFlag\":0,\"authorityIds\":[8]}', '', 43, 0, 'sublet-middle', NULL, 1639490881257, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (64, '角色编辑', '127.0.0.1', '/sublet-user/role/9', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637234581262,\"updateBy\":\"admin\",\"updateTime\":1639490881281,\"roleId\":9,\"roleName\":\"中台用户\",\"roleDesc\":\"中台用户\",\"roleCode\":\"ROLE_MIDDLE\",\"delFlag\":0,\"authorityIds\":[8]}', '', 39, 0, 'sublet-middle', NULL, 1639533258106, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (65, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"pid\":\"26\",\"sort\":\"2\",\"icon\":\"message\",\"component\":\"CommentPage\",\"menuUri\":\"/comment\",\"type\":0,\"permission\":\"comment_page\",\"authName\":\"评论管理\"}', '', 33, 0, 'sublet-middle', NULL, 1639548870019, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (66, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"删除评论\",\"permission\":\"comment_del\",\"type\":1,\"sort\":\"2\",\"pid\":\"27\"}', '', 7, 0, 'sublet-middle', NULL, 1639548963372, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (67, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"icon\":\"paper-clip\",\"sort\":\"3\",\"pid\":\"26\",\"component\":\"labelPage\",\"menuUri\":\"/label\",\"type\":0,\"permission\":\"label_page\",\"authName\":\"标签管理\"}', '', 24, 0, 'sublet-middle', NULL, 1639549071036, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (68, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"删除标签\",\"permission\":\"label_del\",\"type\":1,\"sort\":\"3\",\"pid\":\"29\"}', '', 19, 0, 'sublet-middle', NULL, 1639549140245, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (69, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"新增标签\",\"permission\":\"label_add\",\"type\":1,\"sort\":\"1\",\"pid\":\"29\"}', '', 12, 0, 'sublet-middle', NULL, 1639549164575, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (70, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"编辑标签\",\"permission\":\"label_edit\",\"type\":1,\"sort\":\"2\",\"pid\":\"29\"}', '', 10, 0, 'sublet-middle', NULL, 1639549188410, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (71, '编辑权限', '127.0.0.1', '/sublet-user/authority/29', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1639549071036,\"updateBy\":null,\"updateTime\":null,\"authId\":29,\"authName\":\"标签管理\",\"permission\":\"label_page\",\"icon\":\"paper-clip\",\"menuUri\":\"/label\",\"pid\":26,\"component\":\"LabelPage\",\"sort\":3,\"type\":\"0\",\"delFlag\":0}', '', 9, 0, 'sublet-middle', NULL, 1639549461626, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (72, '禁用违规帖子', '127.0.0.1', '/sublet-post/sublet-info/lock/ebd983487f2234fc5d2a2db932612f4b', 'PUT', '', '', 22, 0, 'sublet-middle', NULL, 1639574738874, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (73, '禁用违规帖子', '127.0.0.1', '/sublet-post/sublet-info/lock/ebd983487f2234fc5d2a2db932612f4b', 'PUT', '', '', 12, 0, 'sublet-middle', NULL, 1639574746764, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (74, '新增标签', '127.0.0.1', '/sublet-post/label', 'POST', '{\"labelName\":\"两房两卫\"}', '', 65, 0, 'sublet-middle', NULL, 1639574973136, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (75, '编辑标签', '127.0.0.1', '/sublet-post/label/3', 'PUT', '{\"createBy\":\"admin\",\"createTime\":null,\"updateBy\":null,\"updateTime\":null,\"labelId\":3,\"labelName\":\"两房两卫1\"}', '', 19, 0, 'sublet-middle', NULL, 1639575039261, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (76, '编辑标签', '127.0.0.1', '/sublet-post/label/3', 'PUT', '{\"createBy\":\"admin\",\"createTime\":null,\"updateBy\":\"admin\",\"updateTime\":1639575039269,\"labelId\":3,\"labelName\":\"两房两卫\"}', '', 14, 0, 'sublet-middle', NULL, 1639575056588, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (77, '新增标签', '127.0.0.1', '/sublet-post/label', 'POST', '{\"labelName\":\"拎包入住\"}', '', 14, 0, 'sublet-middle', NULL, 1639575185083, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (78, '新增标签', '127.0.0.1', '/sublet-post/label', 'POST', '{\"labelName\":\"6666\"}', '', 11, 0, 'sublet-middle', NULL, 1639575283799, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (79, '编辑用户', '127.0.0.1', '/sublet-user/user/e813fa325c0f6a96ca5a5ed486a43bd7', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1639985116051,\"updateBy\":\"admin\",\"updateTime\":1639986031136,\"userId\":\"e813fa325c0f6a96ca5a5ed486a43bd7\",\"username\":\"test\",\"avatar\":null,\"email\":\"test123456@qq.com\",\"lastLoginTime\":null,\"lockFlag\":0,\"delFlag\":0}', '', 40, 0, 'sublet-middle', NULL, 1639986437551, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (80, '编辑用户', '127.0.0.1', '/sublet-user/user/e813fa325c0f6a96ca5a5ed486a43bd7', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1639985116051,\"updateBy\":\"admin\",\"updateTime\":1639986437588,\"userId\":\"e813fa325c0f6a96ca5a5ed486a43bd7\",\"username\":\"test\",\"avatar\":null,\"email\":\"test@qq.com\",\"lastLoginTime\":null,\"lockFlag\":0,\"delFlag\":0}', '', 12, 0, 'sublet-middle', NULL, 1639986480504, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (81, '给用户分配角色', '127.0.0.1', '/sublet-user/userRoleRel/role', 'POST', '{\"userId\":\"e813fa325c0f6a96ca5a5ed486a43bd7\",\"roleIds\":[1]}', '', 14, 0, 'sublet-middle', NULL, 1639986901377, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (82, '删除用户', '127.0.0.1', '/sublet-user/user/50218adee043c01d6abb5de0e7ac4710', 'DELETE', '', '', 32, 0, 'sublet-middle', NULL, 1640000487698, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (83, '给用户分配角色', '127.0.0.1', '/sublet-user/userRoleRel/role', 'POST', '{\"userId\":\"e813fa325c0f6a96ca5a5ed486a43bd7\",\"roleIds\":[1,9]}', '', 144, 1, 'sublet-middle', 'com.wrh.sublet.user.biz.mapper.UserRoleRelMapper.insert (batch index #1) failed. Cause: java.sql.BatchUpdateException: Duplicate entry \'9\' for key \'user_role_rel.PRIMARY\'\n; Duplicate entry \'9\' for key \'user_role_rel.PRIMARY\'; nested exception is java.sql.BatchUpdateException: Duplicate entry \'9\' for key \'user_role_rel.PRIMARY\'', 1640005520183, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (84, '给用户分配角色', '127.0.0.1', '/sublet-user/userRoleRel/role', 'POST', '{\"userId\":\"e813fa325c0f6a96ca5a5ed486a43bd7\",\"roleIds\":[1,9]}', '', 8, 1, 'sublet-middle', 'com.wrh.sublet.user.biz.mapper.UserRoleRelMapper.insert (batch index #1) failed. Cause: java.sql.BatchUpdateException: Duplicate entry \'9\' for key \'user_role_rel.PRIMARY\'\n; Duplicate entry \'9\' for key \'user_role_rel.PRIMARY\'; nested exception is java.sql.BatchUpdateException: Duplicate entry \'9\' for key \'user_role_rel.PRIMARY\'', 1640005528463, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (85, '给用户分配角色', '127.0.0.1', '/sublet-user/userRoleRel/role', 'POST', '{\"userId\":\"e813fa325c0f6a96ca5a5ed486a43bd7\",\"roleIds\":[1,9]}', '', 23, 0, 'sublet-middle', NULL, 1640005621238, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (86, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"用户列表\",\"permission\":\"user_list\",\"type\":1,\"sort\":\"1\",\"pid\":\"2\"}', '', 61, 0, 'sublet-middle', NULL, 1640067737597, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (87, '编辑权限', '127.0.0.1', '/sublet-user/authority/3', 'PUT', '{\"createBy\":\"wuruihao\",\"createTime\":1637068278149,\"updateBy\":\"wuruihao\",\"updateTime\":1637068278149,\"authId\":3,\"authName\":\"新增用户\",\"permission\":\"user_add\",\"icon\":\"\",\"menuUri\":\"\",\"pid\":2,\"component\":\"\",\"sort\":\"5\",\"type\":\"1\",\"delFlag\":0}', '', 20, 0, 'sublet-middle', NULL, 1640067778796, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (88, '编辑权限', '127.0.0.1', '/sublet-user/authority/18', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1638346721102,\"updateBy\":null,\"updateTime\":null,\"authId\":18,\"authName\":\"分配角色权限\",\"permission\":\"assign_role\",\"icon\":null,\"menuUri\":null,\"pid\":2,\"component\":null,\"sort\":\"6\",\"type\":\"1\",\"delFlag\":0}', '', 6, 0, 'sublet-middle', NULL, 1640067790109, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (89, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"角色列表\",\"permission\":\"role_list\",\"sort\":\"1\",\"pid\":\"9\"}', '', 16, 0, 'sublet-middle', NULL, 1640067836037, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (90, '编辑权限', '127.0.0.1', '/sublet-user/authority/11', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1638346721102,\"updateBy\":null,\"updateTime\":null,\"authId\":11,\"authName\":\"添加角色\",\"permission\":\"role_add\",\"icon\":null,\"menuUri\":null,\"pid\":9,\"component\":null,\"sort\":\"2\",\"type\":\"1\",\"delFlag\":0}', '', 8, 0, 'sublet-middle', NULL, 1640067853530, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (91, '编辑权限', '127.0.0.1', '/sublet-user/authority/13', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1638346721102,\"updateBy\":null,\"updateTime\":null,\"authId\":13,\"authName\":\"编辑角色\",\"permission\":\"role_edit\",\"icon\":null,\"menuUri\":null,\"pid\":9,\"component\":null,\"sort\":\"3\",\"type\":\"1\",\"delFlag\":0}', '', 6, 0, 'sublet-middle', NULL, 1640067860270, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (92, '编辑权限', '127.0.0.1', '/sublet-user/authority/12', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1638346721102,\"updateBy\":null,\"updateTime\":null,\"authId\":12,\"authName\":\"删除角色\",\"permission\":\"role_del\",\"icon\":null,\"menuUri\":null,\"pid\":9,\"component\":null,\"sort\":\"4\",\"type\":\"1\",\"delFlag\":0}', '', 6, 0, 'sublet-middle', NULL, 1640067868008, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (93, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"权限列表\",\"permission\":\"authority_list\",\"type\":1,\"pid\":\"10\",\"sort\":\"1\"}', '', 12, 0, 'sublet-middle', NULL, 1640067918681, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (94, '编辑权限', '127.0.0.1', '/sublet-user/authority/15', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1638346721102,\"updateBy\":null,\"updateTime\":null,\"authId\":15,\"authName\":\"新增权限\",\"permission\":\"authority_add\",\"icon\":null,\"menuUri\":null,\"pid\":10,\"component\":null,\"sort\":\"3\",\"type\":\"1\",\"delFlag\":0}', '', 14, 0, 'sublet-middle', NULL, 1640067940578, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (95, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"标签列表\",\"permission\":\"label_list\",\"type\":1,\"sort\":\"1\",\"pid\":\"29\"}', '', 13, 0, 'sublet-middle', NULL, 1640067991235, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (96, '编辑权限', '127.0.0.1', '/sublet-user/authority/31', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1639549164576,\"updateBy\":null,\"updateTime\":null,\"authId\":31,\"authName\":\"新增标签\",\"permission\":\"label_add\",\"icon\":null,\"menuUri\":null,\"pid\":29,\"component\":null,\"sort\":\"4\",\"type\":\"1\",\"delFlag\":0}', '', 15, 0, 'sublet-middle', NULL, 1640068019013, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (97, '角色编辑', '127.0.0.1', '/sublet-user/role/9', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637234581262,\"updateBy\":\"admin\",\"updateTime\":1639533258120,\"roleId\":9,\"roleName\":\"中台用户\",\"roleDesc\":\"中台用户\",\"roleCode\":\"ROLE_MIDDLE\",\"delFlag\":0,\"authorityIds\":[8,25,7,26,36,29,33,2,20,6,34,9,35,10,23,21]}', '', 69, 0, 'sublet-middle', NULL, 1640068085281, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (98, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"评论列表\",\"permission\":\"comment_list\",\"type\":1,\"sort\":\"1\",\"pid\":\"27\"}', '', 74, 0, 'sublet-middle', NULL, 1640154524750, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (99, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/5', 'DELETE', '', '', 17, 0, 'sublet-middle', NULL, 1640163156767, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (100, '编辑权限', '127.0.0.1', '/sublet-user/authority/37', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1640154524790,\"updateBy\":null,\"updateTime\":null,\"authId\":37,\"authName\":\"评论列表\",\"permission\":\"comment_list\",\"icon\":null,\"menuUri\":null,\"pid\":\"7\",\"component\":null,\"sort\":1,\"type\":\"1\",\"delFlag\":0}', '', 22, 0, 'sublet-middle', NULL, 1640163578075, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (101, '编辑权限', '127.0.0.1', '/sublet-user/authority/28', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1639548963372,\"updateBy\":null,\"updateTime\":null,\"authId\":28,\"authName\":\"删除评论\",\"permission\":\"comment_del\",\"icon\":null,\"menuUri\":null,\"pid\":\"7\",\"component\":null,\"sort\":2,\"type\":\"1\",\"delFlag\":0}', '', 13, 0, 'sublet-middle', NULL, 1640163588199, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (102, '编辑权限', '127.0.0.1', '/sublet-user/authority/37', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1640154524790,\"updateBy\":\"admin\",\"updateTime\":1640163578091,\"authId\":37,\"authName\":\"评论列表\",\"permission\":\"comment_list\",\"icon\":null,\"menuUri\":null,\"pid\":7,\"component\":null,\"sort\":\"3\",\"type\":\"1\",\"delFlag\":0}', '', 18, 0, 'sublet-middle', NULL, 1640163650301, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (103, '编辑权限', '127.0.0.1', '/sublet-user/authority/28', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1639548963372,\"updateBy\":\"admin\",\"updateTime\":1640163588203,\"authId\":28,\"authName\":\"删除评论\",\"permission\":\"comment_del\",\"icon\":null,\"menuUri\":null,\"pid\":7,\"component\":null,\"sort\":\"4\",\"type\":\"1\",\"delFlag\":0}', '', 11, 0, 'sublet-middle', NULL, 1640163659787, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (104, '给用户分配角色', '127.0.0.1', '/sublet-user/userRoleRel/role', 'POST', '{\"userId\":\"b41159765822c1ef0e196249e34c6534\",\"roleIds\":[1]}', '', 22, 0, 'sublet-middle', NULL, 1640164974650, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (105, '给用户分配角色', '127.0.0.1', '/sublet-user/userRoleRel/role', 'POST', '{\"userId\":\"b41159765822c1ef0e196249e34c6534\",\"roleIds\":[]}', '', 21, 0, 'sublet-middle', NULL, 1640165247699, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (106, '角色编辑', '127.0.0.1', '/sublet-user/role/9', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637234581262,\"updateBy\":\"admin\",\"updateTime\":1640068085294,\"roleId\":9,\"roleName\":\"中台用户\",\"roleDesc\":\"中台用户\",\"roleCode\":\"ROLE_MIDDLE\",\"delFlag\":0,\"authorityIds\":[8,23,21,6,25,7,26,33,2,20,34,9,35,10,36,29,37]}', '', 81, 0, 'sublet-middle', NULL, 1640176801352, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (107, '给用户分配角色', '127.0.0.1', '/sublet-user/userRoleRel/role', 'POST', '{\"userId\":\"e813fa325c0f6a96ca5a5ed486a43bd7\",\"roleIds\":[1,9]}', '', 12, 0, 'sublet-middle', NULL, 1640176878838, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (108, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/9', 'DELETE', '', '', 11, 0, 'sublet-middle', NULL, 1640313944914, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (109, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/9', 'DELETE', '', '', 47, 1, 'sublet-middle', '请检查id是否有误', 1640314301095, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (110, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/8', 'DELETE', '', '', 18, 0, 'sublet-middle', NULL, 1640314306302, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (111, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/7', 'DELETE', '', '', 15, 0, 'sublet-middle', NULL, 1640314433502, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (112, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"authName\":\"转租信息列表\",\"permission\":\"sublet_info_list\",\"type\":1,\"sort\":\"1\",\"pid\":\"7\"}', '', 72, 0, 'sublet-middle', NULL, 1640314639293, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (113, '新增权限', '127.0.0.1', '/sublet-user/authority', 'POST', '{\"pid\":\"21\",\"sort\":\"1\",\"authName\":\"日志列表\",\"permission\":\"log_list\",\"type\":1}', '', 12, 0, 'sublet-middle', NULL, 1640314749082, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (114, '编辑权限', '127.0.0.1', '/sublet-user/authority/39', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1640314749082,\"updateBy\":null,\"updateTime\":null,\"authId\":39,\"authName\":\"日志列表\",\"permission\":\"log_list\",\"icon\":null,\"menuUri\":null,\"pid\":21,\"component\":null,\"sort\":\"3\",\"type\":\"1\",\"delFlag\":0}', '', 23, 0, 'sublet-middle', NULL, 1640314757461, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (115, '编辑权限', '127.0.0.1', '/sublet-user/authority/39', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1640314749082,\"updateBy\":\"admin\",\"updateTime\":1640314757475,\"authId\":39,\"authName\":\"日志列表\",\"permission\":\"log_list\",\"icon\":null,\"menuUri\":null,\"pid\":21,\"component\":null,\"sort\":\"1\",\"type\":\"1\",\"delFlag\":0}', '', 12, 0, 'sublet-middle', NULL, 1640314770754, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (116, '编辑权限', '127.0.0.1', '/sublet-user/authority/23', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1638944037562,\"updateBy\":null,\"updateTime\":null,\"authId\":23,\"authName\":\"日志详情\",\"permission\":\"log_detail\",\"icon\":null,\"menuUri\":null,\"pid\":21,\"component\":null,\"sort\":\"3\",\"type\":\"1\",\"delFlag\":0}', '', 11, 0, 'sublet-middle', NULL, 1640314779245, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (117, '角色编辑', '127.0.0.1', '/sublet-user/role/15', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637240453917,\"updateBy\":\"admin\",\"updateTime\":1640163674963,\"roleId\":15,\"roleName\":\"管理员\",\"roleDesc\":\"中台管理员\",\"roleCode\":\"ROLE_ADMIN\",\"delFlag\":0,\"authorityIds\":[3,2,20,6,33,4,5,14,18,9,34,11,13,12,10,35,16,15,17,8,22,21,23,24,7,26,25,28,30,29,36,32,31,37,38,39]}', '', 43, 0, 'sublet-middle', NULL, 1640315075111, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (118, '角色编辑', '127.0.0.1', '/sublet-user/role/9', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637234581262,\"updateBy\":\"admin\",\"updateTime\":1640176801375,\"roleId\":9,\"roleName\":\"中台用户\",\"roleDesc\":\"中台用户\",\"roleCode\":\"ROLE_MIDDLE\",\"delFlag\":0,\"authorityIds\":[8,25,7,26,33,2,20,6,34,9,35,10,36,29,37,39,21]}', '', 53, 0, 'sublet-middle', NULL, 1640315426899, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (119, '编辑权限', '127.0.0.1', '/sublet-user/authority/24', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1639472025943,\"updateBy\":null,\"updateTime\":null,\"authId\":24,\"authName\":\"帖子禁用\",\"permission\":\"sublet_info_lock\",\"icon\":null,\"menuUri\":null,\"pid\":7,\"component\":null,\"sort\":\"5\",\"type\":\"1\",\"delFlag\":0}', '', 16, 0, 'sublet-middle', NULL, 1640315456230, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (120, '角色编辑', '127.0.0.1', '/sublet-user/role/9', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637234581262,\"updateBy\":\"admin\",\"updateTime\":1640315426922,\"roleId\":9,\"roleName\":\"中台用户\",\"roleDesc\":\"中台用户\",\"roleCode\":\"ROLE_MIDDLE\",\"delFlag\":0,\"authorityIds\":[8,25,7,26,33,2,20,6,34,9,35,10,36,29,37,39,21,38]}', '', 37, 0, 'sublet-middle', NULL, 1640315474829, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (121, '角色编辑', '127.0.0.1', '/sublet-user/role/9', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1637234581262,\"updateBy\":\"admin\",\"updateTime\":1640315474832,\"roleId\":9,\"roleName\":\"中台用户\",\"roleDesc\":\"中台普通用户\",\"roleCode\":\"ROLE_MIDDLE\",\"delFlag\":0,\"authorityIds\":[8,25,7,26,33,2,20,6,34,9,35,10,36,29,37,38,39,21]}', '', 38, 0, 'sublet-middle', NULL, 1640315503694, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (122, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/12', 'DELETE', '', '', 12, 0, 'sublet-middle', NULL, 1640316017462, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (123, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/11', 'DELETE', '', '', 14, 0, 'sublet-middle', NULL, 1640316083497, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (124, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/10', 'DELETE', '', '', 9, 0, 'sublet-middle', NULL, 1640316151127, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (125, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/12', 'DELETE', '', '', 11, 0, 'sublet-middle', NULL, 1640316329124, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (126, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/11', 'DELETE', '', '', 9, 0, 'sublet-middle', NULL, 1640316333151, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (127, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/10', 'DELETE', '', '', 9, 0, 'sublet-middle', NULL, 1640316347777, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (128, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/9', 'DELETE', '', '', 9, 0, 'sublet-middle', NULL, 1640316351415, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (129, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/8', 'DELETE', '', '', 10, 0, 'sublet-middle', NULL, 1640316353375, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (130, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/12', 'DELETE', '', '', 10, 0, 'sublet-middle', NULL, 1640316495110, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (131, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/8', 'DELETE', '', '', 10, 0, 'sublet-middle', NULL, 1640316808900, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (132, '管理端删除评论', '127.0.0.1', '/sublet-post/comment/middle/8', 'DELETE', '', '', 8, 0, 'sublet-middle', NULL, 1640316900467, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (133, '用户注册', '127.0.0.1', '/sublet-user/user', 'POST', '{\"username\":\"sublet\",\"email\":\"sublet@qq.com\",\"password\":\"sublet123456\"}', '', 105, 0, 'sublet-middle', NULL, 1640677826061, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (134, '新增角色', '127.0.0.1', '/sublet-user/role', 'POST', '{\"roleName\":\"体验用户\",\"roleCode\":\"ROLE_VISITOR\",\"roleDesc\":\"体验用户\",\"authorityIds\":[8,38,7,26,25,37,24,36,29,32,31,33,2,20,6,3,34,9,11,35,10,39,21,23]}', '', 83, 0, 'sublet-middle', NULL, 1640678062712, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (135, '给用户分配角色', '127.0.0.1', '/sublet-user/userRoleRel/role', 'POST', '{\"userId\":\"a9844c981ff23ab03bed6b076ee5b79a\",\"roleIds\":[1,17]}', '', 20, 0, 'sublet-middle', NULL, 1640678331915, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (136, '前台用户修改自己的用户信息', '127.0.0.1', '/sublet-user/user', 'PUT', '{\"createBy\":\"admin\",\"createTime\":1640677826081,\"updateBy\":null,\"updateTime\":null,\"userId\":\"a9844c981ff23ab03bed6b076ee5b79a\",\"username\":\"sublet\",\"avatar\":\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/9cd5b0077655413db6aeec31edb4780f.jpg\",\"email\":\"sublet@qq.com\",\"lastLoginTime\":null,\"lockFlag\":0,\"delFlag\":0}', '', 15, 0, 'sublet-middle', NULL, 1640678412897, 0x7375626C6574, NULL, NULL);
INSERT INTO `sys_log` VALUES (137, '新增标签', '127.0.0.1', '/sublet-post/label', 'POST', '{\"labelName\":\"精装\"}', '', 42, 0, 'sublet-middle', NULL, 1640690873531, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (138, '新增标签', '127.0.0.1', '/sublet-post/label', 'POST', '{\"labelName\":\"近地铁\"}', '', 9, 0, 'sublet-middle', NULL, 1640690881007, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (139, '发布转租信息', '0:0:0:0:0:0:0:1', '/sublet-post/sublet-info', 'POST', '{\n  \"address\": \"真功夫总部大楼\",\n  \"city\": \"广州\",\n  \"description\": \"采光非常好\",\n  \"district\": \"南沙区\",\n  \"images\": [\n    \"aaa\"\n  ],\n  \"labels\": [\n    1,6\n  ],\n  \"monthlyRent\": 1600,\n  \"province\": \"广东省\",\n  \"street\": \"南沙街道\"\n}', '', 135, 1, 'sublet-middle', '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'user_id\' doesn\'t have a default value\r\n### The error may exist in com/wrh/sublet/post/biz/mapper/SubletInfoMapper.java (best guess)\r\n### The error may involve com.wrh.sublet.post.biz.mapper.SubletInfoMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO sublet_info  ( sublet_info_id, description,  address, province, city, district, street,   status, lock_flag,  create_time,  create_by, update_by )  VALUES  ( ?, ?,  ?, ?, ?, ?, ?,   ?, ?,  ?,  ?, ? )\r\n### Cause: java.sql.SQLException: Field \'user_id\' doesn\'t have a default value\n; Field \'user_id\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'user_id\' doesn\'t have a default value', 1640691304716, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (140, '发布转租信息', '0:0:0:0:0:0:0:1', '/sublet-post/sublet-info', 'POST', '{\n  \"address\": \"真功夫总部大楼\",\n  \"city\": \"广州\",\n  \"description\": \"采光非常好\",\n  \"district\": \"南沙区\",\n  \"images\": [\n    \"aaa\"\n  ],\n  \"labels\": [\n    1,6\n  ],\n  \"monthlyRent\": 1600,\n  \"province\": \"广东省\",\n  \"street\": \"南沙街道\"\n}', '', 48, 0, 'sublet-middle', NULL, 1640691523217, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (141, '新增标签', '127.0.0.1', '/sublet-post/label', 'POST', '{\"labelName\":\"两室一厅\"}', '', 73, 0, 'sublet-middle', NULL, 1640691750326, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (142, '发布转租信息', '0:0:0:0:0:0:0:1', '/sublet-post/sublet-info', 'POST', '{\n  \"address\": \"碧桂园海湾1号32层3201\",\n  \"city\": \"广州市\",\n  \"description\": \"南北通透，1月份可转\",\n  \"district\": \"南沙区\",\n  \"images\": [\n    \"aaa\"\n  ],\n \"area\":76,\n  \"labels\": [\n    7,8\n  ],\n  \"monthlyRent\": 1500,\n  \"province\": \"广东省\",\n  \"street\": \"南沙街道\"\n}', '', 50, 0, 'sublet-middle', NULL, 1640691947066, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (143, '发布转租信息', '0:0:0:0:0:0:0:1', '/sublet-post/sublet-info', 'POST', '{\n  \"address\": \"碧桂园海湾1号32层3201\",\n  \"city\": \"广州市\",\n  \"description\": \"南北通透，1月份可转\",\n  \"district\": \"南沙区\",\n  \"images\": [\n    \"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/e4a08b8234d34fdc87bbf2a9ca83cab3.JPG\",\n   \"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/610634b93df24cd58e583861f2507bf4.JPG\",\n\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/d3ad8dc87efe4fd9a25487bf663cf44e.JPG\",\n\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/54ba54265d5f450a8e548c73ff32f8fc.JPG\"\n],\n \"area\":76,\n  \"labels\": [\n    7,8\n  ],\n  \"monthlyRent\": 1500,\n  \"province\": \"广东省\",\n  \"street\": \"南沙街道\"\n}', '', 77, 0, 'sublet-middle', NULL, 1640693047830, 0x7375626C6574, NULL, NULL);
INSERT INTO `sys_log` VALUES (144, '发布转租信息', '0:0:0:0:0:0:0:1', '/sublet-post/sublet-info', 'POST', '{\n  \"address\": \"真功夫总部大楼公寓403\",\n  \"city\": \"广州市\",\n  \"description\": \"采光很好，环境干净，没有噪音，住起来很舒服\",\n  \"district\": \"南沙区\",\n  \"images\": [\n    \"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/0c0b94fbad76436db805df26d390a493.JPG\",\n   \"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/a1948c081e6241c8a579eae95ccf08a4.JPG\",\n\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/9b72756ba68b474ab0023e7809e979fb.JPG\",\n\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/da8d9098813d4396861a587556a6557f.JPG\",\n\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/3b21ffd2038d472e8a905569dc9a0925.JPG\",\n\"http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/5d9f655fe0714028a45b7a67874ebf6f.JPG\"\n],\n \"area\":45,\n  \"labels\": [\n    1,6\n  ],\n  \"monthlyRent\": 1600,\n  \"province\": \"广东省\",\n  \"street\": \"南沙街道\"\n}', '', 27, 0, 'sublet-middle', NULL, 1640693459360, 0x7375626C6574, NULL, NULL);
INSERT INTO `sys_log` VALUES (145, '发布转租信息', '0:0:0:0:0:0:0:1', '/sublet-post/sublet-info', 'POST', '{\n  \"address\": \"真功夫总部大楼公寓403\",\n  \"city\": \"广州市\",\n  \"description\": \"aaaaa\",\n  \"district\": \"南沙区\",\n  \"images\": [\n],\n \"area\":45,\n  \"labels\": [\n    1,6\n  ],\n  \"monthlyRent\": 1600,\n  \"province\": \"广东省\",\n  \"street\": \"南沙街道\"\n}', '', 11, 0, 'sublet-middle', NULL, 1640693643552, 0x7375626C6574, NULL, NULL);
INSERT INTO `sys_log` VALUES (146, '禁用违规帖子', '127.0.0.1', '/sublet-post/sublet-info/lock/ebd983487f2234fc5d2a2db932612f4b', 'PUT', '', '', 13, 0, 'sublet-middle', NULL, 1640693776058, 0x7375626C6574, NULL, NULL);
INSERT INTO `sys_log` VALUES (147, '发布转租信息', '0:0:0:0:0:0:0:1', '/sublet-post/sublet-info', 'POST', '{\n  \"address\": \"真功夫总部大楼公寓403\",\n  \"city\": \"广州市\",\n  \"description\": \"aaaaa\",\n  \"district\": \"南沙区\",\n \"area\":45,\n  \"labels\": [\n    1,6\n  ],\n  \"monthlyRent\": 1600,\n  \"province\": \"广东省\",\n  \"street\": \"南沙街道\"\n}', '', 70, 0, 'sublet-middle', NULL, 1640742577081, 0x61646D696E, NULL, NULL);
INSERT INTO `sys_log` VALUES (148, '发布转租信息', '0:0:0:0:0:0:0:1', '/sublet-post/sublet-info', 'POST', '{\n  \"address\": \"真功夫总部大楼公寓403\",\n  \"city\": \"广州市\",\n  \"description\": \"aaaaa\",\n  \"district\": \"南沙区\",\n \"area\":45,\n  \"labels\": [\n    1,6\n  ],\n  \"monthlyRent\": 1600,\n  \"province\": \"广东省\",\n  \"street\": \"南沙街道\"\n}', '', 83, 0, 'sublet-middle', NULL, 1640742752406, 0x61646D696E, NULL, NULL);

-- ----------------------------
-- Table structure for track_file
-- ----------------------------
DROP TABLE IF EXISTS `track_file`;
CREATE TABLE `track_file`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文件名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '路径',
  `bucket_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '容器名称',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文件类型',
  `file_size` double NULL DEFAULT NULL COMMENT '文件大小',
  `del_flag` bigint(0) NULL DEFAULT NULL COMMENT '删除标志',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '添加者',
  `create_time` bigint(0) NULL DEFAULT NULL COMMENT '添加时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新者',
  `update_time` bigint(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of track_file
-- ----------------------------
INSERT INTO `track_file` VALUES (1, 'e4e62df0b5f946faa95cd19a1dd9f28f.png', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-11-11/e4e62df0b5f946faa95cd19a1dd9f28f.png', 'xmcnhol', 'png', 15377, NULL, 'wuruihao', 1636631218391, 'wuruihao', 1636631218391);
INSERT INTO `track_file` VALUES (2, '2021-12-14/e56f90a73f2b4c56bafe0214ed57bd76.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-14/e56f90a73f2b4c56bafe0214ed57bd76.jpg', 'xmcnhol', 'jpg', 15751, NULL, 'admin', 1639487894232, NULL, NULL);
INSERT INTO `track_file` VALUES (3, '2021-12-14/42a2d29f2c4d43c2b66daf2715f61744.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-14/42a2d29f2c4d43c2b66daf2715f61744.jpg', 'xmcnhol', 'jpg', 15751, NULL, 'admin', 1639490204895, NULL, NULL);
INSERT INTO `track_file` VALUES (4, '2021-12-14/3835f53efcae4b3787f78d2ffd71fa74.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-14/3835f53efcae4b3787f78d2ffd71fa74.jpg', 'xmcnhol', 'jpg', 15751, NULL, 'admin', 1639490665780, NULL, NULL);
INSERT INTO `track_file` VALUES (5, '2021-12-14/68dcebac922a45fcaa9c1967be4e559e.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-14/68dcebac922a45fcaa9c1967be4e559e.jpg', 'xmcnhol', 'jpg', 15751, NULL, 'admin', 1639490708661, NULL, NULL);
INSERT INTO `track_file` VALUES (6, '2021-12-14/21bceb766fa14bd5858658b0cea71b2a.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-14/21bceb766fa14bd5858658b0cea71b2a.jpg', 'xmcnhol', 'jpg', 15751, NULL, 'admin', 1639491252794, NULL, NULL);
INSERT INTO `track_file` VALUES (7, '2021-12-15/46eefd8481a74d99b9c6349a0fbda290.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-15/46eefd8481a74d99b9c6349a0fbda290.jpg', 'xmcnhol', 'jpg', 15751, NULL, 'admin', 1639531904689, NULL, NULL);
INSERT INTO `track_file` VALUES (8, '2021-12-15/fd6d2c062625498bb25255cd8989e2b7.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-15/fd6d2c062625498bb25255cd8989e2b7.jpg', 'xmcnhol', 'jpg', 15751, NULL, 'admin', 1639533172626, NULL, NULL);
INSERT INTO `track_file` VALUES (9, '2021-12-20/399c289e2cc54919b7d2d86994896d18.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-20/399c289e2cc54919b7d2d86994896d18.jpg', 'xmcnhol', 'jpg', 325430, NULL, 'admin', 1639968539259, NULL, NULL);
INSERT INTO `track_file` VALUES (10, '2021-12-20/2792aa76c2854124a8cb6c248168cfdb.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-20/2792aa76c2854124a8cb6c248168cfdb.jpg', 'xmcnhol', 'jpg', 325430, NULL, 'admin', 1639968797796, NULL, NULL);
INSERT INTO `track_file` VALUES (11, '2021-12-20/14443b9b6b06448a86660cff61f61a1a.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-20/14443b9b6b06448a86660cff61f61a1a.jpg', 'xmcnhol', 'jpg', 325430, NULL, 'admin', 1639968878008, NULL, NULL);
INSERT INTO `track_file` VALUES (12, '2021-12-20/5236ba8a70a242088988003e2c01439f.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-20/5236ba8a70a242088988003e2c01439f.jpg', 'xmcnhol', 'jpg', 55524, NULL, 'admin', 1639970993157, NULL, NULL);
INSERT INTO `track_file` VALUES (13, '2021-12-20/e05e06bb873a4a118db191167cd133fa.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-20/e05e06bb873a4a118db191167cd133fa.jpg', 'xmcnhol', 'jpg', 55524, NULL, 'admin', 1639971095452, NULL, NULL);
INSERT INTO `track_file` VALUES (14, '2021-12-20/3234743e3ddd443c9a1ec4b287e42a75.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-20/3234743e3ddd443c9a1ec4b287e42a75.jpg', 'xmcnhol', 'jpg', 55524, NULL, 'admin', 1639971563438, NULL, NULL);
INSERT INTO `track_file` VALUES (15, '2021-12-20/dbeca903def34973b415799fe5355c04.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-20/dbeca903def34973b415799fe5355c04.jpg', 'xmcnhol', 'jpg', 55524, NULL, 'admin', 1639980011194, NULL, NULL);
INSERT INTO `track_file` VALUES (16, '2021-12-20/8b82643393f9400caa1439e8f9209ff1.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-20/8b82643393f9400caa1439e8f9209ff1.jpg', 'xmcnhol', 'jpg', 15751, NULL, 'admin', 1639980895853, NULL, NULL);
INSERT INTO `track_file` VALUES (17, '2021-12-21/f5dc5326015f48f1af34a82250072a5b.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-21/f5dc5326015f48f1af34a82250072a5b.jpg', 'xmcnhol', 'jpg', 55524, NULL, 'test', 1640068392230, NULL, NULL);
INSERT INTO `track_file` VALUES (18, '2021-12-28/b398fff8bb214cb08a48c432a359fc43.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/b398fff8bb214cb08a48c432a359fc43.jpg', 'xmcnhol', 'jpg', 60951, NULL, 'sublet', 1640678372591, NULL, NULL);
INSERT INTO `track_file` VALUES (19, '2021-12-28/ce93113c85f14a7389f4487600770160.png', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/ce93113c85f14a7389f4487600770160.png', 'xmcnhol', 'png', 68843, NULL, 'sublet', 1640678390373, NULL, NULL);
INSERT INTO `track_file` VALUES (20, '2021-12-28/9cd5b0077655413db6aeec31edb4780f.jpg', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/9cd5b0077655413db6aeec31edb4780f.jpg', 'xmcnhol', 'jpg', 60951, NULL, 'sublet', 1640678409040, NULL, NULL);
INSERT INTO `track_file` VALUES (21, '2021-12-28/0c0b94fbad76436db805df26d390a493.JPG', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/0c0b94fbad76436db805df26d390a493.JPG', 'xmcnhol', 'JPG', 191562, NULL, 'sublet', 1640692689299, NULL, NULL);
INSERT INTO `track_file` VALUES (22, '2021-12-28/a1948c081e6241c8a579eae95ccf08a4.JPG', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/a1948c081e6241c8a579eae95ccf08a4.JPG', 'xmcnhol', 'JPG', 104068, NULL, 'sublet', 1640692780734, NULL, NULL);
INSERT INTO `track_file` VALUES (23, '2021-12-28/9b72756ba68b474ab0023e7809e979fb.JPG', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/9b72756ba68b474ab0023e7809e979fb.JPG', 'xmcnhol', 'JPG', 113528, NULL, 'sublet', 1640692801610, NULL, NULL);
INSERT INTO `track_file` VALUES (24, '2021-12-28/da8d9098813d4396861a587556a6557f.JPG', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/da8d9098813d4396861a587556a6557f.JPG', 'xmcnhol', 'JPG', 126229, NULL, 'sublet', 1640692827575, NULL, NULL);
INSERT INTO `track_file` VALUES (25, '2021-12-28/3b21ffd2038d472e8a905569dc9a0925.JPG', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/3b21ffd2038d472e8a905569dc9a0925.JPG', 'xmcnhol', 'JPG', 120118, NULL, 'sublet', 1640692848973, NULL, NULL);
INSERT INTO `track_file` VALUES (26, '2021-12-28/5d9f655fe0714028a45b7a67874ebf6f.JPG', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/5d9f655fe0714028a45b7a67874ebf6f.JPG', 'xmcnhol', 'JPG', 73993, NULL, 'sublet', 1640692869618, NULL, NULL);
INSERT INTO `track_file` VALUES (27, '2021-12-28/e4a08b8234d34fdc87bbf2a9ca83cab3.JPG', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/e4a08b8234d34fdc87bbf2a9ca83cab3.JPG', 'xmcnhol', 'JPG', 82050, NULL, 'sublet', 1640692916849, NULL, NULL);
INSERT INTO `track_file` VALUES (28, '2021-12-28/610634b93df24cd58e583861f2507bf4.JPG', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/610634b93df24cd58e583861f2507bf4.JPG', 'xmcnhol', 'JPG', 83896, NULL, 'sublet', 1640692941308, NULL, NULL);
INSERT INTO `track_file` VALUES (29, '2021-12-28/d3ad8dc87efe4fd9a25487bf663cf44e.JPG', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/d3ad8dc87efe4fd9a25487bf663cf44e.JPG', 'xmcnhol', 'JPG', 75686, NULL, 'sublet', 1640692960792, NULL, NULL);
INSERT INTO `track_file` VALUES (30, '2021-12-28/54ba54265d5f450a8e548c73ff32f8fc.JPG', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/54ba54265d5f450a8e548c73ff32f8fc.JPG', 'xmcnhol', 'JPG', 80768, NULL, 'sublet', 1640692976345, NULL, NULL);
INSERT INTO `track_file` VALUES (31, '2021-12-28/26b4b8e12552450fbc61606b7034a532.png', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/26b4b8e12552450fbc61606b7034a532.png', 'xmcnhol', 'png', 118574, NULL, 'sublet', 1640694201280, NULL, NULL);
INSERT INTO `track_file` VALUES (32, '2021-12-28/1ae5189a43cf401dbd113b29cb17819b.png', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/1ae5189a43cf401dbd113b29cb17819b.png', 'xmcnhol', 'png', 1311303, NULL, 'sublet', 1640694553411, NULL, NULL);
INSERT INTO `track_file` VALUES (33, '2021-12-28/705da3f2fb474880992a18fd2b6e7765.png', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/705da3f2fb474880992a18fd2b6e7765.png', 'xmcnhol', 'png', 115544, NULL, 'sublet', 1640694615330, NULL, NULL);
INSERT INTO `track_file` VALUES (34, '2021-12-28/085bb5be6cd74446b36b663ddea042aa.png', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/085bb5be6cd74446b36b663ddea042aa.png', 'xmcnhol', 'png', 121531, NULL, 'sublet', 1640694728111, NULL, NULL);
INSERT INTO `track_file` VALUES (35, '2021-12-28/62f4492bdefb449c8c0546d19c57c0cd.png', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/62f4492bdefb449c8c0546d19c57c0cd.png', 'xmcnhol', 'png', 96160, NULL, 'sublet', 1640694772187, NULL, NULL);
INSERT INTO `track_file` VALUES (36, '2021-12-28/a76ac71f74cf4f529b699534d8f2a157.png', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/a76ac71f74cf4f529b699534d8f2a157.png', 'xmcnhol', 'png', 137015, NULL, 'sublet', 1640694822180, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头像',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',
  `create_time` bigint(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_login_time` bigint(0) NULL DEFAULT NULL COMMENT '最后一次登录时间',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '编辑者',
  `update_time` bigint(0) NULL DEFAULT NULL COMMENT '更新时间',
  `lock_flag` int(0) NULL DEFAULT NULL COMMENT '锁定标志',
  `del_flag` int(0) NULL DEFAULT NULL COMMENT '删除标志',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('50218adee043c01d6abb5de0e7ac4710', 'test1', '$2a$10$4z.u2KW8zXfb9Y9C4/7cC.ae.TRBbqJlWNH0GzyzsLjNZfngpsAou', NULL, 'admin', 1639985151654, NULL, 'admin', 1640000487718, 0, 1, 'test1@qq.com');
INSERT INTO `user` VALUES ('a9844c981ff23ab03bed6b076ee5b79a', 'sublet', '$2a$10$D0p0GYkSNuSCmtl.AXJCfezsNZEczm3G3e9QFM1nBBzQ/N7WZbIDu', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-28/9cd5b0077655413db6aeec31edb4780f.jpg', 'admin', 1640677826081, NULL, 'sublet', 1640678412903, 0, 0, 'sublet@qq.com');
INSERT INTO `user` VALUES ('ac34389f9d1bc981d190318e4d4053a9', 'admin', '$2a$10$Ua7.txlguJGw1WX6fhBPPuDu/nfkdPZ/9jPFK0jU7Hc.ahyE7JQ0m', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-20/8b82643393f9400caa1439e8f9209ff1.jpg', 'admin', 1637229857157, NULL, 'admin', 1639983998696, 0, 0, 'admin@qq.com');
INSERT INTO `user` VALUES ('b41159765822c1ef0e196249e34c6534', 'wrh', '$2a$10$xWQXtuwnSFZxnprcCpH91.kQ7HhZy/M7Z6Pitvwljp1ZOsBCgr77e', NULL, NULL, 1634629764399, NULL, 'admin', 1638857609331, 0, 0, '871154786@qq.com');
INSERT INTO `user` VALUES ('b8cdd8ca0d07b157d3f82f03fd278c6f', 'wuruihao1', '$2a$10$xt0LFt7tYQddvnZWd59/KeY/saBVUkrKq.xQzFlMWzq4rMOGFqeCO', NULL, NULL, 1634545517722, NULL, NULL, NULL, 0, 1, '871154785@qq.com');
INSERT INTO `user` VALUES ('e813fa325c0f6a96ca5a5ed486a43bd7', 'test', '$2a$10$Z8KOx91Nf8HhNx8ESknN2OnaY98MFKVqj.sl0lKFkppNT7BWFgpSm', 'http://xmcnhol.oss-cn-shenzhen.aliyuncs.com/2021-12-21/f5dc5326015f48f1af34a82250072a5b.jpg', 'admin', 1639985116051, NULL, 'test', 1640068668073, 0, 0, 'tes123@qq.com');

-- ----------------------------
-- Table structure for user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `user_role_rel`;
CREATE TABLE `user_role_rel`  (
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role_rel
-- ----------------------------
INSERT INTO `user_role_rel` VALUES (1, 'a9844c981ff23ab03bed6b076ee5b79a');
INSERT INTO `user_role_rel` VALUES (17, 'a9844c981ff23ab03bed6b076ee5b79a');
INSERT INTO `user_role_rel` VALUES (15, 'ac34389f9d1bc981d190318e4d4053a9');

SET FOREIGN_KEY_CHECKS = 1;
