package numeronTest.java;

import numeron.java.OneGame;
import numeron.java.*;

public class UseNaiveFilteringSolver {

	public static void main(String[] args) {
		OneGame g = new OneGame();
		NaiveFilteringSolver nfs = new NaiveFilteringSolver();
		NVec randomTry;
		boolean isContinue = true;
		int gameCnt = 0;

		System.out.println("----- Game Start -----");
		
		while(isContinue) {
			g.setGameCnt(gameCnt++);
			randomTry = nfs.getRandomTry();
			g.setUserTry(randomTry);
			randomTry.print();
			System.out.println("try space size is " +  nfs.getTrySpaceSize());
			g.showResult();
			nfs.updateTrySpace(randomTry, g.getEat(), g.getBite());
			if (g.isEnd()) {
				isContinue = false;
			}
		}
	
		System.out.println("The games played was " + gameCnt + ".");


	}

}
