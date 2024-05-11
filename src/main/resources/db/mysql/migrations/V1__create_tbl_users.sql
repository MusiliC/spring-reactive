create table if not exists tbl_users(
user_id int not null auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
username varchar(50) not null,
primary key (user_id)
)