package Student7;

public class NumberSearchingRange {
    public static void main(String[] args) {
        Range range = new Range(3, 40);

        System.out.println("������ ��������� = " + range.getFrom());
        System.out.println("����� ��������� = " + range.getTo());
        System.out.println("����� ��������� = " + range.getLength());

        System.out.println("������ ����� ��������� � ���������  - " + range.isInside(10));
        System.out.println("������ ����� ��������� � ���������  - " + range.isInside(41));

        System.out.println();
    }
}