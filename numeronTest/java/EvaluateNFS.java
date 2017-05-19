package numeronTest.java;

import java.util.HashSet;
import java.util.Set;


import numeron.java.NVec;
import numeron.java.NaiveFilteringSolver;
import numeron.java.OneGame;

public class EvaluateNFS {

	public static void main(String[] args) {
		int M = 10000;
		int[] result = new int[M];
		
		long start = System.currentTimeMillis();

		for (int i = 0; i < M; i++) {
			OneGame g = new OneGame();
			NaiveFilteringSolver nfs = new NaiveFilteringSolver();
			NVec randomTry;
			boolean isContinue = true;
			int gameCnt = 0;

			while(isContinue) {
				g.setGameCnt(gameCnt++);
				randomTry = nfs.getRandomTry();
				g.setUserTry(randomTry);
				nfs.updateTrySpace(randomTry, g.getEat(), g.getBite());
				if (g.isEnd()) {
					isContinue = false;
				}
			}
		
			result[i] = gameCnt;
		}
		
		Set<Integer> resultSupport = new HashSet<Integer>();
		for (int i : result) {
			resultSupport.add(i);
		}
		
		System.out.println("Naive Filtering Solver");
		System.out.println("を１万回　実行して見た");
		for (int s : resultSupport) {
			int cnt = 0;
			for (int r : result) {
				if (r == s) cnt++;
			}
			System.out.println(s + "回で正解:" + (double) cnt/M * 100 + "%"); 
		}
		
		long end = System.currentTimeMillis();
		System.out.println("かかった時間 : " + (end - start)  + "ms");

	}
}
