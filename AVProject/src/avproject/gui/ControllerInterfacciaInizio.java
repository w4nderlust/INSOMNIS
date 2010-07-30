/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package avproject.gui;

import avproject.control.MotoreGioco;

/**
 *
 * @author w4nder
 */
public class ControllerInterfacciaInizio {

    public ControllerInterfacciaInizio() {
    }

    public void mostraInterfacciaInizio() {
        final ControllerInterfacciaInizio controller = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfacciaInizio(controller).setVisible(true);
            }
        });
    }

    public void iniziaGioco() {
        MotoreGioco motoreGioco = MotoreGioco.getInstance();
        motoreGioco.nuovaPartita();
    }
}
