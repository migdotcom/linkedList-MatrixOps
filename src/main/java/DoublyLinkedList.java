import java.io.*;

public class DoublyLinkedList<E> {

     class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }



    public int size() {
        return size;
    }

    private Node<E> header;
    private Node<E> tail;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        tail = new Node<>(null, header, null);
        header.setNext(tail);
    }



    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getPrev().getElement();
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, tail.getPrev(), tail);
    }

    public static void answer(String output, String content) throws IOException {
        FileWriter writer = new FileWriter(output);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(content);
        bufferedWriter.close();

    }


    public static void read(String input, DoublyLinkedList listToRead) throws IOException {
        FileReader reader = new FileReader(input);
        BufferedReader bufferedReader = new BufferedReader(reader);
        while ((input = bufferedReader.readLine()) != null) {
            String[] row = input.split(" ");
            for (String tmpWord : row) {
                listToRead.addLast(Integer.parseInt(tmpWord));
                System.out.println(tmpWord);
            }
        }
    }


    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }


    public static void main(String[] args) throws IOException {
        DoublyLinkedList list =new DoublyLinkedList();
        String input="/Users/migdotcom/IdeaProjects/HW2/src/test/resources/sample_input_output/1_a.txt";
        list.read(input, list);
        System.out.println(list.size());;

    }
}
