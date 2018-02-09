import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CircleTest {
	@ParameterizedTest
    @ValueSource(doubles = { 1.0, 2.0, 3.0, 4.0, 5.0 })
	void testCircumference(double radius) {
        Circle c = new Circle(0, 0, radius);
        double actual = c.circumference();
        double expected = 2 * Math.PI * radius;
        assertEquals(expected, actual, 0.001);
	}

	@ParameterizedTest
    @ValueSource(doubles = { 1.0, 2.0, 3.0, 4.0, 5.0 })
    void testArea(double radius) {
        Circle c = new Circle(0, 0, radius);
        double actual = c.area();
        double expected = Math.PI * radius * radius;
        assertEquals(expected, actual, 0.001);
    }

	@ParameterizedTest
    @CsvSource({ "1.0, 2.0", "2.0, 4.0", "3.0, 6.0"})
    void testDiameter(double radius, double expected) {
        Circle c = new Circle(0, 0, radius);
        assertEquals(c.getDiameter(), expected);
    }


}
