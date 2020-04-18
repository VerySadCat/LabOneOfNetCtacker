package stream;

import persons.Person;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
Задание:
1) создать мэп, который содержит в себе название подразделения и сколько там денег выплачивают
2) выдать людей,которые старше 30 лет, в имени есть буква А, зарплата которых меньше 5000
3) проверить,есть ли в нашем списке люди в имени идут две А подряд
4) выдать год рождения и сколько людей было рождено в этот год
*/

public class Stream {
    public Map<String, Double> oneTask(List<Person> list){
        Map<String, Double> result = list.stream().collect(Collectors.groupingBy(x->x.getDivision().getName(),
                                                            Collectors.summingDouble(x->x.getSalary().doubleValue())));
        return result;
    }

    public void twoTask(List<Person> list){
        list.stream()
                .filter(e->e.getAge()>30)
                .filter(e->e.getSalary().compareTo(new BigDecimal(5000)) < 0)
                .filter(e->e.getFirstName().toLowerCase().contains("А"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void threeTask(List<Person> list) {
        list.stream()
                .filter(e->e.getFirstName().toLowerCase().contains("АА"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void fourTask(List<Person> list) {
        Map<Integer, Long> fourMap = list.stream().collect(Collectors.groupingBy(Person::getYear, Collectors.counting()));
        for (Map.Entry<Integer, Long> pair : fourMap.entrySet()) {
            Integer key = pair.getKey();
            Long value = pair.getValue();
            System.out.println(key+"  "+value);
        }
    }
}
