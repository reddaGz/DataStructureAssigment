package Assigment9;

import Tree.GeneralTree.BinaryTree.SearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree<E extends Comparable<E>> implements SearchTree<E> {
    protected boolean inserted;
    protected E deleteReturn;
     Node<E> root;
     private int index=0;

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

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root.data +
                '}';
    }
//    public int heightOfTree(){//this works only for Full binary tree
//        int h=(int)((Math.log(countNode())/Math.log(2))-1);
//        return h;
 //   }
    public int countNode(){
        int n=countTotalNode(root);
        return n;
    }

         private int countTotalNode(Node<E> localRoot){
                if(localRoot==null)
                    return 0;
                return 1+countTotalNode(localRoot.left)+countTotalNode(localRoot.right);
         }

    public int[] inOrderFlush()
    {
        int []array=new int[countNode()];
        inOrderFlush(array,root);
        index=0;
        return array;
    }
    private void inOrderFlush(int[] arr,Node<E> node) {

        if (node == null) {
            return;
        }

        inOrderFlush( arr,node.left);
        arr[index++]= (Integer) node.data;
        inOrderFlush(arr,node.right);
    }
    int count=0;
    public void countNum(E data){//this is counter
        countNum(root,data);
    }

    private void countNum(Node<E> node,E data) {
        if (node == null) {
            return;
        }
        countNum( node.left,data);
        if(node.data.compareTo(data)>0){
            count++;
        }
        countNum(node.right,data);
    }
    public int[] inOrderFlush1(E data)
    {
         countNum(data);
        int []array=new int[count];
        inOrderFlush1(array,root,data);
        index=0;
        return array;
    }
    private void inOrderFlush1(int[] arr,Node<E> node,E data) {
        if (node == null) {
            return;
        }

        inOrderFlush1( arr,node.left,data);
          if(node.data.compareTo(data)>0){
              arr[index++]= (Integer) node.data;
          }
        inOrderFlush1(arr,node.right,data);
    }
    public List<E> preOrder() {
        List<E>pre=new ArrayList<>();
        preOrder(pre,root);
        return pre;
    }
    private void preOrder(List pre,Node<E> node) {
        if (node == null) {
            return;
        }
        pre.add(node.data);
        preOrder( pre,node.left);
        preOrder(pre,node.right);
    }

    public int countLeaf(){

        return countLeaf(root);
    }
    private int countLeaf(Node<E>node){
        if(node==null)
            return 0;
        if(node.left==null&&node.right==null)
                return 1;
            return countLeaf(node.left) + countLeaf(node.right);
    }


    public List<E> postOrder()
    {
        List<E>post=new ArrayList<>();
        postOrder(post,root);
        return post;
    }
    private void postOrder(List post,Node<E> node) {
        if (node == null) {
            return;
        }
        postOrder( post,node.left);
        postOrder(post,node.right);
        post.add(node.data);
    }
    @Override
    public boolean add(E item) {
        root =add(root, item);
        return inserted;
    }
    private Node<E> add(Node<E>localRoot,E item){//
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
        return  contains(root,target);
    }
    private boolean contains(Node<E>localRoot,E target){
        if(localRoot==null)
            return false;
        if(localRoot.data.compareTo(target)==0)
            return true;
        if(localRoot.data.compareTo(target)>0)
            return contains(localRoot.left,target);
        else
            return contains(localRoot.right,target);
    }


