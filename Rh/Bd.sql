-- CREATE ROLE izahay LOGIN PASSWORD '1234';
-- create database ressourceH;

-- alter database ressourceH owner to izahay;

drop table employe cascade;
drop table poste cascade;
drop table typeContrat cascade;
drop table contrat cascade;
drop table conges cascade;
drop table avance cascade;
drop table paiementSalaire cascade;
drop table cotisation cascade;
drop table irsa cascade;
drop table historiqueConges cascade;

drop sequence inc_employe;
drop sequence inc_poste;
drop sequence inc_typecontrat;
drop sequence inc_contrat;
drop sequence inc_conges;
drop sequence inc_avance;
drop sequence inc_salaire;
drop sequence inc_tranche;
drop sequence inc_histotiq;
drop sequence inc_cot;


-- \connect ressourceH;
CREATE sequence inc_employe;
CREATE sequence inc_poste;
CREATE sequence inc_typecontrat;
CREATE sequence inc_contrat;
CREATE sequence inc_conges;
CREATE sequence inc_avance;
CREATE sequence inc_salaire;
CREATE sequence inc_tranche;
CREATE sequence inc_histotiq;
CREATE sequence inc_cot;

CREATE TABLE employe(
    id  varchar(50) PRIMARY KEY default 'employe'||nextval('inc_employe'),
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email varchar(100),  
	dtn date,
	sexe varchar(50),
	adresse varchar(100),
	CIN varchar(100),
	mdp varchar(100)
);

CREATE TABLE poste(
	id varchar(50) PRIMARY KEY default 'poste'||nextval('inc_poste'),
	nom varchar(100)
);

CREATE TABLE typeContrat(
	id varchar(50) PRIMARY KEY default 'type'||nextval('inc_typecontrat'),
	designation varchar(100),
	dureeMax INTEGER
);
	
CREATE TABLE contrat(
	id varchar(50) PRIMARY KEY default 'contrat'||nextval('inc_contrat'),
	idEmploye varchar(50) references employe(id),
	idTypeContrat varchar(50) references typeContrat(id),
	debut date,
	duree INTEGER,
	idPoste varchar(50) references poste(id),
	salaireBase float,
	indemnitemax float
);
CREATE TABLE conges(
	id varchar(50) PRIMARY KEY default 'conges'||nextval('inc_conges'),
	type varchar(100),
	label varchar(100)
);

CREATE TABLE avance(
	id varchar(50) PRIMARY KEY default 'avance'||nextval('inc_avance'),
	idcontrat varchar(50)  references contrat(id),
	montant float,
	date date,
	etat int,
	remarque text
);

CREATE TABLE paiementSalaire(
	id varchar(50) PRIMARY KEY default 'salaire'||nextval('inc_salaire'),
	idcontrat varchar(50)  references contrat(id),
	montant float,
	indemnite float,
	modePaiement varchar(100),
	date date
);

CREATE TABLE cotisation(
	id varchar(50) PRIMARY KEY default 'cotisation'||nextval('inc_cot'),
	designation varchar(100),
	partEmploye INTEGER,
	partEntreprise INTEGER
);

CREATE TABLE irsa(
	id varchar(50) PRIMARY KEY default 'tranche'||nextval('inc_tranche'),
	min float,
	max float,
	taux float
);

CREATE TABLE historiqueConges(
	id varchar(50) PRIMARY KEY default nextval('inc_histotiq'),
	idConge varchar(50)  references conges(id),
	idEmploye varchar(50)  references employe(id),
	debut date,
	fin date,
	remarque text,
	etat INTEGER,
	dateReponse date
);
-- insert into ()values();
insert into typeContrat(designation,dureeMax)values('essaie',6);
insert into typeContrat(designation,dureeMax)values('CDD',24);
insert into typeContrat(designation,dureeMax)values('CDI',NULL);

insert into conges(type,label)values('payant','autre');
insert into conges(type,label)values('non payant','maternite');
insert into conges(type,label)values('non payant','evenement familial');
insert into conges(type,label)values('non payant','raison medical');

insert into cotisation(designation,partEmploye,partEntreprise)values('CNAPS',1,12);
insert into cotisation(designation,partEmploye,partEntreprise)values('OSTIE',1,5);

-- insert into contrat(idEmploye,idTypeContrat,debut,duree,idPoste,salaireBase)values('employe1','type1','2022-01-01',3,2,200000);
-- insert into contrat(idEmploye,idTypeContrat,debut,duree,idPoste,salaireBase)values('employe2','type2','2019-05-06',null,1,1000000);
-- insert into contrat(idEmploye,idTypeContrat,debut,duree,idPoste,salaireBase)values('employe3','type3','2021-12-06',24,2,500000);
-- insert into contrat(idEmploye,idTypeContrat,debut,duree,idPoste,salaireBase)values('employe3','type3','2021-02-02',8,2,500000);
-- insert into contrat(idEmploye,idTypeContrat,debut,duree,idPoste,salaireBase)values('employe4','type2','2020-03-06',null,2,1000000);
-- insert into contrat(idEmploye,idTypeContrat,debut,duree,idPoste,salaireBase)values('employe5','type3','2019-06-11',16,1,500000);

insert into irsa(min,max,taux)values(0,350000,0);
insert into irsa(min,max,taux)values(350000,400000,5);
insert into irsa(min,max,taux)values(400001,500000,10);
insert into irsa(min,max,taux)values(500001,600000,15);
insert into irsa(min,max,taux)values(600001,NULL,20);

insert into avance(etat)values(-1);
insert into avance(etat)values(0);
insert into avance(etat)values(1);

insert into historiqueConges(etat)values(-1);
insert into historiqueConges(etat)values(0);
insert into historiqueConges(etat)values(1);

insert into paiementSalaire(modePaiement)values('virement');
insert into paiementSalaire(modePaiement)values('especes');
insert into paiementSalaire(modePaiement)values('cheque');

create or replace view dateEmbauche as 
select idEmploye as idEmploye, debut as debut from contrat where idTypeContrat not like 'type1' ;

create or replace view ListEmploye as (
select e.nom, e.prenom, p.nom as poste ,t.designation as designation, de.debut as dateEmbauche , e.CIN as matricule from employe as e
join contrat c on e.id=c.id
join poste p on p.id=c.idPoste
join typeContrat t on t.id=c.idTypeContrat
join dateEmbauche de on de.idEmploye=e.id
);

create or replace view montantSalaireNet as (
select (c.salaireBase-(c.salaireBase*(select sum(partEmploye) from cotisation)))-a.montant as salairefinal from contrat as c
left join avance a on c.id=a.idcontrat
);


-- select e.*,c.debut as debutContrat ,c.duree as dureeContrat,
-- t.designation as typeContrat,p.nom as poste from employe as e 
-- join contrat c on e.id=c.idEmploye 
-- join typeContrat t on t.id=c.idTypeContrat
-- join poste p on p.id=c.idPoste); 
