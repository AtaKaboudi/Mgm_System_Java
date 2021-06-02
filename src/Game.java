import java.util.ArrayList;

public class Game {
private String opponent ="unspecified";
private int GoalsConceded = 0;
private int GoalsScored = 0 ;
private String GoalScorers ="Unspecified";
private String YellowCardsGiven ="None";
private String RedCardsGiven="None";
private String Assists="None";
public static ArrayList<Game> Championship = new ArrayList<Game>() ;

public Game(String op, int gC, int gSD, String gSS, String y, String r,String A) {
	opponent = op ;
	GoalsConceded = gC ;
	GoalsScored = gSD ;
	GoalScorers = gSS ;
	YellowCardsGiven = y ;
	RedCardsGiven = r ;
	Assists = A ;
}
public String getAssists() {
	return Assists;
}
public void setAssists(String assists) {
	Assists = assists;
}
public String getOpponent() {
	return opponent;
}
public void setOpponent(String opponent) {
	this.opponent = opponent;
}
public int getGoalsConceded() {
	return GoalsConceded;
}
public void setGoalsConceded(int goalsConceded) {
	GoalsConceded = goalsConceded;
}
public int getGoalsScored() {
	return GoalsScored;
}
public void setGoalsScored(int goalsScored) {
	GoalsScored = goalsScored;
}
public String getGoalScorers() {
	return GoalScorers;
}
public void setGoalScorers(String goalScorers) {
	GoalScorers = goalScorers;
}
public String getYellowCardsGiven() {
	return YellowCardsGiven;
}
public void setYellowCardsGiven(String yellowCardsGiven) {
	YellowCardsGiven = yellowCardsGiven;
}
public String getRedCardsGiven() {
	return RedCardsGiven;
}
public void setRedCardsGiven(String redCardsGiven) {
	RedCardsGiven = redCardsGiven;
}
public void Display() {
	System.out.print(" opponent = "+ opponent + " Result " + GoalsScored + " - "+ GoalsConceded + " Scorers = "+ GoalScorers +" Assists = "+Assists+" Yellow Cards = "+ YellowCardsGiven +" Red Cards = "+RedCardsGiven +  "\n");  

}

public static int findIndexByName (String Name ) {
	int i ; 
	int index = 0 ;
	for ( i = 0; i < Game.Championship.size();i++) {
	    if(Name.equals(Game.Championship.get(i).getOpponent())) {
	    index = i ;
		
	}
}
	return index ;
}
}
