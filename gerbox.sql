-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2019 at 12:08 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gerbox`
--

-- --------------------------------------------------------

--
-- Table structure for table `assigned_to`
--

CREATE TABLE `assigned_to` (
  `employeeId` int(11) NOT NULL,
  `serviceId` int(11) NOT NULL,
  `vehicleId` int(11) NOT NULL,
  `start` datetime NOT NULL,
  `finish` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

--
-- Dumping data for table `assigned_to`
--

INSERT INTO `assigned_to` (`employeeId`, `serviceId`, `vehicleId`, `start`, `finish`) VALUES
(4, 64, 73, '2019-06-07 10:00:00', '2019-06-07 12:00:00'),
(4, 73, 73, '2019-06-07 10:00:00', '2019-06-07 16:00:00'),
(4, 74, 76, '2019-06-07 11:00:00', '2019-06-07 17:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL,
  `firstName` varchar(15) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `email` varchar(25) NOT NULL,
  `phone` int(10) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerId`, `firstName`, `lastName`, `email`, `phone`, `password`) VALUES
(2, 'James', 'O\'Connor', 'joconnor@gmail.com', 874567834, 'JOC1234!'),
(3, 'Paul', 'Weir', 'pweir@gmail.com', 887956345, 'PW1234!'),
(4, 'Brian', 'Quinn', 'bquinn@gmail.com', 874656578, 'BQ1234!'),
(5, 'Ellen', 'Smith', 'esmith@gmail.com', 865678456, 'ES1234!'),
(6, 'Thomas', 'Coleman', 'tcoleman@gmail.com', 864739654, 'TC1234!'),
(7, 'Suzanne', 'Brown', 'sbrown@gmail.com', 898767765, 'SB1234!'),
(8, 'Piotr', 'Bar', 'pbar@gmail.com', 89546473, 'PB1234!');

-- --------------------------------------------------------

--
-- Table structure for table `engine_type`
--

