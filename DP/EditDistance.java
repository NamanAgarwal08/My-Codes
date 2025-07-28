// Given two strings str1 and str2, in how many minimum operations out of replace, delete and add string str1 can be converted to str2.
// replace -> replace the existing character with some other character.
// delete -> delete the existing character
// add -> add a new character to the string

public class EditDistance {
    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";

        System.out.println(editDistance(str1, str2));
    }
    
    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        //initialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }
        
        //bottomUp
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;

                    dp[i][j] = Math.min(add, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }
}
