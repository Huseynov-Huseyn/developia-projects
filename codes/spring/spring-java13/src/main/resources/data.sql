insert into users
(username,password,enabled)
values
('Huseynov','{noop}123456','1');

insert into authorities
(username,authority)
values
('Huseynov','ROLE_ADD_STUDENT'),
('Huseynov','ROLE_UPDATE_STUDENT'),
('Huseynov','ROLE_DELETE_STUDENT'),
('Huseynov','ROLE_GET_STUDENT');

insert into students
(name,surname,username)
values
('Ferid','Abaszade','Ferid1905');

insert into users
(username,password,enabled)
values
('Ferid1905','{noop}123456','1');

insert into authorities
(username,authority)
values
('Ferid1905','ROLE_UPDATE_ME');