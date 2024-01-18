import java.util.*;

public class topView {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        int hd;
        Node node;

        Info(int hd,Node node){
            this.hd=hd;
            this.node=node;
        }

    }

    public static void printTopview(Node root) {

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min=0, max=0;
        q.add(new Info(0, root));
        q.add(null);

        while (!q.isEmpty()) {
            Info currInfo = q.remove();
            if (currInfo == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(currInfo. hd)) {
                    map.put(currInfo.hd, currInfo.node);
                }
                if (currInfo.node.left != null) {
                    q.add(new Info(currInfo.hd - 1, currInfo.node.left));
                    min = Math.min(min, currInfo.hd - 1);
                }
                if (currInfo.node.right != null) {
                    q.add(new Info(currInfo.hd + 1, currInfo.node.right));
                    max = Math.max(max, currInfo.hd + 1);
                }
            }
        }
        
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }
    
    public static void main(String args[]) {
    
        //      1
        //    /  \
        //   2    3
        //  / \  / \
        // 4  5 6   7
    
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    
        printTopview(root);
    
    }
}