import javax.swing.JFrame;
import java.awt.Toolkit;

/*Here we write down ventana class. Imports: javax.swing.JFrame, will create the window itself and java.awt.Toolkit
 * that will be responsible of the window content. Swing and AWT are principal Java libraries for graphic application design.
*/
public class VentanaPrincipal extends JFrame { //our class ventana is a JFrame subcalss
	
	public VentanaPrincipal() {  //this is what we call when we instanciate the class
		setSize(1000,800);  //set a size
		setResizable(true); //allow user can resize
		setLocation(150,150); //locate where it shows up
		setTitle("Email Cheecker"); //set a title
		Toolkit mipantalla = Toolkit.getDefaultToolkit(); //here we set a default content
		//we assign an icon from a url (icon can be created with any other software we may like)
		setIconImage(mipantalla.getImage("C:\\Users\\Ángel\\Desktop\\voky\\Programming\\NetBEANS\\Graficos\\icono.gif"));
		//we specify the window behaviour once we close it
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//a method which initiate our components will always be necessary 
		iniciarComponentes();
		//also we have to make our windows visible, otherwise nothing will appear
		setVisible(true);
	}
	
	private void iniciarComponentes() {
		//so to iniciate components we need to create an instance of another class containing the components
		PanelPrincipal panel = new PanelPrincipal();
		//there we add the components to our window
		add(panel);
	}

}
