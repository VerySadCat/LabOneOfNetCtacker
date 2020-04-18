package xml;

import org.apache.log4j.Logger;
import repository.IRepository;
import sort.ISorted;
import sort.ShellSort;

import java.util.*;
import java.util.function.Predicate;

public class Repository<T> implements IRepository<T> {

    private static final Logger logger = Logger.getLogger(Repository.class.getName());

    private Object[] person ;
    private int cardinality = 1;

    private ISorted sorter;

    public Repository() {
       person = new Object[cardinality];
    }

    public Repository(Object[] person) {

        logger.trace("add Object person");
        this.person = person;
        this.cardinality = person.length;
    }

    public int getCardinality() {
        return cardinality;
    }

    public boolean empty() {
        if (cardinality == 0)
            return true;
        else
            return false;
    }

    private void arrayExpansion() {

    }



    @Override
    public T get(int i) {
        logger.trace("get person by id");
        if(i>0 && i<=cardinality)
            return (T)person[i];
        return null;
    }

    @Override
    public T delete(int i) {
        logger.trace("delete person by id");
        for (int j = i; j < cardinality - 1; j++) {
            person[i] = person[i + 1];
        }
        cardinality--;
        Object[] newPersonArray = new Object[person.length - 1];
        System.arraycopy(person, 0, newPersonArray, 0, cardinality);
        person = newPersonArray;
        cardinality--;
        return null;
    }

    @Override
    public T set(int i, T person) {
        logger.trace("set person by id");
        if(i<=cardinality && i>0)
            this.person[i] = person;
        return null;
    }

    @Override
    public void add(int i, T person) {
        logger.trace("add person by index");
        Object[] newArray = new Object[this.person.length + 1];
        System.arraycopy(this.person, 0, newArray, 0, i);
        newArray[i] = person;
        System.arraycopy(this.person, i, newArray, i + 1, cardinality - i);
        this.person = newArray;
        cardinality++;
    }

    @Override
    public List<T> toList() {
        logger.trace("get list persons");
        List<T> list = new LinkedList<T>();
        for (T addPerson: (T[])person) {
            list.add(addPerson);
        }
        return list;
    }

    @Override
    public void add(T person) {
        logger.trace("add person");
        if (cardinality == this.person.length) {
            Object[] newPersonArray = new Object[this.person.length + 1];
            System.arraycopy(this.person, 0, newPersonArray, 0, cardinality);
            this.person = newPersonArray;
        }
        this.person[cardinality++] = person;
    }

    @Override
    public void sortBy(Comparator<T> comparator) {
        logger.trace("sort persons");
        sorter = new ShellSort();
        sorter.sort(person, comparator);
    }

    @Override
    public IRepository<T> searchBy(Predicate<T> predicate) {
        logger.trace("search person");
        Repository list = new Repository();
        for (int i = 0; i < cardinality; i++) {
            if (predicate.test((T)person[i]))
                list.add(person[i]);
        }
        return list;
    }

    @Override
    public boolean equals(Object o) {
        logger.trace("equals person");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository<?> that = (Repository<?>) o;
        return  cardinality == that.cardinality &&
                Arrays.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cardinality, sorter);
        result = 31 * result + Arrays.hashCode(person);
        return result;
    }

    @Override
    public String toString() {
        return "repository{" +
                "person=" + Arrays.toString(person) +
                ", cardinality=" + cardinality +
                ", sorter=" + sorter +
                '}';
    }
}