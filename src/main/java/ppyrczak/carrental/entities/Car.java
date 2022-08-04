package ppyrczak.carrental.entities;

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
    private int priceForWeekend;
    @NotBlank(message = "price is mandatory")
    private int priceForWeek;
    @NotBlank(message = "price is mandatory")
    private int priceForTwoWeeks;
    @NotBlank(message = "price is mandatory")
    private int priceForMonth;

    @OneToMany(
            mappedBy = "car",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
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
        this.priceForWeekend = priceForWeekend;
        this.priceForWeek = priceForWeek;
        this.priceForTwoWeeks = priceForTwoWeeks;
        this.priceForMonth = priceForMonth;
    }

    public String getFuel() {
        return fuel.toString();
    }

    public Transmission getTransmission() {
        return transmission;
    }
}
