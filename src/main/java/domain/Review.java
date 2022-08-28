package domain;

public class Review {

	private Integer id;
	private String name;
	private String comment;
	private Integer evaluation;
	
	public Review(Integer id, String name, String comment, Integer evaluation) {
		super();
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.evaluation = evaluation;
	}

	public Review() {
		
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

	public String getContents() {
		return comment;
	}

	public void setContents(String comment) {
		this.comment = comment;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}
	
}
