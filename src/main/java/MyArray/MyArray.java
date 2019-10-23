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
        // добавка индекса
        if (cardinality!=1){
            array[cardinality-1].setId(array[cardinality-2].getId()+1);
        }
        else{
            array[cardinality - 1].setId(1);
        }
    }


    public boolean remove(int i){
        boolean flagInput = false;
        if(!(cardinality<i)) {
            
        }
        return flagInput;
    }


    /**
     * Функция для поиска по имени
     * @param seachName - имя для поиска в массиве array
     * @return ячейку массиву или null
     */
    public Persons seachPeople(String seachName){
        for (Persons temp :array ) {
            if (temp.getName().equals(seachName)){
                return temp;
            }
        }
        return null;
    }

    /**
     * Процедура вывода всех Person в массиве
     */
    public void printInformPerson(){
        for (Persons temp : array ) {
            System.out.println( temp.getId() + ". "+temp.getName() + " "
                    + temp.getAge()+" "
                    + temp.getGender() + " "
                    + temp.getGrowth()
            );
        }
    }

}
