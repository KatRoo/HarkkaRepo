package ohtu.kivipaperisakset;

public class Paaohjelma {
    
    public static void main(String[] args) {
        Io io = new Io();
       
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.getString();
            if (vastaus.endsWith("a")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                PeliTehdas.kaksinpeli(io).pelaa();
            } else if (vastaus.endsWith("b")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                PeliTehdas.helppoYksinpeli(io).pelaa();
            } else if (vastaus.endsWith("c")) {
                System.out.println("Anna Tekoälyn muistin koko: ");
                int muistinkoko = io.getInt();
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                PeliTehdas.vaikeaYksinpeli(io, muistinkoko).pelaa();
            } else {
                break;
            }

        }

    }
}
