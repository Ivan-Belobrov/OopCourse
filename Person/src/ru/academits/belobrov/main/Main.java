package ru.academits.belobrov.main;

import ru.academits.belobrov.person.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Иван", 30));
        people.add(new Person("Сергей", 28));
        people.add(new Person("Михаил", 22));
        people.add(new Person("Иван", 7));
        people.add(new Person("Петр", 13));
        people.add(new Person("Игорь", 17));

        List<String> uniqueNames = people.stream()
                .map(Person::getName)
                .distinct().toList();

        String namesFormatted = uniqueNames.stream()
                .collect(Collectors.joining(", ", "Имена: ", "."));
        System.out.println(namesFormatted);

        double averageAgeUnder18 = people.stream()
                .filter(person -> person.getAge() < 18)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
        System.out.println("Средний возрост людей младше 18 лет: " + averageAgeUnder18);

        Map<String, Double> averageAgeByName = people.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));
        System.out.println("Средний возрост по именам: " + averageAgeByName);

        List<String> namesFrom20To45 = people.stream()
                .filter(person -> person.getAge() >= 20 && person.getAge() <= 45)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .map(Person::getName).toList();
        System.out.println("Имена людей от 20 до 45 в порядке убывания возроста: " + namesFrom20To45);
    }
}