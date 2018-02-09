package dit.niet.veranderen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BreukTest {

    private Breuk[][] breuken = new Breuk[5][4];

    public BreukTest(){
        breuken[0][0] = new Breuk(1, 2);
        breuken[0][1] = new Breuk(1, 2);
        breuken[0][2] = new Breuk(1, 1);
        breuken[0][3] = new Breuk(1, 4);

        breuken[1][0] = new Breuk(1, 2);
        breuken[1][1] = new Breuk(1, 6);
        breuken[1][2] = new Breuk(2, 3);
        breuken[1][3] = new Breuk(1, 12);

        breuken[2][0] = new Breuk(3, 4);
        breuken[2][1] = new Breuk(3, 8);
        breuken[2][2] = new Breuk(9, 8);
        breuken[2][3] = new Breuk(9, 32);

        breuken[3][0] = new Breuk(5, 12);
        breuken[3][1] = new Breuk(0, 3);
        breuken[3][2] = new Breuk(5, 12);
        breuken[3][3] = new Breuk(0, 36);

        breuken[4][0] = new Breuk(1, 1);
        breuken[4][1] = new Breuk(3, 7);
        breuken[4][2] = new Breuk(10, 7);
        breuken[4][3] = new Breuk(3, 7);
    }

	@Test
	void testTelop1() {
        Breuk b1 = breuken[0][0];
        Breuk b2 = breuken[0][1];
		try {
			b1.telop(b2);
		} catch (RekenfoutException e) {
			e.printStackTrace();
		}
        Breuk bE = breuken[0][2];
        assertTrue(bE.equals(b1));
	}

	@Test
	void testTelop2() {
        Breuk b1 = breuken[1][0];
        Breuk b2 = breuken[1][1];
		try {
			b1.telop(b2);
		} catch (RekenfoutException e) {
			e.printStackTrace();
		}
        Breuk bE = breuken[1][2];
        assertTrue(bE.equals(b1));
	}

	@Test
	void testTelop3() {
        Breuk b1 = breuken[2][0];
        Breuk b2 = breuken[2][1];
		try {
			b1.telop(b2);
		} catch (RekenfoutException e) {
			e.printStackTrace();
		}
        Breuk bE = breuken[2][2];
        assertTrue(bE.equals(b1));
	}

	@Test
	void testTelop4() {
        Breuk b1 = breuken[3][0];
        Breuk b2 = breuken[3][1];
		try {
			b1.telop(b2);
		} catch (RekenfoutException e) {
			e.printStackTrace();
		}
        Breuk bE = breuken[3][2];
        assertTrue(bE.equals(b1));
	}

	@Test
	void testTelop5() {
        Breuk b1 = breuken[4][0];
        Breuk b2 = breuken[4][1];
		try {
			b1.telop(b2);
		} catch (RekenfoutException e) {
			e.printStackTrace();
		}
        Breuk bE = breuken[4][2];
        assertTrue(bE.equals(b1));
	}

	@Test
	void testVermenigvuldig() {
        Breuk b1 = breuken[0][0];
        Breuk b2 = breuken[0][1];
		try {
			b1.vermenigvuldig(b2);
		} catch (RekenfoutException e) {
			e.printStackTrace();
		}
        Breuk bE = breuken[0][3];
        assertTrue(bE.equals(b1));
	}

}
