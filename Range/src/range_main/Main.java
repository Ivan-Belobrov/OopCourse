package range_main;

import range.Range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(10, 95);
        Range range2 = new Range(3, 25);

        Range intersection = range1.getIntersection(range2);
        if (intersection != null) {
            System.out.println("Интервал пресечение: " + intersection.getFrom() + ", " + intersection.getTo());
        } else {
            System.out.println("Пресечения нет.");
        }

        Range[] union = range1.getUnion(range2);
        System.out.print("Объединение: ");

        for (Range range : union) {
            System.out.println(range.getFrom() + ", " + range.getTo());
        }

        Range[] difference = range1.getDifference(range2);
        System.out.print("Разность: ");
        for (Range range : difference) {
            System.out.println(range.getFrom() + ", " + range.getTo());
        }
    }
}
