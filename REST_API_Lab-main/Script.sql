create database studentdb;
use studentdb;

-- Insert into Student table
insert into students(first_name,last_name,course,country)values('Suresh','Reddy','B.Tech','India'),
															   ('Murali','Mohan','B.Arch','Canada'),
                                                               ('Daniel','Denson','B.Tech','NewZealand');
                                                               
-- Insert into Roles table
insert into roles (name) values ('NORMAL_USER');
insert into roles (name) values ('ADMIN_USER');

-- Insert into User table (1. Abc, password:Abc123)(2.Xyz, password:Xyz123)

insert into users (username, password) values ('Abc','$2a$12$IA9fD3yTWtquCip.DVOBQ.dLCmQII/P4vkJDBe.1XpFV6eO/KTHHe'),
											  ('Xyz','$2a$12$QUOZgUAl8ADIDJlabDlqk.gf0l/s87/hIKCSv.tIce..vH55NZufe');
                                              
 -- Insert into user_roles(1.Abc --Normal User, 2.Xyz-- Admin User)
 
 insert into users_roles(user_id,role_id) values('1','1'),
												('2','2');
                                                
                                                
						