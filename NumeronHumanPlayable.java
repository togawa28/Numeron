package la.java;
import java.util.Scanner;
import java.util.Random;

public class NumeronHumanPlayable {
	public static void main(String[] args){
		int gameCnt = 0;
		boolean continueInd = true;
		
		System.out.println("----- Game Start -----");
		NumeronOneGame g = new NumeronOneGame();
		g.generateAns();

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

class NumeronOneGame {
	private static Scanner scan = new Scanner(System.in);
	private static Random rand = new Random();
	
	private int gameCnt;
	private int[] Ans = new int[3];
	int[] userInput = new int[3];
	private int eat = 0;
	private int bite = 0;
	private boolean endInd = false;
		
	/*
	 * generateAns method
	 */
	public void generateAns() {
		Ans[0] = rand.nextInt(9);
		do {
			Ans[1] = rand.nextInt(9);
		} while (Ans[1] == Ans[0]);
		do{
			Ans[2] = rand.nextInt(9);
		} while (Ans[2] == Ans[0] || Ans[2] == Ans[1]);
	}
	
	/*
	 * getter for Ans
	 * keep it only while compiling
	 */
	public void getAns() {
		System.out.println("Ans: " + Ans[0] + Ans[1] + Ans[2]);
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
	
		for( int i = 0; i < this.userInput.length; i++ ) {
			this.userInput[i] = Integer.parseInt(rawInput.substring(i, i+1));
		}
		
	}
	
	public void input (int[] userInput) {
		for (int i = 0; i < this.userInput.length; i++){
			this.userInput[i] = userInput[i];
		}
	}
	
	/*
	 * endInd getter
	 */
	public boolean getEndInd() {
		return this.endInd;
	}
	
	/*
	 * countEat & countBite
	 */
	public static int countEat (int[] Ans, int[] userInput) {
		int eat = 0;
		if (Ans[0] == userInput[0]){
			eat++;
		}
		if (Ans[1] == userInput[1]){
			eat++;
		}
		if (Ans[2] == userInput[2]) {
			eat++;
		}
		return eat;
	}
	
	public static int countBite (int[] Ans, int[] userInput) {
		int bite = 0;
		for (int i = 0; i < userInput.length; i++) {
			for (int j = 0; j < Ans.length; j++) {
				if (userInput[i] == Ans[j]) {
					bite++;
				}
			}
		}
		return bite - countEat(Ans, userInput);
	}

	/*
	 * play method
	 */
	public void play() {
		this.eat = countEat(this.Ans, this.userInput);
		this.bite = countBite(this.Ans, this.userInput);
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
	

}
