package MockExam.Number1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ExamArrayList
{
    private static final int INITIAL_CAPACITY = 2;
    private String[] theData;
    private int size = 0;
    private int capacity = 0;

    public ExamArrayList() {
        capacity = INITIAL_CAPACITY;
        theData = new String[capacity];
    }

    public ExamArrayList(int capacity) {
        this.capacity = capacity;
        theData = new String[capacity];
    }

    public boolean add(String anEntry) {
        if (size == capacity) {
            reallocate();
        }
        theData[size] = anEntry;
        size++;
        return true;
    }

    public void add(int pos, String anEntry) {
        if (pos<0||pos > size)
            return;
        if (size == capacity) {
            reallocate();
        }

        for (int i = size; i > pos; i--) {//shifting forward//to next index
            theData[i] = theData[i-1];
        }
        theData[pos] = anEntry;
        size++;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    public String set(int index, String newValue) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        String oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    public String remove(int index) {//shifting backWard//previous index
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        String returnValue = theData[index];
        for (int i = index + 1; i < size; i++) {
            theData[i - 1] = theData[i];
        }
        size--;
        return returnValue;
    }

    private void reallocate() {
        capacity = 2 * capacity;
//        String[]temp= new String[capacity];
//        for(int i=0;i<size;i++){
//            temp[i]= theData[i];
//        }
//        theData=temp;
        theData = Arrays.copyOf(theData, capacity);
        //theData= Arrays.copyOf(theData,capacity);
    }

    public int size() {
        return size;
    }

    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
//            if (theData[i] == null && item == null) {
//                return -1;
//            }
            if (theData[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }


    public int lastindexOf(String item) {
        for (int i = size-1; i >=0; i--) {
//            if (theData[i] == null && item == null) {
//                return -1;
//            }
            if (theData[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < size-1; ++i){
            sb.append(theData[i]+", ");
        }
        sb.append(theData[size-1]+"]");
        return sb.toString();
    }

    // Q1.A
    public void removeAllOf(String target){
       for(int i=0;i<size;i++){
           if(theData[i].equals(target)){
               remove(i);
           }
       }
    }
    // Q1.B
    public void toEnd(int index){
        String temp;
        if(index<0||index>=size)
            throw new ArrayIndexOutOfBoundsException();
        temp=remove(index);
        add(temp);
//        temp=theData[index];
//        theData[index]=theData[size-1];
//        theData[size-1]=temp;
        // TODO write your implementation here ...
    }

    // Q1.C
    public void resizeArray(){
        if(size<=capacity/2){
            capacity = capacity/2;
            theData = Arrays.copyOf(theData, capacity);
        }
        // TODO write your implementation here ...
    }

    public static void main(String args[]){
        ExamArrayList sl= new ExamArrayList();

        sl.add("Moe");
        sl.add("Jullz");
        sl.add("Nadine");
        sl.add("Zaineh");
        sl.add("Moe");
        sl.add("Jasmine");

        sl.removeAllOf("Moe");
        System.out.println(sl);
        // Should be: [Jullz, Nadine, Zaineh, Jasmine]

        sl.toEnd(1);
        System.out.println(sl);
        // Should be: [Jullz, Nadine, Jasmine, Zaineh]

        sl.resizeArray();
        System.out.println(sl.capacity);
        // Should be: 5
       // String str=sl.get(5);

    }
}


