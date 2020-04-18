package persons;

import divisions.IDivision;
import xml.Persons;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person extends Persons implements IPerson {
    private LocalDate localDate = LocalDate.now();
    private int id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private int age;

    private Gender sex;
    private BigDecimal salary;
    private IDivision division;

    public Person() {
    }

    public Person(int id, String name, String surname, LocalDate dateOfBirth, Gender sex, BigDecimal salary, IDivision division) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.age = Period.between(dateOfBirth,localDate).getYears();
        this.sex = sex;
        this.salary = salary;
        this.division = division;
    }


    public void doSome(){
        System.out.println("We are here");
    }
    public Integer getYear(){
        return dateOfBirth.getYear();
    }
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer integer) {
        this.id=integer;
    }

    @Override
    public String getFirstName() {
        return name;
    }

    @Override
    public void setFirstName(String s) {
        this.name = s;
    }
    @Override
    public String getLastName() {
        return surname;
    }

    @Override
    public void setLastName(String s) {
        this.surname = s;
    }

    @Override
    public java.time.LocalDate getBirthdate() {
        return dateOfBirth;
    }

    @Override
    public void setBirthdate(java.time.LocalDate localDate) {
        this.dateOfBirth = localDate;
    }

    @Override
    public Integer getAge() {
        return Period.between(dateOfBirth,localDate).getYears();
    }

    @Override
    public Gender getGender() {
        return sex;
    }

    @Override
    public void setGender(Gender gender) {
        this.sex = gender;
    }

    @Override
    public IDivision getDivision() {
        return division;
    }

    @Override
    public void setSalary(BigDecimal bigDecimal) {
        this.salary=bigDecimal;
    }

    @Override
    public void setDivision(IDivision iDivision) {
        this.division = iDivision;
    }
    @Override
    public BigDecimal getSalary() {
        return salary;
    }

    public void printPerson(){
        System.out.println("ID: "+id+", Name: "+name+", Surname: "+surname+", Date of birth: "+dateOfBirth+", Age: "+age+", Gender: "+sex+", Salary: "+salary+", Division: "+division);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                salary == person.salary &&
                Objects.equals(localDate, person.localDate) &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(dateOfBirth, person.dateOfBirth) &&
                Objects.equals(sex, person.sex) &&
                Objects.equals(division, person.division);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localDate, id, name, surname, dateOfBirth, age, sex, salary, division);
    }

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", division='" + division + '\'' +
                '}';
    }
}
