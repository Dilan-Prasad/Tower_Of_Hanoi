package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * @author cosinebrosine
 * @version 3/14/18
 * @param <T>
 *            the type of object LinkedStack will hold
 */
public class LinkedStack<T> implements StackInterface<T> {

    private Node<T> topNode;
    private int size;


    /**
     * constructs a linkedStack object
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * an integer representation of the size of the stack
     * 
     * @return size, the number of elements in the stack
     */
    public int size() {
        return size;
    }


    /**
     * returns a String representation of the LinkedStack
     * 
     * @return the string representation
     */
    public String toString() {

        if (size == 0) {
            return "[0]";
        }
        
        String result = "";
        Node<T> current = topNode;

        result += "[";
        while (current != null) {
            result = result + (current.data).toString() + ", ";
            current = current.next;
        }

        result = result.substring(0, result.length() - 2);
        result += "]";
        return result;
    }


    /**
     * clears the stack of all its elements
     */
    @Override
    public void clear() {
        topNode = null;
        size = 0;
    }


    /**
     * tells the user if the stack is empty
     * 
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * returns the top item of the stack without removing it
     * 
     * @return T the top item of the stack
     */
    @Override
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return topNode.data;
    }


    /**
     * returns and removes the top element of the stack
     * 
     * @return T the top element of the stack
     */
    @Override
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        T temp = topNode.data;
        topNode = topNode.next;
        size--;
        return temp;
    }


    /**
     * adds an entry to the top of the stack
     * 
     * @param anEntry
     *            the entry being added
     */
    @Override
    public void push(T anEntry) {

        Node<T> newNode = new Node<T>(anEntry);
        newNode.next = topNode;
        topNode = newNode;
        size++;

    }


    /**
     * 
     * @author cosinebrosine
     * @version 3/18/18
     * @param <T>
     *            the type of object Node will contain
     */
    @SuppressWarnings("hiding")
    class Node<T> {

        private Node<T> next;
        private T data;
        private Node<T> firstNode;


        /**
         * creates a node containing one entry
         * 
         * @param anEntry
         *            the entry contained by the node
         */
        public Node(T anEntry) {
            data = anEntry;
            next = firstNode;
            firstNode = this;
        }

    }
}

