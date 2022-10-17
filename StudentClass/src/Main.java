
public class Main {

	public static void main(String[] args) {
		Student jeff = new Student("Jeff", "Winger", 1);
		Student bob = new Student("Bob", "Kerman", 2);
		Student bill = new Student("Bill", "Kerman", 3);
		
		
		double[] jeffScore = {100, 98, 87.5, 93.7, 75};
		double[] bobScore = {79, 83, 77.5, 75, 93.5};
		double[] billScore = {85, 85, 86, 96, 99.9};
		
		double[][] arr = {jeffScore, bobScore, billScore};
		
		
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) {
				for(double d : arr[i]) {
					jeff.addScore(d);
				}
			}
			else if(i == 1) {
				for(double d : arr[i]) {
					bob.addScore(d);
				}
			}
			else {
				for(double d : arr[i]) {
					bill.addScore(d);
				}
			}
		}
		
		System.out.println(jeff.toString());
		System.out.println(bob.toString());
		System.out.println(bill.toString());
		
		System.out.format("Class average: %.2f %S\n", Student.getTotalScore(), Student.getTotalLetterGrade());
	}

}
