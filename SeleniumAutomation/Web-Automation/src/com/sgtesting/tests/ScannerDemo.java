package com.sgtesting.tests;

import java.util.Scanner;

public class ScannerDemo {

public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String Value:");
		String s=sc.nextLine();
		System.out.println(s);
		sc.close();
	}
}
