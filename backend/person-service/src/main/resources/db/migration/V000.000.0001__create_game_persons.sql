create schema person;


-- создание сторон(свет,тьма)
create table person.side
(
    id          bigserial
        constraint game_side_pk
            primary key,
    name_side   varchar(4) not null,
    description varchar(150)
);

comment on column person.side.name_side is 'Название стороны';

comment on column person.side.description is 'Описание стороны';

create unique index side_id_uindex
    on person.side (id);

create unique index side_name_side_uindex
    on person.side (name_side);

-- создание классов песоонажей
create table person.classes_creature
(
    id            bigserial
        constraint classes_creature_pk
            primary key,
    name_creature varchar(50)  not null,
    description   varchar(500) not null,
    side_id       bigint
);

comment on column person.classes_creature.name_creature is 'Имя существа';

comment on column person.classes_creature.description is 'Описание существа';

comment on column person.classes_creature.side_id is 'Внешний ключ к таблице game_side';

create unique index classes_creature_id_uindex
    on person.classes_creature (id);

create unique index classes_creature_name_creature_uindex
    on person.classes_creature (name_creature);

alter table person.classes_creature
    add constraint classes_creature_side_id_fk
        foreign key (side_id) references person.side;

-- создание типов семей
create table person.family_type
(
    id                  bigserial
        constraint family_type_pk
            primary key,
    family_name         varchar(50) not null,
    description         varchar(300),
    classes_creature_id bigint
);

comment on table person.family_type is 'Тип Семьи';

comment on column person.family_type.family_name is 'Название семьи';

comment on column person.family_type.description is 'Описание семьи';

comment on column person.family_type.classes_creature_id is 'Внешний ключ к таблице classes_creature';

create unique index family_type_id_uindex
    on person.family_type (id);

alter table person.family_type
    add constraint family_type_classes_creature_id_fk
        foreign key (classes_creature_id) references person.classes_creature;


INSERT INTO person.side (name_side, description) VALUES ('Тьма', 'lalala');
INSERT INTO person.side (name_side, description) VALUES ('Свет', 'lalala');
