/**
 * @brief Class Student to represent a special kind of HSMember.
 * @version 2013-01-08
 * @author tj
 */
public class Student
extends HSMember 
{
	private String coStudies;

	public Student()
	{
		super();
		this.coStudies = new String();
	}

	public Student(String lname, String fname, String coStudies)
	{
		super(lname, fname);
		this.coStudies = new String(coStudies);
	}

	public void setCourseOfStudies(String field) { this.coStudies = field; }
	public String getCourseOfstudies()           { return this.coStudies; }
	
	@Override
	public void print()
	{
		System.out.println(toString());
		System.out.println("\tCourse of Studies: " + this.coStudies);
	}

}