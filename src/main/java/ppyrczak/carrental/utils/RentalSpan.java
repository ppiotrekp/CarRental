package ppyrczak.carrental.utils;

public enum RentalSpan {
    WEEKEND("Weekend"),
    WEEK("Week"),
    TWO_WEEKS("Two weeks"),
    MONTH("Month");

    private final String rentalSpan;

    RentalSpan(String rentalSpan) {
        this.rentalSpan = rentalSpan;
    }

    public String toString() {
        return this.rentalSpan;
    }
}
