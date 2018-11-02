
insert into member_role (id , name) values (1, 'USER');
insert into member_role (id , name) values (2, 'ADMIN');


insert into member(id, name, email, password, regdate)
values(1, 'yeom', 'jiwony@kr.ibm.com', '{bcrypt}$2a$10$zyizvHyF1YNx5Zu9/lT8k.7LnuLD9S.7iPKini544opSmhSlKIQ9m', now());

insert into member(id, name, email, password, regdate)
values(2, 'yoon', 'yo0230@gmail.com', '{bcrypt}$2a$10$FifMTL6Glj2LjEqf/..Jvek4ZybiE/sXwVyfEysY7b3RjXlKuPyZu', now());

insert into member_member_role(member_id, member_role_id)
values(1, 1);

insert into member_member_role(member_id, member_role_id)
values(1, 2);

insert into member_member_role(member_id, member_role_id)
values(2, 1);
