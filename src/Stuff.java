
public class Stuff extends Employee{
	
	String[] catagories= {"Libarian","Accountant","Lab Assistant"};
	
	public Stuff() {}
	
	public Stuff(String x,String y,String z,String a,int b)
	{
		this.rank_name=x;this.dept=y;this.name=z;this.adress=a;this.total_salary=b;
	}
	
	
	public void getStuffData()
	{
		rank_name=catagories[getRank_Name()];
		dept=getDept_Name();
		name=getName();
		adress=getAdress();
		total_salary=getTotal_Salary(rank_name);
		Stuff t=new Stuff(rank_name,dept,name,adress,total_salary);
		b.add(t,2);
	}
	

	public int getRank_Name()
	{
		System.out.println("Enter Teacher's Rank");
		System.out.println("1 for Libarian");
		System.out.println("2 for Accountant");
		System.out.println("3 for Lab Assistant");
		return (a.getInt()-1);
	}
	
}
