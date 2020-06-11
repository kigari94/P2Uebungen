package de.haw_hamburg.wecker;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReaderService {
    public static final String OBJECT_FILE = "tmp.bin";
    public static String LIST_FILE = "Data.bin";

    public static Object readObject(Context context){
        File file = new File(context.getExternalFilesDir(null).getAbsolutePath(), OBJECT_FILE);
        Object object = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)){

            object = ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
