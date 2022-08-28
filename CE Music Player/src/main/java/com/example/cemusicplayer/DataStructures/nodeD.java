package com.example.cemusicplayer.DataStructures;


    public class nodeD <T> {
        private T data;
        private nodeD<T> next;
        private nodeD<T> back;


        public nodeD(T data){
            this.data=data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public nodeD<T> getNext() {
            return next;
        }

        public void setNext(nodeD<T> next) {
            this.next = next;
        }

        public nodeD<T> getBack() {
            return back;
        }

        public void setBack(nodeD<T> back) {
            this.back = back;
        }
    }

