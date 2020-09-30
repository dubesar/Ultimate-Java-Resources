import java.util.*;
import java.io.*;
public class apriori {
static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    
    static HashMap<TreeSet<String>,Integer> filtersupport(HashMap<TreeSet<String>,Integer> map,int support)
    {
        HashMap<TreeSet<String>,Integer> calsupport =new HashMap<>();
         for( Map.Entry<TreeSet<String>,Integer> entry : map.entrySet() )
        {
            if(entry.getValue()>=support)
            {
                calsupport.put(entry.getKey(),entry.getValue());
            }
            //System.out.println( entry.getKey() + " => " + entry.getValue() );
            //HashSet<String> set=new HashSet<>();
            //set.add(entry.getKey());
            //calsupport.put(set,entry.getValue());
        }
        return calsupport;
    }
    static int frequency(HashMap<Integer,TreeSet<String>> trans,TreeSet<String> items)
    {
        int count=0;boolean cont=true;
             for( Map.Entry<Integer, TreeSet<String>> entry : trans.entrySet() )
         {
             TreeSet<String> itemset=entry.getValue();
             
             cont=true;
             for( String item : items )
             {
                 if(itemset.contains(item)==false)
                 {
                     cont =false;
                     break;
                 }
                /*if(itemfreq.containsKey(item)==false)
                {
                    itemfreq.put(item,1);
                }
                else
                {
                    itemfreq.put(item,itemfreq.get(item)+1);
                }*/
                
            }
            if(cont==true)
            count++;
            
                //System.out.println( entry.getKey() + " => " + entry.getValue() );
        }
        return count;
    }
    
     static int factorial(int n) 
    { 
        if (n == 0) 
            return 1; 
  
        return n * factorial(n - 1); 
    } 
    
    
    public static void main(String args[]) 
{
	FastReader s=new FastReader();int trans=0,items=0,support=0,freq=0,p=0,num=1,confidence=0,supportof=0,confi=0;String str="",str11="",str12="",item1="";
     //Scanner in=new Scanner(System.in);
     //if(in.hasNext())
     HashMap<Integer,TreeSet<String>> map=new HashMap<>();
     TreeSet<String> totitems=new TreeSet<>();
     trans=s.nextInt();
     
     
     //input taken-----------------
     for(int j=0;j<trans;j++)
     {
      //   if(in.hasNext())
         items=s.nextInt();
         TreeSet<String> set=new TreeSet<>();
         for(int i=0;i<items;i++)
         {
             str=s.next();
             totitems.add(str);
             set.add(str);
         }
         map.put(j+1,set);
     }
     support=s.nextInt();
     confidence=s.nextInt();
     
     HashMap<TreeSet<String>,Integer> itemfreq=new HashMap<>();
     HashMap<TreeSet<String>,Integer> finalcomb=new HashMap<>();
     for(String str1:totitems)
     {
         TreeSet<String> temp=new TreeSet<>();
         temp.add(str1);
         p=frequency(map,temp);
         itemfreq.put(temp,p);
     }
     
     int common=-1;
     int counter=1;
     
     //for(int i1=1;i1<=4;i1++)
     while(itemfreq.size()!=0)
     {
     
     System.out.println("Iteration "+(num));
     
     
     itemfreq=filtersupport(itemfreq,support);
     
     
     
     
    /* for( Map.Entry<Integer, HashSet<String>> entry : map.entrySet() )
     {
         HashSet<String> itemset=entry.getValue();
         for( String item : itemset )
         {
            if(itemfreq.containsKey(item)==false)
            {
                itemfreq.put(item,1);
            }
            else
            {
                itemfreq.put(item,itemfreq.get(item)+1);
            }
        }
            //System.out.println( entry.getKey() + " => " + entry.getValue() );
    }*/
    
    /* HashSet<String> itemremove=new HashSet<>();
     for( Map.Entry<String,Integer> entry : itemfreq.entrySet() )
     {
         item1=entry.getKey();
         freq=entry.getValue();
        // System.out.println(item1+" "+freq);
         if(freq<support)
         {
             itemremove.add(item1);
         }
     }*/
    //System.out.println(itemremove);
     /*for( String item : itemremove )
         {
            String k=(String)itemfreq.remove(item);
        }*/
        
        //convert 
       /* HashMap<HashSet<String>,Integer> calsupport =new HashMap<>();
        for( Map.Entry<String, Integer> entry : itemfreq.entrySet() )
        {
            System.out.println( entry.getKey() + " => " + entry.getValue() );
            HashSet<String> set=new HashSet<>();
            set.add(entry.getKey());
            calsupport.put(set,entry.getValue());
        }
        calsupport=filtersupport(calsupport,support);*/
        List<TreeSet<String>> list = new ArrayList<>();
        for( Map.Entry<TreeSet<String>,Integer> entry : itemfreq.entrySet() )
        {
            TreeSet<String> temp=entry.getKey();
            System.out.println( temp + " => " + entry.getValue() );
            list.add(temp);
            //HashSet<String> set=new HashSet<>();
            //set.add(entry.getKey());
            //calsupport.put(set,entry.getValue());
        }
        itemfreq.clear();
        
        common++;
        num++;
        counter=factorial(num);
        
        HashMap<TreeSet<String>,Integer> setfreq=new HashMap<>();
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.size();j++)
            {
                if(i!=j)
                {
               TreeSet<String> hs1=list.get(i);
               TreeSet<String> hs2=list.get(j);
               //System.out.println(hs1+" "+hs2);
               int getcommon=findintersection(hs1,hs2);
               //System.out.println("common="+getcommon+" ogcomm="+common);
                   if(getcommon==common)
                   {
                       TreeSet<String> merge=mergeSet(hs1,hs2);
                       if(setfreq.containsKey(merge)==false)
                       {
                           //System.out.println("first time="+merge);
                           setfreq.put(merge,1);
                       }
                       else
                       {
                           //System.out.println("second time="+merge);
                           setfreq.put(merge,setfreq.get(merge)+1);
                       }
                   }
                }
               
            }
        }
        
