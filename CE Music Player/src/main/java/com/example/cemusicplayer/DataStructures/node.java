package com.example.cemusicplayer.DataStructures;

public class node <T>{
    private T data;
    private node<T> next;

    public node(T data) {
        this.data=data;
    }

    public void setData(T data){
        this.data=data;
    }

    public T getData(){
        return this.data;
    }

    public void setNext(node<T> next){
        this.next=next;
    }

    public node<T> getNext(){
        return this.next;
    }


}
