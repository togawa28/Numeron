package numeronTest.java;

import numeron.java.*;

public class HumanPlayable {

	public static void main(String[] args) {
		OneGame g = new OneGame();
		boolean isContinue = true;
		int gameCnt = 0;

		System.out.println("----- Game Start -----");
		
		while(isContinue) {
			gameCnt++;
			g.setGameCnt(gameCnt);
			g.setUserTry();
			g.showResult();
			if (g.isEnd()) {
				isContinue = false;
			}
		}
	
		System.out.println("The games played was " + gameCnt + ".");


	}

}
