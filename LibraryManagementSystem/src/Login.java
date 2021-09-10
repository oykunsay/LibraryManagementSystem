import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	Connection conn;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JTextField fld_username;
	private JPasswordField fld_password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		conn = JavaConnection.ConnerDb();
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "LOGIN",
				TitledBorder.LEFT, TitledBorder.TOP, null, SystemColor.activeCaption));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblNewLabel.setBounds(48, 33, 95, 25);
		contentPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblPassword.setBounds(48, 85, 95, 25);
		contentPane.add(lblPassword);

		fld_username = new JTextField();
		fld_username.setBounds(183, 33, 121, 23);
		contentPane.add(fld_username);
		fld_username.setColumns(10);

		fld_password = new JPasswordField();
		fld_password.setBounds(183, 86, 121, 23);
		contentPane.add(fld_password);

		JButton btn_signup = new JButton("SIGNUP");
		btn_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signup = new SignUp();
				signup.setVisible(true);
				dispose();
			}
		});
		btn_signup.setBackground(SystemColor.activeCaption);
		btn_signup.setBounds(183, 146, 121, 25);
		contentPane.add(btn_signup);

		JButton btn_forgotpassword = new JButton("FORGOT PASSWORD");
		btn_forgotpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgotPassword forgotpassword = new ForgotPassword();
				forgotpassword.setVisible(true);
				dispose();
			}
		});
		btn_forgotpassword.setBackground(SystemColor.activeCaption);
		btn_forgotpassword.setBounds(98, 194, 159, 25);
		contentPane.add(btn_forgotpassword);

		JButton btn_login = new JButton("LOGIN");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT * FROM account WHERE username=? AND password=?";
				try {
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setString(1, fld_username.getText());
					preparedStatement.setString(2, fld_password.getText());
					rs = preparedStatement.executeQuery();
					if (rs.next()) {
						rs.close();
						preparedStatement.close();
						setVisible(false);
						Home home = new Home();
						home.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Incorrect username or password.");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e);
				} finally {
					try {
						rs.close();
						preparedStatement.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btn_login.setBackground(SystemColor.activeCaption);
		btn_login.setBounds(48, 147, 121, 25);
		contentPane.add(btn_login);
	}
}
