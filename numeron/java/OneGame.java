package numeron.java;


public class OneGame extends OneTry {
	private static final TrySpace wholeSpace = TrySpace.makeWholeSet();
	private int gameCnt = 0;
	private TrySpace nextTrySpace = TrySpace.makeWholeSet();
	
	public OneGame() {
		super();
		this.setAns(wholeSpace.randomPick());
	}
	public int getGameCnt() {
		return gameCnt;
	}
	
	public TrySpace getNextTrySpace() {
		return nextTrySpace;
	}
	public void setGameCnt(int gameCnt) {
		this.gameCnt = gameCnt;
	}

	/**
	 * showResult method
	 */
	public void showResult() {
		if(this.isEnd()) {
			System.out.println("----- YOU WIN !!!! -----");
			System.out.println("----- Game End -----");
		} else {
			System.out.println("----- Game Count: " + this.gameCnt + "-----");
			System.out.println("eat: " + this.getEat() + " bite: " + this.getBite());
			System.out.println();
		}
		
	}
	
	
}
