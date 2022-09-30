package com.example.cemusicplayer.DataStructures;

/**
 * Nodo simplemente enlazado el cual se utiliza para la lista simplemente enlazada
 * @param <T> Objeto asignado al nodo
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
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
