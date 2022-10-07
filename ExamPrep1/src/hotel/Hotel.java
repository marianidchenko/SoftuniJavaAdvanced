package hotel;

import java.util.ArrayList;

public class Hotel {
    String name;
    int capacity;
    ArrayList<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<Person>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        Person person = roster.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst().orElse(null);
        this.roster.remove(person);
        return person != null;
    }

    public Person getPerson(String name, String hometown) {
        Person person = roster.stream()
                .filter(p -> p.getName().equals(name) && p.getHometown().equals(hometown))
                .findFirst().orElse(null);
        return person;
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:\n", this.name));
        for (Person p: this.roster) {
            sb.append(p.toString() + "\n");
        }
        return sb.toString();
    }
}
