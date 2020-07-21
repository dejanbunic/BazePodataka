SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

drop schema if exists izbori;
create schema izbori default character set utf8 default collate utf8_unicode_ci;
use izbori;
CREATE TABLE Grad
(
	IdGrada              INTEGER AUTO_INCREMENT,
	BrojGlasaca          MEDIUMINT NULL,
	Glasalo              MEDIUMINT NULL default 0,
	Naziv                VARCHAR(50) NULL,
	PRIMARY KEY (IdGrada)
);



CREATE TABLE Drzava
(
	NazivDrzave          VARCHAR(50) NOT NULL,
	Glasalo              MEDIUMINT NOT NULL default 0,
	BrojGlasaca          MEDIUMINT NOT NULL,
	PRIMARY KEY (NazivDrzave)
);



CREATE TABLE Entitet
(
	IdEntiteta           INTEGER AUTO_INCREMENT,
	NazivEntiteta        VARCHAR(50) NOT NULL,
	BrojGlasaca          MEDIUMINT NOT NULL,
	Glasalo              MEDIUMINT NOT NULL default 0,
	NazivDrzave          VARCHAR(50) NOT NULL,
	PRIMARY KEY (IdEntiteta,NazivDrzave),
	FOREIGN KEY R_24 (NazivDrzave) REFERENCES Drzava (NazivDrzave)
);



CREATE TABLE Kanton
(
	IdKantona            INTEGER AUTO_INCREMENT,
	BrojGlasaca          MEDIUMINT NULL,
	Glasalo              MEDIUMINT NULL default 0,
	IdEntiteta           INTEGER NOT NULL,
	NazivDrzave          VARCHAR(50) NOT NULL,
	Naziv                VARCHAR(50) NULL,
	PRIMARY KEY (IdKantona),
	FOREIGN KEY R_25 (IdEntiteta, NazivDrzave) REFERENCES Entitet (IdEntiteta, NazivDrzave)
);



CREATE TABLE IzbornaJedinica
(
	IdIzborneJedinice    INTEGER AUTO_INCREMENT,
	BrojGlasaca          MEDIUMINT NULL,
	Glasalo              MEDIUMINT NULL default 0,
	PRIMARY KEY (IdIzborneJedinice)
);



CREATE TABLE IzbornaJedinicaDrzave
(
	IdIzborneJediniceDrzave INTEGER NOT NULL,
	NazivDrzave          VARCHAR(50) NOT NULL,
	PRIMARY KEY (IdIzborneJediniceDrzave),
	FOREIGN KEY (IdIzborneJediniceDrzave) REFERENCES IzbornaJedinica(IdIzborneJedinice)
		ON DELETE CASCADE,
	FOREIGN KEY R_22 (NazivDrzave) REFERENCES Drzava (NazivDrzave)
);



CREATE TABLE IzbornaJedinicaEntiteta
(
	IdIzborneJediniceEntiteta INTEGER NOT NULL,
	IdEntiteta           INTEGER NOT NULL,
	NazivDrzave          VARCHAR(50) NOT NULL,
	PRIMARY KEY (IdIzborneJediniceEntiteta),
	FOREIGN KEY (IdIzborneJediniceEntiteta) REFERENCES IzbornaJedinica(IdIzborneJedinice)
		ON DELETE CASCADE,
	FOREIGN KEY R_21 (IdEntiteta, NazivDrzave) REFERENCES Entitet (IdEntiteta, NazivDrzave)
);



CREATE TABLE Opstina
(
	IdOpstine            INTEGER AUTO_INCREMENT,
	BrojGlasaca          MEDIUMINT NOT NULL,
	Glasalo              MEDIUMINT NOT NULL default 0,
	IdGrada              INTEGER NULL,
	IdKantona            INTEGER NULL,
	IdIzborneJediniceDrzave INTEGER NOT NULL,
	IdIzborneJediniceEntiteta INTEGER NOT NULL,
	Naziv                VARCHAR(50) NULL,
	PRIMARY KEY (IdOpstine),
	FOREIGN KEY R_5 (IdGrada) REFERENCES Grad (IdGrada),
	FOREIGN KEY R_15 (IdKantona) REFERENCES Kanton (IdKantona),
	FOREIGN KEY R_20 (IdIzborneJediniceEntiteta) REFERENCES IzbornaJedinicaEntiteta (IdIzborneJediniceEntiteta),
	FOREIGN KEY R_19 (IdIzborneJediniceDrzave) REFERENCES IzbornaJedinicaDrzave (IdIzborneJediniceDrzave)
);



CREATE TABLE Osoba
(
	JMBG                 CHAR(13) NOT NULL,
	Ime                  VARCHAR(50) NULL,
	Prezime              VARCHAR(50) NULL,
	MjestoRodjenja       VARCHAR(50) NULL,
	DatumRodjenja        DATE NULL,
	IdOpstine            INTEGER NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY Ima_Prebivaliste (IdOpstine) REFERENCES Opstina (IdOpstine)
);



CREATE TABLE Administrator
(
	JMBG                 CHAR(13) NOT NULL,
	Sifra                VARCHAR(50) NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Osoba(JMBG)
		ON DELETE CASCADE
);



CREATE TABLE PolitickaStranka
(
	Naziv                VARCHAR(50) NOT NULL,
	Adresa               VARCHAR(50) NOT NULL,
	PRIMARY KEY (Naziv)
);



