package com.example.cemusicplayer.DataStructures;

/**
 * Implementacion de la lista simplemente enlazada, utilizada para el manejo de datos secuenciales
 * @param <T> Objetos que estan en la lista simplemente enlazada
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class LinkedList<T> {
    private SimpleNode<T> head;
    private SimpleNode<T> observer;

    private int size;

    public LinkedList() {
        head = null;
    }

    /**
     * Permite obtener el elemento en una posicion dada de la lista simplemente enlazada
     *
     * @param position El valor numerico de la posicion que se esta buscando
     * @return La informacion del nodo en la posicion solicitada
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
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

    /**
     * Permite obtener el elemento que esta inmediatamente despues de un observador dado
     *
     * @return El objeto que esta despues del observador
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public T getNext() {
        SimpleNode<T> Temp = head;
        if (observer == head) {
            observer = observer.getNext();
            return get(0);
        } else if (observer != null) {
            Temp = observer;
            observer = observer.getNext();
            return Temp.getData();
        } else {
            return null;
        }
    }

    /**
     * Permite agregar informacion a la cola de la lista
     *
     * @param data El objeto que se le agrega a la lista
     * @return El objeto que se le agrego a la lista
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public T add(T data) {
        SimpleNode<T> node = head;
        SimpleNode<T> newNode = new SimpleNode<>(data);
        if (head == null) {
            head = observer = newNode;
            this.size++;
            return newNode.getData();
        } else {
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(newNode);
        }
        this.size++;
        return newNode.getData();
    }

    /**
     * Permite borrar informacion de una posicion dada en la lista simplemente enlazada, utilizado para el tratamiento de archivos secuencialses
     *
     * @param position La posicion de la informacion que se desea eliminar
     * @return La informacion eliminada
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public T delete(int position) {
        SimpleNode<T> node = head;
        SimpleNode<T> FinalNode = head;
        if (size < position || position < 0) {
            throw new IndexOutOfBoundsException();
        } else if (head == null) {
            throw new IndexOutOfBoundsException();
        } else if (position == 0) {
            head = head.getNext();
        } else if (position == size - 1) {
            for (int i = 0; i < position - 1; i++) {
                node = node.getNext();
            }
            node.setNext(null);
        } else {
            for (int i = 0; i < position - 1; i++) {
                node = node.getNext();
            }
            FinalNode = node.getNext();
            node.setNext(node.getNext().getNext());
        }
        this.size--;
        return FinalNode.getData();
    }

    /**
     * Permite obtener la posicion de un objeto que esta dentro de la lista
     * @param Item El objeto del cual se quiere obtener la posicion
     * @return El valor numerico de la posicion del objeto dado
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public int IndexOfItem(String Item){
        SimpleNode<T> Checker = head;
        int Value = 0;
        System.out.println("Item" + Item);
        for (int i = 0; i < size; i++){
            System.out.println(get(i));
            if (Item.equals(get(i))){
                Value = i;
            }
        }
        return Value;
    }



    public int getSize() {
        return size;
    }
}