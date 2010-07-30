/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package avproject.model;

/**
 *
 * @author w4nder
 */
public class Slide {
    private String fileImmagine;
    private String testo;

    public Slide(String fileImmagine, String testo) {
        this.fileImmagine = fileImmagine;
        this.testo = testo;
    }

    public String getFileImmagine() {
        return fileImmagine;
    }

    public String getTesto() {
        return testo;
    }

    public void setFileImmagine(String fileImmagine) {
        this.fileImmagine = fileImmagine;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }
}