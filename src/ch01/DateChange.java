package ch01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DateChange extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateChange frame = new DateChange();
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
	public DateChange() {
		ImageIcon img1 = new ImageIcon("buttonImage/대여일 선택하기.png");
		ImageIcon img2 = new ImageIcon("buttonImage/반납일 선택하기.png");
		ImageIcon img3 = new ImageIcon("buttonImage/대여기간 변경하기.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("변경가능한 날짜 JDBC 넣기");
		lblNewLabel.setBounds(180, 61, 528, 299);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("변경가능한 날짜");
		lblNewLabel_1.setFont(new Font("CookieRunOTF Black", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(22, 155, 146, 110);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton(img1);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 달력 띄우고 대여일 값 받아서 변수에 넣기
			}
		});
		btnNewButton.setBounds(115, 376, 247, 79);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton(img2);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 달력 띄우고 반납일 값 받아서 변수에 넣기
			}
		});
		btnNewButton_1.setBounds(469, 376, 239, 79);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton(img3);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 날짜 변경 쿼리 JDBC 실행
				// 변경된 예약 조회 쿼리 실행
			}
		});
		btnNewButton_2.setBounds(247, 489, 321, 79);
		contentPane.add(btnNewButton_2);
	}

}