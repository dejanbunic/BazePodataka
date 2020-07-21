USE `izbori`;
DROP procedure IF EXISTS `azurirajKandidata`;
DELIMITER $$
USE `izbori`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `azurirajKandidata`(
	in pJMBG char(13),
	in pIme varchar(50),
	in pPrezime varchar(50),
	in pMjestoRodjenja varchar(50),
	in pDatumRodjenja date,
	in pPolitickaPartija varchar(50),
	in pOpstina varchar(50),
	in pGrad varchar(50)
    )
BEGIN
	declare a int default null;
    declare b int default null;
    declare c int default 0;
    declare d int default 0;
    declare e int default 0;
    declare f int default 0;
	select IdGrada into a from izbori.grad 
    where Naziv=pGrad;
    if a is null then
    select IdOpstine into b from izbori.opstina
    where Naziv=pOpstina and IdGrada is null;
    else
    select IdOpstine into b from izbori.opstina
    where Naziv=pOpstina and IdGrada=a;
    end if;
    select JMBG count into c from izbori.osoba 
    where JMBG=pJMBG;
    update osoba set
    Ime=pIme,
    Prezime=pPrezime,
    MjestoRodjenja=pMJestoRodjenja,
    DatumRodjenja=pDatumRodjenja,
    IdOpstine=b
    where JMBG=pJMBG;
    select JMBG count into d from izbori.kandidat
    where JMBG=pJMBG;

    update kandidat set Naziv=pPolitickaPartija
    where JMBG=pJMBG;
END$$

DELIMITER ;



USE `izbori`;
DROP procedure IF EXISTS `dodajKandidata`;

DELIMITER $$
USE `izbori`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodajKandidata`(
	in pJMBG char(13),
	in pIme varchar(50),
	in pPrezime varchar(50),
	in pMjestoRodjenja varchar(50),
	in pDatumRodjenja date,
	in pPolitickaPartija varchar(50),
	in pOpstina varchar(50),
	in pGrad varchar(50),
    in pTipKandidata varchar(50))
BEGIN
	declare a int default null;
    declare b int default null;
    declare c int default 0;
    declare d int default 0;
    declare e int default 0;
    declare f int default 0;
	select IdGrada into a from izbori.grad 
    where Naziv=pGrad;
    if a is null then
    select IdOpstine into b from izbori.opstina
    where Naziv=pOpstina and IdGrada is null;
    else
    
    select IdOpstine into b from izbori.opstina
    where Naziv=pOpstina and IdGrada=a;
    end if;
    select JMBG count into c from izbori.osoba 
    where JMBG=pJMBG;
    if c=0 then
	insert into osoba(JMBG,Ime,Prezime,MjestoRodjenja,DatumRodjenja,IdOpstine)
	values(pJMBG,pIme,pPrezime,pMjestoRodjenja,pDatumRodjenja,b);
    end if;
    select JMBG count into d from izbori.kandidat
    where JMBG=pJMBG;
    if d=0 then
    insert into kandidat(JMBG,Naziv)
    values(pJMBG,pPolitickaPartija);
    end if;
    select JMBG count into e from izbori.kandidatzaodbornikaopstine
    where JMBG=pJMBG;
    if pTipKandidata="KandidatZaOdbornikaOpstine" and e=0 then
    insert into kandidatzaodbornikaopstine(JMBG)
    values(pJMBG);
    end if;
    select JMBG count into f from izbori.kandidatzanacelnikaopstine
    where JMBG=pJMBG;
    if pTipKandidata="KandidatZaNacelnikaOpstine" and f=0 then
    insert into kandidatzanacelnikaopstine(JMBG)
    values(pJMBG);
    end if;
END$$

DELIMITER ;
USE `izbori`;
DROP procedure IF EXISTS `obrisiKandidata`;

DELIMITER $$
USE `izbori`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `obrisiKandidata`(
in pJMBG char(13), 
in tip varchar(50))
BEGIN
declare a int default 0;
declare b int default 0;
declare c int default 0;
	select  count(JMBG) into a from kandidatzanacelnikaopstine
    where JMBG=pJMBG;
    select count(JMBG) into b from kandidatzaodbornikaopstine
    where JMBG=pJMBG;
    if tip='KandidatZaNacelnikaOpstine' then
    if a>0 then 
    delete from kandidatzanacelnikaopstine where JMBG=pJMBG;
    end if;
    else
	if b>0 then 
    delete from kandidatzaodbornikaopstine where JMBG=pJMBG;
    end if;
    end if;
    if a=0 and b=1 then
    delete from kandidat where JMBG=pJMBG;
    end if;
    if a=1 and b=0 then 
    delete from kandidat where JMBG=pJMBG;
    end if;
    select  count(JMBG) into c from kandidat
    where JMBG=pJMBG;
    if(a=0 and b=0 and c=1) then  
    delete from kandidat where JMBG=pJMBG;
    end if;
END$$

DELIMITER ;
USE `izbori`;
DROP procedure IF EXISTS `prijava`;

DELIMITER $$
USE `izbori`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `prijava`(in pJMBG char(13), in pSifra varchar(50), in tip varchar(50))
BEGIN
	if tip='Administrator' then
	select  * from izbori.administrator 
    where Sifra=pSifra AND JMBG=pJMBG;
    else 
    select  * from izbori.glasac 
    where Sifra=pSifra AND JMBG=pJMBG;
    end if;
END$$

DELIMITER ;

USE `izbori`;
DROP procedure IF EXISTS `prikaziKandidata`;

DELIMITER $$
USE `izbori`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `prikaziKandidata`(
in JMBG char(13),
in tip varchar(50)
)
BEGIN
	if tip='KandidatZaNacelnikaOpstine' then
    select * FROM izbori.kandidatzanacelnikaopstine
    natural join izbori.kandidat 
    natural join osoba;
    
    else 
    select * FROM izbori.kandidatzaodbornikaopstine 
    natural join izbori.kandidat 
    natural join osoba;
    end if; 
END$$

DELIMITER ;
DROP procedure IF EXISTS `dodajOpstinu`;
DELIMITER $$
USE `izbori`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodajOpstinu`(
in pNazivOpstine varchar(50),
in pBrojGlasaca int,
in pIdGrada int,
in pIdKantona int,
in pIdJedinicaDrzave int,
in pIdJedinicaEntiteta int
)
BEGIN
 declare a int default 0;
	select count(IdOpstine) from osoba 
    where Naziv=pNazivOpstine and IdGrada=pIdGrada into a;
    if a=0 then
