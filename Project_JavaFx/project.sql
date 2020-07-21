-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 21, 2020 lúc 02:17 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `project`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `accountID` int(11) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(16) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` int(11) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`accountID`, `userName`, `password`, `name`, `phone`, `email`) VALUES
(1, 'admin', 'abcdefghik', 'Vũ Toàn Phong', 915021999, 'phongvt@gmail.com'),
(2, 'admin1', 'asdfghjkl', 'Nguyễn Thị Xuân', 326585858, 'xuannguyen@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `brand`
--

CREATE TABLE `brand` (
  `brandID` int(11) NOT NULL,
  `brand` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `brand`
--

INSERT INTO `brand` (`brandID`, `brand`) VALUES
(1, 'Toyota'),
(2, 'Hyundai');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `car`
--

CREATE TABLE `car` (
  `carID` int(11) NOT NULL,
  `sku` varchar(5) NOT NULL,
  `carName` varchar(255) NOT NULL,
  `yearOfManufacture` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `seat` int(11) NOT NULL,
  `fuelUsed` varchar(50) NOT NULL,
  `gear` varchar(50) NOT NULL,
  `brandID` int(11) NOT NULL,
  `categoryID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `car`
--

INSERT INTO `car` (`carID`, `sku`, `carName`, `yearOfManufacture`, `price`, `seat`, `fuelUsed`, `gear`, `brandID`, `categoryID`) VALUES
(1, 'OTO01', 'Camry', 2020, 1000000000, 4, 'diesel', 'Tự động', 1, 1),
(2, 'OTO02', 'Elantra', 2019, 550000000, 4, 'Xăng', 'Bán tự động', 2, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `carcolor`
--

CREATE TABLE `carcolor` (
  `carID` int(11) NOT NULL,
  `colorID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `carcolor`
--

INSERT INTO `carcolor` (`carID`, `colorID`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `categoryID` int(11) NOT NULL,
  `categoryName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`categoryID`, `categoryName`) VALUES
(1, 'Xe Con'),
(2, 'Bán Tải');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `color`
--

CREATE TABLE `color` (
  `colorID` int(11) NOT NULL,
  `color` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `color`
--

INSERT INTO `color` (`colorID`, `color`) VALUES
(1, 'Xanh'),
(2, 'Trắng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `contract`
--

CREATE TABLE `contract` (
  `contractID` int(11) NOT NULL,
  `customerID` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `dateOfSale` datetime NOT NULL,
  `status` int(11) NOT NULL,
  `deposits` int(11) NOT NULL,
  `productReceiptDate` date NOT NULL,
  `accountant` varchar(50) NOT NULL,
  `CarID` int(11) NOT NULL,
  `colorID` int(11) NOT NULL,
  `note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `contract`
--

INSERT INTO `contract` (`contractID`, `customerID`, `price`, `dateOfSale`, `status`, `deposits`, `productReceiptDate`, `accountant`, `CarID`, `colorID`, `note`) VALUES
(1, 1, 850000000, '2020-07-19 08:00:00', 0, 450000000, '2020-07-25', 'Lê Thu Thủy', 1, 0, ''),
(2, 2, 1000000000, '2020-11-05 17:00:00', 1, 560000000, '2020-06-17', 'Bùi Như Lạc', 2, 0, '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `customerID` int(11) NOT NULL,
  `customerName` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`customerID`, `customerName`, `phone`, `address`, `email`) VALUES
(1, 'Hoàng Gia Bảo', 985113113, 'Nam Định', 'giabao@gmail.com'),
(2, 'Cao Kiên Trung', 989565656, 'Hà Nội', 'trungkc@gmail.com');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`accountID`);

--
-- Chỉ mục cho bảng `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`brandID`);

--
-- Chỉ mục cho bảng `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`carID`),
  ADD KEY `FK_Car_Brand` (`brandID`),
  ADD KEY `PK_Car_Category` (`categoryID`);

--
-- Chỉ mục cho bảng `carcolor`
--
ALTER TABLE `carcolor`
  ADD PRIMARY KEY (`carID`,`colorID`),
  ADD KEY `PK_CarColor_Color` (`colorID`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryID`);

--
-- Chỉ mục cho bảng `color`
--
ALTER TABLE `color`
  ADD PRIMARY KEY (`colorID`);

--
-- Chỉ mục cho bảng `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`contractID`),
  ADD KEY `PK_Contract_Car` (`CarID`),
  ADD KEY `PK_Contract_Customer` (`customerID`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `accountID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `brand`
--
ALTER TABLE `brand`
  MODIFY `brandID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `car`
--
ALTER TABLE `car`
  MODIFY `carID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `categoryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `color`
--
ALTER TABLE `color`
  MODIFY `colorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `contract`
--
ALTER TABLE `contract`
  MODIFY `contractID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `customerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `FK_Car_Brand` FOREIGN KEY (`brandID`) REFERENCES `brand` (`brandID`),
  ADD CONSTRAINT `PK_Car_Category` FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryID`);

--
-- Các ràng buộc cho bảng `carcolor`
--
ALTER TABLE `carcolor`
  ADD CONSTRAINT `PK_CarColor_Car` FOREIGN KEY (`carID`) REFERENCES `car` (`carID`),
  ADD CONSTRAINT `PK_CarColor_Color` FOREIGN KEY (`colorID`) REFERENCES `color` (`colorID`);

--
-- Các ràng buộc cho bảng `contract`
--
ALTER TABLE `contract`
  ADD CONSTRAINT `PK_Contract_Car` FOREIGN KEY (`CarID`) REFERENCES `car` (`carID`),
  ADD CONSTRAINT `PK_Contract_Customer` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
