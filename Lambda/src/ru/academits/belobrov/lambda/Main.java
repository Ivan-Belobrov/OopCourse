package ru.academits.belobrov.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> personsList = Arrays.asList(
                new Person("Иван", 45),
                new Person("Сергей", 25),
                new Person("Михаил", 28),
                new Person("Иван", 7),
                new Person("Петр", 13),
                new Person("Игорь", 17)
        );

        List<String> uniqueNamesList = personsList.stream()
                .map(Person::name)
                .distinct()
                .toList();

        String formattedUniqueNamesString = uniqueNamesList.stream()
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(formattedUniqueNamesString);

        OptionalDouble averageAgeUnder18 = personsList.stream()
                .filter(p -> p.age() < 18)
                .mapToInt(Person::age)
                .average();

        averageAgeUnder18.ifPresentOrElse(
                average -> System.out.println("Средний возраст людей младше 18 лет: " + averageAgeUnder18),
                () -> System.out.println("Нет людей младше 18 лет."));

        Map<String, Double> averageAgesByNames = personsList.stream()
                .collect(Collectors.groupingBy(Person::name, Collectors.averagingInt(Person::age)));
        System.out.println("Средний возраст по именам: " + averageAgesByNames);

        List<String> namesFrom20To45 = personsList.stream()
                .filter(p -> p.age() >= 20 && p.age() <= 45)
                .sorted(Comparator.comparingInt(Person::age).reversed())
                .map(Person::name)
                .toList();

        if (namesFrom20To45.isEmpty()) {
            System.out.println("Нет людей в нужном возрасте");
        } else {
            System.out.println("Имена людей от 20 до 45 в порядке убывания возраста: " + namesFrom20To45);
        }
    }
}