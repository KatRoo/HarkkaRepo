package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {

    private Sovelluslogiikka sl;
    private JTextField tuloskentta, syotekentta;
    
    public Nollaa(Sovelluslogiikka sl, JTextField tuloskentta, JTextField syotekentta)  {
        this.sl = sl;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    @Override
    public void suorita() {
        sl.nollaa();
        int laskunTulos = sl.tulos();
         
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }
    
    @Override
    public void peru()  {
        
    }
}
