package com.module;

public class LinkedList<T>{

    public class Node<T>{
        Node<T> next;
        private T data;
        //Constructor
        Node(T dataValue){
            data = dataValue;
            next = null;
        }

        public T getData(){
            return this.data;
        }
        @Override
        public boolean equals(Object object){
            if((object instanceof Node) && ((Node) object).data.equals(this.data)){
                return true;
            }
            else return false;

        }

        @Override
        public int hashCode(){
            return this.data.hashCode();

        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;
    LinkedList(){
        head = null;
        tail = null;
        listSize();
    }
    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        else return false;
    }

    public int listSize(){

        if(isEmpty()){
            size = 0;
        }
        else{
            if(head.next == null){
                size = 1;
            }
            else{
                Node<T> temp = head;
                int counter = 0;
                while(temp != null){
                    temp = temp.next;
                    counter++;
                }
                size = counter;
            }
        }
        return size;
    }

    public Node<T> getTail(){
        return this.tail;
    }

    public Node<T> updateTail(){
       // Node<T> tail = null;
        if(!isEmpty()){
            Node<T> temp = head;
            if(temp.next != null){
                temp = temp.next;
            }
           tail = temp;
        }else tail = null;
        return tail;
    }
    public void insert(T data){
        Node<T> newNode = new Node<T>(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            tail = newNode;
        }
        size++;

    }
    public void delete(T data) throws IllegalArgumentException{

        if(search(data) > 0){
            Node<T> newNode = new Node<>(data);
            boolean found = false;
            if(head.equals(newNode)){
                head = head.next;
                found =true;

            }else{
                Node<T> temp = head;

                while(temp != null){
                    if(temp.next.equals(newNode)){
                        temp.next = temp.next.next;
                        found = true;
                        break;
                    }
                    temp = temp.next;
                }

            }
            if(!found)
                throw new IllegalArgumentException("The node to delete is not in the list");
            size--;
            tail = updateTail();
        } else throw new IllegalArgumentException("The list is empty");
    }

    public T deleteHead() throws IllegalArgumentException{
        if(this.isEmpty()){
            throw new IllegalArgumentException("The list is empty, cannot delete head");
        }
        T data = (T)this.head.getData();
        this.delete(data);
        return data;
    }

    public T deleteTail() throws IllegalArgumentException{
        if(this.isEmpty()){
            throw new IllegalArgumentException("The list is empty, cannot delete tail");
        }
        if(this.head.next == null){
            size--;
            return this.deleteHead();
        }
        Node<T> temp = head;
        while (temp.next != null && temp.next.next != null){
            temp = temp.next;
        }
        T data = temp.next.getData();
        temp.next = null;
        updateTail();
        size--;
        return data;
    }

    public int search(T data) throws IllegalArgumentException{
        Node<T> newNode = new Node<T>(data);
        boolean found = false;
        int counter = 0;
        if(isEmpty()){
            throw new IllegalArgumentException("The list is empty");
        }else{
            Node<T> temp = head;
            while(temp != null){
                if(temp.getData().equals(data)){
                    found = true;
                    counter++;
                    break;
                }
                counter++;
                temp = temp.next;
            }
            if(!found)
                throw new IllegalArgumentException("The node is not in the list");
        }
        return counter;
    }
    public void printList(){
        if(isEmpty()){
            System.out.println("the list is empty");
        }
        else{
            Node<T> temp = head;
            while(temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
}