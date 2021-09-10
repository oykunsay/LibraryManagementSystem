import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotPassword extends JFrame {

	Connection conn;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JTextField fld_username;
	private JTextField fld_name;
	private JTextField fld_answer;
	private JButton btn_search;
	private JButton btn_retrive;
	private JButton btn_back;
	private JTextField fld_securityQuestion;
	private JTextField fld_yourPassword;

	public void Search() {
		String username = fld_username.getText();
		String query = "SELECT * FROM account WHERE username ='" + username + "'";
		try {
			preparedStatement = conn.prepareStatement(query);
			rs = preparedStatement.executeQuery(query);
			if (rs.next()) {
				fld_name.setText(rs.getString(2));
				fld_securityQuestion.setText(rs.getString(4));
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect Username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void Retrive() {
		String username = fld_username.getText();
		String answer = fld_answer.getText();
		String query = "SELECT * FROM account WHERE answer='" + answer + "'";
		try {
			preparedStatement = conn.prepareStatement(query);
			rs = preparedStatement.executeQuery(query);
			if (rs.next()) {
				fld_yourPassword.setText(rs.getString(3));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ForgotPassword() {
		conn = JavaConnection.ConnerDb();

		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"FORGOT PASSWORD", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(153, 180, 209)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblUsername.setBounds(45, 50, 95, 25);
		contentPane.add(lblUsername);

		fld_username = new JTextField();
		fld_username.setColumns(10);
		fld_username.setBounds(180, 50, 121, 23);
		contentPane.add(fld_username);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblName.setBounds(45, 98, 95, 25);
		contentPane.add(lblName);

		fld_name = new JTextField();
		fld_name.setColumns(10);
		fld_name.setBounds(180, 98, 121, 23);
		contentPane.add(fld_name);

		JLabel lblSecurtyQueston = new JLabel("Security Question");
		lblSecurtyQueston.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblSecurtyQueston.setBounds(45, 147, 137, 25);
		contentPane.add(lblSecurtyQueston);

		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblAnswer.setBounds(45, 197, 95, 25);
		contentPane.add(lblAnswer);

		fld_answer = new JTextField();
		fld_answer.setColumns(10);
		fld_answer.setBounds(180, 197, 121, 23);
		contentPane.add(fld_answer);

		JLabel lblNewPassword = new JLabel("Your Password");
		lblNewPassword.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblNewPassword.setBounds(48, 245, 134, 25);
		contentPane.add(lblNewPassword);

		btn_search = new JButton("SEARCH");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search();
			}
		});
		btn_search.setBackground(SystemColor.activeCaption);
		btn_search.setForeground(SystemColor.desktop);
		btn_search.setBounds(319, 50, 89, 23);
		contentPane.add(btn_search);

		btn_retrive = new JButton("RETRIVE");
		btn_retrive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Retrive();
			}
		});
		btn_retrive.setForeground(Color.BLACK);
		btn_retrive.setBackground(SystemColor.activeCaption);
		btn_retrive.setBounds(319, 197, 89, 23);
		contentPane.add(btn_retrive);

		btn_back = new JButton("BACK");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btn_back.setForeground(Color.BLACK);
		btn_back.setBackground(SystemColor.activeCaption);
		btn_back.setBounds(319, 244, 89, 23);
		contentPane.add(btn_back);

		fld_securityQuestion = new JTextField();
		fld_securityQuestion.setColumns(10);
		fld_securityQuestion.setBounds(180, 149, 121, 23);
		contentPane.add(fld_securityQuestion);

		fld_yourPassword = new JTextField();
		fld_yourPassword.setColumns(10);
		fld_yourPassword.setBounds(180, 244, 121, 23);
		contentPane.add(fld_yourPassword);

	}
}
