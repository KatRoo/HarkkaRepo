
package ohtu.intjoukkosovellus;

import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JoukkoOperaatiotTest {
    
    Sovelluslogiikka logiikka;
    Scanner lukija;
    
    @Before
    public void joukkoOperaatiotTest()   {
        this.lukija = new Scanner(System.in);
        this.logiikka = new Sovelluslogiikka();
    }
    
    @Test
    public void testYhdiste() {
        IntJoukko eka = teeJoukko(1,2);
        IntJoukko toka = teeJoukko(3,4);
        
        IntJoukko tulos = logiikka.yhdiste(eka, toka);
        int[] vastauksenLuvut = tulos.toIntArray();
                
        Arrays.sort(vastauksenLuvut);
        
        int[] odotettu = {1,2,3,4};
        
        assertArrayEquals(odotettu, vastauksenLuvut);        
    } 

    @Test
    public void testLeikkaus() {
        IntJoukko eka = teeJoukko(1,2,3);
        IntJoukko toka = teeJoukko(2,3,4);
        
        IntJoukko tulos = logiikka.leikkaus(eka, toka);
        int[] vastauksenLuvut = tulos.toIntArray();
                
        Arrays.sort(vastauksenLuvut);
        
        int[] odotettu = {2,3};
        
        assertArrayEquals(odotettu, vastauksenLuvut);        
    } 
    
    @Test
    public void testErotus() {
        IntJoukko eka = teeJoukko(1,2,3);
        IntJoukko toka = teeJoukko(2,3,4);
        
        IntJoukko tulos = logiikka.erotus(eka, toka);
        int[] vastauksenLuvut = tulos.toIntArray();
                
        Arrays.sort(vastauksenLuvut);
        
        int[] odotettu = {1};
        
        assertArrayEquals(odotettu, vastauksenLuvut);        
    } 
    
    private IntJoukko teeJoukko(int... luvut) {
        IntJoukko joukko = new IntJoukko();
        
        for (int luku : luvut) {
            joukko.lisaa(luku);
        }
        
        return joukko;
    }
}
