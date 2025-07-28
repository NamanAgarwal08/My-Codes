//SubProblem of Edit Distance:
// Convert String1 to String2 with only insertion and deletion operations.
//Print number of insertions and deletions.


public class StringConversion {
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aceg";
        
        // System.out.println(conversion(str1, str2));
        conversion2(str1, str2);

    }
    
    //Method One
    public static int conversion(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int del = dp[i - 1][j] + 1;
                    int ins = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(del, ins);
                }
            }
        }
        return (dp[n][m]);
    }


    //LCS Method
    public static void conversion2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int cond1 = dp[i - 1][j];
                    int cond2 = dp[i][j - 1];
                    dp[i][j] = Math.max(cond1, cond2);
                }
            }
        }
        
        int lcs = dp[n][m];
        System.out.println("Deletions : "+(n-lcs));
        System.out.println("Insertions : " + (m - lcs));
    }
}
