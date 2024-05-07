package ru.academits.belobrov.temperature.model.scales;

import java.util.Arrays;
import java.util.List;

public class TemperatureScalesManager {
    private static final List<TemperatureScale> temperatureScale = Arrays.asList(
            new CelsiusScale(),
            new FahrenheitScale(),
            new KelvinScale()
    );

    public static List<TemperatureScale> getTemperatureScale() {
        return temperatureScale;
    }

    public static String[] getTemperatureScaleNames() {
        return temperatureScale.stream().
                map(TemperatureScale::toString).
                toArray(String[]::new);
    }
}
