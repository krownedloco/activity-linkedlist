package com.example.linkedlist;

import java.util.StringJoiner;

public class SinglyLinkedList<E> implements LinkedList<E>{

    private Node head;
    private Node tail;


    @Override
    public void addFirst(E element) {

        Node node = new Node(element, head);  // 1 & 2

        if (head == null) {  //3
            head = node;
            tail = node;
        } else {
            head = node;   //3
        }

    }

    @Override
    public void addLast(E element) {

        Node node = new Node(element, null);  // 1

        if (tail == null) {
            tail = node;   //3
            head = tail;   //3
        }else{
            tail.next = node; //2
            tail = node; //3
        }

    }

    @Override
    public E pollFirst() {

        E element;

        if (head == null) {
            element = null;
        } else {

            element = head.element;  //1

            Node next = head.next; // 2
            head.next = null; // 3
            head = next; // 4
        }

        return element;
    }

    @Override
    public E pollLast() {

        E element;  //1

        if(tail == null) {  // no elements
            element = null;
        }else {

            element = tail.element;  // 1

            if (head == tail){   //only one element
                head = null;
                tail = null;
            }else {

                Node current = head;
                Node previous = head;
                while (current.next != null) {  // 2
                    previous = current;
                    current = current.next;
                }
                tail = previous; // 3
                tail.next = null; // 4

            }
        }

        return element;
    }

    @Override
    public E peekFirst() {
        return head.element;
    }

    @Override
    public E peekLast() {
        return tail.element;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        StringJoiner joiner = new StringJoiner(", ");
        Node current = head;

        while(current != null){
            joiner.add(current.element.toString());
            current = current.next;
        }

        builder.append(joiner);
        builder.append("]");

        return builder.toString();
    }

    private class Node {

        Node next;
        E element;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

    }
}
