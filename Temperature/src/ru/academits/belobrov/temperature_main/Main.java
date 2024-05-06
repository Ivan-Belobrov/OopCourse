package ru.academits.belobrov.temperature_main;

import ru.academits.belobrov.temperature.Controller;
import ru.academits.belobrov.temperature.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
    }
}