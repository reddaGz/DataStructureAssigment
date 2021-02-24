package Assigment7;
public class PriortyQuaeLinkedList implements MyQue<Person> {
    private Node front=null;
    private Node rear;
    private int size;
    private static class Node{
        private  Person data;
        private Node next;
        private Node(Person data){
            this.data=data;
            this.next=null;
        }
        private Node(Person data,Node ref){
            this.data=data;
            this.next=ref;
        }
    }
    private Node getNode(int index) {
      Node node = front;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }
    public Person get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = getNode(index);
        return node.data;
    }
    private void addFirst(Person item) {
        front = new Node(item, front);
        size++;
    }
    private void addAfter(Node node1, Node newNode) {
        newNode.next=node1.next;
        node1.next=newNode;
        size++;
    }
    @Override
    public boolean add(Person person) {
        Node newNode=new Node(person);
        Node node = front;
        if(node==null){
            front=newNode;
            size++;
            return true;
        }
        else {
            int index=0;
            while (node != null) {
                if (node.data.getAge() < person.getAge()) {
                    break;
                }
                index++;
                node = node.next;
            }
            if(index==0){
                addFirst(person);
            }
            else{
                Node gNode=getNode(index-1);
                addAfter(gNode,newNode);
            }
        }
        return true;
    }

  /*  public boolean addValues(Person person){
        Node newNode=new Node(person);
        Node temp=front;
        if(temp==null){
            front=newNode;
            size++;
            return true;
        }

        else{
             if(front.data.getAge()<person.getAge()){
                 newNode.next=front;
                 front=newNode;
                    size++;
                 return true;
             }
             else{
                 Node node=front;
                 while (node.next!=null){
                     if(node.data.getAge()<person.getAge()){
                         newNode.next=node.next;
                         node.next=newNode;
                         break;
                     }

                     node=node.next;
                 }
                 //node.next=newNode;
             }
        }
        size++;
        return true;
    }*/
    @Override
    public boolean offer(Person person) {
        Node newNode=new Node(person);
        Node node = front;
        if(node==null){
            rear=newNode;
            front=rear;
            size++;
            return true;
        }
        else {
            int index=0;
            while (node != null) {
                if (node.data.getAge() < person.getAge()) {
                    break;
                }
                index++;
                node = node.next;
            }
            if(index==0){
                addFirst(person);
            }
            else{
                Node gNode=getNode(index-1);
                addAfter(gNode,newNode);
            }
        }
        return true;
    }

    @Override
    public Person remove() {
        if(front==null)
            return null;
        Person temp=front.data;
        front=front.next;
        size--;
        return temp;
    }

    @Override
    public Person poll() {
        return null;
    }

    @Override
    public Person element() {
        if(front==null)
            return null;
        else
            return front.data;
    }

    @Override
    public Person peek() {
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
        PriortyQuaeLinkedList pq=new PriortyQuaeLinkedList();
        pq.add(new Person("Redda","Male",30));
        pq.add(new Person("Kaleb","Male",40));
        pq.add(new Person("Ezra","Male",75));
        pq.add(new Person("Kaleb","Male",13));
        pq.add(new Person("Kaleb","Male",90));
        pq.add(new Person("Kaleb","Male",99));
        pq.add(new Person("Kaleb","Male",18));
        pq.add(new Person("Kaleb","Male",98));
        pq.add(new Person("Kaleb","Male",31));
        pq.add(new Person("Kaleb","Male",86));

          while (pq.front!=null){
              System.out.println(pq.front.data);
              pq.front=pq.front.next;
          }
          //System.out.println("peek"+pq.peek());
    }
}
