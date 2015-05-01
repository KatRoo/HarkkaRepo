package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Io {
    private Scanner io;
    
    public Io() {
        this.io = new Scanner(System.in);
    }
   
    public String getString()  {
        return io.next();
    }
    
    public int getInt() {
        return io.nextInt();
    }
}
