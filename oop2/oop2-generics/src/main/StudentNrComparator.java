package main;

import java.util.Comparator;

public class StudentNrComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
        return o1.getStudentNr() - o2.getStudentNr();
	}
}
