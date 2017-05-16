package la.java;
// TODO attempt using TreeSet
// import java.util.Set;
// import java.util.TreeSet;

class TrySpace {
	// private Set<NumeronVec> space2 = new TreeSet<NumeronVec>();
	private NumeronVec[] space;
	private int size = 0;

	public TrySpace(NumeronVec[] space) {
		if (isValidSpace(space)) {
			this.space = space;
			this.size = space.length;
		} else {
			System.out.println("Invalid Space!");
		}
	}

	public TrySpace() {
		// initialize it
		// default case!
		int cnt = 0;
		int size = 10*9*8;
		NumeronVec[] space = new NumeronVec[size];
		//NumeronVec t;

		for ( int i = 0; i < 10; i++ ) {
			for ( int j = 0; j < 10; j++ ) {
				for ( int k = 0; k < 10; k++ ) {
					if (i != j && i != k && j != k) {
						space[cnt] = new NumeronVec(new int[] {i, j, k});
						cnt++;
					}
				}
			}
		}

		this.space = space;
		this.size = size;
	}

	/*
	* setter for space
	*/
	public void setSpace(NumeronVec[] space) {
		if (isValidSpace(space)) {
			this.space = space;	
			this.size = space.length;	
		} else {
			System.out.println("Invalid Space!");
		}
	}
	/*
	* getter for space
	*/
	public NumeronVec[] getSpace() {
		return this.space;
	}
	
	public NumeronVec getSpace(int i) {
		if (i < 0 || this.space.length <= i) {
			System.out.println("Invalid Index!");
		}
		return this.space[i];		
	}
	
	/*
	* getter for size
	* no setter for size
	*/
	public int getSize() {
		return this.size;
	}


	public boolean isValidSpace(NumeronVec[] space) {
		boolean out = true;

		for ( int i = 0; i < space.length - 1; i++ ) {
			for ( int j = i + 1; j < space.length; j++ ) {
				// if there is any pair of identical vectors
				if (space[i].equals(space[j])) {
					out = false;
				}
			}
		}

		return out;
	}
}