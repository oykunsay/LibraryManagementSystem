import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {
	Connection conn;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement;

	private JPanel contentPane;
	private JTextField fld_name;
	private JTextField fld_username;
	private JPasswordField fld_password;
	private JTextField fld_answer;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignUp() {
		conn = JavaConnection.ConnerDb();
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 405);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"NEW ACCOUNT", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(153, 180, 209)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		fld_name = new JTextField();
		fld_name.setColumns(10);
		fld_name.setBounds(184, 91, 121, 23);
		contentPane.add(fld_name);

		JLabel label = new JLabel("Name");
		label.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label.setBounds(49, 88, 95, 25);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Username");
		label_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_1.setBounds(49, 40, 95, 25);
		contentPane.add(label_1);

		fld_username = new JTextField();
		fld_username.setColumns(10);
		fld_username.setBounds(184, 43, 121, 23);
		contentPane.add(fld_username);

		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_2.setBounds(49, 142, 95, 25);
		contentPane.add(label_2);

		fld_password = new JPasswordField();
		fld_password.setBounds(184, 143, 121, 23);
		contentPane.add(fld_password);

		JLabel label_3 = new JLabel("Security Question");
		label_3.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_3.setBounds(49, 196, 137, 25);
		contentPane.add(label_3);

		final JComboBox select_securityQuestion = new JComboBox();
		select_securityQuestion.setModel(new DefaultComboBoxModel(
				new String[] { "First Pet", "Bestfriend's Name", "Favorite Food", "Nick Name" }));
		select_securityQuestion.setBackground(SystemColor.activeCaption);
		select_securityQuestion.setBounds(184, 199, 121, 22);
		contentPane.add(select_securityQuestion);

		JLabel label_4 = new JLabel("Answer");
		label_4.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_4.setBounds(49, 254, 95, 25);
		contentPane.add(label_4);

		fld_answer = new JTextField();
		fld_answer.setColumns(10);
		fld_answer.setBounds(184, 254, 121, 23);
		contentPane.add(fld_answer);

		JButton btn_create = new JButton("CREATE");
		btn_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "INSERT INTO account " + "(username, name, password, sec_q, answer) VALUES"
						+ "(?,?,?,?,?)";
				try {
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setString(1, fld_username.getText());
					preparedStatement.setString(2, fld_name.getText());
					preparedStatement.setString(3, fld_password.getText());
					preparedStatement.setString(4, (String) select_securityQuestion.getSelectedItem());
					preparedStatement.setString(5, fld_answer.getText());
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null, "New account created.");
					setVisible(false);
					Login login = new Login();
					login.setVisible(true);
				} catch (Exception e2) {
				}
			}
		});
		btn_create.setForeground(Color.BLACK);
		btn_create.setBackground(SystemColor.activeCaption);
		btn_create.setBounds(49, 305, 111, 23);
		contentPane.add(btn_create);

		JButton btn_back = new JButton("BACK");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btn_back.setForeground(Color.BLACK);
		btn_back.setBackground(SystemColor.activeCaption);
		btn_back.setBounds(184, 305, 121, 23);
		contentPane.add(btn_back);
	}

}
