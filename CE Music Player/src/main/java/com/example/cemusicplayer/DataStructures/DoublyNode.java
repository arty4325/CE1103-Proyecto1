package com.example.cemusicplayer.DataStructures;

/**
 * Clase de manejo de los nodos de una lista doblemente enlazada circular
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class DoublyNode<T> {
    private T data;
    private DoublyNode<T> next;
    private DoublyNode<T> back;

    /**
     * Metodo para establecer un dato
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public DoublyNode(T data){
        this.data=data;
    }
    /**
     * Metodo para obtener un dato
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    /**
     * Metodo para obtener el siguiente nodo
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public DoublyNode<T> getNext() {
        return next;
    }
    /**
     * Metodo para establecer la referencia al siguiente nodo
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public void setNext(DoublyNode<T> next) {
        this.next = next;
    }
    /**
     * Metodo para obtener el anterior nodo
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public DoublyNode<T> getBack() {
        return back;
    }
    /**
     * Metodo para establecer la referencia el anterior nodo
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public void setBack(DoublyNode<T> back) {
        this.back = back;
    }
}

