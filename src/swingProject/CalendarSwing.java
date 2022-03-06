package swingProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CalendarSwing extends JFrame implements ActionListener{

	Container cp;
	JTextField dDate,aDate;
	JButton nextBtn, beforeBtn,finishBtn, mainBtn;
 	JPanel panel;
	JLabel yearLabel,monthLabel,dDateLabel,aDateLabel;
	ImageIcon underbar= new ImageIcon("/Users/igyeonglyong/Desktop/Swing project/underbar.png");
	ImageIcon airplane= new ImageIcon("/Users/igyeonglyong/Desktop/Swing project/airplane.png");
	
	//
	JButton[] dayButtons = new JButton[49];
	String[] dayName = {"일","월","화","수","목","금","토"};
	CalendarJava cal = new CalendarJava();
	int index = 1;


	/*
	 * 이벤트
	 * */
	
	//month 바꾸기
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		int gap = 0;
		
		if(ob == nextBtn) {
			gap = 1;
			cal.otherMonth(gap);
			yearLabel.setText(cal.getYear()+".");
			monthLabel.setText(cal.getMonth()+".");
			
		}else if(ob == beforeBtn) {
			gap = -1;
			cal.otherMonth(gap);
			yearLabel.setText(cal.getYear()+".");
			monthLabel.setText(cal.getMonth()+".");
		}
		
		//날짜 선택하기
		String departure = "";
		
		for(int i = 0; i < dayButtons.length; i++) {
				if(ob == dayButtons[i] && index == 1) { //첫번째 클릭 일경우
					 //현재 몇일인지 받아오기
					departure = cal.getDay(i);
					index = 2;
					dDate.setText(departure);
					
					}else if(ob == dayButtons[i] && index == 2) {//두번째 클릭 일경우
					departure = cal.getDay(i);//현재 몇일인지 받아오기
					index = 1;
					aDate.setText(departure);
					}
				}
		
	}

	
	
	public void essentialSwingFrame() {
		
		cp = this.getContentPane();
		this.setBounds(500,100,600,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(255,255,255));
	}
	
	
	
	public void initDesign() {
		this.setLayout(null);
		
		
		/*레이아웃 시작*/
		
		
		//비행기 이미지 나오는 완료 버튼 
		//이거 누르면 db에 값 가지고 와서 해당 출발일 비행기 목록 보여주기
		finishBtn = new JButton(airplane);
		finishBtn.setBounds(420, 75, 100, 100);
		finishBtn.setBorderPainted(false);//이미지 삽입시,jbtn의 테두리 없애기
		finishBtn.setContentAreaFilled(false);//이미지 삽입시 배경없애기
		this.add(finishBtn);
		
		//월 넘기기 버튼 구현
		//이미지로구현해줌.
		
		mainBtn = new JButton(new ImageIcon("/Users/igyeonglyong/Desktop/Swing project/mainlogo.jpeg"));
		mainBtn.setBorderPainted(false);//이미지 삽입시,jbtn의 테두리 없애기
		mainBtn.setContentAreaFilled(false);//이미지 삽입시 배경없애기
		mainBtn.setBounds(0, 0, 200, 70);
		this.add(mainBtn);
		
		
		beforeBtn = new JButton(new ImageIcon("/Users/igyeonglyong/Desktop/Swing project/beforeBtn.png"));
		beforeBtn.setBounds(25, 370, 20, 30);
		beforeBtn.setBorderPainted(false);//이미지 삽입시,jbtn의 테두리 없애기
		beforeBtn.setContentAreaFilled(false);//이미지 삽입시 배경없애기
		this.add(beforeBtn);
				
		nextBtn= new JButton(new ImageIcon("/Users/igyeonglyong/Desktop/Swing project/nextBtn.png"));
		nextBtn.setBounds(550, 370, 20, 30);
		nextBtn.setBorderPainted(false);//이미지 삽입시,jbtn의 테두리 없애기
		nextBtn.setContentAreaFilled(false);//이미지 삽입시 배경없애기
		this.add(nextBtn);
		
		
		//가는날 오는날 입력하는 textfield,label,btn
		
		dDateLabel = new JLabel("가는날 ( YYYY.MM.DD. )");
		dDateLabel.setBounds(70, 75, 150, 35);
		this.add(dDateLabel);
		aDateLabel = new JLabel("오는날 ( YYYY.MM.DD. )");
		aDateLabel.setBounds(250, 75, 150, 35);
		this.add(aDateLabel);
		
		JLabel nuderbar_dDate = new JLabel(underbar);
		nuderbar_dDate.setBounds(70, 125, 150, 35);
		this.add(nuderbar_dDate);
		
		JLabel nuderbar_aDate = new JLabel(underbar);
		nuderbar_aDate.setBounds(250, 125, 150, 35);
		this.add(nuderbar_aDate);
		
		//가는날과 오는날을 입력할 textfield
		//익명클래스로 setBorder메소드로 테두리 없애줌.
		dDate = new JTextField(""){
            @Override
            public void setBorder(Border border) {
            }
        };
		dDate.setBounds(75, 110, 150, 35);
		this.add(dDate);
		
		aDate = new JTextField(""){
            @Override
            public void setBorder(Border border) {
            }
        };
		aDate.setBounds(255, 110, 150, 35);
		this.add(aDate);
		
		
		
		/*
		캘린더 레이아웃.
		*/
	
		
		yearLabel = new JLabel(cal.getYear()+".");
		yearLabel.setBounds(230, 200, 100, 35);
		yearLabel.setFont(new Font(getName(), Font.BOLD, 30));
		this.add(yearLabel);
		
		
		monthLabel = new JLabel(cal.getMonth()+".");
		monthLabel.setBounds(320, 200, 60, 35);
		monthLabel.setFont(new Font(getName(), Font.BOLD, 30));
		this.add(monthLabel);
		
		
		
		//달력을 표시해줄 패널 추가
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new GridLayout(7, 7, 5, 5));
		for(int i = 0; i < dayButtons.length; i++) {
			dayButtons[i] = new JButton();
			panel.add(dayButtons[i]);
			
			if(i < 7) //맨 첫재줄에 요일을 넣어줌
				dayButtons[i].setText(dayName[i]);
			if(i%7 == 6)
				dayButtons[i].setForeground(Color.blue);
			if(i%7 == 0)
				dayButtons[i].setForeground(Color.red);
		}
		
		
		
		panel.setBounds(100, 250, 400, 350);
		this.add(panel);
		
		//여기서 get을 안했는데, 왜 적용 되는지 궁금.
		cal.setDayButtons(dayButtons);
		cal.calSet();
		
		
		//이벤트 추가
		nextBtn.addActionListener(this);
		beforeBtn.addActionListener(this);
		
		for(int i = 0; i < dayButtons.length; i++) {
			dayButtons[i].addActionListener(this);
		}
		
		
		
	}
	
	
	public CalendarSwing(String title) {
		super(title);
		essentialSwingFrame();
		initDesign();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new CalendarSwing("");
	
	}


	
	

}


