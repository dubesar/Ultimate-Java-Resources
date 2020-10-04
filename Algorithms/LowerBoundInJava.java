public class Just_Smaller_Binary_Search {

    // implementation of lower bound as in C++ in Java

    static int findJustSmaller(int inp[],int low,int high,int x){
    
    // iterative binary search used in implementation
    
        int ans = -1;
        
        while(low<=high){
        
            int mid = (low+high)/2;
            
            if(inp[mid]>=x){
            
                high = mid-1;
                
            }else{
            
                ans = mid;
                low = mid+1;
                
            }
        }
        
        return ans;
        
    }

    public static void main(String[] args) {
    
        // array already sorted 
        
        int inp[] = {4,5,5,5,7,8,11,12,15,17};
        
        /* index i will contain the index of element in inp
           array which is just smaller than 7*/
        
        int i = findJustSmaller(inp,0,inp.length-1,7);
        
        // -1 implies no such element exsists in inp array
        
        if(i!=-1)
            System.out.println(i+" "+inp[i]);
    }
}
