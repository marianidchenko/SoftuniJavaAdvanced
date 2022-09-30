package CarSalesman;

public class Car {
    String model;
    Engine engine;
    int weight;
    String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this (model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this (model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this (model, engine);
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String result = String.format("%s:\n%s", this.getModel(), this.getEngine().toString());
        if (this.getWeight() != 0) {
            result += "Weight: " + this.getWeight() + "\n";
        } else {
            result += "Weight: n/a\n";
        }
        result += "Color: " + this.getColor();
        return result.replaceAll("null", "n/a");
    }
}
