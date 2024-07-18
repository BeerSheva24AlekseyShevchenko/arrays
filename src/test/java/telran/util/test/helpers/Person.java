package telran.util.test.helpers;

public class Person implements Comparable<Person> {
    private long id;
    private String name;

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        int res = 0;
    
        if (o.getId() > id) {
            res = -1;
        }

        if (o.getId() < id) {
            res = 1;
        }

        return res;
    }
}
