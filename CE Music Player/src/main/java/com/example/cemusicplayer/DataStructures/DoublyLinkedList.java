package com.example.cemusicplayer.DataStructures;


public class DoublyLinkedList<T> {
    private DoublyNode<T> first;
    private DoublyNode<T> last;
    private int size;

    public DoublyLinkedList(){
        this.first=null;
        this.last=null;
        this.size=0;
    }

    public void add(T data){
        DoublyNode<T> newNode=new DoublyNode<>(data);
        if (first==null){
            first=newNode;
            last=first;

        } else {
            newNode.setBack(last);
            last.setNext(newNode);
            last=newNode;
            last.setNext(null);
        }
        this.size++;

    }
    public DoublyNode<T> getNode(int position){
        DoublyNode<T> node = last;
        for(int index=size-1;index>position;index--){
            node=node.getBack();
        }
        return node;
    }
    private DoublyNode<T> back(int position ){
        return getNode(position).getBack();
    }
    private DoublyNode<T> next(int position){
        return getNode(position).getNext();


    }

    public void delete(int position){
        if(size < position || position < 0 ){
            throw new IndexOutOfBoundsException();
        }
        else if (first==null){
            throw new IndexOutOfBoundsException();
        }
        else if (position==0){
            DoublyNode<T> currentNode=getNode(position);
            DoublyNode<T> nextNode=currentNode.getNext();
            nextNode.setBack(null);
            first=nextNode;
        }
        else if(position==size-1){
            DoublyNode<T> currentNode=getNode(position);
            DoublyNode<T> backNode=currentNode.getBack();
            backNode.setNext(null);
            last=backNode;
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

    public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public T getData(int position){
            return getNode(position).getData();


        }
}
