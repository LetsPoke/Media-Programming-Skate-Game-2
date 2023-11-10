-- MariaDB structure definition script for schema "skat"
-- best import using MariaDB client command "source <path to this file>"

SET CHARACTER SET utf8mb4;
DROP DATABASE IF EXISTS skat;
CREATE DATABASE skat CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE skat;

-- define tables, sequences, indices, etc.
CREATE TABLE BaseEntity (
	identity BIGINT NOT NULL AUTO_INCREMENT,
	discriminator ENUM("Document", "Person", "SkatTable", "Card", "GameType", "Game", "Hand", "NetworkNegotiation") NOT NULL,
	version INTEGER NOT NULL DEFAULT 1,
	created BIGINT NOT NULL,
	modified BIGINT NOT NULL,
	PRIMARY KEY (identity),
	KEY (discriminator)
);

CREATE TABLE Document (
	documentIdentity BIGINT NOT NULL,
	content LONGBLOB NOT NULL,
	hash CHAR(64) NOT NULL,
	type VARCHAR(63) NOT NULL,
	PRIMARY KEY (documentIdentity),
	FOREIGN KEY (documentIdentity) REFERENCES BaseEntity (identity) ON DELETE CASCADE ON UPDATE CASCADE,
	UNIQUE KEY (hash)
);

CREATE TABLE SkatTable (
	tableIdentity BIGINT NOT NULL,
	avatarReference BIGINT NOT NULL,
	alias CHAR(32) NOT NULL,
	baseValuation BIGINT NOT NULL,
	PRIMARY KEY (tableIdentity),
	FOREIGN KEY (tableIdentity) REFERENCES BaseEntity (identity) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (avatarReference) REFERENCES Document (documentIdentity) ON DELETE RESTRICT ON UPDATE CASCADE,
	UNIQUE KEY (alias)
);

CREATE TABLE Person (
	personIdentity BIGINT NOT NULL,
	avatarReference BIGINT NOT NULL,
	tableReference BIGINT NULL,
	tablePosition TINYINT NULL,
	email CHAR(128) NOT NULL,
	passwordHash CHAR(64) NOT NULL,
	groupAlias ENUM("USER", "ADMIN") NOT NULL,
	balance BIGINT NOT NULL,
	title VARCHAR(15) NULL,
	surname VARCHAR(31) NOT NULL,
	forename VARCHAR(31) NOT NULL,
	street VARCHAR(63) NOT NULL,
	postcode VARCHAR(15) NOT NULL,
	city VARCHAR(63) NOT NULL,
	country VARCHAR(63) NOT NULL,
	PRIMARY KEY (personIdentity),
	FOREIGN KEY (personIdentity) REFERENCES BaseEntity (identity) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (avatarReference) REFERENCES Document (documentIdentity) ON DELETE RESTRICT ON UPDATE CASCADE,
	FOREIGN KEY (tableReference) REFERENCES SkatTable (tableIdentity) ON DELETE RESTRICT ON UPDATE CASCADE,
	UNIQUE KEY (email),
	UNIQUE KEY (tableReference, tablePosition)
);

CREATE TABLE Card (
	cardIdentity BIGINT NOT NULL,
	suit ENUM("DIAMONDS", "HEARTS", "SPADES", "CLUBS") NOT NULL,
	rank ENUM("SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE") NOT NULL,
	PRIMARY KEY (cardIdentity),
	FOREIGN KEY (cardIdentity) REFERENCES BaseEntity (identity) ON DELETE CASCADE ON UPDATE CASCADE,
	UNIQUE KEY (suit, rank)
);

CREATE TABLE GameType (
	gameTypeIdentity BIGINT NOT NULL,
	variety ENUM("PASS", "SUIT", "NULL") NOT NULL,
	suit ENUM("DIAMONDS", "HEARTS", "SPADES", "CLUBS") NULL,
	value TINYINT NOT NULL,
	PRIMARY KEY (gameTypeIdentity),
	FOREIGN KEY (gameTypeIdentity) REFERENCES BaseEntity (identity) ON DELETE CASCADE ON UPDATE CASCADE,
	UNIQUE KEY (variety, suit)
);

CREATE TABLE Game (
	gameIdentity BIGINT NOT NULL,
	gameTypeReference BIGINT NULL,
	tableReference BIGINT NOT NULL,
	modifier ENUM("HAND", "POOR", "BROKE", "OUVERT") NULL,
	state ENUM("DEAL", "NEGOTIATE", "ACTIVE", "DONE") NOT NULL,
	leftTrickCardReference BIGINT NULL,
	middleTrickCardReference BIGINT NULL,
	rightTrickCardReference BIGINT NULL,
	PRIMARY KEY (gameIdentity),
	FOREIGN KEY (gameIdentity) REFERENCES BaseEntity (identity) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (gameTypeReference) REFERENCES GameType (gameTypeIdentity) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (tableReference) REFERENCES SkatTable (tableIdentity) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (leftTrickCardReference) REFERENCES Card (cardIdentity) ON DELETE SET NULL ON UPDATE CASCADE,
	FOREIGN KEY (middleTrickCardReference) REFERENCES Card (cardIdentity) ON DELETE SET NULL ON UPDATE CASCADE,
	FOREIGN KEY (rightTrickCardReference) REFERENCES Card (cardIdentity) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE Hand (
	handIdentity BIGINT NOT NULL,
	gameReference BIGINT NOT NULL,
	playerReference BIGINT NULL,
	bid SMALLINT NULL,
	solo BOOL NOT NULL,
	points SMALLINT NOT NULL,
	PRIMARY KEY (handIdentity),
	FOREIGN KEY (handIdentity) REFERENCES BaseEntity (identity) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (gameReference) REFERENCES Game (gameIdentity) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (playerReference) REFERENCES Person (personIdentity) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE NetworkNegotiation (
	negotiationIdentity BIGINT NOT NULL,
	negotiatorReference BIGINT NOT NULL,
	type ENUM("WEB_RTC") NOT NULL,
	offer VARCHAR(2046) NOT NULL,
	answer VARCHAR(2046) NULL,
	PRIMARY KEY (negotiationIdentity),
	FOREIGN KEY (negotiationIdentity) REFERENCES BaseEntity (identity) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (negotiatorReference) REFERENCES Person (personIdentity) ON DELETE CASCADE ON UPDATE CASCADE,
	KEY (type),
	KEY (offer),
	KEY (answer)
);

CREATE TABLE PersonPhoneAssociation (
	personReference BIGINT NOT NULL,
	phone CHAR(16) NOT NULL,
	PRIMARY KEY (personReference, phone),
	FOREIGN KEY (personReference) REFERENCES Person (personIdentity) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE HandCardAssociation (
	handReference BIGINT NOT NULL,
	cardReference BIGINT NOT NULL,
	PRIMARY KEY (handReference, cardReference),
	FOREIGN KEY (handReference) REFERENCES Hand (handIdentity) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (cardReference) REFERENCES Card (cardIdentity) ON DELETE CASCADE ON UPDATE CASCADE
);
