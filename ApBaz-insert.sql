INSERT INTO miasto(nazwa) VALUES ('Gdansk');
INSERT INTO miasto(nazwa) VALUES ('Krakow');
INSERT INTO miasto(nazwa) VALUES ('Lodz');
INSERT INTO miasto(nazwa) VALUES ('Koscierzyna');
INSERT INTO miasto(nazwa) VALUES ('Wroclaw');
INSERT INTO miasto(nazwa) VALUES ('Poznan');
go


INSERT INTO klient(imie,nazwisko, id_miasto) VALUES ( 'Marek', 'Markowski', 1);
INSERT INTO klient(imie,nazwisko, id_miasto) VALUES ( 'Adam', 'Adamczyk', 2  );
INSERT INTO klient(imie,nazwisko, id_miasto) VALUES ( 'Bartek', 'Bartkowski', 3 );
INSERT INTO klient(imie,nazwisko, id_miasto) VALUES ( 'Mirek', 'Mirkowski', 4 );
INSERT INTO klient(imie,nazwisko, id_miasto) VALUES ( 'Stas', 'Stasiowski', 5 );
INSERT INTO klient(imie,nazwisko, id_miasto) VALUES ( 'Pawel', 'Pawelczyk', 3 );
INSERT INTO klient(imie,nazwisko, id_miasto) VALUES ( 'Michal', 'Michalak', 2 );
INSERT INTO klient(imie,nazwisko, id_miasto) VALUES ( 'Jan', 'Jankowski', 5 );
INSERT INTO klient(imie,nazwisko, id_miasto) VALUES ( 'Maciej', 'Maciejowski', 6 );
INSERT INTO klient(imie,nazwisko, id_miasto) VALUES ( 'Tomasz', 'Tomaszowski', 6 );
INSERT INTO klient(imie,nazwisko, id_miasto) VALUES ( 'Kacper', 'Kacperowski', 2 );
INSERT INTO klient(imie,nazwisko, id_miasto) VALUES ( 'Damian', 'Damianski', 4 );


INSERT INTO adres( kod, ulica, nr_domu) VALUES ('53-565', 'Poznanska', 15);
INSERT INTO adres( kod, ulica, nr_domu) VALUES ('52-660', 'Betonowa', 16);
INSERT INTO adres( kod, ulica, nr_domu) VALUES ('53-585', 'Poznanska', 17);
INSERT INTO adres( kod, ulica, nr_domu) VALUES ('80-505', 'Poznanska', 18);
INSERT INTO adres( kod, ulica, nr_domu) VALUES ('53-235', 'Mickiewicza', 19);
INSERT INTO adres( kod, ulica, nr_domu) VALUES ('53-565', 'Poznanska', 20);
INSERT INTO adres( kod, ulica, nr_domu) VALUES ('53-565', 'Radomska', 14);
INSERT INTO adres( kod, ulica, nr_domu) VALUES ('12-465', 'Drewniana', 13);
INSERT INTO adres( kod, ulica, nr_domu) VALUES ('53-265', 'Poznanska', 12);
INSERT INTO adres( kod, ulica, nr_domu) VALUES ('83-365', 'Rozana', 11);
INSERT INTO adres( kod, ulica, nr_domu) VALUES ('73-165', 'Kolorowa', 10);
INSERT INTO adres( kod, ulica, nr_domu) VALUES ('53-565', 'Wroclawska', 10);


INSERT INTO lekarz( imie, nazwisko, specjalizacja) VALUES ('Lekarz1', 'Nazw1', 'dermatolog');
INSERT INTO lekarz( imie, nazwisko, specjalizacja) VALUES ('Lekarz2', 'Nazw2', 'dermatolog');
INSERT INTO lekarz( imie, nazwisko, specjalizacja) VALUES ('Lekarz3', 'Nazw3', 'endokrynolog');
INSERT INTO lekarz( imie, nazwisko, specjalizacja) VALUES ('Lekarz4', 'Nazw4', 'endokrynolog');
INSERT INTO lekarz( imie, nazwisko, specjalizacja) VALUES ('Lekarz5', 'Nazw5', 'okulista');
INSERT INTO lekarz( imie, nazwisko, specjalizacja) VALUES ('Lekarz6', 'Nazw6', 'pediatra');
INSERT INTO lekarz( imie, nazwisko, specjalizacja) VALUES ('Lekarz7', 'Nazw7', 'lekarz rodzinny');
INSERT INTO lekarz( imie, nazwisko, specjalizacja) VALUES ('Lekarz8', 'Nazw8', 'lekarz rodzinny');


