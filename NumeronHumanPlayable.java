package la.java;

public class NumeronHumanPlayable {
	public static void main(String[] args){
		int gameCnt = 0;
		boolean continueInd = true;
		
		System.out.println("----- Game Start -----");
		NumeronOneGame g = new NumeronOneGame();

		while(continueInd) {
			gameCnt++;
			g.setGameCnt(gameCnt);
			g.input();
			g.play();
			g.showResult();
			if (g.getEndInd()) {
				continueInd = false;
			}
		}
				
	
		System.out.println("The games played was " + gameCnt + ".");
	}
		
}

