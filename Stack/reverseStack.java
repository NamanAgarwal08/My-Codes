import java.util.*;

public class reverseStack {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= 3; i++) {
            s.push(i);
        }
        System.out.println("Original Stack : ");
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        for (int i = 1; i <= 3; i++) {
            s.push(i);
        }
        System.out.println();
        reverseeStack(s);
        System.out.println("After reversing : ");
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
    
    public static void reverseeStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseeStack(s);
        push_AtBottom(s, top);
        
    }
    
    public static void push_AtBottom(Stack<Integer> s, int element) {
        if (s.isEmpty()) {
            s.push(element);
            return;
        }
        int top = s.pop();
        push_AtBottom(s, element);
        s.push(top);
    }
}
