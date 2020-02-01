import Repository.Repository;
import divisions.Division;
import persons.Gender;
import persons.Person;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Month;

public class Main {
    public static void main(String[] args) throws IOException {
        Person firstPerson = new Person(23, "Irina", "Chulkova", java.time.LocalDate.of(1998, Month.AUGUST, 20), Gender.FEMALE, new BigDecimal(67899), new Division(12, "F"));
        Person secondPerson = new Person(45, "Alex", "Vasil", java.time.LocalDate.of(1999, Month.MAY, 30), Gender.FEMALE, new BigDecimal(98764), new Division(12, "I"));
        Person thirdPerson = new Person(16, "Ivan", "Ivanov", java.time.LocalDate.of(1997, Month.MAY, 17), Gender.MALE, new BigDecimal(70098), new Division(45, "H"));

        Repository<Person> repository = new Repository<Person>();
        repository.add(firstPerson);
        repository.add(secondPerson);
        repository.add(thirdPerson);




    }
}
