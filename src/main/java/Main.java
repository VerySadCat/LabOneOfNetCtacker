import java.util.Scanner;
import MyArray.MyArray;
import persons.Persons;

public class Main {
    public static void main(String[] args) {
        MyArray array = new MyArray();
        Persons newValue = new Persons();



        Scanner in = new Scanner(System.in);
        System.out.println("Input Name");
        newValue.setName(in.next());
        System.out.println("Input birthday");


        System.out.println("Input gender");
        newValue.setGender(in.next().charAt(0));

        array.add(newValue);


    }
}
