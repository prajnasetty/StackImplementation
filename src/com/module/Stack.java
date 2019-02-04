package com.module;

public class Stack<T> {
    private LinkedList<T> stack;
    Stack(){
        stack = new LinkedList<>();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public int stackSize(){
        return stack.listSize();
    }
    public void push(T  data){
        stack.insert(data);
    }
    public T peek(){
        return stack.getTail().getData();
    }

    public T pop() throws IllegalArgumentException{
        return stack.deleteTail();
    }

    public void print() {
        Stack<T> tempStack = new Stack<>();
        System.out.println("Print Stack");
        while (this.stackSize() > 0){
            T data = this.pop();
            System.out.println(data);
            tempStack.push(data);
        }
        while (tempStack.stackSize() > 0){
            this.push(tempStack.pop());
        }
    }
}
