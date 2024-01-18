// package Lecture;

public class print_Numbers_In_Decreasing_Order {
    public static void main(String args[]) {
        int n = 10;
        printNumbers(n);
    }
    
    public static void printNumbers(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNumbers(n-1);
    }
}
