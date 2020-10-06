create database if not exists week6;
use week6;

drop table if exists member_v;

CREATE TABLE member_v (
    id           INT NOT NULL AUTO_INCREMENT,
    username     VARCHAR(16)   NOT NULL,
    pwd          VARCHAR(255)  NOT NULL,
    full_name    VARCHAR(255) NOT NULL,
    PRIMARY KEY(id),
    UNIQUE  (username)
);

INSERT INTO member_v (username, pwd, full_name) VALUES ('apple', 'apple123', 'Apple Ang');
INSERT INTO member_v (username, pwd, full_name) VALUES ('orange', 'orange123', 'Orange Ong');
