package com.company;

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

        System.out.println("In Order Traversal");
        inOrderTraversal(eight);
        System.out.println();


        System.out.println("Post Order Traversal");
        postOrderTraveral(eight);
        System.out.println();

        System.out.println("Pre Order Traversal");
        preOrderTraveral(eight);

        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println();
        //printTree(buildMinimalTree(arr,0,arr.length-1));


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

    public static Node<Integer> buildMinimalTree(int[] nums, int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        Node<Integer> root = new Node<Integer>(nums[mid]);
        root.setLeftChild(buildMinimalTree(nums, start, mid-1));
        root.setRightChild(buildMinimalTree(nums,mid+1, end));
        return root;
    }

//    public static void printTree(Node<Integer> root){
//        System.out.println(root.getData());
//        printChildren(root.getLeftChild(), root.getRightChild());
//    }
//
//
//    public static void printChildren(Node left, Node right){
//        if(left != null) System.out.print(left.getData());
//        System.out.print("   ");
//        if(right !=null) System.out.print(right.getData());
//        System.out.println();
//        if(right != null && left != null) printChildren(left.getLeftChild(), left.getRightChild());
//        if(right != null && left != null) printChildren(right.getLeftChild(), right.getRightChild());
//    }


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


    }

}
