package com.example.cemusicplayer.DataStructures;

public class LinkedList<T> {
    private SimpleNode<T> head;
    private SimpleNode<T> observer;
    private int size;
    public LinkedList(){
        head = null;
    }

    public T get(int position) {
        int cot = 0;
        SimpleNode<T> node = head;
        if (getSize() > position) {
            while (cot != position) {
                cot++;
                node = node.getNext();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return node.getData();
    }


    public T getNext(){
        SimpleNode<T> Temp = head;
        if(observer == head){
            observer = observer.getNext();
            return get(0);
        } else if (observer != null){
            Temp = observer;
            observer = observer.getNext();
            return Temp.getData();
        } else {
            return null;
        }
    }



    public T add(T data){
        SimpleNode<T> node = head;
        SimpleNode<T> newNode = new SimpleNode<>(data);
        if(head == null){
            head = observer = newNode;
            this.size++;
            return newNode.getData();
        } else {
            while(node.getNext() != null){
                node = node.getNext();
            }
            node.setNext(newNode);
        }
        this.size++;
        return newNode.getData();
    }

    public T delete(int position){
        SimpleNode<T> node = head;
        SimpleNode<T> FinalNode = head;
        if(size<position || position<0 ){
            throw new IndexOutOfBoundsException();
        }
        else if (head==null){
            throw new IndexOutOfBoundsException();
        }
        else if (position==0){
            head = head.getNext();
        }
        else if(position==size-1){
            for(int i = 0; i < position - 1; i++){
                node = node.getNext();
            }
            node.setNext(null);
        }
        else{
            for(int i = 0; i < position - 1; i++){
                node = node.getNext();
            }
            FinalNode = node.getNext();
            node.setNext(node.getNext().getNext());
        }
        this.size--;
        return FinalNode.getData();
    }
    public int IndexOfItem(String Item){
        SimpleNode<T> Checker = head;
        int Value = 0;
        for (int i = 0; i < size; i++){

            if (get(i) == Item){
                System.out.println("Es Igual");
                Value = i;
            }
        }
        this.size--;
        System.out.println("End Of Loop");
        return Value;
    }



    public int getSize() {
        return size;
    }
}