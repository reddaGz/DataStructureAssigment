package Tree.GeneralTree;
import java.util.ArrayList;
import java.util.List;
public class GenTree<E> {
    private  Node<E> root;
    private int nodeCount;
    private static class Node<E>{
       private E data;
       private List<Node> children;
       private Node<E> parent;

       private Node(E item){
           data=item;
           children=new ArrayList<>();
           parent=null;
       }
    }

   public void addRoot(Node<E> node){
        if(this.nodeCount==0){
            root=node;
            nodeCount++;
        }
   }
   public void addChild(Node<E> parent,Node<E>child){
        parent.children.add(child);
         child.parent=parent;
        nodeCount++;
   }
   public E getParent(Node<E> node){
        return node.parent.data;
   }
   public boolean areSbling(Node<E> node1,Node<E>node2){
        return (node1.parent.equals(node2.parent));
   }
   public void printChild(Node<E> node){
        for(int i=0;i<node.children.size();i++)
            System.out.println(node.children.get(i).data);
   }
   public void printPreOrder(Node<E> node){
        if(node.children.size()==0){
            return;
        }
      else{
          if(node.equals(root)){
              System.out.println(node.data);
          }
            for(int i=0;i<node.children.size();i++){
                System.out.println(""+node.children.get(i).data);
                printPreOrder(node.children.get(i));
            }
          }
    }
    public void printPreDepth(Node<E> node,String s){
        s=s;
        if(node.children.size()==0){
            return;
        }
        else{
            if(node.equals(root)){
                System.out.println(node.data);
            }
            String star=s+"*";
            for(int i=0;i<node.children.size();i++){
                System.out.println(star+node.children.get(i).data);
                printPreDepth(node.children.get(i),s);
            }
        }
    }
    public static void main(String[] args) {

        Node<String> root=new Node<>("A");
        Node<String> nodeB=new Node<>("B");
        Node<String> nodeC=new Node<>("C");
        Node<String> nodeD=new Node<>("D");
        Node<String> nodeE=new Node<>("E");
        Node<String> nodeF=new Node<>("F");
        Node<String> nodeH=new Node<>("H");

        GenTree<String> tree=new GenTree<>();
        tree.addRoot(root);
        tree.addChild(root,nodeB);
        tree.addChild(root,nodeC);
        tree.addChild(root,nodeD);
        tree.addChild(nodeB,nodeF);
        tree.addChild(nodeB,nodeH);
        tree.printPreDepth(root,"");
    }
}
