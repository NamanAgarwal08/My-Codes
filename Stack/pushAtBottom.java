import java.util.*;

public class pushAtBottom {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            s.push(i);
        }
        int element = sc.nextInt();
        push_AtBottom(s, element);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void push_AtBottom(Stack<Integer> s,int element) {
        if (s.isEmpty()) {
            s.push(element);
            return;
        }
        int top = s.pop();
        push_AtBottom(s, element);
        s.push(top);
    }
}
