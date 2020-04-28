package datastructures;

public class Account {

	String username;
	int phone;

	public Account(String username, int phone) {
		super();
		this.username = username;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj && this != null && obj instanceof Account) {
			return true;
		}
		return false;
	}

}