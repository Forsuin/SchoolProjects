import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {
	private Student test;
	
	
	@BeforeEach
	void setUp() throws Exception {
		test = new Student("firstName", "lastName", 1);
	}

	@Test
	void addScoreNormal() {
		test.addScore(85);
		
		assertEquals(85.0, test.getScore(0), 0.001);
	}
	
	@Test
	void addScoreLow() {
		test.addScore(0);
		
		assertEquals(0, test.getScore(0), 0.001);
	}
	
	@Test
	void addScoreNegative() {
		test.addScore(-10);
		
		assertEquals(0, test.getScore(0), 0.001);
	}
	
	@Test
	void addScoreHigh() {
		test.addScore(120);
		
		assertEquals(110, test.getScore(0), 0.001);
	}
	
	@Test
	void getLetterGradeA() {
		test.addScore(110);
		
		assertEquals(Grade.A, test.getLetterGrade());
	}
	
	@Test
	void getLetterGradeB() {
		test.addScore(85);
		
		assertEquals(Grade.B, test.getLetterGrade());
	}
	
	@Test
	void getLetterGradeC() {
		test.addScore(73);
		
		assertEquals(Grade.C, test.getLetterGrade());
	}
	
	@Test
	void getLetterGradeD() {
		test.addScore(68);
		
		assertEquals(Grade.D, test.getLetterGrade());
	}
	
	@Test
	void getLetterGradeF() {
		test.addScore(50);
		
		assertEquals(Grade.F, test.getLetterGrade());
	}

	@Test
	void getName() {
		assertEquals("firstName lastName", test.getName());
	}
	
	@Test
	void getFirstName() {
		assertEquals("firstName", test.getFirstName());
	}
	
	@Test
	void getLastName() {
		assertEquals("lastName", test.getLastName());
	}
	
	@Test
	void getID() {
		assertEquals(1, test.getID());
	}

}
