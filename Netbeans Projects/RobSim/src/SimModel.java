
import java.io.Serializable;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ely_867287
 */

public class SimModel implements Serializable
{
    private TreeMap<Integer, Team> teams;
    private TreeSet<Match> matches;
    private TreeMap<Integer, Double> oprs;
    private TreeSet <Team> rankedTeams;
    
    public SimModel(TreeMap<Integer, Team> teams, TreeSet<Match> matches, TreeMap<Integer, Double> oprs, TreeSet<Team> rankedTeams)
    {
        this.teams = teams;
        this.matches = matches;
        this.oprs = oprs;
        this.rankedTeams = rankedTeams;
    }
    
    public SimModel(TreeSet<Match> matches, TreeSet<Team> rankedTeams)
    {
        this.matches = matches;
        this.rankedTeams = rankedTeams;
    }
    
    public TreeMap<Integer, Team> getTeams()
    {
        return teams;
    }

    public TreeSet<Match> getMatches()
    {
        return matches;
    }

    public TreeMap<Integer, Double> getOprs()
    {
        return oprs;
    }

    public TreeSet<Team> getRankedTeams()
    {
        return rankedTeams;
    }
}
