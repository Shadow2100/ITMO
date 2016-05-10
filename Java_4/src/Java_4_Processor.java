public class Java_4_Processor {
	public double frequency;
	public double voltage;
	public int tdp;
	public int tempature;
	public boolean power;
	public String model;

	public Java_4_Processor() {
		// TODO Auto-generated constructor stub
		this.frequency = 1.3;
		this.voltage = 1.7;
		this.tdp = 86;
		this.tempature = 0;
		this.power = false;
		this.model = "Pentium IV";
	}

	public Java_4_Processor(int f, int v, int tdpi, int temp, boolean p,
			String modeli) {
		// TODO Auto-generated constructor stub
		this.frequency = f;
		this.voltage = v;
		this.tdp = tdpi;
		this.tempature = temp;
		this.power = p;
		this.model = modeli;
	}

	public void set_tempature(int n) {
		this.tempature = n;
		if (this.tempature > 90) {
			this.power = false;
		}
	}
}