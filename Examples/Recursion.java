class HelloWorld{

  public static void main(String[] args){
  
  static int fact(int n)
    {
        if (n == 1)
 
		// base condition
            return 1;
        else   
            return n*fact(n-1);    
    }    
	public static void main(String[] args) {
    int result = fact(10);
     
     System.out.println("10! = " + result);
    }
  }
}
