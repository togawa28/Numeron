package numeronTest.java;

import numeron.java.MostProfitableChoiceSolver;
import numeron.java.NVec;
import numeron.java.NaiveFilteringSolver;
import numeron.java.OneGame;
import numeron.java.TrySpace;

public class UseMostProfitableChoiceSolver {
	static void myprint(Object m) {
		System.out.println(m);
	}

	public static void main(String[] args) {
		
		
		OneGame g = new OneGame();
		MostProfitableChoiceSolver mpcs = new MostProfitableChoiceSolver();
		NVec nextTry;
		boolean isContinue = true;
		int gameCnt = 0;


		/*
		System.out.println("----- Game Start -----");
		
		while(isContinue) {
			g.setGameCnt(gameCnt++);
			System.out.println("try space size is " +  mpcs.getTrySpaceSize());
			System.out.println("most profitable try space size is " +  
					mpcs.getMostProfitableTrySpaceSize());
			
			if (gameCnt == 1) {
				nextTry = mpcs.getRandomTry();
			} else {
				nextTry = mpcs.generateNextTry();
			}
			
			g.setUserTry(nextTry);
			nextTry.print();
			g.showResult();
			
			mpcs.updateTrySpace(nextTry, g.getEat(), g.getBite());
			mpcs.updateMostProfitableTrySpace();
			if (g.isEnd()) {
				isContinue = false;
			}
		}
	
		System.out.println("The games played was " + gameCnt + ".");
*/
		for ( int eat = 0; eat <= 3; eat++) {
			for ( int bite = 0; bite <= 3 - eat; bite++ ) {
				if (eat == 2 && bite == 1) {
					break;
				} else {
					mpcs = new MostProfitableChoiceSolver();
					myprint("------------------");
					myprint("eat : " + eat + " bite : " + bite);
					myprint("initial TS size:"  + mpcs.getTrySpaceSize());
					myprint("initial MPTS size:"  + mpcs.getMostProfitableTrySpaceSize());
				
					mpcs.updateTrySpace(new NVec("012"), eat, bite);
					mpcs.updateMostProfitableTrySpace();
					
					myprint("------------------");
					
					myprint("updated TS size : "  + mpcs.getTrySpaceSize());
					myprint("updated MPTS size : "  + mpcs.getMostProfitableTrySpaceSize());
					myprint( "are they same? : "  + mpcs.getMostProfitableTrySpace().equals(mpcs.getTrySpace()) );
					boolean isSub = false;
					
					if (mpcs.getTrySpaceSize() > mpcs.getMostProfitableTrySpaceSize()) {
						isSub = mpcs.getTrySpace().containsAll(mpcs.getMostProfitableTrySpace());
					} else if (mpcs.getTrySpaceSize() < mpcs.getMostProfitableTrySpaceSize()) {
						isSub = mpcs.getMostProfitableTrySpace().containsAll(mpcs.getTrySpace());
					}
					myprint("is one containted in anotehr? : " + isSub);
				}
			}
		}

		
		/*
		
		NVec ans = new NVec("012");
		NVec myTry = new NVec("260");
		
		System.out.println(ts.size());
				
		NVec myTry2 = new NVec("789");

		int score = 0;
		
		for ( NVec s : ts) {
			// define tsi, deep copy of ithTrySpace
			// to avoid overwriting ithTrySpace
			TrySpace tsi = new TrySpace(ts);
			tsi.update(myTry2, myTry2.countEat(s), myTry2.countBite(s));
			score += tsi.size();
		}

		myprint(score/ts.size());
		
		myprint(MostProfitableChoiceSolver.score(ts, myTry2) / ts.size());
		myprint("-----");
		
		for (NVec t : ts) {
			myprint(MostProfitableChoiceSolver.score(ts, t) / ts.size());
		}
		*/
		/* 
		*/

	}

}
