package Assigment5.SLL;

/*<listing chapter="2" section="5">*/


import java.util.Iterator;
import java.util.NoSuchElementException;
public class SingleLinkedList<E> implements Iterable<E>{
    @Override
    public Iterator<E> iterator() {
        return new MyItyerator<E>(head);
    }

    private static class MyItyerator<E> implements Iterator<E> {

        Node<E> current;
        public MyItyerator(Node<E> start) {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E value = current.data;
            current = current.next;
            return value;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

    }
    /*
    * 1. Refer to w1l2.linkedlist.SingleLinkedList class and create
    * a removeAllOf() method using an iterator. This method will take a string
    * ‘target’ and search through the list,
    *  if, and it should remove all occurrences of the given target.*/
    public void  removAllOf(int target){
        Iterator<E> it=this.iterator();
        while (it.hasNext()){
           if(it.next().equals(target));
            it.remove();
        }

    }
    private static class Node<E> {
        private E data;
        private Node<E> next = null;
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this(data, null);
        }
    }

    private Node<E> head = null;
    private int size = 0;
    private void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }

    private E removeFirst() {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
        }
        if (temp != null) {
            size--;
            return temp.data;
        } else { // list is empty
            return null;
        }
    }

    private E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        if (temp != null) {
            node.next = temp.next;
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public boolean addLast(E item) {
        add(size, item);
        return true;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> removedNode = null;
        if (index == 0) {
            return removeFirst();
        } else {
            Node<E> node = getNode(index - 1);
            return removeAfter(node);
        }
    }

    int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }
    public boolean removeItem(E item) {
        if (head == null) {
            return false;
        }
        Node<E> current = head;
        if (item.equals(current.data)) {
            removeFirst();
            return true;
        }
        while (current.next != null) {
            if (item.equals(current.next.data)) {
                removeAfter(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void addBeforeItem(E bitem, E item) {

        if (head == null)
            return;
        if (head.data.equals(bitem)) {
            addFirst(item);
            return;

        }
        Node<E> prev = null;
        Node<E> cur = head;

        while (cur != null && !cur.data.equals(bitem)) {
            prev = cur;
            cur = cur.next;
        }
        // insert between cur and prev
        if (cur != null)
            prev.next = new Node<E>(item, cur);
        size++;

    }

    public void addBeforeIndex(int index, E item) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            head = new Node(item, head);
            size++;
        } else {
            int i = index;
            Node<E> current = head;
            while (current != null && --i > 0) {
                current = current.next;
            }
            if (i == 0) {
                current.next = new Node(item, current.next);
                size++;
            } else {
                throw new IndexOutOfBoundsException(Integer.toString(index));
            }
        }
    }
//
    public static void main(String args[]) {
        SingleLinkedList<Integer> sll = new SingleLinkedList<Integer>();

        sll.addFirst(10);
        sll.addFirst(12);
        sll.addFirst(20);
        sll.addFirst(12);
        sll.addFirst(50);
        sll.addFirst(12);

        Iterator<Integer> it=sll.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("After all 12 value removed from the list");
        sll.removAllOf(12);
        while (it.hasNext()){
            System.out.println(it.next());
        }
//        System.out.println(sll);
//        Node x = sll.getNode(0);
//        sll.addAfter(x, 15);
//        System.out.println(sll + " Size is :" + sll.size());
//        System.out.println("Removed First Item : " + sll.removeFirst());
//        System.out.println(sll + " Size is :" + sll.size());
//        x = sll.getNode(0);
//        sll.removeAfter(x);
//        System.out.println(sll + " Size is :" + sll.size());
//        System.out.println("Value at the index 0 : " + sll.get(0));
//        // Modify the index Zero value as 25
//        sll.set(0, 25);
//        System.out.println(sll + " Size is :" + sll.size());
//        sll.addFirst(30);
//        sll.addFirst(40);
//        sll.addFirst(50);
//        sll.addLast(10);
//        sll.addBeforeIndex(2, 35);
//        sll.addBeforeItem(50,60);
//        sll.addBeforeItem(40,45);
//        System.out.println(sll + " Size is :" + sll.size());
//        System.out.println("Remove value at index 1 : " + sll.remove(1));
//        System.out.println("Remove value 50 : " + sll.removeItem(10));
//        System.out.println(sll + " Size is :" + sll.size());

    }
}
/* </listing> */
