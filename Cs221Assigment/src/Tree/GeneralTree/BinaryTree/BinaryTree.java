package Tree.GeneralTree.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree<E extends Comparable<E>>
        implements SearchTree<E> {
    protected boolean inserted;
    protected E deleteReturn;
     Node<E> root;

    public BinaryTree() {
        this.root =null;
    }

    private static class Node<E>{
        E data;
        private Node<E> left;
        private Node<E> right;
        public Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(E data) {
            this(data,null,null);
        }
        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void inOrder()
    {
        inOrder(root);
    }
    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrder( node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }
    @Override
    public boolean add(E item) {
        root =add(root, item);
        return inserted;
    }
    public Node<E> add(Node<E>localRoot,E item){
        if (localRoot == null) {
            inserted = true;
            return new Node<E>(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            inserted = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    @Override
    public boolean contains(E target) {
        return false;
    }

    @Override
    public E find(E target) {
        return find(root,target);//find(root,target);
    }
    public E find(Node<E>localRoot,E target){
        if (localRoot == null) {
            return null;
        }
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0) {
            return localRoot.data;
        } else if (compResult < 0) {
            return find(localRoot.left, target);
        } else {
            return find(localRoot.right, target);
        }
    }

    @Override
    public E delete(E target) {
        root = delete(root, target);
        return deleteReturn;
    }

    private Node<E> delete(Node<E> localRoot, E item) {
        if (localRoot == null) {
            deleteReturn = null;
            return localRoot;
        }
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                return localRoot.right;
            } else if (localRoot.right == null) {
                return localRoot.left;
            } else {
                if (localRoot.left.right == null) {
                    localRoot.data = localRoot.left.data;
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    localRoot.data = findPredessor(localRoot.left);
                    return localRoot;
                }
            }
        }
    }
    private E findPredessor(Node<E> parent) {
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } else {
            return findPredessor(parent.right);
        }
    }
//    private E findSuccessor(Node<E> parent) {
//        if (parent.left.left == null) {
//            E returnValue = parent.left.data;
//            parent.left = parent.left.right;
//            return returnValue;
//        } else {
//            return findSuccessor(parent.left);
//        }
//    }


    public List<E> toList() {
        List<E> result = new ArrayList<E>();
        toList(result, root);
        return result;
    }
    private void toList(List<E> result, Node<E> node) {
        if (node == null) {
            return;
        }
        toList(result, node.left);
        result.add(node.data);
        toList(result, node.right);
    }
    @Override
    public boolean remove(E target) {
        return false;
    }
    public E getRoot(){
        return (E) root.toString();
    }
    public int contTwoChild(){
        return contTwoChild(root);
    }
    private int contTwoChild(Node <E> node){
        if(node==null)
            return 0;
        if(node.left!=null && node.right!=null)
            return 1+contTwoChild(node.left)+contTwoChild(node.right);
        return 0;
    }
    public int contOneChild(){
        return contOneChild(root);
    }
    private int contOneChild(Node <E> node){
        if(node==null)
            return 0;
        if(node.left!=null){
            if(node.right==null)
                return 1+contOneChild(node.left);
        }
        if(node.right!=null){
            if(node.left==null)
                return 1+contOneChild(node.right);
        }
            return contOneChild(node.left)+contOneChild(node.right);
    }
//    public int countInternalNode(Node<E> localRoot){
//        if(localRoot==null)
//            return 0;
//        if(localRoot.left!=null||localRoot.right!=null)
//            return 1;
//        if(localRoot.left==null)
//          return countInternalNode(localRoot.right);
//        if(localRoot.right==null)
//            return countInternalNode(localRoot.left);
//
//    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(56,46,36,66,50, 32,60, 70, 55, 59,72,69);
        BinaryTree<Integer> bt=new BinaryTree<>();
        for(int i=0;i<list.size();i++)
            bt.add(list.get(i));


        System.out.println(bt.getRoot());
        System.out.println("List of Items in a Sorted Order : " + bt.toList());


        System.out.println("Deleted : "+bt.delete(36));
        System.out.println("Deleted : "+bt.delete(59));
        System.out.println("Root : " + bt.getRoot());
        System.out.println("List of Items in a Sorted Order : " + bt.toList());
        System.out.println("Finding of 46 :" + bt.find(46));
        System.out.println("Finding of 46 :" + bt.contains(46));
        System.out.println("Finding of 100 :" + bt.find(100));
        System.out.println("In order Traversal Result : ");
        bt.inOrder();
        System.out.println("number of one child: "+bt.contOneChild());
        System.out.println("number of two child: "+bt.contTwoChild());
    }
}
