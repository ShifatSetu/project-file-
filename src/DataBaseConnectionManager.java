import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseConnectionManager {
	
	    private final String showPayScale = "select * from pay_scale";
	    private final String addteacher = "insert into teacher values(null,?,?,?,?,?)";
	    private final String addstuff = "insert into stuff values(null,?,?,?,?,?)";
	    private final String searchTeachers= "select * from teacher where (name=? and department=?)";
	    private final String searchStuffs= "select * from stuff where (name=? and department=?)";
	    private final String totalsalary= "select total from pay_scale where rank_name=?";
	    
	static Connection connection;
	static PreparedStatement preparedStatement;
	static ResultSet resultSet;
	
	public DataBaseConnectionManager() {
		connection=null;
		preparedStatement=null;
		resultSet=null;
	}
	
	public void payscale()  {
		
	
		
		try {
	       	  Class.forName("com.mysql.jdbc.Driver"); 
	       	  connection = DriverManager.getConnection("jdbc:mysql:///salary_calculation","root","");
	      	

	           preparedStatement = connection.prepareStatement(showPayScale);
	         resultSet=preparedStatement.executeQuery();  
	         
	         System.out.println("+--------+----------------------+---------+-----------+---------+--------+-------+");
	         System.out.println("| Serial "+"| Rank Name "+"|  Basic  "+"| Transport "+"| Medical "+"| Others "+"| Total |");
	         while(resultSet.next())
	         {
	        	  System.out.println("+--------+----------------------+---------+-----------+---------+--------+-------+");
	  	        
	        	 System.out.println("|    "+resultSet.getString(1)+"   |"+resultSet.getString(2)+"            |"+resultSet.getString(3)+"    |"+resultSet.getString(4)+"       |"+resultSet.getString(5)+"     |"+resultSet.getString(6)+"    |"+resultSet.getString(7)+"  |");
	       
	         }
	         System.out.println("+--------+----------------------+---------+-----------+---------+--------+-------+");
		         
	         
	       } catch (Exception e) {
	           e.printStackTrace();
	       } 
		    
	}
		
	
	public void add(Employee a,int x)
	{
		try {
	       	  Class.forName("com.mysql.jdbc.Driver"); 
	       	  connection = DriverManager.getConnection("jdbc:mysql:///salary_calculation","root","");
	      	

	       if(x==1)    preparedStatement = connection.prepareStatement(addteacher);
	       else     preparedStatement = connection.prepareStatement(addstuff);   
	         
	         preparedStatement.setString(1,a.rank_name);
	         preparedStatement.setString(2,a.dept);
	         preparedStatement.setString(3,a.name);
	         preparedStatement.setString(4,a.adress);
	         preparedStatement.setInt(5,a.total_salary);
	         
	            preparedStatement.executeUpdate();  
	       } catch (Exception e) {
	           e.printStackTrace();
	       } 
	}
	
	
	public int getTotalSalary(String rank)
	{
		try {
	       	  Class.forName("com.mysql.jdbc.Driver"); 
	       	  connection = DriverManager.getConnection("jdbc:mysql:///salary_calculation","root","");
	      	

	           preparedStatement = connection.prepareStatement(totalsalary);
	           
	         preparedStatement.setString(1,rank);
	        
	           resultSet=preparedStatement.executeQuery();
	          
	           int result=0;
	         
	         
	          while(resultSet.next())
	           {
	        	  
	        	 result=resultSet.getInt(1);
	        	 System.out.println("Total Salary "+result);
	           }
	          
	           return result;
	       } catch (Exception e) {
	           e.printStackTrace();
	           return 0;
	       } 
	}
	
	public void search(String a, String b,int c)
	{
		try {
	       	  Class.forName("com.mysql.jdbc.Driver"); 
	       	  connection = DriverManager.getConnection("jdbc:mysql:///salary_calculation","root","");
	      	

	      if(c==1)   preparedStatement = connection.prepareStatement(searchTeachers); 
	      else preparedStatement = connection.prepareStatement(searchStuffs); 
	         preparedStatement.setString(1,a);
	         preparedStatement.setString(2,b);
	        
	           resultSet=preparedStatement.executeQuery();
	          
	          output(resultSet); 
	         
	       } catch (Exception e) {
	           e.printStackTrace();
	       } 
	}
	
	public void output(ResultSet resultSet)
	{
		try {
			 System.out.println("+--------+---------------------+-------------+---------------+-----------+--------+");
	         System.out.println("|  No    "+"|  Rank Name          "+"|  Name       "+"| Department    "+"|  Adress   "+"| Salary "+"|");
		int no=0;
	         while(resultSet.next())
		{
	        	 System.out.println("+--------+---------------------+-------------+---------------+-----------+--------+");
       	 System.out.println("|    "+(++no)+"   |    "+resultSet.getString(2)+"         |    "+resultSet.getString(3)+"    |    "+resultSet.getString(4)+"      |    "+resultSet.getString(5)+"  |  "+resultSet.getString(6)+" |");
      
		} 
	             System.out.println("+--------+---------------------+-------------+---------------+-----------+--------+");
	         
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	

}
