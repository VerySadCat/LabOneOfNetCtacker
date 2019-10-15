import java.util.Scanner;
import MyArray.MyArray;
import persons.Persons;
import date.Date;

public class Main {
    public static void main(String[] args) {
        MyArray array = new MyArray();
        Persons newValue = new Persons();

        Date day = new Date();

        Scanner in = new Scanner(System.in);
        System.out.println("Input Name");
        newValue.setName(in.next());
        System.out.println("Input birthday");

        day.setDay(in.nextInt());
        day.setMonth(in.nextInt());
        day.setYear(in.nextInt());

        newValue.setBirtday(day);

        System.out.println("Input gender");
        newValue.setGender(in.next().charAt(0));

        array.add(newValue);


    }
}
