package datastructures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ContactMain {

	public static void main(String[] args) {
//		ArrayList<Contact> contacts = new ArrayList<>();
//		contacts.add(new Contact("Klaus", 0153662));
//		contacts.add(new Contact("Klaus", 999999));
//		contacts.add(new Contact("Optimus Prime", 444444));
//		contacts.add(new Contact("Geralt", 01562));
//		contacts.add(new Contact("Harry", 0153072));
//		contacts.add(new Contact("Zorro", 153662));
//		contacts.add(new Contact("Dieter", 8153662));
//		contacts.add(new Contact("Annette", 3179325));
//
//		Collections.sort(contacts);
//		
//		for(Contact contact : contacts) {
//			System.out.println(String.format("%20s:\t%d", contact.getName(), contact.getPhone()));
//		}

		// Alternative mit Linkedlist
		LinkedList<Contact> contacts = new LinkedList<>();
		contacts.add(new Contact("Alex", 12345));
		contacts.add(new Contact("Bob Ross", 12345));
		contacts.add(new Contact("Bruce Lee", 16545));
		contacts.add(new Contact("Kiwan", 75345));
		contacts.add(new Contact("Daniel", 12875));
		contacts.add(new Contact("Kirsten", 97345));
		contacts.add(new Contact("Kirsten", 12364));
		contacts.add(new Contact("Chuck Norris", 0));
		contacts.add(new Contact("Zorro", 153662));
		contacts.add(new Contact("Uwe Boll", 91872));

//		Collections.sort(contacts);
//
//		for (Contact contact : contacts) {
//			System.out.println(contact.getName() + " : " + contact.getPhone());
//		}

		// Datei erstellen
		File file = new File("Vorlesung05/datastructures/contact.txt");
		if (file.exists()) {
			System.out.println("File found.");
		} else {
			System.out.println("File created.");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Datei schreiben
		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
			oos.writeObject(contacts);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Datei lesen
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);

			LinkedList<Contact> obj = (LinkedList<Contact>) ois.readObject();
			ois.close();
			Collections.sort(obj);

			for (Object object : obj) {
				// Typprüfung
				if (object instanceof Contact) {
					Contact contactData = (Contact) object;
					System.out.println(contactData.getName() + " : " + contactData.getPhone());
				}
			}

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
