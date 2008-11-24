CREATE TABLE NineBallMatch (
  	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	player1Id int(3) NOT NULL,
	player1Rank int(1) NOT NULL,
	player2Id int(3) NOT NULL,
	player2Rank int(1) NOT NULL,
	`date` datetime NOT NULL
);

CREATE TABLE NineBallRack (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nineBallMatchId int(10) NOT NULL,
	player1Score int(2) NOT NULL,
	innings int(2) NOT NULL,
	deadBalls int (2) NOT NULL,
	player2Score int(2) NOT NULL
);

CREATE TABLE Player (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	firstName varchar(255),
	lastName varchar(255),
	apaId integer(10) NOT NULL
);
