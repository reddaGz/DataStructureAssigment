package MockExam.Number1;
    public class DNode<E> {
        public E  dData;
        public DNode<E> next;
        public DNode<E> prev;

        public DNode(E d)
        {
            dData = d;
        }
        @Override
        public String toString() {
            return "DNode{" +
                    "dData=" + dData +
                    '}';
        }
    }

