/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.4.8-MariaDB : Database - seminarskibiblioteka
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarskibiblioteka` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `seminarskibiblioteka`;

/*Data for the table `bibliotekar` */

insert  into `bibliotekar`(`korisnicko_ime`,`sifra`,`ime_prezime`,`email`,`jmbg`,`sifra_zaposlenog`,`broj_telefona`) values 
('Bibliotekar1','sifra','Slika Slike','email@email.com','2311990123321',1,'069000000');

/*Data for the table `knjiga` */

insert  into `knjiga`(`isbn`,`naslov`,`autor`,`izdavac`,`jezik`,`opis`,`broj_strana`,`ukupan_broj_knjiga`,`raspoloziv_broj_knjiga`,`prosecna_ocena`,`vlasnik`) values 
(1,'Knjiga1','Autor1','Izdavac1','Srpski','Ovde ide neki opsi',100,100,100,5,'Bibliotekar1'),
(2,'Knjiga2','Autro2','Izdavac2','Engleski','I ovde ide opis',200,50,50,4,'Bibliotekar1');

/*Data for the table `korisnik` */

insert  into `korisnik`(`korisnicko_ime`,`sifra`,`ime_prezime`,`email`,`jmbg`,`status`,`broj_aktivnih_iznajmljivanja`) values 
('Korisnik1','sifra','Korisnik K','emailneki@gmail.com','1111111111111','aktivan',0),
('Korisnik2','sifra','Korisnik 2','email2@gmail.com','2222222222222','aktivan',0);

/*Data for the table `ocena` */

insert  into `ocena`(`isbn_knjige`,`korisnicko_ime_korisnika`,`konacna_ocena`,`opis`) values 
(1,'Korisnik1',5,'Dobra knjiga'),
(1,'Korisnik2',4,'Ovde isto ide opis neki'),
(2,'Korisnik1',3,'Ovde ide opis');

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`isbn_knjige`,`korisnicko_ime_korisnika`,`datum_od`,`datum_do`,`status`) values 
(1,'Korisnik1','2019-12-13','2019-12-20','vracena'),
(2,'Korisnik1','2010-10-10','2019-12-20','vracena'),
(44,'Korisnik2','2001-01-01','2019-12-20','vracena'),
(44,'Korisnik2','2010-10-10','2019-12-20','vracena');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
