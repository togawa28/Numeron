package numeronTest.java;

import numeron.java.NVec;

public class UseNVec {
	public static void main(String[] args) {
		NVec nv = new NVec("012");
		NVec nv2 = new NVec(new int[] {0,1,2});
		NVec nv3 = new NVec(new int[] {1,2,3});
		NVec nv4 = new NVec("123");
		nv.print();
		nv2.print();
		nv3.print();
		nv4.print();
		
		System.out.println(nv == nv2);
		System.out.println(nv.equals(nv2));
		System.out.println(nv.equals(nv3));
		System.out.println(nv3.equals(nv4));
		
		System.out.println(nv.hashCode());
		System.out.println(nv2.hashCode());
		System.out.println(nv3.hashCode());
		System.out.println(nv4.hashCode());

		System.out.println(nv.countBite(nv2));
		System.out.println(nv.countEat(nv2));
		
		System.out.println(nv.countBite(nv3));
		System.out.println(nv.countEat(nv3));
		
	
	}
}
