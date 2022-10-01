package com.example.cemusicplayer.DataStructures;
/**
 * Clase para crear la lista simplemente enlazada
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class LinkedList<T> {
    private SimpleNode<T> head;
    private SimpleNode<T> observer;
    private SimpleNode<T> secondObserver;

    private int size;
    /**
     * Metodo constructor de la clase
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public LinkedList(){
        head = null;
    }

    /**
     * Metodo para obtener un dato en una posicion específica
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
     * Metodo para obtener el siguiente elemento de la lista
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
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
    /**
     * Metodo para obtener el siguiente elemento de la lista
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public T getNext2(){
        SimpleNode<T> Temp = head;
        if(secondObserver == head){
            secondObserver = secondObserver.getNext();
            return get(0);
        } else if (secondObserver != null){
            Temp = secondObserver;
            secondObserver = secondObserver.getNext();
            return Temp.getData();
        } else {
            return null;
        }
    }


    /**
     * Metodo agregar un dato a la lista
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public T add(T data){
        SimpleNode<T> node = head;
        SimpleNode<T> newNode = new SimpleNode<>(data);
        if(head == null){
            head = observer = secondObserver = newNode;
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
    /**
     * Metodo eliminar un dato a la lista
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
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

    /**
     * Metodo para obtener el índice de un elemento
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


    /**
     * Metodo para obtener el tamaño de la lista
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public int getSize() {
        return size;
    }
}