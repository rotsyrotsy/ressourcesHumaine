CREATE ROLE izahay LOGIN PASSWORD '1234';
create database ressourceH;

alter database ressourceH owner to izahay;

-- drop table contrat cascade;
-- drop table typeContrat cascade;
-- drop table employe cascade;
-- drop table poste cascade;

-- drop sequence inc_employe;
-- drop sequence inc_poste;
-- drop sequence inc_typecontrat;
-- drop sequence inc_contrat

-- drop view contratEmploye;

\connect ressourceH;
CREATE sequence inc_employe;
CREATE sequence inc_poste;
CREATE sequence inc_typecontrat;
CREATE sequence inc_contrat;

CREATE TABLE employe(
    id  varchar(10) PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email varchar(100),  
	dtn date,
	sexe varchar(10),
	adresse varchar(100),
	CIN varchar(100),
	mdp varchar(100)
);

CREATE TABLE poste(
	id varchar(10) PRIMARY KEY,
	nom varchar(100)
);

CREATE TABLE typeContrat(
	id varchar(10) PRIMARY KEY,
	designation varchar(100),
	dureeMax INTEGER
);
	
CREATE TABLE contrat(
	id varchar(10),
	idEmploye varchar(10),
	idTypeContrat varchar(10),
	debut date,
	duree int,
	idPoste varchar(10),
	FOREIGN KEY(idEmploye) references employe(id),
	FOREIGN KEY(idTypeContrat)references typeContrat(id),
	FOREIGN KEY(idPoste)references poste(id)
);

insert into contrat(id,idEmploye,idTypeContrat,debut,duree,idPoste)values(1,1,1,'2022-01-01',3,2);
insert into contrat(id,idEmploye,idTypeContrat,debut,duree,idPoste)values(2,2,2,'2019-05-06',null,1);
insert into contrat(id,idEmploye,idTypeContrat,debut,duree,idPoste)values(6,3,3,'2021-12-06',24,2);
insert into contrat(id,idEmploye,idTypeContrat,debut,duree,idPoste)values(3,3,3,'2021-02-02',8,2);
insert into contrat(id,idEmploye,idTypeContrat,debut,duree,idPoste)values(4,4,2,'2020-03-06',null,2);
insert into contrat(id,idEmploye,idTypeContrat,debut,duree,idPoste)values(5,5,3,'2019-06-11',16,1);

create view contratEmploye as (
select e.*,c.debut as debutContrat ,c.duree as dureeContrat,t.designation as typeContrat,p.nom as poste from employe as e 
join contrat c on e.id=c.idEmploye 
join typeContrat t on t.id=c.idTypeContrat
join poste p on p.id=c.idPoste); 