CREATE TABLE `engine_type` (
  `engineTypeName` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

--
-- Dumping data for table `engine_type`
--

INSERT INTO `engine_type` (`engineTypeName`) VALUES
('diesel'),
('electric'),
('hybrid'),
('petrol');

-- --------------------------------------------------------

--
-- Table structure for table `is_added`
--

CREATE TABLE `is_added` (
  `serviceId` int(11) NOT NULL,
  `partId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

-- --------------------------------------------------------

--
-- Table structure for table `mechanic`
--

CREATE TABLE `mechanic` (
  `employeeId` int(11) NOT NULL,
  `firstName` varchar(15) NOT NULL,
  `lastName` varchar(15) NOT NULL,
  `availability` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

--
-- Dumping data for table `mechanic`
--

INSERT INTO `mechanic` (`employeeId`, `firstName`, `lastName`, `availability`) VALUES
(1, 'Allan', 'Ryan', 0),
(2, 'Joel', 'Mahendran', 0),
(3, 'Erico', 'Rutkoski', 0),
(4, 'Lukas', 'Laronga', 1);

-- --------------------------------------------------------

--
-- Table structure for table `part`
--

CREATE TABLE `part` (
  `itrmId` int(11) NOT NULL,
  `articleNumber` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `cost` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `serviceId` int(11) NOT NULL,
  `description` text NOT NULL,
  `serviceTypeName` varchar(15) NOT NULL,
  `statusName` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`serviceId`, `description`, `serviceTypeName`, `statusName`) VALUES
(64, '', 'annual service', 'collected'),
(73, '', 'major repair', 'collected'),
(74, '', 'major repair', 'collected');

-- --------------------------------------------------------

--
-- Table structure for table `service_type`
--

CREATE TABLE `service_type` (
  `serviceTypeName` varchar(15) NOT NULL,
  `time` time NOT NULL,
  `cost` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

--
-- Dumping data for table `service_type`
--

INSERT INTO `service_type` (`serviceTypeName`, `time`, `cost`) VALUES
('annual service', '02:00:00', 200),
('major repair', '06:00:00', 600),
('major service', '04:00:00', 350),
('repair / fault', '03:00:00', 300);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `statusName` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`statusName`) VALUES
('booked'),
('collected'),
('completed '),
('in service '),
('unrepairable');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `vehicleId` int(11) NOT NULL,
  `registration` varchar(10) NOT NULL,
  `colour` varchar(15) DEFAULT NULL,
  `customerId` int(11) NOT NULL,
  `vehicleMakeName` varchar(15) NOT NULL,
  `vehicleModelName` varchar(15) NOT NULL,
  `engineTypeName` varchar(10) NOT NULL,
  `vehicleTypeName` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`vehicleId`, `registration`, `colour`, `customerId`, `vehicleMakeName`, `vehicleModelName`, `engineTypeName`, `vehicleTypeName`) VALUES
(73, '04D29697', 'Silver', 4, 'Peugeot', '208', 'petrol', 'car'),
(76, '181KE6547', 'Red', 7, 'Hyundai', 'i30', 'petrol', 'car');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_make`
--

CREATE TABLE `vehicle_make` (
  `vehicleMakeName` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

--
-- Dumping data for table `vehicle_make`
--

INSERT INTO `vehicle_make` (`vehicleMakeName`) VALUES
('Audi'),
('BMW'),
('Citroen'),
('Dacia'),
('Fiat'),
('Ford'),
('Honda'),
('Hyundai'),
('Jaguar'),
('Jeep'),
('Kia'),
('Land Rover'),
('Lexus'),
('Maserati'),
('Mazda'),
('Mercedes'),
('MG'),
('Mitsubishi'),
('Nissan'),
('Opel'),
('Peugeot'),
('Porsche'),
('Renault'),
('Seat'),
('Skoda'),
('SsangYong'),
('Subaru'),
('Suzuki'),
('Tesla'),
('Toyota'),
('Vauxhall'),
('Volkswagen'),
('Volvo');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_model`
--

CREATE TABLE `vehicle_model` (
  `vehicleModelName` varchar(15) NOT NULL,
  `vehicleMakeName` varchar(15) NOT NULL,
  `vehicleTypeName` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

--
-- Dumping data for table `vehicle_model`
--

INSERT INTO `vehicle_model` (`vehicleModelName`, `vehicleMakeName`, `vehicleTypeName`) VALUES
('208', '', '2'),
('216i Gran Toure', '', '3'),
('3008', '', '2'),
('308', '', '2'),
('500', '', '2'),
('5008', '', '2'),
('6', '', '2'),
('7', '', '2'),
('A4', '', '2'),
('Accord', '', '2'),
('Altima', '', '2'),
('Bongo', '', '4'),
('Boxer', '', '4'),
('Bravo', '', '2'),
('C3', '', '2'),
('CBR300R', '', '1'),
('Cee\'d', '', '2'),
('Civic', '', '2'),
('Corsa', '', '2'),
('CX-3', '', '2'),
('CX-5', '', '2'),
('Discovery Sport', '', '2'),
('Doblo', '', '3'),
('Ducato', '', '4'),
('Duster', '', '2'),
('E-TRON', '', '2'),
('Evoque', '', '2'),
('Freed', '', '3'),
('i20', '', '2'),
('i30', '', '2'),
('i40', '', '2'),
('JetForce', '', '1'),
('Juke', '', '2'),
('Kona', '', '2'),
('Kuga', '', '2'),
('Leaf', '', '2'),
('Logan', '', '2'),
('LS 460 F Sport', '', '2'),
('Mazda2/Demio', '', '2'),
('Mazda6/Ateza', '', '2'),
('Model 3', '', '2'),
('Model S', '', '2'),
('Model X', '', '2'),
('Model Y', '', '2'),
('MPV', '', '3'),
('Murano', '', '2'),
('NEW BERLINGO', '', '3'),
('Outlander', '', '2'),
('Pajero', '', '2'),
('Panda', '', '2'),
('Partner', '', '3'),
('Pregio', '', '4'),
('Premacy', '', '3'),
('Q2', '', '2'),
('Qashqai', '', '2'),
('RX 350', '', '2'),
('Sabre', '', '1'),
('Sandero', '', '2'),
('Santa Fe', '', '2'),
('Sonata', '', '2'),
('SPACETOURER', '', '4'),
('Sprinter', '', '4'),
('Starex', '', '4'),
('StepWGN', '', '4'),
('Stonic', '', '2'),
('Tipo', '', '2'),
('Tourneo', '', '4'),
('Transit', '', '3'),
('TT', '', '2'),
('V80', '', '4'),
('Vito', '', '4'),
('Vivaro', '', '4'),
('W163', '', '2'),
('W203', '', '2'),
('W211', '', '2'),
('XF', '', '2'),
('XJ', '', '2'),
('Xpander', '', '3');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_type`
--

CREATE TABLE `vehicle_type` (
  `vehicleTypeName` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

--
-- Dumping data for table `vehicle_type`
--

INSERT INTO `vehicle_type` (`vehicleTypeName`) VALUES
('motorbike'),
('car'),
('mini van'),
('mini bus');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assigned_to`
--
ALTER TABLE `assigned_to`
  ADD PRIMARY KEY (`employeeId`,`serviceId`,`vehicleId`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerId`);

--
-- Indexes for table `engine_type`
--
ALTER TABLE `engine_type`
  ADD PRIMARY KEY (`engineTypeName`);

--
-- Indexes for table `is_added`
--
ALTER TABLE `is_added`
  ADD PRIMARY KEY (`serviceId`,`partId`);

--
-- Indexes for table `mechanic`
--
ALTER TABLE `mechanic`
  ADD PRIMARY KEY (`employeeId`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`serviceId`);

--
-- Indexes for table `service_type`
--
ALTER TABLE `service_type`
  ADD PRIMARY KEY (`serviceTypeName`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`statusName`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`vehicleId`);

--
-- Indexes for table `vehicle_make`
--
ALTER TABLE `vehicle_make`
  ADD PRIMARY KEY (`vehicleMakeName`);

--
-- Indexes for table `vehicle_model`
--
ALTER TABLE `vehicle_model`
  ADD PRIMARY KEY (`vehicleModelName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `mechanic`
--
ALTER TABLE `mechanic`
  MODIFY `employeeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `serviceId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `vehicleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
