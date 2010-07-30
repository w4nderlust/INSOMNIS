package avproject.gui;

import avproject.model.Intermezzo;
import avproject.model.Slide;
import java.util.ArrayList;
import java.util.Iterator;

public class ControllerInterfacciaStoria {

    private Intermezzo intermezzo;

    public ControllerInterfacciaStoria(Intermezzo intermezzo) {
        this.intermezzo = intermezzo;
    }

    public void mostraStoria() {
        ArrayList<Slide> slides = intermezzo.getListaSlide();
        Iterator<Slide> si = slides.iterator();
        while (si.hasNext()) {
            new InterfacciaStoria(si.next()).setVisible(true);
        }
    }


}
