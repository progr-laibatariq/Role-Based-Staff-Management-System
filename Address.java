public class Address
{
	private String city;
	private String stNo;
	private String houseNo;
	private String area;
	public Address()
	{
		this.city = "null";
		this.stNo = "null";
		this.houseNo = "null";
		this.area = "null";
	}
	public Address(String c, String s,String h, String a)
	{
		this.city = c;
		this.area = a;
		this.stNo = s;
		this.houseNo = h;
	}
	public Address(Address a)
	{
		this.city = a.city;
		this.stNo = a.stNo;
		this.houseNo = a.houseNo;
		this.area = a.area;  
	}
	public void setCity(String c)
	{
		this.city = c;
	}
	public void setStNo(String s)
	{
		this.stNo = s;
	}
	public void setHouseNo(String n)
	{
		this.houseNo = n;
	}
	public void setArea(String a)
	{
		this.area = a;
	}
	public String getCity()
	{
		return this.city;
	}
	public String getHNo()
	{
		return this.houseNo;
	}
	public String getArea()
	{
		return this.area;
	}
	public String getStNo()
	{
		return this.stNo;
	}
	public void display()
	{
		System.out.println("City : "+getCity()+" Area : "+getArea()+" Street No : "+getStNo()+" House No : "+getHNo());
	}


}