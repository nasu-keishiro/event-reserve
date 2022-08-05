package domain;

public class Reserve {

	private Integer id;
	private String name;
	private Integer age;
	private String address;
	private Integer tell;
	private String email;
	private Integer reserveNum;
	
	public Reserve(Integer id, String name, Integer age, String address, Integer tell, String email,
			Integer reserveNum) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.tell = tell;
		this.email = email;
		this.reserveNum = reserveNum;
	}

	public Reserve() {
		

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTell() {
		return tell;
	}

	public void setTell(Integer tell) {
		this.tell = tell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getReserveNum() {
		return reserveNum;
	}

	public void setReserveNum(Integer reserveNum) {
		this.reserveNum = reserveNum;
	}
	
	
}
