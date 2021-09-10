import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ReturnBook extends JFrame {
	Connection conn;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	private JPanel contentPane;
	private JTextField fld_bookID;
	private JTextField fld_bookName;
	private JTextField fld_bookEditon;
	private JTextField fld_bookPublisher;
	private JTextField fld_bookPrice;
	private JTextField fld_bookPages;
	private JTextField fld_studentID;
	private JTextField fld_studentName;
	private JTextField fld_course;
	private JTextField fld_branch;
	private JTextField fld_studentYear;
	private JTextField fld_studentSemester;
	private JTextField fld_issueDate;

	public void Delete() {
		String query = "DELETE FROM issue_book WHERE student_id = ?";
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, fld_studentID.getText());
			preparedStatement.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ReturnBook() {
		conn = JavaConnection.ConnerDb();
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "Return Book", TitledBorder.LEFT, TitledBorder.TOP, null,
				SystemColor.activeCaption));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Book ID");
		label.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label.setBounds(20, 29, 95, 25);
		contentPane.add(label);

		fld_bookID = new JTextField();
		fld_bookID.setColumns(10);
		fld_bookID.setBounds(155, 32, 121, 23);
		contentPane.add(fld_bookID);

		JLabel label_1 = new JLabel("Name");
		label_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_1.setBounds(20, 77, 95, 25);
		contentPane.add(label_1);

		fld_bookName = new JTextField();
		fld_bookName.setColumns(10);
		fld_bookName.setBounds(155, 80, 121, 23);
		contentPane.add(fld_bookName);

		JButton btn_search = new JButton("SEARCH");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String student_id = fld_studentID.getText();
				String query = "SELECT * FROM issue_book WHERE student_id =" + student_id + "";
				try {
					preparedStatement = conn.prepareStatement(query);
					rs = preparedStatement.executeQuery(query);
					if (rs.next()) {
						String student_name = rs.getString("student_name");
						fld_studentName.setText(student_name);
						String student_course = rs.getString("student_course");
						fld_course.setText(student_course);
						String student_branch = rs.getString("student_branch");
						fld_branch.setText(student_branch);
						String student_year = rs.getString("student_year");
						fld_studentYear.setText(student_year);
						String student_semester = rs.getString("student_semester");
						fld_studentSemester.setText(student_semester);
						String book_id = rs.getString("book_id");
						fld_bookID.setText(book_id);
						String book_name = rs.getString("book_name");
						fld_bookName.setText(book_name);
						String book_edition = rs.getString("book_edition");
						fld_bookEditon.setText(book_edition);
						String book_publisher = rs.getString("book_publisher");
						fld_bookPublisher.setText(book_publisher);
						String book_price = rs.getString("book_price");
						fld_bookPrice.setText(book_price);
						String book_pages = rs.getString("book_pages");
						fld_bookPages.setText(book_pages);
						String issue_date = rs.getString("issue_date");
						fld_issueDate.setText(issue_date);

						rs.close();
						preparedStatement.close();
					} else {
						JOptionPane.showMessageDialog(null, "Book is not issued with this student ID.");
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
		btn_search.setForeground(Color.BLACK);
		btn_search.setBackground(SystemColor.activeCaption);
		btn_search.setBounds(615, 32, 111, 23);
		contentPane.add(btn_search);

		JLabel label_2 = new JLabel("Edition");
		label_2.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_2.setBounds(20, 128, 137, 25);
		contentPane.add(label_2);

		fld_bookEditon = new JTextField();
		fld_bookEditon.setColumns(10);
		fld_bookEditon.setBounds(155, 132, 121, 23);
		contentPane.add(fld_bookEditon);

		JLabel label_3 = new JLabel("Publisher");
		label_3.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_3.setBounds(20, 180, 95, 25);
		contentPane.add(label_3);

		fld_bookPublisher = new JTextField();
		fld_bookPublisher.setColumns(10);
		fld_bookPublisher.setBounds(155, 184, 121, 23);
		contentPane.add(fld_bookPublisher);

		JLabel label_4 = new JLabel("Price");
		label_4.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_4.setBounds(20, 233, 95, 25);
		contentPane.add(label_4);

		fld_bookPrice = new JTextField();
		fld_bookPrice.setColumns(10);
		fld_bookPrice.setBounds(155, 237, 121, 23);
		contentPane.add(fld_bookPrice);

		JLabel label_5 = new JLabel("Pages");
		label_5.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_5.setBounds(20, 282, 95, 25);
		contentPane.add(label_5);

		fld_bookPages = new JTextField();
		fld_bookPages.setColumns(10);
		fld_bookPages.setBounds(155, 285, 121, 23);
		contentPane.add(fld_bookPages);

		JLabel label_6 = new JLabel("Student ID");
		label_6.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_6.setBounds(327, 29, 95, 25);
		contentPane.add(label_6);

		fld_studentID = new JTextField();
		fld_studentID.setColumns(10);
		fld_studentID.setBounds(474, 32, 121, 23);
		contentPane.add(fld_studentID);

		JLabel label_7 = new JLabel("Name");
		label_7.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_7.setBounds(327, 77, 95, 25);
		contentPane.add(label_7);

		fld_studentName = new JTextField();
		fld_studentName.setColumns(10);
		fld_studentName.setBounds(474, 80, 121, 23);
		contentPane.add(fld_studentName);

		fld_course = new JTextField();
		fld_course.setColumns(10);
		fld_course.setBounds(474, 131, 121, 23);
		contentPane.add(fld_course);

		JLabel label_8 = new JLabel("Course");
		label_8.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_8.setBounds(327, 128, 137, 25);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("Branch");
		label_9.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_9.setBounds(327, 180, 95, 25);
		contentPane.add(label_9);

		fld_branch = new JTextField();
		fld_branch.setColumns(10);
		fld_branch.setBounds(474, 183, 121, 23);
		contentPane.add(fld_branch);

		JLabel label_10 = new JLabel("Year");
		label_10.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_10.setBounds(327, 233, 137, 25);
		contentPane.add(label_10);

		fld_studentYear = new JTextField();
		fld_studentYear.setColumns(10);
		fld_studentYear.setBounds(474, 236, 121, 23);
		contentPane.add(fld_studentYear);

		JLabel label_11 = new JLabel("Semester");
		label_11.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_11.setBounds(327, 282, 137, 25);
		contentPane.add(label_11);

		fld_studentSemester = new JTextField();
		fld_studentSemester.setColumns(10);
		fld_studentSemester.setBounds(474, 285, 121, 23);
		contentPane.add(fld_studentSemester);

		JLabel label_12 = new JLabel("Date of Issue");
		label_12.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_12.setBounds(20, 339, 137, 25);
		contentPane.add(label_12);

		final JDateChooser date_return = new JDateChooser();
		date_return.setBounds(474, 339, 121, 20);
		contentPane.add(date_return);

		JButton btn_return = new JButton("RETURN");
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete();

				String query = "INSERT INTO return_book "
						+ "(book_id,book_name,book_edition,book_publisher,book_price,book_pages,issue_date,student_id,student_name,student_course,student_branch,student_year,student_semester,return_date) VALUES"
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String date = "";
				try {
					date = sdf.format(date_return.getDate());
					if (date.length() == 0) {
						JOptionPane.showMessageDialog(null, "Please add a valid date!");
					} else {
						String returnDate = date;
						preparedStatement = conn.prepareStatement(query);
						preparedStatement.setString(1, fld_bookID.getText());
						preparedStatement.setString(2, fld_bookName.getText());
						preparedStatement.setString(3, fld_bookEditon.getText());
						preparedStatement.setString(4, fld_bookPublisher.getText());
						preparedStatement.setString(5, fld_bookPrice.getText());
						preparedStatement.setString(6, fld_bookPages.getText());
						preparedStatement.setString(7, fld_issueDate.getText());
						preparedStatement.setString(8, fld_studentID.getText());
						preparedStatement.setString(9, fld_studentName.getText());
						preparedStatement.setString(10, fld_course.getText());
						preparedStatement.setString(11, fld_branch.getText());
						preparedStatement.setString(12, fld_studentYear.getText());
						preparedStatement.setString(13, fld_studentSemester.getText());
						preparedStatement.setString(14, returnDate);
						preparedStatement.execute();
						JOptionPane.showMessageDialog(null, "Book Returned!");
					}
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btn_return.setForeground(Color.BLACK);
		btn_return.setBackground(SystemColor.activeCaption);
		btn_return.setBounds(327, 383, 111, 23);
		contentPane.add(btn_return);

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
		btn_back.setBounds(474, 383, 121, 23);
		contentPane.add(btn_back);

		fld_issueDate = new JTextField();
		fld_issueDate.setColumns(10);
		fld_issueDate.setBounds(155, 339, 121, 23);
		contentPane.add(fld_issueDate);

		JLabel lblReturnDate = new JLabel("Return Date");
		lblReturnDate.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblReturnDate.setBounds(327, 339, 137, 25);
		contentPane.add(lblReturnDate);
	}
}
