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


## Opis ekrana sa igrom

Ekran sa igrom u aplikaciji Math FunLand osmišljen je tako da korisnicima omogući rješavanje zadatka sabiranja u interaktivnom okruženju. Ekran je prilagođen kako za portretni, tako i za pejzažni način prikaza, te sadrži različite funkcionalnosti koje pomažu korisnicima da se fokusiraju na rješavanje zadataka.

### Elementi Ekrana sa Igrom
1. TopAppBar: prikazuje traku na vrhu ekrana sa navigacijskim dugmetom za povratak na početni ekran i dugmetom za dijeljenje rezultata.
2. Timer: prikazuje preostalo vrijeme za unos odgovora.
3. Zadatak: prikazuje trenutni matematički zadatak (sabiranje/oduzimanje).
4. Polje za unos odgovora: omogućava korisnicima da unesu svoj odgovor.
5. Dugme za potvrdu: omogućava korisnicima da potvrde svoj odgovor.
6. Rezultat: prikazuje trenutni rezultat korisnika.

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
EndGameDialog je funkcija koja prikazuje dijalog kada korisnik da netačan odgov
