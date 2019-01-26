-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 29, 2018 at 03:58 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `D3`
--

-- --------------------------------------------------------

--
-- Table structure for table `purchase_product`
--

CREATE TABLE `purchase_product` (
  `purchase_id` int(255) NOT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `quantity` int(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_product`
--

INSERT INTO `purchase_product` (`purchase_id`, `product_id`, `quantity`) VALUES
(0, '1234', 2),
(0, '1234', 5),
(0, '1234', 5),
(0, '1235', 6),
(2, '1234', 2),
(2, '1235', 2),
(4, '1234', 1),
(5, '1235', 2),
(6, '1235', 1),
(6, '1235', 1),
(6, '1235', 1),
(7, '1235', 1),
(8, '1235', 1),
(9, '1235', 1),
(10, '1235', 1),
(11, '1235', 1),
(11, '1235', 1),
(11, '1235', 1),
(12, '1235', 1),
(12, '1235', 1),
(12, '1235', 1),
(13, '1235', 1),
(14, '1235', 1),
(15, '1235', 1),
(16, '1235', 1),
(16, '1235', 1),
(17, '1234', 1),
(17, '1234', 1),
(0, '13', 1),
(19, '12', 1),
(19, '12', 1),
(21, '13', 1),
(22, '13', 12),
(23, '12', 1),
(24, '12', 1),
(25, '12', 1),
(26, '13', 1),
(27, '12', 1),
(28, '13', 1),
(29, '13', 1),
(29, '12', 1),
(30, '13', 1),
(30, '13', 1),
(32, '1', 1),
(32, '1', 1),
(33, '3', 1),
(34, '3', 1),
(35, '4', 1),
(36, '1', 1),
(37, '2', 1),
(38, '3', 1),
(38, '3', 1),
(39, '3', 1),
(38, '3', 1),
(39, '3', 1),
(41, '2', 1),
(42, '2', 1),
(43, '3', 1),
(43, '3', 1),
(44, '3', 1),
(44, '3', 1),
(45, '3', 1),
(45, '3', 1),
(46, '1', 1),
(46, '1', 1),
(47, '1', 1),
(47, '1', 1),
(48, '3', 1),
(48, '3', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
