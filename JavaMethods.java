import java.io.*;

class Addition
{
    // adding two integer value.
    public int add(int a, int b)
    {
        
        int sum = a+b;
        return sum;
    }
  
}

class GFG 
{
    private static int addTwo(int a,int b){
        int sum = a+b;
        return sum;
    }
	public static void main (String[] args) 
	{
		Addition ob = new Addition();
		int sum1 = ob.add(1,2);
		System.out.println("sum of the two integer value :" + sum1);
		
		int sum2 = ob.add(1,2);
		System.out.println("sum of the three integer value :" + sum2);
		
		int sum3 = addTwo(1,2);
		System.out.println(sum3);
		
	}
}
