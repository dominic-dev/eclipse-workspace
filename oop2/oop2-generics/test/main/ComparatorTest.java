package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class ComparatorTest {
    private static Student student1 = new Student(1, "D", 5f);
    private static Student student2 = new Student(2, "E", 8f);
    private static Student student3 = new Student(3, "I", 3f);
    private static Student student4 = new Student(4, "G", 10f);
    private static Student[] studenten = {
        student2,
        student4,
        student1,
        student3
    };

	@Test
	void testStudentNr() {
        List<Student> studentenList = Arrays.asList(studenten);
        Collections.sort(studentenList, new StudentNrComparator());
        List<Student> studentenExpected = Arrays.asList(new Student[] {
            student1,
            student2,
            student3,
            student4
        });
        Main.printStudenten(studentenList);
        Main.printStudenten(studentenExpected);
        assertTrue(Arrays.equals(studentenList.toArray(), studentenExpected.toArray()));
	}


	@Test
	void testLastName() {
        List<Student> studentenList = Arrays.asList(studenten);
        Collections.sort(studentenList, new LastNameComparator());
        List<Student> studentenExpected = Arrays.asList(new Student[] {
            student3,
            student4,
            student2,
            student1
        });
        Main.printStudenten(studentenList);
        Main.printStudenten(studentenExpected);
        assertTrue(Arrays.equals(studentenList.toArray(), studentenExpected.toArray()));
	}

	@Test
	void testAverageGrade() {
        List<Student> studentenList = Arrays.asList(studenten);
        Collections.sort(studentenList, new AverageGradeComparator());
        List<Student> studentenExpected = Arrays.asList(new Student[] {
            student3,
            student1,
            student2,
            student4
        });
        Main.printStudenten(studentenList);
        Main.printStudenten(studentenExpected);
        assertTrue(Arrays.equals(studentenList.toArray(), studentenExpected.toArray()));
	}

	@Test
	void testAverageGradeFalse() {
        List<Student> studentenList = Arrays.asList(studenten);
        Collections.sort(studentenList, new AverageGradeComparator());
        List<Student> studentenExpected = Arrays.asList(new Student[] {
            student3,
            student4,
            student1,
            student2
        });
        Main.printStudenten(studentenList);
        Main.printStudenten(studentenExpected);
        assertFalse(Arrays.equals(studentenList.toArray(), studentenExpected.toArray()));
	}

}
