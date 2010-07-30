package avproject.model;

import java.io.File;

public class Locazione {
    private Enigma     enigma;
    private Intermezzo intermezzo;
    private Locazione  locazioneNord, locazioneSud, locazioneEst, locazioneOvest;
    private int        gruppo;
    private String     nome, descrizione;
    private String       fileIllustrazione, fileImmagineMappa;
    private boolean    raggiungibile, ricalcolaRCP, giaCalcolatoRCP, intermezzoVisualizzato;

    public Locazione(String nome, int gruppo, String descrizione, String fileIllustrazione, String fileImmagineMappa, boolean raggiungibile, boolean ricalcolaRCP, boolean giaCalcolatoRCP) {
        this.enigma = null;
        this.nome = nome;
        this.gruppo = gruppo;
        this.descrizione = descrizione;
        this.fileIllustrazione = fileIllustrazione;
        this.fileImmagineMappa = fileImmagineMappa;
        this.raggiungibile = raggiungibile;
        this.ricalcolaRCP = ricalcolaRCP;
        this.giaCalcolatoRCP = giaCalcolatoRCP;

        this.locazioneEst = null;
        this.locazioneNord = null;
        this.locazioneOvest = null;
        this.locazioneSud = null;
        this.intermezzo = null;
    }

    public Locazione(Enigma enigma, String nome, int gruppo, String descrizione, String fileIllustrazione, String fileImmagineMappa, boolean raggiungibile, boolean ricalcolaRCP, boolean giaCalcolatoRCP) {
        this.enigma = enigma;
        this.nome = nome;
        this.gruppo = gruppo;
        this.descrizione = descrizione;
        this.fileIllustrazione = fileIllustrazione;
        this.fileImmagineMappa = fileImmagineMappa;
        this.raggiungibile = raggiungibile;
        this.ricalcolaRCP = ricalcolaRCP;
        this.giaCalcolatoRCP = giaCalcolatoRCP;
        
        this.locazioneEst = null;
        this.locazioneNord = null;
        this.locazioneOvest = null;
        this.locazioneSud = null;
        this.intermezzo = null;
    }

    public Locazione(Enigma enigma, Intermezzo intermezzo, String nome, int gruppo, String descrizione, String fileIllustrazione, String fileImmagineMappa, boolean raggiungibile, boolean ricalcolaRCP, boolean giaCalcolatoRCP) {
        this.enigma = enigma;
        this.intermezzo = intermezzo;
        this.nome = nome;
        this.gruppo = gruppo;
        this.descrizione = descrizione;
        this.fileIllustrazione = fileIllustrazione;
        this.fileImmagineMappa = fileImmagineMappa;
        this.raggiungibile = raggiungibile;
        this.ricalcolaRCP = ricalcolaRCP;
        this.giaCalcolatoRCP = giaCalcolatoRCP;

        this.locazioneEst = null;
        this.locazioneNord = null;
        this.locazioneOvest = null;
        this.locazioneSud = null;
    }

    public Locazione(Intermezzo intermezzo, String nome, int gruppo, String descrizione, String fileIllustrazione, String fileImmagineMappa, boolean raggiungibile, boolean ricalcolaRCP, boolean giaCalcolatoRCP) {
        this.enigma = null;
        this.intermezzo = intermezzo;
        this.nome = nome;
        this.gruppo = gruppo;
        this.descrizione = descrizione;
        this.fileIllustrazione = fileIllustrazione;
        this.fileImmagineMappa = fileImmagineMappa;
        this.raggiungibile = raggiungibile;
        this.ricalcolaRCP = ricalcolaRCP;
        this.giaCalcolatoRCP = giaCalcolatoRCP;

        this.locazioneEst = null;
        this.locazioneNord = null;
        this.locazioneOvest = null;
        this.locazioneSud = null;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Enigma getEnigma() {
        return enigma;
    }

    public String getFileIllustrazione() {
        return fileIllustrazione;
    }

    public String getFileImmagineMappa() {
        return fileImmagineMappa;
    }

    public boolean isGiaCalcolatoRCP() {
        return giaCalcolatoRCP;
    }

    public int getGruppo() {
        return gruppo;
    }

    public Intermezzo getIntermezzo() {
        return intermezzo;
    }

    public Locazione getLocazioneEst() {
        return locazioneEst;
    }

    public Locazione getLocazioneNord() {
        return locazioneNord;
    }

    public Locazione getLocazioneOvest() {
        return locazioneOvest;
    }

    public Locazione getLocazioneSud() {
        return locazioneSud;
    }

    public String getNome() {
        return nome;
    }

    public boolean isRaggiungibile() {
        return raggiungibile;
    }

    public boolean isRicalcolaRCP() {
        return ricalcolaRCP;
    }

    public boolean isIntermezzoVisualizzato() {
        return intermezzoVisualizzato;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setEnigma(Enigma enigma) {
        this.enigma = enigma;
    }

    public void setFileIllustrazione(String fileIllustrazione) {
        this.fileIllustrazione = fileIllustrazione;
    }

    public void setFileImmagineMappa(String fileImmagineMappa) {
        this.fileImmagineMappa = fileImmagineMappa;
    }

    public void setGiaCalcolatoRCP(boolean giaCalcolatoRCP) {
        this.giaCalcolatoRCP = giaCalcolatoRCP;
    }

    public void setGruppo(int gruppo) {
        this.gruppo = gruppo;
    }

    public void setIntermezzo(Intermezzo intermezzo) {
        this.intermezzo = intermezzo;
    }

    public void setLocazioneEst(Locazione locazioneEst) {
        this.locazioneEst = locazioneEst;
    }

    public void setLocazioneNord(Locazione locazioneNord) {
        this.locazioneNord = locazioneNord;
    }

    public void setLocazioneOvest(Locazione locazioneOvest) {
        this.locazioneOvest = locazioneOvest;
    }

    public void setLocazioneSud(Locazione locazioneSud) {
        this.locazioneSud = locazioneSud;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaggiungibile(boolean raggiungibile) {
        this.raggiungibile = raggiungibile;
    }

    public void setRicalcolaRCP(boolean ricalcolaRCP) {
        this.ricalcolaRCP = ricalcolaRCP;
    }

    public void setIntermezzoVisualizzato(boolean intermezzoVisualizzato) {
        this.intermezzoVisualizzato = intermezzoVisualizzato;
    }

}
