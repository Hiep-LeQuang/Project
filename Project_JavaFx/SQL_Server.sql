create database Project
use Project

CREATE TABLE Brand(
	brandID INT PRIMARY KEY  AUTO_INCREMENT,
	brand VARCHAR(255) NOT NULL
);
create table Category(
	categoryID int PRIMARY KEY  AUTO_INCREMENT,
	categoryName varchar(255)
);
CREATE TABLE Car(
	carID INT PRIMARY KEY  AUTO_INCREMENT,
	carName VARCHAR(255) NOT NULL,
	yearOfManufacture date NOT NULL,
	price INT NOT NULL,
	seat int null,
	fuelUsed varchar(50) null,
	gear varchar(50) NULL,
	glasses varchar(100) not null,
	brandID INT,
	categoryID int

);
CREATE TABLE Color(
	colorID int PRIMARY KEY  AUTO_INCREMENT,
	color VARCHAR(100) NOT NULL
);

CREATE TABLE CarColor(
	carID INT,
	colorID INT,
	PRIMARY KEY(carID,colorID) 
);

CREATE TABLE Contract(
	contractID INT PRIMARY KEY  AUTO_INCREMENT,
	customerID int,
	price INT NOT NULL,
	dateOfSale DATETIME NOT NULL,
	status int not null,
	deposits int not null,
	productReceiptDate DATE NOT NULL,
	accountant varchar(50) not null,
	CarID int,
	colorID INT,
	note varchar(255)
);

CREATE TABLE Customer(
	customerID INT PRIMARY KEY  AUTO_INCREMENT,
	customerName VARCHAR(255) NOT NULL,
	phone INT not null,
	address VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL
);

CREATE TABLE `Account`(
	accountID INT PRIMARY KEY  AUTO_INCREMENT,
	userName varchar(20),
	`password` varchar(16),
	`name`VARCHAR(100),
	phone INT,
	email VARCHAR(100)
	
);

ALTER TABLE Car
ADD CONSTRAINT FK_Car_Brand FOREIGN KEY (brandID) REFERENCES Brand(brandID);

ALTER TABLE Car
ADD CONSTRAINT PK_Car_Category FOREIGN KEY (categoryID) REFERENCES Category(categoryID);

ALTER TABLE CarColor
ADD CONSTRAINT PK_CarColor_Car FOREIGN KEY (carID) REFERENCES Car(carID);

ALTER TABLE CarColor
ADD CONSTRAINT PK_CarColor_Color FOREIGN KEY (colorID) REFERENCES Color(colorID);

ALTER TABLE Contract
ADD CONSTRAINT PK_Contract_Car FOREIGN KEY (CarID) REFERENCES Car(CarID);

ALTER TABLE Contract
ADD CONSTRAINT PK_Contract_Customer FOREIGN KEY (customerID) REFERENCES Customer(customerID);

