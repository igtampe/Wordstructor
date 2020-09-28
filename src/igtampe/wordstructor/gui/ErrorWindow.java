package igtampe.wordstructor.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * ErrorWindow will render, you guessed it, a cake.
 * <br> <br>
 * wait no.
 */
public class ErrorWindow {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Generate(1, "oh no", "Nothing was Specified", true , "Litterally nothing was specified bobo. Just use Generate instead of the main class.");
			}
/**
 * This function generates an error popup window with the following arguements
 * @author Igtampe
 * @param type The type of window, be it Error 0, Warn (1), Question (2), or inform (3)
 * @param Header The header of the window
 * @param ShortDetail The subtitle of the window.
 * @param HasMore Wether or not this window has more details to show (Rendering the "Details" button)
 * @param MoreDetails the details to show when the "details" button is pressed. (Leave as "" if there isn't)
 */
public static void Generate(int type, String Header, String ShortDetail, boolean HasMore, String MoreDetails) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorWindow window = new ErrorWindow(type, Header, ShortDetail, HasMore, MoreDetails);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public ErrorWindow(int type, String Header, String ShortDetail, boolean HasMore, String MoreDetails) {
		InitializeWithData(type, Header, ShortDetail, HasMore, MoreDetails);
			}

	/**
	 * @wbp.parser.entryPoint
	 */

	private void InitializeWithData(int type, String Header, String ShortDetail, boolean HasMore, String MoreDetails) {
		String image;
		switch (type) {
		case 0:
			image = "/javax/swing/plaf/metal/icons/Error.gif";
			break;

		case 1:
			image = "/javax/swing/plaf/metal/icons/Warn.gif";
			break;

		case 2:
			image = "/javax/swing/plaf/metal/icons/Question.gif";
			break;

		case 3:
			image = "/javax/swing/plaf/metal/icons/Inform.gif";
			break;

		default:
			image = "/javax/swing/plaf/metal/icons/Error.gif";
			break;}
		
		if (Header==null) Header="An error has occurred";
		if (ShortDetail==null) ShortDetail="Something happened and I don't know what it is.";
		if (MoreDetails==null) {
			MoreDetails = "";
			HasMore = false;
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 113);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblErrorlabel = new JLabel("");
		lblErrorlabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorlabel.setIcon(new ImageIcon(ErrorWindow.class.getResource(image)));
		lblErrorlabel.setBounds(10, 11, 49, 49);
		frame.getContentPane().add(lblErrorlabel);
		
		JLabel HeaderLabel = new JLabel(Header);
		HeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		HeaderLabel.setBounds(69, 11, 263, 25);
		frame.getContentPane().add(HeaderLabel);
		
		JLabel TinyDescription = new JLabel(ShortDetail);
		TinyDescription.setBounds(69, 36, 240, 14);
		frame.getContentPane().add(TinyDescription);
		String ToDetails = MoreDetails;
		
		if (HasMore) {
		JButton btnDetails = new JButton("Details");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			TempDetails.main(ToDetails);
			}
		});
		btnDetails.setBounds(335, 37, 89, 23);
		frame.getContentPane().add(btnDetails);
		}
		
		JButton btnOk_1 = new JButton("Ok");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			}
		});
		btnOk_1.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(btnOk_1);
	}
	
}
