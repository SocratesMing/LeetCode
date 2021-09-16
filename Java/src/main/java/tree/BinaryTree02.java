package tree;

public class BinaryTree02 {

    private static Node root = GenerateTree.genTree();

    //求二叉树的最大深度
    public static int Maxdeep(Node root) {
        if (root == null) {
            return 0;
        }

        int left = Maxdeep(root.left);
        int right = Maxdeep(root.right);
        return 1+Math.max(left, right);
    }

    //求二叉树的最小深度
    public static int Mindeep(Node root) {
        if (root == null) {
            return 0;
        }

        int left = Maxdeep(root.left);
        int right = Maxdeep(root.right);
        return 1+Math.min(left, right);
    }

    public static void main(String[] args) {
        System.out.println(BinaryTree02.Maxdeep(root));
    }
}


class GenerateTree {

    public static Node genTree() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        return a;
    }
}