import java.util.ArrayList;
import java.util.Collections;
public class StaffManager
{
	ArrayList<StaffMember> s = new ArrayList<>();
	public StaffManager()
	{
		s = new ArrayList<>();
	}
	public void addInstructor(Instructor i)
	{
		s.add(i);
	}
	public void addHod(Hod h)
	{
		s.add(h);
	}
	public void updateStaffQualification(int id, String q)
	{
		StaffMember sm = searchById(id);
			if(sm != null)
			{
				sm.setQual(q);
				System.out.println("Qualification of staff member ("+sm.getRole()+") with id "+id +"has been updated !! ");
				return;
			}
		System.out.println("Staff member with id "+ id + "is not found");

	}
	public void updateStaffAge(int id, int age)
	{
		StaffMember sm = searchById(id);
			if(sm != null)
			{
				sm.setAge(age);
				System.out.println("Age of staff member "+(sm.getRole())+" with id "+id +" has been updated !! ");
				return;
			}
		System.out.println("Staff member with id "+ id + "is not found");

	}
	public void removeStaffMember(int id, DepartmentManager dm)
	{
			StaffMember sm = searchById(id);
 			if(sm != null)
			{
	 			s.remove(sm);
		        for (Department d : dm.getAllDepartments()) 
		        {
		            if (sm instanceof Instructor) 
		            {
		                d.removeInstructorById(id);
		            } 
		            else if (sm instanceof Hod) 
		            {
		                d.removeHod(id);
		            }
		        }

        		System.out.println("Staff with ID " + id + " has been removed from StaffManager and associated Departments.");

			}
			else 
			{
				System.out.println("Staff member with Id : "+id+" is not found");
			}

	}
	public ArrayList<StaffMember> getList()
	{
		return s;
	}
	public StaffMember searchById(int id)
	{
		for(int i=0; i<s.size(); i++)
		{
			if(s.get(i).getId() == id)
			{
				return s.get(i);
			}
		}
		return null;
	}
	public void display()
	{
		System.out.println("Staff Members List : ");
		for(int i=0; i<s.size(); i++)
		{
			System.out.println(s.get(i).toString());
			System.out.println("----------------------");
		}
	}
	
	
}