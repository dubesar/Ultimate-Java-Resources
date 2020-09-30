import java.util.*;
public class segmentedsieve {
    
    static int MAX =10000001;
    static ArrayList<Integer> sieve()
    {
        boolean isp[]=new boolean[MAX];
        Arrays.fill(isp,true);
        ArrayList<Integer> primes=new ArrayList<>();
        for(int i=2;i*i<MAX;i++)
        {
            if(isp[i])
            {
            for(int j=i*i;j<MAX;j+=i)
            {
                isp[j]=false;
               // primes.add(j);
            }
            }
        }
        primes.add(new Integer("2"));
        for(int i=3;i<MAX;i++)
        {
            if(isp[i])
            primes.add(i);
        }
        return primes;
    }
    static long segsieve(int l,int r,ArrayList<Integer> primes)
    {
        long prod=1;
        long p=1000000007;
        
        int base=0;
        boolean pr[]=new boolean[r-l+1];
        Arrays.fill(pr,true);
        int currprime=0;
        for(int i=0;primes.get(i)*(long)primes.get(i)<=r;i++)
        {
            currprime=primes.get(i);
            base=(l/currprime)*currprime;
            if(base<l)
            base+=currprime;
            for(int j=base;j<=r;j+=currprime)
            {
                pr[j-l]=false;
            }
            if(base==currprime)
            {
                pr[base-l]=true;
            }
        }
        long count=-1;
        for(int i=0;i<=(r-l);i++)
        {
            if(pr[i]==true)
            {
               prod=((prod%p)*((i+l)%p))%p;
            }
        }
        return prod;
    }
    public static void main(String args[]) 
    {
     Scanner in=new Scanner(System.in);int t=0,l=0,r=0;
     if(in.hasNext())
     t=in.nextInt();
     ArrayList<Integer> primes;
     primes=sieve();
         for(int j=0;j<t;j++)
         {
             if(in.hasNext())
             l=in.nextInt();
              if(in.hasNext())
             r=in.nextInt();
             System.out.println(segsieve(l,r,primes));
         }
    }
}