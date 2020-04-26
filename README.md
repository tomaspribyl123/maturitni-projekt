# maturitni-projekt
Na spuštění projektu je nejprve potřeba databáze h2 - https://www.h2database.com/html/main.html
Na vytvoření tabulky knih - CREATE TABLE knihy(
   ID NUMBER(9) AUTO_INCREMENT,
   nazev VARCHAR2(30 CHAR),
   zanr VARCHAR2(15 CHAR),
   autor VARCHAR2(15 CHAR),
   datum_vydani NUMBER(5),
   jazyk VARCHAR2(15 CHAR),
   vydavatel VARCHAR2(15 CHAR),
   PRIMARY KEY(ID)
);
a následný insert pro get metoduINSERT INTO KNIHY (NAZEV, AUTOR, ZANR, ROK_VYDANI, JAZYK, VYDAVATEL) VALUES 
('?', '?','?', ?, '?','?');

Po naimportování projektu je potřeba v application.properties vložit svou cestu k databázi viz.(jdbc:h2:~/Documents/db mode = oracle; )
K testování program Postman - https://www.postman.com/downloads/
