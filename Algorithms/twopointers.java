public boolean twoSum(int[] list, int targetValue) {
    
    //each pointer starts at the opposite end of the sorted list and moves towards the middle
    
    int pointerA = 0;
    int pointerB = list.length - 1;
    
    
    while (pointerA < pointerB) {
        //calculates the sum
        int sum = list[pointerA] + list[pointerB];
        
        //main checker, check whether sum is larger, smaller, or equal to the target
        if (sum == targetValue) {
            return true;
        
        // this section decreases the larger value or increases the smaller value depending on if the sum is 
        // larger or smaller than the target value
        } else if (sum < targetValue) {
            pointerA++;
        } else {
            pointerB--;
        }
    }
 
    return false;
}
