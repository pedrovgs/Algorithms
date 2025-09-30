package com.github.pedrovgs.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListNodeTest {

    @Test
    public void testEqualsSameObject() {
        ListNode<Integer> node = new ListNode<>(1);
        assertEquals(node, node);
    }

    @Test
    public void testEqualsEqualObjects() {
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(1);
        assertEquals(node1, node2);
    }

    @Test
    public void testEqualsWithNextEqual() {
        ListNode<Integer> node1 = new ListNode<>(1);
        node1.setNext(new ListNode<>(2));

        ListNode<Integer> node2 = new ListNode<>(1);
        node2.setNext(new ListNode<>(2));

        assertEquals(node1, node2);
    }

    @Test
    public void testNotEqualsDifferentData() {
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        assertNotEquals(node1, node2);
    }

    @Test
    public void testNotEqualsDifferentNext() {
        ListNode<Integer> node1 = new ListNode<>(1);
        node1.setNext(new ListNode<>(2));

        ListNode<Integer> node2 = new ListNode<>(1);
        node2.setNext(new ListNode<>(3));

        assertNotEquals(node1, node2);
    }

    @Test
    public void testNotEqualsNull() {
        ListNode<Integer> node = new ListNode<>(1);
        assertNotEquals(node, null);
    }

    @Test
    public void testNotEqualsDifferentClass() {
        ListNode<Integer> node = new ListNode<>(1);
        String other = "not a node";
        assertNotEquals(node, other);
    }

    @Test
    public void testHashCodeEqualObjects() {
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(1);
        assertEquals(node1.hashCode(), node2.hashCode());
    }

    @Test
    public void testHashCodeConsistency() {
        ListNode<Integer> node = new ListNode<>(42);
        int h1 = node.hashCode();
        int h2 = node.hashCode();
        assertEquals(h1, h2);
    }

    @Test
    public void testToStringSingleNode() {
        ListNode<Integer> node = new ListNode<>(1);
        String expected = "ListNode{data=1, next=null}";
        assertEquals(expected, node.toString());
    }

    @Test
    public void testToStringTwoNodes() {
        ListNode<Integer> node = new ListNode<>(1);
        node.setNext(new ListNode<>(2));
        String expected = "ListNode{data=1, next=ListNode{data=2, next=null}}";
        assertEquals(expected, node.toString());
    }

    @Test
    public void testToStringChain() {
        ListNode<Integer> node = new ListNode<>(1);
        node.setNext(new ListNode<>(2));
        node.getNext().setNext(new ListNode<>(3));
        String expected = "ListNode{data=1, next=ListNode{data=2, next=ListNode{data=3, next=null}}}";
        assertEquals(expected, node.toString());
    }
}
