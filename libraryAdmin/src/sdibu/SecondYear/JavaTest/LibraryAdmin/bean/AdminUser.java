package sdibu.SecondYear.JavaTest.LibraryAdmin.bean;
//检测用户权限，冻结状态
public class AdminUser extends users {
	private boolean power;
	private boolean frozen;

	public AdminUser(String id, String name, String passward, boolean power, boolean frozen) {
		super(id, name, passward);
		this.power = power;
		this.frozen = frozen;
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


}
