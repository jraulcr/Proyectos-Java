-- phpMyAdmin SQL Dump
-- version 4.9.7deb1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 12-02-2021 a las 13:08:22
-- Versión del servidor: 8.0.23-0ubuntu0.20.10.1
-- Versión de PHP: 7.4.9


--
-- Base de datos: `relacionesHibernate`
--
CREATE DATABASE IF NOT EXISTS `relacionesHibernate` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `relacionesHibernate`;



--
-- Estructura de tabla para la tabla `detalles_cliente`
--


DROP TABLE IF EXISTS `detalles_cliente`;
CREATE TABLE `detalles_cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `web` varchar(128) DEFAULT NULL,
  `tfno` varchar(128) DEFAULT NULL,
  `comentarios` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- RELACIONES PARA LA TABLA `detalles_cliente`:
--
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETALLE` (`id`),
  CONSTRAINT `FK_DETALLE` FOREIGN KEY (`id`) REFERENCES `detalles_cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- RELACIONES PARA LA TABLA `cliente`:
--   `id`
--       `detalles_cliente` -> `id`
--

-- --------------------------------------------------------
--
-- Restricciones para tablas volcadas
--

--

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
