
public class UFO extends Transport{

	protected RobotPilot ArtificialIntelligence;
	public UFO() {
		// TODO Auto-generated constructor stub
		this.speed=299792458;
		this.ArtificialIntelligence=new RobotPilot();
	}

	public void autoPilotOn(){
		this.ArtificialIntelligence.powerOn();
	}
	public boolean autoPilotStatus(){
		return this.ArtificialIntelligence.power_status;
	}
	public void autoPilotOff(){
		this.ArtificialIntelligence.powerOff();
	}
}
