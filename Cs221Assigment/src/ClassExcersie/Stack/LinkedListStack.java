package ClassExcersie.Stack;
import java.util.EmptyStackException;
public class LinkedListStack<E> implements StackInt<E>{
    private Node top;
    private int size=0;
    private static class Node<E>{
        private  E data;
        private Node<E> next;
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
        public Node(E data) {

            this(data,null);
        }
    }
    @Override
    public E push(E obj) {
        Node<E>newNode=new Node<>(obj);
        if(empty())
            top=newNode;
        newNode.next=top;
        top=newNode;
        size++;
        return obj;
    }

    @Override
    public E peek() {
        if(empty())
            throw new EmptyStackException();

        return (E) top.data;
    }

    @Override
    public E pop() {
        if(empty())
            return null;
        E temp= (E) top.data;
        top=top.next;
        size--;
        return temp;
    }

    @Override
    public boolean empty() {
        return top==null;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        StackInt<Integer> stack=new LinkedListStack<>();
        stack.push(34);
        stack.push(56);
        stack.push(90);
        //stack.pop();

        System.out.println(stack.peek());
        System.out.println("Size is '+"+ stack.size());
    }
}
