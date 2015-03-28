
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Katri Roos
 */
public class StaticsticsTest {
    
    Statistics stats;
    Reader readerStub = new Reader() {
        
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
                
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    //vertaa onko kahdella player oliolla samat arvot
    public boolean equals(Player one, Player two)   {
        
        if(one.getName().equals(two.getName()) && one.getTeam().equals(two.getTeam()) && 
                one.getGoals() == two.getGoals() && one.getAssists()== two.getAssists()) {
            return true;
        }
        return false;
    }

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void searchLoytyy() {
       
        Player semenko = new Player("Semenko", "EDM", 4, 12);
        
        assertEquals(true, equals(stats.search("Semenko"), semenko));
    }
    
    @Test
    public void searchEiLoydy() {
        
        assertEquals(null, stats.search("Seppo"));
    }
    
    @Test
    public void teamLoytyy() {
        
        List<Player> joukkue = stats.team("EDM");
        
        assertEquals(3, joukkue.size());
    }
    
    @Test
    public void teamEiLoydy() {
      
        List<Player> joukkue = stats.team("ABC");
        
        assertEquals(0, joukkue.size());
    }
    /*
    @Test
    public void topScorersLkmPienempiKuinPelaajienMaara()   {
        
        List<Player> pelaajat = stats.topScorers(3);
      
        assertEquals( 3, pelaajat.size());
    }
    
    @Test
    public void topScorersLkmSuurempiKuinPelaajienMaara()   {
        
        List<Player> pelaajat = stats.topScorers(7);
      
        assertEquals( 5, pelaajat.size());
    }
    */
    
    @Test
    public void topScorersPalauttaaParhaan()   {
        
        List<Player> pelaajat = stats.topScorers(1);
        Player paras = pelaajat.get(0);
        
        assertEquals( 124, paras.getPoints());
    }
    
}
