package stap2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecursionTest {

	@Test
	void testInvert() {
        Recursion rec = new Recursion();
        String input = "word";
        String expected = "drow";
        String actual = rec.invert(input);
        assertTrue(actual.equals(expected));
	}

	@Test
	void testInvert2() {
        Recursion rec = new Recursion();
        String input = "";
        String expected = "";
        String actual = rec.invert(input);
        assertTrue(actual.equals(expected));
	}

	@Test
	void testInvert3() {
        Recursion rec = new Recursion();
        String input = "a";
        String expected = "a";
        String actual = rec.invert(input);
        assertTrue(actual.equals(expected));
	}

	@Test
	void testInvert4() {
        Recursion rec = new Recursion();
        String input = "ab";
        String expected = "ba";
        String actual = rec.invert(input);
        assertTrue(actual.equals(expected));
	}

	@Test
	void testInvert5() {
        Recursion rec = new Recursion();
        String input = "kak";
        String expected = "kak";
        String actual = rec.invert(input);
        assertTrue(actual.equals(expected));
	}

	@Test
	void testIsPalinDroom() {
        Recursion rec = new Recursion();
        String input = "kak";
        boolean result = rec.isPalinDroom(input);
        boolean expected = true;
        assertEquals(result, expected);
	}

	@Test
	void testIsPalinDroom2() {
        Recursion rec = new Recursion();
        String input = "k";
        boolean result = rec.isPalinDroom(input);
        boolean expected = true;
        assertEquals(result, expected);
	}

	@Test
	void testIsPalinDroom3() {
        Recursion rec = new Recursion();
        String input = "ka";
        boolean result = rec.isPalinDroom(input);
        boolean expected = false;
        assertEquals(result, expected);
	}

	@Test
	void testIsPalinDroom4() {
        Recursion rec = new Recursion();
        String input = "soeplepel";
        boolean result = rec.isPalinDroom(input);
        boolean expected = false;
        assertEquals(result, expected);
	}

	@Test
	void testIsPalinDroom5() {
        Recursion rec = new Recursion();
        String input = "lepel";
        boolean result = rec.isPalinDroom(input);
        boolean expected = true;
        assertEquals(result, expected);
	}


}
