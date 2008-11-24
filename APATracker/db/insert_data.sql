insert into Player (id, firstName, lastName, apaId)
values('1','Adam','Kawula',8371)

insert into Player (id, firstName, lastName, apaId)
values('2','Lori','Jonakin',2841)

insert into NineBallMatch (id, player1Id, player1Rank, player2Id, player2Rank, date)
values (1,1,4,2,5,'2008-11-24 14:26:28')

insert into NineBallRack (id, nineBallMatchId, player1Score, innings, deadBalls, player2Score)
values (1,1,5,2,0,5)

insert into NineBallRack (id, nineBallMatchId, player1Score, innings, deadBalls, player2Score)
values (2,1,5,1,2,13)