package Google;

public class Pokemon {
    String name;
    String element;

    public Pokemon(String name, String element) {
        this.name = name;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return (name == null) ? "" : String.format("%s %s", name, element);
    }
}
