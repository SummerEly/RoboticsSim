
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

/*
 * ScoreMaker.class
Utility class used to calculate performance scores based on a teams historical
data. Uses historical data to generate standard deviation to calculate random 
scores using statistical zscores on a normal distribution. 
 */

/**
 *
 * @author ely_867287
 */

public class ScoreMaker
{
    public static double getAverage(ArrayList<Integer> scores)
    {
        int len = scores.size();
        double total = 0;
        double avg = 0;
        
        for (int i = 0; i < len; i++)
        {
            total += scores.get(i);
        }
        
        avg = total/len;
        return avg;
    }
    
    public static double getHighScore (ArrayList<Integer>scores)
    {
        double highScore = 0;
        
        for(Integer score : scores)
        {
            if (score > highScore)
            {
                highScore = score;
            }
        }
        return highScore;
    }
    
    public static double getSTD(Collection<Integer> scores)
    {
        // Returns the standard deviation of the list
        StandardDeviation std = new StandardDeviation();
        
        // Convert the scores ArrayList<Integer> into a double[] for the
        // StandardDeviation.evaluate(double[]) method
        
        double[] values = new double[scores.size()];
        
        int i = 0;
        for (Object o : scores)
        {
            double value = (Integer) o;
            values[i] = value;
            i++;
        }   
        
        return std.evaluate(values);
    }
    
    public static int getScore (double mean, double std)
    {
        // Returns a randomized score on a normal distribution of historical 
        // scores
        // score = (zScore * STD) + mean
        // zScore = sqrt(2) * (InverseErrorFunction of 2*Percentile) * -1
        // percentile = random value between 0 and 1 
        // std = standardDeviation(historicalScores) / sqrt(2)
            // divide by 2 because its the combined score of 2 teams
        // for our calculation, uses OPR to reflect the contribution of 1 team
        // instead of the score average which reflects 2 teams
        
        double percentile = Math.random();
        
        double zScore = Math.sqrt(2) * Erf.erfcInv(2*percentile) * -1;
        
        int score = new Double(zScore*std/2 + mean).intValue();
        
        return score;
    }
}
