-- phpMyAdmin SQL Dump
-- version 2.11.8.1deb5+lenny4
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mar 27 Juillet 2010 à 17:17
-- Version du serveur: 5.0.51
-- Version de PHP: 5.2.6-1+lenny8

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
  `datetime_registration` datetime default NULL,
  `datetime_last_connection` datetime default NULL,
  `datetime_last_offer_created` datetime default NULL,
  `datetime_last_car_sharing` datetime default NULL,
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
  `datetime_started` datetime default NULL,
  `datetime_ended` datetime default NULL,
  PRIMARY KEY  (`_id_offer`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `offers`
--

INSERT INTO `offers` (`_id_offer`, `_id_offer_type`, `_id_driver`, `title`, `description`, `number_of_place_initial`, `number_of_place_remaining`, `price_per_passenger`, `datetime_started`, `datetime_ended`) VALUES
(1, 0, 0, 'Face de moule', 'Teub', 0, 0, 0.00, '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `offers_to_customer_accounts`
--

CREATE TABLE IF NOT EXISTS `offers_to_customer_accounts` (
  `_id_offers_to_customer_account` int(11) unsigned NOT NULL auto_increment,
  `_id_offer` int(11) unsigned NOT NULL,
  `_id_customer_account` int(11) unsigned NOT NULL,
  PRIMARY KEY  (`_id_offers_to_customer_account`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `offers_to_customer_accounts`
--


-- --------------------------------------------------------

--
-- Structure de la table `offers_to_routes`
--

CREATE TABLE IF NOT EXISTS `offers_to_routes` (
  `_id_offers_to_route` int(11) unsigned NOT NULL auto_increment,
  `_id_offer` int(11) unsigned NOT NULL,
  `_id_route` int(11) unsigned NOT NULL,
  PRIMARY KEY  (`_id_offers_to_route`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `offers_to_routes`
--


-- --------------------------------------------------------

--
-- Structure de la table `opinions`
--

CREATE TABLE IF NOT EXISTS `opinions` (
  `_id_opinion` int(11) unsigned NOT NULL auto_increment,
  `_id_customer_account` int(11) unsigned NOT NULL,
  `positive_or_negative` tinyint(1) NOT NULL,
  `comment` text NOT NULL,
  `datetime_created` datetime default NULL,
  PRIMARY KEY  (`_id_opinion`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `opinions`
--


-- --------------------------------------------------------

--
-- Structure de la table `routes`
--

CREATE TABLE IF NOT EXISTS `routes` (
  `_id_route` int(11) unsigned NOT NULL auto_increment,
  `_id_passenger` int(11) unsigned NOT NULL,
  `starting_address` varchar(60) NOT NULL,
  `starting_city` varchar(60) NOT NULL,
  `finishing_address` varchar(60) NOT NULL,
  `finishing_city` varchar(60) NOT NULL,
  `price` float(4,2) unsigned NOT NULL,
  `conversion_rate_to_euro` float(4,2) unsigned NOT NULL,
  `currency_code` varchar(10) NOT NULL,
  PRIMARY KEY  (`_id_route`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `routes`
--

INSERT INTO `routes` (`_id_route`, `_id_passenger`, `starting_address`, `starting_city`, `finishing_address`, `finishing_city`, `price`, `conversion_rate_to_euro`, `currency_code`) VALUES
(1, 0, 'toto', 'orleans', 'tata', 'paris', 0.00, 0.00, '');

-- --------------------------------------------------------

--
-- Structure de la table `routes_to_customer_accounts`
--

CREATE TABLE IF NOT EXISTS `routes_to_customer_accounts` (
  `_id_routes_to_customer_acount` int(11) unsigned NOT NULL auto_increment,
  `_id_route` int(11) unsigned NOT NULL,
  `_id_customer_account` int(11) unsigned NOT NULL,
  PRIMARY KEY  (`_id_routes_to_customer_acount`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `routes_to_customer_accounts`
--


-- --------------------------------------------------------

--
-- Structure de la table `translations`
--

CREATE TABLE IF NOT EXISTS `translations` (
  `_id_translation` int(11) unsigned NOT NULL auto_increment,
  `_id_translation_value` int(11) unsigned NOT NULL,
  `value_summary` text NOT NULL,
  PRIMARY KEY  (`_id_translation`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `translations`
--


-- --------------------------------------------------------

--
-- Structure de la table `translation_values`
--

CREATE TABLE IF NOT EXISTS `translation_values` (
  `_id_translation_value` int(11) unsigned NOT NULL auto_increment,
  `translation_value` text NOT NULL,
  `language_code` char(2) NOT NULL,
  `country_code` char(2) NOT NULL,
  PRIMARY KEY  (`_id_translation_value`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `translation_values`
--


-- --------------------------------------------------------

--
-- Structure de la table `vehicles`
--

CREATE TABLE IF NOT EXISTS `vehicles` (
  `_id_vehicle` int(11) unsigned NOT NULL auto_increment,
  `model` varchar(60) NOT NULL,
  PRIMARY KEY  (`_id_vehicle`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `vehicles`
--

