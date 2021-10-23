package tree;

public class BalanceTree {
    public  boolean solution(TreeNode node) {
        if (node == null) {
            return false;
        }else {
            return Math.abs(height(node.left) - height(node.right)) <= 1 &&
                    (solution(node.left) && solution(node.right));
        }
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }else {
            return  Math.max(height(node.left),height(node.right))+1;
        }
    }

}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}