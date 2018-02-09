package stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {

	@Test
	void testToString() {
        Queue<Integer> stack = new Queue<>(10);
        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        String expected = "[1, 2, 3, null, null, null, null, null, null, null]";
        String actual = stack.toString();
        assertEquals(expected, actual);
	}

	@Test
	void testPush() {
        Queue<Integer> stack = new Queue<>(10);
        int i;
        for (i=1; i <= 10; i++) {
            stack.offer(i);
        }

        assertFalse(stack.offer(++i));
	}

	@Test
	void testPeek() {
        Queue<Integer> stack = new Queue<>(10);
        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        Integer expected = 1;
        Integer actual = stack.peek();
        actual = stack.peek();
        assertEquals(expected, actual);
	}

	@Test
	void testPoll() {
        Queue<Integer> stack = new Queue<>(10);
        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        stack.offer(4);
        Integer expected = 2;
        Integer actual = stack.poll();
        actual = stack.poll();
        assertEquals(expected, actual);
	}

	@Test
	void testEmpty() {
        Queue<Integer> stack = new Queue<>(10);
        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        assertFalse(stack.empty());
	}

	@Test
	void testEmpty2() {
        Queue<Integer> stack = new Queue<>(10);
        assertTrue(stack.empty());
	}

	@Test
	void testFull() {
        Queue<Integer> stack = new Queue<>(10);
        for(int i=1; i<=10; i++){
            stack.offer(i);
        }
        assertTrue(stack.full());
	}

	@Test
	void testFull2() {
        Queue<Integer> stack = new Queue<>(10);
        assertFalse(stack.full());
	}

	@Test
	void testInteg() {
        Queue<Integer> stack = new Queue<>(10);
        for(int i=1; i<=10; i++){
            stack.offer(i);
        }
        stack.poll();
        stack.poll();
        stack.poll();
        stack.offer(11);
        stack.offer(12);
        stack.offer(13);
        Integer expected = 4;
        Integer actual = stack.peek();
        actual = stack.peek();
        assertEquals(expected, actual);
        assertTrue(stack.full());
        assertFalse(stack.empty());
	}
}
