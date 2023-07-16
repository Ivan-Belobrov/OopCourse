package Student6;

public class new1 {
    public static double getAverage(int start,int end){
        int sum = 0;
        int count = 0;
        for(int i = start; i<=end; ++i){
        sum+=i;
        ++count;
    }return(double)sum/count;
    }public static void main(String[] args){
        double average = getAverage(9, 10);
        System.out.println(average);
        System.out.println(getAverage(-12, 68));
    }
}
