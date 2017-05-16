package la.java;

class NumeronCalc {
	
	public static int countEat (NumeronVec t, NumeronVec ans) {
		int cnt = 0;
		if (t.getSize() != ans.getSize()) {
			System.out.println("vectors provided have different size!");
		} else {
			for (int i = 0; i < t.getSize(); i++) {
				if (t.getVec(i) == ans.getVec(i)) {
					cnt++;
				}	
			}
		}
		return cnt;
	}

	public static int countBite(NumeronVec t, NumeronVec ans) {
		int cnt = 0;
		if (t.getSize() != ans.getSize()) {
			System.out.println("vectors provided have different size!");
		} else {
			for (int i = 0; i < t.getSize(); i++) {
				for (int j = 0; j < ans.getSize(); j++) {
					if (t.getVec(i) == ans.getVec(j)) {
						cnt++;
					}
				}
			}
		}
		return cnt - countEat(t, ans);
	}

	public static int[] getResponse(NumeronVec t, NumeronVec ans) {
		int[] response = { countEat(t, ans), countBite(t, ans) };
		return response;
	}


}