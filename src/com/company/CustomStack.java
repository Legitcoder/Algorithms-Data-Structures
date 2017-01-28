package com.company;


public class CustomStack {

    private int[] stackArray;

    private int top = 0;

    private int stackSize;

    public CustomStack(int stackSize){
        this.stackSize = stackSize;
        this.stackArray = new int[stackSize];
        this.top = 0;
    }

    public int peek(){
        if(top > 0) {
            return this.stackArray[top - 1];
        }
        return -1;
    }

    public void push(int num){
        if(top < stackSize){
            stackArray[top] = num;
            top++;
        }
        else{
            System.out.println("CustomStack Overflow");
        }
    }

    public int pop(){
        int topNum = stackArray[top];
        stackArray[top] = -1;
        top--;
        return topNum;
    }

    public static void main(String[] args){
        CustomStack stack = new CustomStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}



