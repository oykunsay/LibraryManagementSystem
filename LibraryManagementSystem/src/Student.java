import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student extends JFrame {
	Connection conn;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JTextField fld_studentID;
	private JTextField fld_studentName;
	private JTextField fld_studentBranch;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Student() {
		super("New Student");
		setTitle("Library Management System");
		conn = JavaConnection.ConnerDb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"New Student", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(153, 180, 209)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblStudentId.setBounds(55, 27, 95, 25);
		contentPane.add(lblStudentId);

		fld_studentID = new JTextField();
		fld_studentID.setColumns(10);
		fld_studentID.setBounds(190, 30, 121, 23);
		contentPane.add(fld_studentID);

		JLabel label_1 = new JLabel("Name");
		label_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_1.setBounds(55, 75, 95, 25);
		contentPane.add(label_1);

		fld_studentName = new JTextField();
		fld_studentName.setColumns(10);
		fld_studentName.setBounds(190, 78, 121, 23);
		contentPane.add(fld_studentName);

		final JComboBox select_course = new JComboBox();
		select_course.setModel(new DefaultComboBoxModel(new String[] { "B Tech", "BCA", "BBA", "BSC", "MBA" }));
		select_course.setBackground(SystemColor.activeCaption);
		select_course.setBounds(192, 131, 121, 22);
		contentPane.add(select_course);

		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblCourse.setBounds(57, 128, 137, 25);
		contentPane.add(lblCourse);

		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblBranch.setBounds(57, 185, 95, 25);
		contentPane.add(lblBranch);

		fld_studentBranch = new JTextField();
		fld_studentBranch.setColumns(10);
		fld_studentBranch.setBounds(192, 188, 121, 23);
		contentPane.add(fld_studentBranch);

		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblYear.setBounds(57, 238, 137, 25);
		contentPane.add(lblYear);

		final JComboBox select_year = new JComboBox();
		select_year.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
		select_year.setBackground(SystemColor.activeCaption);
		select_year.setBounds(192, 241, 121, 22);
		contentPane.add(select_year);

		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblSemester.setBounds(55, 297, 137, 25);
		contentPane.add(lblSemester);

		final JComboBox select_semester = new JComboBox();
		select_semester.setMaximumRowCount(10);
		select_semester.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
		select_semester.setBackground(SystemColor.activeCaption);
		select_semester.setBounds(190, 300, 121, 22);
		contentPane.add(select_semester);

		JButton btn_register = new JButton("REGISTER");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "INSERT INTO student " + "(student_id,name,course,branch,year,semester) VALUES"
						+ "(?,?,?,?,?,?)";
				try {
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setString(1, fld_studentID.getText());
					preparedStatement.setString(2, fld_studentName.getText());
					preparedStatement.setString(3, (String) select_course.getSelectedItem());
					preparedStatement.setString(4, fld_studentBranch.getText());
					preparedStatement.setString(5, (String) select_year.getSelectedItem());
					preparedStatement.setString(6, (String) select_semester.getSelectedItem());
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null, "New student signed up!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btn_register.setForeground(Color.BLACK);
		btn_register.setBackground(SystemColor.activeCaption);
		btn_register.setBounds(55, 355, 111, 23);
		contentPane.add(btn_register);

		JButton btn_back = new JButton("BACK");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btn_back.setForeground(Color.BLACK);
		btn_back.setBackground(SystemColor.activeCaption);
		btn_back.setBounds(190, 355, 121, 23);
		contentPane.add(btn_back);

	}
}
