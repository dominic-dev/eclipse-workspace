package main;

public class Student {

	private int studentNr;
	private String lastName;
	private float averageGrade;

    public Student(int studentNr, String lastName, float averageGrade) {
		this.studentNr = studentNr;
		this.lastName = lastName;
		this.averageGrade = averageGrade;
    }

	public void setStudentNr(int studentNr) {
    	this.studentNr = studentNr;
	}

	public int getStudentNr() {
    	return studentNr;
	}

	public void setLastName(String lastName) {
    	this.lastName = lastName;
	}

	public String getLastName() {
    	return lastName;
	}

	public void setAverageGrade(float averageGrade) {
    	this.averageGrade = averageGrade;
	}

	public float getAverageGrade() {
    	return averageGrade;
	}

    @Override
    public String toString(){
        return String.format("%s %d %f", lastName, studentNr, averageGrade);
    }

}
