package Tree.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class QuizeTree {
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


}
