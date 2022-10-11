SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS app_user;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE category (
categoryid BIGINT NOT NULL AUTO_INCREMENT,
categoryname VARCHAR(50) NOT NULL,
PRIMARY KEY (categoryid));

INSERT INTO category (categoryname)
VALUES ("Thriller"), ("Novel"), ("Sci-Fi"), ("Classics");

CREATE TABLE book (
id BIGINT NOT NULL AUTO_INCREMENT,
author VARCHAR(50) NOT NULL,
title VARCHAR(50) NOT NULL,
isbn VARCHAR(50) NOT NULL,
book_year INT NOT NULL,
price DOUBLE,
categoryid BIGINT,
PRIMARY KEY (id),
FOREIGN KEY (categoryid) REFERENCES category(categoryid));

INSERT INTO book (title, author, isbn, book_year, price, categoryid)
VALUES ("Ernest Hemingway", "A Farewell to Arms", "1232323-21", 1929, 19.29, 1),
("George Orwell", "Animal Farm", "2212343-5", 1945, 8.90, 2);

CREATE TABLE app_user (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(100) NOT NULL,
lastname VARCHAR(100) NOT NULL,
email VARCHAR(50) NOT NULL,
role VARCHAR(100) NOT NULL,
username VARCHAR(250) NOT NULL,
password_hash VARCHAR(250) NOT NULL);
INSERT INTO app_user (firstname, lastname, email, role, username, password_hash)
VALUES ("Anssi", "Sirkiä", "admin@gmail.com", "ADMIN", "admin", "$2a$10$Xp67oEDHyODcnTzkIIp9z.SpmmpZg33mqZe/jvaSHMnpWtEQGov5e"),
("Kari", "Käyttäjä", "user@usermail.com", "USER", "user", "$2a$10$Rc25Yhstdcr9Ce3WcQFKLeHT3nN1Yr.ud6M0AywXA8Q1tidWcdvqy");