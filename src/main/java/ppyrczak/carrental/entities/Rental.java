package ppyrczak.carrental.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ppyrczak.carrental.utils.RentalSpan;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
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

    public int convertSpanFromEnumToInteger() {
        if (rentalSpan == RentalSpan.WEEKEND) {
            return 2;
        }

        else if (rentalSpan == RentalSpan.WEEK) {
            return 7;
        }

        else if (rentalSpan == RentalSpan.TWO_WEEKS) {
            return 14;
        }

        else
            return 30;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRentalEnd() {
        this.rentalEnd = rentalStart.plusDays(convertSpanFromEnumToInteger());
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
