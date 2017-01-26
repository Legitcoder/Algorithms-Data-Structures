package com.company;

import java.util.*;
import java.util.concurrent.RecursiveAction;

public class LinkedList {

    public static Node recursiveReverse(Node node){
       if(node.next == null){
           return node;
       }
       Node reversedList = recursiveReverse(node.next);
       //The last node points back to the previous node in the stack
       node.next.next = node;
       //Nullifies the forward pointers in the stack
       node.next = null;
       return reversedList;
    }


    //Given an unsorted linked list, remove the duplicates
    public static Node remove_duplicates(Node head){
        if(head == null || head.next == null){
            return null;
        }

        HashSet<Integer> nodes = new HashSet<Integer>();

        Node previous = null;

        while(head != null){
            if(nodes.contains(head.data)){
                //skip the node that contains the duplicate
                previous.next = head.next;
            }
            else{
                nodes.add(head.data);
                previous = head;
            }
            head = head.next;
        }

        return previous;
    }

    public static Node partition(Node head, int n){
        Node left = new Node(0);
        Node right = new Node(0);
        Node rightHead = right;
        Node leftHead = left;

        while(head != null){
            if(head.data < n){
                left.next = head;
                left = left.next;
            }
            else{
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightHead.next;
        return leftHead.next;
        }

    //Find the kth to the last element in a singly linked list
    public static int getKthfromLastNode(Node head, int k){
        if(head == null){
            return -1;
        }
        int length = head.length();

        if(k > length || k < 0 ){
            System.out.println("Out of Range");
            return -1;
        }

        int position = length - k;
        while(position > 0){
            head = head.next;
            position--;
        }
        return head.data;
    }


    //Cracking the Coding Interview Solution
    public static int printKthToLast(Node head, int k){
        if(head == null){
            return 0;
        }
        int index = printKthToLast(head.next, k) +1;
        if(index == k){
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }


    //Given an sorted linked list, remove the duplicates
    public static Node remove_sorted_duplicates(Node head){
        if(head.next == null || head == null) return null;

        Node prev = head;
        head = head.next;


        while(head !=  null){
            if(prev.data == head.data){
                prev.next = head.next;
            }
            prev = head;
            head = head.next;
        }
        return prev;
    }

    public static Node reverse(Node head){
        Node nextNode = null;
        Node prev = null;
        Node curr = head;

        while(curr != null){
            //Temp pointer to the next node
            //Necessary because current link to the next node will be altered
            nextNode = curr.next;
            //Breaks forward link and redirects to point to the previous node
            curr.next = prev;
            //Previous points to the next node in the linked list
            prev = curr;
            //Current points to the nextNode
            //Equivalent to curr = curr.next, but since curr.next was altered we use nextNode
            curr = nextNode;
        }
        return prev;
    }

//    public static boolean isPalindrome(Node head){
//        Node headPtr = head;
//        Node reversedList = reverse(head);
//        head.printList();
//        reversedList.printList();
//        while(head!= null && reversedList !=null){
//            if(head.data != reversedList.data){
//                //System.out.println(head.data);
//                //System.out.println(reversedList.data);
//                break;
//            }
//            head = head.next;
//            reversedList = reversedList.next;
//        }
//        if(head == null && reversedList == null){
//            return true;
//        }
//        return false;
//    }

    public static boolean isPalindrome(Node head){
        Node headPtr = head;
        Stack<Integer> nodes = new Stack<>();
        while(head != null){
            nodes.push(head.data);
            head = head.next;
        }
        while(headPtr != null){
            if(headPtr.data != nodes.peek()){
                return false;
            }
            headPtr = headPtr.next;
            nodes.pop();
        }
        return true;
    }


    public static class Node{

        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

        public Node pop(){
            Node node = this;
            Node previous = node;
            node = node.next;

            while(node.next != null){
                node = node.next;
                previous = previous.next;
            }
            previous.next = null;
            return previous;
        }

        public void deleteMiddleNode(){
            Node head = this;
            int length = (head.length()/2);
            if(head.length() % 2 == 0){
                length--;
            }
            System.out.println(length);
            Node prev = head;
            head = head.next;
            length--;
            System.out.println(length);

            while(prev != null){
                if(length == 0){
                    prev.next = head.next;
                    break;
                }
                prev = prev.next;
                head = head.next;
                length--;
            }

        }

        public Node insert( int data, int position){
            Node newNode = new Node(data);
            Node currentObject = this;
            if(position > currentObject.length() || position <= 0){
                System.out.println("Invalid position");
                return currentObject;
            }
            //Edge case isn't working for some reason
            if(position == 1){
                newNode.next = currentObject;
                return newNode;
            }
            else {
                int count = 1;
                Node previous = null;

                while (currentObject != null) {
                    if (count == position) {
                        previous.next = newNode;
                        newNode.next = currentObject;
                    }
                    previous = currentObject;
                    currentObject = currentObject.next;
                    count++;
                }
                return previous;
            }

        }

        public Node delete(int data){
            Node currentObject = this;
            Node previous = new Node(currentObject.data);
            currentObject = currentObject.next;

            if(currentObject.length() == 1 && currentObject.data == data){
                return null;
            }
            //Edge case isn't working for some reason
            if(previous.data == data){
                return currentObject;
            }

            while(currentObject != null){
                if(currentObject.data == data){
                    previous.next = currentObject.next;
                }
                previous = currentObject;
                currentObject = currentObject.next;
            }
            return previous;
        }

        public int length(){
            int count = 0;
            Node list = this;
            while(list != null){
                list = list.next;
                count++;
            }
            return count;
        }

        public Node append(int data){
            Node temp = new Node(data);
            Node currentObj = this;
            while(currentObj.next != null){
                currentObj = currentObj.next;
            }
            currentObj.next = temp;
            return temp;
        }


        public void printList(){
            Node list = this;
            while(list != null){
                System.out.print(list.data);
                if(list.next != null) {
                    System.out.print("->");
                }
                list = list.next;
            }
            System.out.println();
        }

        public int getData(){
            return this.data;
        }
    }

    public static void main(String[] args) {
        //Driver Code
	Node list = new Node(1);
	list.append(2);
	list.append(1);
	list.append(9000);
	list.append(3);
	list.append(4);
	list.append(5);
	list.insert(9999, 3);
	list.delete(9999);
	list.append(5);
	list.append(7);
	list.append(1);
	list.append(3);
	list.append(6);
	list.append(6);
	list.append(8);
	list.append(9);
	list.append(10);
	list.append(11);
	list.append(12);
//	remove_duplicates(list);
//	list.printList();
	Node sortedList = new Node(2);
    sortedList.append(2);
	sortedList.append(3);
	sortedList.append(3);
	sortedList.append(4);
	sortedList.append(4);
	sortedList.append(5);
	sortedList.append(5);
	Node palindromeList = new Node(1);
	palindromeList.append(2);
	palindromeList.append(3);
	palindromeList.append(4);
	palindromeList.append(5);
	palindromeList.append(5);
	palindromeList.append(4);
	palindromeList.append(3);
	palindromeList.append(2);
	palindromeList.append(1);
	//palindromeList.printList();
	boolean checkPalindrome = isPalindrome(palindromeList);
	System.out.println(checkPalindrome);


	//remove_duplicates(sortedList);
//	remove_sorted_duplicates(sortedList);
//	sortedList.printList();
//	int secondToLast = getKthfromLastNode(list, 2);
//	System.out.println(secondToLast);
//	int thirdToLast = printKthToLast(list, 2);
//	list.deleteMiddleNode();
//	list.printList();
	//Node partitionedList = partition(list, 7);
	//partitionedList.printList();
        Node reversedList = reverse(list);
     reversedList.printList();
    }
}
