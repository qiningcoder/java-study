CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t(a, b) values(1,1), (2,2);
select * from t;

replace into t (id, a, b) values(1, 2, 2);
replace into t (a, b) values(4, 4);
replace into t (a, b) values(4, 5);


insert into t(a, b) values(10,10), (20,20);

insert into t (a, b) VALUES (11, 11) on duplicate key update b = 11;
insert into t (a, b) VALUES (11, 12) on duplicate key update b = 12;
