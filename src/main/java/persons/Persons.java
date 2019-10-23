package persons;
import org.joda.time.DateTime;

/**
 * Класс реализующий человека
 * @author SadCat
 * @version 1.0
 */
public class Persons {
    /** Поле id*/
    private int id;
    /** Поле день дожденья*/
    private DateTime birthday;
    /** Поле пол (м, ж, ср)*/
    private char gender;
    /** Поле рост*/
    private float growth;
    /** Поле имя*/
    private String name;


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

    /**
     * Функция полечения значения поля
     * @return дату рождения
     */
    public DateTime getBirthday() {
        return birthday;
    }

    /**
     *  Процедура определения значения поля
     * @param birthday - дата рождения
     */
    public void setBirthday(DateTime birthday) {
        this.birthday = birthday;
    }

    /**
     * Функция получения значения поля
     * @return возраст человека
     */
    public int getAge(){
        DateTime currentTime = new DateTime();
        int agePerson = currentTime.getYear() - birthday.getYear(); // возраст по годам
        // если не дошел в году до д.р.
        if (currentTime.getMonthOfYear()<birthday.getMonthOfYear())
            agePerson--;
        if (currentTime.getMonthOfYear()==birthday.getMonthOfYear()& currentTime.getDayOfMonth()<birthday.getDayOfMonth())
            agePerson--;
        return agePerson;
    }

    /**
     * Функция полечения значения поля
     * @return id Person
     */
    public int getId() {
        return id;
    }
    /**
     *  Процедура определения значения поля
     * @param id - id Person
     */
    public void setId(int id) {
        this.id = id;
    }
}
