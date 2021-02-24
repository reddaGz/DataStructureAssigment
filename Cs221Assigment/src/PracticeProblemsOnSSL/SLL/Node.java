package PracticeProblemsOnSSL.SLL;
public  class Node {
    int data;
   Node next = null;
    public Node(int data,  Node next) {
        this.data = data;
        this.next = next;
    }
    public  Node(int data){
        this(data,null);
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "data=" + data +
//                '}';
//    }
    @Override
    public String toString() {
        return   data +" ";

    }
}