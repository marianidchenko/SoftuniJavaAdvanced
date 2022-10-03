package Google;

public class Car {
    String name;
    int power;

    public Car(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return (name == null) ? "" : String.format("%s %d", name, power);
    }
}
