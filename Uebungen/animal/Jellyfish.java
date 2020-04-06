package animal;

public class Jellyfish extends Animal{
	
	private boolean fish;
	
	public Jellyfish(boolean fish) {
		super();
		this.fish = fish;
	}

	@Override
	public String getFeed() {
		if(fish) {
			return "fish to eat";
		}else {
			return "Nothing to eat";
		}		
	}

}
