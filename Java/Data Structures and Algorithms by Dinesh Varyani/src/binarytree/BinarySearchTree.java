package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    private TreeNode root;
    private int length;

    public class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value){
            this.val = value;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTree(){
        this.length = 0;
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public TreeNode insert(TreeNode root, int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }

        if(root.val > value){
            root.left = insert(root.left, value);
        }else{
            root.right = insert(root.right, value);
        }

        return root;
    }

    public void levelOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode current = q.poll();
            System.out.print(current.val + " ");
            if(current.left != null){
                q.offer(current.left);
            }
            if(current.right != null){
                q.offer(current.right);
            }
        }
    }

    public TreeNode search(int value){
        return search(root, value);
    }

    private TreeNode search(TreeNode root, int value){
        if(root == null || root.val == value){
            return root;
        }

        if(root.val < value){
            return search(root.right, value);
        }else{
            return search(root.left, value);
        }
    }

    public boolean isValid(){
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }

        if(root.val <= min || root.val >= max){
            return false;
        }

        boolean left = isValid(root.left, min, root.val);
        if(left){
            boolean right = isValid(root.right, root.val, max);
            return right;
        }

        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.insert(bst.root, 6);
        bst.insert(bst.root, 4);
        bst.insert(bst.root, 8);
        bst.insert(bst.root, 2);
        bst.insert(bst.root, 5);
        bst.insert(bst.root, 7);
        bst.insert(bst.root, 9);

        bst.levelOrder(bst.root);

        System.out.println(bst.search(8).val);
        try{
            System.out.println(bst.search(11).val);
        }catch (Exception x){
            System.out.println("not found!");
        }

        if(bst.isValid()){
            System.out.println("It's a Valid Tree!!");
        }else{
            System.out.println("No, It's not a Valid!!!");
        }
    }

}
