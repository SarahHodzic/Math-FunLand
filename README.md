# Dokumentacija

## Opis rada aplikacije sa slikama

Math FunLand je edukativna Android aplikacija osmišljena za učenike prvih razreda osnovne škole kako bi na zabavan i interaktivan način vježbali sabiranje i oduzimanje jednocifrenih brojeva. Aplikacija pruža jednostavno i intuitivno korisničko okruženje koje omogućava djeci da se fokusiraju na učenje kroz igru.

### Početni ekran (Landing page)

Početni ekran aplikacije Math FunLand osmišljen je da pruži korisnicima toplo dobrodošlicu i osnovne informacije o igri, uz jednostavne i intuitivne kontrole za početak igre.

#### Elementi početnog ekrana:
1. Tekst dobrodošlice: prikazuje poruku dobrodošlice korisnicima aplikacije.
2. Informativni tekst: prikazuje osnovne informacije o igri.
3. Dugme za pokretanje igre: pritiskom na dugme otvara se glavni prozor igre, započinje timer i igra počinje.

![image](https://github.com/SarahHodzic/Math-FunLand/assets/82335709/498fde25-dd2f-4fc0-88d1-e8a24e9d53bf)


### Opis ekrana sa igrom

Ekran sa igrom u aplikaciji Math FunLand osmišljen je tako da korisnicima omogući rješavanje zadatka sabiranja u interaktivnom okruženju. Ekran je prilagođen kako za portretni, tako i za pejzažni način prikaza, te sadrži različite funkcionalnosti koje pomažu korisnicima da se fokusiraju na rješavanje zadataka.

### Elementi Ekrana sa Igrom
1. TopAppBar: prikazuje traku na vrhu ekrana sa navigacijskim dugmetom za povratak na početni ekran i dugmetom za dijeljenje rezultata.
2. Timer: prikazuje preostalo vrijeme za unos odgovora.
3. Zadatak: prikazuje trenutni matematički zadatak (sabiranje/oduzimanje).
4. Polje za unos odgovora: omogućava korisnicima da unesu svoj odgovor.
5. Dugme za potvrdu: omogućava korisnicima da potvrde svoj odgovor.
6. Rezultat: prikazuje trenutni rezultat korisnika.

Kada korisnik pritisne dugme za početak igre koji se nalazi na landing page-u odmah započinje timer od 10 sekundi za koje igrač mora unijeti odgovor u polje za unos odgovora. Ukoliko je odgovor tačan pojavljuje se dijalog sa porukom „Tačno“ , ali takođe i dugme čijim klikom se bira naredno pitanje. Ukoliko je odgovor netačan izaći će dijalog sa adekvatnom porukom opcijom da se prekine igra ili započne nova. Ako igrač ne unese odgovor u datom vremenu dobija dijalog sa porukom. Također je uključeno i dugme za dijeljenje rezultata igre drugim aplikacijama. Također i svaki put kada igrač odgovori tačno broj bodova se povećava za 1.

Aplikacija posjeduje pejzažni i portretni prikaz ekrana

Kada je korisnik u portret mode-u svi elementi ekrana su poredani jedan ispod drugom po redoslijedu kojim su navedeni iznad, dok u pejzažnom načinu prikaza timer, polje za unos odgovora i rezultat su u jednom redu, zadatak je iznad njih a dugme za potvrdu odgovora ispod

![image](https://github.com/SarahHodzic/Math-FunLand/assets/82335709/7d2b6387-a26c-4129-9b1e-1f32299380af)
![image](https://github.com/SarahHodzic/Math-FunLand/assets/82335709/f8895a5b-8ebc-4279-86e4-2c937ed3d025)
![image](https://github.com/SarahHodzic/Math-FunLand/assets/82335709/cd236d75-acd1-49ee-b54c-b97463319516)
![image](https://github.com/SarahHodzic/Math-FunLand/assets/82335709/0ff09a9b-3cf3-48f7-bf38-ef9dbb82b779)

## Opis arhitekture aplikacije

Korištena je MVVM (Model-View-ViewModel) arhitektura i Jetpack Compose biblioteke za izradu korisničkog interfejsa.

### Slojevi arhitekture:
1. View (Pogled)
2. ViewModel
3. Model

#### View
View sloj sadrži sve UI komponente koje su izgrađene koristeći Jetpack Compose. Ovaj sloj je odgovoran za prikazivanje podataka i prikupljanje korisničkih interakcija. Ekrani koji spadaju u ovaj sloj su GameScreen i LandingPage.

#### ViewModel
ViewModel sloj je odgovoran za upravljanje logikom aplikacije i poslovnim podacima. ViewModel komunicira sa Model slojem za dohvaćanje podataka i s View slojem za ažuriranje UI-ja. U aplikaciji Math FunLand, ViewModel uključuje:
- GameViewModel: Upravljanjem stanjem igre, kao što su trenutni zadaci, preostalo vrijeme, uneseni odgovori korisnika, rezultati i poruke o uspjehu ili greškama.

#### Model
Model sloj sadrži podatke i poslovnu logiku aplikacije. U kontekstu aplikacije Math FunLand, model sloj može uključivati:
- GameUiState: Klasa koja definira stanje korisničkog interfejsa, kao što su trenutni brojevi za sabiranje, trenutni rezultat, preostalo vrijeme, poruke o tačnim i netačnim odgovorima.

## Opis funkcionalnosti pojedinačnih klasa

### GameScreen
GameScreen je glavna Composable funkcija koja predstavlja glavni ekran igre. Njene funkcionalnosti uključuju:
- Prikazivanje trenutnog stanja igre: Prikazuje timer, zadatak za rješavanje, polje za unos korisnikovog odgovora, trenutni rezultat, i dugme za predaju odgovora.
- Prilagođavanje različitim orijentacijama ekrana: Koristi LocalConfiguration.current za provjeru orijentacije uređaja i prikazivanje odgovarajućeg layouta.
- Prikazivanje dijaloga: Prikazuje dijalog za tačan odgovor (CorrectAnsDialog) ili kraj igre (EndGameDialog) na osnovu stanja igre.

### LanscapeMode
LanscapeMode je pomoćna funkcija koja prilagođava prikaz igre za landscape orijentaciju ekrana.

### TopAppBar
TopAppBar je funkcija koja prikazuje traku na vrhu ekrana sa navigacijskim dugmetom za povratak na prethodni ekran i dugmetom za dijeljenje rezultata.
- Navigacijsko dugme: Vraća korisnika na prethodni ekran i zaustavlja tajmer.
- Dugme za dijeljenje: Omogućava korisniku da dijeli svoj rezultat putem drugih aplikacija.

### CorrectAnsDialog
CorrectAnsDialog je funkcija koja prikazuje dijalog kada korisnik tačno odgovori na zadatak. Omogućava korisniku da pređe na sljedeći zadatak.

### EndGameDialog
EndGameDialog je funkcija koja prikazuje dijalog kada korisnik da netačan odgovor ili istekne vrijeme. Omogućava korisniku da ponovo započne igru ili zatvori aplikaciju.

### MathGame
MathGame je funkcija koja postavlja navigaciju unutar aplikacije, omogućujući prebacivanje između LandingPage i GameScreen.

### LandingPage
LandingPage je početni ekran aplikacije koji pruža dobrodošlicu korisniku i nudi osnovne informacije o igri. Također sadrži dugme za početak igre koje pokreće igru i prebacuje korisnika na GameScreen.

### GameViewModel
GameViewModel je ViewModel klasa koja upravlja stanjem igre i poslovnom logikom. Njene funkcionalnosti uključuju:

•	Upravljanje stanjem igre: Drži trenutne brojeve za zadatak, operaciju (sabiranje ili oduzimanje), preostalo vrijeme, rezultat, i korisnikov unos.
•	Generiranje zadataka: Metoda generatingNumbersAndOperations generira nasumične brojeve i operaciju za novi zadatak.
•	Upravljanje tajmerom: Metode startTimer, stopTimer, i logika unutar startGame i onNextClick upravljaju odbrojavanjem vremena za svaki zadatak.
•	Provjera odgovora: Metoda checkAnswer provjerava da li je korisnikov unos tačan ili netačan i ažurira stanje igre prema tome.

### GameUiState
GameUiState je klasa koja predstavlja stanje korisničkog interfejsa. Sadrži podatke kao što su trenutni brojevi za zadatak, operacija, preostalo vrijeme, rezultat, i poruke o tačnim ili netačnim odgovorima.

### Dijeljenje rezultata putem sharing intent-a
Korisniku se omogućava da dijeli svoj rezultat igre putem različitih aplikacija koje podržavaju dijeljenje tekstualnog sadržaja, kao što su aplikacije za poruke, društvene mreže i email aplikacije. Ovo se postiže korištenjem Intent.ACTION_SEND akcije zajedno sa potrebnim podacima i tipom sadržaja.

### Glavni tok igranja

1.	Početak igre: Korisnik započinje igru sa LandingPage i prebacuje se na GameScreen.
2.	Prikaz zadataka i tajmera: GameScreen prikazuje nasumično generisani zadatak i odbrojavanje vremena.
3.	Unos i provjera odgovora: Korisnik unosi odgovor, a GameViewModel provjerava tačnost unosa.
4.	Prikaz rezultata: Na osnovu tačnosti odgovora, prikazuje se odgovarajući dijalog (CorrectAnsDialog ili EndGameDialog).
5.	Ponovno pokretanje igre: Korisnik može ponovno pokrenuti igru ili zatvoriti aplikaciju.

## Opis opštih koncepata Android frameworka

Opšti koncepti Android frameworka obuhvataju osnovne principe i komponente koje čine strukturu Android operativnog sistema i omogućavaju razvoj mobilnih aplikacija.

•  Activities (Aktivnosti): Koriste se za predstavljanje korisničkog interfejsa na ekranu i za interakciju sa korisnikom. U projektu su korištene aktivnosti poput GameScreen i LandingPage kako bi se prikazale odgovarajuće stranice aplikacije.
•  ViewModel: ViewModel je arhitekturni obrazac koji se koristi za čuvanje i upravljanje podacima koji su povezani sa UI komponentama. GameViewModel u projektu čuva logiku i stanje igre.
•  Layouts (Rasporedi): Layouti definišu strukturu i izgled korisničkog interfejsa, uključujući poziciju i stil elemenata kao što su dugmad, polja za unos teksta, i slično.
•  Intents:  koriste se za pokretanje komponenti aplikacije, slanje i primanje podataka između komponenti, kao i za pokretanje aktivnosti iz različitih dijelova aplikacije. U projektu se koristi Intent za dijeljenje rezultata igre putem drugih aplikacija.
•  Navigation (Navigacija): Navigacija se koristi za upravljanje prelaskom između različitih ekrana ili dijelova aplikacije. U projektu se koristi NavHost sa definisanim rutama (composable) kako bi se omogućilo navigiranje između početne stranice (LandingPage) i stranice igre (GameScreen).
•	Localization: Proces prilagođavanja aplikacije različitim jezicima, regionalnim podešavanjima i kulturnim kontekstima kako bi se korisnicima pružilo lokalizovano iskustvo. Uključuje prevođenje tekstova, prilagođavanje formata datuma, vremena i valuta, kao i prilagođavanje drugih aspekata aplikacije prema jezičkim preferencama korisnika.
•	Životni ciklus (Lifecycle): Odnosi se na seriju stanja koje aktivnost ili fragment može prolaziti tokom svog postojanja, od stvaranja do uništenja. Ovo je ključni koncept jer omogućava android programerima da upravljaju ponašanjem aplikacije u različitim situacijama, kao što su promjene konfiguracije uređaja, prelazak između aktivnosti i fragmenta, kao i promjene u životnom ciklusu samog Android sistema.






