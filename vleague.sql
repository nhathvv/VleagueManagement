-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 13, 2022 lúc 01:12 PM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `vleague`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `footballplayer`
--

CREATE TABLE `footballplayer` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Age` int(10) NOT NULL,
  `Position` varchar(100) NOT NULL,
  `IDFootballTeam` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `footballplayer`
--

INSERT INTO `footballplayer` (`ID`, `Name`, `Age`, `Position`, `IDFootballTeam`) VALUES
('2', 'Phan Mỹ Linh', 19, 'Hậu vệ', 'HAGL'),
('5', 'Trần Anh Tú', 19, 'Tiền đạo', 'HT'),
('NVN', 'Nguyễn Văn Nam', 19, 'Huấn luyện viên', 'HT'),
('PDH', 'Phan Đức Hải', 22, 'Huấn luyện viên', 'HT'),
('PVD', 'Phan Văn Định', 19, 'Tiền đạo', 'QN'),
('TLink', 'Nguyễn Tiến Linh', 19, 'Hậu vệ', 'HT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `footballteam`
--

CREATE TABLE `footballteam` (
  `ID` varchar(10) NOT NULL,
  `footballname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `quantily` int(10) NOT NULL,
  `founding` date NOT NULL,
  `idimage` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `footballteam`
--

INSERT INTO `footballteam` (`ID`, `footballname`, `quantily`, `founding`, `idimage`) VALUES
('DN', 'Đà Nẵng', 0, '1999-09-23', '9'),
('HAGL', 'Hoàng Anh Gia Lại', 1, '2003-02-03', '1'),
('HN', 'Hà Nội', 0, '2008-11-24', '2'),
('HT', 'Hà Tĩnh', 4, '2000-12-27', '10'),
('KKK', 'VKU', 0, '2022-12-01', '8'),
('L', 'lINH', 0, '2022-11-11', '11'),
('QN', 'Quảng Ninh', 1, '2010-10-20', '4'),
('VT', 'Viettel', 0, '2000-12-27', '3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `schedule`
--

CREATE TABLE `schedule` (
  `ID` int(10) NOT NULL,
  `Date` date NOT NULL,
  `Time` varchar(20) NOT NULL,
  `FootballTeam1` varchar(20) NOT NULL,
  `FootballTeam2` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `schedule`
--

INSERT INTO `schedule` (`ID`, `Date`, `Time`, `FootballTeam1`, `FootballTeam2`) VALUES
(1, '2022-11-11', '16:30', 'HN', 'HT'),
(2, '2022-04-27', '18:00', 'DN', 'HAGL'),
(3, '2022-02-03', '2022-10-22', 'QN', 'HAGL'),
(4, '2022-11-11', '12:00', 'VT', 'HN'),
(6, '2022-11-11', '13:00', 'KKK', 'HT');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `footballplayer`
--
ALTER TABLE `footballplayer`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `footballteam`
--
ALTER TABLE `footballteam`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
