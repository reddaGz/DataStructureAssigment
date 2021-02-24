package Assigment6.Number1;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ReverseWord implements StackInt {
    private int top = -1;
    private String[] data;
    private static final int INTIAL_CAPACITY = 10;

    public ReverseWord() {
        data = new String[INTIAL_CAPACITY];
    }

    @Override
    public String push(String str) {
        if (top == data.length)
            reallocate();
        int i = ++top;
        data[i] = str;
        return null;
    }

    @Override
    public String peek() {
        if (empty())
            return null;
        return data[top];
    }

    @Override
    public String pop() {
        if (empty())
            throw new EmptyStackException();
        return data[top--];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
    public void reallocate() {
        data = Arrays.copyOf(data, 2 * data.length);
    }

    public void splitWord(String word) {
        int index=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==' '){
                push(word.substring(index,i));
                index=i;
            }
            if(i+1==word.length())
                push(word.substring(index,i+1));
        }
        System.out.println(size());
        int n=size();
        String st="";
        for(int i=0;i<n;i++){
            st+=pop();
        }
        push(st);
        }

        public static void main (String[]str){
           ReverseWord reverseWord = new ReverseWord();
            reverseWord.push("java programing is baseic in desktop app development ");
            String word=reverseWord.pop();
            reverseWord.splitWord(word);
            System.out.println(reverseWord.peek());
            System.out.println(reverseWord.peek());

        }
    }
