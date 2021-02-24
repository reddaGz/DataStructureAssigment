package PracticeProblemsOnSSL.myQue;

import java.util.NoSuchElementException;
import java.util.Objects;

public class QueCircularArray<E> implements MyQue<E> {
    private int front;
    private int rear;
    private  int size;
    private int capacity;
    private static final int INTIAL_CAPACITY=10;
    private E[]data;
    public QueCircularArray(){
        capacity=INTIAL_CAPACITY;
        data= (E[]) new Objects[capacity];
         front=0;
         rear=capacity-1;
         size=0;
    }

    @Override
    public boolean add(E e) {
        if(size==capacity)
            reallocate();
        size++;
        rear=(rear+1)%capacity;
        data[rear]=e;
        return true;
    }

    @Override
    public boolean offer(E e) {
        if(size==capacity)
            reallocate();
        size++;
        rear=(rear+1)%capacity;
        data[rear]=e;
        return true;
    }

    @Override
    public E remove() {
        if(size==0)
            throw  new NoSuchElementException();
        return null;
    }

    @Override
    public E poll() {
        if(size==0)
            return null;
        E temp=data[front];
        front=(front+1)%capacity;
        size--;
        return temp;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        if(size==0)
            return null;
       else
            return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    public void reallocate(){
        int newCapacity=2*capacity;
        E[]newData= (E[])new Objects[newCapacity];
        int j=front;
        for(int i=0;i<getSize();i++){
            newData[i]=data[j];
            j=(j+1)%capacity;
        }
        front=0;
        rear=size-1;
        capacity=newCapacity;
        data=newData;
    }
}
