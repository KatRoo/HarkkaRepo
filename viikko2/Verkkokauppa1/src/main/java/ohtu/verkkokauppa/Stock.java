
package ohtu.verkkokauppa;

/**
 *
 * @author Katri Roos
 */
public interface Stock {

    Tuote haeTuote(int id);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);

    int saldo(int id);
    
}
