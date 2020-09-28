package igtampe.wordstructor.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TempDetails {

	private JFrame DetailWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String Details) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TempDetails window = new TempDetails(Details);
					window.DetailWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TempDetails(String Details) {
		TempDetailsinitialize(Details);
	}

	/**
	 * Initialize the contents of the DetailWindow.
	 */
	private void TempDetailsinitialize(String Details) {
		DetailWindow = new JFrame();
		DetailWindow.setResizable(false);
		DetailWindow.setBounds(100, 100, 450, 450);
		DetailWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DetailWindow.getContentPane().setLayout(null);
		
		JTextArea txtrTheDetailsShould = new JTextArea();
		txtrTheDetailsShould.setEditable(false);
		txtrTheDetailsShould.setText(Details);
		txtrTheDetailsShould.setBounds(10, 11, 424, 366);
		txtrTheDetailsShould.setLineWrap(true);
		txtrTheDetailsShould.setWrapStyleWord(true);
		DetailWindow.getContentPane().add(txtrTheDetailsShould);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DetailWindow.dispose();
			}
		});
		btnOk.setBounds(345, 388, 89, 23);
		DetailWindow.getContentPane().add(btnOk);
	}
}
