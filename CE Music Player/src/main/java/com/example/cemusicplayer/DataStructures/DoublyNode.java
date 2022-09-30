package com.example.cemusicplayer.DataStructures;

/**
 * Implementacion del nodo doblemente enlazado que es utilizado en la lista doblemente enlazada circular
 * @param <T> El objeto que se le asigna al nodo
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
 */
public class DoublyNode<T> {
        private T data;
        private DoublyNode<T> next;
        private DoublyNode<T> back;


        public DoublyNode(T data){
            this.data=data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public DoublyNode<T> getNext() {
            return next;
        }

        public void setNext(DoublyNode<T> next) {
            this.next = next;
        }

        public DoublyNode<T> getBack() {
            return back;
        }

        public void setBack(DoublyNode<T> back) {
            this.back = back;
        }
    }

