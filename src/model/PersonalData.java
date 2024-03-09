package model;

public class PersonalData {
    private String lastName;
    private String firstName;
    private String patronymic;
    private String dob;
    private long phoneNumber;
    private char gender;

    public PersonalData(String lastName, String firstName, String patronymic, String dob, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDob() {
        return dob;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }
}