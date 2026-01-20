package com.github.pedrovgs.pair;

import org.junit.Test;

import static org.junit.Assert.*;

public class PairTest {

    @Test
    public void testEqualsSameObject() {
        Pair<Integer, String> pair = new Pair<>(1, "one");
        assertEquals(pair, pair);
    }

    @Test
    public void testEqualsEqualObjects() {
        Pair<Integer, String> p1 = new Pair<>(1, "one");
        Pair<Integer, String> p2 = new Pair<>(1, "one");
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void testNotEqualsDifferentA() {
        Pair<Integer, String> p1 = new Pair<>(1, "one");
        Pair<Integer, String> p2 = new Pair<>(2, "one");
        assertNotEquals(p1, p2);
    }

    @Test
    public void testNotEqualsDifferentB() {
        Pair<Integer, String> p1 = new Pair<>(1, "one");
        Pair<Integer, String> p2 = new Pair<>(1, "two");
        assertNotEquals(p1, p2);
    }

    @Test
    public void testNotEqualsNull() {
        Pair<Integer, String> p1 = new Pair<>(1, "one");
        assertNotEquals(p1, null);
    }

    @Test
    public void testNotEqualsDifferentClass() {
        Pair<Integer, String> p1 = new Pair<>(1, "one");
        String other = "something";
        assertNotEquals(p1, other);
    }

    @Test
    public void testHashCodeConsistency() {
        Pair<Integer, String> pair = new Pair<>(42, "answer");
        int h1 = pair.hashCode();
        int h2 = pair.hashCode();
        assertEquals(h1, h2);
    }
}
