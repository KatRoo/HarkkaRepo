package ohtu;

public class TennisGame {
    
    private final int PISTE0=0, PISTE1=1, PISTE2=2, PISTE3=3, PISTE4=4;
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void pisteVoittajalle(String playerName) {
        if ("player1".equals(playerName))
            player1Score += PISTE1;
        else
            player2Score += PISTE1;
    }
    
    public String pisteetKunPeliOnTasan()   {
        switch (player1Score)
            {
                case PISTE0:
                        return "Love-All";
                case PISTE1:
                        return "Fifteen-All";
                case PISTE2:
                        return "Thirty-All";
                case PISTE3:
                        return "Forty-All";
                default:
                        return "Deuce";
            }
    }
    
    public String pisteetKunPeliYliNeljan()  {
        int pisteidenErotus = player1Score-player2Score;
            if (pisteidenErotus==PISTE1) return "Advantage player1";
            else if (pisteidenErotus ==-PISTE1) return "Advantage player2";
            else if (pisteidenErotus>=PISTE2) return "Win for player1";
            else return "Win for player2";
    }
    
    public String pisteetTennissanaMuotoon(int piste)    {
        switch(piste)
                {
                    case PISTE0:
                        return "Love";
                    case PISTE1:
                        return "Fifteen";
                    case PISTE2:
                        return "Thirty";
                    case PISTE3:
                        return "Forty";
                    default:
                        return "";
                }
    }
    
    public String pisteetMuussaTapauksessa() {
        int tempScore=0;
        String score = "";
        for (int i=PISTE1; i<PISTE3; i++)
            {
                if (i==PISTE1) tempScore = player1Score;
                else { score+="-"; tempScore = player2Score;}
                score += pisteetTennissanaMuotoon(tempScore);
            }
        return score;
    }

    public String getScore() {
        if (player1Score==player2Score) return pisteetKunPeliOnTasan();
        else if (player1Score>=PISTE4 || player2Score>=PISTE4) return pisteetKunPeliYliNeljan();
        else return pisteetMuussaTapauksessa();
    }
}