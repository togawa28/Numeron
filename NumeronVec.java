package la.java;

class NumeronVec {
	private int[] vec = new int[] { 0, 1, 2 };
	private int size = 3;
	private int minX = 0;
	private int maxX = 9;

	public NumeronVec(int[] vec) {
		if (isValidVec(vec)) {
			this.vec = vec;
		} else {
			System.out.println("Invalid Numeron Vector!");
		}
	}

	public NumeronVec(NumeronVec userInput) {
		for(int i = 0; i < this.size; i++){
			this.vec[i] = userInput.getVec(i);			
		}
	}
	
	/*
	* setter for vec
	*/
	public void setVec(int[] vec) {
		if (isValidVec(vec)) {
			this.vec = vec;			
		} else {
			System.out.println("Invalid Numeron Vector!");
		}
	}
	public void setVec(NumeronVec t) {
		if (t.getSize() != this.size) {
			System.out.println("Invalid Numeron Vector!");
			return;
		} else {
			 for (int i = 0; i < this.size; i++) {
				 this.vec[i] = t.getVec(i);
			 }
		}
	}
	/*
	* getter for vec
	*/
	public int[] getVec() {
		return this.vec;
	}
	
	public int getVec(int i) {
		if (i < 0 || this.size <= i) {
			System.out.println("Index is out of bounds!");
		}
		
		return this.vec[i];
	}
	/*
	* setter for size
	*/
	public void setSize(int size) {
		this.size = size;
	}
	/*
	* getter for size
	*/
	public int getSize() {
		return this.size;
	}

	/*
	* setter for minX
	*/
	public void setMinX(int minX) {
		this.minX = minX;
	}
	/*
	* getter for minX
	*/
	public int getMinX() {
		return this.minX;
	}

	/*
	* setter for maxX
	*/
	public void setMaxX(int maxX) {
		if (maxX > 9) {
			System.out.println("warning!: maxX exceeds 9!");
		}
		this.maxX = maxX;
	}
	/*
	* getter for maxX
	*/
	public int getMaxX() {
		return this.maxX;
	}



	public boolean isValidVec (int[] vec) {
		boolean out = true;
		
		if (vec.length != this.size) {
			out = false;
		}

		for (int x : vec) {
			if ( this.minX > x || this.maxX < x) {
				out = false;
			}
		}

		if (vec[0] == vec[1] || vec[0] == vec[2] || vec[1] == vec[2]) {
			out = false;
		}


		return out;
	}

	public boolean equals(NumeronVec t) {
		boolean out = true;

		if (this.size != t.getSize() ) {
			out = false;
		}

		for ( int i = 0; i < this.getSize(); i++ ){
			if (this.vec[i] != t.getVec(i)) {
				out = false;
			}
		}

		return out;
	} 

}