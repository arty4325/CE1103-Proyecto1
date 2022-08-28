package com.example.cemusicplayer.DataStructures;


    public class DoubleNode<T> {
        private T data;
        private DoubleNode<T> next;
        private DoubleNode<T> back;


        public DoubleNode(T data){
            this.data=data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public DoubleNode<T> getNext() {
            return next;
        }

        public void setNext(DoubleNode<T> next) {
            this.next = next;
        }

        public DoubleNode<T> getBack() {
            return back;
        }

        public void setBack(DoubleNode<T> back) {
            this.back = back;
        }
    }

