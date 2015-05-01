package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.Io;
import ohtu.kivipaperisakset.Io;
import ohtu.kivipaperisakset.Peli;
import ohtu.kivipaperisakset.Peli;
import ohtu.kivipaperisakset.Tuomari;
import ohtu.kivipaperisakset.Vastustaja;

public class Game implements Peli{
    private Io io;
    private Tuomari tuomari;
    private Vastustaja vastustaja;
    
    public Game(Io io, Tuomari tuomari, Vastustaja vastustaja)  {
        this.io = io;
        this.tuomari = tuomari;
        this.vastustaja = vastustaja;
    }
    
    @Override
    public void pelaa() {        
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.getString();
        String tokanSiirto;


        tokanSiirto = vastustaja.annaSiirto();
        System.out.println("Vastustaja valitsi: " + tokanSiirto);


        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.getString();

            tokanSiirto = vastustaja.annaSiirto();
            System.out.println("Vastustaja valitsi: " + tokanSiirto);
            vastustaja.asetaSiirto(ekanSiirto);

        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    @Override
    public boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
