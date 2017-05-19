package numeron.java;


public class OneGame extends OneTry {
	private int gameCnt = 0;
	
	public OneGame() {
		super();
		this.setAns(TrySpace.wholeSpace.randomPick());
	}
	public int getGameCnt() {
		return gameCnt;
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
