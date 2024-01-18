import java.util.*;

public class reverseString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string you want to reverse : ");
        String str = sc.next();
        reverseStringStack(str); 
    }

    public static void reverseStringStack(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        String str1 = "";
        while (!s.isEmpty()) {
            str1 += s.pop();
            // s.pop();
        }
        System.out.println(str1);
    }
}
