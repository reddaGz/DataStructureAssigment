package PracticeProblemsOnSSL.Stack;

public class Stack<E> {
    private Node top;
    private static class Node<E>{
        private  E data;
        private Node<E> next;
        private Node(E data){
            this.data=data;
        }
    }
    public boolean isEmpty(){
        return top==null;
    }
    public E peek(){
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return (E)top.data;
    }
    public void push(int data){
        Node newNode=new Node(data);
        if(isEmpty())
            top=newNode;
       else{
           newNode.next=top;
           top=newNode;
        }
    }
    public E pop(){
     if(isEmpty())
         throw new IndexOutOfBoundsException();
     E temp=(E)top.data;
         top=top.next;
     return  temp;
    }
    public static void main(String []args){
        Stack <Integer>stack=new Stack<>();
        stack.push(56);
        stack.push(34);
        stack.push(78);
        stack.push(13);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
