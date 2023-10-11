# webpage
CREATE DATABASE BBS; 
use bbs;

crate table user(
userID  VARCHAR(20),
userPassword VARCHAR(20),
userName VARCHAR(20),
userGender VARCHAR(20),
userEmail VARCHAR(50),
primary key (userID)
);
INSERT INTO USER VALUES('injongbai', '123456'  , '인정배', '남','injongbai@naver.com');


crate table bbs(
bbsID int,

bbsTitle VARCHAR(50), 

userID VARCHAR(20),

bbsDate Datetime,

bbsContent varchar(4096),

bbsAvailable INT,

primary key (bbsID)
​
