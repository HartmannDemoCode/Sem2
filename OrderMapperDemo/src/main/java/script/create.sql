use test;
create table orders(
  ono int primary key auto_increment,
  cno int,
  empno int,
  received timestamp default now(),
  shipped timestamp
);

create table products(
  pno int primary key auto_increment,
  pname varchar(30),
  price double,
  descr varchar(50)
);

create table odetails(
  ono int,
  pno int,
  qty int,
  primary key(ono, pno),
  foreign key (ono) references orders(ono),
  foreign key (pno) references products(pno)
);

insert into products (pname, price, descr) values 
('knife', 2.45,'Sharp and efficient')
, ('spoon', 3.25,'Round and pleasant')
, ('fork', 1.15,'Pointy and pokey')
, ('plate', 0.35,'Smooth and Sturdy')
, ('glass', 0.65,'Transparent and tall')
, ('pot', 2.95,'Solid and hot');

insert into orders (cno, empno) values 
(1, 2)
,(2,2)
,(3,2)
,(4,1)
,(1,1);

insert into odetails (ono, pno, qty) values (1,5,3),(1,4,2),(1,1,5),(2,5,8),(2, 4,2), (2,2,1);

select ord.ono, cno, empno, ord.received, ord.shipped, pr.pno, pr.pname, od.qty, pr.descr, pr.price from orders ord, products pr, odetails od where od.pno = pr.pno and od.ono = ord.ono;


select * from orders;