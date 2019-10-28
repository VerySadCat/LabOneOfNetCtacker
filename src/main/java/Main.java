import java.util.Date;
import java.util.Scanner;
import org.joda.time.DateTime;
import MyArray.MyArray;
import persons.Persons;

public class Main {
    public static void main(String[] args) {
        MyArray array = new MyArray();
        DateTime dat = new DateTime();

       Persons newValue0 = new Persons( dat, 'm', 1.86f, "Ivan");
       Persons newValue1 = new Persons( dat, 'm', 1.86f, "Ivan");
       Persons newValue2 = new Persons( dat, 'm', 1.86f, "Ivan");
        array.add(newValue0);

        array.add(newValue1);
        array.add(newValue2);
        array.remove(2);
        array.remove(2);
        array.add((newValue0));
        /*

        Scanner in = new Scanner(System.in);
        System.out.println("Input Name");
        newValue.setName(in.next());
        System.out.println("Input birthday");


        System.out.println("Input gender");
        newValue.setGender(in.next().charAt(0));

        array.add(newValue);

*/

    }
}
