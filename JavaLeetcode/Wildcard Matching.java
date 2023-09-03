public boolean isMatch(String s, String p) {
        
        int rows= s.length();
        int cols = p.length();
        
        boolean[][] dp = new boolean[rows+1][cols+1];
        
        dp[0][0] = true;
        
        for(int j = 1; j < cols+1; j++){
            if(p.charAt(j-1) == '*'){
             dp[0][j] = dp[0][j-1];   
            } 
        }
        
        for(int i = 1; i < rows+1; i++){
            for(int j = 1; j < cols+1; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = (dp[i-1][j] || dp[i][j-1]);
                }
            }
        }
     return dp[rows][cols];   
    }
