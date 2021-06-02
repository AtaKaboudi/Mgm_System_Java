import java.util.ArrayList;

public class Staff extends Person {
private String Job ;
public static ArrayList<Staff> AllStaff = new ArrayList<Staff>(); 

public String getName() {
	return super.getName();
}
public void setName(String name) {
	super.setName(name);
}
public String getJob() {
	return Job;
}
public void setJob(String job) {
	Job = job;
}
public int getSalary() {
	return super.getSalary() ;
}
public void setSalary(int salary) {
	super.setSalary(salary);
}
public int getAge() {
	return super.getAge() ;
}
public void setAge(int age) {
	super.setAge(age);
}
public Staff(String name, int age, String job, int salary) {
	super(name,age,salary) ;
	Job = job;
	}

public void Display() {
System.out.print( "Name = "+ super.getName() +" Age = "+ super.getAge() +" Salary = "+super.getSalary()+" Job = "+Job+"\n" ); 
}

public static int findIndexByName (String Name ) {
	int i ; 
	int index = 0 ;
	for ( i = 0; i < Staff.AllStaff.size();i++) {
	    if(Name.equals(Staff.AllStaff.get(i).getName())) {
	    index = i ;
		
	}
}
	return index ;

}
}