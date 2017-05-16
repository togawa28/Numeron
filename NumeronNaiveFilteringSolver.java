package la.java;
import java.util.Random;

// TODO think possibility to introduce super-class Solver
class NumeronNaiveFilteringSolver{
	private TrySpace ts = new TrySpace(); // initialize it
	private static Random rand = new Random();
	
	public void updateTrySpace (NumeronVec t, int[] response) {
		// TODO write if-else statement for updater
		if (response.equals(new int[] {0,0})) {
			
		} else if (response.equals(new int[] {0,1})) {
			
		} else if (response.equals(new int[] {0,2})) {
			
		} else if (response.equals(new int[] {0,3})) {
			
		} else if (response.equals(new int[] {1,0})) {
			
		} else if (response.equals(new int[] {1,1})) {
			
		} else if (response.equals(new int[] {1,2})) {
			
		} else if (response.equals(new int[] {2,0})) {
			
		} else if (response.equals(new int[] {3,0})) {
			ts = new TrySpace(new NumeronVec[]{t});
		}
	}
	
	public NumeronVec generateInput() {
		int M = ts.getSize();
		int i = rand.nextInt(M);
		return ts.getSpace(i);
	}
}
