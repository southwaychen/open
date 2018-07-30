BEGIN;
INSERT INTO `sys_admin` VALUES ('c7bbca94e4464ab280a9504df9bdf2da', 'admin', '$2a$10$vg5QNHhCknAqevx9vM2s5esllJEzF/pa8VZXtFYHhhOhUcCw/GWyS', null, '17034642111', null, '1', '2018-04-20 07:15:18', '2018-05-11 17:12:00', '0');
COMMIT;

BEGIN;
INSERT INTO `sys_role` VALUES ('79d819f8552e430cb2b217e9a119c232', 'admin', 'ROLE_ADMIN', '超级管理员', '2017-10-29 15:45:51', '2018-04-22 11:40:29', '0');
COMMIT;

BEGIN;
INSERT INTO `sys_menu` VALUES ('b8bbca94e4464ab280a9504df9bdf2ce', '系统管理', null, '/admin', null, null, '-1', 'icon-xitongguanli','1', '0', '2017-11-07 20:56:00', '2018-05-14 21:53:22', '0');
COMMIT;

BEGIN;
INSERT INTO `sys_role_menu` VALUES ('79d819f8552e430cb2b217e9a119c232', 'b8bbca94e4464ab280a9504df9bdf2ce','2017-11-07 20:56:00', '2018-05-14 21:53:22', '0');
COMMIT;