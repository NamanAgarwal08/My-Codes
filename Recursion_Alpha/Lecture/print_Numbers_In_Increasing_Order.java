// package Lecture;

public class print_Numbers_In_Increasing_Order {
    public static void main(String args[]) {
        int n = 10;
        //printNumbers(n, 1);
        printNumbers(n);
    }

    // public static void printNumbers(int n,int m) {
    //     if (m > n) {
    //         return;
    //     }
    //     System.out.println(m);
    //     printNumbers(n, m+1);
    // }

        public static void printNumbers(int n) {
        if (n < 1) {
            return;
        }
        printNumbers(n-1);
        System.out.println(n);
    }

}