import java.util.Iterator;

public class SortedList<E extends Comparable<? super E>> extends List<E> {
        
    public void insert(E data) {
        if (head == null || data.compareTo(head.data) < 0) {
            Node<E> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
            return;
        }
        insert(head, data);
    }

    private void insert(Node<E> node, E data) {
        if (node.next == null || data.compareTo(node.next.data) < 0) {
            Node<E> newNode = new Node<>(data);
            newNode.next = node.next;
            node.next = newNode;
            return;
        }
        insert(node.next, data);
    }

    public void remove(E data) {
        if (head == null) 
            return;

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        remove(head, data);
    }

    private void remove(Node<E> node, E data) {
        if (node.next == null) 
            return;
        if (node.next.data.equals(data)) {
            node.next = node.next.next;
            
            return;
        }
        remove(node.next, data);
    }

    public E retrieve(int index) {
        return retrieve(head, index);
    }

    private E retrieve(Node<E> node, int index) {
        if (node == null) 
            return null;
        if (index == 0) 
            return node.data;
        
        return retrieve(node.next, index - 1);
    }

    public boolean search(E data) {
        return search(head, data);
    }

    private boolean search(Node<E> node, E data) {
        if (node == null) 
            return false;
        if (node.data.equals(data))
             return true;
             
        return search(node.next, data);
    }

    public Iterator<E> iterator() {
        return new SortedListIterator();
    }

    private class SortedListIterator implements Iterator<E> {
        private Node<E> current = head;

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
