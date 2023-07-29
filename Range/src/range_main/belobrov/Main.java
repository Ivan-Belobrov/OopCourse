package range_main.belobrov;

import range.belobrov.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(26, 95);
        Range range2 = new Range(3, 25);

        Range intersection = range1.getIntersection(range2);

        if (intersection != null) {
            System.out.println("Интервал пресечение: " + "(" + intersection.getFrom() + ", " + intersection.getTo() + ")");
        } else {
            System.out.println("Пресечения нет.");
        }

        Range[] union = range1.getUnion(range2);
        System.out.println("Объединение: " + Arrays.toString(union));

        Range[] difference = range1.getDifference(range2);
        System.out.println("Разность: " + Arrays.toString(difference));
    }
}