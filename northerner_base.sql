CREATE DATABASE northerner_base;
USE northerner_base;

CREATE TABLE user(
user_Id INT AUTO_INCREMENT PRIMARY KEY,
user_Name VARCHAR(20) UNIQUE NOT NULL,
password VARCHAR(20) NOT NULL
);

CREATE TABLE tools(
tool_Id INT AUTO_INCREMENT PRIMARY KEY,
tool_Name varchar(20) UNIQUE NOT NULL
);

CREATE TABLE ruleBook(
book_Id INT AUTO_INCREMENT PRIMARY KEY,
book_Name varchar(50) UNIQUE NOT NULL,
version float NOT NULL
);

CREATE TABLE mini(
mini_Id INT AUTO_INCREMENT PRIMARY KEY,
model_Name varchar(20) UNIQUE NOT NULL,
base_Size INT NOT NULL,
points INT NOT NULL,
faction varchar(20)
);

CREATE TABLE inventory(
inventory_Id INT AUTO_INCREMENT PRIMARY KEY,
user_Id INT NOT NULL,
FOREIGN KEY(user_Id) REFERENCES user(user_Id)  
);

CREATE TABLE chapter(
chapter_Id INT AUTO_INCREMENT PRIMARY KEY, 
book_Id INT NOT NULL,
chapter_Name varchar(20) UNIQUE NOT NULL,
FOREIGN KEY(book_Id) REFERENCES ruleBook(book_Id)
);
inventoryinventory
CREATE TABLE inventory_Mini(
inventory_Id INT,
mini_Id INT,
PRIMARY KEY(inventory_Id,mini_Id),
FOREIGN KEY(inventory_Id) REFERENCES inventory(inventory_Id),
FOREIGN KEY(mini_Id) REFERENCES mini(mini_Id)
);
