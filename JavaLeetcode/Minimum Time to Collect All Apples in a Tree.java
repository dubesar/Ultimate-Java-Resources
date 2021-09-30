public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        
        for(int[] e: edges) {
            if(!tree.containsKey(e[0])) {
                tree.put(e[0], new HashSet<>());
            }
            tree.get(e[0]).add(e[1]);
        }
        
        int[] ans = dfs(0, hasApple, tree);
        
        int sum = 0;
        
        for(int val: ans) {
            sum += val;
        }
        
        return sum;
    }
    
    public int[] dfs(int start, List<Boolean>hasApple, Map<Integer, Set<Integer>> tree) {
        if(!tree.containsKey(start)) {
            if(hasApple.get(start) == false) {
                return new int[]{0};
            } else {
                return new int[]{1};
            }
        }
        
        Set<Integer> set = tree.get(start);
        
        int len = set.size(), index = 0;
        
        int[] ans = new int[len];
        
        for(int val: set) {
            int[] child = dfs(val, hasApple, tree);
            int sum = 0;
            for(int depth: child) {
                sum += depth;
            }
            if(sum == 0) {
                if(hasApple.get(val) == true) {
                    ans[index++] = 2;
                } else {
                    ans[index++] = 0;
                }
            } else {
                if(tree.containsKey(val)) {
                    ans[index++] = sum + 2;
                } else {
                    ans[index++] = sum + 1;
                }
                
            }
        }
        
        return ans;
    }
