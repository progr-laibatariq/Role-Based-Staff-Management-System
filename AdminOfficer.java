public class AdminOfficer extends StaffMember
{
	private String duty;
	public AdminOfficer(String n, String cnic, String c, int a ,String q, Address adr, int id, String duty)
	{
		super(n, cnic, c, a, q, adr, id);
		this.duty = duty;

	}
	public void setDuty(String d)
	{
		this.duty = d;
	}
	public String getDuty()
	{
		return this.duty;
	}
	@Override
	public String getRole()
	{
		return "Admin Officer";
	}
	@Override
	public void display()
	{
		super.display();
		System.out.println("Role : "+getRole());
		System.out.println("Duty : "+getDuty());
	}
	@Override
	publilc String toString()
	{
		return super.toString()+ "Role : Admin Officer "+" Duty : "+getDuty();
	}
}