import java.util.Arrays;

class EditDistance {

    /*
     * There are three operations permitted on a word: replace, delete, insert. For
     * example, the edit distance between "a" and "b" is 1, the edit distance
     * between "abc" and "def" is 3.
     */
    public static void main(String[] args) {
        System.out.println(minDistance("", "Tree")); //Inserts "T", "r", "e", "e"
        System.out.println(minDistance("Cat", "Hat")); // Replace "C" with "C"
        System.out.println(minDistance("Dog", "Dsog")); //Insert "s"
        System.out.println(minDistance("Sunday", "Saturday")); //Replace "n" with "r", insert "t" & "a"
    }

    public static int minDistance(String word1, String word2) {
        /*
         * x = last character of word1, y = last character of word2
         * i = length of word1, length of word2
         *
         * if x == y, then dp[i][j] == dp[i-1][j-1] if x != y, and we insert y for
         * word1, then dp[i][j] = dp[i][j-1] + 1 if x != y, and we delete x for word1,
         * then dp[i][j] = dp[i-1][j] + 1 if x != y, and we replace x with y for word1,
         * then dp[i][j] = dp[i-1][j-1] + 1 When x!=y, dp[i][j] is the min of the three
         * situations.
         * 
         */


        // Length of the words
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // Fills dp[][]
        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);

                // If last two chars equal
                if (c1 == c2) {
                    // Update dp for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;
                    
                    // If replace > insert, set min to insert, else set min to replace
                    int min = replace > insert ? insert : replace;
                    // If delete > min, set min to min, else to delete
                    min = delete > min ? min : delete;

                    dp[i + 1][j + 1] = min; 
                }
            }
        }

        return dp[len1][len2];
    }
}