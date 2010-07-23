-- phpMyAdmin SQL Dump
-- version 3.1.2deb1ubuntu0.2
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Ven 23 Juillet 2010 à 16:49
-- Version du serveur: 5.0.75
-- Version de PHP: 5.2.6-3ubuntu4.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de données: `simul_car_sharing`
--

-- --------------------------------------------------------

--
-- Structure de la table `customer_accounts`
--

CREATE TABLE IF NOT EXISTS `customer_accounts` (
  `_id_customer_account` int(11) unsigned NOT NULL auto_increment,
  `customer_login` varchar(20) NOT NULL,
  `customer_password` varchar(20) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `first_name` varchar(40) NOT NULL,
  `email_address` varchar(40) NOT NULL,
  `phone` int(10) unsigned NOT NULL,
  `mobile` int(10) unsigned NOT NULL,
  `customer_type` tinyint(1) unsigned NOT NULL,
  `_id_vehicule` int(11) unsigned NOT NULL,
  `accept_animals` tinyint(1) unsigned NOT NULL,
  `accept_radio` tinyint(1) unsigned NOT NULL,
  `accept_smoker` tinyint(1) unsigned NOT NULL,
  `accept_to_discuss` tinyint(1) unsigned NOT NULL,
  `accept_to_make_a_detour` tinyint(1) unsigned NOT NULL,
  `datetime_registration` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `datetime_last_connection` timestamp NULL default '0000-00-00 00:00:00',
  `datetime_last_offer_created` timestamp NULL default '0000-00-00 00:00:00',
  `datetime_last_car_sharing` timestamp NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`_id_customer_account`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `customer_accounts`
--

INSERT INTO `customer_accounts` (`_id_customer_account`, `customer_login`, `customer_password`, `last_name`, `first_name`, `email_address`, `phone`, `mobile`, `customer_type`, `_id_vehicule`, `accept_animals`, `accept_radio`, `accept_smoker`, `accept_to_discuss`, `accept_to_make_a_detour`, `datetime_registration`, `datetime_last_connection`, `datetime_last_offer_created`, `datetime_last_car_sharing`) VALUES
(1, 'login', 'password', 'lastname', 'firstname', 'email@free.fr', 130937747, 688958079, 0, 0, 0, 0, 0, 0, 0, '2010-07-22 15:07:42', '2010-07-22 00:00:00', '2010-07-23 00:00:00', '2010-07-23 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `offers`
--

CREATE TABLE IF NOT EXISTS `offers` (
  `_id_offer` int(11) unsigned NOT NULL auto_increment,
  `_id_offer_type` int(11) unsigned NOT NULL,
  `_id_driver` int(11) unsigned NOT NULL,
  `title` varchar(40) NOT NULL,
  `description` text NOT NULL,
  `number_of_place_initial` tinyint(1) unsigned NOT NULL,
  `number_of_place_remaining` tinyint(1) unsigned NOT NULL,
  `price_per_passenger` float(4,2) unsigned NOT NULL,
  `datetime_started` datetime NOT NULL,
  `datetime_ended` datetime NOT NULL,
  PRIMARY KEY  (`_id_offer`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `offers`
--

INSERT INTO `offers` (`_id_offer`, `_id_offer_type`, `_id_driver`, `title`, `description`, `number_of_place_initial`, `number_of_place_remaining`, `price_per_passenger`, `datetime_started`, `datetime_ended`) VALUES
(1, 1, 1, 'title', 'description', 1, 1, 1.00, '2010-07-23 16:48:08', '2010-07-23 16:48:12');

-- --------------------------------------------------------

--
-- Structure de la table `offers_to_customer_accounts`
--

CREATE TABLE IF NOT EXISTS `offers_to_customer_accounts` (
  `_id_offers_to_customer_account` int(11) unsigned NOT NULL,
  `_id_offer` int(11) unsigned NOT NULL,
  `_id_customer_account` int(11) unsigned NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `offers_to_customer_accounts`
--


-- --------------------------------------------------------

--
-- Structure de la table `opinions`
--

CREATE TABLE IF NOT EXISTS `opinions` (
  `_id_opinion` int(11) unsigned NOT NULL,
  `_id_customer_account` int(11) unsigned NOT NULL,
  `positive_or_negative` tinyint(1) NOT NULL,
  `comment` text NOT NULL,
  `datetime_created` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `opinions`
--


-- --------------------------------------------------------

--
-- Structure de la table `routes`
--

CREATE TABLE IF NOT EXISTS `routes` (
  `_id_route` int(11) unsigned NOT NULL,
  `_id_offer` int(11) unsigned NOT NULL,
  `_id_passenger` int(11) unsigned NOT NULL,
  `starting_address` varchar(60) NOT NULL,
  `finishing_address` varchar(60) NOT NULL,
  `price` float(4,2) unsigned NOT NULL,
  `conversion_rate_to_euro` float(4,2) unsigned NOT NULL,
  `currency_code` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `routes`
--


-- --------------------------------------------------------

--
-- Structure de la table `routes_to_customer_accounts`
--

CREATE TABLE IF NOT EXISTS `routes_to_customer_accounts` (
  `_id_routes_to_customer_acount` int(11) unsigned NOT NULL,
  `_id_route` int(11) unsigned NOT NULL,
  `_id_customer_account` int(11) unsigned NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `routes_to_customer_accounts`
--


-- --------------------------------------------------------

--
-- Structure de la table `translations`
--

CREATE TABLE IF NOT EXISTS `translations` (
  `_id_translation` int(11) unsigned NOT NULL,
  `_id_translation_value` int(11) unsigned NOT NULL,
  `value_summary` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `translations`
--


-- --------------------------------------------------------

--
-- Structure de la table `translation_values`
--

CREATE TABLE IF NOT EXISTS `translation_values` (
  `_id_translation_value` int(11) unsigned NOT NULL,
  `translation_value` text NOT NULL,
  `language_code` char(2) NOT NULL,
  `country_code` char(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `translation_values`
--


-- --------------------------------------------------------

--
-- Structure de la table `vehicles`
--

CREATE TABLE IF NOT EXISTS `vehicles` (
  `_id_vehicle` int(11) unsigned NOT NULL,
  `model` varchar(60) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `vehicles`
--

