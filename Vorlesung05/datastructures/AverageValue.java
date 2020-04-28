package datastructures;

public class AverageValue {

	double value;
	String status;

	public AverageValue(double value, String status) {
		super();
		this.value = value;
		this.status = status;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
