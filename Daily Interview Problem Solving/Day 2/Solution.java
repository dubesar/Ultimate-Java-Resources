public class Main {
    
    public static int[] productExceptSelf(int[] numArray) {
        // fill in
        // with solution
      int p = 1;
      for(int i = 0; i < numArray.length; i++){
        p*=numArray[i];
      }
      int sz = numArray.length;
      int ct0 = 0;
      for(int i = 0 ; i < numArray.length;i++){
        if(numArray[i] == 0){
          ct0++;
        }
      }
      int arr[] = new int[sz];
      if(ct0>=2){
        for(int i = 0; i < arr.length; i++){
          arr[i] = 0;
        }
      }
      else if(ct0 == 1){
        for(int i = 0; i < arr.length; i++){
          if(numArray[i] == 0){
            arr[i] = p;
          }
          else{
            arr[i] = 0;
          }
        }
      }
      else{
        for(int i = 0; i < arr.length; i++){
        	arr[i] = p/numArray[i];
        }
      }
      
      return arr;
    }

    // remove or comment if running tests (we run our own main)
//     public static void main(String[] args) {
//         Main.productExceptSelf(new int[] {});
//     }

}


