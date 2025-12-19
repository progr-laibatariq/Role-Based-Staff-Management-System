import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class SalaryComputing
{
	private double salaryPerDay;
	private double netSalary;
	public SalaryComputing()
	{
		this.salaryPerDay = 0.0;
	}
	public SalaryComputing(double s_day)
	{
		this.salaryPerDay = s_day;
	}
	public SalaryComputing(SalaryComputing s)
	{
		this.salaryPerDay = s.salaryPerDay;
	}
	public void setSalaryPerDay(double s)
	{
		this.salaryPerDay = s;
	}
	public double getSalaryPerDay()
	{
		return this.salaryPerDay;
	}
	public int calculatePresentDays(int id)throws IOException
	{
		File f = new File("Attendance_record.txt");
		Scanner read = new Scanner(f);
		int present_days = 0;
		while(read.hasNextLine())
		{
			String l = read.nextLine();
			String [] arr = l.split(",");
			int staff_id = Integer.parseInt(arr[0]);
			if(staff_id == id && arr[1].equals("P"))
			{
				present_days++;
			}

		}
		read.close();
		return present_days;

	}
	public double calculateSalary(int id)throws IOException
	{
		double netSalary = 0;
		int presentDays = calculatePresentDays(id);
		if(presentDays>0)
		{
			this.netSalary = (double) this.getSalaryPerDay()*presentDays;
			return netSalary;
		}
		else 
		{
			System.out.println("Sorry!! Your working days are not enough");

		}
		return -1;

	}


}