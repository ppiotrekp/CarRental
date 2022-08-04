package ppyrczak.carrental.entities;

import lombok.Data;
import ppyrczak.carrental.utils.RentalSpan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date rentalStart;
    private Date rentalEnd;
    private RentalSpan rentalSpan;
    private int price;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;



   /* public int getPrice() {
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

        return price;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRentalStart() {
        return rentalStart;
    }

    public void setRentalStart(Date rentalStart) {
        this.rentalStart = rentalStart;
    }

    public Date getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd(Date rentalEnd) {
        this.rentalEnd = rentalEnd;
    }

    public RentalSpan getRentalSpan() {
        return rentalSpan;
    }

    public void setRentalSpan(RentalSpan rentalSpan) {
        this.rentalSpan = rentalSpan;
    }

    public void setPrice(int price) {
        this.price = price;
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
