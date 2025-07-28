//LeetCode - 96 : Unique Binary Search Trees (Catalan's Number form)

// for n =0 : BST=1 (null node)
// for n =1 : BST=1 (current node)
// .
// .
// .
// for n=n :
public class CountingTrees {
    public static void main(String[] args) {
        int n = 30;
        // recursion
        // System.out.println(recursion(n));

        // memorization
        System.out.println(memo(n, new long[n + 1]));

        // tabulation
        System.out.println(tabulation(n));
    }

    // recursion
    public static int recursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += recursion(i) * recursion(n - 1 - i);
        }

        return ans;
    }

    // memorization
    public static long memo(int n, long dp[]) {
        if (n == 0 || n == 1) {
            return dp[n] = 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += memo(i, dp) * memo(n - 1 - i, dp);
        }

        return dp[n] = ans;
    }

    // tabulation
    public static long tabulation(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long dp[] = new long[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

}
