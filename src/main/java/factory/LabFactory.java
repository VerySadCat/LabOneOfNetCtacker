package factory;


import repository.IRepository;
import xml.Repository;
import divisions.Division;
import divisions.IDivision;
import persons.IPerson;
import persons.Person;

public class LabFactory implements ILabFactory {
    @Override
    public IPerson createPerson() {
        Person person = new Person();
        return person;
    }

    @Override
    public IDivision createDivision() {
        Division division = new Division();
        return division;
    }

    @Override
    public <T> IRepository<T> createRepository(Class<T> clazz) {
        Repository<T> repository = new Repository<T>();
        return repository;
    }

}
