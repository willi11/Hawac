-- phpMyAdmin SQL Dump
-- version 2.10.2
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 14-11-2015 a las 12:17:25
-- Versión del servidor: 5.0.45
-- Versión de PHP: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `tienda`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `abonos`
-- 

CREATE DATABASE `tienda`;
USE `tienda`;
CREATE TABLE `abonos` (
  `numero_abono` int(20) NOT NULL auto_increment,
  `monto` varchar(20) NOT NULL,
  `fecha_pago` varchar(15) NOT NULL,
  `forma_pago` varchar(10) NOT NULL,
  `siglas_banco` varchar(10) default NULL,
  `numero_cheque` varchar(20) default NULL,
  `numero_tarjeta` varchar(20) default NULL,
  `fecha_vencimiento` varchar(15) default NULL,
  `numero_referencia` varchar(10) default NULL,
  `numero_apartado` int(11) NOT NULL,
  PRIMARY KEY  (`numero_abono`),
  KEY `numero_apartado` (`numero_apartado`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `abonos`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `apartados`
-- 

CREATE TABLE `apartados` (
  `numero_apartado` int(11) NOT NULL auto_increment,
  `descripcion` varchar(257) NOT NULL,
  `monto` varchar(20) NOT NULL,
  `fecha_realizado` varchar(15) NOT NULL,
  `fecha_maxima` varchar(15) NOT NULL,
  `id_cliente` varchar(20) NOT NULL,
  PRIMARY KEY  (`numero_apartado`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `apartados`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `clientes`
-- 

CREATE TABLE `clientes` (
  `id_cliente` varchar(20) NOT NULL,
  `nombre_cliente` varchar(20) NOT NULL,
  `apellido1_cliente` varchar(20) NOT NULL,
  `apellido2_cliente` varchar(20) NOT NULL,
  `direccion_cliente` varchar(30) NOT NULL,
  `telefono_cliente` varchar(20) NOT NULL,
  KEY `id_cliente` (`id_cliente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `clientes`
-- 

INSERT INTO `clientes` VALUES ('123', 'Juan', 'Morales', 'Pérez', 'Alajuela', '2256-5245');
INSERT INTO `clientes` VALUES ('125', 'Luis', 'Bolaños', 'Cordero', 'Pavas', '22330543');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `productos`
-- 

use tienda
create table `usuario`(`nombre` varchar(45) NOT NULL,
						`contraseña` varchar(45) NOT NULL,
                        `tipo` varchar(10) NOT NULL,
                        PRIMARY KEY (`nombre`)
						) 
insert into usuario(nombre,contraseña,tipo) values ('William','william','super')

create table `productos`(`codigo` varchar(45) NOT NULL,
						`talla` varchar(45) NOT NULL,
                        `color` varchar(45) NOT NULL,
                        `descrippcion` varchar(150) NOT NULL,
                        `genero` varchar(45) NOT NULL,
                        `valor` float NOT NULL,
                        `cantidad` int NOT NULL,
                        PRIMARY KEY (`codigo`)
                        )

-- 
-- Volcar la base de datos para la tabla `productos`
-- 


INSERT INTO `productos` VALUES (1, 'Celular Samsung Galaxy 6', '250000');
INSERT INTO `productos` VALUES (2, 'Computadora de Escritorio Dell ', '245000');
INSERT INTO `productos` VALUES (4, 'Refrigeradora MABE', '357000');
INSERT INTO `productos` VALUES (5, 'Play Station 4', '260000');
INSERT INTO `productos` VALUES (6, 'Lavadora MABE', '430000');
INSERT INTO `productos` VALUES (8, 'Televisor LG', '460000');