package ppyrczak.carrental.utils;

public enum Fuel {
    PETROL("Petrol"),
    DIESEL("Diesel");
    private final String fuel;

    Fuel(String fuel) {
        this.fuel = fuel;
    }

    public String toString() {
        return this.fuel;
    }
}
