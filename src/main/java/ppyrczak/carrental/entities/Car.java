package ppyrczak.carrental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ppyrczak.carrental.utils.Fuel;
import ppyrczak.carrental.utils.Transmission;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @NotBlank(message = "Power is mandatory")
    private int power;
    @NotBlank(message = "price is mandatory")
    private int priceForTwoDays;
    @NotBlank(message = "price is mandatory")
    private int priceForWeek;
    @NotBlank(message = "price is mandatory")
    private int priceForTwoWeeks;
    @NotBlank(message = "price is mandatory")
    private int priceForMonth;

    //@NotBlank(message = "availability is mandatory")
    //private boolean available;

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

    public String getFuel() {
        return fuel.toString();
    }

    public String getTransmission() {
        return transmission.toString();
    }
}
