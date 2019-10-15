package date;

/**
 * Класс реализующий дату
 * @author SadCat
 * @version 1.0
 */
public class Date {
    /** Поля год, месяц, день*/
    private int year, month, day;

    /**
     * Функция полечения значения поля
     * @return год
     */
    public int getYear() {
        return year;
    }

    /**
     * Процедура определения значения поля
     * @param year - год
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Функция полечения значения поля
     * @return месяц
     */
    public int getMonth() {
        return month;
    }

    /**
     * Процедура определения значения поля
     * @param month - месяц
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Функция полечения значения поля
     * @return день
     */
    public int getDay() {
        return day;
    }

    /**
     * Процедура определения значения поля
     * @param day - день
     */
    public void setDay(int day) {
        this.day = day;
    }
}
