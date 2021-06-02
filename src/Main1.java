 import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 

public class Main1 {

	
public static void main(String[]args) {

IO.read();
  boolean Exit = false; 



 while(!Exit){ 
	 System.out.print("Choose : 1.AddPlayer 2.RemovePlayer 3.DisplayTeaminfo 4.AddStaff  5.RemoveStaff 6.DisplayStaffinfo 7.AddGame 8.DisplaySeasonInfo , 9.exit \n");
	  Scanner Sc = new Scanner(System.in); 
	  int Choice = Sc.nextInt(); 

  switch(Choice) {
  case 1:
	  AddPlayer();
    break;
  case 2:
	  RemovePlayer(); 
    break;
  case 3:
	  DisplayTeamInfo();
	 break;
  case 4:
	  AddStaff();
	 break;
  case 5:
	  RemoveStaff();
	 break; 
  case 6:
	  DisplayStaffInfo();
	  break ;
  case 7 :
	  AddGame () ;
	  break ;
  case 8:
	  DisplayChampInfo();
	  break ;
  case 9 :
	  Exit = true ;
  IO.Save();
  }
	  
}

	
	}
public static void AddPlayer() {
    Scanner Sc = new Scanner(System.in); 
    System.out.printf("insert Name, Position, Age, Price, Salary \n");
    String Name = Sc.nextLine(); 
    String Pos = Sc.nextLine();
    int Age = Sc.nextInt();
    int price = Sc.nextInt(); 
    int Salary = Sc.nextInt(); 
    System.out.print( " Name = " + Name +" Age = "+ Age + " Position = "+ Pos+" Salary = "+Salary+"\n");
    Player P = new Player(Name,Age,Pos,price,Salary);
    Player.Team.add(P);
}
public static void RemovePlayer() {
    System.out.printf("Enter Name \n");
    Scanner Sc = new Scanner(System.in); 
    String Name = Sc.nextLine(); 
    System.out.print(Name);
  int i = Player.findIndexByName(Name) ;
  Player.Team.remove(i);
	
}


public static void AddStaff() {
    Scanner Sc = new Scanner(System.in); 
    System.out.printf(" Insert name, job, age, Salary \n");
    String Name = Sc.nextLine(); 
    String Job = Sc.nextLine();
    int Age = Sc.nextInt();
    int Salary = Sc.nextInt(); 
    System.out.print("Name = "+Name+" Age = "+Age +" Job = "+Job+"Salary = "+Salary+"\n");
    Staff S = new Staff(Name,Age,Job,Salary);
    Staff.AllStaff.add(S);
}
public static void RemoveStaff() {
    System.out.printf("Enter Name \n");
    Scanner Sc = new Scanner(System.in); 
    String Name = Sc.nextLine(); 
int size = Staff.AllStaff.size();
for (int i = 0; i< size;i++) {
	if(Name.equals(Staff.AllStaff.get(i).getName())) {
		System.out.print("Removed \n");
		Staff.AllStaff.remove(i);
	break ;	
	}
   }
}
public static void AddGame () {
    System.out.printf("Enter opponent, Goals Scorers, Yellow Cards , Red Cards, Assists , Goalsconceded, GoalsScored, Assists \n");
	 Scanner Sc = new Scanner(System.in); 
	   String opponent = Sc.nextLine(); 	
	    String  GSS = Sc.nextLine(); 	
	    String  Y = Sc.nextLine(); 	
	    String  R = Sc.nextLine(); 	
	    String  A = Sc.nextLine(); 	
	    int GC =Sc.nextInt();
		 int GSD=Sc.nextInt();

  Game G = new Game(opponent,GC,GSD,GSS,Y,R,A);
  Game.Championship.add(G);
  updatePlayersStatus(G);
}
public static void DisplayTeamInfo() {
	System.out.print("1. All team , 2 Specific Player \n");
	Scanner Sc = new Scanner(System.in) ;
	int a = Sc.nextInt();
	int Start = 0 ;
	int End = 0 ;
	if (a == 1) {Start =0 ;  End = Player.Team.size();};
	if (a==2) {
		System.out.print("Enter Name \n");
		Scanner S = new Scanner(System.in) ;	
    String N = S.nextLine();
	Start = Player.findIndexByName(N);
	End = Start +1 ;
	}
	for (int i = Start ; i < End ;i++) {
		Player.Team.get(i).Display();
	    System.out.print("\n");
	}
}
public static void DisplayStaffInfo() {
	System.out.print("1. All Staff , 2 Specific Staff \n");
	Scanner Sc = new Scanner(System.in) ;
	int a = Sc.nextInt();
	int Start = 0 ;
	int End = 0 ;
	if (a == 1) {Start =0 ;  End = Staff.AllStaff.size();};
	if (a==2) {
		System.out.print("Enter Name \n");
		Scanner S = new Scanner(System.in) ;	
    String N = S.nextLine();
	Start = Staff.findIndexByName(N);
	End = Start +1 ;
	}
	for (int i = Start ; i < End ;i++) {
		Staff.AllStaff.get(i).Display();
	    System.out.print("\n");
	}
}
public static void DisplayChampInfo() {
	System.out.print("1. All Games , 2 Specific Game \n");
	Scanner Sc = new Scanner(System.in) ;
	int a = Sc.nextInt();
	if(a==2) {
	
		System.out.print("Enter Name \n");
		Scanner S = new Scanner(System.in) ;	
       String N = S.nextLine();
     int Index = Game.findIndexByName(N);
     Game.Championship.get(Index).Display(); 
	}else {
	int won = 0 ;
	int lost = 0 ;
	int draw = 0;
	for (int i = 0 ; i < Game.Championship.size(); i++) {
		if (Game.Championship.get(i).getGoalsScored() > Game.Championship.get(i).getGoalsConceded()){
		won = won + 1 ;	
		}
		if (Game.Championship.get(i).getGoalsScored() < Game.Championship.get(i).getGoalsConceded()){
		lost = lost + 1 ;	
		}
		if (Game.Championship.get(i).getGoalsScored() == Game.Championship.get(i).getGoalsConceded()){
		draw = draw + 1 ;	
		}
		Game.Championship.get(i).Display();
	}
	System.out.print("WON = "+ won + " Lost = "+ lost+ " Draw = "+ draw + "\n");
	}
}

public static void updatePlayersStatus(Game G) {
	String[] GoalScorers = G.getGoalScorers().split(" ");
	String[] YellowCards = G.getYellowCardsGiven().split(" ");
	String[] RedCards = G.getRedCardsGiven().split(" ");
	String[] Assists = G.getAssists().split(" ");

    for (String a : GoalScorers) {
    int i = Player.findIndexByName(a);
    Player.Team.get(i).setGoalsScored(Player.Team.get(i).getGoalsScored()+1);
 }
    for (String a : YellowCards) {
        int i = Player.findIndexByName(a);
        Player.Team.get(i).setYellowCards(Player.Team.get(i).getYellowCards()+1);
     }
    for (String a : RedCards) {
        int i = Player.findIndexByName(a);
        Player.Team.get(i).setRedCards(Player.Team.get(i).getRedCards()+1);
     }
    for (String a : Assists) {
        int i = Player.findIndexByName(a);
        Player.Team.get(i).setAssists(Player.Team.get(i).getAssists()+1);
     }


}



}