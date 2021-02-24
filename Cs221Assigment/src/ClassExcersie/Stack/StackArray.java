package ClassExcersie.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;
class ArrayStack<E> implements StackInt<E> {

    E[] theData;
    int top = -1; // Initially empty stack.
    private static final int INITIAL_CAPACITY = 10;

    public ArrayStack() {

        theData = (E[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public E push(E obj) {
        if (top == theData.length - 1) {
            reallocate();
        }
        top++;
        theData[top] = obj;
        return obj;
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return theData[top--];
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return theData[top];
    }


    @Override
    public boolean empty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top+1;
    }

    private void reallocate() {

        theData = Arrays.copyOf(theData, 2 * theData.length);
    }

    public static void main(String args[]){
        StackInt<Integer> ai = new ArrayStack<>();
        for(int i=9;i<100;i++)
            ai.push(i);

//        ai.push(20);
//        ai.push(30);
//        ai.push(40);
//        ai.push(50);
//        ai.push(60);
        System.out.println("Peek Element :" + ai.peek());

//        while(!ai.empty())
//            System.out.println(ai.pop());
    }
}

