import java.util.ArrayList;

public class Student {
	private String firstName;
	private String lastName;
	private int ID;
	private ArrayList<Double> testScores;
	private static ArrayList<Student> students = new ArrayList<Student>();
	
	
	public static double getTotalScore() {
		double average = 0;
		
		int numScores = 0;
		
		for(Student student : students) {
			for(double d : student.testScores) {
				average += d;
				numScores++;
			}
		}
		
		average /= numScores;
		
		return average;
	}
	
	public static Grade getTotalLetterGrade() {
		double average = getTotalScore();
		
		if(average < 60) {
			return Grade.F;
		}
		else if(average >= 60 && average < 70) {
			return Grade.D;
		}
		else if(average >= 70 && average < 80) {
			return Grade.C;
		}
		else if(average >= 80 && average < 90) {
			return Grade.B;
		}
		else {
			return Grade.A;
		}
		
	}
	
	Student(String firstName, String lastName, int ID){
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
		
		this.testScores = new ArrayList<Double>();
		
		students.add(this);
	}
	
	public void addScore(double score) {
		
		if(score < 0) {
			score = 0;
		}
		else if(score > 110) {
			score = 110;
		}
		
		testScores.add(score);
	}
	
	public double getScore(int index) {
		return this.testScores.get(index);
	}
	
	
	public Grade getLetterGrade() {
		double grade = this.getAverage();
		
		if(grade < 60) {
			return Grade.F;
		}
		else if(grade >= 60 && grade < 70) {
			return Grade.D;
		}
		else if(grade >= 70 && grade < 80) {
			return Grade.C;
		}
		else if(grade >= 80 && grade < 90) {
			return Grade.B;
		}
		else {
			return Grade.A;
		}
		
	}
	
	public double getAverage() {
		double average = 0;
		for(double i : testScores) {
			average += i;
		}
		
		average /= testScores.size();
		
		return average;
	}
	
	public String getName() {
		return String.format("%s %s", this.firstName, this.lastName);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getID() {
		return ID;
	}

	@Override
	public String toString() {
		return String.format("Student: %s, %-5s ID: %-3d Grade: %S", this.lastName, this.firstName, this.ID, this.getLetterGrade());
	}
	
	
}
