//Question
//https://leetcode.com/problems/merge-intervals/


class Solution {
    public int[][] merge(int[][] arr) {
        Stack<Pair>st=new Stack<>();
        Pair[] pairs=new Pair[arr.length];
        for(int i=0;i<arr.length;i++){
            pairs[i]=new Pair(arr[i][0],arr[i][1]);
        }
        
        Arrays.sort(pairs);
        for(int i=0;i<pairs.length;i++){
            if(i==0)
                st.push(pairs[i]);
            else{
                Pair top=st.peek();
                Pair curr=pairs[i];
                if(top.et<curr.st)
                    st.push(curr);
                else
                    top.et=Math.max(curr.et,top.et);
            }
        }
         Stack<Pair>rs=new Stack<>();
        int j=0;
        while(st.size()>0){
            rs.push(st.pop());
            j++;
        }
        int [][] merge=new int[j][2];
        for(int i=0;i<merge.length;i++){
            Pair top=rs.pop();
            merge[i][0]=top.st;
            merge[i][1]=top.et;
        }
        return merge;
    }
    public static class Pair implements Comparable<Pair>{
        int st;
        int et;
        public Pair(int st,int et){
            this.st=st;
            this.et=et;
        }
        
        public int compareTo(Pair other){
            if(this.st!=other.st)
                return this.st-other.st;
            else
                return this.et-other.et;
        }
    }
}
