package ppyrczak.carrental.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Brand is mandatory")
    private String brand;

    @NotBlank(message = "Model is mandatory")
    private String model;

    @NotBlank(message = "Power is mandatory")
    private int power;

    @NotBlank(message = "price is mandatory")
    private int price;

    @NotBlank(message = "date is mandatory")
    private Date rentStart;

    @NotBlank(message = "date is mandatory")
    private Date rentEnd;


}
