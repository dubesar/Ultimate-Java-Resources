class BinarySearch {

	public static void main(String[] args){
		
		int arr[] = {2,3,4,10,40};
		
		int last = arr.length -1;
		
		int num = 10;
		
	    System.out.println(binarySearch(arr, 0, last, num));	
				
		
	}
	
	
	public static int binarySearch(int arr[], int start, int last, int num){
		
		if(last == start){
			
			int mid = (last + start) / 2;
			
			if(arr[mid] == num)
				return mid;
			
			if(num  > arr[mid]){
				return binarySearch(arr, mid + 1, last, num);
			}
			
			if(num < arr[mid]){
				return binarySearch(arr, start, mid -1 , num);
			}
			
			
		}
			return -1;
		
		
	}
	
	
}