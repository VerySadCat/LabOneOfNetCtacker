package xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Persons {
    List<Persons> personsList = new ArrayList<>();

    @XmlElement
    public List<Persons> getPersons() {
        return personsList;
    }

    public void setPersons(List<Persons> persons) {
        this.personsList = persons;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "persons=" + personsList +
                '}';
    }
}