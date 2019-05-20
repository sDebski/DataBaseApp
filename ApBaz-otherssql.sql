create procedure proc1
as
select klient.nazwisko as 'nazwisko', rejestracja.data_rejestracji as 'data_wizyty', lekarz.nazwisko as 'nazwisko lekarza', lekarz.specjalizacja as 'specjalizacja lekarza', wizyta.nr_pokoju as 'gabinet' 
from wizyta join rejestracja
on wizyta.id_rejestracja=rejestracja.id_rejestracja
join klient
on rejestracja.id_klient=klient.id_klient
join lekarz
on rejestracja.id_lekarz=lekarz.id_lekarz
go


select top 1 klient.nazwisko, rejestracja.data_rejestracji, lekarz.nazwisko, wizyta.nr_pokoju from rejestracja join klient on rejestracja.id_klient = klient.id_klient join lekarz on rejestracja.id_lekarz = lekarz.id_lekarz join wizyta on wizyta.id_rejestracja = rejestracja.id_rejestracja where klient.nazwisko ='Stasiowski' order by FLOOR(DATEDIFF(DAY, rejestracja.data_rejestracji, GETDATE())) asc;


select DATEFROMPARTS(YEAR(data_logowania),MONTH(data_logowania),DAY(data_logowania)), SUBSTRING(Convert(varchar,data_logowania,100),12,12)  from logs


select klient.imie, klient.nazwisko, miasto.nazwa, adres.ulica, adres.nr_domu into #tab1 from klient join miasto on klient.id_miasto = miasto.id_miasto join adres on miasto.id_miasto=adres.id_adres; select * from #tab1;



create trigger uzytkownik_insert_trigger on uzytkownik
after insert
as
begin
  declare @insertedId int
  set @insertedId=-1
  select @insertedId=id_uzytkownik from inserted
  insert into uzytkownicy_zmiany values ( @insertedId ,'dodany')
end
  go



  create trigger uzytkownik_delete_trigger on uzytkownik
after delete
as
begin
  declare @insertedId int
  set @insertedId=-1
  select @insertedId=id_uzytkownik from deleted
  insert into uzytkownicy_zmiany values ( @insertedId ,'usuniety')
end
  go



 --drop trigger uzytkownik_insert_trigger
 
 --drop trigger uzytkownik_delete_trigger
 
 --drop procedure proc1

 delete from uzytkownik where id_uzytkownik=6;