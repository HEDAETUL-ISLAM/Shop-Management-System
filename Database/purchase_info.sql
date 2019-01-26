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
-- Table structure for table `purchase_info`
--

CREATE TABLE `purchase_info` (
  `purchase_id` int(255) NOT NULL,
  `amount` double DEFAULT NULL,
  `purchase_date` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_info`
--

INSERT INTO `purchase_info` (`purchase_id`, `amount`, `purchase_date`, `user_id`) VALUES
(33, 50, '2018-08-27', 'c'),
(32, 200, '2018-08-27', 'c'),
(31, 20, '2018-08-25', 'c'),
(30, 20, '2018-08-25', 'c'),
(29, 300, '2018-08-20', 'c'),
(28, 200, '2018-08-20', 'c'),
(27, 100, '2018-08-20', 'c'),
(26, 200, '2018-08-20', 'c'),
(25, 100, '2018-08-20', 'c'),
(24, 100, '2018-08-20', 'c'),
(23, 100, '2018-08-20', 'c'),
(22, 2400, '2018-08-20', 'c'),
(21, 200, '2018-08-20', 'c'),
(20, 100, '2018-08-20', 'c'),
(19, 100, '2018-08-20', 'c'),
(18, 200, '2018-08-20', 'c'),
(34, 50, '2018-08-27', 'c'),
(35, 4000, '2018-08-27', 'c'),
(36, 100, '2018-08-27', 'c'),
(37, 350, '2018-08-27', 'c'),
(38, 50, '2018-08-27', 'c'),
(39, 100, '2018-08-27', 'c'),
(40, 100, '2018-08-27', 'c'),
(41, 350, '2018-08-27', 'c'),
(42, 350, '2018-08-27', 'c'),
(43, 100, '2018-08-28', 'c'),
(44, 100, '2018-08-28', 'c'),
(45, 100, '2018-08-28', 'c'),
(46, 200, '2018-08-28', 'c'),
(47, 200, '2018-08-28', 'c'),
(48, 100, '2018-08-28', 'c');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `purchase_info`
--
ALTER TABLE `purchase_info`
  ADD PRIMARY KEY (`purchase_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `purchase_info`
--
ALTER TABLE `purchase_info`
  MODIFY `purchase_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
