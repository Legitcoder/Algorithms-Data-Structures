package com.company;


import java.util.*;

public class MyQueue {

    private Stack a = new Stack();
    private Stack b = new Stack();

    public void MyQueue(){
    }

    public void enqueue(int num){
        if(!a.empty()) {
            a.push(num);
        }
        else{
            while(!b.empty()) {
                a.push(b.pop());
            }
            a.push(num);
        }
    }

    public void dequeue(){
        if(!b.empty()){
            b.pop();
        }
        else{
            while(!a.empty()){
                b.push(a.pop());
            }
            b.pop();
        }
    }

    public void peek(){
        if(!b.empty()){
            System.out.println(b.peek());
        }
        else{
            while(!a.empty()){
                b.push(a.pop());
            }
            System.out.println(b.peek());
        }
    }

    public static void main(String[] args){
        MyQueue queue = new MyQueue();
        for(int i = 1; i < 11; i++) {
            queue.enqueue(i);
        }
        queue.peek();
        for(int i = 1; i < 11; i++) {
            queue.dequeue();
        }
        queue.enqueue(44);
        queue.peek();
    }
}
