package calendar;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingCalendar3 extends JFrame implements Runnable {
	// 다이어리 생성
	Diary dr;
	// 패널
	JPanel term;
	JPanel calendar;
	// 라벨
	JLabel yearMonthLabel;
	// 달력 버튼
	JButton previousBtn;
	JButton nextBtn;
	private ImageIcon prebtnIcon;
	private ImageIcon nextbtnIcon;
	// 요일 버튼
	JButton[] buttons;
	// 요일
	private String[] dayAr = { "Sun", "Mon", "Tue", "Wen", "Thur", "Fri", "Sat" };
	// 폰트
	Font font;
	// 날짜 조절
	int gap;
	// 클릭횟수 조절
	private int clickCount;

	// 버튼 텍스트 가져오기
	String firstButtonText;
	String secondButtonText;

	// 버튼 클릭 횟수
	private boolean firstClick = true;
	private boolean secondClick = true;
	private int firstClickedIndex = -1;

	public SwingCalendar3() {
		dr = new Diary();
		initData();
		setInitLayout();

		new Thread(this).start();
	}

	public void initData() {
		// 패널
		calendar = new JPanel();
		term = new JPanel();
		// 라벨
		yearMonthLabel = new JLabel("00년 0월");

		// 버튼
		prebtnIcon = new ImageIcon("img/left.png");
		nextbtnIcon = new ImageIcon("img/right.png");
		previousBtn = new JButton(prebtnIcon);
		nextBtn = new JButton(nextbtnIcon);
		buttons = new JButton[49];

		// 폰트
		font = new Font("SansSerif", Font.BOLD, 24);

	}

	public void setInitLayout() {
		// 프레임 설정
		setTitle("예약");
		setSize(565, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		// 백그라운드 패널
		calendar.setLayout(new GridLayout(7, 7, 5, 5));
		calendar.setBackground(Color.white);
		calendar.setLocation(0, 100);
		calendar.setSize(550, 260);
		add(calendar);

		term.setBackground(Color.WHITE);
		term.setSize(550, 100);
		term.setLocation(0, 0);
		term.setLayout(new GridLayout(0, 1, 10, 5));
		add(term);

		// 버튼사이 라벨
		yearMonthLabel.setSize(230, 100);
		yearMonthLabel.setLocation(220, 0);
		yearMonthLabel.setFont(font);
		yearMonthLabel.setText(dr.getCalText());
		add(yearMonthLabel, 0);

		// 버튼
		previousBtn.setSize(45, 50);
		previousBtn.setLocation(150, 25);
		previousBtn.setBorder(null);
		previousBtn.setContentAreaFilled(false);
		add(previousBtn, 0);

		nextBtn.setSize(45, 50);
		nextBtn.setLocation(350, 25);
		nextBtn.setBorder(null);
		nextBtn.setContentAreaFilled(false);
		add(nextBtn, 0);

		setVisible(true);
	}

	public void run() {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			final int index = i;
			clickCount = 1;
			calendar.add(buttons[i]);
			buttons[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (clickCount % 2 == 1) {
						buttons[index].setEnabled(false);
						firstButtonText = buttons[index].getText();
						System.out.println(dr.getAllCal(firstButtonText));
					} else if (clickCount % 2 == 0) {
						secondButtonText = buttons[index].getText();
						System.out.println(dr.getAllCal(secondButtonText));

						buttons[index].setEnabled(true);
					}
					clickCount++;
					if (firstClick) {
						firstClickedIndex = index;
						firstClick = false;
						System.out.println("대여일 : " + dr.getAllCal(firstButtonText));
					} else {
						int secondClickedIndex = index;

						int start = Math.min(firstClickedIndex, secondClickedIndex);
						int end = Math.max(firstClickedIndex, secondClickedIndex);
						System.out.println("반납일 : " + dr.getAllCal(secondButtonText));
						for (int j = start + 1; j < end + 1; j++) {
							buttons[j].setEnabled(false);
							if (j >= start && j <= end) {
								buttons[j].setEnabled(false);
							}

						}
						firstClickedIndex = -1;
						firstClick = true;
					}
				}
			});
			buttons[i].setFont(new Font("SansSerif", font.BOLD, 20));
			if (i < 7) {
				buttons[i].setText(dayAr[i]);
				buttons[i].setEnabled(false);
				buttons[i].setFont(new Font("SansSerif", font.BOLD, 18));
			}
			if (i % 7 == 0) {
				buttons[i].setForeground(Color.RED);
			}
			if (i % 7 == 6) {
				buttons[i].setForeground(Color.BLUE);
			}
		}
		dr.setButtons(buttons);
		dr.setCal();

		previousBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getSource() == previousBtn) {
					gap = -1;
				}
				dr.initCalData(gap);
				yearMonthLabel.setText(dr.getCalText());
			}
		});
		nextBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getSource() == nextBtn) {
					gap = 1;
				}
				dr.initCalData(gap);
				yearMonthLabel.setText(dr.getCalText());
			}
		});
	}

	public static void main(String[] args) {
		new SwingCalendar3();
	}

}