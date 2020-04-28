import java.util.HashMap;

public class PanGalacticGargleBlaster {

	private String Owner;
	private int shakeCounter;
	private HashMap<String, String> ingredients = new HashMap<>();
	private String recipe;

	public PanGalacticGargleBlaster(String owner, int shakeCounter, HashMap<String, String> ingredients,
			String recipe) {
		super();
		Owner = owner;
		this.shakeCounter = shakeCounter;
		this.ingredients = ingredients;
		this.recipe = recipe;
	}

	public String getOwner() {
		return Owner;
	}

	public void setOwner(String owner) {
		Owner = owner;
	}

	public int getShakeCounter() {
		return shakeCounter;
	}

	public void setShakeCounter(int shakeCounter) {
		this.shakeCounter = shakeCounter;
	}

	public HashMap<String, String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(HashMap<String, String> ingredients) {
		this.ingredients = ingredients;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

}
