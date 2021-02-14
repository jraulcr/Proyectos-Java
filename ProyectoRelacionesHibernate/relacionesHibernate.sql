-- phpMyAdmin SQL Dump
-- version 4.9.7deb1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 12-02-2021 a las 13:08:22
-- Versión del servidor: 8.0.23-0ubuntu0.20.10.1
-- Versión de PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `relacionesHibernate`
--
CREATE DATABASE IF NOT EXISTS `relacionesHibernate` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `relacionesHibernate`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellido` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `direccion` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELACIONES PARA LA TABLA `cliente`:
--   `id`
--       `detalles_cliente` -> `id`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles_cliente`
--

DROP TABLE IF EXISTS `detalles_cliente`;
CREATE TABLE IF NOT EXISTS `detalles_cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `web` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tfno` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `comentarios` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELACIONES PARA LA TABLA `detalles_cliente`:
--

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_detalles` FOREIGN KEY (`id`) REFERENCES `detalles_cliente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
