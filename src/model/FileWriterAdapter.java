package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterAdapter implements PersonalDataWriter {
    @Override
    public void writeToFile(String filename, PersonalData personalData) throws IOException {
        File file = new File(filename);
        BufferedWriter writer = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            writer = new BufferedWriter(new FileWriter(file, true)); // Открываем файл в режиме дозаписи (append mode)

            writer.write("<" + personalData.getLastName() + "> ");
            writer.write("<" + personalData.getFirstName() + "> ");
            writer.write("<" + personalData.getPatronymic() + "> ");
            writer.write("<" + personalData.getDob() + "> ");
            writer.write("<" + personalData.getPhoneNumber() + "> ");
            writer.write("<" + personalData.getGender() + "> ");
            writer.newLine();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}