package parser;

import xml.Repository;
import divisions.Division;
import persons.Gender;
import persons.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Parser {

    List<Division> divisions = new ArrayList<Division>();

    public Parser() {
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    public Repository<Person> readFromFile() throws IOException {
        int count = 0;
        int i = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Repository newList = new Repository();
        BufferedReader reader = new BufferedReader(new FileReader("persons.csv"));
        try {
            String readLine = reader.readLine(); //
            while ((readLine = reader.readLine()) != null) {
                i = 0;
                Person person = new Person();
                count++;
                String[] r = readLine.split(";"); // ставим разграничитель
                person.setId(Integer.parseInt(r[i++]));
                person.setFirstName(r[i++]);
                person.setGender(Gender.valueOf(r[i++].toUpperCase()));
                person.setBirthdate(LocalDate.parse(r[i++], formatter));
                person.setDivision(checkDivision(r[i++]));
                person.setSalary(new BigDecimal(r[i++]));
                newList.add(person);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        } finally {
            reader.close();
        }
        System.out.println("Count = " + count);
        return newList;
    }

    private Division checkDivision(String name) {
        Division division;
        boolean flag = true;
        Division check = null;
        Iterator<Division> it = divisions.iterator();
        while (it.hasNext() && flag) {
            check = it.next();
            if (name.compareTo(check.getName()) == 0) {
                flag = false;
            }
        }
        if (flag) {
            division = new Division(Math.abs(new Random().nextInt()), name);
            divisions.add(division);
            return division;
        } else {
            return check;
        }
    }


    // для инжектора парсим файл аннотации
    public Map<String, String> readFileAnnotation() {
        String[] array = new String[2];
        Map<String, String> map = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Annotation.txt"));
            String c;
            while ((c = reader.readLine()) != null) {
                array = c.split(" = ");
                map.put(array[1], array[0]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public String toString() {
        return "Parser{" +
                "divisions=" + divisions +
                '}';
    }
}
