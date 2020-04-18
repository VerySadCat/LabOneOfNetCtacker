package repository;

import divisions.Division;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import persons.Gender;
import persons.Person;

import java.math.BigDecimal;
import java.time.Month;

class RepositoryTest {

    @Test
    void add() {
        Repository repository = new Repository();
        Person person = new Person(23, "Katy", "Skolkova", java.time.LocalDate.of(1998, Month.AUGUST, 21), Gender.FEMALE, new BigDecimal(67899), new Division(12, "F"));
        repository.add(person);
        Assert.assertEquals(person, repository.get(1));
    }

    @Test
    void delete() {
        Repository repository = new Repository();
        Person person1 = new Person(23, "Ilia", "Petukhov", java.time.LocalDate.of(1998, Month.JULY, 21), Gender.MALE, new BigDecimal(67899), new Division(12, "F"));
        Person person2 = new Person(45, "Alex", "Vasil", java.time.LocalDate.of(1999, Month.MAY, 30), Gender.FEMALE, new BigDecimal(98764), new Division(12, "I"));
        repository.add(person1);
        repository.add(person2);
        repository.delete(1);
        Assert.assertEquals(person2, repository.get(1));
    }

    @Test
    void set() {
        Repository repository = new Repository();
        Person person1 = new Person(23, "Ilia", "Petrov", java.time.LocalDate.of(1998, Month.JULY, 21), Gender.MALE, new BigDecimal(67899), new Division(12, "F"));
        repository.add(person1);
        Person person2 = new Person(45, "Alex", "Vasil", java.time.LocalDate.of(1999, Month.MAY, 30), Gender.FEMALE, new BigDecimal(98764), new Division(12, "I"));
        repository.set(1, person2);
        Assert.assertEquals(person2, repository.get(1));
    }

    @Test
    void add1() {
        Repository repository = new Repository();
        Person person = new Person(23, "Any", "Skolkova", java.time.LocalDate.of(1998, Month.AUGUST, 21), Gender.FEMALE, new BigDecimal(67899), new Division(12, "F"));
        Person person2 = new Person(45, "Ivan", "Vasil", java.time.LocalDate.of(1999, Month.MAY, 30), Gender.FEMALE, new BigDecimal(98764), new Division(12, "I"));
        repository.add(person);
        repository.add(1, person2);
        Assert.assertEquals(person2, repository.get(1));
    }
}