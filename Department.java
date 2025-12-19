import java.util.ArrayList;

public class Department 
	{
	private Hod hod;
	private ArrayList<Instructor> ins;
	private String dept_id;
	private String dept_name;

	public Department() 
	{
		this.dept_id = "null";
		this.dept_name = "null";
		this.ins = new ArrayList<>();
	}

	public Department(String id, String name, Instructor s) 
	{
		this.dept_id = id;
		this.dept_name = name;
		this.ins = new ArrayList<>();
		this.ins.add(s);
	}

	public Department(String id, String name, Hod h)
	{
		this.dept_id = id;
		this.dept_name = name;
		this.hod = h;
		this.ins = new ArrayList<>();
	}

	public Department(Department d, Instructor s) 
	{
		this.dept_id = d.dept_id;
		this.dept_name = d.dept_name;
		this.hod = d.hod;
		this.ins = new ArrayList<>(d.ins); // Copy existing instructors
		this.ins.add(s); // Add new one
	}

	public Department(Department d)
	{
		this.dept_id = d.dept_id;
		this.dept_name = d.dept_name;
		this.hod = d.hod;
		this.ins = new ArrayList<>(d.ins);
	}

	public void addInstructor(Instructor ins) 
	{
		this.ins.add(ins);
	}

	public void setName(String n) 
	{
		this.dept_name = n;
	}

	public String getName() 
	{
		return this.dept_name;
	}

	public void setId(String id) 
	{
		this.dept_id = id;
	}

	public String getId() 
	{
		return this.dept_id;
	}

	public void setHOD(Hod d) 
	{
		this.hod = d;
	}
	public void removeInstructorById(int id)
	{
		for(int i =0; i<ins.size(); i++)
		{
			if(ins.get(i).getId() == id)
			{
				ins.remove(i);
			}
		}
	}
	public void removeHod(int id)
	{
		if(hod.getId() == id)
		{
			hod = null;
		}

	}

	public String getHOD() 
	{
		if (this.hod != null) 
		{
			return this.hod.getName();
		}
		return "No HOD";
	}

	public ArrayList<Instructor> getInstructors() 
	{
		return ins;
	}

	public void display() 
	{
		System.out.println("Department ID : " + getId() + "\nDepartment Name : " + getName());
		if (hod != null) 
		{
			System.out.println("HOD Name : " + hod.getName());
		} 
		else
		{
			System.out.println("No HOD found");
		}
		for (Instructor i : ins)
		{
			System.out.println(i.toString());
		}
	}
}
