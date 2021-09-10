import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Home extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		setForeground(new Color(51, 102, 102));
		getContentPane().setBackground(Color.WHITE);
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		getContentPane().setLayout(null);

		JButton btn_newBook = new JButton("NEW BOOK");
		btn_newBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				NewBook newBook = new NewBook();
				newBook.setVisible(true);
			}
		});
		btn_newBook.setFont(new Font("Ever After", Font.PLAIN, 30));
		btn_newBook.setBackground(SystemColor.activeCaption);
		btn_newBook.setBounds(96, 125, 190, 109);
		getContentPane().add(btn_newBook);

		JButton btn_newStudent = new JButton("NEW STUDENT");
		btn_newStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Student student = new Student();
				student.setVisible(true);
			}
		});
		btn_newStudent.setFont(new Font("Ever After", Font.PLAIN, 30));
		btn_newStudent.setBackground(SystemColor.activeCaption);
		btn_newStudent.setBounds(96, 391, 190, 109);
		getContentPane().add(btn_newStudent);

		JLabel lblNewLabel = new JLabel("WELCOME TO OUR LIBRARY");
		lblNewLabel.setForeground(new Color(112, 128, 144));
		lblNewLabel.setFont(new Font("Footlight MT Light", Font.PLAIN, 28));
		lblNewLabel.setBounds(20, 11, 343, 93);
		getContentPane().add(lblNewLabel);

		JButton btn_returnBook = new JButton("RETURN BOOK");
		btn_returnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ReturnBook returnBook = new ReturnBook();
				returnBook.setVisible(true);
			}
		});
		btn_returnBook.setBackground(new Color(230, 230, 250));
		btn_returnBook.setFont(new Font("Ever After", Font.PLAIN, 30));
		btn_returnBook.setBounds(96, 523, 190, 109);
		getContentPane().add(btn_returnBook);

		JButton btn_issueBook = new JButton("ISSUE BOOK");
		btn_issueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IssueBook issueBook = new IssueBook();
				issueBook.setVisible(true);
			}
		});
		btn_issueBook.setFont(new Font("Ever After", Font.PLAIN, 30));
		btn_issueBook.setBackground(new Color(230, 230, 250));
		btn_issueBook.setBounds(96, 255, 190, 109);
		getContentPane().add(btn_issueBook);
	}
}
