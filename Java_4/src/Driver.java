
public class Driver {
	public String Name;
	protected int sleepStatus;
	protected boolean drunk;
	public Driver() {
		// TODO Auto-generated constructor stub
		this.Name="Unnamed";
		this.sleepStatus=100;
		this.drunk=false;
	}
	public Driver(String n) {
		// TODO Auto-generated constructor stub
		this.Name=n;
		this.sleepStatus=100;
		this.drunk=false;
	}
	public boolean driverCanDrive(){
		
		return (this.sleepStatus>0&!this.drunk);
	}
	public boolean driverStatus(){
		return (this.sleepStatus>0);
	}
}
