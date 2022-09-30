package CarSalesman;

public class Engine {
    String model;
    int power;
    int displacement;
    String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, int power, int displacement) {
        this (model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this (model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this (model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String result = String.format("%s:\nPower: %d\n", this.getModel(), this.getPower());
        if (this.getDisplacement() != 0) {
            result += "Displacement: " + this.getDisplacement() + "\n";
        } else {
            result += "Displacement: n/a\n";
        }
        result += "Efficiency: " + this.getEfficiency() + "\n";
        return result.replaceAll("null", "n/a");
    }
}
