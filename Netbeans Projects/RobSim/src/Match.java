
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ely_867287
 */
class Match implements Comparable, Serializable
{
    String name;
    int red1;
    int red2;
    int blue1;
    int blue2;
    int redScore;
    int blueScore;
    boolean[] surrogates = {false, false, false, false};
   
    
   public Match()
   {
       name = "";
       red1 = 0;
       red2 = 0;
       blue1 = 0;
       blue2 = 0;
       redScore = 0;
       blueScore = 0;
   }
   
   public Match(String name, int red1, int red2, int blue1, int blue2, boolean[] surrogates)
   {
       this.name = name;
       this.red1 = red1;
       this.red2 = red2;
       this.blue1 = blue1;
       this.blue2 = blue2;
       this.redScore = 0;
       this.blueScore = 0;
       this.surrogates = surrogates; 
    
   }
 
   public String getName()
   {
       return name;
   }
   
   @Override
   public String toString()
   {
       // <name>: <redScore> (<red1> <red2>), <blueScore> (<blue1> <blue2>)
       // Qualification 1: 172 (4545 6209), 114 (5826 9048)
       return name + ": " + Integer.toString(redScore) +  " (" + Integer.toString(red1) + " " + Integer.toString(red2) + "), " + Integer.toString(blueScore) + " (" + Integer.toString(blue1) + " " + Integer.toString(blue2) + ")";
   }

    @Override
    public int compareTo(Object o)
    {
        
        Match otherMatch = (Match) o;
        
        int thisMatchNum = Integer.parseInt(name.substring(this.name.indexOf(" ") + 1));
        int otherMatchNum = Integer.parseInt(otherMatch.name.substring(otherMatch.name.indexOf(" ") +1));
        
        if (thisMatchNum > otherMatchNum)
        {
            return 1;
        }
        else if (thisMatchNum < otherMatchNum)
        {
            return -1;
        }
        
        return 0;
    }

    public int getRed1()
    {
        return red1;
    }

    public void setRed1(int red1)
    {
        this.red1 = red1;
    }

    public int getRed2()
    {
        return red2;
    }

    public void setRed2(int red2)
    {
        this.red2 = red2;
    }

    public int getBlue1()
    {
        return blue1;
    }

    public void setBlue1(int blue1)
    {
        this.blue1 = blue1;
    }

    public int getBlue2()
    {
        return blue2;
    }

    public void setBlue2(int blue2)
    {
        this.blue2 = blue2;
    }

    public int getRedScore()
    {
        return redScore;
    }

    public void setRedScore(int redScore)
    {
        this.redScore = redScore;
    }

    public int getBlueScore()
    {
        return blueScore;
    }

    public void setBlueScore(int blueScore)
    {
        this.blueScore = blueScore;
    }

    public boolean[] getSurrogates()
    {
        return surrogates;
    }

    public void setSurrogates(boolean[] surrogates)
    {
        this.surrogates = surrogates;
    }

}
