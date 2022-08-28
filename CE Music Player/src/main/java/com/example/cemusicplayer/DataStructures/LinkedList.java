package com.example.cemusicplayer.DataStructures;

public class list <T> {
    private node<T> head;
    private node<T> tail;
    private int size;
    public list(){
        head = null;
    }

    public T get(int position) {
        int cot = 0;
        node<T> node = head;
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


    public T add(T data){
        node<T> node = head;
        node<T> newNode = new node<>(data);
        if(head == null){
            head = tail = newNode;
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
        node<T> node = head;
        node<T> FinalNode = head;
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



    public int getSize() {
        return size;
    }
}
