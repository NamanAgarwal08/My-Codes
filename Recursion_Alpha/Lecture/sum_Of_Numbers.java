// package Lecture;

public class sum_Of_Numbers {
    public static int sum(int n) {
        if (n < 1) {
            return 0;
        }
        int s = n + sum(n - 1);
        return s;
    }
    
    public static void main(String args[]) {
        int n = 4;
        System.out.println(sum(n));
    }
}
