create table sl_students (
    id int not null,
    name varchar(255),
    age int,
    zip_code int,
    country varchar(255),
    status_id int,
    primary key (id)
);

create table sl_status (
    id int not null,
    name varchar(255),
    title varchar(255),
    primary key (id)
);

insert into sl_status (id, name, title) values (1, 'ACTIVE', 'Ativo');
insert into sl_status (id, name, title) values (2, 'INACTIVE', 'Inativo');
insert into sl_status (id, name, title) values (3, 'REGULAR', 'Regular');

insert into sl_students (id, name, age, zip_code, country, status_id)
  values (1, 'Silvio', 50, 17100000, 'Brasil', 1);
insert into sl_students (id, name, age, zip_code, country, status_id)
  values (2, 'Kevin', 25, 17100000, 'Uk', 2);
insert into sl_students (id, name, age, zip_code, country, status_id)
  values (3, 'Eliza', 30, 17100000, 'Canada', 3);

-- INSERT INTO SL_SECTION (id, title) VALUES (1, 'Cadastro de Usuarios');
-- INSERT INTO SL_SECTION (id, title) VALUES (2, 'Cadastro de Clientes');
-- INSERT INTO SL_SECTION (id, title) VALUES (3, 'Cadastro de Fornecedores');
-- INSERT INTO SL_SECTION (id, title) VALUES (4, 'Cadastro de Funcionarios');
