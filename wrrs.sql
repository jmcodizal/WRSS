-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2024 at 05:23 AM
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
-- Database: `wrrs`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer_info`
--

CREATE TABLE `customer_info` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `contact_number` varchar(15) NOT NULL,
  `barangay` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_info`
--

INSERT INTO `customer_info` (`id`, `name`, `contact_number`, `barangay`) VALUES
(54, 'Hello', '090765554', 'Poblacion 1'),
(55, 'Summer', '0678456', 'Poblacion 2'),
(56, 'Jacob Miles', '096531231', 'Poblacion 3'),
(57, 'Gerob', '0945234', 'Poblacion 5');

-- --------------------------------------------------------

--
-- Table structure for table `deliveries`
--

CREATE TABLE `deliveries` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `barangay` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `deliveries`
--

INSERT INTO `deliveries` (`id`, `customer_id`, `barangay`, `status`, `date`) VALUES
(1, 46, 'Poblacion 2', 'delivered', '2024-12-05'),
(2, 47, 'Poblacion 3', 'delivered', '2024-12-05'),
(3, 49, 'Poblacion 1', 'delivered', '2024-12-05'),
(4, 53, 'Poblacion 1', 'delivered', '2024-12-05'),
(5, 54, 'Poblacion 1', 'delivered', '2024-12-05'),
(6, 55, 'Poblacion 2', 'delivered', '2024-12-05'),
(7, 56, 'Poblacion 3', 'delivered', '2024-12-05'),
(8, 57, 'Poblacion 5', 'delivered', '2024-12-05');

-- --------------------------------------------------------

--
-- Table structure for table `gcash_payment`
--

CREATE TABLE `gcash_payment` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `gcash_name` varchar(255) NOT NULL,
  `gcash_number` varchar(20) NOT NULL,
  `gcash_amount` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gcash_payment`
--

INSERT INTO `gcash_payment` (`id`, `customer_id`, `gcash_name`, `gcash_number`, `gcash_amount`) VALUES
(1, 0, 'rhox', '09876543210', 500.00),
(2, 0, 'juan', '09068162993', 500.00),
(3, 0, 'Robredo', '09768546', 800.00),
(4, 0, 'Robredo', '0956363', 300.00),
(5, 53, 'eto', '09756', 60.00),
(6, 55, 'Summer', '0678456', 60.00),
(7, 57, 'Gerob', '0945234', 270.00);

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` enum('user','admin','','') NOT NULL DEFAULT 'user'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `username`, `email`, `password`, `role`) VALUES
(1, 'jessa', 'jessa@gmail.com', 'qwerty', 'user'),
(3, 'jessa', 'marie', 'werty', 'user'),
(4, 'juanlopez', 'juancedricklopez@gmail.com', 'juan23', 'admin'),
(5, 'kaito', 'kaito1412', '1412', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `MOP` varchar(255) NOT NULL,
  `container` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`id`, `customer_id`, `name`, `MOP`, `container`, `quantity`, `total`, `date`) VALUES
(40, 54, 'Hello', 'Cash on Pickup', '8 Liters', 3, 60.00, '2024-12-05'),
(41, 55, 'Summer', 'Gcash', '8 Liters', 3, 60.00, '2024-12-05'),
(42, 56, 'Jacob Miles', 'Cash on Pickup', '8 Liters', 3, 60.00, '2024-12-05'),
(43, 56, 'Jacob Miles', 'Cash on Pickup', '31 Liters', 3, 120.00, '2024-12-05'),
(44, 56, 'Jacob Miles', 'Cash on Pickup', '21 Liters Container', 4, 120.00, '2024-12-05'),
(45, 56, 'Jacob Miles', 'Cash on Pickup', '21 Liters Dispenser', 3, 90.00, '2024-12-05'),
(46, 57, 'Gerob', 'Gcash', '8 Liters', 3, 60.00, '2024-12-05'),
(47, 57, 'Gerob', 'Gcash', '21 Liters Container', 3, 90.00, '2024-12-05'),
(48, 57, 'Gerob', 'Gcash', '21 Liters Dispenser', 4, 120.00, '2024-12-05');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer_info`
--
ALTER TABLE `customer_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `deliveries`
--
ALTER TABLE `deliveries`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gcash_payment`
--
ALTER TABLE `gcash_payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer_info`
--
ALTER TABLE `customer_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `deliveries`
--
ALTER TABLE `deliveries`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `gcash_payment`
--
ALTER TABLE `gcash_payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
