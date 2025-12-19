public abstract class Person{
	private String name;
	private String cnic;
	private String cont_info;
	private int age;
	private String qualification;
	private Address adr;
	public Person()
	{
		this.name = "null";
		this.cnic = "null";
		this.cont_info = "000";
		this.age = 0;
		this.qualification = "null";
		this.adr = new Address();

	}
	public Person(String n,String cnic, String contact, int age, String q, String city, String st_No, String h_No,String area)
	{
		this.name = n;
		this.cnic = cnic;
		this.age = age;
		this.cont_info = contact;
		this.qualification = q;
		adr.setCity(city);
		adr.setStNo(st_No);
		adr.setHouseNo(h_No);
		adr.setArea(area);
	}
	public Person(String n,String cnic, String contact, int age, String q, Address a)
	{
		this.name = n;
		this.cnic = cnic;
		this.age = age;
		this.cont_info = contact;
		this.qualification = q;
		this.adr = new Address(a);
	}
	public Person(Person p, Address a)
	{
		this.name = p.name;
		this.cnic = p.cnic;
		this.age = p.age;
		this.cont_info = p.cont_info;
		this.qualification = p.qualification;
		this.adr = new Address(a);
	}
	public void setName(String n)
	{
		this.name = n;
	}
	public void setCNIC(String c)
	{
		this.cnic = c;
	}
	public void setAge(int a)
	{
		this.age = a;
	}
	public void setContact(String c)
	{
		this.cont_info = c;
	}
	public void setQual(String q)
	{
		this.qualification = q;
	}
	public String getName()
	{
		return this.name;
	}
	public String getCNIC()
	{
		return this.cnic;
	}
	public int getAge()
	{
		return this.age;
	}
	public String getContact()
	{
		return this.cont_info;
	}
	public String getQual()
	{
		return this.qualification;
	}
	public void display()
	{
		System.out.println(toString());
		adr.display();


	}
	public String toString()
	{
		return "Name : "+getName()+"\nAge : "+getAge()+"\nCNIC : "+getCNIC()+"\nContact : "+getContact()+"\nQualification : "+getQual();
	}
} 