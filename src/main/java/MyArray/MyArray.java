package MyArray;

import persons.Persons;

public class MyArray {

    private Persons array[];
    private int cardinality = 0;

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
