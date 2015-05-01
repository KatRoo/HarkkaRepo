package ohtu.kivipaperisakset;

public class Ihminen implements Vastustaja {
    private Io io;
    
    public Ihminen(Io io){
        this.io = io;
    }

    @Override
    public String annaSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        return io.getString();
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        //Ei tehdä mitään
    }
    
}
