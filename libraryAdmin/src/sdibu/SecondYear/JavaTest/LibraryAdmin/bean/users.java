package sdibu.SecondYear.JavaTest.LibraryAdmin.bean;

public class users {
	private int id;
	private String name;
	private String passward;
	private boolean power;
	private boolean frozen;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public boolean isFrozen() {
		return frozen;
	}
	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}
	public users(int id, String name, String passward, boolean power, boolean frozen) {
		super();
		this.id = id;
		this.name = name;
		this.passward = passward;
		this.power = power;
		this.frozen = frozen;
	}

}
