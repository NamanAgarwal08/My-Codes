// Mountains and Valleys
// Given the pairs of upstrokes(/) and downstrokes(\). Count the number of ways we can form mountains and valeys in different ways by using these pairs.
// Note that at any point, the number of down strokes can't be more than number of up strokes.

// for n =0 , ways = 1 (No range)
// for n =1 , ways = 1 (1 range)

// for 3 pairs of /\ :

// 1. /\/\/\

// 2.  /\
//    /  \/\

// 3.   /\
//   /\/  \

// 4.    /\
//      /  \
//     /    \

// 5. /\/\
//   /    \

// Note : /\/\
//            \
//     this can't be formed as at this point while forming th ranges, number of down strokes are larger than number of up strokes.


// Variation of catalan's number:

// Approach : first consider a mountain range with one pair as given (/\) now calculate remaining combinations as different number of pairs considering inside this given pair and outside this pair.
//  For Eg : n ==4 : so consider /\ as given and remaining combinations will be /0\3 + /1\2 + /2\1 + /3\0 where a number denotes the number of pairs we are considering inside or outside the given mountain.

public class MountainRanges {
    public static void main(String[] args) {
        int n = 3;
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
