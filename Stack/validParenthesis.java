import java.util.*;

public class validParenthesis {
    public static void main(String args[]) {
        Stack<Character> s = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(valid_Parenthesis(s, str));
    }

    public static boolean valid_Parenthesis(Stack<Character> s,String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                s.push(str.charAt(i));
            } else {
                if (s.isEmpty()) {
                    return false;
                } else if ((s.peek() == '(' && str.charAt(i) == ')') || (s.peek() == '{' && str.charAt(i) == '}')
                        || (s.peek() == '[' && str.charAt(i) == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }

        }
        if (s.isEmpty()) {
            return true;
        }else
        return false;
    }
}
