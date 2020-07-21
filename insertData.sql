use izbori;

INSERT INTO `izbori`.`drzava` (`NazivDrzave`, `Glasalo`, `BrojGlasaca`) VALUES ('Bosna i Hercegovina', '0', '4000000');

INSERT INTO `izbori`.`entitet` (`IdEntiteta`, `NazivEntiteta`, `BrojGlasaca`, `Glasalo`, `NazivDrzave`) VALUES ('1', 'Republika Srpska', '2000000', '0', 'Bosna i Hercegovina');
INSERT INTO `izbori`.`entitet` (`IdEntiteta`, `NazivEntiteta`, `BrojGlasaca`, `Glasalo`, `NazivDrzave`) VALUES ('2', 'Brcko', '2000000', '0', 'Bosna i Hercegovina');

INSERT INTO `izbori`.`izbornajedinica` (`IdIzborneJedinice`, `BrojGlasaca`, `Glasalo`) VALUES ('1', '100000', '0');
INSERT INTO `izbori`.`izbornajedinica` (`IdIzborneJedinice`, `BrojGlasaca`, `Glasalo`) VALUES ('2', '1000', '0');
INSERT INTO `izbori`.`izbornajedinica` (`IdIzborneJedinice`, `BrojGlasaca`, `Glasalo`) VALUES ('3', '1000', '0');
INSERT INTO `izbori`.`izbornajedinica` (`IdIzborneJedinice`, `BrojGlasaca`, `Glasalo`) VALUES ('4', '1000', '0');
INSERT INTO `izbori`.`izbornajedinica` (`IdIzborneJedinice`, `BrojGlasaca`, `Glasalo`) VALUES ('5', '1000', '0');
INSERT INTO `izbori`.`izbornajedinica` (`IdIzborneJedinice`, `BrojGlasaca`, `Glasalo`) VALUES ('6', '1000', '0');

INSERT INTO `izbori`.`izbornajedinicadrzave` (`IdIzborneJediniceDrzave`, `NazivDrzave`) VALUES ('1', 'Bosna i Hercegovina');
INSERT INTO `izbori`.`izbornajedinicadrzave` (`IdIzborneJediniceDrzave`, `NazivDrzave`) VALUES ('3', 'Bosna i Hercegovina');
INSERT INTO `izbori`.`izbornajedinicaentiteta` (`IdIzborneJediniceEntiteta`, `IdEntiteta`, `NazivDrzave`) VALUES ('2', '1', 'Bosna i Hercegovina');
INSERT INTO `izbori`.`izbornajedinicaentiteta` (`IdIzborneJediniceEntiteta`, `IdEntiteta`, `NazivDrzave`) VALUES ('4', '1', 'Bosna i Hercegovina');
INSERT INTO `izbori`.`izbornajedinicaentiteta` (`IdIzborneJediniceEntiteta`, `IdEntiteta`, `NazivDrzave`) VALUES ('5', '2', 'Bosna i Hercegovina');
INSERT INTO `izbori`.`izbornajedinicaentiteta` (`IdIzborneJediniceEntiteta`, `IdEntiteta`, `NazivDrzave`) VALUES ('6', '2', 'Bosna i Hercegovina');

INSERT INTO `izbori`.`opstina` (`IdOpstine`, `BrojGlasaca`, `Glasalo`, `IdIzborneJediniceDrzave`, `IdIzborneJediniceEntiteta`,`Naziv`) VALUES ('1', '10000', '0', '1', '2','Banjaluka');
INSERT INTO `izbori`.`opstina` (`IdOpstine`, `BrojGlasaca`, `Glasalo`, `IdIzborneJediniceDrzave`, `IdIzborneJediniceEntiteta`,`Naziv`) VALUES ('2', '10000', '0', '1', '2','Prijedor');
INSERT INTO `izbori`.`opstina` (`IdOpstine`, `BrojGlasaca`, `Glasalo`, `IdIzborneJediniceDrzave`, `IdIzborneJediniceEntiteta`,`Naziv`) VALUES ('3', '10000', '0', '3', '4','Brcko');
INSERT INTO `izbori`.`opstina` (`IdOpstine`, `BrojGlasaca`, `Glasalo`, `IdIzborneJediniceDrzave`, `IdIzborneJediniceEntiteta`,`Naziv`) VALUES ('4', '10000', '0', '3', '4','Smoluca');
INSERT INTO `izbori`.`osoba` (`JMBG`, `Ime`, `Prezime`, `MjestoRodjenja`, `DatumRodjenja`, `IdOpstine`) VALUES ('1111111111111', 'Dejan', 'Bunic', 'Banjaluka', '1994.07.09', '1');
INSERT INTO `izbori`.`osoba` (`JMBG`, `Ime`, `Prezime`, `MjestoRodjenja`, `DatumRodjenja`, `IdOpstine`) VALUES ('222', 'Pero', 'Peric', 'Prnjavor', '1990-01-01', '1');

