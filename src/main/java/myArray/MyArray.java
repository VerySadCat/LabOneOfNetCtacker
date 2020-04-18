package myArray;

import persons.Person;

/**
 * Класс реализующий динамический массив Persons
 * @author SadCat
 * @version 1.0
 */
public class MyArray {
    /** Поле массив Persons*/
    private Person array[];
    /** Поле количество Persons*/
    private int cardinality = 0;

    /**
     * Процедура перенумерования массива
     * @param j номер с которого будем перенумеровывать массив
     */
    private void renumerateArray(int j){
        for (int i = j; i<cardinality; i++){
            array[i].setId(i+1);
        }
    }
    /**
     * Процедра добавления нового Persons в массив
     * @param value - новый Persons
     */
    public void add(Person value){
        cardinality++;
        if (array == null){
            array = new Person[cardinality];
        }
        else{
            Person[] newArray = new Person[cardinality];
            System.arraycopy(array, 0, newArray, 0, cardinality - 1);
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


    /**
     * Функция удаления по порядковому номеру
     * @param i - порядковый номер
     * @return
     */
    public boolean remove(int i){
        boolean flagInput = false;
        if(!(cardinality<i)) { //если есть такой индекс
            Person[] newArray;
            if(i == cardinality){ // если граничная ситуация обрабатываем отдельно
                if (cardinality == 1) {
                    newArray = null;
                }
                else {
                    newArray  = new Person[cardinality-1];
                    System.arraycopy(array, 0, newArray, 0, cardinality-1);
                }
            }
            else{ // если стоит в середине
                newArray  = new Person[cardinality-1];
                System.arraycopy(array, 0, newArray, 0, i-1 );

                System.arraycopy(array, i, newArray, i-1, cardinality - i);
            }
            cardinality--;
            array = newArray;
            renumerateArray(i-1);
        }
        return flagInput;
    }

}
