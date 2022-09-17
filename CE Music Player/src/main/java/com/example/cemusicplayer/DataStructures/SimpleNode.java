package com.example.cemusicplayer.DataStructures;

public class SimpleNode<T>{
    private T data;
    private SimpleNode<T> next;

    public SimpleNode(T data) {
        this.data=data;
    }

    public void setData(T data){
        this.data=data;
    }

    public T getData(){
        return this.data;
    }

    public void setNext(SimpleNode<T> next){
        this.next=next;
    }

    public SimpleNode<T> getNext(){
        return this.next;
    }


}
