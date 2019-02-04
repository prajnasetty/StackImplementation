package com.module;


public class Main {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.insert("1");
        list.insert("2");
        list.insert("3");
        list.insert("6");
        list.insert("2");
        list.delete("2");



        System.out.println("List size:"+list.listSize());

        list.printList();

        System.out.println("-----------------");
        Stack<Integer> stack = new Stack<>();
        Integer data ;
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        data = stack.peek();
        System.out.println("Stack top:" +data);

    }
    }

