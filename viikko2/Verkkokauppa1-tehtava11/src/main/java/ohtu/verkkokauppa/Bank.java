
package ohtu.verkkokauppa;

/**
 *
 * @author Katri Roos
 */
public interface Bank {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
