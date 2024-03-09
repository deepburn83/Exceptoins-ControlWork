package model;

import java.io.IOException;

public interface PersonalDataWriter {
    void writeToFile(String filename, PersonalData personalData) throws IOException;
}