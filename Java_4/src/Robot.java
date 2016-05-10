public abstract class Robot {
	public Java_4_Processor processor;
	public String name;
	public boolean power_status;
	public Accumulator[] accumulator;
	public Robot() {
		// TODO Auto-generated constructor stub
		this.processor = new Java_4_Processor();
		this.power_status = false;
		this.name = "Undefined";
		this.accumulator=new Accumulator[1];
		this.accumulator[0]=new Accumulator();
	}
	public void setProcessor(Java_4_Processor p) {
		this.processor = p;
	}
	public void power_on(){
		Accumulator[] temp;
		int i;
		if(this.accumulator.length>0){
			temp=new Accumulator[this.accumulator.length-1];
			for(i=0;i<this.accumulator.length-1;i++){
				temp[i]=this.accumulator[i];
			}
			this.accumulator=temp;
			this.power_status=true;
			this.processor.power=true;
			this.processor.set_tempature(70);
		}
	}
	
}
