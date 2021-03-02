CREATE TABLE Persona (
	nome VARCHAR(20) NOT NULL,
	cognome VARCHAR(20) NOT NULL,
	codice_fiscale VARCHAR(16) PRIMARY KEY,
	data_nascita DATE NOT NULL,
	numero_telefono VARCHAR(10)
);


CREATE TABLE Utente (
	persona_fk VARCHAR(10) REFERENCES Persona(codice_fiscale) PRIMARY KEY,
	mail VARCHAR(255) NOT NULL,
	password VARCHAR(32) NOT NULL,	/* Cifrata in MD5 */
	nickname VARCHAR(30) NOT NULL UNIQUE,
	data_registrazione DATE NOT NULL
);
ALTER TABLE Utente
ADD CONSTRAINT Check_Mail CHECK(mail LIKE "%@%.__" OR "%@%.___");


CREATE TABLE Qualifica (
	grado VARCHAR(20) NOT NULL UNIQUE,
	id SMALLINT PRIMARY KEY
);


CREATE TABLE Gruppo (
	nome VARCHAR(30) NOT NULL,
	data_creazione DATE NOT NULL,
	id INT PRIMARY KEY
);


CREATE TABLE Materia (
	gruppo_fk INT REFERENCES Gruppo(id) NOT NULL,
	nome VARCHAR(20) NOT NULL,

	PRIMARY KEY (gruppo_fk, nome)
);


CREATE TABLE File (
	nome VARCHAR(255) NOT NULL,
	data MEDIUMBLOB NOT NULL,
	data_caricamento DATE NOT NULL,
	autore_fk VARCHAR(16) REFERENCES Utente(persona_fk) NOT NULL,
	id INT PRIMARY KEY
);


CREATE TABLE Appunto (
	file_fk INT REFERENCES File(id) NOT NULL,
	data_caricamento DATE NOT NULL,

	gruppo_fk INT REFERENCES Materia(gruppo_fk) NOT NULL,
	nome_materia VARCHAR(20) REFERENCES Materia(nome) NOT NULL,

	PRIMARY KEY (gruppo_fk, nome_materia, file_fk)
);

