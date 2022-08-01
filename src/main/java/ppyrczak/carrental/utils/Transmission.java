package ppyrczak.carrental.utils;

public enum Transmission {
    MANUAL("Manual"), AUTOMATIC("Automatic");
    private String transmission;

    Transmission(String transmission) {
        this.transmission = transmission;
    }

    public String toString() {
        return this.transmission;
    }

 }
