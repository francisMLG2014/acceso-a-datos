use bdanimes;

   
 create table animes(
	id integer primary key,
    titulo varchar(200),
    titulo_japones varchar(200) not null,
    en_emision boolean not null
    );
    
create table temporadas(
	id integer primary key,
    numero_temporada integer not null,
    titulo varchar(200),
    titulo_japones varchar(200) not null,
    id_anime integer,
    capitulos integer,
    constraint temporada_anime_fk foreign key (id_anime) references animes(id) on delete cascade,
    constraint numero_temporada_id_unique unique(id,numero_temporada)
    );
    
