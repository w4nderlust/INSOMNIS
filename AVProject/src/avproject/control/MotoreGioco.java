package avproject.control;

//~--- non-JDK imports --------------------------------------------------------
import avproject.librcp.ModuloRCP;
import avproject.model.*;
import avproject.util.*;
import avproject.gui.*;

//~--- JDK imports ------------------------------------------------------------

import java.util.*;

public class MotoreGioco {

    private static MotoreGioco motoreGioco = null;
    private String difficoltaAttuale, tipoVisualizzazioneAttuale, tipoVisualizzazioneMomentanea;
    private ArrayList<StatisticheGruppo> statistiche = new ArrayList<StatisticheGruppo>();
    private Locazione locazioneAttuale, locazionePrecedente;
    private ArrayList<Locazione> primeGruppoSuccessivo = new ArrayList<Locazione>();
    private Cronometro cronometro = new Cronometro();
    private RisultatiQuestionario risultati = new RisultatiQuestionario();

    private MotoreGioco() {
    }

    public static MotoreGioco getInstance() {
        if (motoreGioco == null) {
            motoreGioco = new MotoreGioco();
        }
        return motoreGioco;
    }

    public void inizializzazioneMappa() {
        //setta tutte le locazioni e relative proprietà

        //enigmi
        ArrayList<String> risposteFacili1 = new ArrayList<String>();
        risposteFacili1.add("11010");
        risposteFacili1.add("1100");
        risposteFacili1.add("0101");
        risposteFacili1.add("0110");
        ArrayList<String> risposteMedie1 = new ArrayList<String>();
        risposteMedie1.add("10110");
        risposteMedie1.add("11010");
        risposteMedie1.add("11101");
        risposteMedie1.add("01101");
        ArrayList<String> risposteDifficili1 = new ArrayList<String>();
        risposteDifficili1.add("100101");
        risposteDifficili1.add("110011");
        risposteDifficili1.add("110110");
        risposteDifficili1.add("011011");
        Enigma e1 = new Enigma("110 = 4*1 + 2*1 + 1*0 = 6", false, "/avproject/images/e1f.png", "/avproject/images/e1m.png", "/avproject/images/e1d.png", "\"Quante dita ci sono in una mano? Inserire una risposta\". Tutti i tasti della tastiera non sembrano funzionare tranne il tasto 1 e quello 0...", "\"Qual è il risultato di (5 * 7) − (2 * 3)? Inserire una risposta\". Tutti i tasti della tastiera non sembrano funzionare tranne il tasto 1 e quello 0...", "\"In che anno del XX secolo è morto Alan Turing? Inserire una risposta\". Tutti i tasti della tastiera non sembrano funzionare tranne il tasto 1 e quello 0...", 3, risposteFacili1, risposteMedie1, risposteDifficili1);

        ArrayList<String> risposteFacili2 = new ArrayList<String>();
        risposteFacili2.add("login");
        risposteFacili2.add("logout");
        risposteFacili2.add("logger");
        risposteFacili2.add("logged");
        ArrayList<String> risposteMedie2 = new ArrayList<String>();
        risposteMedie2.add("gurumeditation");
        risposteMedie2.add("gurumotivation");
        risposteMedie2.add("gurumediatics");
        risposteMedie2.add("gurusystematic");
        ArrayList<String> risposteDifficili2 = new ArrayList<String>();
        risposteDifficili2.add("edsgerwdijkstra");
        risposteDifficili2.add("edgarddijkstra");
        risposteDifficili2.add("edsgraddjikstra");
        risposteDifficili2.add("edgardjikistra");
        Enigma e2 = new Enigma("00001 = a, 00010 = b, 00011 = c, ...", false, "/avproject/images/e2f.png", "/avproject/images/e2m.png", "/avproject/images/e2d.png", "Sullo schermo multitouch appare una sequenza di 0 ed 1 e quattro pulsanti al di sotto. La sequenza è: 001100 001111 000111 001001 001110", "Sullo schermo multitouch appare una sequenza di 0 ed 1 e quattro pulsanti al di sotto. La sequenza è: 000111 010101 010010 010101 001101 000101 000100 001001 010100 000001 010100 000011 001101 001100", "Sullo schermo multitouch appare una sequenza di 0 ed 1 e quattro pulsanti al di sotto. La sequenza è: 000101 000100 010011 000111 000101 010010 010111 000100 001001 001010 001011 010011 010100 010010 000001", 1, risposteFacili2, risposteMedie2, risposteDifficili2);

        ArrayList<String> risposteFacili3 = new ArrayList<String>();
        risposteFacili3.add("1");
        risposteFacili3.add("2");
        risposteFacili3.add("3");
        risposteFacili3.add("4");
        ArrayList<String> risposteMedie3 = new ArrayList<String>();
        risposteMedie3.add("6");
        risposteMedie3.add("2");
        risposteMedie3.add("5");
        risposteMedie3.add("3");
        ArrayList<String> risposteDifficili3 = new ArrayList<String>();
        risposteDifficili3.add("7");
        risposteDifficili3.add("2");
        risposteDifficili3.add("4");
        risposteDifficili3.add("5");
        Enigma e3 = new Enigma("L'ultimo bit è il bit di parità, rende pari le cifre.", false, "/avproject/images/e3f.png", "/avproject/images/e3m.png", "/avproject/images/e3d.png", "Scheda perforata:\n 10011 1\n 11100 0\n 10101 1\n 10010 0\n 10110 1\n 01101 1", "Scheda perforata:\n 10011 1\n 11100 0\n 10101 1\n 10010 0\n 10110 1\n 01101 1", "Scheda perforata:\n 1001010 1\n 1110110 0\n 0111011 1\n 1011011 1\n 1001110 0\n 0100100 0\n 1001010 1\n 0111101 1", 2, risposteFacili3, risposteMedie3, risposteDifficili3);

        ArrayList<String> risposteFacili4 = new ArrayList<String>();
        risposteFacili4.add("8");
        risposteFacili4.add("3");
        risposteFacili4.add("2");
        risposteFacili4.add("4");
        ArrayList<String> risposteMedie4 = new ArrayList<String>();
        risposteMedie4.add("32");
        risposteMedie4.add("5");
        risposteMedie4.add("24");
        risposteMedie4.add("13");
        ArrayList<String> risposteDifficili4 = new ArrayList<String>();
        risposteDifficili4.add("128");
        risposteDifficili4.add("7");
        risposteDifficili4.add("5");
        risposteDifficili4.add("64");
        Enigma e4 = new Enigma("Si possono porre domande come \"il quadro si trova nella prima metà del corridoio?\"", false, "/avproject/images/e4f.png", "/avproject/images/e4m.png", "/avproject/images/e4d.png", "Ci sono 8 quadri nel corridoio, quante domande è sufficiente porre?", "Ci sono 32 quadri nel corridoio, quante domande è sufficiente porre?", "Ci sono 128 quadri nel corridoio, quante domande è sufficiente porre?", 2, risposteFacili4, risposteMedie4, risposteDifficili4);

        ArrayList<String> risposteFacili5 = new ArrayList<String>();
        risposteFacili5.add("10");
        risposteFacili5.add("100");
        risposteFacili5.add("3");
        risposteFacili5.add("7");
        ArrayList<String> risposteMedie5 = new ArrayList<String>();
        risposteMedie5.add("15");
        risposteMedie5.add("125");
        risposteMedie5.add("4");
        risposteMedie5.add("9");
        ArrayList<String> risposteDifficili5 = new ArrayList<String>();
        risposteDifficili5.add("20");
        risposteDifficili5.add("400");
        risposteDifficili5.add("5");
        risposteDifficili5.add("11");
        Enigma e5 = new Enigma("Considerare il numero di caselle di ogni riga ed il fatto che è inutile sparare colpi sulle isole", false, "/avproject/images/e5f.png", "/avproject/images/e5m.png", "/avproject/images/e5d.png", "La griglia è 10x10 (numeri sulle righe, lettere sulle colonne) e su di essa ci sono tre isole, una quadrata da B2 a C4, una lunga da E6 a E9 e una verticale da G8 a H8. Trova la nave HMS-6129. Quanti colpi devi sparare al massimo per affondare la nave?", "La griglia è 15x15 (numeri sulle righe, lettere sulle colonne) e su di essa ci sono tre isole, una quadrata da B2 a D4, un'altra quadrata da L6 a M7, una lunga da C8 a E8, una lunga da O7 a Q7, e una verticale da G7 a G9. Trova la nave HMS-612945. Quanti colpi devi sparare al massimo per affondare la nave?", "La griglia è 20x20 (numeri sulle righe, lettere sulle colonne) e su di essa ci sono tre isole, una quadrata da B2 a D4, un'altra rettangolare da L6 a MN14, una lunga da C8 a E8, una lunga da Q9 a U9, e una verticale da G7 a G9. Trova la nave HMS-61284503. Quanti colpi devi sparare al massimo per affondare la nave?", 4, risposteFacili5, risposteMedie5, risposteDifficili5);

        ArrayList<String> risposteFacili6 = new ArrayList<String>();
        risposteFacili6.add("10");
        risposteFacili6.add("5");
        risposteFacili6.add("15");
        risposteFacili6.add("20");
        ArrayList<String> risposteMedie6 = new ArrayList<String>();
        risposteMedie6.add("21");
        risposteMedie6.add("14");
        risposteMedie6.add("7");
        risposteMedie6.add("28");
        ArrayList<String> risposteDifficili6 = new ArrayList<String>();
        risposteDifficili6.add("36");
        risposteDifficili6.add("18");
        risposteDifficili6.add("72");
        risposteDifficili6.add("9");
        Enigma e6 = new Enigma("Per trovare il meno capiente il robot compie ad ogni passo n-1 confronti", false, "/avproject/images/e6f.png", "/avproject/images/e6m.png", "/avproject/images/e6d.png", "\"Gli hard disk hanno capienza rispettivamente di 20tb, 30tb, 50tb, 10tb, 40tb. Quanti confronti dovrò effettuare per disporli nel giusto ordine?\"", "\"Gli hard disk hanno capienza rispettivamente di 20tb, 30tb, 50tb, 10tb, 40tb, 36tb, 24tb. Quanti confronti dovrò effettuare per disporli nel giusto ordine?\"", "\"Gli hard disk hanno capienza rispettivamente di 20tb, 30tb, 50tb, 10tb, 40tb, 36tb, 24tb, 12tb, 60tb. Quanti confronti dovrò effettuare per disporli nel giusto ordine?\"", 1, risposteFacili6, risposteMedie6, risposteDifficili6);

        ArrayList<String> risposteFacili7 = new ArrayList<String>();
        risposteFacili7.add("9");
        risposteFacili7.add("6");
        risposteFacili7.add("5");
        risposteFacili7.add("7");
        ArrayList<String> risposteMedie7 = new ArrayList<String>();
        risposteMedie7.add("16");
        risposteMedie7.add("17");
        risposteMedie7.add("7");
        risposteMedie7.add("13");
        ArrayList<String> risposteDifficili7 = new ArrayList<String>();
        risposteDifficili7.add("9");
        risposteDifficili7.add("29");
        risposteDifficili7.add("27");
        risposteDifficili7.add("26");
        Enigma e7 = new Enigma("Ogni elemento centrale va confrontato n-1 volte con gli altri elementi del sottoinsieme", false, "/avproject/images/e7f.png", "/avproject/images/e7m.png", "/avproject/images/e7d.png", "\"I libri sono scritti dai seguenti autori: Horstmann, Tanenbaum, Mitchell, Russell, Wirth. Quanti confronti dovrò fare per ordinarli correttamente?\"", "\"I libri sono scritti dai seguenti autori: Horstmann, Tanenbaum, Mitchell, Russell, Wirth, Cutland, Elmasri. Quanti confronti dovrò fare per ordinarli correttamente?\"", "\"I libri sono scritti dai seguenti autori: Horstmann, Tanenbaum, Mitchell, Russell, Wirth, Cutland, Elmasri, Gabbrielli, Bertossi. Quanti confronti dovrò fare per ordinarli correttamente?\"", 4, risposteFacili7, risposteMedie7, risposteDifficili7);

        ArrayList<String> risposteFacili8 = new ArrayList<String>();
        risposteFacili8.add("5");
        risposteFacili8.add("7");
        risposteFacili8.add("9");
        risposteFacili8.add("11");
        ArrayList<String> risposteMedie8 = new ArrayList<String>();
        risposteMedie8.add("7");
        risposteMedie8.add("11");
        risposteMedie8.add("16");
        risposteMedie8.add("13");
        ArrayList<String> risposteDifficili8 = new ArrayList<String>();
        risposteDifficili8.add("9");
        risposteDifficili8.add("16");
        risposteDifficili8.add("19");
        risposteDifficili8.add("26");
        Enigma e8 = new Enigma("Ogni volta che si inserisce una custodia sullo scaffale bisogna confrontarla con tutte le custodie che vengono prima di lei e con una sola custodia successiva, per sapere precisamente dove piazzarla", false, "/avproject/images/e8f.png", "/avproject/images/e8m.png", "/avproject/images/e8d.png", "\"Su ogni custodia dei dischi è presente un'etichetta che ne identifica il contenuto. Le custodie sono etichettate: Algoritmi, Sistemi Operativi, Intelligenza Artificiale, Programmazione, Interazione Uomo-Macchina. Quanti confronti dovrò fare per per ottenere uno scaffale ordinato?\"", "\"Su ogni custodia dei dischi è presente un'etichetta che ne identifica il contenuto. Le custodie sono etichettate: Algoritmi, Sistemi Operativi, Intelligenza Artificiale, Programmazione, Interazione Uomo-Macchina, Reti di Calcolatori, Analisi dei Dati. Quanti confronti dovrò fare per per ottenere uno scaffale ordinato?\"", "\"Su ogni custodia dei dischi è presente un'etichetta che ne identifica il contenuto. Le custodie sono etichettate: Algoritmi, Sistemi Operativi, Intelligenza Artificiale, Programmazione, Interazione Uomo-Macchina, Reti di Calcolatori, Analisi dei Dati, Statistica, Ingegneria del Software. Quanti confronti dovrò fare per per ottenere uno scaffale ordinato?\"", 3, risposteFacili8, risposteMedie8, risposteDifficili8);

        ArrayList<String> risposteFacili9 = new ArrayList<String>();
        risposteFacili9.add("7");
        risposteFacili9.add("5");
        risposteFacili9.add("9");
        risposteFacili9.add("11");
        ArrayList<String> risposteMedie9 = new ArrayList<String>();
        risposteMedie9.add("11");
        risposteMedie9.add("5");
        risposteMedie9.add("9");
        risposteMedie9.add("7");
        ArrayList<String> risposteDifficili9 = new ArrayList<String>();
        risposteDifficili9.add("24");
        risposteDifficili9.add("9");
        risposteDifficili9.add("14");
        risposteDifficili9.add("18");
        Enigma e9 = new Enigma("Dopo n passi, i primi n elementi sono ordinati tra di loro, l'elemento successivo dovrà essere scambiato un numero di volte pari agli elementi tra i primi n superiori ad esso", false, "/avproject/images/e9f.png", "/avproject/images/e9m.png", "/avproject/images/e9d.png", "\"Gli anni accademici stampati sulle tesi sono: 2019, 2023, 2014, 2020, 2012. Quanti scambi dovrò fare in tutto?\"", "\"Gli anni accademici stampati sulle tesi sono: 2019, 2023, 2014, 2020, 2012, 2017, 2022. Quanti scambi dovrò fare in tutto?\"", "\"Gli anni accademici stampati sulle tesi sono: 2019, 2023, 2014, 2020, 2012, 2017, 2022, 2016, 2011. Quanti scambi dovrò fare in tutto?\"", 1, risposteFacili9, risposteMedie9, risposteDifficili9);

        ArrayList<String> risposteFacili10 = new ArrayList<String>();
        risposteFacili10.add("5");
        risposteFacili10.add("4");
        risposteFacili10.add("7");
        risposteFacili10.add("6");
        ArrayList<String> risposteMedie10 = new ArrayList<String>();
        risposteMedie10.add("7");
        risposteMedie10.add("9");
        risposteMedie10.add("11");
        risposteMedie10.add("13");
        ArrayList<String> risposteDifficili10 = new ArrayList<String>();
        risposteDifficili10.add("9");
        risposteDifficili10.add("23");
        risposteDifficili10.add("11");
        risposteDifficili10.add("19");
        Enigma e10 = new Enigma("Al primo passo basta un confronto per unire i gruppi, nei successivi bisogna unire i gruppi ordinati con più elementi ottenuti nei passi precedenti", false, "/avproject/images/e10f.png", "/avproject/images/e10m.png", "/avproject/images/e10d.png", "\"I voti sui compiti sono sono: 28, 25, 30, 21, 18. Quanti confronti dovrò fare in tutto?\"", "\"I voti sui compiti sono sono: 28, 25, 30, 21, 18, 20, 27. Quanti confronti dovrò fare in tutto?\"", "\"I voti sui compiti sono sono: 28, 25, 30, 21, 18, 20, 27, 26, 24. Quanti confronti dovrò fare in tutto?\"", 4, risposteFacili10, risposteMedie10, risposteDifficili10);

        ArrayList<String> risposteFacili11 = new ArrayList<String>();
        risposteFacili11.add("Il gruppo alpha");
        risposteFacili11.add("il gruppo beta");
        risposteFacili11.add("Finiscono contemporaneamente");
        risposteFacili11.add("Nessuno dei due gruppi può finire il compito");
        ArrayList<String> risposteMedie11 = new ArrayList<String>();
        risposteMedie11.add("Il gruppo alpha");
        risposteMedie11.add("il gruppo beta");
        risposteMedie11.add("Finiscono contemporaneamente");
        risposteMedie11.add("Nessuno dei due gruppi può finire il compito");
        ArrayList<String> risposteDifficili11 = new ArrayList<String>();
        risposteDifficili11.add("Il gruppo alpha");
        risposteDifficili11.add("il gruppo beta");
        risposteDifficili11.add("Finiscono contemporaneamente");
        risposteDifficili11.add("Nessuno dei due gruppi può finire il compito");
        Enigma e11 = new Enigma("Il gruppo alpha lavora in sequenza, il gruppo beta può lavorare in parallelo.", false, "/avproject/images/e11f.png", "/avproject/images/e11m.png", "/avproject/images/e11d.png", "\"siano dati venti robot, i primi dieci (gruppo alpha) devono costruire un palazzo di dieci piani, gli altri dieci (gruppo beta) devono costruire dieci case di un piano ciascuna. Due robot non possono lavorare contemporaneamente sullo stesso piano del palazzo o sulla stessa casa, perché si intralcerebbero. Chi conclude prima il proprio compito?\"", "\"siano dati cinquanta robot, i primi venticinque (gruppo alpha) devono costruire un palazzo di cinquanta piani, gli altri venticinque (gruppo beta) devono costruire cinquanta case di due piani ciascuna. Due robot non possono lavorare contemporaneamente sullo stesso piano del palazzo o sulla stessa casa, perché si intralcerebbero. Chi conclude prima il proprio compito?\"", "\"siano dati settantadue robot, i primi trentasei (gruppo alpha) devono costruire un palazzo di centootto piani, gli altri trentasei (gruppo beta) devono costruire settantadue case di tre piani ciascuna. Due robot non possono lavorare contemporaneamente sullo stesso piano del palazzo o sulla stessa casa, perché si intralcerebbero. Chi conclude prima il proprio compito?\"", 2, risposteFacili11, risposteMedie11, risposteDifficili11);

        ArrayList<String> risposteFacili12 = new ArrayList<String>();
        risposteFacili12.add("121");
        risposteFacili12.add("22");
        risposteFacili12.add("10");
        risposteFacili12.add("11");
        ArrayList<String> risposteMedie12 = new ArrayList<String>();
        risposteMedie12.add("289");
        risposteMedie12.add("34");
        risposteMedie12.add("16");
        risposteMedie12.add("17");
        ArrayList<String> risposteDifficili12 = new ArrayList<String>();
        risposteDifficili12.add("529");
        risposteDifficili12.add("64");
        risposteDifficili12.add("22");
        risposteDifficili12.add("23");
        Enigma e12 = new Enigma("ciascuna città può essere collegata con qualunque altra, tenere in considerazione il numero delle citta", false, "/avproject/images/e12f.png", "/avproject/images/e12m.png", "/avproject/images/e12d.png", "Di fianco è scritta la domanda \"si supponga di voler connettere 11 le città alla rete elettrica, qual è il numero minimo di collegamenti necessari?\"", "Di fianco è scritta la domanda \"si supponga di voler connettere 17 le città alla rete elettrica, qual è il numero minimo di collegamenti necessari?\"", "Di fianco è scritta la domanda \"si supponga di voler connettere 23 le città alla rete elettrica, qual è il numero minimo di collegamenti necessari?\"", 3, risposteFacili12, risposteMedie12, risposteDifficili12);

        //intermezzi
        Slide s1 = new Slide("/avproject/images/s0_1.png", "Italia, 203X.\nUn governo autocratico prese il potere nel 2015 grazie al monopolio esercitato dal suo leader sui mezzi di comunicazione, nella totale indifferenza dei cittadini ormai irrimediabilmente instupiditi dalla televisione commerciale e dall'impoverimento culturale causato dall'abolizione dello studio della storia e della filosofia nelle scuole pubbliche. Il potere è attualmente mantenuto grazie ad avanzati strumenti di controllo informatici che intercettano, filtrano e rilevano qualunque tipo di comunicazione tra i cittadini. Le telecamere sono ovunque, i microfoni sono impiantati direttamente nelle mascelle dei cittadini e chip biometrici sotto forma di impianti sottocutanei vengono installati fin dalla nascita ad ogni bambino. Le università si sono trasformate in fondazioni private, tutte le ricerche che non dessero un vantaggio competitivo tecnologico o bellico scomparirono senza lasciar traccia, mentre l'esercito entrò come principale sovvenzionatore di ricerche su armi robotiche e software di controllo intelligenti a tal punto che gran parte dei centri di ricerca rimasti sono attualmente gestiti da ufficiali dell'esercito. Un gruppo di rivoltosi decise di ribellarsi al governo, rimuovendosi gli impianti e rifugiandosi nelle fogne, l'unico luogo cittadino non ancora sottoposto a sorveglianza. Le comunicazioni tra cellule di rivoltosi avvengono attualmente tramite una rete criptata che gli esperti del ministero delle comunicazioni non sono ancora riusciti a decifrare.");
        Slide s2 = new Slide("/avproject/images/s0_2.png", "Il gruppo di rivoltosi riceve una comunicazione cifrata da un mittente non identificato contente informazioni incredibili: al settimo piano del Dipartimento di Informatica di Bari sarebbe presente un software custodito all'interno di un computer nel museo dello stabile, contenente un'intelligenza artificiale estremamente sviluppata, capace di oscurare l'intero sistema di comunicazione del governo. Il software fu sviluppato nei primi anni della seconda decade del millennio ed è custodito sull'HD di un Cray CX1 all'insaputa dei militari che al momento gestiscono i vari laboratori di ricerca.");
        Slide s3 = new Slide("/avproject/images/s0_3.png", "I ribelli decidono di inviare un membro della loro organizzazione per recuperare il software. Riescono a farlo accedere all'edificio attraverso il sistema di scarico. L'intruso viene però rilevato come tale dal sistema di sicurezza che, incredibilmente, anziché sbarazzarsene, sfida l'intruso in una serie di enigmi di difficoltà crescente ad ogni piano del palazzo, fino al 7° ed ultimo piano dove si trova l'HD. ");
        ArrayList<Slide> als1 = new ArrayList<Slide>();
        als1.add(s1);
        als1.add(s2);
        als1.add(s3);
        Intermezzo intro = new Intermezzo(als1);

        //piano terra
        Locazione l0_ascensore = new Locazione("Ascensore - Piano Terra", 0, "L'ascensore è l'unico modo per muoversi tra i piani dell'edificio", "/avproject/images/l0_ascensore.png", "/avproject/images/ml0_ascensore.png", true, false, false);
        Locazione l0_1 = new Locazione(intro, "Bagni", 0, "C'è un water distrutto e sotto di esso un buco causato da un'esplosione. Le piastrelle sono di un colore rosa poco rassicurante", "/avproject/images/l0_1.png", "/avproject/images/ml0_1.png", true, false, false);
        Locazione l0_2 = new Locazione("Corridoio Macchinette", 0, "In questo corridoio si trovano le macchine automatiche che vendono caffè, bibite e i generi alimentari per il sostentamento degli studenti", "/avproject/images/l0_2.png", "/avproject/images/ml0_2.png", true, false, false);
        Locazione l0_3 = new Locazione(e1, "Sala Lettura", 0, "In sala lettura ci sono dei computer per la consultazione, sullo schermo di un computer compare una scritta", "/avproject/images/l0_3.png", "/avproject/images/ml0_3.png", true, false, false);
        Locazione l0_4 = new Locazione("Scale", 0, "Queste scale portano al piano terra", "/avproject/images/l0_4.png", "/avproject/images/ml0_4.png", true, false, false);
        Locazione l0_5 = new Locazione("Pianerottolo - Piano Terra", 0, "Il lucente marmo scuro sul pavimento e sulle pareti rende il pianerottolo alquanto lugubre", "/avproject/images/l0_5.png", "/avproject/images/ml0_5.png", true, false, false);
        Locazione l0_6 = new Locazione(e2, "Atrio", 0, "Nell'atrio c'è un gabbiotto per il portiere e c'è uno schermo multitouch solitamente usato come bacheca con sopra un messaggio cifrato.", "/avproject/images/l0_6.png", "/avproject/images/ml0_6.png", true, false, false);
        Locazione l0_7 = new Locazione("Aula Magna", 0, "L'aula principale in cui vengono svolte le lezioni, dotata di tutti i più moderni ritrovati tecnologici per la didattica, tutti accastati in un angolo a prendere polvere", "/avproject/images/l0_7.png", "/avproject/images/ml0_7.png", true, false, false);
        Locazione l0_8 = new Locazione("Aula 1", 0, "Identica all'Aula Magna non è stata ritenuta degna di un nome altisonante", "/avproject/images/l0_8.png", "/avproject/images/ml0_8.png", true, false, false);
        Locazione l0_9 = new Locazione("Sala d'attesa", 0, "Stanza con ai lati dei posti a sedere, solitamente usati dagli studenti tra una lezione e l'altra", "/avproject/images/l0_9.png", "/avproject/images/ml0_9.png", true, false, false);
        Locazione l0_10 = new Locazione(e4, "Corridoio", 0, "Un corridoio commemorativo dei padri dell'informatica. Si sente una voce proveniente dagli altoparlanti dire \"ci sono dei quadri in questo corridoio, ed io ne ho scelto uno. Puoi pormi delle domande per scoprire quale ho scelto, io potrò rispondere solo sì o no. Quante domande è sufficiente pormi per scoprire il quadro che ho scelto?\"", "/avproject/images/l0_10.png", "/avproject/images/ml0_10.png", true, false, false);
        Locazione l0_11 = new Locazione(e3, "Museo", 0, "Un museo contenente una serie di antichi cimeli della computazione. Tra di essi ce n'è uno dotato di un lettore di schede perforate. Sul monitor del computer compare il messaggio \"la scheda perforata presenta un errore in una riga, indica quale\"", "/avproject/images/l0_11.png", "/avproject/images/ml0_11.png", true, false, false);

        l0_1.setLocazioneNord(l0_2);
        l0_2.setLocazioneSud(l0_1);
        l0_2.setLocazioneNord(l0_3);
        l0_2.setLocazioneEst(l0_4);
        l0_3.setLocazioneSud(l0_2);
        l0_4.setLocazioneOvest(l0_2);
        l0_4.setLocazioneNord(l0_5);
        l0_5.setLocazioneSud(l0_4);
        l0_5.setLocazioneEst(l0_ascensore);
        l0_5.setLocazioneOvest(l0_6);
        l0_5.setLocazioneNord(l0_9);
        l0_ascensore.setLocazioneOvest(l0_5);
        l0_6.setLocazioneEst(l0_5);
        l0_6.setLocazioneSud(l0_7);
        l0_6.setLocazioneNord(l0_8);
        l0_7.setLocazioneNord(l0_6);
        l0_8.setLocazioneSud(l0_6);
        l0_9.setLocazioneSud(l0_5);
        l0_9.setLocazioneEst(l0_10);
        l0_10.setLocazioneOvest(l0_9);
        l0_10.setLocazioneSud(l0_11);
        l0_11.setLocazioneNord(l0_10);

        //primo piano
        Locazione l1_ascensore = new Locazione("Ascensore - Primo Piano", 0, "L'ascensore è l'unico modo per muoversi tra i piani dell'edificio", "/avproject/images/l1_ascensore.png", "/avproject/images/ml1_ascensore.png", true, false, false);
        Locazione l1_1 = new Locazione("Pianerottolo - Primo Piano", 1, "Il lucente marmo scuro sul pavimento e sulle pareti rende il pianerottolo alquanto lugubre. Sono affissi vari fogli ai muri con i risultati degli esami", "/avproject/images/l1_1.png", "/avproject/images/ml1_1.png", false, true, false);
        Locazione l1_2 = new Locazione("Corridoio Nord", 1, "Nel corridoio è presente un quadro elettrico, ma è chiuso da un dispositivo a riconoscimento della retina", "/avproject/images/l1_2.png", "/avproject/images/ml1_2.png", true, false, false);
        Locazione l1_3 = new Locazione(e5, "Aula Godel", 1, "Aula solitamente utilizzata per i seminari, al suo interno è presente una lavagna interattiva, ovvero un grande monitor multitouch. Sullo schermo compare una griglia, sembra essere una battaglia navale. Sotto la griglia c'è scritto: \"L'ultima cifra della somma dei numeri nel nome della nave ti indica la riga.\"", "/avproject/images/l1_3.png", "/avproject/images/ml1_3.png", true, false, false);
        Locazione l1_4 = new Locazione(e6, "Laboratorio Von Neumann", 1, "Laboratorio didattico, con una cospicua dotazione di computer collegati a degli schermi minuscoli. Al suo interno c'è un robot, una serie di computer ed una serie di hard disk su cui esso sta operando. Il robot dice: \"Il mio compito è di inserire gli hard disk nei computer in ordine dal più piccolo al più grande, ma per ordinarli posso confrontarne solo due per volta. Trovo prima il meno capiente confrontandoli tutti e lo metto da parte, poi cerco il meno capiente tra tutti i rimanenti e ripeto finché non ci sono più hard disk. Quanti confronti dovrò effettuare per disporli nel giusto ordine?\"", "/avproject/images/l1_4.png", "/avproject/images/ml1_4.png", true, false, false);
        Locazione l1_5 = new Locazione("Corridoio Sud", 1, "Nel corridoio si trova un rack contente svariati blade neri in un cabinet alto all'incirca 2 metri e 30. Il contenitore è chiuso da una serratura a riconoscimento della retina", "/avproject/images/l1_5.png", "/avproject/images/ml1_5.png", true, false, false);
        Locazione l1_6 = new Locazione(e7, "Biblioteca", 1, "Biblioteca molto fornita, ma che, per qualche strana ragione, rimane aperta solo due ore al giorno, rendendo impossibile agli studenti la fruizione dei libri in essa contenuti. Vicino ad uno scaffale c'è un robot, e una serie di libri di vari autori. Il robot dice: \"Devo creare uno schedario in ordine alfabetico degli autori di questi libri confrontandoli due a due. Parto prendendo il centrale e lo confronto con tutti gli altri per creare due sottoinsiemi: quelli precedenti e quelli successivi nell'ordine alfabetico. Ripeto l'operazione sui sottoinsiemi che ho ottenuto fintantoché lo schedario non è completamente ordinato. Quanti confronti dovrò effettuare per disporli nel giusto ordine?\"", "/avproject/images/l1_6.png", "/avproject/images/ml1_6.png", true, false, false);
        Locazione l1_7 = new Locazione(e8, "Aula Studio", 1, "Di giorno la sala studio è popolata di studenti che si sfidano in tornei di FPS o di videogiochi a sfondo calcistico e studentesse che rispondono ai commenti sulle proprie foto discinte presenti sui social network. A quest'ora della notte invece nella sala studio c'è solo un robot che sta operando su uno scaffale e una pila di dischi blu ray per la consultazione. Il robot dice: \"Devo ordinare questo scaffale in base alle etichette sulle custodie confrontandole due a due. Parto dalla prima della pila e la metto in ordine sullo scaffale, dopo le custodie che cominciano con una lettera precedente e prima delle custodie che cominciano con una lettera successiva e ripeto l'operazione fino a che la pila di custodie è vuota. Quanti confronti dovrò fare per per ottenere uno scaffale ordinato?\"", "/avproject/images/l1_7.png", "/avproject/images/ml1_7.png", true, false, false);

        l1_ascensore.setLocazioneOvest(l1_1);
        l1_1.setLocazioneEst(l1_ascensore);
        l1_1.setLocazioneNord(l1_2);
        l1_1.setLocazioneSud(l1_5);
        l1_2.setLocazioneSud(l1_1);
        l1_2.setLocazioneOvest(l1_3);
        l1_2.setLocazioneEst(l1_4);
        l1_3.setLocazioneEst(l1_2);
        l1_4.setLocazioneOvest(l1_2);
        l1_5.setLocazioneNord(l1_1);
        l1_5.setLocazioneOvest(l1_6);
        l1_5.setLocazioneEst(l1_7);
        l1_6.setLocazioneEst(l1_5);
        l1_7.setLocazioneOvest(l1_5);

        //secondo piano
        Locazione l2_ascensore = new Locazione("Ascensore - Secondo Piano", 0, "L'ascensore è l'unico modo per muoversi tra i piani dell'edificio", "/avproject/images/l2_ascensore.png", "/avproject/images/ml1_ascensore.png", true, false, false);
        Locazione l2_1 = new Locazione("Pianerottolo - Secondo Piano", 2, "Il lucente marmo scuro sul pavimento e sulle pareti rende il pianerottolo alquanto lugubre. Sono affissi vari fogli ai muri con avvisi di seminari", "/avproject/images/l1_1.png", "/avproject/images/ml1_1.png", false, true, false);
        Locazione l2_2 = new Locazione("Corridoio Nord", 2, "Nel corridoio c'è un dispositivo dotato di touch screen e telecamera montato al muro, probabilmente utilizzato per il riconoscimento dei dipendenti", "/avproject/images/l2_2.png", "/avproject/images/ml1_2.png", true, false, false);
        Locazione l2_3 = new Locazione(e9, "Segreteria", 2, "La segreteria ha 6 sportelli, cinque dei quali sono chiusi e pieni di polvere. All'interno di quello aperto c'è un robot che sta operando su uno scaffale e una pila di tesi di laurea. Su ognuna di esse è indicato l'anno accademico in cui è stata presentata. Il robot dice: \"Devo ordinare queste tesi di laurea in base all'anno accademico confrontandole due a due. Confronto la prima con la seconda e se l'anno è successivo le scambio di posto, continuando poi sulla seconda, la terza e così via, fin quando non trovo una tesi più nuova. Ripeto l'operazione dall'inizio finché le tesi non sono tutte ordinate.Quanti scambi dovrò effettuare?\"", "/avproject/images/l2_3.png", "/avproject/images/ml1_3.png", true, false, false);
        Locazione l2_4 = new Locazione(e10, "Uffici", 2, "Appesi ai muri degli uffici ci sono una serie di poster di congressi, perlomeno mascherano il grigio delle pareti. Vicino alla scrivania c'è un robot che sta operando su una pila di fogli, delle prove d'esame. Su ognuna di esse è indicata la votazione. Il robot dice: \"Devo ordinare queste prove d'esame in base al voto confrontandole due a due. Suddivido la pila di fogli in tanti gruppi quanti sono i fogli. Poi unisco i gruppi due a due confrontandoli mettendo sopra i fogli con i voti maggiori e scorrendo ciascun gruppo, e ripeto unendo in ordine i gruppi finché non ho ricostruito un'unica pila ordinata. Quanti confronti dovrò fare per per ottenere uno scaffale ordinato?\"", "/avproject/images/l2_4.png", "/avproject/images/ml1_4.png", true, false, false);
        Locazione l2_5 = new Locazione("Corridoio Sud", 2, "Nel corridoio c'è un fastidioso ronzio, probabilmente proveniente da una ventola difettosa nel sistea di areazione", "/avproject/images/l2_5.png", "/avproject/images/ml1_5.png", true, false, false);
        Locazione l2_6 = new Locazione(e11, "Aula Hume", 2, "Quest'aula è adibita allo sviluppo di progetti multimediali e presenta una strumentazione avanzata. Dagli altoparlanti dell'aula una voce dice: \"chi conclude prima il lavoro?\"", "/avproject/images/l2_6.png", "/avproject/images/ml1_6.png", true, false, false);
        Locazione l2_7 = new Locazione(e12, "Aula Boole", 2, "Quast'aula è adibita agli studi sulla robotica ed è dotata di componenti di braccia e arti artificiali. Sulla lavagna interattiva dell'aula è disegnata una mappa con delle città e tra di loro è possibile disegnare dei percorsi.", "/avproject/images/l2_7.png", "/avproject/images/ml1_7.png", true, false, false);

        l2_ascensore.setLocazioneOvest(l2_1);
        l2_1.setLocazioneEst(l2_ascensore);
        l2_1.setLocazioneNord(l2_2);
        l2_1.setLocazioneSud(l2_5);
        l2_2.setLocazioneSud(l2_1);
        l2_2.setLocazioneOvest(l2_3);
        l2_2.setLocazioneEst(l2_4);
        l2_3.setLocazioneEst(l2_2);
        l2_4.setLocazioneOvest(l2_2);
        l2_5.setLocazioneNord(l2_1);
        l2_5.setLocazioneOvest(l2_6);
        l2_5.setLocazioneEst(l2_7);
        l2_6.setLocazioneEst(l2_5);
        l2_7.setLocazioneOvest(l2_5);

        // locazione finale
        Locazione l3_ascensore = new Locazione("Ascensore - Terzo Piano", 0, "L'ascensore è l'unico modo per muoversi tra i piani dell'edificio", "/avproject/images/l3_ascensore.png", "/avproject/images/ml1_ascensore.png", true, false, false);
        Locazione l3_1 = new Locazione("Pianerottolo - Terzo Piano", 3, "Il gioco al momento finisce qui, complimenti per essere giunto fino al terzo piano... Nella prossima versione si arriverà fino al 7°, a presto!", "/avproject/images/l1_1.png", "/avproject/images/ml1_1.png", false, true, false);

        l3_ascensore.setLocazioneOvest(l3_1);
        //l3_1.setLocazioneEst(l3_ascensore);

        //ascensori
        l0_ascensore.setLocazioneNord(l1_ascensore);
        l1_ascensore.setLocazioneSud(l0_ascensore);
        l1_ascensore.setLocazioneNord(l2_ascensore);
        l2_ascensore.setLocazioneSud(l1_ascensore);
        l2_ascensore.setLocazioneNord(l3_ascensore);
        l3_ascensore.setLocazioneSud(l2_ascensore);

        //setta locazione attuale
        locazioneAttuale = l0_1;

        //setta primeGruppo
        primeGruppoSuccessivo.add(l1_1);
        primeGruppoSuccessivo.add(l2_1);
        primeGruppoSuccessivo.add(l3_1);
    }

