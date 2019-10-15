package Persons;

import date.Date;

/**
 * Класс реализующий человека
 * @author SadCat
 * @version 1.0
 */
public class Persons {
    /** Поле день дожденья*/
    private Date birtday;
    /** Поле пол (м, ж, ср)*/
    private char gender;
    /** Поле рост*/
    private float growth;
    /** Поле имя*/
    private String name;

    /**
     * Функция полечения значения поля
     * @return день рожденья
     */
    public Date getBirtday() {
        return birtday;
    }

    /**
     * Процедура определения значения поля
     * @param birtday - день рождения
     */
    public void setBirtday(Date birtday) {
        this.birtday = birtday;
    }

    /**
     * Функция полечения значения поля
     * @return пол
     */
    public char getGender() {
        return gender;
    }

    /**
     * Процедура определения значения поля
     * @param gender - пол
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Функция полечения значения поля
     * @return рост
     */
    public float getGrowth() {
        return growth;
    }

    /**
     * Процедура определения значения поля
     * @param growth - рост
     */
    public void setGrowth(float growth) {
        this.growth = growth;
    }


    /**
     * Функция полечения значения поля
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     *  Процедура определения значения поля
     * @param name - имя
     */
    public void setName(String name) {
        this.name = name;
    }
}
