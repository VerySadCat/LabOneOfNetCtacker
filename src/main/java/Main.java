import divisions.Division;
import persons.Gender;
import persons.Person;
import xml.Repository;
import xml.CreatorXml;

import java.math.BigDecimal;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Person firstPerson = new Person(23, "Katy", "SAD", java.time.LocalDate.of(1998, Month.JULY, 22), Gender.FEMALE, new BigDecimal(13231), new Division(8, "F"));
        Person secondPerson = new Person(45, "Alex", "Vas", java.time.LocalDate.of(1998, Month.DECEMBER, 30), Gender.MALE, new BigDecimal(777), new Division(11, "I"));
        Person thirdPerson = new Person(16, "Ivan", "Kot", java.time.LocalDate.of(1997, Month.JUNE, 18), Gender.MALE, new BigDecimal(14098), new Division(4, "H"));

        Repository<Person> repository = new Repository<Person>();
        repository.add(firstPerson);
        repository.add(secondPerson);
        repository.add(thirdPerson);

        /**
         * work with xml
         */
        CreatorXml work = new CreatorXml();
        Repository<Person> personList = new Repository<>();
        personList.add(firstPerson);
        personList.add(secondPerson);
        personList.add(thirdPerson);
        work.toXml(personList);
        Repository<Person> personRepository = work.fromXml("Output.xml");
    }
}