    public void load() {
    }

    public void save() {
    }

    public void nuovaPartita() {
        //proponi questionario
        visualizzaQuestionario();

        //inferisci difficolta e visualizzazione iniziali
        interrogaRCP("livello_difficolta_iniziale");
        interrogaRCP("visualizzazione_iniziale");

        ModuloRCP.getInstance().printRCP("livello_difficolta_iniziale");
        ModuloRCP.getInstance().printRCP("visualizzazione_iniziale");

        this.inizializzazioneMappa();

        //setta statistiche
        StatisticheGruppo zero = new StatisticheGruppo();
        zero.setNumeroEnigmi(4);
        statistiche.add(zero);
        StatisticheGruppo uno = new StatisticheGruppo();
        uno.setNumeroEnigmi(4);
        statistiche.add(uno);
        StatisticheGruppo due = new StatisticheGruppo();
        due.setNumeroEnigmi(4);
        statistiche.add(due);

        cronometro.avanza();
        aggiornaInterfaccia();
    }

    public void rispostaInviata(int numeroRispsota) {
        if (numeroRispsota == locazioneAttuale.getEnigma().getNumeroRispostaEsatta()) {
            statistiche.get(locazioneAttuale.getGruppo()).setNumeroEnigmiRisolti(statistiche.get(locazioneAttuale.getGruppo()).getNumeroEnigmiRisolti() + 1);
            if (statistiche.get(locazioneAttuale.getGruppo()).getPercentualeEnigmiRisolti() >= 0.5) {
                primeGruppoSuccessivo.get(locazioneAttuale.getGruppo()).setRaggiungibile(true);
            }
            locazioneAttuale.getEnigma().setGiaRisolto(true);
            visualizzaMessaggio("Risposta Corretta");
        } else {
            locazioneAttuale.getEnigma().setNumeroRisposteErrate(locazioneAttuale.getEnigma().getNumeroRisposteErrate() + 1);
            visualizzaMessaggio("Risposta Errata");
        }
        aggiornaInterfaccia();
    }

