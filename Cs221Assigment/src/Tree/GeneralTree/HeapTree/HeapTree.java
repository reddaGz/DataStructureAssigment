package Tree.GeneralTree.HeapTree;
//priorty Que using using heep tree
public class HeapTree <E extends Comparable<E>>  {//
     final static int DEFUALT_SIZE=2;
     private int capacity;
     private   int[] data;
      private int size=0;

    public HeapTree(){
        capacity=DEFUALT_SIZE;
        data=new int[capacity];
    }
    public void add(int e) {
        if(size==data.length)
            reallocate();
        data[size]= e;
        size++;
        bubbleUp(size -	1);
    }

private void bubbleUp(int c) {//k chiled
    int p = (c - 1) / 2;//p is parent
    while (c > 0 && (data[c]> data[p])) {
        int temp=data[c];
        data[c]=data[p];
        data[p]=temp;
        c = p;
        p = (c - 1) / 2;
    }
}
    public int poll() {
        int temp=data[0];
        if(size==0)
            return 0;
        data[0]=data[size-1];
         size= size-1;
        bubbleDown();
        return temp;
    }

    private void bubbleDown() {
        int i = 0;//is parent
        int c = 2 * i + 2;//c is right chiled
        if (c >= size || data[c - 1] > data[c])
            c = c - 1;//left chiled
        while (c <size && (data[c] > data[i])) {
            int temp = data[i];
            data[i] = data[c];
            data[c] = temp;
            i = c;//parent
            c = 2 * i + 2;//right child
            if (c >=size || data[c - 1] > data[c])
                c = c - 1;//left chiled
        }
    }
    private void reallocate(){
         capacity=2*data.length;
        int[]temp= new int[capacity];
        for(int i=0;i<size;i++)
            temp[i]=data[i];
        data=temp;
    }
    public int peek(){
        return data[0];
    }
    public int getSize(){
        return size;
    }
//==========================

    public static void main(String[] args) {
        HeapTree hp=new HeapTree();
        hp.add(34);
        hp.add(85);
        hp.add(7);
        hp.add(16);
        hp.add(67);
        hp.add(43);
        hp.add(50);
        hp.add(42);
        hp.add(98);
        hp.add(62);
        hp.add(109);
        hp.add(12);
        hp.add(96);
        hp.add(120);
        hp.add(120);
  System.out.println(hp.peek());
        System.out.println("Added values ");
        int n=hp.getSize();
        for(int i=0;i<n;i++){
            System.out.print(hp.data[i]+" ");
        }
        System.out.println("\n=======================");
        System.out.println("After poll the value");
        for(int i=0;i<n;i++){
            System.out.print(hp.poll()+" ");
        }
    }
}

