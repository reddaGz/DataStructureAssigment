package Assigment7;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
public class PriortyQuueArray implements MyQue<Person> {

    private int front=0;
    private  int size=0;
    private int capacity;
    private static final int INTIAL_CAPACITY=10;
    private Person[]data;
    public PriortyQuueArray(){
        capacity=INTIAL_CAPACITY;
        data= new Person[capacity];
    }

    @Override
    public boolean add(Person e) {
        if(size==data.length)
             reallocate();
        if(size==0)//{
            data[size++] = e;
        else
        {
            int i;
            for(i=size-1; i>=0; i--)
            {
                if( e.getAge() > data[i].getAge())
                    data[i+1] = data[i];
                else
                    break;
            }
            System.out.println(i);
            data[i+1] = e;
            size++;
        }
        return true;
    }

    @Override
    public boolean offer(Person e) {
        if(size==data.length)
            reallocate();
        if(size==0)
            data[size] = e;
        else
        {
            int i;
            for(i=size-1; i>=0; i--)
            {
                if( e.getAge() > data[i].getAge() )
                    data[i+1] = data[i];
                else
                    break;
            }
            data[i+1] = e;
        }
        size++;
        return true;
    }

    @Override
    public Person remove() {
        if(size==0)
            throw  new NoSuchElementException();
        Person temp=data[front];
        for(int i=0;i<size;i++){
            data[i]=data[i+1];
        }
        size--;
        return temp;
    }

    @Override
    public Person poll() {
        if(size==0)
            return null;
        Person temp=data[front];
        for(int i=0;i<size;i++){
            data[i]=data[i+1];
        }
        size--;
        return temp;
    }
    @Override
    public Person element() {
        if(size==0)
            return null;
        else
            return data[front];
    }

    @Override
    public Person peek() {
        if(size==0)
            return null;
       else
            return data[front];
    }
    @Override
    public int getSize() {
        return size;
    }
 public boolean empty(){
        return size==0;
 }
    public void reallocate(){
     int newCapacity=2*capacity;
     Person[]temp=new Person[newCapacity];
     for(int i=0;i<size;i++){
         temp[i]=data[i];
     }
     data=temp;
    }

    public static void main(String[] args) {
        PriortyQuueArray pq=new PriortyQuueArray();
        PriorityQueue<Person> pp=new PriorityQueue<>();
        pq.add(new Person("Redda","Male",23));
        pq.add(new Person("Kaleb","Male",48));
        pq.add(new Person("Ezra","Male",12));
        pq.add(new Person("Kaleb","Male",84));
        pq.add(new Person("Kaleb","Male",90));
        pq.add(new Person("Kaleb","Male",99));
        pq.add(new Person("Kaleb","Male",18));
        pq.add(new Person("Kaleb","Male",99));
        pq.add(new Person("Kaleb","Male",31));
        pq.add(new Person("Kaleb","Male",86));

        for(int i=0;i< pq.size;i++){
            System.out.println(pq.data[i]);
        }
    }

}
