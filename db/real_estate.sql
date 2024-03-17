-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: mariadb:3306
-- Generation Time: Mar 17, 2024 at 05:06 PM
-- Server version: 10.4.32-MariaDB-1:10.4.32+maria~ubu2004
-- PHP Version: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `real_estate`
--

-- --------------------------------------------------------

--
-- Table structure for table `proprety`
--

CREATE TABLE `proprety` (
  `id` int(11) NOT NULL,
  `type_id` int(11) DEFAULT NULL,
  `front_photo` varchar(254) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `bedrooms` int(45) DEFAULT NULL,
  `bathrooms` int(45) DEFAULT NULL,
  `pets_allowed` tinyint(4) DEFAULT NULL,
  `adress` varchar(45) DEFAULT NULL,
  `for_rent` tinyint(4) DEFAULT NULL,
  `square_metters` int(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp(),
  `city_id` int(11) DEFAULT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `proprety`
--

INSERT INTO `proprety` (`id`, `type_id`, `front_photo`, `price`, `bedrooms`, `bathrooms`, `pets_allowed`, `adress`, `for_rent`, `square_metters`, `create_time`, `city_id`, `description`) VALUES
(1, 2, 'work-3.jpg', '300', 2, 3, 0, 'Tangier,Morroco', 0, 10, '2024-02-27 21:37:11', 1, 'white house'),
(4, 1, 'work-2.jpg', '1000', 2, 5, 0, 'Rabat,Morroco', 0, 400, '2024-03-11 15:35:58', 2, 'blue house'),
(5, 1, 'work-1.jpg', '1000', 2, 4, 0, 'Tangier,Morroco', 1, 300, '2024-03-12 14:53:02', 1, 'beach appartement'),
(6, 2, 'image_2.jpg', '2000', 2, 5, 1, '123 Main Street, Anytown, USA 12345', 0, 1000, '2024-03-17 16:56:41', 5, 'greenhouse Marrakech'),
(7, 1, 'image_1.jpg', '2500', 3, 3, 1, 'Essaouira, Morocco', 1, 300, '2024-03-17 16:56:41', 6, 'Nice View Apartment'),
(8, 1, 'work-8.jpg', '999', 3, 2, 0, 'Casabalanca, Morroco', 1, 250, '2024-03-17 17:00:19', 3, 'Good View Apartment'),
(9, 2, 'work-9.jpg', '1500', 1, 2, 1, 'Marrakech , Morroco', 1, 600, '2024-03-17 17:03:27', NULL, 'White House Marrakech');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `proprety`
--
ALTER TABLE `proprety`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_proprety_type1_idx` (`type_id`),
  ADD KEY `fk_proprety_city1_idx` (`city_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `proprety`
--
ALTER TABLE `proprety`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `proprety`
--
ALTER TABLE `proprety`
  ADD CONSTRAINT `fk_proprety_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_proprety_type1` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