INSERT INTO recepta(tresc, id_lekarza) VALUES ('tresc', 1);
INSERT INTO recepta(tresc, id_lekarza) VALUES ('tresc', 5);
INSERT INTO recepta(tresc, id_lekarza) VALUES ('tresc', 3);
INSERT INTO recepta(tresc, id_lekarza) VALUES ('tresc', 1);
INSERT INTO recepta(tresc, id_lekarza) VALUES ('tresc', 6);
INSERT INTO recepta(tresc, id_lekarza) VALUES ('tresc', 2);
INSERT INTO recepta(tresc, id_lekarza) VALUES ('tresc', 1);


INSERT INTO zwolnienie(tresc, od_kiedy, do_kiedy, id_lekarza) VALUES ('tresc', '2006-06-06', '2006-06-20', 2);
INSERT INTO zwolnienie(tresc, od_kiedy, do_kiedy, id_lekarza) VALUES ('tresc', '2006-06-06', '2006-06-15', 3);
INSERT INTO zwolnienie(tresc, od_kiedy, do_kiedy, id_lekarza) VALUES ('tresc', '2006-06-06', '2006-06-10', 5);
INSERT INTO zwolnienie(tresc, od_kiedy, do_kiedy, id_lekarza) VALUES ('tresc', '2006-06-06', '2006-06-12', 1);
INSERT INTO zwolnienie(tresc, od_kiedy, do_kiedy, id_lekarza) VALUES ('tresc', '2006-06-06', '2006-06-13', 2);



INSERT INTO skierowanie(tresc, id_lekarza) VALUES ('tresc', 8);
INSERT INTO skierowanie(tresc, id_lekarza) VALUES ('tresc', 7);


INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20060606 09:30:00 AM', 1, 1);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20060608 09:30:00 AM', 1, 2);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20060609 10:30:00 AM', 1, 3);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20060611 09:30:00 AM', 2, 1);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20060613 09:30:00 AM', 3, 8);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20060615 09:30:00 AM', 4, 2);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20060616 01:30:00 PM', 5, 6);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20060606 09:30:00 AM', 6, 8);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20090617 09:30:00 AM', 7, 2);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20190415 06:30:00 PM', 8, 5);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20060619 09:30:00 AM', 9, 4);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20060606 10:30:00 AM', 11, 3);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20060620 09:30:00 AM', 12, 8);
INSERT INTO rejestracja ( data_rejestracji, id_klient, id_lekarz ) VALUES ( '20060624 10:30:00 AM', 12, 7);


INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 10,  1);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 5,  2);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 1, 3);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 3, 4);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 24,  5);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 24, 6);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 10, 7);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 5, 8);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 8,  9);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 2, 10);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 7, 11);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 7, 12);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 15, 13);
INSERT INTO wizyta ( nr_pokoju, id_rejestracja) VALUES ( 10, 14);
go



INSERT INTO sprzet ( nazwa, ilosc, opis, nr_pokoju)
VALUES
('stetoskop', 3, 'lakierowany stetoskop firmy Lekax', 1),
('stetoskop', 2, 'lakierowany stetoskop firmy Lekax', 2),
('stetoskop', 1, 'lakierowany stetoskop firmy Lekax', 4),
('stetoskop', 1, 'lakierowany stetoskop firmy Lekax', 10),
('waga elektroniczna', 2, 'czarna waga firmy Wagex', 5),
('waga elektroniczna', 1, 'czarna waga firmy Wagex', 1),
('waga elektroniczna', 1, 'czarna waga firmy Wagex', 2),
('strzykawka bioniczna', 1, 'laminowana skrzykawka firmy Strzyx', 5),
('strzykawka bioniczna', 1, 'laminowana skrzykawka firmy Strzyx', 10),
('strzykawka bioniczna', 1, 'laminowana skrzykawka firmy Strzyx', 1),
('strzykawka bioniczna', 1, 'laminowana skrzykawka firmy Strzyx', 2)
go


INSERT INTO administrator VALUES ('admin', 'qaz123')
go


INSERT INTO uzytkownik VALUES ('user1', 'wsx123');
INSERT INTO uzytkownik VALUES ('user2', 'wsx234');
INSERT INTO uzytkownik VALUES ('user3', 'wsx345');
INSERT INTO uzytkownik VALUES ('user4', 'wsx456');
INSERT INTO uzytkownik VALUES ('user5', 'wsx567');
INSERT INTO uzytkownik VALUES ('user6', 'wsx678');




insert into logs values( 'user3', getdate(), 5);