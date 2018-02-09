package dit.niet.veranderen;

import static org.junit.Assert.*;

import org.junit.Test;

public class BreukTest {

	@Test
	public void testTelop1() {
		Breuk a = new Breuk(1, 2);
		Breuk b = new Breuk(1, 2);
		try {
			a.telop(b);
			Breuk expected = new Breuk(1, 1);
			assertEquals(expected, a);
		} catch (RekenfoutException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTelop2() {
		Breuk a = new Breuk(1, 2);
		Breuk b = new Breuk(1, 6);
		try {
			a.telop(b);
			Breuk expected = new Breuk(2, 3);
			assertEquals(expected, a);
		} catch (RekenfoutException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testVermenigvuldig() {
		Breuk a = new Breuk(1, 2);
		Breuk b = new Breuk(1, 2);
		try {
			a.vermenigvuldig(b);
			Breuk expected = new Breuk(1, 4);
			assertEquals(expected, a);
		} catch (RekenfoutException e) {
			e.printStackTrace();
		}
	}

}
