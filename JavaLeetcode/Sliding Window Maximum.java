public static int[] maxSlidingWindow(List<Integer> nums, int k)
{
        int ans[]=new int[nums.size()-k+1];
        int n=nums.size();

        Deque<Integer> dq=new LinkedList<>();

        int m=0;

        for(int i=0;i<n;i++)
        {
            if(i>=k)
            {
                if(!dq.isEmpty()&&dq.peekFirst()==i-k)
                    dq.pollFirst();
            }

            while(!dq.isEmpty()&& nums.get(i) > nums.get(dq.peekLast()))
                dq.pollLast();

            dq.addLast(i);

            if(i>=k-1)
                ans[m++]=nums.get(dq.peekFirst());
        }

        
        return ans;
}
