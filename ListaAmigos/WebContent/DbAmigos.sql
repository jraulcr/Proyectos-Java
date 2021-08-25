-- phpMyAdmin SQL Dump
-- version 4.9.7deb1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 25-08-2021 a las 10:23:53
-- Versión del servidor: 8.0.25-0ubuntu0.20.10.1
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
-- Base de datos: `dbamigos`
--
CREATE DATABASE IF NOT EXISTS `dbamigos` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `dbamigos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amigos`
--

DROP TABLE IF EXISTS `amigos`;
CREATE TABLE IF NOT EXISTS `amigos` (
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `edad` tinyint NOT NULL,
  `nivelAmistad` tinyint NOT NULL,
  `comentarios` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `amigos`
--

INSERT INTO `amigos` (`nombre`, `direccion`, `telefono`, `edad`, `nivelAmistad`, `comentarios`) VALUES
('gfhfg', 'fghfg', '333333', 44, 4, 'hgjgh'),
('hfghgf', 'gfhgf', '333333', 55, 1, 'cvbcx'),
('rttr', 'rty', '33', 44, 2, 'hnm'),
('Pepe', 'Pijo', '66666', 66, 9, 'sdfg'),
('Paco Jones', 'Avenida llegada 45', '98999999', 22, 9, 'fgdhfg'),
('Atun Pirulero', 'Percebe 13', '6969696', 33, 10, 'dsf');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
