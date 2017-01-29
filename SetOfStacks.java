package com.company;

import java.util.*;

//Cracking the Coding Interview Question 3.3
public class SetOfStacks {
    private ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    private int capacity;
    private int currentPile = 0;


    public SetOfStacks(int capacity){
        this.capacity = capacity;
        this.stacks.add(new Stack<Integer>());
    }

    public void push(int num){
        if(stacks.get(currentPile).size() < capacity){
            stacks.get(currentPile).push(num);
        }
        else{
            currentPile++;
            stacks.add(new Stack<Integer>());
            stacks.get(currentPile).push(num);
        }
    }

    public int pop(){
        if(stacks.get(stacks.size()-1).size() == 0){
            stacks.remove(stacks.size()-1);
            currentPile--;
        }
        return stacks.get(currentPile).pop();
    }

    public int popAt(int pile){
        //System.out.println(stacks.get(pile-1).size());
        System.out.println(currentPile);
        if(stacks.get(pile-1) != null){
            int v = stacks.get(pile-1).pop();
            if(stacks.get(pile-1).empty()){
                stacks.remove(pile-1);
                currentPile--;
            }
            return v;
        }
        else{
            return -1;
        }
    }

    public java.lang.Object peek(){
        Stack pile = stacks.get(currentPile);
        return pile.peek();
    }

    public static void main(String[] args){
        SetOfStacks stacks = new SetOfStacks(5);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);
        stacks.push(8);
        System.out.println(stacks.peek());
        stacks.popAt(2);
        System.out.println(stacks.peek());
        stacks.popAt(2);
        stacks.popAt(2);
        stacks.popAt(2);
        System.out.println(stacks.peek());
        stacks.popAt(2);
        System.out.println(stacks.peek());
    }
}