//    public Node<E> findNode(E target) {
//
//        return  findNode(root,target);
//    }
//    private Node<E> findNode(Node<E>localRoot,E target){
//        if(localRoot==null)
//            return null;
//        if(localRoot.data.compareTo(target)==0)
//            return localRoot;
//        if(localRoot.data.compareTo(target)>0)
//            return findNode(localRoot.left,target);
//        else
//            return findNode(localRoot.right,target);
//    }
//
//

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
        if(localRoot==null) {
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
    public E findPredessor(Node<E> parent){
        return findPredessor(root,parent);
    }
    private E findPredessor(Node<E>localRoot,Node<E> parent) {
        if(parent==null)
            return null;
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } else {
            return findPredessor(parent.right);
        }
    }
    public List<E> toList() {
        List<E> result = new ArrayList<E>();
        toList(result, root);
        return result;
    }
    private void toList(List<E> array, Node<E> node) {
        if (node == null) {
            return;
        }
        toList(array, node.left);
        array.add(node.data);
        toList(array, node.right);
    }
    @Override
    public boolean remove(E target) {
        return false;
    }
    public E getRoot(){
        return (E) root.toString();
    }
    public int contOneChild(){

        return contOneChild(root);
    }
    private int contOneChild(Node<E> node){
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
    public int contTwoChild(){
        return contTwoChild(root);
    }
    private int contTwoChild(Node<E> node){
        if(node==null)
            return 0;
        if(node.left!=null && node.right!=null)
            return 1+contTwoChild(node.left)+contTwoChild(node.right);
        return 0;
    }
  public int countInternalNode(){
        //return this.countNode()-this.countLeaf();//optional
     return countInternalNode(root);
  }
  private int countInternalNode(Node<E> localRoot){
        if(localRoot==null)
            return 0;
        if((localRoot.left==null && localRoot.right==null))
            return  countInternalNode(localRoot.left)+countInternalNode(localRoot.right);;
        return 1+countInternalNode(localRoot.left)+countInternalNode(localRoot.right);
  }
  public  E findLargetValue(){//wrapper class
        return findLargetValue(root);
    }
    private E findLargetValue(Node<E> localRoot){
        if(localRoot==null)
            return null;
        if(localRoot.right==null)
            return localRoot.data;
        return findLargetValue(localRoot.right);
    }
    public E findSmallestValue(){
        return findSmallestValue(root);
    }
    private E findSmallestValue(Node<E> localRoot){
        if(localRoot==null)
            return null;
        if(localRoot.left==null)
            return localRoot.data;
        return findSmallestValue(localRoot.left);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(55,45,47,43,54,58,76,71,50,60,68,80,91);
        BinaryTree<Integer> bt=new BinaryTree<>();
        for(int i=0;i<list.size();i++)
            bt.add(list.get(i));
        bt.add(56);

//        System.out.println(bt.getRoot());
//        System.out.println("List of Items in a Sorted Order : " + bt.toList());

//        System.out.println("Deleted : "+bt.delete(36));
//        System.out.println("Deleted : "+bt.delete(59));
//        System.out.println("Root : " + bt.getRoot());
//        System.out.println("List of Items in a Sorted Order : " + bt.toList());
//        System.out.println("Finding of 46 :" + bt.find(46));
//        System.out.println("Finding of 46 :" + bt.contains(46));
//        System.out.println("Finding of 100 :" + bt.find(100));
//        System.out.println("In order Traversal Result : ");

   int n=47;
        System.out.println("Is "+n+" int the list: "+bt.contains(n));
        System.out.println("Given List:"+list);
        System.out.println("Total number of node: "+bt.countNode());
        System.out.println("Internal node: "+bt.countInternalNode());
    //    System.out.println("Height of the tree: "+bt.heightOfTree());
//
        System.out.println("Number of two child: "+bt.contTwoChild());
        System.out.println("Number of one child: "+bt.contOneChild());
        System.out.println("Number of leaf: "+bt.countLeaf());

//
        System.out.println("\n=====================");
        System.out.println("In order List: "+bt.toList());
        System.out.println("The largest values : "+bt.findLargetValue());
        System.out.println("The smallest values : "+bt.findSmallestValue());
//
//
        System.out.println("Pre Order List: "+bt.preOrder());
        System.out.println("Post Order List: "+bt.postOrder());


        System.out.println("Copy to the array in order ");
        int[]result=bt.inOrderFlush();
        for(int i=0;i<result.length;i++)
            System.out.print(result[i]+" ");

        int x=60;
        System.out.println("\nValues greater than "+x+" from the tree ");
        int[]result1=bt.inOrderFlush1(n);
        for(int i=0;i<result1.length;i++)
            System.out.print(result1[i]+" ");
//       bt.postOrder();
//        List<Integer>list1=bt.toList();
//
//        for(int i=0;i<bt.toList().size();i++){
//
//        }
//        Integer n=90;
//        Integer y=93;
//        System.out.println(n.compareTo(y));

    }
}
