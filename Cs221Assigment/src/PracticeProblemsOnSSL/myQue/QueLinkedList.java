package PracticeProblemsOnSSL.myQue;


public class QueLinkedList<E> implements MyQue<E> {

    private Node<E> front;
    private Node<E> rear;
    private int size;
    //Node Class
    private static class Node<E>{
        private  E data;
        private Node<E> next;
        private Node(E data){
            this(data,null);
        }
        private Node(E data,Node<E> ref){
            this.data=data;
            this.next=ref;
        }
    }
    @Override
    public boolean add(E e) {
        Node<E> newNode=new Node(e);
        if(front==null)
            front=newNode;
        else
            rear.next=newNode;
        rear=newNode;
        size++;
        return true;
    }
    @Override
    public boolean offer(E e) {
        Node<E> newNode=new Node(e);
        if(front.equals(null))
            front=newNode;
        else
            rear.next=newNode;
        rear=newNode;
        size++;
        return true;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        if(front==null)
            return null;
        E temp=front.data;
        front=front.next;
        size--;
        return temp;
    }

    @Override
    public E element() {
        if(front==null)
            return null;
        else
            return front.data;
    }

    @Override
    public E peek() {
        if(front==null)
            return null;
        else
        return front.data;
    }
    @Override
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        QueLinkedList<Integer> ql=new QueLinkedList();
        ql.add(45);
        System.out.println(ql.poll());
        System.out.println(ql.peek());
    }
}
