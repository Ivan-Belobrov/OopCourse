package Student7;

public class NumberSearchingRange {
    public static void main(String[] args) {
        Range range = new Range(3, 40);

        System.out.println("Начало диапазона = " + range.getFrom());
        System.out.println("Конец диапазона = " + range.getTo());
        System.out.println("Длина диапазона = " + range.getLength());

        System.out.println("Данное число находится в диапазоне  - " + range.isInside(10));
        System.out.println("Данное число находится в диапазоне  - " + range.isInside(41));

        System.out.println();
    }
}