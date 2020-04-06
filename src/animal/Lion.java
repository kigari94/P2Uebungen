package animal;

public class Lion extends Animal {
	private boolean dark;
	private boolean game;

	public Lion(boolean dark, boolean game) {
		super();
		this.dark = dark;
		this.game = game;
	}

	@Override
	public String getFeed() {
		if(dark && game) {
			return "Eating deer";
		}else {
			return "Nothing to eat";
		}
	}

}
