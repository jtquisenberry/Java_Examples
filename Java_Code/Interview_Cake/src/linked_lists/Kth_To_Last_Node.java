package linked_lists;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

// https://www.interviewcake.com/question/java/kth-to-last-node-in-singly-linked-list?section=linked-lists&course=fc1

// Find the kth to last node in a linked list.

import static org.junit.Assert.*;

public class Kth_To_Last_Node {

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) {

        // return the kth to last node in the linked list
        if (k < 1)
        {
            throw new IllegalArgumentException("");
        }
        
        
        int length = 1;
        
        LinkedListNode right_node = head;
        while (right_node.next != null)
        {
            right_node = right_node.next;
            length += 1;
        }
        
        
        if (k > length)
        {
            throw new IllegalArgumentException("");
        }
        
        
        LinkedListNode left_node = head;
        {
            for (int i = 0; i < length - k; i++)
            {
                left_node = left_node.next;    
            }
        }
        
        return left_node;
        
        
    }


    // tests

    @Test
    public void firstToLastNodeTest() {
        final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        final int k = 1;
        final LinkedListNode actual = kthToLastNode(k, listNodes[0]);
        final LinkedListNode expected = listNodes[listNodes.length - k];
        assertSame(expected, actual);
    }

    @Test
    public void secondToLastNodeTest() {
        final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        final int k = 2;
        final LinkedListNode actual = kthToLastNode(k, listNodes[0]);
        final LinkedListNode expected = listNodes[listNodes.length - k];
        assertSame(expected, actual);
    }

    @Test
    public void firstNodeTest() {
        final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        final int k = 4;
        final LinkedListNode actual = kthToLastNode(k, listNodes[0]);
        final LinkedListNode expected = listNodes[listNodes.length - k];
        assertSame(expected, actual);
    }

    @Test(expected = Exception.class)
    public void kIsGreaterThanLinkedListLengthTest() {
        final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        final int k = 5;
        kthToLastNode(k, listNodes[0]);
    }

    @Test(expected = Exception.class)
    public void kIsZeroTest() {
        final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        final int k = 0;
        kthToLastNode(k, listNodes[0]);
    }

    private static LinkedListNode[] valuesToLinkedListNodes(int[] values) {
        final LinkedListNode[] nodes = new LinkedListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new LinkedListNode(values[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i]; 
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Kth_To_Last_Node.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}