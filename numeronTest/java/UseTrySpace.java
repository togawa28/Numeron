package numeronTest.java;

import java.util.Random;
import numeron.java.*;

public class UseTrySpace {

	public static void main(String[] args) {
		TrySpace ts = new TrySpace();
		ts.add(new NVec("123"));
		ts.add(new NVec("137"));
		ts.add(new NVec("372"));
		ts.add(new NVec("092"));
		ts.add(new NVec("123"));
		
		ts.print();
		System.out.println("--- ts ----");
		
		TrySpace ts2 = new TrySpace();
		ts2.add(new NVec("123"));
		ts2.add(new NVec("372"));
		ts2.add(new NVec("137"));
		ts2.add(new NVec("123"));
		ts2.add(new NVec("092"));
		
		System.out.println(ts == ts2);
		System.out.println(ts.equals(ts2));

		ts.remove(new NVec("137"));
		ts.remove(new NVec(new int[] {0,9,2}));
		ts.print();
		System.out.println("--- ts ----");

		System.out.println(ts.equals(ts2));
		
		TrySpace ts3 = new TrySpace();
		ts3.add(new NVec("137"));
		ts3.add(new NVec("092"));
		ts3.add(new NVec(new int[] {5,9,2}));
		ts2.removeAll(ts3);
		ts2.print();
		System.out.println("--- ts2 ----");
		System.out.println(ts2.equals(ts));
		
		ts.print();
		System.out.println("-----");
		ts2.print();
		System.out.println("-----");
		ts3.print();
		System.out.println("-----");
		
		TrySpace ts4 = TrySpace.makeWholeSet();
		ts4.print();
		System.out.println("----");
		System.out.println("size:" + ts4.size());
		
		/*
		Random rand = new Random();
		System.out.println(rand.nextInt(ts4.size()));
		System.out.println(rand.nextInt(ts4.size()));
		System.out.println(rand.nextInt(ts4.size()));
		System.out.println(rand.nextInt(ts4.size()));
		
		int randomIndex = rand.nextInt(ts4.size());
		System.out.println("randomIndex:" + randomIndex);
		int cnt = 0;
		NVec randomPickedNVec = new NVec();
		for (NVec nv : ts4) {
			if ( cnt == randomIndex ) {
				randomPickedNVec = nv;
			}
			cnt++;
		}
		randomPickedNVec.print();
		System.out.println("----- random pick experiment -----");
		ts4.randomPick().print();
		ts4.randomPick().print();
		ts4.randomPick().print();
		ts4.randomPick().print();
		*/
		ts4.update(new NVec("789"), 1, 2);
		System.out.println("ts4 candidates printed....");
		ts4.print();
	}

}
