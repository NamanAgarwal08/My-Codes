// variation of 0-1 KnapSack

// Ques : Given an array and an integer target, we have to check whether there is a subset of numbers present 
        // whose total equals target?



public class TargetSumSubset {
    public static void main(String[] args) {
        int numbers[] = { 4, 2, 7, 1,3 };
        int targetSum = 9;
        boolean dp[][] = new boolean[numbers.length + 1][targetSum + 1];
        for (int i = 0; i < dp.length; i++) { // when the given sum is 0 then no matter what the sie of numbers array is. We can always form 0 by not choosing any number from the array in the set.
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (numbers[i - 1] <= j) {
                    dp[i][j] = dp[i-1][j - numbers[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
        
    }
}