SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";




CREATE TABLE IF NOT EXISTS `client` (

  `Cl_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Cl_Nom` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cl_Prenom` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cl_Adresse` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cl_CP` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cl_Ville` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cl_Pays` tinyint(4) DEFAULT NULL,
  `Cl_Naiss` date DEFAULT NULL,
  PRIMARY KEY (`Cl_Id`)
 

) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT = 50;

INSERT INTO `client` (`Cl_Id`, `Cl_Nom`, `Cl_Prenom`, `Cl_Adresse`, `Cl_CP`, `Cl_Ville`, `Cl_Pays`, `Cl_Naiss`) VALUES
(1, 'sahtan', 'ibrahim', 'jan mulsstraat', 1853, 'grimbergen', 2, '1990-11-07'),
(2, 'mouley', 'leila', 'koning boudewlijn', 2660, 'temse', 2, '1995-10-22'),
(3, 'dupont', 'marc', 'projet sgbd', 2300, 'uccle', 1, '1980-11-20'),
(4, 'delaure', 'jean', 'rue des lettres', 2400, 'libramont', 3, '1980-11-07'),
(5, 'meiser', 'michel', 'projet sgbd', 2500, 'gibraltar', 4, '1960-11-20'),
(6, 'cali', 'jules', 'projet sgbd', 2700, 'casablanca', 2, '1950-11-20'),
(7, 'stony', 'javier', 'projet sgbd', 2800, 'nador', 1, '1980-11-02'),
(8, 'bagril', 'christophe', 'projet sgbd', 4200, 'lisbonne', 3, '1990-11-20');




CREATE TABLE IF NOT EXISTS `pays` (

  `P_Id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `P_Nom` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`P_Id`)
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5;

INSERT INTO `pays` (`P_Id`,`P_Nom`) VALUES
 (1,'Allemagne'),
 (2,'Belgique'),
 (3,'Espagne'),
 (4,'France');


 
 
CREATE TABLE IF NOT EXISTS `chambre` (

  `Ch_Num` tinyint(4) NOT NULL AUTO_INCREMENT,
  `Ch_Bain` tinyint(1) NOT NULL,
  `Ch_Douche` tinyint(1) NOT NULL,
  `Ch_WC` tinyint(1) NOT NULL,
  `Ch_Couchage` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`Ch_Num`)
  
  ) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT= 30;

INSERT INTO `chambre` (`Ch_Num`, `Ch_Bain`, `Ch_Douche`, `Ch_WC`, `Ch_Couchage`)   VALUES
  (1,0, 1, 1, 1),
  (2, 1, 1, 1, 2),
  (3,0, 1, 1, 3),
  (4, 1, 1, 0, 4),
  (5, 1, 0, 0, 3),
  (6, 0, 1, 1, 2),
  (7, 1, 0, 0, 4),
  (8, 0, 1, 1, 1),
  (9, 1, 0, 0, 2),
  (10, 1, 1, 0, 4);

  
  
  
  
CREATE TABLE IF NOT EXISTS `planning`  (

  `Pl_Id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `Pl_Date` date NOT NULL,
  PRIMARY KEY (`Pl_Id`),
  UNIQUE KEY `Pl_Date` (`Pl_Date`)
  
  ) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=10 ;

INSERT INTO `planning` (`Pl_Id`,`Pl_Date`) VALUES
  (1,'2020-07-01'),
  (2,'2020-08-02'),
  (3, '2020-09-03'),
  (4, '2020-10-04'),
  (5, '2020-11-05'),
  (6, '2020-12-06'),
  (7, '2020-02-07'),
  (8, '2020-03-08'),
  (9, '2020-04-09'),
  (10, '2020-05-10');
  


  
  
CREATE TABLE IF NOT EXISTS `reservation` ( 

  `Res_Id` int(7) NOT NULL AUTO_INCREMENT,
  `Cl_Id` int (11) DEFAULT NULL,
  `Ch_Num` tinyint(4) DEFAULT NULL,
  `Pl_Id` tinyint(4) DEFAULT NULL,
  `NbPers` tinyint(2) NOT NULL,
  UNIQUE KEY (`Res_Id`),
  -- PRIMARY KEY(`Res_Id`)
  PRIMARY KEY (`Cl_Id` , `Ch_Num` , `Pl_Id`)
 

  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
  
  INSERT INTO `reservation` (`Res_Id`, `Cl_Id`, `Ch_Num`, `Pl_Id`, `NbPers`) VALUES
(1, 3, 8, 1, 1),
(2, 2, 6, 3, 2),
(6, 5, 3, 6, 2);

  
  /*  ALTER TABLE `reservation`
    ADD KEY `fk_reservation_client` (`Cl_Id`), ADD KEY `fk_reservation_chambre` (`Ch_Num`), 
	ADD KEY `fk_reservation_planning` (`Pl_Id`);
  */
	

 
    ALTER TABLE `client`
    ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`Cl_Pays`) REFERENCES `pays` (`P_Id`);
	

  
    ALTER TABLE `reservation`
    ADD CONSTRAINT `fk_reservation_client`     FOREIGN KEY (`Cl_Id`)  REFERENCES `client`(`Cl_Id`),
    ADD CONSTRAINT `fk_reservation_chambre`    FOREIGN KEY (`Ch_Num`)  REFERENCES `chambre` (`Ch_Num`),
    ADD CONSTRAINT `fk_reservation_planning`   FOREIGN KEY (`Pl_Id`)  REFERENCES `planning` (`Pl_Id`);
  


  
  
