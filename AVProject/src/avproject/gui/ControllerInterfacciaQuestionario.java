/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package avproject.gui;

import avproject.control.MotoreGioco;
import avproject.util.RisultatiQuestionario;

/**
 *
 * @author Gianni
 */
public class ControllerInterfacciaQuestionario {
    boolean confirmed = false;

    public ControllerInterfacciaQuestionario(){

    }

    public void mostraInterfacciaQuestionario(){
        final ControllerInterfacciaQuestionario controller = this;
        //java.awt.EventQueue.invokeLater(new Runnable() {
         //   public void run() {
                new InterfacciaQuestionario(controller).setVisible(true);
       //     }
        //});
    }

    public void setRisultatiQuestionario(boolean studiatoInformaticaSi, boolean scuolaSuperiore, boolean editorTesti, boolean dbms, boolean ide, boolean giaGiocatoSi, boolean figura4,  boolean parola4, boolean grafico) {
        RisultatiQuestionario risultati = new RisultatiQuestionario();

        risultati.setStudiatoInformatica(studiatoInformaticaSi);
        if (scuolaSuperiore)
            risultati.setGradoIstruzione("superiore");
        else
            risultati.setGradoIstruzione("università");
        risultati.setUsatoEditorTesti(editorTesti);
        risultati.setUsatoDBMS(dbms);
        risultati.setUsatoIDE(ide);
        risultati.setGiaGiocato(giaGiocatoSi);
        risultati.setIndovinelloGraficoCorretto(figura4);
        risultati.setIndovinelloTestualeCorretto(parola4);
        if (grafico)
            risultati.setPreferenzaVisualizzazione("grafico");
        else
            risultati.setPreferenzaVisualizzazione("testuale");

        MotoreGioco motore = MotoreGioco.getInstance();
        motore.setRisultatiQuestionario(risultati);
        setConfirmed(true);
    }

    public void setConfirmed(boolean stato) {
        confirmed = stato;
    }

    public boolean isConfirmed(){
        return confirmed;
    }



}
