package com.compiler;

public class StackCommands<E>{
    private Node<E> top = null;
    int size = 0; // initializing number of elements in stack

    /**
     * Return true if the stack is empty, false otherwise.
     * 
     * @return
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Node class
     * 
     * @param <E>
     */
    public static class Node<E> {
        public static final boolean isEmpty = false;
        private E data;

        private Node<E> next = null;

        public Node(E data) {
            this.data = data;
        }
    }

    /**
     * Returns the element at the top of the stack
     * 
     * @return
     */
    public E peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return null;
        } else {
            return top.data;
        }
    }

    /**
     * Insert an element at the top of the stack.
     * 
     * @param data
     */
    public void push(E data) {
        Node<E> newNode = new Node<>(data);

        if (top == null) {
            top = newNode;
            size++;
        } else {
            newNode.data = data;
            newNode.next = top;
            top = newNode;
            size++;
        }
    }

    /**
     * Remove the top element from the stack.
     * 
     * @return
     */
    public E pop() {
        if (top == null) {
            System.out.println("The stack is empty");
            return null;
        }
        E popItem = top.data;
        top = top.next;
        size--;
        return popItem;
    }

    /**
     * Prints the elements in the stack
     */
    public void display() {
        if (top == null) {
            System.out.println("The stack is empty");
        } else {
            Node<E> item = top;
            while (item != null) {
                System.out.println(item.data.toString());
                item = item.next;
            }
        }
    }

}
