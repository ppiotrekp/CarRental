package ppyrczak.carrental.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ppyrczak.carrental.utils.RentalSpan;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalEnd;
    @Enumerated(EnumType.STRING)
    private RentalSpan rentalSpan;
    private int price;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


    public int getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRentalStart() {
        return rentalStart;
    }

    public void setRentalStart(LocalDate rentalStart) {
        this.rentalStart = rentalStart;
    }

    public LocalDate getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd() {
        this.rentalEnd = rentalStart.plusDays(30);
    }

    public RentalSpan getRentalSpan() {
        return rentalSpan;
    }

    public void setRentalSpan(RentalSpan rentalSpan) {
        this.rentalSpan = rentalSpan;
    }

    public void setPrice() {
        if (rentalSpan == RentalSpan.WEEKEND) {
            price = car.getPriceForWeekend();
        }

        else if (rentalSpan == RentalSpan.WEEK) {
            price = car.getPriceForWeek();
        }

        else if (rentalSpan == RentalSpan.TWO_WEEKS) {
            price = car.getPriceForTwoWeeks();
        }

        else {
            price = car.getPriceForMonth();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
