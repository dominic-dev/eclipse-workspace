package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaarTest {

	@Test
	void testGelijkeLengte1() {
        Paar<Double, Integer> paar = new Paar<>(10.0, 1234);
        System.out.println(paar.gelijkeLengte());
        assertTrue(paar.gelijkeLengte());
	}

	@Test
	void testGelijkeLengte2() {
        Paar<Double, String> paar = new Paar<>(3.1415, "cirkel");
        assertTrue(paar.gelijkeLengte());
	}

	@Test
	void testGelijkeLengte3() {
        Paar<Integer, String> paar = new Paar<>(12, "taalf");
        assertFalse(paar.gelijkeLengte());
	}

}
