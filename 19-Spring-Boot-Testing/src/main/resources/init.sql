-- ----------------------------
-- Table structure for T_USER
-- ----------------------------
CREATE TABLE T_USER (
   ID int NOT NULL primary key auto_increment,
   USERNAME VARCHAR(20) NOT NULL ,
   PASSWD VARCHAR(128) NOT NULL ,
   CREATE_TIME DATE NULL ,
   STATUS CHAR(1) NOT NULL
);
# alter table t_user change column id  id int(10) not null primary key auto_increment;
-- ----------------------------
-- Records of T_USER
-- ----------------------------
INSERT INTO T_USER VALUES ('2', 'tester', '243e29429b340192700677d48c09d992', date('2017-12-11 17:20:21'), '1');
INSERT INTO T_USER VALUES ('1', 'mrbird', '42ee25d1e43e9f57119a00d0a39e5250', date('2017-12-11 10:52:48'), '1');


select * from t_user;