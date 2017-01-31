package com.company;

import java.util.*;

public class SortStacks {

    public static Stack<Integer>  sortStack(Stack<Integer> stack){
        Stack<Integer> temp = new Stack<Integer>();
        temp.push(stack.pop());
        int current;
        while(!stack.empty()){
            current = stack.pop();
            if(current < temp.peek()){
                while(!temp.empty()){
                    stack.push(temp.pop());
                }
                temp.push(current);
            }
            else{
                temp.push(current);
            }
        }
        while(!temp.empty()){
            stack.push(temp.pop());
        }
        return stack;
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        Random random = new Random();

        for(int i = 0; i < 10; i++){
            stack.push(random.nextInt(10) + 1);
            System.out.print(stack.peek() + " ");
        }

       // System.out.println(stack.size());

        System.out.println();

        Stack<Integer> sortedStack = sortStack(stack);

//        System.out.println(sortedStack.size());
//        System.out.println(stack.size());

        while(!sortedStack.empty()){
            System.out.print(sortedStack.pop() + " ");
        }


    }

}
