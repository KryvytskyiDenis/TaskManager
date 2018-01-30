DROP TABLE IF EXISTS user_account;
CREATE TABLE user_account(
	id serial PRIMARY KEY,
	username varchar(100) not null UNIQUE,
	password varchar(100) not null,
);

DROP TABLE IF EXISTS task;
CREATE TABLE task(
	id serial PRIMARY KEY,
	task_name varchar(100) not null,
	decription varchar(1000) not null,
	date_created timestamp not null,
	user_id int not null references user_account(id)
);