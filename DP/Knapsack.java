// Note : TargetSumSubset is another variation of 0-1 KnapSack 

import java.util.*;

public class Knapsack {
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        System.out.println(knapsack(val, wt, W, val.length));


        int n = wt.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(knapsack2(val, wt, W, n, dp));


        System.out.println(knapsack3(val, wt, W));

    }

    //0-1 Knapsack
    public static int knapsack(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            //include
            int inc = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1);

            //exclude
            int exc = knapsack(val, wt, W, n - 1);

            return Math.max(inc, exc);

        } else {
            return knapsack(val, wt, W, n - 1);
        }
    }

    //memorization
    public static int knapsack2(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        //valid
        if (wt[n - 1] <= W) {
            // include
            int inc = val[n - 1] + knapsack2(val, wt, W - wt[n - 1], n - 1, dp);

            // exclude
            int exc = knapsack2(val, wt, W, n - 1, dp);

            return dp[n][W] = Math.max(inc, exc);

        }
        //invalid
        else {
            return dp[n][W]=knapsack2(val, wt, W, n - 1,dp);
        }
    }

    //tabulation (iteration)
    public static int knapsack3(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = val[i - 1];
                int w = wt[j - 1];

                //valid
                if (w <= j) {
                    //include
                    int ans1 = v + dp[i - 1][j - w];

                    //exclude
                    int ans2 = dp[i - 1][j];

                    dp[i][j] = Math.max(ans1, ans2);
                }

                //invalid
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];

    }

}
