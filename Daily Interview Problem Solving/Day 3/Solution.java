class Solution {
    int dirs[][] = {{0, 1}, {1,0}, {0,-1}, {-1,0}};
    
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< 2; i++){
            for(int j=0; j< 3; j++){
                sb.append(board[i][j]);
            }
        }
        
        String start = sb.toString();
        
        Set<String> set = new HashSet<>();
        set.add(start);
        
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        
        
        int moves = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){
                String curr = queue.poll();
                
                if(curr.equals(target)){
                    return moves;
                }
                
                int index = curr.indexOf('0');
                int x = index / 3;
                int y = index % 3;
                
                for(int dir[]: dirs){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    
                    if(newX < 0 || newY <0 || newX >= 2 || newY >= 3){
                        continue;
                    }
                    
                    String next = swap(curr, index, newX*3 + newY);
                    
                    if(!set.contains(next)){
                        queue.add(next);
                        set.add(next);
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
    
    public String swap(String str, int i, int j){
        char arr[] = str.toCharArray();
        
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        
        return new String(arr);
    }
}