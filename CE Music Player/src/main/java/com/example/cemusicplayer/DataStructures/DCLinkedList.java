package com.example.cemusicplayer.DataStructures;

public class DCLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private DoublyNode<T> observer;
    private int size;
    public DCLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public void ModifyObserver(DoublyNode<T> NewNode){
        this.observer = NewNode;
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
    public DoublyNode<T> getObserver(){
        return observer;
    }

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
    public T getNextItemNotLoop(){
        DoublyNode<T>Temp = head;
        if(observer == tail){
            return getData(size - 1);
        } else if (observer == head) {
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

    public T getData(int position){
        return getNode(position).getData();
    }
    public int getSize(){return size;}


}
