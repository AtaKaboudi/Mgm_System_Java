import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO {
	public static void read() {
		readPlayerData();
		readStaffData();
		readGameData();
	}
	public static void readPlayerData () {
		String csvFile = "src/Data.txt";
		BufferedReader br = null;
		String line = "";
		try {
	      br = new BufferedReader(new FileReader(csvFile));
	      while ((line = br.readLine()) != null) {
	       String[] PlayerData = line.split(",");
	         Player P = new Player(PlayerData[0],Integer.parseInt(PlayerData[1]),PlayerData[2],Integer.parseInt(PlayerData[3]),Integer.parseInt(PlayerData[4]),Integer.parseInt(PlayerData[5]),Integer.parseInt(PlayerData[6]),Integer.parseInt(PlayerData[7]),Integer.parseInt(PlayerData[8]));
	         Player.Team.add(P);
	      	}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}	
	  }
	}
	public static void readStaffData () {
		String csvFile = "src/Staff.txt";
		BufferedReader br = null;
		String line = "";
		try {
	      br = new BufferedReader(new FileReader(csvFile));
	      while ((line = br.readLine()) != null) {
	       String[] StaffData = line.split(",");
	         Staff S = new Staff(StaffData[0],Integer.parseInt(StaffData[1]),StaffData[2],Integer.parseInt(StaffData[3]));
	         Staff.AllStaff.add(S);

	      	}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}	
	  }
	}
	
	public static void readGameData () {
		String csvFile = "src/GamesData.txt";
		BufferedReader br = null;
		String line = "";
		try {
	      br = new BufferedReader(new FileReader(csvFile));
	      while ((line = br.readLine()) != null) {
	       String[] GamesData = line.split(",");
	        Game G = new Game(GamesData[0],Integer.parseInt(GamesData[1]),Integer.parseInt(GamesData[2]),GamesData[3],GamesData[4],GamesData[5],GamesData[6]);
	        Game.Championship.add(G);
	      	
	      	}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}	
	  }
	}

public static String PlayerCSV(Player P) throws IOException {
	
	return  P.getName() +","+ P.getAge() + ","+ P.getPosition() + ","+ (int) P.getPrice() + ","+ (int) P.getSalary() + ","+P.getRedCards() + ","+P.getYellowCards()+ ","+P.getGoalsScored() + ","+P.getAssists();
	
}

public static String StafftoCSV(Staff S) throws IOException {
	
	return  S.getName() +","+ S.getAge() + ","+ S.getJob() +","+ (int) S.getSalary() ;
	
}
public static String GameCsv(Game G) throws IOException {
	
	return G.getOpponent() +","+ G.getGoalsConceded()+","+G.getGoalsScored()+","+G.getGoalScorers()+","+G.getYellowCardsGiven()+","+G.getRedCardsGiven()+","+G.getAssists();
	
}
public static void Save() {
    String Str="";
    try{
	File file = new File("src/Data.txt");
	FileWriter writer = new FileWriter(file) ;
	for (int i = 0; i< Player.Team.size();i++) {
	 Str = Str.concat(PlayerCSV(Player.Team.get(i)));
	 if (i<Player.Team.size()-1) {
	 Str =Str.concat("\n");
	  }
	
	 }
	writer.write(Str );
	writer.close();

    	}catch (Exception e){
		e.printStackTrace();
    	}
    String Str1="";
    
    try{
    	File file1 = new File("src/GamesData.txt");
    	FileWriter writer1 = new FileWriter(file1) ;
    	for (int i = 0; i< Game.Championship.size();i++) {
    	Str1 = Str1.concat(GameCsv(Game.Championship.get(i)));
    	 if (i < Game.Championship.size()-1) {
    		 Str1 = Str1.concat("\n");
    		  }
    	}
    	writer1.write(Str1);
    	writer1.close();

        	}catch (Exception e){
    		e.printStackTrace();
        	}
    String Str2 ="";
	 try{
	    	File file1 = new File("src/Staff.txt");
	    	FileWriter writer1 = new FileWriter(file1) ;
	    	for (int i = 0; i<Staff.AllStaff.size();i++) {
	    	Str2 = Str2.concat(StafftoCSV(Staff.AllStaff.get(i)));
	    	 if (i < Staff.AllStaff.size()-1) {
	    		 Str2 = Str2.concat("\n");
	    		  }
	    	}
	    	writer1.write(Str2);
	    	writer1.close();

	        	}catch (Exception e){
	    		e.printStackTrace();
	        	}
	       
   

}

}
