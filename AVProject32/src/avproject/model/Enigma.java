package avproject.model;

//~--- JDK imports ------------------------------------------------------------

import java.util.*;

public class Enigma {
    private String  indizio;
    private boolean giaRisolto;
    private boolean indizioGiaMostrato;
    private String              fileImmagineFacile, fileImmagineMedio, fileImmagineDifficile;
    private String            testoEnigmaFacile, testoEnigmaMedio, testoEnigmaDifficile;
    private int               numeroRispostaEsatta, numeroRisposteErrate;
    private ArrayList<String> risposteFacili, risposteMedia, risposteDifficili;

    public Enigma(String indizio, boolean giaRisolto, String fileImmagineFacile, String fileImmagineMedio, String fileImmagineDifficile, String testoEnigmaFacile, String testoEnigmaMedio, String testoEnigmaDifficile, int numeroRispostaEsatta, ArrayList<String> risposteFacili, ArrayList<String> rispsoteMedia, ArrayList<String> rispsoteDifficili) {
        this.indizio = indizio;
        this.giaRisolto = giaRisolto;
        this.indizioGiaMostrato = false;
        this.fileImmagineFacile = fileImmagineFacile;
        this.fileImmagineMedio = fileImmagineMedio;
        this.fileImmagineDifficile = fileImmagineDifficile;
        this.testoEnigmaFacile = testoEnigmaFacile;
        this.testoEnigmaMedio = testoEnigmaMedio;
        this.testoEnigmaDifficile = testoEnigmaDifficile;
        this.numeroRispostaEsatta = numeroRispostaEsatta;
        this.risposteFacili = risposteFacili;
        this.risposteMedia = rispsoteMedia;
        this.risposteDifficili = rispsoteDifficili;
        this.numeroRisposteErrate = 0;
    }



    public String getIndizio() {
        return indizio;
    }

    public String getFileImmagineDifficile() {
        return fileImmagineDifficile;
    }

    public String getFileImmagineFacile() {
        return fileImmagineFacile;
    }

    public String getFileImmagineMedio() {
        return fileImmagineMedio;
    }

    public boolean isGiaRisolto() {
        return giaRisolto;
    }

    public int getNumeroRispostaEsatta() {
        return numeroRispostaEsatta;
    }

    public String getTestoEnigmaDifficile() {
        return testoEnigmaDifficile;
    }

    public String getTestoEnigmaFacile() {
        return testoEnigmaFacile;
    }

    public String getTestoEnigmaMedio() {
        return testoEnigmaMedio;
    }

    public int getNumeroRisposteErrate() {
        return numeroRisposteErrate;
    }

    public boolean isIndizioGiaMostrato() {
        return indizioGiaMostrato;
    }

    public void setIndizio(String indizio) {
        this.indizio = indizio;
    }

    public void setFileImmagineDifficile(String fileImmagineDifficile) {
        this.fileImmagineDifficile = fileImmagineDifficile;
    }

    public void setFileImmagineFacile(String fileImmagineFacile) {
        this.fileImmagineFacile = fileImmagineFacile;
    }

    public void setFileImmagineMedio(String fileImmagineMedio) {
        this.fileImmagineMedio = fileImmagineMedio;
    }

    public void setGiaRisolto(boolean giaRisolto) {
        this.giaRisolto = giaRisolto;
    }

    public void setNumeroRispostaEsatta(int numeroRispostaEsatta) {
        this.numeroRispostaEsatta = numeroRispostaEsatta;
    }

    public void setTestoEnigmaDifficile(String testoEnigmaDifficile) {
        this.testoEnigmaDifficile = testoEnigmaDifficile;
    }

    public void setTestoEnigmaFacile(String testoEnigmaFacile) {
        this.testoEnigmaFacile = testoEnigmaFacile;
    }

    public void setTestoEnigmaMedio(String testoEnigmaMedio) {
        this.testoEnigmaMedio = testoEnigmaMedio;
    }

    public void setNumeroRisposteErrate(int numeroRisposteErrate) {
        this.numeroRisposteErrate = numeroRisposteErrate;
    }

    public void setIndizioGiaMostrato(boolean indizioGiaMostrato) {
        this.indizioGiaMostrato = indizioGiaMostrato;
    }

    public ArrayList<String> getRisposteFacili() {
        return risposteFacili;
    }

    public ArrayList<String> getRisposteDifficili() {
        return risposteDifficili;
    }

    public ArrayList<String> getRisposteMedia() {
        return risposteMedia;
    }

    public void setRisposteFacili(ArrayList<String> risposteFacili) {
        this.risposteFacili = risposteFacili;
    }

    public void setRispsoteDifficili(ArrayList<String> rispsoteDifficili) {
        this.risposteDifficili = rispsoteDifficili;
    }

    public void setRispsoteMedia(ArrayList<String> rispsoteMedia) {
        this.risposteMedia = rispsoteMedia;
    }

}

