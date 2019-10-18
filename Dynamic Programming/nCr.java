import java.io.*;
public class nCr
{
  int store[1000][1000];
  int calc(int n,int r)
  {
    if(n<r)
    return 0;
    if(r==1)
    return n;
    if(r==0 || r==n)
    return 1;
    if(store[n][r] == -1)
    store[n][r] = calc(n-1,r-1) + calc(n-1,r);
    return store[n][r];
  }
  void main()throws IOException
  {
     BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     int t;
     System.out.println("Enter number of test cases");
     t = Integer.parseInt(in.readLine());
     for(int i=0;i<1000;i++)
     {
        for(int j=0;j<1000;j++)
        store[i][j] = -1;
        }
    while(t!=0)
    {
    t--;
    int n;
    int r;
    System.out.println("Enter the value of n and r in the form of nCr");
    n = Integer.parseInt(in.readLine());
    r = Integer.parseInt(in.readLine());
    int ans = calc(n,r);
    System.out.println(ans);
    }
   }
   
}
 
    
