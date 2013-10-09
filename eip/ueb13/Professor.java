/**
 * @brief Class Professor to represent a special kind of HSMember.
 * @version 2013-01-08
 * @author tj
 */
public class Professor
extends HSMember 
{
	private String foResearch;
	private String foEducation;

	public Professor()
	{
		super();
		this.foResearch   = new String();
		this.foEducation  = new String();
	}

	public Professor(String lname, String fname, String foResearch, String foEducation)
	{
		super(lname, fname);
		this.foResearch   = new String(foResearch);
		this.foEducation  = new String(foEducation);
	}

	public void setFieldOfResearch(String field)  { this.foResearch = field; }
	public String getFieldOfResearch()            { return this.foResearch; }
	public void setFieldOfEducation(String field) { this.foEducation = field; }
	public String getFieldOfEducation()           { return this.foResearch; }
	
	@Override
	public void print()
	{
		System.out.println(toString());
		System.out.println("\tField of Research: " + this.foResearch);
		System.out.println("\tField of Education: " + this.foEducation);
	}

}