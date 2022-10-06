package ComparingObjects;

public class Person implements Comparable<Person>{
    String name;
    int age;
    String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person o) {
        if(this.name.equals(o.name)) {
            if(this.age == o.age) {
                if(this.town.equals(o.town)) {
                    return -1;
                }
            }
        }
        return this.name.compareTo(o.name);
    }
}
