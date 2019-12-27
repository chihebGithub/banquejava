-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  ven. 27 déc. 2019 à 23:40
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `banque`
--

-- --------------------------------------------------------

--
-- Structure de la table `Client`
--

CREATE TABLE `Client` (
  `codClt` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `Sex` varchar(20) DEFAULT NULL,
  `Country` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Client`
--

INSERT INTO `Client` (`codClt`, `name`, `firstName`, `password`, `email`, `Sex`, `Country`) VALUES
(14, 'null', '14141', '\r\n', 'aaaaaaa@aaaaaa', 'null', 'Tunisia'),
(45, 'null', 'aaaaaa', '\r\naaaaaaa', 'aaaaaaaaa@aaaaaa', 'male', 'Tunisia'),
(151, 'null', 'test', '\r\naaaaaaa', 'chiheb.rabeh@gmail.com', 'male', 'Tunisia'),
(525, 'null', 'aaaaaaa', '\r\naaaaaa', 'aaaaaaa@aaaaaa', 'male', 'Tunisia'),
(748, 'aaaaaaaa', 'aaaaaaaa', 'aaaaaaaa', 'aaaaaaaa@aaaaaaa', 'male', 'Tunisia'),
(787, 'aaaaaaa', 'aaaaaaaaa', '\r\naaaaaaaa', 'aaaaaaaaaaa@aaaaa', 'male', 'Tunisia'),
(1212, 'null', 'aaaaa', '\r\naaaaaaa', 'aaaaaaaa@aaa', 'male', 'Franse'),
(1414, 'null', 'aaaaa', '\r\naaaaaa', 'aaaaaaa@aaaaa', 'male', 'Tunisia'),
(1417, 'amina', 'aaaaaaaaa', 'null', 'aaaaaaa@aaaaaaaa', 'male', 'Tunisia'),
(4141, 'aaaaaaaa', 'aaaaaa', 'null', 'aaaaaa@aaaa', 'male', 'Tunisia'),
(12456, 'null', 'aaaaaaaaa', '\r\naaaaaaaa', 'aaaaaaaa@aaaaaa', 'male', 'Tunisia'),
(141414, 'null', 'aaaaaa', '\r\nzzzzzzzzzz', 'aaaaaa@aaaaaaaa', 'male', 'Tunisia'),
(414141, 'null', 'aaaaaaaaa', '\r\naaaaaa', 'aaaaaaaa@aaaa', 'male', 'Tunisia'),
(1414114, 'aaaaaa', 'aaaaaaaaaa', 'aaaaa', 'aaaaaaaa@aaaaaaaa', 'male', 'Tunisia'),
(7474789, 'aaaaaa', 'aaaaaa', 'aaaaa\r\n', 'aaaaa@aaa', 'male', 'Franse'),
(9832570, 'chiheb', 'rabeh', 'tunis', 'consultant', '', '0'),
(9832571, 'chiheb', 'rabeh', 'chihebrabeh', 'chiheb.rabeh@hotmail.fr', 'male', 'Tunisia'),
(9832574, 'rabeh', 'chiheb', 'chihebrabeh', 'chiheb.rabeh1920@gmail.com', 'male', 'Tunisia'),
(9832576, 'chiheb', 'rabeh', 'consullat', 'consultant', '', '0'),
(9832577, 'test', 'test', 'aaaaaa', 'aaaaaa@aaaaaa', 'male', 'France'),
(12345678, 'chiheb', 'rabeh', 'aaaaaaaaaa', 'aaaaaa@aaaaaa', 'male', 'Tunisia'),
(14141414, 'null', 'aaaaaaaa', 'null', 'aaaaaaaaa@aaaaaaaa', 'on', 'null'),
(98325778, 'null', 'test', 'test', 'null', '', '0'),
(151555555, 'null', 'aaaaaaaa', 'null', 'aaaaaaaa@aaaaaa', 'on', 'null');

-- --------------------------------------------------------

--
-- Structure de la table `comptes`
--

CREATE TABLE `comptes` (
  `numCpt` int(11) NOT NULL,
  `codNatCpt` int(11) NOT NULL,
  `solde` double NOT NULL,
  `codClt` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `comptes`
--

INSERT INTO `comptes` (`numCpt`, `codNatCpt`, `solde`, `codClt`) VALUES
(1, 100, 17400.01000000001, 9832570),
(2, 0, 0, 0),
(3, 0, 0, 0),
(4, 0, 0, 0),
(5, 100, 0, 9832570),
(6, 0, 0, 0),
(7, 0, 0, 0),
(8, 0, 0, 0),
(9, 100, 0, 9832570),
(10, 0, 0, 0),
(11, 0, 0, 0),
(12, 0, 0, 0),
(13, 100, 0, 9832570),
(14, 0, 0, 0),
(15, 0, 0, 0),
(16, 0, 0, 0),
(17, 100, 0, 9832570),
(18, 0, 0, 0),
(19, 0, 0, 0),
(20, 0, 0, 0),
(21, 100, 0, 9832570),
(22, 0, 0, 0),
(23, 0, 0, 0),
(24, 0, 0, 0),
(25, 100, 0, 9832570),
(26, 0, 0, 0),
(27, 0, 0, 0),
(28, 0, 0, 0),
(29, 100, 0, 9832570),
(30, 0, 0, 0),
(31, 0, 0, 0),
(32, 0, 0, 0),
(33, 100, 0, 9832570),
(34, 0, 0, 0),
(35, 0, 0, 0),
(36, 0, 0, 0),
(37, 100, 0, 9832570),
(38, 0, 0, 0),
(39, 0, 0, 0),
(40, 0, 0, 0),
(41, 100, 0, 9832570),
(42, 0, 0, 0),
(43, 0, 0, 0),
(44, 0, 0, 0),
(45, 100, 0, 9832570),
(46, 0, 0, 0),
(47, 0, 0, 0),
(48, 0, 0, 0),
(49, 100, 0, 9832570),
(50, 0, 0, 0),
(51, 0, 0, 0),
(52, 0, 0, 0),
(53, 100, 0, 9832570),
(54, 0, 0, 0),
(55, 0, 0, 0),
(56, 0, 0, 0),
(57, 100, 0, 9832570),
(58, 0, 0, 0),
(59, 0, 0, 0),
(60, 0, 0, 0),
(61, 100, 0, 9832570),
(62, 0, 0, 0),
(63, 0, 0, 0),
(64, 0, 0, 0),
(65, 100, 0, 9832570),
(66, 0, 0, 0),
(67, 0, 0, 0),
(68, 0, 0, 0),
(69, 100, 0, 9832570),
(70, 0, 0, 0),
(71, 0, 0, 0),
(72, 0, 0, 0),
(73, 100, 0, 9832570),
(74, 0, 0, 0),
(75, 0, 0, 0),
(76, 0, 0, 0),
(77, 100, 0, 9832570),
(78, 0, 0, 0),
(79, 0, 0, 0),
(80, 0, 0, 0),
(81, 100, 0, 9832570),
(82, 0, 0, 0),
(83, 0, 0, 0),
(84, 0, 0, 0),
(85, 100, 0, 9832570),
(86, 0, 0, 0),
(87, 0, 0, 0),
(88, 0, 0, 0),
(89, 100, 0, 9832570),
(90, 0, 0, 0),
(91, 0, 0, 0),
(92, 0, 0, 0),
(93, 100, 0, 9832570),
(94, 0, 0, 0),
(95, 0, 0, 0),
(96, 0, 0, 0),
(97, 100, 0, 9832570),
(98, 0, 0, 0),
(99, 0, 0, 0),
(100, 0, 0, 0),
(101, 100, 0, 9832570),
(102, 0, 0, 0),
(103, 0, 0, 0),
(104, 0, 0, 0),
(105, 100, 0, 9832570),
(106, 0, 0, 0),
(107, 0, 0, 0),
(108, 0, 0, 0),
(109, 100, 0, 9832570),
(110, 0, 0, 0),
(111, 0, 0, 0),
(112, 0, 0, 0),
(113, 100, 0, 9832570),
(114, 0, 0, 0),
(115, 0, 0, 0),
(116, 0, 0, 0),
(117, 100, 0, 9832570),
(118, 0, 0, 0),
(119, 0, 0, 0),
(120, 0, 0, 0),
(121, 100, 0, 9832570),
(122, 0, 0, 0),
(123, 0, 0, 0),
(124, 0, 0, 0),
(125, 100, 0, 9832570),
(126, 0, 0, 0),
(127, 0, 0, 0),
(128, 0, 0, 0),
(129, 100, 100, 9832574),
(130, 100, 0, 9832570),
(131, 110, 0, 9832570),
(132, 110, 0, 9832570),
(133, 100, 0, 9832570),
(134, 100, 0, 9832570),
(135, 110, 0, 7474789),
(136, 110, 0, 12345678),
(137, 100, 0, 9832570),
(138, 100, 0, 9832570),
(139, 100, 0, 14145115),
(140, 100, 0, 9832570),
(141, 100, 0, 9832570),
(142, 100, 0, 9832570),
(143, 100, 0, 9832570),
(144, 110, 0, 9832570),
(145, 110, 0, 9832570),
(146, 110, 0, 9832570),
(147, 110, 0, 9832570),
(148, 110, 0, 9832570),
(149, 100, 0, 9832570),
(150, 110, 0, 9832570),
(151, 110, 0, 9832570);

-- --------------------------------------------------------

--
-- Structure de la table `Nature`
--

CREATE TABLE `Nature` (
  `codnat` int(11) NOT NULL,
  `libnat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Operation`
--

CREATE TABLE `Operation` (
  `numMouvement` int(11) NOT NULL,
  `dateMouvement` date NOT NULL,
  `numCompte` int(11) NOT NULL,
  `montant` double NOT NULL,
  `soldeAvant` double NOT NULL,
  `soldeApres` double NOT NULL,
  `CompteY` int(11) NOT NULL,
  `typeOperation` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Operation`
--

INSERT INTO `Operation` (`numMouvement`, `dateMouvement`, `numCompte`, `montant`, `soldeAvant`, `soldeApres`, `CompteY`, `typeOperation`) VALUES
(1, '1970-01-01', 1, 0, 0, 0, 0, 'null'),
(2, '1970-01-01', 1, 0, 0, 0, 0, 'null'),
(3, '1970-01-01', 1, 0, 0, 0, 0, 'null'),
(4, '1970-01-01', 1, 0, 0, 0, 0, 'null'),
(5, '1970-01-01', 1, 0, 0, 0, 0, 'null'),
(6, '2019-12-25', 1, 0, 0, 0, 0, 'null'),
(7, '2019-12-25', 1, 0, 0, 0, 0, 'null'),
(8, '2019-12-25', 1, 0, 0, 0, 0, 'null'),
(9, '2019-12-25', 1, 0, 0, 0, 0, 'null'),
(10, '2019-12-25', 1, 0, 0, 0, 0, 'null'),
(11, '2019-12-25', 1, 0, 0, 0, 0, 'null'),
(12, '2019-12-25', 1, 0, 0, 0, 0, 'null'),
(13, '2019-12-25', 1, 0, 0, 0, 0, 'null'),
(14, '2019-12-25', 1, 0, 0, 0, 0, 'null'),
(15, '2019-12-25', 1, 0, 0, 0, 0, 'null'),
(16, '2019-12-25', 1, 0, 0, 0, 0, 'null'),
(17, '2019-12-25', 1, 0, 0, 0, 0, 'null'),
(18, '2019-12-25', 1, 0, 0, 0, 0, 'VRS'),
(19, '2019-12-25', 1, 0, 0, 0, 0, 'VRS'),
(20, '2019-12-25', 1, 1500, 0, 0, 0, 'VRS'),
(21, '2019-12-25', 1, 1000, 0, 0, 0, 'VRS'),
(22, '2019-12-25', 1, 1000, 0, 0, 0, 'VRS'),
(23, '2019-12-25', 1, 1000, 0, 0, 0, 'VRS'),
(24, '2019-12-25', 1, 1000, 8500, 9500, 0, 'VRS'),
(25, '2019-12-26', 1, 100.01, 9500, 9600.01, 0, 'VRS'),
(26, '2019-12-26', 1, 100, 9600.01, 9700.01, 0, 'VRS'),
(27, '2019-12-26', 1, 100, 9700.01, 9800.01, 0, 'VRS'),
(28, '2019-12-26', 1, 1500, 9800.01, 11300.01, 0, 'VRS'),
(29, '2019-12-26', 1, 589990, 11300.01, 601290.01, 0, 'VRS'),
(30, '2019-12-26', 1, 10000, 601290.01, 591290.01, 0, 'RTRD'),
(31, '2019-12-26', 1, 100002, 591290.01, 491288.01, 0, 'RTRD'),
(32, '2019-12-26', 1, 491288, 491288.01, 0.010000000009313226, 0, 'RTRD'),
(33, '2019-12-27', 1, 1500, 0.010000000009313226, 1500.0100000000093, 0, 'VRS'),
(34, '2019-12-27', 1, 1500, 1500.0100000000093, 3000.0100000000093, 0, 'VRS'),
(35, '2019-12-27', 1, 1500, 3000.0100000000093, 4500.010000000009, 0, 'VRS'),
(36, '2019-12-27', 1, 1000, 4500.010000000009, 5500.010000000009, 0, 'VRS'),
(37, '2019-12-27', 1, 1000, 5500.010000000009, 6500.010000000009, 0, 'VRS'),
(38, '2019-12-27', 1, 1000, 6500.010000000009, 7500.010000000009, 0, 'VRS'),
(39, '2019-12-27', 1, 100, 7500.010000000009, 7400.010000000009, 0, 'RTRD'),
(40, '2019-12-27', 1, 10000, 7400.010000000009, 17400.01000000001, 0, 'VRS');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Client`
--
ALTER TABLE `Client`
  ADD PRIMARY KEY (`codClt`),
  ADD UNIQUE KEY `codClt` (`codClt`);

--
-- Index pour la table `comptes`
--
ALTER TABLE `comptes`
  ADD PRIMARY KEY (`numCpt`);

--
-- Index pour la table `Nature`
--
ALTER TABLE `Nature`
  ADD PRIMARY KEY (`codnat`);

--
-- Index pour la table `Operation`
--
ALTER TABLE `Operation`
  ADD PRIMARY KEY (`numMouvement`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `comptes`
--
ALTER TABLE `comptes`
  MODIFY `numCpt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=152;

--
-- AUTO_INCREMENT pour la table `Operation`
--
ALTER TABLE `Operation`
  MODIFY `numMouvement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
