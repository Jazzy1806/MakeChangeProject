package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {
//Test- did this commit?
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("What is the price of the item? ");
		//Multiplying price by 100 to allow for integer conversion later
		double price = scan.nextDouble() * 100;
		
		System.out.print("How much was tendered by the customer? ");
		//Multiplying tender by 100 to allow for integer conversion later
		double tender = scan.nextDouble() * 100;
		
		if (tender == price) {
			System.out.println("\nCustomer provided the exact amount. No change is due.");
		}
		else if (tender < price) {
			System.out.println("\nCustomer has not provided enough to purchase this item.");
		}
		else {
			//Cast all formats to integer before doing arithmetic to handle inaccuracy of double numbers at penny level
			int change = (int) (tender - price);

			int[] amount = {2000, 1000, 500, 100, 25, 10, 05, 01};
			String[] denomination = {" twenty dollar bill(s)\n", " ten dollar bill(s)\n", " five dollar bill(s)\n", " one dollar bill(s)\n", " quarter(s)\n", " dime(s)\n", " nickel(s)\n", " penny(ies)\n"};
			System.out.println("\nThe customer is due the following change:\n");
		
			for (int i = 0; i<8; i++) {
				int due = change / amount[i];
				change %= amount[i];
				if (due != 0) {
					System.out.print(due + denomination[i]);
				}
			}
		}
	}
}