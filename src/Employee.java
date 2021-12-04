
public class Employee{

	static Input a=new Input();
	static DataBaseConnectionManager b=new DataBaseConnectionManager();
	
	public String name,adress,dept,rank_name;
	public int total_salary;

	
	public Employee() {}
	
	public String getDept_Name()
	 {
		System.out.println("Enter Dept Name :: ");
		return dept=a.getString();
	 }
	
	public String getName()
	 {
		System.out.println("Enter Employee Name :: ");
		return name=a.getString();
	 }
	
	public String getAdress()
	 {
		System.out.println("Enter Adress :: ");
		return adress=a.getString();
	 }
	
	
	public int getTotal_Salary(String a)
	 {
		return b.getTotalSalary(a);
	 }
	
	public void searchData(int x)
	{
		dept=getDept_Name();
		name=getName();
		b.search(dept,name,x);
	}
	
}