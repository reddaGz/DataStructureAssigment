package Assigment4;

public class DoubleLinkedList<E> {
    private DNode first;
    private DNode last;
    public int size=0;

    public DoubleLinkedList() {
        first = null;
        last = null;
    }
    public static class DNode<E> {
        public E  dData;
        public DNode<E> next;
        public DNode<E> prev;

        public DNode(E d)
        {
            dData = d;
        }
        @Override
        public String toString() {
            return dData+" ";
        }
    }

//    a) private void addFirst(E item)
    private void addFirst(E item) {
        DNode newNode = new DNode(item);
        if (first == null){
            last  = newNode;
            size++;
        }
        else
        {
            first.prev = newNode;
            newNode.next = first;
            size++;
        }
        first = newNode;
    }
//    b) private void addAfter(Node<E> node, E item)
    private void addAfter(DNode<E> node, E item){
//           if(last==null);
//                addFirst(item);
        DNode newNode=new DNode(item);
            if(node.next==null){
                addLast(item);
            }
        else{
                newNode.next=node.next;
                newNode.prev=node;
                node.next.prev=newNode;
                node.next=newNode;
                size++;
            }
}
//    c) private E removeFirst()
     private  E removeFirst(){
        DNode temp=first;
        if(temp==null)
            return null;
        if(first.next==null){
            last=null;
            first=null;
            size--;
        }
        else{
            first=first.next;
            first.prev=null;
            size--;
        }
  return (E) temp;

     }
    private  E removeLast(){
        DNode temp=last;
        if(temp==null)
            return null;
        if(last.prev==null){
            last=null;
            first=null;
        }
        else{
            last=last.prev;
            last.next=null;
            size--;
        }
        return (E) temp;

    }
//   d) private E removeAfter(Node<E> node)
     private  E removeAfter(DNode<E> node){
        DNode temp=node.next;
        if(temp.next==null)
            return null;
        else{
            node.next=node.next.next;
            node.next.next.prev=node;
            node.next=null;
            temp.prev=null;
            size--;
        }
  return (E) temp;
     }
//    e) private Node<E> getNode(int index)
     private DNode<E> getNode(int index){
         DNode node = first;
         if(node==null)
             return null;
         if(node!=null)
             for (int i=0; i<index; i++) {
                 node = node.next;
             }
         return node;
     }
//    f) public E get(int index)
    public  E get(int index){
        E data=null;
        if(index<0||index>size)
            throw new ArrayIndexOutOfBoundsException();
        DNode node=getNode(index);
        if(node!=null)
             data= (E) node.dData;
        return data;
    }
//    g) public void add(int index, E item)
    public void add(int index, E item){
        if(index<0||index>size)
            throw new ArrayIndexOutOfBoundsException();
        DNode node=getNode(index);
       if(node.next==null)
           addLast(item);
       else if(node.prev==null)
           addFirst(item);
       else if(node.prev!=null&&node.next!=null){
           DNode newNode=new DNode(item);
           newNode.next=node;
           newNode.prev=node.prev;
           node.prev.next=newNode;
           node.prev=newNode;
           size++;
       }
    }
//   h) public boolean addLast(E item)
    public  boolean addLast(E item){
        DNode temp=new DNode(item);
        if(last==null){
            first=temp;
            size++;
        }
        else{
            temp.prev=last;
            last.next=temp;
            size++;
        }
        last=temp;
        return true;
    }
//    i) public E remove(int index)
    public E remove(int index){

        if(index<0||index>size)
            throw new ArrayIndexOutOfBoundsException();
        DNode node=getNode(index);
        E temp= (E) node.dData;
        if(node==null)
            return null;
        if(node.next==null)
            removeLast();

        if(node.prev==null){
            removeFirst();
        }
        if(node.next!=null && node.prev!=null){
            node.prev.next=node.next;
            node.next.prev=node.prev;
            node.next=null;
            node.prev=null;
            size--;
        }
       return temp;
    }
//    j) public int size();
    public int size(){
        return size;
    }
//    k) public String toString();
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DNode p = first;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.dData.toString()+" ");
                p = p.next;
            }
            sb.append(p.dData.toString());
        }
        return sb.toString();
    }
    public static void main(String []args){
      DoubleLinkedList<Integer> dList=new DoubleLinkedList<>();
      dList.addFirst(56);
      dList.addFirst(67);
      dList.addFirst(78);
      dList.addFirst(90);
      //dList.addAfter(dList.getNode(1),56);
      dList.remove(1);

        System.out.println(dList+" ");//67 56 78 90
//      dList.add(2,12);//
//        System.out.println(dList+" ");//67 56 12 78 90
//      dList.add(3,43);
//        System.out.println(dList+" ");//67 56 12 43 78 90
//      dList.remove(1);
//       System.out.println(dList+" ");//67 12 43 78 90
//        System.out.println(dList.get(3)+" ");//78
    }
}
