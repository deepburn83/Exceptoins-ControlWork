package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PersonalDataFileReader {
    public static boolean doesFileExist(String filename) {
        File file = new File(filename);
        return file.exists();
    }

    public static boolean doesLastNameExist(String filename, String lastName) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length > 0 && parts[0].equals("<" + lastName + ">")) {
                    return true;
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return false;
    }
}