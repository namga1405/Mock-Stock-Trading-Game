package Inheritance;

public class car extends vehicle {
	public int doors;
	public int seats;
	public boolean sunroof;
	
public car (String r, String m, String md, String c, String o, double v, boolean t, int d, int s, boolean sr) {
	super(r,m,md,c,o,v,4,t);
	this.doors = d;
	this.seats = s;
	this.sunroof = false;
}

public static void main(String[] args) {
	
}

}