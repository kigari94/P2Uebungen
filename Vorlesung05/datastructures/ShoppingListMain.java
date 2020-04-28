package datastructures;

import java.util.HashMap;
import java.util.Set;

public class ShoppingListMain {

	public static void main(String[] args) {
		HashMap<String, String> shoppingList = new HashMap<>();
		shoppingList.put("Bananas", "2");
		shoppingList.put("Bread", "10");
		shoppingList.put("Toiletpaper", "0");
		shoppingList.put("Milk", "1");
		shoppingList.put("Cola Bottles", "81");
		shoppingList.put("Eggs", "42");
		
		Set<String> articlename = shoppingList.keySet();
		for(String name : articlename) {
			System.out.println(name + " : " + shoppingList.get(name));
		}

	}

}
