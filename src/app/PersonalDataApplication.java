//It is necessary to make corrections to the code so that when working with the application,
// when correct data is entered and a file is written/appended,
// the user receives the request “Enter new data? (y/n): “,
// and if the data is entered incorrectly and an exception is processed,
// then the user received the request "Try entering the data again without errors: "


package app;

import model.FileWriterAdapter;
import presenter.PersonalDataPresenter;
import view.PersonalDataView;

public class PersonalDataApplication {
    public static void main(String[] args) {
        PersonalDataView view = new PersonalDataView();
        PersonalDataPresenter presenter = new PersonalDataPresenter(new FileWriterAdapter(), view);

        while (true) {
            try {
                presenter.savePersonalData(view.getInputData());
                if (!view.promptForNewData()) {
                    break;
                }
            } catch (Exception e) {
                view.displayMessage(e.getMessage());

            }
            view.requestForCorrection();
        }

        view.closeScanner();
    }
}