public class Just_Greater_Binary_Search {

// implementation of upper bound method as in C++ in Java using iterative binary search

    static int findJustGreater(int inp[],int low ,int high,int x){

        // doesn't handle equals to case , which is more often than not required
        
        // iterative binary search
        
        int mid ;
        int ans = -1 ;
        while(low<=high){
             mid = (low+high)/2 ;
             
             if(inp[mid]<=x){
             
                 low = mid+1;
                 
             }else{
             
                 ans = mid;
                 high = mid - 1;
                 
             }

        }

        return ans;

    }

    public static void main(String[] args) {
  
        // already sorted input array
        int inp[] = {4,5,5,5,7,8,11,12,15,17};
        
        /* i will contain the index ofjust greater element than
           11 in inp array (similar to upper bound in C++)
        */
        
        int i = findJustGreater(inp,0,inp.length-1,11);
        
        // -1 implies no element greater than 11 in our inp array
        
        if(i!=-1)
        System.out.println(i+" "+inp[i]);

    }
}
