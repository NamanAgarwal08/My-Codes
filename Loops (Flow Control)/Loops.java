import java.util.*;

public class Loops {
    public static void main(String args[]) {
        // 2. Sum of even and odd numbers.

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the number of integers you want to enter : ");
        // int x = sc.nextInt();
        // int oddSum=0;
        // int evenSum=0;
        // int y;
        // for (int i = 0; i < x; i++) {
        //     System.out.print("Enter the number : ");
        //     y = sc.nextInt();
        //     if (y % 2 == 0) {
        //         evenSum += y;
        //     } else {
        //         oddSum += y;
        //     }
        // }
        // System.out.println("Even sum = " + evenSum);
        // System.out.println("Odd Sum = " + oddSum);

        
        
        // 3. Factorial of a number entered by the user.

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter any number for its factorial : ");
        // int n = sc.nextInt();
        // int fact = 1;
        // for (n=n ; n > 0 ; n--){
        //     fact*=n;
        // }
        // System.out.println("Factorial of the number is " + fact);

        
        
        // 4. Multiplication table.

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter any number for its table : ");
        // int n = sc.nextInt();
        // for (int i = 1; i <= 10; i++) {
        //     System.out.println(n + " x " + i + " = " + (n*i));
        // }

    
        
        // 5. Scope of variable.
        // for (int i = 0; i <= 5; i++) {
        //     System.out.println("Value of i : " + i);
        // }
        // //System.out.println("Value after the loop : " + i); // Cannot find symbol i (Scope of variable is limitd to inside foor loop only)

        int i;                                              //|  This is the    
        for (i = 0; i <= 5; i++) {                          //|  right code
            System.out.println("Value of i : " + i);        //|  for using 'i'
        }                                                   //|  outside the
        System.out.println("Value after the loop : " + i);  //|  loop.
    }
    
}
