package Polymorphism;

import java.util.Scanner;
import java.util.Random;

public class dice {

		int dice1;
		int dice2;
		int doubledice;
		
		
		
		
	public static void main(String[] args) {
			dice d1 = new dice();		
		}

	public dice(int loops)  {
		Random r1 = new Random();
		doubledice = 0;
		for(int i = 0; i < loops; i++) {
			roll();
		}
		System.out.println("Number of doubles: " +doubledice);
	}

	public dice() {
		Random r1 = new Random();
		doubledice = 0;
		for(int i = 0; i < 10; i++) {
			roll();
		}
			System.out.println("Number of doubles: " +doubledice);
	}
	private int roll() {
		 Random r1 = new Random();
		 
		 dice1 = r1.nextInt(6)+1;
		 dice2 = r1.nextInt(6)+1;
		
		if (dice1 == dice2) {
			doubledice++;
		}
		System.out.println("Rolled " +dice1+","+dice2);
		return doubledice;
	}
	}

