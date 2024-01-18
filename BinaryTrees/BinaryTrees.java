import java.util.*;

public class BinaryTrees {

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

    static class BinaryTree {
        static int i = -1;

        public Node buildTree(int nodes[]) {

            i++;

            if (nodes[i] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[i]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorderTraverse(Node root) {

        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }

        System.out.print(root.data + " ");
        preorderTraverse(root.left);
        preorderTraverse(root.right);

    }

    public static void inorderTraverse(Node root) {

        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }

        inorderTraverse(root.left);
        System.out.print(root.data + " ");
        inorderTraverse(root.right);

    }

    public static void postorderTraverse(Node root) {
        
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }

        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.print(root.data + " ");

    }

    public static void levelOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int heightOfTree(Node root) { // this is with respect to nodes (for edges : -1 from final answer)

        if (root == null) {
            return 0;
        }

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        return Math.max(left, right) + 1;
    }
    
    //Number of nodes in a tree
    public static int numberOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int left = numberOfNodes(root.left);
        int right = numberOfNodes(root.right);

        return left + right + 1;
    }
    
    //Sum of values in nodes of tree
    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);

        return left + right + root.data;
    }

    //Diameter of a binary tree (with static var)
    static int count = 0;

    public static int diamater(Node root) {
        if (root == null) {
            return 0;
        }
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        count = Math.max(count, left + right + 1);
        return Math.max(left, right) + 1;
    }
    
    
    //Diameter of a binary tree without static var (O(n^2) approah)
    public static int dia(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHt = heightOfTree(root.left);
        int leftDia = dia(root.left);
        int rightHt = heightOfTree(root.right);
        int rightDia = dia(root.right);

        int selfDia = leftHt + rightHt + 1;

        return Math.max(selfDia, Math.max(leftDia, rightDia));
    }

    //Kth level of the Binary Tree
    public static void KthLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
            return;
        }
        KthLevel(root.left, level - 1);
        KthLevel(root.right, level - 1);
    }
    
    //Lowest Common Ancestor
    //    1
    //   / \
    //  2   3
    // / \   \
    //4   5   6
    // Lowest Common Ancestor of 4 and 5 is 2
    // Lowest Common Ancestor of 4 and 6 is 1
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, path1, n1);
        getPath(root, path2, n2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // lca -> (i-1)th place
        return path1.get(i - 1);

    }

    public static boolean getPath(Node root, ArrayList<Node> path, int n) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean leftPath = getPath(root.left, path, n);
        boolean rightPath = getPath(root.right, path, n);

        if (leftPath || rightPath) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
    
    //Second Approach for lca (to find the first node from bottom whose subtree contains both the elements)
    public static Node lca2(Node root, int n1, int n2) {

        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = lca2(root.left, n1, n2);
        Node right = lca2(root.right, n1, n2);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // if (left != null && right != null) {
        //     return root;
        // }
        return root; //(same as commented lines above)
    }
    
    //Minimum Ditance between two Nodes (Number of edges between them)
    public static int minDistance(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        
        int d1 = lcaDistance(lca, n1);
        int d2 = lcaDistance(lca, n2);

        return d1 + d2;

    }

    public static int lcaDistance(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int left = lcaDistance(root.left, n);
        int right = lcaDistance(root.right, n);

        if (left == -1 && right == -1) {
            return -1;
        }

        if (left != -1) {
            return left + 1;
        } else {
            return right + 1;
        }
    }
    
    //Kth Ancestor of the node
    public static int KthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int left = KthAncestor(root.left, n, k);
        int right = KthAncestor(root.right, n, k);

        if (left == -1 && right == -1) {
            return -1;
        }

        int max = Math.max(left, right);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;

    }
    
    //Transform of Sum Tree (Each node data = sum of left subtree and right subtree)
    public static int transformSumTree(Node root) {
        if (root == null) {
            return 0;
        }
        int left = transformSumTree(root.left);
        int right = transformSumTree(root.right);

        // int data = root.data;
        // root.data = left + right ;
        // return root.data + data;

        int data = root.data;

        int newLeft = root.left==null?0:root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        
        root.data = newLeft + left + newRight + right;
        return data;
    }
    

    public static void main(String args[]) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);

        System.out.println("preorderTraverse :");
        preorderTraverse(root);
        System.out.println();

        System.out.println("inorderTraverse :");
        inorderTraverse(root);
        System.out.println();

        System.out.println("postorderTraverse :");
        postorderTraverse(root);
        System.out.println();

        System.out.println("levelOrderTraverse :");
        levelOrderTraverse(root);
        System.out.println();

        System.out.println("Height :");
        System.out.println(heightOfTree(root));
        System.out.println();

        System.out.println("Number of Nodes :");
        System.out.println(numberOfNodes(root));
        System.out.println();

        System.out.println("Sum of Nodes :");
        System.out.println(sumOfNodes(root));
        System.out.println();

        System.out.println("Diameter (static var) :");
        diamater(root);
        System.out.println(count);
        System.out.println();

        System.out.println("Diameter (O(n^2)) :");
        System.out.println(dia(root));
        System.out.println();

        System.out.println("Kth Level :");
        KthLevel(root, 2);
        System.out.println();

        System.out.println("Lowest Common Ancestor :");
        System.out.println(lca(root, 4, 6).data);
        System.out.println();
        
        System.out.println("Lowest Common Ancestor (Approach 2) :");
        System.out.println(lca(root, 4, 5).data);
        System.out.println();
        
        System.out.println("Minimum Distance between the nodes :");
        System.out.println(minDistance(root, 4, 6));
        System.out.println();

        System.out.println("Kth Ancestor :");
        KthAncestor(root, 4, 1);
        System.out.println();

        System.out.println("Transform of Sum Tree");
        transformSumTree(root);
        levelOrderTraverse(root);
        System.out.println();
    }
    
}