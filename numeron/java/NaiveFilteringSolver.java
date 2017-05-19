package numeron.java;

public class NaiveFilteringSolver {
	private TrySpace trySpace = TrySpace.makeWholeSpace();
	private NVec randomTry = new NVec();
	
	public NVec getRandomTry () {
		randomTry =  trySpace.randomPick();
		return randomTry;
	}
	
	public void updateTrySpace(NVec randomTry, int eat, int bite) {
		trySpace.update(randomTry, eat, bite);
	}
	
	public void updateTrySpace(NVec randomTry, NVec ans) {
		updateTrySpace(randomTry,randomTry.countEat(ans), randomTry.countBite(ans));
	}
	
	public int getTrySpaceSize () {
		return trySpace.size();
	}
}
