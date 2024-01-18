import java.util.*;

// Get ith bit of the number -

public class get {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number");
        int num = sc.nextInt();
        System.out.println("Enter the bit number");
        int b = sc.nextInt();
        num >>= b;
        System.out.println();
        System.out.println(b+"th bit is : "+(num & 1));
    }
}
