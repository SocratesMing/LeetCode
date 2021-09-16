package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeOrder {

    public static void preOrder(Node node) {
        if (node==null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);

    }

    public static void perOrder1(Node root) {
        //不使用递归的方式
        if (root==null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
//            System.out.print(stack);
            Node node = stack.pop();
            System.out.print(node.value);
            if (node.right!=null) stack.push(node.right);//右节点先入栈，右节点最后出栈
            if (node.left!=null) stack.push(node.left);//左节点后入栈，左节点最先出栈
        }
    }

    public static void midOrder(Node node) {
        if (node==null) return;
        midOrder(node.left);
        System.out.print(node.value);
        midOrder(node.right);

    }

    public static void midOrder1(Node root) {
        //有点问题
        if (root==null) return;
        Stack<Node> stack = new Stack<>();
        Node cur=root;
        while (!stack.isEmpty()||cur!=null ) {
            while (cur != null) { //添加最左节点
                stack.push(cur);
                cur = cur.left;
            }

            Node node = stack.pop();
            System.out.print(node.value);
            if (node.right!=null) stack.push(node.right);
        }
    }

    public static void postOrder(Node node) {
        if (node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);

    }

    public static void postOrder1(Node node) {
        if (node==null) return;

        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            stack2.push(pop);
            if (pop.left!=null) stack.push(pop.left);
            if (pop.right!=null) stack.push(pop.right);

        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value);
        }

    }

    public static void bsf(Node root) {
        //双端队列
        if (root==null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();//弹出第一个元素
            System.out.print(node.value);
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
        }

    }


    public static void main(String[] args) {
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

        System.out.println("前序遍历");
        preOrder(a);
        System.out.println();
        perOrder1(a);
        System.out.println();
        System.out.println("中序遍历");
        midOrder(a);
        System.out.println();
        midOrder1(a);
        System.out.println();
        System.out.println("后续遍历");
        postOrder(a);
        System.out.println();
        postOrder1(a);
        System.out.println();

        System.out.println("层序遍历");
        Queue<Node> queue = new LinkedList<>();
        bsf(a);

    }

}


class Node {
    public String value;
    public Node left;
    public Node right;

    public Node(String value) {
        this.value = value;
    }
}