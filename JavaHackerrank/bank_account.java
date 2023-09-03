/*Design and write a class to represent a bank account that includes the following members:
a. Data members
· Owner name
· Account number
· Balance amount in the account
b. Methods members
· To assign initial values
· To deposit an amount
· To withdraw an amount after checking balance
· To display the owner name and balance*/

import java.util.Scanner;
public class BankAccount1
{
    int  acc_no;
    String name;
    float bal,amt,withdraw;
    Scanner A=new Scanner(System.in);
    void read()
    {
        System.out.println("Enter Owner's Name: ");
        name=A.next();
        System.out.println("Enter Account Number: ");
        acc_no=A.nextInt();
        }
    void deposit()
    {
        int choice;
        float current,saving;
        Scanner A=new Scanner(System.in);
        System.out.println("Enter Initial Amount: ");
        amt=A.nextFloat();
        System.out.println("1.Savings Account");
        System.out.println("2.Current Account");
        System.out.println("Enter Choice: ");
        choice=A.nextInt();
        switch(choice)
        {
            case 1:
            saving=amt;
            System.out.println("Amount In Savings Account Is: "+saving);
            break;
            case 2:
            current=amt;
            System.out.println("Amount In Savings Account Is: "+current);
            break;
            default:
            break;
            
        }
    }
    void withdraw()
    {
       Scanner A=new Scanner(System.in);
       System.out.println("Enter Withdrawal Amount: ");
       withdraw=A.nextFloat();
       bal=amt-withdraw;
       amt=bal;
       if(bal>0)
       {
       System.out.println("Balance Amount Left Is :"+bal);
       }
      else
      {
       System.out.println("Zero Balance");
        }
	}
    void display()
	{
		System.out.println("Owner's Name Is: "+name);
		System.out.println("Balance Left In Bank Is: "+bal);
	}
	public static void main(String[] args) {
		BankAccount1 B1=new BankAccount1();
		B1.read();
		B1.deposit();
		B1.withdraw();
		B1.display();

	}

}
