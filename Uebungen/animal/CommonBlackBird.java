package animal;

public class CommonBlackBird extends Animal implements ISound {
	private boolean insects;
	private boolean berries;
	
	public CommonBlackBird(boolean insects, boolean berries) {
		super();
		this.insects = insects;
		this.berries = berries;
	}

	@Override
	public String getFeed() {
		if(insects) {
			return "Insects to eat";
		}else if(berries) {
			return "Berries to eat";
		}else {
			return "Nothing to eat";
		}
	}

	@Override
	public void makeSound() {
		System.out.println("Cheep cheep");
		
	}
	
}
