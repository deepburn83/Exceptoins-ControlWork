package view;

import java.util.Scanner;

public class PersonalDataView {
    private Scanner scanner;

    public PersonalDataView() {
        this.scanner = new Scanner(System.in);
    }

    public String getInputData() {
        System.out.println("Enter full name, date of birth (dd.mm.yyyy), " +
                "phone number, and gender (f/m), separated by spaces:");
        return scanner.nextLine().trim();
    }

    public void requestForCorrection() {
        System.out.println("Try entering the data again without errors: ");
    }

    public boolean promptForNewData() {
        while (true) {
            System.out.print("Enter new data? (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void closeScanner() {
        scanner.close();
    }
}