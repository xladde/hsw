/**
 * @brief Class Employee to represent a special kind of HSMember.
 * @version 2013-01-08
 * @author tj
 */
public class Employee
extends HSMember 
{
	private String department;

	public Employee()
	{
		super();
		this.department = new String();
	}

	public Employee(String lname, String fname, String department)
	{
		super(lname, fname);
		this.department = new String(department);
	}

	public void setDepartment(String field) { this.department = field; }
	public String getDepartment()           { return this.department; }
	
	@Override
	public void print()
	{
		System.out.println(toString());
		System.out.println("\tDepartment: " + this.department);
	}

}