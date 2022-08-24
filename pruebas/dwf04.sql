-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-08-2022 a las 00:19:05
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dwf04`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boletos`
--

CREATE TABLE `boletos` (
  `id_boleto` int(11) NOT NULL,
  `oferta_boleto` int(11) NOT NULL,
  `codigo_boleto` char(7) NOT NULL,
  `estado_boleto` char(30) NOT NULL,
  `cliente_boleto` int(11) NOT NULL,
  `empresa_boleto` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `boletos`
--

INSERT INTO `boletos` (`id_boleto`, `oferta_boleto`, `codigo_boleto`, `estado_boleto`, `cliente_boleto`, `empresa_boleto`) VALUES
(1, 1, 'G04I31B', 'Activo', 1, 'EOR001'),
(2, 1, 'H7I437V', 'Canjeado', 1, 'EOR001'),
(3, 1, '15G148A', 'Vencido', 1, 'EOR001'),
(4, 1, '9BL29K2', 'Activo', 2, 'EOR001');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `Id_Empresa` varchar(10) NOT NULL,
  `Nombre_Empresa` char(50) NOT NULL,
  `Dirección_Empresa` char(90) NOT NULL,
  `Contacto_Empresa` char(20) NOT NULL,
  `Telefono_Empresa` char(12) NOT NULL,
  `Correo_Empresa` char(100) NOT NULL,
  `Rubro_Empresa` char(30) NOT NULL,
  `Comision_Empresa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`Id_Empresa`, `Nombre_Empresa`, `Dirección_Empresa`, `Contacto_Empresa`, `Telefono_Empresa`, `Correo_Empresa`, `Rubro_Empresa`, `Comision_Empresa`) VALUES
('EOR001', 'Salchipapa', 'Calle de Velázquez, 80 Madrid, Street de Velázquez, 80 Madrid', 'AAAAAA', '71283923', 'salchipapa_empresa@gmail.com', 'Comida y alimentos congelados', 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_oferta`
--

CREATE TABLE `estado_oferta` (
  `Id_estado_Oferta` int(11) NOT NULL,
  `Estado_Oferta` char(15) NOT NULL,
  `Detalle_estado_Oferta` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas_empresa`
--

CREATE TABLE `ofertas_empresa` (
  `id_Empresa_Oferta` int(11) NOT NULL,
  `Titulo_Oferta` char(40) NOT NULL,
  `Precio_normal_Oferta` decimal(5,2) NOT NULL,
  `Precio_ofertado_Oferta` decimal(5,2) NOT NULL,
  `Fecha_inicio_Oferta` date NOT NULL,
  `Fecha_final_Oferta` date NOT NULL,
  `Fecha_limite_Oferta` date NOT NULL,
  `Cantidad_limite_Oferta` int(11) DEFAULT NULL,
  `Descripcion_Oferta` text NOT NULL,
  `Detalles_Oferta` text NOT NULL,
  `Estado_Oferta` int(11) DEFAULT NULL,
  `Empresa_Oferta` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ofertas_empresa`
--

INSERT INTO `ofertas_empresa` (`id_Empresa_Oferta`, `Titulo_Oferta`, `Precio_normal_Oferta`, `Precio_ofertado_Oferta`, `Fecha_inicio_Oferta`, `Fecha_final_Oferta`, `Fecha_limite_Oferta`, `Cantidad_limite_Oferta`, `Descripcion_Oferta`, `Detalles_Oferta`, `Estado_Oferta`, `Empresa_Oferta`) VALUES
(1, 'HOT DOG\'S', '12.34', '8.99', '2022-08-01', '2022-09-22', '2022-09-22', 600, 'Bueno venta de hod-dog que estan apunto de vencer así que venderlo por favor', 'Bueno venta de hod-dog que estan apunto de vencer así que venderlo por favor', NULL, 'EOR001');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Id_Usuario` int(11) NOT NULL,
  `Nombre_Usuario` char(20) NOT NULL,
  `Apellido_Usuario` char(20) NOT NULL,
  `Telefono_Usuario` char(12) NOT NULL,
  `Correo_Usuario` char(80) NOT NULL,
  `DUI_Usuario` char(10) NOT NULL,
  `Contrasena_Usuario` char(16) NOT NULL,
  `Verifcacion_Usuario` bit(1) NOT NULL,
  `Categoria_Usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Id_Usuario`, `Nombre_Usuario`, `Apellido_Usuario`, `Telefono_Usuario`, `Correo_Usuario`, `DUI_Usuario`, `Contrasena_Usuario`, `Verifcacion_Usuario`, `Categoria_Usuario`) VALUES
(1, 'Jonnathan alexander', 'Urquilla munoz', '71287300', 'jonnathanweltx@gmil.com', '12345678-9', 'matamancos3000', b'1', 3),
(2, 'Joana alexia', 'urquilla munes', '72963923', 'joanaMunes@hotmail.com', '12345678-0', 'Udb12345', b'1', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_categoria`
--

CREATE TABLE `usuario_categoria` (
  `Id_Categoria` int(11) NOT NULL,
  `Nombre_Categoria` char(30) NOT NULL,
  `Descripcion_CategoriA` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario_categoria`
--

INSERT INTO `usuario_categoria` (`Id_Categoria`, `Nombre_Categoria`, `Descripcion_CategoriA`) VALUES
(1, 'administrador', 'Bueno este usuario tiene el poder ilimitado\r\n'),
(2, 'Administrador de empresas', 'Bueno este usuario puede controlar las ofertas de la empresa, no tiene poder ilimitado pero con un solo click puede borrar una oferta de la faz de la tierra'),
(3, 'Clientes', 'Bueno en el caso de nuestro sitio web nada mas son simples mortales'),
(4, 'Dependiente de sucursal', 'Bueno este usuario solo tendrá un rol y es el guardián de los boletos ');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `boletos`
--
ALTER TABLE `boletos`
  ADD PRIMARY KEY (`id_boleto`),
  ADD KEY `oferta_empresa_boleto` (`oferta_boleto`),
  ADD KEY `cliente_boleto` (`cliente_boleto`),
  ADD KEY `empresa_boleto` (`empresa_boleto`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`Id_Empresa`);

--
-- Indices de la tabla `estado_oferta`
--
ALTER TABLE `estado_oferta`
  ADD PRIMARY KEY (`Id_estado_Oferta`);

--
-- Indices de la tabla `ofertas_empresa`
--
ALTER TABLE `ofertas_empresa`
  ADD PRIMARY KEY (`id_Empresa_Oferta`),
  ADD KEY `estado_oferta` (`Estado_Oferta`),
  ADD KEY `empresa_oferta` (`Empresa_Oferta`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id_Usuario`),
  ADD KEY `cliente_categoria` (`Categoria_Usuario`);

--
-- Indices de la tabla `usuario_categoria`
--
ALTER TABLE `usuario_categoria`
  ADD PRIMARY KEY (`Id_Categoria`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `boletos`
--
ALTER TABLE `boletos`
  MODIFY `id_boleto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `empresa`
--

--
-- AUTO_INCREMENT de la tabla `estado_oferta`
--
ALTER TABLE `estado_oferta`
  MODIFY `Id_estado_Oferta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ofertas_empresa`
--
ALTER TABLE `ofertas_empresa`
  MODIFY `id_Empresa_Oferta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario_categoria`
--
ALTER TABLE `usuario_categoria`
  MODIFY `Id_Categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `boletos`
--
ALTER TABLE `boletos`
  ADD CONSTRAINT `cliente_boleto` FOREIGN KEY (`cliente_boleto`) REFERENCES `usuario` (`Id_Usuario`),
  ADD CONSTRAINT `empresa_boleto` FOREIGN KEY (`empresa_boleto`) REFERENCES `empresa` (`Id_Empresa`),
  ADD CONSTRAINT `oferta_empresa_boleto` FOREIGN KEY (`oferta_boleto`) REFERENCES `ofertas_empresa` (`id_Empresa_Oferta`);

--
-- Filtros para la tabla `ofertas_empresa`
--
ALTER TABLE `ofertas_empresa`
  ADD CONSTRAINT `empresa_oferta` FOREIGN KEY (`Empresa_Oferta`) REFERENCES `empresa` (`Id_Empresa`),
  ADD CONSTRAINT `estado_oferta` FOREIGN KEY (`Estado_Oferta`) REFERENCES `estado_oferta` (`Id_estado_Oferta`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `cliente_categoria` FOREIGN KEY (`Categoria_Usuario`) REFERENCES `usuario_categoria` (`Id_Categoria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
