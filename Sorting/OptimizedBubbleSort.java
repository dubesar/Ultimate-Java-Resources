class BubbleSort {
  public static void bubbleSort (int [] a){
        for (int j = 0; j < a.length-1; j++){
            if (a[j] > a[j+1]) {
                swap (a, j, j+1);
                j = 0;
            }  
        }
  }  
  public static void swap (int a [], int i, int j){
        int temp = a[i]; 
        a[i] = a[j]; 
        a[j] = temp; 
  }
}
