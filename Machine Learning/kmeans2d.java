import java.util.*;
class kmeans2d
{
    public static double findcentroidx(ArrayList<ArrayList<Integer>> alist)
    {
        int size=alist.size();
        double sum=0.0;
        for(int i=0;i<size;i++)
        {
            ArrayList<Integer> temp=alist.get(i);
            sum+=(double)temp.get(0);
        }
        sum/=(double)size;
        return sum;
    }
    public static double findcentroidy(ArrayList<ArrayList<Integer>> alist)
    {
        int size=alist.size();
        double sum=0.0;
        for(int i=0;i<size;i++)
        {
            ArrayList<Integer> temp=alist.get(i);
            sum+=(double)temp.get(1);
        }
        sum/=(double)size;
        return sum;
    }
    public static void main(String args[]) 
    {
           
            int n=0;
            double centroidx1=0.0,centroidy1=0.0,centroidx2=0.0,centroidy2=0.0,dist1=0.0,dist2=0.0;
            ArrayList<ArrayList<Integer>> cluster1=new ArrayList<>();
            ArrayList<ArrayList<Integer>> cluster2=new ArrayList<>();
            Scanner in=new Scanner(System.in);
            System.out.println("Enter the number of 2d points");
            n=in.nextInt();
            System.out.println("Enter "+n+" points");
            int points[][]=new int[n][2];
            for(int i=0;i<n;i++)
            {
                //System.out.println("Enter the coordinates of "+(i+1)+" point");
                points[i][0]=in.nextInt();
                points[i][1]=in.nextInt();
                if(i==0)
                {
                    ArrayList<Integer> c1=new ArrayList<>();
                    c1.add(points[i][0]);
                    c1.add(points[i][1]);
                    centroidx1=points[i][0];
                    centroidy1=points[i][1];
                    cluster1.add(c1);
                }
                if(i==1)
                {
                    ArrayList<Integer> c2=new ArrayList<>();
                    c2.add(points[i][0]);
                    c2.add(points[i][1]);
                    centroidx2=points[i][0];
                    centroidy2=points[i][1];
                    cluster2.add(c2);
                }
            }
            

            for(int i=2;i<n;i++)
            {
                dist1=Math.sqrt(Math.pow(points[i][0]-centroidx1,2)+Math.pow(points[i][1]-centroidy1,2));
                dist2=Math.sqrt(Math.pow(points[i][0]-centroidx2,2)+Math.pow(points[i][1]-centroidy2,2));
                if(dist1<dist2)
                {
                    ArrayList<Integer> c1=new ArrayList<>();
                    c1.add(points[i][0]);
                    c1.add(points[i][1]);
                    cluster1.add(c1);
                    centroidx1=findcentroidx(cluster1);
                    centroidy1=findcentroidy(cluster1);
                }
                else
                {
                    ArrayList<Integer> c2=new ArrayList<>();
                    c2.add(points[i][0]);
                    c2.add(points[i][1]);
                    cluster2.add(c2);
                    centroidx2=findcentroidx(cluster2);
                    centroidy2=findcentroidy(cluster2);
                }
            }

            System.out.println("Points in Cluster 1");
            for(int i=0;i<cluster1.size();i++)
            {
                System.out.println(cluster1.get(i).toString());
            }

            System.out.println("Points in Cluster 2");
            for(int i=0;i<cluster2.size();i++)
            {
                System.out.println(cluster2.get(i).toString());
            }
        

            
            
    }
}