package ppyrczak.carrental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ppyrczak.carrental.utils.Fuel;
import ppyrczak.carrental.utils.Transmission;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Brand is mandatory")
    private String brand;
    @NotBlank(message = "Model is mandatory")
    private String model;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Fuel fuel;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    @NotNull(message = "Power is mandatory")
    private int power;
    @NotNull(message = "price is mandatory")
    private int priceForTwoDays;
    @NotNull(message = "price is mandatory")
    private int priceForWeek;
    @NotNull(message = "price is mandatory")
    private int priceForTwoWeeks;
    @NotNull(message = "price is mandatory")
    private int priceForMonth;

    private LocalDate unavailableFrom;

    private LocalDate unavailableTo;

    @OneToMany(
            mappedBy = "car",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rental> rentals = new ArrayList<>();

    public Car(String brand,
               String model,
               Fuel fuel,
               Transmission transmission,
               int power,
               int priceForWeekend,
               int priceForWeek,
               int priceForTwoWeeks,
               int priceForMonth) {
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
        this.transmission = transmission;
        this.power = power;
        this.priceForTwoDays = priceForWeekend;
        this.priceForWeek = priceForWeek;
        this.priceForTwoWeeks = priceForTwoWeeks;
        this.priceForMonth = priceForMonth;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public boolean checkAvailability(LocalDate start, LocalDate end) {
        if (unavailableFrom != null && unavailableTo != null) {
            if ((start.isAfter(unavailableFrom) && end.isBefore(unavailableTo)) ||
                    (start.isBefore(unavailableFrom) && end.isAfter(unavailableTo)) ||
                    (start.isBefore(unavailableTo) && end.isAfter(unavailableTo)) ||
                    (start.isBefore(unavailableFrom) && end.isAfter(unavailableFrom)) ||
                    (start.isEqual(unavailableFrom))
            ) {
                log.info("Car is not available");
                return false;
            }
            else {
                return true;
            }
        }

        else {
            return true;
        }
    }



}
