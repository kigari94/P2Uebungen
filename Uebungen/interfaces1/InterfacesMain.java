package interfaces1;

public class InterfacesMain {

	public static void main(String[] args) {
		IMovable [] object = new IMovable[2];
		object[0] = new Ball(0.0f, 0.0f, 10.6f, 5.5f);
		object[1] = new Car(0.8f, 0.0f, 120);
		
		for(IMovable obj : object) {
			obj.move();			
		}
	}

}
