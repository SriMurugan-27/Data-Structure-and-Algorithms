package algorithms;

import java.util.Stack;

public class SymmetricTree {

    public TreeNode root;
    public class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public void createTree(){
        TreeNode one = new TreeNode(1);
        TreeNode twoLeft = new TreeNode(2);
        TreeNode twoRight = new TreeNode(2);
        TreeNode threeLeft = new TreeNode(3);
        TreeNode threeRight = new TreeNode(3);
        TreeNode fourLeft = new TreeNode(4);
        TreeNode fourRight = new TreeNode(4);

        root = one;
        one.left = twoLeft;
        one.right = twoRight;
        twoLeft.left = threeLeft;
        twoLeft.right = fourRight;
        twoRight.left = fourLeft;
        twoRight.right = threeRight;
    }

    public static boolean isSymmetric(TreeNode root){
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()){
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }

        return true;
    }

    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
        st.createTree();

        System.out.println(isSymmetric(st.root));
    }
}
