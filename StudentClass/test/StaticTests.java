import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StaticTests {
	@Test
	void testGetTotalScore() {
		Student jeff = new Student("Jeff", "Winger", 1);
		Student bob = new Student("Bob", "Kerman", 2);
		Student bill = new Student("Bill", "Kerman", 3);
		
		double[] jeffScore = {100, 98, 87.5, 93.7, 75};
		double[] bobScore = {79, 83, 77.5, 75, 93.5};
		double[] billScore = {85, 85, 86, 96, 99.9};
		
		for(int i = 0; i < jeffScore.length; i++) {
			jeff.addScore(jeffScore[i]);
			bob.addScore(bobScore[i]);
			bill.addScore(billScore[i]);
		}
		
		assertEquals(87.6, Student.getTotalScore(), 0.01);
	}

	@Test
	void testGetTotalLetterGrade() {
		Student jeff = new Student("Jeff", "Winger", 1);
		Student bob = new Student("Bob", "Kerman", 2);
		Student bill = new Student("Bill", "Kerman", 3);
		
		double[] jeffScore = {100, 98, 87.5, 93.7, 75};
		double[] bobScore = {79, 83, 77.5, 75, 93.5};
		double[] billScore = {85, 85, 86, 96, 99.9};
		
		for(int i = 0; i < jeffScore.length; i++) {
			jeff.addScore(jeffScore[i]);
			bob.addScore(bobScore[i]);
			bill.addScore(billScore[i]);
		}
		
		assertEquals(Grade.B, Student.getTotalLetterGrade());
	}

}
