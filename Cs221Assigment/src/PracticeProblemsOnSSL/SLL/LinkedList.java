package PracticeProblemsOnSSL.SLL;
public class LinkedList {
    private Node head = null;
    private int size = 0;
    public boolean addFirst(int n){//add at first element
        Node temp=new Node(n, head);
        head = temp;
        size++;
        return  true;
    }
    public void addAfter(int n, Node node) {
        node.next = new Node(n, node.next);
        size++;
    }
    private Node getNode(int index) {
        Node node = head;
        if(node==null)
            return null;
        if(node!=null)
            for (int i=1; i<=index; i++) {
                node = node.next;
            }
        return node;
    }
    public int get(int index){//return the data;
        int num=0;
        if(index<0||index>size)
            throw new ArrayIndexOutOfBoundsException();
        Node node=getNode(index);
        if(node!=null)
             num=node.data;
        return num;
    }

    public  int removeFirst() {
        Node temp = head;
        int num=0;
        if (head != null) {
            head = head.next;
            size--;
        }
        return temp.data;
    }
    public  int removeAfter(Node node) {
        Node temp=node.next;
        int num=0;
        if(temp!=null){
            node.next=temp.next;
            num=temp.data;
            temp.next=null;
            size--;
        }
        return num;
    }

    public int set(int index,int newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node node = getNode(index);
        int result = node.data;
        node.data = newValue;
        return result;
    }
    public int max(){
        int max=get(0);
        for(int i=0;i<size;i++){
            if(max<get(i)){
                max=get(i);
            }

        }

        return max;
    }
    public  int min(){
          int min=get(0);
          for(int i=0;i<size;i++)
              if(min>get(i))
                  min=get(i);
              return min;
    }
public  static void main(String []args){
   LinkedList ll=new LinkedList();
    ll.addFirst(6);
    ll.addFirst(5);
    ll.addFirst(4);
    ll.addFirst(3);
    ll.addFirst(2);
    ll.set(0,78);
    Node y=ll.getNode(2);
    //ll.addAfter(67, y);
    for(Node i = ll.head; i!=null; i=i.next){
       System.out.println(i.data+" ");
    }
    System.out.println(ll.size);
    System.out.println(ll.get(2));
    System.out.println("============================");
    ll.removeAfter(y);
    for(Node i = ll.head; i!=null; i=i.next){
        System.out.println(i+" ");
    }
    System.out.println(ll.size);
    System.out.println("Maximum number:"+ll.max());
    System.out.println("Minimum number:"+ll.min());
 }
}
