/**
 * @brief Class HSMember to represent a general Model for Persons
 * @version 2013-01-08
 * @author tj
 */
public class HSMember
{
	private final int ID;
	private String 	lname;
	private String 	fname;

	public HSMember() 
	{
		// @todo: Generate unique ID
		ID = 0;
		this.lname = new String();
		this.fname = new String();
	}

	public HSMember( String lname, String fname )
	{
		// @todo: Generate unique ID
		ID = 0;
		this.lname = new String( lname );
		this.fname = new String( fname );
	}

	public int getID()                      { return this.ID; }
	public void setLastName( String name )  { this.lname = name; }
	public String getLastName()             { return this.lname; }
	public void setFirstName( String name ) { this.fname = name; }
	public String getFirstName()            { return this.fname; }

	public void print()
	{
		System.out.println(toString());
	}

	public String toString()
	{
		return new String( this.ID + ": " + this.lname + ", " + this.fname );
	}

}