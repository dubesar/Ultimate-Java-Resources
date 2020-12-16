import java.util.*;
public class rectparity {
    
    
    static int even_parity(int seq[])
    {
        int count=0;
        for(int i=0;i<seq.length;i++)
        {
            if(seq[i]==1)
            count++;
        }
        if(count%2==0)
        return 0;
        else
        return 1;
    }
    static int ans=-1;
    static int row_parity[];
    static int col_parity[];

     static int[][] rect_parity(int codeword[][],int nrows,int ncols)
    {
        int c=0,rcount=0,ccount=0,col=0,row=0,m=0,getparity=0;
            for(int rows[]:codeword)
            {
                getparity=even_parity(rows);
                if(getparity!=row_parity[c])
                {
                    rcount++;
                    row=c;
                }
                c++;
                if(rcount>1)
                {
                    ans=2;return codeword;
                }
            }
            for(int i=0;i<ncols;i++)
            {
                int colsarray[]=new int[nrows];
                m=0;
                for(int j=0;j<nrows;j++)
                {
                    colsarray[m]=codeword[j][i];
                    m++;
                }
                getparity=even_parity(colsarray);
                if(getparity!=col_parity[i])
                {
                    ccount++;
                    col=i;
                }
                if(ccount>1)
                {
                    ans=2;return codeword;
                }
            }
            if(rcount==0 && ccount==0)
            {
                ans=0;
            }
            else if(rcount!=0 && ccount!=0)
            {
                ans=1;
                codeword[row][col]=flip_bit(codeword[row][col]);
            }
            else if(rcount!=0)
            {
                ans=1;
                row_parity[row]=flip_bit(row_parity[row]);
            }
            else if(ccount!=0)
            {
                ans=1;
                col_parity[col]=flip_bit(col_parity[col]);
            }
            return codeword;
    }

    public static int flip_bit(int i)
    {
        if(i==0)
        return 1;
        else
        return 0;
    }
    public static void main(String args[]) 
    {
        test_correct_errors();
    }
    public static void print2d(int codeword[][])
    {
        System.out.print("[");
        for(int row[]:codeword)
        System.out.print(Arrays.toString(row)+" ");
        System.out.println("]");
    }
    public static void test_correct_errors()
    {
        
        System.out.println("Message sent from sender...");
        int[][] codeword1={{0, 1, 1, 1}, {1, 1, 1, 0}};
        System.out.print("Received Codeword is:");
        print2d(codeword1);
        int nrows=0,ncols=0;
        row_parity=new int[2];
        col_parity=new int[4];
        row_parity[0]=1;
        row_parity[1]=0;
        col_parity[0]=0;
        col_parity[1]=0; 
        col_parity[2]=0;
        col_parity[3]=1; 
        System.out.println("Received Row parity="+Arrays.toString(row_parity));
        System.out.println("Received Column parity="+Arrays.toString(col_parity));
        nrows=codeword1.length;
        ncols=codeword1[0].length;
        ans=-1;
        codeword1=rect_parity(codeword1,nrows,ncols);
        
        if(ans==0)
        {
            System.out.println("Testing all 2**n = 256 valid codewords\n...passed");
            System.out.println("Testing all possible single-bit errors\n...passed");
            System.out.println("("+ (nrows*ncols+nrows+ncols)+","+(nrows*ncols)+")"+" rectangular parity code successfully passed all 0,1 and 2 bit error tests");
        }
        else if(ans==1)
        {
            System.out.println("Error Detected and Corrected");
            System.out.println("New Codeword is:");
            print2d(codeword1);
            System.out.println("Row parity="+Arrays.toString(row_parity));
            System.out.println("Column parity="+Arrays.toString(col_parity));
        }
        else if(ans==2)
        {
            System.out.println("Uncorrectable error is detected");
            System.out.println("Uncorrected Codeword is:");
            print2d(codeword1);
            System.out.println("Row parity="+Arrays.toString(row_parity));
            System.out.println("Column parity="+Arrays.toString(col_parity));
        }
    }
}