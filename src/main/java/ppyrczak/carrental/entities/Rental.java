package ppyrczak.carrental.entities;

import lombok.Data;
import ppyrczak.carrental.utils.RentalSpan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date rentalStart;
    private Date rentalEnd;
    private RentalSpan rentalSpan;
    private int price;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    public int getPrice() {
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
    }



}
