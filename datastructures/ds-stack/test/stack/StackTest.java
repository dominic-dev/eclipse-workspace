package stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void testToString() {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        String expected = "[1, 2, 3, null, null, null, null, null, null, null]";
        String actual = stack.toString();
        assertEquals(expected, actual);
	}

	@Test
	void testPush() {
        Stack<Integer> stack = new Stack<>(10);
        int i;
        for (i=1; i <= 10; i++) {
            stack.push(i);
        }

        try {
            stack.push(++i);
            fail("Expected StackFullException");
        } catch(StackFullException e){
        }
	}

	@Test
	void testPeek() {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Integer expected = 3;
        Integer actual = stack.peek();
        actual = stack.peek();
        assertEquals(expected, actual);
	}

	@Test
	void testPop() {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Integer expected = 2;
        Integer actual = stack.pop();
        actual = stack.pop();
        assertEquals(expected, actual);
	}

	@Test
	void testEmpty() {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertFalse(stack.empty());
	}

	@Test
	void testEmpty2() {
        Stack<Integer> stack = new Stack<>(10);
        assertTrue(stack.empty());
	}

	@Test
	void testFull() {
        Stack<Integer> stack = new Stack<>(10);
        for(int i=1; i<=10; i++){
            stack.push(i);
        }
        assertTrue(stack.full());
	}

	@Test
	void testFull2() {
        Stack<Integer> stack = new Stack<>(10);
        assertFalse(stack.full());
	}
}
