package interfaces1;

public class Ball implements IMovable {
	
	private float x;
	private float y;
	private float xVelocity;
	private float yVelocity;
	
	public Ball(float x, float y, float xVelocity, float yVelocity) {
		super();
		this.x = x;
		this.y = y;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}

	@Override
	public void move() {
		x = x + xVelocity;
		y = y + yVelocity;
		System.out.println("New coordinates ball: " + x + " for x + " + y + " for y");
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

	public float getyVelocity() {
		return yVelocity;
	}
		
}
