
abstract class Person {
	private String Name ;
	private int Age;
	private int Salary ;

	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
public Person(String Name,int Age) {
	this.Age=Age;
	this.Name=Name ;
}
public Person(String Name,int Age,int S) {
	this.Age=Age;
	this.Name=Name ;
	this.Salary=S ;
}
	
}
