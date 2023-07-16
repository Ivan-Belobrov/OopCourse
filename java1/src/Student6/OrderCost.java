package Student6;

public class OrderCost {
    public static double getOrderCost(int product1Count, double price1Product, int product2Count, double price2Product) {
        final double epsilon = 1.0e-10;

        double orderCost = price1Product * product1Count + price2Product * product2Count;
        int allProductsCount = product1Count + product2Count;

        final double minDiscount = 0.05;
        final double maxDiscount = 0.1;

        final double minOrderValueForDiscount = 1000;
        final int minProductsCountForDiscount = 10;

        if (allProductsCount >= minProductsCountForDiscount && minOrderValueForDiscount - orderCost <= epsilon) {
            return orderCost - (orderCost * maxDiscount);
        }

        if (allProductsCount >= minProductsCountForDiscount || minOrderValueForDiscount - orderCost <= epsilon) {
            return orderCost - (orderCost * minDiscount);
        }

        return orderCost;
    }

    public static void main(String[] args) {
        System.out.println("��������� ������ � ������ ������ = " + getOrderCost(6, 100, 4, 100) + " ������");
        System.out.println("��������� ������ � ������ ������ = " + getOrderCost(1, 50, 9, 100) + " ������");
        System.out.println("��������� ������ � ������ ������ = " + getOrderCost(8, 100, 2, 50) + " ������");
    }
}