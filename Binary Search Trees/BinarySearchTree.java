import java.util.*;

public class BinarySearchTree {
    
    //Time Complexity of BinarySearhTree == O(h) [h->height of tree]

    // a. LeftSubtree Nodes < Root
    // b. RightSubtree Nodes > Root
    // c. Left and Right Subtrees are also BST with no Duplicates

    // The inorder traversal gives the sorted sequence of integers in that tree

    // In a Balanced BST : height -> log(N)
    // In worst condition(Skew Tree) : height -> N

    // Skew Tree: 
    //  1 
    //   \
    //    2
    //     \
    //      3

    // Strategy:
    // In most of the problems we will be using recursion 
    // where we will be dividing the problem into subproblem 
    // and making recursive calls on the subtrees.

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

    //Build a Binary Search Tree;
    public static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (root.data > value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    //inorder traversal of the tree
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //Search in a BST
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }
    
    public static Node delete(Node root, int val) {

        if (root.data > val) {
            root.left = delete(root.left, val);
        }

        else if (root.data < val) {
            root.right = delete(root.right, val);
        }

        else { //voila (there it is)

            // case 1 == leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2 == single child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            //case 3 == has both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }
    
    //Inorder Successor : (it is the node which comes just after a node in inorder sequence of which 
    // we have to find the inorder successor)
    // For eg : in the stream 1 2 3 4 5 , the inorder successor of node 3 is 4
    
    // Note : the inorder successor of the node is the left most node in the right subtree of that node.

    public static Node findInorderSuccessor(Node root) {
        if (root.left == null) {
            return root;
        }
        return findInorderSuccessor(root.left);
    }

    //Validate the BST
    // --> Approach 1 : (max value in left subtree < root) and (min value in right subtree > root)
    // --> Approach 2 : fnd inorder traversal of the BST and check if it is in sorted order or not.
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        if (root.data < k1) {
            printInRange(root.right, k1, k2);
        }
        if (root.data > k2) {
            printInRange(root.left, k1, k2);
        }
    }

    public static void rootToLeafPath(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        rootToLeafPath(root.left, path);
        rootToLeafPath(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static Node mirrorBST(Node root) {
        if (root == null) {
            return null;
        }
        Node left = mirrorBST(root.left);
        Node right = mirrorBST(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static Node treefromSortedArray(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = treefromSortedArray(arr, start, mid - 1);
        root.right = treefromSortedArray(arr, mid + 1, end);
        return root;
    }
    
    public static Node balancedBST(Node root) {
        //inorder sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        //sorted inorder -> balanced BST
        return BSTfromInorder(inorder, 0, inorder.size() - 1);
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node BSTfromInorder(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = BSTfromInorder(inorder, start, mid - 1);
        root.right = BSTfromInorder(inorder, mid + 1, end);
        return root;
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

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;
        int sum;

        public Info(boolean isBST, int size, int min, int max, int sum) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public static int maxSize = 0;
    public static int maxSum = 0;

    public static Info largestBSTinBT(Node root){
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Info left = largestBSTinBT(root.left);
        Info right = largestBSTinBT(root.right);
        int size = left.size + right.size + 1;
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));
        int sum = left.sum + right.sum + root.data;
        if (root.data <= left.max || root.data >= right.min) {
            return new Info(false, size, min, max, sum);
        }
        if (left.isBST && right.isBST) {
            maxSize = Math.max(size, maxSize);
            maxSum = Math.max(maxSum, sum);
            return new Info(true, size, min, max, sum);
        }
        return new Info(false, size, min, max, sum);
    }




    public static void main(String args[]) {
        int values[] = { 8,5,3,6,10,11,14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        
        // System.out.println(root.data);
        // inorder(root);
        // System.out.println();

        // System.out.println(search(root,7));
        
        // root = delete(root, 5);
        // inorder(root);

        // printInRange(root, 5, 14);

        // rootToLeafPath(root, new ArrayList<Integer>());

        // mirrorBST(root);
        // levelOrderTraverse(root);

        // int arr[] = { 3, 5, 6, 8, 10, 11, 12};
        // levelOrderTraverse(treefromSortedArray(arr, 0, arr.length - 1));

        // Node root1 = new Node (8);
        // root1. left = new Node (6);
        // root1. left.left = new Node (5);
        // root1.left.left.left = new Node(3);
        // root1.right = new Node (10);
        // root1.right.right = new Node (11);
        // root1.right.right.right = new Node(12);
            //         8
            //        / \
            //       6  10
            //     /      \
            //    5        11
            //   /          \
            //  3            12
            //   GIVEN BST
            
            //convert to balanced height (first find inorder then make balanced heoght BST)

            //       8
            //    /    \
            //   5     11
            //  / \   / \
            // 3   6 10  12
            //  EXPECTED BST

            // root1 = balancedBST(root1);
            // levelOrderTraverse(root1);


                    //         50
                    //       /     \
                    //     30      60
                    //    /  \    /  \
                    //   5    20 45   70
                    //               /  \
                    //             65    80
                    // Given BST
            Node root2 = new Node (50);
            root2. left = new Node (30) ;
            root2.left.left = new Node (5);
            root2.left.right = new Node(20);
            root2.right = new Node (60) ;
            root2.right.left = new Node (45);
            root2.right.right = new Node (70) ;
            root2.right.right.left = new Node (65) ;
            root2.right.right.right = new Node(80);
            largestBSTinBT(root2);
            System.out.println(maxSize);
            System.out.println(maxSum);


    }
}