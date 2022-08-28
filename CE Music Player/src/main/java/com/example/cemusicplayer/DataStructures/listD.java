package com.example.cemusicplayer.DataStructures;


public class listD <T> {
    private nodeD<T> first;
    private nodeD<T> last;
    private int size;

    public listD(){
        this.first=null;
        this.last=null;
        this.size=0;
    }

    public void add(T data){
        nodeD<T> newNode=new nodeD<>(data);
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
    public nodeD<T> getNode(int position){
        nodeD<T> node = last;
        for(int index=size-1;index>position;index--){
            node=node.getBack();
        }
        return node;
    }
    private nodeD<T> back(int position ){
        return getNode(position).getBack();
    }
    private nodeD<T> next(int position){
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
                nodeD<T> currentNode=getNode(position);
                nodeD<T> nextNode=currentNode.getNext();
                nextNode.setBack(null);
                first=nextNode;
            }
            else if(position==size-1){
                nodeD<T> currentNode=getNode(position);
                nodeD<T> backNode=currentNode.getBack();
                backNode.setNext(null);
                last=backNode;
            }
            else{
                nodeD<T> currentNode=getNode(position);
                nodeD<T> backNode=currentNode.getBack();
                nodeD<T> nextNode=currentNode.getNext();
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

