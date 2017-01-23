package com.company;

public class LinkedList {

    public static Node recursiveReverse(Node node){
       if(node.next == null){
           return node;
       }
       Node reversedList = recursiveReverse(node.next);
       //System.out.print(node.getData());
       //The last node points back to the previous node in the stack
       node.next.next = node;
       //Nullifies the forward pointers in the stack
       node.next = null;
       return reversedList;
    }

    public static Node reverse(Node head){
        Node nextNode = null;
        Node prev = null;
        Node curr = head;

        while(curr != null){
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
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
        }

        public int getData(){
            return this.data;
        }
    }

    public static void main(String[] args) {
	Node list = new Node(1);
	list.append(2);
	list.append(3);
	list.append(4);
	list.append(5);
	Node reversedList = reverse(list);
	reversedList.printList();
//	System.out.println();
//	list.printList();
//	Node recursiveReversedList = recursiveReverse(list);
//	System.out.println();
//	recursiveReversedList.printList();
//	System.out.println();
    }
}
