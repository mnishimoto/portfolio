package dto;

public class ScheduleDto {
	/*
	 * スケジュール名
	 * */
	private String schedule;
	
	/*
	 * 開始予定時刻
	 * */
	private int start;
	
	/*
	 * 終了予定時刻
	 * */
	private int end;

	/*
	 * id
	 * */
	private int id;
	
	private String date;
	

	public String getSchedule() {
		return schedule;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setschedule(String schedule) {
		this.schedule = schedule;
	}

	public int getStart() {
		return start;
	}
	

	public void setStart(int start) {
		this.start = start;
	}
	
	public int getEnd() {
		return end;
	}
	

	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
}
