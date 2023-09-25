package ru.academits.belobrov.lambda_main;

import ru.academits.belobrov.lambda.Person;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> p = new ArrayList<>(Arrays.asList(
                new Person("Иван", 30),
                new Person("Сергей", 28),
                new Person("Михаил", 22),
                new Person("Иван", 7),
                new Person("Петр", 13),
                new Person("Игорь", 17)
        ));

        List<String> uniqueListNames = p.stream()
                .map(Person::name)
                .distinct()
                .toList();

        String formattedStringNames = uniqueListNames.stream()
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(formattedStringNames);

        double averageAgeUnder18 = p.stream()
                .filter(person -> person.age() < 18)
                .mapToInt(Person::age)
                .average()
                .orElse(0);

        System.out.println("Средний возраст людей младше 18 лет: " + averageAgeUnder18);

        Map<String, Double> averageAgeByNames = p.stream()
                .collect(Collectors.groupingBy(Person::name, Collectors.averagingInt(Person::age)));
        System.out.println("Средний возраст по именам: " + averageAgeByNames);

        List<Person> filteredPeople = p.stream()
                .filter(person -> person.age() >= 20 && person.age() <= 45)
                .toList();

        if (filteredPeople.isEmpty()) {
            System.out.println("Нет людей в нужном возросте");
            return;
        }

        List<String> namesFrom20To45 = filteredPeople.stream()
                .sorted(Comparator.comparingInt(Person::age).reversed())
                .map(Person::name)
                .toList();

        System.out.println("Имена людей от 20 до 45 в порядке убывания возраста: " + namesFrom20To45);
    }
}