package domain;

public class Review {

	private Integer id;
	private String name;
	private String email;
	private Integer evaluation;
	private String comment;
	private Integer eventNum;
	
	

	
	public Review(Integer id, String name, String email, Integer evaluation, String comment, Integer eventNum) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.evaluation = evaluation;
		this.comment = comment;
		this.eventNum = eventNum;
	}


	public Integer getEventNum() {
		return eventNum;
	}


	public void setEventNum(Integer eventNum) {
		this.eventNum = eventNum;
	}


	public Review() {
		
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
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



	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}
	
}
