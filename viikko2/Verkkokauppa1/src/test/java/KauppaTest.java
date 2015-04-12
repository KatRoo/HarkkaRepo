/*
 * Kauppa-luokan testit.
 */

import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Tuote;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Katri Roos
 */
public class KauppaTest {
    
    Pankki pankki;
    Varasto varasto;
    Viitegeneraattori viite;
    Kauppa k;
    
    public KauppaTest() {
    }
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        varasto = mock(Varasto.class);
        viite = mock(Viitegeneraattori.class);
        k = new Kauppa(varasto, pankki, viite);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaan() {
        when(viite.uusi()).thenReturn(42);      
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5)); 
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), anyInt());
    }
    
    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        when(viite.uusi()).thenReturn(42);      
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5)); 
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(), eq(5));
    }
    
    @Test
    public void kaksiEriTuotettaKorissaJaKutsutaanPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        when(viite.uusi()).thenReturn(42);      
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5)); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipa", 7));
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(), eq(12));
    }
    
    @Test
    public void kaksiSamaaTuotettaKorissaJaKutsutaanPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        when(viite.uusi()).thenReturn(42);      
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5)); 
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(), eq(10));
    }
    
    @Test
    public void kaksiTuotettaKorissaJaToinenLoppuJaKutsutaanPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        when(viite.uusi()).thenReturn(42);      
        when(varasto.saldo(1)).thenReturn(0);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5)); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipa", 7));
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(), eq(7));
    }
    
    @Test
    public void TehdaanUusiOstosTaphtumaJaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        when(viite.uusi()).thenReturn(42);      
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5)); 
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(), eq(5));
        
        when(viite.uusi()).thenReturn(42); 
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipa", 7));
        
        k.aloitaAsiointi();
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(eq("pekka"), anyInt(),eq("12345"), anyString(), eq(7));
    }
    
    @Test
    public void TehdaanUusiOstosTaphtumaJaViiteVaihtuu() {
        when(viite.uusi()).
                thenReturn(1).
                thenReturn(2);
             
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5)); 
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(eq("pekka"), eq(1), eq("12345"), anyString(), eq(5));
        
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipa", 7));
        
        k.aloitaAsiointi();
        k.lisaaKoriin(2);
        k.tilimaksu("sirpa", "67891");
        
        verify(pankki).tilisiirto(eq("sirpa"), eq(2), eq("67891"), anyString(), eq(7));
    }
    
    @Test
    public void poistetaanKoristaJaVarastoLuokanPalautaVarastoonMetodiaKaytetaan() {
        Tuote tuote = new Tuote(1, "maito", 5);
        when(viite.uusi()).thenReturn(42);      
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(tuote); 
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.poistaKorista(1);
        
        verify(varasto).palautaVarastoon(eq(tuote));
    }
}
