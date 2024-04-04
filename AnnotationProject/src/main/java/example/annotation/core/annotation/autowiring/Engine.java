package example.annotation.core.annotation.autowiring;

public class Engine {
    private String power;
    private String fuelType;

    public Engine(){
        this.power = "1200 cc";
        this.fuelType = "Petrol";
    }

    public Engine(String power, String fuelType) {
        this.power = power;
        this.fuelType = fuelType;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "power='" + power + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
