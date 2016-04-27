-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2016 at 10:33 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toba`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `Id` int(10) NOT NULL,
  `username` varchar(40) NOT NULL,
  `balance` double NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Id`, `username`, `balance`, `type`) VALUES
(1, 'jsmith@toba.com', 200, 'Checking'),
(2, 'jsmith@toba.com', 360, 'Savings'),
(3, 'wesly', 0, 'Checking'),
(4, 'wesly', 25, 'Savings');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `account` int(11) NOT NULL,
  `amount` double NOT NULL,
  `type` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `account`, `amount`, `type`, `time`) VALUES
(1, 2, 20, 'Credit', '26/04/2016'),
(2, 1, 200, 'Credit', '26/04/2016'),
(3, 1, 200, 'Credit', '26/04/2016'),
(4, 2, 40, 'Debit', '26/04/2016'),
(5, 2, 200, 'Credit', '26/04/2016');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(10) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `firstname` varchar(40) NOT NULL,
  `lastname` varchar(40) NOT NULL,
  `address` varchar(60) NOT NULL,
  `phno` varchar(20) NOT NULL,
  `city` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `firstname`, `lastname`, `address`, `phno`, `city`, `state`, `email`) VALUES
(1, 'jsmith@toba.com', 'welcome1', 'jsmith', 'smith', 'ASDD', 'ASD', 'ASD', 'ASD', 'ASD'),
(6, 'wesly', 'welcome1', 'ad', 'as', 'asd', 'ad', 'asd', 'as', 'ad');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
