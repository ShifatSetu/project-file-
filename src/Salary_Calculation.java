
public class Salary_Calculation {

	 
	Input a=new Input();
	DataBaseConnectionManager b=new DataBaseConnectionManager();
	int option,catagory;
	static Teacher x=new Teacher();
	static Stuff y=new Stuff();
	public Salary_Calculation() {
		// TODO Auto-generated constructor stub
	}

	
	public void choices()
	{
		do
		{
			System.out.println("Enter Your Choice");
			System.out.println("1.Add");
			System.out.println("2.Search");
			System.out.println("3.Show Pay Scale");
			System.out.println("4.Exit");
			option=a.getInt();
			if(option==1) Add();
			else if(option==2) Search();
			else if(option==3) ShowPayScale();
			else if(option==4) break;
			else System.out.println("Invalid Input\nPlease Try Again");
		}while(option!=4);
	}
	
	
	public void Add()
	{
		System.out.println("Enter Employee Catagory");
		System.out.println("Enter 1 for Teacher\nEnter 2 for Stuff");
        catagory=a.getInt();
        if(catagory==1) x.getTeacherData();
        else y.getStuffData(); 
	}
	
	public void Search()
	{
		System.out.println("Enter Employee Catagory");
		System.out.println("Enter 1 for Teacher\nEnter 2 for Stuff");
        catagory=a.getInt();
        x.searchData(catagory);
	}
	
	public void ShowPayScale()
	{
		x.showPayscale();
	}
	
	
	
}
