package domain;

import java.util.Date;

public class Event {

	private Integer id;
	private String name;
	private Date date;
	private String place;
	private Integer capacity;
	private String contents;
	private String remarks;
	
	public Event(Integer id, String name, Date date, String place, Integer capacity, String contents, String remarks) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.place = place;
		this.capacity = capacity;
		this.contents = contents;
		this.remarks = remarks;
	}

	public Event() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	
}
