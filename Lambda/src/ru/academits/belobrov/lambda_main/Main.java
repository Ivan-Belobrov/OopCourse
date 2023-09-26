package ru.academits.belobrov.lambda_main;

import ru.academits.belobrov.lambda.Person;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(Arrays.asList(
                new Person("Иван", 30),
                new Person("Сергей", 28),
                new Person("Михаил", 22),
                new Person("Иван", 7),
                new Person("Петр", 13),
                new Person("Игорь", 17)
        ));

        List<String> uniqueNamesList = personList.stream()
                .map(Person::name)
                .distinct()
                .toList();

        String formattedNamesString = uniqueNamesList.stream()
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(formattedNamesString);

        double averageAgeUnder18 = personList.stream()
                .filter(p -> p.age() < 18)
                .mapToInt(Person::age)
                .average()
                .orElse(0);

        System.out.println("Средний возраст людей младше 18 лет: " + averageAgeUnder18);

        Map<String, Double> averageAgeByNames = personList.stream()
                .collect(Collectors.groupingBy(Person::name, Collectors.averagingInt(Person::age)));
        System.out.println("Средний возраст по именам: " + averageAgeByNames);

        List<String> namesFrom20To45 = personList.stream()
                .filter(p -> p.age() >= 20 && p.age() <=45)
                .sorted(Comparator.comparingInt(Person::age).reversed())
                .map(Person::name)
                .toList();

        if (namesFrom20To45.isEmpty()) {
            System.out.println("Нет людей в нужном возрасте");
            return;
        }

        System.out.println("Имена людей от 20 до 45 в порядке убывания возраста: " + namesFrom20To45);
    }
}