package Inheritance;

public class vehicle {
	protected String registration;
	protected String make;
	protected String model;
	protected String colour;
	protected String owner;
	protected double value;
	protected int wheels;
	protected boolean taxed;
//Methods
public void respray(String c) {
	this.colour = c;
}

public void sell(String o, double v) {
	this.owner = o;
	this.value = v;
}

public void tax() {
	this.taxed = true;
	this.value = this.value*0.95;
}

public double crash() {
	this.value = this.value*0.5;
	this.taxed = false;
	return this.value;
}
//Accessor
public String getRegistration() {
	return registration;
}

public String getMake() {
	return make;
}

public String getModel() {
	return model;
}

public String getOwner() {
	return owner;
}

public double getValue() {
	return value;
}
//Create constructor
public vehicle(String r, String m, String md, String c, String o, double v, int w, boolean t) {
	this.registration = r;
	this.make = m;
	this.model = md;
	this.colour = c;
	this.owner = o;
	this.value = v;
	this.wheels = w;
	this.taxed = false;
}

public static void main(String[] args) {
	
}
}

