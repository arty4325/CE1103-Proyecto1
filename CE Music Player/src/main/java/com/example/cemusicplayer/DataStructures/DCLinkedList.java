package com.example.cemusicplayer.DataStructures;

public class DCLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private DoublyNode<T> observer;
    private int size;
    public DCLinkedList() {
        this.head = null;
        this.tail = null;
        this.observer = null;
        this.size = 0;
    }

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
    public DoublyNode<T> getNode(int position){
        DoublyNode<T> node = tail;
        for(int index=size-1;index>position;index--){
            node=node.getBack();
        }
        return node;
    }

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
    public DoublyNode<T> GetNextPosition(){
        observer = observer.getNext();
        return observer.getBack();
    }









    public int getSize(){return size;}


}
