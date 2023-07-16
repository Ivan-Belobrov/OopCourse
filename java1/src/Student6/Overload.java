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
        System.out.println("Размер byte в байтах = " + getTypeSize(a));

        short b = 32766;
        System.out.println("Размер short в байтах = " + getTypeSize(b));

        int c = 2147483647;
        System.out.println("Размер int в байтах = " + getTypeSize(c));

        long d = 922337203;
        System.out.println("Размер long в байтах = " + getTypeSize(d));

        float f = (float) 3.4e+38;
        System.out.println("Размер float в байтах = " + getTypeSize(f));

        double g = 3.5464e+10;
        System.out.println("Размер double в байтах = " + getTypeSize(g));

        System.out.println();
    }
}