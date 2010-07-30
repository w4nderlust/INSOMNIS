/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package avproject.util;

/**
 *
 * @author Piero
 */
public class RisultatiQuestionario {
    private boolean studiatoInformatica;
    private String gradoIstruzione;
    private boolean usatoEditorTesti;
    private boolean usatoDBMS;
    private boolean usatoIDE;
    private boolean giaGiocato;
    private boolean indovinelloTestualeCorretto;
    private boolean indovinelloGraficoCorretto;
    private String preferenzaVisualizzazione;

    public RisultatiQuestionario() {
    }

    public boolean isGiaGiocato() {
        return giaGiocato;
    }

    public String getGradoIstruzione() {
        return gradoIstruzione;
    }

    public boolean isIndovinelloGraficoCorretto() {
        return indovinelloGraficoCorretto;
    }

    public boolean isIndovinelloTestualeCorretto() {
        return indovinelloTestualeCorretto;
    }

    public String getPreferenzaVisualizzazione() {
        return preferenzaVisualizzazione;
    }

    public boolean isStudiatoInformatica() {
        return studiatoInformatica;
    }

    public boolean isUsatoDBMS() {
        return usatoDBMS;
    }

    public boolean isUsatoEditorTesti() {
        return usatoEditorTesti;
    }

    public boolean isUsatoIDE() {
        return usatoIDE;
    }

    public void setGiaGiocato(boolean giaGiocato) {
        this.giaGiocato = giaGiocato;
    }

    public void setGradoIstruzione(String gradoIstruzione) {
        this.gradoIstruzione = gradoIstruzione;
    }

    public void setIndovinelloGraficoCorretto(boolean indovinelloGraficoCorretto) {
        this.indovinelloGraficoCorretto = indovinelloGraficoCorretto;
    }

    public void setIndovinelloTestualeCorretto(boolean indovinelloTestualeCorretto) {
        this.indovinelloTestualeCorretto = indovinelloTestualeCorretto;
    }

    public void setPreferenzaVisualizzazione(String preferenzaVisualizzazione) {
        this.preferenzaVisualizzazione = preferenzaVisualizzazione;
    }

    public void setStudiatoInformatica(boolean studiatoInformatica) {
        this.studiatoInformatica = studiatoInformatica;
    }

    public void setUsatoDBMS(boolean usatoDBMS) {
        this.usatoDBMS = usatoDBMS;
    }

    public void setUsatoEditorTesti(boolean usatoEditorTesti) {
        this.usatoEditorTesti = usatoEditorTesti;
    }

    public void setUsatoIDE(boolean usatoIDE) {
        this.usatoIDE = usatoIDE;
    }

    
}
