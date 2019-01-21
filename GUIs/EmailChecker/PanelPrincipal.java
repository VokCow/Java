//here we import all staff will be necesary for the content of our window
//staff like colour
import java.awt.Color;
// creation of buttons need from the concept of event. Cuple of classes must be added with that respect
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// then the proper button creation class
import javax.swing.JButton;
//the panel creation class
import javax.swing.JPanel;
// then couple of classes for labels and texts
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.regex.Matcher;


public class PanelPrincipal extends JPanel { //Our class for panel content is a JPanel subcalss

/* This panel will contains a field where user can insert some text and confirm  whether such test is an email or not.  */
	
	JTextField email_field; //where user will introduce text
	JLabel warn= new JLabel("");	//answer user will see
	
	
//here it goes the "public part" of our panel class. It just call the components to be started by iniciarcomponentes() mehtod and make them visible
	public PanelPrincipal() {
		iniciarComponentes();
		setVisible(true); 
	}
	

	private void iniciarComponentes() { //here we iniciate our screen components
		
		warn.setFont(new java.awt.Font("Arial", 1, 30));

		// we set the text that appear in the label
		JLabel emailclaimer = new JLabel("Email : ");
		emailclaimer.setFont(new java.awt.Font("Arial", 1, 26));
		add(emailclaimer);	
		
		//We allocate the JText attribute to the field that will be in the window
		this.email_field = new JTextField();
		email_field.setText("");
		email_field.setFont(new java.awt.Font("Arial", 1, 26));
		email_field.setColumns(20); //determines the breadth of the text field
		add(email_field);
		
		//now we work on the button, first we create it
		JButton validar = new JButton("validate"); 
		validar.setFont(new java.awt.Font("Arial",1,26));
		// now we give it functionality
		validar.addActionListener(new validateListener());
		add(validar);
		add(warn);
		warn.setVisible(true);
		
	}
	//here we do the event thing impelmenting a class that is a ActionListener subclass
	//Also we override a method form this superclass
	private class validateListener implements ActionListener {
		private boolean isValid;
		public validateListener() {
		}
		@Override
		public void actionPerformed(ActionEvent e) {
				String email = email_field.getText();
					if(email.matches("^.*@.*\\..*$")) isValid=true;			
					if(isValid) {
						warn.setText("Correct email");
					}
					else {
						warn.setText("Invalid email");
					}
			}
		}
}
