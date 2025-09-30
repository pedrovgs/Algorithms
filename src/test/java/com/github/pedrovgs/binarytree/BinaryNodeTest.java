package com.github.pedrovgs.binarytree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryNodeTest {

    @Test
    public void testEqualsSameObject() {
        BinaryNode<Integer> node = new BinaryNode<>(1);
        assertEquals(node, node); // this == o
    }

    @Test
    public void testEqualsEqualObjectsWithoutChildren() {
        BinaryNode<Integer> node1 = new BinaryNode<>(1);
        BinaryNode<Integer> node2 = new BinaryNode<>(1);
        assertEquals(node1, node2);
    }

    @Test
    public void testEqualsEqualObjectsWithChildren() {
        BinaryNode<Integer> node1 = new BinaryNode<>(1);
        node1.setLeft(new BinaryNode<>(2));
        node1.setRight(new BinaryNode<>(3));

        BinaryNode<Integer> node2 = new BinaryNode<>(1);
        node2.setLeft(new BinaryNode<>(2));
        node2.setRight(new BinaryNode<>(3));

        assertEquals(node1, node2);
    }

    @Test
    public void testEqualsNull() {
        BinaryNode<Integer> node = new BinaryNode<>(1);
        assertNotEquals(node, null);
    }

    @Test
    public void testEqualsDifferentClass() {
        BinaryNode<Integer> node = new BinaryNode<>(1);
        String other = "not a node";
        assertNotEquals(node, other);
    }

    @Test
    public void testNotEqualsDifferentData() {
        BinaryNode<Integer> node1 = new BinaryNode<>(1);
        BinaryNode<Integer> node2 = new BinaryNode<>(2);
        assertNotEquals(node1, node2);
    }

    @Test
    public void testNotEqualsDifferentLeft() {
        BinaryNode<Integer> node1 = new BinaryNode<>(1);
        node1.setLeft(new BinaryNode<>(2));

        BinaryNode<Integer> node2 = new BinaryNode<>(1);
        node2.setLeft(new BinaryNode<>(3));

        assertNotEquals(node1, node2);
    }

    @Test
    public void testNotEqualsDifferentRight() {
        BinaryNode<Integer> node1 = new BinaryNode<>(1);
        node1.setRight(new BinaryNode<>(2));

        BinaryNode<Integer> node2 = new BinaryNode<>(1);
        node2.setRight(new BinaryNode<>(3));

        assertNotEquals(node1, node2);
    }

    @Test
    public void testHashCodeEqualObjectsWithoutChildren() {
        BinaryNode<Integer> node1 = new BinaryNode<>(1);
        BinaryNode<Integer> node2 = new BinaryNode<>(1);
        assertEquals(node1.hashCode(), node2.hashCode());
    }

    @Test
    public void testHashCodeEqualObjectsWithChildren() {
        BinaryNode<Integer> node1 = new BinaryNode<>(1);
        node1.setLeft(new BinaryNode<>(2));
        node1.setRight(new BinaryNode<>(3));

        BinaryNode<Integer> node2 = new BinaryNode<>(1);
        node2.setLeft(new BinaryNode<>(2));
        node2.setRight(new BinaryNode<>(3));

        assertEquals(node1.hashCode(), node2.hashCode());
    }

    @Test
    public void testHashCodeConsistency() {
        BinaryNode<Integer> node = new BinaryNode<>(42);
        int h1 = node.hashCode();
        int h2 = node.hashCode();
        assertEquals(h1, h2);
    }

    @Test
    public void testBinaryNodeSetAndGetData() {
        BinaryNode<Integer> node = new BinaryNode<>(1);
        node.setRight(new BinaryNode<>(2));
        node.setLeft(new BinaryNode<>(3));

        assertEquals(1, (int) node.getData());
        assertEquals(2, (int) node.getRight().getData());
        assertEquals(3, (int) node.getLeft().getData());
    }

    @Test
    public void testBinaryNodeToString() {
        BinaryNode<String> node = new BinaryNode<>("Hello World");
        String expected = "BinaryNode{data=Hello World}";
        assertEquals(expected, node.toString());
    }

    @Test
    public void testHasChildren() {
        BinaryNode<Integer> node = new BinaryNode<>(1);
        node.setRight(new BinaryNode<>(2));

        assertTrue(node.hasRight());
        assertFalse(node.hasLeft());
    }
}