        for( Map.Entry<TreeSet<String>, Integer> entry : setfreq.entrySet() )
        {
            
            TreeSet<String> temp=entry.getKey();
            int freq1=entry.getValue();
            //System.out.println("starter\n"+ temp + " => " + freq1 +" "+counter);
            if(freq1==counter)
            {
                itemfreq.put(temp,frequency(map,temp));
            }
            
        }
        
        //System.out.println("SIZE after"+itemfreq.size());
        
        if(itemfreq.size()==0)
        break;
        
        finalcomb=new HashMap<>(itemfreq);
        //finalcomb=itemfreq.clone();
        
        
        
     }
     
     System.out.println("----------------------FINAL----------------------");
        
        for( Map.Entry<TreeSet<String>,Integer> entry : finalcomb.entrySet() )
        {
            TreeSet<String> temp=entry.getKey();
            
            System.out.println( temp + " => " + entry.getValue() );
            
           // list.add(temp);
            //HashSet<String> set=new HashSet<>();
            //set.add(entry.getKey());
            //calsupport.put(set,entry.getValue());
        }
        
        for( Map.Entry<TreeSet<String>,Integer> entry : finalcomb.entrySet() )
        {
            TreeSet<String> temp=entry.getKey();
            
            supportof=frequency(map,temp);
            List<String> list1 = new ArrayList<>(temp);
            System.out.println(list1);
            for(int i=0;i<list1.size();i++)
            {
                for(int j=0;j<list1.size();j++)
                {
                    if(i>j)
                    continue;
                    if(i==j)
                    {
                        str11=list1.get(i);
                        TreeSet<String> temp2=new TreeSet<>();
                        temp2.add(str11);
                        confi=(supportof/frequency(map,temp2))*100;
                        if(confi>=confidence)
                        {
                            System.out.println(temp2+" confidence="+confidence); 
                        }
                    }
                    else
                    {
                         str11=list1.get(i);
                         str12=list1.get(j);
                        TreeSet<String> temp2=new TreeSet<>();
                        temp2.add(str11);
                        temp2.add(str12);
                        confi=(supportof/frequency(map,temp2))*100;
                         if(confi>=confidence)
                        {
                            System.out.println(temp2+" confidence="+confi); 
                        }
                    }
                }
                
                
            }
            
            //System.out.println( temp + " => " + entry.getValue() );
            
           // list.add(temp);
            //HashSet<String> set=new HashSet<>();
            //set.add(entry.getKey());
            //calsupport.put(set,entry.getValue());
       }
        
        
        
        
    
    
    }
    
    static int findintersection(TreeSet<String> hs1,TreeSet<String> hs2)
    {
        int common=0;
        for(String str:hs1)
        {
            if(hs2.contains(str))
            common++;
        }
        return common;
    }
    
     public static TreeSet<String> mergeSet(TreeSet<String> a, TreeSet<String> b) 
    { 
        return new TreeSet<String>() {{ 
                      addAll(a); 
                       addAll(b); 
        } }; 
    } 
}