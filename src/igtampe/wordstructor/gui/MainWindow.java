package igtampe.wordstructor.gui;

import java.awt.EventQueue;
import igtampe.wordstructor.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField txtWordBeginning;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 312, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitleLabel = new JLabel("Wordstructor");
		lblTitleLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 32));
		lblTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLabel.setBounds(10, 11, 269, 45);
		frame.getContentPane().add(lblTitleLabel);
		
		JLabel lblNewLabel = new JLabel("# of Words:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(10, 92, 99, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 67, 291, 14);
		frame.getContentPane().add(separator);
		
		JSpinner WordSpinner = new JSpinner();
		WordSpinner.setModel(new SpinnerNumberModel(5, 0, 26, 1));
		WordSpinner.setBounds(119, 89, 37, 20);
		frame.getContentPane().add(WordSpinner);
		
		JLabel lblMinLength = new JLabel("Min Length:");
		lblMinLength.setBounds(168, 92, 72, 14);
		frame.getContentPane().add(lblMinLength);
		
		JSpinner MinLengthSpinner = new JSpinner();
		MinLengthSpinner.setModel(new SpinnerNumberModel(5, 4, 100, 1));
		MinLengthSpinner.setBounds(242, 89, 37, 20);
		frame.getContentPane().add(MinLengthSpinner);
		
		JLabel lblMaxLength = new JLabel("Max Length:");
		lblMaxLength.setBounds(168, 128, 72, 14);
		frame.getContentPane().add(lblMaxLength);
		
		JSpinner MaxLengthSpinner = new JSpinner();
		MaxLengthSpinner.setModel(new SpinnerNumberModel(8, 4, 100, 1));
		MaxLengthSpinner.setBounds(242, 125, 37, 20);
		frame.getContentPane().add(MaxLengthSpinner);
		
		JLabel lblFirstLetter = new JLabel("Beginning:");
		lblFirstLetter.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstLetter.setBounds(10, 128, 62, 14);
		frame.getContentPane().add(lblFirstLetter);
		
		txtWordBeginning = new JTextField();
		txtWordBeginning.setToolTipText("The beginning of the words generated");
		txtWordBeginning.setText("p");
		txtWordBeginning.setBounds(82, 125, 72, 20);
		frame.getContentPane().add(txtWordBeginning);
		txtWordBeginning.setColumns(1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 153, 291, 7);
		frame.getContentPane().add(separator_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Consolas", Font.PLAIN, 14));
		textPane.setEditable(false);
		textPane.setBounds(10, 171, 270, 493);
		textPane.setAutoscrolls(true);
		frame.getContentPane().add(textPane);
				
		JButton btnNewButton = new JButton("Wordstruct!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//ok here goes the cosa
				
				int MinLength = (int)MinLengthSpinner.getModel().getValue();
				int MaxLength = (int)MaxLengthSpinner.getModel().getValue();
				int WordNumber = (int)WordSpinner.getModel().getValue();
				
				if(MaxLength<MinLength) {
					ErrorWindow.Generate(0, "An Error Happened", "The Minimum length cannot be larger than the maximum length!", false,"");
					return;
				}
				
				//Create a Wordgenerator
				WordGenerator Generator = new WordGenerator(MaxLength, MinLength);
				
				//Make sure we have a de-esta cosa to hold all words:
				String AllWords=""; 
				
				//Handle if there is a first letter or not
				if(txtWordBeginning.getText().isEmpty()) {for (int i = 0; i < WordNumber; i++) {AllWords+=Generator.Generate()+"\n";}} else {
					Letter FirstLetter;					

					try {FirstLetter=Letters.charToLetter(txtWordBeginning.getText().charAt(txtWordBeginning.getText().length()-1));} catch (Exception e) {
						ErrorWindow.Generate(0, "An Error Happened", "Could not convert last character of beginning to Letter", true,e.toString());
						return;
					}
					
					if(FirstLetter==null) {
						ErrorWindow.Generate(0, "An Error Happened", "Could not convert last character of beginning to Letter", true,"Could not convert '" + txtWordBeginning.getText().charAt(txtWordBeginning.getText().length()-1) + "' to Letter");
						return;
					}
					
					for (int i = 0; i < WordNumber; i++) {AllWords+=txtWordBeginning.getText()+Generator.Generate(FirstLetter)+"\n";}

				}
				
				textPane.setText(AllWords);
			}
		});
		btnNewButton.setBounds(168, 675, 111, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
