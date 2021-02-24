package Assigment4;
/*1. Create a singly linked list for Integer number.
Create a node structure to hold integer value.
 perform the following behaviors.
*/
public class LinkedList {
    private Node head = null;
    private int size = 0;

    private static class Node {
        private int data;
        private Node next = null;
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        public  Node(int data){
            this(data,null);
        }
    }
    //helper method
    private Node getNode(int index) {
        Node node = head;
        if(node==null)
            return null;
        if(node!=null)
         for (int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
    }
    //a.void add( int item) {} - add node in the front
    public void add(int item) {
        head = new Node(item,head);
        size++;
    }
    //b.int size() {} - return the number of nodes in the list
    public int size(){
        return size;
    }
    //c.boolean find(int item) {} - to check the value is in the list or not
   public boolean find(int item){//find by values not the by index
       for(int i=0;i<size;i++){
           if(getNode(i).data==item)
               return true;
       }
           return false;
   }
    //d.int max() – return the greatest integer number in the list
    public int max(){
        int max=getNode(0).data;
        for(int i=0;i<size;i++)
            if(max<getNode(i).data)
                max=getNode(i).data;
            return max;
    }
    //e.int min() – return the smallest integer number in the list
    public int min(){
        int min=getNode(0).data;
        for(int i=0;i<size;i++)
            if(min>getNode(i).data)
                min=getNode(i).data;
        return min;
    }
    public static void main(String []args){

        LinkedList list=new LinkedList();
        list.add(13);
        list.add(80);
        list.add(45);
        list.add(97);
        list.add(65);
        System.out.println(list.find(3));//out put will be false
        System.out.println(list.find(80));//out put will be true
        System.out.println(list.size());//output is 5
        System.out.println(list.max());//output is 97
        System.out.println(list.min());//output is 13
    }
         /* Tested OutPut
           false
            true
            5
            97
            13*/
}