    public void cambiaLocazione(String direzione) {
        if (direzione.equalsIgnoreCase("nord")) {
            if (locazioneAttuale.getLocazioneNord() != null) {
                if (locazioneAttuale.getLocazioneNord().isRaggiungibile()) {
                    if (locazioneAttuale.getLocazioneNord().getGruppo() != locazioneAttuale.getGruppo()) {
                        cambioGruppo();
                    }
                    if (locazioneAttuale.getLocazioneNord().isRicalcolaRCP() && !locazioneAttuale.getLocazioneNord().isGiaCalcolatoRCP()) {
                        interrogaRCP("ogni_livello");
                        ModuloRCP.getInstance().printRCP("ogni_livello");
                        locazioneAttuale.getLocazioneNord().setGiaCalcolatoRCP(true);
                    }
                    locazionePrecedente = locazioneAttuale;
                    locazioneAttuale = locazioneAttuale.getLocazioneNord();
                    aggiornaInterfaccia();
                } else {
                    visualizzaMessaggio("Locazione non raggiungibile\nL'ascensore non si apre, una voce proveniente dall'altoparlante dice: \"Per accedere al livello successivo è necessario risolvere almeno la metà degli enigmi\"");
                    aggiornaInterfaccia();
                }
            }
        } else if (direzione.equalsIgnoreCase("est")) {
            if (locazioneAttuale.getLocazioneEst() != null) {
                if (locazioneAttuale.getLocazioneEst().isRaggiungibile()) {
                    if (locazioneAttuale.getLocazioneEst().getGruppo() != locazioneAttuale.getGruppo()) {
                        cambioGruppo();
                    }
                    if (locazioneAttuale.getLocazioneEst().isRicalcolaRCP() && !locazioneAttuale.getLocazioneEst().isGiaCalcolatoRCP()) {
                        interrogaRCP("ogni_livello");
                        ModuloRCP.getInstance().printRCP("ogni_livello");
                        locazioneAttuale.getLocazioneEst().setGiaCalcolatoRCP(true);
                    }
                    locazionePrecedente = locazioneAttuale;
                    locazioneAttuale = locazioneAttuale.getLocazioneEst();
                    aggiornaInterfaccia();
                } else {
                    visualizzaMessaggio("Locazione non raggiungibile\nL'ascensore non si apre, una voce proveniente dall'altoparlante dice: \"Per accedere al livello successivo è necessario risolvere almeno la metà degli enigmi\"");
                    aggiornaInterfaccia();
                }
            }
        } else if (direzione.equalsIgnoreCase("ovest")) {
            if (locazioneAttuale.getLocazioneOvest() != null) {
                if (locazioneAttuale.getLocazioneOvest().isRaggiungibile()) {
                    if (locazioneAttuale.getLocazioneOvest().getGruppo() != locazioneAttuale.getGruppo()) {
                        cambioGruppo();
                    }
                    if (locazioneAttuale.getLocazioneOvest().isRicalcolaRCP() && !locazioneAttuale.getLocazioneOvest().isGiaCalcolatoRCP()) {
                        interrogaRCP("ogni_livello");
                        ModuloRCP.getInstance().printRCP("ogni_livello");

                        locazioneAttuale.getLocazioneOvest().setGiaCalcolatoRCP(true);
                    }
                    locazionePrecedente = locazioneAttuale;
                    locazioneAttuale = locazioneAttuale.getLocazioneOvest();
                    aggiornaInterfaccia();
                } else {
                    visualizzaMessaggio("Locazione non raggiungibile\nL'ascensore non si apre, una voce proveniente dall'altoparlante dice: \"Per accedere al livello successivo è necessario risolvere almeno la metà degli enigmi\"");
                    aggiornaInterfaccia();
                }
            }
        } else if (direzione.equalsIgnoreCase("sud")) {
            if (locazioneAttuale.getLocazioneSud() != null) {
                if (locazioneAttuale.getLocazioneSud().isRaggiungibile()) {
                    if (locazioneAttuale.getLocazioneSud().getGruppo() != locazioneAttuale.getGruppo()) {
                        cambioGruppo();
                    }
                    if (locazioneAttuale.getLocazioneSud().isRicalcolaRCP() && !locazioneAttuale.getLocazioneSud().isGiaCalcolatoRCP()) {
                        interrogaRCP("ogni_livello");
                        ModuloRCP.getInstance().printRCP("ogni_livello");
                        locazioneAttuale.getLocazioneSud().setGiaCalcolatoRCP(true);
                    }
                    locazionePrecedente = locazioneAttuale;
                    locazioneAttuale = locazioneAttuale.getLocazioneSud();
                    aggiornaInterfaccia();
                } else {
                    visualizzaMessaggio("Locazione non raggiungibile\nL'ascensore non si apre, una voce proveniente dall'altoparlante dice: \"Per accedere al livello successivo è necessario risolvere almeno la metà degli enigmi\"");
                    aggiornaInterfaccia();
                }
            }
        }
        if (tipoVisualizzazioneMomentanea != null) {
            tipoVisualizzazioneMomentanea = null;
        }
    }

