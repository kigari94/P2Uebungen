package animal;

public class AnimalMain {

	public static void main(String[] args) {
		Animal [] animal = new Animal[7];
		animal[0] = new Lion(true, true);
		animal[1] = new Lion(false, true);
		animal[2] = new CommonBlackBird(true, false);
		animal[3] = new CommonBlackBird(false, true);
		animal[4] = new CommonBlackBird(false, false);
		animal[5] = new Jellyfish(true);
		animal[6] = new Jellyfish(false);
		
		for(Animal a : animal) {
			if(a instanceof ISound) {
				((ISound) a).makeSound();
			}
			System.out.println(a.getFeed());
		}
	}

}
