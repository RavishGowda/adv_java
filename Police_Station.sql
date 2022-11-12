-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 12, 2022 at 08:04 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `1MS21CS406`
--

-- --------------------------------------------------------

--
-- Table structure for table `Police_Station`
--

CREATE TABLE `Police_Station` (
  `Area` varchar(50) NOT NULL,
  `Phone_number` int(11) NOT NULL,
  `No_Constables` int(11) NOT NULL,
  `No_of_SI` int(11) NOT NULL,
  `No_of_Criminals` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Police_Station`
--

INSERT INTO `Police_Station` (`Area`, `Phone_number`, `No_Constables`, `No_of_SI`, `No_of_Criminals`) VALUES
('jp nagar', 56787687, 25, 3, 50),
('mg road', 56876545, 15, 3, 7),
('shivajinagar', 5765456, 5, 2, 20),
('yeshwanthpur', 54675687, 45, 5, 50);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Police_Station`
--
ALTER TABLE `Police_Station`
  ADD PRIMARY KEY (`Area`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
