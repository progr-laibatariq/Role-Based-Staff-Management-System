public class Hod extends StaffMember{

    public Hod(String n, String cnic, String c, int a, String q, Address adr)
    {
        super("Prof. "+n, cnic, c, a, q, adr);
    }
    
    @Override
    public String getRole()
    {
        return "HOD";
    }
    @Override
    public String toString() {
        return super.toString() + "\nRole: HOD";
    }
}
