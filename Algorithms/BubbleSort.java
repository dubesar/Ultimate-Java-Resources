class BubbleSort 
{ 
    void bubbleSort(int aray[]) 
    { 
        int n = aray.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (aray[j] > aray[j+1]) 
                { 
                    int temp = aray[j]; 
                    aray[j] = aray[j+1]; 
                    aray[j+1] = temp; 
                } 
    } 
  
    
    void printArray(int aray[]) 
    { 
        int n = aray.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(aray[i] + " "); 
        System.out.println(); 
    } 
  

    public static void main(String args[]) 
    { 
        BubbleSort ob = new BubbleSort(); 
        int aray[] = {55, 38, 9, 86, 72, 10, 21}; 
        ob.bubbleSort(aray); 
        System.out.println("Sorted array"); 
        ob.printArray(aray); 
    } 
} 