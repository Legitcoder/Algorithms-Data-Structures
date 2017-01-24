package com.company;

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

    public static Node reverse(Node head){
        Node nextNode = null;
        Node prev = null;
        Node curr = head;

        while(curr != null){
            //Temp pointer to the next node
            //Necessary because currents link to the next node will be altered
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
	list.insert(9999, 3);
	list.delete(9999);
	//list = list.delete(9999);
	//System.out.println(list.length());
	list.printList();
	System.out.println();
//	Node reversedList = reverse(list);
//	reversedList.printList();
    }
}
