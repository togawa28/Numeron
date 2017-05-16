package la.java;


public class NumeronMachineSolver {
	public static void main(String[] args) {
		int gameCnt = 0;
		boolean continueInd = true;
		NumeronVec machineInput;

		System.out.println("----- Game Start -----");
		NumeronOneGame g = new NumeronOneGame();
		// NumeronRandomSolver s = new NumeronRandomSolver();
		NumeronNaiveFilteringSolver nfs = new NumeronNaiveFilteringSolver();
		
		// TODO think how we can compare two solvers.
		/*
		while(continueInd) {
			gameCnt++;
			g.setGameCnt(gameCnt);
			machineInput = s.generateInput();
			g.input(machineInput);
			g.play();
			g.showResult();
			if (g.getEndInd()) {
				continueInd = false;
			}
		}
				
		System.out.println("The games played was " + gameCnt + ".");
		*/

		while(continueInd) {
			gameCnt++;
			g.setGameCnt(gameCnt);
			machineInput = nfs.generateInput();
			g.input(machineInput);
			g.play();
			g.showResult();
			nfs.updateTrySpace(machineInput, g.getResponse());
			if (g.getEndInd()) {
				continueInd = false;
			}
		}
				
	
		System.out.println("The games played was " + gameCnt + ".");

	}

}