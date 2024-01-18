import java.util.*;

public class duplicateParenthesis {
    public static void main(String args[]) {
        String str = "(a)(a)((a))";
        System.out.println(isDuplicate(str));
    }
    
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ')') {
                s.push(str.charAt(i));
            } else {
                int count = 0;
                while (s.peek() != '(') {
                    count++;
                    s.pop();
                }
                if (count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            }
        }
        return false; 
    }
}
