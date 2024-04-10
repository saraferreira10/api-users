CREATE DATABASE users_db;

USE users_db;

CREATE TABLE users (
	username VARCHAR(50) PRIMARY KEY NOT NULL,
    password VARCHAR(50) NOT NULL,
	enabled TINYINT NOT NULL
);

INSERT INTO users VALUES ("john", "{noop}john123", 1),
("mary", "{noop}mary123", 1),
("susan", "{noop}susan123", 1);

CREATE TABLE authorities (
	username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
	UNIQUE KEY authorities_idx_1 (username, authority),
    CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO authorities VALUES ("john", "ROLE_EMPLOYEE"),
("mary", "ROLE_EMPLOYEE"),
("mary", "ROLE_MANAGER"),
("susan", "ROLE_EMPLOYEE"),
("susan", "ROLE_MANAGER"),
("susan", "ROLE_ADMIN");