CREATE TABLE Kandidat
(
	JMBG                 CHAR(13) NOT NULL,
	BrojGlasova          MEDIUMINT NOT NULL default 0,
	Naziv                VARCHAR(50) NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Osoba(JMBG)
		ON DELETE CASCADE,
	FOREIGN KEY R_8 (Naziv) REFERENCES PolitickaStranka (Naziv)
);



CREATE TABLE KandidatZaPredsednikaKantona
(
	JMBG                 CHAR(13) NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Kandidat(JMBG)
		ON DELETE CASCADE
);



CREATE TABLE KandidatZaPoslanikaKantona
(
	JMBG                 CHAR(13) NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Kandidat(JMBG)
		ON DELETE CASCADE
);



CREATE TABLE KandidatZaOdbornikaGrada
(
	JMBG                 CHAR(13) NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Kandidat(JMBG)
		ON DELETE CASCADE
);



CREATE TABLE KandidatZaNacelnikaGrada
(
	JMBG                 CHAR(13) NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Kandidat(JMBG)
		ON DELETE CASCADE
);



CREATE TABLE KandidatZaOdbornikaOpstine
(
	JMBG                 CHAR(13) NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Kandidat(JMBG)
		ON DELETE CASCADE
);



CREATE TABLE KandidatZaNacelnikaOpstine
(
	JMBG                 CHAR(13) NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Kandidat(JMBG)
		ON DELETE CASCADE
);



CREATE TABLE KanidatZaPoslanikaDrzave
(
	JMBG                 CHAR(13) NOT NULL,
	IdIzborneJediniceDrzave INTEGER NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Kandidat(JMBG)
		ON DELETE CASCADE,
	FOREIGN KEY R_38 (IdIzborneJediniceDrzave) REFERENCES IzbornaJedinicaDrzave (IdIzborneJediniceDrzave)
);



CREATE TABLE KandidatZaPredsednikaDrzave
(
	JMBG                 CHAR(13) NOT NULL,
	NazivDrzave          VARCHAR(50) NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Kandidat(JMBG)
		ON DELETE CASCADE,
	FOREIGN KEY R_34 (NazivDrzave) REFERENCES Drzava (NazivDrzave)
);



CREATE TABLE KandidatZaPredsednikaEntiteta
(
	JMBG                 CHAR(13) NOT NULL,
	IdEntiteta           INTEGER NOT NULL,
	NazivDrzave          VARCHAR(50) NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Kandidat(JMBG)
		ON DELETE CASCADE,
	FOREIGN KEY R_30 (IdEntiteta, NazivDrzave) REFERENCES Entitet (IdEntiteta, NazivDrzave)
);



CREATE TABLE KandidatZaPoslanikaEntiteta
(
	JMBG                 CHAR(13) NOT NULL,
	IdIzborneJediniceEntiteta INTEGER NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Kandidat(JMBG)
		ON DELETE CASCADE,
	FOREIGN KEY R_32 (IdIzborneJediniceEntiteta) REFERENCES IzbornaJedinicaEntiteta (IdIzborneJediniceEntiteta)
);



CREATE TABLE BirackoMjesto
(
	IdBirackogMjesta     INTEGER AUTO_INCREMENT,
	BrojGlasaca          INTEGER NOT NULL,
	Glasalo              INTEGER NOT NULL default 0,
	Adresa               VARCHAR(50) NOT NULL,
	IdOpstine            INTEGER NOT NULL,
	PRIMARY KEY (IdBirackogMjesta),
	FOREIGN KEY R_6 (IdOpstine) REFERENCES Opstina (IdOpstine)
);



CREATE TABLE Izbori
(
	IdIzbora             INTEGER NOT NULL AUTO_INCREMENT,
	Nivo                 INTEGER NOT NULL,
	DatumIzbora          DATE NOT NULL,
	PRIMARY KEY (IdIzbora)
);



CREATE TABLE GlasoviKandidata
(
	IdBirackogMjesta     INTEGER NOT NULL,
	JMBG                 CHAR(13) NOT NULL,
	IdIzbora             INTEGER NOT NULL,
	Glasovi              MEDIUMINT NOT NULL default 0,
	PRIMARY KEY (IdBirackogMjesta,JMBG,IdIzbora),
	FOREIGN KEY R_11 (IdBirackogMjesta) REFERENCES BirackoMjesto (IdBirackogMjesta),
	FOREIGN KEY R_13 (JMBG) REFERENCES Kandidat (JMBG),
	FOREIGN KEY R_46 (IdIzbora) REFERENCES Izbori (IdIzbora)
);



CREATE TABLE GlasoviStranke
(
	IdBirackogMjesta     INTEGER NOT NULL,
	Naziv                VARCHAR(50) NOT NULL,
	IdIzbora             INTEGER NOT NULL,
	Glasovi              MEDIUMINT NOT NULL default 0,
	PRIMARY KEY (IdBirackogMjesta,Naziv,IdIzbora),
	FOREIGN KEY R_10 (IdBirackogMjesta) REFERENCES BirackoMjesto (IdBirackogMjesta),
	FOREIGN KEY R_12 (Naziv) REFERENCES PolitickaStranka (Naziv),
	FOREIGN KEY R_45 (IdIzbora) REFERENCES Izbori (IdIzbora)
);



CREATE TABLE Glasac
(
	JMBG                 CHAR(13) NOT NULL,
	Glasao               boolean NULL default false,
	Sifra                VARCHAR(50) NOT NULL,
	PRIMARY KEY (JMBG),
	FOREIGN KEY (JMBG) REFERENCES Osoba(JMBG)
		ON DELETE CASCADE
);



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;