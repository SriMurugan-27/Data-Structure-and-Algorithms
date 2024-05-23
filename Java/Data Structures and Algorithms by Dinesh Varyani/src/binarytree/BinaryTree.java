package binarytree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private TreeNode root;
    private class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value){
            this.val = value;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree(){
        this.root = null;
    }

    public void createBinaryTree(){
        TreeNode nine = new TreeNode(9);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        root = nine;
        nine.left = two;
        nine.right = three;
        two.left = four;
    }

    public void levelOrder(){
        levelOrder(root);
    }

    private void levelOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            System.out.print(temp.val + " ");
            if(temp.left != null){
                q.offer(temp.left);
            }
            if(temp.right != null){
                q.offer(temp.right);
            }
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.val +" ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    public void preOrderRec(){
        preOrderRec(root);
    }

    private void preOrderRec(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                System.out.print(current.val + " ");
                current = current.right;
            }
        }
    }

    public void inOrderRec(){
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode root){
        if(root == null){
            return;
        }

        inOrderRec(root.left);
        System.out.print(root.val + " ");
        inOrderRec(root.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.val + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.val + " ");
                    }
                }else{
                    current = temp;
                }
            }
        }
    }

    public void postOrderRec(){
        postOrderRec(root);
    }

    private void postOrderRec(TreeNode root){
        if(root == null){
            return;
        }

        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(root.val + " ");
    }

    public int findMax(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int result = root.val;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if(right > result){
            result = right;
        }

        if(left > result){
            result = left;
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.levelOrder();
        System.out.println();

        bt.preOrder();
        System.out.println();
        bt.preOrderRec();
        System.out.println();

        bt.inOrder();
        System.out.println();
        bt.inOrderRec();
        System.out.println();

        bt.postOrder();
        System.out.println();
        bt.postOrderRec();
        System.out.println();

        System.out.println(bt.findMax(bt.root));
    }


}
