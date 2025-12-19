import java.util.ArrayList;

public class DepartmentManager 
{
	private ArrayList<Department> departments = new ArrayList<>();

	public void addDepartment(Department d) 
	{
		departments.add(d);
	}

	public Department findById(String id) 
	{
		for (Department d : departments) 
		{
			if (d.getId().equalsIgnoreCase(id)) 
			{
				return d;
			}
		}
		return null;
	}

	public Department findByName(String name)
	{
		for (Department d : departments)
		{
			if (d.getName().equalsIgnoreCase(name))
			{
				return d;
			}
		}
		return null;
	}

	public Department getOrCreate(String id, String name, Hod hodIfNew)
	{
		Department d = findById(id);
		if (d == null) 
		{
			d = new Department(id, name, hodIfNew);
			addDepartment(d);
		}
		return d;
	}

	public void displayAll() 
	{
		for (Department d : departments)
		{
			d.display();
			System.out.println("------------");
		}
	}

	public ArrayList<Department> getAllDepartments() 
	{
        return departments;
    }
}
