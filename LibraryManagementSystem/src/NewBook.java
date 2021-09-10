import java.awt.EventQueue;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class NewBook extends JFrame {
	Connection conn;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement;

	private JPanel contentPane;
	private JTextField fld_bookID;
	private JTextField fld_bookName;
	private JTextField fld_bookPages;
	private JTextField fld_bookPublisher;
	private JTextField fld_bookPrice;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBook frame = new NewBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NewBook() {
		conn = JavaConnection.ConnerDb();
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 425);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "New Book",
				TitledBorder.LEFT, TitledBorder.TOP, null, SystemColor.activeCaption));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblBookId.setBounds(52, 22, 95, 25);
		contentPane.add(lblBookId);

		fld_bookID = new JTextField();
		fld_bookID.setColumns(10);
		fld_bookID.setBounds(187, 25, 121, 23);
		contentPane.add(fld_bookID);

		JLabel label_1 = new JLabel("Name");
		label_1.setFont(new Font("Bell MT", Font.PLAIN, 18));
		label_1.setBounds(52, 70, 95, 25);
		contentPane.add(label_1);

		fld_bookName = new JTextField();
		fld_bookName.setColumns(10);
		fld_bookName.setBounds(187, 73, 121, 23);
		contentPane.add(fld_bookName);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblPrice.setBounds(52, 226, 95, 25);
		contentPane.add(lblPrice);

		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblEdition.setBounds(52, 121, 137, 25);
		contentPane.add(lblEdition);

		final JComboBox select_bookEdition = new JComboBox();
		select_bookEdition.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
		select_bookEdition.setBackground(SystemColor.activeCaption);
		select_bookEdition.setBounds(187, 124, 121, 22);
		contentPane.add(select_bookEdition);

		JLabel lblPages = new JLabel("Pages");
		lblPages.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblPages.setBounds(52, 275, 95, 25);
		contentPane.add(lblPages);

		fld_bookPages = new JTextField();
		fld_bookPages.setColumns(10);
		fld_bookPages.setBounds(187, 278, 121, 23);
		contentPane.add(fld_bookPages);

		JButton btn_add = new JButton("ADD");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "INSERT INTO book " + "(book_id,name,edition,publisher,price,pages) VALUES"
						+ "(?,?,?,?,?,?)";
				try {
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setString(1, fld_bookID.getText());
					preparedStatement.setString(2, fld_bookName.getText());
					preparedStatement.setString(3, (String) select_bookEdition.getSelectedItem());
					preparedStatement.setString(4, fld_bookPublisher.getText());
					preparedStatement.setString(5, fld_bookPrice.getText());
					preparedStatement.setString(6, fld_bookPages.getText());
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null, "New book added!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btn_add.setForeground(Color.BLACK);
		btn_add.setBackground(SystemColor.activeCaption);
		btn_add.setBounds(52, 341, 111, 23);
		contentPane.add(btn_add);

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
		btn_back.setBounds(187, 341, 121, 23);
		contentPane.add(btn_back);

		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Bell MT", Font.PLAIN, 18));
		lblPublisher.setBounds(52, 173, 95, 25);
		contentPane.add(lblPublisher);

		fld_bookPublisher = new JTextField();
		fld_bookPublisher.setColumns(10);
		fld_bookPublisher.setBounds(187, 177, 121, 23);
		contentPane.add(fld_bookPublisher);

		fld_bookPrice = new JTextField();
		fld_bookPrice.setColumns(10);
		fld_bookPrice.setBounds(187, 230, 121, 23);
		contentPane.add(fld_bookPrice);
	}
}
