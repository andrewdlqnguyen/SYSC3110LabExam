import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

/* The View of the Shepherds barn and how it works with the interface
 *
 * @author Andrew Nguyen
 */
public class GUI extends JFrame {
	
	//Assigning Type to variables
	JLabel totalSheeps, currentSheeps;
	JTextField totalSheepsField, currentSheepsField, resultTextField;
	JButton incrementButton, decrementButton;
    
	public GUI(Shepherd s){
		//Initialize frame
		super("Sheep Counter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Container contentPane;
	
		//Create layout
		contentPane = getContentPane();
	    contentPane.setLayout(new GridLayout(4,2));
		
	    // Create Labels and Text Fields
		totalSheeps = new JLabel("total ");
		totalSheepsField = new JTextField("0");
		currentSheeps = new JLabel("current ");
		currentSheepsField = new JTextField("0");
		
		resultTextField = new JTextField("incomplete!");
		resultTextField.setForeground(Color.red);
		resultTextField.setEditable(false);
		
		// Creating buttons to increment or decrement
		incrementButton = new JButton("increment");
		decrementButton = new JButton("decrement");
		
		
		/* ActionListener for buttons and totalTextfield in case of wolves eating sheeps
		 * All of this can be put into one ActionListener to reduce cohesion
		 * And allow a handler to work with all the ActionListener
		 */
		incrementButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				s.setTotalSheeps(Integer.parseInt(totalSheepsField.getText()));
				s.setcurrentSheeps(Integer.parseInt(currentSheepsField.getText()));
				s.increment();
				currentSheepsField.setText("" + s.getcurrentSheeps());
				resultTextField.setText(s.checkSystem());
				checkString();
			}
		});
		
		decrementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.setTotalSheeps(Integer.parseInt(totalSheepsField.getText()));
				s.setcurrentSheeps(Integer.parseInt(currentSheepsField.getText()));
				s.decrement();
				currentSheepsField.setText("" + s.getcurrentSheeps());
				resultTextField.setText(s.checkSystem());	
				checkString();
			}
		});
		
		totalSheepsField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.setTotalSheeps(Integer.parseInt(totalSheepsField.getText()));
				s.setcurrentSheeps(Integer.parseInt(currentSheepsField.getText()));
				currentSheepsField.setText("" + s.getcurrentSheeps());
				resultTextField.setText(s.checkSystem());	
				checkString();
			}
		});
			
		//add content to layout
		contentPane.add(totalSheeps);
		contentPane.add(totalSheepsField);
	    contentPane.add(currentSheeps); 
	    contentPane.add(currentSheepsField);
	    contentPane.add(incrementButton);
	    contentPane.add(decrementButton);  
	    contentPane.add(resultTextField);
		
	    //Make the frame visible
	    setSize(300,150);
	    setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	/*
	 * This Method is to check the string that prints out when checking the sheeps
	 * If the string equals to either "complete", "incomplete", "inconsistent"
	 * Print color accordingly
	 */
	public void checkString() {
		if (resultTextField.getText().equals("complete!")){
			resultTextField.setForeground(Color.green);
		}
		if (resultTextField.getText().equals("incomplete!")){
			resultTextField.setForeground(Color.red);
		}
		if (resultTextField.getText().equals("inconsistent!")){
			resultTextField.setForeground(Color.yellow);
		}
	}
}
