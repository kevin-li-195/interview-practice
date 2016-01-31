// Question 1: Write code to eliminate duplicates from an unsorted linkedlist.
// Question 1 follow up: How could we solve this problem if a temporary buffer is not allowed?
//
// Question 2: Implement an algorithm to find the kth to last element of a singly linked list.
//
// Question 3: Implement an algorithm to delete a node in the middle of a singly linked list,
// given access to only that node.
//
// Question 4: Write code to partition a linked list around a value x, such that all nodes
// less than x come before all nodes greater than or equal to x.
//
// Question 5: You have two numbers represeted by a linked list. where each node contains a
// single digit. The digits are stored in reverse order, such that the 1's digit is at the
// head of the list. Write a function that adds the two numbers and returns the sum
// as a linked list.
//
// Question 6: Given a circular linked list, implement an algorithm which returns the node
// at the beginning of the loop.
//
// Question 7: Implement a function to check if a linked list is a palindrome.

import java.util.ArrayList;

public class LinkedLists {
    public static class Node {
        Node next;
        int val;

        public Node(int v) {
            val = v;
        }

        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }

        void deleteFromList(int d) {
            Node n = this;
            if (n.val == d) n = n.next;
            while (n.next.val != d) {
                n = n.next;
            }
            n.next = n.next.next;
        }
    }

    static void removeDuplicates(Node head) {
        ArrayList<Integer> arl = new ArrayList();                
        Node n = head;
        while (n.next != null) {
            arl.add(n.val);
            if (arl.indexOf(n.next.val) != (-1)) {
                System.out.println("Found duplicate");
                n.next = n.next.next; 
            }
            if (n.next == null) break;
            n = n.next;
        }
    }

    static void printNodes(Node head) {
        Node n = head;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public static void main(String[] args) {
        Node f = new Node(5);
        Node e = new Node(5);
        Node d = new Node(4);
        Node c = new Node(3);
        Node b = new Node(2);
        Node a = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        printNodes(a);
        removeDuplicates(a);
        printNodes(a);
    }
}