INSERT INTO `izbori`.`glasac` (`JMBG`, `Glasao`, `Sifra`) VALUES ('1111111111111', '0', '0709');
INSERT INTO `izbori`.`kanton` (`IdKantona`, `BrojGlasaca`, `Glasalo`, `IdEntiteta`, `NazivDrzave`, `Naziv`) VALUES ('1', '321321', '0', '1', 'Bosna i Hercegovina', 'Sanski');
INSERT INTO `izbori`.`kanton` (`IdKantona`, `BrojGlasaca`, `Glasalo`, `IdEntiteta`, `NazivDrzave`, `Naziv`) VALUES ('2', '321321', '0', '1', 'Bosna i Hercegovina', 'Posavski');
INSERT INTO `izbori`.`administrator` (`JMBG`, `Sifra`) VALUES ('1111111111111', '0709');
INSERT INTO `izbori`.`administrator` (`JMBG`, `Sifra`) VALUES ('222', '1');

INSERT INTO `izbori`.`grad` (`IdGrada`, `IdEntiteta`, `NazivDrzave`, `BrojGlasaca`, `Naziv`) VALUES ('1', '1', 'Bosna i Hercegovina', '342432', 'Banjaluka');
INSERT INTO `izbori`.`grad` (`IdGrada`, `IdEntiteta`, `NazivDrzave`, `BrojGlasaca`, `Naziv`) VALUES ('2', '1', 'Bosna i Hercegovina', '342432', 'Prijedor');


INSERT INTO `izbori`.`politickastranka` (`Naziv`, `Adresa`) VALUES ('Nezavisni', 'Zivojina Misica 99');
INSERT INTO `izbori`.`politickastranka` (`Naziv`, `Adresa`) VALUES ('Demokrate', 'Stepe Stepanovica 100');
INSERT INTO `izbori`.`politickastranka` (`Naziv`, `Adresa`) VALUES ('Autokrate', 'Petra Bojovica 11');
INSERT INTO `izbori`.`politickastranka` (`Naziv`, `Adresa`) VALUES ('Pobjednici', 'Ratomira Putnika 12');
INSERT INTO `izbori`.`politickastranka` (`Naziv`, `Adresa`) VALUES ('BoljeSutra', 'bb');

INSERT INTO `izbori`.`kandidat` (`JMBG`, `BrojGlasova`, `Naziv`) VALUES ('1111111111111', '0', 'Nezavisni');
INSERT INTO `izbori`.`kandidat` (`JMBG`, `BrojGlasova`, `Naziv`) VALUES ('5555', '0', 'Nezavisni');
INSERT INTO `izbori`.`kandidat` (`JMBG`, `BrojGlasova`, `Naziv`) VALUES ('2222', '0', 'Nezavisni');

INSERT INTO `izbori`.`izbori` (`IdIzbora`, `Nivo`, `DatumIzbora`) VALUES ('1', '1', '1994-04-04');
INSERT INTO `izbori`.`izbori` (`IdIzbora`, `Nivo`, `DatumIzbora`) VALUES ('2', '2', '1996-04-04');
INSERT INTO `izbori`.`izbori` (`IdIzbora`, `Nivo`, `DatumIzbora`) VALUES ('3', '1', '1998-05-05');
INSERT INTO `izbori`.`izbori` (`IdIzbora`, `Nivo`, `DatumIzbora`) VALUES ('4', '2', '200-05-05');

INSERT INTO `izbori`.`birackomjesto` (`IdBirackogMjesta`, `BrojGlasaca`, `Adresa`, `IdOpstine`) VALUES ('1', '321', 'Petra Petrovica 14', '1');
INSERT INTO `izbori`.`birackomjesto` (`IdBirackogMjesta`, `BrojGlasaca`, `Glasalo`, `Adresa`, `IdOpstine`) VALUES ('2', '3221', '0', 'Milosa Obilica', '1');

INSERT INTO `izbori`.`birackomjesto` (`IdBirackogMjesta`, `BrojGlasaca`, `Glasalo`, `Adresa`, `IdOpstine`) VALUES ('2', '3221', '0', 'Milosa Obilica', '1');
INSERT INTO `izbori`.`glasovistranke` (`IdBirackogMjesta`, `Naziv`, `IdIzbora`, `Glasovi`) VALUES ('1', 'BoljeSutra', '1', '222');
INSERT INTO `izbori`.`glasovistranke` (`IdBirackogMjesta`, `Naziv`, `IdIzbora`, `Glasovi`) VALUES ('2', 'Nezavisni', '2', '22');

INSERT INTO `izbori`.`glasovikandidata` (`IdBirackogMjesta`, `JMBG`, `IdIzbora`, `Glasovi`) VALUES ('1', '21', '1', '12121');
INSERT INTO `izbori`.`glasovikandidata` (`IdBirackogMjesta`, `JMBG`, `IdIzbora`, `Glasovi`) VALUES ('2', '12321', '1', '111');