    //imposta il tempo impiegato nelle statistiche
    //da farsi prima di aggiornare la RCP
    public void cambioGruppo() {
        cronometro.ferma();
        statistiche.get(locazioneAttuale.getGruppo()).setTempoImpiegato(cronometro.leggi());
        cronometro.riavvia();
    }

    public void cambiaVisualizzazione() {
        if (tipoVisualizzazioneMomentanea == null) {
            if (tipoVisualizzazioneAttuale.equals("testuale")) {
                tipoVisualizzazioneMomentanea = "grafica";
            } else {
                tipoVisualizzazioneMomentanea = "testuale";
            }
            statistiche.get(locazioneAttuale.getGruppo()).setNumeroCambiModalita(statistiche.get(locazioneAttuale.getGruppo()).getNumeroCambiModalita() + 1);
            System.out.println("cambi = " + statistiche.get(locazioneAttuale.getGruppo()).getNumeroCambiModalita());
        } else {
            if (tipoVisualizzazioneAttuale.equals(tipoVisualizzazioneMomentanea)) {
                if (tipoVisualizzazioneMomentanea.equals("testuale")) {
                    tipoVisualizzazioneMomentanea = "grafica";
                } else {
                    tipoVisualizzazioneMomentanea = "testuale";
                }
                statistiche.get(locazioneAttuale.getGruppo()).setNumeroCambiModalita(statistiche.get(locazioneAttuale.getGruppo()).getNumeroCambiModalita() + 1);
                System.out.println("cambi = " + statistiche.get(locazioneAttuale.getGruppo()).getNumeroCambiModalita());
            } else {
                tipoVisualizzazioneMomentanea = tipoVisualizzazioneAttuale;
                statistiche.get(locazioneAttuale.getGruppo()).setNumeroCambiModalita(statistiche.get(locazioneAttuale.getGruppo()).getNumeroCambiModalita() - 1);
                System.out.println("cambi = " + statistiche.get(locazioneAttuale.getGruppo()).getNumeroCambiModalita());
            }
        }
    }

