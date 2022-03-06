CREATE ROLE izahay LOGIN PASSWORD '1234';
create database ressourceH;

alter database ressourceH owner to izahay;


\connect ressourceH;

CREATE TABLE employe(
    id  varchar(10) PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email varchar(100),
	dtn date,
	sexe varchar(10),
	adresse varchar(100)
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
	FOREIGN KEY(idEmploye) references employ(id),
	FOREIGN KEY(idTypeContrat)references typeContrat(id),
	FOREIGN KEY(idPoste)references poste(id)
);