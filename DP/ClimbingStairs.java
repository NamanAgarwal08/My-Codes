// Count ways to reach the nth start. A person can climb either 1 or 2 stairs at a time.

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;

        // recursion
        System.out.println(countWays(n));

        // memorization
        int ways[] = new int[n + 1];
        System.out.println(countWays2(n, ways));

        // tabulation
        System.out.println(countWays3(n));

    }
    
    // recursion
    public static int countWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    // memorization
    public static int countWays2(int n, int ways[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (ways[n] != 0) {
            return ways[n];
        }
        return ways[n] = countWays2(n-1,ways) + countWays2(n - 2,ways);
    }

    //tabulation
    public static int countWays3(int n) {
        if (n < 0) {
            return 0;
        }
        int ways[] = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }

}
