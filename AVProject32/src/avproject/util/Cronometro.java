/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package avproject.util;

/**
 *
 * @author w4nder
 */
public class Cronometro {

  /** Accumulatore contenente il numero dei millisecondi trascorsi. */
  private long contatore;

  /** Istante temporale dell'ultimo avvio del cronometro. */
  private long avviato_a;

  /** Variabile di stato che indica se il cronometro sta avanzando oppure no. */
  private boolean avanzando;


  /**
   * Costruttore: resetta il cronometro invocando il metodo d'istanza
   * <code>azzera()</code>. Non avvia il conteggio; per fare ciò usare
   * i metodi <code>avanza()</code> ed <code>riavvia()</code>.
   *
   * @see   #azzera()
   * @see   #avanza()
   * @see   #riavvia()
   */
  public Cronometro() {
    synchronized (this) {
      contatore = 0;
      avanzando = false;
    }
  }

  /** Metodo per (fermare ed) azzerare del cronometro. */
  public void azzera() {
    synchronized (this) {
      contatore = 0;
      avanzando = false;
    }
  }

  /**
   * Metodo che fa (ri)partire il conteggio. Non azzera il
   * cronometro, ma fa procedere la misura del tempo partendo dal
   * valore immagazzinato nell'accumulatore.
   * <p>
   * Il cronometro può essere fermato mediante <code>ferma()</code>.
   *
   * @see   #ferma()
   */
  public void avanza() {
    synchronized (this) {
      avviato_a = System.currentTimeMillis();
      avanzando = true;
    }
  }

  /**
   * Metodo che blocca l'avanzamento del cronometro. Usare
   * <code>avanza()</code> per far ripartire il conteggio,
   * <code>riavvia()</code> per azzerare il tutto prima di
   * dare inizio al conteggio.
   *
   * @see   #avanza()
   * @see   #riavvia()
   */
  public void ferma() {
    synchronized (this) {
      contatore += System.currentTimeMillis() - avviato_a;
      avanzando = false;
    }
  }

  /** Azzera il cronometro e ne fa partire il conteggio. */
  public void riavvia() {
    azzera();
    avanza();
  }

  /**
   * Lettura del conteggio corrente effettuato dal cronometro.
   * Chiamate successive a questo metodo riportano valori diversi
   * nel caso in cui il cronometro stia avanzando.
   *
   * @return   il numero totale di millisecondi contati dall'istanza.
   */
  public long leggi() {
    synchronized (this) {
      return avanzando ? contatore + System.currentTimeMillis() - avviato_a
                       : contatore;
    }
  }

  /**
   * Conversione in stringa del conteggio corrente. La lettura del
   * valore viene effettuata mediante il metodo <code>leggi()</code>.
   *
   * @return   una stringa rappresentante il numero di millisecondi
   *           contati dall'istanza in questione.
   * @see      #leggi()
   */
  public String toString() {
    return "" + leggi();
  }
}