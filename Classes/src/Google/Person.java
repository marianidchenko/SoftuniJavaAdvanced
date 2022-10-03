package Google;

import java.util.ArrayList;

public class Person {
    String name;
    Company company;
    Car car;
    ArrayList<Pokemon> pokemon;
    ArrayList<Parent> parents;
    ArrayList<Child> children;

    public Person(String name) {
        this.name = name;
        this.pokemon = new ArrayList<Pokemon>();
        this.children = new ArrayList<Child>();
        this.parents = new ArrayList<Parent>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ArrayList<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }

    public ArrayList<Parent> getParents() {
        return parents;
    }

    public void setParents(Parent parent) {
        this.parents.add(parent);
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public void setChildren(Child child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        String result = name + "\n";
        result += "Company:\n" + (company == null ? "" : company.toString() + "\n");
        result += "Car:\n" + (car == null ? "" : car.toString() + "\n");
        result += "Pokemon:\n";
        if (pokemon.size() > 0) {
            for (Pokemon p : pokemon) {
                result += p.toString()+ "\n";
            }
        }
        result += "Parents:\n";
        if (parents.size() > 0) {
            for (Parent p : parents) {
                result += p.toString() + "\n";
            }
        }
        result += "Children:\n";
        if (children.size() > 0) {
            for (Child c : children) {
                result += c.toString()+ "\n";
            }
        }
        return result;
    }
}
