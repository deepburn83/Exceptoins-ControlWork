package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PersonalDataParser {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static PersonalData parse(String inputData) throws Exception {
        String[] dataParts = inputData.split(" ");
        if (dataParts.length != 6) {
            throw new InvalidDataException("Incorrect number of data elements entered.");
        }

        String lastName = dataParts[0];
        String firstName = dataParts[1];
        String patronymic = dataParts[2];
        String dob = dataParts[3];
        parseDateOfBirth(dob);
        long phoneNumber = Long.parseLong(dataParts[4]);
        char gender = dataParts[5].charAt(0);

        if (!isValidGender(gender)) {
            throw new InvalidDataException("Invalid gender. Please enter 'f' for female or 'm' for male.");
        }

        return new PersonalData(lastName, firstName, patronymic, dob, phoneNumber, gender);
    }

    private static void parseDateOfBirth(String dobStr) throws Exception {
        try {
            LocalDate dob = LocalDate.parse(dobStr, formatter);
            if (dob.isAfter(LocalDate.now())) {
                throw new Exception("Date of birth cannot be from the future.");
            }
            if (dob.getYear() < 1900) {
                throw new Exception("I doubt you could have been born in the 19th century!");
            }
        } catch (DateTimeParseException e) {
            throw new Exception("Invalid date format. Please use dd.MM.yyyy.");
        }
    }

    private static boolean isValidGender(char gender) {
        return gender == 'f' || gender == 'm';
    }
}