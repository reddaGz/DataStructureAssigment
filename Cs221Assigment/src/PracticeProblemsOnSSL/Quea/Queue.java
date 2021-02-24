package PracticeProblemsOnSSL.Quea;

public class Queue <E>{
    private Node head;
    private Node tail;
    private static class Node<E>{
        private  E data;
        private Node<E> next;
        private Node(E data){
            this.data=data;
        }
    }
    public boolean isEmpty(){
        return head==null;
    }
    public E peek(){
        if(isEmpty())
            throw new IndexOutOfBoundsException();
       E temp= (E)head.data;
       return  temp;
    }
    public  void add(int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            head=newNode;
        }
        else{
            tail.next=newNode;
        }
        tail=newNode;

    }
    public E remove(){
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        E temp=(E)head.data;
        if(head.next==null){
            tail=null;
            head=null;
        }
        else{
            head=head.next;
        }
        return temp;
    }
public static void main(String []args){
        Queue <Integer>q=new Queue<>();
        q.add(8);
        q.add(12);
        q.add(4);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }
}
