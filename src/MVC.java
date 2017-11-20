/* The Main location that works with GUI and Shepherd
 * This is not a proper Model-View-Controller but the program does work
 * 
 * @author Andrew Nguyen
 */
public class MVC {

	public static void main(String[] args) {
		Shepherd s = new Shepherd();
		
		//createGUI
		GUI gui = new GUI(s);
		

	}

}