    public void aggiornaInterfaccia() {
        //se c'è intermezzo e non è già stato visualizzato, visualizzarlo e poi settare gia visualizzato a true
        if (locazioneAttuale.getIntermezzo() != null) {
            if (!locazioneAttuale.getIntermezzo().isGiaVisto()) {
                ControllerInterfacciaStoria controllerStoria = new ControllerInterfacciaStoria(locazioneAttuale.getIntermezzo());
                controllerStoria.mostraStoria();
                locazioneAttuale.getIntermezzo().setGiaVisto(true);
            }
        }
        //se c'è un enigma....
        //se l'enigma è già stato risolto, non riproporlo, altrimenti proporlo
        //se il numero di rispsote errate è maggiore o uguale a 2 visualizzare "troppe rispsote errate" o qalcosa di simile
        //visualizzare interfaccia di gioco

        ControllerInterfacciaGioco controllerIGioco = new ControllerInterfacciaGioco();
        if (tipoVisualizzazioneMomentanea == null) {
            controllerIGioco.mostraInterfacciaGioco(locazioneAttuale, difficoltaAttuale, tipoVisualizzazioneAttuale);
        } else {
            controllerIGioco.mostraInterfacciaGioco(locazioneAttuale, difficoltaAttuale, tipoVisualizzazioneMomentanea);
        }
    }

