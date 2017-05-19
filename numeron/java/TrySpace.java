package numeron.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class TrySpace extends HashSet<NVec> {
	private static final long serialVersionUID = 1L;

	public static final TrySpace wholeSpace = makeWholeSpace(); 
	
	public TrySpace() {
		// TODO valid constructor?
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
	
	public static TrySpace makeWholeSpace(){
		TrySpace wholeSpace = new TrySpace();
		
		for ( int i = 0; i <= 9; i++ ) {
			for ( int j = 0; j <= 9; j++ ) {
				for ( int k = 0; k <= 9; k++ ) {
					if ( i != j && i != k && j != k) {
						wholeSpace.add(new NVec(new int[] {i, j, k}));						
					}
				}
			}
		}
		return wholeSpace;
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
	
	protected HashSet<Integer> makeDigitSpace (NVec nv) {
		HashSet<Integer> digitSpace = new HashSet<Integer> ();
		for (int i = 0; i <= 9; i++) {
			digitSpace.add(i);
		}
		digitSpace.removeAll(nv);
		
		return digitSpace;
	}
	
	public void update(NVec nv, int eat, int bite) {
		TrySpace trySpaceToRetain = new TrySpace();
		
		if (eat == 3) {
			trySpaceToRetain.add(nv);
		} 
		else if (eat == 0 && bite == 3) {
			trySpaceToRetain.add(new int[] {nv.get(1), nv.get(2), nv.get(0)});
			trySpaceToRetain.add(new int[] {nv.get(2), nv.get(0), nv.get(1)});
		}
		else if (eat == 1 && bite == 2) {
			// fix one digit and swap other two's
			trySpaceToRetain.add(new int[] {nv.get(0), nv.get(2), nv.get(1)});
			trySpaceToRetain.add(new int[] {nv.get(2), nv.get(1), nv.get(0)});
			trySpaceToRetain.add(new int[] {nv.get(1), nv.get(0), nv.get(2)});
		} 
		else if (eat == 2 && bite == 0) {
			// fix two digits and change another digit
			HashSet<Integer> digitSpace = makeDigitSpace(nv);
			
			for (int i : digitSpace) {
				trySpaceToRetain.add(new int[] {nv.get(0), nv.get(1), i});
				trySpaceToRetain.add(new int[] {nv.get(0), i, nv.get(2)});
				trySpaceToRetain.add(new int[] {i, nv.get(1), nv.get(2)});
			}
		}
		else if (eat == 1 && bite == 1) {
			// fix one digit and swap other two's and change one of them
			HashSet<Integer> digitSpace = makeDigitSpace(nv);
			
			for (int i : digitSpace) {
				trySpaceToRetain.add(new int[] {nv.get(0), i, nv.get(1)});
				trySpaceToRetain.add(new int[] {nv.get(0), nv.get(2), i});
				trySpaceToRetain.add(new int[] {i, nv.get(1), nv.get(0)});
				trySpaceToRetain.add(new int[] {nv.get(2), nv.get(1), i});
				trySpaceToRetain.add(new int[] {i, nv.get(0), nv.get(2)});
				trySpaceToRetain.add(new int[] {nv.get(1), i, nv.get(2)});
			}			
		}
		else if (eat == 0 && bite == 2) {
			// rotate two digits and validate another
			HashSet<Integer> digitSpace = makeDigitSpace(nv);
			
			for (int i : digitSpace) {
				// rotate 1st & 2nd, and validate 3rd
				trySpaceToRetain.add(new int[] {nv.get(1), nv.get(0), i});
				trySpaceToRetain.add(new int[] {nv.get(1), i, nv.get(0)});
				trySpaceToRetain.add(new int[] {i, nv.get(0), nv.get(1)});
				// rotate 1st & 3rd, and validate 2nd
				trySpaceToRetain.add(new int[] {nv.get(2), nv.get(0), i});
				trySpaceToRetain.add(new int[] {nv.get(2), i, nv.get(0)});
				trySpaceToRetain.add(new int[] {i, nv.get(2), nv.get(0)});
				// rotate 2nd & 3rd, and validate 1st
				trySpaceToRetain.add(new int[] {nv.get(1), nv.get(2), i});
				trySpaceToRetain.add(new int[] {nv.get(2), i, nv.get(1)});
				trySpaceToRetain.add(new int[] {i, nv.get(2), nv.get(1)});
			}			
			
		}
		else if (eat == 1 && bite == 0) {
			// fix one and validate other two
			HashSet<Integer> digitSpace = makeDigitSpace(nv);
			
			for (int i :digitSpace) {
				for (int j : digitSpace) {
					if( i!=j ) {
						trySpaceToRetain.add(new int[] {nv.get(0), i, j});
						trySpaceToRetain.add(new int[] {i, nv.get(1), j});
						trySpaceToRetain.add(new int[] {i, j, nv.get(2)});
					}
				}
			}
		}
		else if (eat == 0 && bite == 1) {
			// rotate one and validate other two
			HashSet<Integer> digitSpace = makeDigitSpace(nv);
			
			for (int i :digitSpace) {
				for (int j : digitSpace) {
					if( i!=j ) {
						trySpaceToRetain.add(new int[] {i, nv.get(0), j});
						trySpaceToRetain.add(new int[] {i, j, nv.get(0)});
						trySpaceToRetain.add(new int[] {nv.get(1), i, j});
						trySpaceToRetain.add(new int[] {i, j, nv.get(1)});
						trySpaceToRetain.add(new int[] {nv.get(2), i, j});
						trySpaceToRetain.add(new int[] {i, nv.get(2), j});
					}
				}
			}
		}
		else if (eat == 0 && bite == 0){
			HashSet<Integer> digitSpace = makeDigitSpace(nv);
			
			for (int i :digitSpace) {
				for (int j : digitSpace) {
					for (int k : digitSpace) {
						if( i!=j || i!=k || j!=k) {
							trySpaceToRetain.add(new int[] {i, j, k});
						}
					}
				}
			}
		}
		else { // invalid eat/bite counts
			return;
		}
		
		this.retainAll(trySpaceToRetain);
	}
}
