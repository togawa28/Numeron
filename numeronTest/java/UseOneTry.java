package numeronTest.java;

import numeron.java.*;

public class UseOneTry {
	public static void main(String[] args) {
		NVec ans = new NVec("789");
		NVec myTry = new NVec("789");
		
		OneTry ot = new OneTry(myTry, ans);
		System.out.println(ot.getBite());
		System.out.println(ot.getEat());
		System.out.println(ot.isEnd());
		
		ot.showResult();
		
		ot.setUserTry("478");
		ot.showResult();
		ot.showResult();
		ot.setAns(new int[] {8,7,9});
		ot.showResult();
		ot.showResult();
		ot.setUserTry("879");
		ot.showResult();
	}
}
