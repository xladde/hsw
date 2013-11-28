import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{

		ArrayList<HSMember> list = new ArrayList<HSMember>();

		// adding an object of type HSMember
		list.add( new HSMember("LAST_NAME1", "FIRST_NAME1") );

		// adding an object of type Professor
		list.add( new Professor("LAST_NAME2", "FIRST_NAME2", "Research Example", "Programming in Java") );
		
		// adding an object of type Student
		list.add( new Student("LAST_NAME3", "FIRST_NAME3", "Information Systems") );
		
		// adding an object of type Employee
		list.add( new Employee("LAST_NAME4", "FIRST_NAME4", "Public Relations") );

		// print on screen: this iterates through the arraylist via for-each-loop.
		for(HSMember x: list) { x.print(); }

	}
}