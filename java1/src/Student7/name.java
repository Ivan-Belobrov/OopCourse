package Student7;

import Student7.Contract;

public class name {
    public static void main(String[] args) {

        Contract contract = new Contract("Ivanov", "Ivan", "8952");

        String contractSurName = contract.getSurname();
        String contractName = contract.getName();
        String contractPhoneCount = contract.getPhoneNumber();

        System.out.println("������� " + contractSurName);
        System.out.println("��� " + contractName);
        System.out.println("����� ��������: " + contractPhoneCount);

    }
}