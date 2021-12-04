
public class Teacher extends Employee{
	
	String[] catagories= {"Professor","Assosiate Professor","Assistant Professor","Lecturer"};
	
	public Teacher() {}
	
	public Teacher(String x,String y,String z,String a,int b)
	{
		this.rank_name=x;this.dept=y;this.name=z;this.adress=a;this.total_salary=b;
	}
	
	
	
	public void getTeacherData()
	{
		rank_name=catagories[getRank_Name()];
		dept=getDept_Name();
		name=getName();
		adress=getAdress();
		total_salary=getTotal_Salary(rank_name);
	
		Teacher t=new Teacher(rank_name,dept,name,adress,total_salary);
		b.add(t,1);
	}
	
	
	public int getRank_Name()
	{
		System.out.println("Enter Teacher's Rank");
		System.out.println("1 for Proffesor");
		System.out.println("2 for Assosiate Proffesor");
		System.out.println("3 for Asssistant Proffesor");
		System.out.println("4 for Lecturer");
		return a.getInt()-1;
	}
	
	public void showPayscale()
	{
		b.payscale();
	}

}
