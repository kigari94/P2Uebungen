package datastructures;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextWriter {
	public static void main(String[] args) {

		File file = new File("Vorlesung05/datastructures/text.txt");
		if (file.exists()) {
			System.out.println("Die Datei existiert");
		} else {
			System.out.println("Die Datei wird angelegt");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Text schreiben
		try {
			FileWriter out = new FileWriter(file);
			PrintWriter writer = new PrintWriter(out);
			writer.println("Dies ist ein Beispiel Text:" + "\n" + "Lorem ipsum dolor sit amet."
					+ "\n" + "Lorem ipsum dolor sit amet."
					+ "\n" + "Lorem ipsum dolor sit amet."
					+ "\n" + "Lorem ipsum dolor sit amet."
					+ "\n" + "Lorem ipsum dolor sit amet."
					+ "\n" + "Lorem ipsum dolor sit amet.");
			writer.close();
			out.close();
		} catch (IOException e) {

		}
		
		// Text lesen
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}			
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
