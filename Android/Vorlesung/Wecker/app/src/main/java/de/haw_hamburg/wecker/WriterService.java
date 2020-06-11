package de.haw_hamburg.wecker;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriterService {
    public static void writeObject(Context context, Object object){
        File file = new File(context.getExternalFilesDir(null).getAbsolutePath(), ReaderService.OBJECT_FILE);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(object);
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
