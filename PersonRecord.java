import java.util.List;

record Person(String name, int age) {}

public class PersonRecord {
    public static void main(String[] args) {
        List<Person> people = List.of(new Person("Alice", 25), new Person("Bob", 35));
        people.stream().filter(p -> p.age() > 30).forEach(System.out::println);
    }
}
