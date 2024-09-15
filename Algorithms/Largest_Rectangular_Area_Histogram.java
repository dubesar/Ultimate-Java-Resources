//Java program to find maximum rectangular area in linear time 

import java.util.Stack; 

public class RectArea_Histogram 
{ 
	static int getMaxArea(int hist[], int n) 
	{ 
		// The stack holds indexes of hist[] array 
		Stack<Integer> s = new Stack<>(); 
		
		int max_area = 0; // Initialize max area 
		int top; // To store top of stack 
		int area_with_top; // To store area with top bar as the smallest bar 
	 
		int i = 0; 
		while (i < n) 
		{ 
			// If this bar is higher than the bar on top stack, push it to stack 
			if (s.empty() || hist[s.peek()] <= hist[i]) 
				s.push(i++); 
	
			// If this bar is lower than top of stack, then calculate area of rectangle 
			// with stack top as the smallest bar. 
			else
			{ 
				top = s.peek();  
				s.pop(); 
	
				// Calculate the area with hist[tp] stack as smallest bar 
				area_with_top = hist[top] * (s.empty() ? i : i - s.peek() - 1); 
	
				// update max area, if needed 
				if (max_area < area_with_top) 
					max_area = area_with_top; 
			} 
		} 
	
		// Now pop the remaining bars from stack and calculate area with every 
		// popped bar as the smallest bar 
		while (s.empty() == false) 
		{ 
			top = s.peek(); 
			s.pop(); 
			area_with_top = hist[top] * (s.empty() ? i : i - s.peek() - 1); 
	
			if (max_area < area_with_top) 
				max_area = area_with_top; 
		} 
	
		return max_area; 

	} 
	
 
	public static void main(String[] args) 
	{ 
		int hist[] = { 6, 1, 7, 4, 5, 9, 2 }; 
		System.out.println(getMaxArea(hist, hist.length)); 
	} 
} 

