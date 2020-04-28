package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileMain {

	public static void main(String[] args) {
		// Datei erstellen
		File file = new File("Vorlesung05/fileIO/name.txt");
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

		// Datei schreiben
		try (FileWriter fileWriter = new FileWriter(file, false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			bufferedWriter.write("Corona desinfiziert sich nach Kontakt mit Chuck Norris die Hände - BufferedWriter");
			bufferedWriter.newLine();
			bufferedWriter.flush();

//			fileWriter.write("Corona desinfiziert sich nach Kontakt mit Chuck Norris die Hände\r\n");
//			fileWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Datei lesen
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String text = bufferedReader.readLine();
			System.out.println(text);

			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
//				oos.writeObject(new Ufo(10,15,1000,1000,3,"spriteName"));
				oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
