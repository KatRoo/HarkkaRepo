package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int taulukonminimikoko;
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        taulukonminimikoko = KAPASITEETTI;
        lukujono = new int[KAPASITEETTI];
        alustaJoukko(0);
        this.kasvatuskoko = OLETUSKASVATUS;
        alkioidenLkm = 0;
    }

    public IntJoukko(int kapasiteetti) {
        taulukonminimikoko = kapasiteetti;
        if (kapasiteetti >= 0) {
            lukujono = new int[kapasiteetti];
            alustaJoukko(0);
            this.kasvatuskoko = OLETUSKASVATUS;
        }
        alkioidenLkm = 0;
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        taulukonminimikoko = kapasiteetti;
        if (kapasiteetti >= 0 && kasvatuskoko >= 0) {
            lukujono = new int[kapasiteetti];
            alustaJoukko(0);
        }
        else    {
            throw new IllegalArgumentException("Luvun pitää olla positiivinen kokonaisluku!");
        }
        this.kasvatuskoko = kasvatuskoko;
        alkioidenLkm = 0;
    }

    private void alustaJoukko(int alkuindeksi) {
        Arrays.fill(lukujono, alkuindeksi, (lukujono.length-1), 0);
    }
    
    public boolean lisaa(int luku) {        
        if (!kuuluu(luku)) {
            lukujono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % lukujono.length == 0) {
                lukujono = Arrays.copyOf(lukujono, (alkioidenLkm + kasvatuskoko));
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for(int i = 0; i < lukujono.length; i++)   {
            if(lukujono[i] == luku) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for(int i = 0; i < lukujono.length; i++)   {
            if(lukujono[i] == luku) {
                System.arraycopy(lukujono,i+1,lukujono,i,alkioidenLkm-i);
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }

    @Override
    public String toString() {
        String x = "{";
        if (alkioidenLkm > 0)   {
	    x += Integer.toString(lukujono[0]);
            for(int i = 1; i < alkioidenLkm; i++)   {
	        x += ", " + lukujono[i];
            }
        }
        x += "}";
        return x;
    }    
}