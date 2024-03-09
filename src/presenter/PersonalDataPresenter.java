package presenter;

import model.PersonalData;
import model.PersonalDataFileReader;
import model.PersonalDataParser;
import model.PersonalDataWriter;
import view.PersonalDataView;

public class PersonalDataPresenter {
    private PersonalDataWriter writer;
    private PersonalDataView view;

    public PersonalDataPresenter(PersonalDataWriter writer, PersonalDataView view) {
        this.writer = writer;
        this.view = view;
    }

    public void savePersonalData(String inputData) {
        try {
            PersonalData personalData = PersonalDataParser.parse(inputData);
            String filename = personalData.getLastName() + ".txt";

            if (PersonalDataFileReader.doesFileExist(filename) && PersonalDataFileReader.doesLastNameExist(filename, personalData.getLastName())) {
                // Файл существует и фамилия уже присутствует, добавляем данные в конец файла
                writer.writeToFile(filename, personalData);
                view.displayMessage("Data successfully appended to file: " + filename);
            } else {
                // Файл не существует или фамилии нет, создаем новый файл и записываем данные
                writer.writeToFile(filename, personalData);
                view.displayMessage("Data successfully written to file: " + filename);
            }
        } catch (Exception e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }
}