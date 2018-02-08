USE librarydb;
create table authors
(
  id bigint auto_increment
    primary key,
  all_names varchar(30) null,
  first_name varchar(30) not null,
  last_name varchar(30) not null,
  sex int not null,
  country_id bigint not null
)
  engine=InnoDB
;

create index FKln690lik2kyd7hatb4ndtwtdx
  on authors (country_id)
;

create table books
(
  id bigint auto_increment
    primary key,
  format int not null,
  title varchar(254) not null,
  publisher_id bigint null,
  publishing_year smallint(6) not null,
  number_of_pages int null
)
  engine=InnoDB
;

create index FKayy5edfrqnegqj3882nce6qo8
  on books (publisher_id)
;

create table books_authors_list
(
  books_list_id bigint not null,
  authors_list_id bigint not null,
  constraint FK99xnm55aoo0souwvy2g4g8lrl
  foreign key (books_list_id) references books (id),
  constraint FKis3w9sjn4qaas5fpqanqdcwr6
  foreign key (authors_list_id) references authors (id)
)
  engine=InnoDB
;

create index FK99xnm55aoo0souwvy2g4g8lrl
  on books_authors_list (books_list_id)
;

create index FKis3w9sjn4qaas5fpqanqdcwr6
  on books_authors_list (authors_list_id)
;

create table countries
(
  id bigint auto_increment
    primary key,
  country_name varchar(254) not null,
  constraint UK_lx3r8cp4g7xkaqximbtxum74r
  unique (country_name)
)
  engine=InnoDB
;

alter table authors
  add constraint FKln690lik2kyd7hatb4ndtwtdx
foreign key (country_id) references countries (id)
;

create table publishers
(
  id bigint auto_increment
    primary key,
  publisher_name varchar(254) not null,
  constraint UK_86rbulstali2f0pdguulfyn40
  unique (publisher_name)
)
  engine=InnoDB
;

alter table books
  add constraint FKayy5edfrqnegqj3882nce6qo8
foreign key (publisher_id) references publishers (id)
;