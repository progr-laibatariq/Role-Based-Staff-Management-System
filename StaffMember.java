public abstract class StaffMember extends Person
{
	private int staffID;
	public static int count = 100;
	

	public StaffMember()
	{
		super();
		this.staffID = 0;
	}
	public StaffMember(String n, String cnic, String c, int a ,String q, String city, String st_No, String h_No, String area)
	{
		super(n,cnic,c,a,q,city, st_No, h_No,area);
		this.staffID = count++;
	}
	public StaffMember(String n, String cnic, String c, int a ,String q, Address adr)
	{
		super(n,cnic,c,a,q,adr);
		this.staffID = count++;
	}
	public StaffMember(Person p, Address a)
	{
		super(p,a);
		this.staffID = count++;

	}
	public void setID(int id)
	{
		this.staffID = id;
	}
	public int getId()
	{
		return this.staffID;
	}
	public abstract String getRole();
	public String toString()
	{
		return "Staff Id : "+getId()+ "\n"+super.toString();
	}

}