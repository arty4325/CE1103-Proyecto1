package com.example.cemusicplayer.DataStructures;


public class DoubleLinkedList<T> {
    private DoubleNode<T> first;
    private DoubleNode<T> last;
    private int size;

    public DoubleLinkedList(){
        this.first=null;
        this.last=null;
        this.size=0;
    }

    public void add(T data){
        DoubleNode<T> newNode=new DoubleNode<>(data);
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
    public DoubleNode<T> getNode(int position){
        DoubleNode<T> node = last;
        for(int index=size-1;index>position;index--){
            node=node.getBack();
        }
        return node;
    }
    private DoubleNode<T> back(int position ){
        return getNode(position).getBack();
    }
    private DoubleNode<T> next(int position){
        return getNode(position).getNext();


    }

        public void delete(int position){
            if(size<=position || position<0 ){
                throw new IndexOutOfBoundsException();
            }
            else if (first==null){
                throw new IndexOutOfBoundsException();
            }
            else if (position==0){
                DoubleNode<T> currentNode=getNode(position);
                DoubleNode<T> nextNode=currentNode.getNext();
                nextNode.setBack(null);
                first=nextNode;
            }
            else if(position==size-1){
                DoubleNode<T> currentNode=getNode(position);
                DoubleNode<T> backNode=currentNode.getBack();
                backNode.setNext(null);
                last=backNode;
            }
            else{
                DoubleNode<T> currentNode=getNode(position);
                DoubleNode<T> backNode=currentNode.getBack();
                DoubleNode<T> nextNode=currentNode.getNext();
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

