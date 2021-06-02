import java.util.ArrayList;

public class Player extends Person{

private int GoalsScored = 0 ;
private int YellowCards = 0 ;
private int RedCards = 0 ;
private int assists = 0 ;
private String Position ;
private double Price ;
public static ArrayList<Player> Team = new ArrayList<Player>(); 

public int getAssists() {
	return assists;
}
public void setAssists(int assists) {
	this.assists = assists;
}

public int getGoalsScored() {
	return GoalsScored;
}
public void setGoalsScored(int goalsScored) {
	GoalsScored = goalsScored;
}
public int getYellowCards() {
	return YellowCards;
}
public void setYellowCards(int yellowCards) {
	YellowCards = yellowCards;
}
public int getRedCards() {
	return RedCards;
}
public void setRedCards(int redCards) {
	RedCards = redCards;
}


public int getSalary() {
	return super.getSalary();
}
public void setSalary(int salary) {
	super.setSalary(salary);
}

public String getName() {
	return super.getName();
}
public void setName(String name) {
	super.setName(name);
}
public int getAge() {
	return super.getAge();
}
public void setAge(int age) {
	super.setAge(age);
}
public String getPosition() {
	return Position;
}
public void setPosition(String position) {
	Position = position;
}
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}

public  Player(String name, int age, String position, int price,int S) {
	super(name,age,S);
	Position = position;
	Price = price;
		
}
public  Player(String name, int age, String position, int price,int S,int Red , int Yellow , int G,int A) {
	super(name,age);
	Position = position;
	Price = price;
	RedCards = Red ;
	YellowCards = Yellow ;
	GoalsScored = G ;
	assists = A ;
}
public void Display() {
	System.out.print( "Name = "+ super.getName()+" Age = "+ super.getAge() +" Salary = "+super.getSalary()+" Position = "+Position +" Price = "+ Price +" Goals Scored = "+ GoalsScored + " RedCards = "+RedCards+" Yellow Cards = "+YellowCards +" Assists = "+assists+"\n"); 
	}
public static int findIndexByName (String Name ) {
	int i ; 
	int index = 0 ;
	for ( i = 0; i < Player.Team.size();i++) {
	    if(Name.equals(Player.Team.get(i).getName())) {
	    index = i ;
	    }
	}
		return index ;

	}
}