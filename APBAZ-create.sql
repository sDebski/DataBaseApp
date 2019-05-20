create table miasto 
(id_miasto int primary key identity,
nazwa varchar(50))
go


CREATE TABLE klient
(id_klient int primary key identity, 
imie VARCHAR(50) NOT NULL, 
nazwisko VARCHAR(50) NOT NULL, 
id_miasto int not null,
FOREIGN KEY(id_miasto) REFERENCES miasto(id_miasto)

)
go

CREATE TABLE adres(id_adres int primary key identity, kod VARCHAR(6), ulica VARCHAR(50), nr_domu INTEGER);


CREATE TABLE lekarz (id_lekarz int primary key identity, 
imie VARCHAR(50) NOT NULL, nazwisko VARCHAR(50) NOT NULL, 
specjalizacja VARCHAR(50) NOT NULL);


CREATE TABLE recepta(id_recepta int primary key identity, 
tresc VARCHAR(250), 
id_lekarza int NOT NULL,
FOREIGN KEY (id_lekarza) REFERENCES lekarz(id_lekarz)
);



CREATE TABLE zwolnienie(id_zwolnienie int primary key identity, 
tresc VARCHAR(250), 
od_kiedy DATE, 
do_kiedy DATE, 
id_lekarza int NOT NULL,
FOREIGN KEY(id_lekarza) REFERENCES lekarz(id_lekarz));


CREATE TABLE skierowanie(id_skierowanie int primary key identity,
 tresc VARCHAR(250),
 id_lekarza INTEGER NOT NULL,
 FOREIGN KEY(id_lekarza) REFERENCES lekarz(id_lekarz)
 );

 CREATE TABLE rejestracja( id_rejestracja int primary key identity, 
data_rejestracji DATETIME, 
czy_modyfikowane VARCHAR(3) DEFAULT 'nie', 
id_klient int NOT NULL,
id_lekarz int not null, 
FOREIGN KEY (id_klient) REFERENCES klient(id_klient),
FOREIGN KEY (id_lekarz) REFERENCES lekarz(id_lekarz)
);


CREATE TABLE wizyta ( 
id_wizyta int primary key identity, 
nr_pokoju INTEGER, 
id_rejestracja INT NOT NULL,
FOREIGN KEY (id_rejestracja) REFERENCES rejestracja(id_rejestracja)
);


CREATE TABLE sprzet
(id_sprzet int primary key identity,
nazwa VARCHAR(50) NOT NULL, 
ilosc int NOT NULL, 
opis VARCHAR(50) NOT NULL, 
nr_pokoju int not null,
)
go

CREATE TABLE administrator
(id_administrator int primary key identity,
login VARCHAR(50) NOT NULL, 
haslo VARCHAR(50) NOT NULL
)
go


CREATE TABLE uzytkownik
(id_uzytkownik int primary key identity,
login VARCHAR(50) NOT NULL, 
haslo VARCHAR(50) NOT NULL
)
go


CREATE TABLE logs
(id_logs int primary key identity,
nazwa_uzytkownika VARCHAR(50) NOT NULL, 
data_logowania datetime,
uzytkownik_id int,
FOREIGN KEY (uzytkownik_id) REFERENCES uzytkownik(id_uzytkownik)
)
go



CREATE TABLE uzytkownicy_zmiany
(id_uzytkownicy_zmiany int primary key identity,
 login VARCHAR(50) NOT NULL,
zmiana VARCHAR(50) NOT NULL, 
)
go

--select * from uzytkownicy_zmiany