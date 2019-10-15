package MyArray;

import persons.Persons;

/**
 * Класс реализующий динамический массив Person
 * @author SadCat
 * @version 1.0
 */
public class MyArray {
    /** Поле массив Person*/
    private Persons array[];
    /** Поле количество Person*/
    private int cardinality = 0;

    /**
     * Процедра добавления нового Person в массив
     * @param value - новый Person
     */
    public void add(Persons value){
        cardinality++;
        if (array == null){
            array = new Persons[cardinality];
        }
        else{
            Persons[] newArray = new Persons[cardinality];
            newArray = array.clone();
            array = newArray;
        }
         array[cardinality-1] = value;
    }


    /**
     * Процедура вывода всех Person в массиве
     */
    public void printInformPerson(){
        for (Persons temp : array ) {
            System.out.println( temp.getName() + " "
                    + temp.getBirtday().getDay() + "." + temp.getBirtday().getMonth() + "." + temp.getBirtday().getYear() + " "
                    + temp.getGender() + " "
                    + temp.getGrowth()
            );
        }
    }

}
