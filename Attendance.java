import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
public class Attendance
{
	private int staffId;
	private char status;
	private String date;
	public Attendance()
	{
		// this.staffId = 0;
		this.status = '0';
		this.date = "null";
	}
	public Attendance(int id, char s, String d)
	{
		this.staffId = id;
		this.status = s;
		this.date = d;
	}
	public void setId(int id)
	{
		this.staffId = id;
	}
	public int getId()
	{
		return this.staffId;
	}
	public void setStatus(char status)
	{
		this.status = status;
	}
	public char getStatus()
	{
		return this.status;
	}
	public void setDate(String d)
	{
		this.date = d;
	}
	public String getDate()
	{
		return this.date;
	}
	public void markAttendance(int id, char status,String date) throws IOException
	{
		Attendance a = new Attendance(id,status,date);
		// if(isAlreadyMarked(date,dates))
		// {
		// 	System.out.println("Sorry ! Attendance for this date is already marked");
		// 	return;
		// }
		// else 
		// {
			// writeInFile(a);
				FileWriter fw = new FileWriter("Attendance_record.txt", true);
				fw.write(a.getId()+","+a.getStatus()+","+a.getDate()+"\n");
				fw.close();


	}
	public void attendanceReport() throws IOException
	{
		File f = new File("Attendance_record.txt");
		Scanner read = new Scanner(f);
		System.out.println("Attendance Report");
		System.out.println("--------------------------------------------");
		System.out.println("ID   |Status| Date    ");
		while(read.hasNextLine())
		{
			String l = read.nextLine();
			String [] arr = l.split(",");
			int id = Integer.parseInt(arr[0]);
			System.out.println(id+"  |"+ arr[1]+"      |"+ arr[2]);

		}
		read.close();

	}
	public boolean isAlreadyMarked(String date)throws IOException
	{
		File f = new File("Attendance_record.txt");
		Scanner read = new Scanner(f);
		boolean isMarked = false;
		while(read.hasNextLine())
		{
			String l = read.nextLine();
			String [] arr = l.split(",");
			int id = Integer.parseInt(arr[0]);
			if(arr[2].equals(date))
			{
				isMarked = true;
				break;
			}

		}
		read.close();
		return isMarked;


	}
	public void searchRecords(int id)throws IOException
	{
		File f = new File("Attendance_record.txt");
		Scanner read = new Scanner(f);
		ArrayList<Attendance> a = new ArrayList<>();

		while(read.hasNextLine())
		{
			String l = read.nextLine();
			String [] arr = l.split(",");
			int staffId = Integer.parseInt(arr[0]);
			char status = arr[1].charAt(0);
			String date = arr[2];
			if(id==staffId)
			{
				Attendance at = new Attendance(staffId,status,date);
				a.add(at);
			}
		}
		read.close();
		System.out.println("Staff Member Attendance Record with ID "+id);
		for(Attendance att_records : a)
		{
			System.out.println(att_records.toString());
		}

	}
	public String toString()
	{
		return "Staff ID : "+getId()+ " Status : "+getStatus()+" Date : "+getDate();
	}
}