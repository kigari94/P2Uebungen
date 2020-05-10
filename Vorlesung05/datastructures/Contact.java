package datastructures;

import java.io.Serializable;

public class Contact implements Comparable<Contact>, Serializable {

	//TODO nutze die serialVersionUID
	/**
	 * 
	 */
	private static final long serialVersionUID = 8770199156546982101L;
	private String name;
	private long phone;

	public Contact(String name, int phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public int compareTo(Contact other) {
		if(name.equals("Chuck Norris")) {
			return -1;
		}else if (other.name.equals("Chuck Norris")) {
			return 1;
		// Unterchied zwichen den Werten je nachdem, ob sie als this- oder other-object geladen werden 
		// Dies hängt auch mit der Reihenfolge der Elemente zusammen
		}else if(other.name.contentEquals("Bob Ross") || other.name.equals("Bruce Lee")) {
			return 1;
		}else if(name.equals("Uwe Boll")) {
			return 1;
		}
		int val = name.compareTo(other.name);
		if(val == 0) {
			if(phone < other.phone) {
				return -1;
			}else if(phone >= other.phone) {
				return 1;
			}
		}
		return val;
	}

}
