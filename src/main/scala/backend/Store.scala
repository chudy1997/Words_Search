package backend

import scala.collection.immutable.HashMap

/**
  * Created by Karol on 2017-06-28.
  */
object Store {
  val map=HashMap(
  "Imiona" -> "Adam,Adela,Adolf,Agata,Agnieszka,Albert,Albin,Albina,Aldona,Aleksander,Aleksandra,Alfred,Alicja,Alina,Alojzy,Ambroży,Anastazy,Anastazja,Anatol,Andrzej,Aneta,Angelika,Aniela,Anna,Antoni,Antonina,Apolinary,Apolonia,Apoloniusz,Arkadiusz,Arnold,Artur,August,Augusta,Aurelia,Aureliusz,\nBalbina,Baldwin,Baltazar,Barbara,Barnaba,Bartłomiej,Bazyli,Beata,Benedykt,Benedykta,Beniamin,Benon,Bernadetta,Bernard,Bernardyna,Bertold,Błażej,Bogdan,Bogumił,Bogumiła,Bogusław,Bogusława,Bogusz,Bolesław,Bolesława,Bonifacy,Borys,Bożena,Bronisława,Brunon,Brygida,\nCecylia,Celestyn,Celina,Cezary,Chryzanta,Cyprian,Cyryl,Czesław,\nDagmara,Damian,Daniel,Danuta,Daria,Dariusz,Dawid,Diana,Dionizy,Dobrosław,Dominik,Dominika,Donat,Dorota,\nEdmund,Edward,Edwin,Edyta,Eleonora,Eliasz,Eliza,Elwira,Elżbieta,Emanuel,Emil,Emilia,Ernest,Eryk,Eugenia,Eugeniusz,Eustachy,Euzebia,Euzebiusz,Ewelina,Ewa,\nFaustyn,Faustyna,Felicjan,Felicja,Felicyta,Feliks,Ferdynand,Filip,Filipina,Florentyna,Florian,Flora,Franciszek,Franciszka,Fryderyk,\nGabriel,Gabriela,Gaweł,Genowefa,Gerard,Gertruda,Gerwazy,Gotfryd,Grażyna,Grzegorz,Gustaw,\nHalina,Hanna,Helena,Henryk,Hiacynta,Hieronim,Hilary,Hilaria,Hubert,\nIgnacy,Idefons,Ilona,Innocenty,Ireneusz,Irena,Iwona,Izabela,Izydor,\nJacek,Jadwiga,Jakub,Jan,Janusz,Jarosław,Jarosława,Jerzy,Joachim,Joanna,Jolanta,Józef,Józefa,Judyta,Julian,Julianna,Julia,Juliusz,Justyna,\nKacper,Kajetan,Kamil,Kamila,Karol,Karolina,Katarzyna,Kazimiera,Kazimierz,Kinga,Klara,Klaudia,Klaudiusz,Klemens,Kleopatra,Konrad,Konstancja,Konstanty,Kornel,Kornelia,Korneliusz,Krystian,Krystyna,Krzysztof,Ksawery,Kunegunda,\nLaura,Lech,Leon,Leonard,Leonid,Leopold,Leszek,Lidia,Lubomir,Lucjan,Lucjusz,Lucyna,Ludmiła,Ludomir,Ludosław,Ludwik,Ludwika,Ludwira,Ludosław,\nŁucja,Łukasz,\nMaciej,Magdalena,Makary,Maksym,Maksymilian,Maksyma,Malwina,Małgorzata,Marcely,Marcelin,Marcelina,Marcin,Marcjanna,Marian,Marianna,Maria,Mariola,Mariusz,Marek,Marta,Martyna,Marzena,Mateusz,Matylda,Maurycy,Melania,Melchior,Metody,Michał,Mieczysław,Mieszko,Mikołaj,Miłosz,Mirosław,Mirosława,Monika,Mścisław\nNatalia,Nela,Nikodem,Nina,Norbert,\nOlaf,Olga,Olgierd,Olimpia,Onufry,Oskar,Oswald,Otton,Otylia,\nPatrycja,Patryk,Paulina,Paweł,Pelagia,Petronela,Petroniusz,Piotr,Pius,Przemysław,\nRadosław,Rafał,Rajmund,Regina,Remigiusz,Renata,Robert,Roch,Roman,Romuald,Rozalia,Róża,Rudolf,Ryszard,\nSabina,Saba,Salomea,Saturynin,Sebastian,Sergiusz,Serwacy,Seweryn,Sławomir,Sława,Stanisław,Stanisława,Stefan,Sykstus,Sylwester,Sylwia,Sylwin,Szczepan,Szymon,\nTacjana,Tadeusz,Tekla,Teodor,Teodora,Teodozja,Teodozjusz,Teofil,Teofilia,Teresa,Tomasz,Tymoteusz,Tytus,\nUrban,Urszula,\nWacław,Wacława,Waldemar,Walenty,Waleria,Wanda,Weronika,Wiesław,Wiesława,Wiktor,Wiktoria,Wincenty,Witold,Władysław,Włodzimierz,Wojciech,Wolfgang,\nZachariasz,Zbigniew,Zdzisław,Zdzisława,Zenobia,Zenon,Zofia,Zuzanna,Zygfryd,Zygmunt,Zyta,\nŻaneta,",
  "Kosmos" -> "Antares,Arktur,Atair,\nBetelgeuse,\nCapella,\nDeneb,\nEuropa,\nJowisz,\nKsiężyc,\nMars,Merkury,\nNeptun,\nRegulus,\nSaturn,Spica,Syriusz,\nWenus,\nUran,\nZiemia",
  "Miasta" -> "Augustów\nBaborów,Białystok,Bytom,Bydgoszcz,Brzeg,Będzin,Biłgoraj,\nCzeladź,Częstochowa,Chorzów,Chełm,\nElbląg,Ełk,\nGliwice,Gdańsk,Gdynia,Gniezno,Grudziądz,\nHajnówka,Hel,\nInowrocław,\nJaworzno,Jarosław,\nKatowice,Kraków,Koszalin,Kłodzko,Kalisz,Kielce,Konin,Kołobrzeg,\nLublin,Lubin,Legnica,Leszno,\nŁódź,\nMyszków,Mysłowice,Malbork,\nNysa,\nOlsztyn,Opole,Olkusz,\nPoznań,Pabianice,Przemyśl,Piła,Płock,\nRadom,Rzeszów,Rybnik,Racibórz,\nSzczecin,Suwałki,Siemianowice,Sanok,Siedlce,Słupsk,\nŚwiętochłowice,Świdnica,Świnoujście,\nToruń,Tychy,Tarnów,\nUstka,Ustroń,\nWarszawa,Wrocław,Wałbrzych,Wałcz,Włocławek,\nZawiercie,Zabrze,Zakopane,Zamość,\nŻary,Żory,Żagań,Żywiec",
  "Morza" -> "Atlantycki,Azowskie,Adriatyckie,Alborańskie,Arabskie,Arktyczny,Arafura,Andamańskie,\nBiałe,Bałtyckie,Barentsa,Beringa,Balijskie,Banda,Bohol,\nCzarne,Celtyckie,Czukockie,Czerwone,Celebes,Camotes,\nDavisa,\nFilipińskie,Fidżi,\nGrenlandzkie,\nHebrydzkie,Halmahera,\nIrlandzkie,Indyjski,\nJońskie,Japońskie,Jawajskie,\nKaspijskie,Kreteńskie,Karskie,Karaibskie,Koralowe,\nLiguryjskie,Luzon,Labradorskie,Lincolina,\nŁaptiewów,\nMarmara,Martwe,Moluckie,Mindanao,\nNorweskie,\nOchockie,\nPółnocne,Peczorskie,Południowochińskie,\nRossa,\nSalomona,Spokojny,Seram,Scotia,Sawu,Sulu,Sibuyan,Samar,Sargasowe,Szkockie,\nŚródziemne,\nTyrzeńskie,Trackie,Timor,Tasmana,\nVisayan,\nWschodniosyberyjskie,Wchodniochińskie,Japońskie,Weddela,Wattów,\nŻółte",
  "Państwa" -> "Afganistan,Albania,Algieria,Andora,Angola,Argentyna,Armenia,Australia,Austria,Azerbejdżan,\nBahamy,Bahrajn,Bangladesz,Barbados,Belgia,Belize,Benin,Bhutan,Białoruś,Birma,Boliwia,Botswana,Brazylia,Brunei,Bułgaria,Burundi,\nChile,Chiny,Chorwacja,Cypr,Czad,Czarnogóra,Czechy,\nDania,Dominika,Dominikana,Dżibuti,\nEgipt,Ekwador,Erytrea,Estonia,Etiopia,\nFidżi,Filipiny,Finlandia,Francja,\nGabon,Gambia,Ghana,Grecja,Grenada,Grendia,Gruzja,Gujana,Gwatemala,Gwinea,\nHaiti,Hiszpania,Holandia,Honduras,\nIndie,Indonezja,Irak,Iran,Irlandia,Islandia,Izrael,\nJamajka,Japonia,Jemen,Jordania,\nKambodża,Kamerun,Kanada,Katar,Kazachstan,Kenia,Kirgistan,Kiribati,Kolumbia,Komory,Kongo,Kosowo,Korea,Kosowo,Kostaryka,Kuba,Kuwejt,\nLaos,Lesotho,Liban,Liberia,Libia,Liechtenstein,Litwa,Luksemburg,\nŁotwa,\nMacedonia,Madagaskar,Malawi,Malediwy,Malezja,Mali,Malta,Maroko,Mauretania,Mauritius,Meksyk,Mikronezja,Mołdawia,Monaco,Mongolia,Mozambik,\nNamibia,Nauru,Niemcy,Niger,Nigeria,Nikaragua,Norwegia,\nOman,\nPakistan,Palau,Palestyna,Panama,Paragwaj,Peru,Polska,Portugalia,\nRPA,Rosja,Rumunia,Rwanda,\nSalwador,Samoa,Senegal,Serbia,Seszele,Singapur,Słowacja,Słowenia,Somalia,Suazi,Sudan,Surinam,Syria,Szwajcaria,Szwecja,\nTadżykistan,Tajlandia,Tajwan,Tanzania,Togo,Tonga,Tunezja,Turcja,Turkmenistan,Tuvalu,\nUganda,Ukraina,Urugwaj,Uzbekistan,UK,USA,\nVanuatu,\nWatykan,Wenezuela,Węgry,Wietnam,Włochy,\nZambia,Zimbabwe",
  "Rośliny" -> "Buk,\nCzereśnia,\nDąb,\nEukaliptus,\nFiołek,\nGrusza,\nHuba,\nJabłoń,Jarzębina,Jemioła,Jeżyna,\nKlon,\nLen,\nMalina,Mniszek,\nOgórek,Orzech,\nPomidor,\nRóża,\nStokrotka,Szpinak,\nŚliwka,\nTulipan,Truskawka,\nWiśnia",
  "Samochody" -> "Acura,Alpina,Audi,\nBentley,BMW,Bugatti,Buick,Brabus,\nCadillac,Caterham,Citroen,Chrysler,Chevrolet,Corvetta,\nDaewoo,Daihatsu,Daimler,Dacia,Dodge,Datsun,\nFerrari,Fiat,Ford,\nHamann,Holden,Honda,Hummer,Hyundai,\nInfiniti,Iveco,\nJaguar,Jeep,Jelcz,\nKamos,Kia,Kleemann,Koenigsegg,\nLamborghini,Lancia,Lexus,Lincoln,Lotus,\nMan,Maserati,Maybach,Mazda,Mercedes,Mercury,MG,Minicooper,Mitshubishi,Morgan,\nNissan,\nOpel,\nPeugeot,Pontiac,Porsche,\nRenault,Rinspeed,Rover,\nSaab,Saleen,Scania,Scion,Seat,Skoda,Smart,Subaru,\nTalbot,Toyota,\nUrsus,\nVoltswagen,Volvo,\nWarszawa,Wołga,\nZastawa",
  "Stolice" -> "Abidżan,Amman,Amsterdam,Andora,Ankara,Ateny,\nBagdad,Baku,Bangkok,Bejrut,Belgrad,Berlin,Berno,Biszkek,Bratysława,Bruksela,Budapeszt,Bukareszt,\nCanberra,Caracas,Castries,Chartum,\nDamaszek,Delhi,Dhaka,Dili,Dublin,Duszanbe,Dżakarta,\nErywań,\nFreetown,\nGaborone,Georgetown,Gwatemala,\nHanoi,Harare,Hawana,Helsinki,Honiara,\nIslamabad,\nJamusukro,Jaunde,Jerozolima,\nKabul,Kair,Katmandu,Kigali,Kijów,Kingstown,Kiszyniów,Kopenhaga,Kuwejt,\nLibreville,Lilongwe,Lima,Lizbona,Londyn,Lublana,\nMadryt,Malabo,Manama,Manila,Meksyk,Mińsk,Mogadiszu,Monako,Montevideo,Moskwa,\nNassau,Nawakszut,Nikozja,\nOslo,Ottawa,\nPanama,Paryż,Pekin,Praga,\nRabat,Reykjavik,Roseau,Ryga,Rzym,\nSana,Sarajewo,Seul,Singapur,Skopje,Sofia,Sztokholm,\nTajpej,Tallin,Taszkent,Tbilisi,Teheran,Tirana,Tokio,Trypolis,\nVaduz,Vaiaku,Valletta,Victoria,\nWarszawa,Watykan,Wellington,Wiedeń,Wientian,Wilno,Windhuk,\nYaren,\nZagrzeb",
  "Zawody" -> "Atleta,Architekt\nBrukarz,Biegacz,Biolog,Budowlaniec\nCukiernik,Chemik\nDekarz,Dentysta,Dyrektor,\nElektryk,Ekonomista,\nFilatelista,Fizyk,\nGarncarz,Geograf,\nHycel,Hokeista,\nIluzjonista,Inżynier,\nJubiler,\nKardiolog,Kierowca,Klaun,Kierownik,Konsultant,Komornik,\nListonosz,Lekarz,Laryngolog,\nŁyżwiarz,\nMurarz,Malarz,\nNumizmatyk,Notariusz,\nOgrodnik,Onkolog,Ortodonta,Ortopeda,Okulista,\nPiłarz,Policjant,Pływak,Pilot,Prezes,Pełnomocnik,Piekarz,Pianista,\nRybak,Rzecznik,\nSiatkarz,Sportowiec,Strażak,Sędzia,Sekretarz,\nŚlusarz,\nTenisista,\nUrbanista,\nWeterynarz,\nZegarmistrz,Złotnik",
  "Zwierzęta" -> "Anakonda,Antylopa,Ara,Aligator,\nBocian,Byk,Baran,Bażant,Bóbr,Borsuk,Bizon,\nCzapla,Chrabąszcz,Chomik,\nĆma,\nDzik,Delfin,Dzięcioł,Dromader,\nEmu,\nFoka,Flaming,\nGoryl,Gawron,Gepard,Gęś,Gnu,Gołąb,\nHiena,Hipopotam,\nIndyk,Ibis,\nJaguar,Jak,Jaskółka,Jeleń,Jeż,\nKomar,Królik,Kot,Kura,Koala,Kukułka,Kornik,Kangur,Krowa,Koń,\nLis,Lew,Lama,Lampart,\nŁosoś,Łabędź,Łoś,\nMucha,Mysz,Mrówka,Małpa,Mewa,Motyl,Mrówka,Mors,\nNiedźwiedź,Nosorożec,Nietoperz,\nOwca,Osa,Orka,Orzeł,Osioł,Ośmiornica,\nPszczoła,Pies,Panga,Panda,Patyczak,Pająk,Pelikan,Paw,Pingwin,Pstrąg,\nRak,Ryba,Rekin,Renifer,Ryś,\nStruś,Sarna,Słoń,Surykatka,Sęp,Sowa,Szczur,Szpak,Szympans,\nŚlimak,Świnia,Świstak,\nTermit,Trzmiel,Tygrys,\nUchatka,Ukwiał,\nWilk,Wieloryb,Ważka,Wielbłąd,Wiewiórka,Wróbel,Wydra,\nZając,Zebra,Zimorodek,\nŻuk,Żyrafa,Żaba,Żmija,Żółw,Żuraw,\nŹrebak",
  )
}