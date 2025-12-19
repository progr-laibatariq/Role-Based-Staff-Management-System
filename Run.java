import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
public class Run
{
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(System.in);
		Scanner sizy = new Scanner(System.in);
		DepartmentManager dm = new DepartmentManager();
		StaffManager sm = new StaffManager();
		Attendance a = new Attendance();
		SalaryComputing sc = new SalaryComputing();
		String[] subs1 = {"AI", "ML"};
		String[] subs2 = {"Linear Algebra", "Calculus_I"};
		String[] subs3 = {"AICT", "Computer Networks"};
		String[] subs4 = {"DLD","Discrete"};
		Address a1 = new Address("Gujranwala", "Tr32","441", "Model Town");
		Address a2 = new Address("Lahore", "T76T","885", "Defense");
		Address a3 = new Address("Gujranwala", "L876","975", "Garden Town");
		Address a4 = new Address("Gujranwala", "T287","217", "DC Colony");
		Instructor i1 = new Instructor("Danyal Zafar","123r4572","03018733325",23,"Masters",a1,subs1); 
		Instructor i2 = new Instructor("Aqsa Khalid","12ywt662","03036333325",25,"Masters",a2,subs3);	
		Instructor i3 = new Instructor("Hassan Shahid","982654t","0325631282",35,"PHD",a3,subs2); 
		Instructor i4 = new Instructor("Ayesha Amir","9826264r","035732761",38,"Masters",a4,subs4);  
		Hod h1 = new Hod("Mr. Qaiser Durani","16541t197", "091871543",45,"PHD", a2);
		Hod h2 = new Hod("Mr. Fakhar Lodhi","98t2451y", "091871543",45,"PHD", a2);
		Department d1 = new Department("D01", "CS",h1);
		Department d2 = new Department("D02", "Maths",h2);
		sm.addInstructor(i1);
		sm.addInstructor(i2);
		sm.addInstructor(i3);
		sm.addInstructor(i4);
		sm.addHod(h1);
		sm.addHod(h2);
		d1.addInstructor(i1);
		d1.addInstructor(i4);
		d2.addInstructor(i2);
		d2.addInstructor(i3);
		d1.setHOD(h1);
		d2.setHOD(h2);
		dm.addDepartment(d1);
		dm.addDepartment(d2);
		// sm.display();
		// dm.displayAll();
		System.out.println("*****WELCOME TO STAFF MANAGEMENT SYSTEM*****");
		while(true)
		{
			System.out.println();
			System.out.println();
			System.out.println("Enter 1 to add Staff Member");
			System.out.println("Enter 2 to update staff's qualification by ID");
			System.out.println("Enter 3 to update staff's age");
			System.out.println("Enter 4 to remove staff member by its Id");
			System.out.println("Enter 5 to search staff by ID");
			System.out.println("Enter 6 to get Department records");
			System.out.println("Enter 7 to get the Department by Id");
			System.out.println("Enter 8 to get the Department by name");
			System.out.println("Enter 9 to mark Attendance");
			System.out.println("Enter 10 to view Attendance Record");
			System.out.println("Enter 11 to search Attendance records by ID");
			System.out.println("Enter 12 to compute salary");
			System.out.println("Enter 13 to get the list of all Staff Members");

			int user_input = Integer.parseInt(sizy.nextLine());
			if(user_input == 0)
			{
				System.exit(0);
			}
			else 
			{
				if(user_input == 1)
				{
					System.out.print("Enter the role of staff you want to add : ");
					String r = sizy.nextLine().toLowerCase();
					char role = r.charAt(0);
					addStaff(sm,dm,role);
					System.out.println("************************************");
					System.out.println("Staff Details");
					System.out.println("************************************");
					sm.display();
				}
				else if(user_input == 2)
				{
					System.out.print("Enter the Staff's ID : ");
					int id = input.nextInt();
					System.out.print("Enter the updated Qualification status : ");
					String qual = sizy.nextLine();
					StaffMember s = sm.searchById(id);
					if(s.getQual().equalsIgnoreCase(qual))
					{
						System.out.println();
						System.out.println("Qualification is already same");
						System.out.println();
					}
					else 
					{
						sm.updateStaffQualification(id,qual);
						System.out.println("Updated Qualification");
						System.out.println(sm.searchById(id));
					}	

				}
				else if(user_input == 3)
				{
					System.out.print("Enter the Staff's ID : ");
					int id = input.nextInt();
					System.out.print("Enter the updated age  : ");
					int age = input.nextInt();
					StaffMember s = sm.searchById(id);
					if(s.getAge()== age )
					{
						System.out.println();
						System.out.println("Age is already same");
						System.out.println();
					}
					else 
					{
						sm.updateStaffAge(id,age);
						System.out.println("Updated Age");
						System.out.println(sm.searchById(id));
						System.out.println("***************************************");
						sm.display();
						System.out.println("***************************************");
						dm.displayAll();

					}	

				}
				else if(user_input == 4)
				{
					System.out.print("Enter the staff's ID : ");
					int id = input.nextInt();
					sm.removeStaffMember(id, dm);
					System.out.println("************************************");
					sm.display();
					System.out.println("************************************");
					dm.displayAll();

				}
				else if(user_input == 5)
				{
					System.out.println("Enter the staff's ID you wanna search : ");
					int id = input.nextInt();
					StaffMember s = sm.searchById(id);
					if(s!=null)
					{
						System.out.print(s.toString());
					}
					else 
					{
						System.out.println("Staff with this ID is not found");
					}
				}
				else if(user_input == 6)
				{
					for(Department d : dm.getAllDepartments())
					{
						System.out.println("Department Name : "+d.getName()+" Department ID : "+d.getId());
					}
				}
				else if(user_input == 7)
				{
					System.out.println("Enter the ID to search for department : ");
					String id = sizy.nextLine();
					Department dept = dm.findById(id);
					if(dept!= null)
					{
						dept.display();
					}
					else
					{
						System.out.println("Department with this ID does not found");
					}
				}
				else if(user_input == 8)
				{
					System.out.print("Enter the name to search for department : ");
					String name = sizy.nextLine();
					Department dept = dm.findByName(name);
					if(dept!= null)
					{
						dept.display();
					}
					else
					{
						System.out.print("Department with this name does not found");
					}

				}
				else if(user_input ==  9)
				{
					System.out.println("Enter the date : ");
					String date = sizy.nextLine();
					boolean f = a.isAlreadyMarked(date);
					if(f)
					{
						System.out.println();
						System.out.println("Attendance for this date is already marked");
						System.out.println();
					}
					else 
					{
						System.out.println("Enter the Attendance for all StaffMember");
						System.out.println("******************************************");
						for(StaffMember s : sm.getList())
						{
							int id = s.getId();
							String name = s.getName();
							System.out.print(id+"  "+name+ " : ");
							String status = sizy.nextLine().toUpperCase();
							char st= status.charAt(0);
							while(st !='P' && st != 'A')
							{
								System.out.println("Invalid status ! ");
								System.out.print("Enter the status again");
								status = sizy.nextLine().toUpperCase();
							}
							a.markAttendance(id,st,date);
						}
					}
				}
				else if(user_input == 10)
				{
					a.attendanceReport();
				}
				else if(user_input == 11)
				{
					System.out.println("Enter Staff's ID for which you wanna search : ");
					int id = input.nextInt();
					a.searchRecords(id);
				}
				else if(user_input == 13)
				{
					sm.display();
				}
				else if(user_input == 12)
				{
					System.out.print("Enter the ID : ");
					int id = input.nextInt();
					input.nextLine();
					StaffMember staff_mmember = sm.searchById(id);
					if(staff_mmember == null)
					{
						System.out.println("Staff with this Id is not found");
					}
					else 
					{
						String r = staff_mmember.getRole();
						char role = r.charAt(0);
						if(role == 'i')
						{
							sc.setSalaryPerDay(2000);
							double netSalary = sc.calculateSalary(id);
							if(netSalary != -1)
							{
								System.out.println("Salary based on the number of present days is : "+netSalary);
							}
							else
							{
								System.out.println("Salary not generated");
							}
						}
						else if(role == 'h')
						{
							sc.setSalaryPerDay(5000);
							double netSalary = sc.calculateSalary(id);

							if (netSalary != -1) 
							{
								System.out.println("Salary based on the number of present days is : " + netSalary);
							}
							else 
							{
								System.out.println("Salary not generated");
							}

						}
					}

				}
			}
		}


	
	
	}
	public static void addStaff(StaffManager sm,DepartmentManager dm,char role)
	{
		Scanner input = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("*******************************************");
		System.out.println("Basic details");
		System.out.print("Enter the name : ");
		String n = input.nextLine();
		System.out.print("Enter the cnic number : ");
		String cnic = input.nextLine();
		System.out.print("Enter the phone number : ");
		String p_No = input.nextLine();
		System.out.print("Enter the age : ");
		int age = sc.nextInt();
		System.out.print("Enter the Qualification : ");
		String q = input.nextLine();
		System.out.print("Enter the city name : ");
		String city = input.nextLine();
		System.out.print("Enter the area : ");
		String a = input.nextLine();
		System.out.print("Enter the street no. : ");
		String s_no = input.nextLine();
		System.out.print("Enter the house no. : ");
		String h_no = input.nextLine();
		Address adr = new Address(city, s_no, h_no, a);
		
		if(role == 'i')
		{
			System.out.println("Enter the no. of courses : ");
			int size = sc.nextInt();
			String[] subjects = new String[size];
			for(int i =0; i<size; i++)
			{
				System.out.println("Enter course "+(i+1)+ ": ");
				subjects[i] = input.nextLine();

			}
			Instructor ins = new Instructor(n, cnic,p_No,age,q,adr,subjects);
			sm.addInstructor(ins);
			System.out.print("Suitable Department for this instructor : ");
			String dept_name = input.nextLine();
			if(dm.findByName(dept_name) == null)
			{
				System.out.println("You have to create department first to add instructor in it ");
				System.out.println("To Create a new department with the "+dept_name+" you have to add ID for department: ");
				String dept_id = input.nextLine();
				System.out.println("Department has been created ");
				Department d = new Department(dept_id, dept_name,ins);
				dm.addDepartment(d);
			}
			else 
			{
				Department d = dm.findByName(dept_name);
				d.addInstructor(ins);
				System.out.println("Instructor has been added to department ");

			}


		}
		else if(role == 'h')
		{
			Hod hod = new Hod(n, cnic,p_No,age,q,adr);
			sm.addHod(hod);
			System.out.println("Enter suitable department for this HOD by name : ");
			String dept_name = input.nextLine();
			if(dm.findByName(dept_name) == null)
			{
				System.out.println("First you have to create department");
				System.out.println("To Create a new department with the "+dept_name+" you have to add ID for department: ");
				String dept_id = input.nextLine();
				System.out.println("Now as Department has been created ");
				Department d = new Department(dept_id, dept_name,hod);
				dm.addDepartment(d);
			}
			else 
			{
				Department d = dm.findByName(dept_name);
				d.setHOD(hod);
				System.out.println("Hod has been added to department ");

			}

		}

	}
	
}