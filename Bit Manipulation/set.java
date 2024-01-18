import java.util.*;

public class set {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int num = sc.nextInt();
        System.out.println("Enter bit number you want to set :");
        int bitNum = sc.nextInt();
        bitNum =1<<bitNum;
        System.out.println(num | bitNum);

    }
}
