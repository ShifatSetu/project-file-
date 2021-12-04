import java.util.Scanner;

public class Input {

	private static Scanner scanf;
	
	public Input() {
		scanf=new Scanner(System.in);
	}

	public int getInt()
	{
		return scanf.nextInt();
	}
	
	public String getString()
	{
		return scanf.next();
	}
	
	

}
