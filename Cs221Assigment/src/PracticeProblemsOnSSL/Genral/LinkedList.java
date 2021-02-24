package PracticeProblemsOnSSL.Genral;
import java.util.HashMap;
import java.util.HashSet;
public class LinkedList<E> {

    private Node<E> head;

    private class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }
    private int size(Node<E> head) {
        if (head == null) {
            return 0;
        } else {
            return 1 + size(head.next);
        }
    }

    public int size() {
        return size(head);
    }
    private String toString(Node<E> head) {
        if (head == null) {
            return "";
        } else {
            return head.data + "\n" + toString(head.next);
        }
    }

    @Override
    public String toString() {
        return toString(head);
    }
    private void replace(Node<E> head, E oldObj, E newObj) {
        if (head != null) {
            if (oldObj.equals(head.data)) {
                head.data = newObj;
            }
            replace(head.next, oldObj, newObj);
        }
    }

    public void replace(E oldObj, E newObj) {
        replace(head, oldObj, newObj);
    }

    private void add(Node<E> head, E data) {

        if (head.next == null) {
            head.next = new Node<E>(data);
        } else {
            add(head.next, data);
        }
    }
    public void add(E data) {
        if (head == null) {
            head = new Node<E>(data);
        } else {
            add(head, data);
        }
    }


    private boolean remove(Node<E> head, Node<E> pred, E outData) {
        if (head == null)
        {
            return false;
        } else if (head.data.equals(outData)) {
            pred.next = head.next;
            return true;
        } else {
            return remove(head.next, head, outData);
        }
    }

    public boolean remove(E outData) {
        if (head == null) {
            return false;
        } else if (head.data.equals(outData)) {
            head = head.next;
            return true;
        } else {
            return remove(head.next, head, outData);
        }
    }


    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        LinkedList<E> other = (LinkedList<E>) obj;
        return equals(head, other.head);
    }
    private boolean equals(Node<E> node1, Node<E> node2) {
        if (node1 == null & node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node2 == null) {
            return false;
        }
        if (node1.data.equals(node2.data)) {
            return equals(node1.next, node2.next);
        }
        return false;
    }

    public void insertBefore(E target, E inData) {
        if (head == null) {
            head = new Node<E>(target, null);
            return;
        }
        if (head.data.equals(target)) {
            head = new Node<E>(inData, head);
            return;
        }
        insertBefore(target, inData, head);
    }

    private void insertBefore(E target, E inData, Node<E> node) {
        if (node.next == null) {
            node.next = new Node<E>(inData, null);
            return;
        }
        if (target.equals(node.next.data)) {
            node.next = new Node<E>(inData, node.next);
            return;
        }
        insertBefore(target, inData, node.next);
    }

    LinkedList<E> reverse() {
        LinkedList<E> result = new LinkedList<E>();
        result.head = reverse(head, null);
        return result;
    }


    private Node<E> reverse(Node<E> head, Node<E> newHead) {
        if (head == null) {
            return newHead;
        }
        return reverse(head.next, new Node<E>(head.data, newHead));
    }

    public void insert(E obj, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = new Node<E>(obj, head);
        } else {
            insert(obj, head, index - 1);
        }
    }


    private void insert(E obj, Node<E> pred, int index) {
        if (pred == null) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            pred.next = new Node<E>(obj, pred.next);
        } else {
            insert(obj, pred.next, index - 1);
        }
    }

    public void remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
        } else {
            remove(head, index - 1);
        }
    }

    private void remove(Node<E> pred, int index) {
        if (pred == null) {
            throw new IndexOutOfBoundsException();
        }
        if (pred.next == null) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            pred.next = pred.next.next;
        } else {
            remove(pred.next, index - 1);
        }
    }
    public boolean contains (E target) {
        return contains(head,target);

    }
    private boolean contains(Node temp,E target) {
        if(temp==null)
            return false;
        if(temp.data==target)
            return true;
        return contains(temp.next,target);

    }
    public static void main(String[] args) {
        LinkedList<Integer> values=new LinkedList<Integer>();
        values.add(45);
        values.add(10);
        values.add(67);
        values.add(89);
        values.add(12);
        values.add(53);
        System.out.println(values.contains(53));
        System.out.println(values.contains(40));

    }
}
