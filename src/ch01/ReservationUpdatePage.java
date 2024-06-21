package ch01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ReservationUpdatePage extends JFrame {

	private JPanel backgroundPanel;
	private JButton updateCarBtn;
	private JButton updateDateBtn;
	private JTextField reservationId;
	private JTextField reservationname;
	private JTextField reservationPhoneNumber;
	private JTextField reservationCarName;
	private JTextField reservationCarNumber;
	private JTextField reservationCarType;
	private JTextField reservationCarBrand;
	private JTextField reservationCarPuel;
	private JTextField reservationCarRentDate;
	private JTextField reservationCarReturnDate;

	private JTextField id;
	private JTextField name;
	private JTextField phoneNumber;

	private JTextField title;
	
	private JTextField cartype;
	private JTextField carbrand;
	private JTextField carpuel;
	private JTextField rentdate;
	private JTextField returndate;

	private JTextField carName;
	private JTextField carNumber;

	private JTextField reservationPersonInfo;
	private JTextField reservationCarInfo;

	// 버튼
	private ImageIcon periodImg;
	private ImageIcon changeCarImg;

	private ImageIcon carImage;
	private JLabel imgLabel;

	private Color backgrounColor = new Color(220, 220, 220);

	private JLabel lineImgLabel;
	private ImageIcon lineImg;

	public ReservationUpdatePage() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		backgroundPanel = new BackgroundPanel();

		lineImg = new ImageIcon("img/img1.png");
		lineImgLabel = new JLabel(lineImg);
		backgroundPanel.add(lineImgLabel);

		
		title = new JTextField("예약 변경하기");
		
		// 버튼
		periodImg = new ImageIcon("img/changePeriod.png");
		changeCarImg = new ImageIcon("img/changeCar.png");

		carImage = new ImageIcon("img/car.jpg");
		imgLabel = new JLabel(carImage);

		carName = new JTextField("현대 팔리세이드");
		carNumber = new JTextField("17가3124");

		updateCarBtn = new JButton(changeCarImg);
		updateDateBtn = new JButton(periodImg);

		reservationId = new JTextField("예약 번호");
		reservationname = new JTextField("성함");
		reservationPhoneNumber = new JTextField("전화번호");

		reservationCarName = new JTextField("차량 이름");
		reservationCarNumber = new JTextField("차량 번호");
		reservationCarType = new JTextField("차종");
		reservationCarBrand = new JTextField("차량 브랜드");
		reservationCarPuel = new JTextField("차량 유종");
		reservationCarRentDate = new JTextField("대여일");
		reservationCarReturnDate = new JTextField("반납일");

		reservationPersonInfo = new JTextField("예약자 정보");
		reservationCarInfo = new JTextField("예약된 차량 정보");

		// 값 받아오기
		id = new JTextField();
		name = new JTextField();
		phoneNumber = new JTextField();

		cartype = new JTextField();
		carbrand = new JTextField();
		carpuel = new JTextField();
		rentdate = new JTextField();
		returndate = new JTextField();
	}

	public void setInitLayout() {
		// 프레임 설정
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		
		title.setBounds(185, 20, 400, 80);
		title.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		title.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		title.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		title.setBackground(Color.white);
		title.setHorizontalAlignment(JTextField.CENTER);
		title.setFont(new Font("굴림", Font.BOLD, 20));

		backgroundPanel.add(title);
		
		
		id.setBounds(549, 200, 190, 30);
		name.setBounds(549, 230, 190, 30);
		phoneNumber.setBounds(549, 260, 190, 30);
		id.setBorder(new LineBorder(new Color(0, 0, 0)));
		name.setBorder(new LineBorder(new Color(0, 0, 0)));
		phoneNumber.setBorder(new LineBorder(new Color(0, 0, 0)));

		cartype.setBounds(549, 350, 190, 30);
		carbrand.setBounds(549, 380, 190, 30);
		carpuel.setBounds(549, 410, 190, 30);
		rentdate.setBounds(549, 440, 190, 30);
		returndate.setBounds(549, 470, 190, 30);
		cartype.setBorder(new LineBorder(new Color(0, 0, 0)));
		carbrand.setBorder(new LineBorder(new Color(0, 0, 0)));
		carpuel.setBorder(new LineBorder(new Color(0, 0, 0)));
		rentdate.setBorder(new LineBorder(new Color(0, 0, 0)));
		returndate.setBorder(new LineBorder(new Color(0, 0, 0)));

		// 차 이미지

		imgLabel.setBounds(50, 210, 300, 300);
		backgroundPanel.add(imgLabel);

		// 차이름 차넘버
		carName.setBounds(120, 110, 160, 50);
		carName.setFont(new Font("굴림", Font.BOLD, 20));
		carNumber.setBounds(145, 170, 100, 30);
		carNumber.setFont(new Font("굴림", Font.BOLD, 15));
		backgroundPanel.add(carName);
		backgroundPanel.add(carNumber);
		carName.setHorizontalAlignment(JTextField.CENTER);
		carNumber.setHorizontalAlignment(JTextField.CENTER);
		carName.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		carName.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		carName.setHorizontalAlignment(JTextField.CENTER);
		carName.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		carNumber.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		carNumber.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		carNumber.setHorizontalAlignment(JTextField.CENTER);
		carNumber.setBorder(new LineBorder(new Color(0, 0, 0, 0)));

		// 패널
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		// 버튼
		updateCarBtn.setBounds(70, 580, 300, 100);
		updateDateBtn.setBounds(430, 580, 300, 100);

		// 예약자 정보
		reservationPersonInfo.setBounds(450, 160, 100, 30);
		reservationPersonInfo.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		reservationPersonInfo.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		reservationPersonInfo.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		reservationPersonInfo.setBackground(new Color(0, 0, 0, 0));

		reservationId.setBounds(450, 200, 100, 30);
		reservationId.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationId.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		reservationId.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		reservationId.setBackground(backgrounColor);
		reservationId.setHorizontalAlignment(JTextField.CENTER);

		reservationname.setBounds(450, 230, 100, 30);
		reservationname.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationname.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		reservationname.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		reservationname.setBackground(backgrounColor);
		reservationname.setHorizontalAlignment(JTextField.CENTER);

		reservationPhoneNumber.setBounds(450, 260, 100, 30);
		reservationPhoneNumber.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationPhoneNumber.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		reservationPhoneNumber.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		reservationPhoneNumber.setBackground(backgrounColor);
		reservationPhoneNumber.setHorizontalAlignment(JTextField.CENTER);

		// 차량 정보
		reservationCarInfo.setBounds(450, 310, 100, 30);
		reservationCarInfo.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		reservationCarInfo.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		reservationCarInfo.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		reservationCarInfo.setBackground(new Color(0, 0, 0, 0));

		reservationCarType.setBounds(450, 350, 100, 30);
		reservationCarType.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationCarType.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		reservationCarType.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		reservationCarType.setBackground(backgrounColor);
		reservationCarType.setHorizontalAlignment(JTextField.CENTER);

		reservationCarBrand.setBounds(450, 380, 100, 30);
		reservationCarBrand.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationCarBrand.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		reservationCarBrand.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		reservationCarBrand.setBackground(backgrounColor);
		reservationCarBrand.setHorizontalAlignment(JTextField.CENTER);

		reservationCarPuel.setBounds(450, 410, 100, 30);
		reservationCarPuel.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationCarPuel.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		reservationCarPuel.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		reservationCarPuel.setBackground(backgrounColor);
		reservationCarPuel.setHorizontalAlignment(JTextField.CENTER);

		reservationCarRentDate.setBounds(450, 440, 100, 30);
		reservationCarRentDate.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationCarRentDate.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		reservationCarRentDate.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		reservationCarRentDate.setBackground(backgrounColor);
		reservationCarRentDate.setHorizontalAlignment(JTextField.CENTER);

		reservationCarReturnDate.setBounds(450, 470, 100, 30);
		reservationCarReturnDate.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationCarReturnDate.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		reservationCarReturnDate.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		reservationCarReturnDate.setBackground(backgrounColor);
		reservationCarReturnDate.setHorizontalAlignment(JTextField.CENTER);

		backgroundPanel.add(reservationCarInfo);
		backgroundPanel.add(reservationCarName);
		backgroundPanel.add(reservationCarNumber);
		backgroundPanel.add(reservationCarType);
		backgroundPanel.add(reservationCarBrand);
		backgroundPanel.add(reservationCarPuel);
		backgroundPanel.add(reservationCarRentDate);
		backgroundPanel.add(reservationCarReturnDate);

		backgroundPanel.add(reservationId);
		backgroundPanel.add(reservationname);
		backgroundPanel.add(reservationPhoneNumber);
		backgroundPanel.add(reservationPersonInfo);
		backgroundPanel.add(updateCarBtn);
		backgroundPanel.add(updateDateBtn);
		
		id.setHorizontalAlignment(JTextField.CENTER);
		name.setHorizontalAlignment(JTextField.CENTER);
		phoneNumber.setHorizontalAlignment(JTextField.CENTER);
		cartype.setHorizontalAlignment(JTextField.CENTER);
		carbrand.setHorizontalAlignment(JTextField.CENTER);
		carpuel.setHorizontalAlignment(JTextField.CENTER);
		rentdate.setHorizontalAlignment(JTextField.CENTER);
		returndate.setHorizontalAlignment(JTextField.CENTER);
		
		id.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		id.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		id.setBackground(Color.white);
		
		name.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		name.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		name.setBackground(Color.white);
		 
		phoneNumber.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		phoneNumber.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		phoneNumber.setBackground(Color.white);
		
		cartype.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		cartype.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		cartype.setBackground(Color.white);
		
		carbrand.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		carbrand.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		carbrand.setBackground(Color.white);
		
		carpuel.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		carpuel.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		carpuel.setBackground(Color.white);
		
		rentdate.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		rentdate.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		rentdate.setBackground(Color.white);
		
		returndate.setEditable(false); // 입력불가상태 (텍스트 색상변경가능)
		returndate.setForeground(Color.BLACK); // 메인보드 텍스트 검정색
		returndate.setBackground(Color.white);
		
		
		
		
		backgroundPanel.add(id);
		backgroundPanel.add(name);
		backgroundPanel.add(phoneNumber);
		backgroundPanel.add(cartype);
		backgroundPanel.add(carbrand);
		backgroundPanel.add(carpuel);
		backgroundPanel.add(rentdate);
		backgroundPanel.add(returndate);

		setVisible(true);

		// line

		MyDrawPanel drawpanel = new MyDrawPanel();
		drawpanel.setBackground(Color.white);
		drawpanel.setSize(800, 800);
		drawpanel.setVisible(true);
		backgroundPanel.add(drawpanel);

		repaint();
	}

	class MyDrawPanel extends JPanel {
		public void paint(Graphics g) {
			super.paintComponent(g);
			g.drawRoundRect(30, 135, 730, 400, 20, 20);

		}
	}

	private class BackgroundPanel extends JPanel {
		// private Image backgroundImage;
		private JPanel backgroundPanel;

		// 백그라운드 패널
		public BackgroundPanel() {
			// backgroundImage = new ImageIcon("img/background.jpg").getImage();
			backgroundPanel = new JPanel();
		}
	}
	
	private void addEventListener() {
		updateCarBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			}
		});
		
		updateDateBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			}
		});
	}

	public static void main(String[] args) {
		new ReservationUpdatePage();
	}
}