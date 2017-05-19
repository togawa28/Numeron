package numeron.java;

import java.util.ArrayList;
import java.util.Collection;

public class NVec extends ArrayList<Integer> {
	// TODO define size?
	private static final long serialVersionUID = 1L;

	public NVec() {
		// TODO what to do?
	}

	public NVec(Collection<? extends Integer> c) {
		super(c);
		// TODO check if $c is valid input
	}
	
	public NVec(int[] vec) {
		super();
		// TODO check if $vec is valid input
		for (int i = 0; i < vec.length; i++) {
			this.add(vec[i]);
		}
	}
	
	public NVec(String strVec) {
		super();
		// TODO check if $strVec is valid input
		for (int i = 0; i < strVec.length(); i++ ) {
			this.add(Integer.parseInt(strVec.substring(i, i+1)));
		}
	}
	
	public int countBite(NVec nv) {
		if (this.isComparable(nv)) {
			int cnt = 0;
			for (int i = 0; i < nv.size(); i++) {
				if ( this.indexOf(nv.get(i)) != -1 ) cnt++;
			}
			return cnt - countEat(nv);
		} else {
			return -1;
		}
	}
	
	public int countEat(NVec nv) {
		if (nv.isComparable(this)) {
			int cnt = 0;
			for (int i = 0; i < this.size(); i++) {
				if (this.get(i).equals(nv.get(i))) cnt++;
			}
			return cnt;			
		} else {
			return -1;
		}
	}
	
	public boolean equals(Object o) {
		boolean out = true;
		if (! this.isComparable(o) ) {
			out = false;
		} else {
			NVec nv = (NVec) o;
			for (int i = 0; i < super.size(); i++) {
				if ( ! ( super.get(i).equals(nv.get(i)) ) ) {
					out = false;
				}
			}
		}
		return out;
	}
	
	public int hashCode() {
		return super.hashCode();
	}
	
	public boolean isComparable(Object o) {
		boolean out = true;
		if ( !( o instanceof NVec) ) {
			out = false; 
		} else {
			NVec oNv = (NVec) o;
			if ( this.size() != oNv.size() ) {
				out = false;
			}
		}
		return out;
	}
	
	public void print() {
		for (int i = 0; i < this.size(); i++) {
			System.out.print(this.get(i));
		}
		System.out.println();
	}
}
