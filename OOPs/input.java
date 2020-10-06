package elebill;

import java.util.Scanner;

public class input {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No of users: ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Units: ");
			double u=sc.nextDouble();
			System.out.println("Enter Phases:");
			int ph=sc.nextInt();
			
		}
	}
}
