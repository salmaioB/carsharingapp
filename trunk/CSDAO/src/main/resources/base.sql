-- phpMyAdmin SQL Dump
-- version 2.11.3deb1ubuntu1.3
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mer 21 Juillet 2010 à 01:08
-- Version du serveur: 5.0.51
-- Version de PHP: 5.2.4-2ubuntu5.10

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
  `datetime_registration` datetime NOT NULL,
  `datetime_last_connection` datetime NOT NULL,
  `datetime_last_offer_created` datetime NOT NULL,
  `datetime_last_car_sharing` datetime NOT NULL,
  PRIMARY KEY  (`_id_customer_account`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `customer_accounts`
--


-- --------------------------------------------------------

--
-- Structure de la table `offers`
--

CREATE TABLE IF NOT EXISTS `offers` (
  `_id_offer` int(11) unsigned NOT NULL,
  `_id_offer_type` int(11) unsigned NOT NULL,
  `_id_driver` int(11) unsigned NOT NULL,
  `title` varchar(40) NOT NULL,
  `description` text NOT NULL,
  `number_of_place_initial` tinyint(1) unsigned NOT NULL,
  `number_of_place_remaining` tinyint(1) unsigned NOT NULL,
  `price_per_passenger` float(4,2) unsigned NOT NULL,
  `datetime_started` datetime NOT NULL,
  `datetime_ended` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `offers`
--


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

