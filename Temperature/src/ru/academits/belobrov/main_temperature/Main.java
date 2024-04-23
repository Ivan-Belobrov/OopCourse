package ru.academits.belobrov.main_temperature;

import ru.academits.belobrov.temperature.Controller;
import ru.academits.belobrov.temperature.Model;
import ru.academits.belobrov.temperature.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        Model model = new Model();
    }
}