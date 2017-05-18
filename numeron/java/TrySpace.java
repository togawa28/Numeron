package numeron.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class TrySpace extends HashSet<NVec> {
	// TODO generalization?
	private HashSet<Integer> firstDigitSet	= new HashSet<Integer> ();
	private HashSet<Integer> secondDigitSet	= new HashSet<Integer> ();
	private HashSet<Integer> thirdDigitSet	= new HashSet<Integer> ();
	
	public void updateEachDigitSet() {
		firstDigitSet.clear();
		secondDigitSet.clear();
		thirdDigitSet.clear();
		
		for (NVec nv : this) {
			firstDigitSet.add(nv.get(0));
			secondDigitSet.add(nv.get(1));
			thirdDigitSet.add(nv.get(2));
		}
	}
	
	public TrySpace() {
		// TODO Auto-generated constructor stub
	}

	public TrySpace(Collection<? extends NVec> c) {
		super(c);
		// TODO check valid input?
	}

	public boolean add(NVec nv){
		boolean out = super.add(nv);
		// TODO check valid input; refuse different size for $nv
		return out;
	}
	public boolean add(int[] intNv){
		NVec nv = new NVec(intNv);
		boolean out = add(nv);
		// TODO check valid input; refuse different size for $nv
		return out;
	}
	
	public static TrySpace makeWholeSet(){
		TrySpace wholeSet = new TrySpace();
		
		for ( int i = 0; i <= 9; i++ ) {
			for ( int j = 0; j <= 9; j++ ) {
				for ( int k = 0; k <= 9; k++ ) {
					if ( i != j && i != k && j != k) {
						wholeSet.add(new NVec(new int[] {i, j, k}));						
					}
				}
			}
		}
		return wholeSet;
	}
	
	public void print() {
		for (NVec nv : this) {
			nv.print();
		}
	}
	
	public NVec randomPick () {
		Random rand = new Random();
		int randomIndex = rand.nextInt(this.size());
		int cnt = 0;
		NVec randomNVec = new NVec();
		for (NVec nv : this) {
			if ( cnt == randomIndex ) {
				randomNVec = nv;
				break;
			}
			cnt++;
		}
		return randomNVec;
	}
	
	public void update(NVec nv, int eat, int bite) {
		// TODO check input
		if (eat == 3) {
			this.clear();
			this.add(nv);
		} 
		else if (eat == 0 && bite == 3) {
			this.clear();
			this.add(new int[] {nv.get(1), nv.get(2), nv.get(0)});
			this.add(new int[] {nv.get(2), nv.get(0), nv.get(1)});
		}
		else if (eat == 1 && bite == 2) {
			this.clear();
			// fix one digit and swap other two's
			this.add(new int[] {nv.get(0), nv.get(2), nv.get(1)});
			this.add(new int[] {nv.get(2), nv.get(1), nv.get(0)});
			this.add(new int[] {nv.get(1), nv.get(0), nv.get(2)});
		} 
		else if (eat == 2 && bite == 0) {
			// fix two digits and change another digit
			updateEachDigitSet();
			firstDigitSet.removeAll(nv);
			secondDigitSet.removeAll(nv);
			thirdDigitSet.removeAll(nv);
			this.clear();
			for (int i : thirdDigitSet) {
				this.add(new int[] {nv.get(0), nv.get(1), i});
			}
			for (int i : secondDigitSet) {
				this.add(new int[] {nv.get(0), i, nv.get(2)});
			}
			for (int i : firstDigitSet) {
				this.add(new int[] {i, nv.get(1), nv.get(2)});
			}
		}
		else if (eat == 1 && bite == 1) {
			// fix one digit and swap other two's and change one of them
			updateEachDigitSet();
			this.clear();
			for (int i : thirdDigitSet) {
				this.add(new int[] {nv.get(0), nv.get(2), i});
			}
			for (int i : secondDigitSet) {
				this.add(new int[] {nv.get(0), i, nv.get(2)});
			}
			for (int i : firstDigitSet) {
				this.add(new int[] {i, nv.get(1), nv.get(2)});
			}
			
		}
		 
	}
}
