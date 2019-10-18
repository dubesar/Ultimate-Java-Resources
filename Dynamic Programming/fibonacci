import java.io.*;
public class fibonacci
{
  int store[] = new int[1000000];
  int fibo(int n)
  {
    if(store[n]==-1)
    store[n] = fibo(n-1) + fibo(n-2);
    return store[n];
  }
  public void main()throws IOException
  {
    int t;
    System.out.println("enter number of test cases");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(in.readLine());

    for(int i=0;i<1000000;i++)
    store[i] = -1;
        store[0] = 0;
    store[1] = 1;
    while(t!=0)
    {
      t--;
      System.out.println(" enter the nth fibonacci number you want to find");
      int n = Integer.parseInt(in.readLine());
      int ans = fibo(n);
      System.out.println(ans);
     }
  }
}
    
