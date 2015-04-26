package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento {

    private Sovelluslogiikka sl;
    private JTextField tuloskentta, syotekentta;
    private int edellinen;
    
    public Summa(Sovelluslogiikka sl, JTextField tuloskentta, JTextField syotekentta)  {
        this.sl = sl;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.edellinen = 0;
    }
    
    @Override
    public void suorita() {
        edellinen = Integer.parseInt(syotekentta.getText());
        sl.plus(edellinen);
        int laskunTulos = sl.tulos();
         
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }
    
    @Override
    public void peru()  {
        sl.miinus(edellinen);
        int laskunTulos = sl.tulos();
         
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }
}
