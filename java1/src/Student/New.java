package Student;

import java.text.SimpleDateFormat;
import java.util.Date;


public class New {
    public static void main(String[] args) {
        int day = 25;
        int month = 2;
        int year = 2021;

        String pattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formattedDate = simpleDateFormat.format(new Date(year - 1900, month - 1, day));

        System.out.println(formattedDate);
    }
}
