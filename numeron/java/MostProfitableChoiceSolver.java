package numeron.java;
import numeron.java.TrySpace;

public class MostProfitableChoiceSolver extends NaiveFilteringSolver {
	public static int score (TrySpace ithTrySpace, NVec t) {
		int score = 0;
		
		for ( NVec s : ithTrySpace) {
			// define tsi, deep copy of ithTrySpace
			// to avoid overwriting ithTrySpace
			TrySpace tsi = new TrySpace(ithTrySpace);
			tsi.update(t, t.countEat(s), t.countBite(s));
			score += tsi.size();
		}
		return score;
	}
	
	private TrySpace mostProfitableTrySpace = new TrySpace();

	private NVec mostProfitableTry;
	
	public NVec generateNextTry () {		
		// TODO how to judge?
		if (mostProfitableTrySpace.size() <= 100 || 
				mostProfitableTrySpace.size() > super.getTrySpaceSize()) {
			System.out.println("picked from try space!");
			this.mostProfitableTry = super.getTrySpace().randomPick();
		} else {
			System.out.println("picked from mp try space!");
			this.mostProfitableTry = mostProfitableTrySpace.randomPick();				
		}
		return this.mostProfitableTry;
	}
	
	public TrySpace getMostProfitableTrySpace() {
		return mostProfitableTrySpace;
	}
	
	public int getMostProfitableTrySpaceSize () {
		return mostProfitableTrySpace.size();
	}
	
	public void updateMostProfitableTrySpace () {
		TrySpace ithTrySpace = super.getTrySpace();
		int minScore = ithTrySpace.size() * ithTrySpace.size();
		
		
		for (NVec t : TrySpace.wholeSpace) {
			int score = score(ithTrySpace, t);
			if (score == minScore) {
				this.mostProfitableTrySpace.add(t);
			} else if (score < minScore) {
				this.mostProfitableTrySpace.clear();
				this.mostProfitableTrySpace.add(t);
				minScore = score;
			}
		}
	}
	
}
