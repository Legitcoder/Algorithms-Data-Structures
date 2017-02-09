package com.company;
import java.util.*;

public class BinaryTree {

    public static void main(String[] args){
        Node<Integer> eight = new Node<Integer>(8);
        Node<Integer> three = new Node<Integer>(3);
        Node<Integer> ten = new Node<Integer>(10);
        Node<Integer> one = new Node<Integer>(1);
        Node<Integer> six = new Node<Integer>(6);
        Node<Integer> four = new Node<Integer>(4);
        Node<Integer> seven = new Node<Integer>(7);
        Node<Integer> fourteen = new Node<Integer>(14);
        Node<Integer> thirteen = new Node<Integer>(13);

        eight.setLeftChild(three);
        eight.setRightChild(ten);
        three.setLeftChild(one);
        three.setRightChild(six);
        six.setLeftChild(four);
        six.setRightChild(seven);
        ten.setRightChild(fourteen);
        fourteen.setLeftChild(thirteen);
//
//        System.out.println("In Order Traversal");
//        inOrderTraversal(eight);
//        System.out.println();
//
//
//        System.out.println("Post Order Traversal");
//        postOrderTraveral(eight);
//        System.out.println();
//
//        System.out.println("Pre Order Traversal");
//        preOrderTraveral(eight);

        //System.out.println(leastCommonAncestor(eight, fourteen, thirteen).getData());
//        int[] nums = {1,2,3,4,5,6,7,8};
//        Node<Integer> root = buildMinimalTree(nums, 0, nums.length-1);
//        System.out.println(root.getLeftChild().getRightChild().getData());
        ArrayList<LinkedList<Node>> bTreeList = treeList(eight);
        for(LinkedList<Node> node : bTreeList){
            System.out.println(node.peek().data);
        }

    }

    public static void inOrderTraversal(Node<Integer> node){
        if(node != null){
            inOrderTraversal(node.getLeftChild());
            visit(node);
            inOrderTraversal(node.getRightChild());
        }
    }

    public static void postOrderTraveral(Node<Integer> node){
        if(node != null){
            postOrderTraveral(node.getLeftChild());
            postOrderTraveral(node.getRightChild());
            visit(node);
        }
    }

    public static void preOrderTraveral(Node<Integer> node){
        if(node != null){
            visit(node);
            preOrderTraveral(node.getLeftChild());
            preOrderTraveral(node.getRightChild());
        }
    }

    public static ArrayList<LinkedList<Node>> treeList(Node<Integer> root){
        if(root == null) return null;
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        return treeList(root, lists, 0 );
    }

    public static ArrayList<LinkedList<Node>> treeList(Node<Integer> root, ArrayList<LinkedList<Node>> lists, int level){
        if(root == null) return lists;
        LinkedList<Node> list = null;
        if(lists.size() == level){
            list = new LinkedList<Node>();
            list.add(root);
            lists.add(list);
        }
        else{
            list = lists.get(level);
            list.add(root);
        }
        treeList(root.getLeftChild(), lists, level+1);
        treeList(root.getRightChild(), lists, level+1);
        return lists;
    }

    public static Node<Integer> leastCommonAncestor(Node<Integer> root, Node<Integer> a, Node<Integer> b){
        if(root == null) return null;
        if(root ==  a || root == b) return root;
        Node<Integer> rightLCA = leastCommonAncestor(root.getRightChild(), a, b);
        Node<Integer> leftLCA = leastCommonAncestor(root.getLeftChild(), a, b);
        if(rightLCA != null && leftLCA != null) return root;
        if(rightLCA !=null) return rightLCA;
        return leftLCA;
    }

//    public static boolean validateBST(Node<Integer> root){
//
//    }

    public static Node<Integer> buildMinimalTree(int[] nums, int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        Node<Integer> root = new Node<Integer>(nums[mid]);
        root.setLeftChild(buildMinimalTree(nums, start, mid-1));
        root.setRightChild(buildMinimalTree(nums,mid+1, end));
        return root;
    }




    public static void visit(Node node) {
        System.out.print(node.getData() + "->");
    }

    public static class Node<T> {
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T data){
            this.data = data;
        }

        public T getData(){
            return data;
        }

        public Node<T> getLeftChild(){
            return leftChild;
        }

        public Node<T> getRightChild(){
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild){
            this.rightChild = rightChild;
        }

        public void setLeftChild(Node<T> leftChild){
            this.leftChild = leftChild;
        }

        public int height(Node root){
            if (root==null) return 0;
            return 1 + Math.max(height(root.getLeftChild()),height(root.getRightChild()));
        }


        public void levelOrderQueue(Node root){
            Queue q = new LinkedList();
            int levelNodes =0;
            if(root==null) return;
            q.add(root);
            while(!q.isEmpty()){
                levelNodes = q.size();
                while(levelNodes>0){
                    Node n = (Node)q.remove();
                    System.out.print(" " + n.data);
                    if(n.getLeftChild()!=null) q.add(n.getLeftChild());
                    if(n.getRightChild()!=null) q.add(n.getRightChild());
                    levelNodes--;
                }
                System.out.println("");
            }
        }

}
}
