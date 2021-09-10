import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class IssueBook extends JFrame {
	Connection conn;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JTextField fld_bookID;
	private JTextField fld_bookName;
	private JTextField fld_bookPages;
	private JTextField fld_bookPrice;
	private JTextField fld_bookPublisher;
	private JTextField fld_bookEdition;
	private JTextField fld_studentID;
	private JTextField fld_studentName;
	private JTextField fld_branchName;
	private JTextField fld_courseName;
	private JTextField fld_studentYear;
	private JTextField fld_studentSemester;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IssueBook() {
		conn = JavaConnection.ConnerDb();
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Issue Book", TitledBorder.LEFT, TitledBorder.TOP, null, SystemColor.activeCaption));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Book ID");
		label.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label.setBounds(25, 29, 95, 25);
		contentPane.add(label);

		fld_bookID = new JTextField();
		fld_bookID.setColumns(10);
		fld_bookID.setBounds(160, 32, 121, 23);
		contentPane.add(fld_bookID);

		JLabel label_1 = new JLabel("Name");
		label_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_1.setBounds(25, 77, 95, 25);
		contentPane.add(label_1);

		fld_bookName = new JTextField();
		fld_bookName.setColumns(10);
		fld_bookName.setBounds(160, 80, 121, 23);
		contentPane.add(fld_bookName);

		JLabel label_2 = new JLabel("Edition");
		label_2.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_2.setBounds(25, 128, 137, 25);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Publisher");
		label_3.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_3.setBounds(25, 180, 95, 25);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Price");
		label_4.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_4.setBounds(25, 233, 95, 25);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Pages");
		label_5.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_5.setBounds(25, 282, 95, 25);
		contentPane.add(label_5);

		fld_bookPages = new JTextField();
		fld_bookPages.setColumns(10);
		fld_bookPages.setBounds(160, 285, 121, 23);
		contentPane.add(fld_bookPages);

		fld_bookPrice = new JTextField();
		fld_bookPrice.setColumns(10);
		fld_bookPrice.setBounds(160, 237, 121, 23);
		contentPane.add(fld_bookPrice);

		fld_bookPublisher = new JTextField();
		fld_bookPublisher.setColumns(10);
		fld_bookPublisher.setBounds(160, 184, 121, 23);
		contentPane.add(fld_bookPublisher);

		fld_bookEdition = new JTextField();
		fld_bookEdition.setColumns(10);
		fld_bookEdition.setBounds(160, 132, 121, 23);
		contentPane.add(fld_bookEdition);

		JLabel label_6 = new JLabel("Student ID");
		label_6.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_6.setBounds(441, 29, 95, 25);
		contentPane.add(label_6);

		fld_studentID = new JTextField();
		fld_studentID.setColumns(10);
		fld_studentID.setBounds(588, 32, 121, 23);
		contentPane.add(fld_studentID);

		JLabel label_7 = new JLabel("Name");
		label_7.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_7.setBounds(441, 77, 95, 25);
		contentPane.add(label_7);

		fld_studentName = new JTextField();
		fld_studentName.setColumns(10);
		fld_studentName.setBounds(588, 80, 121, 23);
		contentPane.add(fld_studentName);

		JLabel label_8 = new JLabel("Course");
		label_8.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_8.setBounds(441, 128, 137, 25);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("Branch");
		label_9.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_9.setBounds(441, 180, 95, 25);
		contentPane.add(label_9);

		fld_branchName = new JTextField();
		fld_branchName.setColumns(10);
		fld_branchName.setBounds(588, 183, 121, 23);
		contentPane.add(fld_branchName);

		JLabel label_10 = new JLabel("Year");
		label_10.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_10.setBounds(441, 233, 137, 25);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("Semester");
		label_11.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_11.setBounds(441, 282, 137, 25);
		contentPane.add(label_11);

		fld_courseName = new JTextField();
		fld_courseName.setColumns(10);
		fld_courseName.setBounds(588, 131, 121, 23);
		contentPane.add(fld_courseName);

		fld_studentYear = new JTextField();
		fld_studentYear.setColumns(10);
		fld_studentYear.setBounds(588, 236, 121, 23);
		contentPane.add(fld_studentYear);

		fld_studentSemester = new JTextField();
		fld_studentSemester.setColumns(10);
		fld_studentSemester.setBounds(588, 285, 121, 23);
		contentPane.add(fld_studentSemester);

		JLabel lblDateOfIssue = new JLabel("Date of Issue");
		lblDateOfIssue.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblDateOfIssue.setBounds(441, 342, 137, 25);
		contentPane.add(lblDateOfIssue);

		final JDateChooser date_issue = new JDateChooser();
		date_issue.setBounds(588, 347, 121, 20);
		contentPane.add(date_issue);

		JButton btn_issue = new JButton("ISSUE");
		btn_issue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "INSERT INTO issue_book "
						+ "(book_id,book_name,book_edition,book_publisher,book_price,book_pages,student_id,student_name,student_course,student_branch,student_year,student_semester,issue_date) VALUES"
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String date = "";

				try {
					date = sdf.format(date_issue.getDate());
					if (date.length() == 0) {
						JOptionPane.showMessageDialog(null, "Please add a valid date!");
					} else {
						String selectDate = date;

						preparedStatement = conn.prepareStatement(query);
						preparedStatement.setString(1, fld_bookID.getText());
						preparedStatement.setString(2, fld_bookName.getText());
						preparedStatement.setString(3, fld_bookEdition.getText());
						preparedStatement.setString(4, fld_bookPublisher.getText());
						preparedStatement.setString(5, fld_bookPrice.getText());
						preparedStatement.setString(6, fld_studentID.getText());
						preparedStatement.setString(7, fld_studentID.getText());
						preparedStatement.setString(8, fld_studentName.getText());
						preparedStatement.setString(9, fld_courseName.getText());
						preparedStatement.setString(10, fld_branchName.getText());
						preparedStatement.setString(11, fld_studentYear.getText());
						preparedStatement.setString(12, fld_studentSemester.getText());
						preparedStatement.setString(13, selectDate);
						preparedStatement.execute();
						JOptionPane.showMessageDialog(null, "Book Issued!");
					}
				} catch (Exception e2) {
					System.out.println(e2);
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btn_issue.setForeground(Color.BLACK);
		btn_issue.setBackground(SystemColor.activeCaption);
		btn_issue.setBounds(441, 383, 111, 23);
		contentPane.add(btn_issue);

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
		btn_back.setBounds(588, 383, 121, 23);
		contentPane.add(btn_back);

		JButton btn_bookSearch = new JButton("SEARCH");
		btn_bookSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String book_id = fld_bookID.getText();
				String query = "SELECT * FROM book WHERE book_id ='" + book_id + "'";
				try {
					preparedStatement = conn.prepareStatement(query);
					rs = preparedStatement.executeQuery(query);
					if (rs.next()) {
						String bookName = rs.getString("Name");
						fld_bookName.setText(bookName);
						String bookEdition = rs.getString("Edition");
						fld_bookEdition.setText(bookEdition);
						String bookPublisher = rs.getString("Publisher");
						fld_bookPublisher.setText(bookPublisher);
						String bookPrice = rs.getString("Price");
						fld_bookPrice.setText(bookPrice);
						String bookPages = rs.getString("Pages");
						fld_bookPages.setText(bookPages);
						rs.close();
						preparedStatement.close();
					} else {
						JOptionPane.showMessageDialog(null, "Can't find a registry for this ID.");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				} finally {
					try {
						rs.close();
						preparedStatement.close();
					} catch (Exception e3) {

					}
				}
			}
		});
		btn_bookSearch.setForeground(Color.BLACK);
		btn_bookSearch.setBackground(SystemColor.activeCaption);
		btn_bookSearch.setBounds(291, 32, 111, 23);
		contentPane.add(btn_bookSearch);

		JButton button = new JButton("SEARCH");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String student_id = fld_studentID.getText();
				String query = "SELECT * FROM student WHERE student_id ='" + student_id + "'";
				try {
					preparedStatement = conn.prepareStatement(query);
					rs = preparedStatement.executeQuery(query);
					if (rs.next()) {
						String studentName = rs.getString("Name");
						fld_studentName.setText(studentName);
						String courseName = rs.getString("Course");
						fld_courseName.setText(courseName);
						String branchName = rs.getString("Branch");
						fld_branchName.setText(branchName);
						String studentYear = rs.getString("Year");
						fld_studentYear.setText(studentYear);
						String studentSemester = rs.getString("Semester");
						fld_studentSemester.setText(studentSemester);
						rs.close();
						preparedStatement.close();
					} else {
						JOptionPane.showMessageDialog(null, "Can't find a registry for this ID.");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				} finally {
					try {
						rs.close();
						preparedStatement.close();
					} catch (Exception e3) {

					}
				}
			}
		});
		button.setForeground(Color.BLACK);
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(719, 32, 111, 23);
		contentPane.add(button);
	}
}
