insert into Hop (id,alpha,application,aroma_bitter,category,country,description,name,storage) values(1,8.5,'English ales, especially dark strong, highly hopped ones.  Sometimes used for aroma in ales.', 'Mostly bittering, some aroma',1,'England, (Origin) U.S.','English flavor.  Pungent, heavy, very bitter.  Can be overpowering as aromatic','Brewer''s Gold', 'Poor');
insert into Hop (id,alpha,application,aroma_bitter,category,country,description,name,storage) values(2,8.5,'English ales, especially dark strong, highly hopped ones.  Sometimes used for aroma in ales.', 'Mostly bittering, some aroma',1,'England, (Origin) U.S.','English flavor.  Pungent, heavy, very bitter.  Can be overpowering as aromatic','Bullion', 'Poor');
insert into Hop (id,alpha,application,aroma_bitter,category,country,description,name,storage) values(3,5.75,'American ales and otehr distinctly Anerican beers.  Inappropiate in German or British styles.','Aroma, rarely bittering',2,'U.S., Canada','Unique aroma--floral, minty, herbal, spicy.  Gives American or Canadian flavor to lagers.','Cascade', 'Poor');
insert into Hop (id,alpha,application,aroma_bitter,category,country,description,name,storage) values(4,7.5,'English style Ale, Porter, Stout, ESB, Bitter, Barley Wine, Brown Ales','One of the few recognized dual-purpose hops combining moderate amounts of alpha acids with a good kettle hop aroma',3,'England','A granddaughter of Northern Brewer bred in England with German downy mildew resistant males.','Challenger','Good');
insert into Hop (id,alpha,application,aroma_bitter,category,country,description,name,storage) values(5,4.25,'Aroma for all types of English ales, especially paler ones.','Bittering and Aroma',4,'England','Clean, spicy, British flavor "black currant" tasts.  Classic English hop.','Golding','Poor');
insert into Hop (id,alpha,application,aroma_bitter,category,country,description,name,storage) values(6,5,'Classic English hop for bittering and aroma in English ales, especially dark ones.','Aroma and bittering',5,'England','Mild spicy.  Recognizable English taste.','Fuggles','Fair');

insert into HopIngredient (id,boilTime,pelletLeaf,quantity,hop_id) values(1,60,'pellet',1,4);
insert into HopIngredient (id,boilTime,pelletLeaf,quantity,hop_id) values(2,15,'pellet',1,5);
insert into HopIngredient (id,boilTime,pelletLeaf,quantity,hop_id) values(3,5,'pellet',1,6);

insert into Barley(id, variety) values (1,'Maris Otter Pale Malt');
insert into Barley(id, variety) values (2,'Honey Malt');
insert into Barley(id, variety) values (3,'Carapils');

insert into BarleyIngredient(id,quantity,barley_id) values (1,8,1);
insert into BarleyIngredient(id,quantity,barley_id) values (2,.5,2);
insert into BarleyIngredient(id,quantity,barley_id) values (3,.5,3);

insert into Additive(id,name) values (1, 'Honey');

insert into AdditiveIngredient (id, quantity,additive_id) values (1,2,1);

insert into Yeast(id,brand,category,name) values (1,'Wyeast',1,'London ESB 1968');
insert into Yeast(id,brand,category,name) values (2,'White Labs',1,'English Ale 002');
insert into Yeast(id,brand,category,name) values (3,'Dry Yeast',1,'Muntons Premium Gold');

insert into YeastIngredient(id,quantity,yeast_id) values (1,1,1);

insert into Recipe (id,finalGravity,initialGravity,name,style) values (1,1.015,1.062,'AHS English Honey Better - All Grain','BITTER');

insert into Recipe_AdditiveIngredient (Recipe_id,additives_id) values (1,1);

insert into Recipe_BarleyIngredient (Recipe_id,barlies_id) values (1,1);
insert into Recipe_BarleyIngredient (Recipe_id,barlies_id) values (1,2);
insert into Recipe_BarleyIngredient (Recipe_id,barlies_id) values (1,3);

insert into Recipe_HopIngredient (Recipe_id, hops_id) values (1,1);
insert into Recipe_HopIngredient (Recipe_id, hops_id) values (1,2);
insert into Recipe_HopIngredient (Recipe_id, hops_id) values (1,3);

insert into Recipe_YeastIngredient (Recipe_id, yeasts_id) values(1,1);

