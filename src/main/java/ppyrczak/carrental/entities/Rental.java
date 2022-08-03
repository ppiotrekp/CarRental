package ppyrczak.carrental.entities;

import ppyrczak.carrental.utils.RentalSpan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long carId;
    private Date rentalStart;
    private Date rentalEnd;
    private RentalSpan rentalSpan;
    private int price;



}
