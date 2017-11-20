/* The Model - Shepherd Class that has control over the increase and decrease of sheeps
 * that enters and leaves the barn.
 * 
 * @author Andrew Nguyen
 */
public class Shepherd {
	
	int totalSheeps;
	int currentSheeps;
	
	public Shepherd() {
		this.totalSheeps = 0;
		this.currentSheeps = 0;
	}
	
	/*
	 * @return total sheeps
	 */
	public int getTotalSheeps() {
		return totalSheeps;
	}

	/*
	 * @param set the total sheep to...
	 */
	public void setTotalSheeps(int totalSheeps) {
		this.totalSheeps = totalSheeps;
	}

	/*
	 * @return current sheeps in the barn
	 */
	public int getcurrentSheeps() {
		return currentSheeps;
	}

	/*
	 * @param set the current sheeps in the barn to...
	 */
	public void setcurrentSheeps(int currentSheeps) {
		this.currentSheeps = currentSheeps;
	}

	/*
	 * increase the amount of sheeps that enters the barn
	 */
	public void increment() {
		currentSheeps++;
	}
	
	/*
	 * decrease the amount of sheeps that leaves the barn
	 */
	public void decrement() {
		currentSheeps--;
	}
	
	/*
	 * Check and update the text whether there's sufficient amount of sheeps
	 */
	public String checkSystem() {
		if(currentSheeps > totalSheeps || currentSheeps < 0) {
			return "inconsistent!";
		}
		else if(currentSheeps < totalSheeps) {
			return "incomplete!";
		}
		else{
			return "complete!";
		}
	}
}
