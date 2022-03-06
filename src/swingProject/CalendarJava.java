package swingProject;

import java.util.Calendar;

import javax.swing.JButton;

public class CalendarJava {

	JButton[] dayButtons;
	Calendar cal = Calendar.getInstance();
	private int year, month;
	

	//getter/setter
	public JButton[] getDayButtons() {
		return dayButtons;
	}
	
	public void setDayButtons(JButton[] dayButtons) {
		this.dayButtons = dayButtons;
	}
	
	
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	//생성자
	public CalendarJava() {
		// TODO Auto-generated constructor stub
	year = cal.get(Calendar.YEAR);
	month = cal.get(Calendar.MONTH) + 1; //월에 +1찍어주는게 국룰이다.
	
	}

	public void calSet() {
		//객체의 날짜를 1로 설정
		cal.set(year, month-1, 1);
		
		int firstday = cal.get(Calendar.DAY_OF_WEEK);
		firstday--;
		
		for(int i= 1; i <= cal.getActualMaximum(cal.DATE); i++) {
			//배열 6까지는 월화수목... 이 들어가며 6이후부터 날짜를 출력한다.
			//매 달에 시작하는 첫번째 요일부터 i가 들어가며, 해당하는 버튼에 날짜르 넣어준다.
			dayButtons[6 + firstday + i].setText(String.valueOf(i)+"일");
		}
	
	}
	public void otherMonth(int gap) {
		
		for(int i = 7; i < dayButtons.length; i++) {
			//기존 날짜버튼 요일 제외하고 지우기
			dayButtons[i].setText("");
		}
		//달바꾸기 누를때마다 gap을 +-로 하나씩 가져온다.
		month += gap;
		//전년도로 갈 경우
		if(month <= 0) {
			year--;
			month = 12;
		}else if (month >= 13) { //내년도로 갈경우
			year++;
			month = 1;
		}
			calSet();
		
		}
	
	
	//현재 몇일인지 반환하는 메소드
	public String getDay(int i) {
		cal.set(year, month-1, 1);
		int firstday = cal.get(Calendar.DAY_OF_WEEK);
		firstday--;
		
		int day = i-firstday-6;
		//현재 날짜를 구하되, 요일부분을 클릭하거나 최대 요일을 넘어서 선택한 경우.
		if(day <= 0 || day > cal.getActualMaximum(Calendar.DAY_OF_MONTH))
			 return "날짜를 다시 선택해 주세요";
		
		return year + "." + month +"." + day;
	}
	
	
}
