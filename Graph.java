package com.company;

import java.util.*;

public class Graph {


    public static void main(String[] args){
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        zero.addEdge(one);
        zero.addEdge(two);
        one.addEdge(two);
        two.addEdge(zero);
        two.addEdge(three);
        three.addEdge(three);
        Node four = new Node(4);

        System.out.println(hasBFSPath(one, three));
        System.out.println(hasDFSPath(one, three));
    }

    public static class Node{
        private int data;
        LinkedList<Node> adjacent = new LinkedList<Node>();

        public Node(int data){
            this.data = data;
        }

        public void addEdge(Node destination){
            this.adjacent.add(destination);
        }
    }

    public static boolean hasDFSPath(Node source, Node destination){
        HashSet<Node> visited = new HashSet<Node>();
        return hasDFSPath(source, destination, visited);
    }

    private static boolean hasDFSPath(Node source, Node destination, HashSet<Node> visited){
        if(visited.contains(source)) return false;
        visited.add(source);
        if(source == destination) return true;
        for(Node child : source.adjacent) {
            if(hasDFSPath(child, destination, visited)){
                return true;
            }
        }
        return false;
    }

    public static boolean hasBFSPath(Node source, Node destination){
        LinkedList<Node> nextToVisit = new LinkedList<Node>();
        HashSet<Node> visited = new HashSet<Node>();
        nextToVisit.add(source);
        while(!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if (node == destination) {
                return true;
            }

            if(visited.contains(node)){
                continue;
            }
            visited.add(node);

            for (Node child : node.adjacent) {
                    nextToVisit.add(child);

            }
        }
        return false;
    }


}
