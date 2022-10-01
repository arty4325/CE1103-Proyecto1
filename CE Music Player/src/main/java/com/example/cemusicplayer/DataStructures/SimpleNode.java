package com.example.cemusicplayer.DataStructures;
/**
 * Clase de manejo de los nodos de una lista simplemente enlazada
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class SimpleNode<T>{
    private T data;
    private SimpleNode<T> next;

    /**
     * Metodo para establecer un dato
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public SimpleNode(T data) {
        this.data=data;
    }

    public void setData(T data){
        this.data=data;
    }
    /**
     * Metodo para obtener un dato
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public T getData(){
        return this.data;
    }
    /**
     * Metodo para establecer la referencia al siguiente nodo
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public void setNext(SimpleNode<T> next){
        this.next=next;
    }
    /**
     * Metodo para obtener el siguiente nodo
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public SimpleNode<T> getNext(){
        return this.next;
    }


}
