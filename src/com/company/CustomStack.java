package com.company;


public class CustomStack {

    private int[] stackArray;

    private int top = 0;

    private int minElement;

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
        if(empty()){
            minElement = num;
        }
        if(top < stackSize){
            stackArray[top] = num;
            top++;
        }
        else{
            System.out.println("CustomStack Overflow");
        }
        if(num < minElement){
            minElement = num;
        }
    }

    public int min(){
        return this.minElement;
    }

    public boolean empty(){
        if(top == 0){
            return true;
        }
        else{
            return false;
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
        stack.push(-9999);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}



