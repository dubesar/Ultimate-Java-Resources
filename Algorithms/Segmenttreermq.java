import java.util.*;
public class Segmenttreermq {


    static void build(int tree[],int index,int s,int e,int a[])
    {
        if(s>e)
        return;
        if(s==e)
        {
            tree[index]=a[s];
        }
        else
        {
            int mid=(s+e)/2;
            build(tree,2*index,s,mid,a);
            build(tree,2*index+1,mid+1,e,a);
            int left=tree[2*index];
            int right=tree[2*index+1];
            tree[index]=Math.min(left,right);
        }
    }
    static int query(int tree[],int index,int s,int e,int qs,int qe)
    {
        if(s>=qs && e<=qe)//complete
        return(tree[index]);
        else if(qe<s || qs>e)
        return Integer.MAX_VALUE;
        else
        {
            int mid=(s+e)/2;
            return(Math.min(query(tree,2*index,s,mid,qs,qe),query(tree,2*index+1,mid+1,e,qs,qe)));
        }
    }
    static void update(int tree[],int index,int s,int e,int i,int val)
    {
        if(i<s || i>e)
        return;
        else if(s==e)
        {tree[index]=val;return;}
        else
        {
         int mid=(s+e)/2;
         update(tree,2*index,s,mid,i,val);
         update(tree,2*index+1,mid+1,e,i,val);
         tree[index]=Math.min(tree[2*index],tree[2*index+1]);
        }
    }
    
   
    public static void main(String args[]) 
    {
      
      int a[]={1,3,2,-2,4,5};
      int n=a.length;
      int tree[]=new int[4*n+1];
      int index=1;
      int s=0;
      int e=n-1;
      build(tree,index,s,e,a);
      //System.out.println(Arrays.toString(tree));
      
      System.out.println("Minimum from 2 to 5 = " + query(tree,index,s,e,2,5));
      update(tree,index,s,e,3,-100);
     // System.out.println(Arrays.toString(tree));
      System.out.println("Minimum from 4 to 5 = " + query(tree,index,s,e,4,5));
      
      //System.out.println(Arrays.toString(tree));
      System.out.println("Minimum from 2 to 4 = " + query(tree,index,s,e,2,4));
    }
}