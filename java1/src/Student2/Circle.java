package Student2;

public class Circle {
    public static void main(String[] args) {
        double radius1 = 5;
        double circleArea1 = Math.PI * Math.pow(radius1, 2);
        double circumference1 = 2 * Math.PI * radius1;
        System.out.println("������� ����� = " + circleArea1);
        System.out.println("����� ���������� ����� = " + circumference1);

        double circleArea2 = 78.5;
        double radius2 = Math.sqrt(circleArea2 / Math.PI);
        System.out.println("������ ����� = " + radius2);

        double radius3 = 10;
        double angleDegrees3 = 30;
        double sectorArea3 = ((Math.PI * Math.pow(radius3, 2)) / 360) * angleDegrees3;
        System.out.println("������� ������� ����� = " + sectorArea3);
    }
}