    public void visualizzaMessaggio(String messaggio) {
        //apre una finestra modale che visualizza un messaggio
        InterfacciaMessaggio im = new InterfacciaMessaggio(messaggio);
        im.setVisible(true);
    }

    public void visualizzaIndizio() {
        if (!locazioneAttuale.getEnigma().isIndizioGiaMostrato()) {
            statistiche.get(locazioneAttuale.getGruppo()).setNumeroIndiziUsati(statistiche.get(locazioneAttuale.getGruppo()).getNumeroIndiziUsati() + 1);
        }
        visualizzaMessaggio(locazioneAttuale.getEnigma().getIndizio());
    }

    public void visualizzaQuestionario() {
        //visualizza un interfaccia che interroghi l'utente
        //salvare le rispsote in risultati
        ControllerInterfacciaQuestionario controller = new ControllerInterfacciaQuestionario();
        controller.mostraInterfacciaQuestionario();
    }

    public void interrogaRCP(String rete) {
        ModuloRCP modulo = ModuloRCP.getInstance();
        if (rete.equalsIgnoreCase("ogni_livello")) {
            //prendi informazioni da statistiche del livello attuale
            //setta difficolta e visualizzazione

            // legge l'oggetto delle statistiche della locazione attuale
            StatisticheGruppo stat = statistiche.get(locazioneAttuale.getGruppo());

            double percAiuti = stat.getPercentualeIndiziUsati();
            double percEnigmi = stat.getPercentualeEnigmiRisolti();
            double tempoMedio = stat.getTempoMedioPerEnigma();
            double percCambi = stat.getPercentualeCambiModalita();
            long indice_stato;

            if (percAiuti <= 0.5) {
                indice_stato = 0;
            } else {
                indice_stato = 1;
            }
            modulo.setEvidence("ogni_livello", "Aiuti_Utilizzati", indice_stato);

            if (percEnigmi <= 0.5) {
                indice_stato = 0;
            } else if (percEnigmi <= 0.75) {
                indice_stato = 1;
            } else {
                indice_stato = 2;
            }
            modulo.setEvidence("ogni_livello", "Enigmi_Risolti", indice_stato);

            if (tempoMedio <= 180000) //180000 = 3 min
            {
                indice_stato = 0;
            } else if (tempoMedio <= 300000) //300000 = 5 min
            {
                indice_stato = 1;
            } else {
                indice_stato = 2;
            }
            modulo.setEvidence("ogni_livello", "Tempo_Impiegato", indice_stato);

            if (percCambi <= 0.25) {
                indice_stato = 0;
            } else if (percCambi <= 0.50) {
                indice_stato = 1;
            } else {
                indice_stato = 2;
            }
            modulo.setEvidence("ogni_livello", "Cambi_Modalita", indice_stato);

            if (difficoltaAttuale.equalsIgnoreCase("facile")) {
                indice_stato = 0;
            } else if (difficoltaAttuale.equalsIgnoreCase("medio")) {
                indice_stato = 1;
            } else {
                indice_stato = 2;
            }
            modulo.setEvidence("ogni_livello", "Livello_Difficolta_Precedente", indice_stato);

            if (tipoVisualizzazioneAttuale.equalsIgnoreCase("testuale")) {
                indice_stato = 0;
            } else {
                indice_stato = 1;
            }
            modulo.setEvidence("ogni_livello", "Visualizzazione_Precedente", indice_stato);


            // legge i belief del nodo Livello_difficolta e setta il relativo campo
            double facile = modulo.getBelief("ogni_livello", "Livello_Difficolta", 0);
            double medio = modulo.getBelief("ogni_livello", "Livello_Difficolta", 1);
            double difficile = modulo.getBelief("ogni_livello", "Livello_Difficolta", 2);

            if (facile > medio) {
                if (facile > difficile) {
                    difficoltaAttuale = "facile";
                } else {
                    difficoltaAttuale = "difficile";
                }
            } else if (medio > difficile) {
                difficoltaAttuale = "medio";
            } else {
                difficoltaAttuale = "difficile";
            }

            // legge i belief del nodo Visualizzazione e setta il relativo campo
            double testuale = modulo.getBelief("ogni_livello", "Visualizzazione", 0);
            double grafica = modulo.getBelief("ogni_livello", "Visualizzazione", 1);

            if (testuale > grafica) {
                tipoVisualizzazioneAttuale = "testuale";
            } else {
                tipoVisualizzazioneAttuale = "grafica";
            }

        } else if (rete.equalsIgnoreCase("livello_difficolta_iniziale")) {
            //prendi info da risultati questionario
            //setta difficolta

            // setta il nodo Conosce_Informatica
            if (risultati.isStudiatoInformatica()) {
                //se ha studiato università, setto MOLTO
                if (risultati.getGradoIstruzione().equalsIgnoreCase("università")) {
                    modulo.setEvidence("livello_difficolta_iniziale", "Conosce_Informatica", 0);
                } //se ha studiato licelo, setto MEDIO
                else if (risultati.getGradoIstruzione().equalsIgnoreCase("liceo")) {
                    modulo.setEvidence("livello_difficolta_iniziale", "Conosce_Informatica", 1);
                }
            } else {
                // se non ha studiato informatica
                // se ha usato dbms e ide, setto MOLTO
                if (risultati.isUsatoDBMS() && risultati.isUsatoIDE()) {
                    modulo.setEvidence("livello_difficolta_iniziale", "Conosce_Informatica", 0);
                } // se NON ha usato dbms e ide, setto POCO
                else if (!risultati.isUsatoDBMS() && !risultati.isUsatoIDE()) {
                    modulo.setEvidence("livello_difficolta_iniziale", "Conosce_Informatica", 2);
                } else // negli altri casi, setto MEDIO
                {
                    modulo.setEvidence("livello_difficolta_iniziale", "Conosce_Informatica", 1);
                }
            }

            //setta il nodo Gia_Giocato
            if (risultati.isGiaGiocato()) {
                modulo.setEvidence("livello_difficolta_iniziale", "Gia_Giocato", 1);
            } else {
                modulo.setEvidence("livello_difficolta_iniziale", "Gia_Giocato", 0);
            }

            // legge i belief del nodo Livello_difficolta e setta il relativo campo
            double facile = modulo.getBelief("livello_difficolta_iniziale", "Livello_Difficolta", 0);
            double medio = modulo.getBelief("livello_difficolta_iniziale", "Livello_Difficolta", 1);
            double difficile = modulo.getBelief("livello_difficolta_iniziale", "Livello_Difficolta", 2);

            if (facile > medio) {
                if (facile > difficile) {
                    difficoltaAttuale = "facile";
                } else {
                    difficoltaAttuale = "difficile";
                }
            } else if (medio > difficile) {
                difficoltaAttuale = "medio";
            } else {
                difficoltaAttuale = "difficile";
            }

        } else if (rete.equalsIgnoreCase("visualizzazione_iniziale")) {
            //prendi info da risultati questionario
            //setta visualizzazione

            // setta il nodo Propensione
            // se sono entrambe corrette/scorrette, si mantiene lo 0.5% di possibilità senza inserire evidenze
            if (risultati.isIndovinelloTestualeCorretto()) {
                if (!risultati.isIndovinelloGraficoCorretto()) {
                    modulo.setEvidence("visualizzazione_iniziale", "Propensione", 0);
                }
            } else if (risultati.isIndovinelloGraficoCorretto()) {
                modulo.setEvidence("visualizzazione_iniziale", "Propensione", 1);
            }

            // setta il nodo Visualizzazione_Preferita
            if (risultati.getPreferenzaVisualizzazione().equalsIgnoreCase("testuale")) {
                modulo.setEvidence("visualizzazione_iniziale", "Visualizzazione_Preferita", 0);
            } else {
                modulo.setEvidence("visualizzazione_iniziale", "Visualizzazione_Preferita", 1);
            }

            // legge i belief del nodo Visualizzazione e setta il relativo campo
            double testuale = modulo.getBelief("visualizzazione_iniziale", "Visualizzazione", 0);
            double grafica = modulo.getBelief("visualizzazione_iniziale", "Visualizzazione", 1);

            if (testuale > grafica) {
                tipoVisualizzazioneAttuale = "testuale";
            } else {
                tipoVisualizzazioneAttuale = "grafica";
            }
        }

    }

    public void setRisultatiQuestionario(RisultatiQuestionario risultati) {
        this.risultati = risultati;
    }
}
