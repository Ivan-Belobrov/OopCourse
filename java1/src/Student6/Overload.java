package Student6;

public class Overload {
    public static int getTypeSize(byte number) {
        return 1;
    }

    public static int getTypeSize(short number) {
        return 2;
    }

    public static int getTypeSize(int number) {
        return 4;
    }

    public static int getTypeSize(long number) {
        return 8;
    }

    public static int getTypeSize(float number) {
        return 4;
    }

    public static int getTypeSize(double number) {
        return 8;
    }

    public static void main(String[] args) {
        byte a = 127;
        System.out.println("������ byte � ������ = " + getTypeSize(a));

        short b = 32766;
        System.out.println("������ short � ������ = " + getTypeSize(b));

        int c = 2147483647;
        System.out.println("������ int � ������ = " + getTypeSize(c));

        long d = 922337203;
        System.out.println("������ long � ������ = " + getTypeSize(d));

        float f = (float) 3.4e+38;
        System.out.println("������ float � ������ = " + getTypeSize(f));

        double g = 3.5464e+10;
        System.out.println("������ double � ������ = " + getTypeSize(g));

        System.out.println();
    }
}