package interfaces1;

public class Car implements IMovable {
	
	private float x;
	private float y;
	private float xVelocity;
	
	public Car(float x, float y, float xVelocity) {
		super();
		this.x = x;
		this.y = y;
		this.xVelocity = xVelocity;
	}

	@Override
	public void move() {
		x = x + xVelocity;
		System.out.println("New coordinates car: " + x + " for x + " + y + " for y");		
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getxVelocity() {
		return xVelocity;
	}

}
