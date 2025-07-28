//Given a text and a wildcard pattern, implement wildcard pattern matching algorithm which finds if wildcard pattern matches with text.
//The matching shiuyld coiver the entire text (not partial text).
//The wildcard pattern can include the characters '?' and '*' :
//      '?' matches any single character
//      '*' matches any sequence of characters (including empty sequence)

public class StringMatching {
    public static void main(String[] args) {
        String str = "baaabab";
        String pattern = "*****ba*****ab";
        System.out.println(isMatch(str, pattern));
    }

    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n + 1][m + 1];

        dp[0][0] = true; // empty string always matches with empty text

        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = (dp[i][j - 1] || dp[i - 1][j]);
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];

    }
}