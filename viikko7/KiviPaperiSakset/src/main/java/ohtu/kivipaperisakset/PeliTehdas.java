package ohtu.kivipaperisakset;

public class PeliTehdas {
   
    public static Peli kaksinpeli(Io io)  {
        return new Game(io, new Tuomari(), new Ihminen(io));
    }
    
    public static Peli helppoYksinpeli(Io io)  {
        return new Game(io, new Tuomari(), new Tekoaly());
    }
    
    public static Peli vaikeaYksinpeli(Io io, int muisti)  {
        return new Game(io, new Tuomari(), new TekoalyParannettu(muisti));
    }
}