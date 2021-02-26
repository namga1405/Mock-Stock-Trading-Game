package Inheritance;


public class motorbike extends vehicle{
	
	public motorbike(String r, String ma, String mo, String c, String o, double v,int w, boolean t ) {
		super (r,ma,mo,c,o,v,2,t);
	}

	
	public double crash() {
		this.value=this.value*0.25;
		return this.value; 
	}
	
	public static void main(String[] args) {

	}

}
