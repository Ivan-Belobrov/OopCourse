package Student7;

public class Contract {
    private String surName;
    private String name;
    private String phoneNumber;

    public Contract(String surName, String name, String phoneNumber) {
        this.surName = surName;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}