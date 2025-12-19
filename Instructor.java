public class Instructor extends StaffMember
{
	private String []subjects;
	// private Department dept;
	public Instructor(String n, String cnic, String c, int a ,String q, Address adr,String[] subs)
	{
		super(n,cnic,c,a,q,adr);
		this.subjects = new String[subs.length];
		// this.dept = dept;
		for(int i =0; i<subs.length; i++)
		{
			subjects[i] = subs[i];
		}
	}
	// public void setDepartment(Department d)
	// {
	// 	this.dept = d;
	// }
	public String[] getSubjects()
	{
		return this.subjects;
	}
	public void setSubjects(String[] subs)
	{
		this.subjects = new String[subs.length];
		for(int i =0; i<subs.length; i++)
		{
			this.subjects[i] = subs[i];
		}
	}
	@Override
	public String getRole()
	{
		return "Instructor";
	}
	@Override
	public void display()
	{
		System.out.println(super.toString());
		System.out.println("Related Subjects");
		for(int i=0; i<subjects.length; i++)
		{
			System.out.println(subjects[i]);
		}
		// System.out.println("Department : ");
		// if(dept != null && !dept.getName().equals(""))
		// {
		// 	System.out.println("Department : "+dept.toString());
		// }
		// else 
		// {
		// 	System.out.println("Not related to certain department");
		// }
	}
	@Override
	public String toString()
	{
		return super.toString()+"\nRole : Instructor \nRelated Subjects : \n"+String.join(",",subjects);
	}


}