package Train;
import java.util.*;

public class Train {
String[] Departure = {"9:00","11:00","13:00","15:00","10:00","12:00","14:00","16:00"};
int Capacity[] = {480,480,480,640,480,480,480,640};
int SeatBuy[] = {0,0,0,0,0,0,0,0};
double MoneyMake[] = {0,0,0,0,0,0,0,0};
int cost = 25;
int noFreeTicket;
int noSeatLeft;
int Price;
int Passengers;
boolean Full;

Scanner input = new Scanner(System.in);

public Train()
{
	boolean go = true;
	
	while (go != false) {
	//Departure train
		double tripprice = 0;
		System.out.println(">>>>>>>>>> WELCOME TO THE TRAIN STATION <<<<<<<<<<");
		System.out.print("Number of passengers: ");
		String enter = input.nextLine();
		while (!checkInt(enter)) {
			System.out.print("Please re-enter the number of passengers: ");
			enter = input.nextLine();
		}
		Passengers = Integer.parseInt(enter);
		
		System.out.println("Please choose the number corresponds to the time you want to leave the station");
		for (int i = 0; i < 4; i++) {
			System.out.println(i + ": " + Departure[i]);
		}
		System.out.print("Enter your choice please: ");
		int timeleave = OrderTicketGo(Departure);
		Full = checkFull(Capacity,Passengers,timeleave);
		while (Full != false) {
			System.out.println("Coach full, please pick another coach");
			for (int i = 0; i < 4; i++) {
				System.out.println(i + ": " + Departure[i]);
			}
			timeleave = OrderTicketGo(Departure);
			Full = checkFull(Capacity,Passengers,timeleave);
		}
		Capacity[timeleave] = Capacity[timeleave] - addSeat(Passengers,SeatBuy,timeleave);
		SeatBuy[timeleave] = SeatBuy[timeleave] + addSeat(Passengers, SeatBuy, timeleave);
		noFreeTicket = CalcFreeTicket(Passengers);
		Price = (Passengers-noFreeTicket)*cost;
		tripprice = tripprice + Price;
		MoneyMake[timeleave] = MoneyMake[timeleave] + Price;
		System.out.println(Passengers + " tickets was sold");
		System.out.println("There will be " + noFreeTicket + " free tickets");
		System.out.println("The cost for this train is: " + Price);
		
		//Return train
		System.out.println("Please choose the number corresponds to the time you want to leave the mountain");
		for (int i = 4; i < 8; i++) {
			System.out.println(i + ": " + Departure[i]);
		}
		System.out.print("Enter your choice please: ");
		int timereturn = OrderTicketReturn(Departure,timeleave);
		Full = checkFull(Capacity,Passengers,timereturn);
		while (Full == true) {
			System.out.println("Coach full, please pick another coach");
			for (int i = 4; i < 8; i++) {
				System.out.println(i + ": " + Departure[i]);
			}
			timereturn = OrderTicketGo(Departure);
			Full = checkFull(Capacity,Passengers,timereturn);
		}
		Capacity[timereturn] = Capacity[timereturn] - addSeat(Passengers,SeatBuy,timereturn);
		SeatBuy[timereturn] = SeatBuy[timereturn] + addSeat(Passengers,SeatBuy,timereturn);
		noFreeTicket = CalcFreeTicket(Passengers);
		Price = (Passengers-noFreeTicket)*cost;
		tripprice = tripprice + Price;
		MoneyMake[timereturn] = MoneyMake[timereturn] + Price;
		System.out.println(Passengers + " tickets was sold");
		System.out.println("There will be " + noFreeTicket + " free tickets");
		System.out.println("The cost for this train is: " + Price);
		System.out.println("The toal cost for both trains is: " +tripprice);
		System.out.println("Thank you for coming");
	
	
	System.out.println(">>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< ");
	System.out.println("Are you a new customer, Y for yes and N for no: ");
	Scanner pick = new Scanner(System.in);
	String respond = pick.nextLine();
	respond = respond.toUpperCase();		
	if (!respond.equals("Y")) {
		go = false;
		System.out.println("Calculating total for the days");
		System.out.println(">>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<");
	}
	else {
		go = true;
		
	}
	
		
}
		
	int totalSeat = CalcSeat(SeatBuy);
	double totalMoney = CalcMoney(MoneyMake);
	int mostSeats = mostSeat(SeatBuy);
	for (int i = 0; i < SeatBuy.length; i++) {
		if (SeatBuy[i] == mostSeats) {
			System.out.println("The coach with the most seats is: " + Departure[i]);
		}
	}
	System.out.println("The total money made is: " + totalMoney);
	System.out.println("The toal amount of seats bought is: " + totalSeat);
	System.out.println("Day ended");
	
}

public int mostSeat(int[] s) {
	int largest = s[0];
	for (int i = 1; i < s.length; i++) {
		if (largest < s[i]) {
			largest = s[i];
		}
	}
	return largest;
}

public int CalcSeat(int[] s) {
	int total = 0;
	for (int i = 0; i < s.length; i++) {
		total = total + s[i];
	}
	return total;
}

public double CalcMoney(double[] m) {
	double total = 0;
	for (int i = 0; i < m.length; i ++) {
		total = total + m[i];
	}
	return total;
}

public int OrderTicketGo(String d[]) {
	Scanner input = new Scanner(System.in);
	String index = input.nextLine();
	while (!checkInt(index)) {
		System.out.print("Not valid, please re-enter your choice: ");
		index = input.nextLine();
	}
	int indexChosen = Integer.parseInt(index);
	
	while (indexChosen < 0 || indexChosen > 3) {
			System.out.print("Not valid number, please re-enter your choice: ");
			indexChosen = input.nextInt();
	}
	return indexChosen;
	}

public int OrderTicketReturn(String d[], int limit) {
	Scanner input = new Scanner(System.in);
	String index = input.nextLine();
	while (!checkInt(index)) {
		System.out.print("Not valid, please re-enter your choice: ");
		index = input.nextLine();
	}
	int indexChosen = Integer.parseInt(index);
	
	while (indexChosen < limit+4 || indexChosen > 7) {
		System.out.print("Not valid number, please enter again: ");
		indexChosen = input.nextInt();
	}
	return indexChosen;
}

public boolean checkFull(int[] c,int p, int i) {
	if (c[i] <= 0) {
		return true;
	}
	if (c[i] - p < 0) {
		return true;
	}
	else {
		return false;
	}
}

public int CalcFreeTicket(int n) {
	if (n < 10 || n > 80) {
		return 0;
	}
	int free = n/10;
	return free;
}


public int addSeat(int n, int[] s, int i) {
	int seats = s[i] + n;
	return seats;
}

public boolean checkInt(String i) {
	try {
		Integer.parseInt(i);
		return true;
	}
	catch(NumberFormatException e) {
		return false;
	}
	
}

public static void main(String[] args) {
	Train t1 = new Train();
}
}
