package avproject.gui;

import avproject.control.MotoreGioco;
import avproject.model.Locazione;

public class ControllerInterfacciaGioco {
    
    public ControllerInterfacciaGioco(){
        
    }

    public void mostraInterfacciaGioco(final Locazione locazione, final String difficoltaAttuale, final String tipoVisualizzaizoneAttuale) {
        final ControllerInterfacciaGioco controller = this;
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new InterfacciaGioco(locazione, difficoltaAttuale, tipoVisualizzaizoneAttuale, controller).setVisible(true);
            }
        });
    }

    public void setDirection(String direzione){
        MotoreGioco motore = MotoreGioco.getInstance();
        motore.cambiaLocazione(direzione);
    }

    public void confermaRisposta(boolean risposta1, boolean risposta2, boolean risposta3, boolean risposta4){
        MotoreGioco motore = MotoreGioco.getInstance();
        if (risposta1)
            motore.rispostaInviata(1);
        else if (risposta2)
            motore.rispostaInviata(2);
        else if (risposta3)
            motore.rispostaInviata(3);
        else if (risposta4)
            motore.rispostaInviata(4);
        else {
            motore.visualizzaMessaggio("Non si è selezionata alcuna risposta.");
            motore.aggiornaInterfaccia();
        }
        
    }

    public void cambiaVisualizzazione() {
        MotoreGioco motore = MotoreGioco.getInstance();
        motore.cambiaVisualizzazione();
        motore.aggiornaInterfaccia();
    }

    public void visualizzaIndizio() {
        MotoreGioco motore = MotoreGioco.getInstance();
        motore.visualizzaIndizio();
    }
}
