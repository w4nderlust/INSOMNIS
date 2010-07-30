
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package avproject.model;

/**
 *
 * @author w4nder
 */
public class StatisticheGruppo {

    // va diviso per il numero di enigmi per avere una percentuale
    private double numeroCambiModalita;
    private double numeroEnigmi;

    // va diviso per il numero di enigmi per sapere la percentuale di enigmi risolti
    private double numeroEnigmiRisolti;

    // va diviso per il numero di enigmi per avere una percentuale di indizi
    // ricordarsi di aggiugnere uno agli indizi usati non ad ogni click ma ad ogni enigma di cui viene visualizato l'indizio
    private double numeroIndiziUsati;

    // va diviso per il numero di enigmi per avere una media del tempo per enigma
    private long tempoImpiegato;

    public StatisticheGruppo() {
        this.numeroCambiModalita = 0;
        this.numeroEnigmi = 0;
        this.numeroEnigmiRisolti = 0;
        this.numeroIndiziUsati = 0;
        this.tempoImpiegato = 0;
    }

    public double getNumeroCambiModalita() {
        return numeroCambiModalita;
    }

    public double getNumeroEnigmi() {
        return numeroEnigmi;
    }

    public double getNumeroEnigmiRisolti() {
        return numeroEnigmiRisolti;
    }

    public double getNumeroIndiziUsati() {
        return numeroIndiziUsati;
    }

    public long getTempoImpiegato() {
        return tempoImpiegato;
    }

    public double getPercentualeEnigmiRisolti() {
        return (numeroEnigmiRisolti / numeroEnigmi);
    }

    public double getPercentualeIndiziUsati() {
        return (numeroIndiziUsati / numeroEnigmi);
    }

    public double getPercentualeCambiModalita() {
        return (numeroCambiModalita / numeroEnigmi);
    }

    public double getTempoMedioPerEnigma() {
        return (tempoImpiegato / numeroEnigmi);
    }

    public void setNumeroCambiModalita(double numeroCambiModalita) {
        this.numeroCambiModalita = numeroCambiModalita;
    }

    public void setNumeroEnigmi(double numeroEnigmi) {
        this.numeroEnigmi = numeroEnigmi;
    }

    public void setNumeroEnigmiRisolti(double numeroEnigmiRisolti) {
        this.numeroEnigmiRisolti = numeroEnigmiRisolti;
    }

    public void setNumeroIndiziUsati(double numeroIndiziUsati) {
        this.numeroIndiziUsati = numeroIndiziUsati;
    }

    public void setTempoImpiegato(long tempoImpiegato) {
        this.tempoImpiegato = tempoImpiegato;
    }
    
}