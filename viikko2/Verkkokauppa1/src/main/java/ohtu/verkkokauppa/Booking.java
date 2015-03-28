
package ohtu.verkkokauppa;

import java.util.ArrayList;

/**
 *
 * @author Katri Roos
 */
public interface Booking {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
