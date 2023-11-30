-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2023 a las 00:46:31
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ciudadonabd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `address`
--

CREATE TABLE `address` (
  `id` binary(16) NOT NULL,
  `reference` varchar(300) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `street` varchar(300) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `id_user` binary(16) DEFAULT NULL,
  `ubdistrito_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `address`
--

INSERT INTO `address` (`id`, `reference`, `created_at`, `street`, `updated_at`, `id_user`, `ubdistrito_id`) VALUES
(0x8d9cb33c4e2f497e8cee1156882d8c24, 'asdasd', '2023-11-30 19:14:13.000000', 'sdasd', '2023-11-30 19:14:13.000000', 0x8dd99a51d9aa4b2e9545b0ec7882fd03, 1233);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brand`
--

CREATE TABLE `brand` (
  `id` binary(16) NOT NULL,
  `name` varchar(500) NOT NULL,
  `idtype_product` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `brand`
--

INSERT INTO `brand` (`id`, `name`, `idtype_product`) VALUES
(0x0081e3b76a1e43cc896da2f3e391e48b, 'San Luis', 0xc329084d0d304393945df2efb1b01345),
(0x42e27316f59940b6b247dee94e01009e, 'San Mateo', 0xc329084d0d304393945df2efb1b01345),
(0x51096112908941a2bcb37c0c5c89861d, 'Inca Kola Agua', 0xc329084d0d304393945df2efb1b01345),
(0x53517567ca9c47e79a858b33cc4090a2, 'vida', 0xc329084d0d304393945df2efb1b01345),
(0x5fb04ae6b6314607af493cd6ea008253, 'EcoAndina', 0xc329084d0d304393945df2efb1b01345),
(0xb651658e625e4eb194b4b00386078cdf, 'Vilcamayu', 0xc329084d0d304393945df2efb1b01345),
(0xc5329cf5bf224076b51d45066a528e5c, 'San Jerónimo', 0xc329084d0d304393945df2efb1b01345),
(0xea50d4cd6afd4d1199a0dcfaedf97eeb, 'cielo', 0xc329084d0d304393945df2efb1b01345),
(0xf17c719edb1f4ce09b755ec6b12714ed, 'San Carlos', 0xc329084d0d304393945df2efb1b01345);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categori_store`
--

CREATE TABLE `categori_store` (
  `id` binary(16) NOT NULL,
  `idcategory` binary(16) DEFAULT NULL,
  `id_store` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categori_store`
--

INSERT INTO `categori_store` (`id`, `idcategory`, `id_store`) VALUES
(0x1be8983bbafa41319ddbe8d44aec7509, 0x1d62b912f2294f3dad3311fcc58fd5e1, 0xce1d190fa8d44fb997288c0003ea088d);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `id` binary(16) NOT NULL,
  `name` varchar(100) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `foto_url` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`id`, `name`, `created_at`, `foto_url`, `updated_at`) VALUES
(0x1d62b912f2294f3dad3311fcc58fd5e1, 'Agua', '2023-11-30 19:13:35.000000', '8tgbkg30.png', '2023-11-30 19:13:35.000000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `company`
--

CREATE TABLE `company` (
  `id` binary(16) NOT NULL,
  `branch` varchar(255) NOT NULL,
  `business_name` varchar(300) NOT NULL,
  `ruc` varchar(12) NOT NULL,
  `activo` bit(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `id_user` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `company`
--

INSERT INTO `company` (`id`, `branch`, `business_name`, `ruc`, `activo`, `created_at`, `updated_at`, `id_user`) VALUES
(0x2ec7d4366af24341993be89aa447cb61, '1', '1', '12345678945', b'1', '2023-11-30 19:14:13.000000', '2023-11-30 19:14:13.000000', 0x8dd99a51d9aa4b2e9545b0ec7882fd03);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `container_type`
--

CREATE TABLE `container_type` (
  `id` binary(16) NOT NULL,
  `name` varchar(500) NOT NULL,
  `idtype_product` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `container_type`
--

INSERT INTO `container_type` (`id`, `name`, `idtype_product`) VALUES
(0x1dd226fe5d5c4a48b07289a6fc64d9f3, 'vidrio descartable', 0xc329084d0d304393945df2efb1b01345),
(0x6931648c6d6947c18c17949c5a76f6a3, 'plastico retornable', 0xc329084d0d304393945df2efb1b01345),
(0xd5a4d283f5fe497eacd87c35f7912023, 'vidrio retornable', 0xc329084d0d304393945df2efb1b01345),
(0xde6cc17b1965406096a2c492d36318e7, 'plastico descartable', 0xc329084d0d304393945df2efb1b01345);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descripcion_agua`
--

CREATE TABLE `descripcion_agua` (
  `id` binary(16) NOT NULL,
  `detalle_enbase` varchar(255) DEFAULT NULL,
  `activo` bit(1) NOT NULL DEFAULT b'1',
  `created_at` datetime(6) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `unidad_paquete` int(11) DEFAULT NULL,
  `updated_at` datetime(6) NOT NULL,
  `idproducto` binary(16) DEFAULT NULL,
  `idcontainer_type` binary(16) DEFAULT NULL,
  `idmedidas_producto` binary(16) DEFAULT NULL,
  `idunidad_medida` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `descripcion_agua`
--

INSERT INTO `descripcion_agua` (`id`, `detalle_enbase`, `activo`, `created_at`, `price`, `stock`, `unidad_paquete`, `updated_at`, `idproducto`, `idcontainer_type`, `idmedidas_producto`, `idunidad_medida`) VALUES
(0x917ae12c5a5f4c78ad429974856c5e00, 'con envase', b'1', '2023-11-30 23:04:40.000000', 18.00, 0, 0, '2023-11-30 23:04:40.000000', 0xde0cb78ff0f247119c226f3ea3df0f5f, 0x1dd226fe5d5c4a48b07289a6fc64d9f3, 0x094af46ffd104deb8e106dccacfd8261, 0xc80b9acd753644fd9bfe9d7c22a4c913);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `id` binary(16) NOT NULL,
  `genero` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `images_product`
--

CREATE TABLE `images_product` (
  `id` binary(16) NOT NULL,
  `foto_url` varchar(255) DEFAULT NULL,
  `id_descripcion_agua` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `images_product`
--

INSERT INTO `images_product` (`id`, `foto_url`, `id_descripcion_agua`) VALUES
(0xa4c7079baedf4ddf9a206cad9d39e1ca, 'jvcub6f8sccrgvfnx5e7.png', 0x917ae12c5a5f4c78ad429974856c5e00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medidas_producto`
--

CREATE TABLE `medidas_producto` (
  `id` binary(16) NOT NULL,
  `nombre` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `medidas_producto`
--

INSERT INTO `medidas_producto` (`id`, `nombre`) VALUES
(0x094af46ffd104deb8e106dccacfd8261, 'por caja'),
(0x1fc17c1edf7444719a5f14ea5d119618, 'Por unidad '),
(0x90cf8e51fa2742d3bc896cf6eeda4530, 'MAYOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

CREATE TABLE `oferta` (
  `id` binary(16) NOT NULL,
  `nombre` varchar(300) DEFAULT NULL,
  `activo` bit(1) DEFAULT NULL,
  `cantidad` decimal(38,2) DEFAULT NULL,
  `fecha_incio` datetime(6) NOT NULL,
  `fechafin` datetime(6) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `id_descripcion_agua` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `oferta`
--

INSERT INTO `oferta` (`id`, `nombre`, `activo`, `cantidad`, `fecha_incio`, `fechafin`, `price`, `id_descripcion_agua`) VALUES
(0x6cbd34d66940409c988115ca65ac1ee9, 'condon dino aguanda como dino', b'1', 2.00, '2022-12-12 00:00:00.000000', '2022-12-12 00:00:00.000000', 12.20, 0x917ae12c5a5f4c78ad429974856c5e00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`id`, `created_at`, `nombre`, `updated_at`) VALUES
(1, '2023-11-02 23:43:19', 'Peru', '2023-11-02 23:43:19'),
(2, '2023-11-03 15:53:03', 'Venezuela', '2023-11-03 15:53:03'),
(3, '2023-11-03 14:57:21', 'Chile', '2023-11-03 14:57:21'),
(4, '2023-11-03 16:17:24', 'venezuela', '2023-11-03 16:17:24'),
(5, '2023-11-03 16:56:43', 'venezuela', '2023-11-03 16:56:43'),
(6, '2023-11-03 16:56:48', 'venezuela', '2023-11-03 16:56:48'),
(7, '2023-11-03 21:39:49', 'venezuela', '2023-11-03 21:39:49');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permission`
--

CREATE TABLE `permission` (
  `id` binary(16) NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `id_person` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `id` binary(16) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `date_of_birth` datetime(6) NOT NULL,
  `name` varchar(300) NOT NULL,
  `sur_name` varchar(300) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `state` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `id_user` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `phone`
--

CREATE TABLE `phone` (
  `id` binary(16) NOT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `whatsapp` varchar(30) DEFAULT NULL,
  `id_user` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `phone`
--

INSERT INTO `phone` (`id`, `celular`, `created_at`, `updated_at`, `whatsapp`, `id_user`) VALUES
(0x2e34a383a43d4ff7a7ca1f0cabe96f70, '+51989466574', '2023-11-30 19:14:13.000000', '2023-11-30 19:14:13.000000', '+51989466574', 0x8dd99a51d9aa4b2e9545b0ec7882fd03);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `id` binary(16) NOT NULL,
  `cualidad` varchar(255) DEFAULT NULL,
  `activo` bit(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `foto_url_principal` text NOT NULL,
  `short_description` text NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `brand` binary(16) DEFAULT NULL,
  `idtype_product` binary(16) DEFAULT NULL,
  `id_store` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id`, `cualidad`, `activo`, `created_at`, `foto_url_principal`, `short_description`, `updated_at`, `brand`, `idtype_product`, `id_store`) VALUES
(0x2f81db11bb89438087bdedfc0f7574cd, '222', b'1', '2023-11-30 23:02:44.000000', '383w68dqn8qbmh0vvqa4.png', '22', '2023-11-30 23:02:44.000000', 0x0081e3b76a1e43cc896da2f3e391e48b, 0x79c1dc2cd5cc448387366e0d25a81fad, 0xce1d190fa8d44fb997288c0003ea088d),
(0x433303fcf57e41108717b2ef26365f95, 's', b'1', '2023-11-30 20:15:22.000000', 'c1cdvkshhc0fonq3ec3f.png', 's', '2023-11-30 20:15:22.000000', 0x0081e3b76a1e43cc896da2f3e391e48b, 0xc329084d0d304393945df2efb1b01345, 0xce1d190fa8d44fb997288c0003ea088d),
(0x4bf7834b2b364e23b1b69609b4d95a33, 'ww', b'1', '2023-11-30 22:57:57.000000', 'xel0fr0ifxph1qidzxrf.png', 'ww', '2023-11-30 22:57:57.000000', 0x0081e3b76a1e43cc896da2f3e391e48b, 0x79c1dc2cd5cc448387366e0d25a81fad, 0xce1d190fa8d44fb997288c0003ea088d),
(0x64154105748f4726bd92cc8c0e418e74, 'ssSassASASasasas', b'1', '2023-11-30 22:24:25.000000', '2ced47v3kuitvwd3oqoa.png', 'cielossssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss', '2023-11-30 22:24:25.000000', 0x0081e3b76a1e43cc896da2f3e391e48b, 0x79c1dc2cd5cc448387366e0d25a81fad, 0xce1d190fa8d44fb997288c0003ea088d),
(0x72b9fd783e184ada8a50ebc9c0dae55e, 'sss', b'1', '2023-11-30 22:46:09.000000', 'xrd0gz49ol6dkdbm8i5v.png', 'ss', '2023-11-30 22:46:09.000000', 0x0081e3b76a1e43cc896da2f3e391e48b, 0x79c1dc2cd5cc448387366e0d25a81fad, 0xce1d190fa8d44fb997288c0003ea088d),
(0xb9b2dbc26ed24b58a9c3b3595d117877, 'ww', b'1', '2023-11-30 22:48:04.000000', '99c9stb04wmx05cwrn31.png', 'w', '2023-11-30 22:48:04.000000', 0x0081e3b76a1e43cc896da2f3e391e48b, 0x79c1dc2cd5cc448387366e0d25a81fad, 0xce1d190fa8d44fb997288c0003ea088d),
(0xde0cb78ff0f247119c226f3ea3df0f5f, '222', b'1', '2023-11-30 23:04:40.000000', '8vlikpyzdqxfu2oap5dj.png', '2222', '2023-11-30 23:04:40.000000', 0x0081e3b76a1e43cc896da2f3e391e48b, 0x79c1dc2cd5cc448387366e0d25a81fad, 0xce1d190fa8d44fb997288c0003ea088d),
(0xe325cd9851d948679dcf20a0133e1554, 'ww', b'1', '2023-11-30 22:59:49.000000', 'wn1k1xhgeq4miciehk2i.png', 'ww', '2023-11-30 22:59:49.000000', 0x0081e3b76a1e43cc896da2f3e391e48b, 0x79c1dc2cd5cc448387366e0d25a81fad, 0xce1d190fa8d44fb997288c0003ea088d),
(0xf5f55af1f9434821a3c693df280e80fd, '222', b'1', '2023-11-30 23:03:45.000000', '5e32omf8thv9ug4r3fka.png', '22', '2023-11-30 23:03:45.000000', 0x0081e3b76a1e43cc896da2f3e391e48b, 0x79c1dc2cd5cc448387366e0d25a81fad, 0xce1d190fa8d44fb997288c0003ea088d),
(0xfaaeb9ae4eff473a845a8eaa58460569, 'ww', b'1', '2023-11-30 22:47:17.000000', 'dc89qtfiqdluybtds8sq.png', 'w', '2023-11-30 22:47:17.000000', 0x0081e3b76a1e43cc896da2f3e391e48b, 0x79c1dc2cd5cc448387366e0d25a81fad, 0xce1d190fa8d44fb997288c0003ea088d);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `responsible`
--

CREATE TABLE `responsible` (
  `id` binary(16) NOT NULL,
  `name` varchar(300) NOT NULL,
  `sur_name` varchar(300) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `whatsapp` varchar(30) DEFAULT NULL,
  `id_company` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `responsible`
--

INSERT INTO `responsible` (`id`, `name`, `sur_name`, `celular`, `whatsapp`, `id_company`) VALUES
(0x19681ef24c8f4a6e8dc2b96b890a337c, 'Eisten', 'Padilla', '989466574', '989466574', 0x2ec7d4366af24341993be89aa447cb61);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
  `id` binary(16) NOT NULL,
  `name` varchar(100) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `name`, `created_at`, `updated_at`) VALUES
(0x4030ab2530fa42d0942eec187a2d00f6, 'EMPRESA', '2023-11-30 19:13:09.000000', '2023-11-30 19:13:09.000000'),
(0xaa07f50bff0b42f49a5b3fa3323b57c1, 'CLIENTE', '2023-11-30 19:13:01.000000', '2023-11-30 19:13:01.000000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role_permission`
--

CREATE TABLE `role_permission` (
  `id` binary(16) NOT NULL,
  `id_rol` binary(16) DEFAULT NULL,
  `permission_id` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `store`
--

CREATE TABLE `store` (
  `id` binary(16) NOT NULL,
  `activo` bit(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `foto_url` varchar(255) DEFAULT NULL,
  `name` varchar(300) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `id_company` binary(16) DEFAULT NULL,
  `id_distrito` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `store`
--

INSERT INTO `store` (`id`, `activo`, `created_at`, `foto_url`, `name`, `updated_at`, `id_company`, `id_distrito`) VALUES
(0xce1d190fa8d44fb997288c0003ea088d, b'1', '2023-11-30 19:15:00.000000', 'eh82o3ku.png', 'AguaVida', '2023-11-30 19:15:00.000000', 0x2ec7d4366af24341993be89aa447cb61, 1233);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subcategory`
--

CREATE TABLE `subcategory` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `foto_url` varchar(255) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `idcategory` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sub_categori_store`
--

CREATE TABLE `sub_categori_store` (
  `id` binary(16) NOT NULL,
  `id_categori_store` binary(16) DEFAULT NULL,
  `id_store` binary(16) DEFAULT NULL,
  `idsubcategory` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `timetable`
--

CREATE TABLE `timetable` (
  `id` binary(16) NOT NULL,
  `apertura` time(6) DEFAULT NULL,
  `cierre` time(6) DEFAULT NULL,
  `store_id` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `timetable`
--

INSERT INTO `timetable` (`id`, `apertura`, `cierre`, `store_id`) VALUES
(0x13407841624345d2b6347ae99b48d353, '14:15:00.000000', '14:15:00.000000', 0xce1d190fa8d44fb997288c0003ea088d);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `type_product`
--

CREATE TABLE `type_product` (
  `id` binary(16) NOT NULL,
  `tipe_produc_name` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `type_product`
--

INSERT INTO `type_product` (`id`, `tipe_produc_name`) VALUES
(0x14000155076a45409952c7b54a2ec883, 'ropa'),
(0x79c1dc2cd5cc448387366e0d25a81fad, 'Agua de Mesa'),
(0xc329084d0d304393945df2efb1b01345, 'Agua Mineral'),
(0xc7abebb023094fa480554f65787c04da, 'pollo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubdepartamento`
--

CREATE TABLE `ubdepartamento` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `pais_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ubdepartamento`
--

INSERT INTO `ubdepartamento` (`id`, `nombre`, `pais_id`) VALUES
(1, 'AMAZONAS', 1),
(2, 'ANCASH', 1),
(3, 'APURIMAC', 1),
(4, 'AREQUIPA', 1),
(5, 'AYACUCHO', 1),
(6, 'CAJAMARCA', 1),
(7, 'CALLAO', 1),
(8, 'CUSCO', 1),
(9, 'HUANCAVELICA', 1),
(10, 'HUANUCO', 1),
(11, 'ICA', 1),
(12, 'JUNIN', 1),
(13, 'LA LIBERTAD', 1),
(14, 'LAMBAYEQUE', 1),
(15, 'LIMA', 1),
(16, 'LORETO', 1),
(17, 'MADRE DE DIOS', 1),
(18, 'MOQUEGUA', 1),
(19, 'PASCO', 1),
(20, 'PIURA', 1),
(21, 'PUNO', 1),
(22, 'SAN MARTIN', 1),
(23, 'TACNA', 1),
(24, 'TUMBES', 1),
(25, 'UCAYALI', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubdistrito`
--

CREATE TABLE `ubdistrito` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `id_prov` bigint(20) DEFAULT NULL,
  `foto_url` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ubdistrito`
--

INSERT INTO `ubdistrito` (`id`, `nombre`, `id_prov`, `foto_url`) VALUES
(1, 'CHACHAPOYAS', 1, 'portadaAppDelHambre1.jpg'),
(2, 'ASUNCION', 1, 'portadaAppDelHambre1.jpg'),
(3, 'BALSAS', 1, 'portadaAppDelHambre1.jpg'),
(4, 'CHETO', 1, 'portadaAppDelHambre1.jpg'),
(5, 'CHILIQUIN', 1, 'portadaAppDelHambre1.jpg'),
(6, 'CHUQUIBAMBA', 1, 'portadaAppDelHambre1.jpg'),
(7, 'GRANADA', 1, 'portadaAppDelHambre1.jpg'),
(8, 'HUANCAS', 1, 'portadaAppDelHambre1.jpg'),
(9, 'LA JALCA', 1, 'portadaAppDelHambre1.jpg'),
(10, 'LEIMEBAMBA', 1, 'portadaAppDelHambre1.jpg'),
(11, 'LEVANTO', 1, 'portadaAppDelHambre1.jpg'),
(12, 'MAGDALENA', 1, 'portadaAppDelHambre1.jpg'),
(13, 'MARISCAL CASTILLA', 1, 'portadaAppDelHambre1.jpg'),
(14, 'MOLINOPAMPA', 1, 'portadaAppDelHambre1.jpg'),
(15, 'MONTEVIDEO', 1, 'portadaAppDelHambre1.jpg'),
(16, 'OLLEROS', 1, 'portadaAppDelHambre1.jpg'),
(17, 'QUINJALCA', 1, 'portadaAppDelHambre1.jpg'),
(18, 'SAN FRANCISCO DE DAGUAS', 1, 'portadaAppDelHambre1.jpg'),
(19, 'SAN ISIDRO DE MAINO', 1, 'portadaAppDelHambre1.jpg'),
(20, 'SOLOCO', 1, 'portadaAppDelHambre1.jpg'),
(21, 'SONCHE', 1, 'portadaAppDelHambre1.jpg'),
(22, 'LA PECA', 2, 'portadaAppDelHambre1.jpg'),
(23, 'ARAMANGO', 2, 'portadaAppDelHambre1.jpg'),
(24, 'COPALLIN', 2, 'portadaAppDelHambre1.jpg'),
(25, 'EL PARCO', 2, 'portadaAppDelHambre1.jpg'),
(26, 'IMAZA', 2, 'portadaAppDelHambre1.jpg'),
(27, 'JUMBILLA', 3, 'portadaAppDelHambre1.jpg'),
(28, 'CHISQUILLA', 3, 'portadaAppDelHambre1.jpg'),
(29, 'CHURUJA', 3, 'portadaAppDelHambre1.jpg'),
(30, 'COROSHA', 3, 'portadaAppDelHambre1.jpg'),
(31, 'CUISPES', 3, 'portadaAppDelHambre1.jpg'),
(32, 'FLORIDA', 3, 'portadaAppDelHambre1.jpg'),
(33, 'JAZAN', 3, 'portadaAppDelHambre1.jpg'),
(34, 'RECTA', 3, 'portadaAppDelHambre1.jpg'),
(35, 'SAN CARLOS', 3, 'portadaAppDelHambre1.jpg'),
(36, 'SHIPASBAMBA', 3, 'portadaAppDelHambre1.jpg'),
(37, 'VALERA', 3, 'portadaAppDelHambre1.jpg'),
(38, 'YAMBRASBAMBA', 3, 'portadaAppDelHambre1.jpg'),
(39, 'NIEVA', 4, 'portadaAppDelHambre1.jpg'),
(40, 'EL CENEPA', 4, 'portadaAppDelHambre1.jpg'),
(41, 'RIO SANTIAGO', 4, 'portadaAppDelHambre1.jpg'),
(42, 'LAMUD', 5, 'portadaAppDelHambre1.jpg'),
(43, 'CAMPORREDONDO', 5, 'portadaAppDelHambre1.jpg'),
(44, 'COCABAMBA', 5, 'portadaAppDelHambre1.jpg'),
(45, 'COLCAMAR', 5, 'portadaAppDelHambre1.jpg'),
(46, 'CONILA', 5, 'portadaAppDelHambre1.jpg'),
(47, 'INGUILPATA', 5, 'portadaAppDelHambre1.jpg'),
(48, 'LONGUITA', 5, 'portadaAppDelHambre1.jpg'),
(49, 'LONYA CHICO', 5, 'portadaAppDelHambre1.jpg'),
(50, 'LUYA', 5, 'portadaAppDelHambre1.jpg'),
(51, 'LUYA VIEJO', 5, 'portadaAppDelHambre1.jpg'),
(52, 'MARIA', 5, 'portadaAppDelHambre1.jpg'),
(53, 'OCALLI', 5, 'portadaAppDelHambre1.jpg'),
(54, 'OCUMAL', 5, 'portadaAppDelHambre1.jpg'),
(55, 'PISUQUIA', 5, 'portadaAppDelHambre1.jpg'),
(56, 'PROVIDENCIA', 5, 'portadaAppDelHambre1.jpg'),
(57, 'SAN CRISTOBAL', 5, 'portadaAppDelHambre1.jpg'),
(58, 'SAN FRANCISCO DEL YESO', 5, 'portadaAppDelHambre1.jpg'),
(59, 'SAN JERONIMO', 5, 'portadaAppDelHambre1.jpg'),
(60, 'SAN JUAN DE LOPECANCHA', 5, 'portadaAppDelHambre1.jpg'),
(61, 'SANTA CATALINA', 5, 'portadaAppDelHambre1.jpg'),
(62, 'SANTO TOMAS', 5, 'portadaAppDelHambre1.jpg'),
(63, 'TINGO', 5, 'portadaAppDelHambre1.jpg'),
(64, 'TRITA', 5, 'portadaAppDelHambre1.jpg'),
(65, 'SAN NICOLAS', 6, 'portadaAppDelHambre1.jpg'),
(66, 'CHIRIMOTO', 6, 'portadaAppDelHambre1.jpg'),
(67, 'COCHAMAL', 6, 'portadaAppDelHambre1.jpg'),
(68, 'HUAMBO', 6, 'portadaAppDelHambre1.jpg'),
(69, 'LIMABAMBA', 6, 'portadaAppDelHambre1.jpg'),
(70, 'LONGAR', 6, 'portadaAppDelHambre1.jpg'),
(71, 'MARISCAL BENAVIDES', 6, 'portadaAppDelHambre1.jpg'),
(72, 'MILPUC', 6, 'portadaAppDelHambre1.jpg'),
(73, 'OMIA', 6, 'portadaAppDelHambre1.jpg'),
(74, 'SANTA ROSA', 6, 'portadaAppDelHambre1.jpg'),
(75, 'TOTORA', 6, 'portadaAppDelHambre1.jpg'),
(76, 'VISTA ALEGRE', 6, 'portadaAppDelHambre1.jpg'),
(77, 'BAGUA GRANDE', 7, 'portadaAppDelHambre1.jpg'),
(78, 'CAJARURO', 7, 'portadaAppDelHambre1.jpg'),
(79, 'CUMBA', 7, 'portadaAppDelHambre1.jpg'),
(80, 'EL MILAGRO', 7, 'portadaAppDelHambre1.jpg'),
(81, 'JAMALCA', 7, 'portadaAppDelHambre1.jpg'),
(82, 'LONYA GRANDE', 7, 'portadaAppDelHambre1.jpg'),
(83, 'YAMON', 7, 'portadaAppDelHambre1.jpg'),
(84, 'HUARAZ', 8, 'portadaAppDelHambre1.jpg'),
(85, 'COCHABAMBA', 8, 'portadaAppDelHambre1.jpg'),
(86, 'COLCABAMBA', 8, 'portadaAppDelHambre1.jpg'),
(87, 'HUANCHAY', 8, 'portadaAppDelHambre1.jpg'),
(88, 'INDEPENDENCIA', 8, 'portadaAppDelHambre1.jpg'),
(89, 'JANGAS', 8, 'portadaAppDelHambre1.jpg'),
(90, 'LA LIBERTAD', 8, 'portadaAppDelHambre1.jpg'),
(91, 'OLLEROS', 8, 'portadaAppDelHambre1.jpg'),
(92, 'PAMPAS', 8, 'portadaAppDelHambre1.jpg'),
(93, 'PARIACOTO', 8, 'portadaAppDelHambre1.jpg'),
(94, 'PIRA', 8, 'portadaAppDelHambre1.jpg'),
(95, 'TARICA', 8, 'portadaAppDelHambre1.jpg'),
(96, 'AIJA', 9, 'portadaAppDelHambre1.jpg'),
(97, 'CORIS', 9, 'portadaAppDelHambre1.jpg'),
(98, 'HUACLLAN', 9, 'portadaAppDelHambre1.jpg'),
(99, 'LA MERCED', 9, 'portadaAppDelHambre1.jpg'),
(100, 'SUCCHA', 9, 'portadaAppDelHambre1.jpg'),
(101, 'LLAMELLIN', 10, 'portadaAppDelHambre1.jpg'),
(102, 'ACZO', 10, 'portadaAppDelHambre1.jpg'),
(103, 'CHACCHO', 10, 'portadaAppDelHambre1.jpg'),
(104, 'CHINGAS', 10, 'portadaAppDelHambre1.jpg'),
(105, 'MIRGAS', 10, 'portadaAppDelHambre1.jpg'),
(106, 'SAN JUAN DE RONTOY', 10, 'portadaAppDelHambre1.jpg'),
(107, 'CHACAS', 11, 'portadaAppDelHambre1.jpg'),
(108, 'ACOCHACA', 11, 'portadaAppDelHambre1.jpg'),
(109, 'CHIQUIAN', 12, 'portadaAppDelHambre1.jpg'),
(110, 'ABELARDO PARDO LEZAMETA', 12, 'portadaAppDelHambre1.jpg'),
(111, 'ANTONIO RAYMONDI', 12, 'portadaAppDelHambre1.jpg'),
(112, 'AQUIA', 12, 'portadaAppDelHambre1.jpg'),
(113, 'CAJACAY', 12, 'portadaAppDelHambre1.jpg'),
(114, 'CANIS', 12, 'portadaAppDelHambre1.jpg'),
(115, 'COLQUIOC', 12, 'portadaAppDelHambre1.jpg'),
(116, 'HUALLANCA', 12, 'portadaAppDelHambre1.jpg'),
(117, 'HUASTA', 12, 'portadaAppDelHambre1.jpg'),
(118, 'HUAYLLACAYAN', 12, 'portadaAppDelHambre1.jpg'),
(119, 'LA PRIMAVERA', 12, 'portadaAppDelHambre1.jpg'),
(120, 'MANGAS', 12, 'portadaAppDelHambre1.jpg'),
(121, 'PACLLON', 12, 'portadaAppDelHambre1.jpg'),
(122, 'SAN MIGUEL DE CORPANQUI', 12, 'portadaAppDelHambre1.jpg'),
(123, 'TICLLOS', 12, 'portadaAppDelHambre1.jpg'),
(124, 'CARHUAZ', 13, 'portadaAppDelHambre1.jpg'),
(125, 'ACOPAMPA', 13, 'portadaAppDelHambre1.jpg'),
(126, 'AMASHCA', 13, 'portadaAppDelHambre1.jpg'),
(127, 'ANTA', 13, 'portadaAppDelHambre1.jpg'),
(128, 'ATAQUERO', 13, 'portadaAppDelHambre1.jpg'),
(129, 'MARCARA', 13, 'portadaAppDelHambre1.jpg'),
(130, 'PARIAHUANCA', 13, 'portadaAppDelHambre1.jpg'),
(131, 'SAN MIGUEL DE ACO', 13, 'portadaAppDelHambre1.jpg'),
(132, 'SHILLA', 13, 'portadaAppDelHambre1.jpg'),
(133, 'TINCO', 13, 'portadaAppDelHambre1.jpg'),
(134, 'YUNGAR', 13, 'portadaAppDelHambre1.jpg'),
(135, 'SAN LUIS', 14, 'portadaAppDelHambre1.jpg'),
(136, 'SAN NICOLAS', 14, 'portadaAppDelHambre1.jpg'),
(137, 'YAUYA', 14, 'portadaAppDelHambre1.jpg'),
(138, 'CASMA', 15, 'portadaAppDelHambre1.jpg'),
(139, 'BUENA VISTA ALTA', 15, 'portadaAppDelHambre1.jpg'),
(140, 'COMANDANTE NOEL', 15, 'portadaAppDelHambre1.jpg'),
(141, 'YAUTAN', 15, 'portadaAppDelHambre1.jpg'),
(142, 'CORONGO', 16, 'portadaAppDelHambre1.jpg'),
(143, 'ACO', 16, 'portadaAppDelHambre1.jpg'),
(144, 'BAMBAS', 16, 'portadaAppDelHambre1.jpg'),
(145, 'CUSCA', 16, 'portadaAppDelHambre1.jpg'),
(146, 'LA PAMPA', 16, 'portadaAppDelHambre1.jpg'),
(147, 'YANAC', 16, 'portadaAppDelHambre1.jpg'),
(148, 'YUPAN', 16, 'portadaAppDelHambre1.jpg'),
(149, 'HUARI', 17, 'portadaAppDelHambre1.jpg'),
(150, 'ANRA', 17, 'portadaAppDelHambre1.jpg'),
(151, 'CAJAY', 17, 'portadaAppDelHambre1.jpg'),
(152, 'CHAVIN DE HUANTAR', 17, 'portadaAppDelHambre1.jpg'),
(153, 'HUACACHI', 17, 'portadaAppDelHambre1.jpg'),
(154, 'HUACCHIS', 17, 'portadaAppDelHambre1.jpg'),
(155, 'HUACHIS', 17, 'portadaAppDelHambre1.jpg'),
(156, 'HUANTAR', 17, 'portadaAppDelHambre1.jpg'),
(157, 'MASIN', 17, 'portadaAppDelHambre1.jpg'),
(158, 'PAUCAS', 17, 'portadaAppDelHambre1.jpg'),
(159, 'PONTO', 17, 'portadaAppDelHambre1.jpg'),
(160, 'RAHUAPAMPA', 17, 'portadaAppDelHambre1.jpg'),
(161, 'RAPAYAN', 17, 'portadaAppDelHambre1.jpg'),
(162, 'SAN MARCOS', 17, 'portadaAppDelHambre1.jpg'),
(163, 'SAN PEDRO DE CHANA', 17, 'portadaAppDelHambre1.jpg'),
(164, 'UCO', 17, 'portadaAppDelHambre1.jpg'),
(165, 'HUARMEY', 18, 'portadaAppDelHambre1.jpg'),
(166, 'COCHAPETI', 18, 'portadaAppDelHambre1.jpg'),
(167, 'CULEBRAS', 18, 'portadaAppDelHambre1.jpg'),
(168, 'HUAYAN', 18, 'portadaAppDelHambre1.jpg'),
(169, 'MALVAS', 18, 'portadaAppDelHambre1.jpg'),
(170, 'CARAZ', 26, 'portadaAppDelHambre1.jpg'),
(171, 'HUALLANCA', 26, 'portadaAppDelHambre1.jpg'),
(172, 'HUATA', 26, 'portadaAppDelHambre1.jpg'),
(173, 'HUAYLAS', 26, 'portadaAppDelHambre1.jpg'),
(174, 'MATO', 26, 'portadaAppDelHambre1.jpg'),
(175, 'PAMPAROMAS', 26, 'portadaAppDelHambre1.jpg'),
(176, 'PUEBLO LIBRE', 26, 'portadaAppDelHambre1.jpg'),
(177, 'SANTA CRUZ', 26, 'portadaAppDelHambre1.jpg'),
(178, 'SANTO TORIBIO', 26, 'portadaAppDelHambre1.jpg'),
(179, 'YURACMARCA', 26, 'portadaAppDelHambre1.jpg'),
(180, 'PISCOBAMBA', 27, 'portadaAppDelHambre1.jpg'),
(181, 'CASCA', 27, 'portadaAppDelHambre1.jpg'),
(182, 'ELEAZAR GUZMAN BARRON', 27, 'portadaAppDelHambre1.jpg'),
(183, 'FIDEL OLIVAS ESCUDERO', 27, 'portadaAppDelHambre1.jpg'),
(184, 'LLAMA', 27, 'portadaAppDelHambre1.jpg'),
(185, 'LLUMPA', 27, 'portadaAppDelHambre1.jpg'),
(186, 'LUCMA', 27, 'portadaAppDelHambre1.jpg'),
(187, 'MUSGA', 27, 'portadaAppDelHambre1.jpg'),
(188, 'OCROS', 21, 'portadaAppDelHambre1.jpg'),
(189, 'ACAS', 21, 'portadaAppDelHambre1.jpg'),
(190, 'CAJAMARQUILLA', 21, 'portadaAppDelHambre1.jpg'),
(191, 'CARHUAPAMPA', 21, 'portadaAppDelHambre1.jpg'),
(192, 'COCHAS', 21, 'portadaAppDelHambre1.jpg'),
(193, 'CONGAS', 21, 'portadaAppDelHambre1.jpg'),
(194, 'LLIPA', 21, 'portadaAppDelHambre1.jpg'),
(195, 'SAN CRISTOBAL DE RAJAN', 21, 'portadaAppDelHambre1.jpg'),
(196, 'SAN PEDRO', 21, 'portadaAppDelHambre1.jpg'),
(197, 'SANTIAGO DE CHILCAS', 21, 'portadaAppDelHambre1.jpg'),
(198, 'CABANA', 22, 'portadaAppDelHambre1.jpg'),
(199, 'BOLOGNESI', 22, 'portadaAppDelHambre1.jpg'),
(200, 'CONCHUCOS', 22, 'portadaAppDelHambre1.jpg'),
(201, 'HUACASCHUQUE', 22, 'portadaAppDelHambre1.jpg'),
(202, 'HUANDOVAL', 22, 'portadaAppDelHambre1.jpg'),
(203, 'LACABAMBA', 22, 'portadaAppDelHambre1.jpg'),
(204, 'LLAPO', 22, 'portadaAppDelHambre1.jpg'),
(205, 'PALLASCA', 22, 'portadaAppDelHambre1.jpg'),
(206, 'PAMPAS', 22, 'portadaAppDelHambre1.jpg'),
(207, 'SANTA ROSA', 22, 'portadaAppDelHambre1.jpg'),
(208, 'TAUCA', 22, 'portadaAppDelHambre1.jpg'),
(209, 'POMABAMBA', 23, 'portadaAppDelHambre1.jpg'),
(210, 'HUAYLLAN', 23, 'portadaAppDelHambre1.jpg'),
(211, 'PAROBAMBA', 23, 'portadaAppDelHambre1.jpg'),
(212, 'QUINUABAMBA', 23, 'portadaAppDelHambre1.jpg'),
(213, 'RECUAY', 24, 'portadaAppDelHambre1.jpg'),
(214, 'CATAC', 24, 'portadaAppDelHambre1.jpg'),
(215, 'COTAPARACO', 24, 'portadaAppDelHambre1.jpg'),
(216, 'HUAYLLAPAMPA', 24, 'portadaAppDelHambre1.jpg'),
(217, 'LLACLLIN', 24, 'portadaAppDelHambre1.jpg'),
(218, 'MARCA', 24, 'portadaAppDelHambre1.jpg'),
(219, 'PAMPAS CHICO', 24, 'portadaAppDelHambre1.jpg'),
(220, 'PARARIN', 24, 'portadaAppDelHambre1.jpg'),
(221, 'TAPACOCHA', 24, 'portadaAppDelHambre1.jpg'),
(222, 'TICAPAMPA', 24, 'portadaAppDelHambre1.jpg'),
(223, 'CHIMBOTE', 25, 'portadaAppDelHambre1.jpg'),
(224, 'CACERES DEL PERU', 25, 'portadaAppDelHambre1.jpg'),
(225, 'COISHCO', 25, 'portadaAppDelHambre1.jpg'),
(226, 'MACATE', 25, 'portadaAppDelHambre1.jpg'),
(227, 'MORO', 25, 'portadaAppDelHambre1.jpg'),
(228, 'NEPE&Ntilde;A', 25, 'portadaAppDelHambre1.jpg'),
(229, 'SAMANCO', 25, 'portadaAppDelHambre1.jpg'),
(230, 'SANTA', 25, 'portadaAppDelHambre1.jpg'),
(231, 'NUEVO CHIMBOTE', 25, 'portadaAppDelHambre1.jpg'),
(232, 'SIHUAS', 26, 'portadaAppDelHambre1.jpg'),
(233, 'ACOBAMBA', 26, 'portadaAppDelHambre1.jpg'),
(234, 'ALFONSO UGARTE', 26, 'portadaAppDelHambre1.jpg'),
(235, 'CASHAPAMPA', 26, 'portadaAppDelHambre1.jpg'),
(236, 'CHINGALPO', 26, 'portadaAppDelHambre1.jpg'),
(237, 'HUAYLLABAMBA', 26, 'portadaAppDelHambre1.jpg'),
(238, 'QUICHES', 26, 'portadaAppDelHambre1.jpg'),
(239, 'RAGASH', 26, 'portadaAppDelHambre1.jpg'),
(240, 'SAN JUAN', 26, 'portadaAppDelHambre1.jpg'),
(241, 'SICSIBAMBA', 26, 'portadaAppDelHambre1.jpg'),
(242, 'YUNGAY', 27, 'portadaAppDelHambre1.jpg'),
(243, 'CASCAPARA', 27, 'portadaAppDelHambre1.jpg'),
(244, 'MANCOS', 27, 'portadaAppDelHambre1.jpg'),
(245, 'MATACOTO', 27, 'portadaAppDelHambre1.jpg'),
(246, 'QUILLO', 27, 'portadaAppDelHambre1.jpg'),
(247, 'RANRAHIRCA', 27, 'portadaAppDelHambre1.jpg'),
(248, 'SHUPLUY', 27, 'portadaAppDelHambre1.jpg'),
(249, 'YANAMA', 27, 'portadaAppDelHambre1.jpg'),
(250, 'ABANCAY', 28, 'portadaAppDelHambre1.jpg'),
(251, 'CHACOCHE', 28, 'portadaAppDelHambre1.jpg'),
(252, 'CIRCA', 28, 'portadaAppDelHambre1.jpg'),
(253, 'CURAHUASI', 28, 'portadaAppDelHambre1.jpg'),
(254, 'HUANIPACA', 28, 'portadaAppDelHambre1.jpg'),
(255, 'LAMBRAMA', 28, 'portadaAppDelHambre1.jpg'),
(256, 'PICHIRHUA', 28, 'portadaAppDelHambre1.jpg'),
(257, 'SAN PEDRO DE CACHORA', 28, 'portadaAppDelHambre1.jpg'),
(258, 'TAMBURCO', 28, 'portadaAppDelHambre1.jpg'),
(259, 'ANDAHUAYLAS', 29, 'portadaAppDelHambre1.jpg'),
(260, 'ANDARAPA', 29, 'portadaAppDelHambre1.jpg'),
(261, 'CHIARA', 29, 'portadaAppDelHambre1.jpg'),
(262, 'HUANCARAMA', 29, 'portadaAppDelHambre1.jpg'),
(263, 'HUANCARAY', 29, 'portadaAppDelHambre1.jpg'),
(264, 'HUAYANA', 29, 'portadaAppDelHambre1.jpg'),
(265, 'KISHUARA', 29, 'portadaAppDelHambre1.jpg'),
(266, 'PACOBAMBA', 29, 'portadaAppDelHambre1.jpg'),
(267, 'PACUCHA', 29, 'portadaAppDelHambre1.jpg'),
(268, 'PAMPACHIRI', 29, 'portadaAppDelHambre1.jpg'),
(269, 'POMACOCHA', 29, 'portadaAppDelHambre1.jpg'),
(270, 'SAN ANTONIO DE CACHI', 29, 'portadaAppDelHambre1.jpg'),
(271, 'SAN JERONIMO', 29, 'portadaAppDelHambre1.jpg'),
(272, 'SAN MIGUEL DE CHACCRAMPA', 29, 'portadaAppDelHambre1.jpg'),
(273, 'SANTA MARIA DE CHICMO', 29, 'portadaAppDelHambre1.jpg'),
(274, 'TALAVERA', 29, 'portadaAppDelHambre1.jpg'),
(275, 'TUMAY HUARACA', 29, 'portadaAppDelHambre1.jpg'),
(276, 'TURPO', 29, 'portadaAppDelHambre1.jpg'),
(277, 'KAQUIABAMBA', 29, 'portadaAppDelHambre1.jpg'),
(278, 'ANTABAMBA', 30, 'portadaAppDelHambre1.jpg'),
(279, 'EL ORO', 30, 'portadaAppDelHambre1.jpg'),
(280, 'HUAQUIRCA', 30, 'portadaAppDelHambre1.jpg'),
(281, 'JUAN ESPINOZA MEDRANO', 30, 'portadaAppDelHambre1.jpg'),
(282, 'OROPESA', 30, 'portadaAppDelHambre1.jpg'),
(283, 'PACHACONAS', 30, 'portadaAppDelHambre1.jpg'),
(284, 'SABAINO', 30, 'portadaAppDelHambre1.jpg'),
(285, 'CHALHUANCA', 31, 'portadaAppDelHambre1.jpg'),
(286, 'CAPAYA', 31, 'portadaAppDelHambre1.jpg'),
(287, 'CARAYBAMBA', 31, 'portadaAppDelHambre1.jpg'),
(288, 'CHAPIMARCA', 31, 'portadaAppDelHambre1.jpg'),
(289, 'COLCABAMBA', 31, 'portadaAppDelHambre1.jpg'),
(290, 'COTARUSE', 31, 'portadaAppDelHambre1.jpg'),
(291, 'HUAYLLO', 31, 'portadaAppDelHambre1.jpg'),
(292, 'JUSTO APU SAHUARAURA', 31, 'portadaAppDelHambre1.jpg'),
(293, 'LUCRE', 31, 'portadaAppDelHambre1.jpg'),
(294, 'POCOHUANCA', 31, 'portadaAppDelHambre1.jpg'),
(295, 'SAN JUAN DE CHAC&Ntilde;A', 31, 'portadaAppDelHambre1.jpg'),
(296, 'SA&Ntilde;AYCA', 31, 'portadaAppDelHambre1.jpg'),
(297, 'SORAYA', 31, 'portadaAppDelHambre1.jpg'),
(298, 'TAPAIRIHUA', 31, 'portadaAppDelHambre1.jpg'),
(299, 'TINTAY', 31, 'portadaAppDelHambre1.jpg'),
(300, 'TORAYA', 31, 'portadaAppDelHambre1.jpg'),
(301, 'YANACA', 31, 'portadaAppDelHambre1.jpg'),
(302, 'TAMBOBAMBA', 32, 'portadaAppDelHambre1.jpg'),
(303, 'COTABAMBAS', 32, 'portadaAppDelHambre1.jpg'),
(304, 'COYLLURQUI', 32, 'portadaAppDelHambre1.jpg'),
(305, 'HAQUIRA', 32, 'portadaAppDelHambre1.jpg'),
(306, 'MARA', 32, 'portadaAppDelHambre1.jpg'),
(307, 'CHALLHUAHUACHO', 32, 'portadaAppDelHambre1.jpg'),
(308, 'CHINCHEROS', 33, 'portadaAppDelHambre1.jpg'),
(309, 'ANCO-HUALLO', 33, 'portadaAppDelHambre1.jpg'),
(310, 'COCHARCAS', 33, 'portadaAppDelHambre1.jpg'),
(311, 'HUACCANA', 33, 'portadaAppDelHambre1.jpg'),
(312, 'OCOBAMBA', 33, 'portadaAppDelHambre1.jpg'),
(313, 'ONGOY', 33, 'portadaAppDelHambre1.jpg'),
(314, 'URANMARCA', 33, 'portadaAppDelHambre1.jpg'),
(315, 'RANRACANCHA', 33, 'portadaAppDelHambre1.jpg'),
(316, 'CHUQUIBAMBILLA', 34, 'portadaAppDelHambre1.jpg'),
(317, 'CURPAHUASI', 34, 'portadaAppDelHambre1.jpg'),
(318, 'GAMARRA', 34, 'portadaAppDelHambre1.jpg'),
(319, 'HUAYLLATI', 34, 'portadaAppDelHambre1.jpg'),
(320, 'MAMARA', 34, 'portadaAppDelHambre1.jpg'),
(321, 'MICAELA BASTIDAS', 34, 'portadaAppDelHambre1.jpg'),
(322, 'PATAYPAMPA', 34, 'portadaAppDelHambre1.jpg'),
(323, 'PROGRESO', 34, 'portadaAppDelHambre1.jpg'),
(324, 'SAN ANTONIO', 34, 'portadaAppDelHambre1.jpg'),
(325, 'SANTA ROSA', 34, 'portadaAppDelHambre1.jpg'),
(326, 'TURPAY', 34, 'portadaAppDelHambre1.jpg'),
(327, 'VILCABAMBA', 34, 'portadaAppDelHambre1.jpg'),
(328, 'VIRUNDO', 34, 'portadaAppDelHambre1.jpg'),
(329, 'CURASCO', 34, 'portadaAppDelHambre1.jpg'),
(330, 'AREQUIPA', 35, 'portadaAppDelHambre1.jpg'),
(331, 'ALTO SELVA ALEGRE', 35, 'portadaAppDelHambre1.jpg'),
(332, 'CAYMA', 35, 'portadaAppDelHambre1.jpg'),
(333, 'CERRO COLORADO', 35, 'portadaAppDelHambre1.jpg'),
(334, 'CHARACATO', 35, 'portadaAppDelHambre1.jpg'),
(335, 'CHIGUATA', 35, 'portadaAppDelHambre1.jpg'),
(336, 'JACOBO HUNTER', 35, 'portadaAppDelHambre1.jpg'),
(337, 'LA JOYA', 35, 'portadaAppDelHambre1.jpg'),
(338, 'MARIANO MELGAR', 35, 'portadaAppDelHambre1.jpg'),
(339, 'MIRAFLORES', 35, 'portadaAppDelHambre1.jpg'),
(340, 'MOLLEBAYA', 35, 'portadaAppDelHambre1.jpg'),
(341, 'PAUCARPATA', 35, 'portadaAppDelHambre1.jpg'),
(342, 'POCSI', 35, 'portadaAppDelHambre1.jpg'),
(343, 'POLOBAYA', 35, 'portadaAppDelHambre1.jpg'),
(344, 'QUEQUE&Ntilde;A', 35, 'portadaAppDelHambre1.jpg'),
(345, 'SABANDIA', 35, 'portadaAppDelHambre1.jpg'),
(346, 'SACHACA', 35, 'portadaAppDelHambre1.jpg'),
(347, 'SAN JUAN DE SIGUAS', 35, 'portadaAppDelHambre1.jpg'),
(348, 'SAN JUAN DE TARUCANI', 35, 'portadaAppDelHambre1.jpg'),
(349, 'SANTA ISABEL DE SIGUAS', 35, 'portadaAppDelHambre1.jpg'),
(350, 'SANTA RITA DE SIGUAS', 35, 'portadaAppDelHambre1.jpg'),
(351, 'SOCABAYA', 35, 'portadaAppDelHambre1.jpg'),
(352, 'TIABAYA', 35, 'portadaAppDelHambre1.jpg'),
(353, 'UCHUMAYO', 35, 'portadaAppDelHambre1.jpg'),
(354, 'VITOR', 35, 'portadaAppDelHambre1.jpg'),
(355, 'YANAHUARA', 35, 'portadaAppDelHambre1.jpg'),
(356, 'YARABAMBA', 35, 'portadaAppDelHambre1.jpg'),
(357, 'YURA', 35, 'portadaAppDelHambre1.jpg'),
(358, 'JOSE LUIS BUSTAMANTE Y RIVERO', 35, 'portadaAppDelHambre1.jpg'),
(359, 'CAMANA', 36, 'portadaAppDelHambre1.jpg'),
(360, 'JOSE MARIA QUIMPER', 36, 'portadaAppDelHambre1.jpg'),
(361, 'MARIANO NICOLAS VALCARCEL', 36, 'portadaAppDelHambre1.jpg'),
(362, 'MARISCAL CACERES', 36, 'portadaAppDelHambre1.jpg'),
(363, 'NICOLAS DE PIEROLA', 36, 'portadaAppDelHambre1.jpg'),
(364, 'OCO&Ntilde;A', 36, 'portadaAppDelHambre1.jpg'),
(365, 'QUILCA', 36, 'portadaAppDelHambre1.jpg'),
(366, 'SAMUEL PASTOR', 36, 'portadaAppDelHambre1.jpg'),
(367, 'CARAVELI', 37, 'portadaAppDelHambre1.jpg'),
(368, 'ACARI', 37, 'portadaAppDelHambre1.jpg'),
(369, 'ATICO', 37, 'portadaAppDelHambre1.jpg'),
(370, 'ATIQUIPA', 37, 'portadaAppDelHambre1.jpg'),
(371, 'BELLA UNION', 37, 'portadaAppDelHambre1.jpg'),
(372, 'CAHUACHO', 37, 'portadaAppDelHambre1.jpg'),
(373, 'CHALA', 37, 'portadaAppDelHambre1.jpg'),
(374, 'CHAPARRA', 37, 'portadaAppDelHambre1.jpg'),
(375, 'HUANUHUANU', 37, 'portadaAppDelHambre1.jpg'),
(376, 'JAQUI', 37, 'portadaAppDelHambre1.jpg'),
(377, 'LOMAS', 37, 'portadaAppDelHambre1.jpg'),
(378, 'QUICACHA', 37, 'portadaAppDelHambre1.jpg'),
(379, 'YAUCA', 37, 'portadaAppDelHambre1.jpg'),
(380, 'APLAO', 38, 'portadaAppDelHambre1.jpg'),
(381, 'ANDAGUA', 38, 'portadaAppDelHambre1.jpg'),
(382, 'AYO', 38, 'portadaAppDelHambre1.jpg'),
(383, 'CHACHAS', 38, 'portadaAppDelHambre1.jpg'),
(384, 'CHILCAYMARCA', 38, 'portadaAppDelHambre1.jpg'),
(385, 'CHOCO', 38, 'portadaAppDelHambre1.jpg'),
(386, 'HUANCARQUI', 38, 'portadaAppDelHambre1.jpg'),
(387, 'MACHAGUAY', 38, 'portadaAppDelHambre1.jpg'),
(388, 'ORCOPAMPA', 38, 'portadaAppDelHambre1.jpg'),
(389, 'PAMPACOLCA', 38, 'portadaAppDelHambre1.jpg'),
(390, 'TIPAN', 38, 'portadaAppDelHambre1.jpg'),
(391, 'U&Ntilde;ON', 38, 'portadaAppDelHambre1.jpg'),
(392, 'URACA', 38, 'portadaAppDelHambre1.jpg'),
(393, 'VIRACO', 38, 'portadaAppDelHambre1.jpg'),
(394, 'CHIVAY', 39, 'portadaAppDelHambre1.jpg'),
(395, 'ACHOMA', 39, 'portadaAppDelHambre1.jpg'),
(396, 'CABANACONDE', 39, 'portadaAppDelHambre1.jpg'),
(397, 'CALLALLI', 39, 'portadaAppDelHambre1.jpg'),
(398, 'CAYLLOMA', 39, 'portadaAppDelHambre1.jpg'),
(399, 'COPORAQUE', 39, 'portadaAppDelHambre1.jpg'),
(400, 'HUAMBO', 39, 'portadaAppDelHambre1.jpg'),
(401, 'HUANCA', 39, 'portadaAppDelHambre1.jpg'),
(402, 'ICHUPAMPA', 39, 'portadaAppDelHambre1.jpg'),
(403, 'LARI', 39, 'portadaAppDelHambre1.jpg'),
(404, 'LLUTA', 39, 'portadaAppDelHambre1.jpg'),
(405, 'MACA', 39, 'portadaAppDelHambre1.jpg'),
(406, 'MADRIGAL', 39, 'portadaAppDelHambre1.jpg'),
(407, 'SAN ANTONIO DE CHUCA', 39, 'portadaAppDelHambre1.jpg'),
(408, 'SIBAYO', 39, 'portadaAppDelHambre1.jpg'),
(409, 'TAPAY', 39, 'portadaAppDelHambre1.jpg'),
(410, 'TISCO', 39, 'portadaAppDelHambre1.jpg'),
(411, 'TUTI', 39, 'portadaAppDelHambre1.jpg'),
(412, 'YANQUE', 39, 'portadaAppDelHambre1.jpg'),
(413, 'MAJES', 39, 'portadaAppDelHambre1.jpg'),
(414, 'CHUQUIBAMBA', 40, 'portadaAppDelHambre1.jpg'),
(415, 'ANDARAY', 40, 'portadaAppDelHambre1.jpg'),
(416, 'CAYARANI', 40, 'portadaAppDelHambre1.jpg'),
(417, 'CHICHAS', 40, 'portadaAppDelHambre1.jpg'),
(418, 'IRAY', 40, 'portadaAppDelHambre1.jpg'),
(419, 'RIO GRANDE', 40, 'portadaAppDelHambre1.jpg'),
(420, 'SALAMANCA', 40, 'portadaAppDelHambre1.jpg'),
(421, 'YANAQUIHUA', 40, 'portadaAppDelHambre1.jpg'),
(422, 'MOLLENDO', 41, 'portadaAppDelHambre1.jpg'),
(423, 'COCACHACRA', 41, 'portadaAppDelHambre1.jpg'),
(424, 'DEAN VALDIVIA', 41, 'portadaAppDelHambre1.jpg'),
(425, 'ISLAY', 41, 'portadaAppDelHambre1.jpg'),
(426, 'MEJIA', 41, 'portadaAppDelHambre1.jpg'),
(427, 'PUNTA DE BOMBON', 41, 'portadaAppDelHambre1.jpg'),
(428, 'COTAHUASI', 42, 'portadaAppDelHambre1.jpg'),
(429, 'ALCA', 42, 'portadaAppDelHambre1.jpg'),
(430, 'CHARCANA', 42, 'portadaAppDelHambre1.jpg'),
(431, 'HUAYNACOTAS', 42, 'portadaAppDelHambre1.jpg'),
(432, 'PAMPAMARCA', 42, 'portadaAppDelHambre1.jpg'),
(433, 'PUYCA', 42, 'portadaAppDelHambre1.jpg'),
(434, 'QUECHUALLA', 42, 'portadaAppDelHambre1.jpg'),
(435, 'SAYLA', 42, 'portadaAppDelHambre1.jpg'),
(436, 'TAURIA', 42, 'portadaAppDelHambre1.jpg'),
(437, 'TOMEPAMPA', 42, 'portadaAppDelHambre1.jpg'),
(438, 'TORO', 42, 'portadaAppDelHambre1.jpg'),
(439, 'AYACUCHO', 43, 'portadaAppDelHambre1.jpg'),
(440, 'ACOCRO', 43, 'portadaAppDelHambre1.jpg'),
(441, 'ACOS VINCHOS', 43, 'portadaAppDelHambre1.jpg'),
(442, 'CARMEN ALTO', 43, 'portadaAppDelHambre1.jpg'),
(443, 'CHIARA', 43, 'portadaAppDelHambre1.jpg'),
(444, 'OCROS', 43, 'portadaAppDelHambre1.jpg'),
(445, 'PACAYCASA', 43, 'portadaAppDelHambre1.jpg'),
(446, 'QUINUA', 43, 'portadaAppDelHambre1.jpg'),
(447, 'SAN JOSE DE TICLLAS', 43, 'portadaAppDelHambre1.jpg'),
(448, 'SAN JUAN BAUTISTA', 43, 'portadaAppDelHambre1.jpg'),
(449, 'SANTIAGO DE PISCHA', 43, 'portadaAppDelHambre1.jpg'),
(450, 'SOCOS', 43, 'portadaAppDelHambre1.jpg'),
(451, 'TAMBILLO', 43, 'portadaAppDelHambre1.jpg'),
(452, 'VINCHOS', 43, 'portadaAppDelHambre1.jpg'),
(453, 'JESUS NAZARENO', 43, 'portadaAppDelHambre1.jpg'),
(454, 'CANGALLO', 44, 'portadaAppDelHambre1.jpg'),
(455, 'CHUSCHI', 44, 'portadaAppDelHambre1.jpg'),
(456, 'LOS MOROCHUCOS', 44, 'portadaAppDelHambre1.jpg'),
(457, 'MARIA PARADO DE BELLIDO', 44, 'portadaAppDelHambre1.jpg'),
(458, 'PARAS', 44, 'portadaAppDelHambre1.jpg'),
(459, 'TOTOS', 44, 'portadaAppDelHambre1.jpg'),
(460, 'SANCOS', 45, 'portadaAppDelHambre1.jpg'),
(461, 'CARAPO', 45, 'portadaAppDelHambre1.jpg'),
(462, 'SACSAMARCA', 45, 'portadaAppDelHambre1.jpg'),
(463, 'SANTIAGO DE LUCANAMARCA', 45, 'portadaAppDelHambre1.jpg'),
(464, 'HUANTA', 46, 'portadaAppDelHambre1.jpg'),
(465, 'AYAHUANCO', 46, 'portadaAppDelHambre1.jpg'),
(466, 'HUAMANGUILLA', 46, 'portadaAppDelHambre1.jpg'),
(467, 'IGUAIN', 46, 'portadaAppDelHambre1.jpg'),
(468, 'LURICOCHA', 46, 'portadaAppDelHambre1.jpg'),
(469, 'SANTILLANA', 46, 'portadaAppDelHambre1.jpg'),
(470, 'SIVIA', 46, 'portadaAppDelHambre1.jpg'),
(471, 'LLOCHEGUA', 46, 'portadaAppDelHambre1.jpg'),
(472, 'SAN MIGUEL', 47, 'portadaAppDelHambre1.jpg'),
(473, 'ANCO', 47, 'portadaAppDelHambre1.jpg'),
(474, 'AYNA', 47, 'portadaAppDelHambre1.jpg'),
(475, 'CHILCAS', 47, 'portadaAppDelHambre1.jpg'),
(476, 'CHUNGUI', 47, 'portadaAppDelHambre1.jpg'),
(477, 'LUIS CARRANZA', 47, 'portadaAppDelHambre1.jpg'),
(478, 'SANTA ROSA', 47, 'portadaAppDelHambre1.jpg'),
(479, 'TAMBO', 47, 'portadaAppDelHambre1.jpg'),
(480, 'PUQUIO', 48, 'portadaAppDelHambre1.jpg'),
(481, 'AUCARA', 48, 'portadaAppDelHambre1.jpg'),
(482, 'CABANA', 48, 'portadaAppDelHambre1.jpg'),
(483, 'CARMEN SALCEDO', 48, 'portadaAppDelHambre1.jpg'),
(484, 'CHAVI&Ntilde;A', 48, 'portadaAppDelHambre1.jpg'),
(485, 'CHIPAO', 48, 'portadaAppDelHambre1.jpg'),
(486, 'HUAC-HUAS', 48, 'portadaAppDelHambre1.jpg'),
(487, 'LARAMATE', 48, 'portadaAppDelHambre1.jpg'),
(488, 'LEONCIO PRADO', 48, 'portadaAppDelHambre1.jpg'),
(489, 'LLAUTA', 48, 'portadaAppDelHambre1.jpg'),
(490, 'LUCANAS', 48, 'portadaAppDelHambre1.jpg'),
(491, 'OCA&Ntilde;A', 48, 'portadaAppDelHambre1.jpg'),
(492, 'OTOCA', 48, 'portadaAppDelHambre1.jpg'),
(493, 'SAISA', 48, 'portadaAppDelHambre1.jpg'),
(494, 'SAN CRISTOBAL', 48, 'portadaAppDelHambre1.jpg'),
(495, 'SAN JUAN', 48, 'portadaAppDelHambre1.jpg'),
(496, 'SAN PEDRO', 48, 'portadaAppDelHambre1.jpg'),
(497, 'SAN PEDRO DE PALCO', 48, 'portadaAppDelHambre1.jpg'),
(498, 'SANCOS', 48, 'portadaAppDelHambre1.jpg'),
(499, 'SANTA ANA DE HUAYCAHUACHO', 48, 'portadaAppDelHambre1.jpg'),
(500, 'SANTA LUCIA', 48, 'portadaAppDelHambre1.jpg'),
(501, 'CORACORA', 49, 'portadaAppDelHambre1.jpg'),
(502, 'CHUMPI', 49, 'portadaAppDelHambre1.jpg'),
(503, 'CORONEL CASTA&Ntilde;EDA', 49, 'portadaAppDelHambre1.jpg'),
(504, 'PACAPAUSA', 49, 'portadaAppDelHambre1.jpg'),
(505, 'PULLO', 49, 'portadaAppDelHambre1.jpg'),
(506, 'PUYUSCA', 49, 'portadaAppDelHambre1.jpg'),
(507, 'SAN FRANCISCO DE RAVACAYCO', 49, 'portadaAppDelHambre1.jpg'),
(508, 'UPAHUACHO', 49, 'portadaAppDelHambre1.jpg'),
(509, 'PAUSA', 50, 'portadaAppDelHambre1.jpg'),
(510, 'COLTA', 50, 'portadaAppDelHambre1.jpg'),
(511, 'CORCULLA', 50, 'portadaAppDelHambre1.jpg'),
(512, 'LAMPA', 50, 'portadaAppDelHambre1.jpg'),
(513, 'MARCABAMBA', 50, 'portadaAppDelHambre1.jpg'),
(514, 'OYOLO', 50, 'portadaAppDelHambre1.jpg'),
(515, 'PARARCA', 50, 'portadaAppDelHambre1.jpg'),
(516, 'SAN JAVIER DE ALPABAMBA', 50, 'portadaAppDelHambre1.jpg'),
(517, 'SAN JOSE DE USHUA', 50, 'portadaAppDelHambre1.jpg'),
(518, 'SARA SARA', 50, 'portadaAppDelHambre1.jpg'),
(519, 'QUEROBAMBA', 51, 'portadaAppDelHambre1.jpg'),
(520, 'BELEN', 51, 'portadaAppDelHambre1.jpg'),
(521, 'CHALCOS', 51, 'portadaAppDelHambre1.jpg'),
(522, 'CHILCAYOC', 51, 'portadaAppDelHambre1.jpg'),
(523, 'HUACA&Ntilde;A', 51, 'portadaAppDelHambre1.jpg'),
(524, 'MORCOLLA', 51, 'portadaAppDelHambre1.jpg'),
(525, 'PAICO', 51, 'portadaAppDelHambre1.jpg'),
(526, 'SAN PEDRO DE LARCAY', 51, 'portadaAppDelHambre1.jpg'),
(527, 'SAN SALVADOR DE QUIJE', 51, 'portadaAppDelHambre1.jpg'),
(528, 'SANTIAGO DE PAUCARAY', 51, 'portadaAppDelHambre1.jpg'),
(529, 'SORAS', 51, 'portadaAppDelHambre1.jpg'),
(530, 'HUANCAPI', 52, 'portadaAppDelHambre1.jpg'),
(531, 'ALCAMENCA', 52, 'portadaAppDelHambre1.jpg'),
(532, 'APONGO', 52, 'portadaAppDelHambre1.jpg'),
(533, 'ASQUIPATA', 52, 'portadaAppDelHambre1.jpg'),
(534, 'CANARIA', 52, 'portadaAppDelHambre1.jpg'),
(535, 'CAYARA', 52, 'portadaAppDelHambre1.jpg'),
(536, 'COLCA', 52, 'portadaAppDelHambre1.jpg'),
(537, 'HUAMANQUIQUIA', 52, 'portadaAppDelHambre1.jpg'),
(538, 'HUANCARAYLLA', 52, 'portadaAppDelHambre1.jpg'),
(539, 'HUAYA', 52, 'portadaAppDelHambre1.jpg'),
(540, 'SARHUA', 52, 'portadaAppDelHambre1.jpg'),
(541, 'VILCANCHOS', 52, 'portadaAppDelHambre1.jpg'),
(542, 'VILCAS HUAMAN', 53, 'portadaAppDelHambre1.jpg'),
(543, 'ACCOMARCA', 53, 'portadaAppDelHambre1.jpg'),
(544, 'CARHUANCA', 53, 'portadaAppDelHambre1.jpg'),
(545, 'CONCEPCION', 53, 'portadaAppDelHambre1.jpg'),
(546, 'HUAMBALPA', 53, 'portadaAppDelHambre1.jpg'),
(547, 'INDEPENDENCIA', 53, 'portadaAppDelHambre1.jpg'),
(548, 'SAURAMA', 53, 'portadaAppDelHambre1.jpg'),
(549, 'VISCHONGO', 53, 'portadaAppDelHambre1.jpg'),
(550, 'CAJAMARCA', 54, 'portadaAppDelHambre1.jpg'),
(551, 'CAJAMARCA', 54, 'portadaAppDelHambre1.jpg'),
(552, 'ASUNCION', 54, 'portadaAppDelHambre1.jpg'),
(553, 'CHETILLA', 54, 'portadaAppDelHambre1.jpg'),
(554, 'COSPAN', 54, 'portadaAppDelHambre1.jpg'),
(555, 'ENCA&Ntilde;ADA', 54, 'portadaAppDelHambre1.jpg'),
(556, 'JESUS', 54, 'portadaAppDelHambre1.jpg'),
(557, 'LLACANORA', 54, 'portadaAppDelHambre1.jpg'),
(558, 'LOS BA&Ntilde;OS DEL INCA', 54, 'portadaAppDelHambre1.jpg'),
(559, 'MAGDALENA', 54, 'portadaAppDelHambre1.jpg'),
(560, 'MATARA', 54, 'portadaAppDelHambre1.jpg'),
(561, 'NAMORA', 54, 'portadaAppDelHambre1.jpg'),
(562, 'SAN JUAN', 54, 'portadaAppDelHambre1.jpg'),
(563, 'CAJABAMBA', 55, 'portadaAppDelHambre1.jpg'),
(564, 'CACHACHI', 55, 'portadaAppDelHambre1.jpg'),
(565, 'CONDEBAMBA', 55, 'portadaAppDelHambre1.jpg'),
(566, 'SITACOCHA', 55, 'portadaAppDelHambre1.jpg'),
(567, 'CELENDIN', 56, 'portadaAppDelHambre1.jpg'),
(568, 'CHUMUCH', 56, 'portadaAppDelHambre1.jpg'),
(569, 'CORTEGANA', 56, 'portadaAppDelHambre1.jpg'),
(570, 'HUASMIN', 56, 'portadaAppDelHambre1.jpg'),
(571, 'JORGE CHAVEZ', 56, 'portadaAppDelHambre1.jpg'),
(572, 'JOSE GALVEZ', 56, 'portadaAppDelHambre1.jpg'),
(573, 'MIGUEL IGLESIAS', 56, 'portadaAppDelHambre1.jpg'),
(574, 'OXAMARCA', 56, 'portadaAppDelHambre1.jpg'),
(575, 'SOROCHUCO', 56, 'portadaAppDelHambre1.jpg'),
(576, 'SUCRE', 56, 'portadaAppDelHambre1.jpg'),
(577, 'UTCO', 56, 'portadaAppDelHambre1.jpg'),
(578, 'LA LIBERTAD DE PALLAN', 56, 'portadaAppDelHambre1.jpg'),
(579, 'CHOTA', 57, 'portadaAppDelHambre1.jpg'),
(580, 'ANGUIA', 57, 'portadaAppDelHambre1.jpg'),
(581, 'CHADIN', 57, 'portadaAppDelHambre1.jpg'),
(582, 'CHIGUIRIP', 57, 'portadaAppDelHambre1.jpg'),
(583, 'CHIMBAN', 57, 'portadaAppDelHambre1.jpg'),
(584, 'CHOROPAMPA', 57, 'portadaAppDelHambre1.jpg'),
(585, 'COCHABAMBA', 57, 'portadaAppDelHambre1.jpg'),
(586, 'CONCHAN', 57, 'portadaAppDelHambre1.jpg'),
(587, 'HUAMBOS', 57, 'portadaAppDelHambre1.jpg'),
(588, 'LAJAS', 57, 'portadaAppDelHambre1.jpg'),
(589, 'LLAMA', 57, 'portadaAppDelHambre1.jpg'),
(590, 'MIRACOSTA', 57, 'portadaAppDelHambre1.jpg'),
(591, 'PACCHA', 57, 'portadaAppDelHambre1.jpg'),
(592, 'PION', 57, 'portadaAppDelHambre1.jpg'),
(593, 'QUEROCOTO', 57, 'portadaAppDelHambre1.jpg'),
(594, 'SAN JUAN DE LICUPIS', 57, 'portadaAppDelHambre1.jpg'),
(595, 'TACABAMBA', 57, 'portadaAppDelHambre1.jpg'),
(596, 'TOCMOCHE', 57, 'portadaAppDelHambre1.jpg'),
(597, 'CHALAMARCA', 57, 'portadaAppDelHambre1.jpg'),
(598, 'CONTUMAZA', 58, 'portadaAppDelHambre1.jpg'),
(599, 'CHILETE', 58, 'portadaAppDelHambre1.jpg'),
(600, 'CUPISNIQUE', 58, 'portadaAppDelHambre1.jpg'),
(601, 'GUZMANGO', 58, 'portadaAppDelHambre1.jpg'),
(602, 'SAN BENITO', 58, 'portadaAppDelHambre1.jpg'),
(603, 'SANTA CRUZ DE TOLED', 58, 'portadaAppDelHambre1.jpg'),
(604, 'TANTARICA', 58, 'portadaAppDelHambre1.jpg'),
(605, 'YONAN', 58, 'portadaAppDelHambre1.jpg'),
(606, 'CUTERVO', 59, 'portadaAppDelHambre1.jpg'),
(607, 'CALLAYUC', 59, 'portadaAppDelHambre1.jpg'),
(608, 'CHOROS', 59, 'portadaAppDelHambre1.jpg'),
(609, 'CUJILLO', 59, 'portadaAppDelHambre1.jpg'),
(610, 'LA RAMADA', 59, 'portadaAppDelHambre1.jpg'),
(611, 'PIMPINGOS', 59, 'portadaAppDelHambre1.jpg'),
(612, 'QUEROCOTILLO', 59, 'portadaAppDelHambre1.jpg'),
(613, 'SAN ANDRES DE CUTERVO', 59, 'portadaAppDelHambre1.jpg'),
(614, 'SAN JUAN DE CUTERVO', 59, 'portadaAppDelHambre1.jpg'),
(615, 'SAN LUIS DE LUCMA', 59, 'portadaAppDelHambre1.jpg'),
(616, 'SANTA CRUZ', 59, 'portadaAppDelHambre1.jpg'),
(617, 'SANTO DOMINGO DE LA CAPILLA', 59, 'portadaAppDelHambre1.jpg'),
(618, 'SANTO TOMAS', 59, 'portadaAppDelHambre1.jpg'),
(619, 'SOCOTA', 59, 'portadaAppDelHambre1.jpg'),
(620, 'TORIBIO CASANOVA', 59, 'portadaAppDelHambre1.jpg'),
(621, 'BAMBAMARCA', 60, 'portadaAppDelHambre1.jpg'),
(622, 'CHUGUR', 60, 'portadaAppDelHambre1.jpg'),
(623, 'HUALGAYOC', 60, 'portadaAppDelHambre1.jpg'),
(624, 'JAEN', 61, 'portadaAppDelHambre1.jpg'),
(625, 'BELLAVISTA', 61, 'portadaAppDelHambre1.jpg'),
(626, 'CHONTALI', 61, 'portadaAppDelHambre1.jpg'),
(627, 'COLASAY', 61, 'portadaAppDelHambre1.jpg'),
(628, 'HUABAL', 61, 'portadaAppDelHambre1.jpg'),
(629, 'LAS PIRIAS', 61, 'portadaAppDelHambre1.jpg'),
(630, 'POMAHUACA', 61, 'portadaAppDelHambre1.jpg'),
(631, 'PUCARA', 61, 'portadaAppDelHambre1.jpg'),
(632, 'SALLIQUE', 61, 'portadaAppDelHambre1.jpg'),
(633, 'SAN FELIPE', 61, 'portadaAppDelHambre1.jpg'),
(634, 'SAN JOSE DEL ALTO', 61, 'portadaAppDelHambre1.jpg'),
(635, 'SANTA ROSA', 61, 'portadaAppDelHambre1.jpg'),
(636, 'SAN IGNACIO', 62, 'portadaAppDelHambre1.jpg'),
(637, 'CHIRINOS', 62, 'portadaAppDelHambre1.jpg'),
(638, 'HUARANGO', 62, 'portadaAppDelHambre1.jpg'),
(639, 'LA COIPA', 62, 'portadaAppDelHambre1.jpg'),
(640, 'NAMBALLE', 62, 'portadaAppDelHambre1.jpg'),
(641, 'SAN JOSE DE LOURDES', 62, 'portadaAppDelHambre1.jpg'),
(642, 'TABACONAS', 62, 'portadaAppDelHambre1.jpg'),
(643, 'PEDRO GALVEZ', 63, 'portadaAppDelHambre1.jpg'),
(644, 'CHANCAY', 63, 'portadaAppDelHambre1.jpg'),
(645, 'EDUARDO VILLANUEVA', 63, 'portadaAppDelHambre1.jpg'),
(646, 'GREGORIO PITA', 63, 'portadaAppDelHambre1.jpg'),
(647, 'ICHOCAN', 63, 'portadaAppDelHambre1.jpg'),
(648, 'JOSE MANUEL QUIROZ', 63, 'portadaAppDelHambre1.jpg'),
(649, 'JOSE SABOGAL', 63, 'portadaAppDelHambre1.jpg'),
(650, 'SAN MIGUEL', 64, 'portadaAppDelHambre1.jpg'),
(651, 'SAN MIGUEL', 64, 'portadaAppDelHambre1.jpg'),
(652, 'BOLIVAR', 64, 'portadaAppDelHambre1.jpg'),
(653, 'CALQUIS', 64, 'portadaAppDelHambre1.jpg'),
(654, 'CATILLUC', 64, 'portadaAppDelHambre1.jpg'),
(655, 'EL PRADO', 64, 'portadaAppDelHambre1.jpg'),
(656, 'LA FLORIDA', 64, 'portadaAppDelHambre1.jpg'),
(657, 'LLAPA', 64, 'portadaAppDelHambre1.jpg'),
(658, 'NANCHOC', 64, 'portadaAppDelHambre1.jpg'),
(659, 'NIEPOS', 64, 'portadaAppDelHambre1.jpg'),
(660, 'SAN GREGORIO', 64, 'portadaAppDelHambre1.jpg'),
(661, 'SAN SILVESTRE DE COCHAN', 64, 'portadaAppDelHambre1.jpg'),
(662, 'TONGOD', 64, 'portadaAppDelHambre1.jpg'),
(663, 'UNION AGUA BLANCA', 64, 'portadaAppDelHambre1.jpg'),
(664, 'SAN PABLO', 65, 'portadaAppDelHambre1.jpg'),
(665, 'SAN BERNARDINO', 65, 'portadaAppDelHambre1.jpg'),
(666, 'SAN LUIS', 65, 'portadaAppDelHambre1.jpg'),
(667, 'TUMBADEN', 65, 'portadaAppDelHambre1.jpg'),
(668, 'SANTA CRUZ', 66, 'portadaAppDelHambre1.jpg'),
(669, 'ANDABAMBA', 66, 'portadaAppDelHambre1.jpg'),
(670, 'CATACHE', 66, 'portadaAppDelHambre1.jpg'),
(671, 'CHANCAYBA&Ntilde;OS', 66, 'portadaAppDelHambre1.jpg'),
(672, 'LA ESPERANZA', 66, 'portadaAppDelHambre1.jpg'),
(673, 'NINABAMBA', 66, 'portadaAppDelHambre1.jpg'),
(674, 'PULAN', 66, 'portadaAppDelHambre1.jpg'),
(675, 'SAUCEPAMPA', 66, 'portadaAppDelHambre1.jpg'),
(676, 'SEXI', 66, 'portadaAppDelHambre1.jpg'),
(677, 'UTICYACU', 66, 'portadaAppDelHambre1.jpg'),
(678, 'YAUYUCAN', 66, 'portadaAppDelHambre1.jpg'),
(679, 'CALLAO', 67, 'portadaAppDelHambre1.jpg'),
(680, 'BELLAVISTA', 67, 'portadaAppDelHambre1.jpg'),
(681, 'CARMEN DE LA LEGUA REYNOSO', 67, 'portadaAppDelHambre1.jpg'),
(682, 'LA PERLA', 67, 'portadaAppDelHambre1.jpg'),
(683, 'LA PUNTA', 67, 'portadaAppDelHambre1.jpg'),
(684, 'VENTANILLA', 67, 'portadaAppDelHambre1.jpg'),
(685, 'CUSCO', 67, 'portadaAppDelHambre1.jpg'),
(686, 'CCORCA', 67, 'portadaAppDelHambre1.jpg'),
(687, 'POROY', 67, 'portadaAppDelHambre1.jpg'),
(688, 'SAN JERONIMO', 67, 'portadaAppDelHambre1.jpg'),
(689, 'SAN SEBASTIAN', 67, 'portadaAppDelHambre1.jpg'),
(690, 'SANTIAGO', 67, 'portadaAppDelHambre1.jpg'),
(691, 'SAYLLA', 67, 'portadaAppDelHambre1.jpg'),
(692, 'WANCHAQ', 67, 'portadaAppDelHambre1.jpg'),
(693, 'ACOMAYO', 68, 'portadaAppDelHambre1.jpg'),
(694, 'ACOPIA', 68, 'portadaAppDelHambre1.jpg'),
(695, 'ACOS', 68, 'portadaAppDelHambre1.jpg'),
(696, 'MOSOC LLACTA', 68, 'portadaAppDelHambre1.jpg'),
(697, 'POMACANCHI', 68, 'portadaAppDelHambre1.jpg'),
(698, 'RONDOCAN', 68, 'portadaAppDelHambre1.jpg'),
(699, 'SANGARARA', 68, 'portadaAppDelHambre1.jpg'),
(700, 'ANTA', 69, 'portadaAppDelHambre1.jpg'),
(701, 'ANCAHUASI', 69, 'portadaAppDelHambre1.jpg'),
(702, 'CACHIMAYO', 69, 'portadaAppDelHambre1.jpg'),
(703, 'CHINCHAYPUJIO', 69, 'portadaAppDelHambre1.jpg'),
(704, 'HUAROCONDO', 69, 'portadaAppDelHambre1.jpg'),
(705, 'LIMATAMBO', 69, 'portadaAppDelHambre1.jpg'),
(706, 'MOLLEPATA', 69, 'portadaAppDelHambre1.jpg'),
(707, 'PUCYURA', 69, 'portadaAppDelHambre1.jpg'),
(708, 'ZURITE', 69, 'portadaAppDelHambre1.jpg'),
(709, 'CALCA', 70, 'portadaAppDelHambre1.jpg'),
(710, 'COYA', 70, 'portadaAppDelHambre1.jpg'),
(711, 'LAMAY', 70, 'portadaAppDelHambre1.jpg'),
(712, 'LARES', 70, 'portadaAppDelHambre1.jpg'),
(713, 'PISAC', 70, 'portadaAppDelHambre1.jpg'),
(714, 'SAN SALVADOR', 70, 'portadaAppDelHambre1.jpg'),
(715, 'TARAY', 70, 'portadaAppDelHambre1.jpg'),
(716, 'YANATILE', 70, 'portadaAppDelHambre1.jpg'),
(717, 'YANAOCA', 71, 'portadaAppDelHambre1.jpg'),
(718, 'CHECCA', 71, 'portadaAppDelHambre1.jpg'),
(719, 'KUNTURKANKI', 71, 'portadaAppDelHambre1.jpg'),
(720, 'LANGUI', 71, 'portadaAppDelHambre1.jpg'),
(721, 'LAYO', 71, 'portadaAppDelHambre1.jpg'),
(722, 'PAMPAMARCA', 71, 'portadaAppDelHambre1.jpg'),
(723, 'QUEHUE', 71, 'portadaAppDelHambre1.jpg'),
(724, 'TUPAC AMARU', 71, 'portadaAppDelHambre1.jpg'),
(725, 'SICUANI', 72, 'portadaAppDelHambre1.jpg'),
(726, 'CHECACUPE', 72, 'portadaAppDelHambre1.jpg'),
(727, 'COMBAPATA', 72, 'portadaAppDelHambre1.jpg'),
(728, 'MARANGANI', 72, 'portadaAppDelHambre1.jpg'),
(729, 'PITUMARCA', 72, 'portadaAppDelHambre1.jpg'),
(730, 'SAN PABLO', 72, 'portadaAppDelHambre1.jpg'),
(731, 'SAN PEDRO', 72, 'portadaAppDelHambre1.jpg'),
(732, 'TINTA', 72, 'portadaAppDelHambre1.jpg'),
(733, 'SANTO TOMAS', 73, 'portadaAppDelHambre1.jpg'),
(734, 'CAPACMARCA', 73, 'portadaAppDelHambre1.jpg'),
(735, 'CHAMACA', 73, 'portadaAppDelHambre1.jpg'),
(736, 'COLQUEMARCA', 73, 'portadaAppDelHambre1.jpg'),
(737, 'LIVITACA', 73, 'portadaAppDelHambre1.jpg'),
(738, 'LLUSCO', 73, 'portadaAppDelHambre1.jpg'),
(739, 'QUI&Ntilde;OTA', 73, 'portadaAppDelHambre1.jpg'),
(740, 'VELILLE', 73, 'portadaAppDelHambre1.jpg'),
(741, 'ESPINAR', 74, 'portadaAppDelHambre1.jpg'),
(742, 'CONDOROMA', 74, 'portadaAppDelHambre1.jpg'),
(743, 'COPORAQUE', 74, 'portadaAppDelHambre1.jpg'),
(744, 'OCORURO', 74, 'portadaAppDelHambre1.jpg'),
(745, 'PALLPATA', 74, 'portadaAppDelHambre1.jpg'),
(746, 'PICHIGUA', 74, 'portadaAppDelHambre1.jpg'),
(747, 'SUYCKUTAMBO', 74, 'portadaAppDelHambre1.jpg'),
(748, 'ALTO PICHIGUA', 74, 'portadaAppDelHambre1.jpg'),
(749, 'SANTA ANA', 75, 'portadaAppDelHambre1.jpg'),
(750, 'ECHARATE', 75, 'portadaAppDelHambre1.jpg'),
(751, 'HUAYOPATA', 75, 'portadaAppDelHambre1.jpg'),
(752, 'MARANURA', 75, 'portadaAppDelHambre1.jpg'),
(753, 'OCOBAMBA', 75, 'portadaAppDelHambre1.jpg'),
(754, 'QUELLOUNO', 75, 'portadaAppDelHambre1.jpg'),
(755, 'KIMBIRI', 75, 'portadaAppDelHambre1.jpg'),
(756, 'SANTA TERESA', 75, 'portadaAppDelHambre1.jpg'),
(757, 'VILCABAMBA', 75, 'portadaAppDelHambre1.jpg'),
(758, 'PICHARI', 75, 'portadaAppDelHambre1.jpg'),
(759, 'PARURO', 76, 'portadaAppDelHambre1.jpg'),
(760, 'ACCHA', 76, 'portadaAppDelHambre1.jpg'),
(761, 'CCAPI', 76, 'portadaAppDelHambre1.jpg'),
(762, 'COLCHA', 76, 'portadaAppDelHambre1.jpg'),
(763, 'HUANOQUITE', 76, 'portadaAppDelHambre1.jpg'),
(764, 'OMACHA', 76, 'portadaAppDelHambre1.jpg'),
(765, 'PACCARITAMBO', 76, 'portadaAppDelHambre1.jpg'),
(766, 'PILLPINTO', 76, 'portadaAppDelHambre1.jpg'),
(767, 'YAURISQUE', 76, 'portadaAppDelHambre1.jpg'),
(768, 'PAUCARTAMBO', 77, 'portadaAppDelHambre1.jpg'),
(769, 'CAICAY', 77, 'portadaAppDelHambre1.jpg'),
(770, 'CHALLABAMBA', 77, 'portadaAppDelHambre1.jpg'),
(771, 'COLQUEPATA', 77, 'portadaAppDelHambre1.jpg'),
(772, 'HUANCARANI', 77, 'portadaAppDelHambre1.jpg'),
(773, 'KOS&Ntilde;IPATA', 77, 'portadaAppDelHambre1.jpg'),
(774, 'URCOS', 78, 'portadaAppDelHambre1.jpg'),
(775, 'ANDAHUAYLILLAS', 78, 'portadaAppDelHambre1.jpg'),
(776, 'CAMANTI', 78, 'portadaAppDelHambre1.jpg'),
(777, 'CCARHUAYO', 78, 'portadaAppDelHambre1.jpg'),
(778, 'CCATCA', 78, 'portadaAppDelHambre1.jpg'),
(779, 'CUSIPATA', 78, 'portadaAppDelHambre1.jpg'),
(780, 'HUARO', 78, 'portadaAppDelHambre1.jpg'),
(781, 'LUCRE', 78, 'portadaAppDelHambre1.jpg'),
(782, 'MARCAPATA', 78, 'portadaAppDelHambre1.jpg'),
(783, 'OCONGATE', 78, 'portadaAppDelHambre1.jpg'),
(784, 'OROPESA', 78, 'portadaAppDelHambre1.jpg'),
(785, 'QUIQUIJANA', 78, 'portadaAppDelHambre1.jpg'),
(786, 'URUBAMBA', 79, 'portadaAppDelHambre1.jpg'),
(787, 'CHINCHERO', 79, 'portadaAppDelHambre1.jpg'),
(788, 'HUAYLLABAMBA', 79, 'portadaAppDelHambre1.jpg'),
(789, 'MACHUPICCHU', 79, 'portadaAppDelHambre1.jpg'),
(790, 'MARAS', 79, 'portadaAppDelHambre1.jpg'),
(791, 'OLLANTAYTAMBO', 79, 'portadaAppDelHambre1.jpg'),
(792, 'YUCAY', 79, 'portadaAppDelHambre1.jpg'),
(793, 'HUANCAVELICA', 80, 'portadaAppDelHambre1.jpg'),
(794, 'ACOBAMBILLA', 80, 'portadaAppDelHambre1.jpg'),
(795, 'ACORIA', 80, 'portadaAppDelHambre1.jpg'),
(796, 'CONAYCA', 80, 'portadaAppDelHambre1.jpg'),
(797, 'CUENCA', 80, 'portadaAppDelHambre1.jpg'),
(798, 'HUACHOCOLPA', 80, 'portadaAppDelHambre1.jpg'),
(799, 'HUAYLLAHUARA', 80, 'portadaAppDelHambre1.jpg'),
(800, 'IZCUCHACA', 80, 'portadaAppDelHambre1.jpg'),
(801, 'LARIA', 80, 'portadaAppDelHambre1.jpg'),
(802, 'MANTA', 80, 'portadaAppDelHambre1.jpg'),
(803, 'MARISCAL CACERES', 80, 'portadaAppDelHambre1.jpg'),
(804, 'MOYA', 80, 'portadaAppDelHambre1.jpg'),
(805, 'NUEVO OCCORO', 80, 'portadaAppDelHambre1.jpg'),
(806, 'PALCA', 80, 'portadaAppDelHambre1.jpg'),
(807, 'PILCHACA', 80, 'portadaAppDelHambre1.jpg'),
(808, 'VILCA', 80, 'portadaAppDelHambre1.jpg'),
(809, 'YAULI', 80, 'portadaAppDelHambre1.jpg'),
(810, 'ASCENSION', 80, 'portadaAppDelHambre1.jpg'),
(811, 'HUANDO', 80, 'portadaAppDelHambre1.jpg'),
(812, 'ACOBAMBA', 81, 'portadaAppDelHambre1.jpg'),
(813, 'ANDABAMBA', 81, 'portadaAppDelHambre1.jpg'),
(814, 'ANTA', 81, 'portadaAppDelHambre1.jpg'),
(815, 'CAJA', 81, 'portadaAppDelHambre1.jpg'),
(816, 'MARCAS', 81, 'portadaAppDelHambre1.jpg'),
(817, 'PAUCARA', 81, 'portadaAppDelHambre1.jpg'),
(818, 'POMACOCHA', 81, 'portadaAppDelHambre1.jpg'),
(819, 'ROSARIO', 81, 'portadaAppDelHambre1.jpg'),
(820, 'LIRCAY', 82, 'portadaAppDelHambre1.jpg'),
(821, 'ANCHONGA', 82, 'portadaAppDelHambre1.jpg'),
(822, 'CALLANMARCA', 82, 'portadaAppDelHambre1.jpg'),
(823, 'CCOCHACCASA', 82, 'portadaAppDelHambre1.jpg'),
(824, 'CHINCHO', 82, 'portadaAppDelHambre1.jpg'),
(825, 'CONGALLA', 82, 'portadaAppDelHambre1.jpg'),
(826, 'HUANCA-HUANCA', 82, 'portadaAppDelHambre1.jpg'),
(827, 'HUAYLLAY GRANDE', 82, 'portadaAppDelHambre1.jpg'),
(828, 'JULCAMARCA', 82, 'portadaAppDelHambre1.jpg'),
(829, 'SAN ANTONIO DE ANTAPARCO', 82, 'portadaAppDelHambre1.jpg'),
(830, 'SANTO TOMAS DE PATA', 82, 'portadaAppDelHambre1.jpg'),
(831, 'SECCLLA', 82, 'portadaAppDelHambre1.jpg'),
(832, 'CASTROVIRREYNA', 83, 'portadaAppDelHambre1.jpg'),
(833, 'ARMA', 83, 'portadaAppDelHambre1.jpg'),
(834, 'AURAHUA', 83, 'portadaAppDelHambre1.jpg'),
(835, 'CAPILLAS', 83, 'portadaAppDelHambre1.jpg'),
(836, 'CHUPAMARCA', 83, 'portadaAppDelHambre1.jpg'),
(837, 'COCAS', 83, 'portadaAppDelHambre1.jpg'),
(838, 'HUACHOS', 83, 'portadaAppDelHambre1.jpg'),
(839, 'HUAMATAMBO', 83, 'portadaAppDelHambre1.jpg'),
(840, 'MOLLEPAMPA', 83, 'portadaAppDelHambre1.jpg'),
(841, 'SAN JUAN', 83, 'portadaAppDelHambre1.jpg'),
(842, 'SANTA ANA', 83, 'portadaAppDelHambre1.jpg'),
(843, 'TANTARA', 83, 'portadaAppDelHambre1.jpg'),
(844, 'TICRAPO', 83, 'portadaAppDelHambre1.jpg'),
(845, 'CHURCAMPA', 84, 'portadaAppDelHambre1.jpg'),
(846, 'ANCO', 84, 'portadaAppDelHambre1.jpg'),
(847, 'CHINCHIHUASI', 84, 'portadaAppDelHambre1.jpg'),
(848, 'EL CARMEN', 84, 'portadaAppDelHambre1.jpg'),
(849, 'LA MERCED', 84, 'portadaAppDelHambre1.jpg'),
(850, 'LOCROJA', 84, 'portadaAppDelHambre1.jpg'),
(851, 'PAUCARBAMBA', 84, 'portadaAppDelHambre1.jpg'),
(852, 'SAN MIGUEL DE MAYOCC', 84, 'portadaAppDelHambre1.jpg'),
(853, 'SAN PEDRO DE CORIS', 84, 'portadaAppDelHambre1.jpg'),
(854, 'PACHAMARCA', 84, 'portadaAppDelHambre1.jpg'),
(855, 'HUAYTARA', 85, 'portadaAppDelHambre1.jpg'),
(856, 'AYAVI', 85, 'portadaAppDelHambre1.jpg'),
(857, 'CORDOVA', 85, 'portadaAppDelHambre1.jpg'),
(858, 'HUAYACUNDO ARMA', 85, 'portadaAppDelHambre1.jpg'),
(859, 'LARAMARCA', 85, 'portadaAppDelHambre1.jpg'),
(860, 'OCOYO', 85, 'portadaAppDelHambre1.jpg'),
(861, 'PILPICHACA', 85, 'portadaAppDelHambre1.jpg'),
(862, 'QUERCO', 85, 'portadaAppDelHambre1.jpg'),
(863, 'QUITO-ARMA', 85, 'portadaAppDelHambre1.jpg'),
(864, 'SAN ANTONIO DE CUSICANCHA', 85, 'portadaAppDelHambre1.jpg'),
(865, 'SAN FRANCISCO DE SANGAYAICO', 85, 'portadaAppDelHambre1.jpg'),
(866, 'SAN ISIDRO', 85, 'portadaAppDelHambre1.jpg'),
(867, 'SANTIAGO DE CHOCORVOS', 85, 'portadaAppDelHambre1.jpg'),
(868, 'SANTIAGO DE QUIRAHUARA', 85, 'portadaAppDelHambre1.jpg'),
(869, 'SANTO DOMINGO DE CAPILLAS', 85, 'portadaAppDelHambre1.jpg'),
(870, 'TAMBO', 85, 'portadaAppDelHambre1.jpg'),
(871, 'PAMPAS', 86, 'portadaAppDelHambre1.jpg'),
(872, 'ACOSTAMBO', 86, 'portadaAppDelHambre1.jpg'),
(873, 'ACRAQUIA', 86, 'portadaAppDelHambre1.jpg'),
(874, 'AHUAYCHA', 86, 'portadaAppDelHambre1.jpg'),
(875, 'COLCABAMBA', 86, 'portadaAppDelHambre1.jpg'),
(876, 'DANIEL HERNANDEZ', 86, 'portadaAppDelHambre1.jpg'),
(877, 'HUACHOCOLPA', 86, 'portadaAppDelHambre1.jpg'),
(878, 'HUARIBAMBA', 86, 'portadaAppDelHambre1.jpg'),
(879, '&Ntilde;AHUIMPUQUIO', 86, 'portadaAppDelHambre1.jpg'),
(880, 'PAZOS', 86, 'portadaAppDelHambre1.jpg'),
(881, 'QUISHUAR', 86, 'portadaAppDelHambre1.jpg'),
(882, 'SALCABAMBA', 86, 'portadaAppDelHambre1.jpg'),
(883, 'SALCAHUASI', 86, 'portadaAppDelHambre1.jpg'),
(884, 'SAN MARCOS DE ROCCHAC', 86, 'portadaAppDelHambre1.jpg'),
(885, 'SURCUBAMBA', 86, 'portadaAppDelHambre1.jpg'),
(886, 'TINTAY PUNCU', 86, 'portadaAppDelHambre1.jpg'),
(887, 'HUANUCO', 87, 'portadaAppDelHambre1.jpg'),
(888, 'AMARILIS', 87, 'portadaAppDelHambre1.jpg'),
(889, 'CHINCHAO', 87, 'portadaAppDelHambre1.jpg'),
(890, 'CHURUBAMBA', 87, 'portadaAppDelHambre1.jpg'),
(891, 'MARGOS', 87, 'portadaAppDelHambre1.jpg'),
(892, 'QUISQUI', 87, 'portadaAppDelHambre1.jpg'),
(893, 'SAN FRANCISCO DE CAYRAN', 87, 'portadaAppDelHambre1.jpg'),
(894, 'SAN PEDRO DE CHAULAN', 87, 'portadaAppDelHambre1.jpg'),
(895, 'SANTA MARIA DEL VALLE', 87, 'portadaAppDelHambre1.jpg'),
(896, 'YARUMAYO', 87, 'portadaAppDelHambre1.jpg'),
(897, 'PILLCO MARCA', 87, 'portadaAppDelHambre1.jpg'),
(898, 'AMBO', 88, 'portadaAppDelHambre1.jpg'),
(899, 'CAYNA', 88, 'portadaAppDelHambre1.jpg'),
(900, 'COLPAS', 88, 'portadaAppDelHambre1.jpg'),
(901, 'CONCHAMARCA', 88, 'portadaAppDelHambre1.jpg'),
(902, 'HUACAR', 88, 'portadaAppDelHambre1.jpg'),
(903, 'SAN FRANCISCO', 88, 'portadaAppDelHambre1.jpg'),
(904, 'SAN RAFAEL', 88, 'portadaAppDelHambre1.jpg'),
(905, 'TOMAY KICHWA', 88, 'portadaAppDelHambre1.jpg'),
(906, 'LA UNION', 89, 'portadaAppDelHambre1.jpg'),
(907, 'CHUQUIS', 89, 'portadaAppDelHambre1.jpg'),
(908, 'MARIAS', 89, 'portadaAppDelHambre1.jpg'),
(909, 'PACHAS', 89, 'portadaAppDelHambre1.jpg'),
(910, 'QUIVILLA', 89, 'portadaAppDelHambre1.jpg'),
(911, 'RIPAN', 89, 'portadaAppDelHambre1.jpg'),
(912, 'SHUNQUI', 89, 'portadaAppDelHambre1.jpg'),
(913, 'SILLAPATA', 89, 'portadaAppDelHambre1.jpg'),
(914, 'YANAS', 89, 'portadaAppDelHambre1.jpg'),
(915, 'HUACAYBAMBA', 90, 'portadaAppDelHambre1.jpg'),
(916, 'CANCHABAMBA', 90, 'portadaAppDelHambre1.jpg'),
(917, 'COCHABAMBA', 90, 'portadaAppDelHambre1.jpg'),
(918, 'PINRA', 90, 'portadaAppDelHambre1.jpg'),
(919, 'LLATA', 91, 'portadaAppDelHambre1.jpg'),
(920, 'ARANCAY', 91, 'portadaAppDelHambre1.jpg'),
(921, 'CHAVIN DE PARIARCA', 91, 'portadaAppDelHambre1.jpg'),
(922, 'JACAS GRANDE', 91, 'portadaAppDelHambre1.jpg'),
(923, 'JIRCAN', 91, 'portadaAppDelHambre1.jpg'),
(924, 'MIRAFLORES', 91, 'portadaAppDelHambre1.jpg'),
(925, 'MONZON', 91, 'portadaAppDelHambre1.jpg'),
(926, 'PUNCHAO', 91, 'portadaAppDelHambre1.jpg'),
(927, 'PU&Ntilde;OS', 91, 'portadaAppDelHambre1.jpg'),
(928, 'SINGA', 91, 'portadaAppDelHambre1.jpg'),
(929, 'TANTAMAYO', 91, 'portadaAppDelHambre1.jpg'),
(930, 'RUPA-RUPA', 92, 'portadaAppDelHambre1.jpg'),
(931, 'DANIEL ALOMIA ROBLES', 92, 'portadaAppDelHambre1.jpg'),
(932, 'HERMILIO VALDIZAN', 92, 'portadaAppDelHambre1.jpg'),
(933, 'JOSE CRESPO Y CASTILLO', 92, 'portadaAppDelHambre1.jpg'),
(934, 'LUYANDO', 92, 'portadaAppDelHambre1.jpg'),
(935, 'MARIANO DAMASO BERAUN', 92, 'portadaAppDelHambre1.jpg'),
(936, 'HUACRACHUCO', 93, 'portadaAppDelHambre1.jpg'),
(937, 'CHOLON', 93, 'portadaAppDelHambre1.jpg'),
(938, 'SAN BUENAVENTURA', 93, 'portadaAppDelHambre1.jpg'),
(939, 'PANAO', 94, 'portadaAppDelHambre1.jpg'),
(940, 'CHAGLLA', 94, 'portadaAppDelHambre1.jpg'),
(941, 'MOLINO', 94, 'portadaAppDelHambre1.jpg'),
(942, 'UMARI', 94, 'portadaAppDelHambre1.jpg'),
(943, 'PUERTO INCA', 95, 'portadaAppDelHambre1.jpg'),
(944, 'CODO DEL POZUZO', 95, 'portadaAppDelHambre1.jpg'),
(945, 'HONORIA', 95, 'portadaAppDelHambre1.jpg'),
(946, 'TOURNAVISTA', 95, 'portadaAppDelHambre1.jpg'),
(947, 'YUYAPICHIS', 95, 'portadaAppDelHambre1.jpg'),
(948, 'JESUS', 96, 'portadaAppDelHambre1.jpg'),
(949, 'BA&Ntilde;OS', 96, 'portadaAppDelHambre1.jpg'),
(950, 'JIVIA', 96, 'portadaAppDelHambre1.jpg'),
(951, 'QUEROPALCA', 96, 'portadaAppDelHambre1.jpg'),
(952, 'RONDOS', 96, 'portadaAppDelHambre1.jpg'),
(953, 'SAN FRANCISCO DE ASIS', 96, 'portadaAppDelHambre1.jpg'),
(954, 'SAN MIGUEL DE CAURI', 96, 'portadaAppDelHambre1.jpg'),
(955, 'CHAVINILLO', 97, 'portadaAppDelHambre1.jpg'),
(956, 'CAHUAC', 97, 'portadaAppDelHambre1.jpg'),
(957, 'CHACABAMBA', 97, 'portadaAppDelHambre1.jpg'),
(958, 'APARICIO POMARES', 97, 'portadaAppDelHambre1.jpg'),
(959, 'JACAS CHICO', 97, 'portadaAppDelHambre1.jpg'),
(960, 'OBAS', 97, 'portadaAppDelHambre1.jpg'),
(961, 'PAMPAMARCA', 97, 'portadaAppDelHambre1.jpg'),
(962, 'CHORAS', 97, 'portadaAppDelHambre1.jpg'),
(963, 'ICA', 98, 'portadaAppDelHambre1.jpg'),
(964, 'LA TINGUI&Ntilde;A', 98, 'portadaAppDelHambre1.jpg'),
(965, 'LOS AQUIJES', 98, 'portadaAppDelHambre1.jpg'),
(966, 'OCUCAJE', 98, 'portadaAppDelHambre1.jpg'),
(967, 'PACHACUTEC', 98, 'portadaAppDelHambre1.jpg'),
(968, 'PARCONA', 98, 'portadaAppDelHambre1.jpg'),
(969, 'PUEBLO NUEVO', 98, 'portadaAppDelHambre1.jpg'),
(970, 'SALAS', 98, 'portadaAppDelHambre1.jpg'),
(971, 'SAN JOSE DE LOS MOLINOS', 98, 'portadaAppDelHambre1.jpg'),
(972, 'SAN JUAN BAUTISTA', 98, 'portadaAppDelHambre1.jpg'),
(973, 'SANTIAGO', 98, 'portadaAppDelHambre1.jpg'),
(974, 'SUBTANJALLA', 98, 'portadaAppDelHambre1.jpg'),
(975, 'TATE', 98, 'portadaAppDelHambre1.jpg'),
(976, 'YAUCA DEL ROSARIO', 98, 'portadaAppDelHambre1.jpg'),
(977, 'CHINCHA ALTA', 99, 'portadaAppDelHambre1.jpg'),
(978, 'ALTO LARAN', 99, 'portadaAppDelHambre1.jpg'),
(979, 'CHAVIN', 99, 'portadaAppDelHambre1.jpg'),
(980, 'CHINCHA BAJA', 99, 'portadaAppDelHambre1.jpg'),
(981, 'EL CARMEN', 99, 'portadaAppDelHambre1.jpg'),
(982, 'GROCIO PRADO', 99, 'portadaAppDelHambre1.jpg'),
(983, 'PUEBLO NUEVO', 99, 'portadaAppDelHambre1.jpg'),
(984, 'SAN JUAN DE YANAC', 99, 'portadaAppDelHambre1.jpg'),
(985, 'SAN PEDRO DE HUACARPANA', 99, 'portadaAppDelHambre1.jpg'),
(986, 'SUNAMPE', 99, 'portadaAppDelHambre1.jpg'),
(987, 'TAMBO DE MORA', 99, 'portadaAppDelHambre1.jpg'),
(988, 'NAZCA', 100, 'portadaAppDelHambre1.jpg'),
(989, 'CHANGUILLO', 100, 'portadaAppDelHambre1.jpg'),
(990, 'EL INGENIO', 100, 'portadaAppDelHambre1.jpg'),
(991, 'MARCONA', 100, 'portadaAppDelHambre1.jpg'),
(992, 'VISTA ALEGRE', 100, 'portadaAppDelHambre1.jpg'),
(993, 'PALPA', 101, 'portadaAppDelHambre1.jpg'),
(994, 'LLIPATA', 101, 'portadaAppDelHambre1.jpg'),
(995, 'RIO GRANDE', 101, 'portadaAppDelHambre1.jpg'),
(996, 'SANTA CRUZ', 101, 'portadaAppDelHambre1.jpg');
INSERT INTO `ubdistrito` (`id`, `nombre`, `id_prov`, `foto_url`) VALUES
(997, 'TIBILLO', 101, 'portadaAppDelHambre1.jpg'),
(998, 'PISCO', 102, 'portadaAppDelHambre1.jpg'),
(999, 'HUANCANO', 102, 'portadaAppDelHambre1.jpg'),
(1000, 'HUMAY', 102, 'portadaAppDelHambre1.jpg'),
(1001, 'INDEPENDENCIA', 102, 'portadaAppDelHambre1.jpg'),
(1002, 'PARACAS', 102, 'portadaAppDelHambre1.jpg'),
(1003, 'SAN ANDRES', 102, 'portadaAppDelHambre1.jpg'),
(1004, 'SAN CLEMENTE', 102, 'portadaAppDelHambre1.jpg'),
(1005, 'TUPAC AMARU INCA', 102, 'portadaAppDelHambre1.jpg'),
(1006, 'HUANCAYO', 103, 'portadaAppDelHambre1.jpg'),
(1007, 'CARHUACALLANGA', 103, 'portadaAppDelHambre1.jpg'),
(1008, 'CHACAPAMPA', 103, 'portadaAppDelHambre1.jpg'),
(1009, 'CHICCHE', 103, 'portadaAppDelHambre1.jpg'),
(1010, 'CHILCA', 103, 'portadaAppDelHambre1.jpg'),
(1011, 'CHONGOS ALTO', 103, 'portadaAppDelHambre1.jpg'),
(1012, 'CHUPURO', 103, 'portadaAppDelHambre1.jpg'),
(1013, 'COLCA', 103, 'portadaAppDelHambre1.jpg'),
(1014, 'CULLHUAS', 103, 'portadaAppDelHambre1.jpg'),
(1015, 'EL TAMBO', 103, 'portadaAppDelHambre1.jpg'),
(1016, 'HUACRAPUQUIO', 103, 'portadaAppDelHambre1.jpg'),
(1017, 'HUALHUAS', 103, 'portadaAppDelHambre1.jpg'),
(1018, 'HUANCAN', 103, 'portadaAppDelHambre1.jpg'),
(1019, 'HUASICANCHA', 103, 'portadaAppDelHambre1.jpg'),
(1020, 'HUAYUCACHI', 103, 'portadaAppDelHambre1.jpg'),
(1021, 'INGENIO', 103, 'portadaAppDelHambre1.jpg'),
(1022, 'PARIAHUANCA', 103, 'portadaAppDelHambre1.jpg'),
(1023, 'PILCOMAYO', 103, 'portadaAppDelHambre1.jpg'),
(1024, 'PUCARA', 103, 'portadaAppDelHambre1.jpg'),
(1025, 'QUICHUAY', 103, 'portadaAppDelHambre1.jpg'),
(1026, 'QUILCAS', 103, 'portadaAppDelHambre1.jpg'),
(1027, 'SAN AGUSTIN', 103, 'portadaAppDelHambre1.jpg'),
(1028, 'SAN JERONIMO DE TUNAN', 103, 'portadaAppDelHambre1.jpg'),
(1029, 'SA&Ntilde;O', 103, 'portadaAppDelHambre1.jpg'),
(1030, 'SAPALLANGA', 103, 'portadaAppDelHambre1.jpg'),
(1031, 'SICAYA', 103, 'portadaAppDelHambre1.jpg'),
(1032, 'SANTO DOMINGO DE ACOBAMBA', 103, 'portadaAppDelHambre1.jpg'),
(1033, 'VIQUES', 103, 'portadaAppDelHambre1.jpg'),
(1034, 'CONCEPCION', 104, 'portadaAppDelHambre1.jpg'),
(1035, 'ACO', 104, 'portadaAppDelHambre1.jpg'),
(1036, 'ANDAMARCA', 104, 'portadaAppDelHambre1.jpg'),
(1037, 'CHAMBARA', 104, 'portadaAppDelHambre1.jpg'),
(1038, 'COCHAS', 104, 'portadaAppDelHambre1.jpg'),
(1039, 'COMAS', 104, 'portadaAppDelHambre1.jpg'),
(1040, 'HEROINAS TOLEDO', 104, 'portadaAppDelHambre1.jpg'),
(1041, 'MANZANARES', 104, 'portadaAppDelHambre1.jpg'),
(1042, 'MARISCAL CASTILLA', 104, 'portadaAppDelHambre1.jpg'),
(1043, 'MATAHUASI', 104, 'portadaAppDelHambre1.jpg'),
(1044, 'MITO', 104, 'portadaAppDelHambre1.jpg'),
(1045, 'NUEVE DE JULIO', 104, 'portadaAppDelHambre1.jpg'),
(1046, 'ORCOTUNA', 104, 'portadaAppDelHambre1.jpg'),
(1047, 'SAN JOSE DE QUERO', 104, 'portadaAppDelHambre1.jpg'),
(1048, 'SANTA ROSA DE OCOPA', 104, 'portadaAppDelHambre1.jpg'),
(1049, 'CHANCHAMAYO', 105, 'portadaAppDelHambre1.jpg'),
(1050, 'PERENE', 105, 'portadaAppDelHambre1.jpg'),
(1051, 'PICHANAQUI', 105, 'portadaAppDelHambre1.jpg'),
(1052, 'SAN LUIS DE SHUARO', 105, 'portadaAppDelHambre1.jpg'),
(1053, 'SAN RAMON', 105, 'portadaAppDelHambre1.jpg'),
(1054, 'VITOC', 105, 'portadaAppDelHambre1.jpg'),
(1055, 'JAUJA', 106, 'portadaAppDelHambre1.jpg'),
(1056, 'ACOLLA', 106, 'portadaAppDelHambre1.jpg'),
(1057, 'APATA', 106, 'portadaAppDelHambre1.jpg'),
(1058, 'ATAURA', 106, 'portadaAppDelHambre1.jpg'),
(1059, 'CANCHAYLLO', 106, 'portadaAppDelHambre1.jpg'),
(1060, 'CURICACA', 106, 'portadaAppDelHambre1.jpg'),
(1061, 'EL MANTARO', 106, 'portadaAppDelHambre1.jpg'),
(1062, 'HUAMALI', 106, 'portadaAppDelHambre1.jpg'),
(1063, 'HUARIPAMPA', 106, 'portadaAppDelHambre1.jpg'),
(1064, 'HUERTAS', 106, 'portadaAppDelHambre1.jpg'),
(1065, 'JANJAILLO', 106, 'portadaAppDelHambre1.jpg'),
(1066, 'JULCAN', 106, 'portadaAppDelHambre1.jpg'),
(1067, 'LEONOR ORDO&Ntilde;EZ', 106, 'portadaAppDelHambre1.jpg'),
(1068, 'LLOCLLAPAMPA', 106, 'portadaAppDelHambre1.jpg'),
(1069, 'MARCO', 106, 'portadaAppDelHambre1.jpg'),
(1070, 'MASMA', 106, 'portadaAppDelHambre1.jpg'),
(1071, 'MASMA CHICCHE', 106, 'portadaAppDelHambre1.jpg'),
(1072, 'MOLINOS', 106, 'portadaAppDelHambre1.jpg'),
(1073, 'MONOBAMBA', 106, 'portadaAppDelHambre1.jpg'),
(1074, 'MUQUI', 106, 'portadaAppDelHambre1.jpg'),
(1075, 'MUQUIYAUYO', 106, 'portadaAppDelHambre1.jpg'),
(1076, 'PACA', 106, 'portadaAppDelHambre1.jpg'),
(1077, 'PACCHA', 106, 'portadaAppDelHambre1.jpg'),
(1078, 'PANCAN', 106, 'portadaAppDelHambre1.jpg'),
(1079, 'PARCO', 106, 'portadaAppDelHambre1.jpg'),
(1080, 'POMACANCHA', 106, 'portadaAppDelHambre1.jpg'),
(1081, 'RICRAN', 106, 'portadaAppDelHambre1.jpg'),
(1082, 'SAN LORENZO', 106, 'portadaAppDelHambre1.jpg'),
(1083, 'SAN PEDRO DE CHUNAN', 106, 'portadaAppDelHambre1.jpg'),
(1084, 'SAUSA', 106, 'portadaAppDelHambre1.jpg'),
(1085, 'SINCOS', 106, 'portadaAppDelHambre1.jpg'),
(1086, 'TUNAN MARCA', 106, 'portadaAppDelHambre1.jpg'),
(1087, 'YAULI', 106, 'portadaAppDelHambre1.jpg'),
(1088, 'YAUYOS', 106, 'portadaAppDelHambre1.jpg'),
(1089, 'JUNIN', 107, 'portadaAppDelHambre1.jpg'),
(1090, 'CARHUAMAYO', 107, 'portadaAppDelHambre1.jpg'),
(1091, 'ONDORES', 107, 'portadaAppDelHambre1.jpg'),
(1092, 'ULCUMAYO', 107, 'portadaAppDelHambre1.jpg'),
(1093, 'SATIPO', 108, 'portadaAppDelHambre1.jpg'),
(1094, 'COVIRIALI', 108, 'portadaAppDelHambre1.jpg'),
(1095, 'LLAYLLA', 108, 'portadaAppDelHambre1.jpg'),
(1096, 'MAZAMARI', 108, 'portadaAppDelHambre1.jpg'),
(1097, 'PAMPA HERMOSA', 108, 'portadaAppDelHambre1.jpg'),
(1098, 'PANGOA', 108, 'portadaAppDelHambre1.jpg'),
(1099, 'RIO NEGRO', 108, 'portadaAppDelHambre1.jpg'),
(1100, 'RIO TAMBO', 108, 'portadaAppDelHambre1.jpg'),
(1101, 'TARMA', 109, 'portadaAppDelHambre1.jpg'),
(1102, 'ACOBAMBA', 109, 'portadaAppDelHambre1.jpg'),
(1103, 'HUARICOLCA', 109, 'portadaAppDelHambre1.jpg'),
(1104, 'HUASAHUASI', 109, 'portadaAppDelHambre1.jpg'),
(1105, 'LA UNION', 109, 'portadaAppDelHambre1.jpg'),
(1106, 'PALCA', 109, 'portadaAppDelHambre1.jpg'),
(1107, 'PALCAMAYO', 109, 'portadaAppDelHambre1.jpg'),
(1108, 'SAN PEDRO DE CAJAS', 109, 'portadaAppDelHambre1.jpg'),
(1109, 'TAPO', 109, 'portadaAppDelHambre1.jpg'),
(1110, 'LA OROYA', 110, 'portadaAppDelHambre1.jpg'),
(1111, 'CHACAPALPA', 110, 'portadaAppDelHambre1.jpg'),
(1112, 'HUAY-HUAY', 110, 'portadaAppDelHambre1.jpg'),
(1113, 'MARCAPOMACOCHA', 110, 'portadaAppDelHambre1.jpg'),
(1114, 'MOROCOCHA', 110, 'portadaAppDelHambre1.jpg'),
(1115, 'PACCHA', 110, 'portadaAppDelHambre1.jpg'),
(1116, 'SANTA BARBARA DE CARHUACAYAN', 110, 'portadaAppDelHambre1.jpg'),
(1117, 'SANTA ROSA DE SACCO', 110, 'portadaAppDelHambre1.jpg'),
(1118, 'SUITUCANCHA', 110, 'portadaAppDelHambre1.jpg'),
(1119, 'YAULI', 110, 'portadaAppDelHambre1.jpg'),
(1120, 'CHUPACA', 111, 'portadaAppDelHambre1.jpg'),
(1121, 'AHUAC', 111, 'portadaAppDelHambre1.jpg'),
(1122, 'CHONGOS BAJO', 111, 'portadaAppDelHambre1.jpg'),
(1123, 'HUACHAC', 111, 'portadaAppDelHambre1.jpg'),
(1124, 'HUAMANCACA CHICO', 111, 'portadaAppDelHambre1.jpg'),
(1125, 'SAN JUAN DE ISCOS', 111, 'portadaAppDelHambre1.jpg'),
(1126, 'SAN JUAN DE JARPA', 111, 'portadaAppDelHambre1.jpg'),
(1127, 'TRES DE DICIEMBRE', 111, 'portadaAppDelHambre1.jpg'),
(1128, 'YANACANCHA', 111, 'portadaAppDelHambre1.jpg'),
(1129, 'TRUJILLO', 112, 'portadaAppDelHambre1.jpg'),
(1130, 'EL PORVENIR', 112, 'portadaAppDelHambre1.jpg'),
(1131, 'FLORENCIA DE MORA', 112, 'portadaAppDelHambre1.jpg'),
(1132, 'HUANCHACO', 112, 'portadaAppDelHambre1.jpg'),
(1133, 'LA ESPERANZA', 112, 'portadaAppDelHambre1.jpg'),
(1134, 'LAREDO', 112, 'portadaAppDelHambre1.jpg'),
(1135, 'MOCHE', 112, 'portadaAppDelHambre1.jpg'),
(1136, 'POROTO', 112, 'portadaAppDelHambre1.jpg'),
(1137, 'SALAVERRY', 112, 'portadaAppDelHambre1.jpg'),
(1138, 'SIMBAL', 112, 'portadaAppDelHambre1.jpg'),
(1139, 'VICTOR LARCO HERRERA', 112, 'portadaAppDelHambre1.jpg'),
(1140, 'ASCOPE', 113, 'portadaAppDelHambre1.jpg'),
(1141, 'CHICAMA', 113, 'portadaAppDelHambre1.jpg'),
(1142, 'CHOCOPE', 113, 'portadaAppDelHambre1.jpg'),
(1143, 'MAGDALENA DE CAO', 113, 'portadaAppDelHambre1.jpg'),
(1144, 'PAIJAN', 113, 'portadaAppDelHambre1.jpg'),
(1145, 'RAZURI', 113, 'portadaAppDelHambre1.jpg'),
(1146, 'SANTIAGO DE CAO', 113, 'portadaAppDelHambre1.jpg'),
(1147, 'CASA GRANDE', 113, 'portadaAppDelHambre1.jpg'),
(1148, 'BOLIVAR', 114, 'portadaAppDelHambre1.jpg'),
(1149, 'BAMBAMARCA', 114, 'portadaAppDelHambre1.jpg'),
(1150, 'CONDORMARCA', 114, 'portadaAppDelHambre1.jpg'),
(1151, 'LONGOTEA', 114, 'portadaAppDelHambre1.jpg'),
(1152, 'UCHUMARCA', 114, 'portadaAppDelHambre1.jpg'),
(1153, 'UCUNCHA', 114, 'portadaAppDelHambre1.jpg'),
(1154, 'CHEPEN', 115, 'portadaAppDelHambre1.jpg'),
(1155, 'PACANGA', 115, 'portadaAppDelHambre1.jpg'),
(1156, 'PUEBLO NUEVO', 115, 'portadaAppDelHambre1.jpg'),
(1157, 'JULCAN', 116, 'portadaAppDelHambre1.jpg'),
(1158, 'CALAMARCA', 116, 'portadaAppDelHambre1.jpg'),
(1159, 'CARABAMBA', 116, 'portadaAppDelHambre1.jpg'),
(1160, 'HUASO', 116, 'portadaAppDelHambre1.jpg'),
(1161, 'OTUZCO', 117, 'portadaAppDelHambre1.jpg'),
(1162, 'AGALLPAMPA', 117, 'portadaAppDelHambre1.jpg'),
(1163, 'CHARAT', 117, 'portadaAppDelHambre1.jpg'),
(1164, 'HUARANCHAL', 117, 'portadaAppDelHambre1.jpg'),
(1165, 'LA CUESTA', 117, 'portadaAppDelHambre1.jpg'),
(1166, 'MACHE', 117, 'portadaAppDelHambre1.jpg'),
(1167, 'PARANDAY', 117, 'portadaAppDelHambre1.jpg'),
(1168, 'SALPO', 117, 'portadaAppDelHambre1.jpg'),
(1169, 'SINSICAP', 117, 'portadaAppDelHambre1.jpg'),
(1170, 'USQUIL', 117, 'portadaAppDelHambre1.jpg'),
(1171, 'SAN PEDRO DE LLOC', 118, 'portadaAppDelHambre1.jpg'),
(1172, 'GUADALUPE', 118, 'portadaAppDelHambre1.jpg'),
(1173, 'JEQUETEPEQUE', 118, 'portadaAppDelHambre1.jpg'),
(1174, 'PACASMAYO', 118, 'portadaAppDelHambre1.jpg'),
(1175, 'SAN JOSE', 118, 'portadaAppDelHambre1.jpg'),
(1176, 'TAYABAMBA', 119, 'portadaAppDelHambre1.jpg'),
(1177, 'BULDIBUYO', 119, 'portadaAppDelHambre1.jpg'),
(1178, 'CHILLIA', 119, 'portadaAppDelHambre1.jpg'),
(1179, 'HUANCASPATA', 119, 'portadaAppDelHambre1.jpg'),
(1180, 'HUAYLILLAS', 119, 'portadaAppDelHambre1.jpg'),
(1181, 'HUAYO', 119, 'portadaAppDelHambre1.jpg'),
(1182, 'ONGON', 119, 'portadaAppDelHambre1.jpg'),
(1183, 'PARCOY', 119, 'portadaAppDelHambre1.jpg'),
(1184, 'PATAZ', 119, 'portadaAppDelHambre1.jpg'),
(1185, 'PIAS', 119, 'portadaAppDelHambre1.jpg'),
(1186, 'SANTIAGO DE CHALLAS', 119, 'portadaAppDelHambre1.jpg'),
(1187, 'TAURIJA', 119, 'portadaAppDelHambre1.jpg'),
(1188, 'URPAY', 119, 'portadaAppDelHambre1.jpg'),
(1189, 'HUAMACHUCO', 120, 'portadaAppDelHambre1.jpg'),
(1190, 'CHUGAY', 120, 'portadaAppDelHambre1.jpg'),
(1191, 'COCHORCO', 120, 'portadaAppDelHambre1.jpg'),
(1192, 'CURGOS', 120, 'portadaAppDelHambre1.jpg'),
(1193, 'MARCABAL', 120, 'portadaAppDelHambre1.jpg'),
(1194, 'SANAGORAN', 120, 'portadaAppDelHambre1.jpg'),
(1195, 'SARIN', 120, 'portadaAppDelHambre1.jpg'),
(1196, 'SARTIMBAMBA', 120, 'portadaAppDelHambre1.jpg'),
(1197, 'SANTIAGO DE CHUCO', 121, 'portadaAppDelHambre1.jpg'),
(1198, 'ANGASMARCA', 121, 'portadaAppDelHambre1.jpg'),
(1199, 'CACHICADAN', 121, 'portadaAppDelHambre1.jpg'),
(1200, 'MOLLEBAMBA', 121, 'portadaAppDelHambre1.jpg'),
(1201, 'MOLLEPATA', 121, 'portadaAppDelHambre1.jpg'),
(1202, 'QUIRUVILCA', 121, 'portadaAppDelHambre1.jpg'),
(1203, 'SANTA CRUZ DE CHUCA', 121, 'portadaAppDelHambre1.jpg'),
(1204, 'SITABAMBA', 121, 'portadaAppDelHambre1.jpg'),
(1205, 'GRAN CHIMU', 122, 'portadaAppDelHambre1.jpg'),
(1206, 'CASCAS', 122, 'portadaAppDelHambre1.jpg'),
(1207, 'LUCMA', 122, 'portadaAppDelHambre1.jpg'),
(1208, 'MARMOT', 122, 'portadaAppDelHambre1.jpg'),
(1209, 'SAYAPULLO', 122, 'portadaAppDelHambre1.jpg'),
(1210, 'VIRU', 123, 'portadaAppDelHambre1.jpg'),
(1211, 'CHAO', 123, 'portadaAppDelHambre1.jpg'),
(1212, 'GUADALUPITO', 123, 'portadaAppDelHambre1.jpg'),
(1213, 'CHICLAYO', 124, 'portadaAppDelHambre1.jpg'),
(1214, 'CHONGOYAPE', 124, 'portadaAppDelHambre1.jpg'),
(1215, 'ETEN', 124, 'portadaAppDelHambre1.jpg'),
(1216, 'ETEN PUERTO', 124, 'portadaAppDelHambre1.jpg'),
(1217, 'JOSE LEONARDO ORTIZ', 124, 'portadaAppDelHambre1.jpg'),
(1218, 'LA VICTORIA', 124, 'portadaAppDelHambre1.jpg'),
(1219, 'LAGUNAS', 124, 'portadaAppDelHambre1.jpg'),
(1220, 'MONSEFU', 124, 'portadaAppDelHambre1.jpg'),
(1221, 'NUEVA ARICA', 124, 'portadaAppDelHambre1.jpg'),
(1222, 'OYOTUN', 124, 'portadaAppDelHambre1.jpg'),
(1223, 'PICSI', 124, 'portadaAppDelHambre1.jpg'),
(1224, 'PIMENTEL', 124, 'portadaAppDelHambre1.jpg'),
(1225, 'REQUE', 124, 'portadaAppDelHambre1.jpg'),
(1226, 'SANTA ROSA', 124, 'portadaAppDelHambre1.jpg'),
(1227, 'SA&Ntilde;A', 124, 'portadaAppDelHambre1.jpg'),
(1228, 'CAYALTI', 124, 'portadaAppDelHambre1.jpg'),
(1229, 'PATAPO', 124, 'portadaAppDelHambre1.jpg'),
(1230, 'POMALCA', 124, 'portadaAppDelHambre1.jpg'),
(1231, 'PUCALA', 124, 'portadaAppDelHambre1.jpg'),
(1232, 'TUMAN', 124, 'portadaAppDelHambre1.jpg'),
(1233, 'FERREÑAFE', 125, 'portadaAppDelHambre1.jpg'),
(1234, 'CAÑARIS', 125, 'portadaAppDelHambre1.jpg'),
(1235, 'INCAHUASI', 125, 'portadaAppDelHambre1.jpg'),
(1236, 'MANUEL ANTONIO MESONES MURO', 125, 'portadaAppDelHambre1.jpg'),
(1237, 'PITIPO', 125, 'portadaAppDelHambre1.jpg'),
(1238, 'PUEBLO NUEVO', 125, 'portadaAppDelHambre1.jpg'),
(1239, 'LAMBAYEQUE', 126, 'portadaAppDelHambre1.jpg'),
(1240, 'CHOCHOPE', 126, 'portadaAppDelHambre1.jpg'),
(1241, 'ILLIMO', 126, 'portadaAppDelHambre1.jpg'),
(1242, 'JAYANCA', 126, 'portadaAppDelHambre1.jpg'),
(1243, 'MOCHUMI', 126, 'portadaAppDelHambre1.jpg'),
(1244, 'MORROPE', 126, 'portadaAppDelHambre1.jpg'),
(1245, 'MOTUPE', 126, 'portadaAppDelHambre1.jpg'),
(1246, 'OLMOS', 126, 'portadaAppDelHambre1.jpg'),
(1247, 'PACORA', 126, 'portadaAppDelHambre1.jpg'),
(1248, 'SALAS', 126, 'portadaAppDelHambre1.jpg'),
(1249, 'SAN JOSE', 126, 'portadaAppDelHambre1.jpg'),
(1250, 'TUCUME', 126, 'portadaAppDelHambre1.jpg'),
(1251, 'LIMA', 127, 'portadaAppDelHambre1.jpg'),
(1252, 'ANCON', 127, 'portadaAppDelHambre1.jpg'),
(1253, 'ATE', 127, 'portadaAppDelHambre1.jpg'),
(1254, 'BARRANCO', 127, 'portadaAppDelHambre1.jpg'),
(1255, 'BRE&Ntilde;A', 127, 'portadaAppDelHambre1.jpg'),
(1256, 'CARABAYLLO', 127, 'portadaAppDelHambre1.jpg'),
(1257, 'CHACLACAYO', 127, 'portadaAppDelHambre1.jpg'),
(1258, 'CHORRILLOS', 127, 'portadaAppDelHambre1.jpg'),
(1259, 'CIENEGUILLA', 127, 'portadaAppDelHambre1.jpg'),
(1260, 'COMAS', 127, 'portadaAppDelHambre1.jpg'),
(1261, 'EL AGUSTINO', 127, 'portadaAppDelHambre1.jpg'),
(1262, 'INDEPENDENCIA', 127, 'portadaAppDelHambre1.jpg'),
(1263, 'JESUS MARIA', 127, 'portadaAppDelHambre1.jpg'),
(1264, 'LA MOLINA', 127, 'portadaAppDelHambre1.jpg'),
(1265, 'LA VICTORIA', 127, 'portadaAppDelHambre1.jpg'),
(1266, 'LINCE', 127, 'portadaAppDelHambre1.jpg'),
(1267, 'LOS OLIVOS', 127, 'portadaAppDelHambre1.jpg'),
(1268, 'LURIGANCHO', 127, 'portadaAppDelHambre1.jpg'),
(1269, 'LURIN', 127, 'portadaAppDelHambre1.jpg'),
(1270, 'MAGDALENA DEL MAR', 127, 'portadaAppDelHambre1.jpg'),
(1271, 'MAGDALENA VIEJA', 127, 'portadaAppDelHambre1.jpg'),
(1272, 'MIRAFLORES', 127, 'portadaAppDelHambre1.jpg'),
(1273, 'PACHACAMAC', 127, 'portadaAppDelHambre1.jpg'),
(1274, 'PUCUSANA', 127, 'portadaAppDelHambre1.jpg'),
(1275, 'PUENTE PIEDRA', 127, 'portadaAppDelHambre1.jpg'),
(1276, 'PUNTA HERMOSA', 127, 'portadaAppDelHambre1.jpg'),
(1277, 'PUNTA NEGRA', 127, 'portadaAppDelHambre1.jpg'),
(1278, 'RIMAC', 127, 'portadaAppDelHambre1.jpg'),
(1279, 'SAN BARTOLO', 127, 'portadaAppDelHambre1.jpg'),
(1280, 'SAN BORJA', 127, 'portadaAppDelHambre1.jpg'),
(1281, 'SAN ISIDRO', 127, 'portadaAppDelHambre1.jpg'),
(1282, 'SAN JUAN DE LURIGANCHO', 127, 'portadaAppDelHambre1.jpg'),
(1283, 'SAN JUAN DE MIRAFLORES', 127, 'portadaAppDelHambre1.jpg'),
(1284, 'SAN LUIS', 127, 'portadaAppDelHambre1.jpg'),
(1285, 'SAN MARTIN DE PORRES', 127, 'portadaAppDelHambre1.jpg'),
(1286, 'SAN MIGUEL', 127, 'portadaAppDelHambre1.jpg'),
(1287, 'SANTA ANITA', 127, 'portadaAppDelHambre1.jpg'),
(1288, 'SANTA MARIA DEL MAR', 127, 'portadaAppDelHambre1.jpg'),
(1289, 'SANTA ROSA', 127, 'portadaAppDelHambre1.jpg'),
(1290, 'SANTIAGO DE SURCO', 127, 'portadaAppDelHambre1.jpg'),
(1291, 'SURQUILLO', 127, 'portadaAppDelHambre1.jpg'),
(1292, 'VILLA EL SALVADOR', 127, 'portadaAppDelHambre1.jpg'),
(1293, 'VILLA MARIA DEL TRIUNFO', 127, 'portadaAppDelHambre1.jpg'),
(1294, 'BARRANCA', 128, 'portadaAppDelHambre1.jpg'),
(1295, 'PARAMONGA', 128, 'portadaAppDelHambre1.jpg'),
(1296, 'PATIVILCA', 128, 'portadaAppDelHambre1.jpg'),
(1297, 'SUPE', 128, 'portadaAppDelHambre1.jpg'),
(1298, 'SUPE PUERTO', 128, 'portadaAppDelHambre1.jpg'),
(1299, 'CAJATAMBO', 129, 'portadaAppDelHambre1.jpg'),
(1300, 'COPA', 129, 'portadaAppDelHambre1.jpg'),
(1301, 'GORGOR', 129, 'portadaAppDelHambre1.jpg'),
(1302, 'HUANCAPON', 129, 'portadaAppDelHambre1.jpg'),
(1303, 'MANAS', 129, 'portadaAppDelHambre1.jpg'),
(1304, 'CANTA', 130, 'portadaAppDelHambre1.jpg'),
(1305, 'ARAHUAY', 130, 'portadaAppDelHambre1.jpg'),
(1306, 'HUAMANTANGA', 130, 'portadaAppDelHambre1.jpg'),
(1307, 'HUAROS', 130, 'portadaAppDelHambre1.jpg'),
(1308, 'LACHAQUI', 130, 'portadaAppDelHambre1.jpg'),
(1309, 'SAN BUENAVENTURA', 130, 'portadaAppDelHambre1.jpg'),
(1310, 'SANTA ROSA DE QUIVES', 130, 'portadaAppDelHambre1.jpg'),
(1311, 'SAN VICENTE DE CA&Ntilde;ETE', 131, 'portadaAppDelHambre1.jpg'),
(1312, 'ASIA', 131, 'portadaAppDelHambre1.jpg'),
(1313, 'CALANGO', 131, 'portadaAppDelHambre1.jpg'),
(1314, 'CERRO AZUL', 131, 'portadaAppDelHambre1.jpg'),
(1315, 'CHILCA', 131, 'portadaAppDelHambre1.jpg'),
(1316, 'COAYLLO', 131, 'portadaAppDelHambre1.jpg'),
(1317, 'IMPERIAL', 131, 'portadaAppDelHambre1.jpg'),
(1318, 'LUNAHUANA', 131, 'portadaAppDelHambre1.jpg'),
(1319, 'MALA', 131, 'portadaAppDelHambre1.jpg'),
(1320, 'NUEVO IMPERIAL', 131, 'portadaAppDelHambre1.jpg'),
(1321, 'PACARAN', 131, 'portadaAppDelHambre1.jpg'),
(1322, 'QUILMANA', 131, 'portadaAppDelHambre1.jpg'),
(1323, 'SAN ANTONIO', 131, 'portadaAppDelHambre1.jpg'),
(1324, 'SAN LUIS', 131, 'portadaAppDelHambre1.jpg'),
(1325, 'SANTA CRUZ DE FLORES', 131, 'portadaAppDelHambre1.jpg'),
(1326, 'ZU&Ntilde;IGA', 131, 'portadaAppDelHambre1.jpg'),
(1327, 'HUARAL', 132, 'portadaAppDelHambre1.jpg'),
(1328, 'ATAVILLOS ALTO', 132, 'portadaAppDelHambre1.jpg'),
(1329, 'ATAVILLOS BAJO', 132, 'portadaAppDelHambre1.jpg'),
(1330, 'AUCALLAMA', 132, 'portadaAppDelHambre1.jpg'),
(1331, 'CHANCAY', 132, 'portadaAppDelHambre1.jpg'),
(1332, 'IHUARI', 132, 'portadaAppDelHambre1.jpg'),
(1333, 'LAMPIAN', 132, 'portadaAppDelHambre1.jpg'),
(1334, 'PACARAOS', 132, 'portadaAppDelHambre1.jpg'),
(1335, 'SAN MIGUEL DE ACOS', 132, 'portadaAppDelHambre1.jpg'),
(1336, 'SANTA CRUZ DE ANDAMARCA', 132, 'portadaAppDelHambre1.jpg'),
(1337, 'SUMBILCA', 132, 'portadaAppDelHambre1.jpg'),
(1338, 'VEINTISIETE DE NOVIEMBRE', 132, 'portadaAppDelHambre1.jpg'),
(1339, 'MATUCANA', 133, 'portadaAppDelHambre1.jpg'),
(1340, 'ANTIOQUIA', 133, 'portadaAppDelHambre1.jpg'),
(1341, 'CALLAHUANCA', 133, 'portadaAppDelHambre1.jpg'),
(1342, 'CARAMPOMA', 133, 'portadaAppDelHambre1.jpg'),
(1343, 'CHICLA', 133, 'portadaAppDelHambre1.jpg'),
(1344, 'CUENCA', 133, 'portadaAppDelHambre1.jpg'),
(1345, 'HUACHUPAMPA', 133, 'portadaAppDelHambre1.jpg'),
(1346, 'HUANZA', 133, 'portadaAppDelHambre1.jpg'),
(1347, 'HUAROCHIRI', 133, 'portadaAppDelHambre1.jpg'),
(1348, 'LAHUAYTAMBO', 133, 'portadaAppDelHambre1.jpg'),
(1349, 'LANGA', 133, 'portadaAppDelHambre1.jpg'),
(1350, 'LARAOS', 133, 'portadaAppDelHambre1.jpg'),
(1351, 'MARIATANA', 133, 'portadaAppDelHambre1.jpg'),
(1352, 'RICARDO PALMA', 133, 'portadaAppDelHambre1.jpg'),
(1353, 'SAN ANDRES DE TUPICOCHA', 133, 'portadaAppDelHambre1.jpg'),
(1354, 'SAN ANTONIO', 133, 'portadaAppDelHambre1.jpg'),
(1355, 'SAN BARTOLOME', 133, 'portadaAppDelHambre1.jpg'),
(1356, 'SAN DAMIAN', 133, 'portadaAppDelHambre1.jpg'),
(1357, 'SAN JUAN DE IRIS', 133, 'portadaAppDelHambre1.jpg'),
(1358, 'SAN JUAN DE TANTARANCHE', 133, 'portadaAppDelHambre1.jpg'),
(1359, 'SAN LORENZO DE QUINTI', 133, 'portadaAppDelHambre1.jpg'),
(1360, 'SAN MATEO', 133, 'portadaAppDelHambre1.jpg'),
(1361, 'SAN MATEO DE OTAO', 133, 'portadaAppDelHambre1.jpg'),
(1362, 'SAN PEDRO DE CASTA', 133, 'portadaAppDelHambre1.jpg'),
(1363, 'SAN PEDRO DE HUANCAYRE', 133, 'portadaAppDelHambre1.jpg'),
(1364, 'SANGALLAYA', 133, 'portadaAppDelHambre1.jpg'),
(1365, 'SANTA CRUZ DE COCACHACRA', 133, 'portadaAppDelHambre1.jpg'),
(1366, 'SANTA EULALIA', 133, 'portadaAppDelHambre1.jpg'),
(1367, 'SANTIAGO DE ANCHUCAYA', 133, 'portadaAppDelHambre1.jpg'),
(1368, 'SANTIAGO DE TUNA', 133, 'portadaAppDelHambre1.jpg'),
(1369, 'SANTO DOMINGO DE LOS OLLEROS', 133, 'portadaAppDelHambre1.jpg'),
(1370, 'SURCO', 133, 'portadaAppDelHambre1.jpg'),
(1371, 'HUACHO', 134, 'portadaAppDelHambre1.jpg'),
(1372, 'AMBAR', 134, 'portadaAppDelHambre1.jpg'),
(1373, 'CALETA DE CARQUIN', 134, 'portadaAppDelHambre1.jpg'),
(1374, 'CHECRAS', 134, 'portadaAppDelHambre1.jpg'),
(1375, 'HUALMAY', 134, 'portadaAppDelHambre1.jpg'),
(1376, 'HUAURA', 134, 'portadaAppDelHambre1.jpg'),
(1377, 'LEONCIO PRADO', 134, 'portadaAppDelHambre1.jpg'),
(1378, 'PACCHO', 134, 'portadaAppDelHambre1.jpg'),
(1379, 'SANTA LEONOR', 134, 'portadaAppDelHambre1.jpg'),
(1380, 'SANTA MARIA', 134, 'portadaAppDelHambre1.jpg'),
(1381, 'SAYAN', 134, 'portadaAppDelHambre1.jpg'),
(1382, 'VEGUETA', 134, 'portadaAppDelHambre1.jpg'),
(1383, 'OYON', 135, 'portadaAppDelHambre1.jpg'),
(1384, 'ANDAJES', 135, 'portadaAppDelHambre1.jpg'),
(1385, 'CAUJUL', 135, 'portadaAppDelHambre1.jpg'),
(1386, 'COCHAMARCA', 135, 'portadaAppDelHambre1.jpg'),
(1387, 'NAVAN', 135, 'portadaAppDelHambre1.jpg'),
(1388, 'PACHANGARA', 135, 'portadaAppDelHambre1.jpg'),
(1389, 'YAUYOS', 136, 'portadaAppDelHambre1.jpg'),
(1390, 'ALIS', 136, 'portadaAppDelHambre1.jpg'),
(1391, 'AYAUCA', 136, 'portadaAppDelHambre1.jpg'),
(1392, 'AYAVIRI', 136, 'portadaAppDelHambre1.jpg'),
(1393, 'AZANGARO', 136, 'portadaAppDelHambre1.jpg'),
(1394, 'CACRA', 136, 'portadaAppDelHambre1.jpg'),
(1395, 'CARANIA', 136, 'portadaAppDelHambre1.jpg'),
(1396, 'CATAHUASI', 136, 'portadaAppDelHambre1.jpg'),
(1397, 'CHOCOS', 136, 'portadaAppDelHambre1.jpg'),
(1398, 'COCHAS', 136, 'portadaAppDelHambre1.jpg'),
(1399, 'COLONIA', 136, 'portadaAppDelHambre1.jpg'),
(1400, 'HONGOS', 136, 'portadaAppDelHambre1.jpg'),
(1401, 'HUAMPARA', 136, 'portadaAppDelHambre1.jpg'),
(1402, 'HUANCAYA', 136, 'portadaAppDelHambre1.jpg'),
(1403, 'HUANGASCAR', 136, 'portadaAppDelHambre1.jpg'),
(1404, 'HUANTAN', 136, 'portadaAppDelHambre1.jpg'),
(1405, 'HUA&Ntilde;EC', 136, 'portadaAppDelHambre1.jpg'),
(1406, 'LARAOS', 136, 'portadaAppDelHambre1.jpg'),
(1407, 'LINCHA', 136, 'portadaAppDelHambre1.jpg'),
(1408, 'MADEAN', 136, 'portadaAppDelHambre1.jpg'),
(1409, 'MIRAFLORES', 136, 'portadaAppDelHambre1.jpg'),
(1410, 'OMAS', 136, 'portadaAppDelHambre1.jpg'),
(1411, 'PUTINZA', 136, 'portadaAppDelHambre1.jpg'),
(1412, 'QUINCHES', 136, 'portadaAppDelHambre1.jpg'),
(1413, 'QUINOCAY', 136, 'portadaAppDelHambre1.jpg'),
(1414, 'SAN JOAQUIN', 136, 'portadaAppDelHambre1.jpg'),
(1415, 'SAN PEDRO DE PILAS', 136, 'portadaAppDelHambre1.jpg'),
(1416, 'TANTA', 136, 'portadaAppDelHambre1.jpg'),
(1417, 'TAURIPAMPA', 136, 'portadaAppDelHambre1.jpg'),
(1418, 'TOMAS', 136, 'portadaAppDelHambre1.jpg'),
(1419, 'TUPE', 136, 'portadaAppDelHambre1.jpg'),
(1420, 'VI&Ntilde;AC', 136, 'portadaAppDelHambre1.jpg'),
(1421, 'VITIS', 136, 'portadaAppDelHambre1.jpg'),
(1422, 'IQUITOS', 137, 'portadaAppDelHambre1.jpg'),
(1423, 'ALTO NANAY', 137, 'portadaAppDelHambre1.jpg'),
(1424, 'FERNANDO LORES', 137, 'portadaAppDelHambre1.jpg'),
(1425, 'INDIANA', 137, 'portadaAppDelHambre1.jpg'),
(1426, 'LAS AMAZONAS', 137, 'portadaAppDelHambre1.jpg'),
(1427, 'MAZAN', 137, 'portadaAppDelHambre1.jpg'),
(1428, 'NAPO', 137, 'portadaAppDelHambre1.jpg'),
(1429, 'PUNCHANA', 137, 'portadaAppDelHambre1.jpg'),
(1430, 'PUTUMAYO', 137, 'portadaAppDelHambre1.jpg'),
(1431, 'TORRES CAUSANA', 137, 'portadaAppDelHambre1.jpg'),
(1432, 'BELEN', 137, 'portadaAppDelHambre1.jpg'),
(1433, 'SAN JUAN BAUTISTA', 137, 'portadaAppDelHambre1.jpg'),
(1434, 'YURIMAGUAS', 138, 'portadaAppDelHambre1.jpg'),
(1435, 'BALSAPUERTO', 138, 'portadaAppDelHambre1.jpg'),
(1436, 'BARRANCA', 138, 'portadaAppDelHambre1.jpg'),
(1437, 'CAHUAPANAS', 138, 'portadaAppDelHambre1.jpg'),
(1438, 'JEBEROS', 138, 'portadaAppDelHambre1.jpg'),
(1439, 'LAGUNAS', 138, 'portadaAppDelHambre1.jpg'),
(1440, 'MANSERICHE', 138, 'portadaAppDelHambre1.jpg'),
(1441, 'MORONA', 138, 'portadaAppDelHambre1.jpg'),
(1442, 'PASTAZA', 138, 'portadaAppDelHambre1.jpg'),
(1443, 'SANTA CRUZ', 138, 'portadaAppDelHambre1.jpg'),
(1444, 'TENIENTE CESAR LOPEZ ROJAS', 138, 'portadaAppDelHambre1.jpg'),
(1445, 'NAUTA', 139, 'portadaAppDelHambre1.jpg'),
(1446, 'PARINARI', 139, 'portadaAppDelHambre1.jpg'),
(1447, 'TIGRE', 139, 'portadaAppDelHambre1.jpg'),
(1448, 'TROMPETEROS', 139, 'portadaAppDelHambre1.jpg'),
(1449, 'URARINAS', 139, 'portadaAppDelHambre1.jpg'),
(1450, 'RAMON CASTILLA', 140, 'portadaAppDelHambre1.jpg'),
(1451, 'PEBAS', 140, 'portadaAppDelHambre1.jpg'),
(1452, 'YAVARI', 140, 'portadaAppDelHambre1.jpg'),
(1453, 'SAN PABLO', 140, 'portadaAppDelHambre1.jpg'),
(1454, 'REQUENA', 141, 'portadaAppDelHambre1.jpg'),
(1455, 'ALTO TAPICHE', 141, 'portadaAppDelHambre1.jpg'),
(1456, 'CAPELO', 141, 'portadaAppDelHambre1.jpg'),
(1457, 'EMILIO SAN MARTIN', 141, 'portadaAppDelHambre1.jpg'),
(1458, 'MAQUIA', 141, 'portadaAppDelHambre1.jpg'),
(1459, 'PUINAHUA', 141, 'portadaAppDelHambre1.jpg'),
(1460, 'SAQUENA', 141, 'portadaAppDelHambre1.jpg'),
(1461, 'SOPLIN', 141, 'portadaAppDelHambre1.jpg'),
(1462, 'TAPICHE', 141, 'portadaAppDelHambre1.jpg'),
(1463, 'JENARO HERRERA', 141, 'portadaAppDelHambre1.jpg'),
(1464, 'YAQUERANA', 141, 'portadaAppDelHambre1.jpg'),
(1465, 'CONTAMANA', 142, 'portadaAppDelHambre1.jpg'),
(1466, 'INAHUAYA', 142, 'portadaAppDelHambre1.jpg'),
(1467, 'PADRE MARQUEZ', 142, 'portadaAppDelHambre1.jpg'),
(1468, 'PAMPA HERMOSA', 142, 'portadaAppDelHambre1.jpg'),
(1469, 'SARAYACU', 142, 'portadaAppDelHambre1.jpg'),
(1470, 'VARGAS GUERRA', 142, 'portadaAppDelHambre1.jpg'),
(1471, 'TAMBOPATA', 143, 'portadaAppDelHambre1.jpg'),
(1472, 'INAMBARI', 143, 'portadaAppDelHambre1.jpg'),
(1473, 'LAS PIEDRAS', 143, 'portadaAppDelHambre1.jpg'),
(1474, 'LABERINTO', 143, 'portadaAppDelHambre1.jpg'),
(1475, 'MANU', 144, 'portadaAppDelHambre1.jpg'),
(1476, 'FITZCARRALD', 144, 'portadaAppDelHambre1.jpg'),
(1477, 'MADRE DE DIOS', 144, 'portadaAppDelHambre1.jpg'),
(1478, 'HUEPETUHE', 144, 'portadaAppDelHambre1.jpg'),
(1479, 'I&Ntilde;APARI', 145, 'portadaAppDelHambre1.jpg'),
(1480, 'IBERIA', 145, 'portadaAppDelHambre1.jpg'),
(1481, 'TAHUAMANU', 145, 'portadaAppDelHambre1.jpg'),
(1482, 'MOQUEGUA', 146, 'portadaAppDelHambre1.jpg'),
(1483, 'CARUMAS', 146, 'portadaAppDelHambre1.jpg'),
(1484, 'CUCHUMBAYA', 146, 'portadaAppDelHambre1.jpg'),
(1485, 'SAMEGUA', 146, 'portadaAppDelHambre1.jpg'),
(1486, 'SAN CRISTOBAL', 146, 'portadaAppDelHambre1.jpg'),
(1487, 'TORATA', 146, 'portadaAppDelHambre1.jpg'),
(1488, 'OMATE', 147, 'portadaAppDelHambre1.jpg'),
(1489, 'CHOJATA', 147, 'portadaAppDelHambre1.jpg'),
(1490, 'COALAQUE', 147, 'portadaAppDelHambre1.jpg'),
(1491, 'ICHU&Ntilde;A', 147, 'portadaAppDelHambre1.jpg'),
(1492, 'LA CAPILLA', 147, 'portadaAppDelHambre1.jpg'),
(1493, 'LLOQUE', 147, 'portadaAppDelHambre1.jpg'),
(1494, 'MATALAQUE', 147, 'portadaAppDelHambre1.jpg'),
(1495, 'PUQUINA', 147, 'portadaAppDelHambre1.jpg'),
(1496, 'QUINISTAQUILLAS', 147, 'portadaAppDelHambre1.jpg'),
(1497, 'UBINAS', 147, 'portadaAppDelHambre1.jpg'),
(1498, 'YUNGA', 147, 'portadaAppDelHambre1.jpg'),
(1499, 'ILO', 148, 'portadaAppDelHambre1.jpg'),
(1500, 'EL ALGARROBAL', 148, 'portadaAppDelHambre1.jpg'),
(1501, 'PACOCHA', 148, 'portadaAppDelHambre1.jpg'),
(1502, 'CHAUPIMARCA', 149, 'portadaAppDelHambre1.jpg'),
(1503, 'HUACHON', 149, 'portadaAppDelHambre1.jpg'),
(1504, 'HUARIACA', 149, 'portadaAppDelHambre1.jpg'),
(1505, 'HUAYLLAY', 149, 'portadaAppDelHambre1.jpg'),
(1506, 'NINACACA', 149, 'portadaAppDelHambre1.jpg'),
(1507, 'PALLANCHACRA', 149, 'portadaAppDelHambre1.jpg'),
(1508, 'PAUCARTAMBO', 149, 'portadaAppDelHambre1.jpg'),
(1509, 'SAN FCO.DE ASIS DE YARUSYACAN', 149, 'portadaAppDelHambre1.jpg'),
(1510, 'SIMON BOLIVAR', 149, 'portadaAppDelHambre1.jpg'),
(1511, 'TICLACAYAN', 149, 'portadaAppDelHambre1.jpg'),
(1512, 'TINYAHUARCO', 149, 'portadaAppDelHambre1.jpg'),
(1513, 'VICCO', 149, 'portadaAppDelHambre1.jpg'),
(1514, 'YANACANCHA', 149, 'portadaAppDelHambre1.jpg'),
(1515, 'YANAHUANCA', 150, 'portadaAppDelHambre1.jpg'),
(1516, 'CHACAYAN', 150, 'portadaAppDelHambre1.jpg'),
(1517, 'GOYLLARISQUIZGA', 150, 'portadaAppDelHambre1.jpg'),
(1518, 'PAUCAR', 150, 'portadaAppDelHambre1.jpg'),
(1519, 'SAN PEDRO DE PILLAO', 150, 'portadaAppDelHambre1.jpg'),
(1520, 'SANTA ANA DE TUSI', 150, 'portadaAppDelHambre1.jpg'),
(1521, 'TAPUC', 150, 'portadaAppDelHambre1.jpg'),
(1522, 'VILCABAMBA', 150, 'portadaAppDelHambre1.jpg'),
(1523, 'OXAPAMPA', 151, 'portadaAppDelHambre1.jpg'),
(1524, 'CHONTABAMBA', 151, 'portadaAppDelHambre1.jpg'),
(1525, 'HUANCABAMBA', 151, 'portadaAppDelHambre1.jpg'),
(1526, 'PALCAZU', 151, 'portadaAppDelHambre1.jpg'),
(1527, 'POZUZO', 151, 'portadaAppDelHambre1.jpg'),
(1528, 'PUERTO BERMUDEZ', 151, 'portadaAppDelHambre1.jpg'),
(1529, 'VILLA RICA', 151, 'portadaAppDelHambre1.jpg'),
(1530, 'PIURA', 152, 'portadaAppDelHambre1.jpg'),
(1531, 'CASTILLA', 152, 'portadaAppDelHambre1.jpg'),
(1532, 'CATACAOS', 152, 'portadaAppDelHambre1.jpg'),
(1533, 'CURA MORI', 152, 'portadaAppDelHambre1.jpg'),
(1534, 'EL TALLAN', 152, 'portadaAppDelHambre1.jpg'),
(1535, 'LA ARENA', 152, 'portadaAppDelHambre1.jpg'),
(1536, 'LA UNION', 152, 'portadaAppDelHambre1.jpg'),
(1537, 'LAS LOMAS', 152, 'portadaAppDelHambre1.jpg'),
(1538, 'TAMBO GRANDE', 152, 'portadaAppDelHambre1.jpg'),
(1539, 'AYABACA', 153, 'portadaAppDelHambre1.jpg'),
(1540, 'FRIAS', 153, 'portadaAppDelHambre1.jpg'),
(1541, 'JILILI', 153, 'portadaAppDelHambre1.jpg'),
(1542, 'LAGUNAS', 153, 'portadaAppDelHambre1.jpg'),
(1543, 'MONTERO', 153, 'portadaAppDelHambre1.jpg'),
(1544, 'PACAIPAMPA', 153, 'portadaAppDelHambre1.jpg'),
(1545, 'PAIMAS', 153, 'portadaAppDelHambre1.jpg'),
(1546, 'SAPILLICA', 153, 'portadaAppDelHambre1.jpg'),
(1547, 'SICCHEZ', 153, 'portadaAppDelHambre1.jpg'),
(1548, 'SUYO', 153, 'portadaAppDelHambre1.jpg'),
(1549, 'HUANCABAMBA', 154, 'portadaAppDelHambre1.jpg'),
(1550, 'CANCHAQUE', 154, 'portadaAppDelHambre1.jpg'),
(1551, 'EL CARMEN DE LA FRONTERA', 154, 'portadaAppDelHambre1.jpg'),
(1552, 'HUARMACA', 154, 'portadaAppDelHambre1.jpg'),
(1553, 'LALAQUIZ', 154, 'portadaAppDelHambre1.jpg'),
(1554, 'SAN MIGUEL DE EL FAIQUE', 154, 'portadaAppDelHambre1.jpg'),
(1555, 'SONDOR', 154, 'portadaAppDelHambre1.jpg'),
(1556, 'SONDORILLO', 154, 'portadaAppDelHambre1.jpg'),
(1557, 'CHULUCANAS', 155, 'portadaAppDelHambre1.jpg'),
(1558, 'BUENOS AIRES', 155, 'portadaAppDelHambre1.jpg'),
(1559, 'CHALACO', 155, 'portadaAppDelHambre1.jpg'),
(1560, 'LA MATANZA', 155, 'portadaAppDelHambre1.jpg'),
(1561, 'MORROPON', 155, 'portadaAppDelHambre1.jpg'),
(1562, 'SALITRAL', 155, 'portadaAppDelHambre1.jpg'),
(1563, 'SAN JUAN DE BIGOTE', 155, 'portadaAppDelHambre1.jpg'),
(1564, 'SANTA CATALINA DE MOSSA', 155, 'portadaAppDelHambre1.jpg'),
(1565, 'SANTO DOMINGO', 155, 'portadaAppDelHambre1.jpg'),
(1566, 'YAMANGO', 155, 'portadaAppDelHambre1.jpg'),
(1567, 'PAITA', 156, 'portadaAppDelHambre1.jpg'),
(1568, 'AMOTAPE', 156, 'portadaAppDelHambre1.jpg'),
(1569, 'ARENAL', 156, 'portadaAppDelHambre1.jpg'),
(1570, 'COLAN', 156, 'portadaAppDelHambre1.jpg'),
(1571, 'LA HUACA', 156, 'portadaAppDelHambre1.jpg'),
(1572, 'TAMARINDO', 156, 'portadaAppDelHambre1.jpg'),
(1573, 'VICHAYAL', 156, 'portadaAppDelHambre1.jpg'),
(1574, 'SULLANA', 157, 'portadaAppDelHambre1.jpg'),
(1575, 'BELLAVISTA', 157, 'portadaAppDelHambre1.jpg'),
(1576, 'IGNACIO ESCUDERO', 157, 'portadaAppDelHambre1.jpg'),
(1577, 'LANCONES', 157, 'portadaAppDelHambre1.jpg'),
(1578, 'MARCAVELICA', 157, 'portadaAppDelHambre1.jpg'),
(1579, 'MIGUEL CHECA', 157, 'portadaAppDelHambre1.jpg'),
(1580, 'QUERECOTILLO', 157, 'portadaAppDelHambre1.jpg'),
(1581, 'SALITRAL', 157, 'portadaAppDelHambre1.jpg'),
(1582, 'PARI&Ntilde;AS', 158, 'portadaAppDelHambre1.jpg'),
(1583, 'EL ALTO', 158, 'portadaAppDelHambre1.jpg'),
(1584, 'LA BREA', 158, 'portadaAppDelHambre1.jpg'),
(1585, 'LOBITOS', 158, 'portadaAppDelHambre1.jpg'),
(1586, 'LOS ORGANOS', 158, 'portadaAppDelHambre1.jpg'),
(1587, 'MANCORA', 158, 'portadaAppDelHambre1.jpg'),
(1588, 'SECHURA', 159, 'portadaAppDelHambre1.jpg'),
(1589, 'BELLAVISTA DE LA UNION', 159, 'portadaAppDelHambre1.jpg'),
(1590, 'BERNAL', 159, 'portadaAppDelHambre1.jpg'),
(1591, 'CRISTO NOS VALGA', 159, 'portadaAppDelHambre1.jpg'),
(1592, 'VICE', 159, 'portadaAppDelHambre1.jpg'),
(1593, 'RINCONADA LLICUAR', 159, 'portadaAppDelHambre1.jpg'),
(1594, 'PUNO', 160, 'portadaAppDelHambre1.jpg'),
(1595, 'ACORA', 160, 'portadaAppDelHambre1.jpg'),
(1596, 'AMANTANI', 160, 'portadaAppDelHambre1.jpg'),
(1597, 'ATUNCOLLA', 160, 'portadaAppDelHambre1.jpg'),
(1598, 'CAPACHICA', 160, 'portadaAppDelHambre1.jpg'),
(1599, 'CHUCUITO', 160, 'portadaAppDelHambre1.jpg'),
(1600, 'COATA', 160, 'portadaAppDelHambre1.jpg'),
(1601, 'HUATA', 160, 'portadaAppDelHambre1.jpg'),
(1602, 'MA&Ntilde;AZO', 160, 'portadaAppDelHambre1.jpg'),
(1603, 'PAUCARCOLLA', 160, 'portadaAppDelHambre1.jpg'),
(1604, 'PICHACANI', 160, 'portadaAppDelHambre1.jpg'),
(1605, 'PLATERIA', 160, 'portadaAppDelHambre1.jpg'),
(1606, 'SAN ANTONIO', 160, 'portadaAppDelHambre1.jpg'),
(1607, 'TIQUILLACA', 160, 'portadaAppDelHambre1.jpg'),
(1608, 'VILQUE', 160, 'portadaAppDelHambre1.jpg'),
(1609, 'AZANGARO', 161, 'portadaAppDelHambre1.jpg'),
(1610, 'ACHAYA', 161, 'portadaAppDelHambre1.jpg'),
(1611, 'ARAPA', 161, 'portadaAppDelHambre1.jpg'),
(1612, 'ASILLO', 161, 'portadaAppDelHambre1.jpg'),
(1613, 'CAMINACA', 161, 'portadaAppDelHambre1.jpg'),
(1614, 'CHUPA', 161, 'portadaAppDelHambre1.jpg'),
(1615, 'JOSE DOMINGO CHOQUEHUANCA', 161, 'portadaAppDelHambre1.jpg'),
(1616, 'MU&Ntilde;ANI', 161, 'portadaAppDelHambre1.jpg'),
(1617, 'POTONI', 161, 'portadaAppDelHambre1.jpg'),
(1618, 'SAMAN', 161, 'portadaAppDelHambre1.jpg'),
(1619, 'SAN ANTON', 161, 'portadaAppDelHambre1.jpg'),
(1620, 'SAN JOSE', 161, 'portadaAppDelHambre1.jpg'),
(1621, 'SAN JUAN DE SALINAS', 161, 'portadaAppDelHambre1.jpg'),
(1622, 'SANTIAGO DE PUPUJA', 161, 'portadaAppDelHambre1.jpg'),
(1623, 'TIRAPATA', 161, 'portadaAppDelHambre1.jpg'),
(1624, 'MACUSANI', 162, 'portadaAppDelHambre1.jpg'),
(1625, 'AJOYANI', 162, 'portadaAppDelHambre1.jpg'),
(1626, 'AYAPATA', 162, 'portadaAppDelHambre1.jpg'),
(1627, 'COASA', 162, 'portadaAppDelHambre1.jpg'),
(1628, 'CORANI', 162, 'portadaAppDelHambre1.jpg'),
(1629, 'CRUCERO', 162, 'portadaAppDelHambre1.jpg'),
(1630, 'ITUATA', 162, 'portadaAppDelHambre1.jpg'),
(1631, 'OLLACHEA', 162, 'portadaAppDelHambre1.jpg'),
(1632, 'SAN GABAN', 162, 'portadaAppDelHambre1.jpg'),
(1633, 'USICAYOS', 162, 'portadaAppDelHambre1.jpg'),
(1634, 'JULI', 163, 'portadaAppDelHambre1.jpg'),
(1635, 'DESAGUADERO', 163, 'portadaAppDelHambre1.jpg'),
(1636, 'HUACULLANI', 163, 'portadaAppDelHambre1.jpg'),
(1637, 'KELLUYO', 163, 'portadaAppDelHambre1.jpg'),
(1638, 'PISACOMA', 163, 'portadaAppDelHambre1.jpg'),
(1639, 'POMATA', 163, 'portadaAppDelHambre1.jpg'),
(1640, 'ZEPITA', 163, 'portadaAppDelHambre1.jpg'),
(1641, 'ILAVE', 164, 'portadaAppDelHambre1.jpg'),
(1642, 'CAPAZO', 164, 'portadaAppDelHambre1.jpg'),
(1643, 'PILCUYO', 164, 'portadaAppDelHambre1.jpg'),
(1644, 'SANTA ROSA', 164, 'portadaAppDelHambre1.jpg'),
(1645, 'CONDURIRI', 164, 'portadaAppDelHambre1.jpg'),
(1646, 'HUANCANE', 165, 'portadaAppDelHambre1.jpg'),
(1647, 'COJATA', 165, 'portadaAppDelHambre1.jpg'),
(1648, 'HUATASANI', 165, 'portadaAppDelHambre1.jpg'),
(1649, 'INCHUPALLA', 165, 'portadaAppDelHambre1.jpg'),
(1650, 'PUSI', 165, 'portadaAppDelHambre1.jpg'),
(1651, 'ROSASPATA', 165, 'portadaAppDelHambre1.jpg'),
(1652, 'TARACO', 165, 'portadaAppDelHambre1.jpg'),
(1653, 'VILQUE CHICO', 165, 'portadaAppDelHambre1.jpg'),
(1654, 'LAMPA', 166, 'portadaAppDelHambre1.jpg'),
(1655, 'CABANILLA', 166, 'portadaAppDelHambre1.jpg'),
(1656, 'CALAPUJA', 166, 'portadaAppDelHambre1.jpg'),
(1657, 'NICASIO', 166, 'portadaAppDelHambre1.jpg'),
(1658, 'OCUVIRI', 166, 'portadaAppDelHambre1.jpg'),
(1659, 'PALCA', 166, 'portadaAppDelHambre1.jpg'),
(1660, 'PARATIA', 166, 'portadaAppDelHambre1.jpg'),
(1661, 'PUCARA', 166, 'portadaAppDelHambre1.jpg'),
(1662, 'SANTA LUCIA', 166, 'portadaAppDelHambre1.jpg'),
(1663, 'VILAVILA', 166, 'portadaAppDelHambre1.jpg'),
(1664, 'AYAVIRI', 167, 'portadaAppDelHambre1.jpg'),
(1665, 'ANTAUTA', 167, 'portadaAppDelHambre1.jpg'),
(1666, 'CUPI', 167, 'portadaAppDelHambre1.jpg'),
(1667, 'LLALLI', 167, 'portadaAppDelHambre1.jpg'),
(1668, 'MACARI', 167, 'portadaAppDelHambre1.jpg'),
(1669, 'NU&Ntilde;OA', 167, 'portadaAppDelHambre1.jpg'),
(1670, 'ORURILLO', 167, 'portadaAppDelHambre1.jpg'),
(1671, 'SANTA ROSA', 167, 'portadaAppDelHambre1.jpg'),
(1672, 'UMACHIRI', 167, 'portadaAppDelHambre1.jpg'),
(1673, 'MOHO', 168, 'portadaAppDelHambre1.jpg'),
(1674, 'CONIMA', 168, 'portadaAppDelHambre1.jpg'),
(1675, 'HUAYRAPATA', 168, 'portadaAppDelHambre1.jpg'),
(1676, 'TILALI', 168, 'portadaAppDelHambre1.jpg'),
(1677, 'PUTINA', 169, 'portadaAppDelHambre1.jpg'),
(1678, 'ANANEA', 169, 'portadaAppDelHambre1.jpg'),
(1679, 'PEDRO VILCA APAZA', 169, 'portadaAppDelHambre1.jpg'),
(1680, 'QUILCAPUNCU', 169, 'portadaAppDelHambre1.jpg'),
(1681, 'SINA', 169, 'portadaAppDelHambre1.jpg'),
(1682, 'JULIACA', 170, 'portadaAppDelHambre1.jpg'),
(1683, 'CABANA', 170, 'portadaAppDelHambre1.jpg'),
(1684, 'CABANILLAS', 170, 'portadaAppDelHambre1.jpg'),
(1685, 'CARACOTO', 170, 'portadaAppDelHambre1.jpg'),
(1686, 'SANDIA', 171, 'portadaAppDelHambre1.jpg'),
(1687, 'CUYOCUYO', 171, 'portadaAppDelHambre1.jpg'),
(1688, 'LIMBANI', 171, 'portadaAppDelHambre1.jpg'),
(1689, 'PATAMBUCO', 171, 'portadaAppDelHambre1.jpg'),
(1690, 'PHARA', 171, 'portadaAppDelHambre1.jpg'),
(1691, 'QUIACA', 171, 'portadaAppDelHambre1.jpg'),
(1692, 'SAN JUAN DEL ORO', 171, 'portadaAppDelHambre1.jpg'),
(1693, 'YANAHUAYA', 171, 'portadaAppDelHambre1.jpg'),
(1694, 'ALTO INAMBARI', 171, 'portadaAppDelHambre1.jpg'),
(1695, 'YUNGUYO', 172, 'portadaAppDelHambre1.jpg'),
(1696, 'ANAPIA', 172, 'portadaAppDelHambre1.jpg'),
(1697, 'COPANI', 172, 'portadaAppDelHambre1.jpg'),
(1698, 'CUTURAPI', 172, 'portadaAppDelHambre1.jpg'),
(1699, 'OLLARAYA', 172, 'portadaAppDelHambre1.jpg'),
(1700, 'TINICACHI', 172, 'portadaAppDelHambre1.jpg'),
(1701, 'UNICACHI', 172, 'portadaAppDelHambre1.jpg'),
(1702, 'MOYOBAMBA', 173, 'portadaAppDelHambre1.jpg'),
(1703, 'CALZADA', 173, 'portadaAppDelHambre1.jpg'),
(1704, 'HABANA', 173, 'portadaAppDelHambre1.jpg'),
(1705, 'JEPELACIO', 173, 'portadaAppDelHambre1.jpg'),
(1706, 'SORITOR', 173, 'portadaAppDelHambre1.jpg'),
(1707, 'YANTALO', 173, 'portadaAppDelHambre1.jpg'),
(1708, 'BELLAVISTA', 174, 'portadaAppDelHambre1.jpg'),
(1709, 'ALTO BIAVO', 174, 'portadaAppDelHambre1.jpg'),
(1710, 'BAJO BIAVO', 174, 'portadaAppDelHambre1.jpg'),
(1711, 'HUALLAGA', 174, 'portadaAppDelHambre1.jpg'),
(1712, 'SAN PABLO', 174, 'portadaAppDelHambre1.jpg'),
(1713, 'SAN RAFAEL', 174, 'portadaAppDelHambre1.jpg'),
(1714, 'SAN JOSE DE SISA', 175, 'portadaAppDelHambre1.jpg'),
(1715, 'AGUA BLANCA', 175, 'portadaAppDelHambre1.jpg'),
(1716, 'SAN MARTIN', 175, 'portadaAppDelHambre1.jpg'),
(1717, 'SANTA ROSA', 175, 'portadaAppDelHambre1.jpg'),
(1718, 'SHATOJA', 175, 'portadaAppDelHambre1.jpg'),
(1719, 'SAPOSOA', 176, 'portadaAppDelHambre1.jpg'),
(1720, 'ALTO SAPOSOA', 176, 'portadaAppDelHambre1.jpg'),
(1721, 'EL ESLABON', 176, 'portadaAppDelHambre1.jpg'),
(1722, 'PISCOYACU', 176, 'portadaAppDelHambre1.jpg'),
(1723, 'SACANCHE', 176, 'portadaAppDelHambre1.jpg'),
(1724, 'TINGO DE SAPOSOA', 176, 'portadaAppDelHambre1.jpg'),
(1725, 'LAMAS', 177, 'portadaAppDelHambre1.jpg'),
(1726, 'ALONSO DE ALVARADO', 177, 'portadaAppDelHambre1.jpg'),
(1727, 'BARRANQUITA', 177, 'portadaAppDelHambre1.jpg'),
(1728, 'CAYNARACHI', 177, 'portadaAppDelHambre1.jpg'),
(1729, 'CU&Ntilde;UMBUQUI', 177, 'portadaAppDelHambre1.jpg'),
(1730, 'PINTO RECODO', 177, 'portadaAppDelHambre1.jpg'),
(1731, 'RUMISAPA', 177, 'portadaAppDelHambre1.jpg'),
(1732, 'SAN ROQUE DE CUMBAZA', 177, 'portadaAppDelHambre1.jpg'),
(1733, 'SHANAO', 177, 'portadaAppDelHambre1.jpg'),
(1734, 'TABALOSOS', 177, 'portadaAppDelHambre1.jpg'),
(1735, 'ZAPATERO', 177, 'portadaAppDelHambre1.jpg'),
(1736, 'JUANJUI', 178, 'portadaAppDelHambre1.jpg'),
(1737, 'CAMPANILLA', 178, 'portadaAppDelHambre1.jpg'),
(1738, 'HUICUNGO', 178, 'portadaAppDelHambre1.jpg'),
(1739, 'PACHIZA', 178, 'portadaAppDelHambre1.jpg'),
(1740, 'PAJARILLO', 178, 'portadaAppDelHambre1.jpg'),
(1741, 'PICOTA', 179, 'portadaAppDelHambre1.jpg'),
(1742, 'BUENOS AIRES', 179, 'portadaAppDelHambre1.jpg'),
(1743, 'CASPISAPA', 179, 'portadaAppDelHambre1.jpg'),
(1744, 'PILLUANA', 179, 'portadaAppDelHambre1.jpg'),
(1745, 'PUCACACA', 179, 'portadaAppDelHambre1.jpg'),
(1746, 'SAN CRISTOBAL', 179, 'portadaAppDelHambre1.jpg'),
(1747, 'SAN HILARION', 179, 'portadaAppDelHambre1.jpg'),
(1748, 'SHAMBOYACU', 179, 'portadaAppDelHambre1.jpg'),
(1749, 'TINGO DE PONASA', 179, 'portadaAppDelHambre1.jpg'),
(1750, 'TRES UNIDOS', 179, 'portadaAppDelHambre1.jpg'),
(1751, 'RIOJA', 180, 'portadaAppDelHambre1.jpg'),
(1752, 'AWAJUN', 180, 'portadaAppDelHambre1.jpg'),
(1753, 'ELIAS SOPLIN VARGAS', 180, 'portadaAppDelHambre1.jpg'),
(1754, 'NUEVA CAJAMARCA', 180, 'portadaAppDelHambre1.jpg'),
(1755, 'PARDO MIGUEL', 180, 'portadaAppDelHambre1.jpg'),
(1756, 'POSIC', 180, 'portadaAppDelHambre1.jpg'),
(1757, 'SAN FERNANDO', 180, 'portadaAppDelHambre1.jpg'),
(1758, 'YORONGOS', 180, 'portadaAppDelHambre1.jpg'),
(1759, 'YURACYACU', 180, 'portadaAppDelHambre1.jpg'),
(1760, 'TARAPOTO', 181, 'portadaAppDelHambre1.jpg'),
(1761, 'ALBERTO LEVEAU', 181, 'portadaAppDelHambre1.jpg'),
(1762, 'CACATACHI', 181, 'portadaAppDelHambre1.jpg'),
(1763, 'CHAZUTA', 181, 'portadaAppDelHambre1.jpg'),
(1764, 'CHIPURANA', 181, 'portadaAppDelHambre1.jpg'),
(1765, 'EL PORVENIR', 181, 'portadaAppDelHambre1.jpg'),
(1766, 'HUIMBAYOC', 181, 'portadaAppDelHambre1.jpg'),
(1767, 'JUAN GUERRA', 181, 'portadaAppDelHambre1.jpg'),
(1768, 'LA BANDA DE SHILCAYO', 181, 'portadaAppDelHambre1.jpg'),
(1769, 'MORALES', 181, 'portadaAppDelHambre1.jpg'),
(1770, 'PAPAPLAYA', 181, 'portadaAppDelHambre1.jpg'),
(1771, 'SAN ANTONIO', 181, 'portadaAppDelHambre1.jpg'),
(1772, 'SAUCE', 181, 'portadaAppDelHambre1.jpg'),
(1773, 'SHAPAJA', 181, 'portadaAppDelHambre1.jpg'),
(1774, 'TOCACHE', 182, 'portadaAppDelHambre1.jpg'),
(1775, 'NUEVO PROGRESO', 182, 'portadaAppDelHambre1.jpg'),
(1776, 'POLVORA', 182, 'portadaAppDelHambre1.jpg'),
(1777, 'SHUNTE', 182, 'portadaAppDelHambre1.jpg'),
(1778, 'UCHIZA', 182, 'portadaAppDelHambre1.jpg'),
(1779, 'TACNA', 183, 'portadaAppDelHambre1.jpg'),
(1780, 'ALTO DE LA ALIANZA', 183, 'portadaAppDelHambre1.jpg'),
(1781, 'CALANA', 183, 'portadaAppDelHambre1.jpg'),
(1782, 'CIUDAD NUEVA', 183, 'portadaAppDelHambre1.jpg'),
(1783, 'INCLAN', 183, 'portadaAppDelHambre1.jpg'),
(1784, 'PACHIA', 183, 'portadaAppDelHambre1.jpg'),
(1785, 'PALCA', 183, 'portadaAppDelHambre1.jpg'),
(1786, 'POCOLLAY', 183, 'portadaAppDelHambre1.jpg'),
(1787, 'SAMA', 183, 'portadaAppDelHambre1.jpg'),
(1788, 'CORONEL GREGORIO ALBARRACIN LA', 183, 'portadaAppDelHambre1.jpg'),
(1789, 'CANDARAVE', 184, 'portadaAppDelHambre1.jpg'),
(1790, 'CAIRANI', 184, 'portadaAppDelHambre1.jpg'),
(1791, 'CAMILACA', 184, 'portadaAppDelHambre1.jpg'),
(1792, 'CURIBAYA', 184, 'portadaAppDelHambre1.jpg'),
(1793, 'HUANUARA', 184, 'portadaAppDelHambre1.jpg'),
(1794, 'QUILAHUANI', 184, 'portadaAppDelHambre1.jpg'),
(1795, 'LOCUMBA', 185, 'portadaAppDelHambre1.jpg'),
(1796, 'ILABAYA', 185, 'portadaAppDelHambre1.jpg'),
(1797, 'ITE', 185, 'portadaAppDelHambre1.jpg'),
(1798, 'TARATA', 186, 'portadaAppDelHambre1.jpg'),
(1799, 'CHUCATAMANI', 186, 'portadaAppDelHambre1.jpg'),
(1800, 'ESTIQUE', 186, 'portadaAppDelHambre1.jpg'),
(1801, 'ESTIQUE-PAMPA', 186, 'portadaAppDelHambre1.jpg'),
(1802, 'SITAJARA', 186, 'portadaAppDelHambre1.jpg'),
(1803, 'SUSAPAYA', 186, 'portadaAppDelHambre1.jpg'),
(1804, 'TARUCACHI', 186, 'portadaAppDelHambre1.jpg'),
(1805, 'TICACO', 186, 'portadaAppDelHambre1.jpg'),
(1806, 'TUMBES', 187, 'portadaAppDelHambre1.jpg'),
(1807, 'CORRALES', 187, 'portadaAppDelHambre1.jpg'),
(1808, 'LA CRUZ', 187, 'portadaAppDelHambre1.jpg'),
(1809, 'PAMPAS DE HOSPITAL', 187, 'portadaAppDelHambre1.jpg'),
(1810, 'SAN JACINTO', 187, 'portadaAppDelHambre1.jpg'),
(1811, 'SAN JUAN DE LA VIRGEN', 187, 'portadaAppDelHambre1.jpg'),
(1812, 'ZORRITOS', 188, 'portadaAppDelHambre1.jpg'),
(1813, 'CASITAS', 188, 'portadaAppDelHambre1.jpg'),
(1814, 'ZARUMILLA', 189, 'portadaAppDelHambre1.jpg'),
(1815, 'AGUAS VERDES', 189, 'portadaAppDelHambre1.jpg'),
(1816, 'MATAPALO', 189, 'portadaAppDelHambre1.jpg'),
(1817, 'PAPAYAL', 189, 'portadaAppDelHambre1.jpg'),
(1818, 'CALLERIA', 190, 'portadaAppDelHambre1.jpg'),
(1819, 'CAMPOVERDE', 190, 'portadaAppDelHambre1.jpg'),
(1820, 'IPARIA', 190, 'portadaAppDelHambre1.jpg'),
(1821, 'MASISEA', 190, 'portadaAppDelHambre1.jpg'),
(1822, 'YARINACOCHA', 190, 'portadaAppDelHambre1.jpg'),
(1823, 'NUEVA REQUENA', 190, 'portadaAppDelHambre1.jpg'),
(1824, 'RAYMONDI', 191, 'portadaAppDelHambre1.jpg'),
(1825, 'SEPAHUA', 191, 'portadaAppDelHambre1.jpg'),
(1826, 'TAHUANIA', 191, 'portadaAppDelHambre1.jpg'),
(1827, 'YURUA', 191, 'portadaAppDelHambre1.jpg'),
(1828, 'PADRE ABAD', 192, 'portadaAppDelHambre1.jpg'),
(1829, 'IRAZOLA', 192, 'portadaAppDelHambre1.jpg'),
(1830, 'CURIMANA', 192, 'portadaAppDelHambre1.jpg'),
(1831, 'PURUS', 193, 'portadaAppDelHambre1.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubprovincia`
--

CREATE TABLE `ubprovincia` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `id_depa` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ubprovincia`
--

INSERT INTO `ubprovincia` (`id`, `nombre`, `id_depa`) VALUES
(1, 'CHACHAPOYAS ', 1),
(2, 'BAGUA', 1),
(3, 'BONGARA', 1),
(4, 'CONDORCANQUI', 1),
(5, 'LUYA', 1),
(6, 'RODRIGUEZ DE MENDOZA', 1),
(7, 'UTCUBAMBA', 1),
(8, 'HUARAZ', 2),
(9, 'AIJA', 2),
(10, 'ANTONIO RAYMONDI', 2),
(11, 'ASUNCION', 2),
(12, 'BOLOGNESI', 2),
(13, 'CARHUAZ', 2),
(14, 'CARLOS FERMIN FITZCARRALD', 2),
(15, 'CASMA', 2),
(16, 'CORONGO', 2),
(17, 'HUARI', 2),
(18, 'HUARMEY', 2),
(19, 'HUAYLAS', 2),
(20, 'MARISCAL LUZURIAGA', 2),
(21, 'OCROS', 2),
(22, 'PALLASCA', 2),
(23, 'POMABAMBA', 2),
(24, 'RECUAY', 2),
(25, 'SANTA', 2),
(26, 'SIHUAS', 2),
(27, 'YUNGAY', 2),
(28, 'ABANCAY', 3),
(29, 'ANDAHUAYLAS', 3),
(30, 'ANTABAMBA', 3),
(31, 'AYMARAES', 3),
(32, 'COTABAMBAS', 3),
(33, 'CHINCHEROS', 3),
(34, 'GRAU', 3),
(35, 'AREQUIPA', 4),
(36, 'CAMANA', 4),
(37, 'CARAVELI', 4),
(38, 'CASTILLA', 4),
(39, 'CAYLLOMA', 4),
(40, 'CONDESUYOS', 4),
(41, 'ISLAY', 4),
(42, 'LA UNION', 4),
(43, 'HUAMANGA', 5),
(44, 'CANGALLO', 5),
(45, 'HUANCA SANCOS', 5),
(46, 'HUANTA', 5),
(47, 'LA MAR', 5),
(48, 'LUCANAS', 5),
(49, 'PARINACOCHAS', 5),
(50, 'PAUCAR DEL SARA SARA', 5),
(51, 'SUCRE', 5),
(52, 'VICTOR FAJARDO', 5),
(53, 'VILCAS HUAMAN', 5),
(54, 'CAJAMARCA', 6),
(55, 'CAJABAMBA', 6),
(56, 'CELENDIN', 6),
(57, 'CHOTA ', 6),
(58, 'CONTUMAZA', 6),
(59, 'CUTERVO', 6),
(60, 'HUALGAYOC', 6),
(61, 'JAEN', 6),
(62, 'SAN IGNACIO', 6),
(63, 'SAN MARCOS', 6),
(64, 'SAN PABLO', 6),
(65, 'SANTA CRUZ', 6),
(66, 'CALLAO', 7),
(67, 'CUSCO', 8),
(68, 'ACOMAYO', 8),
(69, 'ANTA', 8),
(70, 'CALCA', 8),
(71, 'CANAS', 8),
(72, 'CANCHIS', 8),
(73, 'CHUMBIVILCAS', 8),
(74, 'ESPINAR', 8),
(75, 'LA CONVENCION', 8),
(76, 'PARURO', 8),
(77, 'PAUCARTAMBO', 8),
(78, 'QUISPICANCHI', 8),
(79, 'URUBAMBA', 8),
(80, 'HUANCAVELICA', 9),
(81, 'ACOBAMBA', 9),
(82, 'ANGARAES', 9),
(83, 'CASTROVIRREYNA', 9),
(84, 'CHURCAMPA', 9),
(85, 'HUAYTARA', 9),
(86, 'TAYACAJA', 9),
(87, 'HUANUCO', 10),
(88, 'AMBO', 10),
(89, 'DOS DE MAYO', 10),
(90, 'HUACAYBAMBA', 10),
(91, 'HUAMALIES', 10),
(92, 'LEONCIO PRADO', 10),
(93, 'MARA&Ntilde;ON', 10),
(94, 'PACHITEA', 10),
(95, 'PUERTO INCA', 10),
(96, 'LAURICOCHA', 10),
(97, 'YAROWILCA', 10),
(98, 'ICA', 11),
(99, 'CHINCHA', 11),
(100, 'NAZCA', 11),
(101, 'PALPA', 11),
(102, 'PISCO', 11),
(103, 'HUANCAYO', 12),
(104, 'CONCEPCION', 12),
(105, 'CHANCHAMAYO', 12),
(106, 'JAUJA', 12),
(107, 'JUNIN', 12),
(108, 'SATIPO', 12),
(109, 'TARMA', 12),
(110, 'YAULI', 12),
(111, 'CHUPACA', 12),
(112, 'TRUJILLO', 13),
(113, 'ASCOPE', 13),
(114, 'BOLIVAR', 13),
(115, 'CHEPEN', 13),
(116, 'JULCAN', 13),
(117, 'OTUZCO', 13),
(118, 'PACASMAYO', 13),
(119, 'PATAZ', 13),
(120, 'SANCHEZ CARRION', 13),
(121, 'SANTIAGO DE CHUCO', 13),
(122, 'GRAN CHIMU', 13),
(123, 'VIRU', 13),
(124, 'CHICLAYO', 14),
(125, 'FERREÑAFE', 14),
(126, 'LAMBAYEQUE', 14),
(127, 'LIMA', 15),
(128, 'BARRANCA', 15),
(129, 'CAJATAMBO', 15),
(130, 'CANTA', 15),
(131, 'CA&Ntilde;ETE', 15),
(132, 'HUARAL', 15),
(133, 'HUAROCHIRI', 15),
(134, 'HUAURA', 15),
(135, 'OYON', 15),
(136, 'YAUYOS', 15),
(137, 'MAYNAS', 16),
(138, 'ALTO AMAZONAS', 16),
(139, 'LORETO', 16),
(140, 'MARISCAL RAMON CASTILLA', 16),
(141, 'REQUENA', 16),
(142, 'UCAYALI', 16),
(143, 'TAMBOPATA', 17),
(144, 'MANU', 17),
(145, 'TAHUAMANU', 17),
(146, 'MARISCAL NIETO', 18),
(147, 'GENERAL SANCHEZ CERRO', 18),
(148, 'ILO', 18),
(149, 'PASCO', 19),
(150, 'DANIEL ALCIDES CARRION', 19),
(151, 'OXAPAMPA', 19),
(152, 'PIURA', 20),
(153, 'AYABACA', 20),
(154, 'HUANCABAMBA', 20),
(155, 'MORROPON', 20),
(156, 'PAITA', 20),
(157, 'SULLANA', 20),
(158, 'TALARA', 20),
(159, 'SECHURA', 20),
(160, 'PUNO', 21),
(161, 'AZANGARO', 21),
(162, 'CARABAYA', 21),
(163, 'CHUCUITO', 21),
(164, 'EL COLLAO', 21),
(165, 'HUANCANE', 21),
(166, 'LAMPA', 21),
(167, 'MELGAR', 21),
(168, 'MOHO', 21),
(169, 'SAN ANTONIO DE PUTINA', 21),
(170, 'SAN ROMAN', 21),
(171, 'SANDIA', 21),
(172, 'YUNGUYO', 21),
(173, 'MOYOBAMBA', 22),
(174, 'BELLAVISTA', 22),
(175, 'EL DORADO', 22),
(176, 'HUALLAGA', 22),
(177, 'LAMAS', 22),
(178, 'MARISCAL CACERES', 22),
(179, 'PICOTA', 22),
(180, 'RIOJA', 22),
(181, 'SAN MARTIN', 22),
(182, 'TOCACHE', 22),
(183, 'TACNA', 23),
(184, 'CANDARAVE', 23),
(185, 'JORGE BASADRE', 23),
(186, 'TARATA', 23),
(187, 'TUMBES', 24),
(188, 'CONTRALMIRANTE VILLAR', 24),
(189, 'ZARUMILLA', 24),
(190, 'CORONEL PORTILLO', 25),
(191, 'ATALAYA', 25),
(192, 'PADRE ABAD', 25),
(193, 'PURUS', 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad_medida`
--

CREATE TABLE `unidad_medida` (
  `id` binary(16) NOT NULL,
  `medida` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `unidad_medida`
--

INSERT INTO `unidad_medida` (`id`, `medida`) VALUES
(0x00c52417973d4d9fb5bca4197d07bb13, ' 700 ML'),
(0x1461f846ef264ead8033d6f6cd64661e, ' 700 ML'),
(0x17c68026bbc049518c44dbdc6e6b6ba2, ' 700 ML'),
(0xb0cb729cb3c94f7fa0ac480cfa212bd2, ' 700 ML'),
(0xc80b9acd753644fd9bfe9d7c22a4c913, ' 700 ML'),
(0xc901631a819c4618a3c88c58512b549a, ' 700 ML'),
(0xd47917da94874752a42d00aae4e96f37, ' 700 ML'),
(0xdf8ffb1e2fb24fe48cc102746b15e2a6, ' 700 ML'),
(0xf46416abbb904645bac35b920c35e3ff, ' 700 ML');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` binary(16) NOT NULL,
  `activo` bit(1) NOT NULL,
  `otp` varchar(255) DEFAULT NULL,
  `otp_generated_time` datetime(6) DEFAULT NULL,
  `password` varchar(300) NOT NULL,
  `roles` enum('ADMIN','USER') DEFAULT NULL,
  `username` varchar(300) NOT NULL,
  `role_id` binary(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `activo`, `otp`, `otp_generated_time`, `password`, `roles`, `username`, `role_id`) VALUES
(0x8dd99a51d9aa4b2e9545b0ec7882fd03, b'1', NULL, NULL, '$2a$10$2/CWDRtJeJpj921OzGfEa.PzozLj/I2P306xW4NbRk2m/TxyE6LQ2', 'USER', 'dino@gmail.com', 0x4030ab2530fa42d0942eec187a2d00f6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpmtr515lcs96s5mnrhbakm097` (`id_user`),
  ADD KEY `FKsu3hq6uabc61g8219w4qumatu` (`ubdistrito_id`);

--
-- Indices de la tabla `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpjbmgyt47wuf8edu6bci8g9ww` (`idtype_product`);

--
-- Indices de la tabla `categori_store`
--
ALTER TABLE `categori_store`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgvidycsbg2jguxn9lul13vcmn` (`idcategory`),
  ADD KEY `FKb8svchgcoyl2q0o5k4r8c3d9k` (`id_store`);

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_46ccwnsi9409t36lurvtyljak` (`name`);

--
-- Indices de la tabla `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_r52xvm9qscdkdpif9rqb5yvfw` (`branch`),
  ADD UNIQUE KEY `UK_2mxn4rd72i7pcx7qggybri191` (`business_name`),
  ADD UNIQUE KEY `UK_4wj9cgtgxme9ui0wlifm1ngeb` (`ruc`),
  ADD KEY `FK3r2clubs1xgbbuks5tranug2a` (`id_user`);

--
-- Indices de la tabla `container_type`
--
ALTER TABLE `container_type`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKclh1cej7ijsih8tdwpeufy8ys` (`idtype_product`);

--
-- Indices de la tabla `descripcion_agua`
--
ALTER TABLE `descripcion_agua`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdghuoikdw5wfy15mw8130vu8e` (`idproducto`),
  ADD KEY `FKscs7ruvt3wrps5qsxtjsbv1ah` (`idcontainer_type`),
  ADD KEY `FKojfeq4xvk0ur9yo81up36tgqt` (`idmedidas_producto`),
  ADD KEY `FKec09vg0x7s4mw295odrf8m8h7` (`idunidad_medida`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `images_product`
--
ALTER TABLE `images_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4m57vv0lqkxvbo3ngo6n9v5y9` (`id_descripcion_agua`);

--
-- Indices de la tabla `medidas_producto`
--
ALTER TABLE `medidas_producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdl4wj749nmxc4cyvm0iy5c04f` (`id_descripcion_agua`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKis2nqgwh5iy1rgppee42h451k` (`id_person`);

--
-- Indices de la tabla `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKas2niaqx78in8m06j3s6djmou` (`id_user`);

--
-- Indices de la tabla `phone`
--
ALTER TABLE `phone`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbtclsgmcq82gwkcwm7ms1ginv` (`id_user`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKti0lsgnnoerhclcve20iho3un` (`brand`),
  ADD KEY `FKc9wh4y4xpsdmpkl4qx9lw6vy1` (`idtype_product`),
  ADD KEY `FK9e9jnrg713b1vstyefbnp59mv` (`id_store`);

--
-- Indices de la tabla `responsible`
--
ALTER TABLE `responsible`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKc7ntncq94bus03dlujhsma2pu` (`id_company`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`);

--
-- Indices de la tabla `role_permission`
--
ALTER TABLE `role_permission`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKosbvhwswv75s5x8ar1ru6l9f1` (`id_rol`),
  ADD KEY `FKf8yllw1ecvwqy3ehyxawqa1qp` (`permission_id`);

--
-- Indices de la tabla `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKthpega9nhe2l8kqgflx76csvh` (`id_company`),
  ADD KEY `FKcj1aakxss911d22d73aqed5n5` (`id_distrito`);

--
-- Indices de la tabla `subcategory`
--
ALTER TABLE `subcategory`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoj0c50bm9syaaq249tllqehtg` (`idcategory`);

--
-- Indices de la tabla `sub_categori_store`
--
ALTER TABLE `sub_categori_store`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa1narlfk0njd6i45xjbpkxvqe` (`id_categori_store`),
  ADD KEY `FKof6nd9viipl2gnhjeui82596e` (`id_store`),
  ADD KEY `FKn0m06k496bm9nqs0qks0jxpxe` (`idsubcategory`);

--
-- Indices de la tabla `timetable`
--
ALTER TABLE `timetable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3eiaswe9xophetlk1uypr3t28` (`store_id`);

--
-- Indices de la tabla `type_product`
--
ALTER TABLE `type_product`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ubdepartamento`
--
ALTER TABLE `ubdepartamento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl2dmguoojhajaahykittq7iqc` (`pais_id`);

--
-- Indices de la tabla `ubdistrito`
--
ALTER TABLE `ubdistrito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbvlreosas0eeysm3x3kmjs3tp` (`id_prov`);

--
-- Indices de la tabla `ubprovincia`
--
ALTER TABLE `ubprovincia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9ym36h33ehof2fn9nc4vserop` (`id_depa`);

--
-- Indices de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`),
  ADD KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `ubdepartamento`
--
ALTER TABLE `ubdepartamento`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `ubdistrito`
--
ALTER TABLE `ubdistrito`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1832;

--
-- AUTO_INCREMENT de la tabla `ubprovincia`
--
ALTER TABLE `ubprovincia`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=194;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `FKpmtr515lcs96s5mnrhbakm097` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKsu3hq6uabc61g8219w4qumatu` FOREIGN KEY (`ubdistrito_id`) REFERENCES `ubdistrito` (`id`);

--
-- Filtros para la tabla `brand`
--
ALTER TABLE `brand`
  ADD CONSTRAINT `FKpjbmgyt47wuf8edu6bci8g9ww` FOREIGN KEY (`idtype_product`) REFERENCES `type_product` (`id`);

--
-- Filtros para la tabla `categori_store`
--
ALTER TABLE `categori_store`
  ADD CONSTRAINT `FKb8svchgcoyl2q0o5k4r8c3d9k` FOREIGN KEY (`id_store`) REFERENCES `store` (`id`),
  ADD CONSTRAINT `FKgvidycsbg2jguxn9lul13vcmn` FOREIGN KEY (`idcategory`) REFERENCES `category` (`id`);

--
-- Filtros para la tabla `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `FK3r2clubs1xgbbuks5tranug2a` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `container_type`
--
ALTER TABLE `container_type`
  ADD CONSTRAINT `FKclh1cej7ijsih8tdwpeufy8ys` FOREIGN KEY (`idtype_product`) REFERENCES `type_product` (`id`);

--
-- Filtros para la tabla `descripcion_agua`
--
ALTER TABLE `descripcion_agua`
  ADD CONSTRAINT `FKdghuoikdw5wfy15mw8130vu8e` FOREIGN KEY (`idproducto`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKec09vg0x7s4mw295odrf8m8h7` FOREIGN KEY (`idunidad_medida`) REFERENCES `unidad_medida` (`id`),
  ADD CONSTRAINT `FKojfeq4xvk0ur9yo81up36tgqt` FOREIGN KEY (`idmedidas_producto`) REFERENCES `medidas_producto` (`id`),
  ADD CONSTRAINT `FKscs7ruvt3wrps5qsxtjsbv1ah` FOREIGN KEY (`idcontainer_type`) REFERENCES `container_type` (`id`);

--
-- Filtros para la tabla `images_product`
--
ALTER TABLE `images_product`
  ADD CONSTRAINT `FK4m57vv0lqkxvbo3ngo6n9v5y9` FOREIGN KEY (`id_descripcion_agua`) REFERENCES `descripcion_agua` (`id`);

--
-- Filtros para la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD CONSTRAINT `FKdl4wj749nmxc4cyvm0iy5c04f` FOREIGN KEY (`id_descripcion_agua`) REFERENCES `descripcion_agua` (`id`);

--
-- Filtros para la tabla `permission`
--
ALTER TABLE `permission`
  ADD CONSTRAINT `FKis2nqgwh5iy1rgppee42h451k` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`);

--
-- Filtros para la tabla `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `FKas2niaqx78in8m06j3s6djmou` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `phone`
--
ALTER TABLE `phone`
  ADD CONSTRAINT `FKbtclsgmcq82gwkcwm7ms1ginv` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK9e9jnrg713b1vstyefbnp59mv` FOREIGN KEY (`id_store`) REFERENCES `store` (`id`),
  ADD CONSTRAINT `FKc9wh4y4xpsdmpkl4qx9lw6vy1` FOREIGN KEY (`idtype_product`) REFERENCES `type_product` (`id`),
  ADD CONSTRAINT `FKti0lsgnnoerhclcve20iho3un` FOREIGN KEY (`brand`) REFERENCES `brand` (`id`);

--
-- Filtros para la tabla `responsible`
--
ALTER TABLE `responsible`
  ADD CONSTRAINT `FKc7ntncq94bus03dlujhsma2pu` FOREIGN KEY (`id_company`) REFERENCES `company` (`id`);

--
-- Filtros para la tabla `role_permission`
--
ALTER TABLE `role_permission`
  ADD CONSTRAINT `FKf8yllw1ecvwqy3ehyxawqa1qp` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`),
  ADD CONSTRAINT `FKosbvhwswv75s5x8ar1ru6l9f1` FOREIGN KEY (`id_rol`) REFERENCES `role` (`id`);

--
-- Filtros para la tabla `store`
--
ALTER TABLE `store`
  ADD CONSTRAINT `FKcj1aakxss911d22d73aqed5n5` FOREIGN KEY (`id_distrito`) REFERENCES `ubdistrito` (`id`),
  ADD CONSTRAINT `FKthpega9nhe2l8kqgflx76csvh` FOREIGN KEY (`id_company`) REFERENCES `company` (`id`);

--
-- Filtros para la tabla `subcategory`
--
ALTER TABLE `subcategory`
  ADD CONSTRAINT `FKoj0c50bm9syaaq249tllqehtg` FOREIGN KEY (`idcategory`) REFERENCES `category` (`id`);

--
-- Filtros para la tabla `sub_categori_store`
--
ALTER TABLE `sub_categori_store`
  ADD CONSTRAINT `FKa1narlfk0njd6i45xjbpkxvqe` FOREIGN KEY (`id_categori_store`) REFERENCES `categori_store` (`id`),
  ADD CONSTRAINT `FKn0m06k496bm9nqs0qks0jxpxe` FOREIGN KEY (`idsubcategory`) REFERENCES `subcategory` (`id`),
  ADD CONSTRAINT `FKof6nd9viipl2gnhjeui82596e` FOREIGN KEY (`id_store`) REFERENCES `store` (`id`);

--
-- Filtros para la tabla `timetable`
--
ALTER TABLE `timetable`
  ADD CONSTRAINT `FK3eiaswe9xophetlk1uypr3t28` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`);

--
-- Filtros para la tabla `ubdepartamento`
--
ALTER TABLE `ubdepartamento`
  ADD CONSTRAINT `FKl2dmguoojhajaahykittq7iqc` FOREIGN KEY (`pais_id`) REFERENCES `pais` (`id`);

--
-- Filtros para la tabla `ubdistrito`
--
ALTER TABLE `ubdistrito`
  ADD CONSTRAINT `FKbvlreosas0eeysm3x3kmjs3tp` FOREIGN KEY (`id_prov`) REFERENCES `ubprovincia` (`id`);

--
-- Filtros para la tabla `ubprovincia`
--
ALTER TABLE `ubprovincia`
  ADD CONSTRAINT `FK9ym36h33ehof2fn9nc4vserop` FOREIGN KEY (`id_depa`) REFERENCES `ubdepartamento` (`id`);

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
