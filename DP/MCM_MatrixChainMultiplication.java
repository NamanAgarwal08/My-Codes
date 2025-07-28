import java.util.*;

public class MCM_MatrixChainMultiplication {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;
        System.out.println(mcm(arr, 1, n - 1));

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(mcm2(arr, 1, n - 1, dp));
    }
    
    //recursion
    public static int mcm(int arr[], int i, int j) {
        if (i == j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE; 
        for (int k = i; k < j; k++) {
            int cost1 = mcm(arr, i, k); // Ai.Ai+1.Ai+2.....Ak ==> arr[i-1]Xarr[k]
            int cost2 = mcm(arr, k + 1, j);// Ak+1.Ak+2....Aj ==> arr[k]Xarr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int cost = cost1 + cost2 + cost3;
            ans = Math.min(ans, cost);
        }
        return ans;
    }

    //memorization
    public static int mcm2(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return dp[i][j] = 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1 = mcm2(arr, i, k, dp); // Ai.Ai+1.Ai+2.....Ak ==> arr[i-1]Xarr[k]
            int cost2 = mcm2(arr, k + 1, j, dp);// Ak+1.Ak+2....Aj ==> arr[k]Xarr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int cost = cost1 + cost2 + cost3;
            ans = Math.min(ans, cost);
        }
        return dp[i][j] = ans;
    }
    
}