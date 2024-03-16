-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 15, 2024 at 06:14 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

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
-- Table structure for table `amenity`
--

CREATE TABLE `amenity` (
  `id` int(11) NOT NULL,
  `label` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `amenity`
--

INSERT INTO `amenity` (`id`, `label`) VALUES
(1, 'wifi'),
(2, 'television');

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `label` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `label`) VALUES
(1, 'tangier'),
(2, 'rabat'),
(3, 'casa'),
(4, 'agadir'),
(5, 'marrakech'),
(6, 'essaouira');

-- --------------------------------------------------------

--
-- Table structure for table `photos`
--

CREATE TABLE `photos` (
  `id` int(11) NOT NULL,
  `photo_path` varchar(254) DEFAULT NULL,
  `proprety_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

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
(1, 2, 'work-3.jpg', '300', 2, 3, 0, 'hey belabass', 0, 10, '2024-02-27 21:37:11', 1, 'white house'),
(4, 1, 'work-2.jpg', '1000', 2, 5, 0, 'hay belabass', 0, 400, '2024-03-11 15:35:58', 2, 'blue house'),
(5, 1, 'work-1.jpg', '1000', 2, 4, 0, 'adress in tangier', 1, 300, '2024-03-12 14:53:02', 1, 'beach appartement');

-- --------------------------------------------------------

--
-- Table structure for table `proprety_has_amenity`
--

CREATE TABLE `proprety_has_amenity` (
  `proprety_id` int(11) NOT NULL,
  `Amenity_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `proprety_has_amenity`
--

INSERT INTO `proprety_has_amenity` (`proprety_id`, `Amenity_id`) VALUES
(1, 2),
(4, 1),
(5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `label` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`id`, `label`) VALUES
(1, 'appartement'),
(2, 'house');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `amenity`
--
ALTER TABLE `amenity`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `photos`
--
ALTER TABLE `photos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_photos_proprety1_idx` (`proprety_id`);

--
-- Indexes for table `proprety`
--
ALTER TABLE `proprety`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_proprety_type1_idx` (`type_id`),
  ADD KEY `fk_proprety_city1_idx` (`city_id`);

--
-- Indexes for table `proprety_has_amenity`
--
ALTER TABLE `proprety_has_amenity`
  ADD PRIMARY KEY (`proprety_id`,`Amenity_id`),
  ADD KEY `fk_proprety_has_Amenity_Amenity1_idx` (`Amenity_id`),
  ADD KEY `fk_proprety_has_Amenity_proprety1_idx` (`proprety_id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `amenity`
--
ALTER TABLE `amenity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `photos`
--
ALTER TABLE `photos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `proprety`
--
ALTER TABLE `proprety`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `photos`
--
ALTER TABLE `photos`
  ADD CONSTRAINT `fk_photos_proprety1` FOREIGN KEY (`proprety_id`) REFERENCES `proprety` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `proprety`
--
ALTER TABLE `proprety`
  ADD CONSTRAINT `fk_proprety_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_proprety_type1` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `proprety_has_amenity`
--
ALTER TABLE `proprety_has_amenity`
  ADD CONSTRAINT `fk_proprety_has_Amenity_Amenity1` FOREIGN KEY (`Amenity_id`) REFERENCES `amenity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_proprety_has_Amenity_proprety1` FOREIGN KEY (`proprety_id`) REFERENCES `proprety` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
