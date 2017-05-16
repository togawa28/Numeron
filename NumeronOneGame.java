package la.java;
import java.util.Random;
import java.util.Scanner;

class NumeronOneGame {
	private static Scanner scan = new Scanner(System.in);
	private static Random rand = new Random();
	
	private int gameCnt;
	private NumeronVec ans;
	NumeronVec userInput;
	// TODO re-design t if using TreeSet at TrySpace.java 
	// should return t.getSize() and t.getSpace()[i] correctly
	private static final TrySpace t = new TrySpace(); // initialize it
	private int eat = 0;
	private int bite = 0;
	private boolean endInd = false;
	
	public NumeronOneGame () {
		generateAns();
	}
	
	/*
	 * generateAns method
	 */
	public void generateAns() {
		int size = t.getSize();
		int i = rand.nextInt(size);
		NumeronVec ans = t.getSpace()[i];
		this.ans = ans;
	}
	
	/*
	 * getter for Ans
	 * keep it only while compiling
	 */ 
	public void getAns() {
		System.out.println("Ans: " + ans.getVec(0) + ans.getVec(1) + ans.getVec(2));
	}
	
	/*
	 * setter for gameCnt
	 */
	public void setGameCnt (int gameCnt) {
		this.gameCnt = gameCnt;
	}
	
	/*
	 * input methods (with override)
	 */
	public void input () {
		getAns();
		System.out.print("Input your try: ");
		String rawInput = scan.nextLine();
		int[] intInput = new int[this.ans.getSize()];
		
		for( int i = 0; i < intInput.length; i++ ) {
			intInput[i] = Integer.parseInt(rawInput.substring(i, i+1));
		}
		userInput = new NumeronVec(intInput);
	}
	
	public void input (NumeronVec userInput) {
		this.userInput = new NumeronVec(userInput);
	}
	public void input (int[] intInput) {
		this.userInput = new NumeronVec(intInput);
	}

	/*
	 * endInd getter
	 */
	public boolean getEndInd() {
		return this.endInd;
	}
	


	/*
	 * play method
	 */
	public void play() {
		this.eat = NumeronCalc.countEat( this.userInput, this.ans);
		this.bite = NumeronCalc.countBite(this.userInput, this.ans);
		if (this.eat == 3) {
			this.endInd = true;
		}
	}
	

	/**
	 * showResult method
	 */
	public void showResult() {
		if(this.endInd) {
			System.out.println("----- YOU WIN !!!! -----");
			System.out.println("----- Game End -----");
		} else {
			System.out.println("----- Game Count: " + this.gameCnt + "-----");
			System.out.println("eat: " + eat + " bite: " + bite);
			System.out.println();
		}
		
	}
	
	/*
	 * getter for response
	 */
	public int[] getResponse() {
		return new int[] {eat, bite};
	}

}
