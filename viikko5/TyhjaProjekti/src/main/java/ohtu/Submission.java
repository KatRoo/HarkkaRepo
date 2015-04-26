package ohtu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Submission {
    private String student_number;
    private String week;
    private String hours;
    private boolean a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
    private int yhteensa;
    
    public Submission()   {
        
    }
    
    public String tehdytTehtavat() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.yhteensa = 0;
        String tehtavat = "";
        
        for(int i = 1; i < 11; i++)   {
            Method method = getClass().getMethod("getA" + i);
            boolean arvo = (Boolean)method.invoke(this); 
            if(arvo) {
                this.yhteensa++;
                tehtavat += i + " ";
            }
        }
        return tehtavat;
    } 
    
    public int getYhteensa() {
        return yhteensa;
    }
    
    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    } 
    
    public boolean getA1() {
        return a1;
    }

    public void setA1(boolean a1) {
        this.a1 = a1;
    }

    public boolean getA2() {
        return a2;
    }

    public void setA2(boolean a2) {
        this.a2 = a2;
    }

    public boolean getA3() {
        return a3;
    }

    public void setA3(boolean a3) {
        this.a3 = a3;
    }

    public boolean getA4() {
        return a4;
    }

    public void setA4(boolean a4) {
        this.a4 = a4;
    }

    public boolean getA5() {
        return a5;
    }

    public void setA5(boolean a5) {
        this.a5 = a5;
    }

    public boolean getA6() {
        return a6;
    }

    public void setA6(boolean a6) {
        this.a6 = a6;
    }

    public boolean getA7() {
        return a7;
    }

    public void setA7(boolean a7) {
        this.a7 = a7;
    }

    public boolean getA8() {
        return a8;
    }

    public void setA8(boolean a8) {
        this.a8 = a8;
    }

    public boolean getA9() {
        return a9;
    }

    public void setA9(boolean a9) {
        this.a9 = a9;
    }

    public boolean getA10() {
        return a10;
    }

    public void setA10(boolean a10) {
        this.a10 = a10;
    }

     @Override
    public String toString() {
    String alku = "";
        try {
            alku = "opiskelijanumero\t" + getStudent_number() + "\n\n"
                    + "viikko " + getWeek() + ": tehtyjä tehtäviä yhteensä: "
                    + ", aikaa kului " + getHours() + " tuntia, "
                    + "tehdyt tehtävät: " + this.tehdytTehtavat();
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String loppu = "\nyhteensä: " + getYhteensa() + " \n";
        
        return alku + loppu;
    }    
}