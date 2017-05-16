package la.java;
import java.util.Random;

class NumeronRandomSolver {
	private static Random rand = new Random();
	
	public int[] generateInput() {
		
		int[] Input = new int[3];
		Input[0] = rand.nextInt(9);
		do {
			Input[1] = rand.nextInt(9);
		} while (Input[1] == Input[0]);
		do{
			Input[2] = rand.nextInt(9);
		} while (Input[2] == Input[0] || Input[2] == Input[1]);
		return Input;
	}
}
