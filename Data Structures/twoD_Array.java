
import java.util.*;
import java.lang.*;
import java.io.*;


class twoDimensionalArray
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		int n = 3;         
		
		// twoD_Matrix is dynamic two dimensional array initialized with n=3 rows.
		ArrayList<ArrayList<Integer> > twoD_Matrix = new ArrayList<ArrayList<Integer>>(n);
		
		//Rows of two-d matrix
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		ArrayList<Integer> row3 = new ArrayList<Integer>();
		
		//Inserting elements to the row 1
		row1.add(10);
		row1.add(11);
		row1.add(12);
		
		//Inserting elements to the row 2
		row2.add(20);
		row2.add(21);
		row2.add(22);
		
		//Inserting elements to the row 3
		row3.add(30);
		row3.add(31);
		row3.add(32);
		
		//Inserting rows to the matrix
		twoD_Matrix.add(row1);
		twoD_Matrix.add(row2);
		twoD_Matrix.add(row3);
		
		//printing the matrix
		for (int i = 0; i < twoD_Matrix.size(); i++) { 
		    
		    // Iterating over each rows of the twoD_Matrix
            
            for (int j = 0; j < twoD_Matrix.get(i).size(); j++) { 
                
                //Iterating over each elements of the rows
                
                System.out.print(twoD_Matrix.get(i).get(j) + " "); 
            } 
            
            System.out.println(); 
        }
        
        
        
        
		/*
		If user want to give inputs from the console 
		
		Scanner input = new Scanner(System.in);
		// Instance of scanner class to take input from the console.
		
		
		System.out.print("Please input no of rows: ");
		
		n=input.nextInt();
		
		Iterate till n and take input from the user and insert into the matrix
		
		*/
    
	}	
}
