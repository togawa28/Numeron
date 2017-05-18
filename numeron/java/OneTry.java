package numeron.java;

import java.util.Scanner;

public class OneTry {
	private NVec userTry;
	private NVec ans;
	private int eat = 0;
	private int bite = 0;
	private boolean isEnd = false;
	
	
	public OneTry () {
		// TODO valid initialization?
		this(new NVec("012"), new NVec("789"));
	}
	public OneTry (NVec userTry, NVec ans) {
		this.userTry	= userTry;
		this.ans		= ans;
		this.updateResponse();
	}
	
	public NVec getAns() {
		return ans;
	}
	public int getBite() {
		return bite;
	}
	public int getEat() {
		return eat;
	}

	public NVec getUserTry() {
		return userTry;
	}

	public boolean isEnd() {
		return isEnd;
	}
	public void setAns(int[] intAns) {
		NVec ans = new NVec(intAns);
		setAns(ans);
	}
	public void setAns(NVec ans) {
		this.ans = ans;
		updateResponse();
	}
	public void setAns(String strAns) {
		NVec ans = new NVec(strAns);
		setAns(ans);
	}
	public void setUserTry () {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("Input your try: ");
		String strUserTry = scan.nextLine();
		this.userTry = new NVec(strUserTry);
		updateResponse();
	}
	public void setUserTry(int[] intUserTry) {
		NVec userTry = new NVec(intUserTry);
		setUserTry(userTry);
	}
	public void setUserTry(NVec userTry) {
		this.userTry = userTry;
		updateResponse();
	}

	
	public void setUserTry(String strUserTry) {
		NVec userTry = new NVec(strUserTry);
		setUserTry(userTry);
	}
	
	public void showResult() {
		if(this.isEnd) {
			System.out.println("----- YOU WIN !!!! -----");
		} else {
			System.out.println("eat: " + eat + " bite: " + bite);
		}
		
	}
	
	public void updateResponse () {
		this.eat		= this.userTry.countEat(this.ans);
		this.bite		= this.userTry.countBite(this.ans);
		this.isEnd		= ( this.eat == 3);
	}

}
