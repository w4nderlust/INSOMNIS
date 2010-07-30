package avproject.model;

//~--- JDK imports ------------------------------------------------------------

import java.util.*;

public class Intermezzo {
    private boolean giaVisto;
    private ArrayList<Slide> listaSlide;

    public Intermezzo() {
        listaSlide = new ArrayList<Slide>();
        giaVisto = false;
    }

    public Intermezzo(ArrayList<Slide> listaSlide) {
        this.giaVisto = false;
        this.listaSlide = listaSlide;
    }

    public boolean isGiaVisto() {
        return giaVisto;
    }

    public ArrayList<Slide> getListaSlide() {
        return listaSlide;
    }

    public void setGiaVisto(boolean giaVisto) {
        this.giaVisto = giaVisto;
    }

    public void setListaSlide(ArrayList<Slide> listaSlide) {
        this.listaSlide = listaSlide;
    }

}