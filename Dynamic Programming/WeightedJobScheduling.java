import java.util.Arrays; 
import java.util.Comparator; 
  
class Job 
{ 
    int start, finish, profit; 
    
    Job(int start, int finish, int profit) 
    { 
        this.start = start; 
        this.finish = finish; 
        this.profit = profit; 
    } 
} 
  
// Used to sort job according to finish times 
class JobComparator implements Comparator<Job> 
{ 
    public int compare(Job a, Job b) 
    { 
        return a.finish < b.finish ? -1 : a.finish == b.finish ? 0 : 1; 
    } 
} 
  
public class WeightedJobScheduling 
{ 
    public static int binarySearch(Job jobs[], int index) 
    { 
        int lo = 0, hi = index - 1; 
  
        while (lo <= hi) 
        { 
            int mid = (lo + hi) / 2; 
            if (jobs[mid].finish <= jobs[index].start) 
            { 
                if (jobs[mid + 1].finish <= jobs[index].start) 
                    lo = mid + 1; 
                else
                    return mid; 
            } 
            else
                hi = mid - 1; 
        } 
  
        return -1; 
    } 
   
    public static int schedule(Job jobs[]) 
    { 
        Arrays.sort(jobs, new JobComparator()); 
        int n = jobs.length; 
        int table[] = new int[n]; 
        table[0] = jobs[0].profit; 
  
        for (int i=1; i<n; i++) 
        { 
            int inclProf = jobs[i].profit; 
            int l = binarySearch(jobs, i); 
            if (l != -1) 
                inclProf += table[l]; 
            table[i] = Math.max(inclProf, table[i-1]); 
        } 
  
        return table[n-1]; 
    } 
    
    public static void main(String[] args) 
    { 
        Job jobs[] = {new Job(1, 2, 50), new Job(3, 5, 20), 
                      new Job(6, 19, 100), new Job(2, 100, 200)}; 
  
        System.out.println("Optimal profit is " + schedule(jobs)); 
    } 
} 
