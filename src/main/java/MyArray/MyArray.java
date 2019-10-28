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
     * Процедура перенумерования массива
     * @param j номер с которого будем перенумеровывать массив
     */
    private void renumerateArray(int j){
        for (int i = j; i<cardinality; i++){
            array[i].setId(i+1);
        }
    }
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
            Persons[] newArray;
            if(i == cardinality){ // если граничная ситуация обрабатываем отдельно
                if (cardinality == 1) {
                    newArray = null;
                }
                else {
                    newArray  = new Persons[cardinality-1];
                    System.arraycopy(array, 0, newArray, 0, cardinality-1);
                }
            }
            else{ // если стоит в середине
                newArray  = new Persons[cardinality-1];
                System.arraycopy(array, 0, newArray, 0, i-1 );

                System.arraycopy(array, i, newArray, i-1, cardinality - i);
            }
            cardinality--;
            array = newArray;
            renumerateArray(i-1);
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
