package com.example.cemusicplayer.DataStructures;
/**
 * Clase para crear la lista doblemente enlazada circular
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class DCLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private DoublyNode<T> observer;
    private int size;
    /**
     * Metodo constructor de la clase
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public DCLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    /**
     * Metodo para modificar el observer
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public void ModifyObserver(DoublyNode<T> NewNode){
        this.observer = NewNode;
    }
    /**
     * Metodo para agregar un elemento de una lista
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public void add(T data){
        DoublyNode<T> NewNode = new DoublyNode<>(data);
        NewNode.setNext(null);
        NewNode.setBack(null);
        if(head == null){
            head = tail = observer = NewNode;
            NewNode.setNext(head);
            NewNode.setBack(head);
        } else {
            tail = NewNode;
            DoublyNode<T> Temporal;
            Temporal = head;
            while(Temporal.getNext() != head){
                Temporal = Temporal.getNext();
            }
            Temporal.setNext(NewNode);
            NewNode.setNext(head);
            NewNode.setBack(Temporal);
            head.setBack(NewNode);
        }
        this.size++;
    }
    /**
     * Metodo para obtener el nodo en una posicion específica
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public DoublyNode<T> getNode(int position){
        DoublyNode<T> node = tail;
        for(int index=size-1;index>position;index--){
            node=node.getBack();
        }
        return node;
    }
    /**
     * Metodo para eliminar un elemento en una posicion
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public void delete(int position){
        if(size < position || position < 0){
            throw new IndexOutOfBoundsException();
        }
        else if (head == null){
            throw new IndexOutOfBoundsException();
        }
        else if (position == 0){
            DoublyNode<T> currentNode = getNode(position);
            DoublyNode<T> backNode=currentNode.getBack();
            backNode.setNext(null);
            tail = backNode;
        }
        else if(position==size-1){
            DoublyNode<T> currentNode = getNode(position);
            DoublyNode<T> backNode = currentNode.getBack();
            backNode.setNext(head);
            tail = backNode;
        }
        else{
            DoublyNode<T> currentNode=getNode(position);
            DoublyNode<T> backNode=currentNode.getBack();
            DoublyNode<T> nextNode=currentNode.getNext();
            backNode.setNext(nextNode);
            nextNode.setBack(backNode);
        }
        this.size--;
    }
    /**
     * Metodo para obtener el observer
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public DoublyNode<T> getObserver(){
        return observer;
    }
    /**
     * Metodo para obtener el siguiente elemento de la lista
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public T getNextItem(){
        DoublyNode<T>Temp = head;
        if(observer == head){
            observer = observer.getNext();
            return getData(0);
        }
        else if (observer != null){
            Temp = observer;
            observer =observer.getNext();
            return Temp.getData();
        } else {
            observer = head;
            return observer.getData();
        }
    }
    /**
     * Metodo para obtener el siguiente elemento de la lista, pero sin seguir al primer elemento cuando esta en el ultimo
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public T getNextItemNotLoop(){
        DoublyNode<T>Temp = head;
        if(observer == tail){//Se hace una verificacion para que el usuario no pueda pasar de la ultima cancion
            return getData(size - 1);
        } else if (observer == head) {//Se hace la verificacion para que cuando se llega a la cabeza con el get back cuando se vualva a a llamar el get back siga a la segunda cancion
            observer = getNode(2);
            return observer.getBack().getData();
        } else if (observer != null){
            Temp = observer;
            observer = observer.getNext();
            return Temp.getData();
        } else {
            return null;
        }
    }
    /**
     * Metodo para obtener el anterior elemento de la lista
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public T getBackItem(){
        DoublyNode<T>Temp = head;
        if (observer != null) {
            observer = observer.getBack();
            Temp = observer;
            if (Temp.getBack() != null){
                Temp = Temp.getBack();
            }
            return Temp.getData();
        } else {
            observer = getNode(size - 1);
            return getData(size - 1);
        }
    }
    /**
     * Metodo para obtener el anterior elemento de la lista pero sin ir al último cuando esta en el primero
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public T getBackItemNotLoop(){
        DoublyNode<T>Temp = head;
        if (observer != getNode(0) && observer != getNode(1) && observer != tail){
            observer = observer.getBack();
            Temp = observer;
            if (Temp.getBack() != null){
                Temp = Temp.getBack();
            }
            return Temp.getData();
        } else if (observer == getNode(1)){
            observer = observer.getBack();
            return getNode(0).getData();
        } else if (observer == tail){
            observer = observer.getBack();
            return getData(size - 2);
        } else {
            observer = getNode(0);
            return getNode(0).getData();
        }
    }
    /**
     * Metodo para obtener un dato en la una posicion específica
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public T getData(int position){
        return getNode(position).getData();
    }

    /**
     * Metodo para obtener el tamaño de la lista
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public int getSize(){return size;}


}