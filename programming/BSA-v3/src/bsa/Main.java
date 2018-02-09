package bsa;
/**
 * 
 * @author dominic
 *
 */

public class Main {
	public static Course[] courses;
	public static int maxCourseName;
	public static int totalCredits;
	public static int maxCredits;

	public static void main(String[] args) {
		courses = new Course[] {
			new Course("Project Fasten Your Seatbelts", 12),
			new Course("Programming", 3),
			new Course("Databases", 3),
			new Course("Personal Skills", 2),
			new Course("Project Skills", 2),
		};

		System.out.println("Voer behaalde cijfers in:");
		for (Course course : courses) {
			// Assert longest course getName()
			// Used for padding while printing.
			if (course.getName().length() > maxCourseName) {
				maxCourseName = course.getName().length();
			}
			System.out.print(course.getName() + ":" );
			course.setScore(course.askScore());
		}
		Main.printResults();

	}
	
	public static void printResults() {
		System.out.println("");
		for (Course course : courses) {
			System.out.printf("Vak/Project: %-" + maxCourseName + "s", course.getName());
			System.out.printf(" Cijfer: %.1f", course.getScore());
			System.out.print(" Behaalde punten: ");
			if (course.isPassed()) {
				System.out.printf("%d", course.getCredits());
				totalCredits += course.getCredits();
			} else {
				System.out.print(0);
			}
			System.out.println("");
			maxCredits += course.getCredits();
		}
			double neededCredits = 5.0/6 * maxCredits;
			
			System.out.println("");
			System.out.printf("Totaal behaalde studiepunten %d/%d", totalCredits,
					maxCredits);
			
			if(totalCredits < neededCredits) {
				System.out.println("Pas op je ligt op schema voor een negatief BSA.");
			}
			
	}

}