insert into opstina(Naziv,BrojGlasaca,IdGrada,IdKantona,IdIzborneJediniceDrzave,IdIzborneJediniceEntiteta)
values(pNazivOpstine,pBrojGlasaca,pIdGrada,pIdKantona,pIdJedinicaDrzave,pIdJedinicaEntiteta);
end if;
END$$

DELIMITER ;
DROP procedure IF EXISTS `obrisiOpstinu`;

DELIMITER $$
USE `izbori`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `obrisiOpstinu`(
in pIdOpstine int
)
BEGIN
	declare a int default 0;
    declare b int default 0;
    select count(IdOpstine) from osoba 
    where IdOpstine=pIdOpstine into a;
    select count(IdOpstine) from birackomjesto 
    where IdOpstine=pIdOpstine into b;
    if a=0 and b=0 then
    delete from opstina
    where IdOpstine=pIdOpstine;
    end if;
      
END$$

DELIMITER ;

DROP procedure IF EXISTS `azurirajOpstinu`;

DELIMITER $$
USE `izbori`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `azurirajOpstinu`(
in pIdOpstine int,
in pNazivOpstine varchar(50),
in pBrojGlasaca int,
in pIdGrada int,
in pIdKantona int,
in pIdJedinicaDrzave int,
in pIdJedinicaEntiteta int
)
BEGIN
	update opstina set
    Naziv=pNazivOpstine,
    BrojGlasaca=pBrojGlasaca,
    IdGrada=pIdGrada,
    IdKantona=pIdKantona,
    IdIzborneJediniceDrzave=pIdJedinicaDrzave,
    IdIzborneJediniceEntiteta=pIdJedinicaEntiteta
    where IdOpstine=pIdOpstine;
     
END$$
create view opstinaview as 
select o.IdOpstine,o.Naziv as NazivOpstine,o.BrojGlasaca,o.Glasalo,g.Naziv as NazivGrada,ijd.IdIzborneJediniceDrzave,ije.IdIzborneJediniceEntiteta,k.Naziv as NazivKantona,ije.NazivEntiteta,ijd.NazivDrzave from opstina o 
left join grad g on o.IdGrada=g.IdGrada
left join kanton k on o.IdKantona=k.IdKantona
left join (select NazivDrzave,IdIzborneJediniceDrzave from izbornajedinicadrzave natural join drzava )as ijd on o.IdIzborneJediniceDrzave=ijd.IdIzborneJediniceDrzave
left join (select NazivDrzave,IdEntiteta,IdIzborneJediniceEntiteta,NazivEntiteta from izbornajedinicaentiteta natural join entitet)as ije on o.IdIzborneJediniceEntiteta=ije.IdIzborneJediniceEntiteta order by IdOpstine;