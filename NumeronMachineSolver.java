package la.java;
import java.util.Random;

public class NumeronMachineSolver {
	public static void main(String[] args) {
		int gameCnt = 0;
		boolean continueInd = true;
		int[] machineInput = new int[3];

		System.out.println("----- Game Start -----");
		NumeronOneGame g = new NumeronOneGame();
		g.generateAns();

		while(continueInd) {
			gameCnt++;
			g.setGameCnt(gameCnt);
			machineInput = NumeronRandomSolver.generateInput();
			g.input(machineInput);
			g.play();
			g.showResult();
			if (g.getEndInd()) {
				continueInd = false;
			}
		}
				
	
		System.out.println("The games played was " + gameCnt + ".");

	}

}

class NumeronRandomSolver {
	private static Random rand = new Random();

	public static int[] generateInput() {
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